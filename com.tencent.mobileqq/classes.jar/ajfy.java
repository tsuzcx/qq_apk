import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajfy
  implements EIPCResultCallback
{
  public ajfy(ajga paramajga) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShow_CmShowRenderView", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtil.b("changeApolloStatus code:" + paramEIPCResult.code);
    ajga localajga;
    if (this.a != null)
    {
      localajga = this.a;
      if (paramEIPCResult.code != 0) {
        break label82;
      }
    }
    for (;;)
    {
      localajga.a(bool);
      return;
      label82:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfy
 * JD-Core Version:    0.7.0.1
 */