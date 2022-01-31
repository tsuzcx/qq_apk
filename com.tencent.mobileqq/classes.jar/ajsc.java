import java.util.concurrent.ThreadFactory;

class ajsc
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    ajsb.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + ajsb.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajsc
 * JD-Core Version:    0.7.0.1
 */