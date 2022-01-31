import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class aktk
  implements View.OnClickListener
{
  public aktk(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131375573)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aktk
 * JD-Core Version:    0.7.0.1
 */