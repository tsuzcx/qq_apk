import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.webview.sonic.SonicPreloadData;

public final class akuf
  implements Parcelable.Creator
{
  public SonicPreloadData a(Parcel paramParcel)
  {
    return new SonicPreloadData(paramParcel);
  }
  
  public SonicPreloadData[] a(int paramInt)
  {
    return new SonicPreloadData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akuf
 * JD-Core Version:    0.7.0.1
 */