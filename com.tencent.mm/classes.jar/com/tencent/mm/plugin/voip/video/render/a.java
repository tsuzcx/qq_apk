package com.tencent.mm.plugin.voip.video.render;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/EncodeProgram;", "", "()V", "dataCallbackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mBackUpSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getMBackUpSurface", "()Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setMBackUpSurface", "(Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;)V", "mBeauty", "", "mEncodeSurface", "mHeight", "mIsMirror", "getMIsMirror", "()Z", "setMIsMirror", "(Z)V", "mSTFilter", "mWidth", "onFrameDataAvailableCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "width", "Height", "getOnFrameDataAvailableCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFrameDataAvailableCallback", "(Lkotlin/jvm/functions/Function3;)V", "renderProc", "Lcom/tencent/mm/plugin/voip/video/render/VoipEncoderTextureRenderProcTexture;", "addEncodeSurface", "surface", "addFrameDataCallback", "callback", "createProgram", "getEncoderRenderSurface", "getRenderSurface", "", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "release", "render", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setInputTexture", "texObject", "Lcom/tencent/mm/media/globject/GLTextureObject;", "setLocalRenderOrientation", "rotateDegree", "setMirror", "isMirror", "setVoipFaceBeauty", "beauty", "setVoipSTFilter", "stFilter", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateEncodeSize", "height", "updateRendererSize", "renderSize", "Landroid/util/Size;", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a URy;
  q<? super Integer, ? super Integer, ? super Boolean, ah> URA;
  g URB;
  g URC;
  l URD;
  public boolean URE;
  public boolean URF;
  CopyOnWriteArrayList<r<ByteBuffer, Integer, Integer, Integer, ah>> URz;
  int mHeight;
  int mWidth;
  
  static
  {
    AppMethodBeat.i(293218);
    URy = new a.a((byte)0);
    AppMethodBeat.o(293218);
  }
  
  public a()
  {
    AppMethodBeat.i(293203);
    this.URz = new CopyOnWriteArrayList();
    AppMethodBeat.o(293203);
  }
  
  public final void aru(int paramInt)
  {
    AppMethodBeat.i(293241);
    l locall = this.URD;
    if (locall != null) {
      locall.th(paramInt);
    }
    locall = this.URD;
    if (locall != null) {
      locall.arz(paramInt);
    }
    AppMethodBeat.o(293241);
  }
  
  public final void bl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293260);
    l locall = this.URD;
    if (locall != null) {
      locall.bl(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(293260);
  }
  
  public final void i(Size paramSize)
  {
    AppMethodBeat.i(293226);
    s.u(paramSize, "renderSize");
    l locall = this.URD;
    if (locall != null) {
      locall.el(paramSize.getWidth(), paramSize.getHeight());
    }
    AppMethodBeat.o(293226);
  }
  
  public final void idf()
  {
    AppMethodBeat.i(293250);
    l locall = this.URD;
    if (locall != null) {
      locall.gr(true);
    }
    locall = this.URD;
    if (locall != null) {
      locall.GZ(true);
    }
    AppMethodBeat.o(293250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.a
 * JD-Core Version:    0.7.0.1
 */