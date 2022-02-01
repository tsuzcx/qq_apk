import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class afnv
  extends aptq<afnw>
{
  @NonNull
  public afnw a(int paramInt)
  {
    return new afnw();
  }
  
  @Nullable
  public afnw a(aptx[] paramArrayOfaptx)
  {
    afnw localafnw = new afnw();
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null)) {
      afnw.a(localafnw, paramArrayOfaptx[0].a);
    }
    return localafnw;
  }
  
  public void a(afnw paramafnw) {}
  
  public Class<afnw> clazz()
  {
    return afnw.class;
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
 * Qualified Name:     afnv
 * JD-Core Version:    0.7.0.1
 */