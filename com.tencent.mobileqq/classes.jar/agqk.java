import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import java.util.ArrayList;

public class agqk
  implements Runnable
{
  public agqk(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agqk
 * JD-Core Version:    0.7.0.1
 */