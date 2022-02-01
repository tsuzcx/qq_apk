import android.os.Message;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aljp
  extends apec
{
  aljp(aljo paramaljo) {}
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
      }
      aljo.a(this.a).obtainMessage(2, 0, 0, paramList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljp
 * JD-Core Version:    0.7.0.1
 */