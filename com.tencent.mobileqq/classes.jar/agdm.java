import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class agdm
  implements ldp
{
  agdm(agdj paramagdj, agdn paramagdn, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, agdn paramagdn)
  {
    agdj.a(this.jdField_a_of_type_Agdj, this.jdField_a_of_type_Agdn);
    if (paramagdn != null) {
      ldn.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    String str;
    if (this.jdField_a_of_type_Agdn != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Agdn.jdField_b_of_type_Long + "request id:" + paramLong);
      }
      if ((!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Agdn.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Agdn.jdField_b_of_type_Long != paramLong) || (paramagdn == null) || (paramagdn.jdField_c_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
        break label481;
      }
      if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        break label317;
      }
      agdj.g += 1;
      if (this.jdField_a_of_type_Agdn.f != 0) {
        break label389;
      }
      str = "0";
      label180:
      azri.a(this.jdField_a_of_type_Agdj.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Agdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramagdn.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
      if ((paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (paramString2.equalsIgnoreCase(paramString1))) {
        break label434;
      }
      paramLanguage = ldn.a(this.jdField_a_of_type_Agdj.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      }
      paramagdn.g = 1;
      this.jdField_a_of_type_Agdj.b();
    }
    label317:
    label481:
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
      {
        agdj.g += 1;
        break;
      }
      if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW"))) {
        break;
      }
      agdj.g += 1;
      break;
      if (this.jdField_a_of_type_Agdn.f == 1)
      {
        str = "1";
        break label180;
      }
      if (this.jdField_a_of_type_Agdn.f == 3000)
      {
        str = "2";
        break label180;
      }
      str = "";
      break label180;
      paramLanguage = ldn.a(this.jdField_a_of_type_Agdj.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Agdj.a(2131717649);
      return;
      if ((!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        ldn.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    label389:
    label434:
    ldn.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, agdn paramagdn)
  {
    agdj.a(this.jdField_a_of_type_Agdj, this.jdField_a_of_type_Agdn);
    if (paramagdn != null) {
      ldn.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramagdn.jdField_c_of_type_JavaLangString, paramagdn.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramagdn != null) && (paramagdn.jdField_c_of_type_AndroidViewView != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.jdField_a_of_type_Agdj.a(2131717650);
          if (this.jdField_a_of_type_Agdn.f != 0) {
            break label232;
          }
          paramString = "0";
          azri.a(this.jdField_a_of_type_Agdj.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Agdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Agdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
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
        this.jdField_a_of_type_Agdj.a(2131717652);
        continue;
        this.jdField_a_of_type_Agdj.a(2131717653);
        continue;
        if (this.jdField_a_of_type_Agdn.f == 1) {
          paramString = "1";
        } else if (this.jdField_a_of_type_Agdn.f == 3000) {
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
 * Qualified Name:     agdm
 * JD-Core Version:    0.7.0.1
 */