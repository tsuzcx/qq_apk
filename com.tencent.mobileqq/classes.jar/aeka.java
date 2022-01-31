import android.os.Bundle;
import mqq.observer.BusinessObserver;

class aeka
  implements BusinessObserver
{
  aeka(aejx paramaejx, aekc paramaekc) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Aekc != null)) {
      this.jdField_a_of_type_Aekc.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeka
 * JD-Core Version:    0.7.0.1
 */