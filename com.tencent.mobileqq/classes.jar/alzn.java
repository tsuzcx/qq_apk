import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.InputStream;

public class alzn
  implements DialogInterface.OnClickListener
{
  public alzn(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      QfavJumpActivity.a(this.jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("qqfav|QfavJumpActivity", 2, "copy file error", paramDialogInterface);
      }
      QfavJumpActivity.a(this.jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity, this.jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzn
 * JD-Core Version:    0.7.0.1
 */