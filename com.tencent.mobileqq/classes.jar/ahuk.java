import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ahuk
  extends altm
{
  ahuk(ahuf paramahuf) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      ahuf.a(this.a, true);
      ahuf.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuk
 * JD-Core Version:    0.7.0.1
 */