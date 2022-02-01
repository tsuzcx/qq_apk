package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.b.ae;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
public final class c
  extends com.tencent.mm.loader.d.b<d>
{
  public static final a FoB;
  private static final String TAG = "MicroMsg.Loader.StoryDownloader";
  
  static
  {
    AppMethodBeat.i(118901);
    FoB = new a((byte)0);
    TAG = "MicroMsg.Loader.StoryDownloader";
    AppMethodBeat.o(118901);
  }
  
  private static boolean a(d paramd, String paramString1, e parame, String paramString2)
  {
    AppMethodBeat.i(118899);
    try
    {
      edt localedt = paramd.FoD;
      String str = new URL(localedt.Msz).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = (localedt.Id + "_");
      parame.url = localedt.Msz;
      parame.host = str;
      parame.referer = paramString2;
      parame.gqq = paramString1;
      parame.gqr = ef((List)localArrayList1);
      parame.gqs = ef((List)localArrayList2);
      parame.gqt = i;
      parame.gqu = j;
      parame.isColdSnsData = false;
      parame.signalQuality = NetStatusUtil.getStrength(MMApplicationContext.getContext());
      parame.snsScene = "";
      parame.snsCipherKey = paramd.FoD.MsR;
      parame.fuQ = 3;
      parame.appType = 100;
      parame.fileType = 20201;
      Log.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", new Object[] { parame });
      AppMethodBeat.o(118899);
      return true;
    }
    catch (MalformedURLException paramd)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramd, "", new Object[0]);
      Log.w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramd)));
      AppMethodBeat.o(118899);
    }
    return false;
  }
  
  private static String[] ef(List<String> paramList)
  {
    AppMethodBeat.i(118900);
    String[] arrayOfString = new String[paramList.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(118900);
    return arrayOfString;
  }
  
  public final void a(final com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.f.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(118898);
    kotlin.g.b.p.h(parama, "data");
    kotlin.g.b.p.h(paramg, "fileNameCreator");
    kotlin.g.b.p.h(paramb, "callback");
    d locald = (d)parama.value();
    Object localObject1 = ae.SYK;
    localObject1 = "https://" + WeChatHosts.domainString(2131761749) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
    int i = com.tencent.mm.protocal.d.KyO;
    Object localObject2 = j.Fmy;
    kotlin.g.b.p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
    localObject2 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(NetStatusUtil.getStrength(MMApplicationContext.getContext())), "" }, 5));
    kotlin.g.b.p.g(localObject2, "java.lang.String.format(format, *args)");
    e locale = new e();
    locale.taskName = "task_StoryDownloader";
    Log.i(TAG, "loadDataImp " + (d)parama.value() + " story " + locald.FoD.Url);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = com.tencent.mm.plugin.story.f.l.FmK;
    Object localObject3 = ((d)parama.value()).FoD.Url;
    String str = ((d)parama.value()).username;
    if (localObject3 == null) {}
    for (localObject1 = "";; localObject1 = com.tencent.mm.plugin.story.f.l.jF(str, com.tencent.mm.b.g.getMessageDigest((byte[])localObject3)) + ".d")
    {
      parama = (String)localObject1 + paramg.d(parama);
      kotlin.g.b.p.g(locald, "story");
      if (!a(locald, parama, locale, (String)localObject2)) {
        break label461;
      }
      locale.gqy = ((g.a)new b(locald, paramb, parama));
      if (!com.tencent.mm.an.f.baQ().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(118898);
      return;
      localObject1 = new StringBuilder();
      str = com.tencent.mm.plugin.story.f.l.aRU(str) + "pic/";
      localObject3 = ((String)localObject3).getBytes(kotlin.n.d.UTF_8);
      kotlin.g.b.p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    }
    Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(118898);
    return;
    label461:
    Log.w(TAG, "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(118898);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class b
    implements g.a
  {
    b(d paramd, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(118895);
      kotlin.g.b.p.h(paramString, "mediaId");
      Log.i(c.access$getTAG$cp(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.FoC == null)
        {
          AppMethodBeat.o(118895);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.az(parama, "");
        kotlin.g.b.p.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
      }
      AppMethodBeat.o(118895);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(118896);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(118896);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(118897);
      kotlin.g.b.p.h(paramString, "mediaId");
      kotlin.g.b.p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(118897);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.c
 * JD-Core Version:    0.7.0.1
 */