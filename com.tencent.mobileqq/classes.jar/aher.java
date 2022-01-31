import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import java.util.ArrayList;

public class aher
  implements Runnable
{
  public aher(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = ReceiptMessageReadMemberListContainerFragment.a(this.a).a().b(ReceiptMessageReadMemberListContainerFragment.a(this.a).jdField_a_of_type_JavaLangString, ReceiptMessageReadMemberListContainerFragment.a(this.a).jdField_a_of_type_Int, ReceiptMessageReadMemberListContainerFragment.c(this.a));
    if (ReceiptMessageReadMemberListContainerFragment.a(this.a).size() == 0) {
      ReceiptMsgManager.a(ReceiptMessageReadMemberListContainerFragment.a(this.a), localMessageRecord, "3");
    }
    while (ReceiptMessageReadMemberListContainerFragment.b(this.a).size() <= 0) {
      return;
    }
    ReceiptMsgManager.a(ReceiptMessageReadMemberListContainerFragment.a(this.a), localMessageRecord, "4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aher
 * JD-Core Version:    0.7.0.1
 */