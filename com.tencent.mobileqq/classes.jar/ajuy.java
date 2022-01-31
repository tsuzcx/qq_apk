import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ajuy
  implements Runnable
{
  public ajuy(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    Iterator localIterator = this.a.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ImageView)((FrameLayout)this.a.e.get(localObject)).findViewById(2131362355);
      ((ImageView)localObject).setImageResource(2130845166);
      ((ImageView)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajuy
 * JD-Core Version:    0.7.0.1
 */