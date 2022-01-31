import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class agiq
  extends MqqHandler
{
  agiq(aghx paramaghx) {}
  
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
          QQToast.a(aghx.e(this.a), 2131720109, 0).a();
          return;
          aghx.f(this.a).getString(2131720110);
          paramMessage = (String)paramMessage.obj;
          bdhj.a(aghx.g(this.a), paramMessage);
          QQToast.a(aghx.h(this.a), 2, alud.a(2131700436), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bdgm.a(aghx.i(this.a), 232, aghx.j(this.a).getResources().getString(2131720142), aghx.k(this.a).getResources().getString(2131720141), 2131720124, 2131719209, new agir(this, paramMessage), new agis(this));
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
      QQToast.a(aghx.l(this.a), 1, alud.a(2131700454), 0).a();
      NativeVideoImage.resumeAll();
      aghx.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(aghx.m(this.a), 2, alud.a(2131700443), 0).a();
    NativeVideoImage.resumeAll();
    aghx.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiq
 * JD-Core Version:    0.7.0.1
 */