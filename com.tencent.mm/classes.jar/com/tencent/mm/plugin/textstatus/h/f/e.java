package com.tencent.mm.plugin.textstatus.h.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusReference;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.textstatus.j.e
{
  private static final IAutoDBItem.MAutoDBInfo JmM;
  public static final e.a TnM;
  
  static
  {
    AppMethodBeat.i(290705);
    TnM = new e.a((byte)0);
    JmM = com.tencent.mm.plugin.textstatus.j.e.aJm();
    AppMethodBeat.o(290705);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290708);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = JmM;
    s.s(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(290708);
    return localMAutoDBInfo;
  }
  
  public final TextStatusTopicInfo hHM()
  {
    AppMethodBeat.i(290711);
    TextStatusTopicInfo localTextStatusTopicInfo = new TextStatusTopicInfo();
    if (this.field_TopicInfo != null) {
      localTextStatusTopicInfo.parseFrom(this.field_TopicInfo);
    }
    AppMethodBeat.o(290711);
    return localTextStatusTopicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.e
 * JD-Core Version:    0.7.0.1
 */