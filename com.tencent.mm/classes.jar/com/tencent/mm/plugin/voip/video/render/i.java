package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.voip.b.f.a;
import com.tencent.mm.plugin.voip.video.c.b.a;
import com.tencent.mm.plugin.voip.video.c.f.b;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyParam", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "()I", "setFaceBeautyAlgo", "(I)V", "isFaceBeautyAlogChanged", "", "()Z", "setFaceBeautyAlogChanged", "(Z)V", "isViewPortChange", "onRgbDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "getOnRgbDataCallback", "()Lkotlin/jvm/functions/Function3;", "setOnRgbDataCallback", "(Lkotlin/jvm/functions/Function3;)V", "outputTexturObject", "programId", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getOutputRendererTexture", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setVoipBeauty", "cmd", "algorithm", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class i
  extends a
{
  public static final i.a zAE;
  private int gvL;
  int gvQ = -1;
  private boolean zAA = true;
  boolean zAB;
  int zAC;
  com.tencent.mm.media.f.d zAD;
  private com.tencent.mm.plugin.voip.video.c.c zAv;
  private com.tencent.mm.plugin.voip.video.c.b zAw;
  private com.tencent.mm.plugin.voip.video.c.f zAx;
  com.tencent.mm.media.f.d zAy;
  q<? super ByteBuffer, ? super Integer, ? super Integer, y> zAz;
  private int zvB;
  
  static
  {
    AppMethodBeat.i(192504);
    zAE = new i.a((byte)0);
    AppMethodBeat.o(192504);
  }
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
  }
  
  public final void akt()
  {
    AppMethodBeat.i(192500);
    if (this.zAA)
    {
      this.guS.position(0);
      if (this.zAC != 0)
      {
        this.guS.put(m(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        this.guS.position(0);
        this.guT.position(0);
        this.guT.put(com.tencent.mm.media.j.c.gwe);
        this.guT.position(0);
      }
    }
    else
    {
      if (this.zAC != 0)
      {
        if (this.guU == null)
        {
          this.guU = com.tencent.mm.media.f.c.a(true, 3L);
          localObject = com.tencent.mm.media.f.c.grn;
          this.guV = com.tencent.mm.media.f.c.lC(3L);
        }
        localObject = com.tencent.mm.media.j.c.gwl;
        c.a.a(this.guV, this.guU, this.guK, this.guL);
      }
      GLES20.glViewport(0, 0, this.guK, this.guL);
      AppMethodBeat.o(192500);
      return;
    }
    float f7 = this.gvh.x / this.guI;
    float f4 = (this.gvh.y - 1.0F) / this.guJ;
    float f6 = (this.gvi.x - 1.0F) / this.guI;
    float f5 = this.gvi.y / this.guJ;
    Object localObject = com.tencent.mm.media.j.c.gwf;
    localObject = Arrays.copyOf((float[])localObject, localObject.length);
    int i;
    label304:
    int j;
    int k;
    int m;
    label347:
    label352:
    float f1;
    float f2;
    if ((this.guD == 90) || (this.guD == 270))
    {
      i = 1;
      j = this.gvi.x - this.gvh.x;
      k = this.gvh.y - this.gvi.y;
      if (i == 0) {
        break label534;
      }
      m = k;
      if (i == 0) {
        break label541;
      }
      f1 = this.guK / m;
      f2 = this.guL / j;
      if (f1 >= f2) {
        break label548;
      }
      f2 = m - this.guK / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label392:
      this.gve = (m - (int)f2);
      this.gvf = (j - (int)f1);
      float f3;
      if (i != 0)
      {
        f1 = f1 / 2.0F / j;
        f3 = f2 / 2.0F / m;
        f2 = f1;
      }
      for (f1 = f3;; f1 = f1 / 2.0F / j)
      {
        f3 = f7 + f2;
        f2 = f6 - f2;
        f5 += f1;
        f1 = f4 - f1;
        localObject[0] = f3;
        localObject[1] = f1;
        localObject[2] = f2;
        localObject[3] = f1;
        localObject[4] = f3;
        localObject[5] = f5;
        localObject[6] = f2;
        localObject[7] = f5;
        FloatBuffer localFloatBuffer = this.guS;
        k.g(localObject, "cropTextureCoord");
        localFloatBuffer.put(m((float[])localObject));
        break;
        i = 0;
        break label304;
        label534:
        m = j;
        break label347;
        label541:
        j = k;
        break label352;
        label548:
        if (f1 <= f2) {
          break label590;
        }
        f1 = j - this.guL / f1;
        f2 = 0.0F;
        break label392;
        f2 = f2 / 2.0F / m;
      }
      label590:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void aku()
  {
    AppMethodBeat.i(192502);
    if (this.zAC != 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      c.a locala = com.tencent.mm.media.j.c.gwl;
      c.a.akz();
    }
    AppMethodBeat.o(192502);
  }
  
  public final void akv()
  {
    AppMethodBeat.i(192501);
    Object localObject1;
    Object localObject2;
    FloatBuffer localFloatBuffer;
    int i;
    int j;
    int k;
    Object localObject3;
    switch (this.zAC)
    {
    default: 
      localObject1 = this.zAv;
      if (localObject1 != null)
      {
        localObject2 = this.guT;
        localFloatBuffer = this.guS;
        i = this.gvQ;
        k.h(localObject2, "cubeBuffer");
        k.h(localFloatBuffer, "textureCoordBuff");
        if (i != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvL);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, i);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvO, 0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvM, 2, 5126, false, 8, (Buffer)localObject2);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvM);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvN, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvN);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvM);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvN);
        }
        AppMethodBeat.o(192501);
        return;
      }
      break;
    case 2: 
      localObject1 = this.zAx;
      if (localObject1 != null)
      {
        i = this.guK;
        j = this.guL;
        localObject2 = this.guT;
        localFloatBuffer = this.guS;
        k = this.gvQ;
        localObject3 = this.guU;
        if (localObject3 == null) {
          k.fvU();
        }
      }
      for (localObject1 = ((com.tencent.mm.plugin.voip.video.c.f)localObject1).a(i, j, (FloatBuffer)localObject2, localFloatBuffer, k, (com.tencent.mm.media.f.d)localObject3, this.zvB);; localObject1 = null)
      {
        this.zAD = ((com.tencent.mm.media.f.d)localObject1);
        AppMethodBeat.o(192501);
        return;
      }
    case 1: 
      localObject2 = this.zAw;
      if (localObject2 != null)
      {
        i = this.guK;
        j = this.guL;
        localFloatBuffer = this.guT;
        localObject3 = this.guS;
        k = this.gvQ;
        localObject1 = this.guU;
        if (localObject1 == null) {
          k.fvU();
        }
        k.h(localFloatBuffer, "cubeBuffer");
        k.h(localObject3, "textureCoordBuff");
        k.h(localObject1, "outputTexture");
        if (k != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvL);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, k);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvO, 0);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxm, 0.5F);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxn, 0);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxo, 2);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxp, 0.8F);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxq, i);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).zxr, j);
          localFloatBuffer.position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvM, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvM);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvN, 2, 5126, false, 8, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvN);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvM);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gvN);
          GLES20.glBindTexture(36197, 0);
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).zyt;
          if (localObject2 != null)
          {
            ((com.tencent.mm.media.i.b.d)localObject2).mz(90);
            ((a)localObject2).guE = true;
            ((com.tencent.mm.media.i.b.d)localObject2).guC = ((com.tencent.mm.media.f.d)localObject1).gro;
            ((com.tencent.mm.media.i.b.d)localObject2).cS(i, j);
            ((com.tencent.mm.media.i.b.d)localObject2).cT(j, i);
            ((com.tencent.mm.media.i.b.d)localObject2).cU(j, i);
            ((a)localObject2).gvc = true;
            ((com.tencent.mm.media.i.b.d)localObject2).akk();
            AppMethodBeat.o(192501);
            return;
          }
        }
        AppMethodBeat.o(192501);
        return;
      }
      AppMethodBeat.o(192501);
      return;
    }
    AppMethodBeat.o(192501);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192498);
    super.cS(paramInt1, paramInt2);
    this.zAA = true;
    AppMethodBeat.o(192498);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192499);
    if ((paramInt1 != this.guK) || (paramInt2 != this.guL))
    {
      super.cT(paramInt1, paramInt2);
      this.zAA = true;
    }
    AppMethodBeat.o(192499);
  }
  
  public final void ic(int paramInt1, int paramInt2)
  {
    int i = 90;
    boolean bool = true;
    AppMethodBeat.i(192497);
    ad.i("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.zvB = paramInt1;
    if (this.zAC != paramInt2)
    {
      this.zAC = paramInt2;
      this.zAA = true;
    }
    Object localObject;
    for (this.zAB = true;; this.zAB = false) {
      switch (paramInt2)
      {
      default: 
        if (this.zAv == null)
        {
          this.zAv = new com.tencent.mm.plugin.voip.video.c.c();
          localObject = com.tencent.mm.plugin.voip.b.f.ztz;
          f.a.QG(0);
        }
        this.guM = 1;
        AppMethodBeat.o(192497);
        return;
      }
    }
    q localq;
    com.tencent.mm.media.i.b.d locald;
    if (this.zAx == null)
    {
      this.zAx = new com.tencent.mm.plugin.voip.video.c.f();
      localObject = this.zAx;
      if (localObject != null)
      {
        localq = (q)new b(this);
        k.h(localq, "callback");
        locald = ((com.tencent.mm.plugin.voip.video.c.f)localObject).zyt;
        if (locald != null) {
          locald.gvb = ((d.g.a.b)new f.b((com.tencent.mm.plugin.voip.video.c.f)localObject, localq));
        }
      }
      localObject = com.tencent.mm.plugin.voip.b.f.ztz;
      f.a.QG(1);
    }
    if ((this.zAx != null) && (this.zAB))
    {
      if (this.guD != 90) {
        break label290;
      }
      paramInt1 = 270;
      this.guD = paramInt1;
      if (this.guE) {
        break label296;
      }
    }
    label290:
    label296:
    for (bool = true;; bool = false)
    {
      this.guE = bool;
      ad.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
      this.guM = 2;
      AppMethodBeat.o(192497);
      return;
      paramInt1 = 90;
      break;
    }
    if (this.zAw == null)
    {
      this.zAw = new com.tencent.mm.plugin.voip.video.c.b();
      localObject = this.zAw;
      if (localObject != null)
      {
        localq = (q)new c(this);
        k.h(localq, "callback");
        locald = ((com.tencent.mm.plugin.voip.video.c.b)localObject).zyt;
        if (locald != null) {
          locald.gvb = ((d.g.a.b)new b.a((com.tencent.mm.plugin.voip.video.c.b)localObject, localq));
        }
      }
      localObject = com.tencent.mm.plugin.voip.b.f.ztz;
      f.a.QG(2);
    }
    if ((this.zAw != null) && (this.zAB))
    {
      paramInt1 = i;
      if (this.guD == 90) {
        paramInt1 = 270;
      }
      this.guD = paramInt1;
      if (this.guE) {
        break label451;
      }
    }
    for (;;)
    {
      this.guE = bool;
      this.guM = 2;
      AppMethodBeat.o(192497);
      return;
      label451:
      bool = false;
    }
  }
  
  public final void mA(int paramInt)
  {
    this.gvQ = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(192503);
    super.release();
    Object localObject1 = this.zAv;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gvL);
    }
    localObject1 = this.zAx;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.f)localObject1).zyt;
      if (localObject2 != null) {
        ((com.tencent.mm.media.i.b.d)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.f)localObject1).oSo;
      if (localObject2 != null) {
        ((com.tencent.mm.media.f.d)localObject2).close();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.f)localObject1).zyA;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).zwE;
      if (localObject3 != null) {
        ((com.tencent.mm.media.f.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).fVU != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).fVU;
        if (localObject3 == null) {
          k.fvU();
        }
        ((XLabEffect)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).fVU = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.f)localObject1).gvL);
    localObject1 = this.zAw;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject1).zyt;
      if (localObject2 != null) {
        ((com.tencent.mm.media.i.b.d)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject1).gvL);
    }
    GLES20.glDeleteProgram(this.gvL);
    AppMethodBeat.o(192503);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "(Ljava/nio/ByteBuffer;II)Lkotlin/Unit;"})
  static final class b
    extends d.g.b.l
    implements q<ByteBuffer, Integer, Integer, y>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "(Ljava/nio/ByteBuffer;II)Lkotlin/Unit;"})
  static final class c
    extends d.g.b.l
    implements q<ByteBuffer, Integer, Integer, y>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.i
 * JD-Core Version:    0.7.0.1
 */