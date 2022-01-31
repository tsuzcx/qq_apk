import android.view.View;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy;

public class aafc
  implements Runnable
{
  public aafc(ARVideoRecordViewProxy paramARVideoRecordViewProxy) {}
  
  public void run()
  {
    if (ARVideoRecordViewProxy.b(this.a) != null)
    {
      ARVideoRecordViewProxy.b(this.a).setVisibility(0);
      ARVideoRecordViewProxy.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aafc
 * JD-Core Version:    0.7.0.1
 */