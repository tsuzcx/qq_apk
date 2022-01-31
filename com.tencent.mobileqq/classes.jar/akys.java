import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.utils.WebStateReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akys
  implements Runnable
{
  public akys(WebStateReporter paramWebStateReporter, boolean paramBoolean, String paramString1, Context paramContext, long paramLong, String paramString2) {}
  
  public void run()
  {
    boolean bool3 = this.jdField_a_of_type_Boolean;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bool2 = bool3;
    }
    for (;;)
    {
      try
      {
        localObject = Uri.parse(this.jdField_a_of_type_JavaLangString);
        bool2 = bool3;
        str1 = ((Uri)localObject).getQueryParameter("hasRedDot");
        bool1 = bool3;
        bool2 = bool3;
        if (!TextUtils.isEmpty(str1))
        {
          bool2 = bool3;
          bool1 = str1.equalsIgnoreCase("1");
        }
        bool2 = bool1;
        localObject = ((Uri)localObject).getQueryParameter("crashFrom");
        bool2 = bool1;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        bool2 = bool1;
        i = Integer.parseInt((String)localObject);
      }
      catch (Exception localException1)
      {
        String str1;
        int i = -1;
        boolean bool1 = bool2;
        if (QLog.isColorLevel()) {
          QLog.e("WebStateReporter_report", 2, "parse url got some problem!", localException1);
        }
        continue;
        Object localObject = (Integer)WebStateReporter.jdField_a_of_type_JavaUtilHashMap.get("sample_rate");
        continue;
        int j = 0;
        continue;
        if (i != -1)
        {
          String str2 = localException1 + "?type=" + i;
          if (QLog.isColorLevel()) {
            QLog.d("WebStateReporter_report", 2, "try report web status,  step: " + this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Int + ", hasRedDot : " + bool1 + ", crashFrom : " + i + ", stepTime: " + (this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Long) + ", totalTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Long) + "\n" + str2);
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_a_of_type_JavaLangString))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_a_of_type_JavaLangString;
            String str3 = this.b;
            if (bool1)
            {
              i = 1;
              ReportController.b(null, "P_CliOper", "WebStatusReport", "", (String)localObject, str3, i, 1, this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Int, str2, Build.VERSION.RELEASE, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_c_of_type_Long - this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Long), String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.jdField_b_of_type_Long));
            }
          }
          else
          {
            localObject = "unknown";
            continue;
          }
          i = 0;
          continue;
        }
        i = -1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebStateReporter_report", 2, "parse url, redDot : " + str1 + ", urlFromType : " + (String)localObject);
        }
        j = this.jdField_a_of_type_JavaLangString.indexOf("?");
        str1 = this.jdField_a_of_type_JavaLangString;
        if (j == -1) {
          continue;
        }
        str1 = str1.substring(0, j);
      }
      catch (Exception localException2)
      {
        continue;
        continue;
      }
    }
    if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewUtilsWebStateReporter.a(this.jdField_a_of_type_AndroidContentContext);
      if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.isEmpty()) {
        WebStateReporter.jdField_a_of_type_JavaUtilHashMap.put("sample_rate", Integer.valueOf(10));
      }
    }
    if (WebStateReporter.jdField_a_of_type_JavaUtilHashMap.containsKey(str1))
    {
      localObject = (Integer)WebStateReporter.jdField_a_of_type_JavaUtilHashMap.get(str1);
      j = ((Integer)localObject).intValue();
      if ((1 != j) && (this.jdField_a_of_type_Long % j != WebStateReporter.jdField_c_of_type_Int)) {
        break label315;
      }
      j = 1;
      if (j != 0) {
        break label320;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */