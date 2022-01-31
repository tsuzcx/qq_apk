import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.olympic.activity.OlympicToolBaseActivity;

public class afrp
  implements View.OnClickListener
{
  public afrp(OlympicToolBaseActivity paramOlympicToolBaseActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371082: 
      this.a.b();
      return;
    case 2131371085: 
      this.a.d();
      return;
    case 2131371088: 
      this.a.e();
      return;
    }
    this.a.doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrp
 * JD-Core Version:    0.7.0.1
 */