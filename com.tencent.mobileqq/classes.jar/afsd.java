import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afsd
  extends ajxj
{
  afsd(afry paramafry) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      afry.a(this.a, true);
      afry.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsd
 * JD-Core Version:    0.7.0.1
 */