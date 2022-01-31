package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class MP3FileCheck
{
  private static final String TAG = "MP3FileCheck";
  private byte[] buf = new byte[8192];
  private int endPos;
  private boolean eof;
  private int frameCount;
  private boolean hasCheck = false;
  private boolean hasID3V2 = false;
  private MP3Header header = new MP3Header();
  private int headerMask;
  private boolean isMP3 = false;
  private String mFilePath = null;
  private int mID3V2Size = -1;
  private RandomAccessFile mRandomAccessFile = null;
  private int pos;
  private int skipped;
  private boolean sync;
  
  public MP3FileCheck(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  private boolean available(int paramInt1, int paramInt2)
  {
    return ((paramInt1 & paramInt2) == paramInt2) && ((paramInt1 >> 19 & 0x3) != 1) && ((paramInt1 >> 17 & 0x3) != 0) && ((paramInt1 >> 12 & 0xF) != 15) && ((paramInt1 >> 12 & 0xF) != 0) && ((paramInt1 >> 10 & 0x3) != 3);
  }
  
  private int byte2int(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
  }
  
  private boolean checkAndSeekID3V2Tag()
  {
    byte[] arrayOfByte = new byte[10];
    int i = fillBuffer(arrayOfByte, 0, 10);
    if (i <= 0) {
      return false;
    }
    if ((arrayOfByte[0] == 73) && (arrayOfByte[1] == 68) && (arrayOfByte[2] == 51))
    {
      this.mID3V2Size = ((arrayOfByte[6] << 21) + (arrayOfByte[7] << 14) + (arrayOfByte[8] << 7) + arrayOfByte[9]);
      this.hasID3V2 = true;
      seekTo(this.mID3V2Size - i);
      Logger.d("MP3FileCheck", "有ID3V2，ID3V2大小 = " + this.mID3V2Size);
    }
    for (;;)
    {
      return this.hasID3V2;
      closeFileStream();
      Logger.d("MP3FileCheck", "没有有ID3V2");
    }
  }
  
  private void closeFileStream()
  {
    if (this.mRandomAccessFile != null) {}
    try
    {
      this.mRandomAccessFile.close();
      this.mRandomAccessFile = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.e("MP3FileCheck", localIOException);
      }
    }
  }
  
  private int fillBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.mRandomAccessFile == null) {
        this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
      }
      paramInt1 = this.mRandomAccessFile.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Exception paramArrayOfByte) {}
    return -1;
  }
  
  private boolean isMp3File()
  {
    if (!this.hasCheck) {
      fileCheck();
    }
    return this.isMP3;
  }
  
  public static boolean isMp3File(String paramString)
  {
    return new MP3FileCheck(paramString).isMp3File();
  }
  
  private void nextFrameHeader()
  {
    int i = 0;
    while ((!this.eof) && (!syncFrame()))
    {
      int k = this.endPos - this.pos;
      if (k > 0) {
        System.arraycopy(this.buf, this.pos, this.buf, 0, k);
      }
      this.endPos = (fillBuffer(this.buf, k, this.pos) + k);
      int j = i;
      if (this.endPos > k)
      {
        j = i + this.pos;
        i = j;
        if (j <= 65536) {}
      }
      else
      {
        this.eof = true;
        i = j;
      }
      this.pos = 0;
    }
  }
  
  private void seekTo(int paramInt)
  {
    try
    {
      this.mRandomAccessFile.seek(paramInt);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("MP3FileCheck", localException);
    }
  }
  
  private boolean syncFrame()
  {
    int j = this.pos;
    if (this.endPos - this.pos <= 4) {
      return false;
    }
    int i = byte2int(this.buf, this.pos);
    this.pos += 4;
    System.out.println(this.frameCount);
    for (;;)
    {
      if (!this.eof)
      {
        while (!available(i, this.headerMask))
        {
          arrayOfByte = this.buf;
          k = this.pos;
          this.pos = (k + 1);
          i = i << 8 | arrayOfByte[k] & 0xFF;
          if (this.pos == this.endPos)
          {
            i = this.skipped;
            k = this.pos - 4;
            this.pos = k;
            this.skipped = (i + (k - j));
            return false;
          }
        }
        if (this.pos > j + 4)
        {
          this.sync = false;
          this.skipped += this.pos - 4 - j;
        }
        this.header.decode(i);
        k = this.header.getFrameSize();
        if (this.pos + k > this.endPos + 4)
        {
          i = this.skipped;
          k = this.pos - 4;
          this.pos = k;
          this.skipped = (i + (k - j));
          return false;
        }
        if (!this.sync)
        {
          if (this.pos + k > this.endPos)
          {
            i = this.skipped;
            k = this.pos - 4;
            this.pos = k;
            this.skipped = (i + (k - j));
            return false;
          }
          int m = 0x180000 & i | 0xFFE00000 | 0x60000 & i | i & 0xC00;
          if (!available(byte2int(this.buf, k + (this.pos - 4)), m)) {
            break label410;
          }
          if (this.headerMask == -2097152) {
            this.headerMask = m;
          }
          this.sync = true;
        }
      }
      if (this.header.isProtected()) {
        this.pos += 2;
      }
      this.frameCount += 1;
      if ((this.skipped > 0) || ((this.skipped == 0) && (this.sync)))
      {
        this.isMP3 = true;
        this.skipped = 0;
      }
      return true;
      label410:
      byte[] arrayOfByte = this.buf;
      int k = this.pos;
      this.pos = (k + 1);
      i = i << 8 | arrayOfByte[k] & 0xFF;
    }
  }
  
  public void fileCheck()
  {
    for (;;)
    {
      try
      {
        this.hasCheck = true;
        checkAndSeekID3V2Tag();
        this.headerMask = -2097152;
        this.sync = false;
        this.eof = false;
        this.frameCount = 0;
        int i = this.buf.length;
        this.pos = i;
        this.endPos = i;
        this.header.initialize();
        nextFrameHeader();
      }
      catch (Exception localException2)
      {
        Logger.e("MP3FileCheck", localException2);
        if (this.mRandomAccessFile == null) {
          continue;
        }
        try
        {
          this.mRandomAccessFile.close();
          return;
        }
        catch (Exception localException3)
        {
          Logger.e("MP3FileCheck", localException3);
          return;
        }
      }
      finally
      {
        if (this.mRandomAccessFile == null) {
          break label126;
        }
      }
      try
      {
        this.mRandomAccessFile.close();
        return;
      }
      catch (Exception localException1)
      {
        Logger.e("MP3FileCheck", localException1);
        return;
      }
    }
    try
    {
      this.mRandomAccessFile.close();
      label126:
      throw localObject;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        Logger.e("MP3FileCheck", localException4);
      }
    }
  }
  
  public int getFrameSize()
  {
    if (this.header != null) {
      return this.header.getFrameSize();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3FileCheck
 * JD-Core Version:    0.7.0.1
 */