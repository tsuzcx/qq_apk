import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class airo
  extends amsu
{
  airo(airj paramairj) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      airj.a(this.a, true);
      airj.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airo
 * JD-Core Version:    0.7.0.1
 */