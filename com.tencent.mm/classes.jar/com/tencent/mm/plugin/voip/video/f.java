package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public final class f
{
  private v2protocal NOO;
  public int NYv;
  public boolean Oac;
  private int Oad;
  private int Oae;
  private ArrayList<a> mCallbackList;
  
  public f()
  {
    AppMethodBeat.i(115701);
    this.Oac = false;
    this.NYv = 0;
    this.mCallbackList = new ArrayList();
    this.NOO = new v2protocal(new MMHandler(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] L(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(238143);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(238143);
    return paramArrayOfInt;
  }
  
  private static int[] cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238141);
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
      AppMethodBeat.o(238141);
      return localObject;
    }
  }
  
  public final void Bq(boolean paramBoolean)
  {
    AppMethodBeat.i(238147);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = L((int[])localObject);
      if (this.NOO.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = cF((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new f.b(this);
      localObject = new f.b(this);
      ((f.b)localObject).Oaf = (i & 0xFFFF);
      ((f.b)localObject).Oag = (i >> 16 & 0xFFFF);
      ((f.b)localObject).Oah = (j & 0xFFFF);
      ((f.b)localObject).Oai = (j >> 16 & 0xFFFF);
      Log.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.mCallbackList.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((f.b)localObject).Oaf;
        j = ((f.b)localObject).Oag;
        int k = ((f.b)localObject).Oah;
        int m = ((f.b)localObject).Oai;
        paramBoolean = this.Oac;
        int n = this.NYv;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(238147);
    return;
    label269:
    localObject = this.mCallbackList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.Oac, this.NYv);
    }
    label315:
    AppMethodBeat.o(238147);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(238151);
    if (!this.mCallbackList.contains(parama)) {
      this.mCallbackList.add(parama);
    }
    AppMethodBeat.o(238151);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.mCallbackList.contains(parama)) {
      this.mCallbackList.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void kY(int paramInt1, int paramInt2)
  {
    this.Oae = paramInt2;
    this.Oad = paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.f
 * JD-Core Version:    0.7.0.1
 */