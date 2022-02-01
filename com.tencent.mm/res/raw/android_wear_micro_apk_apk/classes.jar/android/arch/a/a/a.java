package android.arch.a.a;

import java.util.concurrent.Executor;

public class a
  extends c
{
  private static volatile a a;
  private static final Executor d = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.a().b(paramAnonymousRunnable);
    }
  };
  private static final Executor e = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.a().a(paramAnonymousRunnable);
    }
  };
  private c b = this.c;
  private c c = new b();
  
  public static a a()
  {
    if (a != null) {
      return a;
    }
    try
    {
      if (a == null) {
        a = new a();
      }
      return a;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.b.a(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.b.b(paramRunnable);
  }
  
  public final boolean b()
  {
    return this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.7.0.1
 */