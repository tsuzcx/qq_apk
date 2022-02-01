package com.tencent.mm.plugin.thumbplayer.render;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/render/MMTextureViewRender;", "Landroid/view/TextureView;", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropRect", "Landroid/graphics/Rect;", "curSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "onSurfaceListener", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView$IOnSurfaceListener;", "originVideoHeight", "", "originVideoWidth", "scaleType", "surface", "Landroid/view/Surface;", "tagPrefix", "", "value", "videoDegree", "getVideoDegree", "()I", "setVideoDegree", "(I)V", "videoHeight", "videoWidth", "centerCrop", "", "containerWidth", "containerHeight", "centerFit", "cropVideo", "getLogTag", "getScaleType", "getSurface", "getTagPrefix", "handleOnMeasure", "widthMeasureSpec", "heightMeasureSpec", "init", "onMeasure", "reset", "rotateVideoSurface", "measureWidth", "measureHeight", "setCropRect", "setOpaqueInfo", "isOpaque", "", "setOriginVideoWidthAndHeight", "width", "height", "setScaleType", "type", "setSurfaceListener", "listener", "setTagPrefix", "tag", "setVideoWidthAndHeight", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMTextureViewRender
  extends TextureView
  implements a
{
  public static final MMTextureViewRender.a TFW;
  private Rect Gl;
  private String TFM;
  private a.a TFN;
  private int TFO;
  private float TFP;
  private float TFQ;
  private SurfaceTexture TFX;
  private int nDl;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(272258);
    TFW = new MMTextureViewRender.a((byte)0);
    AppMethodBeat.o(272258);
  }
  
  public MMTextureViewRender(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272201);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272201);
  }
  
  public MMTextureViewRender(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272211);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272211);
  }
  
  public MMTextureViewRender(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272219);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272219);
  }
  
  private final String getTagPrefix()
  {
    return this.TFM;
  }
  
  private final void init()
  {
    AppMethodBeat.i(272223);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b(this));
    AppMethodBeat.o(272223);
  }
  
  private final void mk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272235);
    Log.i(getLogTag(), "centerCrop, container:[" + paramInt1 + ", " + paramInt2 + ']');
    float f3 = paramInt1 / this.videoWidth;
    float f1 = paramInt2 / this.videoHeight;
    float f2 = Math.max(f3, f1);
    f3 = f2 / f3;
    f1 = f2 / f1;
    Matrix localMatrix = new Matrix();
    localMatrix.setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
    Log.i(getLogTag(), s.X("centerCrop matrix:", localMatrix));
    setTransform(localMatrix);
    AppMethodBeat.o(272235);
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(272344);
    String str = s.X(getTagPrefix(), "_MMTextureViewRender");
    AppMethodBeat.o(272344);
    return str;
  }
  
  public final int getScaleType()
  {
    return this.nDl;
  }
  
  public final Surface getSurface()
  {
    AppMethodBeat.i(272281);
    if (getSurfaceTexture() == null)
    {
      Log.w("MMTextureViewRender", "getSurface return for null");
      AppMethodBeat.o(272281);
      return null;
    }
    if (Build.VERSION.SDK_INT > 26)
    {
      localObject = getSurfaceTexture();
      s.checkNotNull(localObject);
      if (((SurfaceTexture)localObject).isReleased())
      {
        Log.w("MMTextureViewRender", "getSurface return for Released");
        AppMethodBeat.o(272281);
        return null;
      }
    }
    Object localObject = new Surface(getSurfaceTexture());
    AppMethodBeat.o(272281);
    return localObject;
  }
  
  public final int getVideoDegree()
  {
    return this.TFO;
  }
  
  public final void mj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272330);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      requestLayout();
      AppMethodBeat.o(272330);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(272330);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272362);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(272362);
      return;
    }
    int j = TextureView.getDefaultSize(1, paramInt1);
    int k = TextureView.getDefaultSize(1, paramInt2);
    Object localObject;
    float f1;
    float f2;
    float f3;
    switch (getScaleType())
    {
    case 2: 
    default: 
      setTransform(new Matrix());
      if ((this.TFO == 90) || (this.TFO == 270))
      {
        localObject = new Matrix();
        ((Matrix)localObject).set(getMatrix());
        f1 = j / 2.0F;
        f2 = k / 2.0F;
        f3 = k / j;
        if (getScaleX() != 1.0F) {
          break label720;
        }
        i = 1;
        label170:
        if (i != 0) {
          if (getScaleY() != 1.0F) {
            break label726;
          }
        }
      }
      break;
    }
    label465:
    label726:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        ((Matrix)localObject).setScale(getScaleX(), getScaleY(), f1, f2);
      }
      ((Matrix)localObject).postRotate(this.TFO, f1, f2);
      ((Matrix)localObject).postScale(1.0F / f3, f3, f1, f2);
      setTransform((Matrix)localObject);
      setMeasuredDimension(j, k);
      Log.i(getLogTag(), "onMeasure#handleOnMeasure video size[" + this.videoWidth + ' ' + this.videoHeight + "] spec[" + TextureView.getDefaultSize(1, paramInt1) + ", " + TextureView.getDefaultSize(1, paramInt2) + "] result=" + j + ',' + k);
      AppMethodBeat.o(272362);
      return;
      mk(j, k);
      break;
      f3 = j / this.videoWidth;
      f1 = k / this.videoHeight;
      f2 = Math.min(f3, f1);
      f3 = f2 / f3;
      f1 = f2 / f1;
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f3, f1, getWidth() / 2.0F, getHeight() / 2.0F);
      setTransform((Matrix)localObject);
      break;
      if (!this.Gl.isEmpty())
      {
        localObject = this.Gl;
        if (this.TFP == 0.0F)
        {
          i = 1;
          if (i != 0) {
            break label701;
          }
          if (this.TFQ != 0.0F) {
            break label703;
          }
        }
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (((Rect)localObject).isEmpty())) {
            break label707;
          }
          f1 = j / ((Rect)localObject).width();
          f2 = k / ((Rect)localObject).height();
          f3 = j / this.TFP;
          float f4 = k / this.TFQ;
          float f5 = Math.max(f3, f4);
          f3 = f5 / f3;
          f4 = f5 / f4;
          f5 = this.TFP / 2.0F;
          float f6 = ((Rect)localObject).centerX();
          float f7 = this.TFQ / 2.0F;
          float f8 = ((Rect)localObject).centerY();
          localObject = new Matrix();
          ((Matrix)localObject).setScale(f3, f4, j / 2.0F, k / 2.0F);
          ((Matrix)localObject).postTranslate(f1 * (f5 - f6), (f7 - f8) * f2);
          Log.i(getLogTag(), "cropRect(), containerWidth:" + j + " containerHeight:" + k + ' ' + localObject);
          setTransform((Matrix)localObject);
          break;
          i = 0;
          break label465;
          break;
        }
        break;
      }
      mk(j, k);
      break;
      i = 0;
      break label170;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(272337);
    Log.i(getLogTag(), s.X("reset cropRect=", this.Gl));
    this.Gl = new Rect();
    AppMethodBeat.o(272337);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(272314);
    s.u(paramRect, "cropRect");
    Log.i(getLogTag(), s.X("setCropRect, cropRect:", paramRect));
    this.Gl = paramRect;
    AppMethodBeat.o(272314);
  }
  
  public final void setOpaqueInfo(boolean paramBoolean)
  {
    AppMethodBeat.i(272321);
    if (paramBoolean) {
      setOpaque(true);
    }
    for (float f = 1.0F;; f = 0.0F)
    {
      setAlpha(f);
      AppMethodBeat.o(272321);
      return;
      setOpaque(false);
    }
  }
  
  public final void setScaleType(int paramInt)
  {
    AppMethodBeat.i(272301);
    Log.i(getLogTag(), s.X("setScaleType type:", Integer.valueOf(paramInt)));
    this.nDl = paramInt;
    AppMethodBeat.o(272301);
  }
  
  public final void setSurfaceListener(a.a parama)
  {
    AppMethodBeat.i(272295);
    s.u(parama, "listener");
    this.TFN = parama;
    AppMethodBeat.o(272295);
  }
  
  public final void setTagPrefix(String paramString)
  {
    AppMethodBeat.i(272289);
    s.u(paramString, "tag");
    this.TFM = paramString;
    AppMethodBeat.o(272289);
  }
  
  public final void setVideoDegree(int paramInt)
  {
    AppMethodBeat.i(272268);
    this.TFO = paramInt;
    Log.i(getLogTag(), s.X("setVideoDegree, videoDegree:", Integer.valueOf(this.TFO)));
    AppMethodBeat.o(272268);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/render/MMTextureViewRender$init$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextureView.SurfaceTextureListener
  {
    b(MMTextureViewRender paramMMTextureViewRender) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272238);
      s.u(paramSurfaceTexture, "surface");
      Log.i(this.TFY.getLogTag(), "onSurfaceTextureAvailable surface:" + paramSurfaceTexture + " [" + paramInt1 + ", " + paramInt2 + "] listener:" + MMTextureViewRender.a(this.TFY));
      MMTextureViewRender.a(this.TFY, paramSurfaceTexture);
      a.a locala = MMTextureViewRender.a(this.TFY);
      if (locala != null) {
        locala.fE(paramSurfaceTexture);
      }
      AppMethodBeat.o(272238);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272251);
      s.u(paramSurfaceTexture, "surface");
      a.a locala = MMTextureViewRender.a(this.TFY);
      if (locala == null) {}
      for (boolean bool = true;; bool = locala.fG(paramSurfaceTexture))
      {
        Log.i(this.TFY.getLogTag(), "onSurfaceTextureDestroyed surface:" + paramSurfaceTexture + " result:" + bool + " listener:" + MMTextureViewRender.a(this.TFY));
        AppMethodBeat.o(272251);
        return bool;
      }
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(272244);
      s.u(paramSurfaceTexture, "surface");
      Log.i(this.TFY.getLogTag(), "onSurfaceTextureSizeChanged surface:" + paramSurfaceTexture + " [" + paramInt1 + ", " + paramInt2 + "] listener:" + MMTextureViewRender.a(this.TFY));
      a.a locala = MMTextureViewRender.a(this.TFY);
      if (locala != null) {
        locala.h(paramSurfaceTexture, paramInt1, paramInt2);
      }
      AppMethodBeat.o(272244);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(272257);
      s.u(paramSurfaceTexture, "surface");
      a.a locala = MMTextureViewRender.a(this.TFY);
      if (locala != null) {
        locala.fF(paramSurfaceTexture);
      }
      AppMethodBeat.o(272257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.render.MMTextureViewRender
 * JD-Core Version:    0.7.0.1
 */