package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.plugin.mvvmlist.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "info", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "(Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;)V", "getInfo", "()Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "compareTo", "", "other", "getItemType", "getUniqueId", "", "isSameContent", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a<k>
{
  final s OwO;
  
  public k(s params)
  {
    AppMethodBeat.i(278074);
    this.OwO = params;
    AppMethodBeat.o(278074);
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(278097);
    Object localObject = super.clone();
    AppMethodBeat.o(278097);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(278084);
    String str = this.OwO.field_id;
    kotlin.g.b.s.s(str, "info.id");
    AppMethodBeat.o(278084);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.k
 * JD-Core Version:    0.7.0.1
 */