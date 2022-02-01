package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationView", "Landroid/widget/ImageView;", "contentView", "context", "Landroid/content/Context;", "detailShadow", "detailTv", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "fullIconLayout", "fullLayout", "fullTextTv", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentRenderVideo", "getMCurrentRenderVideo", "()Z", "setMCurrentRenderVideo", "(Z)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mLastVideoData", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRootView", "()Landroid/view/View;", "setRootView", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "changeRenderAnimation", "userName", "bitmap", "angle", "mirror", "changeRenderUser", "", "name", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "getRenderSurface", "hideOther", "hideView", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "release", "setVoicePlayDevice", "device", "Companion", "plugin-multitalk_release"})
public final class i
{
  public static final i.a zTo;
  View contentView;
  Context context;
  View lJI;
  private Paint qvj;
  private final float radius;
  TextView zSY;
  private VoIPRenderTextureView zSZ;
  ImageView zTa;
  private View zTb;
  View zTc;
  ImageView zTd;
  TextView zTe;
  boolean zTf;
  String zTg;
  String zTh;
  Long zTi;
  private Bitmap zTj;
  private int zTk;
  private int zTl;
  private long zTm;
  private boolean zTn;
  
  static
  {
    AppMethodBeat.i(239800);
    zTo = new i.a((byte)0);
    AppMethodBeat.o(239800);
  }
  
  public i(View paramView)
  {
    AppMethodBeat.i(239799);
    this.lJI = paramView;
    this.radius = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.lJI.findViewById(2131305030);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.zSY = ((TextView)this.lJI.findViewById(2131305067));
    this.zTb = this.lJI.findViewById(2131297145);
    this.context = this.lJI.getContext();
    this.zSZ = ((VoIPRenderTextureView)this.lJI.findViewById(2131305060));
    paramView = this.zSZ;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.zSZ;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.zTa = ((ImageView)this.lJI.findViewById(2131305059));
    paramView = this.zTa;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.zTa;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.qvj = new Paint();
    paramView = this.qvj;
    if (paramView != null) {
      paramView.setColor(-16777216);
    }
    paramView = this.qvj;
    if (paramView != null) {
      paramView.setFilterBitmap(false);
    }
    paramView = this.qvj;
    if (paramView != null) {
      paramView.setTextSize(40.0F);
    }
    this.zTc = this.lJI.findViewById(2131310040);
    paramView = this.zTc;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.zTc;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.zTd = ((ImageView)this.lJI.findViewById(2131305040));
    this.zTe = ((TextView)this.lJI.findViewById(2131305041));
    this.zTm = -1L;
    AppMethodBeat.o(239799);
  }
  
  private final void aGu(final String paramString)
  {
    AppMethodBeat.i(239793);
    h.RTc.aV((Runnable)new c(this, paramString));
    AppMethodBeat.o(239793);
  }
  
