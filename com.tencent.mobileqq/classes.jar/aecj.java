import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aecj
  implements lbl
{
  aecj(aecg paramaecg, aeck paramaeck, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, aeck paramaeck)
  {
    aecg.a(this.jdField_a_of_type_Aecg, this.jdField_a_of_type_Aeck);
    if (paramaeck != null) {
      lbj.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    String str;
    if (this.jdField_a_of_type_Aeck != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Aeck.jdField_b_of_type_Long + "request id:" + paramLong);
      }
      if ((!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Aeck.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Aeck.jdField_b_of_type_Long != paramLong) || (paramaeck == null) || (paramaeck.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
        break label481;
      }
      if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        break label317;
      }
      aecg.g += 1;
      if (this.jdField_a_of_type_Aeck.f != 0) {
        break label389;
      }
      str = "0";
      label180:
      axrn.a(this.jdField_a_of_type_Aecg.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Aecg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aecg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramaeck.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
      if ((paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (paramString2.equalsIgnoreCase(paramString1))) {
        break label434;
      }
      paramLanguage = lbj.a(this.jdField_a_of_type_Aecg.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      }
      paramaeck.g = 1;
      this.jdField_a_of_type_Aecg.b();
    }
    label317:
    label481:
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
      {
        aecg.g += 1;
        break;
      }
      if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW"))) {
        break;
      }
      aecg.g += 1;
      break;
      if (this.jdField_a_of_type_Aeck.f == 1)
      {
        str = "1";
        break label180;
      }
      if (this.jdField_a_of_type_Aeck.f == 3000)
      {
        str = "2";
        break label180;
      }
      str = "";
      break label180;
      paramLanguage = lbj.a(this.jdField_a_of_type_Aecg.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Aecg.a(2131717265);
      return;
      if ((!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        lbj.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    label389:
    label434:
    lbj.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, aeck paramaeck)
  {
    aecg.a(this.jdField_a_of_type_Aecg, this.jdField_a_of_type_Aeck);
    if (paramaeck != null) {
      lbj.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramaeck.jdField_c_of_type_JavaLangString, paramaeck.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramaeck != null) && (paramaeck.jdField_c_of_type_AndroidViewView != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.jdField_a_of_type_Aecg.a(2131717266);
          if (this.jdField_a_of_type_Aeck.f != 0) {
            break label232;
          }
          paramString = "0";
          axrn.a(this.jdField_a_of_type_Aecg.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Aecg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aecg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
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
        this.jdField_a_of_type_Aecg.a(2131717268);
        continue;
        this.jdField_a_of_type_Aecg.a(2131717269);
        continue;
        if (this.jdField_a_of_type_Aeck.f == 1) {
          paramString = "1";
        } else if (this.jdField_a_of_type_Aeck.f == 3000) {
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
 * Qualified Name:     aecj
 * JD-Core Version:    0.7.0.1
 */