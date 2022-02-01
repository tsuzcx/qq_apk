package com.tencent.mm.plugin.textstatus.h.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.d;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusLike;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  private static final IAutoDBItem.MAutoDBInfo JmM;
  public static final c.a TnI;
  private static final int TnJ = 0;
  private static final int TnK;
  
  static
  {
    AppMethodBeat.i(290713);
    TnI = new c.a((byte)0);
    JmM = d.aJm();
    TnK = 1;
    AppMethodBeat.o(290713);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290718);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = JmM;
    s.s(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(290718);
    return localMAutoDBInfo;
  }
  
  public final TextStatusTopicInfo hHM()
  {
    AppMethodBeat.i(290723);
    TextStatusTopicInfo localTextStatusTopicInfo = new TextStatusTopicInfo();
    if (this.field_TopicInfo != null) {
      localTextStatusTopicInfo.parseFrom(this.field_TopicInfo);
    }
    AppMethodBeat.o(290723);
    return localTextStatusTopicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.c
 * JD-Core Version:    0.7.0.1
 */