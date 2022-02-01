package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c;
import com.tencent.mm.g.e;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/downloader/CdnImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/thumbplayer/downloader/ImageLoadData;", "()V", "TAG", "", "attachSnsImgTaskInfo", "", "data", "imageUrl", "tmpFilePath", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.loader.c.b<g>
{
  final String TAG = "MicroMsg.CdnImageDownloder";
  
  private final boolean a(g paramg, String paramString1, String paramString2, e parame, String paramString3)
  {
    AppMethodBeat.i(272181);
    try
    {
      String str = new URL(paramString1).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = paramg.aUt();
      parame.url = paramString1;
      parame.snsCipherKey = paramg.decodeKey;
      parame.host = str;
      parame.referer = paramString3;
      parame.lwD = paramString2;
      parame.lwE = hb((List)localArrayList1);
      parame.lwF = hb((List)localArrayList2);
      parame.lwG = i;
      parame.lwH = j;
      parame.isColdSnsData = false;
      parame.signalQuality = s.X("", Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)));
      parame.snsScene = "";
      parame.hyY = 3;
      parame.appType = 150;
      parame.fileType = 20201;
      Log.i(this.TAG, s.X("attachSnsImgTaskInfo, imageUrl:%s， ", paramg.decodeKey), new Object[] { paramString1 });
      AppMethodBeat.o(272181);
      return true;
    }
    catch (MalformedURLException paramg)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramg, "", new Object[0]);
      Log.w(this.TAG, s.X("attachSnsImgTaskInfo fail:", paramg));
      AppMethodBeat.o(272181);
    }
    return false;
  }
  
  private static String[] hb(List<String> paramList)
  {
    AppMethodBeat.i(272193);
    String[] arrayOfString = new String[paramList.size()];
    int k = arrayOfString.length - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      arrayOfString[i] = ((String)paramList.get(i));
      if (j > k)
      {
        AppMethodBeat.o(272193);
        return arrayOfString;
      }
    }
  }
  
  public final void a(com.tencent.mm.loader.g.a.a<g> parama, com.tencent.mm.loader.e.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(272213);
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    Object localObject2 = ((g)parama.bmg()).url;
    Object localObject1 = ((g)parama.bmg()).msf;
    paramg = (com.tencent.mm.loader.e.g)localObject1;
    if (localObject1 == null) {
      paramg = "";
    }
    paramg = s.X((String)localObject2, paramg);
    localObject1 = am.aixg;
    localObject1 = "https://" + WeChatHosts.domainString(com.tencent.mm.plugin.thumbplayer.a.a.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
    int i = com.tencent.mm.protocal.d.Yxh;
    h.baC();
    localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)), "" }, 5));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    localObject2 = new e();
    ((e)localObject2).taskName = "task_FinderCdnDownloader";
    final String str = ((g)parama.bmg()).filePath;
    Log.i(this.TAG, "start load tmpFileFilePath:" + str + ", url:" + ((g)parama.bmg()).url);
    y.bDX(new u(str).jKO());
    parama = parama.bmg();
    s.s(parama, "url.value()");
    if (a((g)parama, paramg, str, (e)localObject2, (String)localObject1))
    {
      ((e)localObject2).lwL = ((g.a)new a(this, str, paramb));
      if (k.bHW().b((com.tencent.mm.g.g)localObject2, -1))
      {
        Log.i(this.TAG, "SubCoreCdnTransport addRecvTask succ");
        AppMethodBeat.o(272213);
        return;
      }
      Log.w(this.TAG, "SubCoreCdnTransport addRecvTask failed");
      paramb.atR();
      AppMethodBeat.o(272213);
      return;
    }
    Log.w(this.TAG, "attachSnsImgTaskInfo failed");
    paramb.atR();
    AppMethodBeat.o(272213);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/thumbplayer/downloader/CdnImageDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    a(a parama, String paramString, b.b paramb) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(272163);
      s.u(paramString, "mediaId");
      paramc = this.TCe.TAG;
      StringBuilder localStringBuilder = new StringBuilder("mediaId ").append(paramString).append(" startRet ").append(paramInt).append(" sceneResult ").append(paramd).append(" onlyCheckExist ").append(paramBoolean).append(" retCode ");
      if (paramd == null)
      {
        paramString = "";
        Log.i(paramc, paramString + ", fileExist:" + y.ZC(str));
        if (paramd == null) {
          break label179;
        }
        if (paramd.field_retCode == 0) {
          break label145;
        }
        paramb.atR();
      }
      for (;;)
      {
        AppMethodBeat.o(272163);
        return 0;
        paramString = Integer.valueOf(paramd.field_retCode);
        break;
        label145:
        paramString = paramb;
        paramc = com.tencent.mm.loader.g.a.aL(str, "");
        s.s(paramc, "create(tmpFilePath, \"\")");
        paramString.a((f)paramc);
        continue;
        label179:
        if (paramInt != 0) {
          paramb.atR();
        }
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(272172);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(272172);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(272179);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(272179);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.a
 * JD-Core Version:    0.7.0.1
 */