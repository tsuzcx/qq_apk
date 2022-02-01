package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.b;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setSharedContext", "sharedContext", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class k
  extends b
{
  public static final k.a zAJ;
  private boolean zAH;
  private EGLContext zAI;
  private d.g.a.b<? super b, y> zzI;
  
  static
  {
    AppMethodBeat.i(192520);
    zAJ = new k.a((byte)0);
    AppMethodBeat.o(192520);
  }
  
  public k(boolean paramBoolean)
  {
    super(paramBoolean, zAJ.hashCode());
    AppMethodBeat.i(192519);
    AppMethodBeat.o(192519);
  }
  
  public final void a(f paramf, ac paramac, Integer paramInteger, Boolean paramBoolean)
  {
    int j = 90;
    int i = 0;
    AppMethodBeat.i(192517);
    d.g.b.k.h(paramac, "renderSize");
    if (paramf != null)
    {
      boolean bool;
      if (paramInteger != null)
      {
        i = paramInteger.intValue();
        if (paramBoolean == null) {
          break label166;
        }
        bool = paramBoolean.booleanValue();
        label44:
        d.g.b.k.h(paramac, "cameraSize");
        if (paramf.dXK() == 0) {
          break label172;
        }
        paramInteger = paramf.zzE;
        if (paramInteger != null) {
          paramInteger.cS(paramac.width, paramac.height);
        }
        paramac = paramf.zzE;
        if (paramac != null)
        {
          if (i == 90) {
            j = 270;
          }
          paramac.mz(j);
        }
        paramac = paramf.zzE;
        if (paramac != null) {
          paramac.guE = bool;
        }
        label120:
        paramf = paramf.zzE;
        if (paramf == null) {
          break label240;
        }
      }
      label166:
      label172:
      label240:
      for (paramf = paramf.guU;; paramf = null)
      {
        a(paramf);
        paramf = this.zyM;
        if (paramf == null) {
          break label245;
        }
        paramf.mz(0);
        AppMethodBeat.o(192517);
        return;
        i = 90;
        break;
        bool = false;
        break label44;
        paramInteger = paramf.zzE;
        if (paramInteger != null) {
          paramInteger.cS(paramac.width, paramac.height);
        }
        paramac = paramf.zzE;
        if (paramac != null) {
          paramac.mz(i);
        }
        paramac = paramf.zzE;
        if (paramac == null) {
          break label120;
        }
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramac.guE = bool;
          break;
        }
      }
      label245:
      AppMethodBeat.o(192517);
      return;
    }
    paramf = this.zyM;
    if (paramf != null) {
      paramf.cS(paramac.width, paramac.height);
    }
    paramf = this.zyM;
    if (paramf != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramf.mz(i);
      AppMethodBeat.o(192517);
      return;
    }
    AppMethodBeat.o(192517);
  }
  
  public final void a(d.g.a.b<? super b, y> paramb, f paramf)
  {
    AppMethodBeat.i(192516);
    if (paramf != null)
    {
      paramb = paramf.gBJ;
      if (paramb != null) {}
      for (paramb = paramb.gwo;; paramb = null)
      {
        if (paramb != null)
        {
          this.zAI = paramb;
          rZ(true);
        }
        paramb = (d.g.a.b)new b(this);
        if (!paramf.zzK.contains(paramb)) {
          paramf.zzK.add(paramb);
        }
        this.zyN = paramf.width;
        this.zyO = paramf.height;
        AppMethodBeat.o(192516);
        return;
      }
    }
    this.zzI = paramb;
    rZ(false);
    AppMethodBeat.o(192516);
  }
  
  public final void rZ(boolean paramBoolean)
  {
    AppMethodBeat.i(192518);
    if (this.zAH)
    {
      AppMethodBeat.o(192518);
      return;
    }
    if (paramBoolean)
    {
      if (this.zAI == null)
      {
        AppMethodBeat.o(192518);
        return;
      }
      i((d.g.a.a)new c(this));
      this.zAH = true;
      AppMethodBeat.o(192518);
      return;
    }
    i((d.g.a.a)new d(this));
    this.zAH = true;
    AppMethodBeat.o(192518);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<d, y>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(k paramk)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, k.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(192513);
        this.zAM.zAK.i((d.g.a.a)new d.g.b.l(paramSurfaceTexture) {});
        AppMethodBeat.o(192513);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */