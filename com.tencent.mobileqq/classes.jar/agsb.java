import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class agsb
  extends arac<agsc>
{
  @NonNull
  public agsc a(int paramInt)
  {
    return new agsc();
  }
  
  @Nullable
  public agsc a(araj[] paramArrayOfaraj)
  {
    agsc localagsc = new agsc();
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null)) {
      agsc.a(localagsc, paramArrayOfaraj[0].a);
    }
    return localagsc;
  }
  
  public void a(agsc paramagsc) {}
  
  public Class<agsc> clazz()
  {
    return agsc.class;
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
    return 592;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsb
 * JD-Core Version:    0.7.0.1
 */