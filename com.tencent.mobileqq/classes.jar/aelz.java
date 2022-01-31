import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.magicface.drawable.IMessageHandler;

public final class aelz
  extends Handler
{
  java.lang.ref.WeakReference a;
  
  public aelz(IMessageHandler paramIMessageHandler)
  {
    super(Looper.getMainLooper());
    this.a = new mqq.util.WeakReference(paramIMessageHandler);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    IMessageHandler localIMessageHandler;
    do
    {
      return;
      localIMessageHandler = (IMessageHandler)this.a.get();
    } while (localIMessageHandler == null);
    localIMessageHandler.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelz
 * JD-Core Version:    0.7.0.1
 */