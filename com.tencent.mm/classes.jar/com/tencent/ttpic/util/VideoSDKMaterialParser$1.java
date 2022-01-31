package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoSDKMaterialParser$1
  implements DecryptListener
{
  public final byte[] decrypt(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(84221);
    paramArrayOfByte = Coffee.drink(paramArrayOfByte, Coffee.getDefaultSign());
    AppMethodBeat.o(84221);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoSDKMaterialParser.1
 * JD-Core Version:    0.7.0.1
 */