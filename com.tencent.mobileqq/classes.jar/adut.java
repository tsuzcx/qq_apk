import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class adut
  implements View.OnClickListener
{
  adut(aduq paramaduq) {}
  
  public void onClick(View paramView)
  {
    if (aduq.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(aduq.a(this.a).a) }));
      }
      paramView = aduq.a(this.a);
      aduq.a(this.a);
      if (paramView != null) {
        paramView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adut
 * JD-Core Version:    0.7.0.1
 */