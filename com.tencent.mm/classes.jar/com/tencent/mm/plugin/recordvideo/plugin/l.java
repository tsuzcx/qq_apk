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
import com.tencent.mm.plugin.recordvideo.b.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "getOkBtn", "()Landroid/widget/Button;", "rotateImg", "Landroid/widget/ImageView;", "getRotateImg", "()Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getUnDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class l
  implements View.OnClickListener, u
{
  private d APl;
  public ViewGroup AQv;
  public final ViewGroup HNr;
  public final ViewGroup HNs;
  public final ImageView HNt;
  public final ImageView HNu;
  public l.a HNv;
  private Context context;
  public final Button kEt;
  private final Button kGN;
  
  public l(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75555);
    this.AQv = paramViewGroup;
    this.APl = paramd;
    this.HNr = ((ViewGroup)this.AQv.findViewById(b.e.func_layout));
    this.HNs = ((ViewGroup)this.AQv.findViewById(b.e.crop_func_layout));
    this.kGN = ((Button)this.AQv.findViewById(b.e.crop_cancel));
    this.kEt = ((Button)this.AQv.findViewById(b.e.crop_finish));
    this.HNt = ((ImageView)this.AQv.findViewById(b.e.crop_undo));
    this.HNu = ((ImageView)this.AQv.findViewById(b.e.crop_rotate));
    this.HNv = l.a.HNy;
    this.context = this.AQv.getContext();
    paramViewGroup = this.AQv.findViewById(b.e.edit_root);
    int i = ax.aB(this.AQv.getContext());
    p.j(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.HNt.setImageDrawable(au.o(this.AQv.getContext(), b.g.icons_filled_undo, -1));
    this.HNu.setImageDrawable(au.o(this.AQv.getContext(), b.g.icons_filled_rotate, -1));
    this.kGN.setOnClickListener((View.OnClickListener)this);
    this.kEt.setOnClickListener((View.OnClickListener)this);
    this.HNt.setOnClickListener((View.OnClickListener)this);
    this.HNu.setOnClickListener((View.OnClickListener)this);
    fwU();
    AppMethodBeat.o(75555);
  }
  
  public final void bbp() {}
  
  public final void fwU()
  {
    AppMethodBeat.i(75552);
    this.HNv = l.a.HNx;
    ViewGroup localViewGroup = this.HNr;
    p.j(localViewGroup, "normalFuncLayout");
    localViewGroup.setVisibility(0);
    localViewGroup = this.HNs;
    p.j(localViewGroup, "cropFuncLayout");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(75552);
  }
  
  public final String name()
  {
    AppMethodBeat.i(216347);
    String str = getClass().getName();
    AppMethodBeat.o(216347);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75553);
    if (this.HNv == l.a.HNw)
    {
      this.HNv = l.a.HNy;
      d.b.a(this.APl, d.c.HSC);
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
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.e.crop_cancel;
      if (paramView != null) {
        break label109;
      }
      label58:
      i = b.e.crop_finish;
      if (paramView != null) {
        break label162;
      }
      label66:
      i = b.e.crop_undo;
      if (paramView != null) {
        break label222;
      }
      label74:
      i = b.e.crop_rotate;
      if (paramView != null) {
        break label243;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75554);
      return;
      paramView = null;
      break;
      label109:
      if (paramView.intValue() != i) {
        break label58;
      }
      paramView = this.HNr;
      p.j(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.HNs;
      p.j(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.APl, d.c.HSC);
      continue;
      label162:
      if (paramView.intValue() != i) {
        break label66;
      }
      paramView = this.HNr;
      p.j(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.HNs;
      p.j(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      this.HNv = l.a.HNx;
      d.b.a(this.APl, d.c.HSD);
      continue;
      label222:
      if (paramView.intValue() != i) {
        break label74;
      }
      d.b.a(this.APl, d.c.HSF);
      continue;
      label243:
      if (paramView.intValue() == i) {
        d.b.a(this.APl, d.c.HSE);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216350);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(216350);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(75551);
    if (this.AQv.getVisibility() == paramInt)
    {
      AppMethodBeat.o(75551);
      return;
    }
    this.AQv.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, b.a.alpha_in);
      localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
      this.AQv.startAnimation(localAnimation);
      AppMethodBeat.o(75551);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, b.a.alpha_out);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.AQv.startAnimation(localAnimation);
    AppMethodBeat.o(75551);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class b
    implements Animation.AnimationListener
  {
    b(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75546);
      p.k(paramAnimation, "animation");
      this.HNA.AQv.setVisibility(paramInt);
      AppMethodBeat.o(75546);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75547);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(75547);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75545);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(75545);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"})
  public static final class c
    implements Animation.AnimationListener
  {
    c(int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75549);
      p.k(paramAnimation, "animation");
      this.HNA.AQv.setVisibility(paramInt);
      AppMethodBeat.o(75549);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75550);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(75550);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75548);
      p.k(paramAnimation, "animation");
      AppMethodBeat.o(75548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.l
 * JD-Core Version:    0.7.0.1
 */