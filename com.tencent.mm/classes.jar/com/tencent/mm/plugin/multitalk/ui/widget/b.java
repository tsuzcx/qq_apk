package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarDetailView", "avatarOverlay", "Landroid/widget/FrameLayout;", "curShowedCenterViewType", "", "getCurShowedCenterViewType", "()I", "setCurShowedCenterViewType", "(I)V", "footerStub", "getFooterStub", "()Landroid/view/View;", "setFooterStub", "headerStub", "getHeaderStub", "setHeaderStub", "isShowAnimationDone", "", "()Z", "setShowAnimationDone", "(Z)V", "isShowBubbleToast", "setShowBubbleToast", "loadingIv", "Landroid/widget/ImageView;", "mMuteIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mTimerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "mTitleShowCallback", "Lkotlin/Function1;", "", "", "maskView", "multiTalkVideoView", "Lcom/tencent/mm/plugin/multitalk/ui/widget/MultitalkFrameView;", "screenNavRootLayout", "Landroid/widget/RelativeLayout;", "getScreenNavRootLayout", "()Landroid/widget/RelativeLayout;", "setScreenNavRootLayout", "(Landroid/widget/RelativeLayout;)V", "screenProjectAnimationNav", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "getScreenProjectAnimationNav", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "setScreenProjectAnimationNav", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;)V", "switchCameraTv", "Landroid/widget/TextView;", "talkingAvatarLayout", "userName", "userNameShadowIv", "userNameTv", "userUinName", "getUserUinName", "()Ljava/lang/String;", "setUserUinName", "(Ljava/lang/String;)V", "videoVertical", "getVideoVertical", "setVideoVertical", "voiceMaskIv", "weakNetworkIv", "dismissCenterInfo", "dismissCenterInfoLoadingAnim", "isPause", "fetchAvatarNavShowList", "finish", "getLayoutInflater", "Landroid/view/LayoutInflater;", "hideUserName", "reachNavAnimationEnd", "showCenterInfo", "centerView", "withBackground", "width", "height", "res", "showCenterInfoLoadingAnim", "showText", "showCenterText", "textId", "showMuteIcon", "visible", "showRotateScreenInfo", "isv2h", "autoDismiss", "showScreenCastIcon", "showUserName", "isTitleShowCallback", "mIsContinue", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.v
{
  public static final b.a LsH;
  public ImageView KGG;
  public MultitalkFrameView LsI;
  public ImageView LsJ;
  public ImageView LsK;
  public TextView LsL;
  public WeImageView LsM;
  public TextView LsN;
  private View LsO;
  private View LsP;
  String LsQ;
  private kotlin.g.a.b<? super String, ah> LsR;
  public final FrameLayout LsS;
  public boolean LsT;
  public View LsU;
  View LsV;
  View LsW;
  public int LsX;
  public c LsY;
  private RelativeLayout LsZ;
  public boolean Lta;
  public MTimerHandler eln;
  public View maskView;
  public String userName;
  
  static
  {
    AppMethodBeat.i(285587);
    LsH = new b.a((byte)0);
    AppMethodBeat.o(285587);
  }
  
  public b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178966);
    View localView = paramView.findViewById(a.e.avatar_cell_overlay);
    s.s(localView, "itemView.findViewById(R.id.avatar_cell_overlay)");
    this.LsS = ((FrameLayout)localView);
    this.LsT = true;
    localView = paramView.findViewById(a.e.talking_avatar_layout);
    s.s(localView, "itemView.findViewById(R.id.talking_avatar_layout)");
    this.LsU = localView;
    localView = paramView.findViewById(a.e.header_stub);
    s.s(localView, "itemView.findViewById(R.id.header_stub)");
    this.LsV = localView;
    localView = paramView.findViewById(a.e.footer_stub);
    s.s(localView, "itemView.findViewById(R.id.footer_stub)");
    this.LsW = localView;
    this.LsX = -1;
    this.LsI = ((MultitalkFrameView)paramView.findViewById(a.e.talking_video_view));
    this.maskView = paramView.findViewById(a.e.mask_view);
    localView = paramView.findViewById(a.e.voice_icon_iv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.LsJ = ((ImageView)localView);
    localView = paramView.findViewById(a.e.multitalk_weaknetwork_iv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.LsK = ((ImageView)localView);
    localView = paramView.findViewById(a.e.switch_camera_tip_tv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.LsL = ((TextView)localView);
    localView = paramView.findViewById(a.e.loading_iv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.KGG = ((ImageView)localView);
    localView = paramView.findViewById(a.e.multitalk_mute_iv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.LsM = ((WeImageView)localView);
    localView = paramView.findViewById(a.e.avatar_username_tv);
    if (localView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178966);
      throw paramView;
    }
    this.LsN = ((TextView)localView);
    this.LsP = paramView.findViewById(a.e.avatar_username_iv);
    this.LsO = paramView.findViewById(a.e.avatar_layout_detail);
    this.LsZ = ((RelativeLayout)paramView.findViewById(a.e.screen_animation));
    paramView = paramView.getContext();
    s.s(paramView, "itemView.context");
    this.LsY = new c(paramView);
    AppMethodBeat.o(178966);
  }
  
  private static boolean aNy(String paramString)
  {
    AppMethodBeat.i(285512);
    if (paramString == null)
    {
      AppMethodBeat.o(285512);
      return true;
    }
    boolean bool = ac.ggS().aNg(paramString);
    AppMethodBeat.o(285512);
    return bool;
  }
  
  private void b(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(285560);
    s.u(paramView, "centerView");
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt1, paramInt2, 17);
    if (paramBoolean)
    {
      FrameLayout localFrameLayout = new FrameLayout(this.caK.getContext());
      MultitalkFrameView localMultitalkFrameView = this.LsI;
      Object localObject2;
      if (localMultitalkFrameView != null)
      {
        localObject2 = BitmapUtil.createBitmap(this.LsS.getWidth() / 4, this.LsS.getHeight() / 4, Bitmap.Config.ARGB_8888);
        if (localObject2 == null) {}
      }
      for (;;)
      {
        try
        {
          new Canvas((Bitmap)localObject2).drawColor(-16777216);
          Object localObject1 = localMultitalkFrameView.getElementPrev();
          Object localObject3 = ((MultitalkFrameView.b)localObject1).currentBitmap;
          if (localObject3 != null)
          {
            paramInt1 = 1;
            if (paramInt1 != 0)
            {
              if (localObject1 != null) {
                continue;
              }
              localObject1 = null;
              if (localObject1 != null) {
                continue;
              }
              paramInt1 = 0;
              if (paramInt1 == 0) {
                localFrameLayout.setBackgroundColor(this.caK.getResources().getColor(a.b.multitalk_screen_cast_center_info_background));
              }
              localFrameLayout.addView(paramView, (ViewGroup.LayoutParams)localLayoutParams);
              this.LsS.addView((View)localFrameLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
              AppMethodBeat.o(285560);
            }
          }
          else
          {
            paramInt1 = 0;
            continue;
          }
          localObject1 = null;
          continue;
          localObject3 = this.userName;
          s.checkNotNull(localObject3);
          Bitmap localBitmap = ((MultitalkFrameView.b)localObject1).currentBitmap;
          s.checkNotNull(localBitmap);
          localMultitalkFrameView.a((String)localObject3, localBitmap, ((MultitalkFrameView.b)localObject1).LwK, ((MultitalkFrameView.b)localObject1).LwL);
          localObject1 = ah.aiuX;
          continue;
          localObject1 = BitmapUtil.fastblur((Bitmap)localObject2, 10);
          localObject1 = new BitmapDrawable(this.caK.getResources(), (Bitmap)localObject1);
          ((BitmapDrawable)localObject1).setColorFilter((ColorFilter)new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F })));
          localObject2 = ah.aiuX;
          localFrameLayout.setBackground((Drawable)localObject1);
          paramInt1 = 1;
          continue;
          paramInt1 = 0;
        }
        catch (Exception localException)
        {
          Log.e("AvatarLayoutHolder", localException.getMessage() + ' ' + ah.aiuX);
        }
      }
    }
    this.LsS.addView(paramView, (ViewGroup.LayoutParams)localLayoutParams);
    AppMethodBeat.o(285560);
  }
  
  private static final boolean c(b paramb)
  {
    AppMethodBeat.i(285565);
    s.u(paramb, "this$0");
    paramb.ghn();
    AppMethodBeat.o(285565);
    return true;
  }
  
  private static final void d(b paramb)
  {
    AppMethodBeat.i(285571);
    s.u(paramb, "this$0");
    if (paramb.LsX == 4) {
      d.uiThread((kotlin.g.a.a)new c(paramb));
    }
    AppMethodBeat.o(285571);
  }
  
  private LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(285536);
    Object localObject = this.caK.getContext().getSystemService("layout_inflater");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
      AppMethodBeat.o(285536);
      throw ((Throwable)localObject);
    }
    localObject = (LayoutInflater)localObject;
    AppMethodBeat.o(285536);
    return localObject;
  }
  
  private final void ghn()
  {
    AppMethodBeat.i(285527);
    Object localObject = this.LsO;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).cancel();
      }
    }
    localObject = this.LsO;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(150L);
          if (localObject != null) {
            ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new b(this));
          }
        }
      }
    }
    localObject = this.eln;
    if (localObject != null) {
      ((MTimerHandler)localObject).stopTimer();
    }
    localObject = this.eln;
    if (localObject != null) {
      ((MTimerHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.eln;
    if (localObject != null) {
      ((MTimerHandler)localObject).quitSafely();
    }
    AppMethodBeat.o(285527);
  }
  
  public final void aC(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(285629);
    if (this.LsX == 3)
    {
      AppMethodBeat.o(285629);
      return;
    }
    if ((paramBoolean1) && (this.LsX == 2))
    {
      AppMethodBeat.o(285629);
      return;
    }
    if ((!paramBoolean1) && (this.LsX != -1))
    {
      AppMethodBeat.o(285629);
      return;
    }
    Object localObject1 = getLayoutInflater().inflate(a.f.multitalk_center_info_loading_anim, (ViewGroup)this.LsS, false);
    s.s(localObject1, "getLayoutInflater().infl…im, avatarOverlay, false)");
    Object localObject2 = ((View)localObject1).findViewById(a.e.multitalk_center_info_anim);
    s.s(localObject2, "center.findViewById(R.id…ltitalk_center_info_anim)");
    localObject2 = (ImageView)localObject2;
    if ((!paramBoolean1) || (!paramBoolean2)) {
      ((TextView)((View)localObject1).findViewById(a.e.multitalk_center_info_text)).setVisibility(8);
    }
    ic((View)localObject1);
    if ((((ImageView)localObject2).getBackground() instanceof AnimationDrawable))
    {
      localObject1 = ((ImageView)localObject2).getBackground();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(285629);
        throw ((Throwable)localObject1);
      }
      ((AnimationDrawable)localObject1).start();
    }
    if (paramBoolean1)
    {
      this.LsX = 2;
      AppMethodBeat.o(285629);
      return;
    }
    this.LsX = 1;
    AppMethodBeat.o(285629);
  }
  
  public final void abO(int paramInt)
  {
    AppMethodBeat.i(285605);
    Object localObject = this.LsM;
    if (localObject != null) {
      ((WeImageView)localObject).setImageDrawable(bb.m(this.caK.getContext(), a.g.icon_filled_mike_off, -65536));
    }
    localObject = this.LsM;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(this.caK.getContext().getResources().getColor(a.b.red));
    }
    localObject = this.LsI;
    int i;
    if (localObject != null)
    {
      i = a.e.tag_multi_talk_status_mute;
      if (paramInt != 0) {
        break label170;
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      ((MultitalkFrameView)localObject).setTag(i, Boolean.valueOf(bool));
      ((RelativeLayout)this.caK.findViewById(a.e.multitalk_mute_icon_bg)).setBackground(bb.m(this.caK.getContext(), a.d.multitalk_mute_icon_background, this.caK.getContext().getResources().getColor(a.b.White)));
      ((RelativeLayout)this.caK.findViewById(a.e.multitalk_mute_icon_bg)).setVisibility(paramInt);
      AppMethodBeat.o(285605);
      return;
    }
  }
  
  public final void abP(int paramInt)
  {
    AppMethodBeat.i(285616);
    Object localObject;
    c localc;
    if ((ac.ggS().ggg().geG()) && (paramInt == 0))
    {
      ac.ggS().aNh(this.LsQ);
      ghn();
      this.Lta = true;
      localObject = this.LsZ;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(0);
      }
      localObject = this.LsZ;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).removeAllViews();
        localc = this.LsY;
        if (localc != null) {
          localc.a((RelativeLayout)localObject);
        }
      }
      localObject = this.LsY;
      if (localObject != null)
      {
        ((c)localObject).gib();
        AppMethodBeat.o(285616);
      }
    }
    else if ((paramInt == 0) && (!this.Lta) && (!aNy(this.LsQ)))
    {
      Log.i("AvatarLayoutHolder", "showScreenCastIcon visible first times");
      ghn();
      this.Lta = true;
      localObject = this.LsZ;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(0);
      }
      localObject = this.LsZ;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).removeAllViews();
        localc = this.LsY;
        if (localc != null) {
          localc.a((RelativeLayout)localObject);
        }
      }
      localObject = this.LsY;
      if (localObject != null)
      {
        ((c)localObject).gia();
        AppMethodBeat.o(285616);
      }
    }
    else if (paramInt == 0)
    {
      Log.i("AvatarLayoutHolder", "showScreenCastIcon invisible cause VISIBLE");
      ghn();
      localObject = this.LsZ;
      if (localObject != null)
      {
        ((RelativeLayout)localObject).removeAllViews();
        localc = this.LsY;
        if (localc != null) {
          localc.a((RelativeLayout)localObject);
        }
      }
      localObject = this.LsY;
      if (localObject != null)
      {
        ((c)localObject).abX(paramInt);
        AppMethodBeat.o(285616);
      }
    }
    else
    {
      Log.i("AvatarLayoutHolder", "showScreenCastIcon invisible cause INVISIBLE");
      localObject = this.LsZ;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      localObject = this.LsY;
      if (localObject != null) {
        ((c)localObject).gic();
      }
    }
    AppMethodBeat.o(285616);
  }
  
  public final void az(kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(285621);
    TextView localTextView = this.LsN;
    if ((localTextView != null) && (localTextView.getVisibility() == 8)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.LsR = paramb;
      paramb = this.LsN;
      if (paramb != null) {
        paramb.setText((CharSequence)this.userName);
      }
      paramb = this.LsO;
      if (paramb != null) {
        paramb.setAlpha(0.0F);
      }
      paramb = this.LsP;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.LsN;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.eln;
      if (paramb != null) {
        paramb.stopTimer();
      }
      paramb = this.eln;
      if (paramb != null) {
        paramb.removeCallbacksAndMessages(null);
      }
      paramb = this.eln;
      if (paramb != null) {
        paramb.quitSafely();
      }
      this.eln = new MTimerHandler(new b..ExternalSyntheticLambda0(this), false);
      paramb = this.LsO;
      if (paramb != null)
      {
        paramb = paramb.animate();
        if (paramb != null) {
          paramb.cancel();
        }
      }
      paramb = this.LsO;
      if (paramb == null) {
        break label252;
      }
      paramb = paramb.animate();
      if (paramb == null) {
        break label252;
      }
      paramb = paramb.alpha(1.0F);
      if (paramb == null) {
        break label252;
      }
      paramb = paramb.setDuration(150L);
      if (paramb == null) {
        break label252;
      }
      paramb.setListener((Animator.AnimatorListener)new d(this));
      AppMethodBeat.o(285621);
      return;
    }
    ghn();
    label252:
    AppMethodBeat.o(285621);
  }
  
  public final void gho()
  {
    AppMethodBeat.i(285644);
    if ((this.LsX == 2) || (this.LsX == 1)) {
      zi(true);
    }
    this.LsS.removeAllViews();
    this.LsX = -1;
    this.LsX = -1;
    AppMethodBeat.o(285644);
  }
  
  public final void ic(View paramView)
  {
    AppMethodBeat.i(285624);
    b(paramView, -2, -2, true);
    AppMethodBeat.o(285624);
  }
  
  public final void zi(boolean paramBoolean)
  {
    AppMethodBeat.i(285638);
    if ((!paramBoolean) && (this.LsX == 2))
    {
      AppMethodBeat.o(285638);
      return;
    }
    if ((this.LsX != 1) && (this.LsX != 2))
    {
      AppMethodBeat.o(285638);
      return;
    }
    if (this.LsS.getChildCount() != 1)
    {
      AppMethodBeat.o(285638);
      return;
    }
    Object localObject = this.LsS.getChildAt(0);
    s.s(localObject, "avatarOverlay.getChildAt(0)");
    ImageView localImageView = (ImageView)((View)localObject).findViewById(a.e.multitalk_center_info_anim);
    if (localImageView == null) {
      localObject = null;
    }
    while ((localObject instanceof AnimationDrawable))
    {
      localObject = localImageView.getBackground();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(285638);
        throw ((Throwable)localObject);
        localObject = localImageView.getBackground();
      }
      else
      {
        ((AnimationDrawable)localObject).stop();
      }
    }
    this.LsS.removeViewAt(0);
    this.LsX = -1;
    AppMethodBeat.o(285638);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder$hideUserName$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285611);
      paramAnimator = this.Ltb.LsN;
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = b.f(this.Ltb);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = this.Ltb.userName;
      if (paramAnimator != null)
      {
        kotlin.g.a.b localb = b.g(this.Ltb);
        if (localb != null) {
          localb.invoke(paramAnimator);
        }
      }
      AppMethodBeat.o(285611);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder$showUserName$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(b paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285615);
      paramAnimator = b.e(this.Ltb);
      if (paramAnimator != null) {
        paramAnimator.startTimer(5000L);
      }
      AppMethodBeat.o(285615);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */