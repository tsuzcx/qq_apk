import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import java.util.List;

public class adws
  implements PopupWindow.OnDismissListener
{
  public adws(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void onDismiss()
  {
    this.a.a = null;
    Object localObject;
    if ((TextPreviewTranslateActivity.b(this.a) != null) && (TextPreviewTranslateActivity.b(this.a).size() > 1))
    {
      localObject = this.a.getResources();
      if (!TextPreviewTranslateActivity.a(this.a)) {
        break label76;
      }
    }
    label76:
    for (int i = 2130845157;; i = 2130845668)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      TextPreviewTranslateActivity.b(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adws
 * JD-Core Version:    0.7.0.1
 */