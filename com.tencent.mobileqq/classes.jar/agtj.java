import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class agtj
  extends agsz<agti>
{
  public int a()
  {
    return 540;
  }
  
  @NonNull
  public agti a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new agti();
  }
  
  protected agti a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "onParsed " + paramArrayOfalzs);
      }
      return agti.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<agti> a()
  {
    return agti.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "[onReqFailed] failCode=" + paramInt);
    }
  }
  
  public void a(agti paramagti)
  {
    super.a(paramagti);
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public agti b(alzs[] paramArrayOfalzs)
  {
    return (agti)super.b(paramArrayOfalzs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agtj
 * JD-Core Version:    0.7.0.1
 */