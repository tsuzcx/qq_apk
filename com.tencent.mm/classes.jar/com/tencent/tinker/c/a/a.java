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
  private com.tencent.tinker.c.a.a.a.i<t> ICA;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> ICB;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> ICC;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> ICD;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> ICE;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> ICF;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> ICG;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> ICH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> ICI;
  private final com.tencent.tinker.a.a.i ICq;
  private final com.tencent.tinker.a.a.i ICr;
  private final com.tencent.tinker.c.a.b.a ICs;
  private final com.tencent.tinker.c.a.c.c ICt;
  private com.tencent.tinker.c.a.a.a.i<r> ICu;
  private com.tencent.tinker.c.a.a.a.i<Integer> ICv;
  private com.tencent.tinker.c.a.a.a.i<q> ICw;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> ICx;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> ICy;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> ICz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.ICq = parami;
    this.ICs = parama;
    this.ICr = new com.tencent.tinker.a.a.i(parama.IDr);
    this.ICt = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.ICq.xy(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.ICs == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.ICs.IDK;
    if (com.tencent.tinker.a.a.b.c.p((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.ICr.IBe;
    ((s)localObject1).IBy.off = 0;
    ((s)localObject1).IBy.size = 1;
    ((s)localObject1).IBF.size = 1;
    ((s)localObject1).IBz.off = this.ICs.IDt;
    ((s)localObject1).IBA.off = this.ICs.IDu;
    ((s)localObject1).IBG.off = this.ICs.IDA;
    ((s)localObject1).IBB.off = this.ICs.IDv;
    ((s)localObject1).IBC.off = this.ICs.IDw;
    ((s)localObject1).IBD.off = this.ICs.IDx;
    ((s)localObject1).IBE.off = this.ICs.IDy;
    ((s)localObject1).IBF.off = this.ICs.IDz;
    ((s)localObject1).IBL.off = this.ICs.IDF;
    ((s)localObject1).IBN.off = this.ICs.IDH;
    ((s)localObject1).IBI.off = this.ICs.IDC;
    ((s)localObject1).IBH.off = this.ICs.IDB;
    ((s)localObject1).IBP.off = this.ICs.IDJ;
    ((s)localObject1).IBO.off = this.ICs.IDI;
    ((s)localObject1).IBM.off = this.ICs.IDG;
    ((s)localObject1).IBK.off = this.ICs.IDE;
    ((s)localObject1).IBJ.off = this.ICs.IDD;
    ((s)localObject1).fileSize = this.ICs.IDr;
    Arrays.sort(((s)localObject1).IBQ);
    ((s)localObject1).foQ();
    this.ICu = new com.tencent.tinker.c.a.a.a.n(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICv = new o(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICw = new l(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICx = new j(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICy = new com.tencent.tinker.c.a.a.a.k(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICz = new com.tencent.tinker.c.a.a.a.f(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICA = new com.tencent.tinker.c.a.a.a.p(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICB = new com.tencent.tinker.c.a.a.a.b(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICC = new com.tencent.tinker.c.a.a.a.c(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICD = new com.tencent.tinker.c.a.a.a.e(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICE = new com.tencent.tinker.c.a.a.a.g(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICF = new com.tencent.tinker.c.a.a.a.h(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICG = new com.tencent.tinker.c.a.a.a.a(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICH = new m(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICI = new com.tencent.tinker.c.a.a.a.d(this.ICs, this.ICq, this.ICr, this.ICt);
    this.ICu.execute();
    this.ICv.execute();
    this.ICA.execute();
    this.ICw.execute();
    this.ICx.execute();
    this.ICy.execute();
    this.ICG.execute();
    this.ICC.execute();
    this.ICB.execute();
    this.ICI.execute();
    this.ICF.execute();
    this.ICE.execute();
    this.ICD.execute();
    this.ICH.execute();
    this.ICz.execute();
    localObject2 = this.ICr.acc(((s)localObject1).IBy.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((s)localObject1).hDs);
    ((i.e)localObject2).write(((s)localObject1).taa);
    ((i.e)localObject2).writeInt(((s)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((s)localObject1).IBR);
    ((i.e)localObject2).writeInt(((s)localObject1).IBS);
    ((i.e)localObject2).writeInt(((s)localObject1).IBF.off);
    ((i.e)localObject2).writeInt(((s)localObject1).IBz.size);
    if (((s)localObject1).IBz.exists())
    {
      i = ((s)localObject1).IBz.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).IBA.size);
      if (!((s)localObject1).IBA.exists()) {
        break label1360;
      }
      i = ((s)localObject1).IBA.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).IBB.size);
      if (!((s)localObject1).IBB.exists()) {
        break label1365;
      }
      i = ((s)localObject1).IBB.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).IBC.size);
      if (!((s)localObject1).IBC.exists()) {
        break label1370;
      }
      i = ((s)localObject1).IBC.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).IBD.size);
      if (!((s)localObject1).IBD.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).IBD.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).IBE.size);
      i = j;
      if (((s)localObject1).IBE.exists()) {
        i = ((s)localObject1).IBE.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).oJm);
      ((i.e)localObject2).writeInt(((s)localObject1).IBT);
      ((s)localObject1).b(this.ICr.acc(((s)localObject1).IBF.off));
      this.ICr.fos();
      paramOutputStream.write(this.ICr.aIq.array());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */