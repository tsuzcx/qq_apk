import android.text.TextUtils;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.UnitedVerifyMsgEditFragment;

class adwo
  implements Runnable
{
  adwo(adwn paramadwn, String paramString1, String paramString2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Adwn.a.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_JavaLangString);
    try
    {
      if (!TextUtils.isEmpty(this.b)) {
        this.jdField_a_of_type_Adwn.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.lastIndexOf(this.b), this.jdField_a_of_type_JavaLangString.length());
      }
      for (;;)
      {
        label58:
        this.jdField_a_of_type_Adwn.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setSoftInputMode(4);
        return;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          this.jdField_a_of_type_Adwn.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_JavaLangString.length());
        }
      }
    }
    catch (Throwable localThrowable)
    {
      break label58;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwo
 * JD-Core Version:    0.7.0.1
 */