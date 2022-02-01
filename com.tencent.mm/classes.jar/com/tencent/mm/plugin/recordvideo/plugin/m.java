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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "getOkBtn", "()Landroid/widget/Button;", "rotateImg", "Landroid/widget/ImageView;", "getRotateImg", "()Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getUnDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  public ViewGroup NKm;
  public final ViewGroup NKn;
  public final ViewGroup NKo;
  public final ImageView NKp;
  public final ImageView NKq;
  public m.a NKr;
  private Context context;
  public final Button nhC;
  private final Button njI;
  
  public m(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75555);
    this.NKm = paramViewGroup;
    this.GrC = parama;
    this.NKn = ((ViewGroup)this.NKm.findViewById(b.e.func_layout));
    this.NKo = ((ViewGroup)this.NKm.findViewById(b.e.crop_func_layout));
    this.njI = ((Button)this.NKm.findViewById(b.e.crop_cancel));
    this.nhC = ((Button)this.NKm.findViewById(b.e.crop_finish));
    this.NKp = ((ImageView)this.NKm.findViewById(b.e.crop_undo));
    this.NKq = ((ImageView)this.NKm.findViewById(b.e.crop_rotate));
    this.NKr = m.a.NKu;
    this.context = this.NKm.getContext();
    paramViewGroup = this.NKm.findViewById(b.e.edit_root);
    paramViewGroup.setPadding(0, 0, 0, bf.bk(this.NKm.getContext()) + paramViewGroup.getPaddingBottom());
    this.NKp.setImageDrawable(bb.m(this.NKm.getContext(), b.g.icons_filled_undo, -1));
    this.NKq.setImageDrawable(bb.m(this.NKm.getContext(), b.g.icons_filled_rotate, -1));
    this.njI.setOnClickListener((View.OnClickListener)this);
    this.nhC.setOnClickListener((View.OnClickListener)this);
    this.NKp.setOnClickListener((View.OnClickListener)this);
    this.NKq.setOnClickListener((View.OnClickListener)this);
    gIC();
    AppMethodBeat.o(75555);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280902);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280902);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280924);
    s.u(this, "this");
    AppMethodBeat.o(280924);
  }
  
  public final void gIC()
  {
    AppMethodBeat.i(75552);
    this.NKr = m.a.NKt;
    this.NKn.setVisibility(0);
    this.NKo.setVisibility(4);
    AppMethodBeat.o(75552);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280908);
    String str = v.a.b(this);
    AppMethodBeat.o(280908);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280914);
    s.u(this, "this");
    AppMethodBeat.o(280914);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75553);
    if (this.NKr == m.a.NKs)
    {
      this.NKr = m.a.NKu;
      a.b.a(this.GrC, a.c.NPi);
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
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.e.crop_cancel;
      if (paramView != null) {
        break label111;
      }
      label53:
      i = b.e.crop_finish;
      if (paramView != null) {
        break label148;
      }
      label61:
      i = b.e.crop_undo;
      if (paramView != null) {
        break label192;
      }
      label69:
      i = b.e.crop_rotate;
      if (paramView != null) {
        break label213;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75554);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label111:
      if (paramView.intValue() != i) {
        break label53;
      }
      this.NKn.setVisibility(0);
      this.NKo.setVisibility(4);
      a.b.a(this.GrC, a.c.NPi);
      continue;
      label148:
      if (paramView.intValue() != i) {
        break label61;
      }
      this.NKn.setVisibility(0);
      this.NKo.setVisibility(4);
      this.NKr = m.a.NKt;
      a.b.a(this.GrC, a.c.NPj);
      continue;
      label192:
      if (paramView.intValue() != i) {
        break label69;
      }
      a.b.a(this.GrC, a.c.NPl);
      continue;
      label213:
      if (paramView.intValue() == i)
      {
        a.b.a(this.GrC, a.c.NPk);
        this.NKq.announceForAccessibility((CharSequence)com.tencent.mm.cd.a.bt(this.NKm.getContext(), b.h.aging_rotate_click));
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280929);
    s.u(this, "this");
    AppMethodBeat.o(280929);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280932);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280932);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset()
  {
    AppMethodBeat.i(280936);
    s.u(this, "this");
    AppMethodBeat.o(280936);
  }
  
  public final void setVisibility(final int paramInt)
  {
    AppMethodBeat.i(75551);
    if (this.NKm.getVisibility() == paramInt)
    {
      AppMethodBeat.o(75551);
      return;
    }
    this.NKm.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, b.a.alpha_in);
      localAnimation.setAnimationListener((Animation.AnimationListener)new b(this, paramInt));
      this.NKm.startAnimation(localAnimation);
      AppMethodBeat.o(75551);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, b.a.alpha_out);
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this, paramInt));
    this.NKm.startAnimation(localAnimation);
    AppMethodBeat.o(75551);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animation.AnimationListener
  {
    b(m paramm, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75546);
      s.u(paramAnimation, "animation");
      this.NKw.NKm.setVisibility(paramInt);
      AppMethodBeat.o(75546);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75547);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(75547);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75545);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(75545);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$setVisibility$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animation.AnimationListener
  {
    c(m paramm, int paramInt) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(75549);
      s.u(paramAnimation, "animation");
      this.NKw.NKm.setVisibility(paramInt);
      AppMethodBeat.o(75549);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation)
    {
      AppMethodBeat.i(75550);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(75550);
    }
    
    public final void onAnimationStart(Animation paramAnimation)
    {
      AppMethodBeat.i(75548);
      s.u(paramAnimation, "animation");
      AppMethodBeat.o(75548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.m
 * JD-Core Version:    0.7.0.1
 */