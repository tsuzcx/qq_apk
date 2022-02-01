import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class aala
  implements DialogInterface.OnDismissListener
{
  aala(aakz paramaakz) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    zwp.a().a(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aala
 * JD-Core Version:    0.7.0.1
 */