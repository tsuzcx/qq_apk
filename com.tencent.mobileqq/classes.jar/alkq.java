import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;

public final class alkq
  implements Parcelable.Creator<ArFeatureInfo>
{
  public ArFeatureInfo a(Parcel paramParcel)
  {
    return new ArFeatureInfo(paramParcel);
  }
  
  public ArFeatureInfo[] a(int paramInt)
  {
    return new ArFeatureInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alkq
 * JD-Core Version:    0.7.0.1
 */