import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class akqu
  implements Runnable
{
  public akqu(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void run()
  {
    Iterator localIterator = this.a.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ImageView)((FrameLayout)this.a.e.get(localObject)).findViewById(2131362358);
      ((ImageView)localObject).setImageResource(2130845367);
      ((ImageView)localObject).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqu
 * JD-Core Version:    0.7.0.1
 */