import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.config.ShopScanCheckHandler.Info;

public final class aayq
  implements Parcelable.Creator
{
  public ShopScanCheckHandler.Info a(Parcel paramParcel)
  {
    return new ShopScanCheckHandler.Info(paramParcel);
  }
  
  public ShopScanCheckHandler.Info[] a(int paramInt)
  {
    return new ShopScanCheckHandler.Info[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayq
 * JD-Core Version:    0.7.0.1
 */