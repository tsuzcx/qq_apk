import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class afgi
  extends ajjh
{
  afgi(afgd paramafgd) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      afgd.a(this.a, true);
      afgd.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afgi
 * JD-Core Version:    0.7.0.1
 */