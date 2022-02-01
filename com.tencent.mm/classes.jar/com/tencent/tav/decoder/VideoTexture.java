package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.Utils;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class VideoTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = "VideoTexture";
  private Filter copyFilter;
  private VideoCropInfo cropInfo;
  private boolean frameAvailable;
  private final Object frameSyncObject;
  private int preferRotation;
  private boolean quitFlag;
  private RenderContext renderContext;
  private SurfaceTexture surfaceTexture;
  private TextureInfo textureInfo;
  private Matrix textureMatrix;
  private int textureType;
  
  public VideoTexture(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 36197, 0);
  }
  
  public VideoTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, RenderContext.createTexture(paramInt3));
    AppMethodBeat.i(216082);
    AppMethodBeat.o(216082);
  }
  
  public VideoTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(216095);
    this.frameSyncObject = new Object();
    this.quitFlag = false;
    this.preferRotation = 0;
    this.textureType = paramInt3;
    this.surfaceTexture = new SurfaceTexture(paramInt5);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      this.textureInfo = new TextureInfo(paramInt5, paramInt3, paramInt1, paramInt2, null, paramInt4);
      this.preferRotation = paramInt4;
      AppMethodBeat.o(216095);
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
  }
  
  public VideoTexture(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(216057);
    this.frameSyncObject = new Object();
    this.quitFlag = false;
    this.preferRotation = 0;
    this.textureInfo = paramTextureInfo;
    this.surfaceTexture = new SurfaceTexture(paramTextureInfo.textureID);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      paramTextureInfo = new float[16];
      this.surfaceTexture.getTransformMatrix(paramTextureInfo);
      this.preferRotation = 0;
      AppMethodBeat.o(216057);
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
  }
  
  private Matrix getTextureMatrix(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(216130);
    Object localObject = new float[16];
    paramSurfaceTexture.getTransformMatrix((float[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[4];
    float f3 = localObject[12];
    float f4 = localObject[1];
    float f5 = localObject[5];
    float f6 = localObject[13];
    paramSurfaceTexture = new Matrix();
    localObject = new Matrix();
    if (paramInt != 0) {
      DecoderUtils.getRotationMatrix((Matrix)localObject, paramInt, 1.0F, 1.0F);
    }
    if (((int)f1 == f1) && ((int)f4 == f4) && ((int)f2 == f2) && ((int)f5 == f5))
    {
      paramSurfaceTexture.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
      if (paramInt != 0) {
        paramSurfaceTexture.preConcat((Matrix)localObject);
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Matrix localMatrix = new Matrix();
        ((Matrix)localObject).invert(localMatrix);
        paramSurfaceTexture.postConcat(localMatrix);
      }
      AppMethodBeat.o(216130);
      return paramSurfaceTexture;
      paramSurfaceTexture.setValues(new float[] { f1, f2, f3, f4, f5, f6, 0.0F, 0.0F, 1.0F });
    }
  }
  
  private boolean isIdentity()
  {
    AppMethodBeat.i(216039);
    if ((this.textureMatrix == null) || (this.textureMatrix.isIdentity()))
    {
      AppMethodBeat.o(216039);
      return true;
    }
    AppMethodBeat.o(216039);
    return false;
  }
  
  private boolean isOES()
  {
    return this.textureType == 36197;
  }
  
  private void reflectLooper()
  {
    AppMethodBeat.i(216115);
    Object localObject3 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject3[i];
      if (!localObject1.getName().toLowerCase().contains("handler")) {}
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(216115);
        return;
        i += 1;
        break;
      }
      try
      {
        localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, Looper.getMainLooper() });
        localObject3 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(this.surfaceTexture, localObject1);
        AppMethodBeat.o(216115);
        return;
      }
      catch (Exception localException)
      {
        Logger.e("VideoTexture", "reflectLooper", localException);
        AppMethodBeat.o(216115);
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private void releaseFilter()
  {
    AppMethodBeat.i(216139);
    if (this.copyFilter != null) {
      this.copyFilter.release();
    }
    AppMethodBeat.o(216139);
  }
  
  private void releaseTextureInfo()
  {
    AppMethodBeat.i(216150);
    if (this.textureInfo != null)
    {
      this.textureInfo.release();
      this.textureInfo = null;
    }
    AppMethodBeat.o(216150);
  }
  
  boolean awaitNewImage()
  {
    AppMethodBeat.i(216259);
    boolean bool = awaitNewImage(3000L);
    AppMethodBeat.o(216259);
    return bool;
  }
  
  public boolean awaitNewImage(long paramLong)
  {
    AppMethodBeat.i(216279);
    int i = (int)Math.ceil((float)paramLong * 1.0F / 50.0F);
    synchronized (this.frameSyncObject)
    {
      while (!this.frameAvailable)
      {
        boolean bool = this.quitFlag;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      this.frameAvailable = false;
      if (i == 0)
      {
        AppMethodBeat.o(216279);
        return false;
      }
      if (this.quitFlag)
      {
        this.quitFlag = false;
        AppMethodBeat.o(216279);
        return false;
      }
    }
    RenderContext.checkEglError("before updateTexImage");
    this.surfaceTexture.updateTexImage();
    ??? = getTextureMatrix(this.surfaceTexture, this.preferRotation);
    if ((??? != null) && ("HUAWEI_ARE-AL00".equals(Utils.getPhoneName())) && (this.preferRotation == 1))
    {
      float[] arrayOfFloat = new float[9];
      ((Matrix)???).getValues(arrayOfFloat);
      ((Matrix)???).setValues(new float[] { -arrayOfFloat[4], 0.0F, arrayOfFloat[4], 0.0F, arrayOfFloat[0], arrayOfFloat[2], arrayOfFloat[6], arrayOfFloat[7], arrayOfFloat[8] });
    }
    this.textureInfo.setTextureMatrix((Matrix)???);
    if ((this.cropInfo != null) && ((this.cropInfo.cropRight - this.cropInfo.cropLeft != this.cropInfo.width) || (this.cropInfo.cropBottom - this.cropInfo.cropTop != this.cropInfo.height))) {
      this.textureInfo.setTextureRect(new Rect(this.cropInfo.cropLeft, this.cropInfo.cropTop, this.cropInfo.cropRight, this.cropInfo.cropBottom));
    }
    AppMethodBeat.o(216279);
    return true;
  }
  
  public TextureInfo copyTexture()
  {
    AppMethodBeat.i(216338);
    if (this.copyFilter == null)
    {
      this.copyFilter = new Filter();
      this.copyFilter.setRendererWidth(this.renderContext.width());
      this.copyFilter.setRendererHeight(this.renderContext.height());
      this.copyFilter.setRenderForScreen(false);
    }
    TextureInfo localTextureInfo = this.copyFilter.applyFilter(this.textureInfo, null, this.textureInfo.getTextureMatrix());
    AppMethodBeat.o(216338);
    return localTextureInfo;
  }
  
  public VideoCropInfo getCropInfo()
  {
    return this.cropInfo;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    AppMethodBeat.i(216294);
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped");
        AppMethodBeat.o(216294);
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      AppMethodBeat.o(216294);
      return;
    }
  }
  
  public void quitIfWaiting()
  {
    AppMethodBeat.i(216310);
    synchronized (this.frameSyncObject)
    {
      this.quitFlag = true;
      this.frameSyncObject.notifyAll();
      AppMethodBeat.o(216310);
      return;
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(216320);
    releaseTextureInfo();
    releaseSurfaceTexture();
    releaseFilter();
    AppMethodBeat.o(216320);
  }
  
  public void releaseSurfaceTexture()
  {
    AppMethodBeat.i(216327);
    if (this.surfaceTexture != null)
    {
      this.surfaceTexture.release();
      this.surfaceTexture = null;
    }
    AppMethodBeat.o(216327);
  }
  
  public void setCropInfo(VideoCropInfo paramVideoCropInfo)
  {
    AppMethodBeat.i(216204);
    this.cropInfo = paramVideoCropInfo;
    if ((paramVideoCropInfo != null) && (paramVideoCropInfo.width > 0) && (paramVideoCropInfo.height > 0)) {
      this.textureInfo = new TextureInfo(this.textureInfo.textureID, this.textureInfo.textureType, paramVideoCropInfo.width, paramVideoCropInfo.height, null, this.textureInfo.preferRotation);
    }
    AppMethodBeat.o(216204);
  }
  
  public void setRenderContext(RenderContext paramRenderContext)
  {
    this.renderContext = paramRenderContext;
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public Matrix surfaceTextureMatrix()
  {
    AppMethodBeat.i(216229);
    if ((isIdentity()) && (isOES())) {
      this.textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
    }
    Matrix localMatrix = this.textureMatrix;
    AppMethodBeat.o(216229);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.decoder.VideoTexture
 * JD-Core Version:    0.7.0.1
 */