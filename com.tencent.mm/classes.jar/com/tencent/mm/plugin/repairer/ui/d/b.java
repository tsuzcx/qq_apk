package com.tencent.mm.plugin.repairer.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.statecenter.BaseState;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/state/RepairerState;", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "()V", "isMainUI", "", "()Z", "setMainUI", "(Z)V", "item", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "setItem", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "searchIndexList", "", "getSearchIndexList", "()Ljava/util/List;", "setSearchIndexList", "(Ljava/util/List;)V", "searchResultList", "getSearchResultList", "setSearchResultList", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends BaseState
{
  public ept Oyn;
  public boolean Oyo;
  public List<? extends ept> Oyp;
  
  public final Object clone()
  {
    AppMethodBeat.i(277992);
    Object localObject = super.clone();
    AppMethodBeat.o(277992);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.d.b
 * JD-Core Version:    0.7.0.1
 */