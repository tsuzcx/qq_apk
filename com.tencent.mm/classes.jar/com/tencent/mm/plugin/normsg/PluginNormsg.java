package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.normsg.b.a.a;
import com.tencent.mm.plugin.normsg.b.a.c;
import com.tencent.mm.plugin.normsg.b.b.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class PluginNormsg
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, o, a
{
  private static final String mGE = b.mGA.Kd("\034:/-9+\n.\"0:41\r\"!");
  private static final String mGF = b.mGA.Kd("\005#64 2\004(,");
  private static final String mGG = b.mGA.Kd("");
  
  private void processUpdateCCEncryptKey(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get(b.mGA.Kd("k5>3,1$b\030>+)=/\016:6$. %\0316%s+-4"));
    if (bk.bl(str1))
    {
      y.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      return;
    }
    String str2 = Normsg.a.boF();
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      y.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
      h.nFQ.h(876L, 0L, 1L);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        y.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
        h.nFQ.h(876L, 1L, 1L);
        return;
      }
    }
    File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
      localf.ceg = false;
      localf.dlQ = str1;
      localf.field_fileType = com.tencent.mm.j.a.dlx;
      localf.field_fullpath = localFile.getAbsolutePath();
      localf.field_mediaId = str2;
      localf.allow_mobile_net_download = false;
      localf.dlU = true;
      localf.is_resume_task = false;
      localf.field_autostart = true;
      localf.dlR = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localf.dlS = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localf.dlP = new PluginNormsg.1(this, localFile, paramMap);
      com.tencent.mm.ak.f.Nd().b(localf, -1);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  private void processUpdateRqtSignKey(Map<String, String> paramMap, int paramInt)
  {
    String str1 = (String)paramMap.get(b.mGA.Kd("b<7:%8-k\0217\" 4&\020,(q++4"));
    if (bk.bl(str1))
    {
      y.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
      return;
    }
    String str2 = Normsg.a.vm(paramInt);
    if (str2 != null) {}
    for (paramMap = new File(str2); paramMap == null; paramMap = null)
    {
      y.e("MicroMsg.PluginNormsg", "urqtk: failure to get required path.");
      h.nFQ.h(876L, 27L, 1L);
      return;
    }
    if (!paramMap.exists())
    {
      localFile = paramMap.getParentFile();
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        y.e("MicroMsg.PluginNormsg", "urqtk: failure to create required path.");
        h.nFQ.h(876L, 28L, 1L);
        return;
      }
    }
    File localFile = new File(str2 + "_@tmp");
    if (localFile.exists()) {
      localFile.delete();
    }
    for (;;)
    {
      com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
      localf.ceg = false;
      localf.dlQ = str1;
      localf.field_fileType = com.tencent.mm.j.a.dlx;
      localf.field_fullpath = localFile.getAbsolutePath();
      localf.field_mediaId = str2;
      localf.allow_mobile_net_download = false;
      localf.dlU = true;
      localf.is_resume_task = false;
      localf.field_autostart = true;
      localf.dlR = ((int)TimeUnit.MINUTES.toSeconds(1L));
      localf.dlS = ((int)TimeUnit.MINUTES.toSeconds(10L));
      localf.dlP = new PluginNormsg.2(this, localFile, paramMap);
      com.tencent.mm.ak.f.Nd().b(localf, -1);
      return;
      localFile.getParentFile().mkdirs();
    }
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    com.tencent.mm.plugin.normsg.a.b.a(b.mGA);
  }
  
  public void dependency()
  {
    dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    dependsOn(com.tencent.mm.plugin.report.c.class);
    dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    dependsOn(p.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    alias(a.class);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    paramc = com.tencent.mm.plugin.normsg.b.a.boQ();
    com.tencent.mm.kernel.b.g localg = com.tencent.mm.kernel.g.DM().Dr();
    if (!a.c.isEnabled()) {
      y.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
    }
    for (;;)
    {
      ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a(mGE, this);
      return;
      int j = a.c.boW();
      int i = j;
      if (j <= 0) {
        i = 26;
      }
      if (Build.VERSION.SDK_INT > i) {
        y.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
      } else if (com.tencent.mm.plugin.normsg.b.a.mGN.contains(com.tencent.mm.plugin.normsg.b.a.Kf(localg.dIA))) {
        try
        {
          com.tencent.mm.plugin.normsg.b.b localb = com.tencent.mm.plugin.normsg.b.b.boY();
          localb.initialize(localg.bT);
          localb.ensureInitialized();
          localb.mHt.add(paramc);
          y.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
        }
        catch (b.f localf)
        {
          y.printErrStackTrace("MircoMsg.AEDHLP", localf, "[tomys] aed install failed.", new Object[0]);
          paramc.h(localf);
        }
      } else {
        y.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
      }
    }
  }
  
  public void onAccountRelease()
  {
    ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b(mGE, this);
  }
  
  public void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    y.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", new Object[] { paramString });
    if (mGE.equals(paramString)) {
      processUpdateCCEncryptKey(paramMap);
    }
    do
    {
      return;
      if (mGF.equals(paramString))
      {
        processUpdateRqtSignKey(paramMap, 0);
        return;
      }
    } while (!mGG.equals(paramString));
    processUpdateRqtSignKey(paramMap, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.PluginNormsg
 * JD-Core Version:    0.7.0.1
 */