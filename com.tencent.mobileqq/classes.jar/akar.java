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
import java.net.URLDecoder;

public final class akar
  implements Runnable
{
  public akar(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, BaseActivity paramBaseActivity, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject2;
      Object localObject4;
      try
      {
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("system=android");
          localStringBuilder.append("&version=7.6.3");
          localStringBuilder.append("&uintype=1");
          localObject3 = new StringBuilder().append("&eviluin=");
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            localObject2 = this.b;
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("&appname=KQQ");
            localStringBuilder.append("&appid=2400002");
            localStringBuilder.append("&subapp=" + (String)localObject1);
            localStringBuilder.append("&scene=" + this.jdField_a_of_type_Int);
            if (TextUtils.isEmpty(this.c)) {
              continue;
            }
            localStringBuilder.append("&buddyflag=" + this.c);
            if (!TextUtils.isEmpty(this.d)) {
              localStringBuilder.append("&groupid=" + this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
              break label1013;
            }
            localObject2 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.b, this.d, this.jdField_a_of_type_Int);
            localStringBuilder.append("&srv_para=" + (String)localObject2);
            localStringBuilder.append("&text_evidence=" + "");
            localStringBuilder.append("&img_evidence=" + "");
            localStringBuilder.append("&url_evidence=" + "");
            localStringBuilder.append("&video_evidence=" + "");
            localStringBuilder.append("&file_evidence=" + "");
            localStringBuilder.append("&audio_evidence=" + "");
            localStringBuilder.append("&user_input_param=" + "REPORT_IP=0&EVIL_IP=0");
            localObject3 = "abcdabcdabcdabcd";
            localObject1 = localObject3;
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        StringBuilder localStringBuilder;
        Object localObject3;
        Object localObject1;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new akat(this, localException1));
        return;
      }
      try
      {
        localObject4 = HttpBaseUtil.a("http://jubao.qq.com/uniform_impeach/impeach_cryptokey", "GET", new Bundle()).jdField_a_of_type_JavaLangString;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject3;
          QLog.d("safetyNewReport", 1, "get cryptograph step1 : get response=" + (String)localObject4);
        }
        localObject1 = localObject3;
        localObject3 = NewReportPlugin.a((String)localObject4);
        localObject4 = localObject3;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject3;
          QLog.d("safetyNewReport", 1, "get cryptograph step2 : get encryptedKey=" + (String)localObject3);
          localObject4 = localObject3;
        }
      }
      catch (Exception localException2)
      {
        QLog.d("safetyNewReport", 1, "get cryptograph exception" + localException2.getMessage());
        localObject4 = localException1;
        continue;
        str = this.jdField_a_of_type_JavaLangString;
        continue;
        localObject2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label1123;
        }
        for (str = this.b;; str = this.jdField_a_of_type_JavaLangString)
        {
          str = str + "_" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getCurrentAccountUin() + "_" + localException2;
          break;
        }
        str = "";
      }
      localObject1 = NewReportPlugin.a("d41d8cd98f00b204e9800998ecf8427e", (String)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("safetyNewReport", 1, "get cryptograph step3 : get decryptedKey=" + (String)localObject1);
      }
      localObject1 = "android_7.6.3_" + this.jdField_a_of_type_Int + "_" + (String)localObject1;
      localObject3 = MD5Utils.d((String)localObject1).toUpperCase();
      if (QLog.isColorLevel()) {
        QLog.d("safetyNewReport", 1, "get cryptograph step4 : scretKey=" + (String)localObject3 + ", scretKeyStr=" + (String)localObject1);
      }
      if (this.jdField_a_of_type_Int > 3001)
      {
        localObject4 = new StringBuilder();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject1 = this.b;
          localObject1 = (String)localObject1 + "_" + URLDecoder.decode((String)localObject2, "UTF-8") + "_" + "" + "_" + "" + "_" + "" + "_" + "" + "_" + "" + "_" + "" + "_" + (String)localObject3;
          localObject2 = MD5.toMD5(((String)localObject1).getBytes("UTF-8"));
          if (QLog.isColorLevel()) {
            QLog.d("safetyNewReport", 1, "get cryptograph step5 : get cryptograph=" + (String)localObject2 + ", cryptographStr=" + (String)localObject1);
          }
          localStringBuilder.append("&cryptograph=" + (String)localObject2);
          localObject1 = localStringBuilder.toString();
          if (QLog.isColorLevel()) {
            QLog.d("safetyNewReport", 1, "postData=" + (String)localObject1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new akas(this, (String)localObject1));
          return;
          localObject2 = this.jdField_a_of_type_JavaLangString;
          continue;
          localStringBuilder.append("&buddyflag=0");
          continue;
          label1013:
          localObject2 = this.e;
          continue;
        }
      }
      label1123:
      continue;
      String str = "c2c_honest_say";
      continue;
      str = "nearby_kuoli";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akar
 * JD-Core Version:    0.7.0.1
 */