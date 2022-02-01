package com.tencent.mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.f.c;
import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryCaptureProxy
  extends com.tencent.mm.remoteservice.a
  implements a
{
  public static final a SpO;
  public static StoryCaptureProxy SpQ;
  private static final String TAG;
  private static final String nBg;
  private r<? super Integer, ? super Integer, ? super String, ? super dlp, ah> SpP;
  
  static
  {
    AppMethodBeat.i(119365);
    SpO = new a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    nBg = "result_key";
    AppMethodBeat.o(119365);
  }
  
  public StoryCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static final void createInstance(com.tencent.mm.remoteservice.d paramd)
  {
    AppMethodBeat.i(119366);
    paramd = new StoryCaptureProxy(paramd);
    s.u(paramd, "<set-?>");
    SpQ = paramd;
    AppMethodBeat.o(119366);
  }
  
  public final int commitStory(String paramString1, String paramString2, enw paramenw, aes paramaes, fir paramfir, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(366965);
    s.u(paramString1, "taskId");
    s.u(paramString2, "thumbPath");
    s.u(paramenw, "location");
    s.u(paramaes, "captureInfo");
    s.u(paramfir, "editorInfo");
    s.u(paramList1, "groupList");
    s.u(paramList2, "blackList");
    s.u(paramList3, "srcMd5List");
    com.tencent.mm.plugin.story.model.f.d locald = new com.tencent.mm.plugin.story.model.f.d();
    dmb localdmb = new dmb();
    Log.d(TAG, "storyEditorData " + paramString1 + " isCaptureVideo:" + paramaes.nJW);
    localdmb.aaSg = paramaes.nJW;
    locald.ne(paramString1, paramString2);
    locald.a(paramfir);
    locald.b(paramenw);
    locald.a(localdmb);
    locald.ane(paramInt);
    locald.lg(paramList1);
    locald.lh(paramList2);
    locald.lh(paramList2);
    locald.EI(paramaes.NGB);
    locald.li(paramList3);
    paramInt = locald.FW();
    paramString1 = StoryCore.SjP;
    StoryCore.b.hvX().checkPost();
    AppMethodBeat.o(366965);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, enw paramenw, boolean paramBoolean, fir paramfir, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(366963);
    s.u(paramString1, "videoPath");
    s.u(paramString2, "thumbPath");
    s.u(paramString3, "mediaDes");
    s.u(paramenw, "location");
    s.u(paramfir, "editorInfo");
    s.u(paramList1, "groupList");
    s.u(paramList2, "blackList");
    s.u(paramList3, "srcMd5List");
    String str = g.getMD5(paramString1);
    com.tencent.mm.plugin.story.model.f.d locald = new com.tencent.mm.plugin.story.model.f.d();
    dmb localdmb = new dmb();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localdmb.aaSg = paramBoolean;
    s.s(str, "md5");
    locald.bh(paramString1, paramString2, str);
    locald.a(paramfir);
    locald.b(paramenw);
    locald.a(localdmb);
    locald.ane(paramInt1);
    locald.lg(paramList1);
    locald.lh(paramList2);
    locald.li(paramList3);
    paramInt1 = locald.FW();
    paramString1 = StoryCore.SjP;
    StoryCore.b.hvX().checkPost();
    AppMethodBeat.o(366963);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public final void commitStoryRemote(String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(366968);
    s.u(paramString1, "videoPath");
    s.u(paramString2, "thumbPath");
    s.u(paramString3, "mediaDes");
    s.u(paramList, "srcMd5List");
    String str = g.getMD5(paramString1);
    com.tencent.mm.plugin.story.model.f.d locald = new com.tencent.mm.plugin.story.model.f.d();
    dmb localdmb = new dmb();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localdmb.aaSg = paramBoolean;
    s.s(str, "md5");
    locald.bh(paramString1, paramString2, str);
    locald.a(localdmb);
    locald.li(paramList);
    locald.FW();
    paramString1 = StoryCore.SjP;
    StoryCore.b.hvX().checkPost();
    AppMethodBeat.o(366968);
  }
  
  public final Object get(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(119363);
    s.u(parama, "key");
    s.u(paramObject, "defva");
    at.a[] arrayOfa = (at.a[])at.a.class.getEnumConstants();
    if (arrayOfa == null) {}
    for (parama = null;; parama = arrayOfa[parama.ordinal()])
    {
      Log.i(TAG, "getConfigStorage, %s %s", new Object[] { parama, paramObject });
      parama = h.baE().ban().get(parama, paramObject);
      s.s(parama, "storage().configStg.get(index, defva)");
      AppMethodBeat.o(119363);
      return parama;
    }
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(119355);
    String str = REMOTE_CALL("getAccPathRemote", new Object[0]).toString();
    AppMethodBeat.o(119355);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(119356);
    String str = h.baE().mCJ;
    s.s(str, "storage().accPath");
    AppMethodBeat.o(119356);
    return str;
  }
  
  public final r<Integer, Integer, String, dlp, ah> getMusicCallback()
  {
    return this.SpP;
  }
  
  public final VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119357);
    VideoTransPara localVideoTransPara = (VideoTransPara)REMOTE_CALL("getVideoParaRemote", new Object[0]);
    s.checkNotNull(localVideoTransPara);
    AppMethodBeat.o(119357);
    return localVideoTransPara;
  }
  
  @com.tencent.mm.remoteservice.f
  public final VideoTransPara getVideoParaRemote()
  {
    AppMethodBeat.i(119358);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.e.bIg().bIl();
    s.s(localVideoTransPara, "para");
    AppMethodBeat.o(119358);
    return localVideoTransPara;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(119364);
    s.u(paramString, "methodName");
    s.u(paramBundle, "data");
    Log.i(TAG, "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        s.s(arrayOfMethod, "methods");
        int j = arrayOfMethod.length;
        int i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label265;
        }
        localObject1 = arrayOfMethod[i];
        i += 1;
        if (!n.T(((Method)localObject1).getName(), paramString, true)) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.e(TAG, "exception:%s", new Object[] { Util.stackTraceToString((Throwable)paramString) });
        AppMethodBeat.o(119364);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = getArgs(paramBundle);
        paramString = ((Method)localObject1).invoke(this, Arrays.copyOf(paramString, paramString.length));
        if (!s.p(((Method)localObject1).getReturnType(), Void.TYPE))
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable(nBg, (Parcelable)paramString);
            AppMethodBeat.o(119364);
            return;
          }
          localObject1 = nBg;
          if (paramString != null) {
            break label248;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
          AppMethodBeat.o(119364);
          throw paramString;
        }
      }
      label248:
      paramBundle.putSerializable((String)localObject1, (Serializable)paramString);
      AppMethodBeat.o(119364);
      return;
      label265:
      if (localObject1 != null) {
        if (paramBoolean) {
          paramString = com.tencent.mm.remoteservice.e.class;
        } else {
          paramString = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void set(at.a parama, Object paramObject)
  {
    AppMethodBeat.i(119362);
    s.u(parama, "key");
    s.u(paramObject, "defva");
    Log.i(TAG, "get %s %s", new Object[] { parama, paramObject });
    at.a[] arrayOfa = (at.a[])at.a.class.getEnumConstants();
    if (arrayOfa == null) {}
    for (parama = null;; parama = arrayOfa[parama.ordinal()])
    {
      Log.i(TAG, "setConfigStorage, %s %s", new Object[] { parama, paramObject });
      h.baE().ban().set(parama, paramObject);
      AppMethodBeat.o(119362);
      return;
    }
  }
  
  public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super dlp, ah> paramr)
  {
    this.SpP = paramr;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static StoryCaptureProxy hxw()
    {
      AppMethodBeat.i(119354);
      StoryCaptureProxy localStoryCaptureProxy = StoryCaptureProxy.SpQ;
      if (localStoryCaptureProxy != null)
      {
        AppMethodBeat.o(119354);
        return localStoryCaptureProxy;
      }
      s.bIx("instance");
      AppMethodBeat.o(119354);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryCaptureProxy
 * JD-Core Version:    0.7.0.1
 */