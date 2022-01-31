import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import java.io.File;
import mqq.os.MqqHandler;

class aehn
  extends MqqHandler
{
  aehn(aegu paramaegu) {}
  
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
          bcpw.a(aegu.e(this.a), 2131719554, 0).a();
          return;
          aegu.f(this.a).getString(2131719555);
          paramMessage = (String)paramMessage.obj;
          bbdr.a(aegu.g(this.a), paramMessage);
          bcpw.a(aegu.h(this.a), 2, ajyc.a(2131700044), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bbcv.a(aegu.i(this.a), 232, aegu.j(this.a).getResources().getString(2131719587), aegu.k(this.a).getResources().getString(2131719586), 2131719569, 2131718713, new aeho(this, paramMessage), new aehp(this));
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
      bcpw.a(aegu.l(this.a), 1, ajyc.a(2131700062), 0).a();
      NativeVideoImage.resumeAll();
      aegu.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    bcpw.a(aegu.m(this.a), 2, ajyc.a(2131700051), 0).a();
    NativeVideoImage.resumeAll();
    aegu.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehn
 * JD-Core Version:    0.7.0.1
 */