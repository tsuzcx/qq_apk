package com.tencent.mm.plugin.textstatus.g.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatus;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDeleteFlag", "", "newStatusId", "", "newInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "isBlur", "", "isExpired", "isRead", "toString", "Companion", "plugin-textstatus_release"})
public final class a
  extends com.tencent.mm.plugin.textstatus.i.a
{
  private static final IAutoDBItem.MAutoDBInfo MDR;
  private static final int MDS = 1;
  private static final int MDT = 2;
  public static final a.a MDU;
  
  static
  {
    AppMethodBeat.i(237666);
    MDU = new a.a((byte)0);
    MDR = com.tencent.mm.plugin.textstatus.i.a.aoY();
    MDS = 1;
    MDT = 2;
    AppMethodBeat.o(237666);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(237655);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = MDR;
    p.j(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(237655);
    return localMAutoDBInfo;
  }
  
  public final TextStatusTopicInfo glY()
  {
    AppMethodBeat.i(237657);
    TextStatusTopicInfo localTextStatusTopicInfo = new TextStatusTopicInfo();
    if (this.field_TopicInfo != null) {
      localTextStatusTopicInfo.parseFrom(this.field_TopicInfo);
    }
    AppMethodBeat.o(237657);
    return localTextStatusTopicInfo;
  }
  
  public final boolean glZ()
  {
    return this.field_state == MDT;
  }
  
  public final boolean gma()
  {
    AppMethodBeat.i(237659);
    if ((this.field_option.longValue() & 1L) != 0L)
    {
      AppMethodBeat.o(237659);
      return true;
    }
    AppMethodBeat.o(237659);
    return false;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(237661);
    if (this.field_ExpireTime <= cm.bfF())
    {
      AppMethodBeat.o(237661);
      return true;
    }
    AppMethodBeat.o(237661);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237663);
    String str = "TSItem() statusId:" + this.field_StatusID + " ,TopicId:" + this.field_TopicId + ",sourceId:" + this.field_SourceID + ",IconID:" + this.field_IconID + ",MediaType:" + this.field_MediaType + ",mediaUrl:" + this.field_MediaUrl + ",thumb:" + this.field_MediaThumbUrl + "state:" + this.field_state + ",bid:" + this.field_backgroundId + ",likeCont:" + this.field_LikeCount + ",mwidth" + this.field_mediaWidth + ",mheight" + this.field_mediaHeight + ",etime:" + this.field_ExpireTime;
    AppMethodBeat.o(237663);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.a
 * JD-Core Version:    0.7.0.1
 */