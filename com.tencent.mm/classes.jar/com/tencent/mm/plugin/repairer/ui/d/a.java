package com.tencent.mm.plugin.repairer.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/state/InitAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "item", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "getItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BaseStateAction
{
  public final ept Oyn;
  
  public a(ept paramept)
  {
    AppMethodBeat.i(277987);
    this.Oyn = paramept;
    AppMethodBeat.o(277987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.d.a
 * JD-Core Version:    0.7.0.1
 */