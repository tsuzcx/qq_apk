import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;

class aixk
  implements aqyg
{
  aixk(aixj paramaixj) {}
  
  public void a()
  {
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "onConfirm: ");
    long l = System.currentTimeMillis();
    boolean bool = false;
    if (aixj.a(this.a) > l) {
      bool = true;
    }
    if (aixj.a(this.a) != null) {
      aixj.a(this.a).a(aixj.a(this.a), bool);
    }
    if (bool) {
      aixj.a(this.a).dismiss();
    }
    int i = (int)(aixj.a(this.a) - System.currentTimeMillis()) / 60000;
    bdll.b(null, "dc00898", "", "", "0X800AE7F", "0X800AE7F", aixj.a(this.a), i, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aixj.a(this.a, paramInt1, paramInt2);
    QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "column: " + paramInt1 + ", row: " + paramInt2);
    if (paramInt1 == 0) {
      aixj.a(this.a).a(1);
    }
  }
  
  public void a(View paramView)
  {
    aixj.a(this.a).dismiss();
    bdll.b(null, "dc00898", "", "", "0X800AE80", "0X800AE80", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixk
 * JD-Core Version:    0.7.0.1
 */