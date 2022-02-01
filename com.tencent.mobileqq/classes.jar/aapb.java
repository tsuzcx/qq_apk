import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class aapb
  implements DialogInterface.OnDismissListener
{
  aapb(aapa paramaapa) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    aaak.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */