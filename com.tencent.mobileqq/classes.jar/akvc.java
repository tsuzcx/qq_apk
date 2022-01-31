import android.view.View;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.widget.NewStyleDropdownView;

public class akvc
  extends URLDrawableDownListener.Adapter
{
  public akvc(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    paramView = paramURLDrawable.getCurrDrawable();
    if ((paramView instanceof ApngDrawable)) {
      VasFaceManager.a((ApngDrawable)paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvc
 * JD-Core Version:    0.7.0.1
 */