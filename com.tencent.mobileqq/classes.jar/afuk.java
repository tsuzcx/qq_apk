import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class afuk
  extends alzl
{
  public static afuj a()
  {
    return (afuj)alzw.a().a(470);
  }
  
  public int a()
  {
    return 470;
  }
  
  @NonNull
  public afuj a(int paramInt)
  {
    return new afuj();
  }
  
  @Nullable
  public afuj a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfalzs[0].a);
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return afuj.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<afuj> a()
  {
    return afuj.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 0, "onUpdate " + paramObject);
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuk
 * JD-Core Version:    0.7.0.1
 */