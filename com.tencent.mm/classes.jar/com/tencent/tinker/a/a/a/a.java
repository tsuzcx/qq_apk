package com.tencent.tinker.a.a.a;

import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.e.a;
import com.tencent.tinker.a.a.e.b;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.g.a;
import com.tencent.tinker.a.a.g.b;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t;
import java.io.ByteArrayOutputStream;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a
  implements com.tencent.tinker.a.a.b.a, com.tencent.tinker.a.a.b.b
{
  private static final short[] ahNW = new short[0];
  private static final g.b[] ahOR = new g.b[0];
  private static final g.a[] ahOS = new g.a[0];
  private int ahOT;
  private boolean ahOU;
  public ByteBuffer cKQ;
  
  public a()
  {
    this.cKQ = ByteBuffer.allocate(512);
    this.cKQ.order(ByteOrder.LITTLE_ENDIAN);
    this.ahOT = this.cKQ.position();
    this.cKQ.limit(this.cKQ.capacity());
    this.ahOU = true;
  }
  
  public a(ByteBuffer paramByteBuffer)
  {
    this.cKQ = paramByteBuffer;
    this.cKQ.order(ByteOrder.LITTLE_ENDIAN);
    this.ahOT = paramByteBuffer.limit();
    this.ahOU = false;
  }
  
  private void a(e.a[] paramArrayOfa)
  {
    int k = paramArrayOfa.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      e.a locala = paramArrayOfa[i];
      o.a(this, locala.ahNw - j);
      j = locala.ahNw;
      o.a(this, locala.ahNx);
      i += 1;
    }
  }
  
  private void a(e.b[] paramArrayOfb)
  {
    int k = paramArrayOfb.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      e.b localb = paramArrayOfb[i];
      o.a(this, localb.ahNy - j);
      j = localb.ahNy;
      o.a(this, localb.ahNx);
      o.a(this, localb.ahNz);
      i += 1;
    }
  }
  
  private void aIl(int paramInt)
  {
    if ((this.cKQ.position() + paramInt > this.cKQ.limit()) && (this.ahOU))
    {
      byte[] arrayOfByte1 = this.cKQ.array();
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt + (arrayOfByte1.length >> 1)];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, this.cKQ.position());
      paramInt = this.cKQ.position();
      this.cKQ = ByteBuffer.wrap(arrayOfByte2);
      this.cKQ.order(ByteOrder.LITTLE_ENDIAN);
      this.cKQ.position(paramInt);
      this.cKQ.limit(this.cKQ.capacity());
    }
  }
  
  private short[] aIn(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = ahNW;
      return localObject;
    }
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfShort;
      if (i >= paramInt) {
        break;
      }
      arrayOfShort[i] = this.cKQ.getShort();
      i += 1;
    }
  }
  
  private e.a[] aIo(int paramInt)
  {
    e.a[] arrayOfa = new e.a[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = o.b(this) + j;
      arrayOfa[i] = new e.a(j, o.b(this));
      i += 1;
    }
    return arrayOfa;
  }
  
  private e.b[] aIp(int paramInt)
  {
    e.b[] arrayOfb = new e.b[paramInt];
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j = o.b(this) + j;
      arrayOfb[i] = new e.b(j, o.b(this), o.b(this));
      i += 1;
    }
    return arrayOfb;
  }
  
  private byte[] aIq(int paramInt)
  {
    byte[] arrayOfByte = new byte[this.cKQ.position() - paramInt];
    this.cKQ.position(paramInt);
    this.cKQ.get(arrayOfByte);
    return arrayOfByte;
  }
  
  private void aIr(int paramInt)
  {
    int i = (short)paramInt;
    if (paramInt != (0xFFFF & i)) {
      throw new IllegalArgumentException("Expected an unsigned short: ".concat(String.valueOf(paramInt)));
    }
    b(i);
  }
  
  private int kbT()
  {
    return o.b(this);
  }
  
  private int kbU()
  {
    return o.b(this) - 1;
  }
  
  private int kbV()
  {
    return o.a(this);
  }
  
  private int readUnsignedShort()
  {
    return this.cKQ.getShort() & 0xFFFF;
  }
  
  private void skip(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    this.cKQ.position(this.cKQ.position() + paramInt);
  }
  
  public int a(k paramk)
  {
    int i = this.cKQ.position();
    write(paramk.data);
    return i;
  }
  
  public int a(n paramn)
  {
    int i = this.cKQ.position();
    aIr(paramn.ahOk);
    aIr(paramn.ahNA);
    aX(paramn.ahOl);
    return i;
  }
  
  public int a(p paramp)
  {
    int i = this.cKQ.position();
    aIr(paramp.ahOk);
    aIr(paramp.ahOm);
    aX(paramp.ahOl);
    return i;
  }
  
  public int a(q paramq)
  {
    int i = this.cKQ.position();
    aX(paramq.ahOn);
    aX(paramq.ahOo);
    aX(paramq.ahOp);
    return i;
  }
  
  public int a(r paramr)
  {
    int n = this.cKQ.position();
    for (;;)
    {
      long l;
      int k;
      byte[] arrayOfByte;
      int i2;
      try
      {
        o.a(this, paramr.value.length());
        paramr = paramr.value;
        l = 0L;
        k = paramr.length();
        j = 0;
        if (j < k)
        {
          m = paramr.charAt(j);
          if ((m == 0) || (m > 127)) {
            break label289;
          }
          l += 1L;
          break label282;
        }
        arrayOfByte = new byte[(int)l];
        int i1 = paramr.length();
        k = 0;
        j = 0;
        if (k >= i1) {
          break label268;
        }
        i2 = paramr.charAt(k);
        if ((i2 != 0) && (i2 <= 127))
        {
          m = j + 1;
          arrayOfByte[j] = ((byte)i2);
          j = m;
        }
        else if (i2 <= 2047)
        {
          m = j + 1;
          arrayOfByte[j] = ((byte)(i2 >> 6 & 0x1F | 0xC0));
          j = m + 1;
          arrayOfByte[m] = ((byte)(i2 & 0x3F | 0x80));
        }
      }
      catch (UTFDataFormatException paramr)
      {
        throw new AssertionError(paramr);
      }
      int m = j + 1;
      int i = (byte)(i2 >> 12 & 0xF | 0xE0);
      arrayOfByte[j] = i;
      int i3 = m + 1;
      arrayOfByte[m] = ((byte)(i2 >> 6 & 0x3F | 0x80));
      int j = i3 + 1;
      arrayOfByte[i3] = ((byte)(i2 & 0x3F | 0x80));
      break label319;
      label268:
      write(arrayOfByte);
      eQ(0);
      return n;
      for (;;)
      {
        label282:
        j += 1;
        break;
        label289:
        if (m <= 2047) {
          l += 2L;
        } else {
          l += 3L;
        }
      }
      label319:
      k += 1;
    }
  }
  
  public int a(t paramt)
  {
    int j = this.cKQ.position();
    paramt = paramt.ahOQ;
    aX(paramt.length);
    int k = paramt.length;
    int i = 0;
    while (i < k)
    {
      b(paramt[i]);
      i += 1;
    }
    return j;
  }
  
  public final byte[] aIm(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.cKQ.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public final void aX(int paramInt)
  {
    aIl(4);
    this.cKQ.putInt(paramInt);
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
  }
  
  public int b(com.tencent.tinker.a.a.a parama)
  {
    int i = this.cKQ.position();
    eQ(parama.ahNk);
    a(parama.ahNl);
    return i;
  }
  
  public int b(com.tencent.tinker.a.a.b paramb)
  {
    int j = this.cKQ.position();
    aX(paramb.ahNm.length);
    paramb = paramb.ahNm;
    int k = paramb.length;
    int i = 0;
    while (i < k)
    {
      aX(paramb[i]);
      i += 1;
    }
    return j;
  }
  
  public int b(c paramc)
  {
    int j = this.cKQ.position();
    aX(paramc.ahNn.length);
    paramc = paramc.ahNn;
    int k = paramc.length;
    int i = 0;
    while (i < k)
    {
      aX(paramc[i]);
      i += 1;
    }
    return j;
  }
  
  public int b(d paramd)
  {
    int j = this.cKQ.position();
    aX(paramd.ahNo);
    aX(paramd.ahNp.length);
    aX(paramd.ahNq.length);
    aX(paramd.ahNr.length);
    int[][] arrayOfInt = paramd.ahNp;
    int k = arrayOfInt.length;
    int i = 0;
    int[] arrayOfInt1;
    while (i < k)
    {
      arrayOfInt1 = arrayOfInt[i];
      aX(arrayOfInt1[0]);
      aX(arrayOfInt1[1]);
      i += 1;
    }
    arrayOfInt = paramd.ahNq;
    k = arrayOfInt.length;
    i = 0;
    while (i < k)
    {
      arrayOfInt1 = arrayOfInt[i];
      aX(arrayOfInt1[0]);
      aX(arrayOfInt1[1]);
      i += 1;
    }
    paramd = paramd.ahNr;
    k = paramd.length;
    i = 0;
    while (i < k)
    {
      arrayOfInt = paramd[i];
      aX(arrayOfInt[0]);
      aX(arrayOfInt[1]);
      i += 1;
    }
    return j;
  }
  
  public int b(e parame)
  {
    int i = this.cKQ.position();
    o.a(this, parame.ahNs.length);
    o.a(this, parame.ahNt.length);
    o.a(this, parame.ahNu.length);
    o.a(this, parame.ahNv.length);
    a(parame.ahNs);
    a(parame.ahNt);
    a(parame.ahNu);
    a(parame.ahNv);
    return i;
  }
  
  public int b(f paramf)
  {
    int i = this.cKQ.position();
    aX(paramf.ahNA);
    aX(paramf.ahNx);
    aX(paramf.ahNB);
    aX(paramf.ahNC);
    aX(paramf.ahND);
    aX(paramf.ahNE);
    aX(paramf.ahNF);
    aX(paramf.ahNG);
    return i;
  }
  
  public int b(g paramg)
  {
    int k = 0;
    int m = this.cKQ.position();
    aIr(paramg.ahNH);
    aIr(paramg.ahNI);
    aIr(paramg.ahNJ);
    aIr(paramg.ahNM.length);
    aX(paramg.ahNK);
    aX(paramg.ahNL.length);
    Object localObject1 = paramg.ahNL;
    aIl(localObject1.length * 2);
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      b(localObject1[i]);
      i += 1;
    }
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
    if (paramg.ahNM.length > 0)
    {
      if ((paramg.ahNL.length & 0x1) == 1) {
        b((short)0);
      }
      int n = this.cKQ.position();
      i = paramg.ahNM.length * 8;
      aIl(i * 1);
      skip(i);
      g.a[] arrayOfa = paramg.ahNN;
      int i1 = this.cKQ.position();
      o.a(this, arrayOfa.length);
      localObject1 = new int[arrayOfa.length];
      i = 0;
      while (i < arrayOfa.length)
      {
        localObject1[i] = (this.cKQ.position() - i1);
        Object localObject2 = arrayOfa[i];
        int i2 = ((g.a)localObject2).ahNQ;
        int[] arrayOfInt = ((g.a)localObject2).ahNO;
        localObject2 = ((g.a)localObject2).ahNP;
        if (i2 != -1) {
          o.c(this, -arrayOfInt.length);
        }
        for (;;)
        {
          j = 0;
          while (j < arrayOfInt.length)
          {
            o.a(this, arrayOfInt[j]);
            o.a(this, localObject2[j]);
            j += 1;
          }
          o.c(this, arrayOfInt.length);
        }
        if (i2 != -1) {
          o.a(this, i2);
        }
        i += 1;
      }
      j = this.cKQ.position();
      this.cKQ.position(n);
      paramg = paramg.ahNM;
      n = paramg.length;
      i = k;
      while (i < n)
      {
        arrayOfa = paramg[i];
        aX(arrayOfa.ahNR);
        aIr(arrayOfa.ahNS);
        aIr(localObject1[arrayOfa.ahNT]);
        i += 1;
      }
      this.cKQ.position(j);
    }
    return m;
  }
  
  public int b(h paramh)
  {
    int j = this.cKQ.position();
    o.a(this, paramh.dIe);
    int k = paramh.ahNU.length;
    o.a(this, k);
    int i = 0;
    while (i < k)
    {
      o.a(this, paramh.ahNU[i] + 1);
      i += 1;
    }
    write(paramh.ahNV);
    return j;
  }
  
  public final void b(short paramShort)
  {
    aIl(2);
    this.cKQ.putShort(paramShort);
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
  }
  
  public final void eQ(int paramInt)
  {
    aIl(1);
    this.cKQ.put((byte)paramInt);
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
  }
  
  public q kbA()
  {
    return new q(this.cKQ.position(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt());
  }
  
  public f kbB()
  {
    return new f(this.cKQ.position(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt(), this.cKQ.getInt());
  }
  
  public g kbC()
  {
    int k = this.cKQ.position();
    int m = readUnsignedShort();
    int n = readUnsignedShort();
    int i1 = readUnsignedShort();
    int i2 = readUnsignedShort();
    int i3 = this.cKQ.getInt();
    short[] arrayOfShort = aIn(this.cKQ.getInt());
    g.a[] arrayOfa;
    Object localObject;
    if (i2 > 0)
    {
      if ((arrayOfShort.length & 0x1) == 1) {
        skip(2);
      }
      int i4 = this.cKQ.position();
      skip(i2 * 8);
      int i5 = this.cKQ.position();
      int i6 = o.b(this);
      arrayOfa = new g.a[i6];
      int i = 0;
      int i7;
      int j;
      if (i < i6)
      {
        i7 = this.cKQ.position();
        int i8 = o.a(this);
        int i9 = Math.abs(i8);
        localObject = new int[i9];
        int[] arrayOfInt = new int[i9];
        j = 0;
        while (j < i9)
        {
          localObject[j] = o.b(this);
          arrayOfInt[j] = o.b(this);
          j += 1;
        }
        if (i8 <= 0) {}
        for (j = o.b(this);; j = -1)
        {
          arrayOfa[i] = new g.a((int[])localObject, arrayOfInt, j, i7 - i5);
          i += 1;
          break;
        }
      }
      i5 = this.cKQ.position();
      this.cKQ.position(i4);
      localObject = new g.b[i2];
      i = 0;
      if (i < i2)
      {
        i4 = this.cKQ.getInt();
        i6 = readUnsignedShort();
        i7 = readUnsignedShort();
        j = 0;
        for (;;)
        {
          if (j >= arrayOfa.length) {
            break label335;
          }
          if (arrayOfa[j].offset == i7)
          {
            localObject[i] = new g.b(i4, i6, j);
            i += 1;
            break;
          }
          j += 1;
        }
        label335:
        throw new IllegalArgumentException();
      }
      this.cKQ.position(i5);
    }
    for (;;)
    {
      return new g(k, m, n, i1, i3, arrayOfShort, (g.b[])localObject, arrayOfa);
      localObject = ahOR;
      arrayOfa = ahOS;
    }
  }
  
  /* Error */
  public h kbD()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/tencent/tinker/a/a/a/a:cKQ	Ljava/nio/ByteBuffer;
    //   4: invokevirtual 60	java/nio/ByteBuffer:position	()I
    //   7: istore_2
    //   8: aload_0
    //   9: invokestatic 129	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/a;)I
    //   12: istore_3
    //   13: aload_0
    //   14: invokestatic 129	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/a;)I
    //   17: istore 4
    //   19: iload 4
    //   21: newarray int
    //   23: astore 5
    //   25: iconst_0
    //   26: istore_1
    //   27: iload_1
    //   28: iload 4
    //   30: if_icmpge +20 -> 50
    //   33: aload 5
    //   35: iload_1
    //   36: aload_0
    //   37: invokestatic 129	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/a;)I
    //   40: iconst_1
    //   41: isub
    //   42: iastore
    //   43: iload_1
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: goto -20 -> 27
    //   50: new 454	java/io/ByteArrayOutputStream
    //   53: dup
    //   54: bipush 64
    //   56: invokespecial 456	java/io/ByteArrayOutputStream:<init>	(I)V
    //   59: astore 6
    //   61: new 10	com/tencent/tinker/a/a/a/a$1
    //   64: dup
    //   65: aload_0
    //   66: aload 6
    //   68: invokespecial 459	com/tencent/tinker/a/a/a/a$1:<init>	(Lcom/tencent/tinker/a/a/a/a;Ljava/io/ByteArrayOutputStream;)V
    //   71: astore 7
    //   73: aload_0
    //   74: getfield 46	com/tencent/tinker/a/a/a/a:cKQ	Ljava/nio/ByteBuffer;
    //   77: invokevirtual 462	java/nio/ByteBuffer:get	()B
    //   80: istore_1
    //   81: aload 6
    //   83: iload_1
    //   84: invokevirtual 464	java/io/ByteArrayOutputStream:write	(I)V
    //   87: iload_1
    //   88: tableswitch	default:+215 -> 303, 0:+56->144, 1:+82->170, 2:+110->198, 3:+123->211, 4:+123->211, 5:+171->259, 6:+171->259, 7:+215->303, 8:+215->303, 9:+184->272
    //   145: aconst_null
    //   146: f2l
    //   147: dup
    //   148: iload_2
    //   149: iload_3
    //   150: aload 5
    //   152: aload 6
    //   154: invokevirtual 467	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: invokespecial 470	com/tencent/tinker/a/a/h:<init>	(II[I[B)V
    //   160: astore 5
    //   162: aload 6
    //   164: invokevirtual 473	java/io/ByteArrayOutputStream:close	()V
    //   167: aload 5
    //   169: areturn
    //   170: aload 7
    //   172: aload_0
    //   173: invokespecial 475	com/tencent/tinker/a/a/a/a:kbT	()I
    //   176: invokestatic 86	com/tencent/tinker/a/a/o:a	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   179: pop
    //   180: goto -107 -> 73
    //   183: astore 5
    //   185: aload 6
    //   187: ifnull +8 -> 195
    //   190: aload 6
    //   192: invokevirtual 473	java/io/ByteArrayOutputStream:close	()V
    //   195: aload 5
    //   197: athrow
    //   198: aload 7
    //   200: aload_0
    //   201: invokespecial 477	com/tencent/tinker/a/a/a/a:kbV	()I
    //   204: invokestatic 384	com/tencent/tinker/a/a/o:c	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   207: pop
    //   208: goto -135 -> 73
    //   211: aload 7
    //   213: aload_0
    //   214: invokespecial 475	com/tencent/tinker/a/a/a/a:kbT	()I
    //   217: invokestatic 86	com/tencent/tinker/a/a/o:a	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   220: pop
    //   221: aload 7
    //   223: aload_0
    //   224: invokespecial 479	com/tencent/tinker/a/a/a/a:kbU	()I
    //   227: invokestatic 481	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   230: pop
    //   231: aload 7
    //   233: aload_0
    //   234: invokespecial 479	com/tencent/tinker/a/a/a/a:kbU	()I
    //   237: invokestatic 481	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   240: pop
    //   241: iload_1
    //   242: iconst_4
    //   243: if_icmpne -170 -> 73
    //   246: aload 7
    //   248: aload_0
    //   249: invokespecial 479	com/tencent/tinker/a/a/a/a:kbU	()I
    //   252: invokestatic 481	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   255: pop
    //   256: goto -183 -> 73
    //   259: aload 7
    //   261: aload_0
    //   262: invokespecial 475	com/tencent/tinker/a/a/a/a:kbT	()I
    //   265: invokestatic 86	com/tencent/tinker/a/a/o:a	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   268: pop
    //   269: goto -196 -> 73
    //   272: aload 7
    //   274: aload_0
    //   275: invokespecial 479	com/tencent/tinker/a/a/a/a:kbU	()I
    //   278: invokestatic 481	com/tencent/tinker/a/a/o:b	(Lcom/tencent/tinker/a/a/b/b;I)I
    //   281: pop
    //   282: goto -209 -> 73
    //   285: astore 6
    //   287: aload 5
    //   289: areturn
    //   290: astore 6
    //   292: goto -97 -> 195
    //   295: astore 5
    //   297: aconst_null
    //   298: astore 6
    //   300: goto -115 -> 185
    //   303: goto -230 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	a
    //   26	218	1	i	int
    //   7	142	2	j	int
    //   12	138	3	k	int
    //   17	14	4	m	int
    //   23	145	5	localObject1	Object
    //   183	105	5	localh	h
    //   295	1	5	localObject2	Object
    //   59	132	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   285	1	6	localException1	java.lang.Exception
    //   290	1	6	localException2	java.lang.Exception
    //   298	1	6	localObject3	Object
    //   71	202	7	local1	1
    // Exception table:
    //   from	to	target	type
    //   61	73	183	finally
    //   73	87	183	finally
    //   144	162	183	finally
    //   170	180	183	finally
    //   198	208	183	finally
    //   211	241	183	finally
    //   246	256	183	finally
    //   259	269	183	finally
    //   272	282	183	finally
    //   162	167	285	java/lang/Exception
    //   190	195	290	java/lang/Exception
    //   50	61	295	finally
  }
  
  public e kbE()
  {
    int i = this.cKQ.position();
    int j = o.b(this);
    int k = o.b(this);
    int m = o.b(this);
    int n = o.b(this);
    return new e(i, aIo(j), aIo(k), aIp(m), aIp(n));
  }
  
  public com.tencent.tinker.a.a.a kbF()
  {
    int i = this.cKQ.position();
    byte b = this.cKQ.get();
    int j = this.cKQ.position();
    new m(this, 29).Zp();
    return new com.tencent.tinker.a.a.a(i, b, new k(j, aIq(j)));
  }
  
  public com.tencent.tinker.a.a.b kbG()
  {
    int j = this.cKQ.position();
    int k = this.cKQ.getInt();
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInt[i] = this.cKQ.getInt();
      i += 1;
    }
    return new com.tencent.tinker.a.a.b(j, arrayOfInt);
  }
  
  public c kbH()
  {
    int j = this.cKQ.position();
    int k = this.cKQ.getInt();
    int[] arrayOfInt = new int[k];
    int i = 0;
    while (i < k)
    {
      arrayOfInt[i] = this.cKQ.getInt();
      i += 1;
    }
    return new c(j, arrayOfInt);
  }
  
  public d kbI()
  {
    int j = this.cKQ.position();
    int k = this.cKQ.getInt();
    int i1 = this.cKQ.getInt();
    int n = this.cKQ.getInt();
    int m = this.cKQ.getInt();
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1, 2 });
    int i = 0;
    while (i < i1)
    {
      arrayOfInt1[i][0] = this.cKQ.getInt();
      arrayOfInt1[i][1] = this.cKQ.getInt();
      i += 1;
    }
    int[][] arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
    i = 0;
    while (i < n)
    {
      arrayOfInt2[i][0] = this.cKQ.getInt();
      arrayOfInt2[i][1] = this.cKQ.getInt();
      i += 1;
    }
    int[][] arrayOfInt3 = (int[][])Array.newInstance(Integer.TYPE, new int[] { m, 2 });
    i = 0;
    while (i < m)
    {
      arrayOfInt3[i][0] = this.cKQ.getInt();
      arrayOfInt3[i][1] = this.cKQ.getInt();
      i += 1;
    }
    return new d(j, k, arrayOfInt1, arrayOfInt2, arrayOfInt3);
  }
  
  public k kbJ()
  {
    int i = this.cKQ.position();
    new m(this, 28).Zp();
    return new k(i, aIq(i));
  }
  
  public final void kbW()
  {
    this.cKQ.position(this.cKQ.position() + 3 & 0xFFFFFFFC);
  }
  
  public final void kbX()
  {
    aIl(((this.cKQ.position() + 3 & 0xFFFFFFFC) - this.cKQ.position()) * 1);
    while ((this.cKQ.position() & 0x3) != 0) {
      this.cKQ.put((byte)0);
    }
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
  }
  
  public r kbw()
  {
    int j = 0;
    int k = this.cKQ.position();
    for (;;)
    {
      int i;
      try
      {
        int m = o.b(this);
        Object localObject = new char[m];
        i = (char)(readByte() & 0xFF);
        if (i == 0)
        {
          localObject = new String((char[])localObject, 0, j);
          if (((String)localObject).length() == m) {
            break label259;
          }
          throw new j("Declared length " + m + " doesn't match decoded length of " + ((String)localObject).length());
        }
      }
      catch (UTFDataFormatException localUTFDataFormatException)
      {
        throw new j(localUTFDataFormatException);
      }
      localUTFDataFormatException[j] = i;
      if (i < 128)
      {
        j += 1;
      }
      else
      {
        int n;
        int i1;
        label259:
        r localr;
        if ((i & 0xE0) == 192)
        {
          n = readByte() & 0xFF;
          if ((n & 0xC0) != 128) {
            throw new UTFDataFormatException("bad second byte");
          }
        }
        else
        {
          if ((i & 0xF0) == 224)
          {
            n = readByte() & 0xFF;
            i1 = readByte() & 0xFF;
            if (((n & 0xC0) == 128) && ((i1 & 0xC0) == 128)) {
              break label299;
            }
            throw new UTFDataFormatException("bad second or third byte");
          }
          throw new UTFDataFormatException("bad byte");
          localr = new r(k, localUTFDataFormatException);
          return localr;
        }
        localr[j] = ((char)((i & 0x1F) << 6 | n & 0x3F));
        j += 1;
        continue;
        label299:
        localr[j] = ((char)((i & 0xF) << 12 | (n & 0x3F) << 6 | i1 & 0x3F));
        j += 1;
      }
    }
  }
  
  public t kbx()
  {
    return new t(this.cKQ.position(), aIn(this.cKQ.getInt()));
  }
  
  public n kby()
  {
    return new n(this.cKQ.position(), readUnsignedShort(), readUnsignedShort(), this.cKQ.getInt());
  }
  
  public p kbz()
  {
    return new p(this.cKQ.position(), readUnsignedShort(), readUnsignedShort(), this.cKQ.getInt());
  }
  
  public final byte readByte()
  {
    return this.cKQ.get();
  }
  
  public final void write(byte[] paramArrayOfByte)
  {
    aIl(paramArrayOfByte.length * 1);
    this.cKQ.put(paramArrayOfByte);
    if (this.cKQ.position() > this.ahOT) {
      this.ahOT = this.cKQ.position();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */