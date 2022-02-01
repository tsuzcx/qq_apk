import android.os.MessageQueue.IdleHandler;

class aiom
  implements MessageQueue.IdleHandler
{
  aiom(aioi paramaioi) {}
  
  public boolean queueIdle()
  {
    this.a.b();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiom
 * JD-Core Version:    0.7.0.1
 */