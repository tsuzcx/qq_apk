import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class akah
  implements BusinessObserver
{
  akah(akac paramakac, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "setRecommendTroopDeleted uin: " + this.jdField_a_of_type_JavaLangString + " isSuccess: " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akah
 * JD-Core Version:    0.7.0.1
 */