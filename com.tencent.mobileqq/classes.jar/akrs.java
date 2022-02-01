import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class akrs
  implements DialogInterface.OnClickListener
{
  akrs(Activity paramActivity, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      akrn.a(this.jdField_a_of_type_AndroidAppActivity, false, this.jdField_a_of_type_JavaLangString, this.b, false);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrs
 * JD-Core Version:    0.7.0.1
 */