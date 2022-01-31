import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class alnq
{
  private static float jdField_a_of_type_Float;
  public static DisplayMetrics a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:picture", "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:story", "com.tencent.mobileqq:troopmanage", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:qwallet", "com.tencent.mobileqq:qqwifi", "com.tencent.mobileqq:qqfav", "com.tencent.mobileqq:dingdong", "com.tencent.mobileqq:buscard", "com.tencent.mobileqq:qqhotspot", "com.tencent.mobileqq" };
  private static final String[][] jdField_a_of_type_Array2dOfJavaLangString = { { "OPPO", "PHILIPS", "KONKA", "Sony", "Meitu", "GiONEE", "GiONEE", "GiONEE", "GiONEE", "alps", "Xiaomi", "Xiaomi", "Xiaomi", "Huawei", "BBK", "LGE" }, { "R815T", "W6500", "K5", "S39h", "MK150", "GN137", "GN705T", "GN708T", "E3T", "K5", "Mi-4c", "MI 4S", "MI NOTE Pro", "Nexus 6P", "vivo X3S W", "Nexus 5X" } };
  public static DisplayMetrics b;
  private static final String[] b;
  private static final String[] c = { "vivo Y13", "vivo X3t", "vivo Y11i T", "MI-ONE Plus", "vivoY11iT", "Coolpad 7270", "Coolpad 8122", "Lenovo A708T", "Lenovo S820", "Lenovo S898t", "GT-I9050", "GT-S7568", "DOOV S2y", "TCL J928", "vivo Y22", "ChanghongZ8t", "HUAWEI Y516-T00", "Lenovo A678t", "K-Touch T60", "vivo X710L", "HM MOTE 1TD", "Redmi 3" };
  
  static
  {
    jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    jdField_b_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    jdField_a_of_type_Float = 16.0F;
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:photoplus", "com.tencent.mobileqq:video", "com.tencent.mobileqq:mini_internal", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:mini1", "com.tencent.mobileqq:mini2", "com.tencent.mobileqq:mini3", "com.tencent.mobileqq:mini4", "com.tencent.mobileqq:mini5", "com.tencent.mobileqq:mini6", "com.tencent.mobileqq:mini7" };
  }
  
  public static float a()
  {
    return jdField_a_of_type_Float;
  }
  
  private static float a(Context paramContext)
  {
    if (paramContext == null) {
      return -1000.0F;
    }
    float f2 = Float.valueOf(ammx.a(paramContext, "key_font_level", String.valueOf(16.0F))).floatValue();
    float f1;
    if (f2 >= 13.92F)
    {
      f1 = f2;
      if (f2 <= 18.0F) {}
    }
    else
    {
      f1 = 16.0F;
    }
    jdField_a_of_type_Float = f1;
    return jdField_a_of_type_Float;
  }
  
  public static void a()
  {
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      a(BaseApplicationImpl.getContext(), str);
      i += 1;
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext.density = jdField_b_of_type_AndroidUtilDisplayMetrics.density;
    paramContext.scaledDensity = jdField_b_of_type_AndroidUtilDisplayMetrics.density;
    paramContext.densityDpi = jdField_b_of_type_AndroidUtilDisplayMetrics.densityDpi;
  }
  
  private static void a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return;
    }
    ammx.a(paramContext, "key_font_level", String.valueOf(paramFloat));
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramContext.getResources();
    if ((localResources != null) && ((Math.abs(jdField_b_of_type_AndroidUtilDisplayMetrics.density - localResources.getDisplayMetrics().density) > 0.01F) || (Math.abs(jdField_b_of_type_AndroidUtilDisplayMetrics.scaledDensity - localResources.getDisplayMetrics().scaledDensity) > 0.01F) || (jdField_b_of_type_AndroidUtilDisplayMetrics.densityDpi != localResources.getDisplayMetrics().densityDpi)))
    {
      jdField_a_of_type_AndroidUtilDisplayMetrics.setTo(localResources.getDisplayMetrics());
      if (QLog.isColorLevel()) {
        QLog.i("FontSettingManager", 2, "current density: " + jdField_a_of_type_AndroidUtilDisplayMetrics.density + ", custom density: " + jdField_b_of_type_AndroidUtilDisplayMetrics.density);
      }
      b(paramContext, paramBoolean1, paramBoolean2);
    }
  }
  
  private static void a(DisplayMetrics paramDisplayMetrics)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramDisplayMetrics);
    localDisplayMetrics.density = jdField_a_of_type_AndroidUtilDisplayMetrics.density;
    localDisplayMetrics.scaledDensity = jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity;
    localDisplayMetrics.densityDpi = jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi;
    if (QLog.isColorLevel())
    {
      QLog.d("FontSettingManager", 2, "systemMetrics.density : " + jdField_a_of_type_AndroidUtilDisplayMetrics.density);
      QLog.d("FontSettingManager", 2, "systemMetrics.scaledDensity : " + jdField_a_of_type_AndroidUtilDisplayMetrics.scaledDensity);
      QLog.d("FontSettingManager", 2, "systemMetrics.densityDpi : " + jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi);
    }
    jdField_a_of_type_AndroidUtilDisplayMetrics = localDisplayMetrics;
  }
  
  public static boolean a()
  {
    Object localObject = bdcb.h();
    String str = bdcb.d();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + (String)localObject + ", modelName:" + str);
    }
    int i = jdField_a_of_type_Array2dOfJavaLangString[0].length - 1;
    while (i >= 0)
    {
      if ((((String)localObject).equals(jdField_a_of_type_Array2dOfJavaLangString[0][i])) && (str.equals(jdField_a_of_type_Array2dOfJavaLangString[1][i]))) {
        return false;
      }
      i -= 1;
    }
    localObject = c;
    int j = localObject.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label132;
      }
      if (str.equals(localObject[i])) {
        break;
      }
      i += 1;
    }
    label132:
    return true;
  }
  
  private static boolean a(float paramFloat)
  {
    return (paramFloat > 13.82F) && (paramFloat < 18.1F);
  }
  
  private static boolean a(Context paramContext)
  {
    paramContext = BaseApplicationImpl.processName;
    String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramContext)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(Context paramContext, float paramFloat, boolean paramBoolean)
  {
    if (!a(paramFloat)) {
      if (QLog.isColorLevel()) {
        QLog.d("FontSettingManager", 2, "wrong scale vale : " + paramFloat);
      }
    }
    do
    {
      DisplayMetrics localDisplayMetrics;
      do
      {
        return false;
        float f = paramFloat / 16.0F;
        localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        a(localDisplayMetrics);
        localDisplayMetrics.density = (jdField_a_of_type_AndroidUtilDisplayMetrics.density * f);
        localDisplayMetrics.scaledDensity = (jdField_a_of_type_AndroidUtilDisplayMetrics.density * f);
        localDisplayMetrics.densityDpi = ((int)(f * jdField_a_of_type_AndroidUtilDisplayMetrics.densityDpi));
        QLog.d("FontSettingManager", 1, new Object[] { "currentDm: ", Float.valueOf(localDisplayMetrics.density), ", ", Float.valueOf(localDisplayMetrics.scaledDensity), ", ", Integer.valueOf(localDisplayMetrics.densityDpi) });
      } while (!paramBoolean);
      jdField_b_of_type_AndroidUtilDisplayMetrics.setTo(localDisplayMetrics);
    } while (jdField_a_of_type_Float == paramFloat);
    jdField_a_of_type_Float = paramFloat;
    a(paramContext, paramFloat);
    return true;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.equals(paramString))
      {
        Process.killProcess(localRunningAppProcessInfo.pid);
        return true;
      }
    }
    return false;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext.getResources().getDisplayMetrics().density != jdField_a_of_type_AndroidUtilDisplayMetrics.density) {
      a(paramContext, 16.0F, true);
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!a(paramContext))
    {
      jdField_b_of_type_AndroidUtilDisplayMetrics.setTo(paramContext.getResources().getDisplayMetrics());
      return;
    }
    if (paramBoolean1) {}
    for (float f = jdField_a_of_type_Float;; f = a(paramContext))
    {
      a(paramContext, f, paramBoolean2);
      return;
    }
  }
  
  public static boolean b()
  {
    String str1 = bdcb.h();
    String str2 = bdcb.d();
    if (QLog.isColorLevel()) {
      QLog.d("FontSettingManager", 2, "current machine brandName:" + str1 + ", modelName:" + str2);
    }
    return ((!str1.equals("Xiaomi")) || (!str2.equals("MI 4S"))) && ((!str1.equals("Huawei")) || (!str2.equals("Nexus 6P"))) && ((!str1.equals("BBK")) || (!str2.equals("vivo X3S W"))) && ((!str1.equals("LGE")) || (!str2.equals("Nexus 5X"))) && (!str2.equals("Redmi 3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alnq
 * JD-Core Version:    0.7.0.1
 */