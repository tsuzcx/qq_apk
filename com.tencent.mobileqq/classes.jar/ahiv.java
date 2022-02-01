import android.os.Handler;
import android.os.Message;

class ahiv
  extends Handler
{
  ahiv(ahiu paramahiu) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 1: 
      ahiu.a(this.a);
      return;
    case 2: 
      ahiu.b(this.a);
      return;
    case 3: 
      ahiu.c(this.a);
      return;
    case 4: 
      ahiu.d(this.a);
      return;
    case 6: 
      ahiu.a(this.a, paramMessage);
      return;
    case 9: 
      ahiu.b(this.a, paramMessage);
      return;
    case 7: 
      ahiu.e(this.a);
      return;
    }
    ahiu.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiv
 * JD-Core Version:    0.7.0.1
 */