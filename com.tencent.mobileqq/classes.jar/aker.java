import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aker
  extends aqwt
{
  public static akeq a()
  {
    return (akeq)aqxe.a().a(470);
  }
  
  @NonNull
  public akeq a(int paramInt)
  {
    return new akeq();
  }
  
  @Nullable
  public akeq a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaqxa[0].a);
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0)) {
      return akeq.a(paramArrayOfaqxa);
    }
    return null;
  }
  
  public Class<akeq> clazz()
  {
    return akeq.class;
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
  
  public void onUpdate(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 0, "onUpdate " + paramObject);
    }
  }
  
  public int type()
  {
    return 470;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aker
 * JD-Core Version:    0.7.0.1
 */