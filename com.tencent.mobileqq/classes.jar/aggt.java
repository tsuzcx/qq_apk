import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aggt
  implements View.OnClickListener
{
  aggt(aggq paramaggq) {}
  
  public void onClick(View paramView)
  {
    if (aggq.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(aggq.a(this.a).a) }));
      }
      paramView = aggq.a(this.a);
      aggq.a(this.a);
      if (paramView != null) {
        paramView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aggt
 * JD-Core Version:    0.7.0.1
 */