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
  static final short[] IBd = new short[0];
  public final s IBe = new s();
  private final f IBf = new f((byte)0);
  private final g IBg = new g((byte)0);
  private final h IBh = new h((byte)0);
  private final d IBi = new d((byte)0);
  private final b IBj = new b((byte)0);
  private final c IBk = new c((byte)0);
  private final a IBl = new a((byte)0);
  private int IBm = 0;
  public ByteBuffer aIq;
  private byte[] taa = null;
  
  public i(int paramInt)
  {
    this.aIq = ByteBuffer.wrap(new byte[paramInt]);
    this.aIq.order(ByteOrder.LITTLE_ENDIAN);
    this.IBe.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aIq = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aIq.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.IBe;
    e locale = a(paramInputStream.IBy);
    byte[] arrayOfByte = locale.ach(8);
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
    paramInputStream.hDs = locale.aIq.getInt();
    paramInputStream.taa = locale.ach(20);
    paramInputStream.fileSize = locale.aIq.getInt();
    i = locale.aIq.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aIq.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.IBR = locale.aIq.getInt();
    paramInputStream.IBS = locale.aIq.getInt();
    paramInputStream.IBF.off = locale.aIq.getInt();
    if (paramInputStream.IBF.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.IBz.size = locale.aIq.getInt();
    paramInputStream.IBz.off = locale.aIq.getInt();
    paramInputStream.IBA.size = locale.aIq.getInt();
    paramInputStream.IBA.off = locale.aIq.getInt();
    paramInputStream.IBB.size = locale.aIq.getInt();
    paramInputStream.IBB.off = locale.aIq.getInt();
    paramInputStream.IBC.size = locale.aIq.getInt();
    paramInputStream.IBC.off = locale.aIq.getInt();
    paramInputStream.IBD.size = locale.aIq.getInt();
    paramInputStream.IBD.off = locale.aIq.getInt();
    paramInputStream.IBE.size = locale.aIq.getInt();
    paramInputStream.IBE.off = locale.aIq.getInt();
    paramInputStream.oJm = locale.aIq.getInt();
    paramInputStream.IBT = locale.aIq.getInt();
    paramInputStream.a(acc(paramInputStream.IBF.off));
    paramInputStream.foQ();
  }
  
  private static void kq(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aIq.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aIq.capacity());
    }
    ByteBuffer localByteBuffer = this.aIq.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e acc(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aIq.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aIq.capacity());
    }
    ByteBuffer localByteBuffer = this.aIq.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aIq.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int acd(int paramInt)
  {
    kq(paramInt, this.IBe.IBA.size);
    int i = this.IBe.IBA.off;
    return this.aIq.getInt(i + paramInt * 4);
  }
  
  public final void fos()
  {
    acc(12).write(xy(true));
    e locale = acc(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aIq.duplicate();
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
  
  public final byte[] xy(boolean paramBoolean)
  {
    if ((this.taa != null) && (!paramBoolean)) {
      return this.taa;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aIq.duplicate();
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
    this.taa = arrayOfByte1;
    return arrayOfByte1;
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).IBE.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).IBC.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).IBD.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).IBB.size;
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
      if (parama.IBV)
      {
        if (paramBoolean) {
          foV();
        }
      }
      else {
        return;
      }
      foU();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).IBO, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).IBC, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).IBD, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).IBB, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).IBL, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).IBG, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).IBN, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).IBI, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).IBH, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).IBP, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).IBJ, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).IBE, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).IBK, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).IBM, true);
      return super.b(paramh);
    }
    
    public final h foA()
    {
      a(i.a(i.this).IBM, false);
      return super.foA();
    }
    
    public final e foB()
    {
      a(i.a(i.this).IBJ, false);
      return super.foB();
    }
    
    public final a foC()
    {
      a(i.a(i.this).IBN, false);
      return super.foC();
    }
    
    public final b foD()
    {
      a(i.a(i.this).IBI, false);
      return super.foD();
    }
    
    public final c foE()
    {
      a(i.a(i.this).IBH, false);
      return super.foE();
    }
    
    public final d foF()
    {
      a(i.a(i.this).IBP, false);
      return super.foF();
    }
    
    public final k foG()
    {
      a(i.a(i.this).IBO, false);
      return super.foG();
    }
    
    public final r fot()
    {
      a(i.a(i.this).IBL, false);
      return super.fot();
    }
    
    public final t fou()
    {
      a(i.a(i.this).IBG, false);
      return super.fou();
    }
    
    public final n fov()
    {
      a(i.a(i.this).IBC, false);
      return super.fov();
    }
    
    public final p fow()
    {
      a(i.a(i.this).IBD, false);
      return super.fow();
    }
    
    public final q fox()
    {
      a(i.a(i.this).IBB, false);
      return super.fox();
    }
    
    public final f foy()
    {
      a(i.a(i.this).IBE, false);
      return super.foy();
    }
    
    public final g foz()
    {
      a(i.a(i.this).IBK, false);
      return super.foz();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String Hc(int paramInt)
    {
      i.kr(paramInt, i.a(i.this).IBz.size);
      paramInt = i.this.acc(i.a(i.this).IBz.off + paramInt * 4).aIq.getInt();
      return i.this.acc(paramInt).fot().value;
    }
    
    public final int size()
    {
      return i.a(i.this).IBz.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).IBA.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).IBA.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */