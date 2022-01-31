package com.tencent.mm.plugin.story.proxy;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.i;
import com.tencent.mm.plugin.story.model.audio.i.a;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "audioTaskMap", "Landroid/util/SparseArray;", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "cacheAudio", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "callback", "cacheAudioCallback", "musicId", "", "cacheAudioRemote", "cancelAll", "cancelAllRemote", "cancelCache", "cancelCacheRemote", "onCallback", "methodName", "", "data", "Landroid/os/Bundle;", "clientCall", "Companion", "plugin-story_release"})
public final class StoryAudioManagerProxy
  extends a
{
  private static final String RESULT_KEY = "result_key";
  private static final String TAG = "MicroMsg.StoryAudioManagerProxy";
  public static StoryAudioManagerProxy sCN;
  public static final StoryAudioManagerProxy.a sCO;
  private final SparseArray<LinkedList<b<Boolean, y>>> sCM;
  
  static
  {
    AppMethodBeat.i(109702);
    sCO = new StoryAudioManagerProxy.a((byte)0);
    TAG = "MicroMsg.StoryAudioManagerProxy";
    RESULT_KEY = "result_key";
    AppMethodBeat.o(109702);
  }
  
  public StoryAudioManagerProxy(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(109701);
    this.sCM = new SparseArray();
    AppMethodBeat.o(109701);
  }
  
  public static final void createInstance(d paramd)
  {
    AppMethodBeat.i(109704);
    StoryAudioManagerProxy.a.createInstance(paramd);
    AppMethodBeat.o(109704);
  }
  
  public final void cacheAudio(AudioCacheInfo paramAudioCacheInfo, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(109692);
    j.q(paramAudioCacheInfo, "info");
    LinkedList localLinkedList2 = (LinkedList)this.sCM.get(paramAudioCacheInfo.swp);
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.sCM.put(paramAudioCacheInfo.swp, localLinkedList1);
    }
    if (paramb != null) {
      localLinkedList1.add(paramb);
    }
    paramb = i.swW;
    i.cBF().a(paramAudioCacheInfo, (a.f.a.m)new StoryAudioManagerProxy.b(this, paramAudioCacheInfo));
    AppMethodBeat.o(109692);
  }
  
  @e
  public final void cacheAudioCallback(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109694);
    Object localObject = (LinkedList)this.sCM.get(paramInt);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).S(Boolean.valueOf(paramBoolean));
      }
      AppMethodBeat.o(109694);
      return;
    }
    AppMethodBeat.o(109694);
  }
  
  @f
  public final void cacheAudioRemote(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109695);
    j.q(paramAudioCacheInfo, "info");
    i.a locala = i.swW;
    i.cBF().a(paramAudioCacheInfo, (a.f.a.m)new StoryAudioManagerProxy.c(this, paramAudioCacheInfo));
    AppMethodBeat.o(109695);
  }
  
  public final void cancelAll()
  {
    AppMethodBeat.i(109698);
    this.sCM.clear();
    REMOTE_CALL("cancelAllRemote", new Object[0]);
    AppMethodBeat.o(109698);
  }
  
  @f
  public final void cancelAllRemote()
  {
    AppMethodBeat.i(109699);
    i.a locala = i.swW;
    i.cBF().cancelAll();
    AppMethodBeat.o(109699);
  }
  
  public final void cancelCache(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109696);
    if (paramAudioCacheInfo != null)
    {
      this.sCM.removeAt(paramAudioCacheInfo.swp);
      REMOTE_CALL("cancelCacheRemote", new Object[] { paramAudioCacheInfo });
    }
    AppMethodBeat.o(109696);
  }
  
  @f
  public final void cancelCacheRemote(AudioCacheInfo paramAudioCacheInfo)
  {
    AppMethodBeat.i(109697);
    i.a locala = i.swW;
    i.cBF().cancelCache(paramAudioCacheInfo);
    AppMethodBeat.o(109697);
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(109700);
    j.q(paramString, "methodName");
    j.q(paramBundle, "data");
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
        j.p(localObject1, "mth");
        if (!a.l.m.I(((Method)localObject1).getName(), paramString, true)) {
          break label277;
        }
      }
      catch (Exception paramString)
      {
        ab.e(TAG, "exception:%s", new Object[] { bo.l((Throwable)paramString) });
        AppMethodBeat.o(109700);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent(paramString))
      {
        paramBundle.setClassLoader(AudioCacheInfo.class.getClassLoader());
        paramString = getArgs(paramBundle);
        paramString = ((Method)localObject1).invoke(this, Arrays.copyOf(paramString, paramString.length));
        if ((j.e(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((paramString instanceof Parcelable))
          {
            paramBundle.putParcelable(RESULT_KEY, (Parcelable)paramString);
            AppMethodBeat.o(109700);
            return;
          }
          localObject1 = RESULT_KEY;
          if (paramString != null) {
            break label245;
          }
          paramString = new v("null cannot be cast to non-null type java.io.Serializable");
          AppMethodBeat.o(109700);
          throw paramString;
        }
      }
      label245:
      paramBundle.putSerializable((String)localObject1, (Serializable)paramString);
      AppMethodBeat.o(109700);
      return;
      label261:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          paramString = e.class;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy
 * JD-Core Version:    0.7.0.1
 */