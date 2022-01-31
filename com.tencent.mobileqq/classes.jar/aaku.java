import com.tencent.mobileqq.ar.ScanningSurfaceView;

public class aaku
  implements Runnable
{
  public aaku(ScanningSurfaceView paramScanningSurfaceView) {}
  
  public void run()
  {
    while (ScanningSurfaceView.a(this.a))
    {
      long l = System.currentTimeMillis();
      ScanningSurfaceView.a(this.a);
      try
      {
        Thread.sleep(Math.max(0L, ScanningSurfaceView.a(this.a) - (System.currentTimeMillis() - l)));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (ScanningSurfaceView.b(this.a)) {
      ScanningSurfaceView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaku
 * JD-Core Version:    0.7.0.1
 */