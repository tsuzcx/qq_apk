package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.a;
import com.tencent.mm.plugin.livelist.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/DemoLiveListItem;", "Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "info", "Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "(Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;)V", "getInfo", "()Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "clone", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "compareTo", "", "other", "getItemType", "getUniqueId", "", "isSameContent", "", "ui-repairer_release"})
public final class d
  extends a
{
  final h Ixp;
  
  public d(h paramh)
  {
    AppMethodBeat.i(226901);
    this.Ixp = paramh;
    AppMethodBeat.o(226901);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final boolean c(b paramb)
  {
    AppMethodBeat.i(226889);
    p.k(paramb, "other");
    if ((paramb instanceof d))
    {
      if ((p.h(this.Ixp.field_info, ((d)paramb).Ixp.field_info)) && (this.Ixp.field_timestamp == ((d)paramb).Ixp.field_timestamp))
      {
        AppMethodBeat.o(226889);
        return true;
      }
      AppMethodBeat.o(226889);
      return false;
    }
    AppMethodBeat.o(226889);
    return false;
  }
  
  public final b eLO()
  {
    AppMethodBeat.i(226893);
    b localb = (b)new d(this.Ixp);
    AppMethodBeat.o(226893);
    return localb;
  }
  
  public final String eLP()
  {
    AppMethodBeat.i(226885);
    String str = this.Ixp.field_id;
    p.j(str, "info.field_id");
    AppMethodBeat.o(226885);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.d
 * JD-Core Version:    0.7.0.1
 */