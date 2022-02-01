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
  private com.tencent.tinker.c.a.a.a.i<r> ShA;
  private com.tencent.tinker.c.a.a.a.i<Integer> ShB;
  private com.tencent.tinker.c.a.a.a.i<q> ShC;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> ShD;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> ShE;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> ShF;
  private com.tencent.tinker.c.a.a.a.i<t> ShG;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> ShH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> ShI;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> ShJ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> ShK;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> ShL;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> ShM;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> ShN;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> ShO;
  private final com.tencent.tinker.a.a.i Shw;
  private final com.tencent.tinker.a.a.i Shx;
  private final com.tencent.tinker.c.a.b.a Shy;
  private final com.tencent.tinker.c.a.c.c Shz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.Shw = parami;
    this.Shy = parama;
    this.Shx = new com.tencent.tinker.a.a.i(parama.Six);
    this.Shz = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.Shw.Ea(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.Shy == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.Shy.SiQ;
    if (com.tencent.tinker.a.a.b.c.p((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.Shx.Sgk;
    ((s)localObject1).SgE.off = 0;
    ((s)localObject1).SgE.size = 1;
    ((s)localObject1).SgL.size = 1;
    ((s)localObject1).SgF.off = this.Shy.Siz;
    ((s)localObject1).SgG.off = this.Shy.SiA;
    ((s)localObject1).SgM.off = this.Shy.SiG;
    ((s)localObject1).SgH.off = this.Shy.SiB;
    ((s)localObject1).SgI.off = this.Shy.SiC;
    ((s)localObject1).SgJ.off = this.Shy.SiD;
    ((s)localObject1).SgK.off = this.Shy.SiE;
    ((s)localObject1).SgL.off = this.Shy.SiF;
    ((s)localObject1).SgR.off = this.Shy.SiL;
    ((s)localObject1).SgT.off = this.Shy.SiN;
    ((s)localObject1).SgO.off = this.Shy.SiI;
    ((s)localObject1).SgN.off = this.Shy.SiH;
    ((s)localObject1).SgV.off = this.Shy.SiP;
    ((s)localObject1).SgU.off = this.Shy.SiO;
    ((s)localObject1).SgS.off = this.Shy.SiM;
    ((s)localObject1).SgQ.off = this.Shy.SiK;
    ((s)localObject1).SgP.off = this.Shy.SiJ;
    ((s)localObject1).fileSize = this.Shy.Six;
    Arrays.sort(((s)localObject1).SgW);
    ((s)localObject1).hoR();
    this.ShA = new com.tencent.tinker.c.a.a.a.n(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShB = new o(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShC = new l(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShD = new j(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShE = new com.tencent.tinker.c.a.a.a.k(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShF = new com.tencent.tinker.c.a.a.a.f(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShG = new com.tencent.tinker.c.a.a.a.p(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShH = new com.tencent.tinker.c.a.a.a.b(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShI = new com.tencent.tinker.c.a.a.a.c(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShJ = new com.tencent.tinker.c.a.a.a.e(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShK = new com.tencent.tinker.c.a.a.a.g(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShL = new com.tencent.tinker.c.a.a.a.h(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShM = new com.tencent.tinker.c.a.a.a.a(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShN = new m(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShO = new com.tencent.tinker.c.a.a.a.d(this.Shy, this.Shw, this.Shx, this.Shz);
    this.ShA.execute();
    this.ShB.execute();
    this.ShG.execute();
    this.ShC.execute();
    this.ShD.execute();
    this.ShE.execute();
    this.ShM.execute();
    this.ShI.execute();
    this.ShH.execute();
    this.ShO.execute();
    this.ShL.execute();
    this.ShK.execute();
    this.ShJ.execute();
    this.ShN.execute();
    this.ShF.execute();
    localObject2 = this.Shx.arH(((s)localObject1).SgE.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((s)localObject1).jvw);
    ((i.e)localObject2).write(((s)localObject1).yRs);
    ((i.e)localObject2).writeInt(((s)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((s)localObject1).SgX);
    ((i.e)localObject2).writeInt(((s)localObject1).SgY);
    ((i.e)localObject2).writeInt(((s)localObject1).SgL.off);
    ((i.e)localObject2).writeInt(((s)localObject1).SgF.size);
    if (((s)localObject1).SgF.exists())
    {
      i = ((s)localObject1).SgF.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).SgG.size);
      if (!((s)localObject1).SgG.exists()) {
        break label1360;
      }
      i = ((s)localObject1).SgG.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).SgH.size);
      if (!((s)localObject1).SgH.exists()) {
        break label1365;
      }
      i = ((s)localObject1).SgH.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).SgI.size);
      if (!((s)localObject1).SgI.exists()) {
        break label1370;
      }
      i = ((s)localObject1).SgI.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).SgJ.size);
      if (!((s)localObject1).SgJ.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).SgJ.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).SgK.size);
      i = j;
      if (((s)localObject1).SgK.exists()) {
        i = ((s)localObject1).SgK.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).dataSize);
      ((i.e)localObject2).writeInt(((s)localObject1).SgZ);
      ((s)localObject1).b(this.Shx.arH(((s)localObject1).SgL.off));
      this.Shx.hot();
      paramOutputStream.write(this.Shx.aKP.array());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */