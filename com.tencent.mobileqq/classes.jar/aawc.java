import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aawc
  extends aqkz<aawb>
{
  @NonNull
  public aawb a(int paramInt)
  {
    return new aawb();
  }
  
  @Nullable
  public aawb a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aawb localaawb = aawb.a(paramArrayOfaqlg[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      a(localaawb);
      return localaawb;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(aawb paramaawb)
  {
    if (paramaawb != null)
    {
      aavz.a().a("mine_videostory_entrance", paramaawb.a());
      aavz.a().a("enable_click_take_picture", paramaawb.b());
      aavz.a().a("mine_videostory_drawer_entrance", paramaawb.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramaawb.toString());
    }
  }
  
  public Class<aawb> clazz()
  {
    return aawb.class;
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
 * Qualified Name:     aawc
 * JD-Core Version:    0.7.0.1
 */