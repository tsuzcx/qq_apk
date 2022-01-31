import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aecl
  implements lbq
{
  aecl(aeci paramaeci, aecm paramaecm, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, aecm paramaecm)
  {
    aeci.a(this.jdField_a_of_type_Aeci, this.jdField_a_of_type_Aecm);
    if (paramaecm != null) {
      lbo.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    String str;
    if (this.jdField_a_of_type_Aecm != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Aecm.jdField_b_of_type_Long + "request id:" + paramLong);
      }
      if ((!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Aecm.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Aecm.jdField_b_of_type_Long != paramLong) || (paramaecm == null) || (paramaecm.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
        break label481;
      }
      if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        break label317;
      }
      aeci.g += 1;
      if (this.jdField_a_of_type_Aecm.f != 0) {
        break label389;
      }
      str = "0";
      label180:
      axrl.a(this.jdField_a_of_type_Aeci.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Aeci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramaecm.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
      if ((paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (paramString2.equalsIgnoreCase(paramString1))) {
        break label434;
      }
      paramLanguage = lbo.a(this.jdField_a_of_type_Aeci.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      }
      paramaecm.g = 1;
      this.jdField_a_of_type_Aeci.b();
    }
    label317:
    label481:
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
      {
        aeci.g += 1;
        break;
      }
      if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW"))) {
        break;
      }
      aeci.g += 1;
      break;
      if (this.jdField_a_of_type_Aecm.f == 1)
      {
        str = "1";
        break label180;
      }
      if (this.jdField_a_of_type_Aecm.f == 3000)
      {
        str = "2";
        break label180;
      }
      str = "";
      break label180;
      paramLanguage = lbo.a(this.jdField_a_of_type_Aeci.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Aeci.a(2131717254);
      return;
      if ((!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        lbo.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    label389:
    label434:
    lbo.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, aecm paramaecm)
  {
    aeci.a(this.jdField_a_of_type_Aeci, this.jdField_a_of_type_Aecm);
    if (paramaecm != null) {
      lbo.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramaecm.jdField_c_of_type_JavaLangString, paramaecm.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramaecm != null) && (paramaecm.jdField_c_of_type_AndroidViewView != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.jdField_a_of_type_Aeci.a(2131717255);
          if (this.jdField_a_of_type_Aecm.f != 0) {
            break label232;
          }
          paramString = "0";
          axrl.a(this.jdField_a_of_type_Aeci.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Aeci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aeci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
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
        this.jdField_a_of_type_Aeci.a(2131717257);
        continue;
        this.jdField_a_of_type_Aeci.a(2131717258);
        continue;
        if (this.jdField_a_of_type_Aecm.f == 1) {
          paramString = "1";
        } else if (this.jdField_a_of_type_Aecm.f == 3000) {
          paramString = "2";
        } else {
          paramString = "";
        }
      }
    }
    QLog.e("Translator", 2, "onFailed:e is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecl
 * JD-Core Version:    0.7.0.1
 */