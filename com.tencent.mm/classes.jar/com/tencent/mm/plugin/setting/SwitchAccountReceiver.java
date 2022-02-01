package com.tencent.mm.plugin.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;

public class SwitchAccountReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(73757);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(73757);
      return;
    }
    String str = paramIntent.getStringExtra("switch_process_action_code_key");
    ae.i("MicroMsg.SwitchAccountReceiver", "onReceive, action %s", new Object[] { str });
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(73757);
      return;
    }
    if (str.equals("action_reload_resources"))
    {
      str = paramIntent.getStringExtra("switch_language");
      ae.i("MicroMsg.SwitchAccountReceiver", "onReceive, language %s", new Object[] { str });
      paramIntent = ad.aRN(str);
      if ("language_default".equalsIgnoreCase(str))
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label147;
        }
        paramIntent = ad.Ixw;
        Locale.setDefault(paramIntent);
      }
    }
    for (;;)
    {
      ad.a(paramContext.getApplicationContext(), paramIntent);
      ak.h(b.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str));
      AppMethodBeat.o(73757);
      return;
      label147:
      paramIntent = Locale.getDefault();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.SwitchAccountReceiver
 * JD-Core Version:    0.7.0.1
 */