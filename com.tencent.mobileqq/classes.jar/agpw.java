import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.QLog;

public class agpw
  implements Runnable
{
  public agpw(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReceiptMessageDetailFragment", 2, "mSendReadReportRequestRunnable");
    }
    switch (ReceiptMessageDetailFragment.a(this.a).a)
    {
    default: 
      return;
    case 1: 
      ReceiptMessageDetailFragment.c(this.a);
      return;
    case 3000: 
      ReceiptMessageDetailFragment.d(this.a);
      return;
    }
    ReceiptMessageDetailFragment.a(this.a).addObserver(ReceiptMessageDetailFragment.a(this.a), false);
    QLog.d("ReceiptMessageDetailFragment", 4, "send read report in c2c");
    ReceiptMessageDetailFragment.a(this.a, ReceiptMessageDetailFragment.a(this.a).a().a(ReceiptMessageDetailFragment.a(this.a), ReceiptMessageDetailFragment.a(this.a, ReceiptMessageDetailFragment.a(this.a).getCurrentAccountUin()), ReceiptMessageDetailFragment.a(this.a), MessageUtils.a(ReceiptMessageDetailFragment.b(this.a))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agpw
 * JD-Core Version:    0.7.0.1
 */