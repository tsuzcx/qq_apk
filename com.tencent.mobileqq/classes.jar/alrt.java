import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class alrt
  extends alzl<alrs>
{
  public static alrs a()
  {
    return (alrs)alzw.a().a(549);
  }
  
  public int a()
  {
    return 549;
  }
  
  @NonNull
  public alrs a(int paramInt)
  {
    return new alrs();
  }
  
  @Nullable
  public alrs a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      alrs localalrs = alrs.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteConfigProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localalrs;
    }
    return null;
  }
  
  public Class a()
  {
    return alrs.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteConfigProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(alrs paramalrs) {}
  
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
 * Qualified Name:     alrt
 * JD-Core Version:    0.7.0.1
 */