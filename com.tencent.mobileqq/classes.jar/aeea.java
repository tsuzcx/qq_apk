import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.activity.ScoreQAVFragment;
import java.util.ArrayList;

public class aeea
  implements aeec
{
  public aeea(ScoreQAVFragment paramScoreQAVFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = (Button)paramView.findViewById(2131374604);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeea
 * JD-Core Version:    0.7.0.1
 */