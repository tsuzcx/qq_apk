import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajnd
  extends anvi
{
  ajnd(ajmy paramajmy) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      ajmy.a(this.a, true);
      ajmy.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnd
 * JD-Core Version:    0.7.0.1
 */