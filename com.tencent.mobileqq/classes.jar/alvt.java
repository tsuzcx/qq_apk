import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class alvt
  extends alzl<alvu>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    alvu localalvu = (alvu)alzw.a().a(579);
    if ((localalvu != null) && (!TextUtils.isEmpty(localalvu.a))) {
      a = "1".equals(localalvu.a);
    }
    return a;
  }
  
  public static boolean f()
  {
    alvu localalvu = (alvu)alzw.a().a(579);
    if ((localalvu != null) && (!TextUtils.isEmpty(localalvu.b))) {
      b = "1".equals(localalvu.b);
    }
    return b;
  }
  
  public int a()
  {
    return 579;
  }
  
  @NonNull
  public alvu a(int paramInt)
  {
    return new alvu();
  }
  
  public alvu a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new alvu(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public alvu a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      alvu localalvu = a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localalvu;
    }
    return new alvu();
  }
  
  public Class<alvu> a()
  {
    return alvu.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(alvu paramalvu)
  {
    if (paramalvu != null)
    {
      if (TextUtils.isEmpty(paramalvu.a)) {
        a = "1".equals(paramalvu.a);
      }
      if (TextUtils.isEmpty(paramalvu.b)) {
        b = "1".equals(paramalvu.b);
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
 * Qualified Name:     alvt
 * JD-Core Version:    0.7.0.1
 */