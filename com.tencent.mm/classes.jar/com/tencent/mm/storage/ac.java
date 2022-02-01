package com.tencent.mm.storage;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.model.bp;
import com.tencent.mm.protocal.protobuf.dkd;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/storage/BizTimeLineRecCardLogic;", "", "()V", "MAX_INSERT_COUNT", "", "getMAX_INSERT_COUNT", "()I", "MAX_SAVE_COUNT", "getMAX_SAVE_COUNT", "MAX_SAVE_COUNT$delegate", "Lkotlin/Lazy;", "MIN_NEW_COUNT", "getMIN_NEW_COUNT", "MIN_NEW_COUNT$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "idKey1577", "", "key", "", "insertRecCardUnderLine", "saveRecCardUnderLine", "msgContent", "", "plugin-biz_release"})
public final class ac
{
  private static final f NQZ;
  static final f NRa;
  private static final int NRb;
  public static final ac NRc;
  private static final f iBW;
  
  static
  {
    AppMethodBeat.i(212617);
    NRc = new ac();
    iBW = kotlin.g.ah((kotlin.g.a.a)ac.d.NRg);
    NQZ = kotlin.g.ah((kotlin.g.a.a)a.NRd);
    NRa = kotlin.g.ah((kotlin.g.a.a)b.NRe);
    NRb = gBf();
    AppMethodBeat.o(212617);
  }
  
  public static void Nd(long paramLong)
  {
    AppMethodBeat.i(212616);
    com.tencent.mm.plugin.report.service.h.CyF.n(1577L, paramLong, 1L);
    AppMethodBeat.o(212616);
  }
  
