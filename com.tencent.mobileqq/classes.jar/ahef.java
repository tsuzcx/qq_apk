import com.tencent.mobileqq.search.activity.VADActivity;
import mqq.os.MqqHandler;

public final class ahef
  implements Runnable
{
  public ahef(MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    
    if (VADActivity.a())
    {
      this.a.sendEmptyMessage(0);
      return;
    }
    this.a.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahef
 * JD-Core Version:    0.7.0.1
 */