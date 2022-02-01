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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.voip.b.g;
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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationView", "Landroid/widget/ImageView;", "contentView", "context", "Landroid/content/Context;", "detailShadow", "detailTv", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "fullIconLayout", "fullLayout", "fullTextTv", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentRenderVideo", "getMCurrentRenderVideo", "()Z", "setMCurrentRenderVideo", "(Z)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mLastVideoData", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRootView", "()Landroid/view/View;", "setRootView", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "changeRenderAnimation", "userName", "bitmap", "angle", "mirror", "changeRenderUser", "", "name", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "getRenderSurface", "hideOther", "hideView", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "release", "setVoicePlayDevice", "device", "Companion", "plugin-multitalk_release"})
public final class i
{
  public static final i.a FyQ;
  TextView FyA;
  private VoIPRenderTextureView FyB;
  ImageView FyC;
  private View FyD;
  View FyE;
  ImageView FyF;
  TextView FyG;
  boolean FyH;
  String FyI;
  String FyJ;
  Long FyK;
  private Bitmap FyL;
  private int FyM;
  private int FyN;
  private long FyO;
  private boolean FyP;
  View contentView;
  Context context;
  View oFW;
  private final float radius;
  private Paint tUe;
  
  static
  {
    AppMethodBeat.i(196164);
    FyQ = new i.a((byte)0);
    AppMethodBeat.o(196164);
  }
  
