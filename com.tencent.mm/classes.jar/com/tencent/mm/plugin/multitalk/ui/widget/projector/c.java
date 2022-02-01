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
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenAvatarNavAnimatorUI;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isDoAnimationEnd", "", "mContentRoot", "Landroid/widget/RelativeLayout;", "mMainIconViewBg", "Landroid/view/View;", "mScreenProjectNavTv", "Landroid/widget/TextView;", "mUiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "runnable", "Ljava/lang/Runnable;", "screenNavBg", "screenProjectIconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "screenProjectMainIconIv", "doAnimationHide", "", "getNavLayout", "reachAnimationEnd", "releaseAnimation", "showScreenAvatarNav", "showScreenIconAvatar", "visible", "", "Companion", "plugin-multitalk_release"})
public final class c
{
  public static final c.a FBJ;
  WeImageView FBC;
  View FBD;
  private View FBE;
  private TextView FBF;
  private WeImageView FBG;
  private boolean FBH;
  private RelativeLayout FBI;
  Context context;
  private Runnable fKd;
  private MMHandler ntw;
  View oFW;
  
  static
  {
    AppMethodBeat.i(199983);
    FBJ = new c.a((byte)0);
    AppMethodBeat.o(199983);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(199982);
    this.context = paramContext;
    this.fKd = ((Runnable)new c(this));
    AppMethodBeat.o(199982);
  }
  
