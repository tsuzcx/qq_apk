import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class amay
  extends alzl<amas>
{
  public static amas b(int paramInt)
  {
    amas localamas = (amas)alzw.a().a(paramInt);
    if (localamas != null) {
      return localamas;
    }
    return new amas();
  }
  
  public int a()
  {
    return 0;
  }
  
  @NonNull
  public amas a(int paramInt)
  {
    return new amas();
  }
  
  public amas a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + a() + ", content = " + paramString);
    return new amas(paramString);
  }
  
  @Nullable
  public amas a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onParsed] config type = " + a());
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = paramArrayOfalzs[0].a;
      if (!TextUtils.isEmpty(paramArrayOfalzs)) {
        return a(paramArrayOfalzs);
      }
      QLog.d("ArkConfProcessor", 1, "[onParsed] content is empty, config type = " + a());
    }
    return null;
  }
  
  public Class<amas> a()
  {
    return amas.class;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    QLog.d("ArkConfProcessor", 1, "[onReqFailed] failCode=" + paramInt + ", config type = " + a());
  }
  
  public void a(amas paramamas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkConfProcessor", 2, "[onUpdate]  config type = " + a());
    }
  }
  
  public boolean a()
  {
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amay
 * JD-Core Version:    0.7.0.1
 */