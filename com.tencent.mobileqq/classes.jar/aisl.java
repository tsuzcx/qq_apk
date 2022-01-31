import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.script.SpriteUtil.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class aisl
{
  private static int a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return (int)(babp.i() * 4L / 3L);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 0;
    case 7: 
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramInt1 == 0) || (8 == paramInt1)) {
      paramInt2 = ApolloUtil.a(208.0F, paramString, paramInt3);
    }
    do
    {
      do
      {
        return paramInt2;
        if (3 == paramInt1) {
          return 32;
        }
        if (6 != paramInt1) {
          break;
        }
        paramInt2 = 33;
      } while (paramInt3 != 2);
      return 75;
      if (7 == paramInt1)
      {
        if (paramInt3 != 2) {
          break;
        }
        return 74;
      }
    } while (9 == paramInt1);
    QLog.d("cmshow_scripted_SpriteUtil", 1, new Object[] { "Other bubble type, NOT Handle, bubbleType:", Integer.valueOf(paramInt1), ", bubbleId:", Integer.valueOf(32) });
    return 32;
  }
  
  public static int a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3)
  {
    int i = 26;
    paramInt2 = 0;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramInt2 = 28;
      }
    }
    else if (!paramBoolean1) {
      if (!paramBoolean2) {
        break label79;
      }
    }
    label79:
    for (paramInt2 = 30;; paramInt2 = 26)
    {
      if (ApolloUtil.d(paramInt1, paramInt2)) {
        return paramInt2;
      }
      QLog.w("cmshow_scripted_SpriteUtil", 1, "nick bubble not exist, id:" + paramInt2);
      paramInt1 = i;
      if (paramBoolean1) {
        paramInt1 = 25;
      }
      return paramInt1;
      paramInt2 = 25;
      break;
    }
    return paramInt2;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return aifg.b(paramQQAppInterface);
  }
  
  public static aije a(String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        int j = paramString1.optInt("isNeedRemark");
        JSONArray localJSONArray1 = paramString1.optJSONArray("uins");
        paramString1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = new JSONObject();
          String str1 = localJSONArray1.optString(i);
          if (j == 0)
          {
            bool = true;
            String str2 = a(paramQQAppInterface, paramInt, str1, paramString2, bool);
            localJSONObject.put("uin", str1);
            localJSONObject.put("nickname", str2);
            localJSONArray2.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramString1.put("nicknames", localJSONArray2);
          paramQQAppInterface = new aije();
          paramQQAppInterface.jdField_b_of_type_Boolean = true;
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString1.toString();
          return paramQQAppInterface;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString1, new Object[0]);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static airu a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (airu)((aisi)paramQQAppInterface.getManager(249)).a().a(0);
  }
  
  public static aisa a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  public static aisd a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((aisi)paramQQAppInterface.getManager(249)).a();
  }
  
  public static aise a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((aisi)paramQQAppInterface.getManager(249)).a();
  }
  
  public static aisi a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (aisi)paramQQAppInterface.getManager(249);
  }
  
  public static ApolloActionData a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((aiyu)paramQQAppInterface.getManager(155)).c(paramInt);
  }
  
  public static MessageForApollo a(String paramString, aisd paramaisd)
  {
    for (;;)
    {
      try
      {
        if (paramaisd.a() == null) {
          return null;
        }
        JSONObject localJSONObject = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
        Object localObject = new ApolloMessage();
        ((ApolloMessage)localObject).id = localJSONObject.optInt("id");
        paramString = localJSONObject.optString("name");
        if (!TextUtils.isEmpty(paramString)) {
          ((ApolloMessage)localObject).name = baaw.decode(paramString.getBytes("utf-8"), 0);
        }
        ((ApolloMessage)localObject).flag = localJSONObject.optInt("flag");
        ((ApolloMessage)localObject).peer_status = localJSONObject.optInt("peerStatus");
        ((ApolloMessage)localObject).sender_status = localJSONObject.optInt("senderStatus");
        ((ApolloMessage)localObject).peer_ts = localJSONObject.optLong("peerTS");
        ((ApolloMessage)localObject).sender_ts = localJSONObject.optLong("senderTS");
        ((ApolloMessage)localObject).peer_uin = localJSONObject.optLong("peerUin");
        paramString = localJSONObject.optString("atText");
        if (!paramString.isEmpty()) {
          ((ApolloMessage)localObject).text = baaw.decode(paramString.getBytes("utf-8"), 0);
        }
        paramString = localJSONObject.optJSONObject("extraStr");
        localJSONObject = localJSONObject.optJSONObject("extendJson");
        if (paramString == null)
        {
          paramString = new JSONObject();
          if (localJSONObject != null) {
            paramString.put("extendJson", localJSONObject);
          }
          ((ApolloMessage)localObject).extStr = paramString.toString();
          paramaisd = awbi.a(paramaisd.a(), paramaisd.a().a.jdField_a_of_type_JavaLangString, paramaisd.a().a.jdField_b_of_type_JavaLangString, paramaisd.jdField_a_of_type_Int, (ApolloMessage)localObject);
          paramaisd.inputText = paramString.optString("inputText");
          paramaisd.audioId = paramString.optInt("audioID");
          if (paramString.has("audioStartTime")) {
            paramaisd.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
          }
          paramaisd.actionType = paramString.optInt("actionType");
          if (localJSONObject != null) {
            paramaisd.extendJson = localJSONObject.toString();
          }
          if (paramString.has("mApollo3DMessage"))
          {
            paramString = paramString.getJSONObject("mApollo3DMessage");
            localObject = new Apollo3DMessage();
            ((Apollo3DMessage)localObject).setMessageWithJSONObject(paramString);
            paramaisd.mApollo3DMessage = ((Apollo3DMessage)localObject);
          }
          return paramaisd;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString, new Object[0]);
        return null;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUtil", 2, new Object[] { "[getSpriteName], uin:", paramString1, ",sessionType:", Integer.valueOf(paramInt), ",groupUin:", paramString2, ",isNeedRemark:", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = "";
      return paramString1;
    }
    if (("-1".equals(paramString1)) || ("-2".equals(paramString1))) {
      return "";
    }
    String str = "";
    if (-1 == paramInt) {
      paramString2 = babh.c(paramQQAppInterface, paramString1, true);
    }
    label253:
    do
    {
      for (;;)
      {
        paramQQAppInterface = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = paramString2.replace("\\", "").replace("'", "").replace("\"", "");
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        return paramQQAppInterface;
        if ((paramInt != 1) && (paramInt != 3000)) {
          break label272;
        }
        if (paramBoolean) {}
        for (str = babh.f(paramQQAppInterface, paramString2, paramString1);; str = babh.e(paramQQAppInterface, paramString2, paramString1))
        {
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = str;
            if (!str.equals(paramString1)) {
              break;
            }
          }
          paramString2 = ((ajjj)paramQQAppInterface.getManager(51)).e(paramString1);
          if (paramString2 == null) {
            break label253;
          }
          paramString2 = paramString2.name;
          break;
        }
        ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString1, false);
        paramString2 = str;
      }
      paramString2 = str;
    } while (paramInt != 0);
    label272:
    if (paramBoolean) {}
    for (str = babh.p(paramQQAppInterface, paramString1);; str = babh.c(paramQQAppInterface, paramString1, true))
    {
      paramString2 = str;
      if (!paramString1.equals(str)) {
        break;
      }
      ((FriendListHandler)paramQQAppInterface.a(1)).a(paramString1, false);
      paramString2 = str;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static void a(int paramInt, Object... paramVarArgs)
  {
    if (BaseApplicationImpl.sProcessId != 1) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      } while ((localObject == null) || (!(localObject instanceof QQAppInterface)));
      localObject = a((QQAppInterface)localObject);
    } while (localObject == null);
    int i = paramInt;
    if (paramInt == 0) {
      i = -100;
    }
    ((aisi)localObject).a(i, paramVarArgs);
  }
  
  public static void a(aisd paramaisd, List<aisk> paramList)
  {
    if ((paramaisd == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramaisd = a(paramaisd.a());
    } while (paramaisd == null);
    paramaisd.a().a(paramList);
  }
  
  public static void a(aisu paramaisu, int paramInt, ApolloActionData paramApolloActionData)
  {
    if (paramaisu == null) {
      return;
    }
    aisk localaisk = new aisk();
    localaisk.f = paramApolloActionData.actionId;
    localaisk.k = paramInt;
    localaisk.jdField_c_of_type_Int = paramApolloActionData.actionType;
    localaisk.g = 5;
    localaisk.e = 0;
    localaisk.jdField_a_of_type_Long = 1000000L;
    localaisk.jdField_a_of_type_Boolean = true;
    localaisk.jdField_b_of_type_Boolean = false;
    paramApolloActionData = paramaisu.a();
    if ((paramApolloActionData != null) && (paramApolloActionData.a() != null)) {
      localaisk.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionData.jdField_b_of_type_JavaLangString);
    }
    paramaisu.a().a(localaisk);
  }
  
  public static void a(aisu paramaisu, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramaisu == null) || (paramaisu.a() == null)) {
      return;
    }
    airu localairu = paramaisu.a();
    paramaisu.a().a(paramInt1);
    paramaisu = paramaisu.a();
    int i = 1;
    if (paramaisu != null) {
      i = aifg.a(paramaisu, paramaisu.c());
    }
    localairu.a("", paramString, a(paramInt1, paramInt2, paramString, i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, aisk paramaisk)
  {
    if ((paramaisk == null) || (paramQQAppInterface == null)) {}
    aisd localaisd;
    int k;
    label71:
    do
    {
      do
      {
        return;
        localaisd = a(paramQQAppInterface);
      } while (localaisd == null);
      k = localaisd.jdField_a_of_type_Int;
      if ((1 == k) || (3000 == k))
      {
        i = 0;
        int j;
        if (!TextUtils.isEmpty(paramaisk.jdField_c_of_type_JavaLangString))
        {
          if (paramaisk.jdField_b_of_type_Boolean) {
            i = 2;
          }
        }
        else
        {
          if (!paramaisk.jdField_a_of_type_Boolean) {
            break label161;
          }
          j = 0;
          k = ApolloUtil.b(k);
          str = Integer.toString(paramaisk.f);
          if (paramaisk.e != 0) {
            break label166;
          }
        }
        for (paramaisk = "0";; paramaisk = "1")
        {
          bajr.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", j, k, new String[] { str, paramaisk, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localaisd.jdField_a_of_type_JavaLangString });
          return;
          i = 1;
          break;
          j = 1;
          break label71;
        }
      }
    } while (k != 0);
    label161:
    label166:
    String str = "0";
    if (!TextUtils.isEmpty(paramaisk.jdField_c_of_type_JavaLangString)) {
      str = "1";
    }
    if (paramaisk.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      bajr.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(paramaisk.f), str, "", String.valueOf(System.currentTimeMillis() / 1000L), localaisd.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (-1 == paramQQAppInterface.d) {
        paramQQAppInterface.b();
      }
    } while (paramQQAppInterface.d == 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((paramInt == 1) || (paramInt == 3000))
    {
      HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support hot chat right now.");
        }
        return false;
      }
    }
    if ((paramInt == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support isQidianPrivateTroop now.");
      }
      return false;
    }
    if ((paramInt == 0) && (azzz.b(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support isBabyQUin now.");
      }
      return false;
    }
    if ((paramInt != 1) && (paramInt != 0) && ((paramInt != 3000) || (aifg.c("discuss") != 1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support, not friend or troop or discussion.");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, aisk paramaisk, aisd paramaisd, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramaisd == null) || (paramaisd.a() == null)) {
      bool1 = false;
    }
    label111:
    do
    {
      do
      {
        do
        {
          return bool1;
          paramaisd = paramaisd.a().getCurrentAccountUin();
          if ((TextUtils.isEmpty(paramaisk.jdField_b_of_type_JavaLangString)) || (paramaisk.jdField_b_of_type_JavaLangString.length() <= 4)) {
            break label111;
          }
          if ((!paramString.equals(paramaisk.jdField_b_of_type_JavaLangString)) || (!paramString.equals(paramaisd))) {
            break;
          }
          bool1 = bool2;
        } while (!paramString.equals(paramaisk.jdField_a_of_type_JavaLangString));
        if (!paramString.equals(paramaisk.jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool1 = bool2;
      } while (paramBoolean);
      return false;
      if (TextUtils.isEmpty(paramaisk.jdField_a_of_type_JavaLangString)) {
        break;
      }
      bool1 = bool2;
    } while (paramString.equals(paramaisd));
    return false;
    return false;
  }
  
  public static int b()
  {
    return (int)babp.i();
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      aisd localaisd;
      SharedPreferences localSharedPreferences;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            localaisd = a(paramQQAppInterface);
          } while (localaisd == null);
          localSharedPreferences = localaisd.jdField_a_of_type_AndroidContentSharedPreferences;
        } while (localSharedPreferences == null);
        i = localSharedPreferences.getInt("audio_tips_times" + localaisd.jdField_b_of_type_JavaLangString, 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "totalTimes:" + i);
        }
      } while (3 == i);
      localSharedPreferences.edit().putInt("audio_tips_times" + localaisd.jdField_b_of_type_JavaLangString, i + 1).commit();
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.post(new SpriteUtil.1());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    return (paramQQAppInterface == null) || (paramQQAppInterface.b());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = b(0);
    if (!c(paramQQAppInterface))
    {
      aixo.a(i, 10, 102, new Object[] { "not meet basic case" });
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
    }
    do
    {
      do
      {
        return false;
        if (1 != aiwi.a(paramQQAppInterface.c(), paramQQAppInterface))
        {
          aixo.a(i, 10, 101, new Object[] { "cmshow switch NOT opend" });
          QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
          return false;
        }
        if (!mnf.a().a(paramString)) {
          break;
        }
        aixo.a(i, 10, 104, new Object[] { "aio anonymous" });
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "aio anonymous.");
      return false;
    } while ((!a(paramQQAppInterface, paramInt, paramString)) || (b(paramQQAppInterface)));
    paramQQAppInterface = new SessionInfo();
    paramQQAppInterface.jdField_a_of_type_Int = paramInt;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString;
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return false;
        if (aifg.a(BaseApplicationImpl.getContext())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "NOT allowed to use cmshow.");
      return false;
    } while (!ApolloEngine.a());
    return true;
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (!c(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != aiwi.a(paramQQAppInterface.c(), paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisl
 * JD-Core Version:    0.7.0.1
 */