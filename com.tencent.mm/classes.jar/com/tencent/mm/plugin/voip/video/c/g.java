package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a zyE;
  public volatile boolean guA;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public int uoX;
  public int xYz;
  public ByteBuffer y;
  public int zvl;
  public int zvm;
  public byte[] zvs;
  public int[] zvt;
  public a zyD;
  public int zyg;
  public ByteBuffer zyj;
  public ByteBuffer zyk;
  public ByteBuffer zyl;
  public ByteBuffer zym;
  public boolean zyn;
  public volatile boolean zyq;
  public int zyr;
  public int zys;
  
  static
  {
    AppMethodBeat.i(192384);
    zyE = new g.a((byte)0);
    AppMethodBeat.o(192384);
  }
  
  public g()
  {
    AppMethodBeat.i(192383);
    this.zyD = new a();
    this.zyj = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.zyk = ByteBuffer.allocate(0);
    this.zyl = ByteBuffer.allocate(0);
    this.zym = ByteBuffer.allocate(0);
    AppMethodBeat.o(192383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.g
 * JD-Core Version:    0.7.0.1
 */