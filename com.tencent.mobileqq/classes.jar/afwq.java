import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class afwq
  extends aqwt<afwp>
{
  @NonNull
  public afwp a(int paramInt)
  {
    QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "migrateOldOrDefaultContent, type = " + paramInt);
    return new afwp();
  }
  
  @Nullable
  public afwp a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopDragonKingAnimEntryConfig.config", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return afwp.a(paramArrayOfaqxa[0].a);
    }
    return null;
  }
  
  public void a(afwp paramafwp) {}
  
  public Class<afwp> clazz()
  {
    return afwp.class;
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
 * Qualified Name:     afwq
 * JD-Core Version:    0.7.0.1
 */