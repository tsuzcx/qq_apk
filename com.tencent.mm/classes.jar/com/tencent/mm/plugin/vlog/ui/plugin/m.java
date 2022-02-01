package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-vlog_release"})
public final class m
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  d APl;
  public final String TAG;
  public View view;
  
  public m(View paramView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(230362);
    this.view = paramView;
    this.APl = paramd;
    this.TAG = "MicroMsg.EditFinishPlugin";
    this.view.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(230362);
  }
  
  public final void bbp()
  {
    AppMethodBeat.i(230357);
    super.bbp();
    this.view.setVisibility(0);
    AppMethodBeat.o(230357);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(230356);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.i(this.TAG, "on click edit finish");
    paramView = c.HUw;
    c.acq(12);
    paramView = c.HUw;
    c.fxq().vA(System.currentTimeMillis());
    if (!CaptureDataManager.HKJ.a(this.view.getContext(), (CaptureDataManager.a)new a(this))) {
      d.b.a(this.APl, d.c.HSj);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(230356);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(230358);
    super.onDetach();
    this.view.setVisibility(4);
    AppMethodBeat.o(230358);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onRequestFinish"})
  static final class a
    implements CaptureDataManager.a
  {
    a(m paramm) {}
    
    public final void fvW()
    {
      AppMethodBeat.i(228048);
      d.b.a(this.Nvk.APl, d.c.HSj);
      AppMethodBeat.o(228048);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.m
 * JD-Core Version:    0.7.0.1
 */