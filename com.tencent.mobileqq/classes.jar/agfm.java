import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class agfm
  extends bdzm
{
  agfm(agfl paramagfl) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.b != 327696) || (localbduk.c != 68)) {}
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
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler STATUS_SEND_CANCEL unFinishSeg.get()=" + agfl.a(this.a).get() + " pos=" + localbduk.i);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve finished! unFinishSeg=" + agfl.a(this.a).get() + "  isSttFinish=" + agfl.a(this.a).get() + " pos=" + localbduk.i);
        }
        if (localbduk.A != null)
        {
          this.a.a(new agey(localbduk.A, true), localbduk.i);
          agfl.a(this.a).a();
        }
        agfl.a(this.a).set(agfl.a(this.a).get() - 1);
      } while (agfl.a(this.a).get() != 0);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper unFinishSeg == 0");
      }
      agfl.a(this.a).clear();
      agfl.a(this.a).setSttNetFinish();
      agfl.a(this.a).b(agfl.a(this.a));
      agfl.a(this.a, 1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "mPicTransProcessorHandler recieve error:" + localbduk.g);
      }
      agfl.a(this.a).a(localbduk.g);
      agfl.a(this.a, 0, localbduk.g);
      this.a.a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "vadHelper startrecord sendrequest process text =" + localbduk.A + " pos=" + localbduk.i);
      }
    } while ((bgsp.a(localbduk.A)) || (agfl.a(this.a).get() <= 0));
    this.a.a(new agey(localbduk.A, false), localbduk.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfm
 * JD-Core Version:    0.7.0.1
 */