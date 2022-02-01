package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
{
  private ArrayList<a> mNf;
  private v2protocal zlA;
  public int zuC;
  public boolean zwr;
  private int zws;
  private int zwt;
  
  public k()
  {
    AppMethodBeat.i(115701);
    this.zwr = false;
    this.zuC = 0;
    this.mNf = new ArrayList();
    this.zlA = new v2protocal(new ap(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] F(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(192186);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(192186);
    return paramArrayOfInt;
  }
  
  private static int[] bQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(192185);
    int j = paramArrayOfByte.length / 4;
    if (paramArrayOfByte.length % 4 == 0) {}
    for (int i = 0;; i = 1)
    {
      i += j;
      Object localObject = ByteBuffer.allocate(i * 4);
      ((ByteBuffer)localObject).put(paramArrayOfByte);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      ((ByteBuffer)localObject).rewind();
      paramArrayOfByte = ((ByteBuffer)localObject).asIntBuffer();
      localObject = new int[i];
      paramArrayOfByte.get((int[])localObject);
      AppMethodBeat.o(192185);
      return localObject;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(192188);
    if (!this.mNf.contains(parama)) {
      this.mNf.add(parama);
    }
    AppMethodBeat.o(192188);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.mNf.contains(parama)) {
      this.mNf.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void rX(boolean paramBoolean)
  {
    AppMethodBeat.i(192187);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = F((int[])localObject);
      if (this.zlA.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = bQ((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new b();
      localObject = new b();
      ((b)localObject).zwu = (i & 0xFFFF);
      ((b)localObject).zwv = (i >> 16 & 0xFFFF);
      ((b)localObject).zww = (j & 0xFFFF);
      ((b)localObject).zwx = (j >> 16 & 0xFFFF);
      ad.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.mNf.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((b)localObject).zwu;
        j = ((b)localObject).zwv;
        int k = ((b)localObject).zww;
        int m = ((b)localObject).zwx;
        paramBoolean = this.zwr;
        int n = this.zuC;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(192187);
    return;
    label269:
    localObject = this.mNf.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.zwr, this.zuC);
    }
    label315:
    AppMethodBeat.o(192187);
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    this.zwt = paramInt2;
    this.zws = paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  final class b
  {
    int zwu;
    int zwv;
    int zww;
    int zwx;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.zwu), Integer.valueOf(this.zwv), Integer.valueOf(this.zww), Integer.valueOf(this.zwx) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.k
 * JD-Core Version:    0.7.0.1
 */