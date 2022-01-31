import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import java.util.ArrayList;

public class ahjd
  implements Runnable
{
  public ahjd(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void run()
  {
    ReceiptMessageReadMemberListContainerFragment.a(this.a, new ArrayList());
    ReceiptMessageReadMemberListContainerFragment.b(this.a, new ArrayList());
    if (ReceiptMessageReadMemberListContainerFragment.a(this.a))
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.a, 0L);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjd
 * JD-Core Version:    0.7.0.1
 */