import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;

public class ahry
  implements View.OnClickListener
{
  public ahry(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    VADActivity.a(this.a, 3);
    if (this.a.a != null) {
      this.a.a.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahry
 * JD-Core Version:    0.7.0.1
 */