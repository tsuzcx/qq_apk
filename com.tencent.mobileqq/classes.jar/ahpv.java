import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ahpv
  extends alox
{
  ahpv(ahpq paramahpq) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      ahpq.a(this.a, true);
      ahpq.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpv
 * JD-Core Version:    0.7.0.1
 */