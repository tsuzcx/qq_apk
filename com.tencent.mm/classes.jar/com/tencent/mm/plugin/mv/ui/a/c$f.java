package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.a.a;
import com.tencent.mm.plugin.mv.ui.uic.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/convert/MvItemConvert$initChattingInfo$1", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "onDoCopy", "", "feedId", "", "nonceId", "", "commentId", "(Ljava/lang/Long;Ljava/lang/String;J)V", "onDoExpose", "onReferLinkClicked", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$f
  implements a
{
  c$f(c paramc) {}
  
  public final void X(long paramLong, String paramString)
  {
    AppMethodBeat.i(288200);
    s.u(paramString, "nonceId");
    a locala = this.Mbi.MdK;
    if (locala != null) {
      locala.X(paramLong, paramString);
    }
    AppMethodBeat.o(288200);
  }
  
  public final void a(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(288206);
    a locala = this.Mbi.MdK;
    if (locala != null) {
      locala.a(paramLong, paramString, paramLong1);
    }
    AppMethodBeat.o(288206);
  }
  
  public final void b(Long paramLong, String paramString, long paramLong1)
  {
    AppMethodBeat.i(288214);
    a locala = this.Mbi.MdK;
    if (locala != null) {
      locala.b(paramLong, paramString, paramLong1);
    }
    AppMethodBeat.o(288214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.c.f
 * JD-Core Version:    0.7.0.1
 */