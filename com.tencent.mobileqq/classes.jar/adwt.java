import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class adwt
  extends bayj
{
  adwt(adws paramadws) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (bass)paramMessage.obj;
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
        i = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.p, paramMessage.i, paramMessage.b);
      } while (this.a.jdField_d_of_type_Boolean);
      if (this.a.jdField_b_of_type_Boolean)
      {
        if (paramMessage.d == 1005)
        {
          this.a.jdField_c_of_type_Boolean = true;
          return;
        }
        if (paramMessage.d == 1003)
        {
          this.a.a();
          return;
        }
        adws.a(this.a, this.a.jdField_c_of_type_Int, this.a.jdField_a_of_type_JavaLangString, paramMessage.b);
        return;
      }
      if (paramMessage.d == 1003)
      {
        if (this.a.jdField_a_of_type_Bdjz != null) {
          this.a.jdField_a_of_type_Bdjz.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(100) }));
        }
        this.a.a();
        return;
      }
      if (paramMessage.d == 1005)
      {
        this.a.a();
        return;
      }
    } while (this.a.jdField_a_of_type_Bdjz == null);
    this.a.jdField_a_of_type_Bdjz.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwt
 * JD-Core Version:    0.7.0.1
 */