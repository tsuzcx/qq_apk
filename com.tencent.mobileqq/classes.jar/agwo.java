import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agwo
  implements View.OnClickListener
{
  agwo(agwl paramagwl) {}
  
  public void onClick(View paramView)
  {
    if (agwl.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(agwl.a(this.a).a) }));
      }
      agwk localagwk = agwl.a(this.a);
      agwl.a(this.a);
      if (localagwk != null) {
        localagwk.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwo
 * JD-Core Version:    0.7.0.1
 */