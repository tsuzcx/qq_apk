import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class aiyt
  implements View.OnLongClickListener
{
  public aiyt(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.a).a(false, false) > 0) && (DrawRedpacketPannelPreviewFragment.a(this.a) != null)) {
      DrawRedpacketPannelPreviewFragment.a(this.a).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyt
 * JD-Core Version:    0.7.0.1
 */