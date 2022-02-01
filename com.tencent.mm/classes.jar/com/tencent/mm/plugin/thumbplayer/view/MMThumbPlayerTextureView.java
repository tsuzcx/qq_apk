package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView;", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropRect", "Landroid/graphics/Rect;", "originVideoHeight", "", "originVideoWidth", "radioHeight", "radioWidth", "scaleType", "textureListener", "com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoWidth", "centerCrop", "", "containerWidth", "containerHeight", "centerFit", "cropVideo", "getScaleType", "handleOnMeasureLikeMM", "widthMeasureSpec", "heightMeasureSpec", "initView", "onMeasure", "rotateVideoSurface", "measureWidth", "measureHeight", "setCropRect", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setOriginVideoWidthAndHeight", "width", "height", "setRadio", "num", "den", "setScaleType", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "Companion", "plugin-thumbplayer_release"})
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  private static final int GiA = 2;
  private static final int GiB = 3;
  public static final a GiC;
  private static final int Giy = 0;
  private static final int Giz = 1;
  private int Git;
  public float Giu;
  public float Giv;
  private TextureView.SurfaceTextureListener Giw;
  private final b Gix;
  private Rect iiw;
  private int scaleType;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(238818);
    GiC = new a((byte)0);
    Giz = 1;
    GiA = 2;
    GiB = 3;
    AppMethodBeat.o(238818);
  }
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(238815);
    this.scaleType = Giy;
    this.iiw = new Rect();
    this.Gix = new b(this);
    initView();
    AppMethodBeat.o(238815);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(238816);
    this.scaleType = Giy;
    this.iiw = new Rect();
    this.Gix = new b(this);
    initView();
    AppMethodBeat.o(238816);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(238817);
    this.scaleType = Giy;
    this.iiw = new Rect();
    this.Gix = new b(this);
    initView();
    AppMethodBeat.o(238817);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(238807);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.Gix);
    AppMethodBeat.o(238807);
  }
  
  private final void jl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238814);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop, container:[" + paramInt1 + ", " + paramInt2 + ']');
    float f3 = paramInt1 / this.videoWidth;
    float f1 = paramInt2 / this.videoHeight;
    float f2 = Math.max(f3, f1);
    f3 = f2 / f3;
    f1 = f2 / f1;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "centerCrop matrix:".concat(String.valueOf(localMatrix)));
    setTransform(localMatrix);
    AppMethodBeat.o(238814);
  }
  
  public final int getScaleType()
  {
    return this.scaleType;
  }
  
  public final void jk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238810);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setVideoWidthAndHeight videoWidth:" + this.videoWidth + ", videoHeight:" + this.videoHeight + ", width:" + paramInt1 + ", height:" + paramInt2 + " scaleType:" + this.scaleType);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      requestLayout();
      AppMethodBeat.o(238810);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(238810);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238813);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(238813);
      return;
    }
    int i = MMTextureView.getDefaultSize(1, paramInt1);
    int j = MMTextureView.getDefaultSize(1, paramInt2);
    int k = this.scaleType;
    if (k == Giy) {
      jl(i, j);
    }
    for (;;)
    {
      Object localObject;
      float f1;
      float f2;
      float f3;
      if ((this.Git == 90) || (this.Git == 270))
      {
        localObject = new Matrix();
        ((Matrix)localObject).set(getMatrix());
        f1 = i / 2.0F;
        f2 = j / 2.0F;
        f3 = j / i;
        if ((getScaleX() != 1.0F) || (getScaleY() != 1.0F)) {
          ((Matrix)localObject).setScale(getScaleX(), getScaleY(), f1, f2);
        }
        ((Matrix)localObject).postRotate(this.Git, f1, f2);
        ((Matrix)localObject).postScale(1.0F / f3, f3, f1, f2);
        setTransform((Matrix)localObject);
      }
      setMeasuredDimension(i, j);
      Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "onMeasure#handleOnMeasureLikeMM video size[" + this.videoWidth + ' ' + this.videoHeight + "] spec[" + MMTextureView.getDefaultSize(1, paramInt1) + ", " + MMTextureView.getDefaultSize(1, paramInt2) + "] result=" + i + ',' + j);
      AppMethodBeat.o(238813);
      return;
      if (k == Giz)
      {
        f3 = i / this.videoWidth;
        f1 = j / this.videoHeight;
        f2 = Math.min(f3, f1);
        f3 = f2 / f3;
        f1 = f2 / f1;
        localObject = new Matrix();
        ((Matrix)localObject).setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
        setTransform((Matrix)localObject);
      }
      else if (k == GiB)
      {
        if (!this.iiw.isEmpty())
        {
          localObject = this.iiw;
          if ((this.Giu != 0.0F) && (this.Giv != 0.0F) && (!((Rect)localObject).isEmpty()))
          {
            f1 = i / ((Rect)localObject).width();
            f2 = j / ((Rect)localObject).height();
            f3 = i / this.Giu;
            float f4 = j / this.Giv;
            float f5 = Math.max(f3, f4);
            f3 = f5 / f3;
            f4 = f5 / f4;
            f5 = this.Giu / 2.0F;
            float f6 = ((Rect)localObject).centerX();
            float f7 = this.Giv / 2.0F;
            float f8 = ((Rect)localObject).centerY();
            localObject = new Matrix();
            ((Matrix)localObject).setScale(f3, f4, i / 2.0F, j / 2.0F);
            ((Matrix)localObject).postTranslate(f1 * (f5 - f6), (f7 - f8) * f2);
            Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "cropRect(), containerWidth:" + i + " containerHeight:" + j + ' ' + localObject);
            setTransform((Matrix)localObject);
          }
        }
        else
        {
          jl(i, j);
        }
      }
      else
      {
        setTransform(new Matrix());
      }
    }
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(238808);
    p.h(paramRect, "cropRect");
    this.iiw = paramRect;
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setCropRect, cropRect:".concat(String.valueOf(paramRect)));
    AppMethodBeat.o(238808);
  }
  
  public final void setOpaqueInfo(boolean paramBoolean)
  {
    AppMethodBeat.i(238811);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(238811);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(238811);
  }
  
  public final void setScaleType(int paramInt)
  {
    AppMethodBeat.i(238809);
    Log.i("MicroMsg.TP.MMThumbPlayerTextureView", "setScaleType, scaleType:".concat(String.valueOf(paramInt)));
    this.scaleType = paramInt;
    AppMethodBeat.o(238809);
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(238812);
    p.h(paramSurfaceTextureListener, "listener");
    this.Giw = paramSurfaceTextureListener;
    AppMethodBeat.o(238812);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$Companion;", "", "()V", "SCALE_TYPE_CENTER_INSIDE", "", "getSCALE_TYPE_CENTER_INSIDE", "()I", "SCALE_TYPE_CROP", "getSCALE_TYPE_CROP", "SCALE_TYPE_FULL", "getSCALE_TYPE_FULL", "SCALE_TYPR_CENTER_CROP", "getSCALE_TYPR_CENTER_CROP", "TAG", "", "plugin-thumbplayer_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/thumbplayer/view/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238803);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.GiD);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(238803);
        return;
      }
      AppMethodBeat.o(238803);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238804);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.GiD);
      if (localSurfaceTextureListener != null) {
        localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
      AppMethodBeat.o(238804);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(238805);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.GiD);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(238805);
        return;
      }
      AppMethodBeat.o(238805);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(238806);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.GiD);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
        AppMethodBeat.o(238806);
        return;
      }
      AppMethodBeat.o(238806);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */