import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public final class ahml
  implements Parcelable.Creator
{
  public MusicItemInfo a(Parcel paramParcel)
  {
    return new MusicItemInfo(paramParcel);
  }
  
  public MusicItemInfo[] a(int paramInt)
  {
    return new MusicItemInfo[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahml
 * JD-Core Version:    0.7.0.1
 */