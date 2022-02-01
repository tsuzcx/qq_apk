package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatus;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "isBlur", "", "toString", "", "Companion", "plugin-textstatus_release"})
public final class a
  extends com.tencent.mm.plugin.textstatus.h.a
{
  private static final IAutoDBItem.MAutoDBInfo FZC;
  public static final a.a FZD;
  
  static
  {
    AppMethodBeat.i(216250);
    FZD = new a.a((byte)0);
    FZC = com.tencent.mm.plugin.textstatus.h.a.ajs();
    AppMethodBeat.o(216250);
  }
  
  public final w fvU()
  {
    AppMethodBeat.i(216247);
    w localw = new w();
    if (this.field_TopicInfo != null) {
      localw.parseFrom(this.field_TopicInfo);
    }
    AppMethodBeat.o(216247);
    return localw;
  }
  
  public final boolean fvV()
  {
    AppMethodBeat.i(216248);
    if ((this.field_option.longValue() & 1L) != 0L)
    {
      AppMethodBeat.o(216248);
      return true;
    }
    AppMethodBeat.o(216248);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216246);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = FZC;
    p.g(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(216246);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216249);
    String str = "TSItem() statusId:" + this.field_StatusID + " ,TopicId:" + this.field_TopicId + ",sourceId:" + this.field_SourceID + ",IconID:" + this.field_IconID + ",MediaType:" + this.field_MediaType + ",mediaUrl:" + this.field_MediaUrl + ",thumb:" + this.field_MediaThumbUrl + "state:" + this.field_state + ",bid:" + this.field_backgroundId + ",likeCont:" + this.field_LikeCount + ",mwidth" + this.field_mediaWidth + ",mheight" + this.field_mediaHeight + ",etime:" + this.field_ExpireTime;
    AppMethodBeat.o(216249);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f.a
 * JD-Core Version:    0.7.0.1
 */