package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.report.b.d;
import com.tencent.mm.protocal.protobuf.fuv;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/service/UserDataOperationReporter;", "", "()V", "MERGE_CONFIG", "", "", "MMKV_KEY", "ONCE_PERDAY_CONFIG", "TAG", "accNotReadyCache", "", "Lkotlin/Pair;", "", "getAccNotReadyCache", "()Ljava/util/List;", "accNotReadyCache$delegate", "Lkotlin/Lazy;", "dataList", "Lcom/tencent/mm/protocal/protobuf/BatchUploadUserDataList;", "getDataList", "()Lcom/tencent/mm/protocal/protobuf/BatchUploadUserDataList;", "dataList$delegate", "storage", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getStorage", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "storage$delegate", "today", "", "_op", "", "businessType", "dataType", "forceUpload", "hasPermission", "", "permission", "oncePerDay", "op", "save", "shouldMerge", "upload", "BusinessType", "DataType", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l OAV;
  private static long OAW;
  private static final List<String> OAX;
  private static final List<String> OAY;
  private static final j akiJ;
  private static final j qRc;
  private static final j sZg;
  
  static
  {
    AppMethodBeat.i(261769);
    OAV = new l();
    Log.i("MicroMsg.UserDataOperationReporter", "init");
    new UserDataOperationReporter.1(com.tencent.mm.app.f.hfK).alive();
    long l = System.currentTimeMillis() % 3600000L;
    Log.i("MicroMsg.UserDataOperationReporter", "upload delay " + l + "ms");
    com.tencent.threadpool.h.ahAA.a(l..ExternalSyntheticLambda5.INSTANCE, l, "MicroMsg.UserDataOperationReporter");
    sZg = k.cm((kotlin.g.a.a)l.d.OBc);
    qRc = k.cm((kotlin.g.a.a)c.OBb);
    akiJ = k.cm((kotlin.g.a.a)l.e.akiK);
    OAX = p.listOf(new String[] { "3_11", "12_11", "5_11", "22_11", "3_10", "12_10", "5_10", "22_10", "2_8", "1_8" });
    OAY = p.listOf("10_12");
    AppMethodBeat.o(261769);
  }
  
  private static final Object a(Map.Entry paramEntry, lz paramlz, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(369724);
    s.u(paramEntry, "$entry");
    s.u(paramlz, "$dataList");
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      Log.i("MicroMsg.UserDataOperationReporter", "upload succ. day " + ((Number)paramEntry.getKey()).longValue() + ", size " + ((LinkedList)paramEntry.getValue()).size());
      paramEntry = ah.aiuX;
      AppMethodBeat.o(369724);
      return paramEntry;
    }
    Log.e("MicroMsg.UserDataOperationReporter", "upload err. day " + ((Number)paramEntry.getKey()).longValue() + ". errCode:" + parama.errCode + " errType:" + parama.errType + " errMsg:" + parama.errMsg);
    paramEntry = com.tencent.threadpool.h.ahAA.g(new l..ExternalSyntheticLambda3(paramlz, paramEntry), "MicroMsg.UserDataOperationReporter");
    AppMethodBeat.o(369724);
    return paramEntry;
  }
  
  private static final void a(lz paramlz, Map.Entry paramEntry)
  {
    AppMethodBeat.i(369721);
    s.u(paramlz, "$dataList");
    s.u(paramEntry, "$entry");
    paramlz = paramlz.user_data_list;
    if (paramlz != null) {
      paramlz.addAll((Collection)paramEntry.getValue());
    }
    sz();
    AppMethodBeat.o(369721);
  }
  
  private static boolean aUq(String paramString)
  {
    AppMethodBeat.i(261744);
    try
    {
      int i = androidx.core.content.a.checkSelfPermission(MMApplicationContext.getContext(), paramString);
      if (i != 0)
      {
        AppMethodBeat.o(261744);
        return false;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(261744);
      return false;
    }
    AppMethodBeat.o(261744);
    return true;
  }
  
  private static MultiProcessMMKV dRj()
  {
    AppMethodBeat.i(261719);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)sZg.getValue();
    AppMethodBeat.o(261719);
    return localMultiProcessMMKV;
  }
  
  private static lz gNZ()
  {
    AppMethodBeat.i(261723);
    lz locallz = (lz)qRc.getValue();
    AppMethodBeat.o(261723);
    return locallz;
  }
  
  public static void gOa()
  {
    AppMethodBeat.i(261736);
    LinkedList localLinkedList = gNZ().user_data_list;
    s.s(localLinkedList, "dataList.user_data_list");
    new d(localLinkedList).bFJ().b(l..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(261736);
  }
  
  public static final void kK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261716);
    if (com.tencent.mm.kernel.h.baz())
    {
      com.tencent.mm.kernel.h.baC();
      if ((b.aZr() != com.tencent.mm.kernel.b.a.mCe) && ((paramInt2 != 10) || (aUq("android.permission.ACCESS_FINE_LOCATION")))) {}
    }
    else
    {
      Log.w("MicroMsg.UserDataOperationReporter", "acc not ready(" + com.tencent.mm.kernel.h.baz() + "), or wechat or no permission.");
      kLH().add(new r(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2)));
      AppMethodBeat.o(261716);
      return;
    }
    try
    {
      com.tencent.threadpool.h.ahAA.g(new l..ExternalSyntheticLambda2(paramInt1, paramInt2), "MicroMsg.UserDataOperationReporter");
      AppMethodBeat.o(261716);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.UserDataOperationReporter", (Throwable)localException, null, new Object[0]);
      AppMethodBeat.o(261716);
    }
  }
  
  private static boolean kL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261740);
    boolean bool = OAY.contains(paramInt1 + '_' + paramInt2);
    AppMethodBeat.o(261740);
    return bool;
  }
  
  private static List<r<Integer, Integer>> kLH()
  {
    AppMethodBeat.i(369716);
    List localList = (List)akiJ.getValue();
    AppMethodBeat.o(369716);
    return localList;
  }
  
  private static final void kLI()
  {
    AppMethodBeat.i(369719);
    lz locallz;
    Object localObject3;
    for (;;)
    {
      try
      {
        locallz = gNZ();
        long l = cn.getSyncServerTimeSecond();
        if (OAW == l / 86400L)
        {
          Log.i("MicroMsg.UserDataOperationReporter", "no time to upload.");
          AppMethodBeat.o(369719);
          return;
        }
        OAW = l / 86400L;
        Object localObject1 = locallz.user_data_list;
        if (localObject1 == null)
        {
          localObject1 = null;
          Log.i("MicroMsg.UserDataOperationReporter", s.X("upload. size ", localObject1));
          localObject1 = (Map)new LinkedHashMap();
          localObject3 = locallz.user_data_list;
          if (localObject3 == null) {
            break;
          }
          localObject3 = ((Iterable)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          fuv localfuv = (fuv)((Iterator)localObject3).next();
          l = localfuv.timestamp / 86400L;
          if (((Map)localObject1).get(Long.valueOf(l)) == null) {
            ((Map)localObject1).put(Long.valueOf(l), new LinkedList());
          }
          LinkedList localLinkedList = (LinkedList)((Map)localObject1).get(Long.valueOf(l));
          if (localLinkedList == null) {
            continue;
          }
          localLinkedList.add(localfuv);
          continue;
        }
        localObject2 = Integer.valueOf(localException.size());
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.UserDataOperationReporter", (Throwable)localException, null, new Object[0]);
        AppMethodBeat.o(369719);
        return;
      }
    }
    locallz.user_data_list = new LinkedList();
    Object localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      if (((Number)((Map.Entry)localObject3).getKey()).longValue() != OAW)
      {
        if (OAW - ((Number)((Map.Entry)localObject3).getKey()).longValue() <= 7L) {
          new d((LinkedList)((Map.Entry)localObject3).getValue()).bFJ().b(new l..ExternalSyntheticLambda0((Map.Entry)localObject3, locallz));
        }
      }
      else
      {
        Log.i("MicroMsg.UserDataOperationReporter", s.X("today size: ", Integer.valueOf(((LinkedList)((Map.Entry)localObject3).getValue()).size())));
        locallz.user_data_list.addAll((Collection)((Map.Entry)localObject3).getValue());
        sz();
      }
    }
    AppMethodBeat.o(369719);
  }
  
  private static final void kLJ()
  {
    AppMethodBeat.i(369720);
    Log.i("MicroMsg.UserDataOperationReporter", "save");
    try
    {
      dRj().encode("userdatalistitem", gNZ().toByteArray());
      AppMethodBeat.o(369720);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(369720);
    }
  }
  
  private static final void kM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(261747);
    long l = cn.getSyncServerTimeSecond();
    Object localObject1 = null;
    Object localObject2;
    Object localObject3;
    if ((OAX.contains(paramInt1 + '_' + paramInt2)) || (kL(paramInt1, paramInt2)))
    {
      localObject2 = gNZ().user_data_list;
      s.s(localObject2, "dataList.user_data_list");
      localObject3 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (fuv)((Iterator)localObject3).next();
        if ((((fuv)localObject2).business_type == paramInt1) && (((fuv)localObject2).aaaw == paramInt2)) {
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new fuv();
        ((fuv)localObject2).business_type = paramInt1;
        ((fuv)localObject2).aaaw = paramInt2;
        ((fuv)localObject2).timestamp = l;
        ((fuv)localObject2).abSN = 0;
        localObject1 = ah.aiuX;
        gNZ().user_data_list.add(localObject2);
      }
      if (kL(paramInt1, paramInt2)) {
        ((fuv)localObject2).abSN = 0;
      }
      ((fuv)localObject2).abSN += 1;
      localObject1 = new StringBuilder("op, businessType:");
      localObject3 = a.OAZ;
      localObject1 = ((StringBuilder)localObject1).append(a.toString(paramInt1)).append('(').append(paramInt1).append("), dataType:");
      localObject3 = l.b.OBa;
      Log.i("MicroMsg.UserDataOperationReporter", l.b.toString(paramInt2) + '(' + paramInt2 + "), count:" + ((fuv)localObject2).abSN + ", stack：" + Util.getStack());
      sz();
      AppMethodBeat.o(261747);
      return;
      localObject1 = null;
    }
  }
  
  private static final ah n(com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(369725);
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      Log.i("MicroMsg.UserDataOperationReporter", s.X("upload succ. size:", Integer.valueOf(gNZ().user_data_list.size())));
      gNZ().user_data_list = new LinkedList();
      sz();
    }
    for (;;)
    {
      parama = ah.aiuX;
      AppMethodBeat.o(369725);
      return parama;
      Log.e("MicroMsg.UserDataOperationReporter", "upload err.");
    }
  }
  
  private static void sz()
  {
    AppMethodBeat.i(261724);
    com.tencent.threadpool.h.ahAA.g(l..ExternalSyntheticLambda4.INSTANCE, "MicroMsg.UserDataOperationReporter");
    AppMethodBeat.o(261724);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/service/UserDataOperationReporter$BusinessType;", "", "()V", "APPBRAND", "", "BIZ", "CARDLIST", "CHAT", "CONTACTS", "FINDER", "GAME", "LOGIN", "LOL", "NEARBY", "OTHER", "PROFILE", "RADAR", "REGISTER", "SCAN", "SETTING", "SHAKE", "SNS", "SOS", "SPORT", "TEXTSTATUS", "WECOIN", "toString", "", "type", "BusinessTypeDef", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static final a OAZ;
    
    static
    {
      AppMethodBeat.i(261717);
      OAZ = new a();
      AppMethodBeat.o(261717);
    }
    
    public static String toString(int paramInt)
    {
      switch (paramInt)
      {
      case 16: 
      case 23: 
      default: 
        return "Unknown";
      case 1: 
        return "注册";
      case 2: 
        return "登录";
      case 3: 
        return "聊天";
      case 4: 
        return "个人信息";
      case 5: 
        return "视频号";
      case 6: 
        return "微信游戏";
      case 7: 
        return "看一看";
      case 8: 
        return "小程序";
      case 9: 
        return "状态";
      case 10: 
        return "微信运动";
      case 11: 
        return "公众号";
      case 12: 
        return "朋友圈";
      case 13: 
        return "通讯录";
      case 14: 
        return "卡包";
      case 15: 
        return "微信豆";
      case 17: 
        return "附近的人";
      case 18: 
        return "雷达";
      case 19: 
        return "摇一摇";
      case 20: 
        return "扫一扫";
      case 21: 
        return "搜一搜";
      case 22: 
        return "其它";
      }
      return "设置";
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/BatchUploadUserDataList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<lz>
  {
    public static final c OBb;
    
    static
    {
      AppMethodBeat.i(261739);
      OBb = new c();
      AppMethodBeat.o(261739);
    }
    
    c()
    {
      super();
    }
    
    private static lz gOd()
    {
      AppMethodBeat.i(261737);
      lz locallz = new lz();
      try
      {
        l locall = l.OAV;
        locallz.parseFrom(l.gOc().decodeBytes("userdatalistitem"));
        if ((locallz.user_data_list == null) || (locallz.user_data_list.size() > 10000)) {
          locallz.user_data_list = new LinkedList();
        }
        AppMethodBeat.o(261737);
        return locallz;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.UserDataOperationReporter", (Throwable)localException, null, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.l
 * JD-Core Version:    0.7.0.1
 */