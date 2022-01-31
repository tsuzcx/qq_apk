import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ahmk
{
  private static HashMap<String, Integer> a = new HashMap();
  private static HashMap<String, Long> b = new HashMap();
  private static HashMap<String, List<ahkz>> c = new HashMap();
  private static HashMap<String, HashMap<String, Boolean>> d = new HashMap();
  
  public static byte a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    paramQQAppInterface = (aloz)paramQQAppInterface.getManager(51);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.e(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.gender;
      }
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    if (a.containsKey(paramString)) {
      i = ((Integer)a.get(paramString)).intValue();
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (b.containsKey(paramString)) {
      l = ((Long)b.get(paramString)).longValue();
    }
    return l;
  }
  
  public static List<ahkz> a(String paramString)
  {
    Object localObject = new ArrayList();
    if (c.containsKey(paramString)) {
      localObject = (List)c.get(paramString);
    }
    return localObject;
  }
  
  public static List<ahjq> a(ArrayList<ahkz> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList.isEmpty()) || (paramQQAppInterface == null)) {
      return localArrayList;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = String.valueOf(((ahkz)paramArrayList.get(i)).jdField_a_of_type_Long);
      TroopInfo localTroopInfo = paramQQAppInterface.c(str);
      if ((localTroopInfo != null) && (localTroopInfo.troopname != null) && (!localTroopInfo.troopname.isEmpty()))
      {
        ahjq localahjq = new ahjq();
        localahjq.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
        localahjq.jdField_a_of_type_JavaLangString = str;
        localahjq.jdField_a_of_type_Int = ((ahkz)paramArrayList.get(i)).jdField_a_of_type_Int;
        localArrayList.add(localahjq);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(String paramString)
  {
    if (a.containsKey(paramString)) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      a.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString))) {
      b.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(paramString2);
      paramString2 = (alzf)paramQQAppInterface.a(20);
    } while (paramString2 == null);
    paramString2.a(paramString1, localArrayList, paramString3);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, Boolean.valueOf(paramBoolean));
    d.put(paramString1, localHashMap);
  }
  
  public static void a(String paramString, List<ahkz> paramList)
  {
    if (!TextUtils.isEmpty(paramString)) {
      c.put(paramString, paramList);
    }
  }
  
  public static boolean a(long paramLong, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList,frienduin:" + paramLong);
    }
    String str = String.valueOf(paramLong);
    paramQQAppInterface = (asdx)paramQQAppInterface.a(153);
    if (!a(str))
    {
      paramQQAppInterface.a(a(str), a(str));
      if (QLog.isColorLevel()) {
        QLog.d("TroopWithCommonFriendsHelper", 2, "getTroopWithCommonFriendsList:EnableGetTroopList,false");
      }
      return false;
    }
    if ((paramLong > 0L) && (paramInt != 0))
    {
      paramQQAppInterface.b(paramLong, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    long l1 = (System.currentTimeMillis() - a(paramString)) / 1000L;
    long l2 = a(paramString);
    if ((l1 < l2) && (l2 != 0L)) {
      return false;
    }
    a(paramString);
    b(paramString);
    c(paramString);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = (HashMap)d.get(paramString1);
      if ((paramString1 != null) && (paramString1.containsKey(paramString2))) {
        return ((Boolean)paramString1.get(paramString2)).booleanValue();
      }
    }
    return true;
  }
  
  public static void b(String paramString)
  {
    if (b.containsKey(paramString)) {
      b.remove(paramString);
    }
  }
  
  public static void c(String paramString)
  {
    if (c.containsKey(paramString)) {
      c.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmk
 * JD-Core Version:    0.7.0.1
 */