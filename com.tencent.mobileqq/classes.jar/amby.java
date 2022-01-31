import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amby
  extends alzl<ambx>
{
  public static ambx a()
  {
    return (ambx)alzw.a().a(452);
  }
  
  public int a()
  {
    return 452;
  }
  
  @NonNull
  public ambx a(int paramInt)
  {
    return new ambx().b("0");
  }
  
  @Nullable
  public ambx a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      ambx localambx = ambx.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("C2CLovePushGrayProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localambx;
    }
    return null;
  }
  
  public Class<ambx> a()
  {
    return ambx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLovePushGrayProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(ambx paramambx) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amby
 * JD-Core Version:    0.7.0.1
 */