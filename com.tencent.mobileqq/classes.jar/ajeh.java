import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class ajeh
  implements TVK_SDKMgr.OnLogListener
{
  public static String a = "cmgame_process.CmGameVideoLogImpl";
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, paramString1 + ":" + paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    QLog.e(a, 1, paramString1 + ":" + paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, paramString1 + ":" + paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, paramString1 + ":" + paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    QLog.w(a, 1, paramString1 + ":" + paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajeh
 * JD-Core Version:    0.7.0.1
 */