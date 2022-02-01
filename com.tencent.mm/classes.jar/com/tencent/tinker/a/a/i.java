package com.tencent.tinker.a.a;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i
{
  static final short[] Sgj = new short[0];
  public final s Sgk = new s();
  private final f Sgl = new f((byte)0);
  private final g Sgm = new g((byte)0);
  private final h Sgn = new h((byte)0);
  private final d Sgo = new d((byte)0);
  private final b Sgp = new b((byte)0);
  private final c Sgq = new c((byte)0);
  private final a Sgr = new a((byte)0);
  private int Sgs = 0;
  public ByteBuffer aKP;
  private byte[] yRs = null;
  
  public i(int paramInt)
  {
    this.aKP = ByteBuffer.wrap(new byte[paramInt]);
    this.aKP.order(ByteOrder.LITTLE_ENDIAN);
    this.Sgk.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aKP = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aKP.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.Sgk;
    e locale = a(paramInputStream.SgE);
    byte[] arrayOfByte = locale.arM(8);
    int i = j;
    if (arrayOfByte.length == 8)
    {
      i = j;
      if (arrayOfByte[0] == 100)
      {
        i = j;
        if (arrayOfByte[1] == 101)
        {
          i = j;
          if (arrayOfByte[2] == 120)
          {
            i = j;
            if (arrayOfByte[3] == 10)
            {
              if (arrayOfByte[7] == 0) {
                break label263;
              }
              i = j;
            }
          }
        }
      }
    }
    while (i != 13)
    {
      throw new j("Unexpected magic: " + Arrays.toString(arrayOfByte));
      label263:
      String str = (char)arrayOfByte[4] + (char)arrayOfByte[5] + (char)arrayOfByte[6];
      if (str.equals("036"))
      {
        i = 14;
      }
      else
      {
        i = j;
        if (str.equals("035")) {
          i = 13;
        }
      }
    }
    paramInputStream.jvw = locale.aKP.getInt();
    paramInputStream.yRs = locale.arM(20);
    paramInputStream.fileSize = locale.aKP.getInt();
    i = locale.aKP.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aKP.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.SgX = locale.aKP.getInt();
    paramInputStream.SgY = locale.aKP.getInt();
    paramInputStream.SgL.off = locale.aKP.getInt();
    if (paramInputStream.SgL.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.SgF.size = locale.aKP.getInt();
    paramInputStream.SgF.off = locale.aKP.getInt();
    paramInputStream.SgG.size = locale.aKP.getInt();
    paramInputStream.SgG.off = locale.aKP.getInt();
    paramInputStream.SgH.size = locale.aKP.getInt();
    paramInputStream.SgH.off = locale.aKP.getInt();
    paramInputStream.SgI.size = locale.aKP.getInt();
    paramInputStream.SgI.off = locale.aKP.getInt();
    paramInputStream.SgJ.size = locale.aKP.getInt();
    paramInputStream.SgJ.off = locale.aKP.getInt();
    paramInputStream.SgK.size = locale.aKP.getInt();
    paramInputStream.SgK.off = locale.aKP.getInt();
    paramInputStream.dataSize = locale.aKP.getInt();
    paramInputStream.SgZ = locale.aKP.getInt();
    paramInputStream.a(arH(paramInputStream.SgL.off));
    paramInputStream.hoR();
  }
  
  private static void mB(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final byte[] Ea(boolean paramBoolean)
  {
    if ((this.yRs != null) && (!paramBoolean)) {
      return this.yRs;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aKP.duplicate();
      localByteBuffer.limit(localByteBuffer.capacity());
      localByteBuffer.position(32);
      while (localByteBuffer.hasRemaining())
      {
        int i = Math.min(8192, localByteBuffer.remaining());
        localByteBuffer.get(arrayOfByte2, 0, i);
        localMessageDigest.update(arrayOfByte2, 0, i);
      }
      arrayOfByte1 = localNoSuchAlgorithmException.digest();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError();
    }
    byte[] arrayOfByte1;
    this.yRs = arrayOfByte1;
    return arrayOfByte1;
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aKP.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aKP.capacity());
    }
    ByteBuffer localByteBuffer = this.aKP.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e arH(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aKP.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aKP.capacity());
    }
    ByteBuffer localByteBuffer = this.aKP.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aKP.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int arI(int paramInt)
  {
    mB(paramInt, this.Sgk.SgG.size);
    int i = this.Sgk.SgG.off;
    return this.aKP.getInt(i + paramInt * 4);
  }
  
  public final void hot()
  {
    arH(12).write(Ea(true));
    e locale = arH(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aKP.duplicate();
    localByteBuffer.limit(localByteBuffer.capacity());
    localByteBuffer.position(12);
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(8192, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      localAdler32.update(arrayOfByte, 0, i);
    }
    locale.writeInt((int)localAdler32.getValue());
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).SgK.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).SgI.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).SgJ.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).SgH.size;
    }
  }
  
  public final class e
    extends com.tencent.tinker.a.a.a.a
  {
    private final String name;
    
    private e(String paramString, ByteBuffer paramByteBuffer)
    {
      super();
      this.name = paramString;
    }
    
    private void a(s.a parama, boolean paramBoolean)
    {
      if (parama.Shb)
      {
        if (paramBoolean) {
          hoW();
        }
      }
      else {
        return;
      }
      hoV();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).SgU, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).SgI, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).SgJ, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).SgH, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).SgR, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).SgM, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).SgT, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).SgO, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).SgN, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).SgV, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).SgP, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).SgK, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).SgQ, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).SgS, true);
      return super.b(paramh);
    }
    
    public final g hoA()
    {
      a(i.a(i.this).SgQ, false);
      return super.hoA();
    }
    
    public final h hoB()
    {
      a(i.a(i.this).SgS, false);
      return super.hoB();
    }
    
    public final e hoC()
    {
      a(i.a(i.this).SgP, false);
      return super.hoC();
    }
    
    public final a hoD()
    {
      a(i.a(i.this).SgT, false);
      return super.hoD();
    }
    
    public final b hoE()
    {
      a(i.a(i.this).SgO, false);
      return super.hoE();
    }
    
    public final c hoF()
    {
      a(i.a(i.this).SgN, false);
      return super.hoF();
    }
    
    public final d hoG()
    {
      a(i.a(i.this).SgV, false);
      return super.hoG();
    }
    
    public final k hoH()
    {
      a(i.a(i.this).SgU, false);
      return super.hoH();
    }
    
    public final r hou()
    {
      a(i.a(i.this).SgR, false);
      return super.hou();
    }
    
    public final t hov()
    {
      a(i.a(i.this).SgM, false);
      return super.hov();
    }
    
    public final n how()
    {
      a(i.a(i.this).SgI, false);
      return super.how();
    }
    
    public final p hox()
    {
      a(i.a(i.this).SgJ, false);
      return super.hox();
    }
    
    public final q hoy()
    {
      a(i.a(i.this).SgH, false);
      return super.hoy();
    }
    
    public final f hoz()
    {
      a(i.a(i.this).SgK, false);
      return super.hoz();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String QW(int paramInt)
    {
      i.mC(paramInt, i.a(i.this).SgF.size);
      paramInt = i.this.arH(i.a(i.this).SgF.off + paramInt * 4).aKP.getInt();
      return i.this.arH(paramInt).hou().value;
    }
    
    public final int size()
    {
      return i.a(i.this).SgF.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).SgG.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).SgG.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */