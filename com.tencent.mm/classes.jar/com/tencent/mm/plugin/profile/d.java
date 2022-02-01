package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.f.b.a.nb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.profile.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a GWF;
  private t GWG;
  
  static
  {
    AppMethodBeat.i(26866);
    baseDBFactories = new HashMap();
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.profile.ui.newbizinfo.d.a.lqL;
      }
    });
    AppMethodBeat.o(26866);
  }
  
  public d()
  {
    AppMethodBeat.i(26860);
    this.GWG = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(26859);
        if (Util.nullAsNil(paramAnonymousString).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
          new e(paramAnonymousMap).bnL();
        }
        AppMethodBeat.o(26859);
      }
    };
    AppMethodBeat.o(26860);
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(271852);
    nb localnb = new nb();
    localnb.gBe = aO(paramIntent);
    localnb.gWB = paramInt1;
    localnb.gXL = paramInt2;
    localnb.gXM = localnb.z("username", paramString, true);
    localnb.gTZ = localnb.z("TextStatusID", ((com.tencent.mm.plugin.textstatus.a.d)h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).getTextStatusId(paramString), true);
    localnb.bpa();
    AppMethodBeat.o(271852);
  }
  
  public static int aO(Intent paramIntent)
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
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a fpG()
  {
    AppMethodBeat.i(26861);
    h.aHE().aGH();
    if (fpH().GWF == null)
    {
      localObject = fpH();
      bh.beI();
      ((d)localObject).GWF = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(c.getDataDB());
    }
    Object localObject = fpH().GWF;
    AppMethodBeat.o(26861);
    return localObject;
  }
  
  private static d fpH()
  {
    AppMethodBeat.i(26862);
    bh.beC();
    d locald2 = (d)ch.RZ("plugin.profile");
    d locald1 = locald2;
    if (locald2 == null)
    {
      Log.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      locald1 = new d();
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
    ((v)h.ag(v.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.GWG);
    AppMethodBeat.o(26863);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26864);
    ((v)h.ag(v.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.GWG);
    AppMethodBeat.o(26864);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.d
 * JD-Core Version:    0.7.0.1
 */