package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.profile.b.e;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a vIg;
  private p vIh;
  
  static
  {
    AppMethodBeat.i(26866);
    baseDBFactories = new HashMap();
    b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.profile.ui.newbizinfo.d.a.hlS;
      }
    });
    AppMethodBeat.o(26866);
  }
  
  public c()
  {
    AppMethodBeat.i(26860);
    this.vIh = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(26859);
        if (bs.nullAsNil(paramAnonymousString).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
          new e(paramAnonymousMap).aGG();
        }
        AppMethodBeat.o(26859);
      }
    };
    AppMethodBeat.o(26860);
  }
  
  public static int aB(Intent paramIntent)
  {
    AppMethodBeat.i(26865);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
      ac.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(i)));
      AppMethodBeat.o(26865);
      return i;
    }
    AppMethodBeat.o(26865);
    return 0;
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a dpC()
  {
    AppMethodBeat.i(26861);
    g.agP().afT();
    if (dpD().vIg == null)
    {
      localObject = dpD();
      az.ayM();
      ((c)localObject).vIg = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(com.tencent.mm.model.c.agw());
    }
    Object localObject = dpD().vIg;
    AppMethodBeat.o(26861);
    return localObject;
  }
  
  private static c dpD()
  {
    AppMethodBeat.i(26862);
    az.ayG();
    c localc2 = (c)bz.yz("plugin.profile");
    c localc1 = localc2;
    if (localc2 == null)
    {
      ac.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      localc1 = new c();
      az.ayG().a("plugin.freewifi", localc1);
    }
    AppMethodBeat.o(26862);
    return localc1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26863);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.vIh);
    AppMethodBeat.o(26863);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26864);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.vIh);
    AppMethodBeat.o(26864);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */