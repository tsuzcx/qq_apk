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
  private final com.tencent.tinker.a.a.i KoA;
  private final com.tencent.tinker.c.a.b.a KoB;
  private final com.tencent.tinker.c.a.c.c KoC;
  private com.tencent.tinker.c.a.a.a.i<r> KoD;
  private com.tencent.tinker.c.a.a.a.i<Integer> KoE;
  private com.tencent.tinker.c.a.a.a.i<q> KoF;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> KoG;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> KoH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> KoI;
  private com.tencent.tinker.c.a.a.a.i<t> KoJ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> KoK;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> KoL;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> KoM;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> KoN;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> KoO;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> KoP;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> KoQ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> KoR;
  private final com.tencent.tinker.a.a.i Koz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.Koz = parami;
    this.KoB = parama;
    this.KoA = new com.tencent.tinker.a.a.i(parama.KpA);
    this.KoC = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.Koz.yO(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.KoB == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.KoB.KpT;
    if (com.tencent.tinker.a.a.b.c.p((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.KoA.Knn;
    ((s)localObject1).KnH.off = 0;
    ((s)localObject1).KnH.size = 1;
    ((s)localObject1).KnO.size = 1;
    ((s)localObject1).KnI.off = this.KoB.KpC;
    ((s)localObject1).KnJ.off = this.KoB.KpD;
    ((s)localObject1).KnP.off = this.KoB.KpJ;
    ((s)localObject1).KnK.off = this.KoB.KpE;
    ((s)localObject1).KnL.off = this.KoB.KpF;
    ((s)localObject1).KnM.off = this.KoB.KpG;
    ((s)localObject1).KnN.off = this.KoB.KpH;
    ((s)localObject1).KnO.off = this.KoB.KpI;
    ((s)localObject1).KnU.off = this.KoB.KpO;
    ((s)localObject1).KnW.off = this.KoB.KpQ;
    ((s)localObject1).KnR.off = this.KoB.KpL;
    ((s)localObject1).KnQ.off = this.KoB.KpK;
    ((s)localObject1).KnY.off = this.KoB.KpS;
    ((s)localObject1).KnX.off = this.KoB.KpR;
    ((s)localObject1).KnV.off = this.KoB.KpP;
    ((s)localObject1).KnT.off = this.KoB.KpN;
    ((s)localObject1).KnS.off = this.KoB.KpM;
    ((s)localObject1).fileSize = this.KoB.KpA;
    Arrays.sort(((s)localObject1).KnZ);
    ((s)localObject1).fGY();
    this.KoD = new com.tencent.tinker.c.a.a.a.n(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoE = new o(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoF = new l(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoG = new j(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoH = new com.tencent.tinker.c.a.a.a.k(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoI = new com.tencent.tinker.c.a.a.a.f(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoJ = new com.tencent.tinker.c.a.a.a.p(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoK = new com.tencent.tinker.c.a.a.a.b(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoL = new com.tencent.tinker.c.a.a.a.c(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoM = new com.tencent.tinker.c.a.a.a.e(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoN = new com.tencent.tinker.c.a.a.a.g(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoO = new com.tencent.tinker.c.a.a.a.h(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoP = new com.tencent.tinker.c.a.a.a.a(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoQ = new m(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoR = new com.tencent.tinker.c.a.a.a.d(this.KoB, this.Koz, this.KoA, this.KoC);
    this.KoD.execute();
    this.KoE.execute();
    this.KoJ.execute();
    this.KoF.execute();
    this.KoG.execute();
    this.KoH.execute();
    this.KoP.execute();
    this.KoL.execute();
    this.KoK.execute();
    this.KoR.execute();
    this.KoO.execute();
    this.KoN.execute();
    this.KoM.execute();
    this.KoQ.execute();
    this.KoI.execute();
    localObject2 = this.KoA.aeY(((s)localObject1).KnH.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((s)localObject1).idU);
    ((i.e)localObject2).write(((s)localObject1).uiq);
    ((i.e)localObject2).writeInt(((s)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((s)localObject1).Koa);
    ((i.e)localObject2).writeInt(((s)localObject1).Kob);
    ((i.e)localObject2).writeInt(((s)localObject1).KnO.off);
    ((i.e)localObject2).writeInt(((s)localObject1).KnI.size);
    if (((s)localObject1).KnI.exists())
    {
      i = ((s)localObject1).KnI.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).KnJ.size);
      if (!((s)localObject1).KnJ.exists()) {
        break label1360;
      }
      i = ((s)localObject1).KnJ.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).KnK.size);
      if (!((s)localObject1).KnK.exists()) {
        break label1365;
      }
      i = ((s)localObject1).KnK.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).KnL.size);
      if (!((s)localObject1).KnL.exists()) {
        break label1370;
      }
      i = ((s)localObject1).KnL.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).KnM.size);
      if (!((s)localObject1).KnM.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).KnM.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).KnN.size);
      i = j;
      if (((s)localObject1).KnN.exists()) {
        i = ((s)localObject1).KnN.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).dataSize);
      ((i.e)localObject2).writeInt(((s)localObject1).Koc);
      ((s)localObject1).b(this.KoA.aeY(((s)localObject1).KnO.off));
      this.KoA.fGA();
      paramOutputStream.write(this.KoA.aJg.array());
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