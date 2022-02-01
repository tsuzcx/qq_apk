package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
public final class c
  extends com.tencent.mm.loader.d.b<d>
{
  public static final c.a AMi;
  private static final String TAG = "MicroMsg.Loader.StoryDownloader";
  
  static
  {
    AppMethodBeat.i(118901);
    AMi = new c.a((byte)0);
    TAG = "MicroMsg.Loader.StoryDownloader";
    AppMethodBeat.o(118901);
  }
  
  private static boolean a(d paramd, String paramString1, e parame, String paramString2)
  {
    AppMethodBeat.i(118899);
    try
    {
      djl localdjl = paramd.AMk;
      String str = new URL(localdjl.GSI).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.b.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.b.a(str, true, (List)localArrayList2);
      parame.field_mediaId = (localdjl.Id + "_");
      parame.url = localdjl.GSI;
      parame.host = str;
      parame.referer = paramString2;
      parame.fIZ = paramString1;
      parame.fJa = dF((List)localArrayList1);
      parame.fJb = dF((List)localArrayList2);
      parame.fJc = i;
      parame.fJd = j;
      parame.isColdSnsData = false;
      parame.signalQuality = ay.getStrength(aj.getContext());
      parame.snsScene = "";
      parame.snsCipherKey = paramd.AMk.GTc;
      parame.ePC = 3;
      parame.appType = 100;
      parame.fileType = 20201;
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", new Object[] { parame });
      AppMethodBeat.o(118899);
      return true;
    }
    catch (MalformedURLException paramd)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace(TAG, (Throwable)paramd, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramd)));
      AppMethodBeat.o(118899);
    }
    return false;
  }
  
  private static String[] dF(List<String> paramList)
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
    d.g.b.p.h(parama, "data");
    d.g.b.p.h(paramg, "fileNameCreator");
    d.g.b.p.h(paramb, "callback");
    d locald = (d)parama.value();
    Object localObject1 = d.g.b.ad.MLZ;
    int i = com.tencent.mm.protocal.d.Fnj;
    localObject1 = j.AKb;
    d.g.b.p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
    String str1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(ay.getNetTypeForStat(aj.getContext())), Integer.valueOf(ay.getStrength(aj.getContext())), "" }, 5));
    d.g.b.p.g(str1, "java.lang.String.format(format, *args)");
    e locale = new e();
    locale.fJi = "task_StoryDownloader";
    com.tencent.mm.sdk.platformtools.ad.i(TAG, "loadDataImp " + (d)parama.value() + " story " + locald.AMk.Url);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = com.tencent.mm.plugin.story.f.l.AKo;
    Object localObject2 = ((d)parama.value()).AMk.Url;
    String str2 = ((d)parama.value()).username;
    if (localObject2 == null) {}
    for (localObject1 = "";; localObject1 = com.tencent.mm.plugin.story.f.l.iN(str2, com.tencent.mm.b.g.getMessageDigest((byte[])localObject2)) + ".d")
    {
      parama = (String)localObject1 + paramg.c(parama);
      d.g.b.p.g(locald, "story");
      if (!a(locald, parama, locale, str1)) {
        break label432;
      }
      locale.fJj = ((g.a)new b(locald, paramb, parama));
      if (!com.tencent.mm.ao.f.aGI().e((com.tencent.mm.i.g)locale)) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(118898);
      return;
      localObject1 = new StringBuilder();
      str2 = com.tencent.mm.plugin.story.f.l.aBF(str2) + "pic/";
      localObject2 = ((String)localObject2).getBytes(d.n.d.UTF_8);
      d.g.b.p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    }
    com.tencent.mm.sdk.platformtools.ad.w(TAG, "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(118898);
    return;
    label432:
    com.tencent.mm.sdk.platformtools.ad.w(TAG, "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(118898);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class b
    implements g.a
  {
    b(d paramd, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(118895);
      d.g.b.p.h(paramString, "mediaId");
      com.tencent.mm.sdk.platformtools.ad.i(c.access$getTAG$cp(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.AMj == null)
        {
          AppMethodBeat.o(118895);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.aw(parama, "");
        d.g.b.p.g(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
      }
      AppMethodBeat.o(118895);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(118896);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(118896);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(118897);
      d.g.b.p.h(paramString, "mediaId");
      d.g.b.p.h(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(118897);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.c
 * JD-Core Version:    0.7.0.1
 */