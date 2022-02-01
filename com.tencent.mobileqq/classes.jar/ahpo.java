import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahpo
  implements View.OnClickListener
{
  ahpo(ahpl paramahpl) {}
  
  public void onClick(View paramView)
  {
    if (ahpl.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(ahpl.a(this.a).a) }));
      }
      ahpk localahpk = ahpl.a(this.a);
      ahpl.a(this.a);
      if (localahpk != null) {
        localahpk.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpo
 * JD-Core Version:    0.7.0.1
 */