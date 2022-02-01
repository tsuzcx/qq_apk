package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.b.i.a;
import com.tencent.mm.plugin.voip.video.c.d.a;
import com.tencent.mm.plugin.voip.video.c.h;
import com.tencent.mm.plugin.voip.video.c.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyParam", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "()I", "setFaceBeautyAlgo", "(I)V", "isFaceBeautyAlogChanged", "", "()Z", "setFaceBeautyAlogChanged", "(Z)V", "isViewPortChange", "onFaceBeautyDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "getOnFaceBeautyDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnFaceBeautyDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "outputTexturObject", "programId", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getOutputRendererTexture", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setVoipBeauty", "cmd", "algorithm", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class k
  extends a
{
  public static final k.a Cte;
  private int CnM;
  private com.tencent.mm.plugin.voip.video.c.e CsV;
  private com.tencent.mm.plugin.voip.video.c.d CsW;
  private h CsX;
  com.tencent.mm.media.g.d CsY;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> CsZ;
  private boolean Cta = true;
  boolean Ctb;
  int Ctc;
  com.tencent.mm.media.g.d Ctd;
  private int gLM;
  int hon = -1;
  
  static
  {
    AppMethodBeat.i(216218);
    Cte = new k.a((byte)0);
    AppMethodBeat.o(216218);
  }
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
  }
  
  public final void amq()
  {
    AppMethodBeat.i(216214);
    if (this.Cta)
    {
      this.gLl.position(0);
      if (this.Ctc != 0)
      {
        this.gLl.put(k(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        this.gLl.position(0);
        this.gLm.position(0);
        this.gLm.put(com.tencent.mm.media.k.c.hoI);
        this.gLm.position(0);
      }
    }
    else
    {
      if (this.Ctc != 0)
      {
        if (this.hnu == null)
        {
          this.hnu = com.tencent.mm.media.g.c.a(true, 3L);
          localObject = com.tencent.mm.media.g.c.hkn;
          this.hnv = com.tencent.mm.media.g.c.rq(3L);
        }
        localObject = com.tencent.mm.media.k.c.hoP;
        c.a.a(this.hnv, this.hnu, this.gLD, this.gLE);
      }
      GLES20.glViewport(0, 0, this.gLD, this.gLE);
      AppMethodBeat.o(216214);
      return;
    }
    float f7 = this.hnI.x / this.gKJ;
    float f4 = (this.hnI.y - 1.0F) / this.gKK;
    float f6 = (this.hnJ.x - 1.0F) / this.gKJ;
    float f5 = this.hnJ.y / this.gKK;
    Object localObject = com.tencent.mm.media.k.c.hoJ;
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
    if ((this.hnk == 90) || (this.hnk == 270))
    {
      i = 1;
      j = this.hnJ.x - this.hnI.x;
      k = this.hnI.y - this.hnJ.y;
      if (i == 0) {
        break label534;
      }
      m = k;
      if (i == 0) {
        break label541;
      }
      f1 = this.gLD / m;
      f2 = this.gLE / j;
      if (f1 >= f2) {
        break label548;
      }
      f2 = m - this.gLD / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label392:
      this.hnF = (m - (int)f2);
      this.hnG = (j - (int)f1);
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
        FloatBuffer localFloatBuffer = this.gLl;
        p.g(localObject, "cropTextureCoord");
        localFloatBuffer.put(k((float[])localObject));
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
        f1 = j - this.gLE / f1;
        f2 = 0.0F;
        break label392;
        f2 = f2 / 2.0F / m;
      }
      label590:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void aud()
  {
    AppMethodBeat.i(216216);
    if (this.Ctc != 0) {
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(216216);
  }
  
  public final void aue()
  {
    AppMethodBeat.i(216215);
    Object localObject1;
    Object localObject2;
    FloatBuffer localFloatBuffer;
    int i;
    int j;
    int k;
    Object localObject3;
    switch (this.Ctc)
    {
    default: 
      localObject1 = this.CsV;
      if (localObject1 != null)
      {
        localObject2 = this.gLm;
        localFloatBuffer = this.gLl;
        i = this.hon;
        p.h(localObject2, "cubeBuffer");
        p.h(localFloatBuffer, "textureCoordBuff");
        if (i != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLM);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, i);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLP, 0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLN, 2, 5126, false, 8, (Buffer)localObject2);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLN);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLO, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLO);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLN);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLO);
        }
        AppMethodBeat.o(216215);
        return;
      }
      break;
    case 2: 
      localObject1 = this.CsX;
      if (localObject1 != null)
      {
        i = this.gLD;
        j = this.gLE;
        localObject2 = this.gLm;
        localFloatBuffer = this.gLl;
        k = this.hon;
        localObject3 = this.hnu;
        if (localObject3 == null) {
          p.gfZ();
        }
      }
      for (localObject1 = ((h)localObject1).a(i, j, (FloatBuffer)localObject2, localFloatBuffer, k, (com.tencent.mm.media.g.d)localObject3, this.CnM);; localObject1 = null)
      {
        this.Ctd = ((com.tencent.mm.media.g.d)localObject1);
        AppMethodBeat.o(216215);
        return;
      }
    case 1: 
      localObject2 = this.CsW;
      if (localObject2 != null)
      {
        i = this.gLD;
        j = this.gLE;
        localFloatBuffer = this.gLm;
        localObject3 = this.gLl;
        k = this.hon;
        localObject1 = this.hnu;
        if (localObject1 == null) {
          p.gfZ();
        }
        p.h(localFloatBuffer, "cubeBuffer");
        p.h(localObject3, "textureCoordBuff");
        p.h(localObject1, "outputTexture");
        if (k != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLM);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, k);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLP, 0);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).Cpw, 0.5F);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).Cpx, 0);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).Cpy, 2);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).Cpz, 0.8F);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CpA, i);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CpB, j);
          localFloatBuffer.position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLN, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLN);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLO, 2, 5126, false, 8, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLO);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLN);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLO);
          GLES20.glBindTexture(36197, 0);
          if (((com.tencent.mm.plugin.voip.video.c.d)localObject2).CqV)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).CqU;
            if (localObject2 != null)
            {
              ((EncoderSurfaceRender)localObject2).BHZ = ((com.tencent.mm.media.g.d)localObject1).hko;
              ((EncoderSurfaceRender)localObject2).iA(i, j);
              ((EncoderSurfaceRender)localObject2).requestRender();
              AppMethodBeat.o(216215);
              return;
            }
            AppMethodBeat.o(216215);
            return;
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLL;
          if (localObject2 != null)
          {
            ((com.tencent.mm.media.j.b.e)localObject2).nd(90);
            ((a)localObject2).hnl = true;
            ((com.tencent.mm.media.j.b.e)localObject2).gKH = ((com.tencent.mm.media.g.d)localObject1).hko;
            ((com.tencent.mm.media.j.b.e)localObject2).cU(i, j);
            ((com.tencent.mm.media.j.b.e)localObject2).cT(j, i);
            ((com.tencent.mm.media.j.b.e)localObject2).cW(j, i);
            ((a)localObject2).hnD = true;
            ((com.tencent.mm.media.j.b.e)localObject2).ams();
            AppMethodBeat.o(216215);
            return;
          }
        }
        AppMethodBeat.o(216215);
        return;
      }
      AppMethodBeat.o(216215);
      return;
    }
    AppMethodBeat.o(216215);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216213);
    if ((paramInt1 != this.gLD) || (paramInt2 != this.gLE))
    {
      super.cT(paramInt1, paramInt2);
      this.Cta = true;
    }
    AppMethodBeat.o(216213);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216212);
    super.cU(paramInt1, paramInt2);
    this.Cta = true;
    AppMethodBeat.o(216212);
  }
  
  public final void iE(int paramInt1, int paramInt2)
  {
    int i = 90;
    boolean bool = true;
    AppMethodBeat.i(216211);
    ad.i("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.CnM = paramInt1;
    if (this.Ctc != paramInt2)
    {
      this.Ctc = paramInt2;
      this.Cta = true;
    }
    Object localObject1;
    for (this.Ctb = true;; this.Ctb = false) {
      switch (paramInt2)
      {
      default: 
        if (this.CsV == null)
        {
          this.CsV = new com.tencent.mm.plugin.voip.video.c.e();
          localObject1 = i.ClE;
          i.a.UI(0);
        }
        this.hnp = 1;
        AppMethodBeat.o(216211);
        return;
      }
    }
    Object localObject2;
    if (this.CsX == null)
    {
      this.CsX = new h();
      localObject2 = this.CsX;
      if (localObject2 != null)
      {
        localObject1 = (r)new k.b(this);
        p.h(localObject1, "callback");
        if (!((h)localObject2).CqV) {
          break label286;
        }
        localObject2 = ((h)localObject2).CqU;
        if (localObject2 != null) {
          ((EncoderSurfaceRender)localObject2).Crj = ((r)localObject1);
        }
      }
      localObject1 = i.ClE;
      i.a.UI(1);
    }
    else if ((this.CsX != null) && (this.Ctb))
    {
      if (this.hnk != 90) {
        break label320;
      }
      paramInt1 = 270;
      label244:
      this.hnk = paramInt1;
      if (this.hnl) {
        break label326;
      }
    }
    label286:
    com.tencent.mm.media.j.b.e locale;
    label320:
    label326:
    for (bool = true;; bool = false)
    {
      this.hnl = bool;
      ad.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
      this.hnp = 2;
      AppMethodBeat.o(216211);
      return;
      locale = ((h)localObject2).gLL;
      if (locale == null) {
        break;
      }
      locale.hnB = ((d.g.a.b)new h.b((h)localObject2, (r)localObject1));
      break;
      paramInt1 = 90;
      break label244;
    }
    if (this.CsW == null)
    {
      this.CsW = new com.tencent.mm.plugin.voip.video.c.d();
      localObject2 = this.CsW;
      if (localObject2 != null)
      {
        localObject1 = (r)new k.c(this);
        p.h(localObject1, "callback");
        if (!((com.tencent.mm.plugin.voip.video.c.d)localObject2).CqV) {
          break label477;
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).CqU;
        if (localObject2 != null) {
          ((EncoderSurfaceRender)localObject2).Crj = ((r)localObject1);
        }
      }
      localObject1 = i.ClE;
      i.a.UI(2);
    }
    else if ((this.CsW != null) && (this.Ctb))
    {
      paramInt1 = i;
      if (this.hnk == 90) {
        paramInt1 = 270;
      }
      this.hnk = paramInt1;
      if (this.hnl) {
        break label511;
      }
    }
    for (;;)
    {
      this.hnl = bool;
      this.hnp = 2;
      AppMethodBeat.o(216211);
      return;
      label477:
      locale = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).gLL;
      if (locale == null) {
        break;
      }
      locale.hnB = ((d.g.a.b)new d.a((com.tencent.mm.plugin.voip.video.c.d)localObject2, (r)localObject1));
      break;
      label511:
      bool = false;
    }
  }
  
  public final void nN(int paramInt)
  {
    this.hon = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(216217);
    super.release();
    Object localObject1 = this.CsV;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gLM);
    }
    localObject1 = this.CsX;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((h)localObject1).gLL;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((h)localObject1).gLJ;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((h)localObject1).Crc;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gKI;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).gtl != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gtl;
        if (localObject3 == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gtl = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    Object localObject2 = ((h)localObject1).CqU;
    if (localObject2 != null) {
      ((EncoderSurfaceRender)localObject2).release();
    }
    GLES20.glDeleteProgram(((h)localObject1).gLM);
    localObject1 = this.CsW;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject1).CqU;
      if (localObject2 != null) {
        ((EncoderSurfaceRender)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject1).gLL;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.d)localObject1).gLM);
    }
    GLES20.glDeleteProgram(this.gLM);
    AppMethodBeat.o(216217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */