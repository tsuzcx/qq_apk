import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.Statistic;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public final class ajmm
  implements Runnable
{
  public ajmm(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BaseActivity paramBaseActivity, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("system=android");
          localStringBuilder.append("&version=7.6.0");
          localStringBuilder.append("&uintype=1");
          localObject = new StringBuilder().append("&eviluin=");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            str3 = this.b;
            localStringBuilder.append(str3);
            localStringBuilder.append("&appname=KQQ");
            localStringBuilder.append("&appid=2400002");
            localStringBuilder.append("&subapp=" + str1);
            localStringBuilder.append("&scene=" + this.jdField_a_of_type_Int);
            if (TextUtils.isEmpty(this.c)) {
              continue;
            }
            localStringBuilder.append("&buddyflag=" + this.c);
            if (!TextUtils.isEmpty(this.d)) {
              localStringBuilder.append("&groupid=" + this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
              break label928;
            }
            str1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.b, this.d, this.jdField_a_of_type_Int);
            localStringBuilder.append("&srv_para=" + str1);
            localStringBuilder.append("&text_evidence=" + "");
            localStringBuilder.append("&img_evidence=" + "");
            localStringBuilder.append("&url_evidence=" + "");
            localStringBuilder.append("&video_evidence=" + "");
            localStringBuilder.append("&file_evidence=" + "");
            localStringBuilder.append("&audio_evidence=" + "");
            localStringBuilder.append("&user_input_param=" + "REPORT_IP=0&EVIL_IP=0");
            str3 = "abcdabcdabcdabcd";
            str1 = str3;
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder;
        String str3;
        String str1;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ajmo(this, localException1));
        return;
      }
      try
      {
        localObject = HttpBaseUtil.a("http://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).jdField_a_of_type_JavaLangString;
        str1 = str3;
        if (QLog.isColorLevel())
        {
          str1 = str3;
          QLog.d("safetyNewReport", 1, "get cryptograph step1 : get response=" + (String)localObject);
        }
        str1 = str3;
        str3 = NewReportPlugin.a((String)localObject);
        localObject = str3;
        str1 = str3;
        if (QLog.isColorLevel())
        {
          str1 = str3;
          QLog.d("safetyNewReport", 1, "get cryptograph step2 : get encryptedKey=" + str3);
          localObject = str3;
        }
      }
      catch (Exception localException2)
      {
        QLog.d("safetyNewReport", 1, "get cryptograph exception" + localException2.getMessage());
        localObject = str2;
        continue;
        str2 = this.jdField_a_of_type_JavaLangString;
        continue;
        str2 = "";
      }
      str1 = NewReportPlugin.a("d41d8cd98f00b204e9800998ecf8427e", (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("safetyNewReport", 1, "get cryptograph step3 : get decryptedKey=" + str1);
      }
      str1 = "android_7.6.0_" + this.jdField_a_of_type_Int + "_" + str1;
      str3 = MD5Utils.d(str1).toUpperCase();
      if (QLog.isColorLevel()) {
        QLog.d("safetyNewReport", 1, "get cryptograph step4 : scretKey=" + str3 + ", scretKeyStr=" + str1);
      }
      Object localObject = new StringBuilder();
      label928:
      String str2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str1 = this.b;
        str1 = str1 + "_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin() + "_" + str3;
        str3 = MD5.toMD5(str1.getBytes("UTF-8"));
        if (QLog.isColorLevel()) {
          QLog.d("safetyNewReport", 1, "get cryptograph step5 : get cryptograph=" + str3 + ", cryptographStr=" + str1);
        }
        localStringBuilder.append("&cryptograph=" + str3);
        str1 = localStringBuilder.toString();
        if (QLog.isColorLevel()) {
          QLog.d("safetyNewReport", 1, "postData=" + str1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new ajmn(this, str1));
        return;
        str3 = this.jdField_a_of_type_JavaLangString;
        continue;
        localStringBuilder.append("&buddyflag=0");
        continue;
        str2 = this.e;
      }
      else
      {
        continue;
        str2 = "c2c_honest_say";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajmm
 * JD-Core Version:    0.7.0.1
 */