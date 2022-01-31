import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ahkj
  implements BusinessObserver
{
  ahkj(ahki paramahki) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */