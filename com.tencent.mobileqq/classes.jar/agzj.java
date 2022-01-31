import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class agzj
  implements View.OnClickListener
{
  agzj(agxq paramagxq) {}
  
  public void onClick(View paramView)
  {
    if (agxq.a(this.a).app != null)
    {
      ((ajfi)agxq.a(this.a).app.a(2)).b(0, "", "not_disturb_from_conversation");
      awqx.b(agxq.a(this.a).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agzj
 * JD-Core Version:    0.7.0.1
 */