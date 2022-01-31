import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class akjy
  implements BusinessObserver
{
  akjy(akjx paramakjx) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2004) && (paramBoolean) && (QLog.isColorLevel())) {
      QLog.d("ActivateFriends.Manager", 2, "acs msg succ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akjy
 * JD-Core Version:    0.7.0.1
 */