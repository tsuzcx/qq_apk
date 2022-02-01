package com.tencent.mm.plugin.voip.video.c;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.plugin.voip.b.g;
import java.nio.ByteBuffer;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram;", "", "()V", "attributePosition", "", "attributeTextureCoord", "filterOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "filterProcessTex", "Lcom/tencent/mm/plugin/voip/video/filter/VoipFilterProcessTex;", "glOutFrameBufferObject", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "glSTFilterInputFrameBufferObject", "getGlSTFilterInputFrameBufferObject", "()Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "setGlSTFilterInputFrameBufferObject", "(Lcom/tencent/mm/media/globject/GLFrameBufferObject;)V", "glSTFilterInputTextureObject", "getGlSTFilterInputTextureObject", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setGlSTFilterInputTextureObject", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "mSTFilter", "Lcom/tencent/mm/video/videoprocessing/GPUImageSpatiotemporalDenosing;", "programId", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "stFilterOutputTexture", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "uniformTexture", "useGpuConvert", "", "checkInit", "", "release", "renderImpl", "drawWidth", "drawHeight", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "rotate", "texture", "outputTexture", "useSTfilterScreenOut", "encodeRotate", "encodeMirror", "skipFilter", "setMotionLevel", "motionLevel", "noiseLevel", "", "setSTFilterDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/STFilterDataCallback;", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateSurfaceSize", "width", "height", "updateTextureSize", "Companion", "plugin-voip_release"})
public final class e
{
  public static final e.a HmE;
  public com.tencent.mm.media.g.a HmA;
  public f HmB;
  public d HmC;
  public com.tencent.mm.media.g.a HmD;
  public com.tencent.mm.plugin.voip.video.render.a Hms;
  public final boolean Hmt;
  public int hEA;
  public d hEv;
  public com.tencent.mm.media.j.b.e hEx;
  public int hEy;
  public int hEz;
  public int programId;
  
  static
  {
    AppMethodBeat.i(236177);
    HmE = new e.a((byte)0);
    AppMethodBeat.o(236177);
  }
  
  public e()
  {
    AppMethodBeat.i(236176);
    Object localObject = g.HgZ;
    this.Hmt = g.fKi();
    localObject = com.tencent.mm.media.k.c.ilt;
    this.programId = c.a.aB("\n        attribute vec4 a_position;\n        attribute vec2 a_texCoord;\n        varying vec2 v_texCoord;\n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord;\n        }\n        ", "\n        #extension GL_OES_EGL_image_external : require\n        #ifdef GL_ES\n        precision highp float;\n        #endif\n\n        varying vec2 v_texCoord;\n        uniform samplerExternalOES texture;\n\n        void main () {\n            gl_FragColor = texture2D(texture, v_texCoord);\n        }\n        ");
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.hEA = GLES20.glGetUniformLocation(this.programId, "texture");
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    if (this.Hmt) {
      this.Hms = new com.tencent.mm.plugin.voip.video.render.a();
    }
    for (;;)
    {
      this.HmB = new f();
      localObject = this.HmB;
      if (localObject != null) {
        ((f)localObject).MC();
      }
      if (this.HmC == null)
      {
        this.HmC = com.tencent.mm.media.g.c.a(true, 3L);
        localObject = com.tencent.mm.media.g.c.igu;
        this.HmD = com.tencent.mm.media.g.c.zI(3L);
      }
      w(5, 0.024F);
      AppMethodBeat.o(236176);
      return;
      this.hEx = new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 2, 0, 32);
    }
  }
  
  public final void w(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(236175);
    f localf = this.HmB;
    if (localf != null)
    {
      localf.apH(paramInt);
      localf.cH(paramFloat);
      AppMethodBeat.o(236175);
      return;
    }
    AppMethodBeat.o(236175);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke", "com/tencent/mm/plugin/voip/video/programv2/VoipSTFilterRendererProgram$setSTFilterDataCallback$1$1"})
  public static final class b
    extends q
    implements b<ByteBuffer, x>
  {
    public b(e parame, r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.e
 * JD-Core Version:    0.7.0.1
 */