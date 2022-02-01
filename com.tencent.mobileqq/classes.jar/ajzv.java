import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ajzv
  extends aqkz
{
  public static ajzu a()
  {
    return (ajzu)aqlk.a().a(470);
  }
  
  @NonNull
  public ajzu a(int paramInt)
  {
    return new ajzu();
  }
  
  @Nullable
  public ajzu a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaqlg[0].a);
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return ajzu.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public Class<ajzu> clazz()
  {
    return ajzu.class;
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
 * Qualified Name:     ajzv
 * JD-Core Version:    0.7.0.1
 */