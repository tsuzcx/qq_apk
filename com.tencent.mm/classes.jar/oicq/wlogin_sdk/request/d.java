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
  protected static int ajGM = 0;
  int ajGE;
  int ajGF;
  int ajGG;
  int ajGH;
  public int ajGI;
  protected int ajGJ;
  protected byte[] ajGK;
  protected int ajGL;
  protected int ajGN;
  protected int ajGO;
  protected int ajGP;
  protected int ajGQ;
  protected int ajGR;
  byte ajGS;
  protected i ajGT;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.ajGE = 4096;
    this.ajGF = 0;
    this.ajGG = 27;
    this.ajGH = 0;
    this.ajGI = 15;
    this.ajGJ = 0;
    this.ajGK = new byte[this.ajGE];
    this.ajGL = 8001;
    this.ajGN = 0;
    this.ajGO = 0;
    this.ajGP = 0;
    this.ajGQ = 0;
    this.ajGR = 0;
    AppMethodBeat.o(88066);
  }
  
  final byte[] Z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.ag(arrayOfByte, 0, paramInt1);
    util.ag(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.c(arrayOfByte, arrayOfByte.length, this.ajGT.ajGX);
    arrayOfByte = new byte[paramArrayOfByte.length + this.ajGT.ajGX.length];
    System.arraycopy(this.ajGT.ajGX, 0, arrayOfByte, 0, this.ajGT.ajGX.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.ajGT.ajGX.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88067);
    int i = paramArrayOfByte.length;
    int j = ajGM + 1;
    ajGM = j;
    this.ajGF = 0;
    util.af(this.ajGK, this.ajGF, 2);
    this.ajGF += 1;
    util.ag(this.ajGK, this.ajGF, this.ajGG + 2 + i);
    this.ajGF += 2;
    util.ag(this.ajGK, this.ajGF, paramInt1);
    this.ajGF += 2;
    util.ag(this.ajGK, this.ajGF, paramInt2);
    this.ajGF += 2;
    util.ag(this.ajGK, this.ajGF, j);
    this.ajGF += 2;
    util.ah(this.ajGK, this.ajGF, (int)paramLong);
    this.ajGF += 4;
    util.af(this.ajGK, this.ajGF, 3);
    this.ajGF += 1;
    util.af(this.ajGK, this.ajGF, 0);
    this.ajGF += 1;
    util.af(this.ajGK, this.ajGF, paramInt3);
    this.ajGF += 1;
    util.ah(this.ajGK, this.ajGF, paramInt4);
    this.ajGF += 4;
    util.ah(this.ajGK, this.ajGF, paramInt5);
    this.ajGF += 4;
    util.ah(this.ajGK, this.ajGF, paramInt6);
    this.ajGF += 4;
    if (this.ajGF + i + 1 > this.ajGE)
    {
      this.ajGE = (this.ajGF + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.ajGE];
      System.arraycopy(this.ajGK, 0, arrayOfByte, 0, this.ajGF);
      this.ajGK = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.ajGK, this.ajGF, i);
    this.ajGF = (i + this.ajGF);
    util.af(this.ajGK, this.ajGF, 3);
    this.ajGF += 1;
    AppMethodBeat.o(88067);
  }
  
  public final void aa(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.ae(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.ajGT.ajHt;
      byte[] arrayOfByte = new byte[localai.ajIi];
      System.arraycopy(localai.ajGK, localai.ajHz + 6, arrayOfByte, 0, localai.ajIi);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.ajGT.ajHt;
      arrayOfByte = new byte[localai.ajIj];
      System.arraycopy(localai.ajGK, localai.ajHz + 8 + localai.ajIi, arrayOfByte, 0, localai.ajIj);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.ajGT.ajHt;
      arrayOfByte = new byte[localai.ajIk];
      System.arraycopy(localai.ajGK, localai.ajHz + 12 + localai.ajIi + localai.ajIj, arrayOfByte, 0, localai.ajIk);
      paramArrayOfByte.ajIr = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.ajGT.ajHt.kGo();
    AppMethodBeat.o(88071);
  }
  
  public int ab(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.ajGQ == 2064) && (this.ajGR == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.ajGQ == 2064) && (this.ajGR == 10))
      {
        i = 1;
      }
      else if ((this.ajGQ == 2064) && (this.ajGR == 2))
      {
        i = 2;
      }
      else if ((this.ajGQ == 2064) && (this.ajGR == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = am(paramArrayOfByte, paramInt1 + 2);
    kGh();
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
      aa(paramArrayOfByte, j, this.ajGF - j - 1);
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
          if (this.ajGT.ajGW == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.ajGF - j - 1, this.ajGT.ajGW);; paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.ajGF - j - 1, this.ajGT.ajGV))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.bKf("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).kGj();
        paramInt2 = localObject9.length;
        localo.ae((byte[])localObject9, 2, paramInt2);
        localp.ae((byte[])localObject9, 2, paramInt2);
        locall.ae((byte[])localObject9, 2, paramInt2);
        localq.ae((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.ae((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.bKf("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.ae((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.kGj();
      }
      if (localj.ae((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.ajGT._context, localj.kGj());
      }
      if (locald.ae((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.kGj();
      }
      if (localm.ae((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.kGj();
      }
      if (((a)localObject13).ae((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).kGj();
      }
      if (((a)localObject12).ae((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).kGj();
      }
      if (((a)localObject11).ae((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).kGj();
      }
      if (((a)localObject10).ae((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).ajHY];
        System.arraycopy(((z)localObject10).ajGK, ((z)localObject10).ajHz + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).ajHZ];
        System.arraycopy(((z)localObject10).ajGK, ((z)localObject10).ajHz + 2 + ((z)localObject10).ajHY + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.ae((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.kGj();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).ae(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.ajGT.ajHw = ((byte[])paramArrayOfByte.clone());
          util.ry("fast data:", util.dY(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.ae((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.kGj();
        }
        paramInt1 = localn.ae((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).ae((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.ajGT.ajGV = localn.kGj();
          this.ajGT.ajHu = dN(((a)localObject8).kGj());
          paramArrayOfByte[1] = ((byte[])this.ajGT.ajHu.clone());
        }
        if (((a)localObject5).ae((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).ajIb];
          System.arraycopy(((ab)localObject5).ajGK, ((ab)localObject5).ajHz + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).ae((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).kGj();
        }
        if (((a)localObject7).ae((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).kGj();
        }
        if (localak.ae((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.kGj();
        }
        if (localam.ae((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.kGj();
        }
        if (((a)localObject3).ae((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.ajGT.ajHc != -1L) {
          break label1710;
        }
        l1 = util.ar(((v)localObject3).ajGK, ((v)localObject3).ajHz);
        label1251:
        l3 = 0xFFFFFFFF & util.ar(((v)localObject3).ajGK, ((v)localObject3).ajHz + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).ae((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).kGn() != 0)) {}
      for (long l2 = ((ad)localObject4).kGn();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.ajGT;
          long l4 = this.ajGT._uin;
          long l5 = this.ajGT.ajHa;
          long l6 = i.kGi();
          long l7 = i.kGi();
          long l8 = i.kGi();
          localObject4 = new byte[2];
          System.arraycopy(localt.ajGK, localt.ajHz, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.ajGK, localt.ajHz + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.ajGK, localt.ajHz + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.ajHW];
          System.arraycopy(localt.ajGK, localt.ajHz + 2 + 1 + 1 + 1, localObject7, 0, localt.ajHW);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.kGj(), localo.kGj(), localq.kGj(), localp.kGj(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).ae(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).ae(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).kGg();
          localObject13 = ((a)localObject13).kGg();
          localObject11 = ((a)localObject11).kGg();
          localObject10 = ((ah)localObject10).dU(this.ajGT.ajHe);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.ag(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.ajGT.ajHw = new byte[0];
          break label969;
          label1710:
          l1 = this.ajGT.ajHc;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          aa(paramArrayOfByte, j, this.ajGF - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).ae(paramArrayOfByte, j, this.ajGF - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.ajGT.ajGY = ((f)localObject1);
            i = ((a)localObject2).ae(paramArrayOfByte, j, this.ajGF - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.ajGT.ajGZ = ((g)localObject2);
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
  
  public final int al(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.ajGI + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.ajGJ = (paramInt - this.ajGI - 2);
    if (paramInt > this.ajGE)
    {
      this.ajGE = (paramInt + 128);
      this.ajGK = new byte[this.ajGE];
    }
    this.ajGF = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.ajGK, 0, paramInt);
    paramArrayOfByte = this.ajGK;
    paramInt = this.ajGI + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.ajGJ, this.ajGT.ajGX);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.ajGJ = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.ajGI + 2 > this.ajGE)
      {
        this.ajGE = (paramArrayOfByte.length + this.ajGI + 2);
        byte[] arrayOfByte = new byte[this.ajGE];
        System.arraycopy(this.ajGK, 0, arrayOfByte, 0, this.ajGF);
        this.ajGK = arrayOfByte;
      }
      this.ajGF = 0;
      System.arraycopy(paramArrayOfByte, 0, this.ajGK, paramInt, paramArrayOfByte.length);
      paramInt = this.ajGF;
      int j = this.ajGI;
      this.ajGF = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = ab(this.ajGK, this.ajGI + 1, this.ajGJ);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int am(byte[] paramArrayOfByte, int paramInt)
  {
    this.ajGS = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] dN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.ajGT.ajGV.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.ajGT.ajGV, 0, arrayOfByte, paramArrayOfByte.length, this.ajGT.ajGV.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] dO(byte[] paramArrayOfByte)
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
    this.ajGT.ajGV = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.ajGT.ajGV, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] kGg()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.ajGF];
    System.arraycopy(this.ajGK, 0, arrayOfByte, 0, this.ajGF);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void kGh()
  {
    AppMethodBeat.i(88072);
    this.ajGT.ajHt.kGo();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */