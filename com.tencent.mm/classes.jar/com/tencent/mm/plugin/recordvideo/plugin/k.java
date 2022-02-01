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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class k
  implements View.OnClickListener, t
{
  public final ViewGroup BQB;
  public final ViewGroup BQC;
  private final ImageView BQD;
  private final ImageView BQE;
  public k.a BQF;
  private Context context;
  private final Button hPX;
  private final Button hSq;
  public ViewGroup wgR;
  private d wgr;
  
  public k(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75555);
    this.wgR = paramViewGroup;
    this.wgr = paramd;
    this.BQB = ((ViewGroup)this.wgR.findViewById(2131301849));
    this.BQC = ((ViewGroup)this.wgR.findViewById(2131299334));
    this.hSq = ((Button)this.wgR.findViewById(2131299331));
    this.hPX = ((Button)this.wgR.findViewById(2131299333));
    this.BQD = ((ImageView)this.wgR.findViewById(2131299338));
    this.BQE = ((ImageView)this.wgR.findViewById(2131299337));
    this.BQF = k.a.BQI;
    this.context = this.wgR.getContext();
    paramViewGroup = this.wgR.findViewById(2131299839);
    int i = au.aD(this.wgR.getContext());
    p.g(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.BQD.setImageDrawable(ar.m(this.wgR.getContext(), 2131690701, -1));
    this.BQE.setImageDrawable(ar.m(this.wgR.getContext(), 2131690666, -1));
    this.hSq.setOnClickListener((View.OnClickListener)this);
    this.hPX.setOnClickListener((View.OnClickListener)this);
    this.BQD.setOnClickListener((View.OnClickListener)this);
    this.BQE.setOnClickListener((View.OnClickListener)this);
    eKC();
    AppMethodBeat.o(75555);
  }
  
  public final void aSs() {}
  
  public final void eKC()
  {
    AppMethodBeat.i(75552);
    this.BQF = k.a.BQH;
    ViewGroup localViewGroup = this.BQB;
    p.g(localViewGroup, "normalFuncLayout");
    localViewGroup.setVisibility(0);
    localViewGroup = this.BQC;
    p.g(localViewGroup, "cropFuncLayout");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(75552);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75553);
    if (this.BQF == k.a.BQG)
    {
      this.BQF = k.a.BQI;
      d.b.a(this.wgr, d.c.BVO);
      AppMethodBeat.o(75553);
      return true;
    }
    AppMethodBeat.o(75553);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75554);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      if (paramView.intValue() != 2131299331) {
        break label50;
      }
      paramView = this.BQB;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.BQC;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.wgr, d.c.BVO);
      continue;
      label139:
      if (paramView.intValue() != 2131299333) {
        break label54;
      }
      paramView = this.BQB;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.BQC;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      this.BQF = k.a.BQH;
      d.b.a(this.wgr, d.c.BVP);
      continue;
      label200:
      if (paramView.intValue() != 2131299338) {
        break label58;
      }
      d.b.a(this.wgr, d.c.BVR);
      continue;
      label222:
      if (paramView.intValue() == 2131299337) {
        d.b.a(this.wgr, d.c.BVQ);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237291);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237291);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(75551);
    if (this.wgR.getVisibility() == paramInt)
    {
      AppMethodBeat.o(75551);
      return;
    }
    this.wgR.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, 2130771981);
      localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
      this.wgR.startAnimation(localAnimation);
      AppMethodBeat.o(75551);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130771982);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.wgR.startAnimation(localAnimation);
    AppMethodBeat.o(75551);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75546);
      p.h(paramAnimation, "animation");
      this.BQK.wgR.setVisibility(paramInt);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    c(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75549);
      p.h(paramAnimation, "animation");
      this.BQK.wgR.setVisibility(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.k
 * JD-Core Version:    0.7.0.1
 */