  public static MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(212612);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)iBW.getValue();
    AppMethodBeat.o(212612);
    return localMultiProcessMMKV;
  }
  
  public static void bjb(String paramString)
  {
    AppMethodBeat.i(212614);
    if (paramString == null)
    {
      AppMethodBeat.o(212614);
      return;
    }
    com.tencent.f.h.RTc.b((Runnable)new e(paramString), "RecCardUnderLineThread");
    AppMethodBeat.o(212614);
  }
  
  public static int gBf()
  {
    AppMethodBeat.i(212613);
    int i = ((Number)NQZ.getValue()).intValue();
    AppMethodBeat.o(212613);
    return i;
  }
  
  public static int gBg()
  {
    return NRb;
  }
  
  public static void gBh()
  {
    AppMethodBeat.i(212615);
    com.tencent.f.h.RTc.b((Runnable)c.NRf, "RecCardUnderLineThread");
    AppMethodBeat.o(212615);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final a NRd;
    
    static
    {
      AppMethodBeat.i(212604);
      NRd = new a();
      AppMethodBeat.o(212604);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final b NRe;
    
    static
    {
      AppMethodBeat.i(212606);
      NRe = new b();
      AppMethodBeat.o(212606);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c NRf;
    
    static
    {
      AppMethodBeat.i(212608);
      NRf = new c();
      AppMethodBeat.o(212608);
    }
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(212607);
      Object localObject1 = new StringBuilder("RecCardSaveList:");
      p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      String str = com.tencent.mm.kernel.a.ayV();
      localObject1 = ac.NRc;
      localObject1 = ac.aTI();
      p.g(localObject1, "mmkv");
      if (((MultiProcessMMKV)localObject1).containsKey(str))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label146;
            }
            i = j;
            label94:
            if (i == 0) {
              break label169;
            }
          }
        }
      }
      label146:
      label169:
      ac localac1;
      for (;;)
      {
        try
        {
          localObject2 = dke.class.newInstance();
          ((com.tencent.mm.bw.a)localObject2).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject2;
          localObject1 = (dke)localObject1;
          if (localObject1 != null) {
            break label175;
          }
          AppMethodBeat.o(212607);
          return;
        }
        catch (Exception localException1)
        {
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException1, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break;
        i = 0;
        break label94;
        localac1 = null;
      }
      label175:
      if (localac1.gCs.isEmpty())
      {
        AppMethodBeat.o(212607);
        return;
      }
      Object localObject2 = ac.NRc;
      ac.Nd(10L);
      localObject2 = ag.ban();
      p.g(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      long l = ((aa)localObject2).gAS();
      int i = ag.ban().MS(l);
      localObject2 = ac.NRc;
      if (i < ((Number)ac.NRa.getValue()).intValue())
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine newMsgCount=".concat(String.valueOf(i)));
        localac1 = ac.NRc;
        ac.Nd(11L);
        AppMethodBeat.o(212607);
        return;
      }
      i = ag.ban().MT(l);
      localObject2 = ac.NRc;
      j = ac.gBg() - i;
      if (j <= 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine recCount=".concat(String.valueOf(i)));
        localac1 = ac.NRc;
        ac.Nd(12L);
        AppMethodBeat.o(212607);
        return;
      }
      localObject2 = new LinkedList();
      Object localObject3 = localac1.gCs;
      p.g(localObject3, "recCardSaveList.list");
      localObject3 = ((Iterable)kotlin.a.j.b((Iterable)localObject3, kotlin.k.j.na(j, localac1.gCs.size()))).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        dkd localdkd = (dkd)((Iterator)localObject3).next();
        ((LinkedList)localObject2).add(localdkd);
        ac localac2 = ac.NRc;
        ac.Nd(14L);
        ab.biZ(localdkd.content);
      }
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine insertList=" + ((LinkedList)localObject2).size());
      localObject3 = ac.NRc;
      ac.Nd(13L);
      localac1.gCs.removeAll((Collection)localObject2);
      try
      {
        localObject2 = ac.NRc;
        ac.aTI().encode(str, localac1.toByteArray());
        AppMethodBeat.o(212607);
        return;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo ex " + localException2.getMessage());
        AppMethodBeat.o(212607);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString) {}
    
    public final void run()
    {
      Object localObject3 = null;
      int j = 1;
      AppMethodBeat.i(212611);
      Object localObject1 = new StringBuilder("RecCardSaveList:");
      p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
      String str = com.tencent.mm.kernel.a.ayV();
      localObject1 = ac.NRc;
      localObject1 = ac.aTI();
      p.g(localObject1, "mmkv");
      int i;
      if (((MultiProcessMMKV)localObject1).containsKey(str))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label245;
            }
            i = j;
            label87:
            if (i == 0) {
              break label266;
            }
          }
        }
      }
      label266:
      label271:
      label291:
      label419:
      for (;;)
      {
        Object localObject4;
        try
        {
          localObject4 = dke.class.newInstance();
          ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.bw.a)localObject4;
          localObject4 = (dke)localObject1;
          if (localObject4 != null) {
            break label419;
          }
          localObject4 = new dke();
          i = ((dke)localObject4).gCs.size();
          localObject1 = ac.NRc;
          if (i < ac.gBf()) {
            break label291;
          }
          localObject1 = ((dke)localObject4).gCs;
          p.g(localObject1, "recCardSaveList.list");
          Iterator localIterator = ((Iterable)localObject1).iterator();
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break label271;
          }
          dkd localdkd = (dkd)localIterator.next();
          localObject3 = localdkd;
          if (localObject1 != null)
          {
            if (localObject1 == null) {
              p.hyc();
            }
            if (((dkd)localObject1).MOa <= localdkd.MOa) {
              break label413;
            }
            localObject3 = localdkd;
          }
          localObject1 = localObject3;
          continue;
          i = 0;
        }
        catch (Exception localException1)
        {
          label245:
          Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException1, "decode ProtoBuffer", new Object[0]);
        }
        i = 0;
        break label87;
        Object localObject2 = null;
        continue;
        ((dke)localObject4).gCs.remove(localObject2);
        localObject2 = ac.NRc;
        ac.Nd(19L);
        localObject2 = ((dke)localObject4).gCs;
        localObject3 = new dkd();
        ((dkd)localObject3).content = this.kWI;
        ((dkd)localObject3).MOa = bp.aVP();
        ((LinkedList)localObject2).add(localObject3);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "saveRecCardUnderLine size " + ((dke)localObject4).gCs.size());
        try
        {
          localObject2 = ac.NRc;
          ac.aTI().encode(str, ((dke)localObject4).toByteArray());
          AppMethodBeat.o(212611);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "saveRecCardUnderLine ex " + localException2.getMessage());
          AppMethodBeat.o(212611);
          return;
        }
        localObject3 = localException2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */