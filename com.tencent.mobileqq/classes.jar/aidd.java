import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class aidd
  implements View.OnTouchListener
{
  public aidd(RedBagVideoManager paramRedBagVideoManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (RedBagVideoManager.a(this.a) == null);
        paramView = RedBagVideoManager.a(this.a).getText().toString().trim();
        bool1 = bool2;
      } while ("红包已发".trim().equals(paramView));
      RedBagVideoManager.a(this.a).setAlpha(0.5F);
      return true;
      if (RedBagVideoManager.a(this.a) != null) {
        RedBagVideoManager.a(this.a).setAlpha(1.0F);
      }
      RedBagVideoManager.a(this.a, RedBagVideoManager.a(this.a));
      RedBagVideoManager.b(this.a, System.currentTimeMillis());
      bool1 = bool2;
    } while (RedBagVideoManager.a(this.a) - RedBagVideoManager.b(this.a) < 300L);
    RedBagVideoManager.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aidd
 * JD-Core Version:    0.7.0.1
 */