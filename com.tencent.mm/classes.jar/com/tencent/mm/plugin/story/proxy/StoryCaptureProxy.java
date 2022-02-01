package com.tencent.mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.remoteservice.f;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy
  extends com.tencent.mm.remoteservice.a
  implements a
{
  public static StoryCaptureProxy FsX;
  public static final a FsY;
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  private r<? super Integer, ? super Integer, ? super String, ? super clm, x> FsW;
  
  static
  {
    AppMethodBeat.i(119365);
    FsY = new a((byte)0);
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
    p.h(paramd, "<set-?>");
    access$setInstance$cp(paramd);
    AppMethodBeat.o(119366);
  }
  
  public final int commitStory(String paramString1, String paramString2, dlg paramdlg, acg paramacg, eds parameds, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222915);
    p.h(paramString1, "taskId");
    p.h(paramString2, "thumbPath");
    p.h(paramdlg, "location");
    p.h(paramacg, "captureInfo");
    p.h(parameds, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    p.h(paramList3, "srcMd5List");
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cly localcly = new cly();
    Log.d(TAG, "storyEditorData " + paramString1 + " isCaptureVideo:" + paramacg.iqf);
    localcly.Mrn = paramacg.iqf;
    locald.kZ(paramString1, paramString2);
    locald.a(parameds);
    locald.b(paramdlg);
    locald.a(localcly);
    locald.aaJ(paramInt);
    locald.hs(paramList1);
    locald.ht(paramList2);
    locald.ht(paramList2);
    locald.vO(paramacg.BMX);
    locald.hu(paramList3);
    paramInt = locald.commit();
    paramString1 = j.Fmy;
    j.b.foi().checkPost();
    AppMethodBeat.o(222915);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, dlg paramdlg, boolean paramBoolean, eds parameds, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
    AppMethodBeat.i(222914);
    p.h(paramString1, "videoPath");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "mediaDes");
    p.h(paramdlg, "location");
    p.h(parameds, "editorInfo");
    p.h(paramList1, "groupList");
    p.h(paramList2, "blackList");
    p.h(paramList3, "srcMd5List");
    String str = com.tencent.mm.d.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cly localcly = new cly();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localcly.Mrn = paramBoolean;
    p.g(str, "md5");
    locald.aV(paramString1, paramString2, str);
    locald.a(parameds);
    locald.b(paramdlg);
    locald.a(localcly);
    locald.aaJ(paramInt1);
    locald.hs(paramList1);
    locald.ht(paramList2);
    locald.hu(paramList3);
    paramInt1 = locald.commit();
    paramString1 = j.Fmy;
    j.b.foi().checkPost();
    AppMethodBeat.o(222914);
    return paramInt1;
  }
  
  @f
  public final void commitStoryRemote(String paramString1, String paramString2, String paramString3, boolean paramBoolean, List<String> paramList)
  {
    AppMethodBeat.i(222916);
    p.h(paramString1, "videoPath");
    p.h(paramString2, "thumbPath");
    p.h(paramString3, "mediaDes");
    p.h(paramList, "srcMd5List");
    String str = com.tencent.mm.d.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    cly localcly = new cly();
    Log.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localcly.Mrn = paramBoolean;
    p.g(str, "md5");
    locald.aV(paramString1, paramString2, str);
    locald.a(localcly);
    locald.hu(paramList);
    locald.commit();
    paramString1 = j.Fmy;
    j.b.foi().checkPost();
    AppMethodBeat.o(222916);
  }
  
  public final Object get(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(119363);
    p.h(parama, "key");
    p.h(paramObject, "defva");
    Object localObject = (ar.a[])ar.a.class.getEnumConstants();
    if (localObject != null) {}
    for (parama = localObject[parama.ordinal()];; parama = null)
    {
      Log.i(TAG, "getConfigStorage, %s %s", new Object[] { parama, paramObject });
      localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      parama = ((com.tencent.mm.kernel.e)localObject).azQ().get(parama, paramObject);
      p.g(parama, "MMKernel.storage().configStg.get(index, defva)");
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
  
  @f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(119356);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).getAccPath();
    p.g(localObject, "storage().accPath");
    AppMethodBeat.o(119356);
    return localObject;
  }
  
  public final r<Integer, Integer, String, clm, x> getMusicCallback()
  {
    return this.FsW;
  }
  
  public final VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119357);
    VideoTransPara localVideoTransPara = (VideoTransPara)REMOTE_CALL("getVideoParaRemote", new Object[0]);
    if (localVideoTransPara == null) {
      p.hyc();
    }
    AppMethodBeat.o(119357);
    return localVideoTransPara;
  }
  
  @f
  public final VideoTransPara getVideoParaRemote()
  {
    AppMethodBeat.i(119358);
    Object localObject = com.tencent.mm.modelcontrol.e.baZ();
    p.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.e)localObject).bbd();
    p.g(localObject, "para");
    AppMethodBeat.o(119358);
    return localObject;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(119364);
    p.h(paramString, "methodName");
    p.h(paramBundle, "data");
    Log.i(TAG, "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        p.g(arrayOfMethod, "this.javaClass.methods");
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label269;
        }
        localObject1 = arrayOfMethod[i];
        p.g(localObject1, "mth");
        if (!n.I(((Method)localObject1).getName(), paramString, true)) {
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
        if ((p.j(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
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
          paramString = f.class;
        }
      }
    }
  }
  
  public final void set(ar.a parama, Object paramObject)
  {
    AppMethodBeat.i(119362);
    p.h(parama, "key");
    p.h(paramObject, "defva");
    Log.i(TAG, "get %s %s", new Object[] { parama, paramObject });
    Object localObject = (ar.a[])ar.a.class.getEnumConstants();
    if (localObject != null) {}
    for (parama = localObject[parama.ordinal()];; parama = null)
    {
      Log.i(TAG, "setConfigStorage, %s %s", new Object[] { parama, paramObject });
      localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).azQ().set(parama, paramObject);
      AppMethodBeat.o(119362);
      return;
    }
  }
  
  public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super clm, x> paramr)
  {
    this.FsW = paramr;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
  public static final class a
  {
    public static StoryCaptureProxy fpI()
    {
      AppMethodBeat.i(119354);
      StoryCaptureProxy localStoryCaptureProxy = StoryCaptureProxy.access$getInstance$cp();
      if (localStoryCaptureProxy == null) {
        p.btv("instance");
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