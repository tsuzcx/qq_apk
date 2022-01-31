import android.os.Parcel;
import android.os.Parcelable.Creator;
import cooperation.qqpim.QQPimTipsInfo;

public final class amao
  implements Parcelable.Creator
{
  public QQPimTipsInfo a(Parcel paramParcel)
  {
    return new QQPimTipsInfo(paramParcel, null);
  }
  
  public QQPimTipsInfo[] a(int paramInt)
  {
    return new QQPimTipsInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amao
 * JD-Core Version:    0.7.0.1
 */