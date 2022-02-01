import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class agdl
  implements BusinessObserver
{
  agdl(agdk paramagdk) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2004) && (paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("ReminderDataManagerNew", 2, "acs msg succ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */