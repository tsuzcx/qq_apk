package com.tencent.tinker.c.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.a.a.u;
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
  private com.tencent.tinker.c.a.a.a.i<Integer> BqA;
  private com.tencent.tinker.c.a.a.a.i<r> BqB;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> BqC;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> BqD;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> BqE;
  private com.tencent.tinker.c.a.a.a.i<u> BqF;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> BqG;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> BqH;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> BqI;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> BqJ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> BqK;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> BqL;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> BqM;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> BqN;
  private final com.tencent.tinker.a.a.i Bqv;
  private final com.tencent.tinker.a.a.i Bqw;
  private final com.tencent.tinker.c.a.b.a Bqx;
  private final com.tencent.tinker.c.a.c.c Bqy;
  private com.tencent.tinker.c.a.a.a.i<s> Bqz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.Bqv = parami;
    this.Bqx = parama;
    this.Bqw = new com.tencent.tinker.a.a.i(parama.Brw);
    this.Bqy = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.Bqv.rY(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.Bqx == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.Bqx.BrP;
    if (com.tencent.tinker.a.a.b.c.o((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.Bqw.Bpj;
    ((t)localObject1).BpD.off = 0;
    ((t)localObject1).BpD.size = 1;
    ((t)localObject1).BpK.size = 1;
    ((t)localObject1).BpE.off = this.Bqx.Bry;
    ((t)localObject1).BpF.off = this.Bqx.Brz;
    ((t)localObject1).BpL.off = this.Bqx.BrF;
    ((t)localObject1).BpG.off = this.Bqx.BrA;
    ((t)localObject1).BpH.off = this.Bqx.BrB;
    ((t)localObject1).BpI.off = this.Bqx.BrC;
    ((t)localObject1).BpJ.off = this.Bqx.BrD;
    ((t)localObject1).BpK.off = this.Bqx.BrE;
    ((t)localObject1).BpQ.off = this.Bqx.BrK;
    ((t)localObject1).BpS.off = this.Bqx.BrM;
    ((t)localObject1).BpN.off = this.Bqx.BrH;
    ((t)localObject1).BpM.off = this.Bqx.BrG;
    ((t)localObject1).BpU.off = this.Bqx.BrO;
    ((t)localObject1).BpT.off = this.Bqx.BrN;
    ((t)localObject1).BpR.off = this.Bqx.BrL;
    ((t)localObject1).BpP.off = this.Bqx.BrJ;
    ((t)localObject1).BpO.off = this.Bqx.BrI;
    ((t)localObject1).fileSize = this.Bqx.Brw;
    Arrays.sort(((t)localObject1).BpV);
    ((t)localObject1).dWl();
    this.Bqz = new com.tencent.tinker.c.a.a.a.n(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqA = new o(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqB = new l(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqC = new j(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqD = new com.tencent.tinker.c.a.a.a.k(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqE = new com.tencent.tinker.c.a.a.a.f(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqF = new com.tencent.tinker.c.a.a.a.p(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqG = new com.tencent.tinker.c.a.a.a.b(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqH = new com.tencent.tinker.c.a.a.a.c(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqI = new com.tencent.tinker.c.a.a.a.e(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqJ = new com.tencent.tinker.c.a.a.a.g(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqK = new com.tencent.tinker.c.a.a.a.h(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqL = new com.tencent.tinker.c.a.a.a.a(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqM = new m(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.BqN = new com.tencent.tinker.c.a.a.a.d(this.Bqx, this.Bqv, this.Bqw, this.Bqy);
    this.Bqz.execute();
    this.BqA.execute();
    this.BqF.execute();
    this.BqB.execute();
    this.BqC.execute();
    this.BqD.execute();
    this.BqL.execute();
    this.BqH.execute();
    this.BqG.execute();
    this.BqN.execute();
    this.BqK.execute();
    this.BqJ.execute();
    this.BqI.execute();
    this.BqM.execute();
    this.BqE.execute();
    localObject2 = this.Bqw.Sr(((t)localObject1).BpD.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((t)localObject1).gaG);
    ((i.e)localObject2).write(((t)localObject1).okn);
    ((i.e)localObject2).writeInt(((t)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((t)localObject1).BpW);
    ((i.e)localObject2).writeInt(((t)localObject1).BpX);
    ((i.e)localObject2).writeInt(((t)localObject1).BpK.off);
    ((i.e)localObject2).writeInt(((t)localObject1).BpE.size);
    if (((t)localObject1).BpE.exists())
    {
      i = ((t)localObject1).BpE.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).BpF.size);
      if (!((t)localObject1).BpF.exists()) {
        break label1360;
      }
      i = ((t)localObject1).BpF.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).BpG.size);
      if (!((t)localObject1).BpG.exists()) {
        break label1365;
      }
      i = ((t)localObject1).BpG.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).BpH.size);
      if (!((t)localObject1).BpH.exists()) {
        break label1370;
      }
      i = ((t)localObject1).BpH.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).BpI.size);
      if (!((t)localObject1).BpI.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((t)localObject1).BpI.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).BpJ.size);
      i = j;
      if (((t)localObject1).BpJ.exists()) {
        i = ((t)localObject1).BpJ.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).lsT);
      ((i.e)localObject2).writeInt(((t)localObject1).BpY);
      ((t)localObject1).b(this.Bqw.Sr(((t)localObject1).BpK.off));
      this.Bqw.dVM();
      paramOutputStream.write(this.Bqw.aAS.array());
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