  private final boolean c(final String paramString, final Bitmap paramBitmap, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(239796);
    if (((kotlin.g.b.p.j(this.zTh, paramString) ^ true)) && (this.zTj != null) && (this.zSZ != null))
    {
      h.RTc.aV((Runnable)new b(this, paramBitmap, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(239796);
      return true;
    }
    AppMethodBeat.o(239796);
    return false;
  }
  
  public final void H(int paramInt)
  {
    AppMethodBeat.i(239798);
    View localView = this.zTb;
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      AppMethodBeat.o(239798);
      return;
    }
    AppMethodBeat.o(239798);
  }
  
  public final void aGs(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(239791);
    if (paramString == null)
    {
      this.zTj = null;
      this.zTl = -1;
      this.zTk = -1;
    }
    for (;;)
    {
      this.zTi = localLong;
      this.zTg = paramString;
      AppMethodBeat.o(239791);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void aGt(String paramString)
  {
    AppMethodBeat.i(239792);
    aGs(paramString);
    this.zTh = paramString;
    AppMethodBeat.o(239792);
  }
  
  public final boolean aGv(String paramString)
  {
    int j = 0;
    boolean bool = false;
    try
    {
      AppMethodBeat.i(239797);
      kotlin.g.b.p.h(paramString, "userName");
      if (this.zSZ == null)
      {
        Log.e("MicroMsg.MultiTalkMiniVideoView", "drawAvatar view is null");
        AppMethodBeat.o(239797);
      }
      for (;;)
      {
        return bool;
        if (!this.zTn) {
          break;
        }
        Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
        AppMethodBeat.o(239797);
      }
      localObject1 = a.b.gov();
    }
    finally {}
    Object localObject1;
    Object localObject2 = this.zSZ;
    if (localObject2 != null) {}
    for (int i = ((VoIPRenderTextureView)localObject2).getMeasuredWidth();; i = 0)
    {
      localObject2 = this.zSZ;
      if (localObject2 != null) {
        j = ((VoIPRenderTextureView)localObject2).getMeasuredHeight();
      }
      localObject2 = ((j.a)localObject1).a(paramString, i, j, 1);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() < ((Bitmap)localObject2).getWidth()) {
          localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getHeight());
        }
      }
      if (localObject1 != null)
      {
        if (!c(paramString, (Bitmap)localObject1, 0, 0))
        {
          f((Bitmap)localObject1, 0, 0);
          aGu(paramString);
          this.zTf = false;
        }
        AppMethodBeat.o(239797);
        bool = true;
        break;
      }
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.g(localObject2, "MMApplicationContext.getContext()");
      localObject2 = com.tencent.mm.compatible.f.a.decodeResource(((Context)localObject2).getResources(), 2131690042);
      if (!c(paramString, (Bitmap)localObject1, 0, 0))
      {
        f((Bitmap)localObject2, 0, 0);
        aGu(paramString);
        this.zTf = false;
      }
      AppMethodBeat.o(239797);
      bool = true;
      break;
    }
  }
  
