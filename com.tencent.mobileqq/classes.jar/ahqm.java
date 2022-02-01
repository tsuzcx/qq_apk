import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahqm
  implements View.OnClickListener
{
  ahqm(ahqj paramahqj) {}
  
  public void onClick(View paramView)
  {
    if (ahqj.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(ahqj.a(this.a).a) }));
      }
      ahqi localahqi = ahqj.a(this.a);
      ahqj.a(this.a);
      if (localahqi != null) {
        localahqi.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqm
 * JD-Core Version:    0.7.0.1
 */