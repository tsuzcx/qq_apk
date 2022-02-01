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
  static final short[] ahNW = new short[0];
  private byte[] KnY = null;
  public final s ahNX = new s();
  private final f ahNY = new f((byte)0);
  private final g ahNZ = new g((byte)0);
  private final h ahOa = new h((byte)0);
  private final d ahOb = new d((byte)0);
  private final b ahOc = new b((byte)0);
  private final c ahOd = new c((byte)0);
  private final a ahOe = new a((byte)0);
  private int ahOf = 0;
  public ByteBuffer cKQ;
  
  public i(int paramInt)
  {
    this.cKQ = ByteBuffer.wrap(new byte[paramInt]);
    this.cKQ.order(ByteOrder.LITTLE_ENDIAN);
    this.ahNX.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.cKQ = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.f(paramInputStream, 0));
    this.cKQ.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.ahNX;
    e locale = a(paramInputStream.ahOq);
    byte[] arrayOfByte = locale.aIm(8);
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
    paramInputStream.peK = locale.cKQ.getInt();
    paramInputStream.KnY = locale.aIm(20);
    paramInputStream.fileSize = locale.cKQ.getInt();
    i = locale.cKQ.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.cKQ.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.ahOJ = locale.cKQ.getInt();
    paramInputStream.ahOK = locale.cKQ.getInt();
    paramInputStream.ahOx.off = locale.cKQ.getInt();
    if (paramInputStream.ahOx.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.ahOr.size = locale.cKQ.getInt();
    paramInputStream.ahOr.off = locale.cKQ.getInt();
    paramInputStream.ahOs.size = locale.cKQ.getInt();
    paramInputStream.ahOs.off = locale.cKQ.getInt();
    paramInputStream.ahOt.size = locale.cKQ.getInt();
    paramInputStream.ahOt.off = locale.cKQ.getInt();
    paramInputStream.ahOu.size = locale.cKQ.getInt();
    paramInputStream.ahOu.off = locale.cKQ.getInt();
    paramInputStream.ahOv.size = locale.cKQ.getInt();
    paramInputStream.ahOv.off = locale.cKQ.getInt();
    paramInputStream.ahOw.size = locale.cKQ.getInt();
    paramInputStream.ahOw.off = locale.cKQ.getInt();
    paramInputStream.dataSize = locale.cKQ.getInt();
    paramInputStream.ahOL = locale.cKQ.getInt();
    paramInputStream.a(aIh(paramInputStream.ahOx.off));
    paramInputStream.kbS();
  }
  
  private static void pP(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final byte[] OD(boolean paramBoolean)
  {
    if ((this.KnY != null) && (!paramBoolean)) {
      return this.KnY;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.cKQ.duplicate();
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
    this.KnY = arrayOfByte1;
    return arrayOfByte1;
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.cKQ.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.cKQ.capacity());
    }
    ByteBuffer localByteBuffer = this.cKQ.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.ahOO);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e aIh(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.cKQ.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.cKQ.capacity());
    }
    ByteBuffer localByteBuffer = this.cKQ.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.cKQ.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int aIi(int paramInt)
  {
    pP(paramInt, this.ahNX.ahOs.size);
    int i = this.ahNX.ahOs.off;
    return this.cKQ.getInt(i + paramInt * 4);
  }
  
  public final void kbv()
  {
    aIh(12).write(OD(true));
    e locale = aIh(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.cKQ.duplicate();
    localByteBuffer.limit(localByteBuffer.capacity());
    localByteBuffer.position(12);
    while (localByteBuffer.hasRemaining())
    {
      int i = Math.min(8192, localByteBuffer.remaining());
      localByteBuffer.get(arrayOfByte, 0, i);
      localAdler32.update(arrayOfByte, 0, i);
    }
    locale.aX((int)localAdler32.getValue());
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).ahOw.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).ahOu.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).ahOv.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).ahOt.size;
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
      if (parama.ahON)
      {
        if (paramBoolean) {
          kbX();
        }
      }
      else {
        return;
      }
      kbW();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).ahOG, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).ahOu, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).ahOv, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).ahOt, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).ahOD, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).ahOy, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).ahOF, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).ahOA, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).ahOz, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).ahOH, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).ahOB, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).ahOw, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).ahOC, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).ahOE, true);
      return super.b(paramh);
    }
    
    public final q kbA()
    {
      a(i.a(i.this).ahOt, false);
      return super.kbA();
    }
    
    public final f kbB()
    {
      a(i.a(i.this).ahOw, false);
      return super.kbB();
    }
    
    public final g kbC()
    {
      a(i.a(i.this).ahOC, false);
      return super.kbC();
    }
    
    public final h kbD()
    {
      a(i.a(i.this).ahOE, false);
      return super.kbD();
    }
    
    public final e kbE()
    {
      a(i.a(i.this).ahOB, false);
      return super.kbE();
    }
    
    public final a kbF()
    {
      a(i.a(i.this).ahOF, false);
      return super.kbF();
    }
    
    public final b kbG()
    {
      a(i.a(i.this).ahOA, false);
      return super.kbG();
    }
    
    public final c kbH()
    {
      a(i.a(i.this).ahOz, false);
      return super.kbH();
    }
    
    public final d kbI()
    {
      a(i.a(i.this).ahOH, false);
      return super.kbI();
    }
    
    public final k kbJ()
    {
      a(i.a(i.this).ahOG, false);
      return super.kbJ();
    }
    
    public final r kbw()
    {
      a(i.a(i.this).ahOD, false);
      return super.kbw();
    }
    
    public final t kbx()
    {
      a(i.a(i.this).ahOy, false);
      return super.kbx();
    }
    
    public final n kby()
    {
      a(i.a(i.this).ahOu, false);
      return super.kby();
    }
    
    public final p kbz()
    {
      a(i.a(i.this).ahOv, false);
      return super.kbz();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String abm(int paramInt)
    {
      i.pQ(paramInt, i.a(i.this).ahOr.size);
      paramInt = i.this.aIh(i.a(i.this).ahOr.off + paramInt * 4).cKQ.getInt();
      return i.this.aIh(paramInt).kbw().value;
    }
    
    public final int size()
    {
      return i.a(i.this).ahOr.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).ahOs.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).ahOs.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */