package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.story.d.a.e;
import com.tencent.mm.plugin.story.d.a.f;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.e;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.mm.plugin.story.h.h;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/AlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;)V", "localCachedMinId", "", "localMinId", "mIsAll", "", "mMap", "Ljava/util/LinkedHashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/collections/ArrayList;", "mNpLoopCount", "", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IView;", "assembleRealData", "", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "infos", "checkStoryPost", "", "isAll", "errCode", "loadDBData", "loadFpData", "loadNpData", "needLoopFetch", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errType", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h, a.e
{
  public static final a.a Soj;
  private static final String TAG;
  final a.f Sok;
  private final LinkedHashMap<String, ArrayList<com.tencent.mm.plugin.story.h.h>> Sol;
  private long Som;
  private long Son;
  private long Soo;
  private int Sop;
  private String sWX;
  private boolean wHe;
  
  static
  {
    AppMethodBeat.i(119154);
    Soj = new a.a((byte)0);
    TAG = "MicroMsg.AlbumPresenter";
    AppMethodBeat.o(119154);
  }
  
  public a(a.f paramf)
  {
    AppMethodBeat.i(119153);
    this.Sok = paramf;
    this.sWX = "";
    this.Sol = new LinkedHashMap();
    AppMethodBeat.o(119153);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(367039);
    kotlin.g.b.s.u(parama, "this$0");
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = StoryCore.SjP;
    localObject1 = k.a(StoryCore.b.hvR(), parama.sWX, parama.Soo);
    if (!((List)localObject1).isEmpty()) {
      parama.Son = ((j)kotlin.a.p.oM((List)localObject1)).field_storyID;
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      localObject1 = StoryCore.SjP;
      localObject1 = StoryCore.b.hvW();
      Object localObject2 = com.tencent.mm.plugin.story.e.a.Sjk;
      localObject2 = ((i)localObject1).bco(com.tencent.mm.plugin.story.e.a.a.C(Integer.valueOf(localj.field_createTime)));
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder("loadDBData rawLocalId=").append((int)localj.systemRowid).append(" rawStoryId=").append(localj.field_storyID).append(" date=");
      if (localObject2 == null)
      {
        localObject1 = null;
        label181:
        localStringBuilder = localStringBuilder.append(localObject1).append(" count=");
        if (localObject2 != null) {
          break label307;
        }
      }
      label307:
      for (localObject1 = null;; localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.h.h)localObject2).field_count))
      {
        Log.d(str, localObject1);
        if (localObject2 == null) {
          break;
        }
        localObject1 = StoryCore.SjP;
        localj = StoryCore.b.hvR().anv((int)localj.systemRowid);
        localObject1 = localj;
        if (localj == null) {
          localObject1 = new j();
        }
        kotlin.g.b.s.u(localObject1, "<set-?>");
        ((com.tencent.mm.plugin.story.h.h)localObject2).SnL = ((j)localObject1);
        if (localArrayList2.contains(((com.tencent.mm.plugin.story.h.h)localObject2).hzq())) {
          break;
        }
        localArrayList1.add(localObject2);
        localArrayList2.add(((com.tencent.mm.plugin.story.h.h)localObject2).hzq());
        break;
        localObject1 = ((com.tencent.mm.plugin.story.h.h)localObject2).hzq();
        break label181;
      }
    }
    Log.d(TAG, "localCachedMinId=" + parama.Son + " infos.size=" + localArrayList1.size() + " localMinId=" + parama.Soo);
    d.uiThread((kotlin.g.a.a)new b(parama, parama.lj((List)localArrayList1)));
    AppMethodBeat.o(367039);
  }
  
  private static final void b(a parama)
  {
    AppMethodBeat.i(367044);
    kotlin.g.b.s.u(parama, "this$0");
    Log.i(TAG, "loadFpData username=" + parama.sWX + " maxId=" + parama.Som);
    com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
    String str = parama.sWX;
    long l = parama.Som;
    parama = parama.sWX;
    StoryCore.b localb = StoryCore.SjP;
    locals.a((com.tencent.mm.am.p)new e(str, l, Util.isEqual(parama, StoryCore.b.hgg())), 0);
    AppMethodBeat.o(367044);
  }
  
  private static final void c(a parama)
  {
    AppMethodBeat.i(367047);
    kotlin.g.b.s.u(parama, "this$0");
    Log.i(TAG, "loadNpData username=" + parama.sWX + " maxId=" + parama.Som);
    if ((parama.Sop == 0) && (!parama.wHe))
    {
      parama.Sop += 1;
      com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
      String str = parama.sWX;
      long l = parama.Som;
      parama = parama.sWX;
      StoryCore.b localb = StoryCore.SjP;
      locals.a((com.tencent.mm.am.p)new e(str, l, Util.isEqual(parama, StoryCore.b.hgg())), 0);
    }
    AppMethodBeat.o(367047);
  }
  
  private static final void d(a parama)
  {
    AppMethodBeat.i(367050);
    kotlin.g.b.s.u(parama, "this$0");
    parama.vP(parama.Son);
    parama.hvk();
    AppMethodBeat.o(367050);
  }
  
  private static final void e(a parama)
  {
    AppMethodBeat.i(367055);
    kotlin.g.b.s.u(parama, "this$0");
    parama.vP(parama.Son);
    parama.hvk();
    AppMethodBeat.o(367055);
  }
  
  private final List<com.tencent.mm.plugin.story.ui.album.c> lj(List<com.tencent.mm.plugin.story.h.h> paramList)
  {
    AppMethodBeat.i(367031);
    ArrayList localArrayList = new ArrayList();
    this.Sol.clear();
    Iterator localIterator = ((Iterable)paramList).iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.story.h.h localh = (com.tencent.mm.plugin.story.h.h)localIterator.next();
      paramList = com.tencent.mm.plugin.story.e.a.Sjk;
      CharSequence localCharSequence = com.tencent.mm.plugin.story.e.a.a.bbD(localh.hzq());
      Log.d(TAG, "key=" + localCharSequence + " info.date=" + localh.hzq() + " info.count=" + localh.field_count);
      localObject = (ArrayList)this.Sol.get(localCharSequence.toString());
      paramList = (List<com.tencent.mm.plugin.story.h.h>)localObject;
      if (localObject == null)
      {
        paramList = new ArrayList();
        ((Map)this.Sol).put(localCharSequence.toString(), paramList);
      }
      paramList.add(localh);
    }
    paramList = ((Map)this.Sol).entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject = (Map.Entry)paramList.next();
      localObject = new com.tencent.mm.plugin.story.ui.album.c((String)((Map.Entry)localObject).getKey(), (List)((Map.Entry)localObject).getValue());
      Log.i(TAG, String.valueOf(localObject));
      localArrayList.add(localObject);
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(367031);
    return paramList;
  }
  
  private void vP(long paramLong)
  {
    AppMethodBeat.i(119146);
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvR();
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.hwa();
    this.Soo = ((k)localObject).aC(paramLong, n.a.bbR(this.sWX));
    if (this.Som != 0L) {
      if (this.Soo >= this.Som) {
        break label116;
      }
    }
    label116:
    for (paramLong = this.Soo;; paramLong = this.Som)
    {
      this.Soo = paramLong;
      Log.d(TAG, "localMinId=" + this.Soo + ", respMaxId=" + this.Som);
      AppMethodBeat.o(119146);
      return;
    }
  }
  
  public final void hoB()
  {
    AppMethodBeat.i(119148);
    com.tencent.mm.kernel.h.baD().mCm.b(191, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3926, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119148);
  }
  
  public final void hvh()
  {
    AppMethodBeat.i(119151);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new a..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(119151);
  }
  
  public final void hvi()
  {
    AppMethodBeat.i(119150);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new a..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(119150);
  }
  
  public final void hvk()
  {
    AppMethodBeat.i(119149);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new a..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(119149);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119147);
    kotlin.g.b.s.u(paramString, "userName");
    this.sWX = paramString;
    vP(this.Son);
    com.tencent.mm.kernel.h.baD().mCm.a(191, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(3926, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119147);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(119152);
    boolean bool;
    if (((paramp instanceof e)) && (Util.isEqual(((e)paramp).userName, this.sWX)))
    {
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      if (paramInt2 != com.tencent.mm.plugin.story.h.a.hyD())
      {
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt2 != com.tencent.mm.plugin.story.h.a.hyE()) {
          break label185;
        }
      }
      bool = true;
      this.wHe = bool;
      if (this.wHe) {
        this.Sok.hvl();
      }
      if (!((e)paramp).Qsg) {
        break label191;
      }
      paramString = StoryCore.SjP;
      StoryCore.b.gHI().post(new a..ExternalSyntheticLambda2(this));
    }
    for (;;)
    {
      this.Som = ((e)paramp).QtH;
      Log.d(TAG, "onSceneEnd username=" + this.sWX + " respMaxId=" + this.Som + ' ' + paramInt1 + ' ' + paramInt2);
      AppMethodBeat.o(119152);
      return;
      label185:
      bool = false;
      break;
      label191:
      this.Sop = 0;
      paramString = StoryCore.SjP;
      StoryCore.b.gHI().post(new a..ExternalSyntheticLambda1(this));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama, List<com.tencent.mm.plugin.story.ui.album.c> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a
 * JD-Core Version:    0.7.0.1
 */