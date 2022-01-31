import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;

public class agrv
  implements View.OnClickListener
{
  public agrv(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    DrawHbFragment.b(this.a).c("draw.wrappacket.random");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agrv
 * JD-Core Version:    0.7.0.1
 */