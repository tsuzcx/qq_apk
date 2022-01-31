import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class amak
  extends alzl<amal>
{
  public int a()
  {
    return 574;
  }
  
  @NonNull
  public amal a(int paramInt)
  {
    return new amal();
  }
  
  @Nullable
  public amal a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      amal localamal = amal.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AEPituCameraConfigProcessor", 2, "onParsed:" + paramArrayOfalzs[0].a);
      }
      return localamal;
    }
    return null;
  }
  
  public Class<amal> a()
  {
    return amal.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amal paramamal)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onUpdate: " + paramamal.a());
    }
    ShortVideoUtils.a(paramamal.a());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public int b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AEPituCameraConfigProcessor", 2, "onSend: " + paramInt + ", isOpen:" + ShortVideoUtils.g());
    }
    return super.b(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amak
 * JD-Core Version:    0.7.0.1
 */