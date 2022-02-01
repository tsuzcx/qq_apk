package com.tencent.rtmp.sharp.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class RingBuffer
{
  private final int DEFAULT_SIZE;
  public int c_totalSize;
  public boolean m_isEmpty;
  public byte[] m_pBuf;
  public int m_read;
  public int m_write;
  
  public RingBuffer()
  {
    AppMethodBeat.i(13644);
    this.DEFAULT_SIZE = 1000;
    this.c_totalSize = 1000;
    this.m_read = 0;
    this.m_write = 0;
    this.m_isEmpty = true;
    this.m_pBuf = null;
    this.c_totalSize = 1000;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
    AppMethodBeat.o(13644);
  }
  
  public RingBuffer(int paramInt)
  {
    AppMethodBeat.i(13645);
    this.DEFAULT_SIZE = 1000;
    this.c_totalSize = 1000;
    this.m_read = 0;
    this.m_write = 0;
    this.m_isEmpty = true;
    this.c_totalSize = paramInt;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
    AppMethodBeat.o(13645);
  }
  
  public void Clear()
  {
    this.m_write = 0;
    this.m_read = this.m_write;
    this.m_isEmpty = true;
  }
  
  public boolean Pop(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(13648);
    if (this.m_pBuf == null)
    {
      AppMethodBeat.o(13648);
      return false;
    }
    if ((RemainRead() < paramInt) || (paramInt <= 0))
    {
      AppMethodBeat.o(13648);
      return false;
    }
    if (this.c_totalSize - this.m_read >= paramInt) {
      System.arraycopy(this.m_pBuf, this.m_read, paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      this.m_read = ((this.m_read + paramInt) % this.c_totalSize);
      if (this.m_read == this.m_write) {
        bool = true;
      }
      this.m_isEmpty = bool;
      AppMethodBeat.o(13648);
      return true;
      System.arraycopy(this.m_pBuf, this.m_read, paramArrayOfByte, 0, this.c_totalSize - this.m_read);
      System.arraycopy(this.m_pBuf, 0, paramArrayOfByte, this.c_totalSize - this.m_read, paramInt - (this.c_totalSize - this.m_read));
    }
  }
  
  public void Push(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(13646);
    if (this.m_pBuf == null)
    {
      AppMethodBeat.o(13646);
      return;
    }
    if (RemainWrite() < paramInt)
    {
      AppMethodBeat.o(13646);
      return;
    }
    if (this.c_totalSize - this.m_write >= paramInt) {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, this.m_write, paramInt);
    }
    for (;;)
    {
      this.m_write = ((this.m_write + paramInt) % this.c_totalSize);
      this.m_isEmpty = false;
      AppMethodBeat.o(13646);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, this.m_write, this.c_totalSize - this.m_write);
      System.arraycopy(paramArrayOfByte, this.c_totalSize - this.m_write, this.m_pBuf, 0, paramInt - (this.c_totalSize - this.m_write));
    }
  }
  
  public int RemainRead()
  {
    if (this.m_write < this.m_read) {
      return this.c_totalSize - this.m_read + this.m_write;
    }
    if (this.m_write > this.m_read) {
      return this.m_write - this.m_read;
    }
    if (this.m_isEmpty) {
      return 0;
    }
    return this.c_totalSize;
  }
  
  public int RemainWrite()
  {
    AppMethodBeat.i(13647);
    int i = this.c_totalSize;
    int j = RemainRead();
    AppMethodBeat.o(13647);
    return i - j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.RingBuffer
 * JD-Core Version:    0.7.0.1
 */