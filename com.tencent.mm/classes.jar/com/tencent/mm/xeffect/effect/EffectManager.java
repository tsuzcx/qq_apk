package com.tencent.mm.xeffect.effect;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.XEffectLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/EffectManager;", "", "()V", "ptr", "", "(J)V", "effectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "<set-?>", "nPtr", "getNPtr", "()J", "addBlurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "addEffect", "effect", "addGradientBlurEffect", "Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "addTransitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "path", "", "bringToFront", "", "effectId", "clearEffect", "createEffect", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "bytes", "", "destroy", "getEffect", "nAddEffect", "effectPtr", "nBringToFront", "nCreateEffect", "", "nCreateEffectAsset", "nCreateEffectBinary", "length", "nCreateEffectPath", "nDestroy", "nInit", "nProfileData", "nRemoveEffect", "nSetDecoderFactory", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "profileData", "Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "removeEffect", "removeEffects", "setDecoderFactory", "Companion", "renderlib_release"})
public final class EffectManager
{
  public static final String TAG = "EffectManager";
  public static final a YZy;
  public long NmO;
  private final LinkedList<af> NnV;
  
  static
  {
    AppMethodBeat.i(195744);
    YZy = new a((byte)0);
    TAG = "EffectManager";
    com.tencent.mm.xeffect.e.load("xlabeffect");
    com.tencent.mm.xeffect.e.load("pag");
    IStickerDecoderFactory localIStickerDecoderFactory = (IStickerDecoderFactory)new e();
    p.k(localIStickerDecoderFactory, "factory");
    nSetDefaultFactory((IStickerDecoderFactory)new StickerDecoderFactoryWrapper(localIStickerDecoderFactory));
    AppMethodBeat.o(195744);
  }
  
  public EffectManager()
  {
    AppMethodBeat.i(195742);
    this.NnV = new LinkedList();
    this.NmO = nInit();
    AppMethodBeat.o(195742);
  }
  
  private EffectManager(long paramLong)
  {
    AppMethodBeat.i(195743);
    this.NnV = new LinkedList();
    this.NmO = paramLong;
    AppMethodBeat.o(195743);
  }
  
  private final native long nAddEffect(long paramLong1, long paramLong2);
  
  private final native void nBringToFront(long paramLong1, long paramLong2);
  
  private final native long nCreateEffect(long paramLong, int paramInt);
  
