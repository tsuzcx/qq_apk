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
  static final short[] ZIU = new short[0];
  private byte[] Evq = null;
  public final s ZIV = new s();
  private final f ZIW = new f((byte)0);
  private final g ZIX = new g((byte)0);
  private final h ZIY = new h((byte)0);
  private final d ZIZ = new d((byte)0);
  private final b ZJa = new b((byte)0);
  private final c ZJb = new c((byte)0);
  private final a ZJc = new a((byte)0);
  private int ZJd = 0;
  public ByteBuffer aQU;
  
  public i(int paramInt)
  {
    this.aQU = ByteBuffer.wrap(new byte[paramInt]);
    this.aQU.order(ByteOrder.LITTLE_ENDIAN);
    this.ZIV.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aQU = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aQU.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.ZIV;
    e locale = a(paramInputStream.ZJp);
    byte[] arrayOfByte = locale.aBA(8);
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
    paramInputStream.mkZ = locale.aQU.getInt();
    paramInputStream.Evq = locale.aBA(20);
    paramInputStream.fileSize = locale.aQU.getInt();
    i = locale.aQU.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aQU.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.ZJI = locale.aQU.getInt();
    paramInputStream.ZJJ = locale.aQU.getInt();
    paramInputStream.ZJw.off = locale.aQU.getInt();
    if (paramInputStream.ZJw.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.ZJq.size = locale.aQU.getInt();
    paramInputStream.ZJq.off = locale.aQU.getInt();
    paramInputStream.ZJr.size = locale.aQU.getInt();
    paramInputStream.ZJr.off = locale.aQU.getInt();
    paramInputStream.ZJs.size = locale.aQU.getInt();
    paramInputStream.ZJs.off = locale.aQU.getInt();
    paramInputStream.ZJt.size = locale.aQU.getInt();
    paramInputStream.ZJt.off = locale.aQU.getInt();
    paramInputStream.ZJu.size = locale.aQU.getInt();
    paramInputStream.ZJu.off = locale.aQU.getInt();
    paramInputStream.ZJv.size = locale.aQU.getInt();
    paramInputStream.ZJv.off = locale.aQU.getInt();
    paramInputStream.dataSize = locale.aQU.getInt();
    paramInputStream.ZJK = locale.aQU.getInt();
    paramInputStream.a(aBv(paramInputStream.ZJw.off));
    paramInputStream.iss();
  }
  
  private static void nS(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final byte[] IB(boolean paramBoolean)
  {
    if ((this.Evq != null) && (!paramBoolean)) {
      return this.Evq;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aQU.duplicate();
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
    this.Evq = arrayOfByte1;
    return arrayOfByte1;
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aQU.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aQU.capacity());
    }
    ByteBuffer localByteBuffer = this.aQU.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e aBv(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aQU.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aQU.capacity());
    }
    ByteBuffer localByteBuffer = this.aQU.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aQU.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int aBw(int paramInt)
  {
    nS(paramInt, this.ZIV.ZJr.size);
    int i = this.ZIV.ZJr.off;
    return this.aQU.getInt(i + paramInt * 4);
  }
  
  public final void irV()
  {
    aBv(12).write(IB(true));
    e locale = aBv(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aQU.duplicate();
    localByteBuffer.limit(localByteBuffer.capacity());
    localByteBuffer.position(12);
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(8192, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      localAdler32.update(arrayOfByte, 0, i);
    }
    locale.bV((int)localAdler32.getValue());
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).ZJv.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).ZJt.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).ZJu.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).ZJs.size;
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
      if (parama.ZJM)
      {
        if (paramBoolean) {
          isx();
        }
      }
      else {
        return;
      }
      isw();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).ZJF, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).ZJt, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).ZJu, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).ZJs, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).ZJC, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).ZJx, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).ZJE, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).ZJz, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).ZJy, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).ZJG, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).ZJA, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).ZJv, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).ZJB, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).ZJD, true);
      return super.b(paramh);
    }
    
    public final r irW()
    {
      a(i.a(i.this).ZJC, false);
      return super.irW();
    }
    
    public final t irX()
    {
      a(i.a(i.this).ZJx, false);
      return super.irX();
    }
    
    public final n irY()
    {
      a(i.a(i.this).ZJt, false);
      return super.irY();
    }
    
    public final p irZ()
    {
      a(i.a(i.this).ZJu, false);
      return super.irZ();
    }
    
    public final q isa()
    {
      a(i.a(i.this).ZJs, false);
      return super.isa();
    }
    
    public final f isb()
    {
      a(i.a(i.this).ZJv, false);
      return super.isb();
    }
    
    public final g isc()
    {
      a(i.a(i.this).ZJB, false);
      return super.isc();
    }
    
    public final h isd()
    {
      a(i.a(i.this).ZJD, false);
      return super.isd();
    }
    
    public final e ise()
    {
      a(i.a(i.this).ZJA, false);
      return super.ise();
    }
    
    public final a isf()
    {
      a(i.a(i.this).ZJE, false);
      return super.isf();
    }
    
    public final b isg()
    {
      a(i.a(i.this).ZJz, false);
      return super.isg();
    }
    
    public final c ish()
    {
      a(i.a(i.this).ZJy, false);
      return super.ish();
    }
    
    public final d isi()
    {
      a(i.a(i.this).ZJG, false);
      return super.isi();
    }
    
    public final k isj()
    {
      a(i.a(i.this).ZJF, false);
      return super.isj();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String Xk(int paramInt)
    {
      i.nT(paramInt, i.a(i.this).ZJq.size);
      paramInt = i.this.aBv(i.a(i.this).ZJq.off + paramInt * 4).aQU.getInt();
      return i.this.aBv(paramInt).irW().value;
    }
    
    public final int size()
    {
      return i.a(i.this).ZJq.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).ZJr.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).ZJr.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */