import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import java.util.ArrayList;

public class ahem
  implements Runnable
{
  public ahem(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
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
 * Qualified Name:     ahem
 * JD-Core Version:    0.7.0.1
 */