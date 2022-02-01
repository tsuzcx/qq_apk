package com.tencent.qqmusic.mediaplayer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WaveWriter
{
  private static final int OUTPUT_STREAM_BUFFER = 16384;
  private static final String TAG = "WaveWriter";
  private int mBytesWritten;
  private int mChannels;
  private File mOutFile;
  private BufferedOutputStream mOutStream;
  private int mSampleBits;
  private int mSampleRate;
  private ByteArrayOutputStream mTmpStream;
  
  public WaveWriter(File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mOutFile = paramFile;
    this.mSampleRate = paramInt1;
    this.mChannels = paramInt2;
    this.mSampleBits = paramInt3;
    this.mBytesWritten = 0;
  }
  
  public WaveWriter(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76421);
    this.mOutFile = new File(paramString1 + File.separator + paramString2);
    this.mSampleRate = paramInt1;
    this.mChannels = paramInt2;
    this.mSampleBits = paramInt3;
    this.mBytesWritten = 0;
    AppMethodBeat.o(76421);
  }
  
  private short[] interpolate(int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    AppMethodBeat.i(76432);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(76432);
      return paramArrayOfShort;
    }
    int j = Math.round(paramArrayOfShort.length / paramInt1 * paramInt2);
    float f1 = j / paramArrayOfShort.length;
    short[] arrayOfShort = new short[j];
    paramInt1 = 0;
    while (paramInt1 < j)
    {
      float f2 = paramInt1 / f1;
      int k = (int)f2;
      int i = k + 1;
      paramInt2 = i;
      if (i >= paramArrayOfShort.length) {
        paramInt2 = paramArrayOfShort.length - 1;
      }
      arrayOfShort[paramInt1] = ((short)(int)((paramArrayOfShort[paramInt2] - paramArrayOfShort[k]) * (f2 - k) + paramArrayOfShort[k]));
      paramInt1 += 1;
    }
    AppMethodBeat.o(76432);
    return arrayOfShort;
  }
  
  private byte[] reSample(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int n = 0;
    int m = 0;
    AppMethodBeat.i(76431);
    int i1 = paramInt1 / 8;
    if (i1 <= 0)
    {
      AppMethodBeat.o(76431);
      return null;
    }
    int i2 = paramArrayOfByte.length / i1;
    short[] arrayOfShort = new short[i2];
    paramInt1 = 0;
    int j = 0;
    while (paramInt1 < i2)
    {
      int k = 0;
      int i = 0;
      while (k < i1)
      {
        i = (short)(i | (short)((paramArrayOfByte[j] & 0xFF) << k * 8));
        k += 1;
        j += 1;
      }
      arrayOfShort[paramInt1] = i;
      paramInt1 += 1;
    }
    arrayOfShort = interpolate(paramInt2, paramInt3, arrayOfShort);
    paramInt2 = arrayOfShort.length;
    if (i1 == 1)
    {
      paramArrayOfByte = new byte[paramInt2];
      paramInt1 = m;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfByte[paramInt1] = ((byte)arrayOfShort[paramInt1]);
        paramInt1 += 1;
      }
    }
    for (;;)
    {
      this.mSampleRate = paramInt3;
      AppMethodBeat.o(76431);
      return paramArrayOfByte;
      paramArrayOfByte = new byte[paramInt2 * 2];
      paramInt1 = n;
      while (paramInt1 < arrayOfShort.length)
      {
        paramArrayOfByte[(paramInt1 * 2)] = ((byte)(arrayOfShort[paramInt1] & 0xFF));
        paramArrayOfByte[(paramInt1 * 2 + 1)] = ((byte)(arrayOfShort[paramInt1] >> 8 & 0xFF));
        paramInt1 += 1;
      }
    }
  }
  
  private static void writeUnsignedShortLE(ByteArrayOutputStream paramByteArrayOutputStream, short paramShort)
  {
    AppMethodBeat.i(76422);
    paramByteArrayOutputStream.write(paramShort);
    paramByteArrayOutputStream.write(paramShort >> 8);
    AppMethodBeat.o(76422);
  }
  
  private void writeWaveHeader()
  {
    AppMethodBeat.i(76427);
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.mOutFile, "rw");
    localRandomAccessFile.seek(0L);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    int i = (this.mSampleBits + 7) / 8;
    try
    {
      localDataOutputStream.writeBytes("RIFF");
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten + 36));
      localDataOutputStream.writeBytes("WAVE");
      localDataOutputStream.writeBytes("fmt ");
      localDataOutputStream.writeInt(Integer.reverseBytes(16));
      localDataOutputStream.writeShort(Short.reverseBytes((short)1));
      localDataOutputStream.writeShort(Short.reverseBytes((short)this.mChannels));
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate));
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate * this.mChannels * i));
      localDataOutputStream.writeShort(Short.reverseBytes((short)(i * this.mChannels)));
      localDataOutputStream.writeShort(Short.reverseBytes((short)this.mSampleBits));
      localDataOutputStream.writeBytes("data");
      localDataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten));
      localByteArrayOutputStream.flush();
      localRandomAccessFile.write(localByteArrayOutputStream.toByteArray());
      return;
    }
    finally
    {
      localByteArrayOutputStream.close();
      localDataOutputStream.close();
      localRandomAccessFile.close();
      AppMethodBeat.o(76427);
    }
  }
  
  public byte[] changeStereoToMono(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (this.mChannels == 2)
    {
      int k = this.mSampleBits / 8;
      long l = paramArrayOfByte.length / this.mChannels / k;
      arrayOfByte = new byte[(int)(k * l)];
      int i = 0;
      while (i < l)
      {
        int j = 0;
        while (j < k)
        {
          arrayOfByte[(i * k + j)] = ((byte)((paramArrayOfByte[(this.mChannels * i * k + j)] + paramArrayOfByte[((this.mChannels * i + 1) * k + j)]) / 2));
          j += 1;
        }
        i += 1;
      }
      this.mChannels = 1;
    }
    return arrayOfByte;
  }
  
  public void closeWaveFile()
  {
    AppMethodBeat.i(76426);
    if (this.mOutStream != null)
    {
      this.mOutStream.flush();
      this.mOutStream.close();
    }
    if (this.mTmpStream != null)
    {
      this.mTmpStream.flush();
      this.mTmpStream.close();
    }
    writeWaveHeader();
    AppMethodBeat.o(76426);
  }
  
  public boolean createWaveFile()
  {
    AppMethodBeat.i(76423);
    if (this.mOutFile.exists()) {
      this.mOutFile.delete();
    }
    this.mOutFile.getParentFile().mkdirs();
    if (this.mOutFile.createNewFile())
    {
      this.mOutStream = new BufferedOutputStream(new FileOutputStream(this.mOutFile), 16384);
      this.mTmpStream = new ByteArrayOutputStream();
      this.mOutStream.write(new byte[44]);
      AppMethodBeat.o(76423);
      return true;
    }
    AppMethodBeat.o(76423);
    return false;
  }
  
  public int getChannels()
  {
    return this.mChannels;
  }
  
  public boolean reSampler()
  {
    AppMethodBeat.i(76429);
    try
    {
      byte[] arrayOfByte = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(76429);
        return false;
      }
      Logger.d("WaveWriter", "mTmpStream length = " + this.mTmpStream.toByteArray().length);
      arrayOfByte = changeStereoToMono(arrayOfByte);
      Logger.d("WaveWriter", "monoData length = " + arrayOfByte.length);
      arrayOfByte = reSample(arrayOfByte, this.mSampleBits, 8000, 4000);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(76429);
        return false;
      }
      Logger.d("WaveWriter", "resultData length = " + arrayOfByte.length);
      this.mBytesWritten = arrayOfByte.length;
      this.mOutStream.write(arrayOfByte);
      AppMethodBeat.o(76429);
      return true;
    }
    finally
    {
      Logger.e("WaveWriter", localThrowable);
      AppMethodBeat.o(76429);
    }
    return false;
  }
  
  public boolean reSamplerTo8K()
  {
    AppMethodBeat.i(76430);
    try
    {
      byte[] arrayOfByte = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, 8000);
      if (arrayOfByte == null)
      {
        AppMethodBeat.o(76430);
        return false;
      }
      Logger.d("WaveWriter", "mTmpStream length = " + this.mTmpStream.toByteArray().length);
      arrayOfByte = changeStereoToMono(arrayOfByte);
      Logger.d("WaveWriter", "resultData length = " + arrayOfByte.length);
      this.mBytesWritten = arrayOfByte.length;
      this.mOutStream.write(arrayOfByte);
      AppMethodBeat.o(76430);
      return true;
    }
    finally
    {
      Logger.e("WaveWriter", localThrowable);
      AppMethodBeat.o(76430);
    }
    return false;
  }
  
  public void setSampleByte(int paramInt)
  {
    this.mSampleBits = paramInt;
  }
  
  public void write(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76424);
    int i = paramInt1;
    if (paramInt1 > paramInt2)
    {
      paramArrayOfShort = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(76424);
      throw paramArrayOfShort;
    }
    while (i < paramInt2)
    {
      writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort[i]);
      this.mBytesWritten += 2;
      i += 1;
    }
    AppMethodBeat.o(76424);
  }
  
  public void write(short[] paramArrayOfShort1, short[] paramArrayOfShort2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76425);
    if (this.mChannels != 2)
    {
      AppMethodBeat.o(76425);
      return;
    }
    int i = paramInt1;
    if (paramInt1 > paramInt2)
    {
      paramArrayOfShort1 = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      AppMethodBeat.o(76425);
      throw paramArrayOfShort1;
    }
    while (i < paramInt2)
    {
      writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort1[i]);
      writeUnsignedShortLE(this.mTmpStream, paramArrayOfShort2[i]);
      this.mBytesWritten += 4;
      i += 1;
    }
    AppMethodBeat.o(76425);
  }
  
  public void writeDone()
  {
    AppMethodBeat.i(76428);
    try
    {
      this.mOutStream.write(this.mTmpStream.toByteArray());
      AppMethodBeat.o(76428);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e("WaveWriter", localIOException);
      AppMethodBeat.o(76428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.WaveWriter
 * JD-Core Version:    0.7.0.1
 */