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
  private final com.tencent.tinker.c.a.c.c MeA;
  private com.tencent.tinker.c.a.a.a.i<r> MeB;
  private com.tencent.tinker.c.a.a.a.i<Integer> MeC;
  private com.tencent.tinker.c.a.a.a.i<q> MeD;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> MeE;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> MeF;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> MeG;
  private com.tencent.tinker.c.a.a.a.i<t> MeH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> MeI;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> MeJ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> MeK;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> MeL;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> MeM;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> MeN;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> MeO;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> MeP;
  private final com.tencent.tinker.a.a.i Mex;
  private final com.tencent.tinker.a.a.i Mey;
  private final com.tencent.tinker.c.a.b.a Mez;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.Mex = parami;
    this.Mez = parama;
    this.Mey = new com.tencent.tinker.a.a.i(parama.Mfy);
    this.MeA = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.Mex.zB(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.Mez == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.Mez.MfR;
    if (com.tencent.tinker.a.a.b.c.p((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.Mey.Mdl;
    ((s)localObject1).MdF.off = 0;
    ((s)localObject1).MdF.size = 1;
    ((s)localObject1).MdM.size = 1;
    ((s)localObject1).MdG.off = this.Mez.MfA;
    ((s)localObject1).MdH.off = this.Mez.MfB;
    ((s)localObject1).MdN.off = this.Mez.MfH;
    ((s)localObject1).MdI.off = this.Mez.MfC;
    ((s)localObject1).MdJ.off = this.Mez.MfD;
    ((s)localObject1).MdK.off = this.Mez.MfE;
    ((s)localObject1).MdL.off = this.Mez.MfF;
    ((s)localObject1).MdM.off = this.Mez.MfG;
    ((s)localObject1).MdS.off = this.Mez.MfM;
    ((s)localObject1).MdU.off = this.Mez.MfO;
    ((s)localObject1).MdP.off = this.Mez.MfJ;
    ((s)localObject1).MdO.off = this.Mez.MfI;
    ((s)localObject1).MdW.off = this.Mez.MfQ;
    ((s)localObject1).MdV.off = this.Mez.MfP;
    ((s)localObject1).MdT.off = this.Mez.MfN;
    ((s)localObject1).MdR.off = this.Mez.MfL;
    ((s)localObject1).MdQ.off = this.Mez.MfK;
    ((s)localObject1).fileSize = this.Mez.Mfy;
    Arrays.sort(((s)localObject1).MdX);
    ((s)localObject1).fYk();
    this.MeB = new com.tencent.tinker.c.a.a.a.n(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeC = new o(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeD = new l(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeE = new j(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeF = new com.tencent.tinker.c.a.a.a.k(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeG = new com.tencent.tinker.c.a.a.a.f(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeH = new com.tencent.tinker.c.a.a.a.p(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeI = new com.tencent.tinker.c.a.a.a.b(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeJ = new com.tencent.tinker.c.a.a.a.c(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeK = new com.tencent.tinker.c.a.a.a.e(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeL = new com.tencent.tinker.c.a.a.a.g(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeM = new com.tencent.tinker.c.a.a.a.h(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeN = new com.tencent.tinker.c.a.a.a.a(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeO = new m(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeP = new com.tencent.tinker.c.a.a.a.d(this.Mez, this.Mex, this.Mey, this.MeA);
    this.MeB.execute();
    this.MeC.execute();
    this.MeH.execute();
    this.MeD.execute();
    this.MeE.execute();
    this.MeF.execute();
    this.MeN.execute();
    this.MeJ.execute();
    this.MeI.execute();
    this.MeP.execute();
    this.MeM.execute();
    this.MeL.execute();
    this.MeK.execute();
    this.MeO.execute();
    this.MeG.execute();
    localObject2 = this.Mey.ahy(((s)localObject1).MdF.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((s)localObject1).ixp);
    ((i.e)localObject2).write(((s)localObject1).vkY);
    ((i.e)localObject2).writeInt(((s)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((s)localObject1).MdY);
    ((i.e)localObject2).writeInt(((s)localObject1).MdZ);
    ((i.e)localObject2).writeInt(((s)localObject1).MdM.off);
    ((i.e)localObject2).writeInt(((s)localObject1).MdG.size);
    if (((s)localObject1).MdG.exists())
    {
      i = ((s)localObject1).MdG.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MdH.size);
      if (!((s)localObject1).MdH.exists()) {
        break label1360;
      }
      i = ((s)localObject1).MdH.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MdI.size);
      if (!((s)localObject1).MdI.exists()) {
        break label1365;
      }
      i = ((s)localObject1).MdI.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MdJ.size);
      if (!((s)localObject1).MdJ.exists()) {
        break label1370;
      }
      i = ((s)localObject1).MdJ.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MdK.size);
      if (!((s)localObject1).MdK.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).MdK.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).MdL.size);
      i = j;
      if (((s)localObject1).MdL.exists()) {
        i = ((s)localObject1).MdL.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((s)localObject1).dataSize);
      ((i.e)localObject2).writeInt(((s)localObject1).Mea);
      ((s)localObject1).b(this.Mey.ahy(((s)localObject1).MdM.off));
      this.Mey.fXM();
      paramOutputStream.write(this.Mey.aKX.array());
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