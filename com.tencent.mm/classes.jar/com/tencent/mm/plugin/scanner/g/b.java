package com.tencent.mm.plugin.scanner.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/result/DefaultScanCodeResultFilter;", "Lcom/tencent/mm/plugin/scanner/result/IScanCodeResultFilter;", "()V", "filter", "", "Lcom/tencent/qbar/QBar$QBarResult;", "codeResultList", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements d
{
  public final List<a.a> F(List<? extends a.a> paramList)
  {
    AppMethodBeat.i(313556);
    s.u(paramList, "codeResultList");
    AppMethodBeat.o(313556);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g.b
 * JD-Core Version:    0.7.0.1
 */