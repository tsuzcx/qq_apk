import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class acfy
  extends ajrp
{
  public acfy(VisitorsActivity paramVisitorsActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "onVipStatusChanged: ");
    }
    if ((this.a.app != null) && (bajr.b(this.a.app)))
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
          babr.a(this.a, 232, null, ajjy.a(2131651025), null, ajjy.a(2131651022), new acfz(this), null).show();
        }
        this.a.removeObserver(VisitorsActivity.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfy
 * JD-Core Version:    0.7.0.1
 */