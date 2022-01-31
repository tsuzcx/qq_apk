package com.tencent.mm.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.b;
import java.util.Map;

public final class v
{
  static ProgressDialog eeN = null;
  static SecurityImage gwg;
  private static boolean zbS = false;
  
  static
  {
    gwg = null;
  }
  
  public static com.tencent.mm.ui.widget.b.c a(Activity paramActivity, String paramString1, String paramString2, Intent paramIntent)
  {
    AppMethodBeat.i(29610);
    jo localjo = new jo();
    localjo.cze.status = 0;
    localjo.cze.aXG = 1;
    com.tencent.mm.sdk.b.a.ymk.l(localjo);
    paramActivity = com.tencent.mm.ui.base.h.a(paramActivity, paramString1, paramActivity.getString(2131297087), new v.1(paramString2, paramActivity, paramIntent), new v.2(paramString2, paramActivity, paramIntent));
    AppMethodBeat.o(29610);
    return paramActivity;
  }
  
  public static boolean a(final Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(29609);
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(29609);
      return false;
    }
    ab.d("MicroMsg.MMErrorProcessor", "errType = " + paramInt1 + " errCode = " + paramInt2);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(29609);
      return false;
      ab.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131301418, 2131297087, new v.6(paramIntent, paramActivity));
      AppMethodBeat.o(29609);
      return true;
      String str = aw.QD();
      ab.e("MicroMsg.MMErrorProcessor", "account expired=" + paramInt2 + " lastKickReason=" + str);
      paramString = new com.tencent.mm.g.a.w();
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      com.tencent.mm.kernel.a.hold();
      paramString = new jo();
      paramString.cze.status = 0;
      paramString.cze.aXG = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramString);
      ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
      if (zbS)
      {
        if (bo.isNullOrNil(str)) {}
        for (paramActivity = "";; paramActivity = str)
        {
          ab.i("MicroMsg.MMErrorProcessor", "already show kickout dialog before, ignore. lastKickReason[%s]", new Object[] { paramActivity });
          AppMethodBeat.o(29609);
          return true;
        }
      }
      if (!bo.isNullOrNil(str))
      {
        paramString = com.tencent.mm.h.a.kO(str);
        if (paramString != null)
        {
          ab.i("MicroMsg.MMErrorProcessor", "account expired br showType[%d]", new Object[] { Integer.valueOf(paramString.showType) });
          if (((paramString.showType == 3) || (paramString.showType == 4)) && (paramString.a(paramActivity, new v.7(paramIntent, paramActivity, paramString), new v.8(paramIntent, paramActivity))))
          {
            zbS = true;
            ab.i("MicroMsg.MMErrorProcessor", "show kickout dialog by new logic.");
            AppMethodBeat.o(29609);
            return true;
          }
        }
      }
      paramString = str;
      Map localMap;
      if (!bo.isNullOrNil(str))
      {
        paramString = str;
        if (str.startsWith("<"))
        {
          localMap = br.F(str, "e");
          paramString = str;
          if (localMap != null)
          {
            paramString = str;
            if (!bo.isNullOrNil((String)localMap.get(".e.Content")))
            {
              paramString = (String)localMap.get(".e.Content");
              ab.i("MicroMsg.MMErrorProcessor", "account expired summerauthkick errmsg=" + paramString + " |v=" + localMap);
            }
          }
        }
      }
      ab.i("MicroMsg.MMErrorProcessor", "account expired lastKickReason[%s]", new Object[] { paramString });
      str = paramString;
      if (bo.isNullOrNil(paramString)) {
        str = com.tencent.mm.cb.a.aq(paramActivity, 2131301416);
      }
      com.tencent.mm.ui.base.h.a(paramActivity, str, paramActivity.getString(2131297087), new v.9(paramIntent, paramActivity), new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(29604);
          if (this.zbT != null)
          {
            if (!(paramActivity instanceof LauncherUI)) {
              paramActivity.finish();
            }
            paramActivity.startActivity(this.zbT);
            b.K(paramActivity, this.zbT);
            com.tencent.mm.platformtools.w.ct(paramActivity);
          }
          AppMethodBeat.o(29604);
        }
      });
      zbS = true;
      ab.i("MicroMsg.MMErrorProcessor", "show kickout dialog by old logic.");
      AppMethodBeat.o(29609);
      return true;
      ab.e("MicroMsg.MMErrorProcessor", "account expired=".concat(String.valueOf(paramInt2)));
      com.tencent.mm.ui.base.h.a(paramActivity, 2131296531, 2131297087, new v.11(paramIntent, paramActivity));
      AppMethodBeat.o(29609);
      return true;
      ab.e("MicroMsg.MMErrorProcessor", "accout errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt2), paramString });
      if ((!bo.isNullOrNil(paramString)) && (paramString.startsWith("autoauth_errmsg_"))) {
        str = paramString.substring(16);
      }
      do
      {
        paramString = str;
        if (!bo.isNullOrNil(str))
        {
          paramString = str;
          if (str.startsWith("<"))
          {
            localMap = br.F(str, "e");
            paramString = str;
            if (localMap != null)
            {
              paramString = str;
              if (!bo.isNullOrNil((String)localMap.get(".e.Content"))) {
                paramString = (String)localMap.get(".e.Content");
              }
            }
          }
        }
        str = paramString;
        if (bo.isNullOrNil(paramString)) {
          str = ah.getContext().getString(2131301418);
        }
        com.tencent.mm.ui.base.h.a(paramActivity, str, ah.getContext().getString(2131297087), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(29606);
            if (this.zbT != null)
            {
              paramActivity.finish();
              paramActivity.startActivity(this.zbT);
              b.K(paramActivity, this.zbT);
              com.tencent.mm.platformtools.w.ct(paramActivity);
            }
            AppMethodBeat.o(29606);
          }
        });
        AppMethodBeat.o(29609);
        return true;
        str = paramString;
      } while (paramInt2 != -104);
      ab.i("MicroMsg.MMErrorProcessor", "MM_ERR_LOGIC but not autoauth showMsg[%s] break", new Object[] { paramString });
    }
  }
  
  private static boolean aA(Activity paramActivity)
  {
    AppMethodBeat.i(29614);
    com.tencent.mm.pluginsdk.model.app.a locala = com.tencent.mm.pluginsdk.model.app.a.dlr();
    if (locala != null)
    {
      locala.dlu();
      ab.i("MicroMsg.MMErrorProcessor", "alpha download in silence.");
      AppMethodBeat.o(29614);
      return true;
    }
    if (com.tencent.mm.plugin.p.d.bSu() != null)
    {
      com.tencent.mm.plugin.p.d.bSu().eB(paramActivity).update(2);
      AppMethodBeat.o(29614);
      return true;
    }
    AppMethodBeat.o(29614);
    return false;
  }
  
  public static boolean az(Activity paramActivity)
  {
    int j = 1;
    AppMethodBeat.i(29611);
    if (bo.apV(com.tencent.mm.m.g.Nq().getValue("SilentDownloadApkAtWiFi")) != 0)
    {
      AppMethodBeat.o(29611);
      return false;
    }
    aw.aaz();
    int i;
    if ((((Integer)com.tencent.mm.model.c.Ru().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      i = 1;
      if ((!at.isWifi(paramActivity)) || (i == 0)) {
        break label121;
      }
      i = j;
      label75:
      if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) == 0) {
        break label126;
      }
      ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      i = 0;
    }
    for (;;)
    {
      if ((i == 0) || (!i.dlV())) {
        break label137;
      }
      boolean bool = aA(paramActivity);
      AppMethodBeat.o(29611);
      return bool;
      i = 0;
      break;
      label121:
      i = 0;
      break label75;
      label126:
      ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label137:
    AppMethodBeat.o(29611);
    return false;
  }
  
  public static boolean c(Activity paramActivity, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29613);
    ab.w("MicroMsg.MMErrorProcessor", "updateRequired [%d,%d] current version:%d  channel:%d updateMode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(com.tencent.mm.protocal.d.whH), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWu), Integer.valueOf(com.tencent.mm.sdk.platformtools.g.bWw) });
    if (paramInt1 != 4)
    {
      AppMethodBeat.o(29613);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(29613);
      return false;
    case -16: 
      if (com.tencent.mm.plugin.p.d.bSu() != null)
      {
        paramActivity = com.tencent.mm.plugin.p.d.bSu().d(paramActivity, new v.4(paramActivity));
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 36L, 1L, true);
        paramActivity.update(1);
        AppMethodBeat.o(29613);
        return true;
      }
      AppMethodBeat.o(29613);
      return false;
    }
    long l = ah.getContext().getSharedPreferences("system_config_prefs", 0).getLong("recomended_update_ignore", -1L);
    ab.i("MicroMsg.MMErrorProcessor", "updateRequired last:%d  now:%d", new Object[] { Long.valueOf(l), Long.valueOf(bo.gz(l)) });
    if ((l != -1L) && (bo.gz(l) < 86400L))
    {
      AppMethodBeat.o(29613);
      return true;
    }
    if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x2) != 0)
    {
      ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      AppMethodBeat.o(29613);
      return true;
    }
    ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    String str = com.tencent.mm.m.g.Nq().getValue("SilentDownloadApkAtWiFi");
    aw.aaz();
    if ((((Integer)com.tencent.mm.model.c.Ru().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || ((!bo.isNullOrNil(str)) && (bo.apV(str) != 0))) {
        break label458;
      }
      bool = true;
      label340:
      if ((com.tencent.mm.sdk.platformtools.g.bWw & 0x1) == 0) {
        break label464;
      }
      ab.d("MicroMsg.MMErrorProcessor", "channel pack, not silence download.");
      bool = false;
    }
    for (;;)
    {
      if (bo.apV(str) != 0) {
        ab.d("MicroMsg.MMErrorProcessor", "dynaCfg close silence wifi download.");
      }
      ab.d("MicroMsg.MMErrorProcessor", "summerupdate updateRequired silenceDownload[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        break label483;
      }
      if (com.tencent.mm.plugin.p.d.bSu() == null) {
        break label475;
      }
      paramActivity = com.tencent.mm.plugin.p.d.bSu().d(paramActivity, new v.5(paramActivity));
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 38L, 1L, true);
      paramActivity.update(2);
      AppMethodBeat.o(29613);
      return true;
      paramInt1 = 0;
      break;
      label458:
      bool = false;
      break label340;
      label464:
      ab.d("MicroMsg.MMErrorProcessor", "not channel pack.");
    }
    label475:
    AppMethodBeat.o(29613);
    return false;
    label483:
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(405L, 40L, 1L, true);
    boolean bool = aA(paramActivity);
    AppMethodBeat.o(29613);
    return bool;
  }
  
  public static boolean hL(Context paramContext)
  {
    AppMethodBeat.i(29612);
    String str = i.dlS();
    int i = i.dlT();
    ab.i("MicroMsg.MMErrorProcessor", "installRequired %s, updateType: %d", new Object[] { str, Integer.valueOf(i) });
    if ((!bo.isNullOrNil(str)) && (!i.dlU()))
    {
      aw.RO().ac(new v.3(i, str, paramContext));
      AppMethodBeat.o(29612);
      return true;
    }
    AppMethodBeat.o(29612);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.v
 * JD-Core Version:    0.7.0.1
 */