package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;

class RepairKit$RepairCursor
  extends AbstractCursor
{
  long mPtr;
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native int nativeGetColumnCount(long paramLong);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(3361);
    byte[] arrayOfByte = nativeGetBlob(this.mPtr, paramInt);
    AppMethodBeat.o(3361);
    return arrayOfByte;
  }
  
  public int getColumnCount()
  {
    AppMethodBeat.i(3353);
    int i = nativeGetColumnCount(this.mPtr);
    AppMethodBeat.o(3353);
    return i;
  }
  
  public String[] getColumnNames()
  {
    AppMethodBeat.i(3352);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(3352);
    throw localUnsupportedOperationException;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(3351);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(3351);
    throw localUnsupportedOperationException;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(3360);
    double d = nativeGetDouble(this.mPtr, paramInt);
    AppMethodBeat.o(3360);
    return d;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(3359);
    float f = (float)getDouble(paramInt);
    AppMethodBeat.o(3359);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(3357);
    paramInt = (int)getLong(paramInt);
    AppMethodBeat.o(3357);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(3358);
    long l = nativeGetLong(this.mPtr, paramInt);
    AppMethodBeat.o(3358);
    return l;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(3356);
    short s = (short)(int)getLong(paramInt);
    AppMethodBeat.o(3356);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(3355);
    String str = nativeGetString(this.mPtr, paramInt);
    AppMethodBeat.o(3355);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(3354);
    paramInt = nativeGetType(this.mPtr, paramInt);
    AppMethodBeat.o(3354);
    return paramInt;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(3362);
    if (getType(paramInt) == 0)
    {
      AppMethodBeat.o(3362);
      return true;
    }
    AppMethodBeat.o(3362);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wcdb.repair.RepairKit.RepairCursor
 * JD-Core Version:    0.7.0.1
 */