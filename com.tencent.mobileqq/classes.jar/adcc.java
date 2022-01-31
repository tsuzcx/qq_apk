import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class adcc
  extends avqr
{
  public adcc(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "onGameCenterMsgReceive. notifyData.");
    }
    if ((this.a.isResume()) && (paramBoolean1) && (paramInt != 2) && (LebaListMgrActivity.a(this.a) != null))
    {
      List localList = aiab.a().a();
      this.a.runOnUiThread(new LebaListMgrActivity.3.1(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcc
 * JD-Core Version:    0.7.0.1
 */