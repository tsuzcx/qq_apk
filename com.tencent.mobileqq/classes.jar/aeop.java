import android.os.Bundle;
import mqq.observer.BusinessObserver;

class aeop
  implements BusinessObserver
{
  aeop(aeom paramaeom, aeor paramaeor) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Aeor != null)) {
      this.jdField_a_of_type_Aeor.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeop
 * JD-Core Version:    0.7.0.1
 */