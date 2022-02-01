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
  protected static int Kig = 0;
  int KhY;
  int KhZ;
  int Kia;
  int Kib;
  public int Kic;
  protected int Kid;
  protected byte[] Kie;
  protected int Kif;
  protected int Kih;
  protected int Kii;
  protected int Kij;
  protected int Kik;
  protected int Kil;
  byte Kim;
  protected i Kin;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.KhY = 4096;
    this.KhZ = 0;
    this.Kia = 27;
    this.Kib = 0;
    this.Kic = 15;
    this.Kid = 0;
    this.Kie = new byte[this.KhY];
    this.Kif = 8001;
    this.Kih = 0;
    this.Kii = 0;
    this.Kij = 0;
    this.Kik = 0;
    this.Kil = 0;
    AppMethodBeat.o(88066);
  }
  
  final byte[] P(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.W(arrayOfByte, 0, paramInt1);
    util.W(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.Kin.Kir);
    arrayOfByte = new byte[paramArrayOfByte.length + this.Kin.Kir.length];
    System.arraycopy(this.Kin.Kir, 0, arrayOfByte, 0, this.Kin.Kir.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.Kin.Kir.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.U(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.Kin.KiN;
      byte[] arrayOfByte = new byte[localai.KjC];
      System.arraycopy(localai.Kie, localai.KiT + 6, arrayOfByte, 0, localai.KjC);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.Kin.KiN;
      arrayOfByte = new byte[localai.KjD];
      System.arraycopy(localai.Kie, localai.KiT + 8 + localai.KjC, arrayOfByte, 0, localai.KjD);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.Kin.KiN;
      arrayOfByte = new byte[localai.KjE];
      System.arraycopy(localai.Kie, localai.KiT + 12 + localai.KjC + localai.KjD, arrayOfByte, 0, localai.KjE);
      paramArrayOfByte.KjL = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.Kin.KiN.fML();
    AppMethodBeat.o(88071);
  }
  
  public int R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.Kik == 2064) && (this.Kil == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.Kik == 2064) && (this.Kil == 10))
      {
        i = 1;
      }
      else if ((this.Kik == 2064) && (this.Kil == 2))
      {
        i = 2;
      }
      else if ((this.Kik == 2064) && (this.Kil == 13))
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
    fME();
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
      Q(paramArrayOfByte, j, this.KhZ - j - 1);
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
          if (this.Kin.Kiq == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.KhZ - j - 1, this.Kin.Kiq);; paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.KhZ - j - 1, this.Kin.Kip))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.aRk("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).fMG();
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
        util.aRk("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.U((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.fMG();
      }
      if (localj.U((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.Kin._context, localj.fMG());
      }
      if (locald.U((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.fMG();
      }
      if (localm.U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.fMG();
      }
      if (((a)localObject13).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).fMG();
      }
      if (((a)localObject12).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).fMG();
      }
      if (((a)localObject11).U((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).fMG();
      }
      if (((a)localObject10).U((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).Kjs];
        System.arraycopy(((z)localObject10).Kie, ((z)localObject10).KiT + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).Kjt];
        System.arraycopy(((z)localObject10).Kie, ((z)localObject10).KiT + 2 + ((z)localObject10).Kjs + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.U((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.fMG();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).U(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.Kin.KiQ = ((byte[])paramArrayOfByte.clone());
          util.mI("fast data:", util.dk(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.fMG();
        }
        paramInt1 = localn.U((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).U((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.Kin.Kip = localn.fMG();
          this.Kin.KiO = cZ(((a)localObject8).fMG());
          paramArrayOfByte[1] = ((byte[])this.Kin.KiO.clone());
        }
        if (((a)localObject5).U((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).Kjv];
          System.arraycopy(((ab)localObject5).Kie, ((ab)localObject5).KiT + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).fMG();
        }
        if (((a)localObject7).U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).fMG();
        }
        if (localak.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.fMG();
        }
        if (localam.U((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.fMG();
        }
        if (((a)localObject3).U((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.Kin.Kiw != -1L) {
          break label1710;
        }
        l1 = util.aj(((v)localObject3).Kie, ((v)localObject3).KiT);
        label1251:
        l3 = 0xFFFFFFFF & util.aj(((v)localObject3).Kie, ((v)localObject3).KiT + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).U((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).fMK() != 0)) {}
      for (long l2 = ((ad)localObject4).fMK();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.Kin;
          long l4 = this.Kin._uin;
          long l5 = this.Kin.Kiu;
          long l6 = i.fMF();
          long l7 = i.fMF();
          long l8 = i.fMF();
          localObject4 = new byte[2];
          System.arraycopy(localt.Kie, localt.KiT, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.Kie, localt.KiT + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.Kie, localt.KiT + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.Kjq];
          System.arraycopy(localt.Kie, localt.KiT + 2 + 1 + 1 + 1, localObject7, 0, localt.Kjq);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.fMG(), localo.fMG(), localq.fMG(), localp.fMG(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
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
          localObject12 = ((a)localObject12).fMD();
          localObject13 = ((a)localObject13).fMD();
          localObject11 = ((a)localObject11).fMD();
          localObject10 = ((ah)localObject10).dg(this.Kin.Kiy);
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
          this.Kin.KiQ = new byte[0];
          break label969;
          label1710:
          l1 = this.Kin.Kiw;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          Q(paramArrayOfByte, j, this.KhZ - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).U(paramArrayOfByte, j, this.KhZ - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.Kin.Kis = ((f)localObject1);
            i = ((a)localObject2).U(paramArrayOfByte, j, this.KhZ - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.Kin.Kit = ((g)localObject2);
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
    int j = Kig + 1;
    Kig = j;
    this.KhZ = 0;
    util.V(this.Kie, this.KhZ, 2);
    this.KhZ += 1;
    util.W(this.Kie, this.KhZ, this.Kia + 2 + i);
    this.KhZ += 2;
    util.W(this.Kie, this.KhZ, paramInt1);
    this.KhZ += 2;
    util.W(this.Kie, this.KhZ, paramInt2);
    this.KhZ += 2;
    util.W(this.Kie, this.KhZ, j);
    this.KhZ += 2;
    util.X(this.Kie, this.KhZ, (int)paramLong);
    this.KhZ += 4;
    util.V(this.Kie, this.KhZ, 3);
    this.KhZ += 1;
    util.V(this.Kie, this.KhZ, 0);
    this.KhZ += 1;
    util.V(this.Kie, this.KhZ, paramInt3);
    this.KhZ += 1;
    util.X(this.Kie, this.KhZ, paramInt4);
    this.KhZ += 4;
    util.X(this.Kie, this.KhZ, paramInt5);
    this.KhZ += 4;
    util.X(this.Kie, this.KhZ, paramInt6);
    this.KhZ += 4;
    if (this.KhZ + i + 1 > this.KhY)
    {
      this.KhY = (this.KhZ + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.KhY];
      System.arraycopy(this.Kie, 0, arrayOfByte, 0, this.KhZ);
      this.Kie = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.Kie, this.KhZ, i);
    this.KhZ = (i + this.KhZ);
    util.V(this.Kie, this.KhZ, 3);
    this.KhZ += 1;
    AppMethodBeat.o(88067);
  }
  
  public final int ad(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.Kic + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.Kid = (paramInt - this.Kic - 2);
    if (paramInt > this.KhY)
    {
      this.KhY = (paramInt + 128);
      this.Kie = new byte[this.KhY];
    }
    this.KhZ = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.Kie, 0, paramInt);
    paramArrayOfByte = this.Kie;
    paramInt = this.Kic + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.Kid, this.Kin.Kir);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.Kid = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.Kic + 2 > this.KhY)
      {
        this.KhY = (paramArrayOfByte.length + this.Kic + 2);
        byte[] arrayOfByte = new byte[this.KhY];
        System.arraycopy(this.Kie, 0, arrayOfByte, 0, this.KhZ);
        this.Kie = arrayOfByte;
      }
      this.KhZ = 0;
      System.arraycopy(paramArrayOfByte, 0, this.Kie, paramInt, paramArrayOfByte.length);
      paramInt = this.KhZ;
      int j = this.Kic;
      this.KhZ = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = R(this.Kie, this.Kic + 1, this.Kid);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int ae(byte[] paramArrayOfByte, int paramInt)
  {
    this.Kim = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] cZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.Kin.Kip.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.Kin.Kip, 0, arrayOfByte, paramArrayOfByte.length, this.Kin.Kip.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] da(byte[] paramArrayOfByte)
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
    this.Kin.Kip = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.Kin.Kip, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] fMD()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.KhZ];
    System.arraycopy(this.Kie, 0, arrayOfByte, 0, this.KhZ);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void fME()
  {
    AppMethodBeat.i(88072);
    this.Kin.KiN.fML();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */