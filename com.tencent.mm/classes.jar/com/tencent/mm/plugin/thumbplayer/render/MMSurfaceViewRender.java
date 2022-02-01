package com.tencent.mm.plugin.thumbplayer.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewRender;", "Landroid/view/SurfaceView;", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cropRect", "Landroid/graphics/Rect;", "onSurfaceListener", "Lcom/tencent/mm/plugin/thumbplayer/render/IMMRenderView$IOnSurfaceListener;", "originVideoHeight", "", "originVideoWidth", "scaleType", "surface", "Landroid/view/Surface;", "surfaceViewSwitchHelper", "Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewSwitchHelper;", "getSurfaceViewSwitchHelper", "()Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewSwitchHelper;", "setSurfaceViewSwitchHelper", "(Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewSwitchHelper;)V", "tagPrefix", "", "value", "videoDegree", "getVideoDegree", "()I", "setVideoDegree", "(I)V", "videoHeight", "videoWidth", "centerCrop", "", "videoRatio", "containerRatio", "containerWidth", "containerHeight", "centerFit", "cropVideo", "getBitmap", "Landroid/graphics/Bitmap;", "getLogTag", "getScaleType", "getSurface", "getTagPrefix", "handleOnMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "init", "onMeasure", "reset", "setCropRect", "setOpaqueInfo", "isOpaque", "", "setOriginVideoWidthAndHeight", "width", "height", "setScaleType", "type", "setSurfaceListener", "listener", "setTagPrefix", "tag", "setVideoWidthAndHeight", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMSurfaceViewRender
  extends SurfaceView
  implements a
{
  public static final MMSurfaceViewRender.a TFL;
  private Rect Gl;
  private b Gpj;
  private String TFM;
  private a.a TFN;
  private int TFO;
  private float TFP;
  private float TFQ;
  private int nDl;
  private Surface surface;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(272299);
    TFL = new MMSurfaceViewRender.a((byte)0);
    AppMethodBeat.o(272299);
  }
  
  public MMSurfaceViewRender(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(272225);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272225);
  }
  
  public MMSurfaceViewRender(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(272233);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272233);
  }
  
  public MMSurfaceViewRender(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(272240);
    this.TFM = "PREFIX";
    this.Gl = new Rect();
    init();
    AppMethodBeat.o(272240);
  }
  
  private static final void a(MMSurfaceViewRender paramMMSurfaceViewRender, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(272277);
    s.u(paramMMSurfaceViewRender, "this$0");
    s.u(paramArrayOfInt, "$measuredSpec");
    b localb = paramMMSurfaceViewRender.getSurfaceViewSwitchHelper();
    int i;
    int j;
    if (localb != null)
    {
      i = paramArrayOfInt[0];
      j = paramArrayOfInt[1];
      paramMMSurfaceViewRender = localb.container.findViewWithTag("MMSurfaceViewSwitchHelper.COVER_VIEW");
      if (paramMMSurfaceViewRender != null) {
        break label96;
      }
    }
    for (paramMMSurfaceViewRender = null;; paramMMSurfaceViewRender = ah.aiuX)
    {
      if (paramMMSurfaceViewRender == null) {
        Log.w(localb.getLogTag(), "onSurfaceViewSizeChange ignore captureBitmap:" + localb.TFT + '.');
      }
      AppMethodBeat.o(272277);
      return;
      label96:
      Log.w(localb.getLogTag(), "onSurfaceViewSizeChange [" + i + " x " + j + "] captureBitmap:" + localb.TFT + '.');
      paramArrayOfInt = paramMMSurfaceViewRender.getLayoutParams();
      paramArrayOfInt.width = i;
      paramArrayOfInt.height = j;
      paramMMSurfaceViewRender.setLayoutParams(paramArrayOfInt);
      paramMMSurfaceViewRender.requestLayout();
    }
  }
  
  private static int[] e(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramFloat1 < paramFloat2) {
      paramInt2 = (int)(paramInt1 / paramFloat1);
    }
    for (;;)
    {
      return new int[] { paramInt1, paramInt2 };
      paramInt1 = (int)(paramInt2 * paramFloat1);
    }
  }
  
  private static int[] f(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramFloat1 > paramFloat2) {
      paramInt2 = (int)(paramInt1 / paramFloat1);
    }
    for (;;)
    {
      return new int[] { paramInt1, paramInt2 };
      paramInt1 = (int)(paramInt2 * paramFloat1);
    }
  }
  
  private final String getTagPrefix()
  {
    return this.TFM;
  }
  
  private final void init()
  {
    AppMethodBeat.i(272246);
    if (Build.VERSION.SDK_INT >= 26) {
      getHolder().setFormat(22);
    }
    getHolder().addCallback((SurfaceHolder.Callback)new b(this));
    AppMethodBeat.o(272246);
  }
  
  public final Bitmap getBitmap()
  {
    return null;
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(272353);
    String str = s.X(getTagPrefix(), "_MMSurfaceViewRender");
    AppMethodBeat.o(272353);
    return str;
  }
  
  public final int getScaleType()
  {
    return this.nDl;
  }
  
  public final Surface getSurface()
  {
    return this.surface;
  }
  
  public final b getSurfaceViewSwitchHelper()
  {
    return this.Gpj;
  }
  
  public final int getVideoDegree()
  {
    return this.TFO;
  }
  
  public final void mj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272407);
    if ((this.videoWidth != paramInt1) || (this.videoHeight != paramInt2))
    {
      this.videoWidth = paramInt1;
      this.videoHeight = paramInt2;
      requestLayout();
      AppMethodBeat.o(272407);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    AppMethodBeat.o(272407);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(272422);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.videoWidth == 0) || (this.videoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(272422);
      return;
    }
    int i = SurfaceView.getDefaultSize(1, paramInt1);
    paramInt2 = SurfaceView.getDefaultSize(1, paramInt2);
    float f1 = this.videoWidth * 1.0F / this.videoHeight;
    float f2 = i * 1.0F / paramInt2;
    Object localObject;
    switch (getScaleType())
    {
    case 2: 
    default: 
      localObject = f(f1, f2, i, paramInt2);
    }
    for (;;)
    {
      post(new MMSurfaceViewRender..ExternalSyntheticLambda0(this, (int[])localObject));
      setMeasuredDimension(localObject[0], localObject[1]);
      Log.i(getLogTag(), "handleOnMeasure, type:" + getScaleType() + " video size[" + this.videoWidth + ' ' + this.videoHeight + "] container:[" + i + ", " + paramInt2 + "]  result=" + localObject[0] + ',' + localObject[1]);
      AppMethodBeat.o(272422);
      return;
      localObject = e(f1, f2, i, paramInt2);
      continue;
      localObject = f(f1, f2, i, paramInt2);
      continue;
      if (!this.Gl.isEmpty())
      {
        localObject = this.Gl;
        if (this.TFP == 0.0F)
        {
          paramInt1 = 1;
          label310:
          if (paramInt1 == 0) {
            if (this.TFQ != 0.0F) {
              break label356;
            }
          }
        }
        label356:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if ((paramInt1 == 0) && (!((Rect)localObject).isEmpty())) {
            break label361;
          }
          localObject = e(f1, f2, i, paramInt2);
          break;
          paramInt1 = 0;
          break label310;
        }
        label361:
        Log.i(getLogTag(), "cropVideo, video size[" + this.videoWidth + ' ' + this.videoHeight + "] container:[" + i + ", " + paramInt2 + "]  result=" + getMeasuredWidth() + ',' + getMeasuredHeight());
        localObject = e(f1, f2, i, paramInt2);
      }
      else
      {
        localObject = e(f1, f2, i, paramInt2);
      }
    }
  }
  
  public final void reset() {}
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(272387);
    s.u(paramRect, "cropRect");
    Log.i(getLogTag(), s.X("setCropRect, cropRect:", paramRect));
    this.Gl = paramRect;
    AppMethodBeat.o(272387);
  }
  
  public final void setOpaqueInfo(boolean paramBoolean) {}
  
  public final void setScaleType(int paramInt)
  {
    AppMethodBeat.i(272379);
    Log.i(getLogTag(), s.X("setScaleType type:", Integer.valueOf(paramInt)));
    this.nDl = paramInt;
    AppMethodBeat.o(272379);
  }
  
  public final void setSurfaceListener(a.a parama)
  {
    AppMethodBeat.i(272369);
    s.u(parama, "listener");
    this.TFN = parama;
    AppMethodBeat.o(272369);
  }
  
  public final void setSurfaceViewSwitchHelper(b paramb)
  {
    this.Gpj = paramb;
  }
  
  public final void setTagPrefix(String paramString)
  {
    AppMethodBeat.i(272365);
    s.u(paramString, "tag");
    this.TFM = paramString;
    AppMethodBeat.o(272365);
  }
  
  public final void setVideoDegree(int paramInt)
  {
    AppMethodBeat.i(272318);
    this.TFO = paramInt;
    Log.i(getLogTag(), s.X("setVideoDegree, videoDegree:", Integer.valueOf(this.TFO)));
    AppMethodBeat.o(272318);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewRender$init$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements SurfaceHolder.Callback
  {
    b(MMSurfaceViewRender paramMMSurfaceViewRender) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(272220);
      s.u(paramSurfaceHolder, "holder");
      Log.i(this.TFR.getLogTag(), "surfaceChanged format:" + paramInt1 + " [" + paramInt2 + ' ' + paramInt3 + "] listener:" + MMSurfaceViewRender.a(this.TFR));
      a.a locala = MMSurfaceViewRender.a(this.TFR);
      if (locala != null) {
        locala.h(paramSurfaceHolder, paramInt2, paramInt3);
      }
      AppMethodBeat.o(272220);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(272234);
      s.u(paramSurfaceHolder, "holder");
      Log.i(this.TFR.getLogTag(), s.X("surfaceCreated listener:", MMSurfaceViewRender.a(this.TFR)));
      MMSurfaceViewRender.a(this.TFR, paramSurfaceHolder.getSurface());
      a.a locala = MMSurfaceViewRender.a(this.TFR);
      if (locala != null) {
        locala.fE(paramSurfaceHolder);
      }
      AppMethodBeat.o(272234);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(272227);
      s.u(paramSurfaceHolder, "holder");
      Log.i(this.TFR.getLogTag(), s.X("surfaceDestroy listener:", MMSurfaceViewRender.a(this.TFR)));
      a.a locala = MMSurfaceViewRender.a(this.TFR);
      if (locala != null) {
        locala.fG(paramSurfaceHolder);
      }
      AppMethodBeat.o(272227);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.render.MMSurfaceViewRender
 * JD-Core Version:    0.7.0.1
 */