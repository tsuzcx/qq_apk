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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class k
  implements View.OnClickListener, t
{
  private Context context;
  private final Button gXc;
  private final Button gZv;
  public ViewGroup tbO;
  private d tbP;
  public final ViewGroup xQD;
  public final ViewGroup xQE;
  private final ImageView xQF;
  private final ImageView xQG;
  public k.a xQH;
  
  public k(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75555);
    this.tbO = paramViewGroup;
    this.tbP = paramd;
    this.xQD = ((ViewGroup)this.tbO.findViewById(2131300333));
    this.xQE = ((ViewGroup)this.tbO.findViewById(2131298862));
    this.gZv = ((Button)this.tbO.findViewById(2131298859));
    this.gXc = ((Button)this.tbO.findViewById(2131298861));
    this.xQF = ((ImageView)this.tbO.findViewById(2131298865));
    this.xQG = ((ImageView)this.tbO.findViewById(2131298864));
    this.xQH = k.a.xQK;
    this.context = this.tbO.getContext();
    paramViewGroup = this.tbO.findViewById(2131299262);
    int i = ar.en(this.tbO.getContext());
    p.g(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.xQF.setImageDrawable(ao.k(this.tbO.getContext(), 2131690493, -1));
    this.xQG.setImageDrawable(ao.k(this.tbO.getContext(), 2131690471, -1));
    this.gZv.setOnClickListener((View.OnClickListener)this);
    this.gXc.setOnClickListener((View.OnClickListener)this);
    this.xQF.setOnClickListener((View.OnClickListener)this);
    this.xQG.setOnClickListener((View.OnClickListener)this);
    dJN();
    AppMethodBeat.o(75555);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75553);
    if (this.xQH == k.a.xQI)
    {
      this.xQH = k.a.xQK;
      d.b.a(this.tbP, d.c.xVg);
      AppMethodBeat.o(75553);
      return true;
    }
    AppMethodBeat.o(75553);
    return false;
  }
  
  public final void azm() {}
  
  public final void dJN()
  {
    AppMethodBeat.i(75552);
    this.xQH = k.a.xQJ;
    ViewGroup localViewGroup = this.xQD;
    p.g(localViewGroup, "normalFuncLayout");
    localViewGroup.setVisibility(0);
    localViewGroup = this.xQE;
    p.g(localViewGroup, "cropFuncLayout");
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
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label85;
      }
      label50:
      if (paramView != null) {
        break label139;
      }
      label54:
      if (paramView != null) {
        break label200;
      }
      label58:
      if (paramView != null) {
        break label222;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75554);
      return;
      paramView = null;
      break;
      label85:
      if (paramView.intValue() != 2131298859) {
        break label50;
      }
      paramView = this.xQD;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.xQE;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.tbP, d.c.xVg);
      continue;
      label139:
      if (paramView.intValue() != 2131298861) {
        break label54;
      }
      paramView = this.xQD;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.xQE;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      this.xQH = k.a.xQJ;
      d.b.a(this.tbP, d.c.xVh);
      continue;
      label200:
      if (paramView.intValue() != 2131298865) {
        break label58;
      }
      d.b.a(this.tbP, d.c.xVj);
      continue;
      label222:
      if (paramView.intValue() == 2131298864) {
        d.b.a(this.tbP, d.c.xVi);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206575);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206575);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(75551);
    if (this.tbO.getVisibility() == paramInt)
    {
      AppMethodBeat.o(75551);
      return;
    }
    this.tbO.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, 2130771981);
      localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
      this.tbO.startAnimation(localAnimation);
      AppMethodBeat.o(75551);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130771982);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.tbO.startAnimation(localAnimation);
    AppMethodBeat.o(75551);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75546);
      p.h(paramAnimation, "animation");
      this.xQM.tbO.setVisibility(paramInt);
      AppMethodBeat.o(75546);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75547);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(75547);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75545);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(75545);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    c(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75549);
      p.h(paramAnimation, "animation");
      this.xQM.tbO.setVisibility(paramInt);
      AppMethodBeat.o(75549);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75550);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(75550);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75548);
      p.h(paramAnimation, "animation");
      AppMethodBeat.o(75548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.k
 * JD-Core Version:    0.7.0.1
 */