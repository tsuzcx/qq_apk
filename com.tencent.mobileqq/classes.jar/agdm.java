import android.os.Bundle;
import mqq.observer.BusinessObserver;

class agdm
  implements BusinessObserver
{
  agdm(agdj paramagdj, agdr paramagdr) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 2003) && (this.jdField_a_of_type_Agdr != null)) {
      this.jdField_a_of_type_Agdr.a(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdm
 * JD-Core Version:    0.7.0.1
 */