import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class aicd
  implements View.OnClickListener
{
  aicd(aicc paramaicc) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof aicj)))
    {
      paramView = (aicj)paramView;
      azgu.a(aicc.a(this.a), aicc.a(this.a), paramView.a);
      azks localazks = (azks)aicc.a(this.a).getManager(203);
      if ((localazks != null) && (localazks.a(aicc.a(this.a), paramView.a, aicc.a(this.a)))) {
        localazks.a(aicc.a(this.a), paramView.a);
      }
      if (aicc.a(this.a) != null) {}
    }
    else
    {
      return;
    }
    awqx.b(aicc.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, paramView.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aicd
 * JD-Core Version:    0.7.0.1
 */