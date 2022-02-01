import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class aixs
  extends beyf
{
  aixs(aixr paramaixr) {}
  
  public void handleMessage(Message paramMessage)
  {
    bete localbete = (bete)paramMessage.obj;
    if ((localbete == null) || (localbete.b != 327696) || (localbete.c != 68)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler STATUS_SEND_CANCEL unFinishSegSize=" + aixr.a(this.a).get() + " pos=" + localbete.i);
        return;
        if (localbete.A != null) {
          this.a.a(new aixw(localbete.A, true), localbete.i);
        }
        aixr.a(this.a).set(aixr.a(this.a).get() - 1);
      } while (aixr.a(this.a).get() != 0);
      aixr.a(this.a).clear();
      if (aixr.a(this.a) != null) {
        aixr.a(this.a).d();
      }
      aixr.a(this.a).b(aixr.a(this.a));
      aiyu.a(1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler recieve error:" + localbete.g);
      }
      if (aixr.a(this.a) != null) {
        aixr.a(this.a).a(localbete.g);
      }
      aiyu.a(0, localbete.g);
      this.a.a();
      return;
    } while ((bhsr.a(localbete.A)) || (aixr.a(this.a).get() <= 0));
    this.a.a(new aixw(localbete.A, false), localbete.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixs
 * JD-Core Version:    0.7.0.1
 */