  public i(View paramView)
  {
    AppMethodBeat.i(196162);
    this.oFW = paramView;
    this.radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.oFW.findViewById(a.e.multitalk_content_view);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.FyA = ((TextView)this.oFW.findViewById(a.e.multitalk_username_tv));
    this.FyD = this.oFW.findViewById(a.e.avatar_username_iv);
    this.context = this.oFW.getContext();
    this.FyB = ((VoIPRenderTextureView)this.oFW.findViewById(a.e.multitalk_small_video_view_content));
    paramView = this.FyB;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.FyB;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.FyC = ((ImageView)this.oFW.findViewById(a.e.multitalk_small_video_view_animation));
    paramView = this.FyC;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.FyC;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.tUe = new Paint();
    paramView = this.tUe;
    if (paramView != null) {
      paramView.setColor(-16777216);
    }
    paramView = this.tUe;
    if (paramView != null) {
      paramView.setFilterBitmap(false);
    }
    paramView = this.tUe;
    if (paramView != null) {
      paramView.setTextSize(40.0F);
    }
    this.FyE = this.oFW.findViewById(a.e.voip_mini_windows_layout);
    paramView = this.FyE;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.FyE;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new e(this.radius));
    }
    this.FyF = ((ImageView)this.oFW.findViewById(a.e.multitalk_mini_full_icon));
    this.FyG = ((TextView)this.oFW.findViewById(a.e.multitalk_mini_full_tv));
    this.FyO = -1L;
    AppMethodBeat.o(196162);
  }
  
  private final void aQI(final String paramString)
  {
    AppMethodBeat.i(196123);
    com.tencent.e.h.ZvG.bc((Runnable)new c(this, paramString));
    AppMethodBeat.o(196123);
  }
  
  private final boolean c(final String paramString, final Bitmap paramBitmap, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(196136);
    if (((kotlin.g.b.p.h(this.FyJ, paramString) ^ true)) && (this.FyL != null) && (this.FyB != null))
    {
      com.tencent.e.h.ZvG.bc((Runnable)new b(this, paramBitmap, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(196136);
      return true;
    }
    AppMethodBeat.o(196136);
    return false;
  }
  
  public final void XH(int paramInt)
  {
    AppMethodBeat.i(196142);
    View localView = this.FyD;
    if (localView != null)
    {
      localView.setVisibility(paramInt);
      AppMethodBeat.o(196142);
      return;
    }
    AppMethodBeat.o(196142);
  }
  
  public final void aQG(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(196121);
    if (paramString == null)
    {
      this.FyL = null;
      this.FyN = -1;
      this.FyM = -1;
    }
    for (;;)
    {
      this.FyK = localLong;
      this.FyI = paramString;
      AppMethodBeat.o(196121);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void aQH(String paramString)
  {
    AppMethodBeat.i(196122);
    aQG(paramString);
    this.FyJ = paramString;
    AppMethodBeat.o(196122);
  }
  
  public final boolean aQJ(String paramString)
  {
    int j = 0;
    boolean bool = false;
    try
    {
      AppMethodBeat.i(196140);
      kotlin.g.b.p.k(paramString, "userName");
      if (this.FyB == null)
      {
        Log.e("MicroMsg.MultiTalkMiniVideoView", "drawAvatar view is null");
        AppMethodBeat.o(196140);
      }
      for (;;)
      {
        return bool;
        if (!this.FyP) {
          break;
        }
        Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
        AppMethodBeat.o(196140);
      }
      localObject1 = a.b.hjf();
    }
    finally {}
    Object localObject1;
    Object localObject2 = this.FyB;
    if (localObject2 != null) {}
    for (int i = ((VoIPRenderTextureView)localObject2).getMeasuredWidth();; i = 0)
    {
      localObject2 = this.FyB;
      if (localObject2 != null) {
        j = ((VoIPRenderTextureView)localObject2).getMeasuredHeight();
      }
      localObject2 = ((j.a)localObject1).b(paramString, i, j, 1);
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
          aQI(paramString);
          this.FyH = false;
        }
        AppMethodBeat.o(196140);
        bool = true;
        break;
      }
      localObject2 = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
      localObject2 = com.tencent.mm.compatible.f.a.decodeResource(((Context)localObject2).getResources(), a.g.default_avatar);
      if (!c(paramString, (Bitmap)localObject1, 0, 0))
      {
        f((Bitmap)localObject2, 0, 0);
        aQI(paramString);
        this.FyH = false;
      }
      AppMethodBeat.o(196140);
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
        AppMethodBeat.i(196135);
        kotlin.g.b.p.k(paramString, "userName");
        if (this.FyB == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "drawVideo view is null");
          AppMethodBeat.o(196135);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img is null");
          AppMethodBeat.o(196135);
          continue;
        }
        if (!this.FyP) {
          break label97;
        }
      }
      finally {}
      Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(196135);
      continue;
      label97:
      if (!c(paramString, paramBitmap, paramInt2, paramInt1))
      {
        f(paramBitmap, paramInt2, paramInt1);
        this.FyO = Util.currentTicks();
        aQI(paramString);
        this.FyH = true;
        AppMethodBeat.o(196135);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(196135);
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
        AppMethodBeat.i(196131);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "DrawBitmap, bitmap is null or recycled");
          com.tencent.mm.plugin.multitalk.model.p.eWM();
          AppMethodBeat.o(196131);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.FyB == null)
        {
          AppMethodBeat.o(196131);
          continue;
        }
        localObject = this.FyB;
      }
      finally {}
      Object localObject;
      if (localObject != null) {
        localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
      }
      if (localCanvas == null)
      {
        Log.e("MicroMsg.MultiTalkMiniVideoView", "getCanvasError");
        AppMethodBeat.o(196131);
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
          localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.tUe);
          this.FyM = paramInt1;
          this.FyN = paramInt2;
          this.FyL = paramBitmap;
          try
          {
            paramBitmap = this.FyB;
            if (paramBitmap == null) {
              break label344;
            }
            paramBitmap.unlockCanvasAndPost(localCanvas);
            AppMethodBeat.o(196131);
          }
          catch (Exception paramBitmap)
          {
            Log.printErrStackTrace("MicroMsg.MultiTalkMiniVideoView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
            AppMethodBeat.o(196131);
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
          AppMethodBeat.o(196131);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(i parami, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(206791);
      Object localObject = i.d(this.FyR);
      if (localObject != null) {
        ((ImageView)localObject).setAlpha(1.0F);
      }
      i.e(this.FyR);
      localObject = i.d(this.FyR);
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = i.d(this.FyR);
      if (localObject != null) {
        ((ImageView)localObject).clearAnimation();
      }
      localObject = i.d(this.FyR);
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
                  AppMethodBeat.i(203111);
                  paramAnonymousAnimator = i.d(this.FyU.FyR);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  paramAnonymousAnimator = i.b(this.FyU.FyR);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(0);
                  }
                  i.a(this.FyU.FyR, false);
                  AppMethodBeat.o(203111);
                }
                
                public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
                
                public final void onAnimationStart(Animator paramAnonymousAnimator)
                {
                  AppMethodBeat.i(203117);
                  this.FyU.FyR.f(this.FyU.cLr, this.FyU.FyS, this.FyU.FyT);
                  paramAnonymousAnimator = i.b(this.FyU.FyR);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setVisibility(8);
                  }
                  paramAnonymousAnimator = i.b(this.FyU.FyR);
                  if (paramAnonymousAnimator != null) {
                    paramAnonymousAnimator.setTextSize(1, 10.0F);
                  }
                  paramAnonymousAnimator = i.b(this.FyU.FyR);
                  if (paramAnonymousAnimator != null)
                  {
                    localObject1 = com.tencent.mm.kernel.h.ae(n.class);
                    kotlin.g.b.p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject1 = ((n)localObject1).bbL().RG(this.FyU.mtC);
                    kotlin.g.b.p.j(localObject1, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    paramAnonymousAnimator.setText((CharSequence)((as)localObject1).getNickname());
                  }
                  Object localObject1 = this.FyU.FyR.oFW;
                  Object localObject2 = new StringBuilder();
                  paramAnonymousAnimator = i.c(this.FyU.FyR);
                  if (paramAnonymousAnimator != null) {}
                  for (paramAnonymousAnimator = paramAnonymousAnimator.getString(b.g.chatting_voip_voice);; paramAnonymousAnimator = null)
                  {
                    paramAnonymousAnimator = ((StringBuilder)localObject2).append(String.valueOf(paramAnonymousAnimator)).append(",");
                    localObject2 = com.tencent.mm.kernel.h.ae(n.class);
                    kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
                    localObject2 = ((n)localObject2).bbL().RG(this.FyU.mtC);
                    kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessen…ava).contactStg[userName]");
                    ((View)localObject1).setContentDescription((CharSequence)((as)localObject2).getNickname());
                    this.FyU.FyR.aQH(this.FyU.mtC);
                    i.a(this.FyU.FyR, true);
                    AppMethodBeat.o(203117);
                    return;
                  }
                }
              });
              AppMethodBeat.o(206791);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(206791);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(i parami, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(201970);
      Object localObject1 = i.a(this.FyR);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = i.b(this.FyR);
      if (localObject1 != null) {
        ((TextView)localObject1).setTextSize(1, 10.0F);
      }
      localObject1 = i.b(this.FyR);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.kernel.h.ae(n.class);
        kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
        localObject2 = ((n)localObject2).bbL().RG(paramString);
        kotlin.g.b.p.j(localObject2, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        ((TextView)localObject1).setText((CharSequence)((as)localObject2).getNickname());
      }
      Object localObject2 = this.FyR.oFW;
      Object localObject3 = new StringBuilder();
      localObject1 = i.c(this.FyR);
      if (localObject1 != null) {}
      for (localObject1 = ((Context)localObject1).getString(b.g.chatting_voip_voice);; localObject1 = null)
      {
        localObject1 = ((StringBuilder)localObject3).append(String.valueOf(localObject1)).append(",");
        localObject3 = com.tencent.mm.kernel.h.ae(n.class);
        kotlin.g.b.p.j(localObject3, "MMKernel.service(IMessengerStorage::class.java)");
        localObject3 = ((n)localObject3).bbL().RG(paramString);
        kotlin.g.b.p.j(localObject3, "MMKernel.service(IMessen…ss.java).contactStg[name]");
        ((View)localObject2).setContentDescription((CharSequence)((as)localObject3).getNickname());
        if ((kotlin.g.b.p.h(this.FyR.FyJ, paramString) ^ true))
        {
          this.FyR.aQH(paramString);
          this.FyR.FyK = Long.valueOf(Util.currentTicks());
        }
        AppMethodBeat.o(201970);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */