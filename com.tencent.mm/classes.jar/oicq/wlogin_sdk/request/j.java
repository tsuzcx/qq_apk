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
    this.Kik = 2064;
    this.Kil = 9;
    this.Kin = parami;
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(88081);
    int i = this.Kin.Kix;
    this.Kin._uin = paramLong;
    byte[] arrayOfByte3 = super.da(paramArrayOfByte2);
    if (arrayOfByte3 == null)
    {
      AppMethodBeat.o(88081);
      return null;
    }
    paramArrayOfByte2 = this.Kin.Kiy;
    byte[] arrayOfByte1 = this.Kin.Kis.fMG();
    byte[] arrayOfByte2 = this.Kin.KiC;
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
    localObject1 = ((an)localObject1).aH(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    this.Kin.KiO = super.cZ(arrayOfByte3);
    int j = arrayOfByte3.length;
    if (((a)localObject9).KiT + j > ((a)localObject9).KhY)
    {
      ((a)localObject9).KhY = (((a)localObject9).KiT + j + 128);
      paramArrayOfByte1 = new byte[((a)localObject9).KhY];
      System.arraycopy(((a)localObject9).Kie, 0, paramArrayOfByte1, 0, ((a)localObject9).KiT);
      ((a)localObject9).Kie = paramArrayOfByte1;
    }
    ((a)localObject9).KhZ = (((a)localObject9).KiT + j);
    System.arraycopy(arrayOfByte3, 0, ((a)localObject9).Kie, ((a)localObject9).KiT, j);
    ((a)localObject9).KiU = j;
    util.W(((a)localObject9).Kie, 0, ((a)localObject9).Kik);
    util.W(((a)localObject9).Kie, 2, ((a)localObject9).KiU);
    arrayOfByte3 = ((a)localObject9).fMD();
    util.mI("req2 a1:", util.dk(arrayOfByte3));
    localObject3 = ((c)localObject3).agq(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).fMJ();
    localObject5 = ((r)localObject5).kZ(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).dg(this.Kin.Kiy);
    if (paramArrayOfByte3.length > 0) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).dd(paramArrayOfByte3);
    }
    for (paramInt1 = 8;; paramInt1 = 7)
    {
      if (paramArrayOfByte2.length > 0) {}
      for (paramArrayOfByte2 = ((k)localObject7).de(paramArrayOfByte2);; paramArrayOfByte2 = new byte[0])
      {
        paramArrayOfByte3 = util.fMM();
        localObject7 = util.fMN();
        paramInt2 = this.Kin.KiB;
        localObject8 = this.Kin.KiA;
        localObject9 = this.Kin.KiD;
        paramArrayOfByte3 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte3, (byte[])localObject7, paramInt2, (byte[])localObject8, new byte[0], (byte[])localObject9), localaa.a(this.Kin.KiJ, this.Kin.KiK, this.Kin.KiL, this.Kin.KiH, this.Kin.Kiy), localaj.q(this.Kin.KiF, this.Kin.KiG), this.Kin.Kip);
        arrayOfByte2 = localae.df(arrayOfByte2);
        paramInt1 = paramInt1 + 1 + 1;
        if (arrayOfByte1.length > 0)
        {
          paramArrayOfByte2 = localf.dc(arrayOfByte1);
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
          paramArrayOfByte1 = super.P(arrayOfByte1, this.Kil, paramInt1);
          a(this.Kif, this.Kik, paramLong, this.Kih, this.Kii, i, this.Kij, paramArrayOfByte1);
          paramArrayOfByte1 = super.fMD();
          AppMethodBeat.o(88081);
          return paramArrayOfByte1;
          paramArrayOfByte2 = new byte[0];
        }
      }
      paramArrayOfByte1 = new byte[0];
    }
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, byte[] paramArrayOfByte4)
  {
    AppMethodBeat.i(88080);
    int i = this.Kin.Kix;
    this.Kin._uin = paramLong;
    util.mI("IMEI", util.dk(this.Kin.Kiy));
    byte[] arrayOfByte4 = this.Kin.Kip;
    byte[] arrayOfByte3 = this.Kin.Kiy;
    byte[] arrayOfByte1 = this.Kin.Kis.fMG();
    byte[] arrayOfByte2 = this.Kin.KiC;
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
    localObject1 = ((an)localObject1).aH(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    paramArrayOfByte3 = ((h)localObject3).a(i, paramLong, paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, arrayOfByte4, this.Kin.KiK, this.Kin.Kiy);
    this.Kin.KiO = super.cZ(((a)localObject3).fMG());
    localObject3 = localc.agq(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).fMJ();
    localObject5 = ((r)localObject5).kZ(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).dg(this.Kin.Kiy);
    paramInt1 = 7;
    if (paramArrayOfByte4.length > 0)
    {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).dd(paramArrayOfByte4);
      paramInt1 = 8;
    }
    for (;;)
    {
      if (arrayOfByte3.length > 0) {}
      for (paramArrayOfByte2 = ((k)localObject7).de(arrayOfByte3);; paramArrayOfByte2 = new byte[0])
      {
        paramArrayOfByte4 = util.fMM();
        arrayOfByte3 = util.fMN();
        paramInt2 = this.Kin.KiB;
        localObject7 = this.Kin.KiA;
        localObject8 = this.Kin.KiD;
        paramArrayOfByte4 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte4, arrayOfByte3, paramInt2, (byte[])localObject7, new byte[0], (byte[])localObject8), localaa.a(this.Kin.KiJ, this.Kin.KiK, this.Kin.KiL, this.Kin.KiH, this.Kin.Kiy), localaj.q(this.Kin.KiF, this.Kin.KiG), this.Kin.Kip);
        arrayOfByte2 = localae.df(arrayOfByte2);
        paramInt1 = paramInt1 + 1 + 1;
        if (arrayOfByte1.length > 0)
        {
          paramArrayOfByte2 = localf.dc(arrayOfByte1);
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
          paramArrayOfByte1 = super.P(arrayOfByte1, this.Kil, paramInt1);
          a(this.Kif, this.Kik, paramLong, this.Kih, this.Kii, i, this.Kij, paramArrayOfByte1);
          paramArrayOfByte1 = super.fMD();
          AppMethodBeat.o(88080);
          return paramArrayOfByte1;
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