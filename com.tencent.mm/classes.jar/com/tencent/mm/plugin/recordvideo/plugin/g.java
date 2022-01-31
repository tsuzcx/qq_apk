package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.content.Context;
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
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class g
  implements View.OnClickListener, q
{
  private Context context;
  private final Button gtF;
  private final Button jIG;
  private d qbI;
  public final ViewGroup qcb;
  public final ViewGroup qcc;
  private final ImageView qcd;
  private final ImageView qce;
  public g.a qcf;
  public ViewGroup qcg;
  
  public g(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150644);
    this.qcg = paramViewGroup;
    this.qbI = paramd;
    this.qcb = ((ViewGroup)this.qcg.findViewById(2131828698));
    this.qcc = ((ViewGroup)this.qcg.findViewById(2131828708));
    this.jIG = ((Button)this.qcg.findViewById(2131828709));
    this.gtF = ((Button)this.qcg.findViewById(2131828712));
    this.qcd = ((ImageView)this.qcg.findViewById(2131828710));
    this.qce = ((ImageView)this.qcg.findViewById(2131828711));
    this.qcf = g.a.qcj;
    this.context = this.qcg.getContext();
    paramViewGroup = this.qcg.findViewById(2131828696);
    int i = am.fx(this.qcg.getContext());
    j.p(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.qcd.setImageDrawable(aj.g(this.qcg.getContext(), 2131231478, -1));
    this.qce.setImageDrawable(aj.g(this.qcg.getContext(), 2131231473, -1));
    this.jIG.setOnClickListener((View.OnClickListener)this);
    this.gtF.setOnClickListener((View.OnClickListener)this);
    this.qcd.setOnClickListener((View.OnClickListener)this);
    this.qce.setOnClickListener((View.OnClickListener)this);
    cgx();
    AppMethodBeat.o(150644);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150642);
    if (this.qcf == g.a.qch)
    {
      this.qcf = g.a.qcj;
      d.b.a(this.qbI, d.c.qfb);
      AppMethodBeat.o(150642);
      return true;
    }
    AppMethodBeat.o(150642);
    return false;
  }
  
  public final void cgx()
  {
    AppMethodBeat.i(150641);
    this.qcf = g.a.qci;
    ViewGroup localViewGroup = this.qcb;
    j.p(localViewGroup, "normalFuncLayout");
    localViewGroup.setVisibility(0);
    localViewGroup = this.qcc;
    j.p(localViewGroup, "cropFuncLayout");
    localViewGroup.setVisibility(4);
    AppMethodBeat.o(150641);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150643);
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
        AppMethodBeat.o(150643);
        return;
        paramView = null;
        break;
        label44:
        if (paramView.intValue() != 2131828709) {
          break label21;
        }
        paramView = this.qcb;
        j.p(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.qcc;
        j.p(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.qbI, d.c.qfb);
        AppMethodBeat.o(150643);
        return;
        label101:
        if (paramView.intValue() != 2131828712) {
          break label25;
        }
        paramView = this.qcb;
        j.p(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.qcc;
        j.p(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        this.qcf = g.a.qci;
        d.b.a(this.qbI, d.c.qfc);
        AppMethodBeat.o(150643);
        return;
        label165:
        if (paramView.intValue() == 2131828710)
        {
          d.b.a(this.qbI, d.c.qfe);
          AppMethodBeat.o(150643);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131828711) {
      d.b.a(this.qbI, d.c.qfd);
    }
    AppMethodBeat.o(150643);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150640);
    if (this.qcg.getVisibility() == paramInt)
    {
      AppMethodBeat.o(150640);
      return;
    }
    this.qcg.clearAnimation();
    if (paramInt == 0)
    {
      localAnimation = AnimationUtils.loadAnimation(this.context, 2131034125);
      localAnimation.setAnimationListener((Animation.AnimationListener)new g.b(this, paramInt));
      this.qcg.startAnimation(localAnimation);
      AppMethodBeat.o(150640);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2131034126);
    localAnimation.setAnimationListener((Animation.AnimationListener)new g.c(this, paramInt));
    this.qcg.startAnimation(localAnimation);
    AppMethodBeat.o(150640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.g
 * JD-Core Version:    0.7.0.1
 */