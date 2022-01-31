import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class alpn
  extends bayj
{
  WeakReference<alpo> a;
  
  public alpn(alpo paramalpo)
  {
    this.a = new WeakReference(paramalpo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    bass localbass = (bass)paramMessage.obj;
    if (localbass.b == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localbass.a;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((alpo)this.a.get()).b(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((alpo)this.a.get()).d();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpn
 * JD-Core Version:    0.7.0.1
 */