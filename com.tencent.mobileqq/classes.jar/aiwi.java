import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.json.JSONObject;

public class aiwi
{
  public static int a;
  public static boolean a;
  private static final String[] a;
  public static int b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    b = 2;
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "/def/role/0/sayhi/1/action/action.json", "/def/role/0/friendcard/1/action/action.json", "/def/role/0/3D/sayhi/1/action.bin", "/def/role/0/3D/3DConfig.json" };
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRandomActionId], roleId:" + paramInt);
    }
    paramString = new File(aiys.g, paramInt + "/" + paramString + "/");
    if (!paramString.exists()) {}
    for (;;)
    {
      return -1;
      Object localObject = paramString.list();
      if ((localObject == null) || (localObject.length == 0))
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloActionHelper", 2, "no any action file.");
        return -1;
      }
      int i = argh.a(localObject.length);
      if ((i >= localObject.length) || (i < 0)) {
        continue;
      }
      localObject = localObject[i];
      try
      {
        int j = Integer.parseInt((String)localObject);
        if (paramInt >= aiys.jdField_a_of_type_Int) {
          if (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/action/" + aiys.R)) {
            continue;
          }
        }
        for (;;)
        {
          return j;
          if ((!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + aiys.x)) || (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + aiys.w)) || (!ApolloUtil.c(paramString.getAbsolutePath() + "/" + (String)localObject + "/" + aiys.y))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "value:" + i + ",actionId:" + (String)localObject);
          }
        }
        return -1;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getApolloFuncSwitch], uin:" + paramString);
    }
    paramString = ((aifg)paramQQAppInterface.getManager(153)).a(paramString);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "apolloBaseInfo is null. ret closed status");
      }
      return 2;
    }
    return paramString.apolloStatus;
  }
  
  public static String a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getTickerPauseString]");
    }
    return "BK.Director.tickerPause();";
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getApolloRsc],  rscType", Integer.valueOf(paramInt1), ",id:" + paramInt2 });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "rsc:" + localStringBuilder);
      }
      return localStringBuilder.toString();
      if (paramInt2 < 21) {
        localStringBuilder.append("def/basic/dress/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      continue;
      if (paramInt2 == 0) {
        localStringBuilder.append("def/basic/skeleton/");
      }
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/role");
    }
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) || (!ApolloUtil.e(paramInt1, paramInt2)))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
    }
    for (;;)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(aiys.F);
      localStringBuilder.append("/");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("/dress");
      return localStringBuilder.toString();
      localStringBuilder.append("role/");
      localStringBuilder.append(paramInt1);
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new StringTokenizer(paramString, "@$");
    int i = argh.a(paramString.countTokens());
    while (paramString.hasMoreTokens())
    {
      i -= 1;
      if (i < 0) {
        return paramString.nextToken();
      }
      paramString.nextToken();
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramString.contains("def"));
    Object localObject = new StringBuilder();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("//").append(paramString);
      return ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).append("ActionRes:");
      continue;
      ((StringBuilder)localObject).append("Dress:");
      continue;
      ((StringBuilder)localObject).append("Role:");
    }
  }
  
  public static String a(String paramString, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] apolloId=", paramString, ", roleId=", Integer.valueOf(paramInt) });
    }
    String str = a(0, paramInt);
    float f = 0.0F;
    if ("friend".equals(paramString)) {
      f = 180.0F;
    }
    paramString = String.format("var %s = loadAnimation('%s', '%s', '%s', %f, %f, %f, %f, %f, '%s','%s');if(%s){%s.openAABBCallback()}", new Object[] { paramString, paramString, str, str, Float.valueOf(1.0F), Float.valueOf(paramFloat1), Float.valueOf(f), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), "null", "null", paramString, paramString });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getRoleLuaString] scriptStr=", paramString });
    }
    return paramString;
  }
  
  public static String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getBubbleLuaString], apolloId:" + paramString1 + ",bubbleId" + paramInt1 + ",roleId:" + paramInt2);
    }
    String str = b(paramInt2, paramInt1);
    paramString1 = String.format("setAccessoryWithInfo(%s, '%s', '%s', '%s');", new Object[] { paramString1, str, str, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static String a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getModelByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    if (aifg.a(paramQQAppInterface, paramString) == 2) {
      return "3D";
    }
    return "2D";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRemoveBubbleLuaString], apolloId:" + paramString1 + ",bubbleName" + paramString2);
    }
    paramString1 = String.format("if(%s) {%s.removeAccessory('%s')};", new Object[] { paramString1, paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, paramString1);
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aisk paramaisk, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[doActionReport], isHasUsrText:" + paramBoolean1 + ",isBarrage:" + paramBoolean2);
    }
    if ((paramaisk == null) || (paramQQAppInterface == null)) {}
    Object localObject;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "taskParam:" + paramaisk.toString());
      }
      localObject = ((aiyu)paramQQAppInterface.getManager(155)).a(paramaisk.f);
    } while (localObject == null);
    String str1 = "";
    int i = 0;
    int j = paramaisk.j;
    String str4 = Integer.toString(paramaisk.f);
    String str2;
    if (paramBoolean1) {
      if (paramBoolean2) {
        str2 = "2";
      }
    }
    for (;;)
    {
      label145:
      label157:
      label175:
      String str3;
      if (paramaisk.h == 0)
      {
        str1 = "action_play";
        if (paramaisk.g != 2) {
          break label425;
        }
        if (!paramaisk.a) {
          break label419;
        }
        i = 2;
        if ((((ApolloActionData)localObject).hasSound) || (paramaisk.i > 0)) {
          break label466;
        }
        str3 = "0";
        label195:
        if ((8 != paramaisk.c) || (TextUtils.isEmpty(paramaisk.d))) {
          break label637;
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject(paramaisk.d).optString("subActionId", "0");
          paramaisk = (aisk)localObject;
        }
        catch (Exception localException)
        {
          label419:
          label425:
          label466:
          QLog.e("ApolloActionHelper", 1, "[random] the json is not right," + paramaisk.d);
          paramaisk = "-1";
          continue;
        }
        bajr.a(paramQQAppInterface, "cmshow", "Apollo", str1, i, j, new String[] { str4, str2, str3, paramaisk });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloActionHelper", 2, "actionName:" + str1 + ",entry:" + i + ",result:" + j + ",r2:" + str4 + ",r3:" + str2 + ",r4:" + str3 + ",r5:" + paramaisk);
        return;
        str2 = "1";
        break label145;
        if (paramaisk.h == 1)
        {
          str1 = "g_action_play";
          break label157;
        }
        if (paramaisk.h != 3000) {
          break label157;
        }
        str1 = "d_action_play";
        break label157;
        i = 3;
        break label175;
        if (paramaisk.g == 0)
        {
          i = 0;
          break label175;
        }
        if (paramaisk.g == 1)
        {
          i = 1;
          break label175;
        }
        if (paramaisk.g != 4) {
          break label175;
        }
        i = 4;
        break label175;
        if ((1 == paramQQAppInterface.c()) && (((paramaisk.h != 1) && (paramaisk.h != 3000)) || (((1 == paramQQAppInterface.a()) || (paramaisk.h == 0)) && (!paramQQAppInterface.k()) && (!paramQQAppInterface.l()) && (paramQQAppInterface.m()) && (!MediaPlayerManager.a(paramQQAppInterface).b()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().k())) && (!paramQQAppInterface.c()) && ((paramQQAppInterface.a() == null) || (!paramQQAppInterface.a().l())))))
        {
          str3 = "1";
          break label195;
        }
        str3 = "2";
        break label195;
        label637:
        if (a(localException.vibrate) == null) {
          paramaisk = "0";
        } else if ((1 == paramQQAppInterface.d()) && (((paramaisk.h != 1) && (paramaisk.h != 3000)) || (((1 == paramQQAppInterface.b()) || (paramaisk.h == 0)) && (!paramQQAppInterface.l())))) {
          paramaisk = "1";
        } else {
          paramaisk = "2";
        }
      }
      str2 = "0";
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      localObject = new File(aiys.c + (String)localObject);
      if (!((File)localObject).exists())
      {
        QLog.d("ApolloActionHelper", 1, new Object[] { "[checkBasicActionExit] rsc file not exist:", ((File)localObject).toString() });
        aitw.a(paramQQAppInterface, paramQQAppInterface.c(), null, 0, null, -1, -1, true);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return a(paramQQAppInterface);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface)
  {
    return a(paramString, paramInt, paramArrayOfInt, paramQQAppInterface, null);
  }
  
  public static boolean a(String paramString, int paramInt, int[] paramArrayOfInt, QQAppInterface paramQQAppInterface, aiud paramaiud)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[isRscValid], roleId:" + paramInt + ",dressId:" + paramArrayOfInt);
    }
    if (paramArrayOfInt == null) {
      return false;
    }
    int[] arrayOfInt = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = true;
    if (!ApolloUtil.c(paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "need download role id:" + paramInt);
      }
      bool = false;
    }
    for (;;)
    {
      int i = 0;
      if (i < paramArrayOfInt.length)
      {
        if (ApolloUtil.b(paramArrayOfInt[i])) {
          break label328;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "need download dress id:" + paramArrayOfInt[i]);
        }
        bool = false;
      }
      label325:
      label328:
      for (;;)
      {
        i += 1;
        break;
        if (!bool)
        {
          paramArrayOfInt = arrayOfInt;
          if (localArrayList.size() > 0)
          {
            arrayOfInt = new int[localArrayList.size()];
            i = 0;
            for (;;)
            {
              paramArrayOfInt = arrayOfInt;
              if (i >= localArrayList.size()) {
                break;
              }
              arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
              i += 1;
            }
          }
          if (paramQQAppInterface != null)
          {
            if (paramaiud != null) {
              break label325;
            }
            paramaiud = ((aifg)paramQQAppInterface.getManager(153)).a();
          }
        }
        for (;;)
        {
          aitw.a(paramQQAppInterface, paramString, paramaiud, paramInt, paramArrayOfInt, -1, -1, false);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "ret:" + bool);
          }
          return bool;
        }
      }
      paramInt = -1;
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[attach3DInfoToJson], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return false;
    }
    ApolloBaseInfo localApolloBaseInfo = ((aifg)paramQQAppInterface.getManager(153)).b(paramString);
    if (localApolloBaseInfo != null)
    {
      try
      {
        paramJSONObject.put("model", a(paramString, paramQQAppInterface));
        paramString = new JSONObject();
        Object localObject = localApolloBaseInfo.getFaceModel(true, paramQQAppInterface);
        if (localObject != null) {
          paramString.put("faceModel", localObject);
        }
        localObject = localApolloBaseInfo.getDress3D(true, paramQQAppInterface);
        int i = localApolloBaseInfo.getRole3D(true, paramQQAppInterface);
        if ((localObject != null) && (i > 0))
        {
          paramString.put("dress", localObject);
          paramString.put("role", String.valueOf(i));
        }
        paramJSONObject.put("3DObject", paramString);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_ApolloActionHelper", 2, "attach3DInfoToJson: obj3D:" + paramString.toString());
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("ApolloActionHelper", 1, "attach3DInfoToJson e=" + paramString.toString());
        }
      }
      return true;
    }
    return false;
  }
  
  public static long[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    long[] arrayOfLong;
    for (;;)
    {
      return null;
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length != 0))
      {
        arrayOfLong = new long[paramString.length];
        i = 0;
        try
        {
          while (i < paramString.length)
          {
            arrayOfLong[i] = Integer.parseInt(paramString[i].trim());
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (NumberFormatException paramString) {}
      }
    }
    QLog.d("ApolloActionHelper", 2, "errInfo->NumberFormatException, e:" + paramString.getMessage());
    return null;
    int i = paramString.length - 2;
    while (i >= 2)
    {
      arrayOfLong[i] = (arrayOfLong[i] - arrayOfLong[(i - 1)] - arrayOfLong[(i - 2)]);
      i -= 2;
    }
    return arrayOfLong;
  }
  
  public static Object[] a(String paramString, int paramInt, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramInt != 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleIdByUin errInfo->null param, userStatus:", Integer.valueOf(paramInt) });
      }
      return new Object[] { Integer.valueOf(-1), null };
    }
    Object localObject = ((aifg)paramQQAppInterface.getManager(153)).b(paramString);
    if (localObject != null)
    {
      localObject = ((ApolloBaseInfo)localObject).getApolloDress3D();
      if (localObject != null)
      {
        paramInt = ((aiju)localObject).jdField_a_of_type_Int;
        localObject = ((aiju)localObject).a();
        if ((paramInt > aiys.jdField_a_of_type_Int) && (localObject != null) && (localObject.length > 0) && ((!paramBoolean) || (a(paramString, paramInt, (int[])localObject, paramQQAppInterface))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, new Object[] { "get3DRoleDressIdByUin valid role and dress RSC, needVerify:", Boolean.valueOf(paramBoolean) });
          }
          paramString = (String)localObject;
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(paramInt), paramString };
      paramString = null;
      paramInt = 0;
    }
  }
  
  public static Object[] a(String paramString, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "[getRoldIdByUin], uin:" + paramString);
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "errInfo->null param.");
      }
      return null;
    }
    Object localObject1 = aitw.a(0);
    int i;
    int j;
    if (("-1".equals(paramString)) || ("-2".equals(paramString)))
    {
      if ("-1".equals(paramString))
      {
        i = 1;
        localObject2 = aitw.a(i);
        if (!a(paramString, i, (int[])localObject2, paramQQAppInterface)) {
          break label213;
        }
        paramString = (String)localObject2;
      }
      for (;;)
      {
        localObject1 = paramString;
        if (!QLog.isColorLevel()) {
          break label732;
        }
        paramString = new StringBuilder();
        paramString.append("******roleId:[");
        paramString.append(i);
        paramString.append("],");
        paramString.append("dress:[");
        j = 0;
        while (j < localObject1.length)
        {
          if (j != 0) {
            paramString.append(",");
          }
          paramString.append(localObject1[j]);
          j += 1;
        }
        i = 2;
        break;
        label213:
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, new Object[] { "role and dress is not ready,uin:", paramString, ",roleId:", Integer.valueOf(0) });
        }
        paramString = (String)localObject1;
        i = 0;
      }
    }
    Object localObject2 = ((aifg)paramQQAppInterface.getManager(153)).b(paramString);
    aiju[] arrayOfaiju;
    if (localObject2 != null)
    {
      i = ((ApolloBaseInfo)localObject2).apolloStatus;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + ((ApolloBaseInfo)localObject2).uin + ", funcSwitch:" + i);
      }
      if (!aifg.a((ApolloBaseInfo)localObject2)) {
        return new Object[] { Integer.valueOf(0), localObject1 };
      }
      if ((paramBoolean) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS))
      {
        QLog.i("ApolloActionHelper", 1, "dress changed, uin:" + ApolloUtil.d(paramString));
        aifg.a(paramQQAppInterface, paramString, "getRoleDressIdByUin");
      }
      arrayOfaiju = ((ApolloBaseInfo)localObject2).getApolloDress(false);
      if ((arrayOfaiju != null) && (arrayOfaiju.length > 0))
      {
        j = arrayOfaiju.length;
        i = 0;
        label439:
        if (i >= j) {
          break label749;
        }
        aiju localaiju = arrayOfaiju[i];
        localObject2 = localaiju.a();
        if (a(paramString, localaiju.jdField_a_of_type_Int, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid role and dress RSC.");
          }
          i = localaiju.jdField_a_of_type_Int;
          j = 1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        localObject2 = aitw.a(arrayOfaiju[0].jdField_a_of_type_Int);
        if (a(paramString, arrayOfaiju[0].jdField_a_of_type_Int, (int[])localObject2, paramQQAppInterface))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionHelper", 2, "valid basic dress.");
          }
          j = arrayOfaiju[0].jdField_a_of_type_Int;
          paramString = (String)localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloActionHelper", 2, "current dress NOT downloaded, check basic dress");
            i = j;
          }
        }
      }
      for (paramString = (String)localObject2;; paramString = (String)localObject1)
      {
        localObject1 = paramString;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "try to get history dress ....");
        }
        i += 1;
        break label439;
        aisl.a(110, new Object[] { "basicDresses is not vaild" });
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "uin: " + paramString + " dress is null");
      }
      for (;;)
      {
        i = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionHelper", 2, "warning: apolloBaseInfo or apolloBaseInfo.apolloDress is NULL, fail to get role info. apolloBaseInfo:" + localObject2);
        }
      }
      paramString.append("]****");
      QLog.d("ApolloActionHelper", 2, paramString.toString());
      label732:
      return new Object[] { Integer.valueOf(i), localObject1 };
      label749:
      j = 0;
      i = 0;
    }
  }
  
  public static String[] a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action/");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/action_background/action");
    String str1 = "background__" + Integer.toString(paramInt);
    String str2 = localStringBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionName:" + str1);
    }
    return new String[] { str2, str1 };
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramInt3, paramBoolean, 1);
  }
  
  public static String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionRscPath], bid:" + paramInt1 + ",activeId:" + paramInt2 + ",roleId:" + paramInt3 + ",isActionMaker:" + paramBoolean, ",userStatus:", Integer.valueOf(paramInt4) });
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt4 == 2)
    {
      paramInt4 = 1;
      switch (paramInt1)
      {
      case 3: 
      case 8: 
      case 9: 
      default: 
        paramInt3 = 1;
        paramInt4 = paramInt2;
        label177:
        if (paramInt3 != 0) {
          localStringBuilder.append("/");
        }
        localStringBuilder.append(paramInt4);
        if ((paramBoolean) || (paramInt2 < 21)) {
          if (localStringBuilder.indexOf(aiys.u) > -1) {
            localStringBuilder.append("/action");
          }
        }
        break;
      }
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = Integer.toString(paramInt1) + "_" + Integer.toString(paramInt4);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt4);
      }
      return new String[] { str1, str2 };
      paramInt4 = 0;
      break;
      paramInt3 = 0;
      paramInt4 = paramInt2;
      break label177;
      localStringBuilder.append("action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append(aiys.u);
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/basic/action");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0) {
        localStringBuilder.append(aiys.u).append(aiys.G);
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append(aiys.G);
      }
      localStringBuilder.append(aiys.u).append(aiys.G);
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      int i = a(paramInt3, aiys.G);
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append(aiys.G);
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0)
      {
        localStringBuilder.append(aiys.u).append(aiys.G);
        paramInt3 = 1;
        paramInt4 = 1;
        break label177;
      }
      localStringBuilder.append("def/basic/").append(aiys.G);
      paramInt3 = 1;
      paramInt4 = 1;
      break label177;
      localStringBuilder.append("drawer_action/");
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append(aiys.u).append(aiys.I);
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append(aiys.I);
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      if (paramInt4 != 0)
      {
        localStringBuilder.append(aiys.u).append(aiys.K);
        paramInt3 = 1;
        paramInt4 = paramInt2;
        break label177;
      }
      localStringBuilder.append("def/role/").append(0).append("/").append(aiys.K);
      paramInt3 = 1;
      paramInt4 = paramInt2;
      break label177;
      i = a(paramInt3, aiys.H);
      if (-1 != i)
      {
        localStringBuilder.append("role/");
        localStringBuilder.append(paramInt3).append("/").append(aiys.H);
        paramInt4 = i;
        paramInt3 = 1;
        break label177;
      }
      if (paramInt4 != 0) {
        localStringBuilder.append(aiys.u).append(aiys.G);
      }
      for (;;)
      {
        paramInt3 = 1;
        paramInt4 = 1;
        break;
        localStringBuilder.append("def/basic/").append(aiys.G);
      }
      localStringBuilder.append("/action/action");
      continue;
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("/action");
    if (paramBoolean2) {
      localStringBuilder.append("/group");
    }
    switch (paramInt2)
    {
    default: 
      if (paramBoolean1) {
        localStringBuilder.append("/action/action");
      }
      break;
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = "whiteface_" + Integer.toString(paramInt2) + "_" + Integer.toString(paramInt1);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[whiteface] path:" + localStringBuilder.toString() + ",actionId:" + paramInt1);
      }
      return new String[] { str1, str2 };
      localStringBuilder.append("/pre");
      break;
      localStringBuilder.append("/main");
      break;
      localStringBuilder.append("/post");
      break;
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public static String[] a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getActionLuaString] apolloId=", paramString1, ", actionId=", Integer.valueOf(paramInt1), ", taskId=", Integer.valueOf(paramInt2), ", animName=", paramString3, ", actionRscName=", paramString2 });
    }
    String[] arrayOfString = new String[2];
    String str = paramString3;
    if (paramString2.contains("_peer")) {
      str = paramString3 + "_peer";
    }
    paramString3 = paramString2;
    if (paramString2.startsWith("action")) {
      paramString3 = paramString2.substring("action/".length());
    }
    arrayOfString[0] = String.format("setAccessoryAnimation(%s, '%s', '%s', '%s');", new Object[] { paramString1, paramString3, paramString3, str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[0]);
    }
    arrayOfString[1] = String.format("if(%s){%s.setAnimation(%d, '%s', false);}", new Object[] { paramString1, paramString1, Integer.valueOf(paramInt2), str });
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  public static String[] a(String paramString, int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] apolloId=", paramString });
    }
    if (paramArrayOfInt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, "[getDressLuaString] no dressId, abort");
      }
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      String str = a(1, paramArrayOfInt[i]);
      arrayOfString[i] = String.format("setAccessory(%s, '%s', '%s');", new Object[] { paramString, str, str });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionHelper", 2, new Object[] { "[getDressLuaString] scriptStr", Integer.valueOf(i), "=", arrayOfString[i] });
      }
      i += 1;
    }
    return arrayOfString;
  }
  
  public static String b()
  {
    return "if(\"undefined\" != typeof addFrame){addFrame();}else{if(renderTicker.paused){if(BK.Director.root){BK.Render.clear(0,0,0,0);BK.Render.treeRender( BK.Director.root,0);BK.Render.commit();}}}";
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, 1);
  }
  
  public static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    return "if(\"undefined\" != typeof comGlobalParam) { comGlobalParam.width=" + paramInt1 + ";comGlobalParam.vWidth=" + paramInt1 + ";comGlobalParam.vHeight=" + paramInt2 + ";if(comGlobalParam.height==0){comGlobalParam.height=" + paramInt3 + ";}}";
  }
  
  public static String b(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramString = ((aifg)paramQQAppInterface.getManager(153)).b(paramString);
    if (paramString != null)
    {
      paramString = paramString.getApolloDress3D();
      if (paramString != null) {
        return paramString.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiwi
 * JD-Core Version:    0.7.0.1
 */