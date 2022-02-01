package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.InputAnimation;
import com.tencent.mm.xeffect.LayoutInfo;
import com.tencent.mm.xeffect.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "inputTextureList", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$EffectInputTexture;", "inputTextureLock", "Ljava/lang/Object;", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "", "destroyEGL", "", "newBitmapInputTexture", "key", "bitmap", "Landroid/graphics/Bitmap;", "animate", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "newVideoInputTexture", "width", "", "height", "rotate", "callback", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "removeInputTexture", "EffectInputTexture", "InputTextureData", "TextureLayoutAnimation", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class h
  extends d
{
  public final String TAG;
  public final ConcurrentLinkedDeque<a> agES;
  private final Object agET;
  
  public h()
  {
    AppMethodBeat.i(233653);
    this.TAG = ("MultiInputEffectRenderController@" + hashCode());
    this.agES = new ConcurrentLinkedDeque();
    this.agET = new Object();
    AppMethodBeat.o(233653);
  }
  
  public final void a(final String paramString, final int paramInt1, final int paramInt2, final int paramInt3, final kotlin.g.a.b<? super SurfaceTexture, ah> paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(233667);
    s.t(paramString, "key");
    s.t(paramb, "callback");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "newVideoInputTexture:".concat(String.valueOf(paramString)), new Object[0]);
    Object localObject2 = (Iterable)this.agES;
    int i;
    if ((!(localObject2 instanceof Collection)) || (!((Collection)localObject2).isEmpty()))
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (s.p(((a)((Iterator)localObject2).next()).key, paramString))
        {
          i = 1;
          if (i == 0) {
            break label243;
          }
          com.tencent.mm.videocomposition.d.b.i(this.TAG, "newVideoInputTexture, already contains same key", new Object[0]);
          Iterator localIterator = ((Iterable)this.agES).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = localIterator.next();
          } while (!s.p(((a)localObject2).key, paramString));
        }
      }
    }
    for (paramString = (String)localObject2;; paramString = null)
    {
      localObject2 = (a)paramString;
      paramString = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((a)localObject2).agEU;
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = ((b)localObject2).surfaceTexture;
        }
      }
      paramb.invoke(paramString);
      AppMethodBeat.o(233667);
      return;
      i = 0;
      break;
    }
    label243:
    K((a)new f(this, paramInt1, paramInt2, paramInt3, paramString, paramb));
    AppMethodBeat.o(233667);
  }
  
  public final void bEz(String paramString)
  {
    AppMethodBeat.i(233674);
    s.t(paramString, "key");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "removeInputTexture:".concat(String.valueOf(paramString)), new Object[0]);
    Iterator localIterator = ((Iterable)this.agES).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((a)localObject).key, paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (a)paramString;
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(233674);
      return;
    }
    cf((a)new g(paramString));
    this.agES.remove(paramString);
    AppMethodBeat.o(233674);
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  public final List<c> jMb()
  {
    AppMethodBeat.i(233693);
    if (this.agES.isEmpty())
    {
      localObject1 = (List)ab.aivy;
      AppMethodBeat.o(233693);
      return localObject1;
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = ((Iterable)this.agES).iterator();
    a locala;
    while (localIterator.hasNext())
    {
      locala = (a)localIterator.next();
      if ((locala.agEU.textureId <= 0) || (locala.agEU.width <= 0) || (locala.agEU.height <= 0))
      {
        com.tencent.mm.videocomposition.d.b.s("error input " + locala.key + ", id:" + locala.agEU.textureId + " width:" + locala.agEU.width + " height:" + locala.agEU.height, new Object[0]);
      }
      else
      {
        int i;
        label234:
        c localc;
        Object localObject2;
        switch (locala.agEU.hYK)
        {
        default: 
          i = 0;
          localc = new c(locala.agEU.textureId, locala.agEU.width, locala.agEU.height, locala.agEU.agEo, i);
          localObject2 = locala.agEV;
          if (localObject2 != null)
          {
            LayoutInfo localLayoutInfo = ((c)localObject2).agEW;
            s.t(localLayoutInfo, "<set-?>");
            localc.agXv = localLayoutInfo;
            localLayoutInfo = ((c)localObject2).agEX;
            s.t(localLayoutInfo, "<set-?>");
            localc.agXw = localLayoutInfo;
            localObject2 = ((c)localObject2).agEY;
            s.t(localObject2, "<set-?>");
            localc.agXx = ((InputAnimation)localObject2);
          }
          break;
        }
        for (;;)
        {
          localc.agXs = false;
          try
          {
            localObject2 = locala.agEU.surfaceTexture;
            if (localObject2 != null) {
              ((SurfaceTexture)localObject2).updateTexImage();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.videocomposition.d.b.e(this.TAG, "update surfaceTexture error key:" + locala.key, new Object[0]);
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
          localc.agXv.centerX = (this.width / 2);
          localc.agXv.centerY = (this.height / 2);
          localc.agXv.agXz = 1;
        }
      }
    }
    localObject1 = (List)localObject1;
    AppMethodBeat.o(233693);
    return localObject1;
  }
  
  public final void jMc()
  {
    AppMethodBeat.i(233699);
    K((a)new d(this));
    super.jMc();
    AppMethodBeat.o(233699);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$EffectInputTexture;", "", "key", "", "data", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "animate", "Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "(Ljava/lang/String;Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;)V", "getAnimate", "()Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "setAnimate", "(Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;)V", "getData", "()Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class a
  {
    final h.b agEU;
    h.c agEV;
    public String key;
    
    public a(String paramString, h.b paramb, h.c paramc)
    {
      AppMethodBeat.i(233580);
      this.key = paramString;
      this.agEU = paramb;
      this.agEV = paramc;
      AppMethodBeat.o(233580);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(233618);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((!s.p(this.key, paramObject.key)) || (!s.p(this.agEU, paramObject.agEU)) || (!s.p(this.agEV, paramObject.agEV))) {}
        }
      }
      else
      {
        AppMethodBeat.o(233618);
        return true;
      }
      AppMethodBeat.o(233618);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(233610);
      Object localObject = this.key;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.agEU;
        if (localObject == null) {
          break label80;
        }
      }
      label80:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.agEV;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(233610);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(233599);
      String str = "EffectInputTexture(key=" + this.key + ", data=" + this.agEU + ", animate=" + this.agEV + ")";
      AppMethodBeat.o(233599);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$InputTextureData;", "", "textureId", "", "isOES", "", "width", "height", "rotate", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "(IZIIILandroid/graphics/SurfaceTexture;)V", "getHeight", "()I", "setHeight", "(I)V", "()Z", "setOES", "(Z)V", "getRotate", "setRotate", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureId", "setTextureId", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  static final class b
  {
    boolean agEo;
    int hYK;
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
      this.agEo = paramBoolean;
      this.width = paramInt2;
      this.height = paramInt3;
      this.hYK = paramInt4;
      this.surfaceTexture = paramSurfaceTexture;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(233611);
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
        if (this.agEo != paramObject.agEo) {
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
        if (this.hYK != paramObject.hYK) {
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
        if ((i == 0) || (!s.p(this.surfaceTexture, paramObject.surfaceTexture))) {
          break label153;
        }
        AppMethodBeat.o(233611);
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
      AppMethodBeat.o(233611);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(233596);
      String str = "InputTextureData(textureId=" + this.textureId + ", isOES=" + this.agEo + ", width=" + this.width + ", height=" + this.height + ", rotate=" + this.hYK + ", surfaceTexture=" + this.surfaceTexture + ")";
      AppMethodBeat.o(233596);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/MultiInputEffectRenderController$TextureLayoutAnimation;", "", "fromLayout", "Lcom/tencent/mm/xeffect/LayoutInfo;", "toLayout", "animate", "Lcom/tencent/mm/xeffect/InputAnimation;", "(Lcom/tencent/mm/xeffect/LayoutInfo;Lcom/tencent/mm/xeffect/LayoutInfo;Lcom/tencent/mm/xeffect/InputAnimation;)V", "getAnimate", "()Lcom/tencent/mm/xeffect/InputAnimation;", "setAnimate", "(Lcom/tencent/mm/xeffect/InputAnimation;)V", "getFromLayout", "()Lcom/tencent/mm/xeffect/LayoutInfo;", "setFromLayout", "(Lcom/tencent/mm/xeffect/LayoutInfo;)V", "getToLayout", "setToLayout", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "video_composition_release"}, k=1, mv={1, 1, 15})
  public static final class c
  {
    public LayoutInfo agEW;
    public LayoutInfo agEX;
    public InputAnimation agEY;
    
    public c(LayoutInfo paramLayoutInfo1, LayoutInfo paramLayoutInfo2, InputAnimation paramInputAnimation)
    {
      AppMethodBeat.i(233574);
      this.agEW = paramLayoutInfo1;
      this.agEX = paramLayoutInfo2;
      this.agEY = paramInputAnimation;
      AppMethodBeat.o(233574);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(233593);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((!s.p(this.agEW, paramObject.agEW)) || (!s.p(this.agEX, paramObject.agEX)) || (!s.p(this.agEY, paramObject.agEY))) {}
        }
      }
      else
      {
        AppMethodBeat.o(233593);
        return true;
      }
      AppMethodBeat.o(233593);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(233586);
      Object localObject = this.agEW;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.agEX;
        if (localObject == null) {
          break label80;
        }
      }
      label80:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.agEY;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        AppMethodBeat.o(233586);
        return (j + i * 31) * 31 + k;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(233581);
      String str = "TextureLayoutAnimation(fromLayout=" + this.agEW + ", toLayout=" + this.agEX + ", animate=" + this.agEY + ")";
      AppMethodBeat.o(233581);
      return str;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class d
    extends u
    implements a<ah>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  public static final class e
    extends u
    implements a<ah>
  {
    public e(h paramh, Bitmap paramBitmap, String paramString, h.c paramc)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class f
    extends u
    implements a<ah>
  {
    f(h paramh, int paramInt1, int paramInt2, int paramInt3, String paramString, kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class g
    extends u
    implements a<ah>
  {
    g(h.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.h
 * JD-Core Version:    0.7.0.1
 */