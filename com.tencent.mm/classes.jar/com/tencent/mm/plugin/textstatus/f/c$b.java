package com.tencent.mm.plugin.textstatus.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.t;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$DescSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "topicStr", "", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Ljava/lang/String;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "initHrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "onClick", "", "widget", "Landroid/view/View;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  extends t
{
  private final u Tmn;
  
  public c$b(String paramString, int paramInt1, int paramInt2, n paramn)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(289707);
    this.mClickListener = paramn;
    this.Tmn = new u(paramString, 0, null);
    AppMethodBeat.o(289707);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(289711);
    s.u(paramView, "widget");
    if (this.mClickListener != null) {
      this.mClickListener.a(paramView, this.Tmn);
    }
    AppMethodBeat.o(289711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.c.b
 * JD-Core Version:    0.7.0.1
 */