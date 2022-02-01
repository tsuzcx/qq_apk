import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class abaf
  extends arac<abae>
{
  @NonNull
  public abae a(int paramInt)
  {
    return new abae();
  }
  
  @Nullable
  public abae a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      abae localabae = abae.a(paramArrayOfaraj[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      a(localabae);
      return localabae;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(abae paramabae)
  {
    if (paramabae != null)
    {
      abac.a().a("mine_videostory_entrance", paramabae.a());
      abac.a().a("enable_click_take_picture", paramabae.b());
      abac.a().a("mine_videostory_drawer_entrance", paramabae.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramabae.toString());
    }
  }
  
  public Class<abae> clazz()
  {
    return abae.class;
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
    return 411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abaf
 * JD-Core Version:    0.7.0.1
 */