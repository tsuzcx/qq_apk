import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class algs
  implements View.OnLongClickListener
{
  public algs(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.a).a(false, false) > 0) && (DrawRedpacketPannelPreviewFragment.a(this.a) != null)) {
      DrawRedpacketPannelPreviewFragment.a(this.a).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algs
 * JD-Core Version:    0.7.0.1
 */