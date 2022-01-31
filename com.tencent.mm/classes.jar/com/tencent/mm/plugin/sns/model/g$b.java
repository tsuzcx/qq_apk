package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.a;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class g$b
  extends h<String, Integer, Boolean>
{
  private awd bZK;
  private n dPv = null;
  private String eFm;
  String key = "";
  private int opB = 0;
  private String path;
  
  public g$b(g paramg, String paramString1, String paramString2, String paramString3, awd paramawd, int paramInt)
  {
    paramg.opl.add(paramString1);
    this.key = paramString1;
    this.path = paramString2;
    this.eFm = paramString3;
    this.bZK = paramawd;
    this.opB = paramInt;
    g.bCW();
    y.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.bCX()) });
  }
  
  private void V(String paramString1, String paramString2, String paramString3)
  {
    com.tencent.mm.vfs.e.bK(this.eFm + paramString3);
    if (!com.tencent.mm.vfs.e.bK(this.eFm + paramString1))
    {
      String str = paramString2;
      if (!com.tencent.mm.vfs.e.bK(this.eFm + paramString2)) {
        str = i.m(this.bZK);
      }
      boolean bool = s.a(this.eFm, str, paramString1, af.bDO());
      if (!bool)
      {
        y.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
        com.tencent.mm.vfs.e.deleteFile(this.eFm + str);
      }
      y.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.eFm + str, this.eFm + paramString1, Boolean.valueOf(bool) });
    }
    s.b(this.eFm, paramString1, paramString3, af.bDN());
  }
  
  private Boolean bCZ()
  {
    g.a(this.opn, true);
    System.currentTimeMillis();
    if (!g.h(this.opn))
    {
      y.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
      return Boolean.valueOf(false);
    }
    if (g.f(this.opn).aC(this.key))
    {
      y.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
      return Boolean.valueOf(false);
    }
    com.tencent.mm.vfs.e.aeW(this.eFm);
    long l1 = System.currentTimeMillis();
    long l2;
    Object localObject;
    if (!com.tencent.mm.vfs.e.bK(this.path))
    {
      V(i.e(this.bZK), i.l(this.bZK), i.f(this.bZK));
      l2 = bk.UZ();
      if (this.opB != 5) {
        break label744;
      }
      if (!com.tencent.mm.vfs.e.bK(this.path)) {
        V(i.e(this.bZK), i.l(this.bZK), i.f(this.bZK));
      }
      bool1 = com.tencent.mm.vfs.e.bK(this.eFm + i.e(this.bZK));
      boolean bool2 = com.tencent.mm.vfs.e.bK(this.eFm + i.l(this.bZK));
      boolean bool3 = com.tencent.mm.vfs.e.bK(this.eFm + i.f(this.bZK));
      this.dPv = i.MY(this.path);
      if (this.dPv == null)
      {
        y.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
        localObject = i.f(this.bZK);
        this.dPv = a.eF(this.eFm + (String)localObject, this.path);
        boolean bool4 = com.tencent.mm.vfs.e.bK(this.path);
        y.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
      }
      label410:
      long l3 = bk.cp(l2);
      int i = (int)com.tencent.mm.vfs.e.aeQ(this.path);
      if (bk.cp(g.i(this.opn)) > 60000L)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), af.bDS(), com.tencent.mm.compatible.util.e.bkF });
        g.b(this.opn, bk.UZ());
      }
      if (this.dPv == null)
      {
        y.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.bZK.lsK });
        com.tencent.mm.vfs.e.deleteFile(this.eFm + i.f(this.bZK));
        com.tencent.mm.vfs.e.deleteFile(this.path);
        com.tencent.mm.plugin.report.service.h.nFQ.a(150L, 2L, 1L, true);
      }
      l3 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.nFQ.a(150L, 0L, 1L, true);
      com.tencent.mm.plugin.report.service.h.nFQ.a(150L, 1L, l3 - l1, true);
      localObject = new StringBuilder("doInBackground decode %s and ");
      if (this.dPv != null) {
        break label847;
      }
    }
    label847:
    for (boolean bool1 = true;; bool1 = false)
    {
      y.i("MicroMsg.ImageLoader", bool1 + " " + this.dPv + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
      return Boolean.valueOf(true);
      y.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
      break;
      label744:
      if (this.opB == 4)
      {
        this.dPv = i.MY(this.path);
        if (this.dPv != null) {
          break label410;
        }
        y.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
        localObject = i.e(this.bZK);
        this.dPv = a.eF(this.eFm + (String)localObject, this.path);
        break label410;
      }
      this.dPv = i.Na(this.path);
      break label410;
    }
  }
  
  public final ah byB()
  {
    return af.aXo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.b
 * JD-Core Version:    0.7.0.1
 */