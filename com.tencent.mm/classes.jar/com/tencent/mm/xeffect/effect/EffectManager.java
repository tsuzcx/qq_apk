package com.tencent.mm.xeffect.effect;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/EffectManager;", "", "()V", "ptr", "", "(J)V", "effectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "<set-?>", "nPtr", "getNPtr", "()J", "addBlurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "addEffect", "effect", "addGradientBlurEffect", "Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "addTransitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "path", "", "bringToFront", "", "effectId", "clearEffect", "createEffect", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "bytes", "", "destroy", "getEffect", "nAddEffect", "effectPtr", "nBringToFront", "nCreateEffect", "", "nCreateEffectAsset", "nCreateEffectBinary", "length", "nCreateEffectPath", "nDestroy", "nInit", "nProfileData", "nRemoveEffect", "nSetDecoderFactory", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "profileData", "Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "removeEffect", "removeEffects", "setDecoderFactory", "Companion", "renderlib_release"}, k=1, mv={1, 1, 15})
public final class EffectManager
{
  public static final String TAG = "EffectManager";
  public static final a agXK;
  private final LinkedList<af> UbB;
  public long nNg;
  
  static
  {
    AppMethodBeat.i(234609);
    agXK = new a((byte)0);
    TAG = "EffectManager";
    f.load("xlabeffect");
    f.load("pag");
    IStickerDecoderFactory localIStickerDecoderFactory = (IStickerDecoderFactory)new e();
    s.t(localIStickerDecoderFactory, "factory");
    nSetDefaultFactory((IStickerDecoderFactory)new StickerDecoderFactoryWrapper(localIStickerDecoderFactory));
    AppMethodBeat.o(234609);
  }
  
  public EffectManager()
  {
    AppMethodBeat.i(234603);
    this.UbB = new LinkedList();
    this.nNg = nInit();
    AppMethodBeat.o(234603);
  }
  
  private EffectManager(long paramLong)
  {
    AppMethodBeat.i(234605);
    this.UbB = new LinkedList();
    this.nNg = paramLong;
    AppMethodBeat.o(234605);
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
  
  public final af AS(long paramLong)
  {
    AppMethodBeat.i(234643);
    Iterator localIterator = ((Iterable)this.UbB).iterator();
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
      AppMethodBeat.o(234643);
      return localObject;
      i = 0;
      break label53;
      label75:
      break;
      localObject = null;
    }
  }
  
