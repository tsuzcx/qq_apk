package com.tencent.mm.plugin.textstatus.h.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.j.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatus;", "()V", "emojiInfoCache", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusEmojiInfo;", "emojiInfoCacheHashCode", "", "topicInfoCache", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "topicInfoCacheHashCode", "clone", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getDeleteFlag", "newStatusId", "", "newInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "getEmojiInfo", "getOption", "", "getTopicInfo", "isReCreate", "", "hasEmoji", "isBlur", "isExpired", "isRead", "isSupportCopy", "toString", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private static final IAutoDBItem.MAutoDBInfo JmM;
  public static final b.a TnB;
  private static final int TnG;
  private static final int TnH;
  private TextStatusEmojiInfo TnC;
  private int TnD;
  private TextStatusTopicInfo TnE;
  private int TnF;
  
  static
  {
    AppMethodBeat.i(290717);
    TnB = new b.a((byte)0);
    JmM = a.aJm();
    TnG = 1;
    TnH = 2;
    AppMethodBeat.o(290717);
  }
  
  private final long hHG()
  {
    AppMethodBeat.i(290706);
    Long localLong = this.field_option;
    if (localLong == null)
    {
      AppMethodBeat.o(290706);
      return 0L;
    }
    long l = localLong.longValue();
    AppMethodBeat.o(290706);
    return l;
  }
  
  public final TextStatusTopicInfo Fz(boolean paramBoolean)
  {
    AppMethodBeat.i(290743);
    if (!paramBoolean)
    {
      int i = this.TnF;
      localObject = this.field_TopicInfo;
      if ((localObject != null) && (i == ((byte[])localObject).hashCode())) {
        i = 1;
      }
      while (i != 0)
      {
        localObject = this.TnE;
        if (localObject == null)
        {
          localObject = new TextStatusTopicInfo();
          AppMethodBeat.o(290743);
          return localObject;
          i = 0;
        }
        else
        {
          AppMethodBeat.o(290743);
          return localObject;
        }
      }
    }
    Object localObject = new TextStatusTopicInfo();
    byte[] arrayOfByte = this.field_TopicInfo;
    if (arrayOfByte != null)
    {
      ((TextStatusTopicInfo)localObject).parseFrom(arrayOfByte);
      this.TnF = arrayOfByte.hashCode();
    }
    this.TnE = ((TextStatusTopicInfo)localObject);
    AppMethodBeat.o(290743);
    return localObject;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(290722);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = JmM;
    s.s(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(290722);
    return localMAutoDBInfo;
  }
  
  public final TextStatusEmojiInfo hHD()
  {
    AppMethodBeat.i(290729);
    int i = this.TnD;
    Object localObject = this.field_EmojiInfo;
    if ((localObject != null) && (i == ((byte[])localObject).hashCode())) {
      i = 1;
    }
    while (i != 0)
    {
      localObject = this.TnC;
      if (localObject == null)
      {
        localObject = new TextStatusEmojiInfo();
        AppMethodBeat.o(290729);
        return localObject;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(290729);
        return localObject;
      }
    }
    localObject = new TextStatusEmojiInfo();
    byte[] arrayOfByte = this.field_EmojiInfo;
    if (arrayOfByte != null)
    {
      ((TextStatusEmojiInfo)localObject).parseFrom(arrayOfByte);
      this.TnD = arrayOfByte.hashCode();
    }
    this.TnC = ((TextStatusEmojiInfo)localObject);
    AppMethodBeat.o(290729);
    return localObject;
  }
  
  public final boolean hHE()
  {
    AppMethodBeat.i(290737);
    CharSequence localCharSequence = (CharSequence)hHD().Md5;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(290737);
      return true;
    }
    AppMethodBeat.o(290737);
    return false;
  }
  
  public final boolean hHF()
  {
    return this.field_state == TnH;
  }
  
  public final boolean hHH()
  {
    AppMethodBeat.i(290758);
    if ((hHG() & 0x4) != 0L)
    {
      AppMethodBeat.o(290758);
      return true;
    }
    AppMethodBeat.o(290758);
    return false;
  }
  
  public final boolean hHI()
  {
    AppMethodBeat.i(290765);
    if ((hHG() & 1L) != 0L)
    {
      AppMethodBeat.o(290765);
      return true;
    }
    AppMethodBeat.o(290765);
    return false;
  }
  
  public final b hHJ()
  {
    AppMethodBeat.i(290801);
    b localb = new b();
    localb.field_UserName = this.field_UserName;
    localb.field_StatusID = this.field_StatusID;
    localb.field_TopicId = this.field_TopicId;
    localb.field_SourceID = this.field_SourceID;
    localb.field_TopicInfo = this.field_TopicInfo;
    localb.field_ClusterShowInfo = this.field_ClusterShowInfo;
    localb.field_IconID = this.field_IconID;
    localb.field_Description = this.field_Description;
    localb.field_MediaType = this.field_MediaType;
    localb.field_MediaUrl = this.field_MediaUrl;
    localb.field_MediaAESKey = this.field_MediaAESKey;
    localb.field_MediaThumbUrl = this.field_MediaThumbUrl;
    localb.field_MediaThumbAESKey = this.field_MediaThumbAESKey;
    localb.field_PoiID = this.field_PoiID;
    localb.field_PoiName = this.field_PoiName;
    localb.field_Longitude = this.field_Longitude;
    localb.field_Latitude = this.field_Latitude;
    localb.field_Visibility = this.field_Visibility;
    localb.field_CreateTime = this.field_CreateTime;
    localb.field_ExpireTime = this.field_ExpireTime;
    localb.field_LikeCount = this.field_LikeCount;
    localb.field_state = this.field_state;
    localb.field_backgroundId = this.field_backgroundId;
    localb.field_option = this.field_option;
    localb.field_mediaWidth = this.field_mediaWidth;
    localb.field_mediaHeight = this.field_mediaHeight;
    localb.field_visibilityInfo = this.field_visibilityInfo;
    localb.field_referenceUserName = this.field_referenceUserName;
    localb.field_referenceTextStatusId = this.field_referenceTextStatusId;
    localb.field_referenceCount = this.field_referenceCount;
    localb.field_sceneType = this.field_sceneType;
    localb.field_duplicateUserName = this.field_duplicateUserName;
    localb.field_duplicateTextStatusId = this.field_duplicateTextStatusId;
    localb.field_EmojiInfo = this.field_EmojiInfo;
    AppMethodBeat.o(290801);
    return localb;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(290777);
    if (this.field_ExpireTime <= cn.getSyncServerTimeSecond())
    {
      AppMethodBeat.o(290777);
      return true;
    }
    AppMethodBeat.o(290777);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290788);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TSItem() statusId:").append(this.field_StatusID).append(" ,TopicId:").append(this.field_TopicId).append(",sourceId:").append(this.field_SourceID).append(",IconID:").append(this.field_IconID).append(",MediaType:").append(this.field_MediaType).append(",mediaUrl:").append(this.field_MediaUrl).append(",thumb:").append(this.field_MediaThumbUrl).append("state:").append(this.field_state).append(",bid:").append(this.field_backgroundId).append(",likeCont:").append(this.field_LikeCount).append(",mwidth").append(this.field_mediaWidth).append(",mheight");
    ((StringBuilder)localObject).append(this.field_mediaHeight).append(",etime:").append(this.field_ExpireTime);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(290788);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.b
 * JD-Core Version:    0.7.0.1
 */