package com.tencent.mm.plugin.repairer.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/state/SearchEndAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "resultList", "", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "(Ljava/util/List;)V", "getResultList", "()Ljava/util/List;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends BaseStateAction
{
  public final List<ept> HtF;
  
  public c(List<? extends ept> paramList)
  {
    AppMethodBeat.i(277984);
    this.HtF = paramList;
    AppMethodBeat.o(277984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.d.c
 * JD-Core Version:    0.7.0.1
 */