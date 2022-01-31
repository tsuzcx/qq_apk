import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.intervideo.IVPluginInfo;

public final class aebp
  implements Parcelable.Creator
{
  public IVPluginInfo a(Parcel paramParcel)
  {
    return new IVPluginInfo(paramParcel);
  }
  
  public IVPluginInfo[] a(int paramInt)
  {
    return new IVPluginInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebp
 * JD-Core Version:    0.7.0.1
 */