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
  private v2protocal GYA;
  public int HhG;
  public boolean Hjo;
  private int Hjp;
  private int Hjq;
  private ArrayList<a> mCallbackList;
  
  public f()
  {
    AppMethodBeat.i(115701);
    this.Hjo = false;
    this.HhG = 0;
    this.mCallbackList = new ArrayList();
    this.GYA = new v2protocal(new MMHandler(Looper.myLooper()));
    AppMethodBeat.o(115701);
  }
  
  private static byte[] M(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(235837);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.asIntBuffer().put(paramArrayOfInt);
    paramArrayOfInt = localByteBuffer.array();
    AppMethodBeat.o(235837);
    return paramArrayOfInt;
  }
  
  private static int[] cp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235836);
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
      AppMethodBeat.o(235836);
      return localObject;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(235839);
    if (!this.mCallbackList.contains(parama)) {
      this.mCallbackList.add(parama);
    }
    AppMethodBeat.o(235839);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(115702);
    if (this.mCallbackList.contains(parama)) {
      this.mCallbackList.remove(parama);
    }
    AppMethodBeat.o(115702);
  }
  
  public final void setPreviewSize(int paramInt1, int paramInt2)
  {
    this.Hjq = paramInt2;
    this.Hjp = paramInt1;
  }
  
  public final void xx(boolean paramBoolean)
  {
    AppMethodBeat.i(235838);
    Object localObject = new int[2];
    if (paramBoolean)
    {
      localObject[0] = 1;
      localObject[1] = 0;
    }
    for (;;)
    {
      localObject = M((int[])localObject);
      if (this.GYA.setAppCmd(13, (byte[])localObject, localObject.length) < 0) {
        break label315;
      }
      localObject = cp((byte[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      if (i + j == 0) {
        break label269;
      }
      new b();
      localObject = new b();
      ((b)localObject).Hjr = (i & 0xFFFF);
      ((b)localObject).Hjs = (i >> 16 & 0xFFFF);
      ((b)localObject).Hjt = (j & 0xFFFF);
      ((b)localObject).Hju = (j >> 16 & 0xFFFF);
      Log.d("MicroMsg.VoipFaceDetector", "detect face, location:%s", new Object[] { localObject });
      Iterator localIterator = this.mCallbackList.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        i = ((b)localObject).Hjr;
        j = ((b)localObject).Hjs;
        int k = ((b)localObject).Hjt;
        int m = ((b)localObject).Hju;
        paramBoolean = this.Hjo;
        int n = this.HhG;
        locala.a(new int[] { i, j, k, m }, paramBoolean, n);
      }
      localObject[0] = 0;
      localObject[1] = 0;
    }
    AppMethodBeat.o(235838);
    return;
    label269:
    localObject = this.mCallbackList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).a(null, this.Hjo, this.HhG);
    }
    label315:
    AppMethodBeat.o(235838);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt);
  }
  
  final class b
  {
    int Hjr;
    int Hjs;
    int Hjt;
    int Hju;
    
    public b() {}
    
    public final String toString()
    {
      AppMethodBeat.i(115700);
      String str = String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[] { Integer.valueOf(this.Hjr), Integer.valueOf(this.Hjs), Integer.valueOf(this.Hjt), Integer.valueOf(this.Hju) });
      AppMethodBeat.o(115700);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.f
 * JD-Core Version:    0.7.0.1
 */