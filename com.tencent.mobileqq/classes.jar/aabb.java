import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.SharePanelShowStateEvent;

class aabb
  implements DialogInterface.OnDismissListener
{
  aabb(aaba paramaaba) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SimpleEventBus.getInstance().dispatchEvent(new SharePanelShowStateEvent(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabb
 * JD-Core Version:    0.7.0.1
 */