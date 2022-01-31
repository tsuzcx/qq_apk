import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ambd
  extends amay
{
  public int a()
  {
    return 380;
  }
  
  public amas a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    try
    {
      ambm localambm = (ambm)amaf.a(paramString, ambm.class);
      return new amax(paramString, localambm);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkPlatformConfProcessor", 1, "readJsonOrXml:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(amas paramamas)
  {
    super.a(paramamas);
    if (paramamas == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + a() + ", content = " + paramamas.a());
      paramamas = paramamas.a();
      aleo.a();
    } while ((paramamas == null) || (paramamas.a() == null));
    paramamas = paramamas.a();
    if (paramamas == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramamas.jdField_a_of_type_Boolean, paramamas.b, paramamas.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambd
 * JD-Core Version:    0.7.0.1
 */