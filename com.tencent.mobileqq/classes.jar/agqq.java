import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

class agqq
  implements lak
{
  agqq(agqn paramagqn, agqr paramagqr, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, agqr paramagqr)
  {
    agqn.a(this.jdField_a_of_type_Agqn, this.jdField_a_of_type_Agqr);
    if (paramagqr != null) {
      lai.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Agqr.jdField_b_of_type_Long + "request id:" + paramLong);
    }
    if ((paramString1.equalsIgnoreCase(this.jdField_a_of_type_Agqr.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Agqr.jdField_b_of_type_Long == paramLong) && (paramagqr != null) && (paramagqr.d != null))
    {
      String str;
      if (paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
      {
        agqn.g += 1;
        if (this.jdField_a_of_type_Agqr.f != 0) {
          break label375;
        }
        str = "0";
      }
      for (;;)
      {
        StatisticCollector.getInstance(this.jdField_a_of_type_Agqn.jdField_a_of_type_AndroidContentContext).reportActionCountRes(this.jdField_a_of_type_Agqn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agqn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramagqr.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
        if ((paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (paramString2.equalsIgnoreCase(paramString1))) {
          break label420;
        }
        paramLanguage = lai.a(this.jdField_a_of_type_Agqn.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (paramLanguage != null) {
          paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        }
        paramagqr.g = 1;
        this.jdField_a_of_type_Agqn.b();
        return;
        if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
        {
          agqn.g += 1;
          break;
        }
        if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW"))) {
          break;
        }
        agqn.g += 1;
        break;
        label375:
        if (this.jdField_a_of_type_Agqr.f == 1) {
          str = "1";
        } else if (this.jdField_a_of_type_Agqr.f == 3000) {
          str = "2";
        } else {
          str = "";
        }
      }
      label420:
      paramLanguage = lai.a(this.jdField_a_of_type_Agqn.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Agqn.a(2131716217);
      return;
    }
    if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      lai.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      return;
    }
    lai.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, agqr paramagqr)
  {
    agqn.a(this.jdField_a_of_type_Agqn, this.jdField_a_of_type_Agqr);
    if (paramagqr != null) {
      lai.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramagqr.jdField_c_of_type_JavaLangString, paramagqr.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramagqr != null) && (paramagqr.d != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.jdField_a_of_type_Agqn.a(2131716218);
          if (this.jdField_a_of_type_Agqr.f != 0) {
            break label232;
          }
          paramString = "0";
          StatisticCollector.getInstance(this.jdField_a_of_type_Agqn.jdField_a_of_type_AndroidContentContext).reportActionCountRes(this.jdField_a_of_type_Agqn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agqn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "onFailed:" + paramTranslateError);
          }
        }
      }
    }
    label232:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_Agqn.a(2131716220);
        continue;
        this.jdField_a_of_type_Agqn.a(2131716221);
        continue;
        if (this.jdField_a_of_type_Agqr.f == 1) {
          paramString = "1";
        } else if (this.jdField_a_of_type_Agqr.f == 3000) {
          paramString = "2";
        } else {
          paramString = "";
        }
      }
    }
    QLog.e("Translator", 2, "onFailed:e is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqq
 * JD-Core Version:    0.7.0.1
 */