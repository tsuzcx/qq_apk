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
  static final short[] Knm = new short[0];
  public final s Knn = new s();
  private final f Kno = new f((byte)0);
  private final g Knp = new g((byte)0);
  private final h Knq = new h((byte)0);
  private final d Knr = new d((byte)0);
  private final b Kns = new b((byte)0);
  private final c Knt = new c((byte)0);
  private final a Knu = new a((byte)0);
  private int Knv = 0;
  public ByteBuffer aJg;
  private byte[] uiq = null;
  
  public i(int paramInt)
  {
    this.aJg = ByteBuffer.wrap(new byte[paramInt]);
    this.aJg.order(ByteOrder.LITTLE_ENDIAN);
    this.Knn.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aJg = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aJg.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.Knn;
    e locale = a(paramInputStream.KnH);
    byte[] arrayOfByte = locale.afd(8);
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
    paramInputStream.idU = locale.aJg.getInt();
    paramInputStream.uiq = locale.afd(20);
    paramInputStream.fileSize = locale.aJg.getInt();
    i = locale.aJg.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aJg.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.Koa = locale.aJg.getInt();
    paramInputStream.Kob = locale.aJg.getInt();
    paramInputStream.KnO.off = locale.aJg.getInt();
    if (paramInputStream.KnO.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.KnI.size = locale.aJg.getInt();
    paramInputStream.KnI.off = locale.aJg.getInt();
    paramInputStream.KnJ.size = locale.aJg.getInt();
    paramInputStream.KnJ.off = locale.aJg.getInt();
    paramInputStream.KnK.size = locale.aJg.getInt();
    paramInputStream.KnK.off = locale.aJg.getInt();
    paramInputStream.KnL.size = locale.aJg.getInt();
    paramInputStream.KnL.off = locale.aJg.getInt();
    paramInputStream.KnM.size = locale.aJg.getInt();
    paramInputStream.KnM.off = locale.aJg.getInt();
    paramInputStream.KnN.size = locale.aJg.getInt();
    paramInputStream.KnN.off = locale.aJg.getInt();
    paramInputStream.dataSize = locale.aJg.getInt();
    paramInputStream.Koc = locale.aJg.getInt();
    paramInputStream.a(aeY(paramInputStream.KnO.off));
    paramInputStream.fGY();
  }
  
  private static void kH(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aJg.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aJg.capacity());
    }
    ByteBuffer localByteBuffer = this.aJg.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e aeY(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aJg.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aJg.capacity());
    }
    ByteBuffer localByteBuffer = this.aJg.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aJg.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int aeZ(int paramInt)
  {
    kH(paramInt, this.Knn.KnJ.size);
    int i = this.Knn.KnJ.off;
    return this.aJg.getInt(i + paramInt * 4);
  }
  
  public final void fGA()
  {
    aeY(12).write(yO(true));
    e locale = aeY(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aJg.duplicate();
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
  
  public final byte[] yO(boolean paramBoolean)
  {
    if ((this.uiq != null) && (!paramBoolean)) {
      return this.uiq;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aJg.duplicate();
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
    this.uiq = arrayOfByte1;
    return arrayOfByte1;
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).KnN.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).KnL.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).KnM.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).KnK.size;
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
      if (parama.Koe)
      {
        if (paramBoolean) {
          fHd();
        }
      }
      else {
        return;
      }
      fHc();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).KnX, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).KnL, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).KnM, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).KnK, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).KnU, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).KnP, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).KnW, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).KnR, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).KnQ, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).KnY, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).KnS, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).KnN, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).KnT, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).KnV, true);
      return super.b(paramh);
    }
    
    public final r fGB()
    {
      a(i.a(i.this).KnU, false);
      return super.fGB();
    }
    
    public final t fGC()
    {
      a(i.a(i.this).KnP, false);
      return super.fGC();
    }
    
    public final n fGD()
    {
      a(i.a(i.this).KnL, false);
      return super.fGD();
    }
    
    public final p fGE()
    {
      a(i.a(i.this).KnM, false);
      return super.fGE();
    }
    
    public final q fGF()
    {
      a(i.a(i.this).KnK, false);
      return super.fGF();
    }
    
    public final f fGG()
    {
      a(i.a(i.this).KnN, false);
      return super.fGG();
    }
    
    public final g fGH()
    {
      a(i.a(i.this).KnT, false);
      return super.fGH();
    }
    
    public final h fGI()
    {
      a(i.a(i.this).KnV, false);
      return super.fGI();
    }
    
    public final e fGJ()
    {
      a(i.a(i.this).KnS, false);
      return super.fGJ();
    }
    
    public final a fGK()
    {
      a(i.a(i.this).KnW, false);
      return super.fGK();
    }
    
    public final b fGL()
    {
      a(i.a(i.this).KnR, false);
      return super.fGL();
    }
    
    public final c fGM()
    {
      a(i.a(i.this).KnQ, false);
      return super.fGM();
    }
    
    public final d fGN()
    {
      a(i.a(i.this).KnY, false);
      return super.fGN();
    }
    
    public final k fGO()
    {
      a(i.a(i.this).KnX, false);
      return super.fGO();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String IZ(int paramInt)
    {
      i.kI(paramInt, i.a(i.this).KnI.size);
      paramInt = i.this.aeY(i.a(i.this).KnI.off + paramInt * 4).aJg.getInt();
      return i.this.aeY(paramInt).fGB().value;
    }
    
    public final int size()
    {
      return i.a(i.this).KnI.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).KnJ.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).KnJ.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */