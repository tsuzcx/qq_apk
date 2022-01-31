import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.activity.AutoRemarkActivity;

public class acct
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public acct(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    int i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i - (((Rect)localObject).bottom - ((Rect)localObject).top) > i / 3)
    {
      i = 1;
      localObject = this.a.getCurrentFocus();
      if (i != 0) {
        break label101;
      }
      if ((localObject != null) && ((localObject instanceof EditText))) {
        ((EditText)localObject).setCursorVisible(false);
      }
    }
    label101:
    while ((localObject == null) || (!(localObject instanceof EditText)))
    {
      return;
      i = 0;
      break;
    }
    ((EditText)localObject).setCursorVisible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acct
 * JD-Core Version:    0.7.0.1
 */