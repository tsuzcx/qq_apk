import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class ahsy
  extends MqqHandler
{
  ahsy(ahsd paramahsd) {}
  
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
          QQToast.a(ahsd.e(this.a), 2131718072, 0).a();
          return;
          ahsd.f(this.a).getString(2131718073);
          paramMessage = (String)paramMessage.obj;
          bgmo.a(ahsd.g(this.a), paramMessage);
          QQToast.a(ahsd.h(this.a), 2, anni.a(2131698862), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bglp.a(ahsd.i(this.a), 232, ahsd.j(this.a).getResources().getString(2131718104), ahsd.k(this.a).getResources().getString(2131718103), 2131718087, 2131717317, new ahsz(this, paramMessage), new ahta(this));
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
      QQToast.a(ahsd.l(this.a), 1, anni.a(2131698880), 0).a();
      NativeVideoImage.resumeAll();
      ahsd.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(ahsd.m(this.a), 2, anni.a(2131698869), 0).a();
    NativeVideoImage.resumeAll();
    ahsd.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsy
 * JD-Core Version:    0.7.0.1
 */