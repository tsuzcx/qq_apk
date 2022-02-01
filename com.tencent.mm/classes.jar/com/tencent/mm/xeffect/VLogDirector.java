package com.tencent.mm.xeffect;

import android.graphics.Rect;
import android.opengl.GLES31;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class VLogDirector
{
  private long LBd;
  private long LBl = 0L;
  private int height;
  private int outputHeight;
  private int outputWidth;
  private long threadId;
  private int width;
  
  static
  {
    AppMethodBeat.i(220015);
    e.load("xlabeffect");
    e.load("pag");
    AppMethodBeat.o(220015);
  }
  
  private void checkThread()
  {
    AppMethodBeat.i(220014);
    if (Thread.currentThread().getId() != this.threadId) {
      XEffectLog.e("VLogDirector", "Thread error", new Object[0]);
    }
    AppMethodBeat.o(220014);
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
    AppMethodBeat.i(220011);
    checkThread();
    if (this.LBd != 0L) {
      nSetOutputCrop(this.LBd, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(220011);
  }
  
  public final void a(List<a> paramList, int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(220012);
    checkThread();
    if (this.LBd != 0L)
    {
      if (parama != null) {
        nAddBlendTexture(this.LBd, parama.textureId, parama.width, parama.height);
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
          if (parama.LBj.isEmpty()) {
            break label345;
          }
          if (!parama.LBh.isEmpty()) {
            break label235;
          }
          nAddInputTextureByContentCrop(this.LBd, parama.LBf, parama.textureId, parama.width, parama.height, parama.dGc, parama.Crb, parama.LBg, parama.LBj.left, parama.LBj.top, parama.LBj.right, parama.LBj.bottom, parama.LBi.left, parama.LBi.top, parama.LBi.right, parama.LBi.bottom);
          break;
        }
        label233:
        continue;
        label235:
        nAddInputTextureByCropAndFitContent(this.LBd, parama.LBf, parama.textureId, parama.width, parama.height, parama.dGc, parama.Crb, parama.LBg, parama.LBh.left, parama.LBh.top, parama.LBh.right, parama.LBh.bottom, parama.LBj.left, parama.LBj.top, parama.LBj.right, parama.LBj.bottom);
        continue;
        label345:
        if (!parama.LBh.isEmpty()) {
          nAddInputTextureByCrop(this.LBd, parama.LBf, parama.textureId, parama.width, parama.height, parama.dGc, parama.Crb, parama.LBg, parama.LBh.left, parama.LBh.top, parama.LBh.right, parama.LBh.bottom);
        } else {
          nAddInputTextureByTransform(this.LBd, parama.LBf, parama.textureId, parama.width, parama.height, parama.dGc, parama.Crb, parama.LBg, parama.hnk, parama.scale, parama.translateX, parama.translateY);
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
      nRender(this.LBd, paramInt, this.outputWidth, this.outputHeight, paramLong);
    }
    AppMethodBeat.o(220012);
  }
  
  public final void b(VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(220013);
    if ((paramVLogEffectMgr != null) && (paramVLogEffectMgr.LBd != 0L) && (paramVLogEffectMgr.LBd != this.LBl))
    {
      nSetVLogEffectMgr(this.LBd, paramVLogEffectMgr.LBd);
      this.LBl = paramVLogEffectMgr.LBd;
    }
    AppMethodBeat.o(220013);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(220010);
    checkThread();
    if (this.LBd != 0L)
    {
      nDestroy(this.LBd);
      this.LBd = 0L;
    }
    AppMethodBeat.o(220010);
  }
  
  public final void init()
  {
    AppMethodBeat.i(220009);
    this.threadId = Thread.currentThread().getId();
    this.LBd = nInit();
    AppMethodBeat.o(220009);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220008);
    this.width = paramInt1;
    this.height = paramInt2;
    checkThread();
    if (this.LBd != 0L) {
      nSetViewCrop(this.LBd, 0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(220008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.xeffect.VLogDirector
 * JD-Core Version:    0.7.0.1
 */