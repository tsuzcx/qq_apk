package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;

final class g$b
  extends h<String, Integer, Boolean>
{
  private bcs cIc;
  private String fVd;
  private n feU;
  String key;
  private String path;
  private int ree;
  
  public g$b(g paramg, String paramString1, String paramString2, String paramString3, bcs parambcs, int paramInt)
  {
    AppMethodBeat.i(36150);
    this.key = "";
    this.feU = null;
    this.ree = 0;
    paramg.rdJ.add(paramString1);
    this.key = paramString1;
    this.path = paramString2;
    this.fVd = paramString3;
    this.cIc = parambcs;
    this.ree = paramInt;
    g.bUR();
    ab.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[] { Integer.valueOf(g.bUU()) });
    AppMethodBeat.o(36150);
  }
  
  private void ag(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(36151);
    com.tencent.mm.vfs.e.cN(this.fVd + paramString3);
    if (!com.tencent.mm.vfs.e.cN(this.fVd + paramString1))
    {
      String str = paramString2;
      if (!com.tencent.mm.vfs.e.cN(this.fVd + paramString2)) {
        str = i.m(this.cIc);
      }
      boolean bool = s.a(this.fVd, str, paramString1, ag.cpo());
      if (!bool)
      {
        ab.i("MicroMsg.ImageLoader", "delete %s", new Object[] { str });
        com.tencent.mm.vfs.e.deleteFile(this.fVd + str);
      }
      ab.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[] { this.fVd + str, this.fVd + paramString1, Boolean.valueOf(bool) });
    }
    s.b(this.fVd, paramString1, paramString3, ag.cpn());
    AppMethodBeat.o(36151);
  }
  
  private Boolean coz()
  {
    AppMethodBeat.i(36152);
    g.a(this.rdL, true);
    Object localObject;
    if (!g.h(this.rdL))
    {
      ab.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
      localObject = Boolean.FALSE;
      AppMethodBeat.o(36152);
      return localObject;
    }
    if (g.f(this.rdL).Z(this.key))
    {
      ab.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
      localObject = Boolean.FALSE;
      AppMethodBeat.o(36152);
      return localObject;
    }
    com.tencent.mm.vfs.e.avN(this.fVd);
    long l1 = System.currentTimeMillis();
    long l2;
    if (!com.tencent.mm.vfs.e.cN(this.path))
    {
      ag(i.e(this.cIc), i.l(this.cIc), i.f(this.cIc));
      l2 = bo.yB();
      if (this.ree != 5) {
        break label769;
      }
      if (!com.tencent.mm.vfs.e.cN(this.path)) {
        ag(i.e(this.cIc), i.l(this.cIc), i.f(this.cIc));
      }
      bool1 = com.tencent.mm.vfs.e.cN(this.fVd + i.e(this.cIc));
      boolean bool2 = com.tencent.mm.vfs.e.cN(this.fVd + i.l(this.cIc));
      boolean bool3 = com.tencent.mm.vfs.e.cN(this.fVd + i.f(this.cIc));
      this.feU = i.ZF(this.path);
      if (this.feU == null)
      {
        ab.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
        localObject = i.f(this.cIc);
        this.feU = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.fVd + (String)localObject, this.path);
        boolean bool4 = com.tencent.mm.vfs.e.cN(this.path);
        ab.i("MicroMsg.ImageLoader", "abc a" + bool1 + " b" + bool2 + " c" + bool3 + " d" + bool4);
      }
      label427:
      long l3 = bo.av(l2);
      int i = (int)com.tencent.mm.vfs.e.avI(this.path);
      if (bo.av(g.i(this.rdL)) > 60000L)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11696, new Object[] { Integer.valueOf(4), Long.valueOf(l3), Integer.valueOf(i), Thread.currentThread().getName(), ag.cpr(), com.tencent.mm.compatible.util.e.eQx });
        g.b(this.rdL, bo.yB());
      }
      if (this.feU == null)
      {
        ab.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[] { this.cIc.Id });
        com.tencent.mm.vfs.e.deleteFile(this.fVd + i.f(this.cIc));
        com.tencent.mm.vfs.e.deleteFile(this.path);
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(150L, 2L, 1L, true);
      }
      l3 = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(150L, 0L, 1L, true);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(150L, 1L, l3 - l1, true);
      localObject = new StringBuilder("doInBackground decode %s and ");
      if (this.feU != null) {
        break label872;
      }
    }
    label769:
    label872:
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.ImageLoader", bool1 + " " + this.feU + " %d ", new Object[] { this.path, Long.valueOf(System.currentTimeMillis() - l2) });
      localObject = Boolean.TRUE;
      AppMethodBeat.o(36152);
      return localObject;
      ab.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[] { this.path });
      break;
      if (this.ree == 4)
      {
        this.feU = i.ZF(this.path);
        if (this.feU != null) {
          break label427;
        }
        ab.i("MicroMsg.ImageLoader", "error path %s", new Object[] { this.path });
        localObject = i.e(this.cIc);
        this.feU = com.tencent.mm.plugin.sns.lucky.a.a.gh(this.fVd + (String)localObject, this.path);
        break label427;
      }
      this.feU = i.ZH(this.path);
      break label427;
    }
  }
  
  public final com.tencent.mm.sdk.g.b.a cjN()
  {
    AppMethodBeat.i(36153);
    com.tencent.mm.sdk.g.b.a locala = ag.coQ();
    AppMethodBeat.o(36153);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.g.b
 * JD-Core Version:    0.7.0.1
 */