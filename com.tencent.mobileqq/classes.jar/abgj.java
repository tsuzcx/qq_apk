import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class abgj
  implements Runnable
{
  public abgj(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    this.a.b = 1;
    this.a.a.post(new abgk(this));
    ARMapEngine.guideToPOI(0.0F);
    ThreadManager.post(new abgl(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgj
 * JD-Core Version:    0.7.0.1
 */