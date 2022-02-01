package com.tencent.mm.plugin.textstatus.e;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$DescSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "topicStr", "", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Ljava/lang/String;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "initHrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "onClick", "", "widget", "Landroid/view/View;", "plugin-textstatus_release"})
public final class c$b
  extends com.tencent.mm.pluginsdk.ui.span.p
{
  private final u MCB;
  
  public c$b(String paramString, int paramInt1, int paramInt2, j paramj)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(234910);
    this.mClickListener = paramj;
    this.MCB = new u(paramString, 0, null);
    AppMethodBeat.o(234910);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(234907);
    kotlin.g.b.p.k(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, this.MCB);
    }
    AppMethodBeat.o(234907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.c.b
 * JD-Core Version:    0.7.0.1
 */