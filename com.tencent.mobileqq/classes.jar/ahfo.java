import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public abstract class ahfo<T>
  extends ampb<T>
{
  public int a()
  {
    return 0;
  }
  
  public Class<T> a()
  {
    return null;
  }
  
  @NonNull
  public T a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[migrateOldOrDefaultContent]" + a());
    }
    return null;
  }
  
  protected abstract T a(ampi[] paramArrayOfampi);
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[onUpdate] onReqNoReceive = " + a());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[onReqNoReceive] failCode=" + paramInt + " type: " + a());
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localQQAppInterface != null) && (paramInt == -2)) {
        ahic.a(2, 2, a(), ahic.a(a()), ampm.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[0]);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(T paramT)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[onUpdate] " + a());
    }
    try
    {
      paramT = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ahic.a(paramT, 1, 0, a(), ahic.a(a()), ampm.a().a(a(), paramT.getCurrentAccountUin()), false, ahic.a(a()));
      return;
    }
    catch (Throwable paramT)
    {
      QLog.e("springHb_BaseConfProcessor", 1, QLog.getStackTraceString(paramT));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public T b(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[onParsed]" + a());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramArrayOfampi == null) || (paramArrayOfampi.length == 0))
    {
      if (localQQAppInterface != null)
      {
        ahic.a(2, 3, a(), ahic.a(a()), ampm.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { "parse config fail!" });
        return null;
      }
    }
    else
    {
      try
      {
        int i = paramArrayOfampi[0].jdField_a_of_type_Int;
        ahic.a(a(), i);
        ahic.a(a(), MD5.toMD5(paramArrayOfampi[0].jdField_a_of_type_JavaLangString));
        paramArrayOfampi = a(paramArrayOfampi);
        return paramArrayOfampi;
      }
      catch (Exception paramArrayOfampi)
      {
        if (localQQAppInterface != null)
        {
          if (!(paramArrayOfampi instanceof JSONException)) {
            break label207;
          }
          ahic.a(2, 5, a(), ahic.a(a()), ampm.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfampi.getCause()) });
        }
      }
      for (;;)
      {
        throw new QConfigureException(paramArrayOfampi.getMessage());
        label207:
        ahic.a(2, 4, a(), ahic.a(a()), ampm.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfampi.getCause()) });
      }
    }
    return null;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfo
 * JD-Core Version:    0.7.0.1
 */