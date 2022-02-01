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
  protected static int abFI = 0;
  int abFA;
  int abFB;
  int abFC;
  int abFD;
  public int abFE;
  protected int abFF;
  protected byte[] abFG;
  protected int abFH;
  protected int abFJ;
  protected int abFK;
  protected int abFL;
  protected int abFM;
  protected int abFN;
  byte abFO;
  protected i abFP;
  
  public d()
  {
    AppMethodBeat.i(88066);
    this.abFA = 4096;
    this.abFB = 0;
    this.abFC = 27;
    this.abFD = 0;
    this.abFE = 15;
    this.abFF = 0;
    this.abFG = new byte[this.abFA];
    this.abFH = 8001;
    this.abFJ = 0;
    this.abFK = 0;
    this.abFL = 0;
    this.abFM = 0;
    this.abFN = 0;
    AppMethodBeat.o(88066);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88067);
    int i = paramArrayOfByte.length;
    int j = abFI + 1;
    abFI = j;
    this.abFB = 0;
    util.ah(this.abFG, this.abFB, 2);
    this.abFB += 1;
    util.ai(this.abFG, this.abFB, this.abFC + 2 + i);
    this.abFB += 2;
    util.ai(this.abFG, this.abFB, paramInt1);
    this.abFB += 2;
    util.ai(this.abFG, this.abFB, paramInt2);
    this.abFB += 2;
    util.ai(this.abFG, this.abFB, j);
    this.abFB += 2;
    util.aj(this.abFG, this.abFB, (int)paramLong);
    this.abFB += 4;
    util.ah(this.abFG, this.abFB, 3);
    this.abFB += 1;
    util.ah(this.abFG, this.abFB, 0);
    this.abFB += 1;
    util.ah(this.abFG, this.abFB, paramInt3);
    this.abFB += 1;
    util.aj(this.abFG, this.abFB, paramInt4);
    this.abFB += 4;
    util.aj(this.abFG, this.abFB, paramInt5);
    this.abFB += 4;
    util.aj(this.abFG, this.abFB, paramInt6);
    this.abFB += 4;
    if (this.abFB + i + 1 > this.abFA)
    {
      this.abFA = (this.abFB + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.abFA];
      System.arraycopy(this.abFG, 0, arrayOfByte, 0, this.abFB);
      this.abFG = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.abFG, this.abFB, i);
    this.abFB = (i + this.abFB);
    util.ah(this.abFG, this.abFB, 3);
    this.abFB += 1;
    AppMethodBeat.o(88067);
  }
  
  final byte[] ab(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88070);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.ai(arrayOfByte, 0, paramInt1);
    util.ai(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.b(arrayOfByte, arrayOfByte.length, this.abFP.abFT);
    arrayOfByte = new byte[paramArrayOfByte.length + this.abFP.abFT.length];
    System.arraycopy(this.abFP.abFT, 0, arrayOfByte, 0, this.abFP.abFT.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.abFP.abFT.length, paramArrayOfByte.length);
    AppMethodBeat.o(88070);
    return arrayOfByte;
  }
  
  public final void ac(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88071);
    ai localai = new ai();
    if (localai.ag(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.abFP.abGp;
      byte[] arrayOfByte = new byte[localai.abHe];
      System.arraycopy(localai.abFG, localai.abGv + 6, arrayOfByte, 0, localai.abHe);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.abFP.abGp;
      arrayOfByte = new byte[localai.abHf];
      System.arraycopy(localai.abFG, localai.abGv + 8 + localai.abHe, arrayOfByte, 0, localai.abHf);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.abFP.abGp;
      arrayOfByte = new byte[localai.abHg];
      System.arraycopy(localai.abFG, localai.abGv + 12 + localai.abHe + localai.abHf, arrayOfByte, 0, localai.abHg);
      paramArrayOfByte.abHn = new String(arrayOfByte);
      AppMethodBeat.o(88071);
      return;
    }
    this.abFP.abGp.iUN();
    AppMethodBeat.o(88071);
  }
  
  public int ad(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88075);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.abFM == 2064) && (this.abFN == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(88075);
      return -1009;
      if ((this.abFM == 2064) && (this.abFN == 10))
      {
        i = 1;
      }
      else if ((this.abFM == 2064) && (this.abFN == 2))
      {
        i = 2;
      }
      else if ((this.abFM == 2064) && (this.abFN == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(88075);
        return -1012;
      }
    }
    paramInt2 = al(paramArrayOfByte, paramInt1 + 2);
    iUG();
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
      ac(paramArrayOfByte, j, this.abFB - j - 1);
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
          if (this.abFP.abFS == null)
          {
            AppMethodBeat.o(88075);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.abFB - j - 1, this.abFP.abFS);; paramInt1 = ((a)localObject9).c(paramArrayOfByte, j, this.abFB - j - 1, this.abFP.abFR))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.bIb("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).iUI();
        paramInt2 = localObject9.length;
        localo.ag((byte[])localObject9, 2, paramInt2);
        localp.ag((byte[])localObject9, 2, paramInt2);
        locall.ag((byte[])localObject9, 2, paramInt2);
        localq.ag((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.ag((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.bIb("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.ag((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.iUI();
      }
      if (localj.ag((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.abFP._context, localj.iUI());
      }
      if (locald.ag((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.iUI();
      }
      if (localm.ag((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.iUI();
      }
      if (((a)localObject13).ag((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).iUI();
      }
      if (((a)localObject12).ag((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).iUI();
      }
      if (((a)localObject11).ag((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).iUI();
      }
      if (((a)localObject10).ag((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).abGU];
        System.arraycopy(((z)localObject10).abFG, ((z)localObject10).abGv + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).abGV];
        System.arraycopy(((z)localObject10).abFG, ((z)localObject10).abGv + 2 + ((z)localObject10).abGU + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.ag((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.iUI();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).ag(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.abFP.abGs = ((byte[])paramArrayOfByte.clone());
          util.pB("fast data:", util.dV(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.ag((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.iUI();
        }
        paramInt1 = localn.ag((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).ag((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.abFP.abFR = localn.iUI();
          this.abFP.abGq = dK(((a)localObject8).iUI());
          paramArrayOfByte[1] = ((byte[])this.abFP.abGq.clone());
        }
        if (((a)localObject5).ag((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).abGX];
          System.arraycopy(((ab)localObject5).abFG, ((ab)localObject5).abGv + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).ag((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).iUI();
        }
        if (((a)localObject7).ag((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).iUI();
        }
        if (localak.ag((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.iUI();
        }
        if (localam.ag((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.iUI();
        }
        if (((a)localObject3).ag((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.abFP.abFY != -1L) {
          break label1710;
        }
        l1 = util.aq(((v)localObject3).abFG, ((v)localObject3).abGv);
        label1251:
        l3 = 0xFFFFFFFF & util.aq(((v)localObject3).abFG, ((v)localObject3).abGv + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).ag((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).iUM() != 0)) {}
      for (long l2 = ((ad)localObject4).iUM();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.abFP;
          long l4 = this.abFP._uin;
          long l5 = this.abFP.abFW;
          long l6 = i.iUH();
          long l7 = i.iUH();
          long l8 = i.iUH();
          localObject4 = new byte[2];
          System.arraycopy(localt.abFG, localt.abGv, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.abFG, localt.abGv + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.abFG, localt.abGv + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.abGS];
          System.arraycopy(localt.abFG, localt.abGv + 2 + 1 + 1 + 1, localObject7, 0, localt.abGS);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.iUI(), localo.iUI(), localq.iUI(), localp.iUI(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).ag(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).ag(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).iUF();
          localObject13 = ((a)localObject13).iUF();
          localObject11 = ((a)localObject11).iUF();
          localObject10 = ((ah)localObject10).dR(this.abFP.abGa);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.ai(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.abFP.abGs = new byte[0];
          break label969;
          label1710:
          l1 = this.abFP.abFY;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          ac(paramArrayOfByte, j, this.abFB - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).ag(paramArrayOfByte, j, this.abFB - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.abFP.abFU = ((f)localObject1);
            i = ((a)localObject2).ag(paramArrayOfByte, j, this.abFB - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.abFP.abFV = ((g)localObject2);
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
  
  public final int ak(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88068);
    if (paramInt <= this.abFE + 2)
    {
      AppMethodBeat.o(88068);
      return -1009;
    }
    this.abFF = (paramInt - this.abFE - 2);
    if (paramInt > this.abFA)
    {
      this.abFA = (paramInt + 128);
      this.abFG = new byte[this.abFA];
    }
    this.abFB = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.abFG, 0, paramInt);
    paramArrayOfByte = this.abFG;
    paramInt = this.abFE + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.abFF, this.abFP.abFT);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(88068);
      return -1002;
      this.abFF = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.abFE + 2 > this.abFA)
      {
        this.abFA = (paramArrayOfByte.length + this.abFE + 2);
        byte[] arrayOfByte = new byte[this.abFA];
        System.arraycopy(this.abFG, 0, arrayOfByte, 0, this.abFB);
        this.abFG = arrayOfByte;
      }
      this.abFB = 0;
      System.arraycopy(paramArrayOfByte, 0, this.abFG, paramInt, paramArrayOfByte.length);
      paramInt = this.abFB;
      int j = this.abFE;
      this.abFB = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = ad(this.abFG, this.abFE + 1, this.abFF);
    AppMethodBeat.o(88068);
    return paramInt;
  }
  
  public final int al(byte[] paramArrayOfByte, int paramInt)
  {
    this.abFO = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] dK(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88073);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(88073);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.abFP.abFR.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.abFP.abFR, 0, arrayOfByte, paramArrayOfByte.length, this.abFP.abFR.length);
    AppMethodBeat.o(88073);
    return arrayOfByte;
  }
  
  public final byte[] dL(byte[] paramArrayOfByte)
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
    this.abFP.abFR = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.abFP.abFR, 0, 16);
    AppMethodBeat.o(88074);
    return arrayOfByte;
  }
  
  public final byte[] iUF()
  {
    AppMethodBeat.i(88069);
    byte[] arrayOfByte = new byte[this.abFB];
    System.arraycopy(this.abFG, 0, arrayOfByte, 0, this.abFB);
    AppMethodBeat.o(88069);
    return arrayOfByte;
  }
  
  public final void iUG()
  {
    AppMethodBeat.i(88072);
    this.abFP.abGp.iUN();
    AppMethodBeat.o(88072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */