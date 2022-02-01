import android.content.Context;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class ahjh
  implements lan
{
  private ahjf jdField_a_of_type_Ahjf;
  private Context jdField_a_of_type_AndroidContentContext;
  public BaseAdapter a;
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  
  public ahjh(Context paramContext, ahjf paramahjf, String paramString, BaseAdapter paramBaseAdapter, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ahjf = paramahjf;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  @NotNull
  private String a()
  {
    if (this.jdField_a_of_type_Ahjf.f == 0) {
      return "0";
    }
    if (this.jdField_a_of_type_Ahjf.f == 1) {
      return "1";
    }
    if (this.jdField_a_of_type_Ahjf.f == 3000) {
      return "2";
    }
    return "";
  }
  
  private void a(Language paramLanguage)
  {
    if (paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
      ahjd.g += 1;
    }
    do
    {
      return;
      if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-CN")))
      {
        ahjd.g += 1;
        return;
      }
    } while ((!paramLanguage.toString().equalsIgnoreCase("zh-CHT")) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase("zh-TW")));
    ahjd.g += 1;
  }
  
  void a(int paramInt)
  {
    Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramInt, 0).show();
  }
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, ahjf paramahjf)
  {
    ahjd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahjf);
    if (paramahjf != null) {
      lal.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "[ChatAdapter]holder id:" + this.jdField_a_of_type_Ahjf.jdField_b_of_type_Long + "request id:" + paramLong);
    }
    if ((paramString1.equalsIgnoreCase(this.jdField_a_of_type_Ahjf.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Ahjf.jdField_b_of_type_Long == paramLong) && (paramahjf != null) && (paramahjf.jdField_c_of_type_AndroidViewView != null))
    {
      a(paramLanguage);
      String str = a();
      StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).reportActionCountRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramahjf.jdField_c_of_type_Long), str, paramLanguage.toString(), this.jdField_a_of_type_JavaLangString);
      if ((!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) && (!paramString2.equalsIgnoreCase(paramString1)))
      {
        paramLanguage = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
        if (paramLanguage != null) {
          paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
        }
        paramahjf.g = 1;
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        return;
      }
      paramLanguage = lal.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
      }
      a(2131716578);
      return;
    }
    if (!paramLanguage.toString().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      lal.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.jdField_a_of_type_JavaLangString);
      return;
    }
    lal.a(this.jdField_a_of_type_AndroidContentContext).a(paramString1, paramString2, paramLong, Boolean.valueOf(false), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, ahjf paramahjf)
  {
    ahjd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ahjf);
    if (paramahjf != null) {
      lal.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_JavaLangString, paramahjf.jdField_c_of_type_JavaLangString, paramahjf.jdField_b_of_type_Long, Boolean.valueOf(false));
    }
    if ((paramahjf != null) && (paramahjf.jdField_c_of_type_AndroidViewView != null) && (paramTranslateError != null)) {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0)) {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") >= 0) || (paramTranslateError.getMessage().indexOf("can't resolve host") >= 0))
        {
          a(2131716579);
          paramString = a();
          StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).reportActionCountRes(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
          if (QLog.isColorLevel()) {
            QLog.e("Translator", 2, "onFailed:" + paramTranslateError);
          }
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        a(2131716581);
        continue;
        a(2131716582);
      }
    }
    QLog.e("Translator", 2, "onFailed:e is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjh
 * JD-Core Version:    0.7.0.1
 */