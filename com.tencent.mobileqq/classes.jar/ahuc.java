import android.content.Context;
import android.os.SystemClock;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ahuc
  implements lat
{
  ahuc(ahtz paramahtz, ahud paramahud, Context paramContext, String paramString) {}
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, ahud paramahud)
  {
    ahtz.a(this.jdField_a_of_type_Ahtz, this.jdField_a_of_type_Ahud);
    if (paramahud != null) {
      lar.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    String str;
    if (this.jdField_a_of_type_Ahud != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Ahud.jdField_b_of_type_Long + "request id:" + paramLong);
      }
      if ((!paramString1.equalsIgnoreCase(this.jdField_a_of_type_Ahud.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Ahud.jdField_b_of_type_Long != paramLong) || (paramahud == null) || (paramahud.d == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
        break label481;
      }
      if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
        break label317;
      }
      ahtz.g += 1;
      if (this.jdField_a_of_type_Ahud.f != 0) {
        break label389;
      }
      str = "0";
      label180:
      bdmc.a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahtz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramahud.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
      if ((paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) || (paramString2.equalsIgnoreCase(paramString1))) {
        break label434;
      }
      paramLanguage = lar.a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      }
      paramahud.g = 1;
      this.jdField_a_of_type_Ahtz.b();
    }
    label317:
    label481:
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
      {
        ahtz.g += 1;
        break;
      }
      if ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW"))) {
        break;
      }
      ahtz.g += 1;
      break;
      if (this.jdField_a_of_type_Ahud.f == 1)
      {
        str = "1";
        break label180;
      }
      if (this.jdField_a_of_type_Ahud.f == 3000)
      {
        str = "2";
        break label180;
      }
      str = "";
      break label180;
      paramLanguage = lar.a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_Ahtz.a(2131715983);
      return;
      if ((!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null))
      {
        lar.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    label389:
    label434:
    lar.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, ahud paramahud)
  {
    ahtz.a(this.jdField_a_of_type_Ahtz, this.jdField_a_of_type_Ahud);
    if (paramahud != null) {
      lar.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramahud.jdField_c_of_type_JavaLangString, paramahud.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramahud != null) && (paramahud.d != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          this.jdField_a_of_type_Ahtz.a(2131715984);
          if (this.jdField_a_of_type_Ahud.f != 0) {
            break label232;
          }
          paramString = "0";
          bdmc.a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ahtz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ahtz.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
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
        this.jdField_a_of_type_Ahtz.a(2131715986);
        continue;
        this.jdField_a_of_type_Ahtz.a(2131715987);
        continue;
        if (this.jdField_a_of_type_Ahud.f == 1) {
          paramString = "1";
        } else if (this.jdField_a_of_type_Ahud.f == 3000) {
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
 * Qualified Name:     ahuc
 * JD-Core Version:    0.7.0.1
 */