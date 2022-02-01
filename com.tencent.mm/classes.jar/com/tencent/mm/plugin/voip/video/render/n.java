package com.tencent.mm.plugin.voip.video.render;

import android.opengl.GLES30;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.voip.video.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "inputTextureID", "mRenderOnScreenProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;", "getMRenderOnScreenProgram", "()Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;", "setMRenderOnScreenProgram", "(Lcom/tencent/mm/plugin/voip/video/programv2/IVoIPRenderSurfaceProgram;)V", "renderMode", "getRenderMode", "()I", "setRenderMode", "(I)V", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "getTextureSize", "Landroid/util/Size;", "release", "renderImpl", "setEncodeMirror", "isMirror", "", "setEncodeRotate", "encodeRotate", "setInputTexture", "texture", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encodeWidth", "encodeHeight", "encoderType", "updateScaleType", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public class n
  extends a
{
  private final String TAG;
  b UUp;
  private int UUq;
  int mWg;
  private d ntz;
  
  public n(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    AppMethodBeat.i(293102);
    this.TAG = s.X("MicroMsg.VoipTextureRenderProcTexture@", Integer.valueOf(hashCode()));
    this.mWg = 1;
    this.UUq = -1;
    AppMethodBeat.o(293102);
  }
  
  public void GZ(boolean paramBoolean) {}
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(293107);
    s.u(paramd, "texture");
    this.ntz = paramd;
    this.UUq = paramd.nAF;
    AppMethodBeat.o(293107);
  }
  
  public void arz(int paramInt) {}
  
  public void bl(int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void bqg()
  {
    int i = 1;
    AppMethodBeat.i(293121);
    Object localObject = this.ntz;
    if ((localObject != null) && (((d)localObject).nAx == true)) {}
    while ((i != 0) || (this.UUq < 0) || (!GLES30.glIsTexture(this.UUq)))
    {
      Log.e(this.TAG, "render inputTexture already released");
      AppMethodBeat.o(293121);
      return;
      i = 0;
    }
    localObject = this.UUp;
    if (localObject != null) {
      ((b)localObject).a(bpW(), bpV(), this.UUq, this.mWg, bpY());
    }
    AppMethodBeat.o(293121);
  }
  
  public void ek(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293126);
    if ((paramInt1 != getDrawWidth()) || (paramInt2 != getDrawHeight()))
    {
      super.ek(paramInt1, paramInt2);
      b localb = this.UUp;
      if (localb != null) {
        localb.ek(paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(293126);
  }
  
  public void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> paramr)
  {
    AppMethodBeat.i(293146);
    s.u(paramr, "callback");
    AppMethodBeat.o(293146);
  }
  
  public final Size idF()
  {
    AppMethodBeat.i(293109);
    Size localSize = new Size(bpT(), bpU());
    AppMethodBeat.o(293109);
    return localSize;
  }
  
  public final void release()
  {
    AppMethodBeat.i(293131);
    b localb = this.UUp;
    if (localb != null) {
      localb.release();
    }
    super.release();
    AppMethodBeat.o(293131);
  }
  
  public final void ud(int paramInt)
  {
    AppMethodBeat.i(293112);
    setScaleType(paramInt);
    AppMethodBeat.o(293112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.n
 * JD-Core Version:    0.7.0.1
 */