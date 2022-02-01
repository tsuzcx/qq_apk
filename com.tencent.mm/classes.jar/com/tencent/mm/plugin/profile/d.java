package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.qj;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.profile.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storagebase.h.b;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements be
{
  private static au MUt;
  private static Boolean MUu;
  private static Boolean MUv;
  private static HashMap<Integer, h.b> baseDBFactories;
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a MUs;
  private t MUw;
  
  static
  {
    AppMethodBeat.i(26866);
    baseDBFactories = new HashMap();
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    baseDBFactories.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new d.1());
    MUu = null;
    MUv = null;
    AppMethodBeat.o(26866);
  }
  
  public d()
  {
    AppMethodBeat.i(26860);
    this.MUw = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(305371);
        if (Util.nullAsNil(paramAnonymousString).equals("NewXmlOpenIMFriReqAcceptedInWxWork")) {
          new e(paramAnonymousMap).bLy();
        }
        AppMethodBeat.o(305371);
      }
    };
    AppMethodBeat.o(26860);
  }
  
  public static void al(au paramau)
  {
    AppMethodBeat.i(305400);
    if ((MUt == null) || (paramau == null) || (!MUt.field_username.equals(paramau.field_username)))
    {
      MUu = null;
      MUv = null;
    }
    MUt = paramau;
    AppMethodBeat.o(305400);
  }
  
  public static void b(Intent paramIntent, final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(305414);
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        long l3 = 0L;
        long l2 = 2L;
        AppMethodBeat.i(305373);
        qj localqj = new qj();
        localqj.iOd = d.bo(d.this);
        localqj.jrM = d.this.getIntExtra("CONTACT_INFO_UI_SUB_SOURCE", 0);
        localqj.jql = paramInt1;
        localqj.jrK = paramInt2;
        localqj.iqX = localqj.F("username", paramString, true);
        localqj.jmP = localqj.F("TextStatusID", ((f)com.tencent.mm.kernel.h.az(f.class)).getTextStatusId(paramString), true);
        if (d.this.getIntExtra("key_label_click_source", 0) > 0) {
          localqj.iOd = 22L;
        }
        if ((d.gAT() != null) && (d.gAT().field_username.equals(paramString)))
        {
          if (d.gAU() != null) {
            break label260;
          }
          l1 = 0L;
          localqj.jrN = l1;
          if (d.gAV() != null) {
            break label282;
          }
          l1 = 0L;
          label182:
          localqj.jrO = l1;
          if (!Util.isNullOrNil(d.gAT().signature)) {
            break label304;
          }
          l1 = 2L;
          label204:
          localqj.iyP = l1;
          if (d.gAT().sex != 0) {
            break label309;
          }
          l1 = l3;
          label222:
          localqj.jrP = l1;
          if (!Util.isNullOrNil(d.gAT().signature)) {
            break label331;
          }
        }
        label260:
        label282:
        label304:
        label309:
        label331:
        for (long l1 = l2;; l1 = 1L)
        {
          localqj.iyP = l1;
          localqj.bMH();
          AppMethodBeat.o(305373);
          return;
          if (d.gAU().booleanValue() == true)
          {
            l1 = 1L;
            break;
          }
          l1 = 2L;
          break;
          if (d.gAV().booleanValue() == true)
          {
            l1 = 1L;
            break label182;
          }
          l1 = 2L;
          break label182;
          l1 = 1L;
          break label204;
          if (d.gAT().sex == 1)
          {
            l1 = 1L;
            break label222;
          }
          l1 = 2L;
          break label222;
        }
      }
    }, 100L);
    AppMethodBeat.o(305414);
  }
  
  public static int bo(Intent paramIntent)
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
  
  public static void cC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(305405);
    if ((MUt != null) && (MUt.field_username.equals(paramString))) {
      MUu = Boolean.valueOf(paramBoolean);
    }
    AppMethodBeat.o(305405);
  }
  
  public static void cD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(305409);
    if ((MUt != null) && (MUt.field_username.equals(paramString))) {
      MUv = Boolean.valueOf(paramBoolean);
    }
    AppMethodBeat.o(305409);
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a gAR()
  {
    AppMethodBeat.i(26861);
    com.tencent.mm.kernel.h.baC().aZJ();
    if (gAS().MUs == null)
    {
      localObject = gAS();
      bh.bCz();
      ((d)localObject).MUs = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(c.getDataDB());
    }
    Object localObject = gAS().MUs;
    AppMethodBeat.o(26861);
    return localObject;
  }
  
  private static d gAS()
  {
    AppMethodBeat.i(26862);
    bh.bCt();
    d locald2 = (d)ci.Ka("plugin.profile");
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
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("NewXmlOpenIMFriReqAcceptedInWxWork", this.MUw);
    AppMethodBeat.o(26863);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(26864);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("NewXmlOpenIMFriReqAcceptedInWxWork", this.MUw);
    AppMethodBeat.o(26864);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.d
 * JD-Core Version:    0.7.0.1
 */