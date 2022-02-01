package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetUtils;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.utils.MathUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CIImage
  implements Cloneable
{
  public static boolean LOG_VERBOSE = false;
  private final String TAG;
  private float alpha;
  private Bitmap bitmap;
  private CGRect frame;
  private boolean isHardMode;
  private final List<CIImage> overlayImages;
  private int preferRotation;
  private final CGSize size;
  private String textureCacheKey;
  private TextureInfo textureInfo;
  private Matrix transform;
  
  public CIImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(191801);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "CIImage() called with: bitmap = [" + paramBitmap + "]");
    }
    this.bitmap = paramBitmap;
    this.size = new CGSize(paramBitmap.getWidth(), paramBitmap.getHeight());
    AppMethodBeat.o(191801);
  }
  
  public CIImage(CGSize paramCGSize)
  {
    AppMethodBeat.i(191799);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "CIImage() called with: renderSize = [" + paramCGSize + "]");
    }
    this.size = paramCGSize;
    AppMethodBeat.o(191799);
  }
  
  public CIImage(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(191800);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "CIImage() called with: textureInfo = [" + paramTextureInfo + "]");
    }
    this.textureInfo = paramTextureInfo;
    this.size = new CGSize(paramTextureInfo.width, paramTextureInfo.height);
    AppMethodBeat.o(191800);
  }
  
  public CIImage(String paramString)
  {
    this(paramString, null);
  }
  
  public CIImage(String paramString, CGSize paramCGSize)
  {
    AppMethodBeat.i(191802);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    long l = System.currentTimeMillis();
    this.preferRotation = TAVBitmapUtils.readImagePreferRotation(paramString);
    this.bitmap = decodeBitmap(paramString, paramCGSize);
    if (this.bitmap != null)
    {
      this.size = new CGSize(this.bitmap.getWidth(), this.bitmap.getHeight());
      if (LOG_VERBOSE)
      {
        Logger.d(this.TAG, "CIImage() called with: imagePath = [" + paramString + "], sampleSize = " + paramCGSize + ", BitmapFactory.decodeFile cons ms = " + (System.currentTimeMillis() - l) + ", outBitmapSize = " + this.size);
        AppMethodBeat.o(191802);
      }
    }
    else
    {
      Logger.e(this.TAG, "CIImage: 图片解码失败！imagePath = ".concat(String.valueOf(paramString)));
      this.size = new CGSize();
    }
    AppMethodBeat.o(191802);
  }
  
  private void addOverlayImage(CIImage paramCIImage)
  {
    AppMethodBeat.i(191808);
    try
    {
      this.overlayImages.add(paramCIImage);
      return;
    }
    finally
    {
      AppMethodBeat.o(191808);
    }
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    int i = 1;
    AppMethodBeat.i(191803);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    paramString = BitmapFactory.decodeFile(paramString, localOptions2);
    AppMethodBeat.o(191803);
    return paramString;
  }
  
  private Matrix getImageTextureMatrix()
  {
    AppMethodBeat.i(191817);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    AppMethodBeat.o(191817);
    return localMatrix;
  }
  
  public void applyFillInFrame(CGRect paramCGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    AppMethodBeat.i(191813);
    Matrix localMatrix = new Matrix();
    switch (1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191813);
      return;
      localMatrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      AppMethodBeat.o(191813);
      return;
      localMatrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      AppMethodBeat.o(191813);
      return;
      paramTAVVideoConfigurationContentMode = new Matrix();
      paramTAVVideoConfigurationContentMode.postScale(paramCGRect.size.width / getExtent().size.width, paramCGRect.size.height / getExtent().size.height);
      localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
      paramTAVVideoConfigurationContentMode = new Matrix();
      paramTAVVideoConfigurationContentMode.postTranslate(paramCGRect.origin.x, paramCGRect.origin.y);
      localMatrix.postConcat(paramTAVVideoConfigurationContentMode);
      imageByApplyingTransform(localMatrix);
    }
  }
  
  public void applyPreferRotation()
  {
    AppMethodBeat.i(191809);
    applyPreferRotation(0);
    AppMethodBeat.o(191809);
  }
  
  public void applyPreferRotation(int paramInt)
  {
    AppMethodBeat.i(191810);
    TextureInfo localTextureInfo = getDrawTextureInfo();
    if (localTextureInfo == null)
    {
      AppMethodBeat.o(191810);
      return;
    }
    paramInt = localTextureInfo.preferRotation + paramInt;
    if (paramInt == 0)
    {
      AppMethodBeat.o(191810);
      return;
    }
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "applyPreferRotation: textureInfo.preferRotation = ".concat(String.valueOf(paramInt)));
    }
    Matrix localMatrix = new Matrix();
    AssetUtils.getRotationMatrix(localMatrix, paramInt, localTextureInfo.width, localTextureInfo.height);
    imageByApplyingTransform(localMatrix);
    if (paramInt % 2 == 1)
    {
      this.size.width = localTextureInfo.height;
      this.size.height = localTextureInfo.width;
    }
    AppMethodBeat.o(191810);
  }
  
  public CIImage clone()
  {
    AppMethodBeat.i(191819);
    CIImage localCIImage = new CIImage(this.size);
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.bitmap = this.bitmap;
    localCIImage.preferRotation = this.preferRotation;
    localCIImage.transform = new Matrix(this.transform);
    if (this.frame != null) {}
    for (CGRect localCGRect = new CGRect(this.frame.origin, this.frame.size);; localCGRect = null)
    {
      localCIImage.frame = localCGRect;
      localCIImage.overlayImages.clear();
      localCIImage.overlayImages.addAll(this.overlayImages);
      localCIImage.alpha = this.alpha;
      AppMethodBeat.o(191819);
      return localCIImage;
    }
  }
  
  public Bitmap convertToBitmap(CIContext paramCIContext)
  {
    AppMethodBeat.i(191816);
    TextureInfo localTextureInfo = CIContext.newTextureInfo((int)this.size.width, (int)this.size.height);
    paramCIContext.convertImageToTexture(this, localTextureInfo);
    paramCIContext = TAVGLUtils.saveBitmap(localTextureInfo);
    localTextureInfo.release();
    AppMethodBeat.o(191816);
    return paramCIContext;
  }
  
  public void draw(TextureFilter paramTextureFilter)
  {
    AppMethodBeat.i(191814);
    Object localObject = getDrawTextureInfo();
    if (localObject != null)
    {
      if (LOG_VERBOSE) {
        Logger.v(this.TAG, "draw: with drawTexture = " + localObject + ", filter = " + paramTextureFilter);
      }
      paramTextureFilter.applyFilter((TextureInfo)localObject, this.transform, ((TextureInfo)localObject).getTextureMatrix(), this.alpha, this.frame);
    }
    if (this.overlayImages.isEmpty())
    {
      AppMethodBeat.o(191814);
      return;
    }
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "draw: with: draw overlayImages = " + this.overlayImages + ", filter = " + paramTextureFilter);
    }
    localObject = this.overlayImages.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CIImage)((Iterator)localObject).next()).draw(paramTextureFilter);
    }
    AppMethodBeat.o(191814);
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public TextureInfo getDrawTextureInfo()
  {
    AppMethodBeat.i(191815);
    if (this.textureInfo != null)
    {
      localObject1 = this.textureInfo;
      AppMethodBeat.o(191815);
      return localObject1;
    }
    Object localObject1 = EGL14.eglGetCurrentContext();
    if (this.textureCacheKey == null) {
      this.textureCacheKey = String.valueOf(hashCode());
    }
    Object localObject2 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
    if ((localObject1 != null) && (localObject2 != null) && (!((TextureInfo)localObject2).isReleased()))
    {
      AppMethodBeat.o(191815);
      return localObject2;
    }
    if (this.bitmap != null)
    {
      int i = RenderContext.createTexture(3553);
      localObject2 = getImageTextureMatrix();
      localObject2 = new TextureInfo(i, 3553, this.bitmap.getWidth(), this.bitmap.getHeight(), (Matrix)localObject2, this.preferRotation);
      GLES20.glBindTexture(3553, ((TextureInfo)localObject2).textureID);
      GLUtils.texImage2D(3553, 0, this.bitmap, 0);
      GLES20.glBindTexture(3553, 0);
      ThreadLocalTextureCache.getInstance().putTextureInfo(this.textureCacheKey, (TextureInfo)localObject2);
      if (LOG_VERBOSE) {
        Logger.v(this.TAG, "getDrawTextureInfo: bind bitmap texture, texture = " + localObject2 + ", eglContext = " + localObject1);
      }
      if (this.isHardMode)
      {
        this.bitmap.recycle();
        this.bitmap = null;
        if (LOG_VERBOSE) {
          Logger.v(this.TAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
        }
      }
      AppMethodBeat.o(191815);
      return localObject2;
    }
    AppMethodBeat.o(191815);
    return null;
  }
  
  public CGRect getExtent()
  {
    AppMethodBeat.i(191804);
    CGRect localCGRect = new CGRect(new PointF(0.0F, 0.0F), this.size);
    AppMethodBeat.o(191804);
    return localCGRect;
  }
  
  public CGSize getSize()
  {
    return this.size;
  }
  
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  public CIImage imageByApplyingTransform(Matrix paramMatrix)
  {
    AppMethodBeat.i(191807);
    if (this.transform == null) {
      this.transform = new Matrix();
    }
    this.transform.postConcat(paramMatrix);
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "imageByApplyingTransform() called with: in transform = [" + paramMatrix + "], result transform = " + this.transform);
    }
    AppMethodBeat.o(191807);
    return this;
  }
  
  public CIImage imageByCompositingOverImage(CIImage paramCIImage)
  {
    AppMethodBeat.i(191806);
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "imageByCompositingOverImage() called with: destImage = [" + paramCIImage + "]");
    }
    paramCIImage.addOverlayImage(this);
    AppMethodBeat.o(191806);
    return paramCIImage;
  }
  
  public CIImage imageByCroppingToRect(CGRect paramCGRect)
  {
    AppMethodBeat.i(191811);
    if (!Utils.isRectValid(paramCGRect))
    {
      AppMethodBeat.o(191811);
      return this;
    }
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "imageByCroppingToRect: frame = [" + paramCGRect + "]");
    }
    this.frame = paramCGRect;
    AppMethodBeat.o(191811);
    return this;
  }
  
  public boolean isCanvasImage()
  {
    return (this.bitmap == null) && (this.textureInfo == null);
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(191818);
      Logger.d(this.TAG, "release() start");
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        this.bitmap.recycle();
        this.bitmap = null;
      }
      Object localObject1 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
      if (localObject1 != null)
      {
        ((TextureInfo)localObject1).release();
        ThreadLocalTextureCache.getInstance().remove(this.textureCacheKey);
      }
      localObject1 = this.overlayImages.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        CIImage localCIImage = (CIImage)((Iterator)localObject1).next();
        if (localCIImage != null) {
          localCIImage.release();
        }
      }
      this.overlayImages.clear();
    }
    finally {}
    Logger.d(this.TAG, "release() end");
    AppMethodBeat.o(191818);
  }
  
  public void reset()
  {
    AppMethodBeat.i(191805);
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "reset() called, before transform = " + this.transform);
    }
    if (this.transform != null) {
      this.transform = null;
    }
    AppMethodBeat.o(191805);
  }
  
  public CIImage safeApplyTransform(Matrix paramMatrix)
  {
    AppMethodBeat.i(191812);
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      AppMethodBeat.o(191812);
      return this;
    }
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "safeApplyTransform: transform = [" + paramMatrix + "]");
    }
    float f1 = getExtent().origin.x + getExtent().size.width / 2.0F;
    float f2 = getExtent().origin.y + getExtent().size.height / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(-f1, -f2);
    localMatrix.postConcat(paramMatrix);
    paramMatrix = new Matrix();
    paramMatrix.postTranslate(f1, f2);
    localMatrix.postConcat(paramMatrix);
    paramMatrix = imageByApplyingTransform(localMatrix);
    AppMethodBeat.o(191812);
    return paramMatrix;
  }
  
  public void setAlpha(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setHardMode(boolean paramBoolean)
  {
    this.isHardMode = paramBoolean;
  }
  
  public CIImage simpleClone()
  {
    AppMethodBeat.i(191820);
    CIImage localCIImage = new CIImage(this.size);
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.preferRotation = this.preferRotation;
    localCIImage.bitmap = this.bitmap;
    localCIImage.alpha = this.alpha;
    AppMethodBeat.o(191820);
    return localCIImage;
  }
  
  public String toString()
  {
    AppMethodBeat.i(191821);
    String str = "CIImage{hash=" + Integer.toHexString(hashCode()) + ", size=" + this.size + ", textureInfo=" + this.textureInfo + ", bitmap=" + this.bitmap + ", transform=" + this.transform + ", frame=" + this.frame + ", overlayImages=" + this.overlayImages + '}';
    AppMethodBeat.o(191821);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImage
 * JD-Core Version:    0.7.0.1
 */