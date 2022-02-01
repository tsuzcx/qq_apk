import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class aaxv
  extends Handler
{
  private WeakReference<aaxt> a;
  
  public aaxv(aaxt paramaaxt, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramaaxt);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (aaxt localaaxt = (aaxt)this.a.get();; localaaxt = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof aaxu)) {
          localObject1 = (aaxu)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localaaxt != null) && (localObject1 != null))
        {
          ((aaxt)this.a.get()).d();
          continue;
          if ((localaaxt != null) && (localObject1 != null))
          {
            ((aaxt)this.a.get()).e();
            continue;
            if ((localaaxt != null) && (localObject1 != null))
            {
              ((aaxt)this.a.get()).c(((aaxu)localObject1).a);
              continue;
              if ((localaaxt != null) && (localObject1 != null))
              {
                ((aaxt)this.a.get()).f();
                continue;
                if ((localaaxt != null) && (localObject1 != null)) {
                  ((aaxt)this.a.get()).b(((aaxu)localObject1).a);
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
 * Qualified Name:     aaxv
 * JD-Core Version:    0.7.0.1
 */