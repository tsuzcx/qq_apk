package com.tencent.tinker.a.b.a;

import java.io.EOFException;

public final class g
  extends a
{
  final short[] Met;
  
  public g(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null) {
      throw new NullPointerException("array == null");
    }
    this.Met = paramArrayOfShort;
  }
  
  public final int read()
  {
    try
    {
      int i = this.Met[this.aoY];
      fYr();
      return i & 0xFFFF;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new EOFException();
    }
  }
  
  public final int readInt()
  {
    return read() | read() << 16;
  }
  
  public final long readLong()
  {
    return read() | read() << 16 | read() << 32 | read() << 48;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.g
 * JD-Core Version:    0.7.0.1
 */