import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afsf
  extends ajxl
{
  afsf(afsa paramafsa) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      afsa.a(this.a, true);
      afsa.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsf
 * JD-Core Version:    0.7.0.1
 */