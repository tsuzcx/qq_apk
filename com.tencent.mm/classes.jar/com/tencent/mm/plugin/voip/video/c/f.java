package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.a.q;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "uniformTexture", "checkInit", "", "beautyParam", "inputTexture", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "setRGBDataCallback", "callback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Companion", "plugin-voip_release"})
public final class f
{
  public static final f.a zyB;
  public int gvL;
  private int gvM;
  private int gvN;
  private int gvO;
  public com.tencent.mm.media.f.d oSo;
  public volatile com.tencent.mm.plugin.voip.video.a.d zyA;
  public com.tencent.mm.media.i.b.d zyt;
  
  static
  {
    AppMethodBeat.i(192382);
    zyB = new f.a((byte)0);
    AppMethodBeat.o(192382);
  }
  
  public f()
  {
    AppMethodBeat.i(192381);
    c.a locala = com.tencent.mm.media.j.c.gwl;
    this.gvL = c.a.ap("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvO = GLES20.glGetUniformLocation(this.gvL, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.zyt == null) {
      this.zyt = new com.tencent.mm.media.i.b.d(0, 0, 0, 0, 2, 0, 32);
    }
    AppMethodBeat.o(192381);
  }
  
  public final com.tencent.mm.media.f.d a(int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2, int paramInt3, com.tencent.mm.media.f.d paramd, int paramInt4)
  {
    AppMethodBeat.i(192380);
    k.h(paramFloatBuffer1, "cubeBuffer");
    k.h(paramFloatBuffer2, "textureCoordBuff");
    k.h(paramd, "outputTexture");
    if (paramInt3 != -1)
    {
      GLES20.glUseProgram(this.gvL);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt3);
      GLES20.glUniform1i(this.gvO, 0);
      paramFloatBuffer1.position(0);
      GLES20.glVertexAttribPointer(this.gvM, 2, 5126, false, 0, (Buffer)paramFloatBuffer1);
      GLES20.glEnableVertexAttribArray(this.gvM);
      paramFloatBuffer2.position(0);
      GLES20.glVertexAttribPointer(this.gvN, 2, 5126, false, 0, (Buffer)paramFloatBuffer2);
      GLES20.glEnableVertexAttribArray(this.gvN);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gvM);
      GLES20.glDisableVertexAttribArray(this.gvN);
      GLES20.glBindTexture(36197, 0);
      GLES20.glBindFramebuffer(36160, 0);
      paramInt3 = paramd.gro;
      if ((paramInt4 != 0) && (this.oSo == null))
      {
        this.oSo = com.tencent.mm.media.f.c.a(true, 14L);
        this.zyA = new com.tencent.mm.plugin.voip.video.a.d();
        paramFloatBuffer1 = this.zyA;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer2 = this.oSo;
          if (paramFloatBuffer2 == null) {
            k.fvU();
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
        ad.i((String)localObject, "initial %s, %d, beauytParams:%s", new Object[] { paramFloatBuffer1, Long.valueOf(localThread.getId()), Integer.valueOf(paramInt4) });
        if (paramFloatBuffer1.fVU != null)
        {
          ad.w(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial xLabEffect: again");
          localObject = paramFloatBuffer1.fVU;
          if (localObject == null) {
            k.fvU();
          }
          ((XLabEffect)localObject).destroy();
        }
        paramFloatBuffer1.fVU = new XLabEffect(0, 0, 1, false, 8);
        localObject = paramFloatBuffer1.fVU;
        if (localObject == null) {
          k.fvU();
        }
        ((XLabEffect)localObject).tP(false);
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
        localObject = paramFloatBuffer1.fVU;
        if (localObject == null) {
          k.fvU();
        }
        ((XLabEffect)localObject).etX();
      }
      if (bool2)
      {
        localObject = paramFloatBuffer1.fVU;
        if (localObject == null) {
          k.fvU();
        }
        ((XLabEffect)localObject).etY();
      }
      if (bool3)
      {
        localObject = paramFloatBuffer1.fVU;
        if (localObject == null) {
          k.fvU();
        }
        ((XLabEffect)localObject).tO(true);
      }
      paramFloatBuffer1.guC = paramInt3;
      paramFloatBuffer1.zwE = paramFloatBuffer2;
      ad.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "initial end %s", new Object[] { paramFloatBuffer1 });
      paramFloatBuffer1 = this.zyA;
      if (paramFloatBuffer1 != null)
      {
        if ((paramInt2 != paramFloatBuffer1.guJ) || (paramInt1 != paramFloatBuffer1.guI)) {
          ad.i(com.tencent.mm.plugin.voip.video.a.d.TAG, "updateTextureSize:%s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        }
        paramFloatBuffer1.guI = paramInt1;
        paramFloatBuffer1.guJ = paramInt2;
        if (paramFloatBuffer1.fVU != null)
        {
          paramFloatBuffer2 = paramFloatBuffer1.fVU;
          if (paramFloatBuffer2 == null) {
            k.fvU();
          }
          paramFloatBuffer2.setSize(paramInt1, paramInt2);
        }
        paramFloatBuffer1.guC = paramd.gro;
        l = bt.GC();
      }
      try
      {
        paramFloatBuffer2 = paramFloatBuffer1.fVU;
        if (paramFloatBuffer2 == null) {
          k.fvU();
        }
        XLabEffect.a(paramFloatBuffer2, paramFloatBuffer1.guC);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        paramFloatBuffer2 = paramFloatBuffer1.zwE;
        if (paramFloatBuffer2 == null) {
          k.fvU();
        }
        paramFloatBuffer2.a(paramFloatBuffer1.guI, paramFloatBuffer1.guJ, 6408, null, 9729, 10497);
        GLES20.glViewport(0, 0, paramFloatBuffer1.guI, paramFloatBuffer1.guJ);
        paramFloatBuffer2 = paramFloatBuffer1.fVU;
        if (paramFloatBuffer2 == null) {
          k.fvU();
        }
        paramInt3 = paramFloatBuffer1.guC;
        paramFloatBuffer1 = paramFloatBuffer1.zwE;
        if (paramFloatBuffer1 == null) {
          k.fvU();
        }
        XLabEffect.a(paramFloatBuffer2, paramInt3, paramFloatBuffer1.gro, 0L, false, 8);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
      }
      catch (Exception paramFloatBuffer1)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.voip.video.a.d.TAG, (Throwable)paramFloatBuffer1, "filterProcess error", new Object[0]);
        continue;
        paramFloatBuffer1 = null;
        continue;
      }
      ad.d(com.tencent.mm.plugin.voip.video.a.d.TAG, "filterProcess: cost %s", new Object[] { Long.valueOf(bt.aS(l)) });
      paramFloatBuffer2 = this.zyt;
      if (paramFloatBuffer2 != null)
      {
        paramFloatBuffer2.mz(90);
        paramFloatBuffer2.guE = true;
        paramFloatBuffer1 = this.oSo;
        if (paramFloatBuffer1 != null)
        {
          paramFloatBuffer1 = Integer.valueOf(paramFloatBuffer1.gro);
          if (paramFloatBuffer1 == null) {
            k.fvU();
          }
          paramFloatBuffer2.guC = paramFloatBuffer1.intValue();
          paramFloatBuffer2.cS(paramInt1, paramInt2);
          paramFloatBuffer2.cT(paramInt2, paramInt1);
          paramFloatBuffer2.cU(paramInt2, paramInt1);
          paramFloatBuffer2.gvc = true;
          paramFloatBuffer2.akk();
        }
      }
      else
      {
        paramFloatBuffer1 = this.oSo;
        AppMethodBeat.o(192380);
        return paramFloatBuffer1;
        bool1 = false;
        break label946;
        bool2 = false;
        break label956;
        bool3 = false;
        continue;
      }
      AppMethodBeat.o(192380);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipYTFaceBeautyRendererProgram$setRGBDataCallback$1$1"})
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