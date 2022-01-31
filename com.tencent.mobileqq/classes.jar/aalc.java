import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;

public final class aalc
  implements Parcelable.Creator
{
  public ARScanStarFaceActInfo a(Parcel paramParcel)
  {
    return new ARScanStarFaceActInfo(paramParcel);
  }
  
  public ARScanStarFaceActInfo[] a(int paramInt)
  {
    return new ARScanStarFaceActInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aalc
 * JD-Core Version:    0.7.0.1
 */