import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import java.util.List;

public class aebf
  implements PopupWindow.OnDismissListener
{
  public aebf(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void onDismiss()
  {
    this.a.b = null;
    Object localObject;
    if ((TextPreviewTranslateActivity.a(this.a) != null) && (TextPreviewTranslateActivity.a(this.a).size() > 1))
    {
      localObject = this.a.getResources();
      if (!TextPreviewTranslateActivity.a(this.a)) {
        break label76;
      }
    }
    label76:
    for (int i = 2130845229;; i = 2130845740)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      TextPreviewTranslateActivity.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebf
 * JD-Core Version:    0.7.0.1
 */