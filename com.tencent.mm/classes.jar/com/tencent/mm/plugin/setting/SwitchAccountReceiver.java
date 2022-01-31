package com.tencent.mm.plugin.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

public class SwitchAccountReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(154164);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(154164);
      return;
    }
    String str = paramIntent.getStringExtra("switch_process_action_code_key");
    ab.i("MicroMsg.SwitchAccountReceiver", "onReceive, action %s", new Object[] { str });
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(154164);
      return;
    }
    if (str.equals("action_reload_resources"))
    {
      str = paramIntent.getStringExtra("switch_language");
      ab.i("MicroMsg.SwitchAccountReceiver", "onReceive, language %s", new Object[] { str });
      paramIntent = aa.apg(str);
      if ("language_default".equalsIgnoreCase(str))
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label147;
        }
        paramIntent = aa.ynv;
        Locale.setDefault(paramIntent);
      }
    }
    for (;;)
    {
      aa.a(paramContext.getApplicationContext(), paramIntent);
      ah.h(b.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str));
      AppMethodBeat.o(154164);
      return;
      label147:
      paramIntent = Locale.getDefault();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.SwitchAccountReceiver
 * JD-Core Version:    0.7.0.1
 */