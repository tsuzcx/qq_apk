package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class TexturePool
  implements ITexturePool
{
  private static final String TAG = "TexturePool";
  private int MaxCacheLength;
  private long MaxCacheSize;
  private List<TextureInfo> textureInfoList;
  
  public TexturePool()
  {
    AppMethodBeat.i(191265);
    this.textureInfoList = new ArrayList();
    this.MaxCacheSize = 207360000L;
    this.MaxCacheLength = 60;
    Logger.d("TexturePool", "TexturePool: create " + Thread.currentThread().getId());
    AppMethodBeat.o(191265);
  }
  
  private void adaptCacheSize()
  {
    try
    {
      AppMethodBeat.i(191276);
      while ((this.textureInfoList.size() > 0) && (this.textureInfoList.size() - this.MaxCacheLength > 0))
      {
        ((TextureInfo)this.textureInfoList.get(0)).release();
        this.textureInfoList.remove(0);
      }
      AppMethodBeat.o(191276);
    }
    finally {}
  }
  
  private void adapterCacheMemorySize()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(191278);
        long l = 0L;
        i = 0;
        if (i < this.textureInfoList.size())
        {
          TextureInfo localTextureInfo = (TextureInfo)this.textureInfoList.get(i);
          l += localTextureInfo.width * localTextureInfo.height;
          if (l > this.MaxCacheSize)
          {
            Logger.v("TexturePool", "texture: release " + localTextureInfo + " - " + Thread.currentThread());
            localTextureInfo.release();
            this.textureInfoList.remove(i);
            i -= 1;
          }
        }
        else
        {
          AppMethodBeat.o(191278);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public TextureInfo popTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iconst_0
    //   8: istore 4
    //   10: iload 4
    //   12: aload_0
    //   13: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   16: invokeinterface 82 1 0
    //   21: if_icmpge +106 -> 127
    //   24: aload_0
    //   25: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   28: iload 4
    //   30: invokeinterface 86 2 0
    //   35: checkcast 88	com/tencent/tav/coremedia/TextureInfo
    //   38: astore 5
    //   40: aload 5
    //   42: getfield 121	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   45: iload_1
    //   46: if_icmpne +72 -> 118
    //   49: aload 5
    //   51: getfield 99	com/tencent/tav/coremedia/TextureInfo:width	I
    //   54: iload_2
    //   55: if_icmpne +63 -> 118
    //   58: aload 5
    //   60: getfield 102	com/tencent/tav/coremedia/TextureInfo:height	I
    //   63: iload_3
    //   64: if_icmpne +54 -> 118
    //   67: ldc 10
    //   69: new 41	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 123
    //   75: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload 5
    //   80: getfield 126	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   83: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 115	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   96: iload 4
    //   98: invokeinterface 94 2 0
    //   103: checkcast 88	com/tencent/tav/coremedia/TextureInfo
    //   106: astore 5
    //   108: ldc 118
    //   110: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: monitorexit
    //   115: aload 5
    //   117: areturn
    //   118: iload 4
    //   120: iconst_1
    //   121: iadd
    //   122: istore 4
    //   124: goto -114 -> 10
    //   127: iload_1
    //   128: invokestatic 135	com/tencent/tav/decoder/RenderContext:createTexture	(I)I
    //   131: istore_1
    //   132: aload_0
    //   133: invokespecial 137	com/tencent/tav/decoder/TexturePool:adaptCacheSize	()V
    //   136: aload_0
    //   137: invokespecial 139	com/tencent/tav/decoder/TexturePool:adapterCacheMemorySize	()V
    //   140: new 88	com/tencent/tav/coremedia/TextureInfo
    //   143: dup
    //   144: iload_1
    //   145: sipush 3553
    //   148: iload_2
    //   149: iload_3
    //   150: aconst_null
    //   151: iconst_0
    //   152: invokespecial 142	com/tencent/tav/coremedia/TextureInfo:<init>	(IIIILandroid/graphics/Matrix;I)V
    //   155: astore 5
    //   157: ldc 118
    //   159: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: goto -49 -> 113
    //   165: astore 5
    //   167: aload_0
    //   168: monitorexit
    //   169: aload 5
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	TexturePool
    //   0	172	1	paramInt1	int
    //   0	172	2	paramInt2	int
    //   0	172	3	paramInt3	int
    //   8	115	4	i	int
    //   38	118	5	localTextureInfo	TextureInfo
    //   165	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	165	finally
    //   10	113	165	finally
    //   127	162	165	finally
  }
  
  /* Error */
  public void pushTexture(TextureInfo paramTextureInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 145
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   14: invokeinterface 82 1 0
    //   19: if_icmpge +82 -> 101
    //   22: aload_0
    //   23: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   26: iload_2
    //   27: invokeinterface 86 2 0
    //   32: checkcast 88	com/tencent/tav/coremedia/TextureInfo
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 121	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   40: aload_1
    //   41: getfield 121	com/tencent/tav/coremedia/TextureInfo:textureType	I
    //   44: if_icmpne +50 -> 94
    //   47: aload_3
    //   48: getfield 126	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   51: aload_1
    //   52: getfield 126	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   55: if_icmpne +39 -> 94
    //   58: ldc 10
    //   60: new 41	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 147
    //   66: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: aload_3
    //   70: getfield 126	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   73: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 115	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 91	com/tencent/tav/coremedia/TextureInfo:release	()V
    //   86: ldc 145
    //   88: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: goto -89 -> 9
    //   101: ldc 10
    //   103: new 41	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 149
    //   109: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: getfield 126	com/tencent/tav/coremedia/TextureInfo:textureID	I
    //   116: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc 109
    //   121: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokestatic 52	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   127: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 115	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_0
    //   137: getfield 33	com/tencent/tav/decoder/TexturePool:textureInfoList	Ljava/util/List;
    //   140: aload_1
    //   141: invokeinterface 153 2 0
    //   146: pop
    //   147: ldc 145
    //   149: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: goto -61 -> 91
    //   155: astore_1
    //   156: aload_0
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	TexturePool
    //   0	160	1	paramTextureInfo	TextureInfo
    //   8	90	2	i	int
    //   35	35	3	localTextureInfo	TextureInfo
    // Exception table:
    //   from	to	target	type
    //   2	7	155	finally
    //   9	91	155	finally
    //   101	152	155	finally
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(191280);
      Logger.d("TexturePool", " release all " + Thread.currentThread().getId());
      int i = 0;
      while (i < this.textureInfoList.size())
      {
        ((TextureInfo)this.textureInfoList.get(i)).release();
        i += 1;
      }
      AppMethodBeat.o(191280);
      return;
    }
    finally {}
  }
  
  public void setMaxCacheLength(int paramInt)
  {
    AppMethodBeat.i(191267);
    this.MaxCacheLength = paramInt;
    adapterCacheMemorySize();
    AppMethodBeat.o(191267);
  }
  
  public void setMaxCacheSize(long paramLong)
  {
    AppMethodBeat.i(191266);
    this.MaxCacheSize = paramLong;
    adaptCacheSize();
    AppMethodBeat.o(191266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.TexturePool
 * JD-Core Version:    0.7.0.1
 */