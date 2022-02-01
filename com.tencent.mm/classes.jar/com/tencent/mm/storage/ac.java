package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.af;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizTimeLineRecCardLogic;", "", "()V", "MAX_INSERT_COUNT", "", "getMAX_INSERT_COUNT", "()I", "MAX_SAVE_COUNT", "getMAX_SAVE_COUNT", "MAX_SAVE_COUNT$delegate", "Lkotlin/Lazy;", "MIN_NEW_COUNT", "getMIN_NEW_COUNT", "MIN_NEW_COUNT$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "getRecReportInfo", "Lcom/tencent/mm/storage/RecMsgReportInfo;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "idKey1577", "", "key", "", "insertRecCardUnderLine", "saveRecCardUnderLine", "msgContent", "", "plugin-biz_release"})
public final class ac
{
  private static final f VeQ;
  static final f VeR;
  private static final int VeS;
  public static final ac VeT;
  private static final f lrB;
  
  static
  {
    AppMethodBeat.i(206869);
    VeT = new ac();
    lrB = g.ar((kotlin.g.a.a)ac.d.VeX);
    VeQ = g.ar((kotlin.g.a.a)a.VeU);
    VeR = g.ar((kotlin.g.a.a)b.VeV);
    VeS = hxp();
    AppMethodBeat.o(206869);
  }
  
