import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;

class aiow
  implements View.OnClickListener
{
  aiow(aiov paramaiov) {}
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof aipc)))
    {
      paramView = (aipc)paramView;
      bahx.a(aiov.a(this.a), aiov.a(this.a), paramView.a);
      balw localbalw = (balw)aiov.a(this.a).getManager(203);
      if ((localbalw != null) && (localbalw.a(aiov.a(this.a), paramView.a, aiov.a(this.a)))) {
        localbalw.a(aiov.a(this.a), paramView.a);
      }
      if (aiov.a(this.a) != null) {}
    }
    else
    {
      return;
    }
    axqw.b(aiov.a(this.a).app, "dc00898", "", "", "", "0X8009F9F", 0, 0, paramView.a, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiow
 * JD-Core Version:    0.7.0.1
 */