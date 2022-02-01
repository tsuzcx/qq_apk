package com.tencent.mm.plugin.textstatus.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "desc", "topicId", "statusId", "headImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHeadImgUrl", "getName", "getStatusId", "getTopicId", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class e
  implements a
{
  public final String FYf;
  public final String FZz;
  private final String desc;
  private final String iAR;
  public final String name;
  
  public e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(216245);
    this.name = paramString1;
    this.desc = paramString2;
    this.FZz = paramString3;
    this.FYf = paramString4;
    this.iAR = paramString5;
    AppMethodBeat.o(216245);
  }
  
  public final int cxn()
  {
    return 0;
  }
  
  public final long lT()
  {
    AppMethodBeat.i(216244);
    long l = hashCode();
    AppMethodBeat.o(216244);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.e.e
 * JD-Core Version:    0.7.0.1
 */