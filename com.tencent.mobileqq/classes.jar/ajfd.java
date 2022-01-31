import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;

public final class ajfd
  implements Parcelable.Creator
{
  public TroopTopicDetailInfo a(Parcel paramParcel)
  {
    TroopTopicDetailInfo localTroopTopicDetailInfo = new TroopTopicDetailInfo();
    localTroopTopicDetailInfo.troopUin = paramParcel.readString();
    localTroopTopicDetailInfo.msgSeq = paramParcel.readLong();
    localTroopTopicDetailInfo.bid = paramParcel.readLong();
    localTroopTopicDetailInfo.pid = paramParcel.readString();
    paramParcel.readByteArray(localTroopTopicDetailInfo.detailInfoData);
    if ((localTroopTopicDetailInfo.detailInfoData != null) && (localTroopTopicDetailInfo.detailInfoData.length > 0)) {
      localTroopTopicDetailInfo.detailStructMsg = StructMsgFactory.a(localTroopTopicDetailInfo.detailInfoData, 0);
    }
    localTroopTopicDetailInfo.pVersion = paramParcel.readLong();
    return localTroopTopicDetailInfo;
  }
  
  public TroopTopicDetailInfo[] a(int paramInt)
  {
    return new TroopTopicDetailInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfd
 * JD-Core Version:    0.7.0.1
 */