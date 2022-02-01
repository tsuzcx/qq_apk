import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.os.MqqHandler;

class aicm
  extends MqqHandler
{
  aicm(aibr paramaibr) {}
  
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
          QQToast.a(aibr.e(this.a), 2131718205, 0).a();
          return;
          aibr.f(this.a).getString(2131718206);
          paramMessage = (String)paramMessage.obj;
          bhmq.a(aibr.g(this.a), paramMessage);
          QQToast.a(aibr.h(this.a), 2, anzj.a(2131698969), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = bhlq.a(aibr.i(this.a), 232, aibr.j(this.a).getResources().getString(2131718237), aibr.k(this.a).getResources().getString(2131718236), 2131718220, 2131717445, new aicn(this, paramMessage), new aico(this));
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
      QQToast.a(aibr.l(this.a), 1, anzj.a(2131698987), 0).a();
      NativeVideoImage.resumeAll();
      aibr.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    QQToast.a(aibr.m(this.a), 2, anzj.a(2131698976), 0).a();
    NativeVideoImage.resumeAll();
    aibr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicm
 * JD-Core Version:    0.7.0.1
 */