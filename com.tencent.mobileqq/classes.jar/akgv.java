import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class akgv
  extends URLDrawableDownListener.Adapter
{
  public akgv(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramURLDrawable.getCurrDrawable();
    if ((paramView instanceof ApngDrawable)) {
      VasFaceManager.a((ApngDrawable)paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgv
 * JD-Core Version:    0.7.0.1
 */