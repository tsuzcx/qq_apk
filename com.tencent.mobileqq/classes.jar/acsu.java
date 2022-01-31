import android.os.Bundle;
import mqq.observer.BusinessObserver;

class acsu
  implements BusinessObserver
{
  acsu(acsr paramacsr, acsw paramacsw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Acsw != null)) {
      this.jdField_a_of_type_Acsw.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acsu
 * JD-Core Version:    0.7.0.1
 */