import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.filemanager.data.FileInfo;

public final class acqp
  implements Parcelable.Creator
{
  public FileInfo a(Parcel paramParcel)
  {
    return new FileInfo(paramParcel, null);
  }
  
  public FileInfo[] a(int paramInt)
  {
    return new FileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */