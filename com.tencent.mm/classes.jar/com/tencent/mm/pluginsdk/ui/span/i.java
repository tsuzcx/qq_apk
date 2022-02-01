package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;", "T", "", "content", "start", "", "end", "(Ljava/lang/Object;II)V", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "clickListener", "Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanClickListener;", "getClickListener", "()Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanClickListener;", "setClickListener", "(Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanClickListener;)V", "color", "getColor", "setColor", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEnd", "getStart", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;II)Lcom/tencent/mm/pluginsdk/ui/span/LinkSpanObj;", "equals", "", "other", "hashCode", "toString", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<T>
{
  public h<T> Yob;
  private final T aeq;
  int bgColor;
  int color;
  final int end;
  final int start;
  
  public i(T paramT, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245182);
    this.aeq = paramT;
    this.start = paramInt1;
    this.end = paramInt2;
    this.color = MMApplicationContext.getContext().getResources().getColor(c.b.Link);
    this.bgColor = MMApplicationContext.getContext().getResources().getColor(c.b.Link_Alpha_0_6);
    AppMethodBeat.o(245182);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(245191);
    if (this == paramObject)
    {
      AppMethodBeat.o(245191);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(245191);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.aeq, paramObject.aeq))
    {
      AppMethodBeat.o(245191);
      return false;
    }
    if (this.start != paramObject.start)
    {
      AppMethodBeat.o(245191);
      return false;
    }
    if (this.end != paramObject.end)
    {
      AppMethodBeat.o(245191);
      return false;
    }
    AppMethodBeat.o(245191);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(245187);
    if (this.aeq == null) {}
    for (int i = 0;; i = this.aeq.hashCode())
    {
      int j = this.start;
      int k = this.end;
      AppMethodBeat.o(245187);
      return (i * 31 + j) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(245185);
    String str = "LinkSpanObj(content=" + this.aeq + ", start=" + this.start + ", end=" + this.end + ')';
    AppMethodBeat.o(245185);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.i
 * JD-Core Version:    0.7.0.1
 */