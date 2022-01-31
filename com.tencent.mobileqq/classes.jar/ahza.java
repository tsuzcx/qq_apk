import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.TimerTask;

public class ahza
  extends TimerTask
{
  public ahza(AIOMessageSpreadManager paramAIOMessageSpreadManager) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.a.a;
      if (l2 >= 950L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.a.a + "],now[" + l1 + "], dur[" + l2 + "],timeOut start check!");
        }
        i = AIOMessageSpreadManager.a(this.a).size() - 1;
        while (i >= 0)
        {
          localMessageRecord = (MessageRecord)AIOMessageSpreadManager.a(this.a).get(i);
          this.a.a((ChatMessage)localMessageRecord);
          i -= 1;
        }
        this.a.a = 0L;
        AIOMessageSpreadManager.a(this.a).clear();
      }
      while (!QLog.isColorLevel())
      {
        int i;
        MessageRecord localMessageRecord;
        return;
      }
      QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.a.a + "],now[" + l1 + "], dur[" + l2 + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahza
 * JD-Core Version:    0.7.0.1
 */