import java.util.concurrent.ThreadFactory;

class akgj
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    akgi.a();
    paramRunnable = new Thread(paramRunnable, "InfiniteTaskThread_" + akgi.b());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akgj
 * JD-Core Version:    0.7.0.1
 */