import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class albu
  implements EIPCResultCallback
{
  public albu(alkp paramalkp) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    if (paramEIPCResult == null)
    {
      this.a.a(1);
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk resp == null");
      return;
    }
    aliu.au = paramEIPCResult.getString("sApolloBaseScriptId");
    aknx.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    aliu.av = aliu.a + "/script/" + aliu.au + "/";
    if (alko.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      alko.b(this.a);
      alko.a(this.a);
      alko.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albu
 * JD-Core Version:    0.7.0.1
 */