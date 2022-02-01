import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aban
  extends arac<abam>
{
  @NonNull
  public abam a(int paramInt)
  {
    return new abam();
  }
  
  @Nullable
  public abam a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      abam localabam = abam.a(paramArrayOfaraj[0].a);
      a(localabam);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      return localabam;
    }
    return null;
  }
  
  public void a(abam paramabam)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramabam != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramabam.toString());
      abac.a().a("subscribe_entrance_enable", paramabam.a());
      abac.a().a("is_open_sharing", paramabam.b());
      abac.a().a("subscribe_account_title", paramabam.c());
      abac.a().a("newfollowlist", paramabam.d());
      abac.a().a("subscribe_publish_entrance_enable", paramabam.e());
    }
  }
  
  public Class<abam> clazz()
  {
    return abam.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 463;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aban
 * JD-Core Version:    0.7.0.1
 */