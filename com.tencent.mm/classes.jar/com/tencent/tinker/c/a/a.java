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
  private final com.tencent.tinker.a.a.i wTR;
  private final com.tencent.tinker.a.a.i wTS;
  private final com.tencent.tinker.c.a.b.a wTT;
  private final com.tencent.tinker.c.a.c.c wTU;
  private com.tencent.tinker.c.a.a.a.i<s> wTV;
  private com.tencent.tinker.c.a.a.a.i<Integer> wTW;
  private com.tencent.tinker.c.a.a.a.i<r> wTX;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> wTY;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> wTZ;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> wUa;
  private com.tencent.tinker.c.a.a.a.i<u> wUb;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> wUc;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> wUd;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> wUe;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> wUf;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> wUg;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> wUh;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> wUi;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> wUj;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.wTR = parami;
    this.wTT = parama;
    this.wTS = new com.tencent.tinker.a.a.i(parama.wUR);
    this.wTU = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.wTR.om(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.wTT == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.wTT.wVk;
    if (com.tencent.tinker.a.a.b.c.l((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.wTS.wSC;
    ((t)localObject1).wSW.off = 0;
    ((t)localObject1).wSW.size = 1;
    ((t)localObject1).wTd.size = 1;
    ((t)localObject1).wSX.off = this.wTT.wUT;
    ((t)localObject1).wSY.off = this.wTT.wUU;
    ((t)localObject1).wTe.off = this.wTT.wVa;
    ((t)localObject1).wSZ.off = this.wTT.wUV;
    ((t)localObject1).wTa.off = this.wTT.wUW;
    ((t)localObject1).wTb.off = this.wTT.wUX;
    ((t)localObject1).wTc.off = this.wTT.wUY;
    ((t)localObject1).wTd.off = this.wTT.wUZ;
    ((t)localObject1).wTj.off = this.wTT.wVf;
    ((t)localObject1).wTl.off = this.wTT.wVh;
    ((t)localObject1).wTg.off = this.wTT.wVc;
    ((t)localObject1).wTf.off = this.wTT.wVb;
    ((t)localObject1).wTn.off = this.wTT.wVj;
    ((t)localObject1).wTm.off = this.wTT.wVi;
    ((t)localObject1).wTk.off = this.wTT.wVg;
    ((t)localObject1).wTi.off = this.wTT.wVe;
    ((t)localObject1).wTh.off = this.wTT.wVd;
    ((t)localObject1).fileSize = this.wTT.wUR;
    Arrays.sort(((t)localObject1).wTo);
    ((t)localObject1).cQx();
    this.wTV = new com.tencent.tinker.c.a.a.a.n(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wTW = new o(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wTX = new l(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wTY = new j(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wTZ = new com.tencent.tinker.c.a.a.a.k(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUa = new com.tencent.tinker.c.a.a.a.f(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUb = new com.tencent.tinker.c.a.a.a.p(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUc = new com.tencent.tinker.c.a.a.a.b(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUd = new com.tencent.tinker.c.a.a.a.c(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUe = new com.tencent.tinker.c.a.a.a.e(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUf = new com.tencent.tinker.c.a.a.a.g(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUg = new com.tencent.tinker.c.a.a.a.h(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUh = new com.tencent.tinker.c.a.a.a.a(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUi = new m(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wUj = new com.tencent.tinker.c.a.a.a.d(this.wTT, this.wTR, this.wTS, this.wTU);
    this.wTV.execute();
    this.wTW.execute();
    this.wUb.execute();
    this.wTX.execute();
    this.wTY.execute();
    this.wTZ.execute();
    this.wUh.execute();
    this.wUd.execute();
    this.wUc.execute();
    this.wUj.execute();
    this.wUg.execute();
    this.wUf.execute();
    this.wUe.execute();
    this.wUi.execute();
    this.wUa.execute();
    localObject2 = this.wTS.Jw(((t)localObject1).wSW.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).writeInt(((t)localObject1).eKZ);
    ((i.e)localObject2).write(((t)localObject1).lMU);
    ((i.e)localObject2).writeInt(((t)localObject1).fileSize);
    ((i.e)localObject2).writeInt(112);
    ((i.e)localObject2).writeInt(305419896);
    ((i.e)localObject2).writeInt(((t)localObject1).wTp);
    ((i.e)localObject2).writeInt(((t)localObject1).wTq);
    ((i.e)localObject2).writeInt(((t)localObject1).wTd.off);
    ((i.e)localObject2).writeInt(((t)localObject1).wSX.size);
    if (((t)localObject1).wSX.exists())
    {
      i = ((t)localObject1).wSX.off;
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wSY.size);
      if (!((t)localObject1).wSY.exists()) {
        break label1360;
      }
      i = ((t)localObject1).wSY.off;
      label1125:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wSZ.size);
      if (!((t)localObject1).wSZ.exists()) {
        break label1365;
      }
      i = ((t)localObject1).wSZ.off;
      label1164:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wTa.size);
      if (!((t)localObject1).wTa.exists()) {
        break label1370;
      }
      i = ((t)localObject1).wTa.off;
      label1203:
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wTb.size);
      if (!((t)localObject1).wTb.exists()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((t)localObject1).wTb.off;; i = 0)
    {
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wTc.size);
      i = j;
      if (((t)localObject1).wTc.exists()) {
        i = ((t)localObject1).wTc.off;
      }
      ((i.e)localObject2).writeInt(i);
      ((i.e)localObject2).writeInt(((t)localObject1).wTr);
      ((i.e)localObject2).writeInt(((t)localObject1).wTs);
      ((t)localObject1).b(this.wTS.Jw(((t)localObject1).wTd.off));
      this.wTS.cPY();
      paramOutputStream.write(this.wTS.ayD.array());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */