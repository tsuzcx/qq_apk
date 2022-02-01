package com.tencent.mm.plugin.repairer.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a;
import com.tencent.mm.protocal.protobuf.ept;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "orderId", "", "type", "item", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "value", "", "(IILcom/tencent/mm/protocal/protobuf/RepairerItem;Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getOrderId", "()I", "getType", "setType", "(I)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "compareTo", "other", "getItemType", "getUniqueId", "isSameContent", "", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<c>
{
  public static final c.a Oym;
  private final int FWs;
  public final ept Oyn;
  public int type;
  public String value;
  
  static
  {
    AppMethodBeat.i(277842);
    Oym = new c.a((byte)0);
    AppMethodBeat.o(277842);
  }
  
  public c(int paramInt1, int paramInt2, ept paramept, String paramString)
  {
    AppMethodBeat.i(277838);
    this.FWs = paramInt1;
    this.type = paramInt2;
    this.Oyn = paramept;
    this.value = paramString;
    AppMethodBeat.o(277838);
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(277866);
    Object localObject = super.clone();
    AppMethodBeat.o(277866);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(277854);
    String str = this.Oyn.key + '-' + this.type;
    AppMethodBeat.o(277854);
    return str;
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(277850);
    s.u(paramString, "<set-?>");
    this.value = paramString;
    AppMethodBeat.o(277850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.c.c
 * JD-Core Version:    0.7.0.1
 */