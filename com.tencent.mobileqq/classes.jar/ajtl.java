import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajtl
  extends aywb
{
  WeakReference<ajtm> a;
  
  public ajtl(ajtm paramajtm)
  {
    this.a = new WeakReference(paramajtm);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayqo localayqo = (ayqo)paramMessage.obj;
    if (localayqo.b == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localayqo.a;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((ajtm)this.a.get()).b(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((ajtm)this.a.get()).d();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtl
 * JD-Core Version:    0.7.0.1
 */