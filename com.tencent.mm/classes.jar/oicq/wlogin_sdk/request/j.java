package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    this.Ucx = 2064;
    this.Ucy = 9;
    this.UcA = parami;
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(88081);
    int i = this.UcA.UcK;
    this.UcA._uin = paramLong;
    byte[] arrayOfByte3 = super.dm(paramArrayOfByte2);
    if (arrayOfByte3 == null)
    {
      AppMethodBeat.o(88081);
      return null;
    }
    byte[] arrayOfByte4 = this.UcA.UcL;
    byte[] arrayOfByte1 = this.UcA.UcF.hPA();
    byte[] arrayOfByte2 = this.UcA.UcP;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject6 = new h();
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
    paramArrayOfByte2 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).a(522017402L, i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    this.UcA.Udb = super.dl(arrayOfByte3);
    int j = arrayOfByte3.length;
    if (((a)localObject6).Udg + j > ((a)localObject6).Ucl)
    {
      ((a)localObject6).Ucl = (((a)localObject6).Udg + j + 128);
      paramArrayOfByte1 = new byte[((a)localObject6).Ucl];
      System.arraycopy(((a)localObject6).Ucr, 0, paramArrayOfByte1, 0, ((a)localObject6).Udg);
      ((a)localObject6).Ucr = paramArrayOfByte1;
    }
    ((a)localObject6).Ucm = (((a)localObject6).Udg + j);
    System.arraycopy(arrayOfByte3, 0, ((a)localObject6).Ucr, ((a)localObject6).Udg, j);
    ((a)localObject6).Udh = j;
    util.ah(((a)localObject6).Ucr, 0, ((a)localObject6).Ucx);
    util.ah(((a)localObject6).Ucr, 2, ((a)localObject6).Udh);
    arrayOfByte3 = ((a)localObject6).hPx();
    util.oF("req2 a1:", util.dw(arrayOfByte3));
    localObject3 = ((c)localObject3).t(522017402L, i, 8256);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).hPD();
    localObject5 = ((r)localObject5).nj(paramInt1, paramInt2);
    localObject6 = paramArrayOfByte2.ds(this.UcA.UcL);
    paramInt1 = 7;
    paramArrayOfByte1 = new byte[0];
    paramArrayOfByte2 = new byte[0];
    if (paramArrayOfByte3.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).dp(paramArrayOfByte3);
      paramInt1 = 8;
    }
    if (arrayOfByte4.length > 0) {
      paramArrayOfByte2 = ((k)localObject7).dq(arrayOfByte4);
    }
    paramArrayOfByte3 = util.hPG();
    arrayOfByte4 = util.hPH();
    paramInt2 = this.UcA.UcO;
    localObject7 = this.UcA.UcN;
    localObject8 = this.UcA.UcQ;
    paramArrayOfByte3 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte3, arrayOfByte4, paramInt2, (byte[])localObject7, new byte[0], (byte[])localObject8), localaa.a(this.UcA.UcW, this.UcA.UcX, this.UcA.UcY, this.UcA.UcU, this.UcA.UcL), localaj.a(522017402L, this.UcA.UcS, this.UcA.UcT), this.UcA.UcC);
    arrayOfByte2 = localae.dr(arrayOfByte2);
    paramInt1 = paramInt1 + 1 + 1;
    if (arrayOfByte1.length > 0)
    {
      paramArrayOfByte2 = localf.jdMethod_do(arrayOfByte1);
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
      paramInt2 = paramArrayOfByte1.length + paramInt2;
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte1, paramInt2, paramArrayOfByte3.length);
      paramInt2 += paramArrayOfByte3.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(localObject6, 0, arrayOfByte1, paramInt2 + paramArrayOfByte2.length, localObject6.length);
      paramArrayOfByte1 = super.aa(arrayOfByte1, this.Ucy, paramInt1);
      a(this.Ucs, this.Ucx, paramLong, this.Ucu, this.Ucv, i, this.Ucw, paramArrayOfByte1);
      paramArrayOfByte1 = super.hPx();
      AppMethodBeat.o(88081);
      return paramArrayOfByte1;
      paramArrayOfByte2 = new byte[0];
    }
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, byte[] paramArrayOfByte4)
  {
    AppMethodBeat.i(88080);
    int i = this.UcA.UcK;
    this.UcA._uin = paramLong;
    util.oF("IMEI", util.dw(this.UcA.UcL));
    byte[] arrayOfByte4 = this.UcA.UcC;
    byte[] arrayOfByte3 = this.UcA.UcL;
    byte[] arrayOfByte1 = this.UcA.UcF.hPA();
    byte[] arrayOfByte2 = this.UcA.UcP;
    Object localObject1 = new an();
    Object localObject2 = new b();
    Object localObject3 = new h();
    Object localObject5 = new r();
    c localc = new c();
    Object localObject4 = new oicq.wlogin_sdk.a.i();
    Object localObject8 = new oicq.wlogin_sdk.a.j();
    Object localObject6 = new k();
    f localf = new f();
    y localy = new y();
    aa localaa = new aa();
    ae localae = new ae();
    ag localag = new ag();
    Object localObject7 = new ah();
    aj localaj = new aj();
    localObject1 = ((an)localObject1).a(522017402L, i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    paramArrayOfByte3 = ((h)localObject3).a(522017402L, i, paramLong, paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, arrayOfByte4, this.UcA.UcX, this.UcA.UcL);
    this.UcA.Udb = super.dl(((a)localObject3).hPA());
    localObject3 = localc.t(522017402L, i, 8256);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).hPD();
    localObject5 = ((r)localObject5).nj(paramInt1, paramInt2);
    localObject7 = ((ah)localObject7).ds(this.UcA.UcL);
    paramInt1 = 7;
    paramArrayOfByte1 = new byte[0];
    paramArrayOfByte2 = new byte[0];
    if (paramArrayOfByte4.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).dp(paramArrayOfByte4);
      paramInt1 = 8;
    }
    if (arrayOfByte3.length > 0) {
      paramArrayOfByte2 = ((k)localObject6).dq(arrayOfByte3);
    }
    paramArrayOfByte4 = util.hPG();
    arrayOfByte3 = util.hPH();
    paramInt2 = this.UcA.UcO;
    localObject6 = this.UcA.UcN;
    localObject8 = this.UcA.UcQ;
    paramArrayOfByte4 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte4, arrayOfByte3, paramInt2, (byte[])localObject6, new byte[0], (byte[])localObject8), localaa.a(this.UcA.UcW, this.UcA.UcX, this.UcA.UcY, this.UcA.UcU, this.UcA.UcL), localaj.a(522017402L, this.UcA.UcS, this.UcA.UcT), this.UcA.UcC);
    arrayOfByte2 = localae.dr(arrayOfByte2);
    paramInt1 = paramInt1 + 1 + 1;
    if (arrayOfByte1.length > 0)
    {
      paramArrayOfByte2 = localf.jdMethod_do(arrayOfByte1);
      paramInt1 += 1;
    }
    for (;;)
    {
      arrayOfByte1 = new byte[localObject1.length + localObject2.length + paramArrayOfByte3.length + localObject5.length + localObject3.length + localObject4.length + paramArrayOfByte1.length + paramArrayOfByte4.length + paramArrayOfByte2.length + arrayOfByte2.length + 0 + localObject7.length];
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
      paramInt2 = paramArrayOfByte1.length + paramInt2;
      System.arraycopy(paramArrayOfByte4, 0, arrayOfByte1, paramInt2, paramArrayOfByte4.length);
      paramInt2 += paramArrayOfByte4.length;
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt2, arrayOfByte2.length);
      paramInt2 += arrayOfByte2.length;
      System.arraycopy(new byte[0], 0, arrayOfByte1, paramInt2, 0);
      paramInt2 += 0;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt2, paramArrayOfByte2.length);
      System.arraycopy(localObject7, 0, arrayOfByte1, paramArrayOfByte2.length + paramInt2, localObject7.length);
      paramArrayOfByte1 = super.aa(arrayOfByte1, this.Ucy, paramInt1);
      a(this.Ucs, this.Ucx, paramLong, this.Ucu, this.Ucv, i, this.Ucw, paramArrayOfByte1);
      paramArrayOfByte1 = super.hPx();
      AppMethodBeat.o(88080);
      return paramArrayOfByte1;
      paramArrayOfByte2 = new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.j
 * JD-Core Version:    0.7.0.1
 */