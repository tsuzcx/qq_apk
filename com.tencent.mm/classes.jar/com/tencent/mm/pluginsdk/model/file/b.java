package com.tencent.mm.pluginsdk.model.file;

import android.util.Pair;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.plugin.record.model.g.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr;", "Lcom/tencent/mm/plugin/record/model/NetSceneDownloadAppAttach$IFileLanDownloadCall;", "()V", "TAG", "", "cdnCallback", "com/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1", "Lcom/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1;", "downloadTaskMap", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lcom/tencent/mm/storage/MsgInfo;", "Lkotlin/collections/HashMap;", "cancelLanDownloadFile", "", "msgInfo", "mediaid", "downloadImp", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cgi", "aesKey", "getMediaId", "startToLanDownloadFile", "appmsgContent", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements g.a
{
  private static final HashMap<String, r<cc, String>> JoS;
  public static final b XTS;
  private static final a XTT;
  
  static
  {
    AppMethodBeat.i(244735);
    b localb = new b();
    XTS = localb;
    g.a((g.a)localb);
    JoS = new HashMap();
    XTT = new a();
    AppMethodBeat.o(244735);
  }
  
  private static void a(cc paramcc, k.b paramb, String paramString1, String paramString2)
  {
    AppMethodBeat.i(244726);
    if (paramcc == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp msgInfo is null");
      AppMethodBeat.o(244726);
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp content is null");
      AppMethodBeat.o(244726);
      return;
    }
    String str = bz(paramcc);
    if (JoS.containsKey(str))
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "downloadImp " + str + " has exist");
      AppMethodBeat.o(244726);
      return;
    }
    if (ab.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(244726);
      return;
    }
    paramb = s.X(n.aK(com.tencent.mm.loader.i.b.bmC(), paramb.title, paramb.nRe), "_lan_tmp");
    if (y.ZC(paramb)) {
      y.deleteFile(paramb);
    }
    ((Map)JoS).put(str, new r(paramcc, paramb));
    com.tencent.mm.plugin.cdndownloader.c.a.dpY().bHX();
    paramcc = c.XTU;
    int i = com.tencent.mm.modelcdntran.d.a(str, paramString1, paramString2, paramb, (int)c.iIN(), (CdnLogic.DownloadCallback)XTT);
    paramcc = f.Ozc;
    if (i == 0) {}
    for (long l = 11L;; l = 12L)
    {
      paramcc.idkeyStat(1680L, l, 1L, false);
      Log.i("MicroMsg.FileLanDownloadMgr", "fetch: start mediaId:" + str + " cgi:" + paramString1 + " aesKey:" + paramString2 + " tmpFile " + str + ' ' + i);
      AppMethodBeat.o(244726);
      return;
    }
  }
  
  public static void b(cc paramcc, k.b paramb)
  {
    AppMethodBeat.i(244716);
    s.u(paramcc, "msgInfo");
    long l1 = cn.bDu();
    long l2 = paramcc.getCreateTime();
    Object localObject = c.XTU;
    if (l1 - l2 >= c.iIN())
    {
      paramcc = c.XTU;
      Log.i("MicroMsg.FileLanDownloadMgr", "startToLanDownloadFile exceed limit time, %s", new Object[] { Long.valueOf(c.iIN()) });
      AppMethodBeat.o(244716);
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.FileLanDownloadMgr", "appmsgContent is null!");
      AppMethodBeat.o(244716);
      return;
    }
    String str = "";
    if (paramb.type == 74)
    {
      if (ab.isNullOrNil(paramb.nTV))
      {
        Log.e("MicroMsg.FileLanDownloadMgr", "fileLanInfo is null!");
        AppMethodBeat.o(244716);
        return;
      }
      localObject = paramb.nTV;
      s.s(localObject, "appmsgContent.fileLanInfo");
      localObject = (CharSequence)localObject;
      localObject = ((Collection)new kotlin.n.k(";").o((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        paramcc = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(244716);
        throw paramcc;
      }
      localObject = (String[])localObject;
      if ((localObject == null) || (localObject.length != 2)) {
        break label324;
      }
      str = localObject[0];
      localObject = localObject[1];
      Log.i("MicroMsg.FileLanDownloadMgr", "startToLanDownloadFile cgi:%s aesKey:%s", new Object[] { str, localObject });
    }
    for (;;)
    {
      a(paramcc, paramb, str, (String)localObject);
      AppMethodBeat.o(244716);
      return;
      localObject = ((PluginMessengerFoundation)h.az(PluginMessengerFoundation.class)).getFileMsgInfoStorage().zg(paramcc.field_msgSvrId);
      if (localObject != null)
      {
        str = ((com.tencent.mm.storage.a.a)localObject).field_cgi;
        s.s(str, "fileMsgInfo.field_cgi");
        localObject = ((com.tencent.mm.storage.a.a)localObject).field_aeskey;
        s.s(localObject, "fileMsgInfo.field_aeskey");
      }
      else
      {
        label324:
        localObject = "";
      }
    }
  }
  
  private static String bz(cc paramcc)
  {
    AppMethodBeat.i(244729);
    paramcc = "lan_" + paramcc.field_talker + '_' + paramcc.field_msgId;
    AppMethodBeat.o(244729);
    return paramcc;
  }
  
  public final void br(cc paramcc)
  {
    AppMethodBeat.i(244749);
    if (paramcc == null) {}
    for (paramcc = null;; paramcc = ah.aiuX)
    {
      if (paramcc == null) {
        Log.e("MicroMsg.FileLanDownloadMgr", "cancelLanDownloadFile msginfo is null");
      }
      AppMethodBeat.o(244749);
      return;
      paramcc = bz(paramcc);
      Log.i("MicroMsg.FileLanDownloadMgr", s.X("cancelLanDownloadFile ", paramcc));
      s.u(paramcc, "mediaid");
      Log.i("MicroMsg.FileLanDownloadMgr", s.X("cancelLanDownloadFile ", paramcc));
      com.tencent.mm.plugin.cdndownloader.c.a.dpY().bHX();
      com.tencent.mm.modelcdntran.d.Nv(paramcc);
      r localr = (r)JoS.get(paramcc);
      if (localr != null)
      {
        y.deleteFile((String)localr.bsD);
        f.Ozc.idkeyStat(1680L, 16L, 1L, false);
      }
      JoS.remove(paramcc);
    }
  }
  
  public final void by(cc paramcc)
  {
    AppMethodBeat.i(244743);
    s.u(paramcc, "msgInfo");
    b(paramcc, k.b.Hf(paramcc.field_content));
    AppMethodBeat.o(244743);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/model/file/FileLanDownloadMgr$cdnCallback$1", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "onC2CDownloadCompleted", "", "filekey", "", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onDownloadProgressChanged", "finished", "", "total", "tryshow", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements CdnLogic.DownloadCallback
  {
    public final void onC2CDownloadCompleted(String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
    {
      AppMethodBeat.i(244717);
      Object localObject2 = new StringBuilder("onC2CDownloadCompleted: ").append(paramString).append(", ");
      Object localObject1;
      long l;
      if (paramC2CDownloadResult == null)
      {
        localObject1 = null;
        Log.i("MicroMsg.FileLanDownloadMgr", localObject1);
        l = System.currentTimeMillis();
        if (paramC2CDownloadResult == null) {
          break label360;
        }
        if (paramC2CDownloadResult.errorCode != 0) {
          break label332;
        }
        localObject1 = (r)((Map)b.fLf()).get(paramString);
        if (localObject1 != null) {
          break label151;
        }
        paramC2CDownloadResult = null;
        if (paramC2CDownloadResult == null) {
          Log.e("MicroMsg.FileLanDownloadMgr", "onC2CDownloadCompleted pair is null");
        }
        f.Ozc.idkeyStat(1680L, 14L, 1L, false);
      }
      for (;;)
      {
        paramC2CDownloadResult = (Map)b.fLf();
        if (paramC2CDownloadResult != null) {
          break label349;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(244717);
        throw paramString;
        localObject1 = Integer.valueOf(paramC2CDownloadResult.errorCode);
        break;
        label151:
        Log.i("MicroMsg.FileLanDownloadMgr", "onC2CDownloadCompleted msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(((cc)((r)localObject1).bsC).field_msgId), Long.valueOf(((cc)((r)localObject1).bsC).field_msgSvrId) });
        StringBuilder localStringBuilder;
        if (com.tencent.mm.plugin.openapi.a.cWJ().yi(((cc)((r)localObject1).bsC).field_msgId) == null)
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.k.d((cc)((r)localObject1).bsC, true);
          localStringBuilder = new StringBuilder("onC2CDownloadCompleted info is null, initPair:");
          if (localObject2 != null) {
            break label308;
          }
          paramC2CDownloadResult = null;
          label248:
          localStringBuilder = localStringBuilder.append(paramC2CDownloadResult).append(", ");
          if (localObject2 != null) {
            break label320;
          }
        }
        label308:
        label320:
        for (paramC2CDownloadResult = null;; paramC2CDownloadResult = (String)((Pair)localObject2).second)
        {
          Log.i("MicroMsg.FileLanDownloadMgr", paramC2CDownloadResult);
          paramC2CDownloadResult = Boolean.valueOf(g.f((cc)((r)localObject1).bsC, (String)((r)localObject1).bsD));
          break;
          paramC2CDownloadResult = (Boolean)((Pair)localObject2).first;
          break label248;
        }
        label332:
        f.Ozc.idkeyStat(1680L, 15L, 1L, false);
      }
      label349:
      an.hJ(paramC2CDownloadResult).remove(paramString);
      label360:
      Log.i("MicroMsg.FileLanDownloadMgr", "cdnCallback downloadTaskMap:" + b.fLf().size() + ", internal:" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(244717);
    }
    
    public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(244728);
      Log.i("MicroMsg.FileLanDownloadMgr", "onDownloadProgressChanged: " + paramString + ", " + paramLong1 + ", " + paramLong2 + ", " + paramBoolean);
      AppMethodBeat.o(244728);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.file.b
 * JD-Core Version:    0.7.0.1
 */