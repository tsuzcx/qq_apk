import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class akbn
  implements TroopMemberApiClient.Callback
{
  public akbn(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler) {}
  
  public void a(Bundle paramBundle)
  {
    int i = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "config = " + i);
    }
    if (i == 0) {
      WxShareHelperFromReadInjoy.a().a(this.a.g, this.a.b, 1, false);
    }
    for (;;)
    {
      this.a.b.recycle();
      this.a.b = null;
      return;
      WXShareHelper.a().a(this.a.g, this.a.b, 1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akbn
 * JD-Core Version:    0.7.0.1
 */