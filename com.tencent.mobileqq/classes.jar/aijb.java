import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class aijb
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static HashMap<String, String> a;
  private static boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = bbjo.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.size();
      }
    }
    return 0;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).getInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString, 1);
  }
  
  public static Set<String> a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = bbjo.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      return paramQQAppInterface;
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_quota" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    Object localObject = bbjo.a(paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4), "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        jdField_a_of_type_JavaUtilHashMap.put(paramQQAppInterface.getCurrentAccountUin() + str, str);
      }
    }
    a(false);
  }
  
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString, paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin() + paramString;
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(localObject2)) {
      jdField_a_of_type_JavaUtilHashMap.put(localObject2, paramString);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = bbjo.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashSet();
      }
      if (((Set)localObject1).contains(paramString)) {
        return;
      }
      ((Set)localObject1).add(paramString);
      paramString = ((Set)localObject1).toArray();
      bbjo.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      if (a(paramString1, paramQQAppInterface)) {
        b(paramString1, paramQQAppInterface);
      }
      if (b(paramString1, paramQQAppInterface)) {
        c(paramString1, paramQQAppInterface);
      }
    }
    do
    {
      return;
      try
      {
        int i = Integer.parseInt(paramString2);
        if (!a(paramString1, paramQQAppInterface)) {
          a(paramString1, paramQQAppInterface);
        }
        a(paramString1, i, paramQQAppInterface);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.i("SpecialCareManager", 2, "dealWithRespSound|exception = " + paramString1.toString());
  }
  
  public static void a(List<String> paramList1, int paramInt, List<String> paramList2, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (akfa)paramQQAppInterface.a(15);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramList1, paramInt, paramList2);
    }
  }
  
  public static void a(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject1 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    label224:
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = bbjo.a((SharedPreferences)localObject1, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
        if (localObject1 != null) {
          break label224;
        }
        localObject1 = new HashSet();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          String str1 = (String)paramList.next();
          String str2 = paramQQAppInterface.getCurrentAccountUin() + str1;
          if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
            jdField_a_of_type_JavaUtilHashMap.put(str2, str1);
          }
          if (((Set)localObject1).contains(str1)) {
            continue;
          }
          ((Set)localObject1).add(str1);
        }
      }
      paramList = ((Set)localObject1).toArray();
      bbjo.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramList).commit();
      return;
    }
  }
  
  public static void a(Map<String, Integer> paramMap, QQAppInterface paramQQAppInterface)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (QLog.isColorLevel()) {
        QLog.d("SpecialCareManager", 2, "getSpecialCareSounds from FriendList: " + localEntry.toString());
      }
      String str = (String)localEntry.getKey();
      int i = ((Integer)localEntry.getValue()).intValue();
      localEditor.putInt("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + str, i);
    }
    localEditor.commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return a();
  }
  
  public static boolean a(String paramString)
  {
    return jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    new HashSet();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      paramQQAppInterface = bbjo.a(localSharedPreferences, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()) && (paramQQAppInterface.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static void b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putInt("special_sound_svip_quota" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.putLong("key_get_special_sound_quota_time" + paramQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    ??? = paramQQAppInterface.getCurrentAccountUin() + paramString;
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(???)) {
      jdField_a_of_type_JavaUtilHashMap.remove(???);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = bbjo.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (localObject2 != null)
      {
        if (!((Set)localObject2).contains(paramString)) {
          return;
        }
        ((Set)localObject2).remove(paramString);
        paramString = ((Set)localObject2).toArray();
        bbjo.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramString).commit();
      }
      return;
    }
  }
  
  public static void b(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    Object localObject2 = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      localObject2 = bbjo.a((SharedPreferences)localObject2, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), null);
      if (localObject2 == null) {
        break label217;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str1 = (String)paramList.next();
        String str2 = paramQQAppInterface.getCurrentAccountUin() + str1;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
          jdField_a_of_type_JavaUtilHashMap.remove(str2);
        }
        if (((Set)localObject2).contains(str1)) {
          ((Set)localObject2).remove(str1);
        }
      }
    }
    paramList = ((Set)localObject2).toArray();
    bbjo.a(localEditor, "special_sound" + paramQQAppInterface.getCurrentAccountUin(), paramList).commit();
    label217:
  }
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).contains("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString);
  }
  
  public static void c(String paramString, QQAppInterface paramQQAppInterface)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    localEditor.remove("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + paramString);
    localEditor.commit();
  }
  
  public static void c(List<String> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localEditor.remove("special_sound_type" + paramQQAppInterface.getCurrentAccountUin() + str);
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aijb
 * JD-Core Version:    0.7.0.1
 */