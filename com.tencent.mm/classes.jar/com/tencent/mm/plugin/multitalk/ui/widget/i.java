package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView;", "", "rootView", "Landroid/view/View;", "(Landroid/view/View;)V", "animationView", "Landroid/widget/ImageView;", "contentView", "context", "Landroid/content/Context;", "detailShadow", "detailTv", "Landroid/widget/TextView;", "drawPaint", "Landroid/graphics/Paint;", "fullIconLayout", "fullLayout", "fullTextTv", "isDoingAnimationChange", "", "lastRenderSwitchTick", "", "getLastRenderSwitchTick", "()Ljava/lang/Long;", "setLastRenderSwitchTick", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "value", "", "mCurrentRenderUser", "getMCurrentRenderUser", "()Ljava/lang/String;", "setMCurrentRenderUser", "(Ljava/lang/String;)V", "mCurrentRenderVideo", "getMCurrentRenderVideo", "()Z", "setMCurrentRenderVideo", "(Z)V", "mCurrentShowUser", "getMCurrentShowUser", "setMCurrentShowUser", "mLastVideoData", "mPrevBitmap", "Landroid/graphics/Bitmap;", "mPrevBitmapAngle", "", "mPrevBitmapMirror", "radius", "", "renderView", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "getRootView", "()Landroid/view/View;", "setRootView", "visibility", "getVisibility", "()Ljava/lang/Integer;", "setVisibility", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "changeRenderAnimation", "userName", "bitmap", "angle", "mirror", "changeRenderUser", "", "name", "drawAvatar", "drawBitmap", "drawPrevBitmap", "drawVideo", "img", "getRenderSurface", "hideOther", "hideView", "onHangupHappened", "onResumeIconAndTipShow", "refreshLayoutCauseDockChanged", "isDockerLeft", "release", "setVoicePlayDevice", "device", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a LuM;
  TextView LuN;
  private VoIPRenderTextureView LuO;
  ImageView LuP;
  private View LuQ;
  ImageView LuR;
  TextView LuS;
  boolean LuT;
  String LuU;
  private String LuV;
  Long LuW;
  private Bitmap LuX;
  private int LuY;
  private int LuZ;
  private long Lva;
  private boolean Lvb;
  View contentView;
  Context context;
  private final float radius;
  private View rootView;
  View ucy;
  private Paint wXu;
  
  static
  {
    AppMethodBeat.i(285462);
    LuM = new i.a((byte)0);
    AppMethodBeat.o(285462);
  }
  
  public i(View paramView)
  {
    AppMethodBeat.i(285430);
    this.rootView = paramView;
    this.radius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.contentView = this.rootView.findViewById(a.e.multitalk_content_view);
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.contentView;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.LuN = ((TextView)this.rootView.findViewById(a.e.multitalk_username_tv));
    this.LuQ = this.rootView.findViewById(a.e.avatar_username_iv);
    this.context = this.rootView.getContext();
    this.LuO = ((VoIPRenderTextureView)this.rootView.findViewById(a.e.multitalk_small_video_view_content));
    paramView = this.LuO;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.LuO;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.LuP = ((ImageView)this.rootView.findViewById(a.e.multitalk_small_video_view_animation));
    paramView = this.LuP;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.LuP;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.wXu = new Paint();
    paramView = this.wXu;
    if (paramView != null) {
      paramView.setColor(-16777216);
    }
    paramView = this.wXu;
    if (paramView != null) {
      paramView.setFilterBitmap(false);
    }
    paramView = this.wXu;
    if (paramView != null) {
      paramView.setTextSize(40.0F);
    }
    this.ucy = this.rootView.findViewById(a.e.voip_mini_windows_layout);
    paramView = this.ucy;
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    paramView = this.ucy;
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new k(this.radius));
    }
    this.LuR = ((ImageView)this.rootView.findViewById(a.e.multitalk_mini_full_icon));
    this.LuS = ((TextView)this.rootView.findViewById(a.e.multitalk_mini_full_tv));
    this.Lva = -1L;
    AppMethodBeat.o(285430);
  }
  
  private static final void a(i parami, final Bitmap paramBitmap, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(285450);
    s.u(parami, "this$0");
    s.u(paramString, "$userName");
    Object localObject1 = parami.LuP;
    if (localObject1 != null) {
      ((ImageView)localObject1).setAlpha(1.0F);
    }
    int i;
    int j;
    Object localObject2;
    Matrix localMatrix;
    if ((parami.LuX != null) && (parami.LuX != null))
    {
      localObject1 = parami.LuX;
      s.checkNotNull(localObject1);
      i = ((Bitmap)localObject1).getWidth();
      localObject1 = parami.LuX;
      s.checkNotNull(localObject1);
      j = ((Bitmap)localObject1).getHeight();
      localObject1 = parami.LuO;
      s.checkNotNull(localObject1);
      int k = ((VoIPRenderTextureView)localObject1).getMeasuredWidth();
      localObject1 = parami.LuO;
      s.checkNotNull(localObject1);
      localObject1 = Bitmap.createBitmap(k, ((VoIPRenderTextureView)localObject1).getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      s.checkNotNull(localObject1);
      localObject2 = new Canvas((Bitmap)localObject1);
      localMatrix = new Matrix();
      if (parami.LuY != OpenGlRender.FLAG_Angle270) {
        break label396;
      }
      localMatrix.setRotate(270.0F, i / 2.0F, j / 2.0F);
    }
    for (;;)
    {
      if (parami.LuZ == OpenGlRender.FLAG_Mirror)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        localMatrix.postTranslate(i, 0.0F);
      }
      localMatrix.postScale(((Canvas)localObject2).getWidth() / j, ((Canvas)localObject2).getHeight() / i);
      Bitmap localBitmap = parami.LuX;
      s.checkNotNull(localBitmap);
      ((Canvas)localObject2).drawBitmap(localBitmap, localMatrix, parami.wXu);
      localObject2 = parami.LuP;
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
      }
      localObject1 = parami.LuP;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(0);
      }
      localObject1 = parami.LuP;
      if (localObject1 != null) {
        ((ImageView)localObject1).clearAnimation();
      }
      localObject1 = parami.LuP;
      if (localObject1 != null)
      {
        localObject1 = ((ImageView)localObject1).animate();
        if (localObject1 != null)
        {
          localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).alpha(0.0F);
            if (localObject1 != null) {
              ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new b(parami, paramBitmap, paramInt1, paramInt2, paramString));
            }
          }
        }
      }
      AppMethodBeat.o(285450);
      return;
      label396:
      if (parami.LuY == OpenGlRender.FLAG_Angle90) {
        localMatrix.setRotate(90.0F, i / 2.0F, j / 2.0F);
      }
    }
  }
  
  private static final void a(i parami, String paramString)
  {
    AppMethodBeat.i(285445);
    s.u(parami, "this$0");
    s.u(paramString, "$name");
    Object localObject = parami.LuQ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = parami.LuN;
    if (localObject != null) {
      ((TextView)localObject).setTextSize(1, 10.0F);
    }
    localObject = parami.LuN;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).field_nickname);
    }
    if (!s.p(parami.LuV, paramString))
    {
      parami.aNA(paramString);
      parami.LuW = Long.valueOf(Util.currentTicks());
    }
    AppMethodBeat.o(285445);
  }
  
  private final void aNB(String paramString)
  {
    AppMethodBeat.i(285435);
    com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda1(this, paramString));
    AppMethodBeat.o(285435);
  }
  
  private final boolean c(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(285441);
    if ((!s.p(this.LuV, paramString)) && (this.LuX != null) && (this.LuO != null))
    {
      com.tencent.threadpool.h.ahAA.bk(new i..ExternalSyntheticLambda0(this, paramBitmap, paramInt1, paramInt2, paramString));
      AppMethodBeat.o(285441);
      return true;
    }
    AppMethodBeat.o(285441);
    return false;
  }
  
  public final void aNA(String paramString)
  {
    AppMethodBeat.i(285484);
    aNz(paramString);
    this.LuV = paramString;
    AppMethodBeat.o(285484);
  }
  
  public final boolean aNC(String paramString)
  {
    int j = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(285503);
        s.u(paramString, "userName");
        if (this.LuO == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "drawAvatar view is null");
          AppMethodBeat.o(285503);
          return bool;
        }
        if (this.Lvb)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
          AppMethodBeat.o(285503);
          continue;
        }
        localObject1 = a.b.iKa();
      }
      finally {}
      Object localObject1;
      Object localObject2 = this.LuO;
      int i;
      if (localObject2 == null)
      {
        i = 0;
        label95:
        localObject2 = this.LuO;
        if (localObject2 != null) {
          break label220;
        }
      }
      for (;;)
      {
        localObject2 = ((j.a)localObject1).b(paramString, i, j, 1);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getHeight() < ((Bitmap)localObject2).getWidth()) {
            localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getHeight());
          }
        }
        if (localObject1 == null) {
          break label229;
        }
        if (!c(paramString, (Bitmap)localObject1, 0, 0))
        {
          f((Bitmap)localObject1, 0, 0);
          aNB(paramString);
          this.LuT = false;
        }
        AppMethodBeat.o(285503);
        bool = true;
        break;
        i = ((VoIPRenderTextureView)localObject2).getMeasuredWidth();
        break label95;
        label220:
        j = ((VoIPRenderTextureView)localObject2).getMeasuredHeight();
      }
      label229:
      localObject2 = com.tencent.mm.compatible.f.a.decodeResource(MMApplicationContext.getContext().getResources(), a.g.default_avatar);
      if (!c(paramString, (Bitmap)localObject1, 0, 0))
      {
        f((Bitmap)localObject2, 0, 0);
        aNB(paramString);
        this.LuT = false;
      }
      AppMethodBeat.o(285503);
      bool = true;
    }
  }
  
  public final void aNz(String paramString)
  {
    Long localLong = null;
    AppMethodBeat.i(285479);
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
      AppMethodBeat.o(285479);
      return;
      localLong = Long.valueOf(Util.currentTicks());
    }
  }
  
  public final void abR(int paramInt)
  {
    AppMethodBeat.i(285505);
    View localView = this.LuQ;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(285505);
  }
  
  public final boolean b(String paramString, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(285497);
        s.u(paramString, "userName");
        if (this.LuO == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "drawVideo view is null");
          AppMethodBeat.o(285497);
          return bool;
        }
        if (paramBitmap == null)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img is null");
          AppMethodBeat.o(285497);
          continue;
        }
        if (!this.Lvb) {
          break label97;
        }
      }
      finally {}
      Log.e("MicroMsg.MultiTalkMiniVideoView", "renderVideoBitmap img false cause isDoingAnimationChange");
      AppMethodBeat.o(285497);
      continue;
      label97:
      if (!c(paramString, paramBitmap, paramInt2, paramInt1))
      {
        f(paramBitmap, paramInt2, paramInt1);
        this.Lva = Util.currentTicks();
        aNB(paramString);
        this.LuT = true;
        AppMethodBeat.o(285497);
        bool = true;
      }
      else
      {
        AppMethodBeat.o(285497);
        bool = true;
      }
    }
  }
  
  public final void f(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Canvas localCanvas = null;
    label155:
    label338:
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(285492);
        if ((paramBitmap == null) || (paramBitmap.isRecycled()))
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "DrawBitmap, bitmap is null or recycled");
          o.gfG();
          AppMethodBeat.o(285492);
          return;
        }
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        if (this.LuO == null)
        {
          AppMethodBeat.o(285492);
          continue;
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
        Log.e("MicroMsg.MultiTalkMiniVideoView", "getCanvasError");
        AppMethodBeat.o(285492);
        break;
        localCanvas = ((VoIPRenderTextureView)localObject).lockCanvas(null);
      }
      label121:
      Object localObject = new Matrix();
      if (paramInt1 == OpenGlRender.FLAG_Angle270)
      {
        ((Matrix)localObject).setRotate(270.0F, i / 2.0F, j / 2.0F);
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
        localCanvas.drawBitmap(paramBitmap, (Matrix)localObject, this.wXu);
        this.LuY = paramInt1;
        this.LuZ = paramInt2;
        this.LuX = paramBitmap;
        try
        {
          paramBitmap = this.LuO;
          if (paramBitmap == null) {
            break label338;
          }
          paramBitmap.unlockCanvasAndPost(localCanvas);
          AppMethodBeat.o(285492);
        }
        catch (Exception paramBitmap)
        {
          Log.printErrStackTrace("MicroMsg.MultiTalkMiniVideoView", (Throwable)paramBitmap, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
          AppMethodBeat.o(285492);
        }
        if (paramInt1 != OpenGlRender.FLAG_Angle90) {
          break label155;
        }
        ((Matrix)localObject).setRotate(90.0F, i / 2.0F, j / 2.0F);
      }
      catch (Exception paramBitmap)
      {
        for (;;)
        {
          Log.e("MicroMsg.MultiTalkMiniVideoView", "draw bitmap error");
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkMiniVideoView$changeRenderAnimation$1$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(i parami, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285373);
      paramAnimator = i.a(this.Lvc);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = i.b(this.Lvc);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(0);
      }
      i.a(this.Lvc, false);
      AppMethodBeat.o(285373);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(285387);
      this.Lvc.f(paramBitmap, paramInt1, paramInt2);
      paramAnimator = i.b(this.Lvc);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = i.b(this.Lvc);
      if (paramAnimator != null) {
        paramAnimator.setTextSize(1, 10.0F);
      }
      paramAnimator = i.b(this.Lvc);
      if (paramAnimator != null) {
        paramAnimator.setText((CharSequence)((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString).field_nickname);
      }
      this.Lvc.aNA(paramString);
      i.a(this.Lvc, true);
      AppMethodBeat.o(285387);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */