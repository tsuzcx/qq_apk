import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class acrt
  extends axvs
{
  acrt(acrs paramacrs) {}
  
  public void handleMessage(Message paramMessage)
  {
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || (localaxqf.b != 327696) || (localaxqf.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + acrs.a(this.a).get() + " pos=" + localaxqf.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + acrs.a(this.a).get() + "  isSttFinish=" + acrs.a(this.a).get() + " pos=" + localaxqf.i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localaxqf.A + " pos=" + localaxqf.i);
        }
        if (localaxqf.A != null)
        {
          this.a.a(new acrf(localaxqf.A, true), localaxqf.i);
          acrs.a(this.a).a();
        }
        acrs.a(this.a).set(acrs.a(this.a).get() - 1);
      } while (acrs.a(this.a).get() != 0);
      acrs.a(this.a).clear();
      acrs.a(this.a).setSttNetFinish();
      acrs.a(this.a).b(acrs.a(this.a));
      acrs.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localaxqf.g);
      }
      acrs.a(this.a).a(localaxqf.g);
      acrs.a(this.a, 0, localaxqf.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localaxqf.A + " pos=" + localaxqf.i);
      }
    } while ((baip.a(localaxqf.A)) || (acrs.a(this.a).get() <= 0));
    this.a.a(new acrf(localaxqf.A, false), localaxqf.i);
    acrs.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrt
 * JD-Core Version:    0.7.0.1
 */