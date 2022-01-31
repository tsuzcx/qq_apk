import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;

public class aheh
  implements View.OnClickListener
{
  public aheh(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      DrawHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
      DrawHbFragment.a(this.a).c("draw.wrappacket.choose");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aheh
 * JD-Core Version:    0.7.0.1
 */