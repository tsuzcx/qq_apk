import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import java.lang.ref.WeakReference;

final class aaon
  implements VSDispatchObserver.onVSRspCallBack<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<aaoj> a;
  
  public aaon(aaoj paramaaoj)
  {
    this.a = new WeakReference(paramaaoj);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramVSBaseRequest = (aaoj)this.a.get();
    if (paramVSBaseRequest == null) {}
    do
    {
      return;
      paramVSBaseRequest.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    aaoj.a(paramVSBaseRequest, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaon
 * JD-Core Version:    0.7.0.1
 */