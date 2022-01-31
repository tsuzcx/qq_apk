package oicq.wlogin_sdk.request;

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
  protected static int xqm = 0;
  int xqe = 4096;
  int xqf = 0;
  int xqg = 27;
  int xqh = 0;
  public int xqi = 15;
  protected int xqj = 0;
  protected byte[] xqk = new byte[this.xqe];
  protected int xql = 8001;
  protected int xqn = 0;
  protected int xqo = 0;
  protected int xqp = 0;
  protected int xqq = 0;
  protected int xqr = 0;
  byte xqs;
  protected i xqt;
  
  private int a(s params)
  {
    long l3 = 4294967295L;
    o localo = new o();
    p localp = new p();
    l locall = new l();
    q localq = new q();
    e locale = new e();
    t localt = new t();
    oicq.wlogin_sdk.a.d locald = new oicq.wlogin_sdk.a.d();
    m localm = new m();
    u localu = new u();
    Object localObject10 = new w();
    Object localObject9 = new x();
    j localj = new j();
    Object localObject6 = new h();
    n localn = new n();
    Object localObject8 = new z();
    Object localObject1 = new v();
    Object localObject2 = new ad();
    Object localObject3 = new ab();
    Object localObject4 = new af();
    Object localObject5 = new ap();
    ak localak = new ak();
    Object localObject7 = new al();
    am localam = new am();
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    byte[] arrayOfByte4 = null;
    byte[] arrayOfByte5 = null;
    byte[] arrayOfByte6 = null;
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte7 = null;
    byte[] arrayOfByte8 = null;
    ac localac = new ac();
    byte[] arrayOfByte9 = params.cUE();
    int i = arrayOfByte9.length;
    localo.B(arrayOfByte9, 2, i);
    localp.B(arrayOfByte9, 2, i);
    locall.B(arrayOfByte9, 2, i);
    localq.B(arrayOfByte9, 2, i);
    int j = localt.B(arrayOfByte9, 2, i);
    if (j < 0) {
      return j;
    }
    if (locale.B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte1 = locale.cUE();
    }
    if (localj.B(arrayOfByte9, 2, i) >= 0) {
      util.a(this.xqt._context, localj.cUE());
    }
    if (locald.B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte2 = locald.cUE();
    }
    if (localm.B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte3 = localm.cUE();
    }
    if (localu.B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte4 = localu.cUE();
    }
    if (((a)localObject10).B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte5 = ((a)localObject10).cUE();
    }
    if (((a)localObject9).B(arrayOfByte9, 2, i) >= 0) {
      arrayOfByte6 = ((a)localObject9).cUE();
    }
    if (((a)localObject8).B(arrayOfByte9, 2, i) >= 0)
    {
      arrayOfByte7 = new byte[((z)localObject8).xry];
      System.arraycopy(((z)localObject8).xqk, ((z)localObject8).xqZ + 2, arrayOfByte7, 0, arrayOfByte7.length);
      arrayOfByte8 = new byte[((z)localObject8).xrz];
      System.arraycopy(((z)localObject8).xqk, ((z)localObject8).xqZ + 2 + ((z)localObject8).xry + 2, arrayOfByte8, 0, arrayOfByte8.length);
    }
    label636:
    long l1;
    if (((a)localObject7).B(arrayOfByte9, 2, i) >= 0)
    {
      localObject10 = new h();
      localObject9 = new n();
      localObject8 = new am();
      params = new ah();
      localObject7 = ((a)localObject7).cUE();
      j = localObject7.length;
      if (((a)localObject10).B((byte[])localObject7, 2, j) < 0)
      {
        params = null;
        if ((params == null) || (params.length <= 0)) {
          break label1362;
        }
        this.xqt.xqW = ((byte[])params.clone());
        util.gW("fast data:", util.ch(params));
      }
    }
    else
    {
      params = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 7, 0 });
      if (localac.B(arrayOfByte9, 2, i) >= 0) {
        params[0] = localac.cUE();
      }
      j = localn.B(arrayOfByte9, 2, i);
      if ((((a)localObject6).B(arrayOfByte9, 2, i) >= 0) && (j >= 0))
      {
        this.xqt.xqv = localn.cUE();
        this.xqt.xqU = bW(((a)localObject6).cUE());
        params[1] = ((byte[])this.xqt.xqU.clone());
      }
      if (((a)localObject3).B(arrayOfByte9, 2, i) >= 0)
      {
        localObject6 = new byte[((ab)localObject3).xrB];
        System.arraycopy(((ab)localObject3).xqk, ((ab)localObject3).xqZ + 2, localObject6, 0, localObject6.length);
        params[2] = localObject6;
      }
      if (((a)localObject4).B(arrayOfByte9, 2, i) >= 0) {
        params[3] = ((a)localObject4).cUE();
      }
      if (((a)localObject5).B(arrayOfByte9, 2, i) >= 0) {
        params[4] = ((a)localObject5).cUE();
      }
      if (localak.B(arrayOfByte9, 2, i) >= 0) {
        params[5] = localak.cUE();
      }
      if (localam.B(arrayOfByte9, 2, i) >= 0) {
        params[6] = localam.cUE();
      }
      if (((a)localObject1).B(arrayOfByte9, 2, i) < 0) {
        break label1398;
      }
      if (this.xqt.xqC != -1L) {
        break label1375;
      }
      l1 = util.ae(((v)localObject1).xqk, ((v)localObject1).xqZ);
      label918:
      l3 = 0xFFFFFFFF & util.ae(((v)localObject1).xqk, ((v)localObject1).xqZ + 4);
    }
    for (;;)
    {
      if ((((a)localObject2).B(arrayOfByte9, 2, i) >= 0) && (((ad)localObject2).cUI() != 0)) {}
      for (long l2 = ((ad)localObject2).cUI();; l2 = 2160000L)
      {
        if (l2 < l1) {
          l2 = l1;
        }
        for (;;)
        {
          localObject1 = this.xqt;
          long l4 = this.xqt._uin;
          long l5 = this.xqt.xqA;
          long l6 = i.cUD();
          long l7 = i.cUD();
          long l8 = i.cUD();
          localObject2 = new byte[2];
          System.arraycopy(localt.xqk, localt.xqZ, localObject2, 0, 2);
          localObject3 = new byte[1];
          System.arraycopy(localt.xqk, localt.xqZ + 2, localObject3, 0, 1);
          localObject4 = new byte[1];
          System.arraycopy(localt.xqk, localt.xqZ + 2 + 1, localObject4, 0, 1);
          localObject5 = new byte[localt.xrw];
          System.arraycopy(localt.xqk, localt.xqZ + 2 + 1 + 1 + 1, localObject5, 0, localt.xrw);
          ((i)localObject1).a(l4, l5, l3, l6, l1 + l7, l2 + l8, (byte[])localObject2, (byte[])localObject3, (byte[])localObject4, (byte[])localObject5, locall.cUE(), localo.cUE(), localq.cUE(), localp.cUE(), arrayOfByte1, arrayOfByte3, arrayOfByte2, arrayOfByte4, arrayOfByte5, arrayOfByte6, arrayOfByte7, arrayOfByte8, params);
          return 0;
          if (((a)localObject9).B((byte[])localObject7, 2, j) < 0)
          {
            params = null;
            break;
          }
          if (((a)localObject8).B((byte[])localObject7, 2, j) < 0)
          {
            params = null;
            break;
          }
          localObject7 = ((a)localObject10).cUB();
          localObject9 = ((a)localObject9).cUB();
          localObject8 = ((a)localObject8).cUB();
          localObject10 = params.cd(this.xqt.xqE);
          params = new byte[localObject7.length + 3 + localObject9.length + localObject8.length + localObject10.length];
          params[0] = 64;
          util.D(params, 1, 4);
          System.arraycopy(localObject7, 0, params, 3, localObject7.length);
          j = localObject7.length + 3;
          System.arraycopy(localObject9, 0, params, j, localObject9.length);
          j = localObject9.length + j;
          System.arraycopy(localObject8, 0, params, j, localObject8.length);
          System.arraycopy(localObject10, 0, params, j + localObject8.length, localObject10.length);
          break;
          label1362:
          this.xqt.xqW = new byte[0];
          break label636;
          label1375:
          l1 = this.xqt.xqC;
          break label918;
        }
      }
      label1398:
      l1 = 3600L;
    }
  }
  
  public final int Y(byte[] paramArrayOfByte, int paramInt)
  {
    int i = -1002;
    int j = 0;
    if (paramInt <= this.xqi + 2) {
      i = -1009;
    }
    for (;;)
    {
      return i;
      this.xqj = (paramInt - this.xqi - 2);
      if (paramInt > this.xqe)
      {
        this.xqe = (paramInt + 128);
        this.xqk = new byte[this.xqe];
      }
      this.xqf = paramInt;
      System.arraycopy(paramArrayOfByte, 0, this.xqk, 0, paramInt);
      paramArrayOfByte = this.xqk;
      paramInt = this.xqi + 1;
      paramArrayOfByte = oicq.wlogin_sdk.tools.d.decrypt(paramArrayOfByte, paramInt, this.xqj, this.xqt.xqx);
      if (paramArrayOfByte == null) {}
      for (paramInt = -1002; paramInt >= 0; paramInt = j)
      {
        return z(this.xqk, this.xqi + 1, this.xqj);
        this.xqj = paramArrayOfByte.length;
        if (paramArrayOfByte.length + this.xqi + 2 > this.xqe)
        {
          this.xqe = (paramArrayOfByte.length + this.xqi + 2);
          byte[] arrayOfByte = new byte[this.xqe];
          System.arraycopy(this.xqk, 0, arrayOfByte, 0, this.xqf);
          this.xqk = arrayOfByte;
        }
        this.xqf = 0;
        System.arraycopy(paramArrayOfByte, 0, this.xqk, paramInt, paramArrayOfByte.length);
        paramInt = this.xqf;
        int k = this.xqi;
        this.xqf = (paramArrayOfByte.length + (k + 2) + paramInt);
      }
    }
  }
  
  public final int Z(byte[] paramArrayOfByte, int paramInt)
  {
    this.xqs = paramArrayOfByte[paramInt];
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = xqm + 1;
    xqm = j;
    this.xqf = 0;
    util.C(this.xqk, this.xqf, 2);
    this.xqf += 1;
    util.D(this.xqk, this.xqf, this.xqg + 2 + i);
    this.xqf += 2;
    util.D(this.xqk, this.xqf, paramInt1);
    this.xqf += 2;
    util.D(this.xqk, this.xqf, paramInt2);
    this.xqf += 2;
    util.D(this.xqk, this.xqf, j);
    this.xqf += 2;
    util.E(this.xqk, this.xqf, (int)paramLong);
    this.xqf += 4;
    util.C(this.xqk, this.xqf, 3);
    this.xqf += 1;
    util.C(this.xqk, this.xqf, 0);
    this.xqf += 1;
    util.C(this.xqk, this.xqf, paramInt3);
    this.xqf += 1;
    util.E(this.xqk, this.xqf, paramInt4);
    this.xqf += 4;
    util.E(this.xqk, this.xqf, paramInt5);
    this.xqf += 4;
    util.E(this.xqk, this.xqf, paramInt6);
    this.xqf += 4;
    if (this.xqf + i + 1 > this.xqe)
    {
      this.xqe = (this.xqf + i + 1 + 128);
      byte[] arrayOfByte = new byte[this.xqe];
      System.arraycopy(this.xqk, 0, arrayOfByte, 0, this.xqf);
      this.xqk = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.xqk, this.xqf, i);
    this.xqf = (i + this.xqf);
    util.C(this.xqk, this.xqf, 3);
    this.xqf += 1;
  }
  
  public final byte[] bW(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + this.xqt.xqv.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    System.arraycopy(this.xqt.xqv, 0, arrayOfByte, paramArrayOfByte.length, this.xqt.xqv.length);
    return arrayOfByte;
  }
  
  public final byte[] bX(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16)) {
      return null;
    }
    paramArrayOfByte = (byte[])paramArrayOfByte.clone();
    int i = paramArrayOfByte.length - 16;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    this.xqt.xqv = new byte[16];
    System.arraycopy(paramArrayOfByte, i, this.xqt.xqv, 0, 16);
    return arrayOfByte;
  }
  
  public final byte[] cUB()
  {
    byte[] arrayOfByte = new byte[this.xqf];
    System.arraycopy(this.xqk, 0, arrayOfByte, 0, this.xqf);
    return arrayOfByte;
  }
  
  public final void cUC()
  {
    this.xqt.xqT.cUJ();
  }
  
  final byte[] x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    util.D(arrayOfByte, 0, paramInt1);
    util.D(arrayOfByte, 2, paramInt2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    paramArrayOfByte = oicq.wlogin_sdk.tools.d.a(arrayOfByte, arrayOfByte.length, this.xqt.xqx);
    arrayOfByte = new byte[paramArrayOfByte.length + this.xqt.xqx.length];
    System.arraycopy(this.xqt.xqx, 0, arrayOfByte, 0, this.xqt.xqx.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, this.xqt.xqx.length, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public final void y(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ai localai = new ai();
    if (localai.B(paramArrayOfByte, paramInt1, paramInt2) >= 0)
    {
      paramArrayOfByte = this.xqt.xqT;
      byte[] arrayOfByte = new byte[localai.xrH];
      System.arraycopy(localai.xqk, localai.xqZ + 6, arrayOfByte, 0, localai.xrH);
      paramArrayOfByte.title = new String(arrayOfByte);
      paramArrayOfByte = this.xqt.xqT;
      arrayOfByte = new byte[localai.xrI];
      System.arraycopy(localai.xqk, localai.xqZ + 8 + localai.xrH, arrayOfByte, 0, localai.xrI);
      paramArrayOfByte.message = new String(arrayOfByte);
      paramArrayOfByte = this.xqt.xqT;
      arrayOfByte = new byte[localai.xrJ];
      System.arraycopy(localai.xqk, localai.xqZ + 12 + localai.xrH + localai.xrI, arrayOfByte, 0, localai.xrJ);
      paramArrayOfByte.xrQ = new String(arrayOfByte);
      return;
    }
    this.xqt.xqT.cUJ();
  }
  
  public int z(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    f localf = new f();
    g localg = new g();
    s locals = new s();
    int i;
    if ((this.xqq == 2064) && (this.xqr == 9)) {
      i = 0;
    }
    while (paramInt2 < 5)
    {
      return -1009;
      if ((this.xqq == 2064) && (this.xqr == 10)) {
        i = 1;
      } else if ((this.xqq == 2064) && (this.xqr == 2)) {
        i = 2;
      } else if ((this.xqq == 2064) && (this.xqr == 13)) {
        i = 4;
      } else {
        return -1012;
      }
    }
    int j = Z(paramArrayOfByte, paramInt1 + 2);
    cUC();
    int k = paramInt1 + 5;
    switch (j)
    {
    default: 
      y(paramArrayOfByte, k, this.xqf - k - 1);
      return j;
    case 0: 
      if (i == 1) {
        if (this.xqt.xqw == null) {
          return -1006;
        }
      }
      for (paramInt1 = locals.b(paramArrayOfByte, k, this.xqf - k - 1, this.xqt.xqw); paramInt1 < 0; paramInt1 = locals.b(paramArrayOfByte, k, this.xqf - k - 1, this.xqt.xqv))
      {
        util.ahk("119 can not decrypt, ret=" + paramInt1);
        return paramInt1;
      }
      paramInt1 = a(locals);
      if (paramInt1 < 0)
      {
        util.ahk("parse 119 failed, ret=" + paramInt1);
        return paramInt1;
      }
      return 0;
    case 1: 
      y(paramArrayOfByte, k, this.xqf - k - 1);
      return j;
    }
    paramInt2 = localf.B(paramArrayOfByte, k, this.xqf - k - 1);
    paramInt1 = paramInt2;
    if (paramInt2 >= 0)
    {
      this.xqt.xqy = localf;
      paramInt2 = localg.B(paramArrayOfByte, k, this.xqf - k - 1);
      paramInt1 = paramInt2;
      if (paramInt2 >= 0)
      {
        this.xqt.xqz = localg;
        return j;
      }
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.d
 * JD-Core Version:    0.7.0.1
 */