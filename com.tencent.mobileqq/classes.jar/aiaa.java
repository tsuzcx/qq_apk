import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aiaa
  implements View.OnClickListener
{
  aiaa(ahzx paramahzx) {}
  
  public void onClick(View paramView)
  {
    if (ahzx.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(ahzx.a(this.a).a) }));
      }
      ahzw localahzw = ahzx.a(this.a);
      ahzx.a(this.a);
      if (localahzw != null) {
        localahzw.a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaa
 * JD-Core Version:    0.7.0.1
 */