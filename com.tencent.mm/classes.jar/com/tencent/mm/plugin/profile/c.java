package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.profile.b.e;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class c
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a uzn;
  private p uzo;
  
  static
  {
    AppMethodBeat.i(26866);
    baseDBFactories = new HashMap();
    b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.profile.ui.newbizinfo.d.a.gLs;
      }
    });
    AppMethodBeat.o(26866);
  }
  
  public c()
  {
    AppMethodBeat.i(26860);
    this.uzo = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(26859);
        if (bt.nullAsNil(paramAnonymousString).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
          new e(paramAnonymousMap).azQ();
        }
        AppMethodBeat.o(26859);
      }
    };
    AppMethodBeat.o(26860);
  }
  
  public static int aA(Intent paramIntent)
  {
    AppMethodBeat.i(26865);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
      ad.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(i)));
      AppMethodBeat.o(26865);
      return i;
    }
    AppMethodBeat.o(26865);
    return 0;
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a dbU()
  {
    AppMethodBeat.i(26861);
    g.afz().aeD();
    if (dbV().uzn == null)
    {
      localObject = dbV();
      az.arV();
      ((c)localObject).uzn = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(com.tencent.mm.model.c.afg());
    }
    Object localObject = dbV().uzn;
    AppMethodBeat.o(26861);
    return localObject;
  }
  
  private static c dbV()
  {
    AppMethodBeat.i(26862);
    az.arP();
    c localc2 = (c)bz.ut("plugin.profile");
    c localc1 = localc2;
    if (localc2 == null)
    {
      ad.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      localc1 = new c();
      az.arP().a("plugin.freewifi", localc1);
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
    ((q)g.ad(q.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.uzo);
    AppMethodBeat.o(26863);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26864);
    ((q)g.ad(q.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.uzo);
    AppMethodBeat.o(26864);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */