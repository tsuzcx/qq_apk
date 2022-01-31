import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;

public final class aenh
  implements Runnable
{
  public aenh(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.a = true;
      localTransferRequest.i = this.jdField_a_of_type_JavaLangString;
      localTransferRequest.b = 64;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localTransferRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aenh
 * JD-Core Version:    0.7.0.1
 */