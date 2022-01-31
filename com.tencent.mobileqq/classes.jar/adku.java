import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class adku
  implements DialogInterface.OnClickListener
{
  public adku(ForwardFileBaseOption paramForwardFileBaseOption, Uri paramUri, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ForwardFileBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption, this.jdField_a_of_type_AndroidNetUri, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaIoInputStream, this.jdField_a_of_type_Long);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardFileBaseOption", 2, "copy file error", paramDialogInterface);
      }
      ForwardFileBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption, this.jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adku
 * JD-Core Version:    0.7.0.1
 */