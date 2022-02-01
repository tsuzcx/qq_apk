package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
  extends SkiaCanvasExternalTexturePlugin
{
  private static final String TAG = "SETPluginWithSTDelegate";
  private Map<String, Map<Integer, InstanceDep>> mDepMap = new ConcurrentHashMap();
  
  private Map<Integer, InstanceDep> getInstanceMapForCanvas(String paramString)
  {
    if (!this.mDepMap.containsKey(paramString)) {
      this.mDepMap.put(paramString, new ConcurrentHashMap());
    }
    return (Map)this.mDepMap.get(paramString);
  }
  
  private void initDelegateChain(InstanceDep paramInstanceDep)
  {
    paramInstanceDep.delegatedUpStreamSurface = new SurfaceTexture(0);
    paramInstanceDep.delegatedUpStreamSurface.detachFromGLContext();
    paramInstanceDep.delegate = new SurfaceTextureRenderDelegate(paramInstanceDep.delegatedUpStreamSurface, paramInstanceDep.originDisplaySurface);
  }
  
  protected void onOriginSurfaceChanged(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      paramString = (InstanceDep)getInstanceMapForCanvas(paramString).get(Integer.valueOf(paramInt));
      if ((paramString != null) && (paramString.delegate != null))
      {
        paramString.delegate.removeDownStreamSurfaceTexture(paramString.originDisplaySurface);
        if (paramSurfaceTexture != null)
        {
          paramString.delegate.addDownStreamSurfaceTexture(paramSurfaceTexture);
          paramString.originDisplaySurface = paramSurfaceTexture;
        }
      }
      return;
    }
    finally {}
  }
  
  public void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString)
  {
    try
    {
      paramString = (InstanceDep)getInstanceMapForCanvas(paramString).get(Integer.valueOf(paramInt));
      if (paramString != null)
      {
        paramISkiaCanvasExternalTextureHandler = (SurfaceTexture)paramString.delegatedClonedDownStreamSurfaceMap.get(paramISkiaCanvasExternalTextureHandler);
        if (paramISkiaCanvasExternalTextureHandler != null)
        {
          paramString.delegate.removeDownStreamSurfaceTexture(paramISkiaCanvasExternalTextureHandler);
          paramInt = paramString.delegate.getAvailableDownStreamCount();
          new StringBuilder("last ").append(paramInt).append(" downstream surface.");
          if (paramInt == 1)
          {
            paramString.delegate.destroy();
            paramString.delegate = null;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public SkiaCanvasExternalTexturePlugin.PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, final String paramString1, final int paramInt, final String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload 4
    //   5: invokespecial 74	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:getInstanceMapForCanvas	(Ljava/lang/String;)Ljava/util/Map;
    //   8: iload_3
    //   9: invokestatic 80	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: invokeinterface 42 2 0
    //   17: checkcast 8	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +18 -> 40
    //   25: new 119	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult
    //   28: dup
    //   29: aconst_null
    //   30: iconst_m1
    //   31: iconst_m1
    //   32: invokespecial 122	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult:<init>	(Landroid/graphics/SurfaceTexture;II)V
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: getfield 70	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   44: ifnonnull +89 -> 133
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 124	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:initDelegateChain	(Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep;)V
    //   52: new 98	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 126
    //   58: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: getfield 63	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:originDisplaySurface	Landroid/graphics/SurfaceTexture;
    //   65: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc 131
    //   70: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload_3
    //   74: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 133
    //   79: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 4
    //   84: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: iload_3
    //   90: aload 4
    //   92: aload_2
    //   93: getfield 55	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegatedUpStreamSurface	Landroid/graphics/SurfaceTexture;
    //   96: invokevirtual 136	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:replaceDisplaySurface	(ILjava/lang/String;Landroid/graphics/SurfaceTexture;)V
    //   99: aload_2
    //   100: getfield 63	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:originDisplaySurface	Landroid/graphics/SurfaceTexture;
    //   103: aload_2
    //   104: getfield 140	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:width	I
    //   107: aload_2
    //   108: getfield 143	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:height	I
    //   111: invokevirtual 147	android/graphics/SurfaceTexture:setDefaultBufferSize	(II)V
    //   114: aload_2
    //   115: getfield 70	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   118: new 6	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1
    //   121: dup
    //   122: aload_0
    //   123: aload_2
    //   124: iload_3
    //   125: aload 4
    //   127: invokespecial 150	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1:<init>	(Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate;Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep;ILjava/lang/String;)V
    //   130: invokevirtual 154	com/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate:addReleaseCallback	(Ljava/lang/Runnable;)V
    //   133: new 48	android/graphics/SurfaceTexture
    //   136: dup
    //   137: iconst_0
    //   138: invokespecial 51	android/graphics/SurfaceTexture:<init>	(I)V
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 58	android/graphics/SurfaceTexture:detachFromGLContext	()V
    //   148: new 98	java/lang/StringBuilder
    //   151: dup
    //   152: ldc 156
    //   154: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 5
    //   159: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: ldc 131
    //   164: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload_3
    //   168: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   171: ldc 133
    //   173: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload 4
    //   178: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_2
    //   183: getfield 70	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   186: aload 5
    //   188: invokevirtual 87	com/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate:addDownStreamSurfaceTexture	(Landroid/graphics/SurfaceTexture;)V
    //   191: aload_2
    //   192: getfield 92	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegatedClonedDownStreamSurfaceMap	Ljava/util/Map;
    //   195: aload_1
    //   196: aload 5
    //   198: invokeinterface 38 3 0
    //   203: pop
    //   204: new 119	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult
    //   207: dup
    //   208: aload 5
    //   210: aload_2
    //   211: getfield 140	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:width	I
    //   214: aload_2
    //   215: getfield 143	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:height	I
    //   218: invokespecial 122	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult:<init>	(Landroid/graphics/SurfaceTexture;II)V
    //   221: astore_1
    //   222: goto -186 -> 36
    //   225: astore_1
    //   226: aload_0
    //   227: monitorexit
    //   228: aload_1
    //   229: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	this	SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
    //   0	230	1	paramISkiaCanvasExternalTextureHandler	ISkiaCanvasExternalTextureHandler
    //   0	230	2	paramString1	String
    //   0	230	3	paramInt	int
    //   0	230	4	paramString2	String
    //   141	68	5	localSurfaceTexture	SurfaceTexture
    // Exception table:
    //   from	to	target	type
    //   2	21	225	finally
    //   25	36	225	finally
    //   40	133	225	finally
    //   133	222	225	finally
  }
  
  protected void registerInstance(int paramInt1, String paramString, int paramInt2, int paramInt3, SurfaceTexture paramSurfaceTexture)
  {
    paramSurfaceTexture = new InstanceDep(paramInt2, paramInt3, paramSurfaceTexture);
    getInstanceMapForCanvas(paramString).put(Integer.valueOf(paramInt1), paramSurfaceTexture);
  }
  
  protected abstract void replaceDisplaySurface(int paramInt, String paramString, SurfaceTexture paramSurfaceTexture);
  
  static class InstanceDep
  {
    SurfaceTextureRenderDelegate delegate;
    Map<ISkiaCanvasExternalTextureHandler, SurfaceTexture> delegatedClonedDownStreamSurfaceMap;
    SurfaceTexture delegatedUpStreamSurface;
    final int height;
    SurfaceTexture originDisplaySurface;
    final int width;
    
    InstanceDep(int paramInt1, int paramInt2, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(4329);
      this.width = paramInt1;
      this.height = paramInt2;
      this.originDisplaySurface = paramSurfaceTexture;
      this.delegatedClonedDownStreamSurfaceMap = new HashMap();
      AppMethodBeat.o(4329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
 * JD-Core Version:    0.7.0.1
 */