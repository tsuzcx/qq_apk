import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class ajgg
  implements View.OnClickListener
{
  ajgg(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    try
    {
      bdgm.a(ajgb.a(this.a), 0, null, alud.a(2131701299), 2131690648, 2131694953, new ajgh(this), new ajgi(this)).show();
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + paramView.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgg
 * JD-Core Version:    0.7.0.1
 */