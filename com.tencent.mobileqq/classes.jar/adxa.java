import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.music.SongInfo;

public final class adxa
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adxa
 * JD-Core Version:    0.7.0.1
 */