import com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread;

public class ahok
  implements Runnable
{
  public ahok(DispatchThread paramDispatchThread) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      this.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahok
 * JD-Core Version:    0.7.0.1
 */