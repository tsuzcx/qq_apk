package com.tencent.mm.plugin.textstatus.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/like/ReferenceHistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "statusId", "", "referenceInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;)V", "getReferenceInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;", "getStatusId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class c
  implements a
{
  private final String MBU;
  public final an MDN;
  
  public c(String paramString, an paraman)
  {
    AppMethodBeat.i(237932);
    this.MBU = paramString;
    this.MDN = paraman;
    AppMethodBeat.o(237932);
  }
  
  public final int bAQ()
  {
    return 1;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(237929);
    long l = hashCode();
    AppMethodBeat.o(237929);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.b.c
 * JD-Core Version:    0.7.0.1
 */