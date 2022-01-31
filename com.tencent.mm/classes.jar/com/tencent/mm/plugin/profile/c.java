package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class c
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a pxD;
  private o pxE;
  
  static
  {
    AppMethodBeat.i(23250);
    baseDBFactories = new HashMap();
    b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new c.1());
    AppMethodBeat.o(23250);
  }
  
  public c()
  {
    AppMethodBeat.i(23244);
    this.pxE = new c.2(this);
    AppMethodBeat.o(23244);
  }
  
  public static int al(Intent paramIntent)
  {
    AppMethodBeat.i(23249);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
      ab.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:".concat(String.valueOf(i)));
      AppMethodBeat.o(23249);
      return i;
    }
    AppMethodBeat.o(23249);
    return 0;
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a cbF()
  {
    AppMethodBeat.i(23245);
    g.RJ().QQ();
    if (cbG().pxD == null)
    {
      localObject = cbG();
      aw.aaz();
      ((c)localObject).pxD = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(com.tencent.mm.model.c.Rq());
    }
    Object localObject = cbG().pxD;
    AppMethodBeat.o(23245);
    return localObject;
  }
  
  private static c cbG()
  {
    AppMethodBeat.i(23246);
    aw.aat();
    c localc2 = (c)bw.pF("plugin.profile");
    c localc1 = localc2;
    if (localc2 == null)
    {
      ab.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      localc1 = new c();
      aw.aat().a("plugin.freewifi", localc1);
    }
    AppMethodBeat.o(23246);
    return localc1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23247);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.pxE);
    AppMethodBeat.o(23247);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23248);
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.pxE);
    AppMethodBeat.o(23248);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.c
 * JD-Core Version:    0.7.0.1
 */