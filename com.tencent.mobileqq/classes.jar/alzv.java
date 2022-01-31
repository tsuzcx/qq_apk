import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class alzv
  extends OnPluginInstallListener.Stub
{
  public alzv(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    String str = String.valueOf(paramInt);
    paramString = "个性化插件";
    if (this.a.b == QQIndividualityBridgeActivity.c) {
      paramString = "斗图";
    }
    for (;;)
    {
      IPluginManager.a(str, paramString);
      int i = NetworkUtil.a(this.a);
      QLog.e("QQIndividuality", 2, "install plugin fail: " + paramInt + " and netType = " + i);
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.c(this.a);
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X8006A98", 0, 0, str, String.valueOf(i), "", "");
      return;
      if (this.a.b == QQIndividualityBridgeActivity.d) {
        paramString = "个签";
      } else if (this.a.b == QQIndividualityBridgeActivity.e) {
        paramString = "历史签名";
      }
    }
  }
  
  public void onInstallFinish(String paramString)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzv
 * JD-Core Version:    0.7.0.1
 */