import java.util.concurrent.ThreadFactory;

class aknw
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    aknv.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + aknv.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aknw
 * JD-Core Version:    0.7.0.1
 */