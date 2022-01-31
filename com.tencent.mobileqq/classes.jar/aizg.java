import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.apollo.lightGame.CmGameSocketConnection;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aizg
  extends Handler
{
  private WeakReference<CmGameSocketConnection> a;
  
  public aizg(Looper paramLooper, CmGameSocketConnection paramCmGameSocketConnection)
  {
    super(paramLooper);
    this.a = new WeakReference(paramCmGameSocketConnection);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConnection.ConnectionHandler", 2, "[handleMessage] msg=" + paramMessage.what);
    }
    if (this.a != null) {}
    for (CmGameSocketConnection localCmGameSocketConnection = (CmGameSocketConnection)this.a.get();; localCmGameSocketConnection = null)
    {
      if (localCmGameSocketConnection == null) {
        QLog.e("CmGameConnection.ConnectionHandler", 1, "[handleMessage] no connection");
      }
      boolean bool;
      label165:
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            bool = CmGameSocketConnection.a(localCmGameSocketConnection);
            if (QLog.isColorLevel()) {
              QLog.d("CmGameConnection.ConnectionHandler", 2, new Object[] { "[handleMessage] conn result=", Boolean.valueOf(bool), ", connected=", Boolean.valueOf(localCmGameSocketConnection.a()) });
            }
            if (bool) {
              break label165;
            }
          }
        } while (localCmGameSocketConnection.a());
        localCmGameSocketConnection.d();
        return;
        super.removeMessages(2);
        paramMessage = super.obtainMessage(2);
        paramMessage.obj = Boolean.valueOf(true);
        super.sendMessage(paramMessage);
        return;
        bool = CmGameSocketConnection.b(localCmGameSocketConnection);
        super.removeMessages(2);
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] heartbeat, result=", Boolean.valueOf(bool), ", flag=", paramMessage.obj });
        }
        if (bool)
        {
          if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue())) {
            localCmGameSocketConnection.c();
          }
          if (ajmr.a > 0L) {}
          for (l = ajmr.a;; l = 120000L)
          {
            super.sendEmptyMessageDelayed(2, l);
            return;
          }
        }
        localCmGameSocketConnection.a(true);
        return;
        bool = CmGameSocketConnection.c(localCmGameSocketConnection);
        if (QLog.isColorLevel()) {
          QLog.d("CmGameConnection.ConnectionHandler", 1, new Object[] { "[handleMessage] send, result=", Boolean.valueOf(bool) });
        }
      } while (!bool);
      super.removeMessages(2);
      if (ajmr.a > 0L) {}
      for (long l = ajmr.a;; l = 120000L)
      {
        super.sendEmptyMessageDelayed(2, l);
        if (!CmGameSocketConnection.d(localCmGameSocketConnection)) {
          break;
        }
        super.removeMessages(3);
        super.sendEmptyMessage(3);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizg
 * JD-Core Version:    0.7.0.1
 */