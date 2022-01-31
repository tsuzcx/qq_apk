import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;

public final class ahzn
  implements Parcelable.Creator<WordingItem>
{
  public WordingItem a(Parcel paramParcel)
  {
    return new WordingItem(paramParcel);
  }
  
  public WordingItem[] a(int paramInt)
  {
    return new WordingItem[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzn
 * JD-Core Version:    0.7.0.1
 */