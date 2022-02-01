import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class ahsd
  extends MqqHandler
{
  ahsd(ahri paramahri) {}
  
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
          QQToast.a(ahri.e(this.a), 2131718832, 0).a();
          return;
          ahri.f(this.a).getString(2131718833);
          paramMessage = (String)paramMessage.obj;
          bheg.a(ahri.g(this.a), paramMessage);
          QQToast.a(ahri.h(this.a), 2, anvx.a(2131699555), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bhdj.a(ahri.i(this.a), 232, ahri.j(this.a).getResources().getString(2131718864), ahri.k(this.a).getResources().getString(2131718863), 2131718847, 2131718048, new ahse(this, paramMessage), new ahsf(this));
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
      QQToast.a(ahri.l(this.a), 1, anvx.a(2131699573), 0).a();
      NativeVideoImage.resumeAll();
      ahri.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(ahri.m(this.a), 2, anvx.a(2131699562), 0).a();
    NativeVideoImage.resumeAll();
    ahri.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsd
 * JD-Core Version:    0.7.0.1
 */