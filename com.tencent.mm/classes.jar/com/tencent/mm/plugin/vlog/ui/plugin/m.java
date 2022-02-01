package com.tencent.mm.plugin.vlog.ui.plugin;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "view", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "onAttach", "", "onClick", "v", "onDetach", "resetStyle", "bgResId", "", "textColor", "text", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  public final String TAG;
  public View view;
  
  public m(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282350);
    this.view = paramView;
    this.TAG = "MicroMsg.EditFinishPlugin";
    float f;
    if ((this.view instanceof TextView))
    {
      paramView = com.tencent.mm.plugin.vlog.util.a.UsM;
      paramView = this.view.getContext();
      s.s(paramView, "view.context");
      f = com.tencent.mm.plugin.vlog.util.a.g(paramView, 14.0F);
      paramView = this.view;
      if (!(paramView instanceof TextView)) {
        break label112;
      }
    }
    label112:
    for (paramView = (TextView)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.setTextSize(1, f);
      }
      this.view.setOnClickListener((View.OnClickListener)this);
      AppMethodBeat.o(282350);
      return;
    }
  }
  
  private static final void a(m paramm)
  {
    AppMethodBeat.i(282357);
    s.u(paramm, "this$0");
    a.b.a(paramm.GrC, a.c.NOP);
    AppMethodBeat.o(282357);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(282384);
    super.bwk();
    this.view.setVisibility(0);
    AppMethodBeat.o(282384);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(282376);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i(this.TAG, "on click edit finish");
    paramView = c.NRf;
    c.agG(12);
    paramView = c.NRf;
    c.gJf().jjw = System.currentTimeMillis();
    if (!CaptureDataManager.NHH.a(this.view.getContext(), new m..ExternalSyntheticLambda0(this))) {
      a.b.a(this.GrC, a.c.NOP);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MultiEditFinishPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282376);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282392);
    super.onDetach();
    this.view.setVisibility(4);
    AppMethodBeat.o(282392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.m
 * JD-Core Version:    0.7.0.1
 */