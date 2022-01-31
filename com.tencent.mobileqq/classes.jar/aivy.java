import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public abstract interface aivy
{
  public abstract void exeJsOnEngine(String paramString);
  
  public abstract long getRenderThreadId();
  
  public abstract long getRuntimeState();
  
  public abstract boolean isJsRuntime();
  
  public abstract void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivy
 * JD-Core Version:    0.7.0.1
 */