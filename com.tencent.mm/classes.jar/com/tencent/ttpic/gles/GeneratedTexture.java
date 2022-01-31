package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class GeneratedTexture
{
  private static final int BLACK = 0;
  private static final int BLUE = 16711680;
  private static final int BYTES_PER_PIXEL = 4;
  private static final int CYAN = 16776960;
  private static final int FORMAT = 6408;
  private static final int GREEN = 65280;
  private static final int[] GRID;
  private static final int HALF = -2147483648;
  private static final int LOW = 1073741824;
  private static final int MAGENTA = 16711935;
  private static final int OPAQUE = -16777216;
  private static final int RED = 255;
  private static final int TEX_SIZE = 64;
  private static final int TRANSP = 0;
  private static final int WHITE = 16777215;
  private static final int YELLOW = 65535;
  private static final ByteBuffer sCoarseImageData;
  private static final ByteBuffer sFineImageData;
  
  static
  {
    AppMethodBeat.i(49997);
    GRID = new int[] { -16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, 65280, -2147483393, -16777216, -256, -65281, -256, -65536 };
    sCoarseImageData = generateCoarseData();
    sFineImageData = generateFineData();
    AppMethodBeat.o(49997);
  }
  
  private static void checkerPattern(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    while (paramInt2 < paramInt4)
    {
      int i = paramInt1;
      if (i < paramInt3)
      {
        int k = paramInt2 * 64 * 4 + i * 4;
        if ((paramInt2 & paramInt7 ^ i & paramInt7) == 0) {}
        for (int j = paramInt5;; j = paramInt6)
        {
          int m = j >> 24 & 0xFF;
          float f = m / 255.0F;
          paramArrayOfByte[k] = ((byte)(int)((j & 0xFF) * f));
          paramArrayOfByte[(k + 1)] = ((byte)(int)((j >> 8 & 0xFF) * f));
          paramArrayOfByte[(k + 2)] = ((byte)(int)((j >> 16 & 0xFF) * f));
          paramArrayOfByte[(k + 3)] = ((byte)m);
          i += 1;
          break;
        }
      }
      paramInt2 += 1;
    }
  }
  
  public static int createTestTexture(GeneratedTexture.Image paramImage)
  {
    AppMethodBeat.i(49994);
    switch (GeneratedTexture.1.$SwitchMap$com$tencent$ttpic$gles$GeneratedTexture$Image[paramImage.ordinal()])
    {
    default: 
      paramImage = new RuntimeException("unknown image");
      AppMethodBeat.o(49994);
      throw paramImage;
    }
    for (paramImage = sCoarseImageData;; paramImage = sFineImageData)
    {
      int i = GlUtil.createImageTexture(paramImage, 64, 64, 6408);
      AppMethodBeat.o(49994);
      return i;
    }
  }
  
  private static ByteBuffer generateCoarseData()
  {
    AppMethodBeat.i(49995);
    byte[] arrayOfByte = new byte[16384];
    int j = 0;
    if (j < 16384)
    {
      int k = j / 4 / 64;
      int i = j / 4;
      k /= 16;
      i = i % 64 / 16;
      i = GRID[(k * 4 + i)];
      if (j == 0) {
        i = -1;
      }
      for (;;)
      {
        k = i >> 24 & 0xFF;
        float f = k / 255.0F;
        arrayOfByte[j] = ((byte)(int)((i & 0xFF) * f));
        arrayOfByte[(j + 1)] = ((byte)(int)((i >> 8 & 0xFF) * f));
        arrayOfByte[(j + 2)] = ((byte)(int)((i >> 16 & 0xFF) * f));
        arrayOfByte[(j + 3)] = ((byte)k);
        j += 4;
        break;
        if (j == 16380) {
          i = -1;
        }
      }
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(16384);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.position(0);
    AppMethodBeat.o(49995);
    return localByteBuffer;
  }
  
  private static ByteBuffer generateFineData()
  {
    AppMethodBeat.i(49996);
    byte[] arrayOfByte = new byte[16384];
    checkerPattern(arrayOfByte, 0, 0, 32, 32, -16776961, -65536, 1);
    checkerPattern(arrayOfByte, 32, 32, 64, 64, -16776961, -16711936, 2);
    checkerPattern(arrayOfByte, 0, 32, 32, 64, -65536, -16711936, 4);
    checkerPattern(arrayOfByte, 32, 0, 64, 32, -1, -16777216, 8);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(16384);
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.position(0);
    AppMethodBeat.o(49996);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.gles.GeneratedTexture
 * JD-Core Version:    0.7.0.1
 */