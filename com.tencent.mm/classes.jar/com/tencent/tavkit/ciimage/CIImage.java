package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.utils.MathUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CIImage
  implements Cloneable
{
  private static Bitmap.Config[] SUPPORT_CONFIGS = { Bitmap.Config.ALPHA_8, Bitmap.Config.RGB_565, Bitmap.Config.ARGB_4444, Bitmap.Config.ARGB_8888 };
  private final String TAG;
  private float alpha;
  private Bitmap bitmap;
  private CGRect frame;
  private boolean isHardMode;
  private final List<CIImage> overlayImages;
  private int preferRotation;
  private int rotation;
  private final CGSize size;
  private String textureCacheKey;
  private TextureInfo textureInfo;
  private Matrix transform;
  
  public CIImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(218587);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    Logger.v(this.TAG, "CIImage() called with: bitmap = [" + paramBitmap + "]");
    this.bitmap = checkBitmapConfig(paramBitmap);
    this.size = new CGSize(paramBitmap.getWidth(), paramBitmap.getHeight());
    AppMethodBeat.o(218587);
  }
  
  public CIImage(CGSize paramCGSize)
  {
    AppMethodBeat.i(218572);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    Logger.v(this.TAG, "CIImage() called with: renderSize = [" + paramCGSize + "]");
    this.size = paramCGSize;
    AppMethodBeat.o(218572);
  }
  
  public CIImage(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(218579);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    Logger.v(this.TAG, "CIImage() called with: textureInfo = [" + paramTextureInfo + "]");
    this.textureInfo = paramTextureInfo;
    this.size = new CGSize(paramTextureInfo.width, paramTextureInfo.height);
    AppMethodBeat.o(218579);
  }
  
  public CIImage(String paramString)
  {
    this(paramString, null);
  }
  
  public CIImage(String paramString, CGSize paramCGSize)
  {
    AppMethodBeat.i(218602);
    this.TAG = ("CIImage@" + Integer.toHexString(hashCode()));
    this.overlayImages = new ArrayList();
    this.isHardMode = false;
    this.alpha = 1.0F;
    long l = System.currentTimeMillis();
    this.preferRotation = TAVBitmapUtils.readImagePreferRotation(paramString);
    this.bitmap = decodeBitmap(paramString, paramCGSize);
    this.bitmap = checkBitmapConfig(this.bitmap);
    if (this.bitmap != null)
    {
      this.size = new CGSize(this.bitmap.getWidth(), this.bitmap.getHeight());
      Logger.v(this.TAG, "CIImage() called with: imagePath = [" + paramString + "], sampleSize = " + paramCGSize + ", BitmapFactory.decodeFile cons ms = " + (System.currentTimeMillis() - l) + ", outBitmapSize = " + this.size);
      AppMethodBeat.o(218602);
      return;
    }
    Logger.e(this.TAG, "CIImage: 图片解码失败！imagePath = ".concat(String.valueOf(paramString)));
    this.size = new CGSize();
    AppMethodBeat.o(218602);
  }
  
  private void addOverlayImage(CIImage paramCIImage)
  {
    AppMethodBeat.i(218629);
    try
    {
      this.overlayImages.add(paramCIImage);
      return;
    }
    finally
    {
      AppMethodBeat.o(218629);
    }
  }
  
  private Bitmap checkBitmapConfig(Bitmap paramBitmap)
  {
    AppMethodBeat.i(218613);
    if (Arrays.binarySearch(SUPPORT_CONFIGS, paramBitmap.getConfig()) < 0)
    {
      paramBitmap = transcodeBitmap(paramBitmap);
      AppMethodBeat.o(218613);
      return paramBitmap;
    }
    AppMethodBeat.o(218613);
    return paramBitmap;
  }
  
  private Bitmap decodeBitmap(String paramString, CGSize paramCGSize)
  {
    int i = 1;
    AppMethodBeat.i(218610);
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    localOptions1.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions1);
    BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
    if (paramCGSize != null) {
      i = (int)(localOptions1.outWidth / paramCGSize.width);
    }
    localOptions2.inSampleSize = i;
    localOptions2.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramString = BitmapFactory.decodeFile(paramString, localOptions2);
    AppMethodBeat.o(218610);
    return paramString;
  }
  
  private Matrix getImageTextureMatrix()
  {
    AppMethodBeat.i(218636);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
    AppMethodBeat.o(218636);
    return localMatrix;
  }
  
  private Bitmap transcodeBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(218621);
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    AppMethodBeat.o(218621);
    return localBitmap;
  }
  
  public void applyFillInFrame(CGRect paramCGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    AppMethodBeat.i(218750);
    Matrix localMatrix = new Matrix();
    switch (1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(218750);
      return;
      localMatrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      AppMethodBeat.o(218750);
      return;
      localMatrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), paramCGRect));
      imageByApplyingTransform(localMatrix);
      AppMethodBeat.o(218750);
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
  
  public void applyFixInSize(CGSize paramCGSize, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    AppMethodBeat.i(218732);
    if (!Utils.isSizeValid(paramCGSize))
    {
      AppMethodBeat.o(218732);
      return;
    }
    switch (1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[paramTAVVideoConfigurationContentMode.ordinal()])
    {
    default: 
      paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
    }
    for (;;)
    {
      paramTAVVideoConfigurationContentMode = new Matrix();
      paramTAVVideoConfigurationContentMode.postScale(paramCGSize.width / this.size.width, paramCGSize.height / this.size.height);
      imageByApplyingTransform(paramTAVVideoConfigurationContentMode);
      this.size.height = paramCGSize.height;
      this.size.width = paramCGSize.width;
      AppMethodBeat.o(218732);
      return;
      paramCGSize = MathUtils.sizeFit(this.size, paramCGSize);
      continue;
      paramCGSize = MathUtils.sizeFill(this.size, paramCGSize);
      continue;
      paramCGSize = MathUtils.sizeScale(this.size, paramCGSize);
    }
  }
  
  public void applyFlip(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f4 = 0.0F;
    float f3 = -1.0F;
    AppMethodBeat.i(218698);
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      AppMethodBeat.o(218698);
      return;
    }
    float f1;
    float f2;
    if (paramBoolean1)
    {
      f1 = -1.0F;
      if (!paramBoolean1) {
        break label114;
      }
      f2 = this.size.width;
      label50:
      if (!paramBoolean2) {
        break label120;
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        f4 = this.size.height;
      }
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f3);
      localMatrix.postTranslate(f2, f4);
      imageByApplyingTransform(localMatrix);
      AppMethodBeat.o(218698);
      return;
      f1 = 1.0F;
      break;
      label114:
      f2 = 0.0F;
      break label50;
      label120:
      f3 = 1.0F;
    }
  }
  
  public void applyPreferRotation()
  {
    AppMethodBeat.i(218702);
    applyPreferRotation(0);
    AppMethodBeat.o(218702);
  }
  
  public void applyPreferRotation(int paramInt)
  {
    AppMethodBeat.i(218711);
    TextureInfo localTextureInfo = getDrawTextureInfo();
    if (localTextureInfo == null)
    {
      AppMethodBeat.o(218711);
      return;
    }
    this.rotation = (localTextureInfo.preferRotation + paramInt);
    if (this.rotation == 0)
    {
      AppMethodBeat.o(218711);
      return;
    }
    Logger.v(this.TAG, "applyPreferRotation: textureInfo.preferRotation = " + this.rotation);
    Matrix localMatrix = new Matrix();
    DecoderUtils.getRotationMatrix(localMatrix, this.rotation, localTextureInfo.width, localTextureInfo.height);
    imageByApplyingTransform(localMatrix);
    if (this.rotation % 2 == 1)
    {
      this.size.width = localTextureInfo.height;
      this.size.height = localTextureInfo.width;
    }
    AppMethodBeat.o(218711);
  }
  
  public CIImage clone()
  {
    AppMethodBeat.i(218801);
    CIImage localCIImage = new CIImage(this.size.clone());
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.textureCacheKey = this.textureCacheKey;
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
      AppMethodBeat.o(218801);
      return localCIImage;
    }
  }
  
  @Deprecated
  public Bitmap convertToBitmap()
  {
    AppMethodBeat.i(218787);
    Bitmap localBitmap = TAVGLUtils.saveBitmap(this);
    AppMethodBeat.o(218787);
    return localBitmap;
  }
  
  public void draw(TextureFilter paramTextureFilter)
  {
    AppMethodBeat.i(218757);
    Object localObject = getDrawTextureInfo();
    if (localObject != null)
    {
      Logger.v(this.TAG, "draw: with drawTexture = " + localObject + ", filter = " + paramTextureFilter);
      paramTextureFilter.applyFilter((TextureInfo)localObject, this.transform, ((TextureInfo)localObject).getTextureMatrix(), this.alpha, this.frame);
    }
    if (this.overlayImages.isEmpty())
    {
      AppMethodBeat.o(218757);
      return;
    }
    Logger.v(this.TAG, "draw: with: draw overlayImages = " + this.overlayImages + ", filter = " + paramTextureFilter);
    localObject = this.overlayImages.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((CIImage)((Iterator)localObject).next()).draw(paramTextureFilter);
    }
    AppMethodBeat.o(218757);
  }
  
  public float getAlpha()
  {
    return this.alpha;
  }
  
  public TextureInfo getDrawTextureInfo()
  {
    AppMethodBeat.i(218776);
    if (this.textureInfo != null)
    {
      localObject1 = this.textureInfo;
      AppMethodBeat.o(218776);
      return localObject1;
    }
    Object localObject1 = EGL14.eglGetCurrentContext();
    if (this.textureCacheKey == null) {
      this.textureCacheKey = String.valueOf(hashCode());
    }
    Object localObject2 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
    if ((localObject1 != null) && (localObject2 != null) && (!((TextureInfo)localObject2).isReleased()))
    {
      AppMethodBeat.o(218776);
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
      Logger.v(this.TAG, "getDrawTextureInfo: bind bitmap texture, texture = " + localObject2 + ", eglContext = " + localObject1);
      if (this.isHardMode)
      {
        this.bitmap.recycle();
        this.bitmap = null;
        Logger.v(this.TAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
      }
      AppMethodBeat.o(218776);
      return localObject2;
    }
    AppMethodBeat.o(218776);
    return null;
  }
  
  public CGRect getExtent()
  {
    AppMethodBeat.i(218655);
    CGRect localCGRect = new CGRect(new PointF(0.0F, 0.0F), this.size);
    AppMethodBeat.o(218655);
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
  
  public CIImage imageApplyFillInFrame(CGRect paramCGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    AppMethodBeat.i(218741);
    TAVVideoConfiguration.TAVVideoConfigurationContentMode localTAVVideoConfigurationContentMode = TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill;
    applyFillInFrame(paramCGRect, paramTAVVideoConfigurationContentMode);
    AppMethodBeat.o(218741);
    return this;
  }
  
  public CIImage imageByApplyingTransform(Matrix paramMatrix)
  {
    AppMethodBeat.i(218695);
    if (this.transform == null) {
      this.transform = new Matrix();
    }
    this.transform.postConcat(paramMatrix);
    Logger.v(this.TAG, "imageByApplyingTransform() called with: in transform = [" + paramMatrix + "], result transform = " + this.transform);
    AppMethodBeat.o(218695);
    return this;
  }
  
  public CIImage imageByCompositingOverImage(CIImage paramCIImage)
  {
    AppMethodBeat.i(218687);
    Logger.v(this.TAG, "imageByCompositingOverImage() called with: destImage = [" + paramCIImage + "]");
    paramCIImage.addOverlayImage(this);
    AppMethodBeat.o(218687);
    return paramCIImage;
  }
  
  public CIImage imageByCroppingToRect(CGRect paramCGRect)
  {
    AppMethodBeat.i(218719);
    if (!Utils.isRectValid(paramCGRect))
    {
      AppMethodBeat.o(218719);
      return this;
    }
    Logger.v(this.TAG, "imageByCroppingToRect: frame = [" + paramCGRect + "]");
    this.size.width = paramCGRect.size.width;
    this.size.height = paramCGRect.size.height;
    if (this.rotation % 2 != 0) {}
    for (this.frame = new CGRect(paramCGRect.origin.y, paramCGRect.origin.x, paramCGRect.size.height, paramCGRect.size.width);; this.frame = paramCGRect.clone())
    {
      paramCGRect = paramCGRect.origin;
      if ((paramCGRect.x != 0.0F) || (paramCGRect.y != 0.0F))
      {
        Matrix localMatrix = new Matrix();
        localMatrix.postTranslate(-paramCGRect.x, -paramCGRect.y);
        imageByApplyingTransform(localMatrix);
      }
      AppMethodBeat.o(218719);
      return this;
    }
  }
  
  public boolean isCanvasImage()
  {
    return (this.bitmap == null) && (this.textureInfo == null);
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(218794);
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
    AppMethodBeat.o(218794);
  }
  
  public void reset()
  {
    AppMethodBeat.i(218679);
    Logger.v(this.TAG, "reset() called, before transform = " + this.transform);
    if (this.transform != null) {
      this.transform = null;
    }
    AppMethodBeat.o(218679);
  }
  
  public CIImage safeApplyTransform(Matrix paramMatrix)
  {
    AppMethodBeat.i(218723);
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      AppMethodBeat.o(218723);
      return this;
    }
    Logger.v(this.TAG, "safeApplyTransform: transform = [" + paramMatrix + "]");
    float f1 = getExtent().origin.x + getExtent().size.width / 2.0F;
    float f2 = getExtent().origin.y + getExtent().size.height / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(-f1, -f2);
    localMatrix.postConcat(paramMatrix);
    paramMatrix = new Matrix();
    paramMatrix.postTranslate(f1, f2);
    localMatrix.postConcat(paramMatrix);
    paramMatrix = imageByApplyingTransform(localMatrix);
    AppMethodBeat.o(218723);
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
    AppMethodBeat.i(218805);
    CIImage localCIImage = new CIImage(this.size.clone());
    localCIImage.textureInfo = this.textureInfo;
    localCIImage.preferRotation = this.preferRotation;
    localCIImage.bitmap = this.bitmap;
    localCIImage.alpha = this.alpha;
    AppMethodBeat.o(218805);
    return localCIImage;
  }
  
  public String toString()
  {
    AppMethodBeat.i(218814);
    String str = "CIImage{hash=" + Integer.toHexString(hashCode()) + ", size=" + this.size + ", textureInfo=" + this.textureInfo + ", bitmap=" + this.bitmap + ", transform=" + this.transform + ", frame=" + this.frame + ", overlayImages=" + this.overlayImages + '}';
    AppMethodBeat.o(218814);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIImage
 * JD-Core Version:    0.7.0.1
 */