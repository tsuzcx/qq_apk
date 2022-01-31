import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ambb
  extends amay
{
  public int a()
  {
    return 250;
  }
  
  public amas a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      ambh localambh = (ambh)amaf.a(paramString, ambh.class);
      return new amav(paramString, localambh);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambb
 * JD-Core Version:    0.7.0.1
 */