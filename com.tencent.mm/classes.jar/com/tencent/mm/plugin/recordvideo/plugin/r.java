package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, t
{
  private final Button gAJ;
  private final Button gCY;
  private ViewGroup rTS;
  private d rTT;
  private final ViewGroup wsI;
  private final ViewGroup wsJ;
  private final ImageView wsK;
  private final ImageView wsL;
  private r.a wtd;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.rTS = paramViewGroup;
    this.rTT = paramd;
    this.wsI = ((ViewGroup)this.rTS.findViewById(2131300333));
    this.wsJ = ((ViewGroup)this.rTS.findViewById(2131298862));
    this.gCY = ((Button)this.rTS.findViewById(2131298859));
    this.gAJ = ((Button)this.rTS.findViewById(2131298861));
    this.wsK = ((ImageView)this.rTS.findViewById(2131298865));
    this.wsL = ((ImageView)this.rTS.findViewById(2131298864));
    this.wtd = r.a.wtg;
    paramViewGroup = this.wsJ;
    k.g(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    paramViewGroup = this.rTS.findViewById(2131299262);
    int i = ap.ej(this.rTS.getContext());
    k.g(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.wsK.setImageDrawable(am.k(this.rTS.getContext(), 2131691345, -1));
    this.wsL.setImageDrawable(am.k(this.rTS.getContext(), 2131690467, -1));
    this.gCY.setOnClickListener((View.OnClickListener)this);
    this.gAJ.setOnClickListener((View.OnClickListener)this);
    this.wsK.setOnClickListener((View.OnClickListener)this);
    this.wsL.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final boolean alO()
  {
    AppMethodBeat.i(75583);
    if (this.wtd == r.a.wte)
    {
      d.b.a(this.rTT, d.c.wxc);
      AppMethodBeat.o(75583);
      return true;
    }
    AppMethodBeat.o(75583);
    return false;
  }
  
  public final void awk() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75584);
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
        AppMethodBeat.o(75584);
        return;
        paramView = null;
        break;
        label44:
        if (paramView.intValue() != 2131298859) {
          break label21;
        }
        paramView = this.wsI;
        k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.wsJ;
        k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.rTT, d.c.wxc);
        AppMethodBeat.o(75584);
        return;
        label101:
        if (paramView.intValue() != 2131298861) {
          break label25;
        }
        paramView = this.wsI;
        k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.wsJ;
        k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.rTT, d.c.wxd);
        AppMethodBeat.o(75584);
        return;
        label158:
        if (paramView.intValue() == 2131298865)
        {
          d.b.a(this.rTT, d.c.wxf);
          AppMethodBeat.o(75584);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131298864) {
      d.b.a(this.rTT, d.c.wxe);
    }
    AppMethodBeat.o(75584);
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.rTS.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */