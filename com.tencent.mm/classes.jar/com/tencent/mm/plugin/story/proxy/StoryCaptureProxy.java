package com.tencent.mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy
  extends com.tencent.mm.remoteservice.a
  implements a
{
  public static StoryCaptureProxy LNa;
  public static final a LNb;
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  private r<? super Integer, ? super Integer, ? super String, ? super cuj, x> LMZ;
  
  static
  {
    AppMethodBeat.i(119365);
    LNb = new a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    RESULT_KEY = "result_key";
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
    p.k(paramd, "<set-?>");
    access$setInstance$cp(paramd);
    AppMethodBeat.o(119366);
  }
  
  public final int commitStory(String paramString1, String paramString2, duy paramduy, acn paramacn, ent parament, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222599);
    p.k(paramString1, "taskId");
    p.k(paramString2, "thumbPath");
    p.k(paramduy, "location");
    p.k(paramacn, "captureInfo");
    p.k(parament, "editorInfo");
    p.k(paramList1, "groupList");
    p.k(paramList2, "blackList");
    p.k(paramList3, "srcMd5List");
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cuv localcuv = new cuv();
    Log.d(TAG, "storyEditorData " + paramString1 + " isCaptureVideo:" + paramacn.lfl);
    localcuv.TCA = paramacn.lfl;
    locald.lw(paramString1, paramString2);
    locald.a(parament);
    locald.b(paramduy);
    locald.a(localcuv);
    locald.aie(paramInt);
    locald.ib(paramList1);
    locald.ic(paramList2);
    locald.ic(paramList2);
    locald.zs(paramacn.HJC);
    locald.id(paramList3);
    paramInt = locald.in();
    paramString1 = j.LGA;
    j.b.gcC().checkPost();
    AppMethodBeat.o(222599);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, duy paramduy, boolean paramBoolean, ent parament, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222583);
    p.k(paramString1, "videoPath");
    p.k(paramString2, "thumbPath");
    p.k(paramString3, "mediaDes");
    p.k(paramduy, "location");
    p.k(parament, "editorInfo");
    p.k(paramList1, "groupList");
    p.k(paramList2, "blackList");
    p.k(paramList3, "srcMd5List");
    String str = g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cuv localcuv = new cuv();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localcuv.TCA = paramBoolean;
    p.j(str, "md5");
    locald.aP(paramString1, paramString2, str);
    locald.a(parament);
    locald.b(paramduy);
    locald.a(localcuv);
    locald.aie(paramInt1);
    locald.ib(paramList1);
    locald.ic(paramList2);
    locald.id(paramList3);
    paramInt1 = locald.in();
    paramString1 = j.LGA;
    j.b.gcC().checkPost();
    AppMethodBeat.o(222583);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public final void commitStoryRemote(String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(222603);
    p.k(paramString1, "videoPath");
    p.k(paramString2, "thumbPath");
    p.k(paramString3, "mediaDes");
    p.k(paramList, "srcMd5List");
    String str = g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cuv localcuv = new cuv();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localcuv.TCA = paramBoolean;
    p.j(str, "md5");
    locald.aP(paramString1, paramString2, str);
    locald.a(localcuv);
    locald.id(paramList);
    locald.in();
    paramString1 = j.LGA;
    j.b.gcC().checkPost();
    AppMethodBeat.o(222603);
  }
  
  public final Object get(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(119363);
    p.k(parama, "key");
    p.k(paramObject, "defva");
    Object localObject = (ar.a[])ar.a.class.getEnumConstants();
    if (localObject != null) {}
    for (parama = localObject[parama.ordinal()];; parama = null)
    {
      Log.i(TAG, "getConfigStorage, %s %s", new Object[] { parama, paramObject });
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      parama = ((com.tencent.mm.kernel.f)localObject).aHp().get(parama, paramObject);
      p.j(parama, "MMKernel.storage().configStg.get(index, defva)");
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
    Object localObject = h.aHG();
    p.j(localObject, "storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).getAccPath();
    p.j(localObject, "storage().accPath");
    AppMethodBeat.o(119356);
    return localObject;
  }
  
  public final r<Integer, Integer, String, cuj, x> getMusicCallback()
  {
    return this.LMZ;
  }
  
  public final VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119357);
    VideoTransPara localVideoTransPara = (VideoTransPara)REMOTE_CALL("getVideoParaRemote", new Object[0]);
    if (localVideoTransPara == null) {
      p.iCn();
    }
    AppMethodBeat.o(119357);
    return localVideoTransPara;
  }
  
  @com.tencent.mm.remoteservice.f
  public final VideoTransPara getVideoParaRemote()
  {
    AppMethodBeat.i(119358);
    Object localObject = com.tencent.mm.modelcontrol.e.bkp();
    p.j(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bkt();
    p.j(localObject, "para");
    AppMethodBeat.o(119358);
    return localObject;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(119364);
    p.k(paramString, "methodName");
    p.k(paramBundle, "data");
    Log.i(TAG, "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        p.j(arrayOfMethod, "this.javaClass.methods");
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label269;
        }
        localObject1 = arrayOfMethod[i];
        p.j(localObject1, "mth");
        if (!n.L(((Method)localObject1).getName(), paramString, true)) {
          break label285;
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
        if ((p.h(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable(RESULT_KEY, (Parcelable)paramString);
            AppMethodBeat.o(119364);
            return;
          }
          localObject1 = RESULT_KEY;
          if (paramString != null) {
            break label252;
          }
          paramString = new t("null cannot be cast to non-null type java.io.Serializable");
          AppMethodBeat.o(119364);
          throw paramString;
        }
      }
      label252:
      paramBundle.putSerializable((String)localObject1, (Serializable)paramString);
      AppMethodBeat.o(119364);
      return;
      label269:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          paramString = com.tencent.mm.remoteservice.e.class;
          continue;
          label285:
          i += 1;
        }
        else
        {
          paramString = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void set(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(119362);
    p.k(parama, "key");
    p.k(paramObject, "defva");
    Log.i(TAG, "get %s %s", new Object[] { parama, paramObject });
    Object localObject = (ar.a[])ar.a.class.getEnumConstants();
    if (localObject != null) {}
    for (parama = localObject[parama.ordinal()];; parama = null)
    {
      Log.i(TAG, "setConfigStorage, %s %s", new Object[] { parama, paramObject });
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(parama, paramObject);
      AppMethodBeat.o(119362);
      return;
    }
  }
  
  public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super cuj, x> paramr)
  {
    this.LMZ = paramr;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
  public static final class a
  {
    public static StoryCaptureProxy gec()
    {
      AppMethodBeat.i(119354);
      StoryCaptureProxy localStoryCaptureProxy = StoryCaptureProxy.access$getInstance$cp();
      if (localStoryCaptureProxy == null) {
        p.bGy("instance");
      }
      AppMethodBeat.o(119354);
      return localStoryCaptureProxy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryCaptureProxy
 * JD-Core Version:    0.7.0.1
 */