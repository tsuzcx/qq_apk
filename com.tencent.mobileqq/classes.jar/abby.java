import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class abby
  extends Handler
{
  private WeakReference<abbw> a;
  
  public abby(abbw paramabbw, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramabbw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (abbw localabbw = (abbw)this.a.get();; localabbw = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof abbx)) {
          localObject1 = (abbx)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localabbw != null) && (localObject1 != null))
        {
          ((abbw)this.a.get()).d();
          continue;
          if ((localabbw != null) && (localObject1 != null))
          {
            ((abbw)this.a.get()).e();
            continue;
            if ((localabbw != null) && (localObject1 != null))
            {
              ((abbw)this.a.get()).c(((abbx)localObject1).a);
              continue;
              if ((localabbw != null) && (localObject1 != null))
              {
                ((abbw)this.a.get()).f();
                continue;
                if ((localabbw != null) && (localObject1 != null)) {
                  ((abbw)this.a.get()).b(((abbx)localObject1).a);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abby
 * JD-Core Version:    0.7.0.1
 */