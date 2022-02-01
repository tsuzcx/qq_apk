import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aitt
  extends arac<aits>
{
  @NonNull
  public aits a(int paramInt)
  {
    return new aits();
  }
  
  @Nullable
  public aits a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      aits localaits = aits.a(paramArrayOfaraj[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AdEmoConfigProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      }
      return localaits;
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
  
  public void a(aits paramaits)
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      String str = localQQAppInterface.c();
      aitr.a(localQQAppInterface.getApp(), str, paramaits.a);
    }
  }
  
  public Class<aits> clazz()
  {
    return aits.class;
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
 * Qualified Name:     aitt
 * JD-Core Version:    0.7.0.1
 */