package com.tencent.ttpic.wav;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WavFileWriter
{
  private DataOutputStream mDataOutputStream;
  private int mDataSize = 0;
  private String mFilepath;
  
  private static byte[] intToByteArray(int paramInt)
  {
    AppMethodBeat.i(84503);
    byte[] arrayOfByte = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramInt).array();
    AppMethodBeat.o(84503);
    return arrayOfByte;
  }
  
  private static byte[] shortToByteArray(short paramShort)
  {
    AppMethodBeat.i(84504);
    byte[] arrayOfByte = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).putShort(paramShort).array();
    AppMethodBeat.o(84504);
    return arrayOfByte;
  }
  
  private boolean writeDataSize()
  {
    AppMethodBeat.i(84502);
    if (this.mDataOutputStream == null)
    {
      AppMethodBeat.o(84502);
      return false;
    }
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.mFilepath, "rw");
      localRandomAccessFile.seek(4L);
      localRandomAccessFile.write(intToByteArray(this.mDataSize + 36), 0, 4);
      localRandomAccessFile.seek(40L);
      localRandomAccessFile.write(intToByteArray(this.mDataSize), 0, 4);
      localRandomAccessFile.close();
      AppMethodBeat.o(84502);
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      AppMethodBeat.o(84502);
      return false;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(84502);
    }
    return false;
  }
  
  private boolean writeHeader(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(84501);
    if (this.mDataOutputStream == null)
    {
      AppMethodBeat.o(84501);
      return false;
    }
    WavFileHeader localWavFileHeader = new WavFileHeader(paramInt1, paramInt2, paramInt3);
    try
    {
      this.mDataOutputStream.writeBytes(localWavFileHeader.mChunkID);
      this.mDataOutputStream.write(intToByteArray(localWavFileHeader.mChunkSize), 0, 4);
      this.mDataOutputStream.writeBytes(localWavFileHeader.mFormat);
      this.mDataOutputStream.writeBytes(localWavFileHeader.mSubChunk1ID);
      this.mDataOutputStream.write(intToByteArray(localWavFileHeader.mSubChunk1Size), 0, 4);
      this.mDataOutputStream.write(shortToByteArray(localWavFileHeader.mAudioFormat), 0, 2);
      this.mDataOutputStream.write(shortToByteArray(localWavFileHeader.mNumChannel), 0, 2);
      this.mDataOutputStream.write(intToByteArray(localWavFileHeader.mSampleRate), 0, 4);
      this.mDataOutputStream.write(intToByteArray(localWavFileHeader.mByteRate), 0, 4);
      this.mDataOutputStream.write(shortToByteArray(localWavFileHeader.mBlockAlign), 0, 2);
      this.mDataOutputStream.write(shortToByteArray(localWavFileHeader.mBitsPerSample), 0, 2);
      this.mDataOutputStream.writeBytes(localWavFileHeader.mSubChunk2ID);
      this.mDataOutputStream.write(intToByteArray(localWavFileHeader.mSubChunk2Size), 0, 4);
      AppMethodBeat.o(84501);
      return true;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(84501);
    }
    return false;
  }
  
  public boolean closeFile()
  {
    AppMethodBeat.i(84499);
    boolean bool = true;
    if (this.mDataOutputStream != null)
    {
      bool = writeDataSize();
      this.mDataOutputStream.close();
      this.mDataOutputStream = null;
    }
    AppMethodBeat.o(84499);
    return bool;
  }
  
  public boolean openFile(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(84498);
    if (this.mDataOutputStream != null) {
      closeFile();
    }
    this.mFilepath = paramString;
    this.mDataSize = 0;
    this.mDataOutputStream = new DataOutputStream(new FileOutputStream(paramString));
    boolean bool = writeHeader(paramInt1, paramInt3, paramInt2);
    AppMethodBeat.o(84498);
    return bool;
  }
  
  public boolean writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84500);
    if (this.mDataOutputStream == null)
    {
      AppMethodBeat.o(84500);
      return false;
    }
    try
    {
      this.mDataOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      this.mDataSize += paramInt2;
      AppMethodBeat.o(84500);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(84500);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.wav.WavFileWriter
 * JD-Core Version:    0.7.0.1
 */