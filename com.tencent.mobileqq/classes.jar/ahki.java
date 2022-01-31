import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahki
  implements View.OnClickListener
{
  ahki(ahkd paramahkd) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bbdj.a(ahkd.a(this.a), 0, null, ajya.a(2131700918), 2131690596, 2131694794, new ahkj(this), new ahkk(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */