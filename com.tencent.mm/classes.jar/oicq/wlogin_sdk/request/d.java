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
  protected static int CMz = 0;
  protected int CMA;
  protected int CMB;
  protected int CMC;
  protected int CMD;
  protected int CME;
  byte CMF;
  protected i CMG;
  int CMr;
  int CMs;
  int CMt;
  int CMu;
  public int CMv;
  protected int CMw;
  protected byte[] CMx;
  protected int CMy;
  
  public d()
  {
    AppMethodBeat.i(96427);
    this.CMr = 4096;
    this.CMs = 0;
    this.CMt = 27;
    this.CMu = 0;
    this.CMv = 15;
    this.CMw = 0;
    this.CMx = new byte[this.CMr];
    this.CMy = 8001;
    this.CMA = 0;
    this.CMB = 0;
    this.CMC = 0;
    this.CMD = 0;
    this.CME = 0;
    AppMethodBeat.o(96427);
  }
  
  final byte[] H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96431);
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.O(arrayOfByte, 0, paramInt1);
    util.O(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.CMG.CMK);
    arrayOfByte = new byte[paramArrayOfByte.length + this.CMG.CMK.length];
    System.arraycopy(this.CMG.CMK, 0, arrayOfByte, 0, this.CMG.CMK.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.CMG.CMK.length, paramArrayOfByte.length);
    AppMethodBeat.o(96431);
    return arrayOfByte;
  }
  
  public final void I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96432);
    ai localai = new ai();
    if (localai.M(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.CMG.CNg;
      byte[] arrayOfByte = new byte[localai.CNU];
      System.arraycopy(localai.CMx, localai.CNm + 6, arrayOfByte, 0, localai.CNU);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.CMG.CNg;
      arrayOfByte = new byte[localai.CNV];
      System.arraycopy(localai.CMx, localai.CNm + 8 + localai.CNU, arrayOfByte, 0, localai.CNV);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.CMG.CNg;
      arrayOfByte = new byte[localai.CNW];
      System.arraycopy(localai.CMx, localai.CNm + 12 + localai.CNU + localai.CNV, arrayOfByte, 0, localai.CNW);
      paramArrayOfByte.COd = new String(arrayOfByte);
      AppMethodBeat.o(96432);
      return;
    }
    this.CMG.CNg.eri();
    AppMethodBeat.o(96432);
  }
  
  public int J(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96436);
    Object localObject1 = new f();
    Object localObject2 = new g();
    Object localObject9 = new s();
    int i;
    if ((this.CMD == 2064) && (this.CME == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      AppMethodBeat.o(96436);
      return -1009;
      if ((this.CMD == 2064) && (this.CME == 10))
      {
        i = 1;
      }
      else if ((this.CMD == 2064) && (this.CME == 2))
      {
        i = 2;
      }
      else if ((this.CMD == 2064) && (this.CME == 13))
      {
        i = 4;
      }
      else
      {
        AppMethodBeat.o(96436);
        return -1012;
      }
    }
    paramInt2 = aa(paramArrayOfByte, paramInt1 + 2);
    erb();
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
      I(paramArrayOfByte, j, this.CMs - j - 1);
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
        AppMethodBeat.o(96436);
        return paramInt1;
        if (i == 1) {
          if (this.CMG.CMJ == null)
          {
            AppMethodBeat.o(96436);
            return -1006;
          }
        }
        for (paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.CMs - j - 1, this.CMG.CMJ);; paramInt1 = ((a)localObject9).b(paramArrayOfByte, j, this.CMs - j - 1, this.CMG.CMI))
        {
          if (paramInt1 >= 0) {
            break label318;
          }
          util.azC("119 can not decrypt, ret=".concat(String.valueOf(paramInt1)));
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
        localObject9 = ((a)localObject9).erd();
        paramInt2 = localObject9.length;
        localo.M((byte[])localObject9, 2, paramInt2);
        localp.M((byte[])localObject9, 2, paramInt2);
        locall.M((byte[])localObject9, 2, paramInt2);
        localq.M((byte[])localObject9, 2, paramInt2);
        paramInt1 = localt.M((byte[])localObject9, 2, paramInt2);
        if (paramInt1 >= 0) {
          break;
        }
        if (paramInt1 >= 0) {
          break label1722;
        }
        util.azC("parse 119 failed, ret=".concat(String.valueOf(paramInt1)));
      }
      if (locale.M((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject1 = locale.erd();
      }
      if (localj.M((byte[])localObject9, 2, paramInt2) >= 0) {
        util.a(this.CMG._context, localj.erd());
      }
      if (locald.M((byte[])localObject9, 2, paramInt2) >= 0) {
        localObject2 = locald.erd();
      }
      if (localm.M((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte1 = localm.erd();
      }
      if (((a)localObject13).M((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte2 = ((a)localObject13).erd();
      }
      if (((a)localObject12).M((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte3 = ((a)localObject12).erd();
      }
      if (((a)localObject11).M((byte[])localObject9, 2, paramInt2) >= 0) {
        arrayOfByte4 = ((a)localObject11).erd();
      }
      if (((a)localObject10).M((byte[])localObject9, 2, paramInt2) >= 0)
      {
        arrayOfByte5 = new byte[((z)localObject10).CNL];
        System.arraycopy(((z)localObject10).CMx, ((z)localObject10).CNm + 2, arrayOfByte5, 0, arrayOfByte5.length);
        arrayOfByte6 = new byte[((z)localObject10).CNM];
        System.arraycopy(((z)localObject10).CMx, ((z)localObject10).CNm + 2 + ((z)localObject10).CNL + 2, arrayOfByte6, 0, arrayOfByte6.length);
      }
      if (paramArrayOfByte.M((byte[])localObject9, 2, paramInt2) >= 0)
      {
        localObject12 = new h();
        localObject13 = new n();
        localObject11 = new am();
        localObject10 = new ah();
        paramArrayOfByte = paramArrayOfByte.erd();
        paramInt1 = paramArrayOfByte.length;
        if (((a)localObject12).M(paramArrayOfByte, 2, paramInt1) < 0)
        {
          paramArrayOfByte = null;
          label936:
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label1697;
          }
          this.CMG.CNj = ((byte[])paramArrayOfByte.clone());
          util.jC("fast data:", util.cS(paramArrayOfByte));
        }
      }
      else
      {
        label969:
        paramArrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
        if (localac.M((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[0] = localac.erd();
        }
        paramInt1 = localn.M((byte[])localObject9, 2, paramInt2);
        if ((((a)localObject8).M((byte[])localObject9, 2, paramInt2) >= 0) && (paramInt1 >= 0))
        {
          this.CMG.CMI = localn.erd();
          this.CMG.CNh = cH(((a)localObject8).erd());
          paramArrayOfByte[1] = ((byte[])this.CMG.CNh.clone());
        }
        if (((a)localObject5).M((byte[])localObject9, 2, paramInt2) >= 0)
        {
          localObject8 = new byte[((ab)localObject5).CNO];
          System.arraycopy(((ab)localObject5).CMx, ((ab)localObject5).CNm + 2, localObject8, 0, localObject8.length);
          paramArrayOfByte[2] = localObject8;
        }
        if (((a)localObject6).M((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[3] = ((a)localObject6).erd();
        }
        if (((a)localObject7).M((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[4] = ((a)localObject7).erd();
        }
        if (localak.M((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[5] = localak.erd();
        }
        if (localam.M((byte[])localObject9, 2, paramInt2) >= 0) {
          paramArrayOfByte[6] = localam.erd();
        }
        if (((a)localObject3).M((byte[])localObject9, 2, paramInt2) < 0) {
          break label1839;
        }
        if (this.CMG.CMP != -1L) {
          break label1710;
        }
        l1 = util.af(((v)localObject3).CMx, ((v)localObject3).CNm);
        label1251:
        l3 = 0xFFFFFFFF & util.af(((v)localObject3).CMx, ((v)localObject3).CNm + 4);
      }
      break;
    }
    for (;;)
    {
      if ((((a)localObject4).M((byte[])localObject9, 2, paramInt2) >= 0) && (((ad)localObject4).erh() != 0)) {}
      for (long l2 = ((ad)localObject4).erh();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject3 = this.CMG;
          long l4 = this.CMG._uin;
          long l5 = this.CMG.CMN;
          long l6 = i.erc();
          long l7 = i.erc();
          long l8 = i.erc();
          localObject4 = new byte[2];
          System.arraycopy(localt.CMx, localt.CNm, localObject4, 0, 2);
          localObject5 = new byte[1];
          System.arraycopy(localt.CMx, localt.CNm + 2, localObject5, 0, 1);
          localObject6 = new byte[1];
          System.arraycopy(localt.CMx, localt.CNm + 2 + 1, localObject6, 0, 1);
          localObject7 = new byte[localt.CNJ];
          System.arraycopy(localt.CMx, localt.CNm + 2 + 1 + 1 + 1, localObject7, 0, localt.CNJ);
          ((i)localObject3).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject4, (byte[])localObject5, (byte[])localObject6, (byte[])localObject7, locall.erd(), localo.erd(), localq.erd(), localp.erd(), (byte[])localObject1, arrayOfByte1, (byte[])localObject2, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, arrayOfByte6, paramArrayOfByte);
          paramInt1 = 0;
          break label627;
          if (((a)localObject13).M(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          if (((a)localObject11).M(paramArrayOfByte, 2, paramInt1) < 0)
          {
            paramArrayOfByte = null;
            break label936;
          }
          localObject12 = ((a)localObject12).era();
          localObject13 = ((a)localObject13).era();
          localObject11 = ((a)localObject11).era();
          localObject10 = ((ah)localObject10).cO(this.CMG.CMR);
          paramArrayOfByte = new byte[localObject12.length + 3 + localObject13.length + localObject11.length + localObject10.length];
          paramArrayOfByte[0] = 64;
          util.O(paramArrayOfByte, 1, 4);
          System.arraycopy(localObject12, 0, paramArrayOfByte, 3, localObject12.length);
          paramInt1 = localObject12.length + 3;
          System.arraycopy(localObject13, 0, paramArrayOfByte, paramInt1, localObject13.length);
          paramInt1 = localObject13.length + paramInt1;
          System.arraycopy(localObject11, 0, paramArrayOfByte, paramInt1, localObject11.length);
          System.arraycopy(localObject10, 0, paramArrayOfByte, paramInt1 + localObject11.length, localObject10.length);
          break label936;
          label1697:
          this.CMG.CNj = new byte[0];
          break label969;
          label1710:
          l1 = this.CMG.CMP;
          break label1251;
          label1722:
          paramInt1 = 0;
          break;
          I(paramArrayOfByte, j, this.CMs - j - 1);
          paramInt1 = paramInt2;
          break;
          i = ((a)localObject1).M(paramArrayOfByte, j, this.CMs - j - 1);
          paramInt1 = i;
          if (i >= 0)
          {
            this.CMG.CML = ((f)localObject1);
            i = ((a)localObject2).M(paramArrayOfByte, j, this.CMs - j - 1);
            paramInt1 = i;
            if (i >= 0)
            {
              this.CMG.CMM = ((g)localObject2);
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
  
  public final int Z(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(96429);
    if (paramInt <= this.CMv + 2)
    {
      AppMethodBeat.o(96429);
      return -1009;
    }
    this.CMw = (paramInt - this.CMv - 2);
    if (paramInt > this.CMr)
    {
      this.CMr = (paramInt + 128);
      this.CMx = new byte[this.CMr];
    }
    this.CMs = paramInt;
    System.arraycopy(paramArrayOfByte, 0, this.CMx, 0, paramInt);
    paramArrayOfByte = this.CMx;
    paramInt = this.CMv + 1;
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.CMw, this.CMG.CMK);
    if (paramArrayOfByte == null) {}
    for (paramInt = -1002; paramInt < 0; paramInt = i)
    {
      AppMethodBeat.o(96429);
      return -1002;
      this.CMw = paramArrayOfByte.length;
      if (paramArrayOfByte.length + this.CMv + 2 > this.CMr)
      {
        this.CMr = (paramArrayOfByte.length + this.CMv + 2);
        byte[] arrayOfByte = new byte[this.CMr];
        System.arraycopy(this.CMx, 0, arrayOfByte, 0, this.CMs);
        this.CMx = arrayOfByte;
      }
      this.CMs = 0;
      System.arraycopy(paramArrayOfByte, 0, this.CMx, paramInt, paramArrayOfByte.length);
      paramInt = this.CMs;
      int j = this.CMv;
      this.CMs = (paramArrayOfByte.length + (j + 2) + paramInt);
    }
    paramInt = J(this.CMx, this.CMv + 1, this.CMw);
    AppMethodBeat.o(96429);
    return paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96428);
    int i = paramArrayOfByte.length;
    int j = CMz + 1;
    CMz = j;
    this.CMs = 0;
    util.N(this.CMx, this.CMs, 2);
    this.CMs += 1;
    util.O(this.CMx, this.CMs, this.CMt + 2 + i);
    this.CMs += 2;
    util.O(this.CMx, this.CMs, paramInt1);
    this.CMs += 2;
    util.O(this.CMx, this.CMs, paramInt2);
    this.CMs += 2;
    util.O(this.CMx, this.CMs, j);
    this.CMs += 2;
    util.P(this.CMx, this.CMs, (int)paramLong);
    this.CMs += 4;
    util.N(this.CMx, this.CMs, 3);
    this.CMs += 1;
    util.N(this.CMx, this.CMs, 0);
    this.CMs += 1;
    util.N(this.CMx, this.CMs, paramInt3);
    this.CMs += 1;
    util.P(this.CMx, this.CMs, paramInt4);
    this.CMs += 4;
    util.P(this.CMx, this.CMs, paramInt5);
    this.CMs += 4;
    util.P(this.CMx, this.CMs, paramInt6);
    this.CMs += 4;
    if (this.CMs + i + 1 > this.CMr)
    {
      this.CMr = (this.CMs + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.CMr];
      System.arraycopy(this.CMx, 0, arrayOfByte, 0, this.CMs);
      this.CMx = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.CMx, this.CMs, i);
    this.CMs = (i + this.CMs);
    util.N(this.CMx, this.CMs, 3);
    this.CMs += 1;
    AppMethodBeat.o(96428);
  }
  
  public final int aa(byte[] paramArrayOfByte, int paramInt)
  {
    this.CMF = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final byte[] cH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96434);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(96434);
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.CMG.CMI.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.CMG.CMI, 0, arrayOfByte, paramArrayOfByte.length, this.CMG.CMI.length);
    AppMethodBeat.o(96434);
    return arrayOfByte;
  }
  
  public final byte[] cI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96435);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
    {
      AppMethodBeat.o(96435);
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    int i = paramArrayOfByte.length - 16;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    this.CMG.CMI = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.CMG.CMI, 0, 16);
    AppMethodBeat.o(96435);
    return arrayOfByte;
  }
  
  public final byte[] era()
  {
    AppMethodBeat.i(96430);
    byte[] arrayOfByte = new byte[this.CMs];
    System.arraycopy(this.CMx, 0, arrayOfByte, 0, this.CMs);
    AppMethodBeat.o(96430);
    return arrayOfByte;
  }
  
  public final void erb()
  {
    AppMethodBeat.i(96433);
    this.CMG.CNg.eri();
    AppMethodBeat.o(96433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */