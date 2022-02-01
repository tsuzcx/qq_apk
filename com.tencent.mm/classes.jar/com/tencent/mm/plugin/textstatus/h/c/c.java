package com.tencent.mm.plugin.textstatus.h.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a;
import com.tencent.mm.plugin.textstatus.h.f.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/CardFeedItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/plugin/mvvmlist/BaseMvvmListItem;", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "compareTo", "", "other", "getItemId", "", "getItemType", "getUniqueId", "", "isSameContent", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<c>
{
  public final b Tmb;
  
  public c(b paramb)
  {
    AppMethodBeat.i(290643);
    this.Tmb = paramb;
    AppMethodBeat.o(290643);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290654);
    long l = hashCode();
    AppMethodBeat.o(290654);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(290677);
    Object localObject = super.clone();
    AppMethodBeat.o(290677);
    return localObject;
  }
  
  public final String fcs()
  {
    AppMethodBeat.i(290663);
    String str = this.Tmb.field_StatusID;
    s.s(str, "info.field_StatusID");
    AppMethodBeat.o(290663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c.c
 * JD-Core Version:    0.7.0.1
 */