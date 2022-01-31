import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aggk
  extends ampb
{
  public static aggj a()
  {
    return (aggj)ampm.a().a(470);
  }
  
  public int a()
  {
    return 470;
  }
  
  @NonNull
  public aggj a(int paramInt)
  {
    return new aggj();
  }
  
  @Nullable
  public aggj a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfampi[0].a);
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return aggj.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<aggj> a()
  {
    return aggj.class;
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
 * Qualified Name:     aggk
 * JD-Core Version:    0.7.0.1
 */