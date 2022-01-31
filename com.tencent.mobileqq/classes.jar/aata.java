import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class aata
  implements Runnable
{
  aata(aasz paramaasz, int paramInt) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new aatb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aata
 * JD-Core Version:    0.7.0.1
 */