package com.tencent.mm.plugin.story.proxy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.f.d;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/proxy/StoryProxy;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "()V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public static final c.a Sql;
  private static final c Sqm;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(119383);
    Sql = new c.a((byte)0);
    TAG = "MicroMsg.StoryProxy";
    Sqm = new c();
    AppMethodBeat.o(119383);
  }
  
  public static VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119380);
    if (MMApplicationContext.isMMProcess())
    {
      localObject = e.bIg().bIl();
      s.s(localObject, "getCore().storyRecordVideoPara");
      AppMethodBeat.o(119380);
      return localObject;
    }
    Object localObject = StoryCaptureProxy.SpO;
    localObject = StoryCaptureProxy.a.hxw().getVideoPara();
    AppMethodBeat.o(119380);
    return localObject;
  }
  
  public final int commitStory(String paramString1, String paramString2, enw paramenw, aes paramaes, fir paramfir, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(366951);
    s.u(paramString1, "taskId");
    s.u(paramString2, "thumbPath");
    s.u(paramenw, "location");
    s.u(paramaes, "captureInfo");
    s.u(paramfir, "editorInfo");
    s.u(paramList1, "groupList");
    s.u(paramList2, "blackList");
    s.u(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      d locald = new d();
      dmb localdmb = new dmb();
      StoryCaptureProxy.a locala = StoryCaptureProxy.SpO;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "storyEditorData " + paramString1 + " isCaptureVideo:" + paramaes.nJW + " scope:" + paramInt);
      localdmb.aaSg = paramaes.nJW;
      locald.ne(paramString1, paramString2);
      locald.a(paramfir);
      locald.b(paramenw);
      locald.a(localdmb);
      locald.ane(paramInt);
      locald.lg(paramList1);
      locald.lh(paramList2);
      locald.li(paramList3);
      locald.EI(paramaes.NGB);
      paramInt = locald.FW();
      paramString1 = StoryCore.SjP;
      StoryCore.b.hvX().checkPost();
      AppMethodBeat.o(366951);
      return paramInt;
    }
    paramList3 = StoryCaptureProxy.SpO;
    paramInt = ((a)StoryCaptureProxy.a.hxw()).commitStory(paramString1, paramString2, paramenw, paramaes, paramfir, paramInt, paramList1, paramList2, (List)new ArrayList());
    AppMethodBeat.o(366951);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, enw paramenw, boolean paramBoolean, fir paramfir, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(366948);
    s.u(paramString1, "videoPath");
    s.u(paramString2, "thumbPath");
    s.u(paramString3, "mediaDes");
    s.u(paramenw, "location");
    s.u(paramfir, "editorInfo");
    s.u(paramList1, "groupList");
    s.u(paramList2, "blackList");
    s.u(paramList3, "srcMd5List");
    if (MMApplicationContext.isMMProcess())
    {
      String str = g.getMD5(paramString1);
      d locald = new d();
      dmb localdmb = new dmb();
      StoryCaptureProxy.a locala = StoryCaptureProxy.SpO;
      Log.i(StoryCaptureProxy.access$getTAG$cp(), "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean + " scope:" + paramInt1);
      localdmb.aaSg = paramBoolean;
      s.s(str, "md5");
      locald.bh(paramString1, paramString2, str);
      locald.b(paramenw);
      locald.a(paramfir);
      locald.a(localdmb);
      locald.ane(paramInt1);
      locald.lg(paramList1);
      locald.lh(paramList2);
      locald.li(paramList3);
      paramInt1 = locald.FW();
      paramString1 = StoryCore.SjP;
      StoryCore.b.hvX().checkPost();
      AppMethodBeat.o(366948);
      return paramInt1;
    }
    paramList3 = StoryCaptureProxy.SpO;
    paramInt1 = a.a.a((a)StoryCaptureProxy.a.hxw(), paramString1, paramString2, paramString3, paramenw, paramBoolean, paramfir, paramInt1, paramList1, paramList2, null, 1152);
    AppMethodBeat.o(366948);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c
 * JD-Core Version:    0.7.0.1
 */