  private final native long nCreateEffectAsset(long paramLong, int paramInt, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateEffectPath(long paramLong, int paramInt, String paramString);
  
  private final native void nDestroy(long paramLong);
  
  private final native long nInit();
  
  private final native long nProfileData(long paramLong);
  
  private final native void nRemoveEffect(long paramLong1, long paramLong2);
  
  private static final native void nSetDefaultFactory(IStickerDecoderFactory paramIStickerDecoderFactory);
  
  public final af WH(long paramLong)
  {
    AppMethodBeat.i(195728);
    Iterator localIterator = ((Iterable)this.NnV).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((af)localObject).id == paramLong)
      {
        i = 1;
        label53:
        if (i == 0) {
          break label75;
        }
      }
    }
    for (;;)
    {
      localObject = (af)localObject;
      AppMethodBeat.o(195728);
      return localObject;
      i = 0;
      break label53;
      label75:
      break;
      localObject = null;
    }
  }
  
  public final void WI(long paramLong)
  {
    AppMethodBeat.i(195730);
    for (;;)
    {
      int j;
      synchronized (this.NnV)
      {
        Object localObject1 = ((List)this.NnV).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((af)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label194;
            if (i >= 0)
            {
              XEffectLog.i(TAG, "removeEffect ptr:" + ((af)this.NnV.get(i)).ptr + ", effectId:" + paramLong, new Object[0]);
              ((af)this.NnV.get(i)).id = 0L;
              this.NnV.remove(i);
            }
            nRemoveEffect(this.NmO, paramLong);
            localObject1 = kotlin.x.aazN;
            AppMethodBeat.o(195730);
          }
          else
          {
            j = 0;
            break label194;
            i += 1;
          }
        }
        else {
          i = -1;
        }
      }
      label194:
      if (j == 0) {}
    }
  }
  
  public final void WJ(long paramLong)
  {
    AppMethodBeat.i(195733);
    for (;;)
    {
      int j;
      synchronized (this.NnV)
      {
        Object localObject1 = ((List)this.NnV).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((af)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label156;
            if (i >= 0)
            {
              localObject1 = this.NnV.remove(i);
              p.j(localObject1, "effectList.removeAt(index)");
              localObject1 = (af)localObject1;
              this.NnV.add(localObject1);
            }
            nBringToFront(this.NmO, paramLong);
            localObject1 = kotlin.x.aazN;
            AppMethodBeat.o(195733);
          }
          else
          {
            j = 0;
            break label156;
            i += 1;
          }
        }
        else {
          i = -1;
        }
      }
      label156:
      if (j == 0) {}
    }
  }
  
  public final af a(j paramj)
  {
    AppMethodBeat.i(195718);
    p.k(paramj, "type");
    paramj = a.a(nCreateEffect(this.NmO, paramj.ordinal()), paramj);
    AppMethodBeat.o(195718);
    return paramj;
  }
  
  public final af a(j paramj, AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(195721);
    p.k(paramj, "type");
    p.k(paramAssetManager, "asset");
    p.k(paramString, "assetPath");
    paramj = a.a(nCreateEffectAsset(this.NmO, paramj.ordinal(), paramAssetManager, paramString), paramj);
    AppMethodBeat.o(195721);
    return paramj;
  }
  
  public final af a(j paramj, String paramString)
  {
    AppMethodBeat.i(195720);
    p.k(paramj, "type");
    p.k(paramString, "path");
    paramj = a.a(nCreateEffectPath(this.NmO, paramj.ordinal(), paramString), paramj);
    AppMethodBeat.o(195720);
    return paramj;
  }
  
  public final af b(af paramaf)
  {
    AppMethodBeat.i(195723);
    if (paramaf != null)
    {
      long l = nAddEffect(this.NmO, paramaf.ptr);
      paramaf.id = l;
      XEffectLog.i(TAG, "addEffect ptr:" + paramaf.ptr + ", effectId:" + l, new Object[0]);
    }
    synchronized (this.NnV)
    {
      this.NnV.add(paramaf);
      AppMethodBeat.o(195723);
      return paramaf;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(195731);
    p.k(paramj, "type");
    Collection localCollection;
    for (;;)
    {
      synchronized (this.NnV)
      {
        Object localObject1 = (Iterable)this.NnV;
        localCollection = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (((af)localObject2).ika() == paramj)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject2);
        }
      }
      int i = 0;
    }
    paramj = ((Iterable)localCollection).iterator();
    while (paramj.hasNext()) {
      c((af)paramj.next());
    }
    paramj = kotlin.x.aazN;
    AppMethodBeat.o(195731);
  }
  
  public final void c(af paramaf)
  {
    AppMethodBeat.i(195729);
    if (paramaf != null) {
      synchronized (this.NnV)
      {
        this.NnV.remove(paramaf);
        nRemoveEffect(this.NmO, paramaf.id);
        paramaf = kotlin.x.aazN;
        AppMethodBeat.o(195729);
        return;
      }
    }
    AppMethodBeat.o(195729);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(195736);
    ike();
    nDestroy(this.NmO);
    AppMethodBeat.o(195736);
  }
  
  public final b ikc()
  {
    AppMethodBeat.i(195725);
    Object localObject = a(j.YZP);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.BlurEffect");
      AppMethodBeat.o(195725);
      throw ((Throwable)localObject);
    }
    localObject = (b)localObject;
    b((af)localObject);
    AppMethodBeat.o(195725);
    return localObject;
  }
  
  public final l ikd()
  {
    AppMethodBeat.i(195727);
    Object localObject = a(j.YZN);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.GradientBlurEffect");
      AppMethodBeat.o(195727);
      throw ((Throwable)localObject);
    }
    localObject = (l)localObject;
    ((l)localObject).setRadius(20.0F);
    b((af)localObject);
    AppMethodBeat.o(195727);
    return localObject;
  }
  
  public final void ike()
  {
    AppMethodBeat.i(195732);
    synchronized (this.NnV)
    {
      Iterator localIterator = ((Iterable)this.NnV).iterator();
      if (localIterator.hasNext())
      {
        af localaf = (af)localIterator.next();
        nRemoveEffect(this.NmO, localaf.id);
        localaf.id = 0L;
      }
    }
    this.NnV.clear();
    kotlin.x localx = kotlin.x.aazN;
    AppMethodBeat.o(195732);
  }
  
  public final EffectProfileData ikf()
  {
    AppMethodBeat.i(195735);
    EffectProfileData localEffectProfileData = new EffectProfileData(nProfileData(this.NmO));
    AppMethodBeat.o(195735);
    return localEffectProfileData;
  }
  
  public final native long nCreateEffectBinary(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2);
  
  public final native void nSetDecoderFactory(long paramLong, IStickerDecoderFactory paramIStickerDecoderFactory);
  
  @kotlin.l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/xeffect/effect/EffectManager$Companion;", "", "()V", "TAG", "", "createEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "createFromExternalPtr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "nSetDefaultFactory", "", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "setDefaultFactory", "renderlib_release"})
  public static final class a
  {
    public static EffectManager WK(long paramLong)
    {
      AppMethodBeat.i(195709);
      EffectManager localEffectManager = new EffectManager(paramLong, (byte)0);
      AppMethodBeat.o(195709);
      return localEffectManager;
    }
    
    public static af a(long paramLong, j paramj)
    {
      AppMethodBeat.i(195706);
      XEffectLog.i(EffectManager.access$getTAG$cp(), "create effect ptr:" + paramLong + ", type:" + paramj, new Object[0]);
      if (paramLong == 0L)
      {
        AppMethodBeat.o(195706);
        return null;
      }
      switch (g.$EnumSwitchMapping$0[paramj.ordinal()])
      {
      default: 
        AppMethodBeat.o(195706);
        return null;
      case 1: 
        paramj = (af)new v(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 2: 
        paramj = (af)new y(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 3: 
        paramj = (af)new x(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 4: 
        paramj = (af)new w(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 5: 
        paramj = (af)new u(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 6: 
        paramj = (af)new n(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 7: 
        paramj = (af)new ac(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 8: 
        paramj = (af)new a(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 9: 
        paramj = (af)new r(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 10: 
        paramj = (af)new c(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 11: 
        paramj = (af)new d(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 12: 
        paramj = (af)new z(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 13: 
        paramj = (af)new m(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 14: 
        paramj = (af)new ag(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 15: 
        paramj = (af)new l(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 16: 
        paramj = (af)new k(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      case 17: 
        paramj = (af)new b(paramLong);
        AppMethodBeat.o(195706);
        return paramj;
      }
      paramj = (af)new q(paramLong);
      AppMethodBeat.o(195706);
      return paramj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.EffectManager
 * JD-Core Version:    0.7.0.1
 */