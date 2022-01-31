import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ahkk
  implements View.OnClickListener
{
  ahkk(ahkf paramahkf) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bbcv.a(ahkf.a(this.a), 0, null, ajyc.a(2131700907), 2131690596, 2131694793, new ahkl(this), new ahkm(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkk
 * JD-Core Version:    0.7.0.1
 */