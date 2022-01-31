import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.olympic.ShuayishuaConfig;

public final class agei
  implements Parcelable.Creator
{
  public ShuayishuaConfig a(Parcel paramParcel)
  {
    return new ShuayishuaConfig(paramParcel);
  }
  
  public ShuayishuaConfig[] a(int paramInt)
  {
    return new ShuayishuaConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agei
 * JD-Core Version:    0.7.0.1
 */