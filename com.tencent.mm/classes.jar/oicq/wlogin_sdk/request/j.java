package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j
  extends d
{
  public j(i parami)
  {
    this.xqq = 2064;
    this.xqr = 9;
    this.xqt = parami;
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3)
  {
    int i = this.xqt.xqD;
    this.xqt._uin = paramLong;
    byte[] arrayOfByte3 = super.bX(paramArrayOfByte2);
    if (arrayOfByte3 == null) {
      return null;
    }
    paramArrayOfByte2 = this.xqt.xqE;
    byte[] arrayOfByte1 = this.xqt.xqy.cUE();
    byte[] arrayOfByte2 = this.xqt.xqI;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject9 = new h();
    Object localObject5 = new r();
    Object localObject3 = new c();
    Object localObject4 = new oicq.wlogin_sdk.a.i();
    Object localObject8 = new oicq.wlogin_sdk.a.j();
    Object localObject7 = new k();
    f localf = new f();
    y localy = new y();
    aa localaa = new aa();
    ae localae = new ae();
    ag localag = new ag();
    Object localObject6 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).Z(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    this.xqt.xqU = super.bW(arrayOfByte3);
    int j = arrayOfByte3.length;
    if (((a)localObject9).xqZ + j > ((a)localObject9).xqe)
    {
      ((a)localObject9).xqe = (((a)localObject9).xqZ + j + 128);
      paramArrayOfByte1 = new byte[((a)localObject9).xqe];
      System.arraycopy(((a)localObject9).xqk, 0, paramArrayOfByte1, 0, ((a)localObject9).xqZ);
      ((a)localObject9).xqk = paramArrayOfByte1;
    }
    ((a)localObject9).xqf = (((a)localObject9).xqZ + j);
    System.arraycopy(arrayOfByte3, 0, ((a)localObject9).xqk, ((a)localObject9).xqZ, j);
    ((a)localObject9).xra = j;
    util.D(((a)localObject9).xqk, 0, ((a)localObject9).xqq);
    util.D(((a)localObject9).xqk, 2, ((a)localObject9).xra);
    arrayOfByte3 = ((a)localObject9).cUB();
    util.gW("req2 a1:", util.ch(arrayOfByte3));
    localObject3 = ((c)localObject3).KQ(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).cUH();
    localObject5 = ((r)localObject5).gE(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).cd(this.xqt.xqE);
    if (paramArrayOfByte3.length > 0) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).ca(paramArrayOfByte3);
    }
    for (paramInt1 = 8;; paramInt1 = 7)
    {
      if (paramArrayOfByte2.length > 0) {}
      for (paramArrayOfByte2 = ((k)localObject7).cb(paramArrayOfByte2);; paramArrayOfByte2 = new byte[0])
      {
        paramArrayOfByte3 = util.cUK();
        localObject7 = util.cUL();
        paramInt2 = this.xqt.xqH;
        localObject8 = this.xqt.xqG;
        localObject9 = this.xqt.xqJ;
        paramArrayOfByte3 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte3, (byte[])localObject7, paramInt2, (byte[])localObject8, new byte[0], (byte[])localObject9), localaa.a(this.xqt.xqP, this.xqt.xqQ, this.xqt.xqR, this.xqt.xqN, this.xqt.xqE), localaj.m(this.xqt.xqL, this.xqt.xqM), this.xqt.xqv);
        arrayOfByte2 = localae.cc(arrayOfByte2);
        paramInt1 = paramInt1 + 1 + 1;
        if (arrayOfByte1.length > 0)
        {
          paramArrayOfByte2 = localf.bZ(arrayOfByte1);
          paramInt1 += 1;
        }
        for (;;)
        {
          arrayOfByte1 = new byte[localObject1.length + localObject2.length + arrayOfByte3.length + localObject5.length + localObject3.length + localObject4.length + paramArrayOfByte1.length + paramArrayOfByte3.length + paramArrayOfByte2.length + arrayOfByte2.length + 0 + localObject6.length];
          System.arraycopy(localObject1, 0, arrayOfByte1, 0, localObject1.length);
          paramInt2 = localObject1.length + 0;
          System.arraycopy(localObject2, 0, arrayOfByte1, paramInt2, localObject2.length);
          paramInt2 += localObject2.length;
          System.arraycopy(arrayOfByte3, 0, arrayOfByte1, paramInt2, arrayOfByte3.length);
          paramInt2 += arrayOfByte3.length;
          System.arraycopy(localObject5, 0, arrayOfByte1, paramInt2, localObject5.length);
          paramInt2 += localObject5.length;
          System.arraycopy(localObject3, 0, arrayOfByte1, paramInt2, localObject3.length);
          paramInt2 += localObject3.length;
          System.arraycopy(localObject4, 0, arrayOfByte1, paramInt2, localObject4.length);
          paramInt2 += localObject4.length;
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt2, paramArrayOfByte1.length);
          paramInt2 += paramArrayOfByte1.length;
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte1, paramInt2, paramArrayOfByte3.length);
          paramInt2 = paramArrayOfByte3.length + paramInt2;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
          paramInt2 += arrayOfByte2.length;
          System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
          paramInt2 += 0;
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
          System.arraycopy(localObject6, 0, arrayOfByte1, paramArrayOfByte2.length + paramInt2, localObject6.length);
          paramArrayOfByte1 = super.x(arrayOfByte1, this.xqr, paramInt1);
          a(this.xql, this.xqq, paramLong, this.xqn, this.xqo, i, this.xqp, paramArrayOfByte1);
          return super.cUB();
          paramArrayOfByte2 = new byte[0];
        }
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, byte[] paramArrayOfByte4)
  {
    int i = this.xqt.xqD;
    this.xqt._uin = paramLong;
    util.gW("IMEI", util.ch(this.xqt.xqE));
    byte[] arrayOfByte4 = this.xqt.xqv;
    byte[] arrayOfByte3 = this.xqt.xqE;
    byte[] arrayOfByte1 = this.xqt.xqy.cUE();
    byte[] arrayOfByte2 = this.xqt.xqI;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject3 = new h();
    Object localObject5 = new r();
    c localc = new c();
    Object localObject4 = new oicq.wlogin_sdk.a.i();
    Object localObject8 = new oicq.wlogin_sdk.a.j();
    Object localObject7 = new k();
    f localf = new f();
    y localy = new y();
    aa localaa = new aa();
    ae localae = new ae();
    ag localag = new ag();
    Object localObject6 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).Z(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    paramArrayOfByte3 = ((h)localObject3).a(i, paramLong, paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, arrayOfByte4, this.xqt.xqQ, this.xqt.xqE);
    this.xqt.xqU = super.bW(((a)localObject3).cUE());
    localObject3 = localc.KQ(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).cUH();
    localObject5 = ((r)localObject5).gE(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).cd(this.xqt.xqE);
    paramInt1 = 7;
    if (paramArrayOfByte4.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).ca(paramArrayOfByte4);
      paramInt1 = 8;
    }
    for (;;)
    {
      if (arrayOfByte3.length > 0) {}
      for (paramArrayOfByte2 = ((k)localObject7).cb(arrayOfByte3);; paramArrayOfByte2 = new byte[0])
      {
        paramArrayOfByte4 = util.cUK();
        arrayOfByte3 = util.cUL();
        paramInt2 = this.xqt.xqH;
        localObject7 = this.xqt.xqG;
        localObject8 = this.xqt.xqJ;
        paramArrayOfByte4 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte4, arrayOfByte3, paramInt2, (byte[])localObject7, new byte[0], (byte[])localObject8), localaa.a(this.xqt.xqP, this.xqt.xqQ, this.xqt.xqR, this.xqt.xqN, this.xqt.xqE), localaj.m(this.xqt.xqL, this.xqt.xqM), this.xqt.xqv);
        arrayOfByte2 = localae.cc(arrayOfByte2);
        paramInt1 = paramInt1 + 1 + 1;
        if (arrayOfByte1.length > 0)
        {
          paramArrayOfByte2 = localf.bZ(arrayOfByte1);
          paramInt1 += 1;
        }
        for (;;)
        {
          arrayOfByte1 = new byte[localObject1.length + localObject2.length + paramArrayOfByte3.length + localObject5.length + localObject3.length + localObject4.length + paramArrayOfByte1.length + paramArrayOfByte4.length + paramArrayOfByte2.length + arrayOfByte2.length + 0 + localObject6.length];
          System.arraycopy(localObject1, 0, arrayOfByte1, 0, localObject1.length);
          paramInt2 = localObject1.length + 0;
          System.arraycopy(localObject2, 0, arrayOfByte1, paramInt2, localObject2.length);
          paramInt2 += localObject2.length;
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte1, paramInt2, paramArrayOfByte3.length);
          paramInt2 += paramArrayOfByte3.length;
          System.arraycopy(localObject5, 0, arrayOfByte1, paramInt2, localObject5.length);
          paramInt2 += localObject5.length;
          System.arraycopy(localObject3, 0, arrayOfByte1, paramInt2, localObject3.length);
          paramInt2 += localObject3.length;
          System.arraycopy(localObject4, 0, arrayOfByte1, paramInt2, localObject4.length);
          paramInt2 += localObject4.length;
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt2, paramArrayOfByte1.length);
          paramInt2 += paramArrayOfByte1.length;
          System.arraycopy(paramArrayOfByte4, 0, arrayOfByte1, paramInt2, paramArrayOfByte4.length);
          paramInt2 = paramArrayOfByte4.length + paramInt2;
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
          paramInt2 += arrayOfByte2.length;
          System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
          paramInt2 += 0;
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
          System.arraycopy(localObject6, 0, arrayOfByte1, paramArrayOfByte2.length + paramInt2, localObject6.length);
          paramArrayOfByte1 = super.x(arrayOfByte1, this.xqr, paramInt1);
          a(this.xql, this.xqq, paramLong, this.xqn, this.xqo, i, this.xqp, paramArrayOfByte1);
          return super.cUB();
          paramArrayOfByte2 = new byte[0];
        }
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.j
 * JD-Core Version:    0.7.0.1
 */