  public final void XN(int paramInt)
  {
    AppMethodBeat.i(199977);
    Log.i("MicroMsg.ScreenAvatarNavAnimatorUI", "showScreenIconAvatar ".concat(String.valueOf(paramInt)));
    Object localObject = this.oFW;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.FBG;
    if (localObject != null) {
      ((WeImageView)localObject).setImageDrawable(au.o(this.context, a.g.icons_filled_board, this.context.getResources().getColor(a.b.White)));
    }
    localObject = this.FBG;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(this.context.getResources().getColor(a.b.White));
    }
    localObject = this.FBG;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(paramInt);
    }
    localObject = this.FBE;
    if (localObject != null) {
      ((View)localObject).setVisibility(paramInt);
    }
    localObject = this.FBC;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.FBD;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.FBF;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(199977);
      return;
    }
    AppMethodBeat.o(199977);
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    AppMethodBeat.i(199974);
    p.k(paramRelativeLayout, "rootView");
    this.oFW = ((View)paramRelativeLayout);
    Object localObject = LayoutInflater.from(this.context).inflate(a.f.screen_avatar_navagation_layout, (ViewGroup)paramRelativeLayout);
    if (localObject == null)
    {
      paramRelativeLayout = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(199974);
      throw paramRelativeLayout;
    }
    this.FBI = ((RelativeLayout)localObject);
    localObject = this.FBI;
    if (localObject != null)
    {
      localObject = (WeImageView)((RelativeLayout)localObject).findViewById(a.e.screen_project_icon_iv);
      this.FBC = ((WeImageView)localObject);
      localObject = this.FBC;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(au.o(paramRelativeLayout.getContext(), a.g.icons_filled_board, -1));
      }
      localObject = this.FBC;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(-1);
      }
      localObject = this.FBI;
      if (localObject == null) {
        break label313;
      }
      localObject = ((RelativeLayout)localObject).findViewById(a.e.screen_project_nav_bg);
      label146:
      this.FBD = ((View)localObject);
      localObject = this.FBI;
      if (localObject == null) {
        break label318;
      }
      localObject = ((RelativeLayout)localObject).findViewById(a.e.multitalk_mute_icon_bg);
      label168:
      this.FBE = ((View)localObject);
      localObject = this.FBE;
      if (localObject != null)
      {
        Context localContext = paramRelativeLayout.getContext();
        int i = a.d.multitalk_mute_icon_background;
        paramRelativeLayout = paramRelativeLayout.getContext();
        p.j(paramRelativeLayout, "rootView.context");
        ((View)localObject).setBackground(au.o(localContext, i, paramRelativeLayout.getResources().getColor(a.b.Blue)));
      }
      paramRelativeLayout = this.FBE;
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setVisibility(4);
      }
      paramRelativeLayout = this.FBI;
      if (paramRelativeLayout == null) {
        break label323;
      }
      paramRelativeLayout = (TextView)paramRelativeLayout.findViewById(a.e.screen_project_nav_tv);
      label257:
      this.FBF = paramRelativeLayout;
      paramRelativeLayout = this.FBI;
      if (paramRelativeLayout == null) {
        break label328;
      }
    }
    label313:
    label318:
    label323:
    label328:
    for (paramRelativeLayout = (WeImageView)paramRelativeLayout.findViewById(a.e.multitalk_screen_iv);; paramRelativeLayout = null)
    {
      this.FBG = paramRelativeLayout;
      paramRelativeLayout = this.FBG;
      if (paramRelativeLayout == null) {
        break label333;
      }
      paramRelativeLayout.setVisibility(8);
      AppMethodBeat.o(199974);
      return;
      localObject = null;
      break;
      localObject = null;
      break label146;
      localObject = null;
      break label168;
      paramRelativeLayout = null;
      break label257;
    }
    label333:
    AppMethodBeat.o(199974);
  }
  
  public final void eZb()
  {
    AppMethodBeat.i(199976);
    this.FBH = false;
    this.ntw = new MMHandler("ScreenAvatarNavAnimatorUI_Hide" + hashCode());
    Object localObject = this.FBC;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(0);
    }
    localObject = this.FBF;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.FBD;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.FBG;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ntw;
    if (localObject != null)
    {
      ((MMHandler)localObject).postUIDelayed(this.fKd, 5000L);
      AppMethodBeat.o(199976);
      return;
    }
    AppMethodBeat.o(199976);
  }
  
  public final void eZc()
  {
    AppMethodBeat.i(199979);
    Object localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.fKd);
    }
    localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.FBD;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.FBC;
    if (localObject != null) {
      ((WeImageView)localObject).clearAnimation();
    }
    XN(0);
    this.FBH = true;
    localObject = this.FBC;
    if (localObject != null) {
      ((WeImageView)localObject).setVisibility(8);
    }
    localObject = this.FBD;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.FBF;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(199979);
      return;
    }
    AppMethodBeat.o(199979);
  }
  
  public final void eZd()
  {
    AppMethodBeat.i(199981);
    this.FBH = true;
    Object localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacks(this.fKd);
    }
    localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.ntw;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    localObject = this.FBD;
    if (localObject != null) {
      ((View)localObject).clearAnimation();
    }
    localObject = this.FBC;
    if (localObject != null)
    {
      ((WeImageView)localObject).clearAnimation();
      AppMethodBeat.o(199981);
      return;
    }
    AppMethodBeat.o(199981);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(205743);
      Object localObject = c.a(this.FBK);
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      localObject = c.b(this.FBK);
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      localObject = c.b(this.FBK);
      if (localObject != null) {
        ((WeImageView)localObject).clearAnimation();
      }
      int k = -aw.fromDPToPix(this.FBK.context, 4);
      localObject = this.FBK.oFW;
      int j;
      label131:
      label230:
      View localView;
      if (localObject != null)
      {
        i = ((View)localObject).getWidth();
        int m = aw.fromDPToPix(this.FBK.context, 32);
        localObject = c.b(this.FBK);
        if (localObject == null) {
          break label421;
        }
        j = ((WeImageView)localObject).getLeft();
        localObject = c.b(this.FBK);
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
        localObject = this.FBK.oFW;
        if (localObject == null) {
          break label426;
        }
        i = ((View)localObject).getWidth();
        localObject = PropertyValuesHolder.ofInt("sizeW", new int[] { i, aw.fromDPToPix(this.FBK.context, 28) });
        localView = this.FBK.oFW;
        if (localView == null) {
          break label431;
        }
      }
      label421:
      label426:
      label431:
      for (int i = localView.getHeight();; i = 0)
      {
        localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, PropertyValuesHolder.ofInt("sizeH", new int[] { i, aw.fromDPToPix(this.FBK.context, 28) }), PropertyValuesHolder.ofInt("marginBottom", new int[] { 0, aw.fromDPToPix(this.FBK.context, 8) }), PropertyValuesHolder.ofInt("marginEnd", new int[] { 0, aw.fromDPToPix(this.FBK.context, 8) }) }).setDuration(300L);
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(205103);
            Object localObject1 = c.b(this.FBL.FBK);
            if (localObject1 != null) {
              ((WeImageView)localObject1).setVisibility(0);
            }
            localObject1 = c.c(this.FBL.FBK);
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject1 = c.c(this.FBL.FBK);
            if (localObject1 != null)
            {
              localObject1 = ((View)localObject1).getLayoutParams();
              if (localObject1 != null)
              {
                localObject2 = paramAnonymousValueAnimator.getAnimatedValue("sizeW");
                if (localObject2 == null)
                {
                  paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(205103);
                  throw paramAnonymousValueAnimator;
                }
                ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
              }
            }
            localObject1 = c.c(this.FBL.FBK);
            if (localObject1 != null)
            {
              localObject1 = ((View)localObject1).getLayoutParams();
              if (localObject1 != null)
              {
                localObject2 = paramAnonymousValueAnimator.getAnimatedValue("sizeH");
                if (localObject2 == null)
                {
                  paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
                  AppMethodBeat.o(205103);
                  throw paramAnonymousValueAnimator;
                }
                ((ViewGroup.LayoutParams)localObject1).height = ((Integer)localObject2).intValue();
              }
            }
            localObject1 = c.c(this.FBL.FBK);
            if (localObject1 != null) {}
            for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(205103);
              throw paramAnonymousValueAnimator;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            Object localObject2 = paramAnonymousValueAnimator.getAnimatedValue("marginBottom");
            if (localObject2 == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(205103);
              throw paramAnonymousValueAnimator;
            }
            ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((Integer)localObject2).intValue();
            localObject1 = c.c(this.FBL.FBK);
            if (localObject1 != null) {}
            for (localObject1 = ((View)localObject1).getLayoutParams(); localObject1 == null; localObject1 = null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
              AppMethodBeat.o(205103);
              throw paramAnonymousValueAnimator;
            }
            localObject1 = (RelativeLayout.LayoutParams)localObject1;
            paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue("marginEnd");
            if (paramAnonymousValueAnimator == null)
            {
              paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(205103);
              throw paramAnonymousValueAnimator;
            }
            ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(((Integer)paramAnonymousValueAnimator).intValue());
            paramAnonymousValueAnimator = c.c(this.FBL.FBK);
            if (paramAnonymousValueAnimator != null)
            {
              paramAnonymousValueAnimator.requestLayout();
              AppMethodBeat.o(205103);
              return;
            }
            AppMethodBeat.o(205103);
          }
        });
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(205743);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(196021);
      if (!c.d(this.FBK))
      {
        Object localObject1 = this.FBK;
        Object localObject2 = ((c)localObject1).FBD;
        if (localObject2 != null) {
          ((View)localObject2).clearAnimation();
        }
        localObject2 = ((c)localObject1).FBC;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setVisibility(0);
        }
        localObject2 = ((c)localObject1).FBD;
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
                  AppMethodBeat.o(196021);
                  return;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(196021);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.c
 * JD-Core Version:    0.7.0.1
 */