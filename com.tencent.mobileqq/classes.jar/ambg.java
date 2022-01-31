import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;

public final class ambg
  implements Parcelable.Creator
{
  public LbsDataV2.PoiInfo a(Parcel paramParcel)
  {
    LbsDataV2.PoiInfo localPoiInfo = new LbsDataV2.PoiInfo();
    if (paramParcel != null)
    {
      localPoiInfo.poiId = paramParcel.readString();
      localPoiInfo.poiName = paramParcel.readString();
      localPoiInfo.poiType = paramParcel.readInt();
      localPoiInfo.poiTypeName = paramParcel.readString();
      localPoiInfo.poiDefaultName = paramParcel.readString();
      localPoiInfo.address = paramParcel.readString();
      localPoiInfo.districtCode = paramParcel.readInt();
      localPoiInfo.distance = paramParcel.readInt();
      localPoiInfo.hotValue = paramParcel.readInt();
      localPoiInfo.phoneNumber = paramParcel.readString();
      localPoiInfo.poiOrderType = paramParcel.readInt();
      localPoiInfo.poiNum = paramParcel.readInt();
      localPoiInfo.dianPingId = paramParcel.readString();
      localPoiInfo.gpsInfo = ((LbsDataV2.GpsInfo)paramParcel.readParcelable(LbsDataV2.GpsInfo.class.getClassLoader()));
      localPoiInfo.show_poi = paramParcel.readInt();
    }
    return localPoiInfo;
  }
  
  public LbsDataV2.PoiInfo[] a(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambg
 * JD-Core Version:    0.7.0.1
 */