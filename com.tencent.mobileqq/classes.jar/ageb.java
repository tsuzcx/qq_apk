import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class ageb
  extends MqqHandler
{
  ageb(agdi paramagdi) {}
  
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
          QQToast.a(agdi.e(this.a), 2131720097, 0).a();
          return;
          agdi.f(this.a).getString(2131720098);
          paramMessage = (String)paramMessage.obj;
          bdda.a(agdi.g(this.a), paramMessage);
          QQToast.a(agdi.h(this.a), 2, alpo.a(2131700424), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bdcd.a(agdi.i(this.a), 232, agdi.j(this.a).getResources().getString(2131720130), agdi.k(this.a).getResources().getString(2131720129), 2131720112, 2131719197, new agec(this, paramMessage), new aged(this));
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
      QQToast.a(agdi.l(this.a), 1, alpo.a(2131700442), 0).a();
      NativeVideoImage.resumeAll();
      agdi.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(agdi.m(this.a), 2, alpo.a(2131700431), 0).a();
    NativeVideoImage.resumeAll();
    agdi.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ageb
 * JD-Core Version:    0.7.0.1
 */