import android.os.Build.VERSION;
import android.view.View;

public final class ajkv
  implements Runnable
{
  public ajkv(View paramView) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.a.sendAccessibilityEvent(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajkv
 * JD-Core Version:    0.7.0.1
 */