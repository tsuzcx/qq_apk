package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.voip.c.g;
import com.tencent.mm.plugin.voip.video.render.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "glSTFilterInputFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "getGlSTFilterInputFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlSTFilterInputFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glSTFilterInputTextureObject", "getGlSTFilterInputTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlSTFilterInputTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mSTFilter", "Lcom/tencent/mm/video/videoprocessing/GPUImageSpatiotemporalDenosing;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTfilterScreenOut", "encodeRotate", "encodeMirror", "skipFilter", "setMotionLevel", "motionLevel", "noiseLevel", "", "setSTFilterDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateSurfaceSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class h
{
  public static final a Ods;
  public com.tencent.mm.ct.a.e Odp;
  public d Odq;
  public a Odr;
  public b QQT;
  public final boolean QQU;
  public d ksA;
  public volatile com.tencent.mm.media.j.b.e ksC;
  public int ksD;
  public int ksE;
  public int ksF;
  public int programId;
  
  static
  {
    AppMethodBeat.i(234833);
    Ods = new a((byte)0);
    AppMethodBeat.o(234833);
  }
  
  public h()
  {
    AppMethodBeat.i(234831);
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
    if (this.QQU) {
      this.QQT = new b();
    }
    for (;;)
    {
      this.Odp = new com.tencent.mm.ct.a.e();
      localObject = this.Odp;
      if (localObject != null) {
        ((com.tencent.mm.ct.a.e)localObject).Pu();
      }
      if (this.Odq == null)
      {
        this.Odq = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.kVi;
        this.Odr = com.tencent.mm.media.g.c.FP(3L);
      }
      x(5, 0.024F);
      AppMethodBeat.o(234831);
      return;
      this.ksC = new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 2, 0, 32);
    }
  }
  
  public final void x(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(234827);
    com.tencent.mm.ct.a.e locale = this.Odp;
    if (locale != null)
    {
      locale.azg(paramInt);
      locale.dc(paramFloat);
      AppMethodBeat.o(234827);
      return;
    }
    AppMethodBeat.o(234827);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.h
 * JD-Core Version:    0.7.0.1
 */