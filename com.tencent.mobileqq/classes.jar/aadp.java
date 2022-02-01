import android.os.Handler;
import com.tencent.biz.richframework.sender.Interceptor.OfflineAndRetryInterceptor.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;

public class aadp
  implements aadq
{
  public String a()
  {
    return "OfflineAndRetryInterceptor";
  }
  
  public void a(Object paramObject, aadu paramaadu)
  {
    if ((paramObject == null) || (paramaadu == null)) {
      return;
    }
    if (!nny.a(BaseApplication.getContext()))
    {
      ThreadManagerV2.getUIHandlerV2().post(new OfflineAndRetryInterceptor.1(this));
      paramaadu.a(false, -1L, "", paramObject, null);
      return;
    }
    paramaadu.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadp
 * JD-Core Version:    0.7.0.1
 */