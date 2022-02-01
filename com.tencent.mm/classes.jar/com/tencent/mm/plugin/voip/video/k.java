package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
{
  public int CEl;
  public boolean CGh;
  private int CGi;
  private int CGj;
  private v2protocal CuO;
  private ArrayList<a> nVT;
  
  public k()
  {
    AppMethodBeat.i(115701);
    this.CGh = false;
    this.CEl = 0;
    this.nVT = new ArrayList();
    this.CuO = new v2protocal(new aq(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] G(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(210250);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(210250);
    return paramArrayOfInt;
  }
  
  private static int[] bZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210249);
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
      AppMethodBeat.o(210249);
      return localObject;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(210252);
    if (!this.nVT.contains(parama)) {
      this.nVT.add(parama);
    }
    AppMethodBeat.o(210252);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.nVT.contains(parama)) {
      this.nVT.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    this.CGj = paramInt2;
    this.CGi = paramInt1;
  }
  
  public final void tP(boolean paramBoolean)
  {
    AppMethodBeat.i(210251);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = G((int[])localObject);
      if (this.CuO.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = bZ((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new b();
      localObject = new b();
      ((b)localObject).CGk = (i & 0xFFFF);
      ((b)localObject).CGl = (i >> 16 & 0xFFFF);
      ((b)localObject).CGm = (j & 0xFFFF);
      ((b)localObject).CGn = (j >> 16 & 0xFFFF);
      ae.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.nVT.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((b)localObject).CGk;
        j = ((b)localObject).CGl;
        int k = ((b)localObject).CGm;
        int m = ((b)localObject).CGn;
        paramBoolean = this.CGh;
        int n = this.CEl;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(210251);
    return;
    label269:
    localObject = this.nVT.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.CGh, this.CEl);
    }
    label315:
    AppMethodBeat.o(210251);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  final class b
  {
    int CGk;
    int CGl;
    int CGm;
    int CGn;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.CGk), Integer.valueOf(this.CGl), Integer.valueOf(this.CGm), Integer.valueOf(this.CGn) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.k
 * JD-Core Version:    0.7.0.1
 */