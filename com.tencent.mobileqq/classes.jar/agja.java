import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class agja
  extends aqkz<agjb>
{
  @NonNull
  public agjb a(int paramInt)
  {
    return new agjb();
  }
  
  @Nullable
  public agjb a(aqlg[] paramArrayOfaqlg)
  {
    agjb localagjb = new agjb();
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null)) {
      agjb.a(localagjb, paramArrayOfaqlg[0].a);
    }
    return localagjb;
  }
  
  public void a(agjb paramagjb) {}
  
  public Class<agjb> clazz()
  {
    return agjb.class;
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
 * Qualified Name:     agja
 * JD-Core Version:    0.7.0.1
 */