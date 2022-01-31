import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aefs
  implements View.OnClickListener
{
  aefs(aefp paramaefp) {}
  
  public void onClick(View paramView)
  {
    if (aefp.a(this.a) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NavigateBarManager", 2, String.format("onClick barId: %s", new Object[] { Integer.valueOf(aefp.a(this.a).a) }));
      }
      paramView = aefp.a(this.a);
      aefp.a(this.a);
      if (paramView != null) {
        paramView.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefs
 * JD-Core Version:    0.7.0.1
 */