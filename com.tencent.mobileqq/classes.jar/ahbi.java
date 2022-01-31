import android.os.MessageQueue.IdleHandler;

class ahbi
  implements MessageQueue.IdleHandler
{
  ahbi(ahbf paramahbf) {}
  
  public boolean queueIdle()
  {
    ahbf.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbi
 * JD-Core Version:    0.7.0.1
 */