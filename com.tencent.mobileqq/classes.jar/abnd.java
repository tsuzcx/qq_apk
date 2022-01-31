import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;

public class abnd
  implements View.OnClickListener
{
  public abnd(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnd
 * JD-Core Version:    0.7.0.1
 */