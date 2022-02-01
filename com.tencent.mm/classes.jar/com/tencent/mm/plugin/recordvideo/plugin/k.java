package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class k
  implements View.OnClickListener, t
{
  private Context context;
  private final Button hJg;
  private final Button hJh;
  private d vjo;
  public final ViewGroup vke;
  public final ViewGroup vkf;
  private final ImageView vkg;
  private final ImageView vkh;
  public k.a vki;
  public ViewGroup vkj;
  
  public k(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75555);
    this.vkj = paramViewGroup;
    this.vjo = paramd;
    this.vke = ((ViewGroup)this.vkj.findViewById(2131300333));
    this.vkf = ((ViewGroup)this.vkj.findViewById(2131298862));
    this.hJg = ((Button)this.vkj.findViewById(2131298859));
    this.hJh = ((Button)this.vkj.findViewById(2131298861));
    this.vkg = ((ImageView)this.vkj.findViewById(2131298865));
    this.vkh = ((ImageView)this.vkj.findViewById(2131298864));
    this.vki = k.a.vkm;
    this.context = this.vkj.getContext();
    paramViewGroup = this.vkj.findViewById(2131299262);
    int i = ap.eb(this.vkj.getContext());
    d.g.b.k.g(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.vkg.setImageDrawable(am.i(this.vkj.getContext(), 2131690493, -1));
    this.vkh.setImageDrawable(am.i(this.vkj.getContext(), 2131690471, -1));
    this.hJg.setOnClickListener((View.OnClickListener)this);
    this.hJh.setOnClickListener((View.OnClickListener)this);
    this.vkg.setOnClickListener((View.OnClickListener)this);
    this.vkh.setOnClickListener((View.OnClickListener)this);
    dio();
    AppMethodBeat.o(75555);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(75553);
    if (this.vki == k.a.vkk)
    {
      this.vki = k.a.vkm;
      d.b.a(this.vjo, d.c.vov);
      AppMethodBeat.o(75553);
      return true;
    }
    AppMethodBeat.o(75553);
    return false;
  }
  
  public final void dio()
  {
    AppMethodBeat.i(75552);
    this.vki = k.a.vkl;
    ViewGroup localViewGroup = this.vke;
    d.g.b.k.g(localViewGroup, "normalFuncLayout");
    localViewGroup.setVisibility(0);
    localViewGroup = this.vkf;
    d.g.b.k.g(localViewGroup, "cropFuncLayout");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(75552);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75554);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label44;
      }
      label21:
      if (paramView != null) {
        break label101;
      }
      label25:
      if (paramView != null) {
        break label165;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        AppMethodBeat.o(75554);
        return;
        paramView = null;
        break;
        label44:
        if (paramView.intValue() != 2131298859) {
          break label21;
        }
        paramView = this.vke;
        d.g.b.k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.vkf;
        d.g.b.k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.vjo, d.c.vov);
        AppMethodBeat.o(75554);
        return;
        label101:
        if (paramView.intValue() != 2131298861) {
          break label25;
        }
        paramView = this.vke;
        d.g.b.k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.vkf;
        d.g.b.k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        this.vki = k.a.vkl;
        d.b.a(this.vjo, d.c.vow);
        AppMethodBeat.o(75554);
        return;
        label165:
        if (paramView.intValue() == 2131298865)
        {
          d.b.a(this.vjo, d.c.voy);
          AppMethodBeat.o(75554);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131298864) {
      d.b.a(this.vjo, d.c.vox);
    }
    AppMethodBeat.o(75554);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(75551);
    if (this.vkj.getVisibility() == paramInt)
    {
      AppMethodBeat.o(75551);
      return;
    }
    this.vkj.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, 2130771981);
      localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
      this.vkj.startAnimation(localAnimation);
      AppMethodBeat.o(75551);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130771982);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.vkj.startAnimation(localAnimation);
    AppMethodBeat.o(75551);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75546);
      d.g.b.k.h(paramAnimation, "animation");
      this.vko.vkj.setVisibility(paramInt);
      AppMethodBeat.o(75546);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75547);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(75547);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75545);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(75545);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    c(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75549);
      d.g.b.k.h(paramAnimation, "animation");
      this.vko.vkj.setVisibility(paramInt);
      AppMethodBeat.o(75549);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75550);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(75550);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75548);
      d.g.b.k.h(paramAnimation, "animation");
      AppMethodBeat.o(75548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.k
 * JD-Core Version:    0.7.0.1
 */