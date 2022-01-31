package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.HashMap;
import junit.framework.Assert;

public class PluginWebSearch
  extends f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c
{
  private static HashMap<Integer, h.d> bVb;
  private final com.tencent.mm.sdk.b.c checkLanguageChangeIListener;
  private com.tencent.mm.sdk.b.c gAV;
  private com.tencent.mm.sdk.b.c iJi;
  private o teE;
  private a uIi;
  private b uIj;
  
  static
  {
    AppMethodBeat.i(91329);
    bVb = new HashMap();
    String str = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.websearch.widget.a.a.info, "WidgetSafeMode");
    bVb.put(Integer.valueOf("WidgetSafeMode".hashCode()), new PluginWebSearch.1(new String[] { str }));
    AppMethodBeat.o(91329);
  }
  
  public PluginWebSearch()
  {
    AppMethodBeat.i(91316);
    this.checkLanguageChangeIListener = new com.tencent.mm.sdk.b.c() {};
    this.gAV = new PluginWebSearch.4(this);
    this.iJi = new PluginWebSearch.5(this);
    this.teE = new PluginWebSearch.6(this);
    AppMethodBeat.o(91316);
  }
  
  public static boolean checkTopStoryTemplateFolderValid()
  {
    AppMethodBeat.i(91325);
    com.tencent.mm.vfs.b localb2 = new com.tencent.mm.vfs.b(aa.Jk(1));
    if ((!localb2.exists()) || (!localb2.isDirectory()))
    {
      AppMethodBeat.o(91325);
      return false;
    }
    com.tencent.mm.vfs.b localb1 = new com.tencent.mm.vfs.b(localb2, aa.cZl());
    localb2 = new com.tencent.mm.vfs.b(localb2, aa.cZm());
    if ((localb1.exists()) && (localb2.exists()))
    {
      AppMethodBeat.o(91325);
      return true;
    }
    AppMethodBeat.o(91325);
    return false;
  }
  
  private void copyTemplateFile(boolean paramBoolean)
  {
    AppMethodBeat.i(91321);
    int[] arrayOfInt = new int[2];
    int[] tmp12_10 = arrayOfInt;
    tmp12_10[0] = 0;
    int[] tmp16_12 = tmp12_10;
    tmp16_12[1] = 1;
    tmp16_12;
    String[] arrayOfString = new String[2];
    int i = 0;
    while (i < 2)
    {
      arrayOfString[i] = aa.Jk(arrayOfInt[i]);
      i += 1;
    }
    Assert.assertEquals(2, 2);
    i = 0;
    if (i < 2)
    {
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(arrayOfString[i]);
      ab.i("MicroMsg.WebSearch.PluginWebSearch", "copy to path %s, type %d", new Object[] { com.tencent.mm.vfs.j.p(localb.dQJ()), Integer.valueOf(arrayOfInt[i]) });
      aa.Jj(arrayOfInt[i]);
      int j = aa.Jf(arrayOfInt[i]);
      if (paramBoolean)
      {
        int k = aa.Jd(arrayOfInt[i]);
        ab.i("MicroMsg.WebSearch.PluginWebSearch", "need update assetVersion=%d currentVersion=%d type=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(arrayOfInt[i]) });
        if (j < k)
        {
          com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(localb.mUri), true);
          aa.a(localb, arrayOfInt[i]);
        }
      }
      for (;;)
      {
        if ((arrayOfInt[i] == 0) && (!aa.Jc(arrayOfInt[i])))
        {
          ab.i("MicroMsg.WebSearch.PluginWebSearch", "copyTemplateFile check md5 fail, try once");
          com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(localb.mUri), true);
          aa.a(localb, arrayOfInt[i], true);
        }
        i += 1;
        break;
        if ((j == 1) || (aa.cZu()))
        {
          ab.i("MicroMsg.WebSearch.PluginWebSearch", "need init template");
          com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(localb.mUri), true);
          aa.a(localb, arrayOfInt[i]);
        }
        else
        {
          ab.i("MicroMsg.WebSearch.PluginWebSearch", "currentVersion=%d", new Object[] { Integer.valueOf(j) });
        }
      }
    }
    com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.eQz, "fts").mUri), true);
    AppMethodBeat.o(91321);
  }
  
  private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b paramb, int paramInt)
  {
    AppMethodBeat.i(91322);
    initTemplateFoldByResUpdate(paramb, paramInt, false);
    AppMethodBeat.o(91322);
  }
  
  private void initTemplateFoldByResUpdate(com.tencent.mm.vfs.b paramb, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91323);
    for (;;)
    {
      Object localObject2 = "";
      Object localObject1 = "";
      int i = -1;
      switch (paramInt)
      {
      }
      while ((bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject1)))
      {
        ab.w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.vfs.j.p(paramb.dQJ()) });
        AppMethodBeat.o(91323);
        return;
        localObject2 = aa.Jk(0);
        localObject1 = aa.Ji(0);
        i = 0;
        continue;
        localObject2 = aa.Jk(1);
        localObject1 = aa.Ji(1);
        i = 1;
      }
      localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
      com.tencent.mm.vfs.e.O(com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject2).mUri), true);
      ((com.tencent.mm.vfs.b)localObject2).mkdirs();
      com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b((com.tencent.mm.vfs.b)localObject2, ".nomedia");
      if (!localb.exists()) {}
      try
      {
        localb.createNewFile();
        localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
        com.tencent.mm.vfs.e.C(com.tencent.mm.vfs.j.p(paramb.dQJ()), com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()));
        j = bo.ii(com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()), ((com.tencent.mm.vfs.b)localObject1).getParent());
        if (j < 0)
        {
          ab.e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + j + ", zipFilePath = " + com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject1).dQJ()) + ", unzipPath = " + ((com.tencent.mm.vfs.b)localObject1).getParent());
          if ((paramBoolean) || (i != 0) || (aa.Jc(i))) {
            break label458;
          }
          ab.i("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate fail, try again , ftsTemplateFolder %s, type %d", new Object[] { localObject2, Integer.valueOf(i) });
          paramBoolean = true;
        }
      }
      catch (IOException localIOException)
      {
        int j;
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", localIOException, "create nomedia file error", new Object[0]);
        }
        switch (paramInt)
        {
        default: 
          j = 1;
        }
        for (;;)
        {
          nz localnz = new nz();
          com.tencent.mm.sdk.b.a.ymk.l(localnz);
          ab.i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", new Object[] { ((com.tencent.mm.vfs.b)localObject1).getParent(), Integer.valueOf(j) });
          break;
          aa.Jj(0);
          j = aa.Jf(0);
          continue;
          aa.Jj(1);
          j = aa.Jf(1);
        }
        label458:
        AppMethodBeat.o(91323);
      }
    }
  }
  
  private static void reportIdKey649ForLook(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91324);
    if (paramInt1 == 2) {
      an.Jw(paramInt2);
    }
    AppMethodBeat.o(91324);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return bVb;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(91318);
    super.configure(paramg);
    this.uIi = new a();
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.b.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.j.class, new com.tencent.mm.kernel.c.e(this.uIi));
    com.tencent.mm.kernel.g.a(n.class, new com.tencent.mm.kernel.c.e(new c()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.b()));
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.p.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.websearch.widget.c()));
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD())
    {
      this.uIj = new b();
      com.tencent.mm.kernel.g.a(m.class, new com.tencent.mm.kernel.c.e(this.uIj));
    }
    AppMethodBeat.o(91318);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void installed()
  {
    AppMethodBeat.i(91317);
    super.installed();
    AppMethodBeat.o(91317);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(91319);
    this.gAV.alive();
    this.iJi.alive();
    this.checkLanguageChangeIListener.alive();
    b.init();
    com.tencent.mm.sdk.g.d.post(new PluginWebSearch.a(this, paramc.eIj), "CopySearchTemplateTask");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.teE);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).SD()) {
      com.tencent.mm.kernel.g.RO().o(new PluginWebSearch.3(this), 2000L);
    }
    AppMethodBeat.o(91319);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(91320);
    this.gAV.dead();
    this.iJi.dead();
    this.checkLanguageChangeIListener.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.teE);
    com.tencent.mm.plugin.websearch.api.ai.uJI = null;
    AppMethodBeat.o(91320);
  }
  
  public void parallelsDependency() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch
 * JD-Core Version:    0.7.0.1
 */