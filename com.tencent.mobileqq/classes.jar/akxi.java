import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class akxi
  implements EIPCResultCallback
{
  public akxi(akxk paramakxk) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShow_CmShowRenderView", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtil.b("changeApolloStatus code:" + paramEIPCResult.code);
    akxk localakxk;
    if (this.a != null)
    {
      localakxk = this.a;
      if (paramEIPCResult.code != 0) {
        break label82;
      }
    }
    for (;;)
    {
      localakxk.a(bool);
      return;
      label82:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxi
 * JD-Core Version:    0.7.0.1
 */