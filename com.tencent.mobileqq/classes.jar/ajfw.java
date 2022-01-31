import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajfw
  implements EIPCResultCallback
{
  public ajfw(ajfy paramajfy) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool = true;
    QLog.i("CmShow_CmShowRenderView", 1, "changeApolloStatus ipc code:" + paramEIPCResult.code);
    ApolloUtil.b("changeApolloStatus code:" + paramEIPCResult.code);
    ajfy localajfy;
    if (this.a != null)
    {
      localajfy = this.a;
      if (paramEIPCResult.code != 0) {
        break label82;
      }
    }
    for (;;)
    {
      localajfy.a(bool);
      return;
      label82:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfw
 * JD-Core Version:    0.7.0.1
 */