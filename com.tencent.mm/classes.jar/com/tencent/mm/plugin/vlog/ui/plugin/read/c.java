package com.tencent.mm.plugin.vlog.ui.plugin.read;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public static byte[] aa(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(191113);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 44];
    int i1 = paramArrayOfByte.length;
    long l = i1 + 36;
    int i = (byte)(int)(l & 0xFF);
    int j = (byte)(int)(l >> 8 & 0xFF);
    int k = (byte)(int)(l >> 16 & 0xFF);
    int m = (byte)(int)(l >> 24 & 0xFF);
    int n = (byte)paramInt;
    l = 44100 * paramInt * 16 / 8;
    System.arraycopy(new byte[] { 82, 73, 70, 70, i, j, k, m, 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, n, 0, 68, -84, 0, 0, (byte)(int)(l & 0xFF), (byte)(int)(l >> 8 & 0xFF), (byte)(int)(l >> 16 & 0xFF), (byte)(int)(l >> 24 & 0xFF), (byte)(paramInt * 16 / 8), 0, 16, 0, 100, 97, 116, 97, (byte)(i1 & 0xFF), (byte)(i1 >> 8 & 0xFF), (byte)(i1 >> 16 & 0xFF), (byte)(i1 >> 24 & 0xFF) }, 0, arrayOfByte, 0, 44);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 44, paramArrayOfByte.length);
    AppMethodBeat.o(191113);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.read.c
 * JD-Core Version:    0.7.0.1
 */