import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class aawm
  extends aqkz<aawl>
{
  @NonNull
  public aawl a(int paramInt)
  {
    return new aawl();
  }
  
  @Nullable
  public aawl a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aawl.a(paramArrayOfaqlg[0].a);
    }
    return null;
  }
  
  public void a(aawl paramaawl)
  {
    bnnx.a().a(true);
  }
  
  public Class<aawl> clazz()
  {
    return aawl.class;
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
    bnnx.a().a(false);
  }
  
  public int type()
  {
    return 406;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawm
 * JD-Core Version:    0.7.0.1
 */