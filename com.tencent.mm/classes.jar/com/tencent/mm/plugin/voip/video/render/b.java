package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/EncodeWindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "()V", "dataCallbackList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "", "", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "mBeauty", "", "mHeight", "mSTFilter", "mWidth", "onFrameDataAvailableCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "width", "Height", "getOnFrameDataAvailableCallback", "()Lkotlin/jvm/functions/Function3;", "setOnFrameDataAvailableCallback", "(Lkotlin/jvm/functions/Function3;)V", "addFrameDataCallback", "callback", "checkInit", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "createEGLContext", "isUseShareContext", "getEncoderRenderSurface", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "getRenderSurface", "", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "release", "render", "setVoipFaceBeauty", "beauty", "setVoipSTFilter", "stFilter", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "updateEncodeSize", "height", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends p
{
  public static final b.a URH;
  q<? super Integer, ? super Integer, ? super Boolean, ah> URA;
  public boolean URE;
  public boolean URF;
  CopyOnWriteArrayList<r<ByteBuffer, Integer, Integer, Integer, ah>> URz;
  int mHeight;
  int mWidth;
  
  static
  {
    AppMethodBeat.i(293073);
    URH = new b.a((byte)0);
    AppMethodBeat.o(293073);
  }
  
  public b()
  {
    super(true);
    AppMethodBeat.i(293058);
    this.URz = new CopyOnWriteArrayList();
    AppMethodBeat.o(293058);
  }
  
  public final void GV(boolean paramBoolean)
  {
    AppMethodBeat.i(293080);
    if (idI())
    {
      AppMethodBeat.o(293080);
      return;
    }
    Log.i("MicroMsg.EncodeWindowSurfaceRenderer", "createEGLContext, isUseShareContext:" + paramBoolean + ", shareGLContext:" + this.UUC);
    if (paramBoolean)
    {
      if (this.UUC == null)
      {
        AppMethodBeat.o(293080);
        return;
      }
      K((a)new c(this));
      idJ();
    }
    AppMethodBeat.o(293080);
  }
  
  public final void a(kotlin.g.a.b<? super f, ah> paramb, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(293089);
    if (paramh != null)
    {
      d(paramh.ido());
      paramh.aO((kotlin.g.a.b)new b(this));
      this.USo = paramh.width;
      this.USp = paramh.height;
      n localn = this.USn;
      if (localn != null) {
        localn.el(paramh.width, paramh.height);
      }
      this.USI = paramb;
    }
    AppMethodBeat.o(293089);
  }
  
  protected final void bgE()
  {
    AppMethodBeat.i(293094);
    K((a)new d(this));
    AppMethodBeat.o(293094);
  }
  
  public final void bl(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(293099);
    K((a)new e(this, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(293099);
  }
  
  public final g[] idg()
  {
    return new g[] { this.URB, this.URC };
  }
  
  public final void release()
  {
    AppMethodBeat.i(293103);
    super.release();
    this.URz.clear();
    AppMethodBeat.o(293103);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<d, ah>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(b paramb, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.b
 * JD-Core Version:    0.7.0.1
 */