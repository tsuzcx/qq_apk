import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituImgResponse;

public final class ahbe
  implements Parcelable.Creator<ZhituImgResponse>
{
  public ZhituImgResponse a(Parcel paramParcel)
  {
    return new ZhituImgResponse(paramParcel);
  }
  
  public ZhituImgResponse[] a(int paramInt)
  {
    return new ZhituImgResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbe
 * JD-Core Version:    0.7.0.1
 */