import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aeht
  extends alxo
{
  public aeht(VisitorsActivity paramVisitorsActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.a.app != null) && (VipUtils.b(this.a.app)))
    {
      this.a.a(true);
      this.a.b(true);
      if (VisitorsActivity.b(this.a).compareAndSet(true, false))
      {
        if (VisitorsActivity.a(this.a).get())
        {
          if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, "onVipStatusChanged: showDialog");
          }
          bdcd.a(this.a, 232, null, alpo.a(2131717199), null, alpo.a(2131717196), new aehu(this), null).show();
        }
        this.a.removeObserver(VisitorsActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeht
 * JD-Core Version:    0.7.0.1
 */