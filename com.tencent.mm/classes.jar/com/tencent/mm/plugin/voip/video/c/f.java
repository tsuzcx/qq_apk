package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "setRGBDataCallback", "callback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Companion", "plugin-voip_release"})
public final class f
{
  public static final f.a ARs;
  public volatile com.tencent.mm.plugin.voip.video.a.d ARr;
  public com.tencent.mm.media.f.d gsb;
  public e gsd;
  public int gse;
  private int gsf;
  private int gsg;
  private int gsh;
  
  static
  {
    AppMethodBeat.i(208733);
    ARs = new f.a((byte)0);
    AppMethodBeat.o(208733);
  }
  
  public f()
  {
    AppMethodBeat.i(208732);
    c.a locala = com.tencent.mm.media.j.c.gWJ;
    this.gse = c.a.ax("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gsf = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.gsg = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.gsh = GLES20.glGetUniformLocation(this.gse, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.gsd == null) {
      this.gsd = new e(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(208732);
  }
  
  public final com.tencent.mm.media.f.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.f.d paramd, int paramInt4)
  {
    AppMethodBeat.i(208731);
    k.h(paramFloatBuffer1, "cubeBuffer");
    k.h(paramFloatBuffer2, "textureCoordBuff");
    k.h(paramd, "outputTexture");
    if (paramInt3 != -1)
    {
      GLES20.glUseProgram(this.gse);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt3);
      GLES20.glUniform1i(this.gsh, 0);
      paramFloatBuffer1.position(0);
      GLES20.glVertexAttribPointer(this.gsf, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.gsf);
      paramFloatBuffer2.position(0);
      GLES20.glVertexAttribPointer(this.gsg, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
      GLES20.glEnableVertexAttribArray(this.gsg);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gsf);
      GLES20.glDisableVertexAttribArray(this.gsg);
      GLES20.glBindTexture(36197, 0);
      GLES20.glBindFramebuffer(36160, 0);
      paramInt3 = paramd.gRW;
      if ((paramInt4 != 0) && (this.gsb == null))
      {
        this.gsb = com.tencent.mm.media.f.c.a(true, 14L);
        this.ARr = new com.tencent.mm.plugin.voip.video.a.d();
        paramFloatBuffer1 = this.ARr;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer2 = this.gsb;
          if (paramFloatBuffer2 == null) {
            k.fOy();
          }
          k.h(paramFloatBuffer2, "outputTexture");
        }
      }
    }
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      try
      {
        localObject = com.tencent.mm.plugin.voip.video.a.d.TAG;
        Thread localThread = Thread.currentThread();
        k.g(localThread, "Thread.currentThread()");
        ac.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { paramFloatBuffer1, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt4) });
        if (paramFloatBuffer1.fZP != null)
        {
          ac.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = paramFloatBuffer1.fZP;
          if (localObject == null) {
            k.fOy();
          }
          ((XLabEffect)localObject).destroy();
        }
        paramFloatBuffer1.fZP = new XLabEffect(0, 0, 1, false, 8);
        localObject = paramFloatBuffer1.fZP;
        if (localObject == null) {
          k.fOy();
        }
        ((XLabEffect)localObject).uQ(false);
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
        ac.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "initial error", new Object[0]);
        continue;
      }
      ac.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if (bool1)
      {
        localObject = paramFloatBuffer1.fZP;
        if (localObject == null) {
          k.fOy();
        }
        ((XLabEffect)localObject).eJq();
      }
      if (bool2)
      {
        localObject = paramFloatBuffer1.fZP;
        if (localObject == null) {
          k.fOy();
        }
        ((XLabEffect)localObject).eJr();
      }
      if (bool3)
      {
        localObject = paramFloatBuffer1.fZP;
        if (localObject == null) {
          k.fOy();
        }
        ((XLabEffect)localObject).uP(true);
      }
      paramFloatBuffer1.gqX = paramInt3;
      paramFloatBuffer1.gqY = paramFloatBuffer2;
      ac.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { paramFloatBuffer1 });
      paramFloatBuffer1 = this.ARr;
      if (paramFloatBuffer1 != null)
      {
        if ((paramInt2 != paramFloatBuffer1.gra) || (paramInt1 != paramFloatBuffer1.gqZ)) {
          ac.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        paramFloatBuffer1.gqZ = paramInt1;
        paramFloatBuffer1.gra = paramInt2;
        if (paramFloatBuffer1.fZP != null)
        {
          paramFloatBuffer2 = paramFloatBuffer1.fZP;
          if (paramFloatBuffer2 == null) {
            k.fOy();
          }
          paramFloatBuffer2.setSize(paramInt1, paramInt2);
        }
        paramFloatBuffer1.gqX = paramd.gRW;
        l = bs.Gn();
      }
      try
      {
        paramFloatBuffer2 = paramFloatBuffer1.fZP;
        if (paramFloatBuffer2 == null) {
          k.fOy();
        }
        XLabEffect.a(paramFloatBuffer2, paramFloatBuffer1.gqX);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        paramFloatBuffer2 = paramFloatBuffer1.gqY;
        if (paramFloatBuffer2 == null) {
          k.fOy();
        }
        paramFloatBuffer2.a(paramFloatBuffer1.gqZ, paramFloatBuffer1.gra, 6408, null, 9729, 10497);
        GLES20.glViewport(0, 0, paramFloatBuffer1.gqZ, paramFloatBuffer1.gra);
        paramFloatBuffer2 = paramFloatBuffer1.fZP;
        if (paramFloatBuffer2 == null) {
          k.fOy();
        }
        paramInt3 = paramFloatBuffer1.gqX;
        paramFloatBuffer1 = paramFloatBuffer1.gqY;
        if (paramFloatBuffer1 == null) {
          k.fOy();
        }
        XLabEffect.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.gRW, 0L, false, 8);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception paramFloatBuffer1)
      {
        ac.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
        continue;
        paramFloatBuffer1 = null;
        continue;
      }
      ac.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bs.aO(l)) });
      paramFloatBuffer2 = this.gsd;
      if (paramFloatBuffer2 != null)
      {
        paramFloatBuffer2.mE(90);
        paramFloatBuffer2.gVi = true;
        paramFloatBuffer1 = this.gsb;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.gRW);
          if (paramFloatBuffer1 == null) {
            k.fOy();
          }
          paramFloatBuffer2.gqX = paramFloatBuffer1.intValue();
          paramFloatBuffer2.cS(paramInt1, paramInt2);
          paramFloatBuffer2.cR(paramInt2, paramInt1);
          paramFloatBuffer2.cU(paramInt2, paramInt1);
          paramFloatBuffer2.gVz = true;
          paramFloatBuffer2.ajG();
        }
      }
      else
      {
        paramFloatBuffer1 = this.gsb;
        AppMethodBeat.o(208731);
        return paramFloatBuffer1;
        bool1 = false;
        break label946;
        bool2 = false;
        break label956;
        bool3 = false;
        continue;
      }
      AppMethodBeat.o(208731);
      return paramd;
      label946:
      if ((paramInt4 & 0x2) != 0)
      {
        bool2 = true;
        label956:
        if ((paramInt4 & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setRGBDataCallback$1$1"})
  public static final class b
    extends d.g.b.l
    implements b<ByteBuffer, y>
  {
    public b(f paramf, q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.f
 * JD-Core Version:    0.7.0.1
 */