import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class aanv
  extends Handler
{
  private WeakReference<aant> a;
  
  public aanv(aant paramaant, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramaant);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    if (this.a.get() != null) {}
    for (aant localaant = (aant)this.a.get();; localaant = null)
    {
      Object localObject1 = localObject2;
      if (paramMessage.obj != null)
      {
        localObject1 = localObject2;
        if ((paramMessage.obj instanceof aanu)) {
          localObject1 = (aanu)paramMessage.obj;
        }
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        if ((localaant != null) && (localObject1 != null))
        {
          ((aant)this.a.get()).d();
          continue;
          if ((localaant != null) && (localObject1 != null))
          {
            ((aant)this.a.get()).e();
            continue;
            if ((localaant != null) && (localObject1 != null))
            {
              ((aant)this.a.get()).c(((aanu)localObject1).a);
              continue;
              if ((localaant != null) && (localObject1 != null))
              {
                ((aant)this.a.get()).f();
                continue;
                if ((localaant != null) && (localObject1 != null)) {
                  ((aant)this.a.get()).b(((aanu)localObject1).a);
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
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */