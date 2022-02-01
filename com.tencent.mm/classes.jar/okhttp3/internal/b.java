package okhttp3.internal;

public abstract class b
  implements Runnable
{
  protected final String name;
  
  public b(String paramString, Object... paramVarArgs)
  {
    this.name = c.format(paramString, paramVarArgs);
  }
  
  protected abstract void execute();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.name);
    try
    {
      execute();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b
 * JD-Core Version:    0.7.0.1
 */