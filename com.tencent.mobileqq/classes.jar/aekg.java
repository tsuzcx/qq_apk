import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.music.SongInfo;

public final class aekg
  implements Parcelable.Creator
{
  public SongInfo a(Parcel paramParcel)
  {
    return new SongInfo(paramParcel, null);
  }
  
  public SongInfo[] a(int paramInt)
  {
    return new SongInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekg
 * JD-Core Version:    0.7.0.1
 */