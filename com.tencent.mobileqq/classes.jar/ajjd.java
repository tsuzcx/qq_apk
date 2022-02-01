import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ajjd
  extends aptq
{
  public static ajjc a()
  {
    return (ajjc)apub.a().a(470);
  }
  
  @NonNull
  public ajjc a(int paramInt)
  {
    return new ajjc();
  }
  
  @Nullable
  public ajjc a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaptx[0].a);
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0)) {
      return ajjc.a(paramArrayOfaptx);
    }
    return null;
  }
  
  public Class<ajjc> clazz()
  {
    return ajjc.class;
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
 * Qualified Name:     ajjd
 * JD-Core Version:    0.7.0.1
 */