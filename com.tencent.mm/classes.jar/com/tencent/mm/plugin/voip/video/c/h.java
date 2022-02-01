package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.voip.video.render.EncoderSurfaceRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.r;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "setFaceBeautyDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "Companion", "plugin-voip_release"})
public final class h
{
  public static final h.a Crd;
  public EncoderSurfaceRender CqU;
  public final boolean CqV;
  public volatile com.tencent.mm.plugin.voip.video.a.d Crc;
  public com.tencent.mm.media.g.d gLJ;
  public e gLL;
  public int gLM;
  private int gLN;
  private int gLO;
  private int gLP;
  
  static
  {
    AppMethodBeat.i(216081);
    Crd = new h.a((byte)0);
    AppMethodBeat.o(216081);
  }
  
  public h()
  {
    AppMethodBeat.i(216080);
    Object localObject = com.tencent.mm.plugin.voip.b.h.Cls;
    this.CqV = com.tencent.mm.plugin.voip.b.h.ezG();
    localObject = com.tencent.mm.media.k.c.hoP;
    this.gLM = c.a.ay("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.gLP = GLES20.glGetUniformLocation(this.gLM, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.CqV)
    {
      this.CqU = new EncoderSurfaceRender();
      AppMethodBeat.o(216080);
      return;
    }
    this.gLL = new e(0, 0, 0, 0, 2, 0, 32);
    AppMethodBeat.o(216080);
  }
  
  public final com.tencent.mm.media.g.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.g.d paramd, int paramInt4)
  {
    AppMethodBeat.i(216079);
    p.h(paramFloatBuffer1, "cubeBuffer");
    p.h(paramFloatBuffer2, "textureCoordBuff");
    p.h(paramd, "outputTexture");
    if (paramInt3 != -1)
    {
      GLES20.glUseProgram(this.gLM);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt3);
      GLES20.glUniform1i(this.gLP, 0);
      paramFloatBuffer1.position(0);
      GLES20.glVertexAttribPointer(this.gLN, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.gLN);
      paramFloatBuffer2.position(0);
      GLES20.glVertexAttribPointer(this.gLO, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
      GLES20.glEnableVertexAttribArray(this.gLO);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gLN);
      GLES20.glDisableVertexAttribArray(this.gLO);
      GLES20.glBindTexture(36197, 0);
      GLES20.glBindFramebuffer(36160, 0);
      paramInt3 = paramd.hko;
      if ((paramInt4 != 0) && (this.gLJ == null))
      {
        this.gLJ = com.tencent.mm.media.g.c.a(true, 14L);
        this.Crc = new com.tencent.mm.plugin.voip.video.a.d();
        paramFloatBuffer1 = this.Crc;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer2 = this.gLJ;
          if (paramFloatBuffer2 == null) {
            p.gfZ();
          }
          p.h(paramFloatBuffer2, "outputTexture");
        }
      }
    }
    label1026:
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      try
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { paramFloatBuffer1, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt4) });
        if (paramFloatBuffer1.gtl != null)
        {
          ad.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = paramFloatBuffer1.gtl;
          if (localObject == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
        }
        paramFloatBuffer1.gtl = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 1, 8);
        localObject = paramFloatBuffer1.gtl;
        if (localObject == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vB(false);
        if ((paramInt4 & 0x1) == 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramFloatBuffer1)
      {
        Object localObject;
        boolean bool1;
        long l;
        ad.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "initial error", new Object[0]);
        continue;
      }
      ad.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localObject = paramFloatBuffer1.gtl;
        if (localObject == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).eYk();
      }
      if (bool2)
      {
        localObject = paramFloatBuffer1.gtl;
        if (localObject == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).eYl();
      }
      if (bool3)
      {
        localObject = paramFloatBuffer1.gtl;
        if (localObject == null) {
          p.gfZ();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).vA(true);
      }
      paramFloatBuffer1.gKH = paramInt3;
      paramFloatBuffer1.gKI = paramFloatBuffer2;
      ad.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { paramFloatBuffer1 });
      paramFloatBuffer1 = this.Crc;
      if (paramFloatBuffer1 != null)
      {
        if ((paramInt2 != paramFloatBuffer1.gKK) || (paramInt1 != paramFloatBuffer1.gKJ)) {
          ad.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        paramFloatBuffer1.gKJ = paramInt1;
        paramFloatBuffer1.gKK = paramInt2;
        if (paramFloatBuffer1.gtl != null)
        {
          paramFloatBuffer2 = paramFloatBuffer1.gtl;
          if (paramFloatBuffer2 == null) {
            p.gfZ();
          }
          paramFloatBuffer2.setSize(paramInt1, paramInt2);
        }
        paramFloatBuffer1.gKH = paramd.hko;
        l = bt.HI();
      }
      try
      {
        paramFloatBuffer2 = paramFloatBuffer1.gtl;
        if (paramFloatBuffer2 == null) {
          p.gfZ();
        }
        com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramFloatBuffer1.gKH);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        paramFloatBuffer2 = paramFloatBuffer1.gKI;
        if (paramFloatBuffer2 == null) {
          p.gfZ();
        }
        paramFloatBuffer2.a(paramFloatBuffer1.gKJ, paramFloatBuffer1.gKK, 6408, null, 9729, 10497);
        GLES20.glViewport(0, 0, paramFloatBuffer1.gKJ, paramFloatBuffer1.gKK);
        paramFloatBuffer2 = paramFloatBuffer1.gtl;
        if (paramFloatBuffer2 == null) {
          p.gfZ();
        }
        paramInt3 = paramFloatBuffer1.gKH;
        paramFloatBuffer1 = paramFloatBuffer1.gKI;
        if (paramFloatBuffer1 == null) {
          p.gfZ();
        }
        com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.hko, false, 8);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception paramFloatBuffer1)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
        continue;
        paramFloatBuffer1 = null;
        continue;
        paramFloatBuffer2 = this.gLL;
        if (paramFloatBuffer2 == null) {
          continue;
        }
        paramFloatBuffer2.nd(90);
        paramFloatBuffer2.hnl = true;
        paramFloatBuffer1 = this.gLJ;
        if (paramFloatBuffer1 == null) {
          break label1003;
        }
      }
      ad.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aO(l)) });
      if (this.CqV)
      {
        paramFloatBuffer2 = this.CqU;
        if (paramFloatBuffer2 != null)
        {
          paramFloatBuffer1 = this.gLJ;
          if (paramFloatBuffer1 != null)
          {
            paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.hko);
            if (paramFloatBuffer1 == null) {
              p.gfZ();
            }
            paramFloatBuffer2.BHZ = paramFloatBuffer1.intValue();
            paramFloatBuffer2.iA(paramInt1, paramInt2);
            paramFloatBuffer2.requestRender();
          }
        }
        else
        {
          paramFloatBuffer1 = this.gLJ;
          AppMethodBeat.o(216079);
          return paramFloatBuffer1;
          bool1 = false;
          break label1016;
          bool2 = false;
          break label1026;
          bool3 = false;
          continue;
        }
      }
      label1003:
      for (paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.hko);; paramFloatBuffer1 = null)
      {
        if (paramFloatBuffer1 == null) {
          p.gfZ();
        }
        paramFloatBuffer2.gKH = paramFloatBuffer1.intValue();
        paramFloatBuffer2.cU(paramInt1, paramInt2);
        paramFloatBuffer2.cT(paramInt2, paramInt1);
        paramFloatBuffer2.cW(paramInt2, paramInt1);
        paramFloatBuffer2.hnD = true;
        paramFloatBuffer2.ams();
        break;
      }
      AppMethodBeat.o(216079);
      return paramd;
      label1016:
      if ((paramInt4 & 0x2) != 0)
      {
        bool2 = true;
        if ((paramInt4 & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setFaceBeautyDataCallback$1$1"})
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