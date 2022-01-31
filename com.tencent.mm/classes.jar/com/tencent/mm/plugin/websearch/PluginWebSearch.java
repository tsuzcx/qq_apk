package com.tencent.mm.plugin.websearch;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.nc;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import junit.framework.Assert;

public class PluginWebSearch
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.d> btR = new HashMap();
  private com.tencent.mm.sdk.b.c fjE = new PluginWebSearch.4(this);
  private com.tencent.mm.sdk.b.c haG = new PluginWebSearch.5(this);
  private final com.tencent.mm.sdk.b.c iWo = new PluginWebSearch.2(this);
  private o pCS = new PluginWebSearch.6(this);
  private b qTb;
  private c qTc;
  
  static
  {
    String str = i.a(com.tencent.mm.plugin.websearch.widget.a.a.buS, "WidgetSafeMode");
    btR.put(Integer.valueOf("WidgetSafeMode".hashCode()), new PluginWebSearch.1(new String[] { str }));
  }
  
  public static boolean checkTopStoryTemplateFolderValid()
  {
    boolean bool = true;
    com.tencent.mm.vfs.b localb2 = new com.tencent.mm.vfs.b(aa.Bw(1));
    if ((!localb2.exists()) || (!localb2.isDirectory())) {
      bool = false;
    }
    com.tencent.mm.vfs.b localb1;
    do
    {
      return bool;
      localb1 = new com.tencent.mm.vfs.b(localb2, aa.bZq());
      localb2 = new com.tencent.mm.vfs.b(localb2, aa.bZr());
    } while ((localb1.exists()) && (localb2.exists()));
    return false;
  }
  
  private void copyTemplateFile(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 1;
    tmp11_7;
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = aa.Bw(arrayOfInt[i]);
      i += 1;
    }
    Assert.assertEquals(2, 2);
    i = 0;
    if (i < 2)
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(arrayOfString[i]);
      y.i("MicroMsg.WebSearch.PluginWebSearch", "copy to path %s, type %d", new Object[] { com.tencent.mm.vfs.j.n(localb.cLr()), Integer.valueOf(arrayOfInt[i]) });
      aa.Bv(arrayOfInt[i]);
      int j = aa.Bs(arrayOfInt[i]);
      if (paramBoolean)
      {
        int k = aa.Bq(arrayOfInt[i]);
        y.i("MicroMsg.WebSearch.PluginWebSearch", "need update assetVersion=%d currentVersion=%d type=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(arrayOfInt[i]) });
        if (j < k)
        {
          com.tencent.mm.vfs.e.K(com.tencent.mm.vfs.j.n(localb.mUri), true);
          aa.a(localb, arrayOfInt[i]);
        }
      }
      for (;;)
      {
        if ((arrayOfInt[i] == 0) && (!aa.Bp(arrayOfInt[i])))
        {
          y.i("MicroMsg.WebSearch.PluginWebSearch", "copyTemplateFile check md5 fail, try once");
          com.tencent.mm.vfs.e.K(com.tencent.mm.vfs.j.n(localb.mUri), true);
          aa.a(localb, arrayOfInt[i], true);
        }
        i += 1;
        break;
        if ((j == 1) || (aa.bZy()))
        {
          y.i("MicroMsg.WebSearch.PluginWebSearch", "need init template");
          com.tencent.mm.vfs.e.K(com.tencent.mm.vfs.j.n(localb.mUri), true);
          aa.a(localb, arrayOfInt[i]);
        }
        else
        {
          y.i("MicroMsg.WebSearch.PluginWebSearch", "currentVersion=%d", new Object[] { Integer.valueOf(j) });
        }
      }
    }
    com.tencent.mm.vfs.e.K(com.tencent.mm.vfs.j.n(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.bkH, "fts").mUri), true);
  }
  
  private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b paramb, int paramInt)
  {
    initTemplateFoldByResUpdate(paramb, paramInt, false);
  }
  
  private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b paramb, int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    label80:
    int j;
    for (;;)
    {
      Object localObject2 = "";
      localObject1 = "";
      int i = -1;
      switch (paramInt)
      {
      }
      while ((bk.bl((String)localObject2)) || (bk.bl((String)localObject1)))
      {
        y.w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.vfs.j.n(paramb.cLr()) });
        return;
        localObject2 = aa.Bw(0);
        localObject1 = aa.Bu(0);
        i = 0;
        continue;
        localObject2 = aa.Bw(1);
        localObject1 = aa.Bu(1);
        i = 1;
      }
      localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
      com.tencent.mm.vfs.e.K(com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject2).mUri), true);
      ((com.tencent.mm.vfs.b)localObject2).mkdirs();
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject2, ".nomedia");
      if (!localb.exists()) {}
      try
      {
        localb.createNewFile();
        localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
        com.tencent.mm.vfs.e.r(com.tencent.mm.vfs.j.n(paramb.cLr()), com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr()));
        j = bk.gh(com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr()), ((com.tencent.mm.vfs.b)localObject1).getParent());
        if (j < 0)
        {
          y.e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + j + ", zipFilePath = " + com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject1).cLr()) + ", unzipPath = " + ((com.tencent.mm.vfs.b)localObject1).getParent());
          if ((paramBoolean) || (i != 0) || (aa.Bp(i))) {
            break label80;
          }
          y.i("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate fail, try again , ftsTemplateFolder %s, type %d", new Object[] { localObject2, Integer.valueOf(i) });
          paramBoolean = true;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", localIOException, "create nomedia file error", new Object[0]);
        }
        switch (paramInt)
        {
        default: 
          j = 1;
        }
      }
    }
    for (;;)
    {
      nc localnc = new nc();
      com.tencent.mm.sdk.b.a.udP.m(localnc);
      y.i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", new Object[] { ((com.tencent.mm.vfs.b)localObject1).getParent(), Integer.valueOf(j) });
      break;
      aa.Bv(0);
      j = aa.Bs(0);
      continue;
      aa.Bv(1);
      j = aa.Bs(1);
    }
  }
  
  private static void reportIdKey649ForLook(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2) {
      ao.BG(paramInt2);
    }
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return btR;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    super.configure(paramg);
    this.qTb = new b();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.b.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(this.qTb));
    com.tencent.mm.kernel.g.a(n.class, new com.tencent.mm.kernel.c.e(new d()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex())
    {
      this.qTc = new c();
      com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.qTc));
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    super.installed();
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    this.fjE.cqo();
    this.haG.cqo();
    this.iWo.cqo();
    c.init();
    com.tencent.mm.sdk.f.e.post(new PluginWebSearch.a(this, paramc.dKL), "CopySearchTemplateTask");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.pCS);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {
      com.tencent.mm.kernel.g.DS().k(new PluginWebSearch.3(this), 2000L);
    }
  }
  
  public void onAccountRelease()
  {
    this.fjE.dead();
    this.haG.dead();
    this.iWo.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.pCS);
    com.tencent.mm.plugin.websearch.api.ai.qUx = null;
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */