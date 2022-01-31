package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.normsg.b.a.a;
import com.tencent.mm.plugin.normsg.b.a.c;
import com.tencent.mm.plugin.normsg.b.b.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PluginNormsg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, o, a
{
  private static final String pgK;
  private static final String pgL;
  private static final String pgM;
  
  static
  {
    AppMethodBeat.i(10360);
    pgK = b.pgG.Wd("\034:/-9+\n.\"0:41\r\"!");
    pgL = b.pgG.Wd("\005#64 2\004(,");
    pgM = b.pgG.Wd("");
    AppMethodBeat.o(10360);
  }
  
  private void processUpdateCCEncryptKey(Map<String, String> paramMap)
  {
    AppMethodBeat.i(10358);
    String str1 = (String)paramMap.get(b.pgG.Wd("k5>3,1$b\030>+)=/\016:6$. %\0316%s+-4"));
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(10358);
      return;
    }
    String str2 = Normsg.a.bXg();
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ab.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
      h.qsU.j(876L, 0L, 1L);
      AppMethodBeat.o(10358);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ab.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
        h.qsU.j(876L, 1L, 1L);
        AppMethodBeat.o(10358);
        return;
      }
    }
    File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.cMU = false;
      localg.eds = str1;
      localg.field_fileType = com.tencent.mm.i.a.ecS;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.edw = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.edt = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.edu = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.edp = new PluginNormsg.1(this, localFile, paramMap);
      com.tencent.mm.al.f.afO().b(localg, -1);
      AppMethodBeat.o(10358);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  private void processUpdateRqtSignKey(Map<String, String> paramMap, int paramInt)
  {
    AppMethodBeat.i(10359);
    String str1 = (String)paramMap.get(b.pgG.Wd("b<7:%8-k\0217\" 4&\020,(q++4"));
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      AppMethodBeat.o(10359);
      return;
    }
    String str2 = Normsg.a.AK(paramInt);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      ab.e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
      h.qsU.j(876L, 27L, 1L);
      AppMethodBeat.o(10359);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        ab.e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
        h.qsU.j(876L, 28L, 1L);
        AppMethodBeat.o(10359);
        return;
      }
    }
    File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.cMU = false;
      localg.eds = str1;
      localg.field_fileType = com.tencent.mm.i.a.ecS;
      localg.field_fullpath = localFile.getAbsolutePath();
      localg.field_mediaId = str2;
      localg.allow_mobile_net_download = false;
      localg.edw = true;
      localg.is_resume_task = false;
      localg.field_autostart = true;
      localg.edt = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localg.edu = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localg.edp = new PluginNormsg.2(this, localFile, paramMap);
      com.tencent.mm.al.f.afO().b(localg, -1);
      AppMethodBeat.o(10359);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10354);
    com.tencent.mm.plugin.normsg.a.b.a(b.pgG);
    AppMethodBeat.o(10354);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(10353);
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(p.class);
    AppMethodBeat.o(10353);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(10352);
    alias(a.class);
    AppMethodBeat.o(10352);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(10355);
    paramc = com.tencent.mm.plugin.normsg.b.a.bXr();
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.RI().Rj();
    if (!a.c.isEnabled()) {
      ab.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a(pgK, this);
      AppMethodBeat.o(10355);
      return;
      int j = a.c.bXy();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        ab.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.b.a.pgT.contains(com.tencent.mm.plugin.normsg.b.a.Wf(localg.mProcessName))) {
        try
        {
          com.tencent.mm.plugin.normsg.b.b localb = com.tencent.mm.plugin.normsg.b.b.bXA();
          localb.initialize(localg.bX);
          localb.ensureInitialized();
          localb.phz.add(paramc);
          ab.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
        }
        catch (b.f localf)
        {
          ab.printErrStackTrace("MircoMsg.AEDHLP", localf, "[tomys] aed install failed.", new Object[0]);
          paramc.j(localf);
        }
      } else {
        ab.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
      }
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(10356);
    ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b(pgK, this);
    AppMethodBeat.o(10356);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(10357);
    ab.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", new Object[] { paramString });
    if (pgK.equals(paramString))
    {
      processUpdateCCEncryptKey(paramMap);
      AppMethodBeat.o(10357);
      return;
    }
    if (pgL.equals(paramString))
    {
      processUpdateRqtSignKey(paramMap, 0);
      AppMethodBeat.o(10357);
      return;
    }
    if (pgM.equals(paramString)) {
      processUpdateRqtSignKey(paramMap, 1);
    }
    AppMethodBeat.o(10357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */