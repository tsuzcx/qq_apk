package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "setFaceBeautyDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "Companion", "plugin-voip_release"})
public final class h
{
  public static final h.a CIH;
  public volatile com.tencent.mm.plugin.voip.video.a.d CIG;
  public EncoderSurfaceRender CIy;
  public final boolean CIz;
  public com.tencent.mm.media.g.d gOs;
  public e gOu;
  public int gOv;
  private int gOw;
  private int gOx;
  private int gOy;
  
  static
  {
    AppMethodBeat.i(210502);
    CIH = new h.a((byte)0);
    AppMethodBeat.o(210502);
  }
  
  public h()
  {
    AppMethodBeat.i(210501);
    Object localObject = com.tencent.mm.plugin.voip.b.h.CCW;
    this.CIz = com.tencent.mm.plugin.voip.b.h.eDo();
    localObject = com.tencent.mm.media.k.c.hrD;
    this.gOv = c.a.az("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gOw = GLES20.glGetAttribLocation(this.gOv, "a_position");
    this.gOx = GLES20.glGetAttribLocation(this.gOv, "a_texCoord");
    this.gOy = GLES20.glGetUniformLocation(this.gOv, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.CIz)
    {
      this.CIy = new EncoderSurfaceRender();
      AppMethodBeat.o(210501);
      return;
    }
    this.gOu = new e(0, 0, 0, 0, 2, 0, 32);
    AppMethodBeat.o(210501);
  }
  
  public final com.tencent.mm.media.g.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.g.d paramd, int paramInt4)
  {
    AppMethodBeat.i(210500);
    p.h(paramFloatBuffer1, "cubeBuffer");
    p.h(paramFloatBuffer2, "textureCoordBuff");
    p.h(paramd, "outputTexture");
    if (paramInt3 != -1)
    {
      GLES20.glUseProgram(this.gOv);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt3);
      GLES20.glUniform1i(this.gOy, 0);
      paramFloatBuffer1.position(0);
      GLES20.glVertexAttribPointer(this.gOw, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.gOw);
      paramFloatBuffer2.position(0);
      GLES20.glVertexAttribPointer(this.gOx, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
      GLES20.glEnableVertexAttribArray(this.gOx);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gOw);
      GLES20.glDisableVertexAttribArray(this.gOx);
      GLES20.glBindTexture(36197, 0);
      GLES20.glBindFramebuffer(36160, 0);
      paramInt3 = paramd.hnc;
      if ((paramInt4 != 0) && (this.gOs == null))
      {
        this.gOs = com.tencent.mm.media.g.c.a(true, 14L);
        this.CIG = new com.tencent.mm.plugin.voip.video.a.d();
        paramFloatBuffer1 = this.CIG;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer2 = this.gOs;
          if (paramFloatBuffer2 == null) {
            p.gkB();
          }
          p.h(paramFloatBuffer2, "outputTexture");
        }
      }
    }
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      try
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ae.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { paramFloatBuffer1, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt4) });
        if (paramFloatBuffer1.gvS != null)
        {
          ae.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = paramFloatBuffer1.gvS;
          if (localObject == null) {
            p.gkB();
          }
          ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
        }
        paramFloatBuffer1.gvS = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 1, 8);
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vJ(false);
        i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEd, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEe, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEf, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEg, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEh, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEi, -1);
        ae.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          break label1235;
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).k(j, m, i1, k, n);
      }
      catch (Exception paramFloatBuffer1)
      {
        Object localObject;
        int i;
        long l;
        ae.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "initial error", new Object[0]);
        continue;
      }
      ae.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).fbW();
      }
      if (bool2)
      {
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).fbX();
      }
      if (bool3)
      {
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).fbY();
        localObject = paramFloatBuffer1.gvS;
        if (localObject == null) {
          p.gkB();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).Y(true, i);
      }
      paramFloatBuffer1.gNq = paramInt3;
      paramFloatBuffer1.gNr = paramFloatBuffer2;
      ae.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { paramFloatBuffer1 });
      paramFloatBuffer1 = this.CIG;
      if (paramFloatBuffer1 != null)
      {
        if ((paramInt2 != paramFloatBuffer1.gNt) || (paramInt1 != paramFloatBuffer1.gNs)) {
          ae.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        paramFloatBuffer1.gNs = paramInt1;
        paramFloatBuffer1.gNt = paramInt2;
        if (paramFloatBuffer1.gvS != null)
        {
          paramFloatBuffer2 = paramFloatBuffer1.gvS;
          if (paramFloatBuffer2 == null) {
            p.gkB();
          }
          paramFloatBuffer2.setSize(paramInt1, paramInt2);
        }
        paramFloatBuffer1.gNq = paramd.hnc;
        l = bu.HQ();
      }
      try
      {
        paramFloatBuffer2 = paramFloatBuffer1.gvS;
        if (paramFloatBuffer2 == null) {
          p.gkB();
        }
        com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramFloatBuffer1.gNq);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        paramFloatBuffer2 = paramFloatBuffer1.gNr;
        if (paramFloatBuffer2 == null) {
          p.gkB();
        }
        paramFloatBuffer2.a(paramFloatBuffer1.gNs, paramFloatBuffer1.gNt, 6408, null, 9729, 10497);
        GLES20.glViewport(0, 0, paramFloatBuffer1.gNs, paramFloatBuffer1.gNt);
        paramFloatBuffer2 = paramFloatBuffer1.gvS;
        if (paramFloatBuffer2 == null) {
          p.gkB();
        }
        paramInt3 = paramFloatBuffer1.gNq;
        paramFloatBuffer1 = paramFloatBuffer1.gNr;
        if (paramFloatBuffer1 == null) {
          p.gkB();
        }
        com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.hnc, false, 8);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception paramFloatBuffer1)
      {
        ae.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
        continue;
        paramFloatBuffer1 = null;
        continue;
        paramFloatBuffer2 = this.gOu;
        if (paramFloatBuffer2 == null) {
          continue;
        }
        paramFloatBuffer2.ng(90);
        paramFloatBuffer2.hpZ = true;
        paramFloatBuffer1 = this.gOs;
        if (paramFloatBuffer1 == null) {
          break label1222;
        }
      }
      ae.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bu.aO(l)) });
      if (this.CIz)
      {
        paramFloatBuffer2 = this.CIy;
        if (paramFloatBuffer2 != null)
        {
          paramFloatBuffer1 = this.gOs;
          if (paramFloatBuffer1 != null)
          {
            paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.hnc);
            if (paramFloatBuffer1 == null) {
              p.gkB();
            }
            paramFloatBuffer2.BZy = paramFloatBuffer1.intValue();
            paramFloatBuffer2.iE(paramInt1, paramInt2);
            paramFloatBuffer2.requestRender();
          }
        }
        else
        {
          paramFloatBuffer1 = this.gOs;
          AppMethodBeat.o(210500);
          return paramFloatBuffer1;
          bool1 = false;
          break label1245;
          bool2 = false;
          break label1255;
          bool3 = false;
          continue;
        }
      }
      label1222:
      for (paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.hnc);; paramFloatBuffer1 = null)
      {
        if (paramFloatBuffer1 == null) {
          p.gkB();
        }
        paramFloatBuffer2.gNq = paramFloatBuffer1.intValue();
        paramFloatBuffer2.cU(paramInt1, paramInt2);
        paramFloatBuffer2.cT(paramInt2, paramInt1);
        paramFloatBuffer2.cW(paramInt2, paramInt1);
        paramFloatBuffer2.hqr = true;
        paramFloatBuffer2.amH();
        break;
      }
      AppMethodBeat.o(210500);
      return paramd;
      label1235:
      if ((paramInt4 & 0x1) != 0)
      {
        bool1 = true;
        label1245:
        if ((paramInt4 & 0x2) != 0)
        {
          bool2 = true;
          label1255:
          if ((paramInt4 & 0x4) != 0) {
            bool3 = true;
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setFaceBeautyDataCallback$1$1"})
  public static final class b
    extends q
    implements d.g.a.b<ByteBuffer, z>
  {
    public b(h paramh, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.h
 * JD-Core Version:    0.7.0.1
 */