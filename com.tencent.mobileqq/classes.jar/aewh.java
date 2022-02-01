import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class aewh
  extends TransProcessorHandler
{
  aewh(aewg paramaewg) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (FileMsg)paramMessage.obj;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i);
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessorProgress(paramMessage.mUin, paramMessage.fileUrl, paramMessage.uniseq);
      } while (this.a.jdField_d_of_type_Boolean);
      if (this.a.jdField_b_of_type_Boolean)
      {
        if (paramMessage.status == 1005)
        {
          this.a.jdField_c_of_type_Boolean = true;
          return;
        }
        if (paramMessage.status == 1003)
        {
          this.a.a();
          return;
        }
        aewg.a(this.a, this.a.jdField_c_of_type_Int, this.a.jdField_a_of_type_JavaLangString, paramMessage.uniseq);
        return;
      }
      if (paramMessage.status == 1003)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(100) }));
        }
        this.a.a();
        return;
      }
      if (paramMessage.status == 1005)
      {
        this.a.a();
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewh
 * JD-Core Version:    0.7.0.1
 */