import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class adcj
  extends aywb
{
  adcj(adci paramadci) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if ((localayqo == null) || (localayqo.b != 327696) || (localayqo.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + adci.a(this.a).get() + " pos=" + localayqo.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + adci.a(this.a).get() + "  isSttFinish=" + adci.a(this.a).get() + " pos=" + localayqo.i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localayqo.A + " pos=" + localayqo.i);
        }
        if (localayqo.A != null)
        {
          this.a.a(new adbv(localayqo.A, true), localayqo.i);
          adci.a(this.a).a();
        }
        adci.a(this.a).set(adci.a(this.a).get() - 1);
      } while (adci.a(this.a).get() != 0);
      adci.a(this.a).clear();
      adci.a(this.a).setSttNetFinish();
      adci.a(this.a).b(adci.a(this.a));
      adci.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localayqo.g);
      }
      adci.a(this.a).a(localayqo.g);
      adci.a(this.a, 0, localayqo.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localayqo.A + " pos=" + localayqo.i);
      }
    } while ((bbkk.a(localayqo.A)) || (adci.a(this.a).get() <= 0));
    this.a.a(new adbv(localayqo.A, false), localayqo.i);
    adci.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcj
 * JD-Core Version:    0.7.0.1
 */