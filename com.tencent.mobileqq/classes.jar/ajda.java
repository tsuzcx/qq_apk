import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment;

public class ajda
  implements View.OnClickListener
{
  public ajda(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      DrawHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
      DrawHbFragment.a(this.a).c("draw.wrappacket.choose");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */