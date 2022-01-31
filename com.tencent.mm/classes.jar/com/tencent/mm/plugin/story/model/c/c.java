package com.tencent.mm.plugin.story.model.c;

import a.f.b.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g.a;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"})
public final class c
  extends com.tencent.mm.loader.d.b<d>
{
  private static final String TAG = "MicroMsg.Loader.StoryDownloader";
  public static final c.a syd;
  
  static
  {
    AppMethodBeat.i(109298);
    syd = new c.a((byte)0);
    TAG = "MicroMsg.Loader.StoryDownloader";
    AppMethodBeat.o(109298);
  }
  
  private static boolean a(d paramd, String paramString1, e parame, String paramString2)
  {
    AppMethodBeat.i(109296);
    try
    {
      chl localchl = paramd.syh;
      String str = new URL(localchl.xrS).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.b.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.b.a(str, true, (List)localArrayList2);
      parame.field_mediaId = (localchl.Id + "_");
      parame.url = localchl.xrS;
      parame.host = str;
      parame.referer = paramString2;
      parame.edg = paramString1;
      parame.edh = de((List)localArrayList1);
      parame.edi = de((List)localArrayList2);
      parame.edj = i;
      parame.edk = j;
      parame.isColdSnsData = false;
      parame.signalQuality = at.getStrength(ah.getContext());
      parame.snsScene = "";
      parame.snsCipherKey = paramd.syh.xsm;
      parame.dqS = 3;
      parame.edl = 100;
      parame.fileType = 20201;
      ab.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", new Object[] { parame });
      AppMethodBeat.o(109296);
      return true;
    }
    catch (MalformedURLException paramd)
    {
      ab.printErrStackTrace(TAG, (Throwable)paramd, "", new Object[0]);
      ab.w(TAG, "attachSnsImgTaskInfo fail:".concat(String.valueOf(paramd)));
      AppMethodBeat.o(109296);
    }
    return false;
  }
  
  private static String[] de(List<String> paramList)
  {
    AppMethodBeat.i(109297);
    String[] arrayOfString = new String[paramList.size()];
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(109297);
    return arrayOfString;
  }
  
  public final void a(final com.tencent.mm.loader.h.a.a<d> parama, com.tencent.mm.loader.f.f paramf, final b.b paramb)
  {
    AppMethodBeat.i(109295);
    a.f.b.j.q(parama, "data");
    a.f.b.j.q(paramf, "fileNameCreator");
    a.f.b.j.q(paramb, "callback");
    d locald = (d)parama.value();
    Object localObject1 = y.BNt;
    int i = com.tencent.mm.protocal.d.whH;
    localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    a.f.b.j.p(com.tencent.mm.kernel.g.RJ(), "MMKernel.account()");
    String str1 = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.a.getUin()), Integer.valueOf(at.getNetTypeForStat(ah.getContext())), Integer.valueOf(at.getStrength(ah.getContext())), "" }, 5));
    a.f.b.j.p(str1, "java.lang.String.format(format, *args)");
    e locale = new e();
    ab.i(TAG, "loadDataImp " + (d)parama.value() + " story " + locald.syh.Url);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = com.tencent.mm.plugin.story.model.l.svv;
    Object localObject2 = ((d)parama.value()).syh.Url;
    String str2 = ((d)parama.value()).username;
    if (localObject2 == null) {}
    for (localObject1 = "";; localObject1 = com.tencent.mm.plugin.story.model.l.gK(str2, com.tencent.mm.a.g.w((byte[])localObject2)) + ".d")
    {
      parama = (String)localObject1 + paramf.c(parama);
      a.f.b.j.p(locald, "story");
      if (!a(locald, parama, locale, str1)) {
        break label424;
      }
      locale.edp = ((g.a)new b(locald, paramb, parama));
      if (!com.tencent.mm.al.f.afO().d((com.tencent.mm.i.g)locale)) {
        break;
      }
      ab.i(TAG, "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(109295);
      return;
      localObject1 = new StringBuilder();
      str2 = com.tencent.mm.plugin.story.model.l.acW(str2) + "/pic/";
      localObject2 = ((String)localObject2).getBytes(a.l.d.UTF_8);
      a.f.b.j.p(localObject2, "(this as java.lang.String).getBytes(charset)");
    }
    ab.w(TAG, "SubCoreCdnTransport addRecvTask failed");
    paramb.onError();
    AppMethodBeat.o(109295);
    return;
    label424:
    ab.w(TAG, "attachSnsImgTaskInfo failed");
    paramb.onError();
    AppMethodBeat.o(109295);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"})
  public static final class b
    implements g.a
  {
    b(d paramd, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(109292);
      a.f.b.j.q(paramString, "mediaId");
      ab.i(c.access$getTAG$cp(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.sye == null)
        {
          AppMethodBeat.o(109292);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.h.a.X(parama, "");
        a.f.b.j.p(paramc, "HttpFileResponse.create(tmpFilePath, \"\")");
        paramString.a((com.tencent.mm.loader.h.f)paramc);
      }
      AppMethodBeat.o(109292);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(109293);
      a.f.b.j.q(paramString, "mediaId");
      a.f.b.j.q(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(109293);
    }
    
    public final byte[] l(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(109294);
      a.f.b.j.q(paramString, "mediaId");
      a.f.b.j.q(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(109294);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.c
 * JD-Core Version:    0.7.0.1
 */