package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String FdC;
  private static final String FdD;
  private static final String FdE;
  private static final blq FdF;
  static final blq FdG;
  private static a<y> FdH;
  public static final b FdI;
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  
  static
  {
    AppMethodBeat.i(105971);
    FdI = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (aj.cbe()) {
      localObject = eJk();
    }
    for (;;)
    {
      FdC = (String)localObject;
      FdD = FdC + "recommend.proto";
      FdE = FdC + "history.proto";
      FdF = new blq();
      FdG = new blq();
      localObject = i.aR(FdD, 0, -1);
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
        FdF.parseFrom((byte[])localObject);
        ad.i(TAG, "parseRecommend: " + FdD + ' ' + FdF.DJs.size());
        eJf();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)h.a(aj.getPackageName(), null, a.class);
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
          ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void B(a<y> parama)
  {
    FdH = parama;
  }
  
  private static void eJf()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = i.aR(FdE, 0, -1);
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
            FdG.parseFrom((byte[])localObject1);
            localObject1 = FdG.DJs;
            d.g.b.k.g(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((blp)localObject3).Dds;
                if ((localCharSequence == null) || (n.aC(localCharSequence)))
                {
                  i = 1;
                  if (i != 0) {
                    break label178;
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
              ad.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
              continue;
              i = 0;
              continue;
              label178:
              i = 0;
            }
            List localList = (List)localException;
            FdG.DJs.clear();
            FdG.DJs.addAll((Collection)localList);
            ad.i(TAG, "parseHistory: " + FdE + ' ' + FdG.DJs.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static void eJg()
  {
    AppMethodBeat.i(105966);
    Object localObject = FdH;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = FdG.toByteArray();
    i.aMF(FdC);
    i.B(FdE, (byte[])localObject);
    ad.i(TAG, "saveHistory: " + FdG.DJs.size());
    AppMethodBeat.o(105966);
  }
  
  public static List<blp> eJh()
  {
    AppMethodBeat.i(105967);
    Object localObject = FdG.DJs;
    d.g.b.k.g(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void eJi()
  {
    AppMethodBeat.i(105968);
    Object localObject1 = FdG.DJs;
    d.g.b.k.g(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      blp localblp = (blp)((Iterator)localObject1).next();
      ad.i(TAG, "checkHistory: " + localblp.Dds);
      Object localObject2 = d.FdM;
      localObject2 = localblp.Dds;
      d.g.b.k.g(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (com.tencent.mm.sticker.c.c)new b(localblp));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void eJj()
  {
    AppMethodBeat.i(105969);
    FdG.DJs.clear();
    eJg();
    AppMethodBeat.o(105969);
  }
  
  private static String eJk()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = g.afB();
    d.g.b.k.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).afk().get(ae.a.Fvm, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = g.afB();
        d.g.b.k.g(localObject2, "MMKernel.storage()");
        ((e)localObject2).afk().set(ae.a.Fvm, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.aia() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void f(blp paramblp)
  {
    AppMethodBeat.i(202305);
    d.g.b.k.h(paramblp, "lensInfo");
    Object localObject = FdG.DJs;
    d.g.b.k.g(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!d.g.b.k.g(((blp)((Iterator)localObject).next()).Dds, paramblp.Dds)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < FdG.DJs.size())) {
        FdG.DJs.remove(i);
      }
      FdG.DJs.add(0, paramblp);
      if (FdG.DJs.size() > 4) {
        FdG.DJs.remove(FdG.DJs.size() - 1);
      }
      eJg();
      AppMethodBeat.o(202305);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static void gO(List<? extends blp> paramList)
  {
    AppMethodBeat.i(105964);
    d.g.b.k.h(paramList, "list");
    FdF.DJs.clear();
    FdF.DJs.addAll((Collection)paramList);
    paramList = FdF.toByteArray();
    i.aMF(FdC);
    i.B(FdD, paramList);
    ad.i(TAG, "saveRecommend: " + FdF.DJs.size());
    AppMethodBeat.o(105964);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.k<Bundle, Bundle>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    b(blp paramblp) {}
    
    public final void a(final int paramInt, final blp paramblp)
    {
      AppMethodBeat.i(105962);
      b localb = b.FdI;
      ad.i(b.eJm(), "onResult: " + this.FdJ.Dds + ", " + paramInt);
      com.tencent.mm.ad.c.g((a)new a(this, paramInt, paramblp));
      AppMethodBeat.o(105962);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(b.b paramb, int paramInt, blp paramblp)
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