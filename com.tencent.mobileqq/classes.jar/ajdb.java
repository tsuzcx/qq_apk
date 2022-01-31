import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;

public class ajdb
  implements View.OnClickListener
{
  public ajdb(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    DrawHbFragment.b(this.a).c("draw.wrappacket.random");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdb
 * JD-Core Version:    0.7.0.1
 */