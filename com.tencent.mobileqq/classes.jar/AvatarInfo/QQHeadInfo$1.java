package AvatarInfo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QQHeadInfo$1
  implements Parcelable.Creator<QQHeadInfo>
{
  public QQHeadInfo a(Parcel paramParcel)
  {
    QQHeadInfo localQQHeadInfo = new QQHeadInfo();
    localQQHeadInfo.readFromParcel(paramParcel);
    return localQQHeadInfo;
  }
  
  public QQHeadInfo[] a(int paramInt)
  {
    return new QQHeadInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AvatarInfo.QQHeadInfo.1
 * JD-Core Version:    0.7.0.1
 */