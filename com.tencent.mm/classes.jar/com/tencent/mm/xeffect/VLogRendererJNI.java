package com.tencent.mm.xeffect;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class VLogRendererJNI
{
  private static final String TAG = "VLogRendererJNI";
  private int height;
  private long nPtr;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(197167);
    System.loadLibrary("xlabeffect");
    AppMethodBeat.o(197167);
  }
  
  private boolean checkInput(a parama)
  {
    AppMethodBeat.i(197166);
    if (parama == null)
    {
      b.x("input is null", new Object[0]);
      AppMethodBeat.o(197166);
      return false;
    }
    AppMethodBeat.o(197166);
    return true;
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(197165);
    if (Thread.currentThread().getId() != this.threadId) {
      b.x("Thread error", new Object[0]);
    }
    AppMethodBeat.o(197165);
  }
  
  private static native int nAddAuxiliaryTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  private static native void nDestroy(long paramLong);
  
  private static native long nInit();
  
  private static native int nRender(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nRenderToTexture(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, long paramLong2);
  
  private static native int nSetEffectConfig(long paramLong, String paramString, float paramFloat1, float paramFloat2);
  
  private static native int nSetEffectConfigProtobuf(long paramLong, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2);
  
  public void destroy()
  {
    AppMethodBeat.i(197160);
    checkThread();
    if (this.nPtr != 0L)
    {
      nDestroy(this.nPtr);
      this.nPtr = 0L;
    }
    AppMethodBeat.o(197160);
  }
  
  public void init()
  {
    AppMethodBeat.i(197159);
    this.threadId = Thread.currentThread().getId();
    this.nPtr = nInit();
    AppMethodBeat.o(197159);
  }
  
  public void render(a parama, int paramInt)
  {
    AppMethodBeat.i(197164);
    checkThread();
    if ((this.nPtr != 0L) && (checkInput(parama)))
    {
      nAddAuxiliaryTexture(this.nPtr, parama.textureId, parama.width, parama.height, parama.duc, parama.ARq, parama.JHZ, parama.JIa.left, parama.JIa.top, parama.JIa.right, parama.JIa.bottom);
      nRender(this.nPtr, paramInt, this.width, this.height);
    }
    AppMethodBeat.o(197164);
  }
  
  public void renderWithConfig(List<a> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(197163);
    checkThread();
    if (this.nPtr != 0L)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (checkInput(locala)) {
          nAddAuxiliaryTexture(this.nPtr, locala.textureId, locala.width, locala.height, locala.duc, locala.ARq, locala.JHZ, locala.JIa.left, locala.JIa.top, locala.JIa.right, locala.JIa.bottom);
        }
      }
      nRenderToTexture(this.nPtr, 0, paramInt, this.width, this.height, 0, false, false, paramLong);
    }
    AppMethodBeat.o(197163);
  }
  
  public void setEffectConfig(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197161);
    checkThread();
    if (this.nPtr != 0L) {
      nSetEffectConfig(this.nPtr, paramString, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(197161);
  }
  
  public void setEffectConfig(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(197162);
    checkThread();
    if (this.nPtr != 0L) {
      nSetEffectConfigProtobuf(this.nPtr, paramArrayOfByte, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(197162);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogRendererJNI
 * JD-Core Version:    0.7.0.1
 */