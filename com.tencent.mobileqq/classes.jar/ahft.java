import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class ahft
  extends ahfm<ahfs>
{
  public int a()
  {
    return 539;
  }
  
  @NonNull
  public ahfs a(int paramInt)
  {
    super.a(paramInt);
    return new ahfs();
  }
  
  protected ahfs a(amph[] paramArrayOfamph)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfamph != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfamph.length > 0)
      {
        paramArrayOfamph = paramArrayOfamph[0].a;
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketPreloadConfProcessor", 2, "onParsed " + paramArrayOfamph);
        }
        localObject1 = ahfs.a(paramArrayOfamph);
      }
    }
    return localObject1;
  }
  
  public Class<ahfs> a()
  {
    return ahfs.class;
  }
  
  public void a()
  {
    super.a();
    ahia.a();
  }
  
  public void a(ahfs paramahfs)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        PreloadManager localPreloadManager = (PreloadManager)localQQAppInterface.getManager(151);
        if (localPreloadManager != null)
        {
          localPreloadManager.a(paramahfs.a, 2);
          localPreloadManager.b();
          localPreloadManager.b(true);
        }
        ahia.a();
        if ((paramahfs.a != null) && (paramahfs.a.length() > 0)) {
          ahia.a(localQQAppInterface, 1, 0, a(), ahia.a(a()), ampl.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, ahia.a(a()));
        }
      }
      return;
    }
    catch (Throwable paramahfs)
    {
      QLog.e("springHb_SpringFestivalRedpacketPreloadConfProcessor", 1, QLog.getStackTraceString(paramahfs));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public ahfs b(amph[] paramArrayOfamph)
  {
    return (ahfs)super.b(paramArrayOfamph);
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
 * Qualified Name:     ahft
 * JD-Core Version:    0.7.0.1
 */