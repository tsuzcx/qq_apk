import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class akel
  implements View.OnLongClickListener
{
  public akel(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.a).a(false, false) > 0) && (DrawRedpacketPannelPreviewFragment.a(this.a) != null)) {
      DrawRedpacketPannelPreviewFragment.a(this.a).show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akel
 * JD-Core Version:    0.7.0.1
 */