import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ahfw
  extends ahfm<ahfv>
{
  public int a()
  {
    return 540;
  }
  
  @NonNull
  public ahfv a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new ahfv();
  }
  
  protected ahfv a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = paramArrayOfamph[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "onParsed " + paramArrayOfamph);
      }
      return ahfv.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<ahfv> a()
  {
    return ahfv.class;
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
  
  public void a(ahfv paramahfv)
  {
    super.a(paramahfv);
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public ahfv b(amph[] paramArrayOfamph)
  {
    return (ahfv)super.b(paramArrayOfamph);
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
 * Qualified Name:     ahfw
 * JD-Core Version:    0.7.0.1
 */