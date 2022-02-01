package com.tencent.mm.xeffect;

import android.graphics.Rect;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.util.Iterator;
import java.util.List;

public class VLogDirector
{
  private long NmO;
  private long YZq = 0L;
  private int height;
  private int outputHeight;
  private int outputWidth;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(194579);
    e.load("xlabeffect");
    e.load("pag");
    AppMethodBeat.o(194579);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(194572);
    if (Thread.currentThread().getId() != this.threadId) {
      XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
    }
    AppMethodBeat.o(194572);
  }
  
  private static native int nAddInputTexture(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2);
  
  private static native void nDestroy(long paramLong);
  
  private static native long nInit();
  
  private static native int nRender(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native void nSetEffectManager(long paramLong1, long paramLong2);
  
  private static native int nSetOutputTexCropRet(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nSetRenderArea(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void a(List<c> paramList, int paramInt, long paramLong)
  {
    AppMethodBeat.i(194567);
    checkThread();
    if (this.NmO != 0L)
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
          localc.YZk.ijX();
          localc.YZl.ijX();
          InputAnimation localInputAnimation = localc.YZm;
          localInputAnimation.nUpdate(localInputAnimation.ptr, localInputAnimation.gcH, localInputAnimation.dgn, localInputAnimation.YZf);
          nAddInputTexture(this.NmO, localc.textureId, localc.width, localc.height, localc.fSM, localc.YZj.left, localc.YZj.top, localc.YZj.right, localc.YZj.bottom, localc.YZi.left, localc.YZi.top, localc.YZi.right, localc.YZi.bottom, localc.YZk.ptr, localc.YZl.ptr, localc.YZm.ptr, localc.Odt, localc.YZh);
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
      nRender(this.NmO, paramInt, this.outputWidth, this.outputHeight, paramLong);
    }
    AppMethodBeat.o(194567);
  }
  
  public final void aa(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194557);
    checkThread();
    if (this.NmO != 0L) {
      nSetOutputTexCropRet(this.NmO, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(194557);
  }
  
  public final void c(EffectManager paramEffectManager)
  {
    AppMethodBeat.i(194570);
    if ((paramEffectManager != null) && (paramEffectManager.NmO != 0L) && (paramEffectManager.NmO != this.YZq))
    {
      nSetEffectManager(this.NmO, paramEffectManager.NmO);
      this.YZq = paramEffectManager.NmO;
    }
    AppMethodBeat.o(194570);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(194554);
    checkThread();
    if (this.NmO != 0L)
    {
      nDestroy(this.NmO);
      this.NmO = 0L;
      this.YZq = 0L;
    }
    AppMethodBeat.o(194554);
  }
  
  public final void init()
  {
    AppMethodBeat.i(194552);
    this.threadId = Thread.currentThread().getId();
    this.NmO = nInit();
    AppMethodBeat.o(194552);
  }
  
  public final void nD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194555);
    checkThread();
    if (this.NmO != 0L) {
      nSetRenderArea(this.NmO, 0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(194555);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194551);
    this.width = paramInt1;
    this.height = paramInt2;
    nD(paramInt1, paramInt2);
    AppMethodBeat.o(194551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogDirector
 * JD-Core Version:    0.7.0.1
 */