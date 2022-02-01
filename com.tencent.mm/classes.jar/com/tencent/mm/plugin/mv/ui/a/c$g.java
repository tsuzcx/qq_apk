package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.a.a;
import com.tencent.mm.plugin.mv.ui.uic.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initChattingInfo$1", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onDoCopy", "", "feedId", "", "nonceId", "", "commentId", "(Ljava/lang/Long;Ljava/lang/String;J)V", "onDoExpose", "onReferLinkClicked", "plugin-mv_release"})
public final class c$g
  implements a
{
  c$g(e parame) {}
  
  public final void J(long paramLong, String paramString)
  {
    AppMethodBeat.i(229229);
    p.k(paramString, "nonceId");
    a locala = this.GfU.GiJ;
    if (locala != null)
    {
      locala.J(paramLong, paramString);
      AppMethodBeat.o(229229);
      return;
    }
    AppMethodBeat.o(229229);
  }
  
  public final void a(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(229231);
    a locala = this.GfU.GiJ;
    if (locala != null)
    {
      locala.a(paramLong, paramString, paramLong1);
      AppMethodBeat.o(229231);
      return;
    }
    AppMethodBeat.o(229231);
  }
  
  public final void b(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(229233);
    a locala = this.GfU.GiJ;
    if (locala != null)
    {
      locala.b(paramLong, paramString, paramLong1);
      AppMethodBeat.o(229233);
      return;
    }
    AppMethodBeat.o(229233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.g
 * JD-Core Version:    0.7.0.1
 */