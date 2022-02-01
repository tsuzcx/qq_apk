package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class k
{
  public static final k.a Odx;
  public int GIg;
  public int Lur;
  public int NYU;
  public int NYV;
  public byte[] NZb;
  public int[] NZc;
  public ByteBuffer OcV;
  public ByteBuffer OcW;
  public ByteBuffer OcX;
  public ByteBuffer OcY;
  public boolean OcZ;
  public volatile boolean Odd;
  public int Ode;
  public int Odf;
  public d Odw;
  public volatile boolean kYe;
  public int ksr;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public ByteBuffer y;
  
  static
  {
    AppMethodBeat.i(236112);
    Odx = new k.a((byte)0);
    AppMethodBeat.o(236112);
  }
  
  public k()
  {
    AppMethodBeat.i(236109);
    this.Odw = new d();
    this.OcV = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.OcW = ByteBuffer.allocate(0);
    this.OcX = ByteBuffer.allocate(0);
    this.OcY = ByteBuffer.allocate(0);
    AppMethodBeat.o(236109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.k
 * JD-Core Version:    0.7.0.1
 */