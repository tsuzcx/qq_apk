import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;

public class ahxp
  extends ahxt
{
  public void a()
  {
    RMVideoStateMgr.a().a.q();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] initState end");
    }
  }
  
  public boolean a()
  {
    RMVideoStateMgr.a().a("RMVideoIdleState");
    return true;
  }
  
  public void b()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] realDeleteVideoSegment ...");
    }
    localRMVideoStateMgr.a.a(100);
    localRMVideoStateMgr.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxp
 * JD-Core Version:    0.7.0.1
 */