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
import org.libpag.PAGFont;

@kotlin.l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/EffectManager;", "", "()V", "effectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "<set-?>", "", "nPtr", "getNPtr", "()J", "addEffect", "effect", "bringToFront", "", "effectId", "clearEffect", "createEffect", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "", "bytes", "", "path", "destroy", "getEffect", "nAddEffect", "ptr", "effectPtr", "nBringToFront", "nCreateEffect", "", "nCreateEffectAsset", "nCreateEffectBinary", "length", "nCreateEffectPath", "nDestroy", "nInit", "nProfileData", "nRemoveEffect", "nSetDecoderFactory", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "profileData", "Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "removeEffect", "removeEffects", "setDecoderFactory", "Companion", "renderlib_release"})
public final class EffectManager
{
  public static final a RxS;
  private static final String TAG = "EffectManager";
  private final LinkedList<ad> GAp;
  public long Rxd;
  
  static
  {
    AppMethodBeat.i(237069);
    RxS = new a((byte)0);
    TAG = "EffectManager";
    com.tencent.mm.xeffect.d.load("xlabeffect");
    com.tencent.mm.xeffect.d.load("pag");
    PAGFont.RegisterFallbackFonts();
    a.b((IStickerDecoderFactory)new e());
    AppMethodBeat.o(237069);
  }
  
  public EffectManager()
  {
    AppMethodBeat.i(237068);
    this.GAp = new LinkedList();
    this.Rxd = nInit();
    AppMethodBeat.o(237068);
  }
  
  private final native long nAddEffect(long paramLong1, long paramLong2);
  
  private final native void nBringToFront(long paramLong1, long paramLong2);
  
  private final native long nCreateEffect(long paramLong, int paramInt);
  
  private final native long nCreateEffectAsset(long paramLong, int paramInt, AssetManager paramAssetManager, String paramString);
  
  private final native long nCreateEffectBinary(long paramLong1, int paramInt, byte[] paramArrayOfByte, long paramLong2);
  
  private final native long nCreateEffectPath(long paramLong, int paramInt, String paramString);
  
  private final native void nDestroy(long paramLong);
  
  private final native long nInit();
  
  private final native long nProfileData(long paramLong);
  
  private final native void nRemoveEffect(long paramLong1, long paramLong2);
  
  private final native void nSetDecoderFactory(long paramLong, IStickerDecoderFactory paramIStickerDecoderFactory);
  
  private static final native void nSetDefaultFactory(IStickerDecoderFactory paramIStickerDecoderFactory);
  
