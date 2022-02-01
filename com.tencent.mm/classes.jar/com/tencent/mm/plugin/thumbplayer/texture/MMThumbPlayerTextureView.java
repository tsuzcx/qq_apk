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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView;", "Lcom/tencent/mm/ui/base/MMTextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PLAYER_SCALE_BOTH_FULLSCREEN", "getPLAYER_SCALE_BOTH_FULLSCREEN", "()I", "PLAYER_SCALE_ORIGINAL_FULLSCREEN", "getPLAYER_SCALE_ORIGINAL_FULLSCREEN", "PLAYER_SCALE_ORIGINAL_RATIO", "getPLAYER_SCALE_ORIGINAL_RATIO", "PLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE", "radioHeight", "radioWidth", "textureListener", "com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Lcom/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1;", "textureListenerCallback", "Landroid/view/TextureView$SurfaceTextureListener;", "videoDegree", "videoHeight", "videoScale", "", "videoWidth", "xyAxis", "initView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDegree", "", "degree", "setOpaqueInfo", "isOpaque", "setRadio", "num", "den", "setScaleParam", "scale", "setTextureListenerCallback", "listener", "setVideoWidthAndHeight", "width", "height", "setXYAxis", "plugin-thumbplayer_release"})
public final class MMThumbPlayerTextureView
  extends MMTextureView
{
  private final int Bql;
  private final int Bqm;
  private final int Bqn;
  private final int Bqo;
  private int Bqp;
  private int Bqq;
  private float Bqr;
  private int Bqs;
  private int Bqt;
  private TextureView.SurfaceTextureListener Bqu;
  private final a Bqv;
  public int videoHeight;
  public int videoWidth;
  
  public MMThumbPlayerTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(217105);
    this.Bqm = 1;
    this.Bqn = 2;
    this.Bqo = 6;
    this.Bqq = this.Bql;
    this.Bqr = 1.0F;
    this.Bqv = new a(this);
    initView();
    AppMethodBeat.o(217105);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(217106);
    this.Bqm = 1;
    this.Bqn = 2;
    this.Bqo = 6;
    this.Bqq = this.Bql;
    this.Bqr = 1.0F;
    this.Bqv = new a(this);
    initView();
    AppMethodBeat.o(217106);
  }
  
  public MMThumbPlayerTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(217107);
    this.Bqm = 1;
    this.Bqn = 2;
    this.Bqo = 6;
    this.Bqq = this.Bql;
    this.Bqr = 1.0F;
    this.Bqv = new a(this);
    initView();
    AppMethodBeat.o(217107);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(217101);
    setOpaque(false);
    setAlpha(0.0F);
    setScaleX(1.0001F);
    setScaleY(1.0001F);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this.Bqv);
    AppMethodBeat.o(217101);
  }
  
  public final int getPLAYER_SCALE_BOTH_FULLSCREEN()
  {
    return this.Bqm;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_FULLSCREEN()
  {
    return this.Bqn;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO()
  {
    return this.Bql;
  }
  
  public final int getPLAYER_SCALE_ORIGINAL_RATIO_SQUARE()
  {
    return this.Bqo;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217104);
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
        AppMethodBeat.o(217104);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).topMargin = 0;
      localObject = getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(217104);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      if (this.Bqq == this.Bqn)
      {
        if (this.videoWidth * i > this.videoHeight * paramInt1)
        {
          paramInt2 = this.videoWidth * i / this.videoHeight;
          paramInt1 = i;
          setMeasuredDimension((int)(paramInt2 * this.Bqr * f), (int)(paramInt1 * this.Bqr * f));
          AppMethodBeat.o(217104);
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
      if (this.Bqq != this.Bqm)
      {
        if (this.Bqq == this.Bqo)
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
          if (this.Bqs != 0)
          {
            paramInt2 = j;
            if (this.Bqt != 0) {
              paramInt2 = (int)(this.videoWidth * this.Bqs / this.Bqt);
            }
          }
          if (paramInt2 * i > this.videoHeight * paramInt1)
          {
            paramInt2 = this.videoHeight * paramInt1 / paramInt2;
            j = paramInt1;
          }
          for (;;)
          {
            if (((this.Bqp == 90) || (this.Bqp == 270)) && (paramInt2 > 0) && (j > 0))
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
              AppMethodBeat.o(217104);
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
    AppMethodBeat.i(217102);
    if (paramBoolean)
    {
      setOpaque(true);
      setAlpha(1.0F);
      AppMethodBeat.o(217102);
      return;
    }
    setOpaque(false);
    setAlpha(0.0F);
    AppMethodBeat.o(217102);
  }
  
  public final void setScaleParam(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      this.Bqq = this.Bql;
      this.Bqr = paramFloat;
    }
  }
  
  public final void setTextureListenerCallback(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(217103);
    p.h(paramSurfaceTextureListener, "listener");
    this.Bqu = paramSurfaceTextureListener;
    AppMethodBeat.o(217103);
  }
  
  public final void setXYAxis(int paramInt)
  {
    this.Bqq = paramInt;
    this.Bqr = 1.0F;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/thumbplayer/texture/MMThumbPlayerTextureView$textureListener$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"})
  public static final class a
    implements TextureView.SurfaceTextureListener
  {
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217097);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.Bqw);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(217097);
        return;
      }
      AppMethodBeat.o(217097);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(217098);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.Bqw);
      if (localSurfaceTextureListener != null) {
        localSurfaceTextureListener.onSurfaceTextureDestroyed(paramSurfaceTexture);
      }
      AppMethodBeat.o(217098);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(217099);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.Bqw);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(217099);
        return;
      }
      AppMethodBeat.o(217099);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(217100);
      p.h(paramSurfaceTexture, "surface");
      TextureView.SurfaceTextureListener localSurfaceTextureListener = MMThumbPlayerTextureView.a(this.Bqw);
      if (localSurfaceTextureListener != null)
      {
        localSurfaceTextureListener.onSurfaceTextureUpdated(paramSurfaceTexture);
        AppMethodBeat.o(217100);
        return;
      }
      AppMethodBeat.o(217100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.texture.MMThumbPlayerTextureView
 * JD-Core Version:    0.7.0.1
 */