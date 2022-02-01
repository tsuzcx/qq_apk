package com.tencent.tinker.c.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.s.a;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> ahPA;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> ahPB;
  private final com.tencent.tinker.a.a.i ahPj;
  private final com.tencent.tinker.a.a.i ahPk;
  private final com.tencent.tinker.c.a.b.a ahPl;
  private final com.tencent.tinker.c.a.c.c ahPm;
  private com.tencent.tinker.c.a.a.a.i<r> ahPn;
  private com.tencent.tinker.c.a.a.a.i<Integer> ahPo;
  private com.tencent.tinker.c.a.a.a.i<q> ahPp;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> ahPq;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> ahPr;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> ahPs;
  private com.tencent.tinker.c.a.a.a.i<t> ahPt;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> ahPu;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> ahPv;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> ahPw;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> ahPx;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> ahPy;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> ahPz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.ahPj = parami;
    this.ahPl = parama;
    this.ahPk = new com.tencent.tinker.a.a.i(parama.ahQk);
    this.ahPm = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.ahPj.OD(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.ahPl == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.ahPl.ahQD;
    if (com.tencent.tinker.a.a.b.c.s((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.ahPk.ahNX;
    ((s)localObject1).ahOq.off = 0;
    ((s)localObject1).ahOq.size = 1;
    ((s)localObject1).ahOx.size = 1;
    ((s)localObject1).ahOr.off = this.ahPl.ahQm;
    ((s)localObject1).ahOs.off = this.ahPl.ahQn;
    ((s)localObject1).ahOy.off = this.ahPl.ahQt;
    ((s)localObject1).ahOt.off = this.ahPl.ahQo;
    ((s)localObject1).ahOu.off = this.ahPl.ahQp;
    ((s)localObject1).ahOv.off = this.ahPl.ahQq;
    ((s)localObject1).ahOw.off = this.ahPl.ahQr;
    ((s)localObject1).ahOx.off = this.ahPl.ahQs;
    ((s)localObject1).ahOD.off = this.ahPl.ahQy;
    ((s)localObject1).ahOF.off = this.ahPl.ahQA;
    ((s)localObject1).ahOA.off = this.ahPl.ahQv;
    ((s)localObject1).ahOz.off = this.ahPl.ahQu;
    ((s)localObject1).ahOH.off = this.ahPl.ahQC;
    ((s)localObject1).ahOG.off = this.ahPl.ahQB;
    ((s)localObject1).ahOE.off = this.ahPl.ahQz;
    ((s)localObject1).ahOC.off = this.ahPl.ahQx;
    ((s)localObject1).ahOB.off = this.ahPl.ahQw;
    ((s)localObject1).fileSize = this.ahPl.ahQk;
    Arrays.sort(((s)localObject1).ahOI);
    ((s)localObject1).kbS();
    this.ahPn = new com.tencent.tinker.c.a.a.a.n(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPo = new o(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPp = new l(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPq = new j(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPr = new com.tencent.tinker.c.a.a.a.k(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPs = new com.tencent.tinker.c.a.a.a.f(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPt = new com.tencent.tinker.c.a.a.a.p(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPu = new com.tencent.tinker.c.a.a.a.b(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPv = new com.tencent.tinker.c.a.a.a.c(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPw = new com.tencent.tinker.c.a.a.a.e(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPx = new com.tencent.tinker.c.a.a.a.g(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPy = new com.tencent.tinker.c.a.a.a.h(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPz = new com.tencent.tinker.c.a.a.a.a(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPA = new m(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPB = new com.tencent.tinker.c.a.a.a.d(this.ahPl, this.ahPj, this.ahPk, this.ahPm);
    this.ahPn.execute();
    this.ahPo.execute();
    this.ahPt.execute();
    this.ahPp.execute();
    this.ahPq.execute();
    this.ahPr.execute();
    this.ahPz.execute();
    this.ahPv.execute();
    this.ahPu.execute();
    this.ahPB.execute();
    this.ahPy.execute();
    this.ahPx.execute();
    this.ahPw.execute();
    this.ahPA.execute();
    this.ahPs.execute();
    localObject2 = this.ahPk.aIh(((s)localObject1).ahOq.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).aX(((s)localObject1).peK);
    ((i.e)localObject2).write(((s)localObject1).KnY);
    ((i.e)localObject2).aX(((s)localObject1).fileSize);
    ((i.e)localObject2).aX(112);
    ((i.e)localObject2).aX(305419896);
    ((i.e)localObject2).aX(((s)localObject1).ahOJ);
    ((i.e)localObject2).aX(((s)localObject1).ahOK);
    ((i.e)localObject2).aX(((s)localObject1).ahOx.off);
    ((i.e)localObject2).aX(((s)localObject1).ahOr.size);
    if (((s)localObject1).ahOr.jKS())
    {
      i = ((s)localObject1).ahOr.off;
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).ahOs.size);
      if (!((s)localObject1).ahOs.jKS()) {
        break label1360;
      }
      i = ((s)localObject1).ahOs.off;
      label1125:
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).ahOt.size);
      if (!((s)localObject1).ahOt.jKS()) {
        break label1365;
      }
      i = ((s)localObject1).ahOt.off;
      label1164:
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).ahOu.size);
      if (!((s)localObject1).ahOu.jKS()) {
        break label1370;
      }
      i = ((s)localObject1).ahOu.off;
      label1203:
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).ahOv.size);
      if (!((s)localObject1).ahOv.jKS()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).ahOv.off;; i = 0)
    {
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).ahOw.size);
      i = j;
      if (((s)localObject1).ahOw.jKS()) {
        i = ((s)localObject1).ahOw.off;
      }
      ((i.e)localObject2).aX(i);
      ((i.e)localObject2).aX(((s)localObject1).dataSize);
      ((i.e)localObject2).aX(((s)localObject1).ahOL);
      ((s)localObject1).b(this.ahPk.aIh(((s)localObject1).ahOx.off));
      this.ahPk.kbv();
      paramOutputStream.write(this.ahPk.cKQ.array());
      paramOutputStream.flush();
      return;
      i = 0;
      break;
      i = 0;
      break label1125;
      i = 0;
      break label1164;
      i = 0;
      break label1203;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */