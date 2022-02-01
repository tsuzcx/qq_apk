import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class abap
  extends arac<abao>
{
  @NonNull
  public abao a(int paramInt)
  {
    return new abao();
  }
  
  @Nullable
  public abao a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return abao.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(abao paramabao)
  {
    bopi.a().a(true);
  }
  
  public Class<abao> clazz()
  {
    return abao.class;
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
    bopi.a().a(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abap
 * JD-Core Version:    0.7.0.1
 */