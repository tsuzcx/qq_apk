import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class afbp
  implements BusinessObserver
{
  afbp(afbo paramafbo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afbp
 * JD-Core Version:    0.7.0.1
 */