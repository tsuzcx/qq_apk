import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class ajpr
  implements DialogInterface.OnClickListener
{
  ajpr(Activity paramActivity, String paramString1, String paramString2, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ajpl.a(this.jdField_a_of_type_AndroidAppActivity, true, this.jdField_a_of_type_JavaLangString, this.b, false);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFC", "0X8009DFC", 0, 0, this.b, "", "", "");
      return;
    }
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009DFD", "0X8009DFD", 0, 0, this.b, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpr
 * JD-Core Version:    0.7.0.1
 */