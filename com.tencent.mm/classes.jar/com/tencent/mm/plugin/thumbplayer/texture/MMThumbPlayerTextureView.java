package com.tencent.mm.plugin.thumbplayer.texture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PLAYER_SCALE_BOTH_FULLSCREEN", "getPLAYER_SCALE_BOTH_FULLSCREEN", "()I", "PLAYER_SCALE_ORIGINAL_FULLSCREEN", "getPLAYER_SCALE_ORIGINAL_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_RATIO", "getPLAYER_SCALE_ORIGINAL_RATIO", "PLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "radioHeight", "radioWidth", "textureListener", "com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoScale", "", "videoWidth", "xyAxis", "initView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setRadio", "num", "den", "setScaleParam", "scale", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "width", "height", "setXYAxis", "plugin-thumbplayer_release"})
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  private int videoHeight;
  private int videoWidth;
  private final int zYA;
  private final int zYB;
  private final int zYC;
  private int zYD;
  private int zYE;
  private float zYF;
  private int zYG;
  private int zYH;
  private TextureView.SurfaceTextureListener zYI;
  private final a zYJ;
  private final int zYz;
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(209684);
    this.zYA = 1;
    this.zYB = 2;
    this.zYC = 6;
    this.zYE = this.zYz;
    this.zYF = 1.0F;
    this.zYJ = new a(this);
    initView();
    AppMethodBeat.o(209684);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209685);
    this.zYA = 1;
    this.zYB = 2;
    this.zYC = 6;
    this.zYE = this.zYz;
    this.zYF = 1.0F;
    this.zYJ = new a(this);
    initView();
    AppMethodBeat.o(209685);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209686);
    this.zYA = 1;
    this.zYB = 2;
    this.zYC = 6;
    this.zYE = this.zYz;
    this.zYF = 1.0F;
    this.zYJ = new a(this);
    initView();
    AppMethodBeat.o(209686);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(209680);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.zYJ);
    AppMethodBeat.o(209680);
  }
  
  public final int getPLAYER_SCALE_BOTH_FULLSCREEN()
  {
    return this.zYA;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_FULLSCREEN()
  {
    return this.zYB;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO()
  {
    return this.zYz;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE()
  {
    return this.zYC;
  }
  
  public final void hS(int paramInt1, int paramInt2)
  {
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209683);
    int i;
    float f;
    if ((this.videoWidth > 0) && (this.videoHeight > 0))
    {
      paramInt1 = View.getDefaultSize(getWidth(), paramInt1);
      i = View.getDefaultSize(getHeight(), paramInt2);
      f = 1.0F;
      Object localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(209683);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(209683);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      if (this.zYE == this.zYB)
      {
        if (this.videoWidth * i > this.videoHeight * paramInt1)
        {
          paramInt2 = this.videoWidth * i / this.videoHeight;
          paramInt1 = i;
          setMeasuredDimension((int)(paramInt2 * this.zYF * f), (int)(paramInt1 * this.zYF * f));
          AppMethodBeat.o(209683);
          return;
        }
        if (this.videoWidth * i >= this.videoHeight * paramInt1) {
          break label557;
        }
      }
    }
    label535:
    label544:
    label557:
    for (paramInt2 = this.videoHeight * paramInt1 / this.videoWidth;; paramInt2 = i)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
      break;
      if (this.zYE != this.zYA)
      {
        if (this.zYE == this.zYC)
        {
          if (this.videoWidth * i > this.videoHeight * paramInt1)
          {
            i = this.videoHeight * paramInt1 / this.videoWidth;
            paramInt2 = paramInt1;
            paramInt1 = i;
            break;
          }
          if (this.videoWidth * i >= this.videoHeight * paramInt1) {
            break label544;
          }
          paramInt1 = this.videoWidth * i / this.videoHeight;
        }
        for (f = i / (this.videoWidth / this.videoHeight * i);; f = 1.0F)
        {
          paramInt2 = paramInt1;
          paramInt1 = i;
          break;
          int j = this.videoWidth;
          paramInt2 = j;
          if (this.zYG != 0)
          {
            paramInt2 = j;
            if (this.zYH != 0) {
              paramInt2 = (int)(this.videoWidth * this.zYG / this.zYH);
            }
          }
          if (paramInt2 * i > this.videoHeight * paramInt1)
          {
            paramInt2 = this.videoHeight * paramInt1 / paramInt2;
            j = paramInt1;
          }
          for (;;)
          {
            if (((this.zYD == 90) || (this.zYD == 270)) && (paramInt2 > 0) && (j > 0))
            {
              if (paramInt1 / paramInt2 < i / j)
              {
                f = paramInt1 / paramInt2;
                paramInt1 = paramInt2;
                paramInt2 = j;
                break;
                if (paramInt2 * i >= this.videoHeight * paramInt1) {
                  break label535;
                }
                j = paramInt2 * i / this.videoHeight;
                paramInt2 = i;
                continue;
              }
              f = i / j;
              paramInt1 = paramInt2;
              paramInt2 = j;
              break;
              super.onMeasure(paramInt1, paramInt2);
              AppMethodBeat.o(209683);
              return;
            }
            paramInt1 = paramInt2;
            paramInt2 = j;
            break;
            paramInt2 = i;
            j = paramInt1;
          }
        }
      }
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
    }
  }
  
  public final void setOpaqueInfo(boolean paramBoolean)
  {
    AppMethodBeat.i(209681);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(209681);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(209681);
  }
  
  public final void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.zYE = this.zYz;
      this.zYF = paramFloat;
    }
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(209682);
    k.h(paramSurfaceTextureListener, "listener");
    this.zYI = paramSurfaceTextureListener;
    AppMethodBeat.o(209682);
  }
  
  public final void setXYAxis(int paramInt)
  {
    this.zYE = paramInt;
    this.zYF = 1.0F;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209676);
      k.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.zYK);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(209676);
        return;
      }
      AppMethodBeat.o(209676);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(209677);
      k.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.zYK);
      if (localSurfaceTextureListener != null) {
        localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
      AppMethodBeat.o(209677);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209678);
      k.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.zYK);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(209678);
        return;
      }
      AppMethodBeat.o(209678);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(209679);
      k.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.zYK);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
        AppMethodBeat.o(209679);
        return;
      }
      AppMethodBeat.o(209679);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */