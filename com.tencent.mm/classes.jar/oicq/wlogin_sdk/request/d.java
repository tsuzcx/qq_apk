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
  protected static int LVP = 0;
  int LVH;
  int LVI;
  int LVJ;
  int LVK;
  public int LVL;
  protected int LVM;
  protected byte[] LVN;
  protected int LVO;
  protected int LVQ;
  protected int LVR;
  protected int LVS;
  protected int LVT;
  protected int LVU;
  byte LVV;
  protected i LVW;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.LVH = 4096;
    this.LVI = 0;
    this.LVJ = 27;
    this.LVK = 0;
    this.LVL = 15;
    this.LVM = 0;
    this.LVN = new byte[this.LVH];
    this.LVO = 8001;
    this.LVQ = 0;
    this.LVR = 0;
    this.LVS = 0;
    this.LVT = 0;
    this.LVU = 0;
    AppMethodBeat.o(88066);
  }
  
  final byte[] O(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.V(arrayOfByte, 0, paramInt1);
    util.V(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.LVW.LWa);
    arrayOfByte = new byte[paramArrayOfByte.length + this.LVW.LWa.length];
    System.arraycopy(this.LVW.LWa, 0, arrayOfByte, 0, this.LVW.LWa.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.LVW.LWa.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void P(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.T(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.LVW.LWw;
      byte[] arrayOfByte = new byte[localai.LXl];
      System.arraycopy(localai.LVN, localai.LWC + 6, arrayOfByte, 0, localai.LXl);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.LVW.LWw;
      arrayOfByte = new byte[localai.LXm];
      System.arraycopy(localai.LVN, localai.LWC + 8 + localai.LXl, arrayOfByte, 0, localai.LXm);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.LVW.LWw;
      arrayOfByte = new byte[localai.LXn];
      System.arraycopy(localai.LVN, localai.LWC + 12 + localai.LXl + localai.LXm, arrayOfByte, 0, localai.LXn);
      paramArrayOfByte.LXu = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.LVW.LWw.gfB();
    AppMethodBeat.o(88071);
  }
  
  public int Q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.LVT == 2064) && (this.LVU == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.LVT == 2064) && (this.LVU == 10))
      {
        i = 1;
      }
      else if ((this.LVT == 2064) && (this.LVU == 2))
      {
        i = 2;
      }
      else if ((this.LVT == 2064) && (this.LVU == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = ad(paramArrayOfByte, paramInt1 + 2);
    gfu();
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
      P(paramArrayOfByte, j, this.LVI - j - 1);
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
          if (this.LVW.LVZ == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.LVI - j - 1, this.LVW.LVZ);; paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.LVI - j - 1, this.LVW.LVY))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.aXk("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).gfw();
        paramInt2 = localObject9.length;
        localo.T((byte[])localObject9, 2, paramInt2);
        localp.T((byte[])localObject9, 2, paramInt2);
        locall.T((byte[])localObject9, 2, paramInt2);
        localq.T((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.T((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.aXk("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.T((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.gfw();
      }
      if (localj.T((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.LVW._context, localj.gfw());
      }
      if (locald.T((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.gfw();
      }
      if (localm.T((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.gfw();
      }
      if (((a)localObject13).T((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).gfw();
      }
      if (((a)localObject12).T((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).gfw();
      }
      if (((a)localObject11).T((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).gfw();
      }
      if (((a)localObject10).T((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).LXb];
        System.arraycopy(((z)localObject10).LVN, ((z)localObject10).LWC + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).LXc];
        System.arraycopy(((z)localObject10).LVN, ((z)localObject10).LWC + 2 + ((z)localObject10).LXb + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.T((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.gfw();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).T(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.LVW.LWz = ((byte[])paramArrayOfByte.clone());
          util.ni("fast data:", util.dk(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.T((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.gfw();
        }
        paramInt1 = localn.T((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).T((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.LVW.LVY = localn.gfw();
          this.LVW.LWx = cZ(((a)localObject8).gfw());
          paramArrayOfByte[1] = ((byte[])this.LVW.LWx.clone());
        }
        if (((a)localObject5).T((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).LXe];
          System.arraycopy(((ab)localObject5).LVN, ((ab)localObject5).LWC + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).T((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).gfw();
        }
        if (((a)localObject7).T((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).gfw();
        }
        if (localak.T((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.gfw();
        }
        if (localam.T((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.gfw();
        }
        if (((a)localObject3).T((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.LVW.LWf != -1L) {
          break label1710;
        }
        l1 = util.ai(((v)localObject3).LVN, ((v)localObject3).LWC);
        label1251:
        l3 = 0xFFFFFFFF & util.ai(((v)localObject3).LVN, ((v)localObject3).LWC + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).T((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).gfA() != 0)) {}
      for (long l2 = ((ad)localObject4).gfA();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.LVW;
          long l4 = this.LVW._uin;
          long l5 = this.LVW.LWd;
          long l6 = i.gfv();
          long l7 = i.gfv();
          long l8 = i.gfv();
          localObject4 = new byte[2];
          System.arraycopy(localt.LVN, localt.LWC, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.LVN, localt.LWC + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.LVN, localt.LWC + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.LWZ];
          System.arraycopy(localt.LVN, localt.LWC + 2 + 1 + 1 + 1, localObject7, 0, localt.LWZ);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.gfw(), localo.gfw(), localq.gfw(), localp.gfw(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).T(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).T(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).gft();
          localObject13 = ((a)localObject13).gft();
          localObject11 = ((a)localObject11).gft();
          localObject10 = ((ah)localObject10).dg(this.LVW.LWh);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.V(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.LVW.LWz = new byte[0];
          break label969;
          label1710:
          l1 = this.LVW.LWf;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          P(paramArrayOfByte, j, this.LVI - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).T(paramArrayOfByte, j, this.LVI - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.LVW.LWb = ((f)localObject1);
            i = ((a)localObject2).T(paramArrayOfByte, j, this.LVI - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.LVW.LWc = ((g)localObject2);
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
    int j = LVP + 1;
    LVP = j;
    this.LVI = 0;
    util.U(this.LVN, this.LVI, 2);
    this.LVI += 1;
    util.V(this.LVN, this.LVI, this.LVJ + 2 + i);
    this.LVI += 2;
    util.V(this.LVN, this.LVI, paramInt1);
    this.LVI += 2;
    util.V(this.LVN, this.LVI, paramInt2);
    this.LVI += 2;
    util.V(this.LVN, this.LVI, j);
    this.LVI += 2;
    util.W(this.LVN, this.LVI, (int)paramLong);
    this.LVI += 4;
    util.U(this.LVN, this.LVI, 3);
    this.LVI += 1;
    util.U(this.LVN, this.LVI, 0);
    this.LVI += 1;
    util.U(this.LVN, this.LVI, paramInt3);
    this.LVI += 1;
    util.W(this.LVN, this.LVI, paramInt4);
    this.LVI += 4;
    util.W(this.LVN, this.LVI, paramInt5);
    this.LVI += 4;
    util.W(this.LVN, this.LVI, paramInt6);
    this.LVI += 4;
    if (this.LVI + i + 1 > this.LVH)
    {
      this.LVH = (this.LVI + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.LVH];
      System.arraycopy(this.LVN, 0, arrayOfByte, 0, this.LVI);
      this.LVN = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.LVN, this.LVI, i);
    this.LVI = (i + this.LVI);
    util.U(this.LVN, this.LVI, 3);
    this.LVI += 1;
    AppMethodBeat.o(88067);
  }
  
  public final int ac(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.LVL + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.LVM = (paramInt - this.LVL - 2);
    if (paramInt > this.LVH)
    {
      this.LVH = (paramInt + 128);
      this.LVN = new byte[this.LVH];
    }
    this.LVI = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.LVN, 0, paramInt);
    paramArrayOfByte = this.LVN;
    paramInt = this.LVL + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.LVM, this.LVW.LWa);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.LVM = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.LVL + 2 > this.LVH)
      {
        this.LVH = (paramArrayOfByte.length + this.LVL + 2);
        byte[] arrayOfByte = new byte[this.LVH];
        System.arraycopy(this.LVN, 0, arrayOfByte, 0, this.LVI);
        this.LVN = arrayOfByte;
      }
      this.LVI = 0;
      System.arraycopy(paramArrayOfByte, 0, this.LVN, paramInt, paramArrayOfByte.length);
      paramInt = this.LVI;
      int j = this.LVL;
      this.LVI = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = Q(this.LVN, this.LVL + 1, this.LVM);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int ad(byte[] paramArrayOfByte, int paramInt)
  {
    this.LVV = paramArrayOfByte[paramInt];
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
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.LVW.LVY.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.LVW.LVY, 0, arrayOfByte, paramArrayOfByte.length, this.LVW.LVY.length);
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
    this.LVW.LVY = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.LVW.LVY, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] gft()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.LVI];
    System.arraycopy(this.LVN, 0, arrayOfByte, 0, this.LVI);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void gfu()
  {
    AppMethodBeat.i(88072);
    this.LVW.LWw.gfB();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */