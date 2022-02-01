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
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"})
public final class r
  implements View.OnClickListener, t
{
  private final ViewGroup BQB;
  private final ViewGroup BQC;
  private final ImageView BQD;
  private final ImageView BQE;
  private r.a BQV;
  private final Button hPX;
  private final Button hSq;
  private ViewGroup wgR;
  private d wgr;
  
  public r(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.wgR = paramViewGroup;
    this.wgr = paramd;
    this.BQB = ((ViewGroup)this.wgR.findViewById(2131301849));
    this.BQC = ((ViewGroup)this.wgR.findViewById(2131299334));
    this.hSq = ((Button)this.wgR.findViewById(2131299331));
    this.hPX = ((Button)this.wgR.findViewById(2131299333));
    this.BQD = ((ImageView)this.wgR.findViewById(2131299338));
    this.BQE = ((ImageView)this.wgR.findViewById(2131299337));
    this.BQV = r.a.BQY;
    paramViewGroup = this.BQC;
    p.g(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    this.wgR.findViewById(2131299839);
    this.BQD.setImageDrawable(ar.m(this.wgR.getContext(), 2131691677, -1));
    this.BQE.setImageDrawable(ar.m(this.wgR.getContext(), 2131690658, -1));
    this.hSq.setOnClickListener((View.OnClickListener)this);
    this.hPX.setOnClickListener((View.OnClickListener)this);
    this.BQD.setOnClickListener((View.OnClickListener)this);
    this.BQE.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final void aSs() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75583);
    if (this.BQV == r.a.BQW)
    {
      d.b.a(this.wgr, d.c.BVO);
      AppMethodBeat.o(75583);
      return true;
    }
    AppMethodBeat.o(75583);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75584);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      d.b.a(this.wgr, d.c.BVP);
      continue;
      label193:
      if (paramView.intValue() != 2131299338) {
        break label58;
      }
      d.b.a(this.wgr, d.c.BVR);
      continue;
      label215:
      if (paramView.intValue() == 2131299337) {
        d.b.a(this.wgr, d.c.BVQ);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237299);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237299);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.wgR.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */