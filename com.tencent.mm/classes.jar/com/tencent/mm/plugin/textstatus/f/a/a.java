package com.tencent.mm.plugin.textstatus.f.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "history", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "getHistory", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setItem", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "monthDayStr", "", "getMonthDayStr", "()Ljava/lang/String;", "setMonthDayStr", "(Ljava/lang/String;)V", "yearStr", "getYearStr", "setYearStr", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  public com.tencent.mm.plugin.textstatus.f.f.a FZq;
  public String FZr;
  public String FZs;
  private final q FZt;
  
  public a(q paramq)
  {
    AppMethodBeat.i(216229);
    this.FZt = paramq;
    paramq = new com.tencent.mm.plugin.textstatus.f.f.a();
    paramq.field_UserName = com.tencent.mm.plugin.auth.a.a.ceA();
    paramq.field_StatusID = this.FZt.Gas;
    g localg = new g();
    localg.parseFrom(Base64.decode(this.FZt.GaN, 0));
    f localf = f.FXJ;
    f.a(paramq, localg);
    this.FZq = paramq;
    AppMethodBeat.o(216229);
  }
  
  public final int cxn()
  {
    return 0;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(216228);
    long l = hashCode();
    AppMethodBeat.o(216228);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.a.a
 * JD-Core Version:    0.7.0.1
 */