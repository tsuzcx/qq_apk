import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.TroopClipPic;

public final class aipv
  implements Parcelable.Creator<TroopClipPic>
{
  public TroopClipPic a(Parcel paramParcel)
  {
    return new TroopClipPic(paramParcel);
  }
  
  public TroopClipPic[] a(int paramInt)
  {
    return new TroopClipPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipv
 * JD-Core Version:    0.7.0.1
 */