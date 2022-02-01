import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleLayout;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;

public class akvi
  implements DialogInterface.OnClickListener
{
  public akvi(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DrawRedpacketPannelPreviewFragment.a(this.a, false);
    DrawRedpacketPannelPreviewFragment.a(this.a).a(false, false);
    DrawRedpacketPannelPreviewFragment.a(this.a);
    DrawRedpacketPannelPreviewFragment.d(this.a).setTextColor(Color.parseColor("#878B99"));
    DrawRedpacketPannelPreviewFragment.d(this.a).setText("......");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvi
 * JD-Core Version:    0.7.0.1
 */