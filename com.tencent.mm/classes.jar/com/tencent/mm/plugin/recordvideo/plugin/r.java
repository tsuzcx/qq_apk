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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, t
{
  private final Button gUt;
  private final Button gWI;
  private ViewGroup sQD;
  private d sQE;
  private final ViewGroup xAI;
  private final ViewGroup xAJ;
  private final ImageView xAK;
  private final ImageView xAL;
  private r.a xBd;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.sQD = paramViewGroup;
    this.sQE = paramd;
    this.xAI = ((ViewGroup)this.sQD.findViewById(2131300333));
    this.xAJ = ((ViewGroup)this.sQD.findViewById(2131298862));
    this.gWI = ((Button)this.sQD.findViewById(2131298859));
    this.gUt = ((Button)this.sQD.findViewById(2131298861));
    this.xAK = ((ImageView)this.sQD.findViewById(2131298865));
    this.xAL = ((ImageView)this.sQD.findViewById(2131298864));
    this.xBd = r.a.xBg;
    paramViewGroup = this.xAJ;
    p.g(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    this.sQD.findViewById(2131299262);
    this.xAK.setImageDrawable(ao.k(this.sQD.getContext(), 2131691345, -1));
    this.xAL.setImageDrawable(ao.k(this.sQD.getContext(), 2131690467, -1));
    this.gWI.setOnClickListener((View.OnClickListener)this);
    this.gUt.setOnClickListener((View.OnClickListener)this);
    this.xAK.setOnClickListener((View.OnClickListener)this);
    this.xAL.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75583);
    if (this.xBd == r.a.xBe)
    {
      d.b.a(this.sQE, d.c.xFl);
      AppMethodBeat.o(75583);
      return true;
    }
    AppMethodBeat.o(75583);
    return false;
  }
  
  public final void ayX() {}
  
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
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      paramView = this.xAI;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.xAJ;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.sQE, d.c.xFl);
      continue;
      label139:
      if (paramView.intValue() != 2131298861) {
        break label54;
      }
      paramView = this.xAI;
      p.g(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.xAJ;
      p.g(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.sQE, d.c.xFm);
      continue;
      label193:
      if (paramView.intValue() != 2131298865) {
        break label58;
      }
      d.b.a(this.sQE, d.c.xFo);
      continue;
      label215:
      if (paramView.intValue() == 2131298864) {
        d.b.a(this.sQE, d.c.xFn);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200322);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200322);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.sQD.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */