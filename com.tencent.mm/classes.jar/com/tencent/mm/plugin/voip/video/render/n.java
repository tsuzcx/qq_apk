package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setMirror", "isMirror", "setSharedContext", "sharedContext", "updateLocalRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "updateRendererSize", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class n
  extends d
{
  public static final n.a Hpt;
  private b<? super d, x> HnA;
  private boolean Hpr;
  private EGLContext Hps;
  
  static
  {
    AppMethodBeat.i(236374);
    Hpt = new n.a((byte)0);
    AppMethodBeat.o(236374);
  }
  
  public n(boolean paramBoolean)
  {
    super(paramBoolean, Hpt.hashCode());
    AppMethodBeat.i(236373);
    AppMethodBeat.o(236373);
  }
  
  public final void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(236370);
    p.h(paramac, "renderSize");
    if (paramg != null)
    {
      boolean bool;
      if (paramInteger != null)
      {
        i = paramInteger.intValue();
        if (paramBoolean == null) {
          break label201;
        }
        bool = paramBoolean.booleanValue();
        label40:
        p.h(paramac, "cameraSize");
        Log.printInfoStack("MicroMsg.PboSurfaceRender", "updatePboAndWindowsSize is " + paramac.width + " and " + paramac.height + " and " + i, new Object[0]);
        paramInteger = paramg.Hnx;
        if (paramInteger != null) {
          paramInteger.cZ(paramac.width, paramac.height);
        }
        paramac = paramg.Hnx;
        if (paramac != null) {
          paramac.qx(i);
        }
        paramac = paramg.Hnx;
        if (paramac != null)
        {
          if (bool) {
            break label207;
          }
          bool = true;
          label149:
          paramac.iju = bool;
        }
        paramg = paramg.Hnx;
        if (paramg == null) {
          break label213;
        }
      }
      label201:
      label207:
      label213:
      for (paramg = paramg.ijD;; paramg = null)
      {
        a(paramg);
        paramg = this.Hnj;
        if (paramg == null) {
          break label218;
        }
        paramg.qx(0);
        AppMethodBeat.o(236370);
        return;
        i = 90;
        break;
        bool = false;
        break label40;
        bool = false;
        break label149;
      }
      label218:
      AppMethodBeat.o(236370);
      return;
    }
    paramg = this.Hnj;
    if (paramg != null) {
      paramg.cZ(paramac.width, paramac.height);
    }
    paramg = this.Hnj;
    if (paramg != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramg.qx(i);
      AppMethodBeat.o(236370);
      return;
    }
    AppMethodBeat.o(236370);
  }
  
  public final void a(b<? super d, x> paramb, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(236369);
    if (paramg != null)
    {
      Object localObject = paramg.ilw;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).ilv;
        if (localObject != null)
        {
          this.Hps = ((EGLContext)localObject);
          xz(true);
        }
        if (!paramBoolean) {
          break label107;
        }
        paramb = (b)new b(this);
        if (!paramg.HnC.contains(paramb)) {
          paramg.HnC.add(paramb);
        }
      }
      for (;;)
      {
        this.Hnk = paramg.width;
        this.Hnl = paramg.height;
        AppMethodBeat.o(236369);
        return;
        localObject = null;
        break;
        label107:
        this.HnA = paramb;
      }
    }
    this.HnA = paramb;
    xz(false);
    AppMethodBeat.o(236369);
  }
  
  public final void aeb(int paramInt)
  {
    AppMethodBeat.i(236372);
    l locall = this.Hnj;
    if (locall != null)
    {
      locall.qx(paramInt);
      AppMethodBeat.o(236372);
      return;
    }
    AppMethodBeat.o(236372);
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    l locall = this.Hnj;
    if (locall != null) {
      locall.iju = paramBoolean;
    }
  }
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(236371);
    if (this.Hpr)
    {
      AppMethodBeat.o(236371);
      return;
    }
    if (paramBoolean)
    {
      if (this.Hps == null)
      {
        AppMethodBeat.o(236371);
        return;
      }
      k((kotlin.g.a.a)new c(this));
      this.Hpr = true;
      AppMethodBeat.o(236371);
      return;
    }
    k((kotlin.g.a.a)new d(this));
    this.Hpr = true;
    AppMethodBeat.o(236371);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends q
    implements b<com.tencent.mm.media.g.d, x>
  {
    b(n paramn)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(n paramn)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(com.tencent.mm.media.g.d paramd, n.c paramc) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(236362);
        this.Hpw.Hpu.k((kotlin.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(236362);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(n paramn)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(com.tencent.mm.media.g.d paramd, n.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(236366);
        this.Hpy.Hpu.k((kotlin.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(236366);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.n
 * JD-Core Version:    0.7.0.1
 */