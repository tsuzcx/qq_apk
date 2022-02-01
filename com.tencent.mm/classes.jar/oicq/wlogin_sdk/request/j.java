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
    this.LVT = 2064;
    this.LVU = 9;
    this.LVW = parami;
  }
  
  public final byte[] a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(88081);
    int i = this.LVW.LWg;
    this.LVW._uin = paramLong;
    byte[] arrayOfByte3 = super.da(paramArrayOfByte2);
    if (arrayOfByte3 == null)
    {
      AppMethodBeat.o(88081);
      return null;
    }
    paramArrayOfByte2 = this.LVW.LWh;
    byte[] arrayOfByte1 = this.LVW.LWb.gfw();
    byte[] arrayOfByte2 = this.LVW.LWl;
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
    localObject1 = ((an)localObject1).aP(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    this.LVW.LWx = super.cZ(arrayOfByte3);
    int j = arrayOfByte3.length;
    if (((a)localObject9).LWC + j > ((a)localObject9).LVH)
    {
      ((a)localObject9).LVH = (((a)localObject9).LWC + j + 128);
      paramArrayOfByte1 = new byte[((a)localObject9).LVH];
      System.arraycopy(((a)localObject9).LVN, 0, paramArrayOfByte1, 0, ((a)localObject9).LWC);
      ((a)localObject9).LVN = paramArrayOfByte1;
    }
    ((a)localObject9).LVI = (((a)localObject9).LWC + j);
    System.arraycopy(arrayOfByte3, 0, ((a)localObject9).LVN, ((a)localObject9).LWC, j);
    ((a)localObject9).LWD = j;
    util.V(((a)localObject9).LVN, 0, ((a)localObject9).LVT);
    util.V(((a)localObject9).LVN, 2, ((a)localObject9).LWD);
    arrayOfByte3 = ((a)localObject9).gft();
    util.ni("req2 a1:", util.dk(arrayOfByte3));
    localObject3 = ((c)localObject3).ajm(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).gfz();
    localObject5 = ((r)localObject5).lp(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).dg(this.LVW.LWh);
    if (paramArrayOfByte3.length > 0) {
      paramArrayOfByte1 = ((oicq.wlogin_sdk.a.j)localObject8).dd(paramArrayOfByte3);
    }
    for (paramInt1 = 8;; paramInt1 = 7)
    {
      if (paramArrayOfByte2.length > 0) {}
      for (paramArrayOfByte2 = ((k)localObject7).de(paramArrayOfByte2);; paramArrayOfByte2 = new byte[0])
      {
        paramArrayOfByte3 = util.gfC();
        localObject7 = util.gfD();
        paramInt2 = this.LVW.LWk;
        localObject8 = this.LVW.LWj;
        localObject9 = this.LVW.LWm;
        paramArrayOfByte3 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte3, (byte[])localObject7, paramInt2, (byte[])localObject8, new byte[0], (byte[])localObject9), localaa.a(this.LVW.LWs, this.LVW.LWt, this.LVW.LWu, this.LVW.LWq, this.LVW.LWh), localaj.q(this.LVW.LWo, this.LVW.LWp), this.LVW.LVY);
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
          paramArrayOfByte1 = super.O(arrayOfByte1, this.LVU, paramInt1);
          a(this.LVO, this.LVT, paramLong, this.LVQ, this.LVR, i, this.LVS, paramArrayOfByte1);
          paramArrayOfByte1 = super.gft();
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
    int i = this.LVW.LWg;
    this.LVW._uin = paramLong;
    util.ni("IMEI", util.dk(this.LVW.LWh));
    byte[] arrayOfByte4 = this.LVW.LVY;
    byte[] arrayOfByte3 = this.LVW.LWh;
    byte[] arrayOfByte1 = this.LVW.LWb.gfw();
    byte[] arrayOfByte2 = this.LVW.LWl;
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
    localObject1 = ((an)localObject1).aP(i, paramLong);
    localObject2 = ((b)localObject2).g(paramLong, paramArrayOfByte1);
    paramArrayOfByte3 = ((h)localObject3).a(i, paramLong, paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte3, arrayOfByte4, this.LVW.LWt, this.LVW.LWh);
    this.LVW.LWx = super.cZ(((a)localObject3).gfw());
    localObject3 = localc.ajm(i);
    localObject4 = ((oicq.wlogin_sdk.a.i)localObject4).gfz();
    localObject5 = ((r)localObject5).lp(paramInt1, paramInt2);
    localObject6 = ((ah)localObject6).dg(this.LVW.LWh);
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
        paramArrayOfByte4 = util.gfC();
        arrayOfByte3 = util.gfD();
        paramInt2 = this.LVW.LWk;
        localObject7 = this.LVW.LWj;
        localObject8 = this.LVW.LWm;
        paramArrayOfByte4 = localag.a(paramArrayOfByte2, localy.a(paramArrayOfByte4, arrayOfByte3, paramInt2, (byte[])localObject7, new byte[0], (byte[])localObject8), localaa.a(this.LVW.LWs, this.LVW.LWt, this.LVW.LWu, this.LVW.LWq, this.LVW.LWh), localaj.q(this.LVW.LWo, this.LVW.LWp), this.LVW.LVY);
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
          paramArrayOfByte1 = super.O(arrayOfByte1, this.LVU, paramInt1);
          a(this.LVO, this.LVT, paramLong, this.LVQ, this.LVR, i, this.LVS, paramArrayOfByte1);
          paramArrayOfByte1 = super.gft();
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