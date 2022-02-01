package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.LayoutInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.e;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "externInputTexture", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$ExternInputTextureInfo;", "externInputTextureSurface", "Landroid/graphics/SurfaceTexture;", "logFrameUdpate", "", "needCreateExteranInputTexture", "renderPts", "", "scaleType", "", "value", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "surfaceCallback", "getSurfaceCallback", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;)V", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "createExternInputTexture", "", "destroyEGL", "initEGL", "onExternTextureInputUpdate", "surfaceTexture", "render", "setInputBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setInputContentInfo", "width", "height", "rotate", "setScaleType", "Companion", "EffectRenderSurfaceCallback", "ExternInputTextureInfo", "ScaleType", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class b
  extends d
{
  public static final b.a agEn;
  public final String TAG;
  private long TCX;
  private c agEi;
  private SurfaceTexture agEj;
  private volatile boolean agEk;
  private boolean agEl;
  b agEm;
  public int nDl;
  
  static
  {
    AppMethodBeat.i(233684);
    agEn = new b.a((byte)0);
    AppMethodBeat.o(233684);
  }
  
  public b()
  {
    AppMethodBeat.i(233670);
    this.TAG = ("EffectRenderController@" + hashCode());
    this.agEi = new c((byte)0);
    this.nDl = 1;
    AppMethodBeat.o(233670);
  }
  
  protected final void AO(long paramLong)
  {
    AppMethodBeat.i(233759);
    super.AO(paramLong);
    if ((this.width <= 0) || (this.height <= 0))
    {
      com.tencent.mm.videocomposition.d.b.s("render with size error " + this.width + ", " + this.height, new Object[0]);
      AppMethodBeat.o(233759);
      return;
    }
    com.tencent.mm.videocomposition.d.c.uiThread((a)new j(this));
    AppMethodBeat.o(233759);
  }
  
  public final void bH(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(233752);
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "setInputContentInfo, size:[" + paramInt1 + ',' + paramInt2 + "], rotate:" + paramInt3, new Object[0]);
    this.agEi.width = paramInt1;
    this.agEi.height = paramInt2;
    this.agEi.hYK = paramInt3;
    try
    {
      SurfaceTexture localSurfaceTexture = this.agEj;
      if (localSurfaceTexture != null)
      {
        localSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
        AppMethodBeat.o(233752);
        return;
      }
      AppMethodBeat.o(233752);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.videocomposition.d.b.printErrStackTrace(this.TAG, (Throwable)localException, "setDefaultBufferSize error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(233752);
    }
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  protected final void jMa()
  {
    AppMethodBeat.i(233757);
    super.jMa();
    K((a)new h(this));
    AppMethodBeat.o(233757);
  }
  
  public final List<com.tencent.mm.xeffect.c> jMb()
  {
    int j = 3;
    boolean bool = true;
    AppMethodBeat.i(233758);
    Object localObject;
    if ((this.agEi.textureId <= 0) || (this.agEi.width <= 0) || (this.agEi.height <= 0))
    {
      com.tencent.mm.videocomposition.d.b.s("error externInput id:" + this.agEi.textureId + " width:" + this.agEi.width + " height:" + this.agEi.height, new Object[0]);
      localObject = (List)ab.aivy;
      AppMethodBeat.o(233758);
      return localObject;
    }
    int i;
    switch (this.agEi.hYK)
    {
    default: 
      i = 0;
      localObject = new com.tencent.mm.xeffect.c(this.agEi.textureId, this.agEi.width, this.agEi.height, this.agEi.agEo, i);
      ((com.tencent.mm.xeffect.c)localObject).agXv.centerX = (this.width / 2);
      ((com.tencent.mm.xeffect.c)localObject).agXv.centerY = (this.height / 2);
      LayoutInfo localLayoutInfo = ((com.tencent.mm.xeffect.c)localObject).agXv;
      i = j;
      switch (this.nDl)
      {
      default: 
        i = 1;
      case 3: 
        label274:
        localLayoutInfo.agXz = i;
        if (this.nDl == 1) {}
        break;
      }
      break;
    }
    for (;;)
    {
      ((com.tencent.mm.xeffect.c)localObject).agXs = bool;
      localObject = kotlin.a.p.listOf(localObject);
      AppMethodBeat.o(233758);
      return localObject;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break label274;
      bool = false;
    }
  }
  
  public final void jMc()
  {
    AppMethodBeat.i(233760);
    K((a)new f(this));
    super.jMc();
    com.tencent.mm.videocomposition.d.c.uiThread((a)new g(this));
    AppMethodBeat.o(233760);
  }
  
  public final void setInputBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(233755);
    s.t(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    if (this.agEi.textureId > 0)
    {
      com.tencent.mm.videocomposition.d.b.i(this.TAG, "already set a inputTexture, will override the old one", new Object[0]);
      SurfaceTexture localSurfaceTexture = this.agEj;
      if (localSurfaceTexture != null) {
        localSurfaceTexture.setOnFrameAvailableListener(null);
      }
    }
    this.TCX = 0L;
    K((a)new k(this, paramBitmap));
    AppMethodBeat.o(233755);
  }
  
  public final void setSurfaceCallback(b paramb)
  {
    AppMethodBeat.i(233743);
    this.agEm = paramb;
    this.agEk = true;
    if ((this.agEu) && (this.agEi.textureId <= 0)) {
      K((a)new l(this));
    }
    AppMethodBeat.o(233743);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "", "onSurfaceAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static abstract interface b
  {
    public abstract void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
    
    public abstract void k(SurfaceTexture paramSurfaceTexture);
    
    public abstract void l(SurfaceTexture paramSurfaceTexture);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController$ExternInputTextureInfo;", "", "textureId", "", "isOES", "", "width", "height", "rotate", "(IZIII)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setOES", "(Z)V", "getRotate", "setRotate", "getTextureId", "setTextureId", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  static final class c
  {
    boolean agEo = false;
    int hYK = 0;
    int height = 0;
    int textureId = 0;
    int width = 0;
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this != paramObject)
      {
        bool1 = bool2;
        if (!(paramObject instanceof c)) {
          break label125;
        }
        paramObject = (c)paramObject;
        if (this.textureId != paramObject.textureId) {
          break label127;
        }
        i = 1;
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.agEo != paramObject.agEo) {
          break label132;
        }
        i = 1;
        label56:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.width != paramObject.width) {
          break label137;
        }
        i = 1;
        label76:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.height != paramObject.height) {
          break label142;
        }
        i = 1;
        label96:
        bool1 = bool2;
        if (i == 0) {
          break label125;
        }
        if (this.hYK != paramObject.hYK) {
          break label147;
        }
      }
      label132:
      label137:
      label142:
      label147:
      for (int i = 1;; i = 0)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
        label125:
        return bool1;
        label127:
        i = 0;
        break;
        i = 0;
        break label56;
        i = 0;
        break label76;
        i = 0;
        break label96;
      }
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(233619);
      String str = "ExternInputTextureInfo(textureId=" + this.textureId + ", isOES=" + this.agEo + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.hYK + ")";
      AppMethodBeat.o(233619);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class e
    extends u
    implements a<ah>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class f
    extends u
    implements a<ah>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class g
    extends u
    implements a<ah>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class h
    extends u
    implements a<ah>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class i
    extends u
    implements a<ah>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class j
    extends u
    implements a<ah>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class k
    extends u
    implements a<ah>
  {
    k(b paramb, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class l
    extends u
    implements a<ah>
  {
    l(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.b
 * JD-Core Version:    0.7.0.1
 */