package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.video.a.e;
import com.tencent.mm.plugin.xlabeffect.a;
import com.tencent.mm.plugin.xlabeffect.k.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTFilter", "setBeautyEnable", "enable", "", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a URu;
  public volatile e URv;
  public com.tencent.mm.media.g.d mWs;
  private int mWv;
  private int mWw;
  private int mWx;
  public int programId;
  
  static
  {
    AppMethodBeat.i(293261);
    URu = new k.a((byte)0);
    AppMethodBeat.o(293261);
  }
  
  public k()
  {
    AppMethodBeat.i(293229);
    com.tencent.mm.media.util.c.a locala = com.tencent.mm.media.util.c.nFs;
    this.programId = com.tencent.mm.media.util.c.a.aN("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.mWx = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    AppMethodBeat.o(293229);
  }
  
  private final void mN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293252);
    e locale;
    com.tencent.mm.media.g.d locald;
    if (this.mWs == null)
    {
      this.mWs = com.tencent.mm.media.g.c.d(true, 14L);
      this.URv = new e();
      locale = this.URv;
      if (locale != null)
      {
        locald = this.mWs;
        s.checkNotNull(locald);
        s.u(locald, "outputTexture");
      }
    }
    for (;;)
    {
      try
      {
        Log.i(e.TAG, "initial %s, %d, beauytParams:%s", new Object[] { locale, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt1) });
        if (locale.muW != null)
        {
          Log.w(e.TAG, "initial xLabEffect: again");
          localk = locale.muW;
          s.checkNotNull(localk);
          localk.destroy();
        }
        locale.muW = new com.tencent.mm.plugin.xlabeffect.k(0, 0, 1, false, true, 24);
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.Jo(false);
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.XLr.jFp = 4;
        i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTf, 0);
        int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTg, -1);
        int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTh, -1);
        int m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTi, -1);
        int n = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTj, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yTk, -1);
        Log.i(e.TAG, "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        localk = locale.muW;
        if (localk == null) {
          break label597;
        }
        localk.q(j, m, i1, k, n);
      }
      catch (Exception localException)
      {
        com.tencent.mm.plugin.xlabeffect.k localk;
        int i;
        Log.printErrStackTrace(e.TAG, (Throwable)localException, "initial error", new Object[0]);
      }
      Log.i(e.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.iGb();
      }
      if (bool2)
      {
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.Jm(true);
      }
      if (bool3)
      {
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.iGc();
        localk = locale.muW;
        s.checkNotNull(localk);
        localk.ao(true, i);
      }
      locale.mVb = paramInt2;
      locale.mVc = locald;
      Log.d(e.TAG, "initial end %s", new Object[] { locale });
      AppMethodBeat.o(293252);
      return;
      boolean bool1 = false;
      break label606;
      boolean bool2 = false;
      break label615;
      boolean bool3 = false;
      continue;
      AppMethodBeat.o(293252);
      return;
      label597:
      if ((paramInt1 & 0x1) != 0)
      {
        bool1 = true;
        label606:
        if ((paramInt1 & 0x2) != 0)
        {
          bool2 = true;
          label615:
          if ((paramInt1 & 0x4) != 0) {
            bool3 = true;
          }
        }
      }
    }
  }
  
  public final void Be(boolean paramBoolean)
  {
    AppMethodBeat.i(293269);
    Object localObject = this.URv;
    if ((localObject != null) && (paramBoolean != ((e)localObject).NQY))
    {
      ((e)localObject).NQY = paramBoolean;
      localObject = ((e)localObject).muW;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.k)localObject).Be(paramBoolean);
      }
    }
    AppMethodBeat.o(293269);
  }
  
  public final com.tencent.mm.media.g.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, int paramInt4, com.tencent.mm.media.g.d paramd, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(369828);
    s.u(paramFloatBuffer1, "cubeBuffer");
    s.u(paramFloatBuffer2, "textureCoordBuff");
    s.u(paramd, "outputTexture");
    label274:
    long l;
    if (paramInt4 != -1) {
      if (paramInt6 == 0)
      {
        GLES20.glUseProgram(this.programId);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, paramInt4);
        GLES20.glUniform1i(this.mWx, 0);
        paramFloatBuffer1.position(0);
        GLES20.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
        GLES20.glEnableVertexAttribArray(this.mWv);
        paramFloatBuffer2.position(0);
        GLES20.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
        GLES20.glEnableVertexAttribArray(this.mWw);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.mWv);
        GLES20.glDisableVertexAttribArray(this.mWw);
        GLES20.glBindTexture(36197, 0);
        GLES20.glBindFramebuffer(36160, 0);
        mN(paramInt5, paramd.nAF);
        paramFloatBuffer1 = this.URv;
        if (paramFloatBuffer1 != null)
        {
          if ((paramInt2 != paramFloatBuffer1.mVe) || (paramInt1 != paramFloatBuffer1.mVd)) {
            Log.i(e.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          }
          paramFloatBuffer1.mVd = paramInt1;
          paramFloatBuffer1.mVe = paramInt2;
          if (paramFloatBuffer1.muW != null)
          {
            paramFloatBuffer2 = paramFloatBuffer1.muW;
            s.checkNotNull(paramFloatBuffer2);
            paramFloatBuffer2.setSize(paramInt1, paramInt2);
          }
          if (paramInt6 != 0) {
            break label606;
          }
          paramFloatBuffer1.mVb = paramd.nAF;
          l = Util.currentTicks();
        }
      }
    }
    for (;;)
    {
      try
      {
        paramFloatBuffer2 = com.tencent.mm.plugin.voip.video.a.d.UPM;
        paramFloatBuffer2 = paramFloatBuffer1.muW;
        s.checkNotNull(paramFloatBuffer2);
        com.tencent.mm.plugin.voip.video.a.d.a(paramFloatBuffer2);
        paramFloatBuffer2 = com.tencent.mm.plugin.voip.video.a.d.UPM;
        paramInt1 = com.tencent.mm.plugin.voip.video.a.d.aNE(paramInt3);
        paramFloatBuffer2 = paramFloatBuffer1.muW;
        s.checkNotNull(paramFloatBuffer2);
        paramInt2 = paramFloatBuffer1.mVb;
        if (paramFloatBuffer2.iGe()) {
          paramFloatBuffer2.XLc.mVb = paramInt2;
        }
        switch (paramInt1)
        {
        case 90: 
          paramInt1 = k.h.akjC.ordinal();
          paramFloatBuffer2.akjo = paramInt1;
          paramFloatBuffer2.XLc.nDP = true;
          paramFloatBuffer2.XLc.bgE();
          paramd = paramFloatBuffer2.XLf;
          if (paramd != null) {
            paramd.invoke(Boolean.valueOf(paramFloatBuffer2.XLe));
          }
          paramFloatBuffer2.XLf = null;
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
          paramFloatBuffer2 = paramFloatBuffer1.mVc;
          s.checkNotNull(paramFloatBuffer2);
          paramFloatBuffer2.a(paramFloatBuffer1.mVd, paramFloatBuffer1.mVe, 6408, null, 9729, 10497);
          GLES20.glViewport(0, 0, paramFloatBuffer1.mVd, paramFloatBuffer1.mVe);
          paramFloatBuffer2 = paramFloatBuffer1.muW;
          s.checkNotNull(paramFloatBuffer2);
          paramInt1 = paramFloatBuffer1.mVb;
          paramFloatBuffer1 = paramFloatBuffer1.mVc;
          s.checkNotNull(paramFloatBuffer1);
          com.tencent.mm.plugin.xlabeffect.k.a(paramFloatBuffer2, paramInt1, paramFloatBuffer1.nAF, false, 8);
          GLES20.glBindFramebuffer(36160, 0);
          GLES20.glBindTexture(3553, 0);
        }
      }
      catch (Exception paramFloatBuffer1)
      {
        label606:
        Log.printErrStackTrace(e.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
        continue;
      }
      Log.d(e.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      paramFloatBuffer1 = this.mWs;
      AppMethodBeat.o(369828);
      return paramFloatBuffer1;
      mN(paramInt5, paramInt4);
      break;
      paramFloatBuffer1.mVb = paramInt4;
      break label274;
      paramInt1 = k.h.akjz.ordinal();
      continue;
      paramInt1 = k.h.akjA.ordinal();
      continue;
      paramInt1 = k.h.akjB.ordinal();
      continue;
      AppMethodBeat.o(369828);
      return paramd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.k
 * JD-Core Version:    0.7.0.1
 */