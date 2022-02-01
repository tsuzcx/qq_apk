import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aawk
  extends aqkz<aawj>
{
  @NonNull
  public aawj a(int paramInt)
  {
    return new aawj();
  }
  
  @Nullable
  public aawj a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aawj localaawj = aawj.a(paramArrayOfaqlg[0].a);
      a(localaawj);
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      return localaawj;
    }
    return null;
  }
  
  public void a(aawj paramaawj)
  {
    QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate ");
    if (paramaawj != null)
    {
      QLog.i("Q.videostory.config.VSSubscribeProcessor", 2, "onUpdate " + paramaawj.toString());
      aavz.a().a("subscribe_entrance_enable", paramaawj.a());
      aavz.a().a("is_open_sharing", paramaawj.b());
      aavz.a().a("subscribe_account_title", paramaawj.c());
      aavz.a().a("newfollowlist", paramaawj.d());
      aavz.a().a("subscribe_publish_entrance_enable", paramaawj.e());
    }
  }
  
  public Class<aawj> clazz()
  {
    return aawj.class;
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
 * Qualified Name:     aawk
 * JD-Core Version:    0.7.0.1
 */