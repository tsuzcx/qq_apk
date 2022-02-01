package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class k
{
  private v2protocal AEn;
  public int ANu;
  public boolean APi;
  private int APj;
  private int APk;
  private ArrayList<a> npr;
  
  public k()
  {
    AppMethodBeat.i(115701);
    this.APi = false;
    this.ANu = 0;
    this.npr = new ArrayList();
    this.AEn = new v2protocal(new ao(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] F(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(208523);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(208523);
    return paramArrayOfInt;
  }
  
  private static int[] bP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208522);
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
      AppMethodBeat.o(208522);
      return localObject;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(208525);
    if (!this.npr.contains(parama)) {
      this.npr.add(parama);
    }
    AppMethodBeat.o(208525);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.npr.contains(parama)) {
      this.npr.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void sY(boolean paramBoolean)
  {
    AppMethodBeat.i(208524);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = F((int[])localObject);
      if (this.AEn.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = bP((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new b();
      localObject = new b();
      ((b)localObject).APl = (i & 0xFFFF);
      ((b)localObject).APm = (i >> 16 & 0xFFFF);
      ((b)localObject).APn = (j & 0xFFFF);
      ((b)localObject).APo = (j >> 16 & 0xFFFF);
      ac.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.npr.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((b)localObject).APl;
        j = ((b)localObject).APm;
        int k = ((b)localObject).APn;
        int m = ((b)localObject).APo;
        paramBoolean = this.APi;
        int n = this.ANu;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(208524);
    return;
    label269:
    localObject = this.npr.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.APi, this.ANu);
    }
    label315:
    AppMethodBeat.o(208524);
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    this.APk = paramInt2;
    this.APj = paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  final class b
  {
    int APl;
    int APm;
    int APn;
    int APo;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.APl), Integer.valueOf(this.APm), Integer.valueOf(this.APn), Integer.valueOf(this.APo) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.k
 * JD-Core Version:    0.7.0.1
 */