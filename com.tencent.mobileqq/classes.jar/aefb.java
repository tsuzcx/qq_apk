import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;

class aefb
  implements WxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener
{
  aefb(aeez paramaeez) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131435319);
      bool = false;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_JavaLangString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.callJs(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(bool) });
        return;
        QRUtils.a(2, 2131435318);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
        {
          int i;
          label171:
          String str1;
          String str2;
          String str3;
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
          {
            i = 1009;
            paramBaseResp = this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.f();
            str1 = this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.g();
            str2 = this.a.b;
            str3 = AccountDetailActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.b());
            String str4 = this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.h();
            if ((str4 == null) || ("".equals(str4))) {
              break label314;
            }
            PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.b(), str3, false);
          }
          for (;;)
          {
            bool = true;
            break;
            i = 1004;
            break label171;
            label314:
            if ("2".equals(this.a.jdField_a_of_type_JavaLangString)) {
              i = 1003;
            }
            PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
          }
          bool = false;
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.callJs4OpenApiIfNeeded("shareMsg", 0, String.valueOf(bool));
        return;
      }
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefb
 * JD-Core Version:    0.7.0.1
 */