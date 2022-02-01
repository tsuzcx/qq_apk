package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String ImX;
  private static final String ImY;
  private static final String ImZ;
  private static final btz Ina;
  static final btz Inb;
  private static a<z> Inc;
  public static final b Ind;
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  
  static
  {
    AppMethodBeat.i(105971);
    Ind = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (aj.cmR()) {
      localObject = fop();
    }
    for (;;)
    {
      ImX = (String)localObject;
      ImY = ImX + "recommend.proto";
      ImZ = ImX + "history.proto";
      Ina = new btz();
      Inb = new btz();
      localObject = i.aY(ImY, 0, -1);
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
        Ina.parseFrom((byte[])localObject);
        ad.i(TAG, "parseRecommend: " + ImY + ' ' + Ina.GOr.size());
        fok();
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
  
  public static void L(a<z> parama)
  {
    Inc = parama;
  }
  
  public static void f(bty parambty)
  {
    AppMethodBeat.i(215385);
    p.h(parambty, "lensInfo");
    Object localObject = Inb.GOr;
    p.g(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!p.i(((bty)((Iterator)localObject).next()).Geb, parambty.Geb)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < Inb.GOr.size())) {
        Inb.GOr.remove(i);
      }
      Inb.GOr.add(0, parambty);
      if (Inb.GOr.size() > 4) {
        Inb.GOr.remove(Inb.GOr.size() - 1);
      }
      fol();
      AppMethodBeat.o(215385);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void fok()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = i.aY(ImZ, 0, -1);
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
            Inb.parseFrom((byte[])localObject1);
            localObject1 = Inb.GOr;
            p.g(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((bty)localObject3).Geb;
                if ((localCharSequence == null) || (n.aE(localCharSequence)))
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
            Inb.GOr.clear();
            Inb.GOr.addAll((Collection)localList);
            ad.i(TAG, "parseHistory: " + ImZ + ' ' + Inb.GOr.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static void fol()
  {
    AppMethodBeat.i(105966);
    Object localObject = Inc;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = Inb.toByteArray();
    i.aYg(ImX);
    i.C(ImZ, (byte[])localObject);
    ad.i(TAG, "saveHistory: " + Inb.GOr.size());
    AppMethodBeat.o(105966);
  }
  
  public static List<bty> fom()
  {
    AppMethodBeat.i(105967);
    Object localObject = Inb.GOr;
    p.g(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void fon()
  {
    AppMethodBeat.i(105968);
    Object localObject1 = Inb.GOr;
    p.g(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      bty localbty = (bty)((Iterator)localObject1).next();
      ad.i(TAG, "checkHistory: " + localbty.Geb);
      Object localObject2 = d.Inh;
      localObject2 = localbty.Geb;
      p.g(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (com.tencent.mm.sticker.c.c)new b(localbty));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void foo()
  {
    AppMethodBeat.i(105969);
    Inb.GOr.clear();
    fol();
    AppMethodBeat.o(105969);
  }
  
  private static String fop()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).ajl().get(al.a.IFL, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        ((e)localObject2).ajl().set(al.a.IFL, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.arN() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void hm(List<? extends bty> paramList)
  {
    AppMethodBeat.i(105964);
    p.h(paramList, "list");
    Ina.GOr.clear();
    Ina.GOr.addAll((Collection)paramList);
    paramList = Ina.toByteArray();
    i.aYg(ImX);
    i.C(ImY, paramList);
    ad.i(TAG, "saveRecommend: " + Ina.GOr.size());
    AppMethodBeat.o(105964);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/model/LensInfoUserCache$IPCGetCacheDir;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-sticker_release"})
  public static final class a
    implements k<Bundle, Bundle>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    b(bty parambty) {}
    
    public final void a(final int paramInt, final bty parambty)
    {
      AppMethodBeat.i(105962);
      b localb = b.Ind;
      ad.i(b.jdMethod_for(), "onResult: " + this.Ine.Geb + ", " + paramInt);
      com.tencent.mm.ad.c.g((a)new a(this, paramInt, parambty));
      AppMethodBeat.o(105962);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<z>
    {
      a(b.b paramb, int paramInt, bty parambty)
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