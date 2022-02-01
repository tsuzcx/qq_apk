package com.tencent.mm.plugin.textstatus.h.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.bk;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/like/ReferenceHistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "statusId", "", "referenceInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;)V", "getReferenceInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusReferenced;", "getStatusId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  private final String Tly;
  public final bk Tny;
  
  public c(String paramString, bk parambk)
  {
    AppMethodBeat.i(290502);
    this.Tly = paramString;
    this.Tny = parambk;
    AppMethodBeat.o(290502);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290509);
    long l = hashCode();
    AppMethodBeat.o(290509);
    return l;
  }
  
  public final int bZB()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.d.c
 * JD-Core Version:    0.7.0.1
 */