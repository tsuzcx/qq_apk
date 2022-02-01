import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aiiz
  extends aqwt<aiiy>
{
  @NonNull
  public aiiy a(int paramInt)
  {
    return new aiiy();
  }
  
  @Nullable
  public aiiy a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aiiy localaiiy = aiiy.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AdEmoConfigProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localaiiy;
    }
    return null;
  }
  
  public QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getApp, runtime is null ?  ");
      if (localAppRuntime != null) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AdEmoConfigProcessor", 2, bool + " , runtime instanceof QQAppInterface ? " + (localAppRuntime instanceof QQAppInterface));
      if (!(localAppRuntime instanceof QQAppInterface)) {
        break;
      }
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(aiiy paramaiiy)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.getCurrentUin();
      aiix.a(localQQAppInterface.getApp(), str, paramaiiy.a);
    }
  }
  
  public Class<aiiy> clazz()
  {
    return aiiy.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 657;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiz
 * JD-Core Version:    0.7.0.1
 */