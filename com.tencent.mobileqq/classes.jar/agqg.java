import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import java.lang.ref.WeakReference;

public class agqg
  implements DownCallBack
{
  private WeakReference a;
  
  public agqg(ReceiptMessageDetailFragment paramReceiptMessageDetailFragment)
  {
    this.a = new WeakReference(paramReceiptMessageDetailFragment);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    ReceiptMessageDetailFragment localReceiptMessageDetailFragment = (ReceiptMessageDetailFragment)this.a.get();
    if (localReceiptMessageDetailFragment == null) {
      return;
    }
    switch (paramDownResult.a)
    {
    default: 
      return;
    case -1: 
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
      ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(7);
      return;
    }
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).a().a(ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment), null);
    ReceiptMessageDetailFragment.a(localReceiptMessageDetailFragment).sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     agqg
 * JD-Core Version:    0.7.0.1
 */