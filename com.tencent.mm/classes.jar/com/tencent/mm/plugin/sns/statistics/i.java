package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.plugin.sns.k.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"update", "", "Lcom/tencent/mm/plugin/sns/snstimeline/SnsPostCgiReportObj;", "plugin-sns_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final void b(f paramf)
  {
    AppMethodBeat.i(306498);
    s.u(paramf, "<this>");
    ((g)h.az(g.class)).updateWithSave(16, paramf.hHB, (a)paramf, null);
    AppMethodBeat.o(306498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.i
 * JD-Core Version:    0.7.0.1
 */