import android.arch.lifecycle.ViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

public abstract class aabb
  extends ViewModel
{
  protected int a = -1;
  protected vua a;
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, aaav paramaaav)
  {
    VSNetworkHelper.a().a(paramInt, paramVSBaseRequest, paramaaav);
    if (paramVSBaseRequest != null) {
      QLog.d(a(), 1, a() + "->sendQCircleRequest: CmdName:" + paramVSBaseRequest.getCmdName() + "| TraceId:" + paramVSBaseRequest.getTraceId() + " | SeqId:" + paramVSBaseRequest.getCurrentSeq());
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, aaav paramaaav)
  {
    a(this.a, paramVSBaseRequest, paramaaav);
  }
  
  protected void a(Object[] paramArrayOfObject) {}
  
  public void d(String paramString)
  {
    QLog.d(a(), 1, "loadPreloadResult:" + paramString);
    aadg.a(paramString, new aabc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabb
 * JD-Core Version:    0.7.0.1
 */