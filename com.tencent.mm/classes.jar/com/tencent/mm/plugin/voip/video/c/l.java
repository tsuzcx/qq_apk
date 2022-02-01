package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "", "()V", "all", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "canDrawYuv", "", "clearFrame", "mAngle", "", "mFlag", "getMFlag", "()I", "setMFlag", "(I)V", "mHardDrawCnt", "mHeight", "getMHeight", "setMHeight", "mImage", "", "getMImage", "()[B", "setMImage", "([B)V", "mImage32", "", "mLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getMLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "setMLock", "(Ljava/util/concurrent/locks/ReentrantLock;)V", "mMirror", "mSProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipGLSProgram;", "mScreenHeight", "mScreenWidth", "mSoftDrawCnt", "mUIHeight", "getMUIHeight", "setMUIHeight", "mUIWidth", "getMUIWidth", "setMUIWidth", "mVideoHeight", "mVideoWidth", "mWidth", "getMWidth", "setMWidth", "renderType", "u", "uv", "v", "y", "checkDisplayAngleSoft", "", "width", "height", "clipEdge", "cropTextureCoord", "", "vert", "createBuffer", "drawFrame", "pBuff", "w", "h", "flag", "feedData", "yuvData", "isYuvDataValid", "onDrawFrame", "release", "renderImpl", "setYUVDataSize", "screenWidth", "screenHeight", "updateDrawViewSize", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a URw;
  int MEW;
  int RXR;
  int UMR;
  int UMS;
  byte[] UMY;
  int[] UMZ;
  ByteBuffer UQV;
  ByteBuffer UQW;
  ByteBuffer UQX;
  ByteBuffer UQY;
  boolean UQZ;
  volatile boolean URd;
  int URe;
  int URf;
  e URx;
  int mHeight;
  ReentrantLock mLock;
  int mScreenHeight;
  int mScreenWidth;
  int mVideoHeight;
  int mVideoWidth;
  int mWidth;
  int mWk;
  volatile boolean nDp;
  ByteBuffer y;
  
  static
  {
    AppMethodBeat.i(293238);
    URw = new l.a((byte)0);
    AppMethodBeat.o(293238);
  }
  
  public l()
  {
    AppMethodBeat.i(293227);
    this.mLock = new ReentrantLock();
    this.URx = new e();
    this.UQV = ByteBuffer.allocate(0);
    this.y = ByteBuffer.allocate(0);
    this.UQW = ByteBuffer.allocate(0);
    this.UQX = ByteBuffer.allocate(0);
    this.UQY = ByteBuffer.allocate(0);
    AppMethodBeat.o(293227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.l
 * JD-Core Version:    0.7.0.1
 */