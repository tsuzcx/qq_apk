package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "mHardDrawCnt", "mHeight", "mImage", "", "mImage32", "", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "mUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"})
public final class h
{
  public static final h.a HmL;
  public int AOS;
  public int FfM;
  public int Hif;
  public int Hig;
  public byte[] Him;
  public int[] Hin;
  public a HmK;
  public ByteBuffer Hmg;
  public ByteBuffer Hmh;
  public ByteBuffer Hmi;
  public ByteBuffer Hmj;
  public boolean Hmk;
  public volatile boolean Hmo;
  public int Hmp;
  public int Hmq;
  public int hEm;
  public volatile boolean ijr;
  public int mHeight;
  public int mScreenHeight;
  public int mScreenWidth;
  public int mVideoHeight;
  public int mVideoWidth;
  public int mWidth;
  public ByteBuffer y;
  
  static
  {
    AppMethodBeat.i(236185);
    HmL = new h.a((byte)0);
    AppMethodBeat.o(236185);
  }
  
  public h()
  {
    AppMethodBeat.i(236184);
    this.HmK = new a();
    this.Hmg = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.Hmh = ByteBuffer.allocate(0);
    this.Hmi = ByteBuffer.allocate(0);
    this.Hmj = ByteBuffer.allocate(0);
    AppMethodBeat.o(236184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.h
 * JD-Core Version:    0.7.0.1
 */