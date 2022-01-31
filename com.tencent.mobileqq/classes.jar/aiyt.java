import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Method;

public class aiyt
{
  public static void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    try
    {
      if (1 != BaseApplicationImpl.sProcessId) {
        return;
      }
      ClassLoader localClassLoader = BaseApplicationImpl.sApplication.getClassLoader();
      if ((localClassLoader != null) && (!TextUtils.isEmpty(paramString2)) && (paramString2.contains("Apollo")))
      {
        localClassLoader.loadClass("com.tencent.mobileqq.apollo.utils.ApolloUtil").getMethod("handleApolloNoCatchCrash", new Class[] { Boolean.TYPE, String.class, String.class }).invoke(null, new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 });
        return;
      }
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aiyt
 * JD-Core Version:    0.7.0.1
 */