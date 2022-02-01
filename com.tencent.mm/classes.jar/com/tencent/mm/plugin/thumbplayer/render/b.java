package com.tencent.mm.plugin.thumbplayer.render;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/render/MMSurfaceViewSwitchHelper;", "", "container", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "captureBitmap", "Landroid/graphics/Bitmap;", "getContainer", "()Landroid/widget/FrameLayout;", "coverView", "Landroid/widget/ImageView;", "defaultBitmap", "isValid", "", "logTag", "", "attach", "", "captureFrame", "surfaceView", "Landroid/view/SurfaceView;", "surface", "Landroid/view/Surface;", "detach", "dismissCoverBitmap", "dismissCoverBitmapInternal", "getLogTag", "onSurfaceViewSizeChange", "width", "", "height", "showCoverBitmap", "showCoverBitmapInternal", "bitmap", "invokeSource", "Companion", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a TFS;
  private final ImageView NTz;
  public Bitmap TFT;
  private boolean clZ;
  public final FrameLayout container;
  public Bitmap hfN;
  private String logTag;
  
  static
  {
    AppMethodBeat.i(272248);
    TFS = new b.a((byte)0);
    AppMethodBeat.o(272248);
  }
  
  public b(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(272209);
    this.container = paramFrameLayout;
    this.logTag = "MMSurfaceViewSwitchHelper";
    paramFrameLayout = new ImageView(this.container.getContext());
    paramFrameLayout.setTag("MMSurfaceViewSwitchHelper.COVER_VIEW");
    ah localah = ah.aiuX;
    this.NTz = paramFrameLayout;
    AppMethodBeat.o(272209);
  }
  
  private static final void a(b paramb, ah.f paramf, int paramInt)
  {
    AppMethodBeat.i(272226);
    s.u(paramb, "this$0");
    s.u(paramf, "$bitmap");
    Log.i(paramb.getLogTag(), "captureFrame end result:" + paramInt + " isValid:" + paramb.clZ + '.');
    if ((paramInt == 0) && (paramb.clZ)) {
      paramb.TFT = ((Bitmap)paramf.aqH);
    }
    AppMethodBeat.o(272226);
  }
  
  private final void hLr()
  {
    AppMethodBeat.i(272218);
    d.uiThread((a)new b(this));
    AppMethodBeat.o(272218);
  }
  
  public final void a(final SurfaceView paramSurfaceView, final Bitmap paramBitmap, final String paramString)
  {
    AppMethodBeat.i(272293);
    if (paramBitmap == null)
    {
      Log.w(getLogTag(), "showCoverBitmapInternal " + paramString + " return for null.");
      AppMethodBeat.o(272293);
      return;
    }
    d.uiThread((a)new c(this, paramString, paramBitmap, paramSurfaceView));
    AppMethodBeat.o(272293);
  }
  
  public final void a(SurfaceView paramSurfaceView, Surface paramSurface, Bitmap paramBitmap)
  {
    AppMethodBeat.i(272266);
    s.u(paramSurfaceView, "surfaceView");
    this.hfN = paramBitmap;
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i(getLogTag(), "captureFrame return for version:" + Build.VERSION.SDK_INT + '.');
      AppMethodBeat.o(272266);
      return;
    }
    if ((paramSurface != null) && (!paramSurface.isValid())) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(getLogTag(), "captureFrame return for surface:" + paramSurface + " isValid:" + paramSurface.isValid() + '.');
      AppMethodBeat.o(272266);
      return;
    }
    Log.i(getLogTag(), "captureFrame begin.");
    try
    {
      paramSurface = new ah.f();
      paramSurface.aqH = Bitmap.createBitmap(paramSurfaceView.getWidth(), paramSurfaceView.getHeight(), Bitmap.Config.ARGB_8888);
      PixelCopy.request(paramSurfaceView, (Bitmap)paramSurface.aqH, new b..ExternalSyntheticLambda0(this, paramSurface), new Handler(Looper.getMainLooper()));
      AppMethodBeat.o(272266);
      return;
    }
    finally
    {
      Log.w("MMSurfaceViewSwitchHelper", s.X("captureFrame e:", paramSurfaceView));
      AppMethodBeat.o(272266);
    }
  }
  
  public final void apR(String paramString)
  {
    AppMethodBeat.i(369752);
    s.u(paramString, "logTag");
    this.clZ = true;
    this.logTag = s.X(paramString, ".MMSurfaceViewSwitchHelper");
    AppMethodBeat.o(369752);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(272285);
    Log.i(getLogTag(), "detach captureBitmap:" + this.TFT + " defaultBitmap:" + this.hfN);
    this.clZ = false;
    this.hfN = null;
    hLq();
    AppMethodBeat.o(272285);
  }
  
  public final String getLogTag()
  {
    AppMethodBeat.i(272298);
    String str = this.logTag + '.' + this.clZ;
    AppMethodBeat.o(272298);
    return str;
  }
  
  public final void hLq()
  {
    AppMethodBeat.i(272276);
    if (this.container.findViewWithTag("MMSurfaceViewSwitchHelper.COVER_VIEW") == null) {}
    for (ah localah = null;; localah = ah.aiuX)
    {
      if (localah == null) {
        Log.w(getLogTag(), "dismissCoverBitmap ignore captureBitmap:" + this.TFT + '.');
      }
      this.TFT = null;
      AppMethodBeat.o(272276);
      return;
      hLr();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(b paramb, String paramString, Bitmap paramBitmap, SurfaceView paramSurfaceView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.render.b
 * JD-Core Version:    0.7.0.1
 */