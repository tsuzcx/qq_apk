import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aijc
  extends aokh
{
  public static aijb a()
  {
    return (aijb)aoks.a().a(470);
  }
  
  public int a()
  {
    return 470;
  }
  
  @NonNull
  public aijb a(int paramInt)
  {
    return new aijb();
  }
  
  @Nullable
  public aijb a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("mini_msg_config", 2, "parse.configData : " + paramArrayOfaoko[0].a);
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aijb.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aijb> a()
  {
    return aijb.class;
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
 * Qualified Name:     aijc
 * JD-Core Version:    0.7.0.1
 */