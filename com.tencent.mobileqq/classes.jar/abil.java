import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity.LoadingTimeStamp;

public final class abil
  implements Parcelable.Creator
{
  public ARMapLoadingActivity.LoadingTimeStamp a(Parcel paramParcel)
  {
    return new ARMapLoadingActivity.LoadingTimeStamp(paramParcel);
  }
  
  public ARMapLoadingActivity.LoadingTimeStamp[] a(int paramInt)
  {
    return new ARMapLoadingActivity.LoadingTimeStamp[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abil
 * JD-Core Version:    0.7.0.1
 */