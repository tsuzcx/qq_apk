import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioKeywordTipBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ainy
  extends MessageObserver
{
  public ainy(TroopAioKeywordTipBar paramTroopAioKeywordTipBar) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2)
  {
    if ((!TroopAioKeywordTipBar.a(this.a)) || (TroopAioKeywordTipBar.a(this.a) == null)) {}
    for (;;)
    {
      return;
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioKeywordTipBar", 2, "msgList == null is true");
        }
      }
      else
      {
        paramList = paramList.iterator();
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
        } while (((MessageRecord)paramList.next()).uniseq != TroopAioKeywordTipBar.a(this.a).uniseq);
        for (int i = 1; i != 0; i = 0)
        {
          ThreadManager.getUIHandler().post(new ainz(this));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ainy
 * JD-Core Version:    0.7.0.1
 */