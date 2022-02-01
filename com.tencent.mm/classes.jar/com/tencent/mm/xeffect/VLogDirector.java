package com.tencent.mm.xeffect;

import android.graphics.Rect;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Iterator;
import java.util.List;

public class VLogDirector
{
  private long RxK = 0L;
  private long Rxd;
  private int height;
  private int outputHeight;
  private int outputWidth;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(236760);
    d.load("xlabeffect");
    d.load("pag");
    AppMethodBeat.o(236760);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(236759);
    if (Thread.currentThread().getId() != this.threadId) {
      XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
    }
    AppMethodBeat.o(236759);
  }
  
  private static native int nAddInputTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nDestroy(long paramLong);
  
  private static native long nInit();
  
  private static native int nRender(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native void nSetEffectManager(long paramLong1, long paramLong2);
  
  private static native int nSetOutputTexCropRet(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nSetRenderArea(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void V(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236756);
    checkThread();
    if (this.Rxd != 0L) {
      nSetOutputTexCropRet(this.Rxd, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(236756);
  }
  
  public final void a(List<b> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(236757);
    checkThread();
    if (this.Rxd != 0L)
    {
      paramList = paramList.iterator();
      label199:
      while (paramList.hasNext())
      {
        b localb = (b)paramList.next();
        if (localb == null) {
          XEffectLog.e("VLogDirector", "input is null", new Object[0]);
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label199;
          }
          nAddInputTexture(this.Rxd, localb.textureId, localb.width, localb.height, localb.dYT, localb.RxJ.left, localb.RxJ.top, localb.RxJ.right, localb.RxJ.bottom, localb.RxI.left, localb.RxI.top, localb.RxI.right, localb.RxI.bottom, localb.translateX, localb.translateY, localb.scale, localb.ijt, localb.HmG, localb.RxH);
          break;
        }
      }
      if ((this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        paramList = new int[2];
        GLES31.glBindTexture(3553, paramInt);
        GLES31.glGetTexLevelParameteriv(3553, 0, 4096, paramList, 0);
        GLES31.glGetTexLevelParameteriv(3553, 0, 4097, paramList, 1);
        this.outputWidth = paramList[0];
        this.outputHeight = paramList[1];
      }
      XEffectLog.d("VLogDirector", "render output size, width:%d, height:%d", new Object[] { Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight) });
      nRender(this.Rxd, paramInt, this.outputWidth, this.outputHeight, paramLong);
    }
    AppMethodBeat.o(236757);
  }
  
  public final void b(EffectManager paramEffectManager)
  {
    AppMethodBeat.i(236758);
    if ((paramEffectManager != null) && (paramEffectManager.Rxd != 0L) && (paramEffectManager.Rxd != this.RxK))
    {
      nSetEffectManager(this.Rxd, paramEffectManager.Rxd);
      this.RxK = paramEffectManager.Rxd;
    }
    AppMethodBeat.o(236758);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(236754);
    checkThread();
    if (this.Rxd != 0L)
    {
      nDestroy(this.Rxd);
      this.Rxd = 0L;
    }
    AppMethodBeat.o(236754);
  }
  
  public final void init()
  {
    AppMethodBeat.i(236753);
    this.threadId = Thread.currentThread().getId();
    this.Rxd = nInit();
    AppMethodBeat.o(236753);
  }
  
  public final void mm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236755);
    checkThread();
    if (this.Rxd != 0L) {
      nSetRenderArea(this.Rxd, 0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(236755);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236752);
    this.width = paramInt1;
    this.height = paramInt2;
    mm(paramInt1, paramInt2);
    AppMethodBeat.o(236752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogDirector
 * JD-Core Version:    0.7.0.1
 */