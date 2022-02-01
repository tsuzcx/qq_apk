package com.tencent.mm.plugin.textstatus.g.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "desc", "topicId", "statusId", "headImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHeadImgUrl", "getName", "getStatusId", "getTopicId", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class e
  implements a
{
  public final String MBU;
  private final String desc;
  private final String lqp;
  public final String name;
  public final String topicId;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(233150);
    this.name = paramString1;
    this.desc = paramString2;
    this.topicId = paramString3;
    this.MBU = paramString4;
    this.lqp = paramString5;
    AppMethodBeat.o(233150);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    AppMethodBeat.i(233148);
    long l = hashCode();
    AppMethodBeat.o(233148);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.d.e
 * JD-Core Version:    0.7.0.1
 */