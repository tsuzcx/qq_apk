import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.image.NativeVideoImage;
import java.io.File;
import mqq.os.MqqHandler;

class adwo
  extends MqqHandler
{
  adwo(advv paramadvv) {}
  
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
          bbmy.a(advv.e(this.a), 2131653670, 0).a();
          return;
          advv.f(this.a).getString(2131653671);
          paramMessage = (String)paramMessage.obj;
          bacm.a(advv.g(this.a), paramMessage);
          bbmy.a(advv.h(this.a), 2, ajjy.a(2131634256), 0).a();
          return;
        } while (paramMessage.obj == null);
        paramMessage = new File((String)paramMessage.obj);
      } while (!paramMessage.exists());
      paramMessage = babr.a(advv.i(this.a), 232, advv.j(this.a).getResources().getString(2131653703), advv.k(this.a).getResources().getString(2131653702), 2131653685, 2131652888, new adwp(this, paramMessage), new adwq(this));
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
      bbmy.a(advv.l(this.a), 1, ajjy.a(2131634274), 0).a();
      NativeVideoImage.resumeAll();
      advv.a(this.a);
      return;
    case 10000: 
      this.a.n = true;
      this.a.d(100);
      sendEmptyMessageDelayed(10003, 200L);
      return;
    }
    this.a.B();
    bbmy.a(advv.m(this.a), 2, ajjy.a(2131634263), 0).a();
    NativeVideoImage.resumeAll();
    advv.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwo
 * JD-Core Version:    0.7.0.1
 */