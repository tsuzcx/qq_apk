import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class alvr
  extends alzl<alvs>
{
  private static boolean a;
  
  public static boolean e()
  {
    alvs localalvs = (alvs)alzw.a().a(576);
    if ((localalvs != null) && (!TextUtils.isEmpty(localalvs.a))) {
      a = "1".equals(localalvs.a);
    }
    return a;
  }
  
  public int a()
  {
    return 576;
  }
  
  @NonNull
  public alvs a(int paramInt)
  {
    return new alvs();
  }
  
  public alvs a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new alvs(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public alvs a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      alvs localalvs = a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localalvs;
    }
    return new alvs();
  }
  
  public Class<alvs> a()
  {
    return alvs.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(alvs paramalvs)
  {
    if ((paramalvs != null) && (!TextUtils.isEmpty(paramalvs.a)))
    {
      a = "1".equals(paramalvs.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
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
 * Qualified Name:     alvr
 * JD-Core Version:    0.7.0.1
 */