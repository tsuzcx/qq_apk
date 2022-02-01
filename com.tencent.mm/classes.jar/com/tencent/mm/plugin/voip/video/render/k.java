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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyParam", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "()I", "setFaceBeautyAlgo", "(I)V", "isFaceBeautyAlogChanged", "", "()Z", "setFaceBeautyAlogChanged", "(Z)V", "isViewPortChange", "onFaceBeautyDataCallback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "getOnFaceBeautyDataCallback", "()Lkotlin/jvm/functions/Function4;", "setOnFaceBeautyDataCallback", "(Lkotlin/jvm/functions/Function4;)V", "outputTexturObject", "programId", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getOutputRendererTexture", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setVoipBeauty", "cmd", "algorithm", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class k
  extends a
{
  public static final k.a CKI;
  private int CFq;
  private com.tencent.mm.plugin.voip.video.c.d CKA;
  private h CKB;
  com.tencent.mm.media.g.d CKC;
  r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, z> CKD;
  private boolean CKE = true;
  boolean CKF;
  int CKG;
  com.tencent.mm.media.g.d CKH;
  private com.tencent.mm.plugin.voip.video.c.e CKz;
  private int gOv;
  int hrb = -1;
  
  static
  {
    AppMethodBeat.i(210639);
    CKI = new k.a((byte)0);
    AppMethodBeat.o(210639);
  }
  
  public k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
  }
  
  public final void amF()
  {
    AppMethodBeat.i(210635);
    if (this.CKE)
    {
      this.gNU.position(0);
      if (this.CKG != 0)
      {
        this.gNU.put(k(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        this.gNU.position(0);
        this.gNV.position(0);
        this.gNV.put(com.tencent.mm.media.k.c.hrw);
        this.gNV.position(0);
      }
    }
    else
    {
      if (this.CKG != 0)
      {
        if (this.hqi == null)
        {
          this.hqi = com.tencent.mm.media.g.c.a(true, 3L);
          localObject = com.tencent.mm.media.g.c.hnb;
          this.hqj = com.tencent.mm.media.g.c.rD(3L);
        }
        localObject = com.tencent.mm.media.k.c.hrD;
        c.a.a(this.hqj, this.hqi, this.gOm, this.gOn);
      }
      GLES20.glViewport(0, 0, this.gOm, this.gOn);
      AppMethodBeat.o(210635);
      return;
    }
    float f7 = this.hqw.x / this.gNs;
    float f4 = (this.hqw.y - 1.0F) / this.gNt;
    float f6 = (this.hqx.x - 1.0F) / this.gNs;
    float f5 = this.hqx.y / this.gNt;
    Object localObject = com.tencent.mm.media.k.c.hrx;
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
    if ((this.hpY == 90) || (this.hpY == 270))
    {
      i = 1;
      j = this.hqx.x - this.hqw.x;
      k = this.hqw.y - this.hqx.y;
      if (i == 0) {
        break label534;
      }
      m = k;
      if (i == 0) {
        break label541;
      }
      f1 = this.gOm / m;
      f2 = this.gOn / j;
      if (f1 >= f2) {
        break label548;
      }
      f2 = m - this.gOm / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label392:
      this.hqt = (m - (int)f2);
      this.hqu = (j - (int)f1);
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
        FloatBuffer localFloatBuffer = this.gNU;
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
        f1 = j - this.gOn / f1;
        f2 = 0.0F;
        break label392;
        f2 = f2 / 2.0F / m;
      }
      label590:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void aus()
  {
    AppMethodBeat.i(210637);
    if (this.CKG != 0) {
      GLES20.glBindFramebuffer(36160, 0);
    }
    AppMethodBeat.o(210637);
  }
  
  public final void aut()
  {
    AppMethodBeat.i(210636);
    Object localObject1;
    Object localObject2;
    FloatBuffer localFloatBuffer;
    int i;
    int j;
    int k;
    Object localObject3;
    switch (this.CKG)
    {
    default: 
      localObject1 = this.CKz;
      if (localObject1 != null)
      {
        localObject2 = this.gNV;
        localFloatBuffer = this.gNU;
        i = this.hrb;
        p.h(localObject2, "cubeBuffer");
        p.h(localFloatBuffer, "textureCoordBuff");
        if (i != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOv);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, i);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOy, 0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOw, 2, 5126, false, 8, (Buffer)localObject2);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOw);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOx, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOx);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOw);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOx);
        }
        AppMethodBeat.o(210636);
        return;
      }
      break;
    case 2: 
      localObject1 = this.CKB;
      if (localObject1 != null)
      {
        i = this.gOm;
        j = this.gOn;
        localObject2 = this.gNV;
        localFloatBuffer = this.gNU;
        k = this.hrb;
        localObject3 = this.hqi;
        if (localObject3 == null) {
          p.gkB();
        }
      }
      for (localObject1 = ((h)localObject1).a(i, j, (FloatBuffer)localObject2, localFloatBuffer, k, (com.tencent.mm.media.g.d)localObject3, this.CFq);; localObject1 = null)
      {
        this.CKH = ((com.tencent.mm.media.g.d)localObject1);
        AppMethodBeat.o(210636);
        return;
      }
    case 1: 
      localObject2 = this.CKA;
      if (localObject2 != null)
      {
        i = this.gOm;
        j = this.gOn;
        localFloatBuffer = this.gNV;
        localObject3 = this.gNU;
        k = this.hrb;
        localObject1 = this.hqi;
        if (localObject1 == null) {
          p.gkB();
        }
        p.h(localFloatBuffer, "cubeBuffer");
        p.h(localObject3, "textureCoordBuff");
        p.h(localObject1, "outputTexture");
        if (k != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOv);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, k);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOy, 0);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHa, 0.5F);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHb, 0);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHc, 2);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHd, 0.8F);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHe, i);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.d)localObject2).CHf, j);
          localFloatBuffer.position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOw, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOw);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOx, 2, 5126, false, 8, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOx);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOw);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOx);
          GLES20.glBindTexture(36197, 0);
          if (((com.tencent.mm.plugin.voip.video.c.d)localObject2).CIz)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).CIy;
            if (localObject2 != null)
            {
              ((EncoderSurfaceRender)localObject2).BZy = ((com.tencent.mm.media.g.d)localObject1).hnc;
              ((EncoderSurfaceRender)localObject2).iE(i, j);
              ((EncoderSurfaceRender)localObject2).requestRender();
              AppMethodBeat.o(210636);
              return;
            }
            AppMethodBeat.o(210636);
            return;
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOu;
          if (localObject2 != null)
          {
            ((com.tencent.mm.media.j.b.e)localObject2).ng(90);
            ((a)localObject2).hpZ = true;
            ((com.tencent.mm.media.j.b.e)localObject2).gNq = ((com.tencent.mm.media.g.d)localObject1).hnc;
            ((com.tencent.mm.media.j.b.e)localObject2).cU(i, j);
            ((com.tencent.mm.media.j.b.e)localObject2).cT(j, i);
            ((com.tencent.mm.media.j.b.e)localObject2).cW(j, i);
            ((a)localObject2).hqr = true;
            ((com.tencent.mm.media.j.b.e)localObject2).amH();
            AppMethodBeat.o(210636);
            return;
          }
        }
        AppMethodBeat.o(210636);
        return;
      }
      AppMethodBeat.o(210636);
      return;
    }
    AppMethodBeat.o(210636);
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210634);
    if ((paramInt1 != this.gOm) || (paramInt2 != this.gOn))
    {
      super.cT(paramInt1, paramInt2);
      this.CKE = true;
    }
    AppMethodBeat.o(210634);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210633);
    super.cU(paramInt1, paramInt2);
    this.CKE = true;
    AppMethodBeat.o(210633);
  }
  
  public final void iI(int paramInt1, int paramInt2)
  {
    int i = 90;
    boolean bool = true;
    AppMethodBeat.i(210632);
    ae.i("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.CFq = paramInt1;
    if (this.CKG != paramInt2)
    {
      this.CKG = paramInt2;
      this.CKE = true;
    }
    Object localObject1;
    for (this.CKF = true;; this.CKF = false) {
      switch (paramInt2)
      {
      default: 
        if (this.CKz == null)
        {
          this.CKz = new com.tencent.mm.plugin.voip.video.c.e();
          localObject1 = i.CDi;
          i.a.Vp(0);
        }
        this.hqd = 1;
        AppMethodBeat.o(210632);
        return;
      }
    }
    Object localObject2;
    if (this.CKB == null)
    {
      this.CKB = new h();
      localObject2 = this.CKB;
      if (localObject2 != null)
      {
        localObject1 = (r)new b(this);
        p.h(localObject1, "callback");
        if (!((h)localObject2).CIz) {
          break label286;
        }
        localObject2 = ((h)localObject2).CIy;
        if (localObject2 != null) {
          ((EncoderSurfaceRender)localObject2).CIN = ((r)localObject1);
        }
      }
      localObject1 = i.CDi;
      i.a.Vp(1);
    }
    else if ((this.CKB != null) && (this.CKF))
    {
      if (this.hpY != 90) {
        break label320;
      }
      paramInt1 = 270;
      label244:
      this.hpY = paramInt1;
      if (this.hpZ) {
        break label326;
      }
    }
    label286:
    com.tencent.mm.media.j.b.e locale;
    label320:
    label326:
    for (bool = true;; bool = false)
    {
      this.hpZ = bool;
      ae.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
      this.hqd = 2;
      AppMethodBeat.o(210632);
      return;
      locale = ((h)localObject2).gOu;
      if (locale == null) {
        break;
      }
      locale.hqp = ((d.g.a.b)new h.b((h)localObject2, (r)localObject1));
      break;
      paramInt1 = 90;
      break label244;
    }
    if (this.CKA == null)
    {
      this.CKA = new com.tencent.mm.plugin.voip.video.c.d();
      localObject2 = this.CKA;
      if (localObject2 != null)
      {
        localObject1 = (r)new c(this);
        p.h(localObject1, "callback");
        if (!((com.tencent.mm.plugin.voip.video.c.d)localObject2).CIz) {
          break label477;
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).CIy;
        if (localObject2 != null) {
          ((EncoderSurfaceRender)localObject2).CIN = ((r)localObject1);
        }
      }
      localObject1 = i.CDi;
      i.a.Vp(2);
    }
    else if ((this.CKA != null) && (this.CKF))
    {
      paramInt1 = i;
      if (this.hpY == 90) {
        paramInt1 = 270;
      }
      this.hpY = paramInt1;
      if (this.hpZ) {
        break label511;
      }
    }
    for (;;)
    {
      this.hpZ = bool;
      this.hqd = 2;
      AppMethodBeat.o(210632);
      return;
      label477:
      locale = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).gOu;
      if (locale == null) {
        break;
      }
      locale.hqp = ((d.g.a.b)new d.a((com.tencent.mm.plugin.voip.video.c.d)localObject2, (r)localObject1));
      break;
      label511:
      bool = false;
    }
  }
  
  public final void nQ(int paramInt)
  {
    this.hrb = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(210638);
    super.release();
    Object localObject1 = this.CKz;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.e)localObject1).gOv);
    }
    localObject1 = this.CKB;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((h)localObject1).gOu;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      localObject2 = ((h)localObject1).gOs;
      if (localObject2 != null) {
        ((com.tencent.mm.media.g.d)localObject2).close();
      }
      localObject2 = ((h)localObject1).CIG;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ae.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gNr;
      if (localObject3 != null) {
        ((com.tencent.mm.media.g.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).gvS != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gvS;
        if (localObject3 == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gvS = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    Object localObject2 = ((h)localObject1).CIy;
    if (localObject2 != null) {
      ((EncoderSurfaceRender)localObject2).release();
    }
    GLES20.glDeleteProgram(((h)localObject1).gOv);
    localObject1 = this.CKA;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject1).CIy;
      if (localObject2 != null) {
        ((EncoderSurfaceRender)localObject2).release();
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject1).gOu;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.d)localObject1).gOv);
    }
    GLES20.glDeleteProgram(this.gOv);
    AppMethodBeat.o(210638);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class b
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, z>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "dataType", "invoke"})
  static final class c
    extends q
    implements r<ByteBuffer, Integer, Integer, Integer, z>
  {
    c(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */