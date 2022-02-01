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
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"})
public final class s
  implements View.OnClickListener, u
{
  private d APl;
  private ViewGroup AQv;
  private s.a HNK;
  private final ViewGroup HNr;
  private final ViewGroup HNs;
  private final ImageView HNt;
  private final ImageView HNu;
  private final Button kEt;
  private final Button kGN;
  
  public s(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75585);
    this.AQv = paramViewGroup;
    this.APl = paramd;
    this.HNr = ((ViewGroup)this.AQv.findViewById(b.e.func_layout));
    this.HNs = ((ViewGroup)this.AQv.findViewById(b.e.crop_func_layout));
    this.kGN = ((Button)this.AQv.findViewById(b.e.crop_cancel));
    this.kEt = ((Button)this.AQv.findViewById(b.e.crop_finish));
    this.HNt = ((ImageView)this.AQv.findViewById(b.e.crop_undo));
    this.HNu = ((ImageView)this.AQv.findViewById(b.e.crop_rotate));
    this.HNK = s.a.HNN;
    paramViewGroup = this.HNs;
    p.j(paramViewGroup, "cropFuncLayout");
    paramViewGroup.setVisibility(4);
    this.AQv.findViewById(b.e.edit_root);
    this.HNt.setImageDrawable(au.o(this.AQv.getContext(), b.g.undo_normal, -1));
    this.HNu.setImageDrawable(au.o(this.AQv.getContext(), b.g.icons_filled_refresh, -1));
    this.kGN.setOnClickListener((View.OnClickListener)this);
    this.kEt.setOnClickListener((View.OnClickListener)this);
    this.HNt.setOnClickListener((View.OnClickListener)this);
    this.HNu.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final void bbp() {}
  
  public final String name()
  {
    AppMethodBeat.i(223442);
    String str = getClass().getName();
    AppMethodBeat.o(223442);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75583);
    if (this.HNK == s.a.HNL)
    {
      d.b.a(this.APl, d.c.HSC);
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
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.e.crop_cancel;
      if (paramView != null) {
        break label101;
      }
      label54:
      i = b.e.crop_finish;
      if (paramView != null) {
        break label154;
      }
      label62:
      i = b.e.crop_undo;
      if (paramView != null) {
        break label207;
      }
      label70:
      i = b.e.crop_rotate;
      if (paramView != null) {
        break label228;
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75584);
      return;
      paramView = null;
      break;
      label101:
      if (paramView.intValue() != i) {
        break label54;
      }
      paramView = this.HNr;
      p.j(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.HNs;
      p.j(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.APl, d.c.HSC);
      continue;
      label154:
      if (paramView.intValue() != i) {
        break label62;
      }
      paramView = this.HNr;
      p.j(paramView, "normalFuncLayout");
      paramView.setVisibility(0);
      paramView = this.HNs;
      p.j(paramView, "cropFuncLayout");
      paramView.setVisibility(4);
      d.b.a(this.APl, d.c.HSD);
      continue;
      label207:
      if (paramView.intValue() != i) {
        break label70;
      }
      d.b.a(this.APl, d.c.HSF);
      continue;
      label228:
      if (paramView.intValue() == i) {
        d.b.a(this.APl, d.c.HSE);
      }
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(223448);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(223448);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.AQv.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */