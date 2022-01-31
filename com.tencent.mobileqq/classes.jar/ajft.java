import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ajft
  implements EIPCResultCallback
{
  public ajft(ajon paramajon) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    ajms.au = paramEIPCResult.data.getString("sApolloBaseScriptId");
    ajms.av = ajms.a + "/script/" + ajms.au + "/";
    if (ajom.a()) {
      this.a.a(0);
    }
    for (;;)
    {
      QLog.i("CmShow_CmShowRenderView", 1, "initSdk");
      return;
      ajom.b(this.a);
      ajom.a(this.a);
      ajom.a("sdk");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajft
 * JD-Core Version:    0.7.0.1
 */