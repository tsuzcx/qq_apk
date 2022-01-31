import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

public class aeez
  implements Runnable
{
  public aeez(QQApiPlugin paramQQApiPlugin, String paramString1, String paramString2, int paramInt, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    int j = 0;
    int i = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.mRuntime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.a((Activity)localObject);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new aefa(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener = new aefb(this);
      WxShareHelperFromReadInjoy.a().a(this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if ("audio".equals(this.c))
    {
      localWXShareHelper = WXShareHelper.a();
      str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c;
      str2 = this.d;
      str3 = this.e;
      str4 = this.b;
      if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i, this.f);
        return;
        i = 1;
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new aefc(this, (Bitmap)localObject));
      return;
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c;
    String str2 = this.d;
    String str3 = this.e;
    String str4 = this.b;
    if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (i = j;; i = 1)
    {
      localWXShareHelper.b(str1, str2, (Bitmap)localObject, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeez
 * JD-Core Version:    0.7.0.1
 */