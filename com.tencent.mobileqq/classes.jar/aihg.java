import com.tencent.mobileqq.shortvideo.mediadevice.DispatchThread;

public class aihg
  implements Runnable
{
  public aihg(DispatchThread paramDispatchThread) {}
  
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
 * Qualified Name:     aihg
 * JD-Core Version:    0.7.0.1
 */