import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;

public final class alpk
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    if (MyAppApi.h())
    {
      if (TMAssistantCallYYB_V2.getInstance().getIPCInterface() != null) {
        break label70;
      }
      LogUtility.b("TAMST_WAKE", "getIPCInterface() == null");
      OuterCallReportModel localOuterCallReportModel = MyAppApi.a();
      MyAppApi.a(localOuterCallReportModel);
      MyAppApi.b(localOuterCallReportModel);
      ControlPolicyUtil.b();
    }
    for (;;)
    {
      LogUtility.c("TAMST_WAKE", "costTime = " + (System.currentTimeMillis() - l));
      return;
      label70:
      LogUtility.b("TAMST_WAKE", "don't need tmast wake");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alpk
 * JD-Core Version:    0.7.0.1
 */