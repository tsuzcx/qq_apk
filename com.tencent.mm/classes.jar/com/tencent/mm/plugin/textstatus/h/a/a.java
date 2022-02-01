package com.tencent.mm.plugin.textstatus.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.an;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "history", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "getHistory", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setItem", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "monthDayStr", "", "getMonthDayStr", "()Ljava/lang/String;", "setMonthDayStr", "(Ljava/lang/String;)V", "yearStr", "getYearStr", "setYearStr", "getItemId", "", "getItemType", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public final an Tni;
  public com.tencent.mm.plugin.textstatus.h.f.b Tnj;
  public String Tnk;
  public String Tnl;
  
  public a(an paraman)
  {
    AppMethodBeat.i(290435);
    this.Tni = paraman;
    this.Tnj = b.a(this.Tni);
    AppMethodBeat.o(290435);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290443);
    long l = hashCode();
    AppMethodBeat.o(290443);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.a.a
 * JD-Core Version:    0.7.0.1
 */