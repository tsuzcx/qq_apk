import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class agce
  implements View.OnClickListener
{
  agce(agcb paramagcb) {}
  
  public void onClick(View paramView)
  {
    if (agcb.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(agcb.a(this.a).a) }));
      }
      paramView = agcb.a(this.a);
      agcb.a(this.a);
      if (paramView != null) {
        paramView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agce
 * JD-Core Version:    0.7.0.1
 */