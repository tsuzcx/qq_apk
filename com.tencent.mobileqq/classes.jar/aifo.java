import com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop;
import com.tencent.qphone.base.util.QLog;

public class aifo
  extends ajse
{
  public aifo(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopDiscussionTroop", 2, "onCacheInited " + paramInt);
      }
    } while (TroopDiscussionTroop.a(this.a) == null);
    TroopDiscussionTroop.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aifo
 * JD-Core Version:    0.7.0.1
 */