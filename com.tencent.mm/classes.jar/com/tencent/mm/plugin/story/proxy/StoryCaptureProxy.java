package com.tencent.mm.plugin.story.proxy;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.f.g.c;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.chx;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import d.y;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "taskId", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy
  extends com.tencent.mm.remoteservice.a
  implements a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  public static StoryCaptureProxy ylL;
  public static final a ylM;
  private r<? super Integer, ? super Integer, ? super String, ? super bnx, y> ylK;
  
  static
  {
    AppMethodBeat.i(119365);
    ylM = new a((byte)0);
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
    k.h(paramd, "<set-?>");
    access$setInstance$cp(paramd);
    AppMethodBeat.o(119366);
  }
  
  public final int commitStory(String paramString1, String paramString2, chx paramchx, xu paramxu, cyl paramcyl, int paramInt, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119360);
    k.h(paramString1, "taskId");
    k.h(paramString2, "thumbPath");
    k.h(paramchx, "location");
    k.h(paramxu, "captureInfo");
    k.h(paramcyl, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    boj localboj = new boj();
    ad.d(TAG, "storyEditorData " + paramString1 + " isCaptureVideo:" + paramxu.gBl);
    localboj.DLK = paramxu.gBl;
    locald.jr(paramString1, paramString2);
    locald.a(paramcyl);
    locald.b(paramchx);
    locald.a(localboj);
    locald.Or(paramInt);
    locald.fU(paramList1);
    locald.fV(paramList2);
    locald.qI(paramxu.vgr);
    paramInt = locald.commit();
    paramString1 = j.yfh;
    j.b.dHj().checkPost();
    AppMethodBeat.o(119360);
    return paramInt;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, chx paramchx, boolean paramBoolean, cyl paramcyl, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(119359);
    k.h(paramString1, "videoPath");
    k.h(paramString2, "thumbPath");
    k.h(paramString3, "mediaDes");
    k.h(paramchx, "location");
    k.h(paramcyl, "editorInfo");
    k.h(paramList1, "groupList");
    k.h(paramList2, "blackList");
    String str = com.tencent.mm.d.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    boj localboj = new boj();
    ad.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localboj.DLK = paramBoolean;
    k.g(str, "md5");
    locald.aB(paramString1, paramString2, str);
    locald.a(paramcyl);
    locald.b(paramchx);
    locald.a(localboj);
    locald.Or(paramInt1);
    locald.fU(paramList1);
    locald.fV(paramList2);
    paramInt1 = locald.commit();
    paramString1 = j.yfh;
    j.b.dHj().checkPost();
    AppMethodBeat.o(119359);
    return paramInt1;
  }
  
  @f
  public final void commitStoryRemote(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(119361);
    k.h(paramString1, "videoPath");
    k.h(paramString2, "thumbPath");
    k.h(paramString3, "mediaDes");
    String str = com.tencent.mm.d.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.f.g.d locald = new com.tencent.mm.plugin.story.f.g.d();
    boj localboj = new boj();
    ad.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localboj.DLK = paramBoolean;
    k.g(str, "md5");
    locald.aB(paramString1, paramString2, str);
    locald.a(localboj);
    locald.commit();
    paramString1 = j.yfh;
    j.b.dHj().checkPost();
    AppMethodBeat.o(119361);
  }
  
  public final Object get(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(119363);
    k.h(parama, "key");
    k.h(paramObject, "defva");
    parama = ((ae.a[])ae.a.class.getEnumConstants())[parama.ordinal()];
    ad.i(TAG, "getConfigStorage, %s %s", new Object[] { parama, paramObject });
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    parama = locale.afk().get(parama, paramObject);
    k.g(parama, "MMKernel.storage().configStg.get(index, defva)");
    AppMethodBeat.o(119363);
    return parama;
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
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).getAccPath();
    k.g(localObject, "storage().accPath");
    AppMethodBeat.o(119356);
    return localObject;
  }
  
  public final r<Integer, Integer, String, bnx, y> getMusicCallback()
  {
    return this.ylK;
  }
  
  public final VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(119357);
    VideoTransPara localVideoTransPara = (VideoTransPara)REMOTE_CALL("getVideoParaRemote", new Object[0]);
    if (localVideoTransPara == null) {
      k.fvU();
    }
    AppMethodBeat.o(119357);
    return localVideoTransPara;
  }
  
  @f
  public final VideoTransPara getVideoParaRemote()
  {
    AppMethodBeat.i(119358);
    Object localObject = com.tencent.mm.modelcontrol.d.awT();
    k.g(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).awX();
    k.g(localObject, "para");
    AppMethodBeat.o(119358);
    return localObject;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(119364);
    k.h(paramString, "methodName");
    k.h(paramBundle, "data");
    ad.i(TAG, "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label261;
        }
        localObject1 = arrayOfMethod[i];
        k.g(localObject1, "mth");
        if (!n.I(((Method)localObject1).getName(), paramString, true)) {
          break label277;
        }
      }
      catch (Exception paramString)
      {
        ad.e(TAG, "exception:%s", new Object[] { bt.m((Throwable)paramString) });
        AppMethodBeat.o(119364);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = getArgs(paramBundle);
        paramString = ((Method)localObject1).invoke(this, Arrays.copyOf(paramString, paramString.length));
        if ((k.g(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable(RESULT_KEY, (Parcelable)paramString);
            AppMethodBeat.o(119364);
            return;
          }
          localObject1 = RESULT_KEY;
          if (paramString != null) {
            break label244;
          }
          paramString = new v("null cannot be cast to non-null type java.io.Serializable");
          AppMethodBeat.o(119364);
          throw paramString;
        }
      }
      label244:
      paramBundle.putSerializable((String)localObject1, (Serializable)paramString);
      AppMethodBeat.o(119364);
      return;
      label261:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          paramString = com.tencent.mm.remoteservice.e.class;
          continue;
          label277:
          i += 1;
        }
        else
        {
          paramString = f.class;
        }
      }
    }
  }
  
  public final void set(ae.a parama, Object paramObject)
  {
    AppMethodBeat.i(119362);
    k.h(parama, "key");
    k.h(paramObject, "defva");
    ad.i(TAG, "get %s %s", new Object[] { parama, paramObject });
    parama = ((ae.a[])ae.a.class.getEnumConstants())[parama.ordinal()];
    ad.i(TAG, "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
    k.g(locale, "MMKernel.storage()");
    locale.afk().set(parama, paramObject);
    AppMethodBeat.o(119362);
  }
  
  public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super bnx, y> paramr)
  {
    this.ylK = paramr;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
  public static final class a
  {
    public static StoryCaptureProxy dIJ()
    {
      AppMethodBeat.i(119354);
      StoryCaptureProxy localStoryCaptureProxy = StoryCaptureProxy.access$getInstance$cp();
      if (localStoryCaptureProxy == null) {
        k.aPZ("instance");
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