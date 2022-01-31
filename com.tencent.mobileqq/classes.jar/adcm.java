import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class adcm
  extends ayvz
{
  adcm(adcl paramadcl) {}
  
  public void handleMessage(Message paramMessage)
  {
    ayqm localayqm = (ayqm)paramMessage.obj;
    if ((localayqm == null) || (localayqm.b != 327696) || (localayqm.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + adcl.a(this.a).get() + " pos=" + localayqm.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + adcl.a(this.a).get() + "  isSttFinish=" + adcl.a(this.a).get() + " pos=" + localayqm.i);
        }
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest finish text =" + localayqm.A + " pos=" + localayqm.i);
        }
        if (localayqm.A != null)
        {
          this.a.a(new adby(localayqm.A, true), localayqm.i);
          adcl.a(this.a).a();
        }
        adcl.a(this.a).set(adcl.a(this.a).get() - 1);
      } while (adcl.a(this.a).get() != 0);
      adcl.a(this.a).clear();
      adcl.a(this.a).setSttNetFinish();
      adcl.a(this.a).b(adcl.a(this.a));
      adcl.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localayqm.g);
      }
      adcl.a(this.a).a(localayqm.g);
      adcl.a(this.a, 0, localayqm.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localayqm.A + " pos=" + localayqm.i);
      }
    } while ((bbjw.a(localayqm.A)) || (adcl.a(this.a).get() <= 0));
    this.a.a(new adby(localayqm.A, false), localayqm.i);
    adcl.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adcm
 * JD-Core Version:    0.7.0.1
 */