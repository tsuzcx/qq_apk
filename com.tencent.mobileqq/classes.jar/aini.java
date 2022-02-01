import android.os.Handler;
import android.os.Message;

class aini
  extends Handler
{
  aini(ainh paramainh) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
      return;
    case 1: 
      ainh.a(this.a);
      return;
    case 2: 
      ainh.b(this.a);
      return;
    case 3: 
      ainh.c(this.a);
      return;
    case 4: 
      ainh.d(this.a);
      return;
    case 6: 
      ainh.a(this.a, paramMessage);
      return;
    case 9: 
      ainh.b(this.a, paramMessage);
      return;
    case 7: 
      ainh.e(this.a);
      return;
    }
    ainh.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aini
 * JD-Core Version:    0.7.0.1
 */