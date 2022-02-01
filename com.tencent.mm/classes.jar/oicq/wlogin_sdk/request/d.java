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
  protected static int Uct = 0;
  protected i UcA;
  int Ucl;
  int Ucm;
  int Ucn;
  int Uco;
  public int Ucp;
  protected int Ucq;
  protected byte[] Ucr;
  protected int Ucs;
  protected int Ucu;
  protected int Ucv;
  protected int Ucw;
  protected int Ucx;
  protected int Ucy;
  byte Ucz;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.Ucl = 4096;
    this.Ucm = 0;
    this.Ucn = 27;
    this.Uco = 0;
    this.Ucp = 15;
    this.Ucq = 0;
    this.Ucr = new byte[this.Ucl];
    this.Ucs = 8001;
    this.Ucu = 0;
    this.Ucv = 0;
    this.Ucw = 0;
    this.Ucx = 0;
    this.Ucy = 0;
    AppMethodBeat.o(88066);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88067);
    int i = paramArrayOfByte.length;
    int j = Uct + 1;
    Uct = j;
    this.Ucm = 0;
    util.ag(this.Ucr, this.Ucm, 2);
    this.Ucm += 1;
    util.ah(this.Ucr, this.Ucm, this.Ucn + 2 + i);
    this.Ucm += 2;
    util.ah(this.Ucr, this.Ucm, paramInt1);
    this.Ucm += 2;
    util.ah(this.Ucr, this.Ucm, paramInt2);
    this.Ucm += 2;
    util.ah(this.Ucr, this.Ucm, j);
    this.Ucm += 2;
    util.ai(this.Ucr, this.Ucm, (int)paramLong);
    this.Ucm += 4;
    util.ag(this.Ucr, this.Ucm, 3);
    this.Ucm += 1;
    util.ag(this.Ucr, this.Ucm, 0);
    this.Ucm += 1;
    util.ag(this.Ucr, this.Ucm, paramInt3);
    this.Ucm += 1;
    util.ai(this.Ucr, this.Ucm, paramInt4);
    this.Ucm += 4;
    util.ai(this.Ucr, this.Ucm, paramInt5);
    this.Ucm += 4;
    util.ai(this.Ucr, this.Ucm, paramInt6);
    this.Ucm += 4;
    if (this.Ucm + i + 1 > this.Ucl)
    {
      this.Ucl = (this.Ucm + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.Ucl];
      System.arraycopy(this.Ucr, 0, arrayOfByte, 0, this.Ucm);
      this.Ucr = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.Ucr, this.Ucm, i);
    this.Ucm = (i + this.Ucm);
    util.ag(this.Ucr, this.Ucm, 3);
    this.Ucm += 1;
    AppMethodBeat.o(88067);
  }
  
  final byte[] aa(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.ah(arrayOfByte, 0, paramInt1);
    util.ah(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.UcA.UcE);
    arrayOfByte = new byte[paramArrayOfByte.length + this.UcA.UcE.length];
    System.arraycopy(this.UcA.UcE, 0, arrayOfByte, 0, this.UcA.UcE.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.UcA.UcE.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void ab(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.af(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.UcA.Uda;
      byte[] arrayOfByte = new byte[localai.UdP];
      System.arraycopy(localai.Ucr, localai.Udg + 6, arrayOfByte, 0, localai.UdP);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.UcA.Uda;
      arrayOfByte = new byte[localai.UdQ];
      System.arraycopy(localai.Ucr, localai.Udg + 8 + localai.UdP, arrayOfByte, 0, localai.UdQ);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.UcA.Uda;
      arrayOfByte = new byte[localai.UdR];
      System.arraycopy(localai.Ucr, localai.Udg + 12 + localai.UdP + localai.UdQ, arrayOfByte, 0, localai.UdR);
      paramArrayOfByte.UdY = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.UcA.Uda.hPF();
    AppMethodBeat.o(88071);
  }
  
  public int ac(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.Ucx == 2064) && (this.Ucy == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.Ucx == 2064) && (this.Ucy == 10))
      {
        i = 1;
      }
      else if ((this.Ucx == 2064) && (this.Ucy == 2))
      {
        i = 2;
      }
      else if ((this.Ucx == 2064) && (this.Ucy == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = aj(paramArrayOfByte, paramInt1 + 2);
    hPy();
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
      ab(paramArrayOfByte, j, this.Ucm - j - 1);
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
          if (this.UcA.UcD == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.Ucm - j - 1, this.UcA.UcD);; paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.Ucm - j - 1, this.UcA.UcC))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.buY("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).hPA();
        paramInt2 = localObject9.length;
        localo.af((byte[])localObject9, 2, paramInt2);
        localp.af((byte[])localObject9, 2, paramInt2);
        locall.af((byte[])localObject9, 2, paramInt2);
        localq.af((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.af((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.buY("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.af((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.hPA();
      }
      if (localj.af((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.UcA._context, localj.hPA());
      }
      if (locald.af((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.hPA();
      }
      if (localm.af((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.hPA();
      }
      if (((a)localObject13).af((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).hPA();
      }
      if (((a)localObject12).af((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).hPA();
      }
      if (((a)localObject11).af((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).hPA();
      }
      if (((a)localObject10).af((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).UdF];
        System.arraycopy(((z)localObject10).Ucr, ((z)localObject10).Udg + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).UdG];
        System.arraycopy(((z)localObject10).Ucr, ((z)localObject10).Udg + 2 + ((z)localObject10).UdF + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.af((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.hPA();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).af(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.UcA.Udd = ((byte[])paramArrayOfByte.clone());
          util.oF("fast data:", util.dw(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.af((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.hPA();
        }
        paramInt1 = localn.af((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).af((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.UcA.UcC = localn.hPA();
          this.UcA.Udb = dl(((a)localObject8).hPA());
          paramArrayOfByte[1] = ((byte[])this.UcA.Udb.clone());
        }
        if (((a)localObject5).af((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).UdI];
          System.arraycopy(((ab)localObject5).Ucr, ((ab)localObject5).Udg + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).af((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).hPA();
        }
        if (((a)localObject7).af((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).hPA();
        }
        if (localak.af((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.hPA();
        }
        if (localam.af((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.hPA();
        }
        if (((a)localObject3).af((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.UcA.UcJ != -1L) {
          break label1710;
        }
        l1 = util.ao(((v)localObject3).Ucr, ((v)localObject3).Udg);
        label1251:
        l3 = 0xFFFFFFFF & util.ao(((v)localObject3).Ucr, ((v)localObject3).Udg + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).af((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).hPE() != 0)) {}
      for (long l2 = ((ad)localObject4).hPE();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.UcA;
          long l4 = this.UcA._uin;
          long l5 = this.UcA.UcH;
          long l6 = i.hPz();
          long l7 = i.hPz();
          long l8 = i.hPz();
          localObject4 = new byte[2];
          System.arraycopy(localt.Ucr, localt.Udg, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.Ucr, localt.Udg + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.Ucr, localt.Udg + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.UdD];
          System.arraycopy(localt.Ucr, localt.Udg + 2 + 1 + 1 + 1, localObject7, 0, localt.UdD);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.hPA(), localo.hPA(), localq.hPA(), localp.hPA(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).af(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).af(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).hPx();
          localObject13 = ((a)localObject13).hPx();
          localObject11 = ((a)localObject11).hPx();
          localObject10 = ((ah)localObject10).ds(this.UcA.UcL);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.ah(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.UcA.Udd = new byte[0];
          break label969;
          label1710:
          l1 = this.UcA.UcJ;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          ab(paramArrayOfByte, j, this.Ucm - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).af(paramArrayOfByte, j, this.Ucm - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.UcA.UcF = ((f)localObject1);
            i = ((a)localObject2).af(paramArrayOfByte, j, this.Ucm - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.UcA.UcG = ((g)localObject2);
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
  
  public final int ai(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.Ucp + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.Ucq = (paramInt - this.Ucp - 2);
    if (paramInt > this.Ucl)
    {
      this.Ucl = (paramInt + 128);
      this.Ucr = new byte[this.Ucl];
    }
    this.Ucm = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Ucr, 0, paramInt);
    paramArrayOfByte = this.Ucr;
    paramInt = this.Ucp + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.Ucq, this.UcA.UcE);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.Ucq = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.Ucp + 2 > this.Ucl)
      {
        this.Ucl = (paramArrayOfByte.length + this.Ucp + 2);
        byte[] arrayOfByte = new byte[this.Ucl];
        System.arraycopy(this.Ucr, 0, arrayOfByte, 0, this.Ucm);
        this.Ucr = arrayOfByte;
      }
      this.Ucm = 0;
      System.arraycopy(paramArrayOfByte, 0, this.Ucr, paramInt, paramArrayOfByte.length);
      paramInt = this.Ucm;
      int j = this.Ucp;
      this.Ucm = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = ac(this.Ucr, this.Ucp + 1, this.Ucq);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int aj(byte[] paramArrayOfByte, int paramInt)
  {
    this.Ucz = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] dl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.UcA.UcC.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.UcA.UcC, 0, arrayOfByte, paramArrayOfByte.length, this.UcA.UcC.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] dm(byte[] paramArrayOfByte)
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
    this.UcA.UcC = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.UcA.UcC, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] hPx()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.Ucm];
    System.arraycopy(this.Ucr, 0, arrayOfByte, 0, this.Ucm);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void hPy()
  {
    AppMethodBeat.i(88072);
    this.UcA.Uda.hPF();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */