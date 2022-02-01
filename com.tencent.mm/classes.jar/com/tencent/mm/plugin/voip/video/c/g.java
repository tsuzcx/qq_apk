package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.video.render.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTFilter", "encodeRotate", "encodeMirror", "setFaceBeautyDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a HmI;
  public volatile com.tencent.mm.plugin.voip.video.a.d HmH;
  public a Hms;
  public final boolean Hmt;
  private int hEA;
  public com.tencent.mm.media.g.d hEv;
  public e hEx;
  private int hEy;
  private int hEz;
  public int programId;
  
  static
  {
    AppMethodBeat.i(236183);
    HmI = new g.a((byte)0);
    AppMethodBeat.o(236183);
  }
  
  public g()
  {
    AppMethodBeat.i(236182);
    Object localObject = com.tencent.mm.plugin.voip.b.g.HgZ;
    this.Hmt = com.tencent.mm.plugin.voip.b.g.fKi();
    localObject = com.tencent.mm.media.k.c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.Hmt)
    {
      this.Hms = new a();
      AppMethodBeat.o(236182);
      return;
    }
    this.hEx = new e(0, 0, 0, 0, 2, 0, 32);
    AppMethodBeat.o(236182);
  }
  
  private final void jL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236180);
    com.tencent.mm.plugin.voip.video.a.d locald;
    com.tencent.mm.media.g.d locald1;
    if ((paramInt1 != 0) && (this.hEv == null))
    {
      this.hEv = com.tencent.mm.media.g.c.a(true, 14L);
      this.HmH = new com.tencent.mm.plugin.voip.video.a.d();
      locald = this.HmH;
      if (locald != null)
      {
        locald1 = this.hEv;
        if (locald1 == null) {
          p.hyc();
        }
        p.h(locald1, "outputTexture");
      }
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        Log.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { locald, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt1) });
        if (locald.hiH != null)
        {
          Log.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = locald.hiH;
          if (localObject == null) {
            p.hyc();
          }
          ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
        }
        locald.hiH = new com.tencent.mm.plugin.xlabeffect.b(0, 0);
        localObject = locald.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).zG(false);
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXh, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXi, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXj, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXk, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXl, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXm, -1);
        Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        localObject = locald.hiH;
        if (localObject == null) {
          break label617;
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).l(j, m, i1, k, n);
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)localException, "initial error", new Object[0]);
        AppMethodBeat.o(236180);
        return;
      }
      Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localObject = locald.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).glh();
      }
      if (bool2)
      {
        localObject = locald.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).glj();
      }
      if (bool3)
      {
        localObject = locald.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).gll();
        localObject = locald.hiH;
        if (localObject == null) {
          p.hyc();
        }
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).aa(true, i);
      }
      locald.hDl = paramInt2;
      locald.hDm = locald1;
      Log.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { locald });
      AppMethodBeat.o(236180);
      return;
      boolean bool1 = false;
      break label626;
      boolean bool2 = false;
      break label635;
      boolean bool3 = false;
      continue;
      AppMethodBeat.o(236180);
      return;
      label617:
      if ((paramInt1 & 0x1) != 0)
      {
        bool1 = true;
        label626:
        if ((paramInt1 & 0x2) != 0)
        {
          bool2 = true;
          label635:
          if ((paramInt1 & 0x4) != 0) {
            bool3 = true;
          }
        }
      }
    }
  }
  
  public final com.tencent.mm.media.g.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.g.d paramd, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    AppMethodBeat.i(236181);
    p.h(paramFloatBuffer1, "cubeBuffer");
    p.h(paramFloatBuffer2, "textureCoordBuff");
    p.h(paramd, "outputTexture");
    label541:
    label669:
    if (paramInt3 != -1)
    {
      if (paramInt5 == 0)
      {
        GLES20.glUseProgram(this.programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramInt3);
        GLES20.glUniform1i(this.hEA, 0);
        paramFloatBuffer1.position(0);
        GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
        GLES20.glEnableVertexAttribArray(this.hEy);
        paramFloatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
        GLES20.glEnableVertexAttribArray(this.hEz);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.hEy);
        GLES20.glDisableVertexAttribArray(this.hEz);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        jL(paramInt4, paramd.igv);
        paramFloatBuffer1 = this.HmH;
        if (paramFloatBuffer1 != null)
        {
          if ((paramInt2 != paramFloatBuffer1.hDo) || (paramInt1 != paramFloatBuffer1.hDn)) {
            Log.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
          paramFloatBuffer1.hDn = paramInt1;
          paramFloatBuffer1.hDo = paramInt2;
          if (paramFloatBuffer1.hiH != null)
          {
            paramFloatBuffer2 = paramFloatBuffer1.hiH;
            if (paramFloatBuffer2 == null) {
              p.hyc();
            }
            paramFloatBuffer2.setSize(paramInt1, paramInt2);
          }
          if (paramInt5 != 0) {
            break label541;
          }
        }
      }
      for (paramFloatBuffer1.hDl = paramd.igv;; paramFloatBuffer1.hDl = paramInt3)
      {
        long l = Util.currentTicks();
        try
        {
          paramFloatBuffer2 = paramFloatBuffer1.hiH;
          if (paramFloatBuffer2 == null) {
            p.hyc();
          }
          com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramFloatBuffer1.hDl);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          paramFloatBuffer2 = paramFloatBuffer1.hDm;
          if (paramFloatBuffer2 == null) {
            p.hyc();
          }
          paramFloatBuffer2.a(paramFloatBuffer1.hDn, paramFloatBuffer1.hDo, 6408, null, 9729, 10497);
          GLES20.glViewport(0, 0, paramFloatBuffer1.hDn, paramFloatBuffer1.hDo);
          paramFloatBuffer2 = paramFloatBuffer1.hiH;
          if (paramFloatBuffer2 == null) {
            p.hyc();
          }
          paramInt3 = paramFloatBuffer1.hDl;
          paramFloatBuffer1 = paramFloatBuffer1.hDm;
          if (paramFloatBuffer1 == null) {
            p.hyc();
          }
          com.tencent.mm.plugin.xlabeffect.b.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.igv, false, 8);
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
            paramFloatBuffer2 = this.hEx;
          } while (paramFloatBuffer2 == null);
          paramFloatBuffer2.qx(paramInt6);
          paramFloatBuffer2.iju = paramBoolean;
          paramFloatBuffer1 = this.hEv;
          if (paramFloatBuffer1 == null) {
            break label669;
          }
        }
        Log.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        if (!this.Hmt) {
          break label576;
        }
        paramFloatBuffer2 = this.Hms;
        if (paramFloatBuffer2 != null)
        {
          paramFloatBuffer1 = this.hEv;
          if (paramFloatBuffer1 == null) {
            break label571;
          }
          paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.igv);
          if (paramFloatBuffer1 == null) {
            p.hyc();
          }
          paramFloatBuffer2.Gxi = paramFloatBuffer1.intValue();
          paramFloatBuffer2.jj(paramInt1, paramInt2);
          paramFloatBuffer2.requestRender();
        }
        paramFloatBuffer1 = this.hEv;
        AppMethodBeat.o(236181);
        return paramFloatBuffer1;
        jL(paramInt4, paramInt3);
        break;
      }
      label571:
      label576:
      for (paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.igv);; paramFloatBuffer1 = null)
      {
        if (paramFloatBuffer1 == null) {
          p.hyc();
        }
        paramFloatBuffer2.hDl = paramFloatBuffer1.intValue();
        paramFloatBuffer2.cZ(paramInt1, paramInt2);
        paramFloatBuffer2.cY(paramInt2, paramInt1);
        paramFloatBuffer2.dc(paramInt2, paramInt1);
        paramFloatBuffer2.ijM = true;
        paramFloatBuffer2.aED();
        break;
      }
    }
    AppMethodBeat.o(236181);
    return paramd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setFaceBeautyDataCallback$1$1"})
  public static final class b
    extends q
    implements kotlin.g.a.b<ByteBuffer, x>
  {
    public b(g paramg, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.g
 * JD-Core Version:    0.7.0.1
 */