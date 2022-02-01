package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d
{
  protected static int NQo = 0;
  int NQg;
  int NQh;
  int NQi;
  int NQj;
  public int NQk;
  protected int NQl;
  protected byte[] NQm;
  protected int NQn;
  protected int NQp;
  protected int NQq;
  protected int NQr;
  protected int NQs;
  protected int NQt;
  byte NQu;
  protected i NQv;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.NQg = 4096;
    this.NQh = 0;
    this.NQi = 27;
    this.NQj = 0;
    this.NQk = 15;
    this.NQl = 0;
    this.NQm = new byte[this.NQg];
    this.NQn = 8001;
    this.NQp = 0;
    this.NQq = 0;
    this.NQr = 0;
    this.NQs = 0;
    this.NQt = 0;
    AppMethodBeat.o(88066);
  }
  
  final byte[] P(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.W(arrayOfByte, 0, paramInt1);
    util.W(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.NQv.NQz);
    arrayOfByte = new byte[paramArrayOfByte.length + this.NQv.NQz.length];
    System.arraycopy(this.NQv.NQz, 0, arrayOfByte, 0, this.NQv.NQz.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.NQv.NQz.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.U(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.NQv.NQV;
      byte[] arrayOfByte = new byte[localai.NRK];
      System.arraycopy(localai.NQm, localai.NRb + 6, arrayOfByte, 0, localai.NRK);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.NQv.NQV;
      arrayOfByte = new byte[localai.NRL];
      System.arraycopy(localai.NQm, localai.NRb + 8 + localai.NRK, arrayOfByte, 0, localai.NRL);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.NQv.NQV;
      arrayOfByte = new byte[localai.NRM];
      System.arraycopy(localai.NQm, localai.NRb + 12 + localai.NRK + localai.NRL, arrayOfByte, 0, localai.NRM);
      paramArrayOfByte.NRT = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.NQv.NQV.gxZ();
    AppMethodBeat.o(88071);
  }
  
  public int R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.NQs == 2064) && (this.NQt == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.NQs == 2064) && (this.NQt == 10))
      {
        i = 1;
      }
      else if ((this.NQs == 2064) && (this.NQt == 2))
      {
        i = 2;
      }
      else if ((this.NQs == 2064) && (this.NQt == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = ae(paramArrayOfByte, paramInt1 + 2);
    gxS();
    int j = paramInt1 + 5;
    label318:
    long l3;
    o localo;
    p localp;
    l locall;
    q localq;
    t localt;
    Object localObject13;
    Object localObject12;
    Object localObject11;
    Object localObject10;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject7;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    byte[] arrayOfByte4;
    byte[] arrayOfByte5;
    byte[] arrayOfByte6;
    label627:
    long l1;
    switch (paramInt2)
    {
    default: 
      Q(paramArrayOfByte, j, this.NQh - j - 1);
      paramInt1 = paramInt2;
    case 0: 
      e locale;
      oicq.wlogin_sdk.a.d locald;
      m localm;
      j localj;
      Object localObject8;
      n localn;
      ak localak;
      am localam;
      ac localac;
      for (;;)
      {
        AppMethodBeat.o(88075);
        return paramInt1;
        if (i == 1) {
          if (this.NQv.NQy == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.NQh - j - 1, this.NQv.NQy);; paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.NQh - j - 1, this.NQv.NQx))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.bdE("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
          break;
        }
        l3 = 4294967295L;
        localo = new o();
        localp = new p();
        locall = new l();
        localq = new q();
        locale = new e();
        localt = new t();
        locald = new oicq.wlogin_sdk.a.d();
        localm = new m();
        localObject13 = new u();
        localObject12 = new w();
        localObject11 = new x();
        localj = new j();
        localObject8 = new h();
        localn = new n();
        localObject10 = new z();
        localObject3 = new v();
        localObject4 = new ad();
        localObject5 = new ab();
        localObject6 = new af();
        localObject7 = new ap();
        localak = new ak();
        paramArrayOfByte = new al();
        localam = new am();
        localObject2 = null;
        arrayOfByte1 = null;
        arrayOfByte2 = null;
        arrayOfByte3 = null;
        arrayOfByte4 = null;
        localObject1 = null;
        arrayOfByte5 = null;
        arrayOfByte6 = null;
        localac = new ac();
        localObject9 = ((a)localObject9).gxU();
        paramInt2 = localObject9.length;
        localo.U((byte[])localObject9, 2, paramInt2);
        localp.U((byte[])localObject9, 2, paramInt2);
        locall.U((byte[])localObject9, 2, paramInt2);
        localq.U((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.U((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.bdE("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.U((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.gxU();
      }
      if (localj.U((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.NQv._context, localj.gxU());
      }
      if (locald.U((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.gxU();
      }
      if (localm.U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.gxU();
      }
      if (((a)localObject13).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).gxU();
      }
      if (((a)localObject12).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).gxU();
      }
      if (((a)localObject11).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).gxU();
      }
      if (((a)localObject10).U((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).NRA];
        System.arraycopy(((z)localObject10).NQm, ((z)localObject10).NRb + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).NRB];
        System.arraycopy(((z)localObject10).NQm, ((z)localObject10).NRb + 2 + ((z)localObject10).NRA + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.U((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.gxU();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).U(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.NQv.NQY = ((byte[])paramArrayOfByte.clone());
          util.nH("fast data:", util.dr(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.gxU();
        }
        paramInt1 = localn.U((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).U((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.NQv.NQx = localn.gxU();
          this.NQv.NQW = dg(((a)localObject8).gxU());
          paramArrayOfByte[1] = ((byte[])this.NQv.NQW.clone());
        }
        if (((a)localObject5).U((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).NRD];
          System.arraycopy(((ab)localObject5).NQm, ((ab)localObject5).NRb + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).gxU();
        }
        if (((a)localObject7).U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).gxU();
        }
        if (localak.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.gxU();
        }
        if (localam.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.gxU();
        }
        if (((a)localObject3).U((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.NQv.NQE != -1L) {
          break label1710;
        }
        l1 = util.aj(((v)localObject3).NQm, ((v)localObject3).NRb);
        label1251:
        l3 = 0xFFFFFFFF & util.aj(((v)localObject3).NQm, ((v)localObject3).NRb + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).U((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).gxY() != 0)) {}
      for (long l2 = ((ad)localObject4).gxY();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.NQv;
          long l4 = this.NQv._uin;
          long l5 = this.NQv.NQC;
          long l6 = i.gxT();
          long l7 = i.gxT();
          long l8 = i.gxT();
          localObject4 = new byte[2];
          System.arraycopy(localt.NQm, localt.NRb, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.NQm, localt.NRb + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.NQm, localt.NRb + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.NRy];
          System.arraycopy(localt.NQm, localt.NRb + 2 + 1 + 1 + 1, localObject7, 0, localt.NRy);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.gxU(), localo.gxU(), localq.gxU(), localp.gxU(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).U(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).U(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).gxR();
          localObject13 = ((a)localObject13).gxR();
          localObject11 = ((a)localObject11).gxR();
          localObject10 = ((ah)localObject10).dn(this.NQv.NQG);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.W(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.NQv.NQY = new byte[0];
          break label969;
          label1710:
          l1 = this.NQv.NQE;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          Q(paramArrayOfByte, j, this.NQh - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).U(paramArrayOfByte, j, this.NQh - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.NQv.NQA = ((f)localObject1);
            i = ((a)localObject2).U(paramArrayOfByte, j, this.NQh - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.NQv.NQB = ((g)localObject2);
              paramInt1 = paramInt2;
              break;
            }
          }
          break;
        }
      }
      label1839:
      l1 = 3600L;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88067);
    int i = paramArrayOfByte.length;
    int j = NQo + 1;
    NQo = j;
    this.NQh = 0;
    util.V(this.NQm, this.NQh, 2);
    this.NQh += 1;
    util.W(this.NQm, this.NQh, this.NQi + 2 + i);
    this.NQh += 2;
    util.W(this.NQm, this.NQh, paramInt1);
    this.NQh += 2;
    util.W(this.NQm, this.NQh, paramInt2);
    this.NQh += 2;
    util.W(this.NQm, this.NQh, j);
    this.NQh += 2;
    util.X(this.NQm, this.NQh, (int)paramLong);
    this.NQh += 4;
    util.V(this.NQm, this.NQh, 3);
    this.NQh += 1;
    util.V(this.NQm, this.NQh, 0);
    this.NQh += 1;
    util.V(this.NQm, this.NQh, paramInt3);
    this.NQh += 1;
    util.X(this.NQm, this.NQh, paramInt4);
    this.NQh += 4;
    util.X(this.NQm, this.NQh, paramInt5);
    this.NQh += 4;
    util.X(this.NQm, this.NQh, paramInt6);
    this.NQh += 4;
    if (this.NQh + i + 1 > this.NQg)
    {
      this.NQg = (this.NQh + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.NQg];
      System.arraycopy(this.NQm, 0, arrayOfByte, 0, this.NQh);
      this.NQm = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.NQm, this.NQh, i);
    this.NQh = (i + this.NQh);
    util.V(this.NQm, this.NQh, 3);
    this.NQh += 1;
    AppMethodBeat.o(88067);
  }
  
  public final int ad(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.NQk + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.NQl = (paramInt - this.NQk - 2);
    if (paramInt > this.NQg)
    {
      this.NQg = (paramInt + 128);
      this.NQm = new byte[this.NQg];
    }
    this.NQh = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.NQm, 0, paramInt);
    paramArrayOfByte = this.NQm;
    paramInt = this.NQk + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.NQl, this.NQv.NQz);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.NQl = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.NQk + 2 > this.NQg)
      {
        this.NQg = (paramArrayOfByte.length + this.NQk + 2);
        byte[] arrayOfByte = new byte[this.NQg];
        System.arraycopy(this.NQm, 0, arrayOfByte, 0, this.NQh);
        this.NQm = arrayOfByte;
      }
      this.NQh = 0;
      System.arraycopy(paramArrayOfByte, 0, this.NQm, paramInt, paramArrayOfByte.length);
      paramInt = this.NQh;
      int j = this.NQk;
      this.NQh = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = R(this.NQm, this.NQk + 1, this.NQl);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int ae(byte[] paramArrayOfByte, int paramInt)
  {
    this.NQu = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] dg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.NQv.NQx.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.NQv.NQx, 0, arrayOfByte, paramArrayOfByte.length, this.NQv.NQx.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] dh(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88074);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
    {
      AppMethodBeat.o(88074);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    int i = paramArrayOfByte.length - 16;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    this.NQv.NQx = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.NQv.NQx, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] gxR()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.NQh];
    System.arraycopy(this.NQm, 0, arrayOfByte, 0, this.NQh);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void gxS()
  {
    AppMethodBeat.i(88072);
    this.NQv.NQV.gxZ();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */