package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.view.Surface;
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
  
  protected void onOriginSurfaceChanged(int paramInt, String paramString, Surface paramSurface)
  {
    try
    {
      paramString = (InstanceDep)getInstanceMapForCanvas(paramString).get(Integer.valueOf(paramInt));
      if ((paramString != null) && (paramString.delegate != null))
      {
        paramString.delegate.removeDownStreamSurface(paramString.originDisplaySurface);
        if (paramSurface != null)
        {
          paramString.delegate.addDownStreamSurface(paramSurface);
          paramString.originDisplaySurface = paramSurface;
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
        paramISkiaCanvasExternalTextureHandler = (Surface)paramString.delegatedClonedDownStreamSurfaceMap.get(paramISkiaCanvasExternalTextureHandler);
        if (paramISkiaCanvasExternalTextureHandler != null)
        {
          paramString.delegate.removeDownStreamSurface(paramISkiaCanvasExternalTextureHandler);
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
    //   5: invokespecial 75	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:getInstanceMapForCanvas	(Ljava/lang/String;)Ljava/util/Map;
    //   8: iload_3
    //   9: invokestatic 81	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12: invokeinterface 42 2 0
    //   17: checkcast 8	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +18 -> 40
    //   25: new 122	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult
    //   28: dup
    //   29: aconst_null
    //   30: iconst_m1
    //   31: iconst_m1
    //   32: invokespecial 125	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult:<init>	(Landroid/graphics/SurfaceTexture;II)V
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: getfield 71	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   44: ifnonnull +96 -> 140
    //   47: aload_0
    //   48: aload_2
    //   49: invokespecial 127	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:initDelegateChain	(Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep;)V
    //   52: new 101	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 129
    //   58: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: getfield 64	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:originDisplaySurface	Landroid/view/Surface;
    //   65: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   68: ldc 134
    //   70: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: iload_3
    //   74: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc 136
    //   79: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 4
    //   84: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: iload_3
    //   90: aload 4
    //   92: new 95	android/view/Surface
    //   95: dup
    //   96: aload_2
    //   97: getfield 55	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegatedUpStreamSurface	Landroid/graphics/SurfaceTexture;
    //   100: invokespecial 139	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   103: invokevirtual 142	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate:replaceDisplaySurface	(ILjava/lang/String;Landroid/view/Surface;)V
    //   106: aload_2
    //   107: getfield 64	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:originDisplaySurface	Landroid/view/Surface;
    //   110: aload_2
    //   111: getfield 146	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:width	I
    //   114: aload_2
    //   115: getfield 149	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:height	I
    //   118: invokestatic 155	com/tencent/xweb/skia_canvas/SkiaCanvasView:setSurfaceSize	(Landroid/view/Surface;II)V
    //   121: aload_2
    //   122: getfield 71	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   125: new 6	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1
    //   128: dup
    //   129: aload_0
    //   130: aload_2
    //   131: iload_3
    //   132: aload 4
    //   134: invokespecial 158	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$1:<init>	(Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate;Lcom/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep;ILjava/lang/String;)V
    //   137: invokevirtual 162	com/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate:addReleaseCallback	(Ljava/lang/Runnable;)V
    //   140: new 48	android/graphics/SurfaceTexture
    //   143: dup
    //   144: iconst_0
    //   145: invokespecial 51	android/graphics/SurfaceTexture:<init>	(I)V
    //   148: astore 5
    //   150: aload 5
    //   152: invokevirtual 58	android/graphics/SurfaceTexture:detachFromGLContext	()V
    //   155: new 95	android/view/Surface
    //   158: dup
    //   159: aload 5
    //   161: invokespecial 139	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   164: astore 6
    //   166: new 101	java/lang/StringBuilder
    //   169: dup
    //   170: ldc 164
    //   172: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload 6
    //   177: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: ldc 166
    //   182: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 5
    //   187: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: ldc 134
    //   192: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload_3
    //   196: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc 136
    //   201: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 4
    //   206: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: getfield 71	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegate	Lcom/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate;
    //   214: aload 6
    //   216: invokevirtual 88	com/tencent/xweb/skia_canvas/external_texture/SurfaceTextureRenderDelegate:addDownStreamSurface	(Landroid/view/Surface;)V
    //   219: aload_2
    //   220: getfield 93	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:delegatedClonedDownStreamSurfaceMap	Ljava/util/Map;
    //   223: aload_1
    //   224: aload 6
    //   226: invokeinterface 38 3 0
    //   231: pop
    //   232: new 122	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult
    //   235: dup
    //   236: aload 5
    //   238: aload_2
    //   239: getfield 146	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:width	I
    //   242: aload_2
    //   243: getfield 149	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate$InstanceDep:height	I
    //   246: invokespecial 125	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin$PluginLoadResult:<init>	(Landroid/graphics/SurfaceTexture;II)V
    //   249: astore_1
    //   250: goto -214 -> 36
    //   253: astore_1
    //   254: aload_0
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
    //   0	258	1	paramISkiaCanvasExternalTextureHandler	ISkiaCanvasExternalTextureHandler
    //   0	258	2	paramString1	String
    //   0	258	3	paramInt	int
    //   0	258	4	paramString2	String
    //   148	89	5	localSurfaceTexture	SurfaceTexture
    //   164	61	6	localSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   2	21	253	finally
    //   25	36	253	finally
    //   40	140	253	finally
    //   140	250	253	finally
  }
  
  protected void registerInstance(int paramInt1, String paramString, int paramInt2, int paramInt3, Surface paramSurface)
  {
    paramSurface = new InstanceDep(paramInt2, paramInt3, paramSurface);
    getInstanceMapForCanvas(paramString).put(Integer.valueOf(paramInt1), paramSurface);
  }
  
  protected abstract void replaceDisplaySurface(int paramInt, String paramString, Surface paramSurface);
  
  static class InstanceDep
  {
    SurfaceTextureRenderDelegate delegate;
    Map<ISkiaCanvasExternalTextureHandler, Surface> delegatedClonedDownStreamSurfaceMap;
    SurfaceTexture delegatedUpStreamSurface;
    final int height;
    Surface originDisplaySurface;
    final int width;
    
    InstanceDep(int paramInt1, int paramInt2, Surface paramSurface)
    {
      AppMethodBeat.i(213864);
      this.width = paramInt1;
      this.height = paramInt2;
      this.originDisplaySurface = paramSurface;
      this.delegatedClonedDownStreamSurfaceMap = new HashMap();
      AppMethodBeat.o(213864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePluginWithSurfaceTextureDelegate
 * JD-Core Version:    0.7.0.1
 */