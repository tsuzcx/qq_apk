import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView;
import java.util.Collections;
import java.util.List;

public class ajci
  implements View.OnClickListener
{
  public ajci(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseItemView.a(this.a) != null) && (ChooseItemView.a(this.a).size() > 1))
    {
      Collections.shuffle(ChooseItemView.a(this.a));
      this.a.a(ChooseItemView.a(this.a), true);
    }
    if (ChooseItemView.a(this.a) != null) {
      ChooseItemView.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajci
 * JD-Core Version:    0.7.0.1
 */