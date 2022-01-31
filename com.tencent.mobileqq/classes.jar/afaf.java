import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituResponse;

public final class afaf
  implements Parcelable.Creator<ZhituResponse>
{
  public ZhituResponse a(Parcel paramParcel)
  {
    return new ZhituResponse(paramParcel);
  }
  
  public ZhituResponse[] a(int paramInt)
  {
    return new ZhituResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afaf
 * JD-Core Version:    0.7.0.1
 */