import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aamc
  extends aqwt<aamb>
{
  @NonNull
  public aamb a(int paramInt)
  {
    return new aamb();
  }
  
  @Nullable
  public aamb a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aamb localaamb = aamb.a(paramArrayOfaqxa[0].a);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      a(localaamb);
      return localaamb;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(aamb paramaamb)
  {
    if (paramaamb != null)
    {
      VSConfigManager.getInstance().setValue("mine_videostory_entrance", paramaamb.a());
      VSConfigManager.getInstance().setValue("enable_click_take_picture", paramaamb.b());
      VSConfigManager.getInstance().setValue("mine_videostory_drawer_entrance", paramaamb.c());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramaamb.toString());
    }
  }
  
  public Class<aamb> clazz()
  {
    return aamb.class;
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
 * Qualified Name:     aamc
 * JD-Core Version:    0.7.0.1
 */