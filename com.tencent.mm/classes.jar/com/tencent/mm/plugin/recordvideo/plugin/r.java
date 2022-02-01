package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.ao;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, t
{
  private final Button gXc;
  private final Button gZv;
  private ViewGroup tbO;
  private d tbP;
  private final ViewGroup xQD;
  private final ViewGroup xQE;
  private final ImageView xQF;
  private final ImageView xQG;
  private r.a xQY;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.tbO = paramViewGroup;
    this.tbP = paramd;
    this.xQD = ((ViewGroup)this.tbO.findViewById(2131300333));
    this.xQE = ((ViewGroup)this.tbO.findViewById(2131298862));
    this.gZv = ((Button)this.tbO.findViewById(2131298859));
    this.gXc = ((Button)this.tbO.findViewById(2131298861));
    this.xQF = ((ImageView)this.tbO.findViewById(2131298865));
    this.xQG = ((ImageView)this.tbO.findViewById(2131298864));
    this.xQY = r.a.xRb;
    paramViewGroup = this.xQE;
    p.g(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    this.tbO.findViewById(2131299262);
    this.xQF.setImageDrawable(ao.k(this.tbO.getContext(), 2131691345, -1));
    this.xQG.setImageDrawable(ao.k(this.tbO.getContext(), 2131690467, -1));
    this.gZv.setOnClickListener((View.OnClickListener)this);
    this.gXc.setOnClickListener((View.OnClickListener)this);
    this.xQF.setOnClickListener((View.OnClickListener)this);
    this.xQG.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75583);
    if (this.xQY == r.a.xQZ)
    {
      d.b.a(this.tbP, d.c.xVg);
      AppMethodBeat.o(75583);
      return true;
    }
    AppMethodBeat.o(75583);
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75584);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
        break label193;
      }
      label58:
      if (paramView != null) {
        break label215;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75584);
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
      d.b.a(this.tbP, d.c.xVh);
      continue;
      label193:
      if (paramView.intValue() != 2131298865) {
        break label58;
      }
      d.b.a(this.tbP, d.c.xVj);
      continue;
      label215:
      if (paramView.intValue() == 2131298864) {
        d.b.a(this.tbP, d.c.xVi);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206583);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206583);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.tbO.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */