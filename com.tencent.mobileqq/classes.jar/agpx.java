import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;

public class agpx
  implements Runnable
{
  public agpx(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "mSendFetchReadStatusRequestRunnable");
    }
    switch (ReceiptMessageDetailFragment.a(this.a).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 3000: 
      ReceiptMessageDetailFragment.e(this.a);
      return;
    case 0: 
      ReceiptMessageDetailFragment.a(this.a).addObserver(ReceiptMessageDetailFragment.b(this.a), false);
      ReceiptMessageDetailFragment.b(this.a, ReceiptMessageDetailFragment.a(this.a).a().b(ReceiptMessageDetailFragment.a(this.a), ReceiptMessageDetailFragment.a(this.a, ReceiptMessageDetailFragment.a(this.a).jdField_a_of_type_JavaLangString), ReceiptMessageDetailFragment.a(this.a), MessageUtils.a(ReceiptMessageDetailFragment.b(this.a))));
      return;
    }
    ReceiptMessageDetailFragment.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agpx
 * JD-Core Version:    0.7.0.1
 */