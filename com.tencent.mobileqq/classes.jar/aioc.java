import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;

public class aioc
  implements BaseBubbleBuilder.TouchDelegate
{
  public int a;
  public View a;
  public ImageView a;
  public TextView a;
  public boolean a;
  public TextView b;
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = this.a.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (ColorFilter localColorFilter = null;; localColorFilter = BaseBubbleBuilder.a)
    {
      localDrawable.setColorFilter(localColorFilter);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 1: 
    case 3: 
      do
      {
        return;
        paramView = this.a.getBackground();
      } while (paramView == null);
      paramView.setColorFilter(null);
      paramView.invalidateSelf();
      return;
    }
    a(false);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aioc
 * JD-Core Version:    0.7.0.1
 */