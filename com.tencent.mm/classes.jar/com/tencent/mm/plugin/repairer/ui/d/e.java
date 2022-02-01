package com.tencent.mm.plugin.repairer.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/state/SearchQueryChangeAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "query", "", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends BaseStateAction
{
  public final String query;
  
  public e(String paramString)
  {
    AppMethodBeat.i(277993);
    this.query = paramString;
    AppMethodBeat.o(277993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.d.e
 * JD-Core Version:    0.7.0.1
 */