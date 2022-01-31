import com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread;

public class aicm
  implements Runnable
{
  public aicm(DispatchThread paramDispatchThread) {}
  
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
 * Qualified Name:     aicm
 * JD-Core Version:    0.7.0.1
 */