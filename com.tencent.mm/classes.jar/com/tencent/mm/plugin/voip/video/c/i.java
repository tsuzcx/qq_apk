package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class i
{
  public static final i.a Crg;
  public int ADH;
  public int Cnp;
  public int Cnq;
  public byte[] Cnw;
  public int[] Cnx;
  public volatile boolean CqA;
  public int CqB;
  public int CqC;
  public ByteBuffer Cqt;
  public ByteBuffer Cqu;
  public ByteBuffer Cqv;
  public ByteBuffer Cqw;
  public boolean Cqx;
  public c Crf;
  public int gLA;
  public volatile boolean hni;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public int wDn;
  public ByteBuffer y;
  
  static
  {
    AppMethodBeat.i(216083);
    Crg = new i.a((byte)0);
    AppMethodBeat.o(216083);
  }
  
  public i()
  {
    AppMethodBeat.i(216082);
    this.Crf = new c();
    this.Cqt = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.Cqu = ByteBuffer.allocate(0);
    this.Cqv = ByteBuffer.allocate(0);
    this.Cqw = ByteBuffer.allocate(0);
    AppMethodBeat.o(216082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.i
 * JD-Core Version:    0.7.0.1
 */