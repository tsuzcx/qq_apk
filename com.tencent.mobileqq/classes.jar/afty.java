import android.os.Bundle;
import mqq.observer.BusinessObserver;

class afty
  implements BusinessObserver
{
  afty(aftv paramaftv, afua paramafua) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Afua != null)) {
      this.jdField_a_of_type_Afua.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afty
 * JD-Core Version:    0.7.0.1
 */