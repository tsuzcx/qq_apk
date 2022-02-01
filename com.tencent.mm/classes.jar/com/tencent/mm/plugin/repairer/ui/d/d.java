package com.tencent.mm.plugin.repairer.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/state/SearchIndexReadyAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "indexItemList", "", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "(Ljava/util/List;)V", "getIndexItemList", "()Ljava/util/List;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends BaseStateAction
{
  public final List<ept> Oyq;
  
  public d(List<? extends ept> paramList)
  {
    AppMethodBeat.i(277988);
    this.Oyq = paramList;
    AppMethodBeat.o(277988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.d.d
 * JD-Core Version:    0.7.0.1
 */