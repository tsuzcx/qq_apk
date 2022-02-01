package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isDoAnimationEnd", "", "mContentRoot", "Landroid/widget/RelativeLayout;", "mMainIconViewBg", "Landroid/view/View;", "mScreenProjectNavTv", "Landroid/widget/TextView;", "mUiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "runnable", "Ljava/lang/Runnable;", "screenNavBg", "screenProjectIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "screenProjectMainIconIv", "doAnimationHide", "", "getNavLayout", "reachAnimationEnd", "releaseAnimation", "showScreenAvatarNav", "showScreenIconAvatar", "visible", "", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a LxE;
  private WeImageView LxF;
  private View LxG;
  private View LxH;
  private TextView LxI;
  private WeImageView LxJ;
  private boolean LxK;
  private RelativeLayout LxL;
  private Context context;
  private Runnable hPJ;
  private MMHandler qse;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(285684);
    LxE = new c.a((byte)0);
    AppMethodBeat.o(285684);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(285646);
    this.context = paramContext;
    this.hPJ = new c..ExternalSyntheticLambda2(this);
    AppMethodBeat.o(285646);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(285654);
    s.u(paramc, "this$0");
    if (!paramc.LxK)
    {
      Object localObject = paramc.LxG;
      if (localObject != null) {
        ((View)localObject).clearAnimation();
      }
      localObject = paramc.LxF;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = paramc.LxG;
      if (localObject != null)
      {
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(100L);
            if (localObject != null)
            {
              paramc = ((ViewPropertyAnimator)localObject).withStartAction(new c..ExternalSyntheticLambda1(paramc));
              if (paramc != null) {
                paramc.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(285654);
  }
  
  private static final void a(c paramc, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(285661);
    s.u(paramc, "this$0");
    Object localObject1 = paramc.LxF;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setVisibility(0);
    }
    localObject1 = paramc.LxH;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = paramc.LxH;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      localObject2 = paramValueAnimator.getAnimatedValue("sizeW");
      if (localObject2 == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(285661);
        throw paramc;
        localObject1 = ((View)localObject1).getLayoutParams();
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
      }
    }
    localObject1 = paramc.LxH;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      localObject2 = paramValueAnimator.getAnimatedValue("sizeH");
      if (localObject2 == null)
      {
        paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(285661);
        throw paramc;
        localObject1 = ((View)localObject1).getLayoutParams();
      }
      else
      {
        ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
      }
    }
    localObject1 = paramc.LxH;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((View)localObject1).getLayoutParams())
    {
      paramc = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(285661);
      throw paramc;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    Object localObject2 = paramValueAnimator.getAnimatedValue("marginBottom");
    if (localObject2 == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(285661);
      throw paramc;
    }
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((Integer)localObject2).intValue();
    localObject1 = paramc.LxH;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((View)localObject1).getLayoutParams())
    {
      paramc = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(285661);
      throw paramc;
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    paramValueAnimator = paramValueAnimator.getAnimatedValue("marginEnd");
    if (paramValueAnimator == null)
    {
      paramc = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(285661);
      throw paramc;
    }
    ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(((Integer)paramValueAnimator).intValue());
    paramc = paramc.LxH;
    if (paramc != null) {
      paramc.requestLayout();
    }
    AppMethodBeat.o(285661);
  }
  
  private static final void b(c paramc)
  {
    AppMethodBeat.i(285674);
    s.u(paramc, "this$0");
    Object localObject = paramc.LxI;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
    localObject = paramc.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = paramc.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).clearAnimation();
    }
    int k = -bd.fromDPToPix(paramc.context, 4);
    localObject = paramc.rootView;
    int j;
    label108:
    View localView;
    if (localObject == null)
    {
      i = 0;
      int m = bd.fromDPToPix(paramc.context, 32);
      localObject = paramc.LxF;
      if (localObject != null) {
        break label370;
      }
      j = 0;
      localObject = paramc.LxF;
      if (localObject != null)
      {
        localObject = ((WeImageView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationX(i - m - j);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).translationY(k);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
      localObject = paramc.rootView;
      if (localObject != null) {
        break label379;
      }
      i = 0;
      label197:
      localObject = PropertyValuesHolder.ofInt("sizeW", new int[] { i, bd.fromDPToPix(paramc.context, 28) });
      localView = paramc.rootView;
      if (localView != null) {
        break label388;
      }
    }
    label388:
    for (int i = 0;; i = localView.getHeight())
    {
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, PropertyValuesHolder.ofInt("sizeH", new int[] { i, bd.fromDPToPix(paramc.context, 28) }), PropertyValuesHolder.ofInt("marginBottom", new int[] { 0, bd.fromDPToPix(paramc.context, 8) }), PropertyValuesHolder.ofInt("marginEnd", new int[] { 0, bd.fromDPToPix(paramc.context, 8) }) }).setDuration(300L);
      ((ValueAnimator)localObject).addUpdateListener(new c..ExternalSyntheticLambda0(paramc));
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(285674);
      return;
      i = ((View)localObject).getWidth();
      break;
      label370:
      j = ((WeImageView)localObject).getLeft();
      break label108;
      label379:
      i = ((View)localObject).getWidth();
      break label197;
    }
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    Object localObject2 = null;
    AppMethodBeat.i(285722);
    s.u(paramRelativeLayout, "rootView");
    this.rootView = ((View)paramRelativeLayout);
    Object localObject1 = LayoutInflater.from(this.context).inflate(a.f.screen_avatar_navagation_layout, (ViewGroup)paramRelativeLayout);
    if (localObject1 == null)
    {
      paramRelativeLayout = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(285722);
      throw paramRelativeLayout;
    }
    this.LxL = ((RelativeLayout)localObject1);
    localObject1 = this.LxL;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.LxF = ((WeImageView)localObject1);
      localObject1 = this.LxF;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setImageDrawable(bb.m(paramRelativeLayout.getContext(), a.g.icons_filled_board, -1));
      }
      localObject1 = this.LxF;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setIconColor(-1);
      }
      localObject1 = this.LxL;
      if (localObject1 != null) {
        break label276;
      }
      localObject1 = null;
      label137:
      this.LxG = ((View)localObject1);
      localObject1 = this.LxL;
      if (localObject1 != null) {
        break label287;
      }
      localObject1 = null;
      label153:
      this.LxH = ((View)localObject1);
      localObject1 = this.LxH;
      if (localObject1 != null) {
        ((View)localObject1).setBackground(bb.m(paramRelativeLayout.getContext(), a.d.multitalk_mute_icon_background, paramRelativeLayout.getContext().getResources().getColor(a.b.Blue)));
      }
      paramRelativeLayout = this.LxH;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(4);
      }
      paramRelativeLayout = this.LxL;
      if (paramRelativeLayout != null) {
        break label298;
      }
      paramRelativeLayout = null;
      label219:
      this.LxI = paramRelativeLayout;
      paramRelativeLayout = this.LxL;
      if (paramRelativeLayout != null) {
        break label312;
      }
    }
    label276:
    label287:
    label298:
    label312:
    for (paramRelativeLayout = localObject2;; paramRelativeLayout = (WeImageView)paramRelativeLayout.findViewById(a.e.multitalk_screen_iv))
    {
      this.LxJ = paramRelativeLayout;
      paramRelativeLayout = this.LxJ;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(8);
      }
      AppMethodBeat.o(285722);
      return;
      localObject1 = (WeImageView)((RelativeLayout)localObject1).findViewById(a.e.screen_project_icon_iv);
      break;
      localObject1 = ((RelativeLayout)localObject1).findViewById(a.e.screen_project_nav_bg);
      break label137;
      localObject1 = ((RelativeLayout)localObject1).findViewById(a.e.multitalk_mute_icon_bg);
      break label153;
      paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(a.e.screen_project_nav_tv);
      break label219;
    }
  }
  
  public final void abX(int paramInt)
  {
    AppMethodBeat.i(285748);
    Log.i("MicroMsg.ScreenAvatarNavAnimatorUI", s.X("showScreenIconAvatar ", Integer.valueOf(paramInt)));
    Object localObject = this.rootView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.LxJ;
    if (localObject != null) {
      ((WeImageView)localObject).setImageDrawable(bb.m(this.context, a.g.icons_filled_board, this.context.getResources().getColor(a.b.White)));
    }
    localObject = this.LxJ;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(this.context.getResources().getColor(a.b.White));
    }
    localObject = this.LxJ;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(paramInt);
    }
    localObject = this.LxH;
    if (localObject != null) {
      ((View)localObject).setVisibility(paramInt);
    }
    localObject = this.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.LxG;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.LxI;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(285748);
  }
  
  public final void gia()
  {
    AppMethodBeat.i(285735);
    this.LxK = false;
    this.qse = new MMHandler(s.X("ScreenAvatarNavAnimatorUI_Hide", Integer.valueOf(hashCode())));
    Object localObject = this.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.LxI;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.LxG;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.LxJ;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).postUIDelayed(this.hPJ, 5000L);
    }
    AppMethodBeat.o(285735);
  }
  
  public final void gib()
  {
    AppMethodBeat.i(285759);
    Object localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.hPJ);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.LxG;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).clearAnimation();
    }
    abX(0);
    this.LxK = true;
    localObject = this.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.LxG;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.LxI;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    AppMethodBeat.o(285759);
  }
  
  public final void gic()
  {
    AppMethodBeat.i(285766);
    this.LxK = true;
    Object localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.hPJ);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.qse;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.LxG;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.LxF;
    if (localObject != null) {
      ((WeImageView)localObject).clearAnimation();
    }
    AppMethodBeat.o(285766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.c
 * JD-Core Version:    0.7.0.1
 */