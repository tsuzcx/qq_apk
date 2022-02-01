package com.tencent.mm.plugin.recordvideo.plugin;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/ClickRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "customName", "", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Ljava/lang/String;)V", "view", "Landroid/view/View;", "setVisibility", "", "visibility", "", "setup", "resId", "event", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private View view;
  
  public b(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, String paramString)
  {
    super(parama, paramString);
    AppMethodBeat.i(280503);
    AppMethodBeat.o(280503);
  }
  
  private static final void a(b paramb, a.c paramc, View paramView)
  {
    AppMethodBeat.i(280508);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/ClickRegisterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(paramc, "$event");
    a.b.a(paramb.GrC, paramc);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/plugin/ClickRegisterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280508);
  }
  
  public final void a(int paramInt, a.c paramc)
  {
    AppMethodBeat.i(280515);
    s.u(paramc, "event");
    this.view = UH(paramInt);
    View localView = this.view;
    if (localView != null) {
      localView.setOnClickListener(new b..ExternalSyntheticLambda0(this, paramc));
    }
    AppMethodBeat.o(280515);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280518);
    super.setVisibility(paramInt);
    View localView = this.view;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(280518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.b
 * JD-Core Version:    0.7.0.1
 */