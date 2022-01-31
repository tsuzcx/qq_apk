import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;

public final class akpo
  implements Parcelable.Creator<ArConfigInfo>
{
  public ArConfigInfo a(Parcel paramParcel)
  {
    return new ArConfigInfo(paramParcel);
  }
  
  public ArConfigInfo[] a(int paramInt)
  {
    return new ArConfigInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akpo
 * JD-Core Version:    0.7.0.1
 */