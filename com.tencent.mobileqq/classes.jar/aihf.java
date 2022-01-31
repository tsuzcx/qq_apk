import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle;

public class aihf
  implements Runnable
{
  public aihf(CameraProxy.WaitDoneBundle paramWaitDoneBundle) {}
  
  public void run()
  {
    synchronized (this.a.a)
    {
      this.a.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aihf
 * JD-Core Version:    0.7.0.1
 */