import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import java.lang.ref.WeakReference;

public class ahev
  extends Handler
{
  private WeakReference a;
  
  private ahev(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment)
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
    ThreadManager.post(new ahew(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
    return;
    ThreadManager.post(new ahex(this, localReceiptMessageReadMemberListContainerFragment), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahev
 * JD-Core Version:    0.7.0.1
 */