import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.BubblePopupWindow.OnDismissListener;

@TargetApi(16)
public class akfe
  implements BubblePopupWindow.OnDismissListener
{
  akfe(ContextMenuTextView paramContextMenuTextView) {}
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {
      ContextMenuTextView.a(this.a, null);
    }
    for (;;)
    {
      this.a.a = null;
      return;
      ContextMenuTextView.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akfe
 * JD-Core Version:    0.7.0.1
 */