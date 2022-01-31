import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajfv
  implements EIPCResultCallback
{
  public ajfv(ajop paramajop) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    ajmu.au = paramEIPCResult.data.getString("sApolloBaseScriptId");
    ajmu.av = ajmu.a + "/script/" + ajmu.au + "/";
    if (ajoo.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      ajoo.b(this.a);
      ajoo.a(this.a);
      ajoo.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajfv
 * JD-Core Version:    0.7.0.1
 */