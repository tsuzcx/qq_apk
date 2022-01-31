import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aewa
  extends aokh<aevz>
{
  public int a()
  {
    return 609;
  }
  
  @NonNull
  public aevz a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new aevz();
  }
  
  @Nullable
  public aevz a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aevz.a(paramArrayOfaoko[0].a);
    }
    return null;
  }
  
  public Class<aevz> a()
  {
    return aevz.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(aevz paramaevz) {}
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewa
 * JD-Core Version:    0.7.0.1
 */