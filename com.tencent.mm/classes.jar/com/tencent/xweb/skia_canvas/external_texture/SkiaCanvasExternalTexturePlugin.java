package com.tencent.xweb.skia_canvas.external_texture;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class SkiaCanvasExternalTexturePlugin
  implements ISkiaCanvasExternalTextureController
{
  private Map<ISkiaCanvasExternalTextureHandler, PluginLoadResult> mLoadResultMap = new ConcurrentHashMap();
  private Map<ISkiaCanvasExternalTextureHandler, Boolean> mSurfaceTextureAttachedMap = new ConcurrentHashMap();
  
  public boolean load(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    paramString1 = onPluginInstanceLoad(paramISkiaCanvasExternalTextureHandler, paramString1, paramInt, paramString2);
    if ((paramString1.surfaceTexture == null) || (paramString1.height < 0) || (paramString1.width < 0)) {
      return false;
    }
    paramString1.surfaceTexture.setOnFrameAvailableListener(new PluginFrameAvailableListener(paramISkiaCanvasExternalTextureHandler));
    paramString1.surfaceTexture.setDefaultBufferSize(paramString1.width, paramString1.height);
    paramISkiaCanvasExternalTextureHandler.onLoad(paramString1.surfaceTexture, paramString1.width, paramString1.height);
    this.mLoadResultMap.put(paramISkiaCanvasExternalTextureHandler, paramString1);
    this.mSurfaceTextureAttachedMap.put(paramISkiaCanvasExternalTextureHandler, Boolean.FALSE);
    return true;
  }
  
  public void onDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2)
  {
    onPluginInstanceDestroy(paramISkiaCanvasExternalTextureHandler, paramInt, paramString2);
    this.mLoadResultMap.remove(paramISkiaCanvasExternalTextureHandler);
    this.mSurfaceTextureAttachedMap.remove(paramISkiaCanvasExternalTextureHandler);
  }
  
  public abstract void onPluginInstanceDestroy(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt, String paramString);
  
  public PluginUpdateResult onPluginInstanceImageUpdate(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, int paramInt2)
  {
    Boolean localBoolean = (Boolean)this.mSurfaceTextureAttachedMap.get(paramISkiaCanvasExternalTextureHandler);
    PluginLoadResult localPluginLoadResult = (PluginLoadResult)this.mLoadResultMap.get(paramISkiaCanvasExternalTextureHandler);
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      localPluginLoadResult.surfaceTexture.attachToGLContext(paramInt1);
      this.mSurfaceTextureAttachedMap.put(paramISkiaCanvasExternalTextureHandler, Boolean.TRUE);
    }
    localPluginLoadResult.surfaceTexture.updateTexImage();
    paramISkiaCanvasExternalTextureHandler = new float[16];
    localPluginLoadResult.surfaceTexture.getTransformMatrix(paramISkiaCanvasExternalTextureHandler);
    return new PluginUpdateResult(paramISkiaCanvasExternalTextureHandler);
  }
  
  public abstract PluginLoadResult onPluginInstanceLoad(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, String paramString1, int paramInt, String paramString2);
  
  public abstract boolean supportType(String paramString);
  
  public float[] updateImage(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    return onPluginInstanceImageUpdate(paramISkiaCanvasExternalTextureHandler, paramInt1, paramInt2).transform;
  }
  
  static class PluginFrameAvailableListener
    implements SurfaceTexture.OnFrameAvailableListener
  {
    private ISkiaCanvasExternalTextureHandler mHandler;
    
    PluginFrameAvailableListener(ISkiaCanvasExternalTextureHandler paramISkiaCanvasExternalTextureHandler)
    {
      this.mHandler = paramISkiaCanvasExternalTextureHandler;
    }
    
    public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(4327);
      this.mHandler.onFrameAvailable();
      AppMethodBeat.o(4327);
    }
  }
  
  public static class PluginLoadResult
  {
    int height;
    SurfaceTexture surfaceTexture;
    int width;
    
    public PluginLoadResult(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      this.surfaceTexture = paramSurfaceTexture;
      this.width = paramInt1;
      this.height = paramInt2;
    }
  }
  
  public static class PluginUpdateResult
  {
    float[] transform;
    
    public PluginUpdateResult(float[] paramArrayOfFloat)
    {
      this.transform = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTexturePlugin
 * JD-Core Version:    0.7.0.1
 */