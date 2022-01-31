import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableString;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public final class adgu
  implements Runnable
{
  public adgu(CharSequence paramCharSequence, Context paramContext, String paramString, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangCharSequence instanceof String)) {
      DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaLangCharSequence, 2131428127, 2131428128, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
    }
    while (!(this.jdField_a_of_type_JavaLangCharSequence instanceof SpannableString)) {
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangCharSequence, 2131428127, 2131428128, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.b).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adgu
 * JD-Core Version:    0.7.0.1
 */