import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.ar.model.ArLBSActivity;

public final class aakv
  implements Parcelable.Creator
{
  public ArLBSActivity a(Parcel paramParcel)
  {
    return new ArLBSActivity(paramParcel);
  }
  
  public ArLBSActivity[] a(int paramInt)
  {
    return new ArLBSActivity[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakv
 * JD-Core Version:    0.7.0.1
 */