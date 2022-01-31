import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class ahfv
  extends ahfo<ahfu>
{
  public int a()
  {
    return 539;
  }
  
  @NonNull
  public ahfu a(int paramInt)
  {
    super.a(paramInt);
    return new ahfu();
  }
  
  protected ahfu a(ampi[] paramArrayOfampi)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfampi != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfampi.length > 0)
      {
        paramArrayOfampi = paramArrayOfampi[0].a;
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketPreloadConfProcessor", 2, "onParsed " + paramArrayOfampi);
        }
        localObject1 = ahfu.a(paramArrayOfampi);
      }
    }
    return localObject1;
  }
  
  public Class<ahfu> a()
  {
    return ahfu.class;
  }
  
  public void a()
  {
    super.a();
    ahic.a();
  }
  
  public void a(ahfu paramahfu)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        PreloadManager localPreloadManager = (PreloadManager)localQQAppInterface.getManager(151);
        if (localPreloadManager != null)
        {
          localPreloadManager.a(paramahfu.a, 2);
          localPreloadManager.b();
          localPreloadManager.b(true);
        }
        ahic.a();
        if ((paramahfu.a != null) && (paramahfu.a.length() > 0)) {
          ahic.a(localQQAppInterface, 1, 0, a(), ahic.a(a()), ampm.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, ahic.a(a()));
        }
      }
      return;
    }
    catch (Throwable paramahfu)
    {
      QLog.e("springHb_SpringFestivalRedpacketPreloadConfProcessor", 1, QLog.getStackTraceString(paramahfu));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public ahfu b(ampi[] paramArrayOfampi)
  {
    return (ahfu)super.b(paramArrayOfampi);
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
 * Qualified Name:     ahfv
 * JD-Core Version:    0.7.0.1
 */