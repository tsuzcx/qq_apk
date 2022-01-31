package com.tencent.mm.plugin.story.proxy;

import a.f.a.r;
import a.l;
import a.l.m;
import a.v;
import a.y;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.story.model.g.c;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "musicCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "errType", "errCode", "", "errMsg", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "resp", "", "getMusicCallback", "()Lkotlin/jvm/functions/Function4;", "setMusicCallback", "(Lkotlin/jvm/functions/Function4;)V", "commitStory", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "isImageVideo", "scope", "favorite", "videoPath", "mediaDes", "commitStoryRemote", "get", "", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getAccPathRemote", "getRecommendMusic", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "getRecommendMusicCallback", "respBytes", "", "getRecommendMusicRemote", "imageDataBytes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "getVideoParaRemote", "onCallback", "methodName", "data", "Landroid/os/Bundle;", "clientCall", "set", "Companion", "plugin-story_release"})
public final class StoryCaptureProxy
  extends com.tencent.mm.remoteservice.a
  implements a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryCaptureProxy";
  public static StoryCaptureProxy sCR;
  public static final StoryCaptureProxy.a sCS;
  private r<? super Integer, ? super Integer, ? super String, ? super ape, y> sCQ;
  
  static
  {
    AppMethodBeat.i(109721);
    sCS = new StoryCaptureProxy.a((byte)0);
    TAG = "MicroMsg.StoryCaptureProxy";
    RESULT_KEY = "result_key";
    AppMethodBeat.o(109721);
  }
  
  public StoryCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
  }
  
  public static final void createInstance(com.tencent.mm.remoteservice.d paramd)
  {
    AppMethodBeat.i(109723);
    StoryCaptureProxy.a.createInstance(paramd);
    AppMethodBeat.o(109723);
  }
  
  public final int commitStory(com.tencent.mm.plugin.story.h.d paramd, String paramString, chj paramchj, boolean paramBoolean1, chk paramchk, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(155304);
    a.f.b.j.q(paramd, "storyEditorData");
    a.f.b.j.q(paramString, "thumbPath");
    a.f.b.j.q(paramchj, "location");
    a.f.b.j.q(paramchk, "editorInfo");
    com.tencent.mm.plugin.story.model.g.d locald = new com.tencent.mm.plugin.story.model.g.d();
    bby localbby = new bby();
    ab.d(TAG, "storyEditorData " + paramd.systemRowid + " isCaptureVideo:" + paramBoolean1);
    localbby.xra = paramBoolean1;
    locald.a(paramd, paramString);
    locald.a(paramchk);
    locald.a(paramchj);
    locald.a(localbby);
    locald.FJ(paramInt1);
    locald.FK(paramInt2);
    locald.lV(paramBoolean2);
    paramInt1 = locald.commit();
    paramd = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().checkPost();
    AppMethodBeat.o(155304);
    return paramInt1;
  }
  
  public final int commitStory(String paramString1, String paramString2, String paramString3, chj paramchj, boolean paramBoolean, chk paramchk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138830);
    a.f.b.j.q(paramString1, "videoPath");
    a.f.b.j.q(paramString2, "thumbPath");
    a.f.b.j.q(paramString3, "mediaDes");
    a.f.b.j.q(paramchj, "location");
    a.f.b.j.q(paramchk, "editorInfo");
    String str = com.tencent.mm.c.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.model.g.d locald = new com.tencent.mm.plugin.story.model.g.d();
    bby localbby = new bby();
    ab.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localbby.xra = paramBoolean;
    a.f.b.j.p(str, "md5");
    locald.aq(paramString1, paramString2, str);
    locald.a(paramchk);
    locald.a(paramchj);
    locald.a(localbby);
    locald.FJ(paramInt1);
    locald.FK(paramInt2);
    paramInt1 = locald.commit();
    paramString1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().checkPost();
    AppMethodBeat.o(138830);
    return paramInt1;
  }
  
  @com.tencent.mm.remoteservice.f
  public final void commitStoryRemote(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(109717);
    a.f.b.j.q(paramString1, "videoPath");
    a.f.b.j.q(paramString2, "thumbPath");
    a.f.b.j.q(paramString3, "mediaDes");
    String str = com.tencent.mm.c.g.getMD5(paramString1);
    com.tencent.mm.plugin.story.model.g.d locald = new com.tencent.mm.plugin.story.model.g.d();
    bby localbby = new bby();
    ab.d(TAG, "videoPath:" + paramString1 + " thumbPath:" + paramString2 + " mediaDes:" + paramString3 + " videoMd5:" + str + " isCaptureVideo:" + paramBoolean);
    localbby.xra = paramBoolean;
    a.f.b.j.p(str, "md5");
    locald.aq(paramString1, paramString2, str);
    locald.a(localbby);
    locald.commit();
    paramString1 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAI().checkPost();
    AppMethodBeat.o(109717);
  }
  
  public final Object get(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(109719);
    a.f.b.j.q(parama, "key");
    a.f.b.j.q(paramObject, "defva");
    parama = ((ac.a[])ac.a.class.getEnumConstants())[parama.ordinal()];
    ab.i(TAG, "getConfigStorage, %s %s", new Object[] { parama, paramObject });
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(locale, "MMKernel.storage()");
    parama = locale.Ru().get(parama, paramObject);
    a.f.b.j.p(parama, "MMKernel.storage().configStg.get(index, defva)");
    AppMethodBeat.o(109719);
    return parama;
  }
  
  public final String getAccPath()
  {
    AppMethodBeat.i(109708);
    String str = REMOTE_CALL("getAccPathRemote", new Object[0]).toString();
    AppMethodBeat.o(109708);
    return str;
  }
  
  @com.tencent.mm.remoteservice.f
  public final String getAccPathRemote()
  {
    AppMethodBeat.i(109709);
    Object localObject = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(localObject, "storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).getAccPath();
    a.f.b.j.p(localObject, "storage().accPath");
    AppMethodBeat.o(109709);
    return localObject;
  }
  
  public final r<Integer, Integer, String, ape, y> getMusicCallback()
  {
    return this.sCQ;
  }
  
  public final void getRecommendMusic(LinkedList<b> paramLinkedList, float paramFloat1, float paramFloat2, long paramLong, r<? super Integer, ? super Integer, ? super String, ? super ape, y> paramr)
  {
    AppMethodBeat.i(109712);
    a.f.b.j.q(paramLinkedList, "imageData");
    ab.i(TAG, "LogStory: getRecommendMusic");
    this.sCQ = paramr;
    paramr = new ArrayList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext()) {
      paramr.add(((b)paramLinkedList.next()).getBytes());
    }
    REMOTE_CALL("getRecommendMusicRemote", new Object[] { paramr, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Long.valueOf(paramLong) });
    AppMethodBeat.o(109712);
  }
  
  @com.tencent.mm.remoteservice.e
  public final void getRecommendMusicCallback(int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(109713);
    a.f.b.j.q(paramArrayOfByte, "respBytes");
    ab.i(TAG, "LogStory: getRecommendMusicCallback");
    ape localape = new ape();
    localape.parseFrom(paramArrayOfByte);
    paramArrayOfByte = this.sCQ;
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, localape);
      AppMethodBeat.o(109713);
      return;
    }
    AppMethodBeat.o(109713);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void getRecommendMusicRemote(ArrayList<byte[]> paramArrayList, float paramFloat1, float paramFloat2, long paramLong)
  {
    AppMethodBeat.i(109714);
    a.f.b.j.q(paramArrayList, "imageDataBytes");
    ab.i(TAG, "LogStory: getRecommendMusicRemote");
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add(new b((byte[])paramArrayList.next()));
    }
    new com.tencent.mm.plugin.story.model.audio.e(localLinkedList, paramFloat1, paramFloat2, paramLong, 0L, 0, 0, 112).adl().j((com.tencent.mm.vending.c.a)new StoryCaptureProxy.b(this));
    AppMethodBeat.o(109714);
  }
  
  public final VideoTransPara getVideoPara()
  {
    AppMethodBeat.i(109710);
    VideoTransPara localVideoTransPara = (VideoTransPara)REMOTE_CALL("getVideoParaRemote", new Object[0]);
    if (localVideoTransPara == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109710);
    return localVideoTransPara;
  }
  
  @com.tencent.mm.remoteservice.f
  public final VideoTransPara getVideoParaRemote()
  {
    AppMethodBeat.i(109711);
    Object localObject = com.tencent.mm.modelcontrol.d.afW();
    a.f.b.j.p(localObject, "SubCoreVideoControl.getCore()");
    localObject = ((com.tencent.mm.modelcontrol.d)localObject).aga();
    a.f.b.j.p(localObject, "para");
    AppMethodBeat.o(109711);
    return localObject;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(109720);
    a.f.b.j.q(paramString, "methodName");
    a.f.b.j.q(paramBundle, "data");
    ab.i(TAG, "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        a.f.b.j.p(localObject1, "mth");
        if (!m.I(((Method)localObject1).getName(), paramString, true)) {
          break label277;
        }
      }
      catch (Exception paramString)
      {
        ab.e(TAG, "exception:%s", new Object[] { bo.l((Throwable)paramString) });
        AppMethodBeat.o(109720);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramString = getArgs(paramBundle);
        paramString = ((Method)localObject1).invoke(this, Arrays.copyOf(paramString, paramString.length));
        if ((a.f.b.j.e(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable(RESULT_KEY, (Parcelable)paramString);
            AppMethodBeat.o(109720);
            return;
          }
          localObject1 = RESULT_KEY;
          if (paramString != null) {
            break label244;
          }
          paramString = new v("null cannot be cast to non-null type java.io.Serializable");
          AppMethodBeat.o(109720);
          throw paramString;
        }
      }
      label244:
      paramBundle.putSerializable((String)localObject1, (Serializable)paramString);
      AppMethodBeat.o(109720);
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
          paramString = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void set(ac.a parama, Object paramObject)
  {
    AppMethodBeat.i(109718);
    a.f.b.j.q(parama, "key");
    a.f.b.j.q(paramObject, "defva");
    ab.i(TAG, "get %s %s", new Object[] { parama, paramObject });
    parama = ((ac.a[])ac.a.class.getEnumConstants())[parama.ordinal()];
    ab.i(TAG, "setConfigStorage, %s %s", new Object[] { parama, paramObject });
    com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(locale, "MMKernel.storage()");
    locale.Ru().set(parama, paramObject);
    AppMethodBeat.o(109718);
  }
  
  public final void setMusicCallback(r<? super Integer, ? super Integer, ? super String, ? super ape, y> paramr)
  {
    this.sCQ = paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryCaptureProxy
 * JD-Core Version:    0.7.0.1
 */