import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;

public final class aalj
  implements Parcelable.Creator<CommodityBean>
{
  public CommodityBean a(Parcel paramParcel)
  {
    return new CommodityBean(paramParcel);
  }
  
  public CommodityBean[] a(int paramInt)
  {
    return new CommodityBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalj
 * JD-Core Version:    0.7.0.1
 */