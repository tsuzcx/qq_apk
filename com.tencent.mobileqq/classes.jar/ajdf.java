import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ajdf
  implements View.OnClickListener
{
  ajdf(ajbm paramajbm) {}
  
  public void onClick(View paramView)
  {
    if (ajbm.a(this.a).app != null)
    {
      ((alkv)ajbm.a(this.a).app.a(2)).b(0, "", "not_disturb_from_conversation");
      azmj.b(ajbm.a(this.a).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdf
 * JD-Core Version:    0.7.0.1
 */