import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ahfy
  extends ahfo<ahfx>
{
  public int a()
  {
    return 540;
  }
  
  @NonNull
  public ahfx a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "[migrateOldOrDefaultContent]");
    }
    return new ahfx();
  }
  
  protected ahfx a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = paramArrayOfampi[0].a;
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketStaggerConfProcessor", 2, "onParsed " + paramArrayOfampi);
      }
      return ahfx.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<ahfx> a()
  {
    return ahfx.class;
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
  
  public void a(ahfx paramahfx)
  {
    super.a(paramahfx);
  }
  
  public int b()
  {
    return 0;
  }
  
  @Nullable
  public ahfx b(ampi[] paramArrayOfampi)
  {
    return (ahfx)super.b(paramArrayOfampi);
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
 * Qualified Name:     ahfy
 * JD-Core Version:    0.7.0.1
 */