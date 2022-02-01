package com.tencent.mm.pluginsdk.ui.span;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/LinkTextClickSpan;", "T", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "index", "", "obj", "Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;", "(ILcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;)V", "getIndex", "()I", "getObj", "()Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;", "onClick", "", "widget", "Landroid/view/View;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j<T>
  extends t
{
  private final i<T> Yoc;
  private final int index;
  
  public j(int paramInt, i<T> parami)
  {
    super(parami.color, parami.bgColor);
    AppMethodBeat.i(245178);
    this.index = paramInt;
    this.Yoc = parami;
    AppMethodBeat.o(245178);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245180);
    s.u(paramView, "widget");
    paramView = this.Yoc.Yob;
    if (paramView != null) {
      paramView.bYI();
    }
    AppMethodBeat.o(245180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.j
 * JD-Core Version:    0.7.0.1
 */