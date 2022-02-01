import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

public class ahta
  implements PopupWindow.OnDismissListener
{
  public ahta(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahta
 * JD-Core Version:    0.7.0.1
 */