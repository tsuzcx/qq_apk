package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.nio.ByteBuffer;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a ARv;
  public int AOc;
  public int AOd;
  public byte[] AOj;
  public int[] AOk;
  public ByteBuffer ARb;
  public ByteBuffer ARc;
  public ByteBuffer ARd;
  public ByteBuffer ARe;
  public boolean ARf;
  public volatile boolean ARi;
  public int ARj;
  public int ARk;
  public a ARu;
  public volatile boolean gVf;
  public int grS;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public int vxT;
  public ByteBuffer y;
  public int zlw;
  
  static
  {
    AppMethodBeat.i(208735);
    ARv = new g.a((byte)0);
    AppMethodBeat.o(208735);
  }
  
  public g()
  {
    AppMethodBeat.i(208734);
    this.ARu = new a();
    this.ARb = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.ARc = ByteBuffer.allocate(0);
    this.ARd = ByteBuffer.allocate(0);
    this.ARe = ByteBuffer.allocate(0);
    AppMethodBeat.o(208734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.g
 * JD-Core Version:    0.7.0.1
 */