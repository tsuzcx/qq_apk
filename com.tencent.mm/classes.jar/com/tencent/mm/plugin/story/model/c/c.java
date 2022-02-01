package com.tencent.mm.plugin.story.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.e;
import com.tencent.mm.g.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
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
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/download/StoryDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "()V", "attachSnsImgTaskInfo", "", "story", "tmpFilePath", "", "taskInfo", "Lcom/tencent/mm/cdn/keep_SnsImageTaskInfo;", "isDcIp", "referer", "getStringArray", "", "strList", "", "(Ljava/util/List;)[Ljava/lang/String;", "idDcIp", "scene", "Lcom/tencent/mm/storage/FROM_SCENE;", "url", "configTime", "", "hostname", "loadDataImp", "", "data", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.loader.c.b<d>
{
  public static final c.a SlW;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118901);
    SlW = new c.a((byte)0);
    TAG = "MicroMsg.Loader.StoryDownloader";
    AppMethodBeat.o(118901);
  }
  
  private static boolean a(d paramd, String paramString1, e parame, String paramString2)
  {
    AppMethodBeat.i(118899);
    try
    {
      fis localfis = paramd.SlY;
      String str = new URL(localfis.aaTl).getHost();
      ArrayList localArrayList1 = new ArrayList();
      int i = com.tencent.mm.network.d.a(str, false, (List)localArrayList1);
      ArrayList localArrayList2 = new ArrayList();
      int j = com.tencent.mm.network.d.a(str, true, (List)localArrayList2);
      parame.field_mediaId = s.X(localfis.Id, "_");
      parame.url = localfis.aaTl;
      parame.host = str;
      parame.referer = paramString2;
      parame.lwD = paramString1;
      parame.lwE = hb((List)localArrayList1);
      parame.lwF = hb((List)localArrayList2);
      parame.lwG = i;
      parame.lwH = j;
      parame.isColdSnsData = false;
      parame.signalQuality = s.X("", Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)));
      parame.snsScene = "";
      parame.snsCipherKey = paramd.SlY.aaTD;
      parame.hyY = 3;
      parame.appType = 100;
      parame.fileType = 20201;
      Log.i(TAG, "attachSnsImgTaskInfo reqDownType:%s", new Object[] { parame });
      AppMethodBeat.o(118899);
      return true;
    }
    catch (MalformedURLException paramd)
    {
      Log.printErrStackTrace(TAG, (Throwable)paramd, "", new Object[0]);
      Log.w(TAG, s.X("attachSnsImgTaskInfo fail:", paramd));
      AppMethodBeat.o(118899);
    }
    return false;
  }
  
  private static String[] hb(List<String> paramList)
  {
    AppMethodBeat.i(118900);
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
        AppMethodBeat.o(118900);
        return arrayOfString;
      }
    }
  }
  
  public final void a(final com.tencent.mm.loader.g.a.a<d> parama, com.tencent.mm.loader.e.g paramg, final b.b paramb)
  {
    AppMethodBeat.i(118898);
    s.u(parama, "data");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    d locald = (d)parama.bmg();
    parama.bmg();
    Object localObject1 = am.aixg;
    localObject1 = "https://" + WeChatHosts.domainString(a.g.host_weixin_qq_com) + "/?version=%d&uin=%s&nettype=%d&signal=%d%s";
    int i = com.tencent.mm.protocal.d.Yxh;
    Object localObject2 = StoryCore.SjP;
    h.baC();
    localObject2 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i), p.getString(com.tencent.mm.kernel.b.getUin()), Integer.valueOf(NetStatusUtil.getNetTypeForStat(MMApplicationContext.getContext())), Integer.valueOf(ConnectivityCompat.Companion.getCompatMixStrength$default(ConnectivityCompat.Companion, false, 1, null)), "" }, 5));
    s.s(localObject2, "java.lang.String.format(format, *args)");
    e locale = new e();
    locale.taskName = "task_StoryDownloader";
    Log.i(TAG, "loadDataImp " + parama.bmg() + " story " + locald.SlY.Url);
    localObject1 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject1 = ((d)parama.bmg()).SlY.Url;
    String str = ((d)parama.bmg()).username;
    if (localObject1 == null) {}
    for (localObject1 = "";; localObject1 = s.X(com.tencent.mm.plugin.story.model.k.lp(str, com.tencent.mm.b.g.getMessageDigest((byte[])localObject1)), ".d"))
    {
      parama = s.X((String)localObject1, paramg.f(parama));
      s.s(locald, "story");
      if (!a(locald, parama, locale, (String)localObject2)) {
        break label415;
      }
      locale.lwL = ((g.a)new b(locald, paramb, parama));
      if (!com.tencent.mm.modelcdntran.k.bHW().b((com.tencent.mm.g.g)locale, -1)) {
        break;
      }
      Log.i(TAG, "SubCoreCdnTransport addRecvTask suc");
      AppMethodBeat.o(118898);
      return;
      str = s.X(com.tencent.mm.plugin.story.model.k.bbL(str), "pic/");
      localObject1 = ((String)localObject1).getBytes(kotlin.n.d.UTF_8);
      s.s(localObject1, "(this as java.lang.String).getBytes(charset)");
    }
    Log.w(TAG, "SubCoreCdnTransport addRecvTask failed");
    paramb.atR();
    AppMethodBeat.o(118898);
    return;
    label415:
    Log.w(TAG, "attachSnsImgTaskInfo failed");
    paramb.atR();
    AppMethodBeat.o(118898);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/download/StoryDownloader$loadDataImp$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g.a
  {
    b(d paramd, b.b paramb, String paramString) {}
    
    public final int a(String paramString, int paramInt, com.tencent.mm.g.c paramc, com.tencent.mm.g.d paramd, boolean paramBoolean)
    {
      AppMethodBeat.i(118895);
      s.u(paramString, "mediaId");
      Log.i(c.access$getTAG$cp(), "mediaId " + paramString + " startRet " + paramInt + " sceneResult " + paramd + " onlyCheckExist " + paramBoolean);
      if (paramd != null)
      {
        if (this.SlX == null)
        {
          AppMethodBeat.o(118895);
          return 0;
        }
        paramString = paramb;
        paramc = com.tencent.mm.loader.g.a.aL(parama, "");
        s.s(paramc, "create(tmpFilePath, \"\")");
        paramString.a((f)paramc);
      }
      AppMethodBeat.o(118895);
      return 0;
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(118896);
      s.u(paramString, "mediaId");
      s.u(paramByteArrayOutputStream, "buff");
      AppMethodBeat.o(118896);
    }
    
    public final byte[] h(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(118897);
      s.u(paramString, "mediaId");
      s.u(paramArrayOfByte, "inbuf");
      AppMethodBeat.o(118897);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.c
 * JD-Core Version:    0.7.0.1
 */