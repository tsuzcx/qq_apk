package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.normsg.c.a.a;
import com.tencent.mm.plugin.normsg.c.a.c;
import com.tencent.mm.plugin.normsg.c.b.f;
import com.tencent.mm.plugin.normsg.c.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PluginNormsg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, q, a
{
  private static final String wtD;
  private static final String wtE;
  private static final String wtF;
  
  static
  {
    AppMethodBeat.i(149007);
    wtD = b.wty.atn("\034:/-9+\n.\"0:41\r\"!");
    wtE = b.wty.atn("\005#64 2\004(,");
    wtF = b.wty.atn("");
    AppMethodBeat.o(149007);
  }
  
  private void processUpdateCCEncryptKey(final Map<String, String> paramMap)
  {
    AppMethodBeat.i(149005);
    String str1 = (String)paramMap.get(b.wty.atn("k5>3,1$b\030>+)=/\016:6$. %\0316%s+-4"));
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(149005);
      return;
    }
    String str2 = c.p.ba(0);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ad.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
      com.tencent.mm.plugin.report.service.g.yhR.n(876L, 0L, 1L);
      AppMethodBeat.o(149005);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ad.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
        com.tencent.mm.plugin.report.service.g.yhR.n(876L, 1L, 1L);
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
      localg.fJi = "task_PluginNormsg_1";
      localg.dNR = false;
      localg.fJm = str1;
      localg.field_fileType = com.tencent.mm.i.a.fIK;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.fJq = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.fJn = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.fJo = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.fJj = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(148983);
          if (paramAnonymousInt == -21006)
          {
            ad.w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
            AppMethodBeat.o(148983);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ad.e("MicroMsg.PluginNormsg", "uccek: start failed : %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 3L, 1L);
            AppMethodBeat.o(148983);
            return 0;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode == 0) {
              break label156;
            }
            ad.e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
            if ((paramAnonymousc != null) && (paramAnonymousc.field_finishedLength > 0L))
            {
              ad.w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
              localFile.delete();
            }
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 4L, 1L);
          }
          for (;;)
          {
            AppMethodBeat.o(148983);
            return 0;
            label156:
            ad.i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
            localFile.renameTo(paramMap);
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 2L, 1L);
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      com.tencent.mm.ao.f.aGI().b(localg, -1);
      AppMethodBeat.o(149005);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  private void processUpdateRqtSignKey(final Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(149006);
    String str1 = (String)paramMap.get(b.wty.atn("b<7:%8-k\0217\" 4&\020,(q++4"));
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(149006);
      return;
    }
    String str2 = c.p.bb(paramInt);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ad.e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
      com.tencent.mm.plugin.report.service.g.yhR.n(876L, 27L, 1L);
      AppMethodBeat.o(149006);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ad.e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
        com.tencent.mm.plugin.report.service.g.yhR.n(876L, 28L, 1L);
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
      localg.fJi = "task_PluginNormsg_2";
      localg.dNR = false;
      localg.fJm = str1;
      localg.field_fileType = com.tencent.mm.i.a.fIK;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.fJq = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.fJn = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.fJo = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.fJj = new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(148984);
          if (paramAnonymousInt == -21006)
          {
            ad.w("MicroMsg.PluginNormsg", "urqtk: duplicate request to download meta, ignore this request.");
            AppMethodBeat.o(148984);
            return 0;
          }
          if (paramAnonymousInt != 0)
          {
            ad.e("MicroMsg.PluginNormsg", "urqtk: start failed : %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 30L, 1L);
            AppMethodBeat.o(148984);
            return 0;
          }
          if (paramAnonymousd != null)
          {
            if (paramAnonymousd.field_retCode == 0) {
              break label156;
            }
            ad.e("MicroMsg.PluginNormsg", "urqtk: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd });
            if ((paramAnonymousc != null) && (paramAnonymousc.field_finishedLength > 0L))
            {
              ad.w("MicroMsg.PluginNormsg", "urqtk: download interrupt, clear broken file.");
              localFile.delete();
            }
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 31L, 1L);
          }
          for (;;)
          {
            AppMethodBeat.o(148984);
            return 0;
            label156:
            ad.i("MicroMsg.PluginNormsg", "urqtk: cdn trans suceess.");
            localFile.renameTo(paramMap);
            com.tencent.mm.plugin.report.service.g.yhR.n(876L, 29L, 1L);
          }
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      };
      com.tencent.mm.ao.f.aGI().b(localg, -1);
      AppMethodBeat.o(149006);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(148987);
    com.tencent.mm.plugin.normsg.a.b.a(b.wty);
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "wc-msaid-init";
      }
      
      public final void run()
      {
        AppMethodBeat.i(148982);
        com.tencent.d.e.b.a.a.b.kT(aj.getContext());
        b localb = b.wty;
        com.tencent.mm.sdk.a.b.wC(b.duM());
        localb = b.wty;
        com.tencent.mm.sdk.a.b.wD(b.duN());
        localb = b.wty;
        com.tencent.mm.sdk.a.b.wE(b.duL());
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
    if (aj.cmR())
    {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
      dependsOn(r.class);
    }
    AppMethodBeat.o(148986);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(148985);
    alias(a.class);
    AppMethodBeat.o(148985);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(148988);
    paramc = com.tencent.mm.plugin.normsg.c.a.duY();
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.ajz().ajb();
    if (!a.c.isEnabled()) {
      ad.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a(wtD, this);
      j.start();
      AppMethodBeat.o(148988);
      return;
      int j = a.c.dvf();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        ad.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.c.a.wtP.contains(com.tencent.mm.plugin.normsg.c.a.fq(localg.mProcessName))) {
        try
        {
          com.tencent.mm.plugin.normsg.c.b localb = com.tencent.mm.plugin.normsg.c.b.dvh();
          localb.initialize(localg.ca);
          localb.ensureInitialized();
          localb.wuv.add(paramc);
          ad.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
        }
        catch (b.f localf)
        {
          ad.printErrStackTrace("MircoMsg.AEDHLP", localf, "[tomys] aed install failed.", new Object[0]);
          paramc.l(localf);
        }
      } else {
        ad.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(148989);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b(wtD, this);
    j.stop();
    AppMethodBeat.o(148989);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(148990);
    ad.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", new Object[] { paramString });
    if (wtD.equals(paramString))
    {
      processUpdateCCEncryptKey(paramMap);
      AppMethodBeat.o(148990);
      return;
    }
    if (wtE.equals(paramString))
    {
      processUpdateRqtSignKey(paramMap, 0);
      AppMethodBeat.o(148990);
      return;
    }
    if (wtF.equals(paramString)) {
      processUpdateRqtSignKey(paramMap, 1);
    }
    AppMethodBeat.o(148990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */