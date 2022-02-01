package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.bb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cancelBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "cropFuncLayout", "curFuncType", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin$FuncType;", "normalFuncLayout", "okBtn", "rotateImg", "Landroid/widget/ImageView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "unDoImg", "getView", "()Landroid/view/ViewGroup;", "setView", "(Landroid/view/ViewGroup;)V", "onBackPress", "", "onClick", "", "v", "Landroid/view/View;", "setVisibility", "visibility", "", "FuncType", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private t.a NKE;
  private ViewGroup NKm;
  private final ViewGroup NKn;
  private final ViewGroup NKo;
  private final ImageView NKp;
  private final ImageView NKq;
  private final Button nhC;
  private final Button njI;
  
  public t(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75585);
    this.NKm = paramViewGroup;
    this.GrC = parama;
    this.NKn = ((ViewGroup)this.NKm.findViewById(b.e.func_layout));
    this.NKo = ((ViewGroup)this.NKm.findViewById(b.e.crop_func_layout));
    this.njI = ((Button)this.NKm.findViewById(b.e.crop_cancel));
    this.nhC = ((Button)this.NKm.findViewById(b.e.crop_finish));
    this.NKp = ((ImageView)this.NKm.findViewById(b.e.crop_undo));
    this.NKq = ((ImageView)this.NKm.findViewById(b.e.crop_rotate));
    this.NKE = t.a.NKH;
    this.NKo.setVisibility(4);
    this.NKm.findViewById(b.e.edit_root);
    this.NKp.setImageDrawable(bb.m(this.NKm.getContext(), b.g.undo_normal, -1));
    this.NKq.setImageDrawable(bb.m(this.NKm.getContext(), b.g.icons_filled_refresh, -1));
    this.njI.setOnClickListener((View.OnClickListener)this);
    this.nhC.setOnClickListener((View.OnClickListener)this);
    this.NKp.setOnClickListener((View.OnClickListener)this);
    this.NKq.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75585);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280766);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280766);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280804);
    s.u(this, "this");
    AppMethodBeat.o(280804);
  }
  
  public final String name()
  {
    AppMethodBeat.i(280777);
    String str = v.a.b(this);
    AppMethodBeat.o(280777);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280788);
    s.u(this, "this");
    AppMethodBeat.o(280788);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75583);
    if (this.NKE == t.a.NKF)
    {
      a.b.a(this.GrC, a.c.NPi);
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
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.e.crop_cancel;
      if (paramView != null) {
        break label101;
      }
      label48:
      i = b.e.crop_finish;
      if (paramView != null) {
        break label138;
      }
      label56:
      i = b.e.crop_undo;
      if (paramView != null) {
        break label175;
      }
      label64:
      i = b.e.crop_rotate;
      if (paramView != null) {
        break label196;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75584);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label101:
      if (paramView.intValue() != i) {
        break label48;
      }
      this.NKn.setVisibility(0);
      this.NKo.setVisibility(4);
      a.b.a(this.GrC, a.c.NPi);
      continue;
      label138:
      if (paramView.intValue() != i) {
        break label56;
      }
      this.NKn.setVisibility(0);
      this.NKo.setVisibility(4);
      a.b.a(this.GrC, a.c.NPj);
      continue;
      label175:
      if (paramView.intValue() != i) {
        break label64;
      }
      a.b.a(this.GrC, a.c.NPl);
      continue;
      label196:
      if (paramView.intValue() == i) {
        a.b.a(this.GrC, a.c.NPk);
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280816);
    s.u(this, "this");
    AppMethodBeat.o(280816);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280824);
    s.u(this, "this");
    AppMethodBeat.o(280824);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280832);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280832);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280838);
    s.u(this, "this");
    AppMethodBeat.o(280838);
  }
  
  public final void release()
  {
    AppMethodBeat.i(280845);
    s.u(this, "this");
    AppMethodBeat.o(280845);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(280852);
    s.u(this, "this");
    AppMethodBeat.o(280852);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75582);
    this.NKm.setVisibility(paramInt);
    AppMethodBeat.o(75582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.t
 * JD-Core Version:    0.7.0.1
 */