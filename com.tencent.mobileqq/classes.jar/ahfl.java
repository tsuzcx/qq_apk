import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedDisplayInfo;
import java.util.ArrayList;

public final class ahfl
  implements Parcelable.Creator
{
  public RedAppInfo a(Parcel paramParcel)
  {
    RedAppInfo localRedAppInfo = new RedAppInfo();
    RedAppInfo.a(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.b(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, paramParcel.readString());
    RedAppInfo.b(localRedAppInfo, paramParcel.readString());
    RedAppInfo.d(localRedAppInfo, paramParcel.readInt());
    localRedAppInfo.a = new ArrayList();
    paramParcel.readList(localRedAppInfo.a, null);
    RedAppInfo.e(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.f(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.c(localRedAppInfo, paramParcel.readString());
    RedAppInfo.g(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.h(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.i(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.j(localRedAppInfo, paramParcel.readInt());
    RedAppInfo.a(localRedAppInfo, (RedDisplayInfo)paramParcel.readParcelable(getClass().getClassLoader()));
    return localRedAppInfo;
  }
  
  public RedAppInfo[] a(int paramInt)
  {
    return new RedAppInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahfl
 * JD-Core Version:    0.7.0.1
 */