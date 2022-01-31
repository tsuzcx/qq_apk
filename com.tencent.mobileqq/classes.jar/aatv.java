import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.RedPackRainCloudView;

public class aatv
  implements Runnable
{
  public aatv(ARMapActivity paramARMapActivity) {}
  
  public void run()
  {
    ARMapManager localARMapManager = (ARMapManager)this.a.app.getManager(209);
    if ((localARMapManager != null) && (this.a.a != null)) {
      this.a.a.a(localARMapManager.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatv
 * JD-Core Version:    0.7.0.1
 */