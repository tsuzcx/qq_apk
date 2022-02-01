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
  static final short[] MAf = new short[0];
  public final s MAg = new s();
  private final f MAh = new f((byte)0);
  private final g MAi = new g((byte)0);
  private final h MAj = new h((byte)0);
  private final d MAk = new d((byte)0);
  private final b MAl = new b((byte)0);
  private final c MAm = new c((byte)0);
  private final a MAn = new a((byte)0);
  private int MAo = 0;
  public ByteBuffer aKX;
  private byte[] vxd = null;
  
  public i(int paramInt)
  {
    this.aKX = ByteBuffer.wrap(new byte[paramInt]);
    this.aKX.order(ByteOrder.LITTLE_ENDIAN);
    this.MAg.fileSize = paramInt;
  }
  
  public i(InputStream paramInputStream)
  {
    this.aKX = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(paramInputStream, 0));
    this.aKX.order(ByteOrder.LITTLE_ENDIAN);
    paramInputStream = this.MAg;
    e locale = a(paramInputStream.MAA);
    byte[] arrayOfByte = locale.aim(8);
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
    paramInputStream.iAi = locale.aKX.getInt();
    paramInputStream.vxd = locale.aim(20);
    paramInputStream.fileSize = locale.aKX.getInt();
    i = locale.aKX.getInt();
    if (i != 112) {
      throw new j("Unexpected header: 0x" + Integer.toHexString(i));
    }
    i = locale.aKX.getInt();
    if (i != 305419896) {
      throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i));
    }
    paramInputStream.MAU = locale.aKX.getInt();
    paramInputStream.MAV = locale.aKX.getInt();
    paramInputStream.MAH.off = locale.aKX.getInt();
    if (paramInputStream.MAH.off == 0) {
      throw new j("Cannot merge dex files that do not contain a map");
    }
    paramInputStream.MAB.size = locale.aKX.getInt();
    paramInputStream.MAB.off = locale.aKX.getInt();
    paramInputStream.MAC.size = locale.aKX.getInt();
    paramInputStream.MAC.off = locale.aKX.getInt();
    paramInputStream.MAD.size = locale.aKX.getInt();
    paramInputStream.MAD.off = locale.aKX.getInt();
    paramInputStream.MAE.size = locale.aKX.getInt();
    paramInputStream.MAE.off = locale.aKX.getInt();
    paramInputStream.MAF.size = locale.aKX.getInt();
    paramInputStream.MAF.off = locale.aKX.getInt();
    paramInputStream.MAG.size = locale.aKX.getInt();
    paramInputStream.MAG.off = locale.aKX.getInt();
    paramInputStream.dataSize = locale.aKX.getInt();
    paramInputStream.MAW = locale.aKX.getInt();
    paramInputStream.a(aih(paramInputStream.MAH.off));
    paramInputStream.gcJ();
  }
  
  private static void ld(int paramInt1, int paramInt2)
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
  
  public final e aih(int paramInt)
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
  
  public final int aii(int paramInt)
  {
    ld(paramInt, this.MAg.MAC.size);
    int i = this.MAg.MAC.off;
    return this.aKX.getInt(i + paramInt * 4);
  }
  
  public final void gcl()
  {
    aih(12).write(zP(true));
    e locale = aih(8);
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
  
  public final byte[] zP(boolean paramBoolean)
  {
    if ((this.vxd != null) && (!paramBoolean)) {
      return this.vxd;
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
    this.vxd = arrayOfByte1;
    return arrayOfByte1;
  }
  
  final class a
    extends AbstractList<f>
    implements RandomAccess
  {
    private a() {}
    
    public final int size()
    {
      return i.a(i.this).MAG.size;
    }
  }
  
  final class b
    extends AbstractList<n>
    implements RandomAccess
  {
    private b() {}
    
    public final int size()
    {
      return i.a(i.this).MAE.size;
    }
  }
  
  final class c
    extends AbstractList<p>
    implements RandomAccess
  {
    private c() {}
    
    public final int size()
    {
      return i.a(i.this).MAF.size;
    }
  }
  
  final class d
    extends AbstractList<q>
    implements RandomAccess
  {
    private d() {}
    
    public final int size()
    {
      return i.a(i.this).MAD.size;
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
      if (parama.MAZ)
      {
        if (paramBoolean) {
          gcO();
        }
      }
      else {
        return;
      }
      gcN();
    }
    
    public final int a(k paramk)
    {
      a(i.a(i.this).MAR, true);
      return super.a(paramk);
    }
    
    public final int a(n paramn)
    {
      a(i.a(i.this).MAE, true);
      return super.a(paramn);
    }
    
    public final int a(p paramp)
    {
      a(i.a(i.this).MAF, true);
      return super.a(paramp);
    }
    
    public final int a(q paramq)
    {
      a(i.a(i.this).MAD, true);
      return super.a(paramq);
    }
    
    public final int a(r paramr)
    {
      a(i.a(i.this).MAN, true);
      return super.a(paramr);
    }
    
    public final int a(t paramt)
    {
      a(i.a(i.this).MAI, true);
      return super.a(paramt);
    }
    
    public final int b(a parama)
    {
      a(i.a(i.this).MAQ, true);
      return super.b(parama);
    }
    
    public final int b(b paramb)
    {
      a(i.a(i.this).MAK, true);
      return super.b(paramb);
    }
    
    public final int b(c paramc)
    {
      a(i.a(i.this).MAJ, true);
      return super.b(paramc);
    }
    
    public final int b(d paramd)
    {
      a(i.a(i.this).MAS, true);
      return super.b(paramd);
    }
    
    public final int b(e parame)
    {
      a(i.a(i.this).MAL, true);
      return super.b(parame);
    }
    
    public final int b(f paramf)
    {
      a(i.a(i.this).MAG, true);
      return super.b(paramf);
    }
    
    public final int b(g paramg)
    {
      a(i.a(i.this).MAM, true);
      return super.b(paramg);
    }
    
    public final int b(h paramh)
    {
      a(i.a(i.this).MAO, true);
      return super.b(paramh);
    }
    
    public final r gcm()
    {
      a(i.a(i.this).MAN, false);
      return super.gcm();
    }
    
    public final t gcn()
    {
      a(i.a(i.this).MAI, false);
      return super.gcn();
    }
    
    public final n gco()
    {
      a(i.a(i.this).MAE, false);
      return super.gco();
    }
    
    public final p gcp()
    {
      a(i.a(i.this).MAF, false);
      return super.gcp();
    }
    
    public final q gcq()
    {
      a(i.a(i.this).MAD, false);
      return super.gcq();
    }
    
    public final f gcr()
    {
      a(i.a(i.this).MAG, false);
      return super.gcr();
    }
    
    public final g gcs()
    {
      a(i.a(i.this).MAM, false);
      return super.gcs();
    }
    
    public final h gct()
    {
      a(i.a(i.this).MAO, false);
      return super.gct();
    }
    
    public final e gcu()
    {
      a(i.a(i.this).MAL, false);
      return super.gcu();
    }
    
    public final a gcv()
    {
      a(i.a(i.this).MAQ, false);
      return super.gcv();
    }
    
    public final b gcw()
    {
      a(i.a(i.this).MAK, false);
      return super.gcw();
    }
    
    public final c gcx()
    {
      a(i.a(i.this).MAJ, false);
      return super.gcx();
    }
    
    public final d gcy()
    {
      a(i.a(i.this).MAS, false);
      return super.gcy();
    }
    
    public final k gcz()
    {
      a(i.a(i.this).MAR, false);
      return super.gcz();
    }
  }
  
  final class f
    extends AbstractList<String>
    implements RandomAccess
  {
    private f() {}
    
    public final String KW(int paramInt)
    {
      i.le(paramInt, i.a(i.this).MAB.size);
      paramInt = i.this.aih(i.a(i.this).MAB.off + paramInt * 4).aKX.getInt();
      return i.this.aih(paramInt).gcm().value;
    }
    
    public final int size()
    {
      return i.a(i.this).MAB.size;
    }
  }
  
  final class g
    extends AbstractList<Integer>
    implements RandomAccess
  {
    private g() {}
    
    public final int size()
    {
      return i.a(i.this).MAC.size;
    }
  }
  
  final class h
    extends AbstractList<String>
    implements RandomAccess
  {
    private h() {}
    
    public final int size()
    {
      return i.a(i.this).MAC.size;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.i
 * JD-Core Version:    0.7.0.1
 */