import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.map.ARMapEngine;

public class aasi
  implements Runnable
{
  public aasi(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    this.a.b = 1;
    this.a.a.post(new aasj(this));
    ARMapEngine.guideToPOI(0.0F);
    ThreadManager.post(new aask(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aasi
 * JD-Core Version:    0.7.0.1
 */