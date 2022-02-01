package com.tencent.mm.plugin.textstatus.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.aa;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "history", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "getHistory", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setItem", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "monthDayStr", "", "getMonthDayStr", "()Ljava/lang/String;", "setMonthDayStr", "(Ljava/lang/String;)V", "yearStr", "getYearStr", "setYearStr", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public com.tencent.mm.plugin.textstatus.g.e.a MDH;
  public String MDI;
  public String MDJ;
  public final aa MDK;
  
  public a(aa paramaa)
  {
    AppMethodBeat.i(232481);
    this.MDK = paramaa;
    this.MDH = b.a(this.MDK);
    AppMethodBeat.o(232481);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(232478);
    long l = hashCode();
    AppMethodBeat.o(232478);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.a.a
 * JD-Core Version:    0.7.0.1
 */