package com.tencent.mm.plugin.thumbplayer.texture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTextureView;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PLAYER_SCALE_BOTH_FULLSCREEN", "getPLAYER_SCALE_BOTH_FULLSCREEN", "()I", "PLAYER_SCALE_ORIGINAL_FULLSCREEN", "getPLAYER_SCALE_ORIGINAL_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_RATIO", "getPLAYER_SCALE_ORIGINAL_RATIO", "PLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "radioHeight", "radioWidth", "textureListener", "com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoScale", "", "videoWidth", "xyAxis", "initView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setRadio", "num", "den", "setScaleParam", "scale", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "width", "height", "setXYAxis", "plugin-thumbplayer_release"})
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  private final int BHK;
  private final int BHL;
  private final int BHM;
  private final int BHN;
  private int BHO;
  private int BHP;
  private float BHQ;
  private int BHR;
  private int BHS;
  private TextureView.SurfaceTextureListener BHT;
  private final a BHU;
  public int videoHeight;
  public int videoWidth;
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(211715);
    this.BHL = 1;
    this.BHM = 2;
    this.BHN = 6;
    this.BHP = this.BHK;
    this.BHQ = 1.0F;
    this.BHU = new a(this);
    initView();
    AppMethodBeat.o(211715);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(211716);
    this.BHL = 1;
    this.BHM = 2;
    this.BHN = 6;
    this.BHP = this.BHK;
    this.BHQ = 1.0F;
    this.BHU = new a(this);
    initView();
    AppMethodBeat.o(211716);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(211717);
    this.BHL = 1;
    this.BHM = 2;
    this.BHN = 6;
    this.BHP = this.BHK;
    this.BHQ = 1.0F;
    this.BHU = new a(this);
    initView();
    AppMethodBeat.o(211717);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(211711);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.BHU);
    AppMethodBeat.o(211711);
  }
  
  public final int getPLAYER_SCALE_BOTH_FULLSCREEN()
  {
    return this.BHL;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_FULLSCREEN()
  {
    return this.BHM;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO()
  {
    return this.BHK;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE()
  {
    return this.BHN;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211714);
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
        AppMethodBeat.o(211714);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(211714);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      if (this.BHP == this.BHM)
      {
        if (this.videoWidth * i > this.videoHeight * paramInt1)
        {
          paramInt2 = this.videoWidth * i / this.videoHeight;
          paramInt1 = i;
          setMeasuredDimension((int)(paramInt2 * this.BHQ * f), (int)(paramInt1 * this.BHQ * f));
          AppMethodBeat.o(211714);
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
      if (this.BHP != this.BHL)
      {
        if (this.BHP == this.BHN)
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
          if (this.BHR != 0)
          {
            paramInt2 = j;
            if (this.BHS != 0) {
              paramInt2 = (int)(this.videoWidth * this.BHR / this.BHS);
            }
          }
          if (paramInt2 * i > this.videoHeight * paramInt1)
          {
            paramInt2 = this.videoHeight * paramInt1 / paramInt2;
            j = paramInt1;
          }
          for (;;)
          {
            if (((this.BHO == 90) || (this.BHO == 270)) && (paramInt2 > 0) && (j > 0))
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
              AppMethodBeat.o(211714);
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
    AppMethodBeat.i(211712);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(211712);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(211712);
  }
  
  public final void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.BHP = this.BHK;
      this.BHQ = paramFloat;
    }
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(211713);
    p.h(paramSurfaceTextureListener, "listener");
    this.BHT = paramSurfaceTextureListener;
    AppMethodBeat.o(211713);
  }
  
  public final void setXYAxis(int paramInt)
  {
    this.BHP = paramInt;
    this.BHQ = 1.0F;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(211707);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.BHV);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(211707);
        return;
      }
      AppMethodBeat.o(211707);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(211708);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.BHV);
      if (localSurfaceTextureListener != null) {
        localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
      AppMethodBeat.o(211708);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(211709);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.BHV);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(211709);
        return;
      }
      AppMethodBeat.o(211709);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(211710);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.BHV);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
        AppMethodBeat.o(211710);
        return;
      }
      AppMethodBeat.o(211710);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */