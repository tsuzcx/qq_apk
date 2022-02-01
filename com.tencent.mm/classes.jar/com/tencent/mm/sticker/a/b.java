package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.cqw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "checkingSize", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  private static final String VbL;
  private static final String VbM;
  private static final String VbN;
  private static final cqw VbO;
  static final cqw VbP;
  private static int VbQ;
  private static a<x> VbR;
  public static final b VbS;
  
  static
  {
    AppMethodBeat.i(105971);
    VbS = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (MMApplicationContext.isMainProcess()) {
      localObject = hvi();
    }
    for (;;)
    {
      VbL = (String)localObject;
      VbM = VbL + "recommend.proto";
      VbN = VbL + "history.proto";
      VbO = new cqw();
      VbP = new cqw();
      localObject = u.aY(VbM, 0, -1);
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
        VbO.parseFrom((byte[])localObject);
        Log.i(TAG, "parseRecommend: " + VbM + ' ' + VbO.Tyo.size());
        hve();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)j.a(MMApplicationContext.getPackageName(), null, a.class);
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
  
  public static void an(a<x> parama)
  {
    VbR = parama;
  }
  
  public static void bBj()
  {
    AppMethodBeat.i(105966);
    Object localObject = VbR;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = VbP.toByteArray();
    u.bBD(VbL);
    u.H(VbN, (byte[])localObject);
    Log.i(TAG, "saveHistory: " + VbP.Tyo.size());
    AppMethodBeat.o(105966);
  }
  
  public static void f(cqv paramcqv)
  {
    AppMethodBeat.i(232830);
    p.k(paramcqv, "lensInfo");
    Object localObject = VbP.Tyo;
    p.j(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!p.h(((cqv)((Iterator)localObject).next()).LensId, paramcqv.LensId)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < VbP.Tyo.size())) {
        VbP.Tyo.remove(i);
      }
      VbP.Tyo.add(0, paramcqv);
      if (VbP.Tyo.size() > 4) {
        VbP.Tyo.remove(VbP.Tyo.size() - 1);
      }
      bBj();
      AppMethodBeat.o(232830);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void hve()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = u.aY(VbN, 0, -1);
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
            VbP.parseFrom((byte[])localObject1);
            localObject1 = VbP.Tyo;
            p.j(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((cqv)localObject3).LensId;
                if ((localCharSequence == null) || (n.ba(localCharSequence)))
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
            VbP.Tyo.clear();
            VbP.Tyo.addAll((Collection)localList);
            Log.i(TAG, "parseHistory: " + VbN + ' ' + VbP.Tyo.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static List<cqv> hvf()
  {
    AppMethodBeat.i(105967);
    Object localObject = VbP.Tyo;
    p.j(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void hvg()
  {
    AppMethodBeat.i(105968);
    Log.i(TAG, "checkHistory: " + VbQ);
    if (VbQ > 0)
    {
      AppMethodBeat.o(105968);
      return;
    }
    Object localObject1 = VbP.Tyo;
    p.j(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      cqv localcqv = (cqv)((Iterator)localObject1).next();
      VbQ += 1;
      Log.i(TAG, "checkHistory: " + localcqv.LensId);
      Object localObject2 = com.tencent.mm.sticker.c.d.VbW;
      localObject2 = localcqv.LensId;
      p.j(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (c)new b(localcqv));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void hvh()
  {
    AppMethodBeat.i(105969);
    VbP.Tyo.clear();
    bBj();
    AppMethodBeat.o(105969);
  }
  
  private static String hvi()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    localObject2 = ((f)localObject2).aHp().get(ar.a.Vxh, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        ((f)localObject2).aHp().set(ar.a.Vxh, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.aSE() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void js(List<? extends cqv> paramList)
  {
    AppMethodBeat.i(105964);
    p.k(paramList, "list");
    VbO.Tyo.clear();
    VbO.Tyo.addAll((Collection)paramList);
    paramList = VbO.toByteArray();
    u.bBD(VbL);
    u.H(VbM, paramList);
    Log.i(TAG, "saveRecommend: " + VbO.Tyo.size());
    AppMethodBeat.o(105964);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"})
  public static final class a
    implements m<Bundle, Bundle>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements c
  {
    b(cqv paramcqv) {}
    
    public final void a(final int paramInt, final cqv paramcqv)
    {
      AppMethodBeat.i(105962);
      b localb = b.VbS;
      Log.i(b.hvk(), "onResult: " + this.VbT.LensId + ", " + paramInt);
      com.tencent.mm.ae.d.uiThread((a)new a(this, paramInt, paramcqv));
      AppMethodBeat.o(105962);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(b.b paramb, int paramInt, cqv paramcqv)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.a.b
 * JD-Core Version:    0.7.0.1
 */