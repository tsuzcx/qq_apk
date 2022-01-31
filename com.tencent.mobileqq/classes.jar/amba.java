import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class amba
  extends amay
{
  public int a()
  {
    return 186;
  }
  
  public amas a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        ambg localambg = (ambg)amaf.a(paramString, ambg.class);
        ambq localambq;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localambq = (ambq)amaf.a(paramString, ambq.class);
          return new amau(paramString, localambg, localambq);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localambg = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(amas paramamas)
  {
    super.a(paramamas);
    if (paramamas == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    alck localalck;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamas.a());
      localalck = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(121)).a();
      paramamas = paramamas.a();
    } while (paramamas == null);
    localalck.a(paramamas.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amba
 * JD-Core Version:    0.7.0.1
 */