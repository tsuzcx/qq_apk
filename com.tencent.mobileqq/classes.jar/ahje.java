import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.qphone.base.util.BaseApplication;

public class ahje
  implements Runnable
{
  public ahje(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public void run()
  {
    if (!this.a.isAdded()) {
      return;
    }
    if (ReceiptMessageReadMemberListContainerFragment.a(this.a).getApp().getSharedPreferences("last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.a).getCurrentAccountUin(), 0).getLong("key_last_update_time" + ReceiptMessageReadMemberListContainerFragment.a(this.a), 0L) - ReceiptMessageReadMemberListContainerFragment.b(this.a) * 1000L > 60000L)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(4);
      return;
    }
    TroopHandler localTroopHandler = (TroopHandler)ReceiptMessageReadMemberListContainerFragment.a(this.a).a(20);
    TroopInfo localTroopInfo = ((TroopManager)ReceiptMessageReadMemberListContainerFragment.a(this.a).getManager(51)).a(Long.toString(ReceiptMessageReadMemberListContainerFragment.a(this.a)));
    if (localTroopInfo == null)
    {
      ReceiptMessageReadMemberListContainerFragment.a(this.a).sendEmptyMessage(-1);
      return;
    }
    ReceiptMessageReadMemberListContainerFragment.a(this.a).addObserver(ReceiptMessageReadMemberListContainerFragment.a(this.a), true);
    localTroopHandler.a(true, localTroopInfo.troopuin, localTroopInfo.troopcode, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahje
 * JD-Core Version:    0.7.0.1
 */