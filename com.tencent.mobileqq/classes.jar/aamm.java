import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aamm
  extends aqwt<aaml>
{
  @NonNull
  public aaml a(int paramInt)
  {
    return new aaml();
  }
  
  @Nullable
  public aaml a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return aaml.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(aaml paramaaml)
  {
    bnhs.a().a(true);
  }
  
  public Class<aaml> clazz()
  {
    return aaml.class;
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
  
  public void onReqNoReceive()
  {
    super.onReqNoReceive();
    bnhs.a().a(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamm
 * JD-Core Version:    0.7.0.1
 */