  public final boolean b(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(239795);
        kotlin.g.b.p.h(paramString, "userName");
        if (this.zSZ == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "drawVideo view is null");
          AppMethodBeat.o(239795);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img is null");
          AppMethodBeat.o(239795);
          continue;
        }
        if (!this.zTn) {
          break label97;
        }
      }
      finally {}
      Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(239795);
      continue;
      label97:
      if (!c(paramString, paramBitmap, paramInt2, paramInt1))
      {
        f(paramBitmap, paramInt2, paramInt1);
        this.zTm = Util.currentTicks();
        aGu(paramString);
        this.zTf = true;
        AppMethodBeat.o(239795);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(239795);
        bool = true;
      }
    }
  }
  
  public final void f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Canvas localCanvas = null;
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(239794);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "DrawBitmap, bitmap is null or recycled");
          com.tencent.mm.plugin.multitalk.model.p.emX();
          AppMethodBeat.o(239794);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.zSZ == null)
        {
          AppMethodBeat.o(239794);
          continue;
        }
        localObject = this.zSZ;
      }
      finally {}
      Object localObject;
      if (localObject != null) {
        localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
      }
      if (localCanvas == null)
      {
        Log.e("MicroMsg.MultiTalkMiniVideoView", "getCanvasError");
        AppMethodBeat.o(239794);
      }
      else
      {
        localObject = new Matrix();
        if (paramInt1 == OpenGlRender.FLAG_Angle270)
        {
          ((Matrix)localObject).setRotate(270.0F, i / 2.0F, j / 2.0F);
          label152:
          if (paramInt2 == OpenGlRender.FLAG_Mirror)
          {
            ((Matrix)localObject).postScale(-1.0F, 1.0F);
            ((Matrix)localObject).postTranslate(i, 0.0F);
          }
          ((Matrix)localObject).postScale(localCanvas.getWidth() / j, localCanvas.getHeight() / i);
          localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
          boolean bool = paramBitmap.isRecycled();
          if (bool) {}
        }
        try
        {
          localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.qvj);
          this.zTk = paramInt1;
          this.zTl = paramInt2;
          this.zTj = paramBitmap;
          try
          {
            paramBitmap = this.zSZ;
            if (paramBitmap == null) {
              break label344;
            }
            paramBitmap.unlockCanvasAndPost(localCanvas);
            AppMethodBeat.o(239794);
          }
          catch (Exception paramBitmap)
          {
            Log.printErrStackTrace("MicroMsg.MultiTalkMiniVideoView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(239794);
          }
          continue;
          if (paramInt1 != OpenGlRender.FLAG_Angle90) {
            break label152;
          }
          ((Matrix)localObject).setRotate(90.0F, i / 2.0F, j / 2.0F);
        }
        catch (Exception paramBitmap)
        {
          for (;;)
          {
            Log.e("MicroMsg.MultiTalkMiniVideoView", "draw bitmap error");
          }
          label344:
          AppMethodBeat.o(239794);
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(239789);
      Object localObject = i.d(this.zTp);
      if (localObject != null) {
        ((ImageView)localObject).setAlpha(1.0F);
      }
      i.e(this.zTp);
      localObject = i.d(this.zTp);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = i.d(this.zTp);
      if (localObject != null) {
        ((ImageView)localObject).clearAnimation();
      }
      localObject = i.d(this.zTp);
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
            if (localObject != null)
            {
              ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
              {
                public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationEnd(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(239787);
                  paramAnonymousAnimator = i.d(this.zTs.zTp);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  paramAnonymousAnimator = i.b(this.zTs.zTp);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(0);
                  }
                  i.a(this.zTs.zTp, false);
                  AppMethodBeat.o(239787);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(239788);
                  this.zTs.zTp.f(this.zTs.cKG, this.zTs.zTq, this.zTs.zTr);
                  paramAnonymousAnimator = i.b(this.zTs.zTp);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  paramAnonymousAnimator = i.b(this.zTs.zTp);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setTextSize(1, 10.0F);
                  }
                  paramAnonymousAnimator = i.b(this.zTs.zTp);
                  if (paramAnonymousAnimator != null)
                  {
                    localObject1 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    kotlin.g.b.p.g(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject1).aSN().Kn(this.zTs.jDi);
                    kotlin.g.b.p.g(localObject1, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    paramAnonymousAnimator.setText((CharSequence)((as)localObject1).getNickname());
                  }
                  Object localObject1 = this.zTs.zTp.lJI;
                  Object localObject2 = new StringBuilder();
                  paramAnonymousAnimator = i.c(this.zTs.zTp);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(2131757549);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject2).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).aSN().Kn(this.zTs.jDi);
                    kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    ((View)localObject1).setContentDescription((CharSequence)((as)localObject2).getNickname());
                    this.zTs.zTp.aGt(this.zTs.jDi);
                    i.a(this.zTs.zTp, true);
                    AppMethodBeat.o(239788);
                    return;
                  }
                }
              });
              AppMethodBeat.o(239789);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(239789);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(i parami, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(239790);
      Object localObject1 = i.a(this.zTp);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = i.b(this.zTp);
      if (localObject1 != null) {
        ((TextView)localObject1).setTextSize(1, 10.0F);
      }
      localObject1 = i.b(this.zTp);
      if (localObject1 != null)
      {
        localObject2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
        localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).aSN().Kn(paramString);
        kotlin.g.b.p.g(localObject2, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        ((TextView)localObject1).setText((CharSequence)((as)localObject2).getNickname());
      }
      Object localObject2 = this.zTp.lJI;
      Object localObject3 = new StringBuilder();
      localObject1 = i.c(this.zTp);
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(2131757549);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(String.valueOf(localObject1)).append(",");
        localObject3 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
        localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject3).aSN().Kn(paramString);
        kotlin.g.b.p.g(localObject3, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        ((View)localObject2).setContentDescription((CharSequence)((as)localObject3).getNickname());
        if ((kotlin.g.b.p.j(this.zTp.zTh, paramString) ^ true))
        {
          this.zTp.aGt(paramString);
          this.zTp.zTi = Long.valueOf(Util.currentTicks());
        }
        AppMethodBeat.o(239790);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */