package com.tencent.mm.plugin.profile.ui.newbizinfo.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    if ("//usenewprofile".equals(paramArrayOfString[0]))
    {
      paramContext = ae.cqS();
      if (paramArrayOfString.length <= 1) {
        paramContext.edit().putBoolean("use_new_profile", true).commit();
      }
    }
    else
    {
      return true;
    }
    paramArrayOfString = paramArrayOfString[1];
    int i = -1;
    switch (paramArrayOfString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return true;
      case 0: 
        paramContext.edit().putBoolean("use_new_profile", true).commit();
        return true;
        if (paramArrayOfString.equals("true"))
        {
          i = 0;
          continue;
          if (paramArrayOfString.equals("false")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramContext.edit().putBoolean("use_new_profile", false).commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a.a
 * JD-Core Version:    0.7.0.1
 */