package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qg;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTFilter", "encodeRotate", "encodeMirror", "setFaceBeautyDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "Companion", "plugin-voip_release"})
public final class j
{
  public static final a Odv;
  public volatile com.tencent.mm.plugin.voip.video.a.d Odu;
  public com.tencent.mm.plugin.voip.video.render.b QQT;
  public final boolean QQU;
  public com.tencent.mm.media.g.d ksA;
  public com.tencent.mm.media.j.b.e ksC;
  private int ksD;
  private int ksE;
  private int ksF;
  public int programId;
  
  static
  {
    AppMethodBeat.i(242890);
    Odv = new a((byte)0);
    AppMethodBeat.o(242890);
  }
  
  public j()
  {
    AppMethodBeat.i(242889);
    Object localObject = g.NXO;
    this.QQU = g.gCH();
    localObject = com.tencent.mm.media.k.c.lar;
    this.programId = c.a.aE("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.ksD = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.ksE = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ksF = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.QQU)
    {
      this.QQT = new com.tencent.mm.plugin.voip.video.render.b();
      AppMethodBeat.o(242889);
      return;
    }
    this.ksC = new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 2, 0, 32);
    AppMethodBeat.o(242889);
  }
  
  private final void lb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242887);
    com.tencent.mm.plugin.voip.video.a.d locald;
    com.tencent.mm.media.g.d locald1;
    if ((paramInt1 != 0) && (this.ksA == null))
    {
      this.ksA = com.tencent.mm.media.g.c.a(true, 14L);
      this.Odu = new com.tencent.mm.plugin.voip.video.a.d();
      locald = this.Odu;
      if (locald != null)
      {
        locald1 = this.ksA;
        if (locald1 == null) {
          p.iCn();
        }
        p.k(locald1, "outputTexture");
      }
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.j(localThread, "Thread.currentThread()");
        Log.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { locald, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt1) });
        if (locald.jUF != null)
        {
          Log.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = locald.jUF;
          if (localObject == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.xlabeffect.e)localObject).destroy();
        }
        locald.jUF = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 1);
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DH(false);
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).QPZ.oZ(4);
        i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDY, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDZ, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEa, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEb, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEc, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEd, -1);
        Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        localObject = locald.jUF;
        if (localObject == null) {
          break label650;
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).o(j, m, i1, k, n);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "initial error", new Object[0]);
        AppMethodBeat.o(242887);
        return;
      }
      Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).hfa();
      }
      if (bool2)
      {
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).DF(true);
      }
      if (bool3)
      {
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).hfb();
        localObject = locald.jUF;
        if (localObject == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.xlabeffect.e)localObject).an(true, i);
      }
      locald.kre = paramInt2;
      locald.krf = locald1;
      Log.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { locald });
      AppMethodBeat.o(242887);
      return;
      boolean bool1 = false;
      break label659;
      boolean bool2 = false;
      break label668;
      boolean bool3 = false;
      continue;
      AppMethodBeat.o(242887);
      return;
      label650:
      if ((paramInt1 & 0x1) != 0)
      {
        bool1 = true;
        label659:
        if ((paramInt1 & 0x2) != 0)
        {
          bool2 = true;
          label668:
          if ((paramInt1 & 0x4) != 0) {
            bool3 = true;
          }
        }
      }
    }
  }
  
  public final com.tencent.mm.media.g.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.g.d paramd, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(293198);
    p.k(paramFloatBuffer1, "cubeBuffer");
    p.k(paramFloatBuffer2, "textureCoordBuff");
    p.k(paramd, "outputTexture");
    label541:
    label669:
    if (paramInt3 != -1)
    {
      if (paramInt5 == 0)
      {
        GLES20.glUseProgram(this.programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramInt3);
        GLES20.glUniform1i(this.ksF, 0);
        paramFloatBuffer1.position(0);
        GLES20.glVertexAttribPointer(this.ksD, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
        GLES20.glEnableVertexAttribArray(this.ksD);
        paramFloatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.ksE, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
        GLES20.glEnableVertexAttribArray(this.ksE);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.ksD);
        GLES20.glDisableVertexAttribArray(this.ksE);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        lb(paramInt4, paramd.kVj);
        paramFloatBuffer1 = this.Odu;
        if (paramFloatBuffer1 != null)
        {
          if ((paramInt2 != paramFloatBuffer1.krh) || (paramInt1 != paramFloatBuffer1.krg)) {
            Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
          paramFloatBuffer1.krg = paramInt1;
          paramFloatBuffer1.krh = paramInt2;
          if (paramFloatBuffer1.jUF != null)
          {
            paramFloatBuffer2 = paramFloatBuffer1.jUF;
            if (paramFloatBuffer2 == null) {
              p.iCn();
            }
            paramFloatBuffer2.setSize(paramInt1, paramInt2);
          }
          if (paramInt5 != 0) {
            break label541;
          }
        }
      }
      for (paramFloatBuffer1.kre = paramd.kVj;; paramFloatBuffer1.kre = paramInt3)
      {
        long l = Util.currentTicks();
        try
        {
          paramFloatBuffer2 = paramFloatBuffer1.jUF;
          if (paramFloatBuffer2 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.xlabeffect.e.a(paramFloatBuffer2, paramFloatBuffer1.kre);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          paramFloatBuffer2 = paramFloatBuffer1.krf;
          if (paramFloatBuffer2 == null) {
            p.iCn();
          }
          paramFloatBuffer2.a(paramFloatBuffer1.krg, paramFloatBuffer1.krh, 6408, null, 9729, 10497);
          GLES20.glViewport(0, 0, paramFloatBuffer1.krg, paramFloatBuffer1.krh);
          paramFloatBuffer2 = paramFloatBuffer1.jUF;
          if (paramFloatBuffer2 == null) {
            p.iCn();
          }
          paramInt3 = paramFloatBuffer1.kre;
          paramFloatBuffer1 = paramFloatBuffer1.krf;
          if (paramFloatBuffer1 == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.xlabeffect.e.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.kVj, false, 8);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
        }
        catch (Exception paramFloatBuffer1)
        {
          do
          {
            for (;;)
            {
              Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
              continue;
              paramFloatBuffer1 = null;
            }
            paramFloatBuffer2 = this.ksC;
          } while (paramFloatBuffer2 == null);
          paramFloatBuffer2.tm(paramInt6);
          paramFloatBuffer2.kYh = paramBoolean;
          paramFloatBuffer1 = this.ksA;
          if (paramFloatBuffer1 == null) {
            break label669;
          }
        }
        Log.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        if (!this.QQU) {
          break label576;
        }
        paramFloatBuffer2 = this.QQT;
        if (paramFloatBuffer2 != null)
        {
          paramFloatBuffer1 = this.ksA;
          if (paramFloatBuffer1 == null) {
            break label571;
          }
          paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.kVj);
          if (paramFloatBuffer1 == null) {
            p.iCn();
          }
          paramFloatBuffer2.NkK = paramFloatBuffer1.intValue();
          paramFloatBuffer2.ku(paramInt1, paramInt2);
          paramFloatBuffer2.requestRender();
        }
        paramFloatBuffer1 = this.ksA;
        AppMethodBeat.o(293198);
        return paramFloatBuffer1;
        lb(paramInt4, paramInt3);
        break;
      }
      label571:
      label576:
      for (paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.kVj);; paramFloatBuffer1 = null)
      {
        if (paramFloatBuffer1 == null) {
          p.iCn();
        }
        paramFloatBuffer2.kre = paramFloatBuffer1.intValue();
        paramFloatBuffer2.dv(paramInt1, paramInt2);
        paramFloatBuffer2.du(paramInt2, paramInt1);
        paramFloatBuffer2.dy(paramInt2, paramInt1);
        paramFloatBuffer2.kYH = true;
        paramFloatBuffer2.aMU();
        break;
      }
    }
    AppMethodBeat.o(293198);
    return paramd;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.j
 * JD-Core Version:    0.7.0.1
 */