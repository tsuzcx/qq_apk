import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class agmm
  extends arac<agml>
{
  @NonNull
  public agml a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new agml();
  }
  
  @Nullable
  public agml a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "onParsed");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return agml.a(paramArrayOfaraj[0].a);
    }
    return null;
  }
  
  public void a(agml paramagml) {}
  
  public Class<agml> clazz()
  {
    return agml.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 609;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmm
 * JD-Core Version:    0.7.0.1
 */