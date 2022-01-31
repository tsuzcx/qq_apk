import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class aeul
  extends baua
{
  aeul(aeuk paramaeuk) {}
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if ((localbaoj == null) || (localbaoj.b != 327696) || (localbaoj.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + aeuk.a(this.a).get() + " pos=" + localbaoj.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + aeuk.a(this.a).get() + "  isSttFinish=" + aeuk.a(this.a).get() + " pos=" + localbaoj.i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localbaoj.A + " pos=" + localbaoj.i);
        }
        if (localbaoj.A != null)
        {
          this.a.a(new aetx(localbaoj.A, true), localbaoj.i);
          aeuk.a(this.a).a();
        }
        aeuk.a(this.a).set(aeuk.a(this.a).get() - 1);
      } while (aeuk.a(this.a).get() != 0);
      aeuk.a(this.a).clear();
      aeuk.a(this.a).setSttNetFinish();
      aeuk.a(this.a).b(aeuk.a(this.a));
      aeuk.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localbaoj.g);
      }
      aeuk.a(this.a).a(localbaoj.g);
      aeuk.a(this.a, 0, localbaoj.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localbaoj.A + " pos=" + localbaoj.i);
      }
    } while ((bdje.a(localbaoj.A)) || (aeuk.a(this.a).get() <= 0));
    this.a.a(new aetx(localbaoj.A, false), localbaoj.i);
    aeuk.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeul
 * JD-Core Version:    0.7.0.1
 */