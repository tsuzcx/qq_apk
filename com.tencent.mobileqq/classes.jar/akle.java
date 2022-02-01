import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class akle
  extends arac
{
  public static akld a()
  {
    return (akld)aran.a().a(470);
  }
  
  @NonNull
  public akld a(int paramInt)
  {
    return new akld();
  }
  
  @Nullable
  public akld a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaraj[0].a);
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return akld.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public Class<akld> clazz()
  {
    return akld.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akle
 * JD-Core Version:    0.7.0.1
 */