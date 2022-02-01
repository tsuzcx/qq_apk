import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;

public class akcn
{
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(paramInt2);
    paramInt2 = paramInt1;
    if (localSharedPreferences != null)
    {
      paramInt2 = paramInt1;
      if (!TextUtils.isEmpty(paramString)) {
        paramInt2 = localSharedPreferences.getInt("url_down_scene" + paramString, paramInt1);
      }
    }
    return paramInt2;
  }
  
  private static SharedPreferences a(int paramInt)
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (paramInt == 1) {
        return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_down_record_utilinner", 4);
      }
      return BaseApplicationImpl.getApplication().getSharedPreferences("qwallet_res_down_record_util", 4);
    }
    return null;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a(paramInt);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().remove("url_down_scene" + paramString).apply();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = a(paramInt2);
    if ((localSharedPreferences != null) && (!TextUtils.isEmpty(paramString))) {
      localSharedPreferences.edit().putInt("url_down_scene" + paramString, paramInt1).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcn
 * JD-Core Version:    0.7.0.1
 */