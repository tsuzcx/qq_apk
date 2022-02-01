package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "callback", "com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1;", "eventListener", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "invokedDestroy", "", "isFullScreen", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "addRenderEventListener", "", "listener", "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "invokeViewDestroy", "release", "removeRenderEventListener", "resetViewSize", "screenSize", "Landroid/graphics/Point;", "setOpenGlViewSize", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public class VoIPRenderSurfaceView
  extends SurfaceView
{
  private boolean Flq;
  public final String TAG;
  public a UTP;
  public j.b UTQ;
  public int UTR;
  private boolean UTS;
  
  public VoIPRenderSurfaceView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(292994);
    AppMethodBeat.o(292994);
  }
  
  public VoIPRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(293000);
    this.TAG = s.X("MicroMsg.VoIPRenderSurfaceView@", Integer.valueOf(hashCode()));
    this.UTP = new a(this);
    AppMethodBeat.o(293000);
  }
  
  private final void idz()
  {
    AppMethodBeat.i(293008);
    if (!this.UTS)
    {
      j.b localb = this.UTQ;
      if (localb != null) {
        localb.ary(this.UTR);
      }
      this.UTS = true;
    }
    AppMethodBeat.o(293008);
  }
  
  public final void idy()
  {
    AppMethodBeat.i(293055);
    Log.i(this.TAG, "removeRenderEventListener invoke surfaceDestroyed, eventListener:" + this.UTQ + ", invokedDestroy:" + this.UTS);
    idz();
    this.UTQ = null;
    getHolder().removeCallback((SurfaceHolder.Callback)this.UTP);
    AppMethodBeat.o(293055);
  }
  
  public void mI(int paramInt1, int paramInt2) {}
  
  public void mJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293048);
    RelativeLayout.LayoutParams localLayoutParams;
    if (aw.jkQ())
    {
      localLayoutParams = new RelativeLayout.LayoutParams(paramInt2 * 9 / 16, paramInt2);
      localLayoutParams.addRule(13);
    }
    for (;;)
    {
      setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      requestLayout();
      AppMethodBeat.o(293048);
      return;
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(293063);
    j.b localb = this.UTQ;
    if (localb != null) {
      localb.ary(this.UTR);
    }
    idy();
    AppMethodBeat.o(293063);
  }
  
  public final void setFullScreen(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements SurfaceHolder.Callback
  {
    a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(293206);
      s.u(paramSurfaceHolder, "holder");
      paramSurfaceHolder = VoIPRenderSurfaceView.b(this.UTT);
      if (paramSurfaceHolder != null) {
        paramSurfaceHolder.bm(paramInt2, paramInt3, VoIPRenderSurfaceView.c(this.UTT));
      }
      AppMethodBeat.o(293206);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(293215);
      s.u(paramSurfaceHolder, "holder");
      VoIPRenderSurfaceView.g(this.UTT);
      String str = VoIPRenderSurfaceView.d(this.UTT);
      StringBuilder localStringBuilder = new StringBuilder("surfaceCreated holder:").append(paramSurfaceHolder).append(", valid:");
      Object localObject = paramSurfaceHolder.getSurface();
      if (localObject == null) {}
      for (localObject = null;; localObject = Boolean.valueOf(((Surface)localObject).isValid()))
      {
        Log.i(str, localObject + ", eventListener:" + VoIPRenderSurfaceView.b(this.UTT) + ", invokedDestroy:" + VoIPRenderSurfaceView.e(this.UTT));
        if (paramSurfaceHolder.getSurface().isValid())
        {
          localObject = VoIPRenderSurfaceView.b(this.UTT);
          if (localObject != null) {
            ((j.b)localObject).a(VoIPRenderSurfaceView.c(this.UTT), paramSurfaceHolder.getSurface(), null);
          }
        }
        AppMethodBeat.o(293215);
        return;
      }
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(293210);
      s.u(paramSurfaceHolder, "holder");
      Log.i(VoIPRenderSurfaceView.d(this.UTT), s.X("surfaceDestroyed invokedDestroy:", Boolean.valueOf(VoIPRenderSurfaceView.e(this.UTT))));
      VoIPRenderSurfaceView.f(this.UTT);
      AppMethodBeat.o(293210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView
 * JD-Core Version:    0.7.0.1
 */