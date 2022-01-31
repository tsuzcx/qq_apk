import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class alky
  extends baua
{
  WeakReference<alkz> a;
  
  public alky(alkz paramalkz)
  {
    this.a = new WeakReference(paramalkz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    baoj localbaoj = (baoj)paramMessage.obj;
    if (localbaoj.b == 35) {
      switch (paramMessage.what)
      {
      }
    }
    do
    {
      do
      {
        return;
        paramMessage = localbaoj.a;
        if ((this.a != null) && (this.a.get() != null))
        {
          ((alkz)this.a.get()).b(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CardHandler", 2, "CardTransProcessorHandler no callback");
      return;
      if ((this.a != null) && (this.a.get() != null))
      {
        ((alkz)this.a.get()).d();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "CardTransProcessorHandler error no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alky
 * JD-Core Version:    0.7.0.1
 */