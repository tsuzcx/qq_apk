import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aamk
  extends aqwt<aamj>
{
  @NonNull
  public aamj a(int paramInt)
  {
    return new aamj();
  }
  
  @Nullable
  public aamj a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aamj localaamj = aamj.a(paramArrayOfaqxa[0].a);
      a(localaamj);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      return localaamj;
    }
    return null;
  }
  
  public void a(aamj paramaamj)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramaamj != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramaamj.toString());
      VSConfigManager.getInstance().setValue("subscribe_entrance_enable", paramaamj.a());
      VSConfigManager.getInstance().setValue("is_open_sharing", paramaamj.b());
      VSConfigManager.getInstance().setValue("subscribe_account_title", paramaamj.c());
      VSConfigManager.getInstance().setValue("newfollowlist", paramaamj.d());
      VSConfigManager.getInstance().setValue("subscribe_publish_entrance_enable", paramaamj.e());
    }
  }
  
  public Class<aamj> clazz()
  {
    return aamj.class;
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
 * Qualified Name:     aamk
 * JD-Core Version:    0.7.0.1
 */