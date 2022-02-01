package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.normsg.c.q;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.normsg.c.a.a;
import com.tencent.mm.plugin.normsg.c.a.c;
import com.tencent.mm.plugin.normsg.c.b.f;
import com.tencent.mm.plugin.normsg.c.j;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PluginNormsg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.normsg.a, p, a
{
  private static final String vol;
  private static final String vom;
  private static final String von;
  
  static
  {
    AppMethodBeat.i(149007);
    vol = b.vog.aon("\034:/-9+\n.\"0:41\r\"!");
    vom = b.vog.aon("\005#64 2\004(,");
    von = b.vog.aon("");
    AppMethodBeat.o(149007);
  }
  
  private void processUpdateCCEncryptKey(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(149005);
    String str1 = (String)paramMap.get(b.vog.aon("k5>3,1$b\030>+)=/\016:6$. %\0316%s+-4"));
    if (bs.isNullOrNil(str1))
    {
      ac.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(149005);
      return;
    }
    String str2 = c.p.ba(0);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ac.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
      com.tencent.mm.plugin.report.service.h.wUl.n(876L, 0L, 1L);
      AppMethodBeat.o(149005);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ac.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
        com.tencent.mm.plugin.report.service.h.wUl.n(876L, 1L, 1L);
        AppMethodBeat.o(149005);
        return;
      }
    }
    final File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.dBE = false;
      localg.fre = str1;
      localg.field_fileType = com.tencent.mm.i.a.fqD;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.fri = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.frf = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.frg = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.frb = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(148983);
          if (paramAnonymousInt == -21006)
          {
            ac.w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
            AppMethodBeat.o(148983);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ac.e("MicroMsg.PluginNormsg", "uccek: start failed : %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 3L, 1L);
            AppMethodBeat.o(148983);
            return 0;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode == 0) {
              break label156;
            }
            ac.e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
            if ((paramAnonymousc != null) && (paramAnonymousc.field_finishedLength > 0L))
            {
              ac.w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
              localFile.delete();
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 4L, 1L);
          }
          for (;;)
          {
            AppMethodBeat.o(148983);
            return 0;
            label156:
            ac.i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
            localFile.renameTo(paramMap);
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 2L, 1L);
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      com.tencent.mm.an.f.aDD().b(localg, -1);
      AppMethodBeat.o(149005);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  private void processUpdateRqtSignKey(final Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(149006);
    String str1 = (String)paramMap.get(b.vog.aon("b<7:%8-k\0217\" 4&\020,(q++4"));
    if (bs.isNullOrNil(str1))
    {
      ac.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(149006);
      return;
    }
    String str2 = c.p.bb(paramInt);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ac.e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
      com.tencent.mm.plugin.report.service.h.wUl.n(876L, 27L, 1L);
      AppMethodBeat.o(149006);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ac.e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
        com.tencent.mm.plugin.report.service.h.wUl.n(876L, 28L, 1L);
        AppMethodBeat.o(149006);
        return;
      }
    }
    final File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.dBE = false;
      localg.fre = str1;
      localg.field_fileType = com.tencent.mm.i.a.fqD;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.fri = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.frf = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.frg = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.frb = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(148984);
          if (paramAnonymousInt == -21006)
          {
            ac.w("MicroMsg.PluginNormsg", "urqtk: duplicate request to download meta, ignore this request.");
            AppMethodBeat.o(148984);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ac.e("MicroMsg.PluginNormsg", "urqtk: start failed : %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 30L, 1L);
            AppMethodBeat.o(148984);
            return 0;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode == 0) {
              break label156;
            }
            ac.e("MicroMsg.PluginNormsg", "urqtk: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
            if ((paramAnonymousc != null) && (paramAnonymousc.field_finishedLength > 0L))
            {
              ac.w("MicroMsg.PluginNormsg", "urqtk: download interrupt, clear broken file.");
              localFile.delete();
            }
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 31L, 1L);
          }
          for (;;)
          {
            AppMethodBeat.o(148984);
            return 0;
            label156:
            ac.i("MicroMsg.PluginNormsg", "urqtk: cdn trans suceess.");
            localFile.renameTo(paramMap);
            com.tencent.mm.plugin.report.service.h.wUl.n(876L, 29L, 1L);
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      com.tencent.mm.an.f.aDD().b(localg, -1);
      AppMethodBeat.o(149006);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(148987);
    c.q.c0(this);
    com.tencent.mm.plugin.normsg.a.b.a(b.vog);
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "wc-msaid-init";
      }
      
      public final void run()
      {
        AppMethodBeat.i(148982);
        b.vog.getOAID();
        b localb = b.vog;
        com.tencent.mm.sdk.a.b.vQ(b.dkA());
        localb = b.vog;
        com.tencent.mm.sdk.a.b.vR(b.dkB());
        localb = b.vog;
        com.tencent.mm.sdk.a.b.vS(b.dkz());
        AppMethodBeat.o(148982);
      }
    });
    AppMethodBeat.o(148987);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(148986);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    if (ai.cin())
    {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
      dependsOn(com.tencent.mm.plugin.messenger.foundation.a.q.class);
    }
    AppMethodBeat.o(148986);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public String getAPKName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(149004);
    paramContext = bs.nullAsNil(NormsgDataProvider.getAPKName(paramContext, paramString));
    AppMethodBeat.o(149004);
    return paramContext;
  }
  
  public byte[] getByteFromMMKV(String paramString)
  {
    AppMethodBeat.i(149001);
    paramString = aw.aKT(new StringBuilder("atadtsurt_").reverse().toString()).decodeBytes(paramString);
    AppMethodBeat.o(149001);
    return paramString;
  }
  
  public String getDeviceId()
  {
    AppMethodBeat.i(148999);
    String str = com.tencent.mm.compatible.deviceinfo.q.XX();
    AppMethodBeat.o(148999);
    return str;
  }
  
  public long getLuckyPackTASCount()
  {
    AppMethodBeat.i(148992);
    long l = com.tencent.mm.plugin.normsg.c.a.dkH().dkI();
    AppMethodBeat.o(148992);
    return l;
  }
  
  public String getOAID()
  {
    AppMethodBeat.i(149003);
    String str = b.vog.getOAID();
    AppMethodBeat.o(149003);
    return str;
  }
  
  public boolean getPhoneState(Context paramContext)
  {
    AppMethodBeat.i(206474);
    boolean bool = NormsgDataProvider.getPhoneState(paramContext);
    AppMethodBeat.o(206474);
    return bool;
  }
  
  public String getRiskScanDataBase64()
  {
    AppMethodBeat.i(148991);
    String str2 = "";
    Object localObject = com.tencent.mm.lib.riskscanner.a.a.cr(ai.getContext());
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((Bundle)localObject).getInt("errCode", -100) == 0)
      {
        localObject = ((Bundle)localObject).getByteArray("reqBufferBase64");
        str1 = str2;
        if (localObject != null) {
          str1 = Base64.encodeToString((byte[])localObject, 2);
        }
      }
    }
    AppMethodBeat.o(148991);
    return str1;
  }
  
  public String getSoterId()
  {
    AppMethodBeat.i(148996);
    String str = com.tencent.mm.plugin.soter.d.d.dTq().znE;
    if (str != null)
    {
      AppMethodBeat.o(148996);
      return str;
    }
    AppMethodBeat.o(148996);
    return "";
  }
  
  public String getSoterUid()
  {
    AppMethodBeat.i(148998);
    String str = com.tencent.mm.plugin.soter.d.d.dTq().znF;
    if (str != null)
    {
      AppMethodBeat.o(148998);
      return str;
    }
    AppMethodBeat.o(148998);
    return "";
  }
  
  public void installed()
  {
    AppMethodBeat.i(148985);
    alias(a.class);
    AppMethodBeat.o(148985);
  }
  
  public boolean isUSBConnected()
  {
    AppMethodBeat.i(148997);
    boolean bool = j.isConnected();
    AppMethodBeat.o(148997);
    return bool;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(148988);
    paramc = com.tencent.mm.plugin.normsg.c.a.dkH();
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.agO().agp();
    if (!a.c.isEnabled()) {
      ac.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a(vol, this);
      j.start();
      AppMethodBeat.o(148988);
      return;
      int j = a.c.dkO();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        ac.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.c.a.vow.contains(com.tencent.mm.plugin.normsg.c.a.ev(localg.mProcessName))) {
        try
        {
          com.tencent.mm.plugin.normsg.c.b localb = com.tencent.mm.plugin.normsg.c.b.dkQ();
          localb.initialize(localg.ca);
          localb.ensureInitialized();
          localb.vpc.add(paramc);
          ac.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
        }
        catch (b.f localf)
        {
          ac.printErrStackTrace("MircoMsg.AEDHLP", localf, "[tomys] aed install failed.", new Object[0]);
          paramc.k(localf);
        }
      } else {
        ac.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148989);
    ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b(vol, this);
    j.stop();
    AppMethodBeat.o(148989);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(148990);
    ac.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", new Object[] { paramString });
    if (vol.equals(paramString))
    {
      processUpdateCCEncryptKey(paramMap);
      AppMethodBeat.o(148990);
      return;
    }
    if (vom.equals(paramString))
    {
      processUpdateRqtSignKey(paramMap, 0);
      AppMethodBeat.o(148990);
      return;
    }
    if (von.equals(paramString)) {
      processUpdateRqtSignKey(paramMap, 1);
    }
    AppMethodBeat.o(148990);
  }
  
  public boolean putByteToMMKV(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149000);
    aw localaw = aw.aKT(new StringBuilder("atadtsurt_").reverse().toString());
    if (!localaw.encode(paramString, paramArrayOfByte))
    {
      AppMethodBeat.o(149000);
      return false;
    }
    boolean bool = localaw.commit();
    AppMethodBeat.o(149000);
    return bool;
  }
  
  public void removeFromMMKV(String paramString)
  {
    AppMethodBeat.i(149002);
    aw.aKT(new StringBuilder("atadtsurt_").reverse().toString()).remove(paramString).commit();
    AppMethodBeat.o(149002);
  }
  
  public void reportGroupedIdKey(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148995);
    com.tencent.mm.plugin.report.service.h.wUl.c(paramInt1, paramInt2, paramInt3, paramInt4, true);
    AppMethodBeat.o(148995);
  }
  
  public void reportIdKey(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148994);
    com.tencent.mm.plugin.report.service.h.wUl.n(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(148994);
  }
  
  public void reportKVStat(int paramInt, String paramString)
  {
    AppMethodBeat.i(148993);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(paramInt, paramString);
    AppMethodBeat.o(148993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */