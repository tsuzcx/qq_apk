import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajbr
  implements View.OnClickListener
{
  ajbr(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bdcd.a(ajbm.a(this.a), 0, null, alpo.a(2131701287), 2131690648, 2131694951, new ajbs(this), new ajbt(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbr
 * JD-Core Version:    0.7.0.1
 */