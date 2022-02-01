package com.tencent.mm.plugin.textstatus.h.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "desc", "topicId", "statusId", "headImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHeadImgUrl", "getName", "getStatusId", "getTopicId", "getItemId", "", "getItemType", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a
{
  public final String Tly;
  private final String desc;
  private final String nVs;
  public final String name;
  public final String topicId;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(290480);
    this.name = paramString1;
    this.desc = paramString2;
    this.topicId = paramString3;
    this.Tly = paramString4;
    this.nVs = paramString5;
    AppMethodBeat.o(290480);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(290485);
    long l = hashCode();
    AppMethodBeat.o(290485);
    return l;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.e.e
 * JD-Core Version:    0.7.0.1
 */