package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isDoAnimationEnd", "", "mContentRoot", "Landroid/widget/RelativeLayout;", "mMainIconViewBg", "Landroid/view/View;", "mScreenProjectNavTv", "Landroid/widget/TextView;", "mUiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "runnable", "Ljava/lang/Runnable;", "screenNavBg", "screenProjectIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "screenProjectMainIconIv", "doAnimationHide", "", "getNavLayout", "reachAnimationEnd", "releaseAnimation", "showScreenAvatarNav", "showScreenIconAvatar", "visible", "", "Companion", "plugin-multitalk_release"})
public final class c
{
  public static final c.a zVZ;
  Context context;
  private Runnable dQN;
  private MMHandler kAn;
  View lJI;
  WeImageView zVS;
  View zVT;
  private View zVU;
  private TextView zVV;
  private WeImageView zVW;
  private boolean zVX;
  private RelativeLayout zVY;
  
  static
  {
    AppMethodBeat.i(239918);
    zVZ = new c.a((byte)0);
    AppMethodBeat.o(239918);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(239917);
    this.context = paramContext;
    this.dQN = ((Runnable)new c(this));
    AppMethodBeat.o(239917);
  }
  
  public final void Rw(int paramInt)
  {
    AppMethodBeat.i(239914);
    Log.i("MicroMsg.ScreenAvatarNavAnimatorUI", "showScreenIconAvatar ".concat(String.valueOf(paramInt)));
    Object localObject = this.lJI;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.zVW;
    if (localObject != null) {
      ((WeImageView)localObject).setImageDrawable(ar.m(this.context, 2131690496, this.context.getResources().getColor(2131099844)));
    }
    localObject = this.zVW;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(this.context.getResources().getColor(2131099844));
    }
    localObject = this.zVW;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(paramInt);
    }
    localObject = this.zVU;
    if (localObject != null) {
      ((View)localObject).setVisibility(paramInt);
    }
    localObject = this.zVS;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.zVT;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.zVV;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(239914);
      return;
    }
    AppMethodBeat.o(239914);
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(239912);
    p.h(paramRelativeLayout, "rootView");
    this.lJI = ((View)paramRelativeLayout);
    Object localObject = LayoutInflater.from(this.context).inflate(2131496159, (ViewGroup)paramRelativeLayout);
    if (localObject == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(239912);
      throw paramRelativeLayout;
    }
    this.zVY = ((RelativeLayout)localObject);
    localObject = this.zVY;
    if (localObject != null)
    {
      localObject = (WeImageView)((RelativeLayout)localObject).findViewById(2131307312);
      this.zVS = ((WeImageView)localObject);
      localObject = this.zVS;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(ar.m(paramRelativeLayout.getContext(), 2131690496, -1));
      }
      localObject = this.zVS;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(-1);
      }
      localObject = this.zVY;
      if (localObject == null) {
        break label300;
      }
      localObject = ((RelativeLayout)localObject).findViewById(2131307313);
      label142:
      this.zVT = ((View)localObject);
      localObject = this.zVY;
      if (localObject == null) {
        break label305;
      }
      localObject = ((RelativeLayout)localObject).findViewById(2131305045);
      label163:
      this.zVU = ((View)localObject);
      localObject = this.zVU;
      if (localObject != null)
      {
        Context localContext = paramRelativeLayout.getContext();
        paramRelativeLayout = paramRelativeLayout.getContext();
        p.g(paramRelativeLayout, "rootView.context");
        ((View)localObject).setBackground(ar.m(localContext, 2131234075, paramRelativeLayout.getResources().getColor(2131099700)));
      }
      paramRelativeLayout = this.zVU;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(4);
      }
      paramRelativeLayout = this.zVY;
      if (paramRelativeLayout == null) {
        break label310;
      }
      paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(2131307314);
      label245:
      this.zVV = paramRelativeLayout;
      paramRelativeLayout = this.zVY;
      if (paramRelativeLayout == null) {
        break label315;
      }
    }
    label300:
    label305:
    label310:
    label315:
    for (paramRelativeLayout = (WeImageView)paramRelativeLayout.findViewById(2131305051);; paramRelativeLayout = null)
    {
      this.zVW = paramRelativeLayout;
      paramRelativeLayout = this.zVW;
      if (paramRelativeLayout == null) {
        break label320;
      }
      paramRelativeLayout.setVisibility(8);
      AppMethodBeat.o(239912);
      return;
      localObject = null;
      break;
      localObject = null;
      break label142;
      localObject = null;
      break label163;
      paramRelativeLayout = null;
      break label245;
    }
    label320:
    AppMethodBeat.o(239912);
  }
  
  public final void epl()
  {
    AppMethodBeat.i(239913);
    this.zVX = false;
    this.kAn = new MMHandler("ScreenAvatarNavAnimatorUI_Hide" + hashCode());
    Object localObject = this.zVS;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.zVV;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.zVT;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.zVW;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.kAn;
    if (localObject != null)
    {
      ((MMHandler)localObject).postUIDelayed(this.dQN, 5000L);
      AppMethodBeat.o(239913);
      return;
    }
    AppMethodBeat.o(239913);
  }
  
  public final void epm()
  {
    AppMethodBeat.i(239915);
    Object localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.dQN);
    }
    localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.zVT;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.zVS;
    if (localObject != null) {
      ((WeImageView)localObject).clearAnimation();
    }
    Rw(0);
    this.zVX = true;
    localObject = this.zVS;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.zVT;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.zVV;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(239915);
      return;
    }
    AppMethodBeat.o(239915);
  }
  
  public final void epn()
  {
    AppMethodBeat.i(239916);
    this.zVX = true;
    Object localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.dQN);
    }
    localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.kAn;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.zVT;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.zVS;
    if (localObject != null)
    {
      ((WeImageView)localObject).clearAnimation();
      AppMethodBeat.o(239916);
      return;
    }
    AppMethodBeat.o(239916);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(239910);
      Object localObject = c.a(this.zWa);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      localObject = c.b(this.zWa);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = c.b(this.zWa);
      if (localObject != null) {
        ((WeImageView)localObject).clearAnimation();
      }
      int k = -at.fromDPToPix(this.zWa.context, 4);
      localObject = this.zWa.lJI;
      int j;
      label131:
      label230:
      View localView;
      if (localObject != null)
      {
        i = ((View)localObject).getWidth();
        int m = at.fromDPToPix(this.zWa.context, 32);
        localObject = c.b(this.zWa);
        if (localObject == null) {
          break label421;
        }
        j = ((WeImageView)localObject).getLeft();
        localObject = c.b(this.zWa);
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
        localObject = this.zWa.lJI;
        if (localObject == null) {
          break label426;
        }
        i = ((View)localObject).getWidth();
        localObject = PropertyValuesHolder.ofInt("sizeW", new int[] { i, at.fromDPToPix(this.zWa.context, 28) });
        localView = this.zWa.lJI;
        if (localView == null) {
          break label431;
        }
      }
      label421:
      label426:
      label431:
      for (int i = localView.getHeight();; i = 0)
      {
        localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, PropertyValuesHolder.ofInt("sizeH", new int[] { i, at.fromDPToPix(this.zWa.context, 28) }), PropertyValuesHolder.ofInt("marginBottom", new int[] { 0, at.fromDPToPix(this.zWa.context, 8) }), PropertyValuesHolder.ofInt("marginEnd", new int[] { 0, at.fromDPToPix(this.zWa.context, 8) }) }).setDuration(300L);
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(239909);
            Object localObject1 = c.b(this.zWb.zWa);
            if (localObject1 != null) {
              ((WeImageView)localObject1).setVisibility(0);
            }
            localObject1 = c.c(this.zWb.zWa);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject1 = c.c(this.zWb.zWa);
            if (localObject1 != null)
            {
              localObject1 = ((View)localObject1).getLayoutParams();
              if (localObject1 != null)
              {
                localObject2 = paramAnonymousValueAnimator.getAnimatedValue("sizeW");
                if (localObject2 == null)
                {
                  paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(239909);
                  throw paramAnonymousValueAnimator;
                }
                ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
              }
            }
            localObject1 = c.c(this.zWb.zWa);
            if (localObject1 != null)
            {
              localObject1 = ((View)localObject1).getLayoutParams();
              if (localObject1 != null)
              {
                localObject2 = paramAnonymousValueAnimator.getAnimatedValue("sizeH");
                if (localObject2 == null)
                {
                  paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(239909);
                  throw paramAnonymousValueAnimator;
                }
                ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
              }
            }
            localObject1 = c.c(this.zWb.zWa);
            if (localObject1 != null) {}
            for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(239909);
              throw paramAnonymousValueAnimator;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            Object localObject2 = paramAnonymousValueAnimator.getAnimatedValue("marginBottom");
            if (localObject2 == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(239909);
              throw paramAnonymousValueAnimator;
            }
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((Integer)localObject2).intValue();
            localObject1 = c.c(this.zWb.zWa);
            if (localObject1 != null) {}
            for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(239909);
              throw paramAnonymousValueAnimator;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue("marginEnd");
            if (paramAnonymousValueAnimator == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(239909);
              throw paramAnonymousValueAnimator;
            }
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(((Integer)paramAnonymousValueAnimator).intValue());
            paramAnonymousValueAnimator = c.c(this.zWb.zWa);
            if (paramAnonymousValueAnimator != null)
            {
              paramAnonymousValueAnimator.requestLayout();
              AppMethodBeat.o(239909);
              return;
            }
            AppMethodBeat.o(239909);
          }
        });
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(239910);
        return;
        i = 0;
        break;
        j = 0;
        break label131;
        i = 0;
        break label230;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(239911);
      if (!c.d(this.zWa))
      {
        Object localObject1 = this.zWa;
        Object localObject2 = ((c)localObject1).zVT;
        if (localObject2 != null) {
          ((View)localObject2).clearAnimation();
        }
        localObject2 = ((c)localObject1).zVS;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setVisibility(0);
        }
        localObject2 = ((c)localObject1).zVT;
        if (localObject2 != null)
        {
          localObject2 = ((View)localObject2).animate();
          if (localObject2 != null)
          {
            localObject2 = ((ViewPropertyAnimator)localObject2).alpha(0.0F);
            if (localObject2 != null)
            {
              localObject2 = ((ViewPropertyAnimator)localObject2).setDuration(100L);
              if (localObject2 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject2).withStartAction((Runnable)new c.b((c)localObject1));
                if (localObject1 != null)
                {
                  ((ViewPropertyAnimator)localObject1).start();
                  AppMethodBeat.o(239911);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(239911);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.c
 * JD-Core Version:    0.7.0.1
 */