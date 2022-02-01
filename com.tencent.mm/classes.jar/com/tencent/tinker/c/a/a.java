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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a
{
  private final com.tencent.tinker.a.a.i ZKh;
  private final com.tencent.tinker.a.a.i ZKi;
  private final com.tencent.tinker.c.a.b.a ZKj;
  private final com.tencent.tinker.c.a.c.c ZKk;
  private com.tencent.tinker.c.a.a.a.i<r> ZKl;
  private com.tencent.tinker.c.a.a.a.i<Integer> ZKm;
  private com.tencent.tinker.c.a.a.a.i<q> ZKn;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.n> ZKo;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.p> ZKp;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.f> ZKq;
  private com.tencent.tinker.c.a.a.a.i<t> ZKr;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.c> ZKs;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.b> ZKt;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.e> ZKu;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.g> ZKv;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.h> ZKw;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.a> ZKx;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.k> ZKy;
  private com.tencent.tinker.c.a.a.a.i<com.tencent.tinker.a.a.d> ZKz;
  
  private a(com.tencent.tinker.a.a.i parami, com.tencent.tinker.c.a.b.a parama)
  {
    this.ZKh = parami;
    this.ZKj = parama;
    this.ZKi = new com.tencent.tinker.a.a.i(parama.ZLi);
    this.ZKk = new com.tencent.tinker.c.a.c.c();
  }
  
  public a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    this(new com.tencent.tinker.a.a.i(paramInputStream1), new com.tencent.tinker.c.a.b.a(paramInputStream2));
  }
  
  public final void V(File paramFile)
  {
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      com.tencent.tinker.c.b.b.closeQuietly(localBufferedOutputStream);
    }
    finally
    {
      try
      {
        c(localBufferedOutputStream);
        com.tencent.tinker.c.b.b.closeQuietly(localBufferedOutputStream);
        return;
      }
      finally {}
      paramFile = finally;
      localBufferedOutputStream = null;
    }
    throw paramFile;
  }
  
  public final void c(OutputStream paramOutputStream)
  {
    int j = 0;
    Object localObject1 = this.ZKh.IB(false);
    if (localObject1 == null) {
      throw new IOException("failed to compute old dex's signature.");
    }
    if (this.ZKj == null) {
      throw new IllegalArgumentException("patch file is null.");
    }
    Object localObject2 = this.ZKj.ZLB;
    if (com.tencent.tinker.a.a.b.c.r((byte[])localObject1, (byte[])localObject2) != 0) {
      throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[] { Arrays.toString((byte[])localObject1), Arrays.toString((byte[])localObject2) }));
    }
    localObject1 = this.ZKi.ZIV;
    ((s)localObject1).ZJp.off = 0;
    ((s)localObject1).ZJp.size = 1;
    ((s)localObject1).ZJw.size = 1;
    ((s)localObject1).ZJq.off = this.ZKj.ZLk;
    ((s)localObject1).ZJr.off = this.ZKj.ZLl;
    ((s)localObject1).ZJx.off = this.ZKj.ZLr;
    ((s)localObject1).ZJs.off = this.ZKj.ZLm;
    ((s)localObject1).ZJt.off = this.ZKj.ZLn;
    ((s)localObject1).ZJu.off = this.ZKj.ZLo;
    ((s)localObject1).ZJv.off = this.ZKj.ZLp;
    ((s)localObject1).ZJw.off = this.ZKj.ZLq;
    ((s)localObject1).ZJC.off = this.ZKj.ZLw;
    ((s)localObject1).ZJE.off = this.ZKj.ZLy;
    ((s)localObject1).ZJz.off = this.ZKj.ZLt;
    ((s)localObject1).ZJy.off = this.ZKj.ZLs;
    ((s)localObject1).ZJG.off = this.ZKj.ZLA;
    ((s)localObject1).ZJF.off = this.ZKj.ZLz;
    ((s)localObject1).ZJD.off = this.ZKj.ZLx;
    ((s)localObject1).ZJB.off = this.ZKj.ZLv;
    ((s)localObject1).ZJA.off = this.ZKj.ZLu;
    ((s)localObject1).fileSize = this.ZKj.ZLi;
    Arrays.sort(((s)localObject1).ZJH);
    ((s)localObject1).iss();
    this.ZKl = new com.tencent.tinker.c.a.a.a.n(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKm = new o(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKn = new l(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKo = new j(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKp = new com.tencent.tinker.c.a.a.a.k(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKq = new com.tencent.tinker.c.a.a.a.f(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKr = new com.tencent.tinker.c.a.a.a.p(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKs = new com.tencent.tinker.c.a.a.a.b(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKt = new com.tencent.tinker.c.a.a.a.c(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKu = new com.tencent.tinker.c.a.a.a.e(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKv = new com.tencent.tinker.c.a.a.a.g(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKw = new com.tencent.tinker.c.a.a.a.h(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKx = new com.tencent.tinker.c.a.a.a.a(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKy = new m(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKz = new com.tencent.tinker.c.a.a.a.d(this.ZKj, this.ZKh, this.ZKi, this.ZKk);
    this.ZKl.execute();
    this.ZKm.execute();
    this.ZKr.execute();
    this.ZKn.execute();
    this.ZKo.execute();
    this.ZKp.execute();
    this.ZKx.execute();
    this.ZKt.execute();
    this.ZKs.execute();
    this.ZKz.execute();
    this.ZKw.execute();
    this.ZKv.execute();
    this.ZKu.execute();
    this.ZKy.execute();
    this.ZKq.execute();
    localObject2 = this.ZKi.aBv(((s)localObject1).ZJp.off);
    ((i.e)localObject2).write(("dex\n" + "035" + "").getBytes("UTF-8"));
    ((i.e)localObject2).bV(((s)localObject1).mkZ);
    ((i.e)localObject2).write(((s)localObject1).Evq);
    ((i.e)localObject2).bV(((s)localObject1).fileSize);
    ((i.e)localObject2).bV(112);
    ((i.e)localObject2).bV(305419896);
    ((i.e)localObject2).bV(((s)localObject1).ZJI);
    ((i.e)localObject2).bV(((s)localObject1).ZJJ);
    ((i.e)localObject2).bV(((s)localObject1).ZJw.off);
    ((i.e)localObject2).bV(((s)localObject1).ZJq.size);
    if (((s)localObject1).ZJq.ifE())
    {
      i = ((s)localObject1).ZJq.off;
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).ZJr.size);
      if (!((s)localObject1).ZJr.ifE()) {
        break label1360;
      }
      i = ((s)localObject1).ZJr.off;
      label1125:
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).ZJs.size);
      if (!((s)localObject1).ZJs.ifE()) {
        break label1365;
      }
      i = ((s)localObject1).ZJs.off;
      label1164:
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).ZJt.size);
      if (!((s)localObject1).ZJt.ifE()) {
        break label1370;
      }
      i = ((s)localObject1).ZJt.off;
      label1203:
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).ZJu.size);
      if (!((s)localObject1).ZJu.ifE()) {
        break label1375;
      }
    }
    label1360:
    label1365:
    label1370:
    label1375:
    for (int i = ((s)localObject1).ZJu.off;; i = 0)
    {
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).ZJv.size);
      i = j;
      if (((s)localObject1).ZJv.ifE()) {
        i = ((s)localObject1).ZJv.off;
      }
      ((i.e)localObject2).bV(i);
      ((i.e)localObject2).bV(((s)localObject1).dataSize);
      ((i.e)localObject2).bV(((s)localObject1).ZJK);
      ((s)localObject1).b(this.ZKi.aBv(((s)localObject1).ZJw.off));
      this.ZKi.irV();
      paramOutputStream.write(this.ZKi.aQU.array());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.c.a.a
 * JD-Core Version:    0.7.0.1
 */