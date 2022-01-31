import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;

public class aahp
  implements aagu
{
  private aahp(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((!"ScanCode".equals(paramString)) || (paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {}
    for (;;)
    {
      return false;
      long l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
      paramString = new Intent();
      paramString.setClassName("com.tencent.mobileqq", "com.tencent.biz.qrcode.activity.ScannerActivity");
      paramString.putExtra("from", ArkAppDeviceModule.class.getName());
      paramString.putExtra("finishAfterSucc", true);
      if (ArkAppDeviceModule.a(this.a) != null) {}
      try
      {
        BaseApplicationImpl.getApplication().unregisterReceiver(ArkAppDeviceModule.a(this.a));
        label105:
        ArkAppDeviceModule.a(this.a, null);
        ArkAppDeviceModule.a(this.a, new aahq(this, l));
        paramArrayOfVariantWrapper = new IntentFilter("com.tencent.mobileqq.ark.API.scanResultAction");
        BaseApplicationImpl.getApplication().registerReceiver(ArkAppDeviceModule.a(this.a), paramArrayOfVariantWrapper, "com.tencent.msg.permission.pushnotify", null);
        paramArrayOfVariantWrapper = BaseActivity.sTopActivity;
        if (paramArrayOfVariantWrapper == null) {
          continue;
        }
        paramArrayOfVariantWrapper.startActivity(paramString);
        return false;
      }
      catch (Exception paramArrayOfVariantWrapper)
      {
        break label105;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */