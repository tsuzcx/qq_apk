import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;

public class ajws
  extends aujb
{
  public ajws(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onBatteryChanged updateOnlineStatusItem");
    }
    FrameHelperActivity localFrameHelperActivity = this.a;
    if (paramInt > 0) {
      i = 1;
    }
    FrameHelperActivity.a(localFrameHelperActivity, i);
    this.a.v();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajws
 * JD-Core Version:    0.7.0.1
 */