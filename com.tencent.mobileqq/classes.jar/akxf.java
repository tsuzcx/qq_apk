import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class akxf
  implements EIPCResultCallback
{
  public akxf(alga paramalga) {}
  
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
    alef.au = paramEIPCResult.getString("sApolloBaseScriptId");
    akji.q = paramEIPCResult.getBoolean("sDisableCreateRenderThread");
    alef.av = alef.a + "/script/" + alef.au + "/";
    if (alfz.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      alfz.b(this.a);
      alfz.a(this.a);
      alfz.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxf
 * JD-Core Version:    0.7.0.1
 */