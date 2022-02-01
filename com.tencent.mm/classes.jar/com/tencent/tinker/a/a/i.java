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
  static final short[] Mdk = new short[0];
  public final s Mdl = new s();
  private final f Mdm = new f((byte)0);
  private final g Mdn = new g((byte)0);
  private final h Mdo = new h((byte)0);
  private final d Mdp = new d((byte)0);
  private final b Mdq = new b((byte)0);
  private final c Mdr = new c((byte)0);
  private final a Mds = new a((byte)0);
  private int Mdt = 0;
  public ByteBuffer aKX;
  private byte[] vkY = null;
  
  public i(int paramInt)
  {
    this.aKX = ByteBuffer.wrap(new byte[paramInt]);
    this.aKX.order(ByteOrder.LITTLE_ENDIAN);
    this.Mdl.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aKX = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aKX.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.Mdl;
    e locale = a(paramInputStream.MdF);
    byte[] arrayOfByte = locale.ahD(8);
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
    paramInputStream.ixp = locale.aKX.getInt();
    paramInputStream.vkY = locale.ahD(20);
    paramInputStream.fileSize = locale.aKX.getInt();
    i = locale.aKX.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aKX.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.MdY = locale.aKX.getInt();
    paramInputStream.MdZ = locale.aKX.getInt();
    paramInputStream.MdM.off = locale.aKX.getInt();
    if (paramInputStream.MdM.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.MdG.size = locale.aKX.getInt();
    paramInputStream.MdG.off = locale.aKX.getInt();
    paramInputStream.MdH.size = locale.aKX.getInt();
    paramInputStream.MdH.off = locale.aKX.getInt();
    paramInputStream.MdI.size = locale.aKX.getInt();
    paramInputStream.MdI.off = locale.aKX.getInt();
    paramInputStream.MdJ.size = locale.aKX.getInt();
    paramInputStream.MdJ.off = locale.aKX.getInt();
    paramInputStream.MdK.size = locale.aKX.getInt();
    paramInputStream.MdK.off = locale.aKX.getInt();
    paramInputStream.MdL.size = locale.aKX.getInt();
    paramInputStream.MdL.off = locale.aKX.getInt();
    paramInputStream.dataSize = locale.aKX.getInt();
    paramInputStream.Mea = locale.aKX.getInt();
    paramInputStream.a(ahy(paramInputStream.MdM.off));
    paramInputStream.fYk();
  }
  
  private static void kW(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2)) {
      throw new IndexOutOfBoundsException("index:" + paramInt1 + ", length=" + paramInt2);
    }
  }
  
  public final e a(s.a parama)
  {
    int i = parama.off;
    if ((i < 0) || (i >= this.aKX.capacity())) {
      throw new IllegalArgumentException("position=" + i + " length=" + this.aKX.capacity());
    }
    ByteBuffer localByteBuffer = this.aKX.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(i);
    localByteBuffer.limit(i + parama.byteCount);
    return new e("section", localByteBuffer, (byte)0);
  }
  
  public final e ahy(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aKX.capacity())) {
      throw new IllegalArgumentException("position=" + paramInt + " length=" + this.aKX.capacity());
    }
    ByteBuffer localByteBuffer = this.aKX.duplicate();
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.position(paramInt);
    localByteBuffer.limit(this.aKX.capacity());
    return new e("temp-section", localByteBuffer, (byte)0);
  }
  
  public final int ahz(int paramInt)
  {
    kW(paramInt, this.Mdl.MdH.size);
    int i = this.Mdl.MdH.off;
    return this.aKX.getInt(i + paramInt * 4);
  }
  
  public final void fXM()
  {
    ahy(12).write(zB(true));
    e locale = ahy(8);
    Adler32 localAdler32 = new Adler32();
    byte[] arrayOfByte = new byte[8192];
    ByteBuffer localByteBuffer = this.aKX.duplicate();
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
  
  public final byte[] zB(boolean paramBoolean)
  {
    if ((this.vkY != null) && (!paramBoolean)) {
      return this.vkY;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      byte[] arrayOfByte2 = new byte[8192];
      ByteBuffer localByteBuffer = this.aKX.duplicate();
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
    this.vkY = arrayOfByte1;
    return arrayOfByte1;
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).MdL.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).MdJ.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).MdK.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).MdI.size;
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
      if (parama.Mec)
      {
        if (paramBoolean) {
          fYp();
        }
      }
      else {
        return;
      }
      fYo();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).MdV, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).MdJ, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).MdK, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).MdI, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).MdS, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).MdN, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).MdU, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).MdP, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).MdO, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).MdW, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).MdQ, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).MdL, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).MdR, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).MdT, true);
      return super.b(paramh);
    }
    
    public final r fXN()
    {
      a(i.a(i.this).MdS, false);
      return super.fXN();
    }
    
    public final t fXO()
    {
      a(i.a(i.this).MdN, false);
      return super.fXO();
    }
    
    public final n fXP()
    {
      a(i.a(i.this).MdJ, false);
      return super.fXP();
    }
    
    public final p fXQ()
    {
      a(i.a(i.this).MdK, false);
      return super.fXQ();
    }
    
    public final q fXR()
    {
      a(i.a(i.this).MdI, false);
      return super.fXR();
    }
    
    public final f fXS()
    {
      a(i.a(i.this).MdL, false);
      return super.fXS();
    }
    
    public final g fXT()
    {
      a(i.a(i.this).MdR, false);
      return super.fXT();
    }
    
    public final h fXU()
    {
      a(i.a(i.this).MdT, false);
      return super.fXU();
    }
    
    public final e fXV()
    {
      a(i.a(i.this).MdQ, false);
      return super.fXV();
    }
    
    public final a fXW()
    {
      a(i.a(i.this).MdU, false);
      return super.fXW();
    }
    
    public final b fXX()
    {
      a(i.a(i.this).MdP, false);
      return super.fXX();
    }
    
    public final c fXY()
    {
      a(i.a(i.this).MdO, false);
      return super.fXY();
    }
    
    public final d fXZ()
    {
      a(i.a(i.this).MdW, false);
      return super.fXZ();
    }
    
    public final k fYa()
    {
      a(i.a(i.this).MdV, false);
      return super.fYa();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String Kw(int paramInt)
    {
      i.kX(paramInt, i.a(i.this).MdG.size);
      paramInt = i.this.ahy(i.a(i.this).MdG.off + paramInt * 4).aKX.getInt();
      return i.this.ahy(paramInt).fXN().value;
    }
    
    public final int size()
    {
      return i.a(i.this).MdG.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).MdH.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).MdH.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */