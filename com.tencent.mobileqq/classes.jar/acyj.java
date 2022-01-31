import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.HashMap;

public class acyj
{
  public static void a(PlusPanel paramPlusPanel, acxl paramacxl)
  {
    if (paramPlusPanel == null) {
      return;
    }
    switch (paramacxl.a)
    {
    default: 
      b(paramPlusPanel, paramacxl);
    }
    for (;;)
    {
      paramPlusPanel.b(paramacxl.b);
      return;
      Bundle localBundle = new Bundle();
      localBundle.putString("extra.GROUP_UIN", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      localBundle.putString("selfSet_leftViewText", ajya.a(2131715727));
      BulkSendMessageFragment.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), localBundle);
    }
  }
  
  public static boolean a(Context paramContext, String paramString, BaseChatPie paramBaseChatPie, acxl paramacxl)
  {
    com.tencent.TMG.utils.QLog.i("TroopPlusPanelUtils", 1, "troopFormLog openMiniApp:url :" + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return MiniAppLauncher.startMiniApp(paramContext, paramString.replace("$UIN$", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$APPID$", String.valueOf(paramacxl.b)), 2016, paramBaseChatPie.a(), null);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    com.tencent.TMG.utils.QLog.i("TroopPlusPanelUtils", 1, "troopFormLog openTroopFormMiniAppInTroopAIO:url :" + paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null)) {
      return false;
    }
    HashMap localHashMap;
    if (paramString1.startsWith("mqqapi://microapp/open?"))
    {
      paramString1 = paramString1.substring(paramString1.indexOf("?") + 1);
      localHashMap = new HashMap();
    }
    for (;;)
    {
      int i;
      String str;
      try
      {
        String[] arrayOfString = paramString1.split("&");
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          paramString1 = arrayOfString[i].split("=");
          if ((paramString1 == null) || (paramString1.length != 2)) {
            break label488;
          }
          Object localObject = paramString1[0];
          str = URLDecoder.decode(paramString1[1]);
          if (!localObject.contains("extraData"))
          {
            paramString1 = str;
            if (!localObject.contains("path")) {}
          }
          else
          {
            paramString1 = str.replace("$GCODE$", "groupid=" + paramString2 + "&groupname=" + paramString3 + "&uinType=" + paramInt);
          }
          localHashMap.put(localObject, paramString1);
        }
      }
      catch (Exception paramString1)
      {
        com.tencent.qphone.base.util.QLog.e("TroopPlusPanelUtils", 1, "troopFormLog openTroopFormMiniAppInTroopAIO, " + com.tencent.qphone.base.util.QLog.getStackTraceString(paramString1));
      }
      if (!TextUtils.isEmpty((CharSequence)localHashMap.get("appid")))
      {
        paramString1 = new LaunchParam();
        paramString1.miniAppId = ((String)localHashMap.get("appid"));
        paramString2 = (String)localHashMap.get("path");
        paramString3 = (String)localHashMap.get("extraData");
        str = (String)localHashMap.get("envVersion");
        try
        {
          if (!TextUtils.isEmpty(paramString2)) {
            paramString1.entryPath = URLDecoder.decode(paramString2.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), "UTF-8");
          }
          if (!TextUtils.isEmpty(paramString3)) {
            paramString1.navigateExtData = URLDecoder.decode(paramString3, "UTF-8");
          }
          if (!TextUtils.isEmpty(str)) {
            paramString1.envVersion = URLDecoder.decode(str, "UTF-8");
          }
        }
        catch (UnsupportedEncodingException paramString2)
        {
          for (;;)
          {
            com.tencent.qphone.base.util.QLog.e("TroopPlusPanelUtils", 1, "troopFormLog openTroopFormMiniAppInTroopAIO, " + com.tencent.qphone.base.util.QLog.getStackTraceString(paramString2));
          }
        }
        paramString1.scene = 2016;
        com.tencent.TMG.utils.QLog.i("TroopPlusPanelUtils", 1, "troopFormLog openTroopFormMiniAppInTroopAIO:argumentMap :" + localHashMap.toString());
        MiniAppLauncher.launchMiniAppById(paramContext, paramString1.miniAppId, paramString1.entryPath, paramString1.navigateExtData, paramString1.envVersion, paramString1.reportData, paramString1.scene);
        return true;
        return MiniAppLauncher.startMiniApp(paramContext, paramString1, 2016, null);
      }
      return false;
      label488:
      i += 1;
    }
  }
  
  public static boolean a(TroopAIOAppInfo paramTroopAIOAppInfo, BaseChatPie paramBaseChatPie, acxl paramacxl)
  {
    if ((paramTroopAIOAppInfo != null) && (paramBaseChatPie != null) && (MiniAppLauncher.isMiniAppUrl(paramTroopAIOAppInfo.url)))
    {
      a(paramBaseChatPie.a(), paramTroopAIOAppInfo.url, paramBaseChatPie, paramacxl);
      return true;
    }
    return false;
  }
  
  private static void b(PlusPanel paramPlusPanel, acxl paramacxl)
  {
    if (paramacxl.a >= 0) {}
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = null;
        if (paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray != null) {
          localObject = (TroopAIOAppInfo)paramPlusPanel.jdField_a_of_type_AndroidUtilSparseArray.get(paramacxl.b);
        }
      } while ((localObject == null) || (((TroopAIOAppInfo)localObject).url == null));
      paramacxl = ((TroopAIOAppInfo)localObject).url.replace("$UIN$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$GCODE$", paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a).replace("$APPID$", String.valueOf(paramacxl.b));
      int j = 0;
      int i = j;
      try
      {
        if (TextUtils.equals(new URI(paramacxl).getScheme(), "mqqapi"))
        {
          localObject = bbex.a(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), paramacxl);
          i = j;
          if (localObject != null)
          {
            ((bbeg)localObject).c();
            i = 1;
          }
        }
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          i = j;
        }
      }
    } while (i != 0);
    localObject = new Intent(paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramacxl);
    ((Intent)localObject).putExtra("selfSet_leftViewText", ajya.a(2131715723));
    paramPlusPanel.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyj
 * JD-Core Version:    0.7.0.1
 */