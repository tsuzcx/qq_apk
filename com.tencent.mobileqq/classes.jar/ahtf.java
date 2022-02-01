import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;

public class ahtf
  implements PopupWindow.OnDismissListener
{
  public ahtf(StructingMsgItemBuilder paramStructingMsgItemBuilder) {}
  
  public void onDismiss()
  {
    StructingMsgItemBuilder.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */