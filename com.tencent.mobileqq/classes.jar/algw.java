import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class algw
  implements DialogInterface.OnClickListener
{
  public algw(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((DrawRedpacketPannelPreviewFragment.a(this.a) != null) && (DrawRedpacketPannelPreviewFragment.a(this.a).isShowing())) {
      DrawRedpacketPannelPreviewFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algw
 * JD-Core Version:    0.7.0.1
 */