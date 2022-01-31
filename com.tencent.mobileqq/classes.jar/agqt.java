import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import java.lang.ref.WeakReference;

public class agqt
  extends Handler
{
  private WeakReference a;
  
  private agqt(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
  {
    this.a = new WeakReference(paramReceiptMessageReadMemberListContainerFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReceiptMessageReadMemberListContainerFragment localReceiptMessageReadMemberListContainerFragment = (ReceiptMessageReadMemberListContainerFragment)this.a.get();
    if ((localReceiptMessageReadMemberListContainerFragment == null) || (!localReceiptMessageReadMemberListContainerFragment.isAdded())) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      case 0: 
      default: 
        return;
      case -1: 
        localReceiptMessageReadMemberListContainerFragment.h();
        ReceiptMessageReadMemberListContainerFragment.g(localReceiptMessageReadMemberListContainerFragment);
        return;
      case 1: 
        ReceiptMessageReadMemberListContainerFragment.b(localReceiptMessageReadMemberListContainerFragment);
        return;
      }
    } while (this.a.get() == null);
    if (ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment)) {
      ReceiptMessageReadMemberListContainerFragment.c(localReceiptMessageReadMemberListContainerFragment);
    }
    for (;;)
    {
      ReceiptMessageReadMemberListContainerFragment.d(localReceiptMessageReadMemberListContainerFragment);
      return;
      sendEmptyMessage(5);
    }
    ReceiptMessageReadMemberListContainerFragment.a(localReceiptMessageReadMemberListContainerFragment, ((Long)paramMessage.obj).longValue());
    return;
    ThreadManager.post(new agqu(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
    return;
    ThreadManager.post(new agqv(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agqt
 * JD-Core Version:    0.7.0.1
 */