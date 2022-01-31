package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class n
  implements View.OnClickListener, q
{
  private final Button gtF;
  private final Button jIG;
  private d qbI;
  private final ViewGroup qcb;
  private final ViewGroup qcc;
  private final ImageView qcd;
  private final ImageView qce;
  private ViewGroup qcg;
  private n.a qcu;
  
  public n(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(150671);
    this.qcg = paramViewGroup;
    this.qbI = paramd;
    this.qcb = ((ViewGroup)this.qcg.findViewById(2131828698));
    this.qcc = ((ViewGroup)this.qcg.findViewById(2131828708));
    this.jIG = ((Button)this.qcg.findViewById(2131828709));
    this.gtF = ((Button)this.qcg.findViewById(2131828712));
    this.qcd = ((ImageView)this.qcg.findViewById(2131828710));
    this.qce = ((ImageView)this.qcg.findViewById(2131828711));
    this.qcu = n.a.qcx;
    paramViewGroup = this.qcc;
    j.p(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    paramViewGroup = this.qcg.findViewById(2131828696);
    int i = am.fx(this.qcg.getContext());
    j.p(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.qcd.setImageDrawable(aj.g(this.qcg.getContext(), 2131232143, -1));
    this.qce.setImageDrawable(aj.g(this.qcg.getContext(), 2131231471, -1));
    this.jIG.setOnClickListener((View.OnClickListener)this);
    this.gtF.setOnClickListener((View.OnClickListener)this);
    this.qcd.setOnClickListener((View.OnClickListener)this);
    this.qce.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(150671);
  }
  
  public final boolean cgq()
  {
    AppMethodBeat.i(150669);
    if (this.qcu == n.a.qcv)
    {
      d.b.a(this.qbI, d.c.qfb);
      AppMethodBeat.o(150669);
      return true;
    }
    AppMethodBeat.o(150669);
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(150670);
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
        break label158;
      }
    }
    for (;;)
    {
      if (paramView == null)
      {
        AppMethodBeat.o(150670);
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
        AppMethodBeat.o(150670);
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
        d.b.a(this.qbI, d.c.qfc);
        AppMethodBeat.o(150670);
        return;
        label158:
        if (paramView.intValue() == 2131828710)
        {
          d.b.a(this.qbI, d.c.qfe);
          AppMethodBeat.o(150670);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131828711) {
      d.b.a(this.qbI, d.c.qfd);
    }
    AppMethodBeat.o(150670);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(150668);
    this.qcg.setVisibility(paramInt);
    AppMethodBeat.o(150668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.n
 * JD-Core Version:    0.7.0.1
 */