import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.qphone.base.util.QLog;

public final class akhy
  implements Runnable
{
  public akhy(int paramInt, String paramString1, String paramString2, String paramString3, BaseActivity paramBaseActivity, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    Object localObject = "";
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("system=android");
          localStringBuilder.append("&");
          localStringBuilder.append("version=7.6.8");
          localStringBuilder.append("&");
          localStringBuilder.append("uintype=1");
          localStringBuilder.append("&");
          localStringBuilder.append("eviluin=" + this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("&");
          localStringBuilder.append("appname=KQQ");
          localStringBuilder.append("&");
          localStringBuilder.append("appid=2400002");
          localStringBuilder.append("&");
          localStringBuilder.append("subapp=" + (String)localObject);
          localStringBuilder.append("&");
          if (this.jdField_a_of_type_Int == 10000)
          {
            localStringBuilder.append("scene=10028");
            if (this.jdField_a_of_type_Int == 11011) {
              localStringBuilder.append("&groupid=").append(this.b);
            }
            localStringBuilder.append("&");
            if (!TextUtils.isEmpty(this.c)) {
              break label780;
            }
            localStringBuilder.append("srv_para=" + ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int));
            if (this.jdField_a_of_type_Int != 1102)
            {
              str2 = "abcdabcdabcdabcd";
              localObject = str2;
            }
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        String str2;
        String str3;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new akia(this, localException1));
        return;
      }
      try
      {
        str3 = HttpBaseUtil.a("http://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).jdField_a_of_type_JavaLangString;
        localObject = str2;
        QLog.d("cryptograph", 1, "get cryptograph step1 : get response=" + str3);
        localObject = str2;
        str2 = NewReportPlugin.a(str3);
        localObject = str2;
        QLog.d("cryptograph", 1, "get cryptograph step2 : get encryptedKey=" + str2);
        localObject = str2;
      }
      catch (Exception localException2)
      {
        QLog.d("cryptograph", 1, "get cryptograph exception" + localException2.getMessage());
        continue;
        if (this.jdField_a_of_type_Int != 10000) {
          continue;
        }
        localStringBuilder.append("|groupid:" + this.b);
        localStringBuilder.append("|SubEntrence:4");
        continue;
      }
      localObject = NewReportPlugin.a("d41d8cd98f00b204e9800998ecf8427e", (String)localObject);
      QLog.d("cryptograph", 1, "get cryptograph step3 : get decryptedKey=" + (String)localObject);
      localObject = MD5Utils.d("android_7.6.8_" + this.jdField_a_of_type_Int + "_" + (String)localObject);
      localObject = MD5Utils.d(this.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin() + "_" + (String)localObject);
      QLog.d("cryptograph", 1, "get cryptograph step4 : get cryptograph=" + (String)localObject);
      localStringBuilder.append("&cryptograph=" + (String)localObject);
      if ((this.jdField_a_of_type_Int == 1101) || (this.jdField_a_of_type_Int == 10026) || (this.jdField_a_of_type_Int == 10027))
      {
        if (!TextUtils.isEmpty(this.b)) {
          localStringBuilder.append("|groupid:" + this.b);
        }
        localObject = localStringBuilder.toString();
        QLog.d("cryptograph", 1, "postData=" + (String)localObject);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new akhz(this, (String)localObject));
        return;
        localStringBuilder.append("scene=" + this.jdField_a_of_type_Int);
        continue;
        label780:
        localStringBuilder.append("srv_para=" + this.c);
      }
      else
      {
        continue;
        String str1 = "c2c";
        continue;
        str1 = "group";
        continue;
        str1 = "group_info";
        continue;
        str1 = "invite_togroup";
        continue;
        str1 = "discuss";
        continue;
        str1 = "nearby_info";
        continue;
        str1 = "c2c_chat";
        continue;
        str1 = "c2c_info";
        continue;
        str1 = "nearby_chat";
        continue;
        str1 = "person_in_group";
        continue;
        str1 = "nearby_kuoli";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhy
 * JD-Core Version:    0.7.0.1
 */