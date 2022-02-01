package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "checkingSize", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final String TAG;
  public static final b acDc;
  private static final String acDd;
  private static final String acDe;
  private static final String acDf;
  private static final dhq acDg;
  static final dhq acDh;
  private static int acDi;
  private static a<ah> acDj;
  
  static
  {
    AppMethodBeat.i(105971);
    acDc = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (MMApplicationContext.isMainProcess()) {
      localObject = iWJ();
    }
    for (;;)
    {
      acDd = (String)localObject;
      acDe = s.X((String)localObject, "recommend.proto");
      acDf = s.X(acDd, "history.proto");
      acDg = new dhq();
      acDh = new dhq();
      localObject = y.bi(acDe, 0, -1);
      int i;
      if (localObject != null)
      {
        if (localObject.length != 0) {
          break label204;
        }
        i = 1;
        label94:
        if (i != 0) {
          break label209;
        }
        i = 1;
        if (i == 0) {}
      }
      try
      {
        acDg.parseFrom((byte[])localObject);
        Log.i(TAG, "parseRecommend: " + acDe + ' ' + acDg.aaMV.size());
        iWF();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)j.a(MMApplicationContext.getPackageName(), null, a.class);
        if (localObject == null)
        {
          localObject = "";
          continue;
        }
        String str = ((Bundle)localObject).getString("data");
        localObject = str;
        if (str != null) {
          continue;
        }
        localObject = "";
        continue;
        label204:
        i = 0;
        break label94;
        label209:
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
  
  public static void caA()
  {
    AppMethodBeat.i(105966);
    Object localObject = acDj;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = acDh.toByteArray();
    y.bDX(acDd);
    y.f(acDf, (byte[])localObject, localObject.length);
    Log.i(TAG, s.X("saveHistory: ", Integer.valueOf(acDh.aaMV.size())));
    AppMethodBeat.o(105966);
  }
  
  public static void cc(a<ah> parama)
  {
    acDj = parama;
  }
  
  public static void f(dhp paramdhp)
  {
    AppMethodBeat.i(233893);
    s.u(paramdhp, "lensInfo");
    Object localObject = acDh.aaMV;
    s.s(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((dhp)((Iterator)localObject).next()).LensId, paramdhp.LensId)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < acDh.aaMV.size())) {
        acDh.aaMV.remove(i);
      }
      acDh.aaMV.add(0, paramdhp);
      if (acDh.aaMV.size() > 4) {
        acDh.aaMV.remove(acDh.aaMV.size() - 1);
      }
      caA();
      AppMethodBeat.o(233893);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void iWF()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = y.bi(acDf, 0, -1);
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
            acDh.parseFrom((byte[])localObject1);
            localObject1 = acDh.aaMV;
            s.s(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((dhp)localObject3).LensId;
                if ((localCharSequence == null) || (n.bp(localCharSequence)))
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
            acDh.aaMV.clear();
            acDh.aaMV.addAll((Collection)localList);
            Log.i(TAG, "parseHistory: " + acDf + ' ' + acDh.aaMV.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static List<dhp> iWG()
  {
    AppMethodBeat.i(105967);
    Object localObject = acDh.aaMV;
    s.s(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void iWH()
  {
    AppMethodBeat.i(105968);
    Log.i(TAG, s.X("checkHistory: ", Integer.valueOf(acDi)));
    if (acDi > 0)
    {
      AppMethodBeat.o(105968);
      return;
    }
    Object localObject1 = acDh.aaMV;
    s.s(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      dhp localdhp = (dhp)((Iterator)localObject1).next();
      acDi += 1;
      Log.i(TAG, s.X("checkHistory: ", localdhp.LensId));
      Object localObject2 = com.tencent.mm.sticker.c.d.acDm;
      localObject2 = localdhp.LensId;
      s.s(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (c)new b(localdhp));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void iWI()
  {
    AppMethodBeat.i(105969);
    acDh.aaMV.clear();
    caA();
    AppMethodBeat.o(105969);
  }
  
  private static String iWJ()
  {
    AppMethodBeat.i(105970);
    Object localObject1 = h.baE().ban().get(at.a.acYT, null);
    if ((localObject1 instanceof String)) {}
    for (localObject1 = (String)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = s.X("lens_", Long.valueOf(System.currentTimeMillis()));
        h.baE().ban().set(at.a.acYT, localObject2);
      }
      localObject1 = com.tencent.mm.loader.i.b.bms() + "sticker/data/" + localObject2 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
    }
  }
  
  public static void mE(List<? extends dhp> paramList)
  {
    AppMethodBeat.i(105964);
    s.u(paramList, "list");
    acDg.aaMV.clear();
    acDg.aaMV.addAll((Collection)paramList);
    paramList = acDg.toByteArray();
    y.bDX(acDd);
    y.f(acDe, paramList, paramList.length);
    Log.i(TAG, s.X("saveRecommend: ", Integer.valueOf(acDg.aaMV.size())));
    AppMethodBeat.o(105964);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m<Bundle, Bundle>
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c
  {
    b(dhp paramdhp) {}
    
    public final void a(int paramInt, final dhp paramdhp)
    {
      AppMethodBeat.i(105962);
      Log.i(b.aUw(), "onResult: " + this.acDk.LensId + ", " + paramInt);
      com.tencent.mm.ae.d.uiThread((a)new a(paramInt, this.acDk, paramdhp));
      AppMethodBeat.o(105962);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(int paramInt, dhp paramdhp1, dhp paramdhp2)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sticker.a.b
 * JD-Core Version:    0.7.0.1
 */