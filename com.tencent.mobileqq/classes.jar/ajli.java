import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class ajli
  extends anmu
{
  ajli(ajld paramajld) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      ajld.a(this.a, true);
      ajld.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajli
 * JD-Core Version:    0.7.0.1
 */