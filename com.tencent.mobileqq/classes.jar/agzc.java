import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class agzc
  extends MqqHandler
{
  agzc(agyh paramagyh) {}
  
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
          QQToast.a(agyh.e(this.a), 2131718446, 0).a();
          return;
          agyh.f(this.a).getString(2131718447);
          paramMessage = (String)paramMessage.obj;
          bfvo.a(agyh.g(this.a), paramMessage);
          QQToast.a(agyh.h(this.a), 2, amtj.a(2131699204), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bfur.a(agyh.i(this.a), 232, agyh.j(this.a).getResources().getString(2131718478), agyh.k(this.a).getResources().getString(2131718477), 2131718461, 2131717677, new agzd(this, paramMessage), new agze(this));
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
      QQToast.a(agyh.l(this.a), 1, amtj.a(2131699222), 0).a();
      NativeVideoImage.resumeAll();
      agyh.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(agyh.m(this.a), 2, amtj.a(2131699211), 0).a();
    NativeVideoImage.resumeAll();
    agyh.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzc
 * JD-Core Version:    0.7.0.1
 */