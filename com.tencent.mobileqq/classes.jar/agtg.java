import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

public class agtg
  extends agsz<agtf>
{
  public int a()
  {
    return 539;
  }
  
  @NonNull
  public agtf a(int paramInt)
  {
    super.a(paramInt);
    return new agtf();
  }
  
  protected agtf a(alzs[] paramArrayOfalzs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfalzs != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfalzs.length > 0)
      {
        paramArrayOfalzs = paramArrayOfalzs[0].a;
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketPreloadConfProcessor", 2, "onParsed " + paramArrayOfalzs);
        }
        localObject1 = agtf.a(paramArrayOfalzs);
      }
    }
    return localObject1;
  }
  
  public Class<agtf> a()
  {
    return agtf.class;
  }
  
  public void a()
  {
    super.a();
    agvn.a();
  }
  
  public void a(agtf paramagtf)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null)
      {
        PreloadManager localPreloadManager = (PreloadManager)localQQAppInterface.getManager(151);
        if (localPreloadManager != null)
        {
          localPreloadManager.a(paramagtf.a, 2);
          localPreloadManager.b();
          localPreloadManager.b(true);
        }
        agvn.a();
        if ((paramagtf.a != null) && (paramagtf.a.length() > 0)) {
          agvn.a(localQQAppInterface, 1, 0, a(), agvn.a(a()), alzw.a().a(a(), localQQAppInterface.getCurrentAccountUin()), true, agvn.a(a()));
        }
      }
      return;
    }
    catch (Throwable paramagtf)
    {
      QLog.e("springHb_SpringFestivalRedpacketPreloadConfProcessor", 1, QLog.getStackTraceString(paramagtf));
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public agtf b(alzs[] paramArrayOfalzs)
  {
    return (agtf)super.b(paramArrayOfalzs);
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
 * Qualified Name:     agtg
 * JD-Core Version:    0.7.0.1
 */