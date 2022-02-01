package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.af;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "()V", "TAG", "", "attachSnsImgTaskInfo", "", "data", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-thumbplayer_release"})
public final class a
  extends com.tencent.mm.loader.d.b<g>
{
  final String TAG = "MicroMsg.CdnImageDownloder";
  
  private final boolean a(g paramg, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(192272);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = paramg.aBv();
      parame.url = paramString1;
      parame.snsCipherKey = paramg.decodeKey;
      parame.host = str;
      parame.referer = paramString3;
      parame.iUy = paramString2;
      parame.iUz = ey((List)localArrayList1);
      parame.iUA = ey((List)localArrayList2);
      parame.iUB = i;
      parame.iUC = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null);
      parame.snsScene = "";
      parame.hDp = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(this.TAG, "attachSnsImgTaskInfo, imageUrl:%s， " + paramg.decodeKey, new Object[] { paramString1 });
      AppMethodBeat.o(192272);
      return true;
    }
    catch (MalformedURLException paramg)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramg, "", new Object[0]);
      Log.w(this.TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramg)));
      AppMethodBeat.o(192272);
    }
    return false;
  }
  
  private static String[] ey(List<String> paramList)
  {
    AppMethodBeat.i(192274);
    String[] arrayOfString = new String[paramList.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(192274);
    return arrayOfString;
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<g> parama, com.tencent.mm.loader.f.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(192258);
    kotlin.g.b.p.k(parama, "url");
    kotlin.g.b.p.k(paramg, "fileNameCreator");
    kotlin.g.b.p.k(paramb, "callback");
    Object localObject2 = new StringBuilder().append(((g)parama.aSr()).url);
    Object localObject1 = ((g)parama.aSr()).zZu;
    paramg = (com.tencent.mm.loader.f.g)localObject1;
    if (localObject1 == null) {
      paramg = "";
    }
    paramg = paramg;
    localObject1 = af.aaBG;
    localObject1 = "https://" + WeChatHosts.domainString(com.tencent.mm.plugin.thumbplayer.a.a.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
    int i = com.tencent.mm.protocal.d.RAD;
    kotlin.g.b.p.j(h.aHE(), "MMKernel.account()");
    localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)), "" }, 5));
    kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
    localObject2 = new e();
    ((e)localObject2).taskName = "task_FinderCdnDownloader";
    final String str = ((g)parama.aSr()).filePath;
    Log.i(this.TAG, "start load tmpFileFilePath:" + str + ", url:" + ((g)parama.aSr()).url);
    u.bBD(new q(str).ifA());
    parama = parama.aSr();
    kotlin.g.b.p.j(parama, "url.value()");
    if (a((g)parama, paramg, str, (e)localObject2, (String)localObject1))
    {
      ((e)localObject2).iUG = ((g.a)new a(this, str, paramb));
      if (com.tencent.mm.aq.f.bkg().e((com.tencent.mm.i.g)localObject2))
      {
        Log.i(this.TAG, "SubCoreCdnTransport addRecvTask succ");
        AppMethodBeat.o(192258);
        return;
      }
      Log.w(this.TAG, "SubCoreCdnTransport addRecvTask failed");
      paramb.onError();
      AppMethodBeat.o(192258);
      return;
    }
    Log.w(this.TAG, "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(192258);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/thumbplayer/downloader/CdnImageDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-thumbplayer_release"})
  public static final class a
    implements g.a
  {
    a(String paramString, b.b paramb) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(192004);
      kotlin.g.b.p.k(paramString, "mediaId");
      paramc = this.MPD.TAG;
      StringBuilder localStringBuilder = new StringBuilder("mediaId ").append(paramString).append(" startRet ").append(paramInt).append(" sceneResult ").append(paramd).append(" onlyCheckExist ").append(paramBoolean).append(" retCode ");
      if (paramd != null)
      {
        paramString = Integer.valueOf(paramd.field_retCode);
        Log.i(paramc, paramString + ", fileExist:" + u.agG(str));
        if (paramd == null) {
          break label179;
        }
        if (paramd.field_retCode == 0) {
          break label145;
        }
        paramb.onError();
      }
      for (;;)
      {
        AppMethodBeat.o(192004);
        return 0;
        paramString = "";
        break;
        label145:
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.aC(str, "");
        kotlin.g.b.p.j(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
        continue;
        label179:
        if (paramInt != 0) {
          paramb.onError();
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(192008);
      kotlin.g.b.p.k(paramString, "mediaId");
      kotlin.g.b.p.k(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(192008);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(192011);
      kotlin.g.b.p.k(paramString, "mediaId");
      kotlin.g.b.p.k(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(192011);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.a
 * JD-Core Version:    0.7.0.1
 */