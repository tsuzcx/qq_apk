import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;

public final class aidt
  implements Runnable
{
  public void run()
  {
    byte[] arrayOfByte2 = null;
    String str = QQStoryContext.a().a();
    for (;;)
    {
      try
      {
        if (SessionInfo.getInstance(str).getHttpconn_sig_session() != null)
        {
          int i = SessionInfo.getInstance(str).getHttpconn_sig_session().length;
          byte[] arrayOfByte1 = new byte[i];
          System.arraycopy(SessionInfo.getInstance(str).getHttpconn_sig_session(), 0, arrayOfByte1, 0, i);
          if (SessionInfo.getInstance(str).getSessionKey() != null)
          {
            i = SessionInfo.getInstance(str).getSessionKey().length;
            arrayOfByte2 = new byte[i];
            System.arraycopy(SessionInfo.getInstance(str).getSessionKey(), 0, arrayOfByte2, 0, i);
          }
          if ((arrayOfByte1 == null) || (arrayOfByte1.length == 0) || (arrayOfByte2 == null) || (arrayOfByte2.length == 0))
          {
            QQStoryContext.a();
            HwServlet.getConfig(QQStoryContext.a(), str);
            SLog.d(StoryUploadProcessor.a, "pull session key");
          }
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aidt
 * JD-Core Version:    0.7.0.1
 */