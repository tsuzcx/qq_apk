import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class agql
  extends asnf
{
  agql(agqk paramagqk) {}
  
  protected void a(Object paramObject)
  {
    QLog.i(agqk.g, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      asmt localasmt;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localasmt = (asmt)paramObject.next();
            if ((TextUtils.isEmpty(localasmt.b)) || (!localasmt.b.equals(this.a.a.a()))) {
              break label115;
            }
            agqk.a(this.a, localasmt);
            agqk.a(this.a, localasmt);
            QLog.i(agqk.g, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(agqk.g, 1, paramObject.getMessage());
      }
      label115:
      if ((!TextUtils.isEmpty(localasmt.b)) && (localasmt.b.equals(this.a.a.b())))
      {
        agqk.b(this.a, localasmt);
        QLog.i(agqk.g, 1, "update my info.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agql
 * JD-Core Version:    0.7.0.1
 */