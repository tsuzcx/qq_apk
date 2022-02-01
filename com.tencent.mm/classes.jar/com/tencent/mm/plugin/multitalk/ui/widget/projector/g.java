package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout;", "", "rootView", "Landroid/widget/RelativeLayout;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "avatarView", "Landroid/widget/ImageView;", "getAvatarView", "()Landroid/widget/ImageView;", "setAvatarView", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "drawPaint", "Landroid/graphics/Paint;", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "mContentView", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mPrevBitmap", "Landroid/graphics/Bitmap;", "getMPrevBitmap", "()Landroid/graphics/Bitmap;", "setMPrevBitmap", "(Landroid/graphics/Bitmap;)V", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "mPrevTarget", "getMPrevTarget", "()I", "setMPrevTarget", "(I)V", "mVoiceIv", "mVoiceRoot", "Landroid/view/View;", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;)V", "getRootView", "()Landroid/widget/RelativeLayout;", "setRootView", "(Landroid/widget/RelativeLayout;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "applyOrientation", "", "orientation", "changeRenderToAvatarAnimation", "userName", "changeRenderToVideoAnimation", "bitmap", "angle", "mirror", "target", "changeRenderUser", "name", "doAnimationHide", "doAnimationShow", "doShowOrHideSpeakerVoice", "show", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "resetLayoutCauseDoodle", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a LxY;
  RelativeLayout Ikt;
  private a Lsq;
  VoIPRenderTextureView LuO;
  String LuU;
  private String LuV;
  Long LuW;
  private Bitmap LuX;
  private int LuY;
  private int LuZ;
  private boolean Lvb;
  int LxZ;
  private ImageView Lya;
  private View Lyb;
  private RelativeLayout Lyc;
  private Context context;
  ImageView pKM;
  private final float radius;
  private Paint wXu;
  
  static
  {
    AppMethodBeat.i(285796);
    LxY = new g.a((byte)0);
    AppMethodBeat.o(285796);
  }
  
  public g(RelativeLayout paramRelativeLayout, a parama)
  {
    AppMethodBeat.i(285694);
    this.Ikt = paramRelativeLayout;
    this.Lsq = parama;
    this.radius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    this.context = this.Ikt.getContext();
    paramRelativeLayout = LayoutInflater.from(this.context).inflate(a.f.multitalk_screen_project_avatart, (ViewGroup)this.Ikt);
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(285694);
      throw paramRelativeLayout;
    }
    this.Lyc = ((RelativeLayout)paramRelativeLayout);
    paramRelativeLayout = this.Lyc;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setClipToOutline(true);
    }
    paramRelativeLayout = this.Lyc;
    if (paramRelativeLayout != null) {
      paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    paramRelativeLayout = this.Lyc;
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = null;
      this.LuO = paramRelativeLayout;
      paramRelativeLayout = this.LuO;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setClipToOutline(true);
      }
      paramRelativeLayout = this.LuO;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
      }
      this.wXu = new Paint();
      paramRelativeLayout = this.wXu;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setColor(-16777216);
      }
      paramRelativeLayout = this.wXu;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setFilterBitmap(true);
      }
      paramRelativeLayout = this.wXu;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setTextSize(40.0F);
      }
      paramRelativeLayout = this.Lyc;
      if (paramRelativeLayout != null) {
        break label329;
      }
      paramRelativeLayout = null;
      label272:
      this.pKM = paramRelativeLayout;
      paramRelativeLayout = this.Lyc;
      if (paramRelativeLayout != null) {
        break label343;
      }
      paramRelativeLayout = null;
      label288:
      this.Lya = paramRelativeLayout;
      paramRelativeLayout = this.Lyc;
      if (paramRelativeLayout != null) {
        break label357;
      }
    }
    label329:
    label343:
    label357:
    for (paramRelativeLayout = localObject;; paramRelativeLayout = paramRelativeLayout.findViewById(a.e.voice_icon_root))
    {
      this.Lyb = paramRelativeLayout;
      AppMethodBeat.o(285694);
      return;
      paramRelativeLayout = (VoIPRenderTextureView)paramRelativeLayout.findViewById(a.e.multitalk_small_video_view_content);
      break;
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(a.e.avatar_frame);
      break label272;
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(a.e.voice_icon_iv);
      break label288;
    }
  }
  
  private static final void a(g paramg)
  {
    AppMethodBeat.i(285743);
    s.u(paramg, "this$0");
    VoIPRenderTextureView localVoIPRenderTextureView = paramg.LuO;
    if (localVoIPRenderTextureView != null) {
      localVoIPRenderTextureView.setAlpha(0.0F);
    }
    paramg = paramg.LuO;
    if (paramg != null)
    {
      paramg = paramg.animate();
      if (paramg != null)
      {
        paramg = paramg.alpha(1.0F);
        if (paramg != null)
        {
          paramg = paramg.setDuration(300L);
          if (paramg != null) {
            paramg.start();
          }
        }
      }
    }
    AppMethodBeat.o(285743);
  }
  
  private static final void a(g paramg, Bitmap paramBitmap, int paramInt1, int paramInt2, final String paramString)
  {
    AppMethodBeat.i(285753);
    s.u(paramg, "this$0");
    s.u(paramString, "$userName");
    Object localObject = paramg.pKM;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            paramString = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new c(paramg, paramString));
            if (paramString != null)
            {
              paramString = paramString.withStartAction(new g..ExternalSyntheticLambda0(paramg));
              if (paramString != null) {
                paramString.start();
              }
            }
          }
        }
      }
    }
    paramg.g(paramBitmap, paramInt1, paramInt2);
    AppMethodBeat.o(285753);
  }
  
  private static final void a(g paramg, final String paramString)
  {
    AppMethodBeat.i(285772);
    s.u(paramg, "this$0");
    s.u(paramString, "$userName");
    Object localObject = paramg.LuO;
    if (localObject != null)
    {
      localObject = ((VoIPRenderTextureView)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
          if (localObject != null)
          {
            paramString = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b(paramg, paramString));
            if (paramString != null) {
              paramString.withStartAction(new g..ExternalSyntheticLambda1(paramg));
            }
          }
        }
      }
    }
    AppMethodBeat.o(285772);
  }
  
  private void aNA(String paramString)
  {
    AppMethodBeat.i(285702);
    aNz(paramString);
    this.LuV = paramString;
    AppMethodBeat.o(285702);
  }
  
  private final void aNB(String paramString)
  {
    AppMethodBeat.i(285730);
    com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda4(this, paramString));
    AppMethodBeat.o(285730);
  }
  
  private static final void b(g paramg)
  {
    Object localObject1 = null;
    AppMethodBeat.i(285762);
    s.u(paramg, "this$0");
    Object localObject2 = paramg.pKM;
    if (localObject2 != null) {
      ((ImageView)localObject2).setAlpha(0.0F);
    }
    paramg = paramg.pKM;
    if (paramg == null) {
      paramg = localObject1;
    }
    for (;;)
    {
      if (paramg != null) {
        paramg.setDuration(300L);
      }
      AppMethodBeat.o(285762);
      return;
      localObject2 = paramg.animate();
      paramg = localObject1;
      if (localObject2 != null) {
        paramg = ((ViewPropertyAnimator)localObject2).alpha(1.0F);
      }
    }
  }
  
  private static final void b(g paramg, String paramString)
  {
    AppMethodBeat.i(285784);
    s.u(paramg, "this$0");
    s.u(paramString, "$name");
    RelativeLayout localRelativeLayout = paramg.Ikt;
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramg.context;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getString(a.h.chatting_voip_voice))
    {
      localRelativeLayout.setContentDescription((CharSequence)(localObject + ',' + ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).field_nickname));
      if (!s.p(paramg.LuV, paramString))
      {
        paramg.aNA(paramString);
        paramg.LuW = Long.valueOf(Util.currentTicks());
      }
      AppMethodBeat.o(285784);
      return;
    }
  }
  
  private void g(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Canvas localCanvas = null;
    int i;
    int j;
    try
    {
      AppMethodBeat.i(285718);
      if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      {
        Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "DrawBitmap, bitmap is null or recycled");
        o.gfG();
        AppMethodBeat.o(285718);
      }
      for (;;)
      {
        return;
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.LuO != null) {
          break;
        }
        AppMethodBeat.o(285718);
      }
      localObject = this.LuO;
    }
    finally {}
    if (localObject == null) {}
    for (;;)
    {
      if (localCanvas != null) {
        break label121;
      }
      Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "getCanvasError");
      AppMethodBeat.o(285718);
      break;
      localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
    }
    label121:
    Object localObject = new Matrix();
    switch (this.Lsq.ghU())
    {
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt1 == OpenGlRender.FLAG_Angle270)
        {
          ((Matrix)localObject).setRotate(270.0F, i / 2.0F, j / 2.0F);
          label189:
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
          for (;;)
          {
            localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.wXu);
            this.LuY = paramInt1;
            this.LuZ = paramInt2;
            this.LuX = paramBitmap;
            this.LxZ = 1;
            try
            {
              paramBitmap = this.LuO;
              if (paramBitmap == null) {
                break label433;
              }
              paramBitmap.unlockCanvasAndPost(localCanvas);
              AppMethodBeat.o(285718);
            }
            catch (Exception paramBitmap)
            {
              Log.printErrStackTrace("MicroMsg.ScreenProjectAvatarCellLayout", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
              AppMethodBeat.o(285718);
            }
          }
          if (paramInt1 == OpenGlRender.FLAG_Angle270)
          {
            ((Matrix)localObject).setRotate(-90.0F, i / 2.0F, j / 2.0F);
            break label189;
          }
          if (paramInt1 != OpenGlRender.FLAG_Angle90) {
            break label189;
          }
          ((Matrix)localObject).setRotate(-270.0F, i / 2.0F, j / 2.0F);
          break label189;
          if (paramInt1 != OpenGlRender.FLAG_Angle90) {
            break label189;
          }
          ((Matrix)localObject).setRotate(90.0F, i / 2.0F, j / 2.0F);
        }
        catch (Exception paramBitmap)
        {
          for (;;)
          {
            Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "draw bitmap error");
          }
        }
      }
      label433:
      break;
    }
  }
  
  public final boolean aNC(String paramString)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(285858);
        s.u(paramString, "userName");
        if (this.LuO == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawAvatar view is null");
          AppMethodBeat.o(285858);
          return bool;
        }
        if (this.Lvb)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
          AppMethodBeat.o(285858);
          continue;
        }
        a.b.A(this.pKM, paramString);
      }
      finally {}
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s ", new Object[] { paramString });
      int i = j;
      if (!s.p(this.LuV, paramString))
      {
        i = j;
        if (this.LuO != null)
        {
          i = j;
          if (this.LxZ != 0)
          {
            aNA(paramString);
            this.Lvb = true;
            com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda3(this, paramString));
            this.LxZ = 0;
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.pKM;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.LuO;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(8);
        }
        aNB(paramString);
      }
      AppMethodBeat.o(285858);
      bool = true;
    }
  }
  
  public final void aNz(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(285839);
    if (paramString == null)
    {
      this.LuX = null;
      this.LuZ = -1;
      this.LuY = -1;
    }
    for (;;)
    {
      this.LuW = localLong;
      this.LuU = paramString;
      AppMethodBeat.o(285839);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void aca(int paramInt)
  {
    AppMethodBeat.i(285902);
    Object localObject1;
    if (this.Lsq.ghX() == 0)
    {
      localObject1 = this.Lyc;
      if (localObject1 != null) {
        if (paramInt != 180) {
          switch (paramInt)
          {
          }
        }
      }
    }
    for (;;)
    {
      if (this.LxZ != 1)
      {
        localObject1 = this.LuU;
        if (localObject1 != null) {
          aNC((String)localObject1);
        }
      }
      if (paramInt != 180)
      {
        localObject1 = this.pKM;
        if (localObject1 != null) {
          ((ImageView)localObject1).setRotation(360.0F - paramInt);
        }
        localObject1 = this.Lya;
        if (localObject1 != null) {
          ((ImageView)localObject1).setRotation(360.0F - paramInt);
        }
      }
      AppMethodBeat.o(285902);
      return;
      Object localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(285902);
        throw ((Throwable)localObject1);
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).requestLayout();
      if (this.Lsq.ghX() == 0)
      {
        localObject1 = this.Ikt;
        localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285902);
          throw ((Throwable)localObject1);
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = f.Luh;
        ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout)localObject1).requestLayout();
      }
      localObject1 = this.Lyb;
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285902);
          throw ((Throwable)localObject1);
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
        ((RelativeLayout.LayoutParams)localObject2).setMarginStart(f.LtS / 2);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((View)localObject1).requestLayout();
        continue;
        localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(285902);
          throw ((Throwable)localObject1);
        }
        localObject2 = (RelativeLayout.LayoutParams)localObject2;
        ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
        ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout)localObject1).requestLayout();
        localObject1 = this.Lyb;
        if (localObject1 != null)
        {
          localObject2 = ((View)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(285902);
            throw ((Throwable)localObject1);
          }
          localObject2 = (RelativeLayout.LayoutParams)localObject2;
          ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
          ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.LtS / 2);
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((View)localObject1).requestLayout();
        }
        if (this.Lsq.ghX() == 0)
        {
          localObject1 = this.Ikt;
          localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(285902);
            throw ((Throwable)localObject1);
          }
          localObject2 = (RelativeLayout.LayoutParams)localObject2;
          ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
          ((RelativeLayout.LayoutParams)localObject2).setMarginStart(f.LtY);
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
          ((RelativeLayout.LayoutParams)localObject2).addRule(20, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout)localObject1).requestLayout();
          continue;
          localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
          if (localObject2 == null)
          {
            localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(285902);
            throw ((Throwable)localObject1);
          }
          localObject2 = (RelativeLayout.LayoutParams)localObject2;
          ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
          ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
          ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RelativeLayout)localObject1).requestLayout();
          localObject1 = this.Lyb;
          if (localObject1 != null)
          {
            localObject2 = ((View)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(285902);
              throw ((Throwable)localObject1);
            }
            localObject2 = (RelativeLayout.LayoutParams)localObject2;
            ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
            ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
            ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
            ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.LtS / 2);
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((View)localObject1).requestLayout();
          }
          if (this.Lsq.ghX() == 0)
          {
            localObject1 = this.Ikt;
            localObject2 = ((RelativeLayout)localObject1).getLayoutParams();
            if (localObject2 == null)
            {
              localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(285902);
              throw ((Throwable)localObject1);
            }
            localObject2 = (RelativeLayout.LayoutParams)localObject2;
            ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
            ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
            ((RelativeLayout.LayoutParams)localObject2).addRule(21, -1);
            ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
            ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
            ((RelativeLayout.LayoutParams)localObject2).setMarginEnd(f.LtY);
            ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ((RelativeLayout)localObject1).requestLayout();
          }
        }
      }
    }
  }
  
  public final boolean b(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(285847);
        s.u(paramString, "userName");
        if (this.LuO == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "drawVideo view is null");
          AppMethodBeat.o(285847);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img is null");
          AppMethodBeat.o(285847);
          continue;
        }
        if (!this.Lvb) {
          break label100;
        }
      }
      finally {}
      Log.e("MicroMsg.ScreenProjectAvatarCellLayout", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(285847);
      continue;
      label100:
      Log.i("MicroMsg.ScreenProjectAvatarCellLayout", "changeRenderAnimation %s and target is %s", new Object[] { paramString, Integer.valueOf(1) });
      int i = j;
      if (!s.p(this.LuV, paramString))
      {
        i = j;
        if (this.LuO != null)
        {
          i = j;
          if (this.LxZ != 1)
          {
            aNA(paramString);
            this.Lvb = true;
            com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda2(this, paramBitmap, paramInt2, paramInt1, paramString));
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        Object localObject = this.pKM;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.LuO;
        if (localObject != null) {
          ((VoIPRenderTextureView)localObject).setVisibility(0);
        }
        g(paramBitmap, paramInt2, paramInt1);
        aNB(paramString);
        AppMethodBeat.o(285847);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(285847);
        bool = true;
      }
    }
  }
  
  public final Integer ght()
  {
    AppMethodBeat.i(285835);
    int i = this.Ikt.getVisibility();
    AppMethodBeat.o(285835);
    return Integer.valueOf(i);
  }
  
  public final void gij()
  {
    AppMethodBeat.i(285862);
    gil();
    aca(this.Lsq.ghU());
    this.Ikt.setAlpha(0.0F);
    this.Ikt.setVisibility(0);
    this.Ikt.clearAnimation();
    this.Ikt.animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new e(this)).start();
    AppMethodBeat.o(285862);
  }
  
  public final void gik()
  {
    AppMethodBeat.i(285870);
    this.LxZ = 0;
    this.Ikt.setAlpha(1.0F);
    this.Ikt.setVisibility(0);
    this.Ikt.clearAnimation();
    this.Ikt.animate().alpha(0.0F).setDuration(300L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(285870);
  }
  
  public final void gil()
  {
    AppMethodBeat.i(285876);
    RelativeLayout localRelativeLayout;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.Lsq.ghU() == 90) || (this.Lsq.ghU() == 270))
    {
      localRelativeLayout = this.Ikt;
      int i = f.Luk;
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      if (!this.Lsq.ghV()) {
        break label94;
      }
      localLayoutParams.setMarginEnd(f.Luh);
    }
    for (;;)
    {
      localLayoutParams.addRule(21);
      localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(285876);
      return;
      label94:
      localLayoutParams.setMarginEnd(f.LtY);
    }
  }
  
  public final void zu(boolean paramBoolean)
  {
    AppMethodBeat.i(285881);
    aca(this.Lsq.ghU());
    View localView = this.Lyb;
    if (localView != null) {
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(285881);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$changeRenderToAvatarAnimation$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(g paramg, String paramString) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285959);
      paramAnimator = this.Lyd.LuO;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      g.c(this.Lyd);
      paramAnimator = this.Lyd.pKM;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(1.0F);
      }
      paramAnimator = this.Lyd.pKM;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      AppMethodBeat.o(285959);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(285968);
      RelativeLayout localRelativeLayout = this.Lyd.Ikt;
      StringBuilder localStringBuilder = new StringBuilder();
      paramAnimator = g.d(this.Lyd);
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.getString(a.h.chatting_voip_voice))
      {
        localRelativeLayout.setContentDescription((CharSequence)(paramAnimator + ',' + ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).field_nickname));
        AppMethodBeat.o(285968);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$changeRenderToVideoAnimation$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "p0", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(g paramg, String paramString) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285981);
      paramAnimator = this.Lyd.pKM;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      g.c(this.Lyd);
      paramAnimator = this.Lyd.LuO;
      if (paramAnimator != null) {
        paramAnimator.setAlpha(1.0F);
      }
      paramAnimator = this.Lyd.LuO;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      AppMethodBeat.o(285981);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(285992);
      RelativeLayout localRelativeLayout = this.Lyd.Ikt;
      StringBuilder localStringBuilder = new StringBuilder();
      paramAnimator = g.d(this.Lyd);
      if (paramAnimator == null) {}
      for (paramAnimator = null;; paramAnimator = paramAnimator.getString(a.h.chatting_voip_voice))
      {
        localRelativeLayout.setContentDescription((CharSequence)(paramAnimator + ',' + ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).field_nickname));
        AppMethodBeat.o(285992);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationHide$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(g paramg) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285945);
      this.Lyd.Ikt.setVisibility(4);
      AppMethodBeat.o(285945);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarCellLayout$doAnimationShow$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(g paramg) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285946);
      this.Lyd.Ikt.setAlpha(1.0F);
      AppMethodBeat.o(285946);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.g
 * JD-Core Version:    0.7.0.1
 */