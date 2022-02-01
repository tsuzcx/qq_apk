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
  protected static int Onu = 0;
  byte OnA;
  protected i OnB;
  int Onm;
  int Onn;
  int Ono;
  int Onp;
  public int Onq;
  protected int Onr;
  protected byte[] Ons;
  protected int Ont;
  protected int Onv;
  protected int Onw;
  protected int Onx;
  protected int Ony;
  protected int Onz;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.Onm = 4096;
    this.Onn = 0;
    this.Ono = 27;
    this.Onp = 0;
    this.Onq = 15;
    this.Onr = 0;
    this.Ons = new byte[this.Onm];
    this.Ont = 8001;
    this.Onv = 0;
    this.Onw = 0;
    this.Onx = 0;
    this.Ony = 0;
    this.Onz = 0;
    AppMethodBeat.o(88066);
  }
  
  final byte[] Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.X(arrayOfByte, 0, paramInt1);
    util.X(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.OnB.OnF);
    arrayOfByte = new byte[paramArrayOfByte.length + this.OnB.OnF.length];
    System.arraycopy(this.OnB.OnF, 0, arrayOfByte, 0, this.OnB.OnF.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.OnB.OnF.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.V(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.OnB.Oob;
      byte[] arrayOfByte = new byte[localai.OoQ];
      System.arraycopy(localai.Ons, localai.Ooh + 6, arrayOfByte, 0, localai.OoQ);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.OnB.Oob;
      arrayOfByte = new byte[localai.OoR];
      System.arraycopy(localai.Ons, localai.Ooh + 8 + localai.OoQ, arrayOfByte, 0, localai.OoR);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.OnB.Oob;
      arrayOfByte = new byte[localai.OoS];
      System.arraycopy(localai.Ons, localai.Ooh + 12 + localai.OoQ + localai.OoR, arrayOfByte, 0, localai.OoS);
      paramArrayOfByte.OoZ = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.OnB.Oob.gCB();
    AppMethodBeat.o(88071);
  }
  
  public int S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.Ony == 2064) && (this.Onz == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.Ony == 2064) && (this.Onz == 10))
      {
        i = 1;
      }
      else if ((this.Ony == 2064) && (this.Onz == 2))
      {
        i = 2;
      }
      else if ((this.Ony == 2064) && (this.Onz == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = ai(paramArrayOfByte, paramInt1 + 2);
    gCu();
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
      R(paramArrayOfByte, j, this.Onn - j - 1);
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
          if (this.OnB.OnE == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.Onn - j - 1, this.OnB.OnE);; paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.Onn - j - 1, this.OnB.OnD))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.bfi("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).gCw();
        paramInt2 = localObject9.length;
        localo.V((byte[])localObject9, 2, paramInt2);
        localp.V((byte[])localObject9, 2, paramInt2);
        locall.V((byte[])localObject9, 2, paramInt2);
        localq.V((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.V((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.bfi("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.V((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.gCw();
      }
      if (localj.V((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.OnB._context, localj.gCw());
      }
      if (locald.V((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.gCw();
      }
      if (localm.V((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.gCw();
      }
      if (((a)localObject13).V((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).gCw();
      }
      if (((a)localObject12).V((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).gCw();
      }
      if (((a)localObject11).V((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).gCw();
      }
      if (((a)localObject10).V((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).OoG];
        System.arraycopy(((z)localObject10).Ons, ((z)localObject10).Ooh + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).OoH];
        System.arraycopy(((z)localObject10).Ons, ((z)localObject10).Ooh + 2 + ((z)localObject10).OoG + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.V((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.gCw();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).V(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.OnB.Ooe = ((byte[])paramArrayOfByte.clone());
          util.nN("fast data:", util.du(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.V((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.gCw();
        }
        paramInt1 = localn.V((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).V((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.OnB.OnD = localn.gCw();
          this.OnB.Ooc = dj(((a)localObject8).gCw());
          paramArrayOfByte[1] = ((byte[])this.OnB.Ooc.clone());
        }
        if (((a)localObject5).V((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).OoJ];
          System.arraycopy(((ab)localObject5).Ons, ((ab)localObject5).Ooh + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).V((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).gCw();
        }
        if (((a)localObject7).V((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).gCw();
        }
        if (localak.V((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.gCw();
        }
        if (localam.V((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.gCw();
        }
        if (((a)localObject3).V((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.OnB.OnK != -1L) {
          break label1710;
        }
        l1 = util.an(((v)localObject3).Ons, ((v)localObject3).Ooh);
        label1251:
        l3 = 0xFFFFFFFF & util.an(((v)localObject3).Ons, ((v)localObject3).Ooh + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).V((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).gCA() != 0)) {}
      for (long l2 = ((ad)localObject4).gCA();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.OnB;
          long l4 = this.OnB._uin;
          long l5 = this.OnB.OnI;
          long l6 = i.gCv();
          long l7 = i.gCv();
          long l8 = i.gCv();
          localObject4 = new byte[2];
          System.arraycopy(localt.Ons, localt.Ooh, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.Ons, localt.Ooh + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.Ons, localt.Ooh + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.OoE];
          System.arraycopy(localt.Ons, localt.Ooh + 2 + 1 + 1 + 1, localObject7, 0, localt.OoE);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.gCw(), localo.gCw(), localq.gCw(), localp.gCw(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).V(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).V(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).gCt();
          localObject13 = ((a)localObject13).gCt();
          localObject11 = ((a)localObject11).gCt();
          localObject10 = ((ah)localObject10).dq(this.OnB.OnM);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.X(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.OnB.Ooe = new byte[0];
          break label969;
          label1710:
          l1 = this.OnB.OnK;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          R(paramArrayOfByte, j, this.Onn - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).V(paramArrayOfByte, j, this.Onn - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.OnB.OnG = ((f)localObject1);
            i = ((a)localObject2).V(paramArrayOfByte, j, this.Onn - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.OnB.OnH = ((g)localObject2);
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
    int j = Onu + 1;
    Onu = j;
    this.Onn = 0;
    util.W(this.Ons, this.Onn, 2);
    this.Onn += 1;
    util.X(this.Ons, this.Onn, this.Ono + 2 + i);
    this.Onn += 2;
    util.X(this.Ons, this.Onn, paramInt1);
    this.Onn += 2;
    util.X(this.Ons, this.Onn, paramInt2);
    this.Onn += 2;
    util.X(this.Ons, this.Onn, j);
    this.Onn += 2;
    util.Y(this.Ons, this.Onn, (int)paramLong);
    this.Onn += 4;
    util.W(this.Ons, this.Onn, 3);
    this.Onn += 1;
    util.W(this.Ons, this.Onn, 0);
    this.Onn += 1;
    util.W(this.Ons, this.Onn, paramInt3);
    this.Onn += 1;
    util.Y(this.Ons, this.Onn, paramInt4);
    this.Onn += 4;
    util.Y(this.Ons, this.Onn, paramInt5);
    this.Onn += 4;
    util.Y(this.Ons, this.Onn, paramInt6);
    this.Onn += 4;
    if (this.Onn + i + 1 > this.Onm)
    {
      this.Onm = (this.Onn + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.Onm];
      System.arraycopy(this.Ons, 0, arrayOfByte, 0, this.Onn);
      this.Ons = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.Ons, this.Onn, i);
    this.Onn = (i + this.Onn);
    util.W(this.Ons, this.Onn, 3);
    this.Onn += 1;
    AppMethodBeat.o(88067);
  }
  
  public final int ah(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.Onq + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.Onr = (paramInt - this.Onq - 2);
    if (paramInt > this.Onm)
    {
      this.Onm = (paramInt + 128);
      this.Ons = new byte[this.Onm];
    }
    this.Onn = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Ons, 0, paramInt);
    paramArrayOfByte = this.Ons;
    paramInt = this.Onq + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.Onr, this.OnB.OnF);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.Onr = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.Onq + 2 > this.Onm)
      {
        this.Onm = (paramArrayOfByte.length + this.Onq + 2);
        byte[] arrayOfByte = new byte[this.Onm];
        System.arraycopy(this.Ons, 0, arrayOfByte, 0, this.Onn);
        this.Ons = arrayOfByte;
      }
      this.Onn = 0;
      System.arraycopy(paramArrayOfByte, 0, this.Ons, paramInt, paramArrayOfByte.length);
      paramInt = this.Onn;
      int j = this.Onq;
      this.Onn = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = S(this.Ons, this.Onq + 1, this.Onr);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int ai(byte[] paramArrayOfByte, int paramInt)
  {
    this.OnA = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] dj(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.OnB.OnD.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.OnB.OnD, 0, arrayOfByte, paramArrayOfByte.length, this.OnB.OnD.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] dk(byte[] paramArrayOfByte)
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
    this.OnB.OnD = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.OnB.OnD, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] gCt()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.Onn];
    System.arraycopy(this.Ons, 0, arrayOfByte, 0, this.Onn);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void gCu()
  {
    AppMethodBeat.i(88072);
    this.OnB.Oob.gCB();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */