package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "checkingSize", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String NOb;
  private static final String NOc;
  private static final String NOd;
  private static final cia NOe;
  static final cia NOf;
  private static int NOg = 0;
  private static a<x> NOh;
  public static final b NOi;
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  
  static
  {
    AppMethodBeat.i(105971);
    NOi = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (MMApplicationContext.isMainProcess()) {
      localObject = gzi();
    }
    for (;;)
    {
      NOb = (String)localObject;
      NOc = NOb + "recommend.proto";
      NOd = NOb + "history.proto";
      NOe = new cia();
      NOf = new cia();
      localObject = s.aW(NOc, 0, -1);
      int i;
      if (localObject != null)
      {
        if (localObject.length != 0) {
          break label226;
        }
        i = 1;
        label122:
        if (i != 0) {
          break label231;
        }
        i = 1;
        if (i == 0) {}
      }
      try
      {
        NOe.parseFrom((byte[])localObject);
        Log.i(TAG, "parseRecommend: " + NOc + ' ' + NOe.Mnt.size());
        gze();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)h.a(MMApplicationContext.getPackageName(), null, a.class);
        if (localObject != null)
        {
          String str = ((Bundle)localObject).getString("data");
          localObject = str;
          if (str != null) {
            continue;
          }
        }
        localObject = "";
        continue;
        label226:
        i = 0;
        break label122;
        label231:
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void ae(a<x> parama)
  {
    NOh = parama;
  }
  
  public static void bqy()
  {
    AppMethodBeat.i(105966);
    Object localObject = NOh;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = NOf.toByteArray();
    s.boN(NOb);
    s.C(NOd, (byte[])localObject);
    Log.i(TAG, "saveHistory: " + NOf.Mnt.size());
    AppMethodBeat.o(105966);
  }
  
  public static void f(chz paramchz)
  {
    AppMethodBeat.i(194232);
    p.h(paramchz, "lensInfo");
    Object localObject = NOf.Mnt;
    p.g(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!p.j(((chz)((Iterator)localObject).next()).Lso, paramchz.Lso)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < NOf.Mnt.size())) {
        NOf.Mnt.remove(i);
      }
      NOf.Mnt.add(0, paramchz);
      if (NOf.Mnt.size() > 4) {
        NOf.Mnt.remove(NOf.Mnt.size() - 1);
      }
      bqy();
      AppMethodBeat.o(194232);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void gze()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = s.aW(NOd, 0, -1);
    if (localObject1 != null)
    {
      int i;
      if (localObject1.length == 0) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          i = 1;
          if (i == 0) {}
        }
        else
        {
          try
          {
            NOf.parseFrom((byte[])localObject1);
            localObject1 = NOf.Mnt;
            p.g(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((chz)localObject3).Lso;
                if ((localCharSequence == null) || (n.aL(localCharSequence)))
                {
                  i = 1;
                  if (i != 0) {
                    break label179;
                  }
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  ((Collection)localObject1).add(localObject3);
                  continue;
                  i = 0;
                  break;
                  i = 0;
                }
              }
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
              continue;
              i = 0;
              continue;
              label179:
              i = 0;
            }
            List localList = (List)localException;
            NOf.Mnt.clear();
            NOf.Mnt.addAll((Collection)localList);
            Log.i(TAG, "parseHistory: " + NOd + ' ' + NOf.Mnt.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static List<chz> gzf()
  {
    AppMethodBeat.i(105967);
    Object localObject = NOf.Mnt;
    p.g(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void gzg()
  {
    AppMethodBeat.i(105968);
    Log.i(TAG, "checkHistory: " + NOg);
    if (NOg > 0)
    {
      AppMethodBeat.o(105968);
      return;
    }
    Object localObject1 = NOf.Mnt;
    p.g(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      chz localchz = (chz)((Iterator)localObject1).next();
      NOg += 1;
      Log.i(TAG, "checkHistory: " + localchz.Lso);
      Object localObject2 = com.tencent.mm.sticker.c.d.NOm;
      localObject2 = localchz.Lso;
      p.g(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (c)new b(localchz));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void gzh()
  {
    AppMethodBeat.i(105969);
    NOf.Mnt.clear();
    bqy();
    AppMethodBeat.o(105969);
  }
  
  private static String gzi()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).azQ().get(ar.a.OiR, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = g.aAh();
        p.g(localObject2, "MMKernel.storage()");
        ((e)localObject2).azQ().set(ar.a.OiR, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.aKC() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void iA(List<? extends chz> paramList)
  {
    AppMethodBeat.i(105964);
    p.h(paramList, "list");
    NOe.Mnt.clear();
    NOe.Mnt.addAll((Collection)paramList);
    paramList = NOe.toByteArray();
    s.boN(NOb);
    s.C(NOc, paramList);
    Log.i(TAG, "saveRecommend: " + NOe.Mnt.size());
    AppMethodBeat.o(105964);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"})
  public static final class a
    implements k<Bundle, Bundle>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements c
  {
    b(chz paramchz) {}
    
    public final void a(final int paramInt, final chz paramchz)
    {
      AppMethodBeat.i(105962);
      b localb = b.NOi;
      Log.i(b.gzk(), "onResult: " + this.NOj.Lso + ", " + paramInt);
      com.tencent.mm.ac.d.h((a)new a(this, paramInt, paramchz));
      AppMethodBeat.o(105962);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(b.b paramb, int paramInt, chz paramchz)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sticker.a.b
 * JD-Core Version:    0.7.0.1
 */