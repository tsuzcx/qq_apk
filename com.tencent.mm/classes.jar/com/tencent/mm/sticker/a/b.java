package com.tencent.mm.sticker.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/model/LensInfoUserCache;", "", "()V", "TAG", "", "historyFile", "historyList", "Lcom/tencent/mm/protocal/protobuf/LensInfoList;", "historyListener", "Lkotlin/Function0;", "", "getHistoryListener", "()Lkotlin/jvm/functions/Function0;", "setHistoryListener", "(Lkotlin/jvm/functions/Function0;)V", "recommendFile", "recommendList", "stickerData", "getStickerData", "()Ljava/lang/String;", "appendHistory", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "checkHistory", "cleanHistory", "getCacheDir", "getCacheDirInMM", "getHistory", "", "getRecommendList", "parseHistory", "parseRecommend", "removeHistory", "lensId", "saveHistory", "saveRecommend", "updateRecommend", "list", "IPCGetCacheDir", "plugin-sticker_release"})
public final class b
{
  private static final String IHi;
  private static final String IHj;
  private static final String IHk;
  private static final but IHl;
  static final but IHm;
  private static a<z> IHn;
  public static final b IHo;
  private static final String TAG = "MicroMsg.LensInfoUserCache";
  
  static
  {
    AppMethodBeat.i(105971);
    IHo = new b();
    TAG = "MicroMsg.LensInfoUserCache";
    Object localObject;
    if (ak.coh()) {
      localObject = fsi();
    }
    for (;;)
    {
      IHi = (String)localObject;
      IHj = IHi + "recommend.proto";
      IHk = IHi + "history.proto";
      IHl = new but();
      IHm = new but();
      localObject = o.bb(IHj, 0, -1);
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
        IHl.parseFrom((byte[])localObject);
        ae.i(TAG, "parseRecommend: " + IHj + ' ' + IHl.HhR.size());
        fsd();
        AppMethodBeat.o(105971);
        return;
        localObject = (Bundle)h.a(ak.getPackageName(), null, b.a.class);
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
          ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void L(a<z> parama)
  {
    IHn = parama;
  }
  
  public static void f(bus parambus)
  {
    AppMethodBeat.i(208264);
    p.h(parambus, "lensInfo");
    Object localObject = IHm.HhR;
    p.g(localObject, "historyList.lensInfoList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!p.i(((bus)((Iterator)localObject).next()).GwI, parambus.GwI)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < IHm.HhR.size())) {
        IHm.HhR.remove(i);
      }
      IHm.HhR.add(0, parambus);
      if (IHm.HhR.size() > 4) {
        IHm.HhR.remove(IHm.HhR.size() - 1);
      }
      fse();
      AppMethodBeat.o(208264);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void fsd()
  {
    AppMethodBeat.i(105965);
    Object localObject1 = o.bb(IHk, 0, -1);
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
            IHm.parseFrom((byte[])localObject1);
            localObject1 = IHm.HhR;
            p.g(localObject1, "historyList.lensInfoList");
            Object localObject2 = (Iterable)localObject1;
            localObject1 = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = ((Iterator)localObject2).next();
                CharSequence localCharSequence = (CharSequence)((bus)localObject3).GwI;
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
              ae.printErrStackTrace(TAG, (Throwable)localException, "", new Object[0]);
              continue;
              i = 0;
              continue;
              label178:
              i = 0;
            }
            List localList = (List)localException;
            IHm.HhR.clear();
            IHm.HhR.addAll((Collection)localList);
            ae.i(TAG, "parseHistory: " + IHk + ' ' + IHm.HhR.size());
          }
        }
      }
    }
    AppMethodBeat.o(105965);
  }
  
  public static void fse()
  {
    AppMethodBeat.i(105966);
    Object localObject = IHn;
    if (localObject != null) {
      ((a)localObject).invoke();
    }
    localObject = IHm.toByteArray();
    o.aZI(IHi);
    o.C(IHk, (byte[])localObject);
    ae.i(TAG, "saveHistory: " + IHm.HhR.size());
    AppMethodBeat.o(105966);
  }
  
  public static List<bus> fsf()
  {
    AppMethodBeat.i(105967);
    Object localObject = IHm.HhR;
    p.g(localObject, "historyList.lensInfoList");
    localObject = (List)localObject;
    AppMethodBeat.o(105967);
    return localObject;
  }
  
  public static void fsg()
  {
    AppMethodBeat.i(105968);
    Object localObject1 = IHm.HhR;
    p.g(localObject1, "historyList.lensInfoList");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      bus localbus = (bus)((Iterator)localObject1).next();
      ae.i(TAG, "checkHistory: " + localbus.GwI);
      Object localObject2 = d.IHs;
      localObject2 = localbus.GwI;
      p.g(localObject2, "it.LensId");
      d.a.a(null, (String)localObject2, (com.tencent.mm.sticker.c.c)new b(localbus));
    }
    AppMethodBeat.o(105968);
  }
  
  public static void fsh()
  {
    AppMethodBeat.i(105969);
    IHm.HhR.clear();
    fse();
    AppMethodBeat.o(105969);
  }
  
  private static String fsi()
  {
    Object localObject1 = null;
    AppMethodBeat.i(105970);
    Object localObject2 = g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    localObject2 = ((e)localObject2).ajA().get(am.a.Jal, null);
    if (!(localObject2 instanceof String)) {}
    for (;;)
    {
      localObject2 = (String)localObject1;
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2))
      {
        localObject1 = "lens_" + System.currentTimeMillis();
        localObject2 = g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        ((e)localObject2).ajA().set(am.a.Jal, localObject1);
      }
      localObject1 = com.tencent.mm.loader.j.b.asc() + "sticker/data/" + (String)localObject1 + '/';
      AppMethodBeat.o(105970);
      return localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static void hw(List<? extends bus> paramList)
  {
    AppMethodBeat.i(105964);
    p.h(paramList, "list");
    IHl.HhR.clear();
    IHl.HhR.addAll((Collection)paramList);
    paramList = IHl.toByteArray();
    o.aZI(IHi);
    o.C(IHj, paramList);
    ae.i(TAG, "saveRecommend: " + IHl.HhR.size());
    AppMethodBeat.o(105964);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/sticker/model/LensInfoUserCache$checkHistory$1$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-sticker_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    b(bus parambus) {}
    
    public final void a(final int paramInt, final bus parambus)
    {
      AppMethodBeat.i(105962);
      b localb = b.IHo;
      ae.i(b.fsk(), "onResult: " + this.IHp.GwI + ", " + paramInt);
      com.tencent.mm.ac.c.h((a)new a(this, paramInt, parambus));
      AppMethodBeat.o(105962);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<z>
    {
      a(b.b paramb, int paramInt, bus parambus)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.a.b
 * JD-Core Version:    0.7.0.1
 */