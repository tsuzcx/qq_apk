import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class akgc
{
  public static int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null)) {
      return -1;
    }
    switch (paramSessionInfo.curType)
    {
    default: 
      return -1;
    case 0: 
    case 1008: 
      return 0;
    case 3000: 
      return 2;
    case 1: 
      paramQQAppInterface = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b(paramSessionInfo.curFriendUin))) {
        return 5;
      }
      return 1;
    case 1000: 
      return 3;
    case 1004: 
      return 4;
    case 1001: 
    case 10002: 
    case 10004: 
      return 6;
    }
    return 58;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = -1;
    Object localObject = "";
    switch (paramSessionInfo.curType)
    {
    default: 
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", i);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      i = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      i = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      int j;
      if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.curFriendUin)))
      {
        j = 5;
        localObject = ContactUtils.getDateNickName(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
        }
      }
      else
      {
        i = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        j = 6;
        localObject = ContactUtils.getDateNickName(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        i = j;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          i = j;
          continue;
          i = 58;
          paramSessionInfo = a(paramQQAppInterface);
        }
      }
    }
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    int i = -1;
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramInt = i;
      paramSessionInfo = (SessionInfo)localObject;
    }
    for (;;)
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("groupType", paramInt);
      paramQQAppInterface.putString("name", paramSessionInfo);
      return paramQQAppInterface;
      paramInt = 0;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      paramInt = 2;
      paramSessionInfo = a(paramQQAppInterface);
      continue;
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      if ((localObject != null) && (((HotChatManager)localObject).b(paramSessionInfo.curFriendUin)))
      {
        i = 5;
        localObject = ContactUtils.getDateNickName(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        paramInt = i;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          paramInt = i;
        }
      }
      else
      {
        paramInt = 1;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        paramInt = 3;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        paramInt = 4;
        paramSessionInfo = a(paramQQAppInterface);
        continue;
        i = 6;
        localObject = ContactUtils.getDateNickName(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin());
        paramSessionInfo = (SessionInfo)localObject;
        paramInt = i;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSessionInfo = a(paramQQAppInterface);
          paramInt = i;
          continue;
          paramInt = 58;
          paramSessionInfo = a(paramQQAppInterface);
        }
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = ((amsw)paramQQAppInterface.getManager(51)).e(str);
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface.name != null) && (paramQQAppInterface.name.length() > 0)) {
        return paramQQAppInterface.name;
      }
      return paramQQAppInterface.uin;
    }
    return str;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramQQAppInterface, paramSessionInfo, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt2, paramInt3, "", 0, paramInt4, null);
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, String paramString8, int paramInt4, int paramInt5, Bundle paramBundle)
  {
    paramString1 = a(paramString2, paramString1, paramInt1, paramString3, paramString4, paramString7, paramSessionInfo.troopUin, paramInt2, paramInt3, paramInt4, paramString8, paramInt5, paramBundle, paramSessionInfo.curFriendUin);
    if (paramSessionInfo.curType == 1008) {
      paramSessionInfo = new JSONObject();
    }
    try
    {
      paramSessionInfo.put("channel", 2);
      paramString1.put("detailinfo", paramSessionInfo);
      paramSessionInfo = new JSONObject();
    }
    catch (Exception paramSessionInfo)
    {
      try
      {
        do
        {
          paramSessionInfo.put("userId", paramQQAppInterface.getCurrentAccountUin());
          paramSessionInfo.put("viewTag", paramString6);
          paramSessionInfo.put("app_info", paramString5);
          paramSessionInfo.put("come_from", 2);
          paramSessionInfo.put("extra_data", paramString1);
          return paramSessionInfo;
          paramSessionInfo = paramSessionInfo;
        } while (!QLog.isDevelopLevel());
        paramSessionInfo.printStackTrace();
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isDevelopLevel()) {}
        paramQQAppInterface.printStackTrace();
      }
    }
    return paramSessionInfo;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt1, SessionInfo paramSessionInfo, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    int i = 0;
    int j = 0;
    int m;
    int k;
    if (paramQQWalletBaseMsgElem != null)
    {
      i = paramQQWalletBaseMsgElem.resourceType;
      j = paramQQWalletBaseMsgElem.skinId;
      m = paramQQWalletBaseMsgElem.special_pop_id;
      k = paramQQWalletBaseMsgElem.hbFrom;
    }
    for (;;)
    {
      paramQQWalletBaseMsgElem = a(paramString2, paramString1, paramInt2, paramString3, paramString4, paramString7, paramMessageForQQWalletMsg.senderuin, paramInt1, i, j, "", paramMessageForQQWalletMsg.fromHBList, null, paramSessionInfo.curFriendUin);
      try
      {
        paramQQWalletBaseMsgElem.put("bigAnimId", m);
        paramQQWalletBaseMsgElem.put("hb_from", k);
        if (paramSessionInfo.curType == 1008)
        {
          paramSessionInfo = new JSONObject();
          paramSessionInfo.put("channel", 2);
          paramQQWalletBaseMsgElem.put("detailinfo", paramSessionInfo);
        }
        paramSessionInfo = new JSONObject();
      }
      catch (Exception paramSessionInfo)
      {
        try
        {
          do
          {
            paramSessionInfo.put("userId", paramQQAppInterface.getCurrentAccountUin());
            paramSessionInfo.put("viewTag", paramString6);
            paramSessionInfo.put("app_info", paramString5);
            paramSessionInfo.put("comeForm", 2);
            paramSessionInfo.put("extra_data", paramQQWalletBaseMsgElem);
            paramSessionInfo.put("senderuin", abwz.c(paramMessageForQQWalletMsg));
            return paramSessionInfo;
            paramSessionInfo = paramSessionInfo;
          } while (!QLog.isDevelopLevel());
          paramSessionInfo.printStackTrace();
        }
        catch (Exception paramQQAppInterface)
        {
          while (!QLog.isDevelopLevel()) {}
          paramQQAppInterface.printStackTrace();
          return paramSessionInfo;
        }
      }
      k = 0;
      m = 0;
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, int paramInt3, int paramInt4, String paramString7, int paramInt5, Bundle paramBundle, String paramString8)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("listid", paramString1);
      localJSONObject.put("name", paramString2);
      localJSONObject.put("grouptype", paramInt1 + "");
      localJSONObject.put("groupid", paramString4);
      localJSONObject.put("channel", paramInt2);
      localJSONObject.put("resource_type", paramInt3);
      localJSONObject.put("skin_id", paramInt4);
      localJSONObject.put("fromHBList", paramInt5);
      if (paramString6 != null) {
        localJSONObject.put("groupuin", paramString6);
      }
      if (paramString3 != null) {
        localJSONObject.put("authkey", paramString3);
      }
      if (paramString5 != null) {
        localJSONObject.put("cftImageUrl", paramString5);
      }
      if (!TextUtils.isEmpty(paramString7)) {
        localJSONObject.put("voice_rate_id", paramString7);
      }
      if (!TextUtils.isEmpty(paramString8)) {
        localJSONObject.put("curFriendUin", paramString8);
      }
      if (paramBundle != null)
      {
        paramString1 = paramBundle.keySet();
        if (paramString1 != null)
        {
          paramString1 = paramString1.iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            localJSONObject.put(paramString2, paramBundle.get(paramString2));
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      if (QLog.isDevelopLevel()) {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (DisplayUtil.dip2px(paramContext, 650.0F) < localDisplayMetrics.heightPixels) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, JumpActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.setData(Uri.parse(paramString));
    paramContext.startActivity(localIntent);
    return true;
  }
  
  public static boolean a(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    return (paramMessageForQQWalletMsg != null) && (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg != null) && (paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem != null);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForQQWalletMsg)) && (a((MessageForQQWalletMsg)paramMessageRecord));
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgc
 * JD-Core Version:    0.7.0.1
 */