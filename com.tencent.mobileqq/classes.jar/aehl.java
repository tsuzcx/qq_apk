import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import java.io.File;
import mqq.os.MqqHandler;

class aehl
  extends MqqHandler
{
  aehl(aegs paramaegs) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          return;
          bcql.a(aegs.e(this.a), 2131719565, 0).a();
          return;
          aegs.f(this.a).getString(2131719566);
          paramMessage = (String)paramMessage.obj;
          bbef.a(aegs.g(this.a), paramMessage);
          bcql.a(aegs.h(this.a), 2, ajya.a(2131700055), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bbdj.a(aegs.i(this.a), 232, aegs.j(this.a).getResources().getString(2131719598), aegs.k(this.a).getResources().getString(2131719597), 2131719580, 2131718724, new aehm(this, paramMessage), new aehn(this));
      try
      {
        paramMessage.show();
        return;
      }
      catch (Throwable paramMessage)
      {
        return;
      }
    case 10001: 
      this.a.B();
      bcql.a(aegs.l(this.a), 1, ajya.a(2131700073), 0).a();
      NativeVideoImage.resumeAll();
      aegs.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    bcql.a(aegs.m(this.a), 2, ajya.a(2131700062), 0).a();
    NativeVideoImage.resumeAll();
    aegs.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehl
 * JD-Core Version:    0.7.0.1
 */