import android.os.Handler;
import android.os.Message;

class aidp
  extends Handler
{
  aidp(aido paramaido) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 1: 
      aido.a(this.a);
      return;
    case 2: 
      aido.b(this.a);
      return;
    case 3: 
      aido.c(this.a);
      return;
    case 4: 
      aido.d(this.a);
      return;
    case 6: 
      aido.a(this.a, paramMessage);
      return;
    case 9: 
      aido.b(this.a, paramMessage);
      return;
    case 7: 
      aido.e(this.a);
      return;
    }
    aido.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidp
 * JD-Core Version:    0.7.0.1
 */