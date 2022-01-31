import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aefq
  implements View.OnClickListener
{
  aefq(aefn paramaefn) {}
  
  public void onClick(View paramView)
  {
    if (aefn.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(aefn.a(this.a).a) }));
      }
      paramView = aefn.a(this.a);
      aefn.a(this.a);
      if (paramView != null) {
        paramView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefq
 * JD-Core Version:    0.7.0.1
 */