package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.ByteBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class i
{
  public static final i.a CIK;
  public int AVh;
  public int CET;
  public int CEU;
  public byte[] CFa;
  public int[] CFb;
  public ByteBuffer CHX;
  public ByteBuffer CHY;
  public ByteBuffer CHZ;
  public c CIJ;
  public ByteBuffer CIa;
  public boolean CIb;
  public volatile boolean CIe;
  public int CIf;
  public int CIg;
  public int gOj;
  public volatile boolean hpW;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public int wSY;
  public ByteBuffer y;
  
  static
  {
    AppMethodBeat.i(210504);
    CIK = new i.a((byte)0);
    AppMethodBeat.o(210504);
  }
  
  public i()
  {
    AppMethodBeat.i(210503);
    this.CIJ = new c();
    this.CHX = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.CHY = ByteBuffer.allocate(0);
    this.CHZ = ByteBuffer.allocate(0);
    this.CIa = ByteBuffer.allocate(0);
    AppMethodBeat.o(210503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.i
 * JD-Core Version:    0.7.0.1
 */