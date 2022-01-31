import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class akgf
  implements View.OnClickListener
{
  akgf(akge paramakge) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof akgl)))
    {
      paramView = (akgl)paramView;
      bcgx.a(akge.a(this.a), akge.a(this.a), paramView.a);
      bckx localbckx = (bckx)akge.a(this.a).getManager(203);
      if ((localbckx != null) && (localbckx.a(akge.a(this.a), paramView.a, akge.a(this.a)))) {
        localbckx.a(akge.a(this.a), paramView.a);
      }
      if (akge.a(this.a) != null) {}
    }
    else
    {
      return;
    }
    azmj.b(akge.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, paramView.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgf
 * JD-Core Version:    0.7.0.1
 */