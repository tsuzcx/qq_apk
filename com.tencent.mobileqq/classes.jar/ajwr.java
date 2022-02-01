import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajwr
  extends anyu
{
  ajwr(ajwm paramajwm) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      ajwm.a(this.a, true);
      ajwm.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwr
 * JD-Core Version:    0.7.0.1
 */