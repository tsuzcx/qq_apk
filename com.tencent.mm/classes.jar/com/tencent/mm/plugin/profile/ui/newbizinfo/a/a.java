package com.tencent.mm.plugin.profile.ui.newbizinfo.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23932);
    if ("//usenewprofile".equals(paramArrayOfString[0]))
    {
      paramContext = ah.dsQ();
      if (paramArrayOfString.length <= 1)
      {
        paramContext.edit().putBoolean("use_new_profile", true).commit();
        AppMethodBeat.o(23932);
        return true;
      }
      paramArrayOfString = paramArrayOfString[1];
      int i = -1;
      switch (paramArrayOfString.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(23932);
        return true;
        if (!paramArrayOfString.equals("true")) {
          break;
        }
        i = 0;
        break;
        if (!paramArrayOfString.equals("false")) {
          break;
        }
        i = 1;
        break;
        paramContext.edit().putBoolean("use_new_profile", true).commit();
        continue;
        paramContext.edit().putBoolean("use_new_profile", false).commit();
      }
    }
    AppMethodBeat.o(23932);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a.a
 * JD-Core Version:    0.7.0.1
 */