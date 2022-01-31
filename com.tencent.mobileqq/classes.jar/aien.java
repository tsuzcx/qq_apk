import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aien
  extends aofy
{
  public static aiem a()
  {
    return (aiem)aogj.a().a(470);
  }
  
  public int a()
  {
    return 470;
  }
  
  @NonNull
  public aiem a(int paramInt)
  {
    return new aiem();
  }
  
  @Nullable
  public aiem a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaogf[0].a);
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aiem.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aiem> a()
  {
    return aiem.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aien
 * JD-Core Version:    0.7.0.1
 */