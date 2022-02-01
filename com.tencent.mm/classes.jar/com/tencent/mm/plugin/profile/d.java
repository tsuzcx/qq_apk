package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.profile.b.e;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a BcF;
  private q BcG;
  
  static
  {
    AppMethodBeat.i(26866);
    baseDBFactories = new HashMap();
    b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.profile.ui.newbizinfo.d.a.iBh;
      }
    });
    AppMethodBeat.o(26866);
  }
  
  public d()
  {
    AppMethodBeat.i(26860);
    this.BcG = new q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(26859);
        if (Util.nullAsNil(paramAnonymousString).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
          new e(paramAnonymousMap).ben();
        }
        AppMethodBeat.o(26859);
      }
    };
    AppMethodBeat.o(26860);
  }
  
  public static int aP(Intent paramIntent)
  {
    AppMethodBeat.i(26865);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
      Log.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(i)));
      AppMethodBeat.o(26865);
      return i;
    }
    AppMethodBeat.o(26865);
    return 0;
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a eDO()
  {
    AppMethodBeat.i(26861);
    g.aAf().azk();
    if (eDP().BcF == null)
    {
      localObject = eDP();
      bg.aVF();
      ((d)localObject).BcF = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(c.getDataDB());
    }
    Object localObject = eDP().BcF;
    AppMethodBeat.o(26861);
    return localObject;
  }
  
  private static d eDP()
  {
    AppMethodBeat.i(26862);
    bg.aVz();
    d locald2 = (d)cg.KG("plugin.profile");
    d locald1 = locald2;
    if (locald2 == null)
    {
      Log.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      locald1 = new d();
      bg.aVz().a("plugin.freewifi", locald1);
    }
    AppMethodBeat.o(26862);
    return locald1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26863);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.BcG);
    AppMethodBeat.o(26863);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26864);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.BcG);
    AppMethodBeat.o(26864);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.d
 * JD-Core Version:    0.7.0.1
 */