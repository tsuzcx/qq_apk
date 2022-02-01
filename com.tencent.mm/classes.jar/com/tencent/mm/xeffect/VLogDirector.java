package com.tencent.mm.xeffect;

import android.graphics.Rect;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class VLogDirector
{
  private long LYd;
  private long LYl = 0L;
  private int height;
  private int outputHeight;
  private int outputWidth;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(216766);
    e.load("xlabeffect");
    e.load("pag");
    AppMethodBeat.o(216766);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(216765);
    if (Thread.currentThread().getId() != this.threadId) {
      XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
    }
    AppMethodBeat.o(216765);
  }
  
  private static native int nAddBlendTexture(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nAddInputTextureByContentCrop(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  private static native int nAddInputTextureByCrop(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  private static native int nAddInputTextureByCropAndFitContent(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12);
  
  private static native int nAddInputTextureByTransform(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, int paramInt5, float paramFloat, int paramInt6, int paramInt7);
  
  private static native void nDestroy(long paramLong);
  
  private static native long nInit();
  
  private static native int nRender(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native int nSetContentCrop(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nSetEffectConfig(long paramLong, String paramString, float paramFloat1, float paramFloat2);
  
  private static native int nSetEffectConfigProtobuf(long paramLong, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2);
  
  private static native int nSetOutputCrop(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nSetVLogEffectMgr(long paramLong1, long paramLong2);
  
  private static native int nSetViewCrop(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public final void W(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216762);
    checkThread();
    if (this.LYd != 0L) {
      nSetOutputCrop(this.LYd, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(216762);
  }
  
  public final void a(List<a> paramList, int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(216763);
    checkThread();
    if (this.LYd != 0L)
    {
      if (parama != null) {
        nAddBlendTexture(this.LYd, parama.textureId, parama.width, parama.height);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        parama = (a)paramList.next();
        if (parama == null) {
          XEffectLog.e("VLogDirector", "input is null", new Object[0]);
        }
        for (int i = 0;; i = 1)
        {
          if (i == 0) {
            break label233;
          }
          if (parama.LYj.isEmpty()) {
            break label345;
          }
          if (!parama.LYh.isEmpty()) {
            break label235;
          }
          nAddInputTextureByContentCrop(this.LYd, parama.LYf, parama.textureId, parama.width, parama.height, parama.dHi, parama.CIF, parama.LYg, parama.LYj.left, parama.LYj.top, parama.LYj.right, parama.LYj.bottom, parama.LYi.left, parama.LYi.top, parama.LYi.right, parama.LYi.bottom);
          break;
        }
        label233:
        continue;
        label235:
        nAddInputTextureByCropAndFitContent(this.LYd, parama.LYf, parama.textureId, parama.width, parama.height, parama.dHi, parama.CIF, parama.LYg, parama.LYh.left, parama.LYh.top, parama.LYh.right, parama.LYh.bottom, parama.LYj.left, parama.LYj.top, parama.LYj.right, parama.LYj.bottom);
        continue;
        label345:
        if (!parama.LYh.isEmpty()) {
          nAddInputTextureByCrop(this.LYd, parama.LYf, parama.textureId, parama.width, parama.height, parama.dHi, parama.CIF, parama.LYg, parama.LYh.left, parama.LYh.top, parama.LYh.right, parama.LYh.bottom);
        } else {
          nAddInputTextureByTransform(this.LYd, parama.LYf, parama.textureId, parama.width, parama.height, parama.dHi, parama.CIF, parama.LYg, parama.hpY, parama.scale, parama.translateX, parama.translateY);
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
      nRender(this.LYd, paramInt, this.outputWidth, this.outputHeight, paramLong);
    }
    AppMethodBeat.o(216763);
  }
  
  public final void b(VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(216764);
    if ((paramVLogEffectMgr != null) && (paramVLogEffectMgr.LYd != 0L) && (paramVLogEffectMgr.LYd != this.LYl))
    {
      nSetVLogEffectMgr(this.LYd, paramVLogEffectMgr.LYd);
      this.LYl = paramVLogEffectMgr.LYd;
    }
    AppMethodBeat.o(216764);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(216761);
    checkThread();
    if (this.LYd != 0L)
    {
      nDestroy(this.LYd);
      this.LYd = 0L;
    }
    AppMethodBeat.o(216761);
  }
  
  public final void init()
  {
    AppMethodBeat.i(216760);
    this.threadId = Thread.currentThread().getId();
    this.LYd = nInit();
    AppMethodBeat.o(216760);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216759);
    this.width = paramInt1;
    this.height = paramInt2;
    checkThread();
    if (this.LYd != 0L) {
      nSetViewCrop(this.LYd, 0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(216759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogDirector
 * JD-Core Version:    0.7.0.1
 */