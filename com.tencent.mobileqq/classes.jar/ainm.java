import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;

class ainm
  implements aqjd
{
  ainm(ainl paramainl) {}
  
  public void a()
  {
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "onConfirm: ");
    long l = System.currentTimeMillis();
    boolean bool = false;
    if (ainl.a(this.a) > l) {
      bool = true;
    }
    if (ainl.a(this.a) != null) {
      ainl.a(this.a).a(ainl.a(this.a), bool);
    }
    if (bool) {
      ainl.a(this.a).dismiss();
    }
    int i = (int)(ainl.a(this.a) - System.currentTimeMillis()) / 60000;
    bcst.b(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", ainl.a(this.a), i, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ainl.a(this.a, paramInt1, paramInt2);
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "column: " + paramInt1 + ", row: " + paramInt2);
    if (paramInt1 == 0) {
      ainl.a(this.a).a(1);
    }
  }
  
  public void a(View paramView)
  {
    ainl.a(this.a).dismiss();
    bcst.b(null, "dc00898", "", "", "0X800AE80", "0X800AE80", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainm
 * JD-Core Version:    0.7.0.1
 */