import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.NewIntent;

public class aivb
  implements aiwf
{
  private static HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static HashMap<String, Integer> b = new HashMap();
  private aiwh jdField_a_of_type_Aiwh;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public static String a(String paramString)
  {
    return "voice_shown_hot_friend_tip_bar_" + paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = str1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "afterShowHotFriendTip() is called,mapKey is:" + str2);
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    String str3 = a(str1);
    boolean bool = ((SharedPreferences)localObject).getBoolean(str3, false);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("ReduFriendServlet", 2, "shownHotFriendTip is:" + bool + ",not need to save value");
      }
    }
    do
    {
      return;
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean(str3, true);
      long l = bcrg.a();
      ((SharedPreferences.Editor)localObject).putString("voice_hot_friend_tip_show_time" + str1, String.valueOf(l * 1000L));
      ((SharedPreferences.Editor)localObject).commit();
      jdField_a_of_type_JavaUtilHashMap.put(str2, Boolean.TRUE);
      b(paramQQAppInterface, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReduFriendServlet", 2, "shownHotFriendTip is:" + bool + ",need to save value");
  }
  
  public static String[] a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    paramQQAppInterface = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = Long.parseLong(paramQQAppInterface.getString(b(paramString), "-1"));
    if (Math.abs(paramLong - l) >= 86400000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReduFriendServlet", 2, "currTime is:" + paramLong + ",pullHotFriendTimeLong is:" + l + ",need to pull hot friend");
      }
      return null;
    }
    return paramQQAppInterface.getString(c(paramString), "").split("\\|");
  }
  
  public static String b(String paramString)
  {
    return "free_call_pull_hot_friend_time_" + paramString;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "incrementHotFriendEnterAIOTimes() is called,mapKey is:" + paramQQAppInterface);
    }
    if (jdField_a_of_type_JavaUtilHashMap.get(paramQQAppInterface) != null)
    {
      paramString = (Integer)b.get(paramQQAppInterface);
      if (paramString == null)
      {
        b.put(paramQQAppInterface, Integer.valueOf(1));
        if (QLog.isColorLevel()) {
          QLog.d("ReduFriendServlet", 2, "shownHotFriendTip flag exist,beforeTimes is:" + paramString);
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        b.put(paramQQAppInterface, Integer.valueOf(paramString.intValue() + 1));
      }
    }
    QLog.d("ReduFriendServlet", 2, "shownHotFriendTip flag does not exist,not increment time");
  }
  
  public static String c(String paramString)
  {
    return "free_call_hot_friend_" + paramString;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "removeShownHotFriendTipFlag() is called");
    }
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface + "_" + paramString;
    jdField_a_of_type_JavaUtilHashMap.remove(paramQQAppInterface);
  }
  
  public int a()
  {
    return 40;
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject3 = paramQQAppInterface.getCurrentAccountUin();
    Object localObject4 = (String)localObject3 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "shouldShowHotFriendVoiceCallBar() ==> ,mapKey is:" + (String)localObject4);
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaUtilHashMap.get(localObject4) == null) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = (Integer)b.get(localObject4);
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Integer)localObject3).intValue() > 3) {
            continue;
          }
        }
        localObject1 = localObject2;
        localObject3 = ((anyw)paramQQAppInterface.getManager(51)).e(paramString);
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        if ((((Friends)localObject3).abilityBits & 1L) == 0L) {
          continue;
        }
        localObject1 = localObject2;
        i = ((Friends)localObject3).getNetWorkType();
        if (i != 2) {
          continue;
        }
        j = 2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
          i = j;
        }
      }
      finally
      {
        try
        {
          int j;
          Object localObject5;
          long l;
          int k;
          int m;
          int n;
          int i1;
          bdll.b(paramQQAppInterface, "CliOper", "", "", "Free_call", "Free_call_tips", 0, 0, "", "", "", "");
          int i = 1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "can show hot friend voice call bar");
          return 1;
        }
        finally
        {
          localObject1 = "can show hot friend voice call bar";
        }
        paramQQAppInterface = finally;
      }
      return i;
      i = 1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory");
        return 1;
        localObject1 = localObject2;
        c(paramQQAppInterface, paramString);
        i = 2;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "find true flag from memory but friend abilityBits does not contain support voice flag");
          return 2;
          localObject1 = localObject2;
          c(paramQQAppInterface, paramString);
          localObject1 = localObject2;
          paramQQAppInterface = "find true flag from memory but enterAIOTimes is too large,enterAIOTimes is:" + localObject3 + ",MAX_ENTER_TIMES is:" + 3;
          i = 2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
            return 2;
            localObject1 = localObject2;
            localObject4 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
            localObject1 = localObject2;
            if (((SharedPreferences)localObject4).getBoolean(a((String)localObject3), false))
            {
              i = 2;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown hot friend tip");
                return 2;
              }
            }
            else
            {
              localObject1 = localObject2;
              localObject5 = ((SharedPreferences)localObject4).getString("voice_remark_tip_show_time" + (String)localObject3, "");
              localObject1 = localObject2;
              l = bcrg.a() * 1000L;
              localObject1 = localObject2;
              localObject4 = new Time();
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                localObject1 = localObject2;
                QLog.d("FriendHotTipsBar", 2, "multiRemarkTipShowTime is:" + (String)localObject5 + ",currTimeMillis is:" + l);
              }
              if (localObject5 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject5).length() > 0)
                {
                  localObject1 = localObject2;
                  localObject5 = ((String)localObject5).split("\\|");
                  localObject1 = localObject2;
                  ((Time)localObject4).set(l);
                  localObject1 = localObject2;
                  i = ((Time)localObject4).year;
                  localObject1 = localObject2;
                  j = ((Time)localObject4).month;
                  localObject1 = localObject2;
                  k = ((Time)localObject4).monthDay;
                  localObject1 = localObject2;
                  ((Time)localObject4).set(Long.parseLong(localObject5[(localObject5.length - 1)]));
                  localObject1 = localObject2;
                  m = ((Time)localObject4).year;
                  localObject1 = localObject2;
                  n = ((Time)localObject4).month;
                  localObject1 = localObject2;
                  i1 = ((Time)localObject4).monthDay;
                  if ((i == m) && (j == n) && (k == i1))
                  {
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "has shown remark tip this day");
                    return 2;
                  }
                }
              }
              localObject1 = localObject2;
              if (!bhnv.h(BaseApplication.getContext()))
              {
                localObject1 = localObject2;
                if (!bhnv.c(BaseApplication.getContext()))
                {
                  i = 2;
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "my network is not wifi or 3g or 4g");
                  return 2;
                }
              }
              localObject1 = localObject2;
              localObject4 = a(paramQQAppInterface, (String)localObject3, bcrg.a());
              if (localObject4 == null)
              {
                paramString = "there is no hot friend,need to pull";
                if (paramBoolean)
                {
                  localObject1 = paramString;
                  localObject2 = new NewIntent(paramQQAppInterface.getApp(), bcvy.class);
                  localObject1 = paramString;
                  ((NewIntent)localObject2).putExtra("k_uin", (String)localObject3);
                  localObject1 = paramString;
                  paramQQAppInterface.startServlet((NewIntent)localObject2);
                  i = 3;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
                    return 3;
                  }
                }
                else
                {
                  i = 2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "there is no hot friend,need to pull");
                    return 2;
                  }
                }
              }
              else
              {
                localObject1 = localObject2;
                localObject3 = new HashMap();
                i = 0;
                localObject1 = localObject2;
                if (i < localObject4.length)
                {
                  localObject1 = localObject2;
                  ((HashMap)localObject3).put(localObject4[i], localObject4[i]);
                  i += 1;
                }
                else
                {
                  localObject1 = localObject2;
                  if (((HashMap)localObject3).get(paramString) != null)
                  {
                    localObject1 = localObject2;
                    localObject3 = ((anyw)paramQQAppInterface.getManager(51)).e(paramString);
                    if (localObject3 == null)
                    {
                      localObject1 = localObject2;
                      paramQQAppInterface = "can not find friend,friendUin is:" + paramString;
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend does not exist in hot friend,friendUin is:" + paramString + ",hotFriend is:" + Arrays.toString((Object[])localObject4);
                    i = 2;
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                    return 2;
                  }
                  localObject1 = localObject2;
                  if ((((Friends)localObject3).abilityBits & 1L) == 0L)
                  {
                    localObject1 = localObject2;
                    paramQQAppInterface = "friend abilityBits does not contain support voice flag,f.abilityBits is:" + ((Friends)localObject3).abilityBits;
                    i = 2;
                    if (QLog.isColorLevel())
                    {
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + paramQQAppInterface);
                      return 2;
                    }
                  }
                  else
                  {
                    localObject1 = localObject2;
                    i = ((Friends)localObject3).getNetWorkType();
                    if (i == 2)
                    {
                      i = 2;
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + "");
                      return 2;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "shouldShowVoiceHotFriendTipBar() ==> step is:" + (String)localObject1);
    }
    throw paramQQAppInterface;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561064, null);
    paramVarArgs.findViewById(2131374288).setOnClickListener(new aivc(this));
    return paramVarArgs;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendHotTipsBar", 2, "curType != Friend");
      }
    }
    arrs localarrs;
    do
    {
      do
      {
        return;
        localarrs = arrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!localarrs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("FriendHotTipsBar", 2, "hasNetTipShow today");
      return;
    } while ((a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true) != 1) || (!this.jdField_a_of_type_Aiwh.a(this, new Object[0])));
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localarrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendHotTipsBar", 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return new int[] { 2000 };
  }
  
  public int b()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivb
 * JD-Core Version:    0.7.0.1
 */