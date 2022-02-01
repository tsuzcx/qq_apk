package com.tencent.mm.pluginsdk.model.a;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.record.b.f.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr;", "Lcom/tencent/mm/plugin/record/model/NetSceneDownloadAppAttach$IFileLanDownloadCall;", "()V", "TAG", "", "cdnCallback", "com/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1", "Lcom/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1;", "downloadTaskMap", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/storage/MsgInfo;", "Lkotlin/collections/HashMap;", "cancelLanDownloadFile", "", "msgInfo", "mediaid", "downloadImp", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cgi", "aesKey", "getMediaId", "startToLanDownloadFile", "appmsgContent", "app_release"})
public final class b
  implements f.a
{
  private static final HashMap<String, o<ca, String>> DvC;
  private static final a QXU;
  public static final b QXV;
  
  static
  {
    AppMethodBeat.i(277618);
    b localb = new b();
    QXV = localb;
    com.tencent.mm.plugin.record.b.f.a((f.a)localb);
    DvC = new HashMap();
    QXU = new a();
    AppMethodBeat.o(277618);
  }
  
  private static void a(ca paramca, k.b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(277613);
    if (paramca == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp msgInfo is null");
      AppMethodBeat.o(277613);
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp content is null");
      AppMethodBeat.o(277613);
      return;
    }
    String str = bj(paramca);
    if (DvC.containsKey(str))
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp " + str + " has exist");
      AppMethodBeat.o(277613);
      return;
    }
    if (ae.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(277613);
      return;
    }
    paramb = m.aw(com.tencent.mm.loader.j.b.aSO(), paramb.title, paramb.llY) + "_lan_tmp";
    if (u.agG(paramb)) {
      u.deleteFile(paramb);
    }
    ((Map)DvC).put(str, new o(paramca, paramb));
    paramca = com.tencent.mm.plugin.cdndownloader.c.a.cMu();
    p.j(paramca, "CdnDownloadNativeService.getInstance()");
    paramca.bkh();
    paramca = c.QXY;
    int i = com.tencent.mm.aq.a.a(str, paramString1, paramString2, paramb, (int)c.hhM(), (CdnLogic.DownloadCallback)QXU);
    paramca = com.tencent.mm.plugin.report.f.Iyx;
    if (i == 0) {}
    for (long l = 11L;; l = 12L)
    {
      paramca.idkeyStat(1680L, l, 1L, false);
      Log.i("MicroMsg.FileLanDownloadMgr", "fetch: start mediaId:" + str + " cgi:" + paramString1 + " aesKey:" + paramString2 + " tmpFile " + str + ' ' + i);
      AppMethodBeat.o(277613);
      return;
    }
  }
  
  public static void b(ca paramca, k.b paramb)
  {
    AppMethodBeat.i(277612);
    p.k(paramca, "msgInfo");
    long l1 = cm.bfC();
    long l2 = paramca.getCreateTime();
    Object localObject = c.QXY;
    if (l1 - l2 >= c.hhM())
    {
      paramca = c.QXY;
      Log.i("MicroMsg.FileLanDownloadMgr", "startToLanDownloadFile exceed limit time, %s", new Object[] { Long.valueOf(c.hhM()) });
      AppMethodBeat.o(277612);
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "appmsgContent is null!");
      AppMethodBeat.o(277612);
      return;
    }
    String str = "";
    if (paramb.type == 74)
    {
      if (ae.isNullOrNil(paramb.loS))
      {
        Log.e("MicroMsg.FileLanDownloadMgr", "fileLanInfo is null!");
        AppMethodBeat.o(277612);
        return;
      }
      localObject = paramb.loS;
      p.j(localObject, "appmsgContent.fileLanInfo");
      localObject = (CharSequence)localObject;
      localObject = ((Collection)new kotlin.n.k(";").u((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        paramca = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(277612);
        throw paramca;
      }
      localObject = (String[])localObject;
      if ((localObject == null) || (localObject.length != 2)) {
        break label336;
      }
      str = localObject[0];
      localObject = localObject[1];
      Log.i("MicroMsg.FileLanDownloadMgr", "startToLanDownloadFile cgi:%s aesKey:%s", new Object[] { str, localObject });
    }
    for (;;)
    {
      a(paramca, paramb, str, (String)localObject);
      AppMethodBeat.o(277612);
      return;
      localObject = h.ag(PluginMessengerFoundation.class);
      p.j(localObject, "MMKernel.plugin(PluginMe…erFoundation::class.java)");
      localObject = ((PluginMessengerFoundation)localObject).getFileMsgInfoStorage().UZ(paramca.apH());
      if (localObject != null)
      {
        str = ((com.tencent.mm.storage.a.a)localObject).field_cgi;
        p.j(str, "fileMsgInfo.field_cgi");
        localObject = ((com.tencent.mm.storage.a.a)localObject).field_aeskey;
        p.j(localObject, "fileMsgInfo.field_aeskey");
      }
      else
      {
        label336:
        localObject = "";
      }
    }
  }
  
  private static String bj(ca paramca)
  {
    AppMethodBeat.i(277614);
    paramca = "lan_" + paramca.apJ() + '_' + paramca.apG();
    AppMethodBeat.o(277614);
    return paramca;
  }
  
  public final void ba(ca paramca)
  {
    AppMethodBeat.i(277615);
    if (paramca != null)
    {
      paramca = bj(paramca);
      Log.i("MicroMsg.FileLanDownloadMgr", "cancelLanDownloadFile ".concat(String.valueOf(paramca)));
      p.k(paramca, "mediaid");
      Log.i("MicroMsg.FileLanDownloadMgr", "cancelLanDownloadFile ".concat(String.valueOf(paramca)));
      Object localObject = com.tencent.mm.plugin.cdndownloader.c.a.cMu();
      p.j(localObject, "CdnDownloadNativeService.getInstance()");
      ((com.tencent.mm.plugin.cdndownloader.c.a)localObject).bkh();
      com.tencent.mm.aq.a.Vv(paramca);
      localObject = (o)DvC.get(paramca);
      if (localObject != null)
      {
        u.deleteFile((String)((o)localObject).My);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1680L, 16L, 1L, false);
      }
      DvC.remove(paramca);
      AppMethodBeat.o(277615);
      return;
    }
    Log.e("MicroMsg.FileLanDownloadMgr", "cancelLanDownloadFile msginfo is null");
    AppMethodBeat.o(277615);
  }
  
  public final void bi(ca paramca)
  {
    AppMethodBeat.i(277611);
    p.k(paramca, "msgInfo");
    b(paramca, k.b.OQ(paramca.getContent()));
    AppMethodBeat.o(277611);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "app_release"})
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(269377);
      StringBuilder localStringBuilder = new StringBuilder("onC2CDownloadCompleted: ").append(paramString).append(", ");
      Object localObject;
      long l;
      if (paramC2CDownloadResult != null)
      {
        localObject = Integer.valueOf(paramC2CDownloadResult.errorCode);
        Log.i("MicroMsg.FileLanDownloadMgr", localObject);
        l = System.currentTimeMillis();
        if (paramC2CDownloadResult == null) {
          break label319;
        }
        if (paramC2CDownloadResult.errorCode != 0) {
          break label291;
        }
        paramC2CDownloadResult = b.QXV;
        paramC2CDownloadResult = (o)((Map)b.hhL()).get(paramString);
        if (paramC2CDownloadResult == null) {
          break label281;
        }
        Log.i("MicroMsg.FileLanDownloadMgr", "onC2CDownloadCompleted msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(((ca)paramC2CDownloadResult.Mx).apG()), Long.valueOf(((ca)paramC2CDownloadResult.Mx).apH()) });
        if (com.tencent.mm.plugin.ab.a.ctZ().TR(((ca)paramC2CDownloadResult.Mx).apG()) == null)
        {
          localObject = com.tencent.mm.pluginsdk.model.app.k.d((ca)paramC2CDownloadResult.Mx, true);
          Log.i("MicroMsg.FileLanDownloadMgr", "onC2CDownloadCompleted info is null, initPair:" + (Boolean)((Pair)localObject).first + ", " + (String)((Pair)localObject).second);
        }
        com.tencent.mm.plugin.record.b.f.d((ca)paramC2CDownloadResult.Mx, (String)paramC2CDownloadResult.My);
        label229:
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1680L, 14L, 1L, false);
      }
      for (;;)
      {
        paramC2CDownloadResult = b.QXV;
        paramC2CDownloadResult = (Map)b.hhL();
        if (paramC2CDownloadResult != null) {
          break label308;
        }
        paramString = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(269377);
        throw paramString;
        localObject = null;
        break;
        label281:
        Log.e("MicroMsg.FileLanDownloadMgr", "onC2CDownloadCompleted pair is null");
        break label229;
        label291:
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1680L, 15L, 1L, false);
      }
      label308:
      ag.fk(paramC2CDownloadResult).remove(paramString);
      label319:
      paramString = new StringBuilder("cdnCallback downloadTaskMap:");
      paramC2CDownloadResult = b.QXV;
      Log.i("MicroMsg.FileLanDownloadMgr", b.hhL().size() + ", internal:" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(269377);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(269379);
      Log.i("MicroMsg.FileLanDownloadMgr", "onDownloadProgressChanged: " + paramString + ", " + paramLong1 + ", " + paramLong2 + ", " + paramBoolean);
      AppMethodBeat.o(269379);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.a.b
 * JD-Core Version:    0.7.0.1
 */