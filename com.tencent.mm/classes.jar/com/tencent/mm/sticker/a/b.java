package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.k;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String GBd;
  private static final String GBe;
  private static final String GBf;
  private static final bpm GBg;
  static final bpm GBh;
  private static a<y> GBi;
  public static final b GBj;
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  
  static
  {
    AppMethodBeat.i(105971);
    GBj = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (ai.cin()) {
      localObject = eYF();
    }
    for (;;)
    {
      GBd = (String)localObject;
      GBe = GBd + "recommend.proto";
      GBf = GBd + "history.proto";
      GBg = new bpm();
      GBh = new bpm();
      localObject = i.aU(GBe, 0, -1);
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
        GBg.parseFrom((byte[])localObject);
        ac.i(TAG, "parseRecommend: " + GBe + ' ' + GBg.FeN.size());
        eYA();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)h.a(ai.getPackageName(), null, b.a.class);
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
          ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void H(a<y> parama)
  {
    GBi = parama;
  }
  
  private static void eYA()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = i.aU(GBf, 0, -1);
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
            GBh.parseFrom((byte[])localObject1);
            localObject1 = GBh.FeN;
            k.g(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((bpl)localObject3).Ewy;
                if ((localCharSequence == null) || (n.aD(localCharSequence)))
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
              ac.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
              continue;
              i = 0;
              continue;
              label178:
              i = 0;
            }
            List localList = (List)localException;
            GBh.FeN.clear();
            GBh.FeN.addAll((Collection)localList);
            ac.i(TAG, "parseHistory: " + GBf + ' ' + GBh.FeN.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static void eYB()
  {
    AppMethodBeat.i(105966);
    Object localObject = GBi;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = GBh.toByteArray();
    i.aSh(GBd);
    i.B(GBf, (byte[])localObject);
    ac.i(TAG, "saveHistory: " + GBh.FeN.size());
    AppMethodBeat.o(105966);
  }
  
  public static List<bpl> eYC()
  {
    AppMethodBeat.i(105967);
    Object localObject = GBh.FeN;
    k.g(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void eYD()
  {
    AppMethodBeat.i(105968);
    Object localObject1 = GBh.FeN;
    k.g(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      bpl localbpl = (bpl)((Iterator)localObject1).next();
      ac.i(TAG, "checkHistory: " + localbpl.Ewy);
      Object localObject2 = d.GBn;
      localObject2 = localbpl.Ewy;
      k.g(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (com.tencent.mm.sticker.c.c)new b(localbpl));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void eYE()
  {
    AppMethodBeat.i(105969);
    GBh.FeN.clear();
    eYB();
    AppMethodBeat.o(105969);
  }
  
  private static String eYF()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = g.agR();
    k.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).agA().get(ah.a.GTg, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = g.agR();
        k.g(localObject2, "MMKernel.storage()");
        ((e)localObject2).agA().set(ah.a.GTg, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.apa() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void f(bpl parambpl)
  {
    AppMethodBeat.i(204916);
    k.h(parambpl, "lensInfo");
    Object localObject = GBh.FeN;
    k.g(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!k.g(((bpl)((Iterator)localObject).next()).Ewy, parambpl.Ewy)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < GBh.FeN.size())) {
        GBh.FeN.remove(i);
      }
      GBh.FeN.add(0, parambpl);
      if (GBh.FeN.size() > 4) {
        GBh.FeN.remove(GBh.FeN.size() - 1);
      }
      eYB();
      AppMethodBeat.o(204916);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static void hb(List<? extends bpl> paramList)
  {
    AppMethodBeat.i(105964);
    k.h(paramList, "list");
    GBg.FeN.clear();
    GBg.FeN.addAll((Collection)paramList);
    paramList = GBg.toByteArray();
    i.aSh(GBd);
    i.B(GBe, paramList);
    ac.i(TAG, "saveRecommend: " + GBg.FeN.size());
    AppMethodBeat.o(105964);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    b(bpl parambpl) {}
    
    public final void a(final int paramInt, final bpl parambpl)
    {
      AppMethodBeat.i(105962);
      b localb = b.GBj;
      ac.i(b.eYH(), "onResult: " + this.GBk.Ewy + ", " + paramInt);
      com.tencent.mm.ac.c.g((a)new a(this, paramInt, parambpl));
      AppMethodBeat.o(105962);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements a<y>
    {
      a(b.b paramb, int paramInt, bpl parambpl)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.a.b
 * JD-Core Version:    0.7.0.1
 */