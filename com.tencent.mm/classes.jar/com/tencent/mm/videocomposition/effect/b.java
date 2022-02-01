package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "externInputTexture", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$ExternInputTextureInfo;", "externInputTextureSurface", "Landroid/graphics/SurfaceTexture;", "logFrameUdpate", "", "needCreateExteranInputTexture", "renderPts", "", "scaleType", "", "value", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "surfaceCallback", "getSurfaceCallback", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "setSurfaceCallback", "(Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;)V", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "createExternInputTexture", "", "destroyEGL", "initEGL", "onExternTextureInputUpdate", "surfaceTexture", "setInputBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setInputContentInfo", "width", "height", "rotate", "Companion", "EffectRenderSurfaceCallback", "ExternInputTextureInfo", "ScaleType", "video_composition_release"})
public final class b
  extends d
{
  public static final a YIG;
  private long MQt;
  final String TAG;
  c YIB;
  private SurfaceTexture YIC;
  volatile boolean YID;
  private boolean YIE;
  b YIF;
  private int kYn;
  
  static
  {
    AppMethodBeat.i(248186);
    YIG = new a((byte)0);
    AppMethodBeat.o(248186);
  }
  
  public b()
  {
    AppMethodBeat.i(248183);
    this.TAG = ("EffectRenderController@" + hashCode());
    this.YIB = new c((byte)0);
    this.kYn = 1;
    AppMethodBeat.o(248183);
  }
  
  public final void bg(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(248175);
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "setInputContentInfo, size:[" + paramInt1 + ',' + paramInt2 + "], rotate:" + paramInt3, new Object[0]);
    this.YIB.width = paramInt1;
    this.YIB.height = paramInt2;
    this.YIB.fSM = paramInt3;
    try
    {
      SurfaceTexture localSurfaceTexture = this.YIC;
      if (localSurfaceTexture != null)
      {
        localSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
        AppMethodBeat.o(248175);
        return;
      }
      AppMethodBeat.o(248175);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.videocomposition.c.b.printErrStackTrace(this.TAG, (Throwable)localException, "setDefaultBufferSize error:" + localException.getMessage(), new Object[0]);
      AppMethodBeat.o(248175);
    }
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  protected final void igL()
  {
    AppMethodBeat.i(248177);
    super.igL();
    j((a)new i(this));
    AppMethodBeat.o(248177);
  }
  
  public final List<com.tencent.mm.xeffect.c> igM()
  {
    AppMethodBeat.i(248180);
    Object localObject;
    if ((this.YIB.textureId <= 0) || (this.YIB.width <= 0) || (this.YIB.height <= 0))
    {
      com.tencent.mm.videocomposition.c.b.r("error externInput id:" + this.YIB.textureId + " width:" + this.YIB.width + " height:" + this.YIB.height, new Object[0]);
      localObject = (List)v.aaAd;
      AppMethodBeat.o(248180);
      return localObject;
    }
    int i;
    switch (this.YIB.fSM)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject = new com.tencent.mm.xeffect.c(this.YIB.textureId, this.YIB.width, this.YIB.height, this.YIB.YIH, i);
      ((com.tencent.mm.xeffect.c)localObject).YZk.centerX = (this.width / 2);
      ((com.tencent.mm.xeffect.c)localObject).YZk.centerY = (this.height / 2);
      ((com.tencent.mm.xeffect.c)localObject).YZk.YZo = 1;
      ((com.tencent.mm.xeffect.c)localObject).YZh = false;
      com.tencent.mm.videocomposition.c.c.uiThread((a)new d(this));
      localObject = j.listOf(localObject);
      AppMethodBeat.o(248180);
      return localObject;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public final void igN()
  {
    AppMethodBeat.i(248182);
    j((a)new g(this));
    super.igN();
    com.tencent.mm.videocomposition.c.c.uiThread((a)new h(this));
    AppMethodBeat.o(248182);
  }
  
  public final void setInputBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(248176);
    p.k(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "setInputBitmap: " + paramBitmap + ", size:[" + paramBitmap.getWidth() + ',' + paramBitmap.getHeight() + ']', new Object[0]);
    if (this.YIB.textureId > 0)
    {
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "already set a inputTexture, will override the old one", new Object[0]);
      SurfaceTexture localSurfaceTexture = this.YIC;
      if (localSurfaceTexture != null) {
        localSurfaceTexture.setOnFrameAvailableListener(null);
      }
    }
    this.MQt = 0L;
    j((a)new k(this, paramBitmap));
    AppMethodBeat.o(248176);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController$Companion;", "", "()V", "SCALE_TYPE_CENTER_CROP", "", "SCALE_TYPE_CENTER_INSIDE", "SCALE_TYPE_DEFAULT", "video_composition_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "", "onSurfaceAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "video_composition_release"})
  public static abstract interface b
  {
    public abstract void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2);
    
    public abstract void l(SurfaceTexture paramSurfaceTexture);
    
    public abstract void m(SurfaceTexture paramSurfaceTexture);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderController$ExternInputTextureInfo;", "", "textureId", "", "isOES", "", "width", "height", "rotate", "(IZIII)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setOES", "(Z)V", "getRotate", "setRotate", "getTextureId", "setTextureId", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
  static final class c
  {
    boolean YIH = false;
    int fSM = 0;
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
        if (this.YIH != paramObject.YIH) {
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
        if (this.fSM != paramObject.fSM) {
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
      AppMethodBeat.i(248118);
      String str = "ExternInputTextureInfo(textureId=" + this.textureId + ", isOES=" + this.YIH + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.fSM + ")";
      AppMethodBeat.o(248118);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends q
    implements a<x>
  {
    k(b paramb, Bitmap paramBitmap)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements a<x>
  {
    l(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.b
 * JD-Core Version:    0.7.0.1
 */