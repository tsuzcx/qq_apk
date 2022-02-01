import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity.4.1;
import com.tencent.qphone.base.util.QLog;

public class aewl
  extends aoge
{
  public aewl(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = akgr.a().a();
    this.a.runOnUiThread(new LebaListMgrActivity.4.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewl
 * JD-Core Version:    0.7.0.1
 */