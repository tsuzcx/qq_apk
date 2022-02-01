package com.tencent.mm.plugin.repairer.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.util.b.a;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/model/RepairerConvertDataItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "item", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "value", "", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;Ljava/lang/String;)V", "getItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "getItemId", "", "getItemType", "", "ui-repairer_release"})
public final class b
  implements a
{
  public final dwp Iye;
  public String value;
  
  public b(dwp paramdwp, String paramString)
  {
    AppMethodBeat.i(226595);
    this.Iye = paramdwp;
    this.value = paramString;
    AppMethodBeat.o(226595);
  }
  
  public final int bAQ()
  {
    return this.Iye.type;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(226592);
    String str = this.Iye.key;
    p.j(str, "item.key");
    long l = b.a.valueOf(str).ordinal();
    AppMethodBeat.o(226592);
    return l;
  }
  
  public final void setValue(String paramString)
  {
    AppMethodBeat.i(226593);
    p.k(paramString, "<set-?>");
    this.value = paramString;
    AppMethodBeat.o(226593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.b.b
 * JD-Core Version:    0.7.0.1
 */