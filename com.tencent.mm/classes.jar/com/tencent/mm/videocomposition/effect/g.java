package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.InputAnimation;
import com.tencent.mm.xeffect.LayoutInfo;
import com.tencent.mm.xeffect.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.v;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "inputTextureList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$EffectInputTexture;", "inputTextureLock", "Ljava/lang/Object;", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "", "destroyEGL", "", "newBitmapInputTexture", "key", "bitmap", "Landroid/graphics/Bitmap;", "animate", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "newVideoInputTexture", "width", "", "height", "rotate", "callback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "removeInputTexture", "EffectInputTexture", "InputTextureData", "TextureLayoutAnimation", "video_composition_release"})
public final class g
  extends d
{
  final String TAG;
  final ConcurrentLinkedDeque<a> YIZ;
  private final Object YJa;
  
  public g()
  {
    AppMethodBeat.i(248385);
    this.TAG = ("MultiInputEffectRenderController@" + hashCode());
    this.YIZ = new ConcurrentLinkedDeque();
    this.YJa = new Object();
    AppMethodBeat.o(248385);
  }
  
  public final void a(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3, final kotlin.g.a.b<? super SurfaceTexture, x> paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(248377);
    p.k(paramString, "key");
    p.k(paramb, "callback");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "newVideoInputTexture:".concat(String.valueOf(paramString)), new Object[0]);
    Object localObject2 = (Iterable)this.YIZ;
    int i;
    if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (p.h(((a)((Iterator)localObject2).next()).key, paramString))
        {
          i = 1;
          if (i == 0) {
            break label243;
          }
          com.tencent.mm.videocomposition.c.b.i(this.TAG, "newVideoInputTexture, already contains same key", new Object[0]);
          Iterator localIterator = ((Iterable)this.YIZ).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = localIterator.next();
          } while (!p.h(((a)localObject2).key, paramString));
        }
      }
    }
    for (paramString = (String)localObject2;; paramString = null)
    {
      localObject2 = (a)paramString;
      paramString = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((a)localObject2).YJb;
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = ((b)localObject2).surfaceTexture;
        }
      }
      paramb.invoke(paramString);
      AppMethodBeat.o(248377);
      return;
      i = 0;
      break;
    }
    label243:
    j((a)new f(this, paramInt1, paramInt2, paramInt3, paramString, paramb));
    AppMethodBeat.o(248377);
  }
  
  public final void a(final String paramString, final Bitmap paramBitmap, final c paramc)
  {
    AppMethodBeat.i(248379);
    p.k(paramString, "key");
    p.k(paramBitmap, "bitmap");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "newBitmapInputTexture:".concat(String.valueOf(paramString)), new Object[0]);
    Object localObject = (Iterable)this.YIZ;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!p.h(((a)((Iterator)localObject).next()).key, paramString));
    }
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.mm.videocomposition.c.b.i(this.TAG, "newBitmapInputTexture, already contains same key", new Object[0]);
      AppMethodBeat.o(248379);
      return;
    }
    j((a)new e(this, paramBitmap, paramString, paramc));
    AppMethodBeat.o(248379);
  }
  
  public final void bCg(String paramString)
  {
    AppMethodBeat.i(248381);
    p.k(paramString, "key");
    com.tencent.mm.videocomposition.c.b.i(this.TAG, "removeInputTexture:".concat(String.valueOf(paramString)), new Object[0]);
    Iterator localIterator = ((Iterable)this.YIZ).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((a)localObject).key, paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (a)paramString;
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(248381);
      return;
    }
    ao((a)new g(paramString));
    this.YIZ.remove(paramString);
    AppMethodBeat.o(248381);
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  public final List<c> igM()
  {
    AppMethodBeat.i(248382);
    if (this.YIZ.isEmpty())
    {
      localObject1 = (List)v.aaAd;
      AppMethodBeat.o(248382);
      return localObject1;
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = ((Iterable)this.YIZ).iterator();
    a locala;
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.YJb.textureId <= 0) || (locala.YJb.width <= 0) || (locala.YJb.height <= 0))
      {
        com.tencent.mm.videocomposition.c.b.r("error input " + locala.key + ", id:" + locala.YJb.textureId + " width:" + locala.YJb.width + " height:" + locala.YJb.height, new Object[0]);
      }
      else
      {
        int i;
        label234:
        c localc;
        Object localObject2;
        switch (locala.YJb.fSM)
        {
        default: 
          i = 0;
          localc = new c(locala.YJb.textureId, locala.YJb.width, locala.YJb.height, locala.YJb.YIH, i);
          localObject2 = locala.YJc;
          if (localObject2 != null)
          {
            LayoutInfo localLayoutInfo = ((c)localObject2).YJd;
            p.k(localLayoutInfo, "<set-?>");
            localc.YZk = localLayoutInfo;
            localLayoutInfo = ((c)localObject2).YJe;
            p.k(localLayoutInfo, "<set-?>");
            localc.YZl = localLayoutInfo;
            localObject2 = ((c)localObject2).YJf;
            p.k(localObject2, "<set-?>");
            localc.YZm = ((InputAnimation)localObject2);
          }
          break;
        }
        for (;;)
        {
          localc.YZh = false;
          try
          {
            localObject2 = locala.YJb.surfaceTexture;
            if (localObject2 != null) {
              ((SurfaceTexture)localObject2).updateTexImage();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.videocomposition.c.b.e(this.TAG, "update surfaceTexture error key:" + locala.key, new Object[0]);
            }
          }
          ((ArrayList)localObject1).add(localc);
          break;
          i = 0;
          break label234;
          i = 1;
          break label234;
          i = 2;
          break label234;
          i = 3;
          break label234;
          localc.YZk.centerX = (this.width / 2);
          localc.YZk.centerY = (this.height / 2);
          localc.YZk.YZo = 1;
        }
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(248382);
    return localObject1;
  }
  
  public final void igN()
  {
    AppMethodBeat.i(248384);
    j((a)new d(this));
    super.igN();
    AppMethodBeat.o(248384);
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$EffectInputTexture;", "", "key", "", "data", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "animate", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "(Ljava/lang/String;Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;)V", "getAnimate", "()Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "setAnimate", "(Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;)V", "getData", "()Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "video_composition_release"})
  static final class a
  {
    final g.b YJb;
    g.c YJc;
    String key;
    
    public a(String paramString, g.b paramb, g.c paramc)
    {
      AppMethodBeat.i(248320);
      this.key = paramString;
      this.YJb = paramb;
      this.YJc = paramc;
      AppMethodBeat.o(248320);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(248326);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!p.h(this.key, paramObject.key)) || (!p.h(this.YJb, paramObject.YJb)) || (!p.h(this.YJc, paramObject.YJc))) {}
        }
      }
      else
      {
        AppMethodBeat.o(248326);
        return true;
      }
      AppMethodBeat.o(248326);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(248323);
      Object localObject = this.key;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.YJb;
        if (localObject == null) {
          break label80;
        }
      }
      label80:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.YJc;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(248323);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(248321);
      String str = "EffectInputTexture(key=" + this.key + ", data=" + this.YJb + ", animate=" + this.YJc + ")";
      AppMethodBeat.o(248321);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "", "textureId", "", "isOES", "", "width", "height", "rotate", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(IZIIILandroid/graphics/SurfaceTexture;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setOES", "(Z)V", "getRotate", "setRotate", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureId", "setTextureId", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"})
  static final class b
  {
    boolean YIH;
    int fSM;
    int height;
    SurfaceTexture surfaceTexture;
    int textureId;
    int width;
    
    public b()
    {
      this(0, 0, 0, 63);
    }
    
    public b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, SurfaceTexture paramSurfaceTexture)
    {
      this.textureId = paramInt1;
      this.YIH = paramBoolean;
      this.width = paramInt2;
      this.height = paramInt3;
      this.fSM = paramInt4;
      this.surfaceTexture = paramSurfaceTexture;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(248340);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label153;
        }
        paramObject = (b)paramObject;
        if (this.textureId != paramObject.textureId) {
          break label128;
        }
        i = 1;
        if (i == 0) {
          break label153;
        }
        if (this.YIH != paramObject.YIH) {
          break label133;
        }
        i = 1;
        label52:
        if (i == 0) {
          break label153;
        }
        if (this.width != paramObject.width) {
          break label138;
        }
        i = 1;
        label69:
        if (i == 0) {
          break label153;
        }
        if (this.height != paramObject.height) {
          break label143;
        }
        i = 1;
        label86:
        if (i == 0) {
          break label153;
        }
        if (this.fSM != paramObject.fSM) {
          break label148;
        }
      }
      label128:
      label133:
      label138:
      label143:
      label148:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!p.h(this.surfaceTexture, paramObject.surfaceTexture))) {
          break label153;
        }
        AppMethodBeat.o(248340);
        return true;
        i = 0;
        break;
        i = 0;
        break label52;
        i = 0;
        break label69;
        i = 0;
        break label86;
      }
      label153:
      AppMethodBeat.o(248340);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(248337);
      String str = "InputTextureData(textureId=" + this.textureId + ", isOES=" + this.YIH + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.fSM + ", surfaceTexture=" + this.surfaceTexture + ")";
      AppMethodBeat.o(248337);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "", "fromLayout", "Lcom/tencent/mm/xeffect/LayoutInfo;", "toLayout", "animate", "Lcom/tencent/mm/xeffect/InputAnimation;", "(Lcom/tencent/mm/xeffect/LayoutInfo;Lcom/tencent/mm/xeffect/LayoutInfo;Lcom/tencent/mm/xeffect/InputAnimation;)V", "getAnimate", "()Lcom/tencent/mm/xeffect/InputAnimation;", "setAnimate", "(Lcom/tencent/mm/xeffect/InputAnimation;)V", "getFromLayout", "()Lcom/tencent/mm/xeffect/LayoutInfo;", "setFromLayout", "(Lcom/tencent/mm/xeffect/LayoutInfo;)V", "getToLayout", "setToLayout", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"})
  public static final class c
  {
    public LayoutInfo YJd;
    public LayoutInfo YJe;
    public InputAnimation YJf;
    
    public c(LayoutInfo paramLayoutInfo1, LayoutInfo paramLayoutInfo2, InputAnimation paramInputAnimation)
    {
      AppMethodBeat.i(248343);
      this.YJd = paramLayoutInfo1;
      this.YJe = paramLayoutInfo2;
      this.YJf = paramInputAnimation;
      AppMethodBeat.o(248343);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(248347);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!p.h(this.YJd, paramObject.YJd)) || (!p.h(this.YJe, paramObject.YJe)) || (!p.h(this.YJf, paramObject.YJf))) {}
        }
      }
      else
      {
        AppMethodBeat.o(248347);
        return true;
      }
      AppMethodBeat.o(248347);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(248346);
      Object localObject = this.YJd;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.YJe;
        if (localObject == null) {
          break label80;
        }
      }
      label80:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.YJf;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(248346);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(248345);
      String str = "TextureLayoutAnimation(fromLayout=" + this.YJd + ", toLayout=" + this.YJe + ", animate=" + this.YJf + ")";
      AppMethodBeat.o(248345);
      return str;
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(g paramg, Bitmap paramBitmap, String paramString, g.c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(g paramg, int paramInt1, int paramInt2, int paramInt3, String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.g
 * JD-Core Version:    0.7.0.1
 */