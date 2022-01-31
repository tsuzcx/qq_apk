import android.os.Bundle;
import mqq.observer.BusinessObserver;

class acif
  implements BusinessObserver
{
  acif(acic paramacic, acih paramacih) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Acih != null)) {
      this.jdField_a_of_type_Acih.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acif
 * JD-Core Version:    0.7.0.1
 */