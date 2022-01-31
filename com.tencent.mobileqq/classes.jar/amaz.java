import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amaz
  extends amay
{
  public int a()
  {
    return 170;
  }
  
  public amas a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      ambf localambf = (ambf)amaf.a(paramString, ambf.class);
      return new amat(paramString, localambf);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkAIDictConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(amas paramamas)
  {
    super.a(paramamas);
    if (paramamas == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamas.a());
          paramamas = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramamas == null);
        paramamas = (ArkAppCenter)paramamas.getManager(121);
      } while (paramamas == null);
      paramamas = paramamas.a();
    } while (paramamas == null);
    paramamas.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amaz
 * JD-Core Version:    0.7.0.1
 */