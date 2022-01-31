package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil
{
  public static final String Se(int paramInt)
  {
    return "KeyConfigHttpCode[" + paramInt + "]";
  }
  
  public static final String Sf(int paramInt)
  {
    return "KeyPatchHttpCode[" + paramInt + "]";
  }
  
  public static final String awx(String paramString)
  {
    if (paramString.contains("?")) {
      return paramString + "uuid=" + UUID.randomUUID().toString();
    }
    return paramString + "?uuid=" + UUID.randomUUID().toString();
  }
  
  public static String iY(Context paramContext)
  {
    return paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0).getString("last_login_uin", "0");
  }
  
  public static String iZ(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramContext.getPackageName() + "_preferences", 0);
    Object localObject2 = localSharedPreferences.getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2)) {
      localObject1 = localSharedPreferences.getString("login_user_name", "");
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = String.valueOf(Util.iT(paramContext));
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.recovery.wx.util.WXUtil
 * JD-Core Version:    0.7.0.1
 */