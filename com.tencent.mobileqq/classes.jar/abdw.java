import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import java.util.List;

public class abdw
  implements View.OnClickListener
{
  public abdw(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      ((View.OnClickListener)this.a.a.get(i)).onClick(paramView);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abdw
 * JD-Core Version:    0.7.0.1
 */