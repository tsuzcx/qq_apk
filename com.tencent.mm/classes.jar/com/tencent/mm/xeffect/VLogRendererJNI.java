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
    AppMethodBeat.i(201299);
    System.loadLibrary("xlabeffect");
    AppMethodBeat.o(201299);
  }
  
  private boolean checkInput(a parama)
  {
    AppMethodBeat.i(201298);
    if (parama == null)
    {
      b.y("input is null", new Object[0]);
      AppMethodBeat.o(201298);
      return false;
    }
    AppMethodBeat.o(201298);
    return true;
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(201297);
    if (Thread.currentThread().getId() != this.threadId) {
      b.y("Thread error", new Object[0]);
    }
    AppMethodBeat.o(201297);
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
    AppMethodBeat.i(201292);
    checkThread();
    if (this.nPtr != 0L)
    {
      nDestroy(this.nPtr);
      this.nPtr = 0L;
    }
    AppMethodBeat.o(201292);
  }
  
  public void init()
  {
    AppMethodBeat.i(201291);
    this.threadId = Thread.currentThread().getId();
    this.nPtr = nInit();
    AppMethodBeat.o(201291);
  }
  
  public void render(a parama, int paramInt)
  {
    AppMethodBeat.i(201296);
    checkThread();
    if ((this.nPtr != 0L) && (checkInput(parama)))
    {
      nAddAuxiliaryTexture(this.nPtr, parama.textureId, parama.width, parama.height, parama.dwp, parama.zyz, parama.LEs, parama.LEt.left, parama.LEt.top, parama.LEt.right, parama.LEt.bottom);
      nRender(this.nPtr, paramInt, this.width, this.height);
    }
    AppMethodBeat.o(201296);
  }
  
  public void renderWithConfig(List<a> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(201295);
    checkThread();
    if (this.nPtr != 0L)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        a locala = (a)paramList.next();
        if (checkInput(locala)) {
          nAddAuxiliaryTexture(this.nPtr, locala.textureId, locala.width, locala.height, locala.dwp, locala.zyz, locala.LEs, locala.LEt.left, locala.LEt.top, locala.LEt.right, locala.LEt.bottom);
        }
      }
      nRenderToTexture(this.nPtr, 0, paramInt, this.width, this.height, 0, false, false, paramLong);
    }
    AppMethodBeat.o(201295);
  }
  
  public void setEffectConfig(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201293);
    checkThread();
    if (this.nPtr != 0L) {
      nSetEffectConfig(this.nPtr, paramString, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(201293);
  }
  
  public void setEffectConfig(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(201294);
    checkThread();
    if (this.nPtr != 0L) {
      nSetEffectConfigProtobuf(this.nPtr, paramArrayOfByte, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(201294);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogRendererJNI
 * JD-Core Version:    0.7.0.1
 */