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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "gotoControlFunc", "", "gotoCropFunc", "onBackPress", "", "onClick", "v", "Landroid/view/View;", "onPause", "onResume", "release", "setVisibility", "visible", "", "FuncType", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, t
{
  private final Button hJg;
  private final Button hJh;
  private d vjo;
  private r.a vkB;
  private final ViewGroup vke;
  private final ViewGroup vkf;
  private final ImageView vkg;
  private final ImageView vkh;
  private ViewGroup vkj;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.vkj = paramViewGroup;
    this.vjo = paramd;
    this.vke = ((ViewGroup)this.vkj.findViewById(2131300333));
    this.vkf = ((ViewGroup)this.vkj.findViewById(2131298862));
    this.hJg = ((Button)this.vkj.findViewById(2131298859));
    this.hJh = ((Button)this.vkj.findViewById(2131298861));
    this.vkg = ((ImageView)this.vkj.findViewById(2131298865));
    this.vkh = ((ImageView)this.vkj.findViewById(2131298864));
    this.vkB = r.a.vkE;
    paramViewGroup = this.vkf;
    k.g(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    paramViewGroup = this.vkj.findViewById(2131299262);
    int i = ap.eb(this.vkj.getContext());
    k.g(paramViewGroup, "root");
    paramViewGroup.setPadding(0, 0, 0, i + paramViewGroup.getPaddingBottom());
    this.vkg.setImageDrawable(am.i(this.vkj.getContext(), 2131691345, -1));
    this.vkh.setImageDrawable(am.i(this.vkj.getContext(), 2131690467, -1));
    this.hJg.setOnClickListener((View.OnClickListener)this);
    this.hJh.setOnClickListener((View.OnClickListener)this);
    this.vkg.setOnClickListener((View.OnClickListener)this);
    this.vkh.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    AppMethodBeat.i(75583);
    if (this.vkB == r.a.vkC)
    {
      d.b.a(this.vjo, d.c.vov);
      AppMethodBeat.o(75583);
      return true;
    }
    AppMethodBeat.o(75583);
    return false;
  }
  
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
        paramView = this.vke;
        k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.vkf;
        k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.vjo, d.c.vov);
        AppMethodBeat.o(75584);
        return;
        label101:
        if (paramView.intValue() != 2131298861) {
          break label25;
        }
        paramView = this.vke;
        k.g(paramView, "normalFuncLayout");
        paramView.setVisibility(0);
        paramView = this.vkf;
        k.g(paramView, "cropFuncLayout");
        paramView.setVisibility(4);
        d.b.a(this.vjo, d.c.vow);
        AppMethodBeat.o(75584);
        return;
        label158:
        if (paramView.intValue() == 2131298865)
        {
          d.b.a(this.vjo, d.c.voy);
          AppMethodBeat.o(75584);
          return;
        }
      }
    }
    if (paramView.intValue() == 2131298864) {
      d.b.a(this.vjo, d.c.vox);
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
    this.vkj.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */