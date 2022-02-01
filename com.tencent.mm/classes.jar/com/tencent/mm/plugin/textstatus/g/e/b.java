package com.tencent.mm.plugin.textstatus.g.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusLike;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "Companion", "plugin-textstatus_release"})
public final class b
  extends com.tencent.mm.plugin.textstatus.i.b
{
  private static final IAutoDBItem.MAutoDBInfo MDR;
  private static final int MDV = 0;
  private static final int MDW = 1;
  public static final b.a MDX;
  
  static
  {
    AppMethodBeat.i(238620);
    MDX = new b.a((byte)0);
    MDR = com.tencent.mm.plugin.textstatus.i.b.aoY();
    MDW = 1;
    AppMethodBeat.o(238620);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(238615);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = MDR;
    p.j(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(238615);
    return localMAutoDBInfo;
  }
  
  public final TextStatusTopicInfo glY()
  {
    AppMethodBeat.i(238617);
    TextStatusTopicInfo localTextStatusTopicInfo = new TextStatusTopicInfo();
    if (this.field_TopicInfo != null) {
      localTextStatusTopicInfo.parseFrom(this.field_TopicInfo);
    }
    AppMethodBeat.o(238617);
    return localTextStatusTopicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.b
 * JD-Core Version:    0.7.0.1
 */