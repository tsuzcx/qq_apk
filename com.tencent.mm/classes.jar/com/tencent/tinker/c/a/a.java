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
  private com.tencent.tinker.c.a.a.a.i<q> MBA;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> MBB;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> MBC;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> MBD;
  private com.tencent.tinker.c.a.a.a.i<t> MBE;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> MBF;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> MBG;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> MBH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> MBI;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> MBJ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> MBK;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> MBL;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> MBM;
  private final com.tencent.tinker.a.a.i MBu;
  private final com.tencent.tinker.a.a.i MBv;
  private final com.tencent.tinker.c.a.b.a MBw;
  private final com.tencent.tinker.c.a.c.c MBx;
  private com.tencent.tinker.c.a.a.a.i<r> MBy;
  private com.tencent.tinker.c.a.a.a.i<Integer> MBz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.MBu = parami;
    this.MBw = parama;
    this.MBv = new com.tencent.tinker.a.a.i(parama.MCv);
    this.MBx = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.MBu.zP(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.MBw == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.MBw.MCO;
    if (com.tencent.tinker.a.a.b.c.q((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.MBv.MAg;
    ((s)localObject1).MAA.off = 0;
    ((s)localObject1).MAA.size = 1;
    ((s)localObject1).MAH.size = 1;
    ((s)localObject1).MAB.off = this.MBw.MCx;
    ((s)localObject1).MAC.off = this.MBw.MCy;
    ((s)localObject1).MAI.off = this.MBw.MCE;
    ((s)localObject1).MAD.off = this.MBw.MCz;
    ((s)localObject1).MAE.off = this.MBw.MCA;
    ((s)localObject1).MAF.off = this.MBw.MCB;
    ((s)localObject1).MAG.off = this.MBw.MCC;
    ((s)localObject1).MAH.off = this.MBw.MCD;
    ((s)localObject1).MAN.off = this.MBw.MCJ;
    ((s)localObject1).MAQ.off = this.MBw.MCL;
    ((s)localObject1).MAK.off = this.MBw.MCG;
    ((s)localObject1).MAJ.off = this.MBw.MCF;
    ((s)localObject1).MAS.off = this.MBw.MCN;
    ((s)localObject1).MAR.off = this.MBw.MCM;
    ((s)localObject1).MAO.off = this.MBw.MCK;
    ((s)localObject1).MAM.off = this.MBw.MCI;
    ((s)localObject1).MAL.off = this.MBw.MCH;
    ((s)localObject1).fileSize = this.MBw.MCv;
    Arrays.sort(((s)localObject1).MAT);
    ((s)localObject1).gcJ();
    this.MBy = new com.tencent.tinker.c.a.a.a.n(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBz = new o(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBA = new l(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBB = new j(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBC = new com.tencent.tinker.c.a.a.a.k(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBD = new com.tencent.tinker.c.a.a.a.f(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBE = new com.tencent.tinker.c.a.a.a.p(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBF = new com.tencent.tinker.c.a.a.a.b(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBG = new com.tencent.tinker.c.a.a.a.c(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBH = new com.tencent.tinker.c.a.a.a.e(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBI = new com.tencent.tinker.c.a.a.a.g(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBJ = new com.tencent.tinker.c.a.a.a.h(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBK = new com.tencent.tinker.c.a.a.a.a(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBL = new m(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBM = new com.tencent.tinker.c.a.a.a.d(this.MBw, this.MBu, this.MBv, this.MBx);
    this.MBy.execute();
    this.MBz.execute();
    this.MBE.execute();
    this.MBA.execute();
    this.MBB.execute();
    this.MBC.execute();
    this.MBK.execute();
    this.MBG.execute();
    this.MBF.execute();
    this.MBM.execute();
    this.MBJ.execute();
    this.MBI.execute();
    this.MBH.execute();
    this.MBL.execute();
    this.MBD.execute();
    localObject2 = this.MBv.aih(((s)localObject1).MAA.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((s)localObject1).iAi);
    ((i.e)localObject2).write(((s)localObject1).vxd);
    ((i.e)localObject2).writeInt(((s)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((s)localObject1).MAU);
    ((i.e)localObject2).writeInt(((s)localObject1).MAV);
    ((i.e)localObject2).writeInt(((s)localObject1).MAH.off);
    ((i.e)localObject2).writeInt(((s)localObject1).MAB.size);
    if (((s)localObject1).MAB.exists())
    {
      i = ((s)localObject1).MAB.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MAC.size);
      if (!((s)localObject1).MAC.exists()) {
        break label1360;
      }
      i = ((s)localObject1).MAC.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MAD.size);
      if (!((s)localObject1).MAD.exists()) {
        break label1365;
      }
      i = ((s)localObject1).MAD.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MAE.size);
      if (!((s)localObject1).MAE.exists()) {
        break label1370;
      }
      i = ((s)localObject1).MAE.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MAF.size);
      if (!((s)localObject1).MAF.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).MAF.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MAG.size);
      i = j;
      if (((s)localObject1).MAG.exists()) {
        i = ((s)localObject1).MAG.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).dataSize);
      ((i.e)localObject2).writeInt(((s)localObject1).MAW);
      ((s)localObject1).b(this.MBv.aih(((s)localObject1).MAH.off));
      this.MBv.gcl();
      paramOutputStream.write(this.MBv.aKX.array());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */