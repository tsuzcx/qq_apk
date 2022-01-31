import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

public class alcf
  extends SSOAccountObserver
{
  public alcf(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QuickLoginAuthorityActivity", 1, "-->onFailed--action = " + paramInt1 + ", ret = " + paramInt2 + ", ssoAccount = *" + AuthorityUtil.a(paramString));
    }
    this.a.g();
    if (paramInt2 == -1000)
    {
      this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, this.a.getResources().getString(2131435603));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    if (paramBundle == null) {}
    for (paramBundle = this.a.getString(2131435610);; paramBundle = paramBundle.getMessage())
    {
      QQToast.a(BaseApplicationImpl.getContext(), paramBundle + "(" + paramInt2 + ")", 0).a();
      this.a.a(paramString);
      return;
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickLoginAuthorityActivity", 2, "-->onGetA1WithA1--ret = " + paramInt1 + ", ssoAccount = *" + AuthorityUtil.a(paramString));
    }
    paramString = "" + this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.a.jdField_a_of_type_JavaLangString = paramString;
    paramString = new WloginSimpleInfo();
    this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.a.jdField_a_of_type_JavaLangString, paramString);
    paramArrayOfByte = new RSACrypt(this.a).EncryptData(this.a.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    paramString = (ErrMsg)paramBundle.getParcelable("errMsg");
    paramBundle = this.a;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getMessage())
    {
      paramBundle.a(paramInt1, paramArrayOfByte, str, paramString);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("QuickLoginAuthorityActivity", 2, "-->onGetTicketNoPasswd--ssoAccount = *" + AuthorityUtil.a(paramString));
    }
    if ((this.a.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.a.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
      QuickLoginAuthorityActivity.a(this.a);
    }
    while (!this.a.jdField_a_of_type_AndroidOsBundle.containsKey("p")) {
      return;
    }
    paramBundle = "";
    if (paramInt == 32) {
      paramBundle = util.buf_to_string(paramArrayOfByte);
    }
    String str = this.a.jdField_a_of_type_AndroidOsBundle.getString("p");
    paramArrayOfByte = str;
    if (!TextUtils.isEmpty(str))
    {
      paramArrayOfByte = str;
      if (!str.endsWith("&")) {
        paramArrayOfByte = str + "&";
      }
    }
    paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramBundle);
    str = paramArrayOfByte + paramString;
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
    paramString = this.a.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.startsWith("mttbrowser://")) {}
    }
    for (paramString = "com.tencent.mtt";; paramString = null) {
      for (;;)
      {
        paramBundle = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          paramArrayOfByte = Uri.parse(paramArrayOfByte).getQueryParameter("pt_browser");
          paramBundle = paramString;
          if (!TextUtils.isEmpty(paramArrayOfByte))
          {
            paramBundle = paramString;
            if ("LieBaoFast".equals(paramArrayOfByte)) {
              paramBundle = "com.ijinshan.browser_fast";
            }
          }
        }
        paramString = localObject;
        if (!TextUtils.isEmpty(paramBundle)) {}
        try
        {
          paramString = this.a.getPackageManager().getPackageInfo(paramBundle, 0);
          if (paramString != null)
          {
            localIntent.setPackage(paramBundle);
            localIntent.setData(Uri.parse(str));
          }
        }
        catch (PackageManager.NameNotFoundException paramString)
        {
          try
          {
            this.a.startActivity(localIntent);
            this.a.f();
            return;
            if (paramString.startsWith("ucweb://"))
            {
              paramString = "com.UCMobile";
            }
            else if (paramString.startsWith("bdbrowser://"))
            {
              paramString = "com.baidu.browser.apps";
            }
            else if (paramString.startsWith("bdapp://"))
            {
              paramString = "com.baidu.searchbox";
            }
            else if (paramString.startsWith("googlechrome://"))
            {
              paramString = "com.android.chrome";
            }
            else if (paramString.startsWith("mzbrowser://"))
            {
              paramString = "com.android.browser";
            }
            else if (paramString.startsWith("lb://"))
            {
              paramString = "com.ijinshan.browser_fast";
            }
            else if (paramString.startsWith("qihoobrowser://"))
            {
              paramString = "com.qihoo.browser";
            }
            else if (paramString.startsWith("browser2345://"))
            {
              paramString = "com.browser2345";
            }
            else if (paramString.startsWith("SogouMSE://"))
            {
              paramString = "sogou.mobile.explorer";
              continue;
              paramString = paramString;
              paramString.printStackTrace();
              paramString = localObject;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SSOAccountObserver", 2, "startActivity :" + paramString.getMessage());
              }
            }
          }
        }
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QuickLoginAuthorityActivity", 2, "-->onUserCancel--action = " + paramInt + ", ssoAccount = *" + AuthorityUtil.a(paramString));
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alcf
 * JD-Core Version:    0.7.0.1
 */