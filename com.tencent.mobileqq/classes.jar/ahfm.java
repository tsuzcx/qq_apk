import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public abstract class ahfm<T>
  extends ampa<T>
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
  
  protected abstract T a(amph[] paramArrayOfamph);
  
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
        ahia.a(2, 2, a(), ahia.a(a()), ampl.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[0]);
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
      ahia.a(paramT, 1, 0, a(), ahia.a(a()), ampl.a().a(a(), paramT.getCurrentAccountUin()), false, ahia.a(a()));
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
  public T b(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_BaseConfProcessor", 2, "[onParsed]" + a());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramArrayOfamph == null) || (paramArrayOfamph.length == 0))
    {
      if (localQQAppInterface != null)
      {
        ahia.a(2, 3, a(), ahia.a(a()), ampl.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { "parse config fail!" });
        return null;
      }
    }
    else
    {
      try
      {
        int i = paramArrayOfamph[0].jdField_a_of_type_Int;
        ahia.a(a(), i);
        ahia.a(a(), MD5.toMD5(paramArrayOfamph[0].jdField_a_of_type_JavaLangString));
        paramArrayOfamph = a(paramArrayOfamph);
        return paramArrayOfamph;
      }
      catch (Exception paramArrayOfamph)
      {
        if (localQQAppInterface != null)
        {
          if (!(paramArrayOfamph instanceof JSONException)) {
            break label207;
          }
          ahia.a(2, 5, a(), ahia.a(a()), ampl.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfamph.getCause()) });
        }
      }
      for (;;)
      {
        throw new QConfigureException(paramArrayOfamph.getMessage());
        label207:
        ahia.a(2, 4, a(), ahia.a(a()), ampl.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, new String[] { QLog.getStackTraceString(paramArrayOfamph.getCause()) });
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
 * Qualified Name:     ahfm
 * JD-Core Version:    0.7.0.1
 */