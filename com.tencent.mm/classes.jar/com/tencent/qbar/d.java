package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88404);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88404);
      return -1;
    }
    paramInt1 = QbarNative.nativeYUVrotate(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    AppMethodBeat.o(88404);
    return paramInt1;
  }
  
  public static int a(byte[] paramArrayOfByte1, int[] paramArrayOfInt, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(88403);
    if (paramArrayOfByte2 == null)
    {
      AppMethodBeat.o(88403);
      return -1;
    }
    paramInt1 = QbarNative.nativeGrayRotateCropSub(paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramArrayOfByte1, paramArrayOfInt, paramInt7, 0);
    AppMethodBeat.o(88403);
    return paramInt1;
  }
  
  public static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88405);
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(88405);
      return -1;
    }
    paramInt1 = QbarNative.nativeTransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(88405);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.d
 * JD-Core Version:    0.7.0.1
 */