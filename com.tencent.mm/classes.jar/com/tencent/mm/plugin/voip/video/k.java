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
  private v2protocal Cdn;
  public int CmH;
  public boolean CoD;
  private int CoE;
  private int CoF;
  private ArrayList<a> nQn;
  
  public k()
  {
    AppMethodBeat.i(115701);
    this.CoD = false;
    this.CmH = 0;
    this.nQn = new ArrayList();
    this.Cdn = new v2protocal(new ap(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] F(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216571);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(216571);
    return paramArrayOfInt;
  }
  
  private static int[] bW(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216570);
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
      AppMethodBeat.o(216570);
      return localObject;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(216573);
    if (!this.nQn.contains(parama)) {
      this.nQn.add(parama);
    }
    AppMethodBeat.o(216573);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.nQn.contains(parama)) {
      this.nQn.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    this.CoF = paramInt2;
    this.CoE = paramInt1;
  }
  
  public final void tI(boolean paramBoolean)
  {
    AppMethodBeat.i(216572);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = F((int[])localObject);
      if (this.Cdn.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = bW((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new b();
      localObject = new b();
      ((b)localObject).CoG = (i & 0xFFFF);
      ((b)localObject).CoH = (i >> 16 & 0xFFFF);
      ((b)localObject).CoI = (j & 0xFFFF);
      ((b)localObject).CoJ = (j >> 16 & 0xFFFF);
      ad.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.nQn.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((b)localObject).CoG;
        j = ((b)localObject).CoH;
        int k = ((b)localObject).CoI;
        int m = ((b)localObject).CoJ;
        paramBoolean = this.CoD;
        int n = this.CmH;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(216572);
    return;
    label269:
    localObject = this.nQn.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.CoD, this.CmH);
    }
    label315:
    AppMethodBeat.o(216572);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  final class b
  {
    int CoG;
    int CoH;
    int CoI;
    int CoJ;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.CoG), Integer.valueOf(this.CoH), Integer.valueOf(this.CoI), Integer.valueOf(this.CoJ) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.k
 * JD-Core Version:    0.7.0.1
 */