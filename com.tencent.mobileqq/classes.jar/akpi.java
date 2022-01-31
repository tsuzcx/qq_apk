import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public final class akpi
  implements Parcelable.Creator<ARCommonConfigInfo>
{
  public ARCommonConfigInfo a(Parcel paramParcel)
  {
    return new ARCommonConfigInfo(paramParcel);
  }
  
  public ARCommonConfigInfo[] a(int paramInt)
  {
    return new ARCommonConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akpi
 * JD-Core Version:    0.7.0.1
 */