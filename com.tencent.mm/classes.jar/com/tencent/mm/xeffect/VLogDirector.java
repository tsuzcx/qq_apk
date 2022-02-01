package com.tencent.mm.xeffect;

import android.graphics.Rect;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Iterator;
import java.util.List;

public class VLogDirector
{
  private long agXB = 0L;
  private int height;
  private long nNg;
  private int outputHeight;
  private int outputWidth;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(234530);
    f.load("xlabeffect");
    f.load("pag");
    AppMethodBeat.o(234530);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(234500);
    if (Thread.currentThread().getId() != this.threadId) {
      XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
    }
    AppMethodBeat.o(234500);
  }
  
  private static native int nAddInputTexture(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nDestroy(long paramLong);
  
  private static native long nInit();
  
  private static native int nRender(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native void nSetEffectManager(long paramLong1, long paramLong2);
  
  private static native int nSetOutputTexCropRet(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nSetRenderArea(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void ak(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234548);
    checkThread();
    if (this.nNg != 0L) {
      nSetOutputTexCropRet(this.nNg, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(234548);
  }
  
  public final void b(List<c> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(234560);
    checkThread();
    if (this.nNg != 0L)
    {
      paramList = paramList.iterator();
      label250:
      while (paramList.hasNext())
      {
        c localc = (c)paramList.next();
        if (localc == null) {
          XEffectLog.e("VLogDirector", "input is null", new Object[0]);
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label250;
          }
          localc.agXv.jQf();
          localc.agXw.jQf();
          InputAnimation localInputAnimation = localc.agXx;
          localInputAnimation.nUpdate(localInputAnimation.ptr, localInputAnimation.startMs, localInputAnimation.endMs, localInputAnimation.agXq);
          nAddInputTexture(this.nNg, localc.textureId, localc.width, localc.height, localc.hYK, localc.agXu.left, localc.agXu.top, localc.agXu.right, localc.agXu.bottom, localc.agXt.left, localc.agXt.top, localc.agXt.right, localc.agXt.bottom, localc.agXv.ptr, localc.agXw.ptr, localc.agXx.ptr, localc.URt, localc.agXs);
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
      nRender(this.nNg, paramInt, this.outputWidth, this.outputHeight, paramLong);
    }
    AppMethodBeat.o(234560);
  }
  
  public final void c(EffectManager paramEffectManager)
  {
    AppMethodBeat.i(234569);
    if ((paramEffectManager != null) && (paramEffectManager.nNg != 0L) && (paramEffectManager.nNg != this.agXB))
    {
      nSetEffectManager(this.nNg, paramEffectManager.nNg);
      this.agXB = paramEffectManager.nNg;
    }
    AppMethodBeat.o(234569);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(234538);
    checkThread();
    if (this.nNg != 0L)
    {
      nDestroy(this.nNg);
      this.nNg = 0L;
      this.agXB = 0L;
    }
    AppMethodBeat.o(234538);
  }
  
  public final void init()
  {
    AppMethodBeat.i(234536);
    this.threadId = Thread.currentThread().getId();
    this.nNg = nInit();
    AppMethodBeat.o(234536);
  }
  
  public final void pA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234543);
    checkThread();
    if (this.nNg != 0L) {
      nSetRenderArea(this.nNg, 0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(234543);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234534);
    this.width = paramInt1;
    this.height = paramInt2;
    pA(paramInt1, paramInt2);
    AppMethodBeat.o(234534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogDirector
 * JD-Core Version:    0.7.0.1
 */