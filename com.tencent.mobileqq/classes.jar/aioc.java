import android.util.Pair;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aioc
  implements Runnable
{
  public aioc(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void run()
  {
    TroopAioKeywordTipBar.b(this.a, false);
    if (!TroopAioKeywordTipBar.c(this.a)) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAioKeywordTipBar", 2, "checkMsgForShow, mIsCanCheck = false");
      }
    }
    TroopAioKeywordTipManager localTroopAioKeywordTipManager;
    ArrayList localArrayList1;
    do
    {
      ArrayList localArrayList2;
      do
      {
        int i;
        int j;
        do
        {
          return;
          i = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() - this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          j = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() - this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          localTroopAioKeywordTipManager = (TroopAioKeywordTipManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(224);
        } while ((i < 0) || (j < 0));
        localArrayList1 = new ArrayList(10);
        localArrayList2 = new ArrayList(10);
        if (i <= j)
        {
          localObject = (MessageRecord)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i);
          if (localObject == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (!((MessageRecord)localObject).isSend()) {
              localArrayList1.add(localObject);
            } else if (((MessageRecord)localObject).time > NetConnInfoCenter.getServerTime() - 5L) {
              localArrayList2.add(0, localObject);
            }
          }
        }
        if (localArrayList2.size() <= 0) {
          break;
        }
      } while ((TroopAioKeywordTipBar.b(this.a) != null) && (TroopAioKeywordTipBar.b(this.a) == localArrayList2.get(0)));
      Object localObject = localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.a(this.a), 1);
      if ((TroopAioKeywordTipBar.a(this.a)) && ((((Pair)localObject).second == null) || ((TroopAioKeywordTipBar.a(this.a) != null) && (TroopAioKeywordTipBar.a(this.a).ruleId != ((Integer)((Pair)localObject).second).intValue())))) {
        TroopAioKeywordTipBar.a(this.a, false);
      }
      for (;;)
      {
        localTroopAioKeywordTipManager.a(localArrayList2, TroopAioKeywordTipBar.a(this.a), 1, new aiod(this, localArrayList1, localTroopAioKeywordTipManager));
        return;
        TroopAioKeywordTipBar.b(this.a, (MessageRecord)localArrayList2.get(0));
      }
    } while ((localArrayList1.size() <= 0) || (TroopAioKeywordTipBar.a(this.a)));
    localTroopAioKeywordTipManager.a(localArrayList1, null, 2, new aiof(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */