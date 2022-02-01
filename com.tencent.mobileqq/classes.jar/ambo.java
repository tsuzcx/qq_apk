import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ambo
  implements EIPCResultCallback
{
  public ambo(amkm paramamkm) {}
  
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
    amip.au = paramEIPCResult.getString("sApolloBaseScriptId");
    alnr.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    alnr.r = paramEIPCResult.getBoolean("sApolloEngineLockEnable");
    amip.av = amip.a + "/script/" + amip.au + "/";
    if (amkk.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      amkk.b(this.a);
      amkk.a(this.a);
      amkk.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambo
 * JD-Core Version:    0.7.0.1
 */