package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.g.a;
import com.tencent.mm.plugin.voip.video.c.b.a;
import com.tencent.mm.plugin.voip.video.c.f;
import com.tencent.mm.plugin.voip.video.c.f.b;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/VoipRenderProcExternalTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "beautyParam", "externalGLTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "externalTexture", "faceBeautyAlgo", "getFaceBeautyAlgo", "()I", "setFaceBeautyAlgo", "(I)V", "isFaceBeautyAlogChanged", "", "()Z", "setFaceBeautyAlogChanged", "(Z)V", "isViewPortChange", "onRgbDataCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "", "getOnRgbDataCallback", "()Lkotlin/jvm/functions/Function3;", "setOnRgbDataCallback", "(Lkotlin/jvm/functions/Function3;)V", "outputTexturObject", "programId", "textureRenderProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRawRendererProgram;", "wcFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipMMFaceBeautyRendererProgram;", "ytFaceBeautyProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "afterRender", "beforeRender", "getOutputRendererTexture", "release", "renderImpl", "setInputGLTexture", "texture", "setInputTexture", "setVoipBeauty", "cmd", "algorithm", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class i
  extends a
{
  public static final i.a ASW;
  private int AOs;
  private com.tencent.mm.plugin.voip.video.c.c ASN;
  private com.tencent.mm.plugin.voip.video.c.b ASO;
  private f ASP;
  com.tencent.mm.media.f.d ASQ;
  q<? super ByteBuffer, ? super Integer, ? super Integer, y> ASR;
  private boolean ASS = true;
  boolean AST;
  int ASU;
  com.tencent.mm.media.f.d ASV;
  int gWh = -1;
  private int gse;
  
  static
  {
    AppMethodBeat.i(208855);
    ASW = new i.a((byte)0);
    AppMethodBeat.o(208855);
  }
  
  public i(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, 2, 1);
  }
  
  public final void ajE()
  {
    AppMethodBeat.i(208851);
    if (this.ASS)
    {
      this.grD.position(0);
      if (this.ASU != 0)
      {
        this.grD.put(m(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F }));
        this.grD.position(0);
        this.grE.position(0);
        this.grE.put(com.tencent.mm.media.j.c.gWC);
        this.grE.position(0);
      }
    }
    else
    {
      if (this.ASU != 0)
      {
        if (this.gVr == null)
        {
          this.gVr = com.tencent.mm.media.f.c.a(true, 3L);
          localObject = com.tencent.mm.media.f.c.gRV;
          this.gVs = com.tencent.mm.media.f.c.pq(3L);
        }
        localObject = com.tencent.mm.media.j.c.gWJ;
        c.a.a(this.gVs, this.gVr, this.grV, this.grW);
      }
      GLES20.glViewport(0, 0, this.grV, this.grW);
      AppMethodBeat.o(208851);
      return;
    }
    float f7 = this.gVE.x / this.gqZ;
    float f4 = (this.gVE.y - 1.0F) / this.gra;
    float f6 = (this.gVF.x - 1.0F) / this.gqZ;
    float f5 = this.gVF.y / this.gra;
    Object localObject = com.tencent.mm.media.j.c.gWD;
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
    if ((this.gVh == 90) || (this.gVh == 270))
    {
      i = 1;
      j = this.gVF.x - this.gVE.x;
      k = this.gVE.y - this.gVF.y;
      if (i == 0) {
        break label534;
      }
      m = k;
      if (i == 0) {
        break label541;
      }
      f1 = this.grV / m;
      f2 = this.grW / j;
      if (f1 >= f2) {
        break label548;
      }
      f2 = m - this.grV / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label392:
      this.gVB = (m - (int)f2);
      this.gVC = (j - (int)f1);
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
        FloatBuffer localFloatBuffer = this.grD;
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
        f1 = j - this.grW / f1;
        f2 = 0.0F;
        break label392;
        f2 = f2 / 2.0F / m;
      }
      label590:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public final void arq()
  {
    AppMethodBeat.i(208853);
    if (this.ASU != 0)
    {
      GLES20.glBindFramebuffer(36160, 0);
      c.a locala = com.tencent.mm.media.j.c.gWJ;
      c.a.art();
    }
    AppMethodBeat.o(208853);
  }
  
  public final void arr()
  {
    AppMethodBeat.i(208852);
    Object localObject1;
    Object localObject2;
    FloatBuffer localFloatBuffer;
    int i;
    int j;
    int k;
    Object localObject3;
    switch (this.ASU)
    {
    default: 
      localObject1 = this.ASN;
      if (localObject1 != null)
      {
        localObject2 = this.grE;
        localFloatBuffer = this.grD;
        i = this.gWh;
        k.h(localObject2, "cubeBuffer");
        k.h(localFloatBuffer, "textureCoordBuff");
        if (i != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gse);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, i);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsh, 0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsf, 2, 5126, false, 8, (Buffer)localObject2);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsf);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsg, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsg);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsf);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gsg);
        }
        AppMethodBeat.o(208852);
        return;
      }
      break;
    case 2: 
      localObject1 = this.ASP;
      if (localObject1 != null)
      {
        i = this.grV;
        j = this.grW;
        localObject2 = this.grE;
        localFloatBuffer = this.grD;
        k = this.gWh;
        localObject3 = this.gVr;
        if (localObject3 == null) {
          k.fOy();
        }
      }
      for (localObject1 = ((f)localObject1).a(i, j, (FloatBuffer)localObject2, localFloatBuffer, k, (com.tencent.mm.media.f.d)localObject3, this.AOs);; localObject1 = null)
      {
        this.ASV = ((com.tencent.mm.media.f.d)localObject1);
        AppMethodBeat.o(208852);
        return;
      }
    case 1: 
      localObject2 = this.ASO;
      if (localObject2 != null)
      {
        i = this.grV;
        j = this.grW;
        localFloatBuffer = this.grE;
        localObject3 = this.grD;
        k = this.gWh;
        localObject1 = this.gVr;
        if (localObject1 == null) {
          k.fOy();
        }
        k.h(localFloatBuffer, "cubeBuffer");
        k.h(localObject3, "textureCoordBuff");
        k.h(localObject1, "outputTexture");
        if (k != -1)
        {
          GLES20.glUseProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gse);
          GLES20.glActiveTexture(33984);
          GLES20.glBindTexture(36197, k);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsh, 0);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQe, 0.5F);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQf, 0);
          GLES20.glUniform1i(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQg, 2);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQh, 0.8F);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQi, i);
          GLES20.glUniform1f(((com.tencent.mm.plugin.voip.video.c.b)localObject2).AQj, j);
          localFloatBuffer.position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsf, 2, 5126, false, 8, (Buffer)localFloatBuffer);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsf);
          ((FloatBuffer)localObject3).position(0);
          GLES20.glVertexAttribPointer(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsg, 2, 5126, false, 8, (Buffer)localObject3);
          GLES20.glEnableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsg);
          GLES20.glDrawArrays(5, 0, 4);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsf);
          GLES20.glDisableVertexAttribArray(((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsg);
          GLES20.glBindTexture(36197, 0);
          localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject2).gsd;
          if (localObject2 != null)
          {
            ((e)localObject2).mE(90);
            ((a)localObject2).gVi = true;
            ((e)localObject2).gqX = ((com.tencent.mm.media.f.d)localObject1).gRW;
            ((e)localObject2).cS(i, j);
            ((e)localObject2).cR(j, i);
            ((e)localObject2).cU(j, i);
            ((a)localObject2).gVz = true;
            ((e)localObject2).ajG();
            AppMethodBeat.o(208852);
            return;
          }
        }
        AppMethodBeat.o(208852);
        return;
      }
      AppMethodBeat.o(208852);
      return;
    }
    AppMethodBeat.o(208852);
  }
  
  public final void cR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208850);
    if ((paramInt1 != this.grV) || (paramInt2 != this.grW))
    {
      super.cR(paramInt1, paramInt2);
      this.ASS = true;
    }
    AppMethodBeat.o(208850);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208849);
    super.cS(paramInt1, paramInt2);
    this.ASS = true;
    AppMethodBeat.o(208849);
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    int i = 90;
    boolean bool = true;
    AppMethodBeat.i(208848);
    ac.i("MicroMsg.VoipRenderProcExternalTexture", "setVoIPBeauty, isON:%d", new Object[] { Integer.valueOf(paramInt1) });
    this.AOs = paramInt1;
    if (this.ASU != paramInt2)
    {
      this.ASU = paramInt2;
      this.ASS = true;
    }
    Object localObject;
    for (this.AST = true;; this.AST = false) {
      switch (paramInt2)
      {
      default: 
        if (this.ASN == null)
        {
          this.ASN = new com.tencent.mm.plugin.voip.video.c.c();
          localObject = g.AMq;
          g.a.SP(0);
        }
        this.gVm = 1;
        AppMethodBeat.o(208848);
        return;
      }
    }
    q localq;
    e locale;
    if (this.ASP == null)
    {
      this.ASP = new f();
      localObject = this.ASP;
      if (localObject != null)
      {
        localq = (q)new b(this);
        k.h(localq, "callback");
        locale = ((f)localObject).gsd;
        if (locale != null) {
          locale.gVy = ((d.g.a.b)new f.b((f)localObject, localq));
        }
      }
      localObject = g.AMq;
      g.a.SP(1);
    }
    if ((this.ASP != null) && (this.AST))
    {
      if (this.gVh != 90) {
        break label290;
      }
      paramInt1 = 270;
      this.gVh = paramInt1;
      if (this.gVi) {
        break label296;
      }
    }
    label290:
    label296:
    for (bool = true;; bool = false)
    {
      this.gVi = bool;
      ac.i("MicroMsg.VoipRenderProcExternalTexture", "render YT face-beauty algorithm");
      this.gVm = 2;
      AppMethodBeat.o(208848);
      return;
      paramInt1 = 90;
      break;
    }
    if (this.ASO == null)
    {
      this.ASO = new com.tencent.mm.plugin.voip.video.c.b();
      localObject = this.ASO;
      if (localObject != null)
      {
        localq = (q)new c(this);
        k.h(localq, "callback");
        locale = ((com.tencent.mm.plugin.voip.video.c.b)localObject).gsd;
        if (locale != null) {
          locale.gVy = ((d.g.a.b)new b.a((com.tencent.mm.plugin.voip.video.c.b)localObject, localq));
        }
      }
      localObject = g.AMq;
      g.a.SP(2);
    }
    if ((this.ASO != null) && (this.AST))
    {
      paramInt1 = i;
      if (this.gVh == 90) {
        paramInt1 = 270;
      }
      this.gVh = paramInt1;
      if (this.gVi) {
        break label451;
      }
    }
    for (;;)
    {
      this.gVi = bool;
      this.gVm = 2;
      AppMethodBeat.o(208848);
      return;
      label451:
      bool = false;
    }
  }
  
  public final void no(int paramInt)
  {
    this.gWh = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(208854);
    super.release();
    Object localObject1 = this.ASN;
    if (localObject1 != null) {
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.c)localObject1).gse);
    }
    localObject1 = this.ASP;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((f)localObject1).gsd;
      if (localObject2 != null) {
        ((e)localObject2).release();
      }
      localObject2 = ((f)localObject1).gsb;
      if (localObject2 != null) {
        ((com.tencent.mm.media.f.d)localObject2).close();
      }
      localObject2 = ((f)localObject1).ARr;
      if (localObject2 != null)
      {
        localObject3 = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ac.i((String)localObject3, "clear %s %d", new Object[] { localObject2, Long.valueOf(localThread.getId()) });
      }
    }
    try
    {
      localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).gqY;
      if (localObject3 != null) {
        ((com.tencent.mm.media.f.d)localObject3).close();
      }
      if (((com.tencent.mm.plugin.voip.video.a.d)localObject2).fZP != null)
      {
        localObject3 = ((com.tencent.mm.plugin.voip.video.a.d)localObject2).fZP;
        if (localObject3 == null) {
          k.fOy();
        }
        ((XLabEffect)localObject3).destroy();
        ((com.tencent.mm.plugin.voip.video.a.d)localObject2).fZP = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "clear error: %s", new Object[] { localException.getMessage() });
      }
    }
    GLES20.glDeleteProgram(((f)localObject1).gse);
    localObject1 = this.ASO;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.voip.video.c.b)localObject1).gsd;
      if (localObject2 != null) {
        ((e)localObject2).release();
      }
      GLES20.glDeleteProgram(((com.tencent.mm.plugin.voip.video.c.b)localObject1).gse);
    }
    GLES20.glDeleteProgram(this.gse);
    AppMethodBeat.o(208854);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "(Ljava/nio/ByteBuffer;II)Lkotlin/Unit;"})
  static final class b
    extends d.g.b.l
    implements q<ByteBuffer, Integer, Integer, y>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "data", "Ljava/nio/ByteBuffer;", "width", "", "height", "invoke", "(Ljava/nio/ByteBuffer;II)Lkotlin/Unit;"})
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