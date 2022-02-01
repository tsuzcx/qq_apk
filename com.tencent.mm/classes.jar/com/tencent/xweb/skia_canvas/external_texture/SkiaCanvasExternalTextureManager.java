package com.tencent.xweb.skia_canvas.external_texture;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class SkiaCanvasExternalTextureManager
  implements ISkiaCanvasExternalTextureController
{
  private static final String TAG = "ExternalTextureManager";
  private List<SkiaCanvasExternalTexturePlugin> mPluginList;
  
  private SkiaCanvasExternalTextureManager()
  {
    AppMethodBeat.i(4326);
    this.mPluginList = new ArrayList();
    AppMethodBeat.o(4326);
  }
  
  /* Error */
  private SkiaCanvasExternalTexturePlugin findPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 4325
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 33	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTextureManager:mPluginList	Ljava/util/List;
    //   12: invokeinterface 47 1 0
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface 53 1 0
    //   24: ifeq +33 -> 57
    //   27: aload_3
    //   28: invokeinterface 57 1 0
    //   33: checkcast 59	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin
    //   36: astore_2
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 63	com/tencent/xweb/skia_canvas/external_texture/SkiaCanvasExternalTexturePlugin:supportType	(Ljava/lang/String;)Z
    //   42: ifeq -24 -> 18
    //   45: sipush 4325
    //   48: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: areturn
    //   57: aconst_null
    //   58: astore_1
    //   59: sipush 4325
    //   62: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -12 -> 53
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	SkiaCanvasExternalTextureManager
    //   0	73	1	paramString	String
    //   36	16	2	localSkiaCanvasExternalTexturePlugin	SkiaCanvasExternalTexturePlugin
    //   17	11	3	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   2	18	68	finally
    //   18	51	68	finally
    //   59	65	68	finally
  }
  
  public static SkiaCanvasExternalTextureManager getInstance()
  {
    return Holder.INSTANCE;
  }
  
  public boolean load(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(174309);
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null)
    {
      boolean bool = localSkiaCanvasExternalTexturePlugin.load(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
      AppMethodBeat.o(174309);
      return bool;
    }
    AppMethodBeat.o(174309);
    return false;
  }
  
  public void onDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(174311);
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null) {
      localSkiaCanvasExternalTexturePlugin.onDestroy(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    }
    AppMethodBeat.o(174311);
  }
  
  public void registerPlugin(SkiaCanvasExternalTexturePlugin paramSkiaCanvasExternalTexturePlugin)
  {
    try
    {
      AppMethodBeat.i(4321);
      this.mPluginList.add(paramSkiaCanvasExternalTexturePlugin);
      AppMethodBeat.o(4321);
      return;
    }
    finally
    {
      paramSkiaCanvasExternalTexturePlugin = finally;
      throw paramSkiaCanvasExternalTexturePlugin;
    }
  }
  
  public float[] updateImage(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(174310);
    SkiaCanvasExternalTexturePlugin localSkiaCanvasExternalTexturePlugin = findPlugin(paramString1);
    if (localSkiaCanvasExternalTexturePlugin != null) {
      localSkiaCanvasExternalTexturePlugin.updateImage(paramISkiaCanvasExternalTextureHandler, paramInt1, paramString1, paramInt2, paramString2);
    }
    AppMethodBeat.o(174310);
    return new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  }
  
  static final class Holder
  {
    static SkiaCanvasExternalTextureManager INSTANCE;
    
    static
    {
      AppMethodBeat.i(4320);
      INSTANCE = new SkiaCanvasExternalTextureManager(null);
      AppMethodBeat.o(4320);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager
 * JD-Core Version:    0.7.0.1
 */