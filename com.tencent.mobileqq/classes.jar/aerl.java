import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aerl
  extends aofy<aerk>
{
  public int a()
  {
    return 609;
  }
  
  @NonNull
  public aerk a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new aerk();
  }
  
  @Nullable
  public aerk a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aerk.a(paramArrayOfaogf[0].a);
    }
    return null;
  }
  
  public Class<aerk> a()
  {
    return aerk.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public void a(aerk paramaerk) {}
  
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
 * Qualified Name:     aerl
 * JD-Core Version:    0.7.0.1
 */