import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class aiat
  extends auto
{
  aiat(aias paramaias) {}
  
  protected void a(Object paramObject)
  {
    QLog.i(aias.g, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      autc localautc;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localautc = (autc)paramObject.next();
            if ((TextUtils.isEmpty(localautc.b)) || (!localautc.b.equals(this.a.a.a()))) {
              break label115;
            }
            aias.a(this.a, localautc);
            aias.a(this.a, localautc);
            QLog.i(aias.g, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(aias.g, 1, paramObject.getMessage());
      }
      label115:
      if ((!TextUtils.isEmpty(localautc.b)) && (localautc.b.equals(this.a.a.b())))
      {
        aias.b(this.a, localautc);
        QLog.i(aias.g, 1, "update my info.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiat
 * JD-Core Version:    0.7.0.1
 */