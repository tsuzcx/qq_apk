import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.LebaListMgrActivity.4.1;
import com.tencent.qphone.base.util.QLog;

public class abla
  extends akfg
{
  public abla(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = agby.a().a();
    this.a.runOnUiThread(new LebaListMgrActivity.4.1(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abla
 * JD-Core Version:    0.7.0.1
 */