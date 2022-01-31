import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import java.util.ArrayList;

public class abpp
  implements abpr
{
  public abpp(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (Button)paramView.findViewById(2131307761);
    if (paramView.isSelected())
    {
      paramView.setSelected(false);
      this.a.a(paramInt);
      if (this.a.a.size() != 0) {}
    }
    do
    {
      return;
      paramView.setSelected(true);
      this.a.a.add(Integer.valueOf(paramInt));
    } while (this.a.a.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abpp
 * JD-Core Version:    0.7.0.1
 */