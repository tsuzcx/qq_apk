import android.os.Bundle;
import mqq.observer.BusinessObserver;

class afnr
  implements BusinessObserver
{
  afnr(afno paramafno, afnw paramafnw) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Afnw != null)) {
      this.jdField_a_of_type_Afnw.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnr
 * JD-Core Version:    0.7.0.1
 */