  public final ad Os(long paramLong)
  {
    AppMethodBeat.i(237061);
    Iterator localIterator = ((Iterable)this.GAp).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((ad)localObject).id == paramLong)
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
      localObject = (ad)localObject;
      AppMethodBeat.o(237061);
      return localObject;
      i = 0;
      break label53;
      label75:
      break;
      localObject = null;
    }
  }
  
  public final void Ot(long paramLong)
  {
    AppMethodBeat.i(237062);
    for (;;)
    {
      int j;
      synchronized (this.GAp)
      {
        Object localObject1 = ((List)this.GAp).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ad)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label194;
            if (i >= 0)
            {
              XEffectLog.i(TAG, "removeEffect ptr:" + ((ad)this.GAp.get(i)).ptr + ", effectId:" + paramLong, new Object[0]);
              ((ad)this.GAp.get(i)).id = 0L;
              this.GAp.remove(i);
            }
            nRemoveEffect(this.Rxd, paramLong);
            localObject1 = kotlin.x.SXb;
            AppMethodBeat.o(237062);
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
  
  public final void Ou(long paramLong)
  {
    AppMethodBeat.i(237065);
    for (;;)
    {
      int j;
      synchronized (this.GAp)
      {
        Object localObject1 = ((List)this.GAp).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          if (((ad)((Iterator)localObject1).next()).id == paramLong)
          {
            j = 1;
            break label156;
            if (i >= 0)
            {
              localObject1 = this.GAp.remove(i);
              p.g(localObject1, "effectList.removeAt(index)");
              localObject1 = (ad)localObject1;
              this.GAp.add(localObject1);
            }
            nBringToFront(this.Rxd, paramLong);
            localObject1 = kotlin.x.SXb;
            AppMethodBeat.o(237065);
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
  
  public final ad a(ad paramad)
  {
    AppMethodBeat.i(237060);
    if (paramad != null)
    {
      long l = nAddEffect(this.Rxd, paramad.ptr);
      paramad.id = l;
      XEffectLog.i(TAG, "addEffect ptr:" + paramad.ptr + ", effectId:" + l, new Object[0]);
    }
    synchronized (this.GAp)
    {
      this.GAp.add(paramad);
      AppMethodBeat.o(237060);
      return paramad;
    }
  }
  
  public final ad a(j paramj)
  {
    AppMethodBeat.i(237056);
    p.h(paramj, "type");
    paramj = a.a(nCreateEffect(this.Rxd, paramj.ordinal()), paramj);
    AppMethodBeat.o(237056);
    return paramj;
  }
  
  public final ad a(j paramj, AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(237059);
    p.h(paramj, "type");
    p.h(paramAssetManager, "asset");
    p.h(paramString, "assetPath");
    paramj = a.a(nCreateEffectAsset(this.Rxd, paramj.ordinal(), paramAssetManager, paramString), paramj);
    AppMethodBeat.o(237059);
    return paramj;
  }
  
  public final ad a(j paramj, String paramString)
  {
    AppMethodBeat.i(237057);
    p.h(paramj, "type");
    p.h(paramString, "path");
    paramj = a.a(nCreateEffectPath(this.Rxd, paramj.ordinal(), paramString), paramj);
    AppMethodBeat.o(237057);
    return paramj;
  }
  
  public final ad a(j paramj, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(237058);
    p.h(paramj, "type");
    p.h(paramArrayOfByte, "bytes");
    long l = nCreateEffectBinary(this.Rxd, paramj.ordinal(), paramArrayOfByte, paramArrayOfByte.length);
    ad localad = a.a(l, paramj);
    XEffectLog.i(TAG, "create effect binary ptr:" + l + ", type:" + paramj + ", " + paramArrayOfByte.length, new Object[0]);
    AppMethodBeat.o(237058);
    return localad;
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(237063);
    p.h(paramj, "type");
    Collection localCollection;
    for (;;)
    {
      synchronized (this.GAp)
      {
        Object localObject1 = (Iterable)this.GAp;
        localCollection = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        Object localObject2 = ((Iterator)localObject1).next();
        if (((ad)localObject2).hiu() == paramj)
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
      Ot(((ad)paramj.next()).id);
    }
    paramj = kotlin.x.SXb;
    AppMethodBeat.o(237063);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(237067);
    hiv();
    nDestroy(this.Rxd);
    AppMethodBeat.o(237067);
  }
  
  public final void hiv()
  {
    AppMethodBeat.i(237064);
    synchronized (this.GAp)
    {
      Iterator localIterator = ((Iterable)this.GAp).iterator();
      if (localIterator.hasNext())
      {
        ad localad = (ad)localIterator.next();
        nRemoveEffect(this.Rxd, localad.id);
        localad.id = 0L;
      }
    }
    this.GAp.clear();
    kotlin.x localx = kotlin.x.SXb;
    AppMethodBeat.o(237064);
  }
  
  public final EffectProfileData hiw()
  {
    AppMethodBeat.i(237066);
    EffectProfileData localEffectProfileData = new EffectProfileData(nProfileData(this.Rxd));
    AppMethodBeat.o(237066);
    return localEffectProfileData;
  }
  
  @kotlin.l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/xeffect/effect/EffectManager$Companion;", "", "()V", "TAG", "", "createEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "nSetDefaultFactory", "", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "setDefaultFactory", "renderlib_release"})
  public static final class a
  {
    static ad a(long paramLong, j paramj)
    {
      AppMethodBeat.i(237055);
      XEffectLog.i(EffectManager.access$getTAG$cp(), "create effect ptr:" + paramLong + ", type:" + paramj, new Object[0]);
      if (paramLong == 0L)
      {
        AppMethodBeat.o(237055);
        return null;
      }
      switch (g.$EnumSwitchMapping$0[paramj.ordinal()])
      {
      default: 
        AppMethodBeat.o(237055);
        return null;
      case 1: 
        paramj = (ad)new t(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 2: 
        paramj = (ad)new w(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 3: 
        paramj = (ad)new v(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 4: 
        paramj = (ad)new u(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 5: 
        paramj = (ad)new s(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 6: 
        paramj = (ad)new n(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 7: 
        paramj = (ad)new aa(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 8: 
        paramj = (ad)new a(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 9: 
        paramj = (ad)new c(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 10: 
        paramj = (ad)new d(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 11: 
        paramj = (ad)new x(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 12: 
        paramj = (ad)new m(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 13: 
        paramj = (ad)new ae(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 14: 
        paramj = (ad)new l(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      case 15: 
        paramj = (ad)new k(paramLong);
        AppMethodBeat.o(237055);
        return paramj;
      }
      paramj = (ad)new b(paramLong);
      AppMethodBeat.o(237055);
      return paramj;
    }
    
    public static void b(IStickerDecoderFactory paramIStickerDecoderFactory)
    {
      AppMethodBeat.i(237054);
      p.h(paramIStickerDecoderFactory, "factory");
      EffectManager.a((IStickerDecoderFactory)new StickerDecoderFactoryWrapper(paramIStickerDecoderFactory));
      AppMethodBeat.o(237054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.xeffect.effect.EffectManager
 * JD-Core Version:    0.7.0.1
 */