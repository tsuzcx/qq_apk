import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class agez
  extends aqwt<agfa>
{
  @NonNull
  public agfa a(int paramInt)
  {
    return new agfa();
  }
  
  @Nullable
  public agfa a(aqxa[] paramArrayOfaqxa)
  {
    agfa localagfa = new agfa();
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      agfa.a(localagfa, paramArrayOfaqxa[0].a);
    }
    return localagfa;
  }
  
  public void a(agfa paramagfa) {}
  
  public Class<agfa> clazz()
  {
    return agfa.class;
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
 * Qualified Name:     agez
 * JD-Core Version:    0.7.0.1
 */