  public static ci J(z paramz)
  {
    long l = 0L;
    AppMethodBeat.i(206868);
    p.k(paramz, "info");
    Object localObject1 = "";
    Object localObject2 = "";
    String str = "";
    paramz = paramz.hwL();
    int j;
    if (paramz != null)
    {
      j = paramz.style;
      if ((paramz.style == 101) || (paramz.style == 102) || (paramz.style == 103))
      {
        paramz = paramz.UsF;
        if ((paramz == null) || (Util.isNullOrNil((List)paramz.RVd))) {
          break label262;
        }
        paramz = paramz.RVd.get(0);
        str = ((pf)paramz).UserName;
        pe localpe = (pe)((pf)paramz).RXM.get(0);
        if (localpe != null)
        {
          paramz = localpe.RXK;
          localObject2 = localpe.RTk;
          if (Util.isNullOrNil((String)localObject2)) {
            break label268;
          }
          localObject2 = Uri.parse((String)localObject2);
          l = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
        }
      }
    }
    label262:
    label268:
    for (int i = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);; i = 0)
    {
      for (localObject2 = str;; localObject2 = str)
      {
        paramz = new ci(l, i, j, paramz, (String)localObject1, (String)localObject2);
        AppMethodBeat.o(206868);
        return paramz;
        i = 0;
        paramz = (z)localObject2;
      }
      if (paramz.style == 1001) {}
      for (paramz = paramz.fMh;; paramz = "")
      {
        localObject1 = paramz;
        i = 0;
        paramz = (z)localObject2;
        localObject2 = str;
        break;
        j = 0;
        i = 0;
        paramz = (z)localObject2;
        localObject2 = str;
        break;
      }
    }
  }
  
  public static void UO(long paramLong)
  {
    AppMethodBeat.i(206867);
    com.tencent.mm.plugin.report.service.h.IzE.p(1577L, paramLong, 1L);
    AppMethodBeat.o(206867);
  }
  
  public static MultiProcessMMKV bcJ()
  {
    AppMethodBeat.i(206863);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)lrB.getValue();
    AppMethodBeat.o(206863);
    return localMultiProcessMMKV;
  }
  
  public static void bvw(String paramString)
  {
    AppMethodBeat.i(206865);
    if (paramString == null)
    {
      AppMethodBeat.o(206865);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new e(paramString), "RecCardUnderLineThread");
    AppMethodBeat.o(206865);
  }
  
  public static int hxp()
  {
    AppMethodBeat.i(206864);
    int i = ((Number)VeQ.getValue()).intValue();
    AppMethodBeat.o(206864);
    return i;
  }
  
  public static int hxq()
  {
    return VeS;
  }
  
  public static void hxr()
  {
    AppMethodBeat.i(206866);
    com.tencent.e.h.ZvG.d((Runnable)c.VeW, "RecCardUnderLineThread");
    AppMethodBeat.o(206866);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final a VeU;
    
    static
    {
      AppMethodBeat.i(205478);
      VeU = new a();
      AppMethodBeat.o(205478);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final b VeV;
    
    static
    {
      AppMethodBeat.i(206180);
      VeV = new b();
      AppMethodBeat.o(206180);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    public static final c VeW;
    
    static
    {
      AppMethodBeat.i(210853);
      VeW = new c();
      AppMethodBeat.o(210853);
    }
    
    public final void run()
    {
      int j = 1;
      AppMethodBeat.i(210851);
      Object localObject1 = new StringBuilder("RecCardSaveList:");
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      String str = b.aGq();
      localObject1 = ac.VeT;
      localObject1 = ac.bcJ();
      p.j(localObject1, "mmkv");
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
          localObject2 = dtt.class.newInstance();
          ((com.tencent.mm.cd.a)localObject2).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.cd.a)localObject2;
          localObject1 = (dtt)localObject1;
          if (localObject1 != null) {
            break label175;
          }
          AppMethodBeat.o(210851);
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
      if (localac1.jmy.isEmpty())
      {
        AppMethodBeat.o(210851);
        return;
      }
      Object localObject2 = ac.VeT;
      ac.UO(10L);
      localObject2 = af.bjB();
      p.j(localObject2, "SubCoreBiz.getBizTimeLineInfoStorage()");
      long l = ((aa)localObject2).hxb();
      int i = af.bjB().UD(l);
      localObject2 = ac.VeT;
      if (i < ((Number)ac.VeR.getValue()).intValue())
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine newMsgCount=".concat(String.valueOf(i)));
        localac1 = ac.VeT;
        ac.UO(11L);
        AppMethodBeat.o(210851);
        return;
      }
      i = af.bjB().UE(l);
      localObject2 = ac.VeT;
      j = ac.hxq() - i;
      if (j <= 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine recCount=".concat(String.valueOf(i)));
        localac1 = ac.VeT;
        ac.UO(12L);
        AppMethodBeat.o(210851);
        return;
      }
      localObject2 = new LinkedList();
      Object localObject3 = localac1.jmy;
      p.j(localObject3, "recCardSaveList.list");
      localObject3 = ((Iterable)j.c((Iterable)localObject3, kotlin.k.i.ow(j, localac1.jmy.size()))).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        dts localdts = (dts)((Iterator)localObject3).next();
        ((LinkedList)localObject2).add(localdts);
        ac localac2 = ac.VeT;
        ac.UO(14L);
        ab.bvu(localdts.content);
      }
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "insertRecCardUnderLine insertList=" + ((LinkedList)localObject2).size());
      localObject3 = ac.VeT;
      ac.UO(13L);
      localac1.jmy.removeAll((Collection)localObject2);
      try
      {
        localObject2 = ac.VeT;
        ac.bcJ().encode(str, localac1.toByteArray());
        AppMethodBeat.o(210851);
        return;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo ex " + localException2.getMessage());
        AppMethodBeat.o(210851);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(String paramString) {}
    
    public final void run()
    {
      Object localObject3 = null;
      int j = 1;
      AppMethodBeat.i(205764);
      Object localObject1 = new StringBuilder("RecCardSaveList:");
      p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
      String str = b.aGq();
      localObject1 = ac.VeT;
      localObject1 = ac.bcJ();
      p.j(localObject1, "mmkv");
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
          localObject4 = dtt.class.newInstance();
          ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
          localObject1 = (com.tencent.mm.cd.a)localObject4;
          localObject4 = (dtt)localObject1;
          if (localObject4 != null) {
            break label419;
          }
          localObject4 = new dtt();
          i = ((dtt)localObject4).jmy.size();
          localObject1 = ac.VeT;
          if (i < ac.hxp()) {
            break label291;
          }
          localObject1 = ((dtt)localObject4).jmy;
          p.j(localObject1, "recCardSaveList.list");
          Iterator localIterator = ((Iterable)localObject1).iterator();
          localObject1 = localObject3;
          if (!localIterator.hasNext()) {
            break label271;
          }
          dts localdts = (dts)localIterator.next();
          localObject3 = localdts;
          if (localObject1 != null)
          {
            if (localObject1 == null) {
              p.iCn();
            }
            if (((dts)localObject1).TZT <= localdts.TZT) {
              break label413;
            }
            localObject3 = localdts;
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
        ((dtt)localObject4).jmy.remove(localObject2);
        localObject2 = ac.VeT;
        ac.UO(19L);
        localObject2 = ((dtt)localObject4).jmy;
        localObject3 = new dts();
        ((dts)localObject3).content = this.nQU;
        ((dts)localObject3).TZT = bq.beS();
        ((LinkedList)localObject2).add(localObject3);
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "saveRecCardUnderLine size " + ((dtt)localObject4).jmy.size());
        try
        {
          localObject2 = ac.VeT;
          ac.bcJ().encode(str, ((dtt)localObject4).toByteArray());
          AppMethodBeat.o(205764);
          return;
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.BizTimeLineStorageLogicExKt", "saveRecCardUnderLine ex " + localException2.getMessage());
          AppMethodBeat.o(205764);
          return;
        }
        localObject3 = localException2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.ac
 * JD-Core Version:    0.7.0.1
 */