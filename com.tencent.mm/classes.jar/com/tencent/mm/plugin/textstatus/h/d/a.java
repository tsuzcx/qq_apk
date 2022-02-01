package com.tencent.mm.plugin.textstatus.h.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.bc;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/like/LikeHistoryItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "statusId", "", "likeInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;)V", "getLikeInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusLiked;", "getStatusId", "()Ljava/lang/String;", "getItemId", "", "getItemType", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.view.recyclerview.a
{
  private final String Tly;
  public final bc Tnw;
  
  public a(String paramString, bc parambc)
  {
    AppMethodBeat.i(290500);
    this.Tly = paramString;
    this.Tnw = parambc;
    AppMethodBeat.o(290500);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290506);
    long l = hashCode();
    AppMethodBeat.o(290506);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.d.a
 * JD-Core Version:    0.7.0.1
 */