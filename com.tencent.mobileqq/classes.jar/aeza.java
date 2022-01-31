import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class aeza
  extends bayj
{
  aeza(aeyz paramaeyz) {}
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass = (bass)paramMessage.obj;
    if ((localbass == null) || (localbass.b != 327696) || (localbass.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + aeyz.a(this.a).get() + " pos=" + localbass.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + aeyz.a(this.a).get() + "  isSttFinish=" + aeyz.a(this.a).get() + " pos=" + localbass.i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localbass.A + " pos=" + localbass.i);
        }
        if (localbass.A != null)
        {
          this.a.a(new aeym(localbass.A, true), localbass.i);
          aeyz.a(this.a).a();
        }
        aeyz.a(this.a).set(aeyz.a(this.a).get() - 1);
      } while (aeyz.a(this.a).get() != 0);
      aeyz.a(this.a).clear();
      aeyz.a(this.a).setSttNetFinish();
      aeyz.a(this.a).b(aeyz.a(this.a));
      aeyz.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localbass.g);
      }
      aeyz.a(this.a).a(localbass.g);
      aeyz.a(this.a, 0, localbass.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localbass.A + " pos=" + localbass.i);
      }
    } while ((bdnn.a(localbass.A)) || (aeyz.a(this.a).get() <= 0));
    this.a.a(new aeym(localbass.A, false), localbass.i);
    aeyz.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeza
 * JD-Core Version:    0.7.0.1
 */