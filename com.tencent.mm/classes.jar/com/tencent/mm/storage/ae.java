package com.tencent.mm.storage;

import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.br;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emo;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizTimeLineRecCardLogic;", "", "()V", "MAX_INSERT_COUNT", "", "getMAX_INSERT_COUNT", "()I", "MAX_SAVE_COUNT", "getMAX_SAVE_COUNT", "MAX_SAVE_COUNT$delegate", "Lkotlin/Lazy;", "MIN_NEW_COUNT", "getMIN_NEW_COUNT", "MIN_NEW_COUNT$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "getRecReportInfo", "Lcom/tencent/mm/storage/RecMsgReportInfo;", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "idKey1577", "", "key", "", "insertRecCardUnderLine", "saveRecCardUnderLine", "msgContent", "", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final ae acGm;
  private static final j acGn;
  private static final j acGo;
  private static final int acGp;
  private static final j exj;
  
  static
  {
    AppMethodBeat.i(248527);
    acGm = new ae();
    exj = kotlin.k.cm((kotlin.g.a.a)ae.c.acGs);
    acGn = kotlin.k.cm((kotlin.g.a.a)a.acGq);
    acGo = kotlin.k.cm((kotlin.g.a.a)b.acGr);
    acGp = iYV();
    AppMethodBeat.o(248527);
  }
  
  public static cj I(ab paramab)
  {
    long l = 0L;
    AppMethodBeat.i(248508);
    s.u(paramab, "info");
    String str3 = "";
    String str2 = "";
    String str1 = "";
    Object localObject = paramab.iYp();
    int j;
    int i;
    if (localObject != null)
    {
      j = ((flj)localObject).style;
      if ((((flj)localObject).style == 101) || (((flj)localObject).style == 102) || (((flj)localObject).style == 103))
      {
        localObject = ((flj)localObject).abLM;
        paramab = str1;
        if (localObject == null) {
          break label249;
        }
        paramab = str1;
        if (Util.isNullOrNil((List)((apx)localObject).YSB)) {
          break label249;
        }
        paramab = ((apx)localObject).YSB.get(0);
        str1 = ((qo)paramab).UserName;
        localObject = (qn)((qo)paramab).YVI.get(0);
        paramab = str1;
        if (localObject == null) {
          break label249;
        }
        str2 = ((qn)localObject).YVF;
        paramab = ((qn)localObject).YQK;
        if (Util.isNullOrNil(paramab)) {
          break label254;
        }
        paramab = Uri.parse(paramab);
        l = Util.getLong(paramab.getQueryParameter("mid"), 0L);
        i = Util.getInt(paramab.getQueryParameter("idx"), 0);
        paramab = str1;
      }
    }
    for (;;)
    {
      paramab = new cj(l, i, j, str2, str3, paramab);
      AppMethodBeat.o(248508);
      return paramab;
      paramab = str1;
      if (((flj)localObject).style == 1001)
      {
        str3 = ((flj)localObject).hRR;
        i = 0;
        paramab = str1;
      }
      else
      {
        label249:
        i = 0;
        continue;
        label254:
        i = 0;
        break;
        j = 0;
        i = 0;
        paramab = str1;
      }
    }
  }
  
  public static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(248488);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(248488);
    return localMultiProcessMMKV;
  }
  
  public static void bvF(String paramString)
  {
    AppMethodBeat.i(248494);
    if (paramString == null)
    {
      AppMethodBeat.o(248494);
      return;
    }
    com.tencent.threadpool.h.ahAA.g(new ae..ExternalSyntheticLambda0(paramString), "RecCardUnderLineThread");
    AppMethodBeat.o(248494);
  }
  
  private static final void bvG(String paramString)
  {
    Object localObject3 = null;
    int j = 1;
    AppMethodBeat.i(248513);
    com.tencent.mm.kernel.h.baC();
    String str = s.X("RecCardSaveList:", b.aZs());
    Object localObject1 = atj();
    s.s(localObject1, "mmkv");
    int i;
    if (((MultiProcessMMKV)localObject1).containsKey(str))
    {
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
      if (localObject1 != null) {
        if (localObject1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label215;
          }
          i = j;
          label68:
          if (i == 0) {
            break label238;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        localObject4 = emo.class.newInstance();
        ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject4;
        localObject4 = (emo)localObject1;
        if (localObject4 != null) {
          break label243;
        }
        localObject4 = new emo();
        if (((emo)localObject4).lPK.size() < iYV()) {
          break label262;
        }
        localObject1 = ((emo)localObject4).lPK;
        s.s(localObject1, "recCardSaveList.list");
        Iterator localIterator = ((Iterable)localObject1).iterator();
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break label246;
        }
        emn localemn = (emn)localIterator.next();
        localObject3 = localemn;
        if (localObject1 != null)
        {
          if (((emn)localObject1).abqQ <= localemn.abqQ) {
            break label368;
          }
          localObject3 = localemn;
        }
        localObject1 = localObject3;
        continue;
        i = 0;
      }
      catch (Exception localException)
      {
        label215:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break label68;
      label238:
      Object localObject2 = null;
      continue;
      label243:
      continue;
      label246:
      ((emo)localObject4).lPK.remove(localObject2);
      yX(19L);
      label262:
      localObject2 = ((emo)localObject4).lPK;
      localObject3 = new emn();
      ((emn)localObject3).content = paramString;
      ((emn)localObject3).abqQ = br.bCJ();
      paramString = ah.aiuX;
      ((LinkedList)localObject2).add(localObject3);
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", s.X("saveRecCardUnderLine size ", Integer.valueOf(((emo)localObject4).lPK.size())));
      try
      {
        atj().encode(str, ((emo)localObject4).toByteArray());
        AppMethodBeat.o(248513);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.BizTimeLineStorageLogicExKt", s.X("saveRecCardUnderLine ex ", paramString.getMessage()));
        AppMethodBeat.o(248513);
        return;
      }
      label368:
      localObject3 = localObject2;
    }
  }
  
  private static int iYV()
  {
    AppMethodBeat.i(248491);
    int i = ((Number)acGn.getValue()).intValue();
    AppMethodBeat.o(248491);
    return i;
  }
  
  public static void iYW()
  {
    AppMethodBeat.i(248499);
    com.tencent.threadpool.h.ahAA.g(ae..ExternalSyntheticLambda1.INSTANCE, "RecCardUnderLineThread");
    AppMethodBeat.o(248499);
  }
  
  private static final void iYX()
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(248522);
    com.tencent.mm.kernel.h.baC();
    String str = s.X("RecCardSaveList:", b.aZs());
    Object localObject1 = atj();
    s.s(localObject1, "mmkv");
    if (((MultiProcessMMKV)localObject1).containsKey(str))
    {
      localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(str);
      if (localObject1 != null) {
        if (localObject1.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label129;
          }
          i = k;
          label75:
          if (i == 0) {
            break label154;
          }
        }
      }
    }
    label129:
    label154:
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject3 = emo.class.newInstance();
        ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (com.tencent.mm.bx.a)localObject3;
        localObject1 = (emo)localObject1;
        if (localObject1 != null) {
          break label160;
        }
        AppMethodBeat.o(248522);
        return;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException1, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label75;
      localObject2 = null;
    }
    label160:
    if (localObject2.lPK.isEmpty())
    {
      AppMethodBeat.o(248522);
      return;
    }
    yX(10L);
    long l1 = af.bHl().iYD();
    Object localObject3 = af.bHl();
    long l2 = l1 << 32;
    Object localObject4 = "SELECT count(*) FROM BizTimeLineInfo where orderFlag >= ".concat(String.valueOf(l2));
    localObject3 = ((ac)localObject3).omV.rawQuery((String)localObject4, null);
    if (((Cursor)localObject3).moveToFirst()) {}
    for (int i = ((Cursor)localObject3).getInt(0);; i = 0)
    {
      ((Cursor)localObject3).close();
      if (i < ((Number)acGo.getValue()).intValue())
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", s.X("insertRecCardUnderLine newMsgCount=", Integer.valueOf(i)));
        yX(11L);
        AppMethodBeat.o(248522);
        return;
      }
      localObject3 = af.bHl();
      localObject4 = "SELECT count(*) FROM BizTimeLineInfo where type = 620757041 and orderFlag < " + l2 + " and orderFlag >= " + (l1 - 1L << 32);
      localObject3 = ((ac)localObject3).omV.rawQuery((String)localObject4, null);
      i = j;
      if (((Cursor)localObject3).moveToFirst()) {
        i = ((Cursor)localObject3).getInt(0);
      }
      ((Cursor)localObject3).close();
      j = acGp - i;
      if (j <= 0)
      {
        Log.i("MicroMsg.BizTimeLineStorageLogicExKt", s.X("insertRecCardUnderLine recCount=", Integer.valueOf(i)));
        yX(12L);
        AppMethodBeat.o(248522);
        return;
      }
      localObject3 = new LinkedList();
      localObject4 = localObject2.lPK;
      s.s(localObject4, "recCardSaveList.list");
      localObject4 = ((Iterable)p.c((Iterable)localObject4, kotlin.k.k.qv(j, localObject2.lPK.size()))).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        emn localemn = (emn)((Iterator)localObject4).next();
        ((LinkedList)localObject3).add(localemn);
        yX(14L);
        ad.bvC(localemn.content);
      }
      Log.i("MicroMsg.BizTimeLineStorageLogicExKt", s.X("insertRecCardUnderLine insertList=", Integer.valueOf(((LinkedList)localObject3).size())));
      yX(13L);
      localObject2.lPK.removeAll((Collection)localObject3);
      try
      {
        atj().encode(str, localObject2.toByteArray());
        AppMethodBeat.o(248522);
        return;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.BizDigestUtil", s.X("saveWebViewAlbumInfoInfo ex ", localException2.getMessage()));
        AppMethodBeat.o(248522);
        return;
      }
    }
  }
  
  public static void yX(long paramLong)
  {
    AppMethodBeat.i(248502);
    com.tencent.mm.plugin.report.service.h.OAn.p(1577L, paramLong, 1L);
    AppMethodBeat.o(248502);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final a acGq;
    
    static
    {
      AppMethodBeat.i(248640);
      acGq = new a();
      AppMethodBeat.o(248640);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b acGr;
    
    static
    {
      AppMethodBeat.i(248634);
      acGr = new b();
      AppMethodBeat.o(248634);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.storage.ae
 * JD-Core Version:    0.7.0.1
 */