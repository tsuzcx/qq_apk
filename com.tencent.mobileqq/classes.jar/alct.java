import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class alct
  extends URLDrawableDownListener.Adapter
{
  public alct(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramURLDrawable.getCurrDrawable();
    if ((paramView instanceof ApngDrawable)) {
      VasFaceManager.a((ApngDrawable)paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alct
 * JD-Core Version:    0.7.0.1
 */