  public final void AT(long paramLong)
  {
    AppMethodBeat.i(234651);
    for (;;)
    {
      int j;
      synchronized (this.UbB)
      {
        Object localObject1 = ((List)this.UbB).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((af)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label194;
            if (i >= 0)
            {
              XEffectLog.i(TAG, "removeEffect ptr:" + ((af)this.UbB.get(i)).ptr + ", effectId:" + paramLong, new Object[0]);
              ((af)this.UbB.get(i)).id = 0L;
              this.UbB.remove(i);
            }
            nRemoveEffect(this.nNg, paramLong);
            localObject1 = ah.aiuX;
            AppMethodBeat.o(234651);
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
  
  public final void AU(long paramLong)
  {
    AppMethodBeat.i(234661);
    for (;;)
    {
      int j;
      synchronized (this.UbB)
      {
        Object localObject1 = ((List)this.UbB).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((af)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label156;
            if (i >= 0)
            {
              localObject1 = this.UbB.remove(i);
              s.r(localObject1, "effectList.removeAt(index)");
              localObject1 = (af)localObject1;
              this.UbB.add(localObject1);
            }
            nBringToFront(this.nNg, paramLong);
            localObject1 = ah.aiuX;
            AppMethodBeat.o(234661);
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
    AppMethodBeat.i(234613);
    s.t(paramj, "type");
    paramj = a.a(nCreateEffect(this.nNg, paramj.ordinal()), paramj);
    AppMethodBeat.o(234613);
    return paramj;
  }
  
  public final af a(j paramj, AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(234622);
    s.t(paramj, "type");
    s.t(paramAssetManager, "asset");
    s.t(paramString, "assetPath");
    paramj = a.a(nCreateEffectAsset(this.nNg, paramj.ordinal(), paramAssetManager, paramString), paramj);
    AppMethodBeat.o(234622);
    return paramj;
  }
  
  public final af a(j paramj, String paramString)
  {
    AppMethodBeat.i(234617);
    s.t(paramj, "type");
    s.t(paramString, "path");
    paramj = a.a(nCreateEffectPath(this.nNg, paramj.ordinal(), paramString), paramj);
    AppMethodBeat.o(234617);
    return paramj;
  }
  
  public final af b(af paramaf)
  {
    AppMethodBeat.i(234628);
    if (paramaf != null)
    {
      long l = nAddEffect(this.nNg, paramaf.ptr);
      paramaf.id = l;
      XEffectLog.i(TAG, "addEffect ptr:" + paramaf.ptr + ", effectId:" + l, new Object[0]);
    }
    synchronized (this.UbB)
    {
      this.UbB.add(paramaf);
      AppMethodBeat.o(234628);
      return paramaf;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(234654);
    s.t(paramj, "type");
    Collection localCollection;
    for (;;)
    {
      synchronized (this.UbB)
      {
        Object localObject1 = (Iterable)this.UbB;
        localCollection = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (((af)localObject2).jQi() == paramj)
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
    paramj = ah.aiuX;
    AppMethodBeat.o(234654);
  }
  
  public final void c(af paramaf)
  {
    AppMethodBeat.i(234646);
    if (paramaf != null) {
      synchronized (this.UbB)
      {
        this.UbB.remove(paramaf);
        nRemoveEffect(this.nNg, paramaf.id);
        paramaf = ah.aiuX;
        AppMethodBeat.o(234646);
        return;
      }
    }
    AppMethodBeat.o(234646);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(234667);
    jQl();
    nDestroy(this.nNg);
    AppMethodBeat.o(234667);
  }
  
  public final b jQj()
  {
    AppMethodBeat.i(234633);
    Object localObject = a(j.agYb);
    if (localObject == null)
    {
      localObject = new kotlin.w("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.BlurEffect");
      AppMethodBeat.o(234633);
      throw ((Throwable)localObject);
    }
    localObject = (b)localObject;
    b((af)localObject);
    AppMethodBeat.o(234633);
    return localObject;
  }
  
  public final l jQk()
  {
    AppMethodBeat.i(234638);
    Object localObject = a(j.agXZ);
    if (localObject == null)
    {
      localObject = new kotlin.w("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.GradientBlurEffect");
      AppMethodBeat.o(234638);
      throw ((Throwable)localObject);
    }
    localObject = (l)localObject;
    ((l)localObject).setRadius(20.0F);
    b((af)localObject);
    AppMethodBeat.o(234638);
    return localObject;
  }
  
  public final void jQl()
  {
    AppMethodBeat.i(234658);
    synchronized (this.UbB)
    {
      Iterator localIterator = ((Iterable)this.UbB).iterator();
      if (localIterator.hasNext())
      {
        af localaf = (af)localIterator.next();
        nRemoveEffect(this.nNg, localaf.id);
        localaf.id = 0L;
      }
    }
    this.UbB.clear();
    ah localah = ah.aiuX;
    AppMethodBeat.o(234658);
  }
  
  public final EffectProfileData jQm()
  {
    AppMethodBeat.i(234663);
    EffectProfileData localEffectProfileData = new EffectProfileData(nProfileData(this.nNg));
    AppMethodBeat.o(234663);
    return localEffectProfileData;
  }
  
  public final native long nCreateEffectBinary(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2);
  
  public final native void nSetDecoderFactory(long paramLong, IStickerDecoderFactory paramIStickerDecoderFactory);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/xeffect/effect/EffectManager$Companion;", "", "()V", "TAG", "", "createEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "createFromExternalPtr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "nSetDefaultFactory", "", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "setDefaultFactory", "renderlib_release"}, k=1, mv={1, 1, 15})
  public static final class a
  {
    public static EffectManager AV(long paramLong)
    {
      AppMethodBeat.i(234581);
      EffectManager localEffectManager = new EffectManager(paramLong, (byte)0);
      AppMethodBeat.o(234581);
      return localEffectManager;
    }
    
    public static af a(long paramLong, j paramj)
    {
      AppMethodBeat.i(234580);
      XEffectLog.i(EffectManager.access$getTAG$cp(), "create effect ptr:" + paramLong + ", type:" + paramj, new Object[0]);
      if (paramLong == 0L)
      {
        AppMethodBeat.o(234580);
        return null;
      }
      switch (g.$EnumSwitchMapping$0[paramj.ordinal()])
      {
      default: 
        AppMethodBeat.o(234580);
        return null;
      case 1: 
        paramj = (af)new v(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 2: 
        paramj = (af)new y(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 3: 
        paramj = (af)new x(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 4: 
        paramj = (af)new w(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 5: 
        paramj = (af)new u(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 6: 
        paramj = (af)new n(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 7: 
        paramj = (af)new ac(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 8: 
        paramj = (af)new a(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 9: 
        paramj = (af)new r(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 10: 
        paramj = (af)new c(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 11: 
        paramj = (af)new d(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 12: 
        paramj = (af)new z(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 13: 
        paramj = (af)new m(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 14: 
        paramj = (af)new ag(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 15: 
        paramj = (af)new l(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 16: 
        paramj = (af)new k(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      case 17: 
        paramj = (af)new b(paramLong);
        AppMethodBeat.o(234580);
        return paramj;
      }
      paramj = (af)new q(paramLong);
      AppMethodBeat.o(234580);
      return paramj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.EffectManager
 * JD-Core Version:    0.7.0.1
 */