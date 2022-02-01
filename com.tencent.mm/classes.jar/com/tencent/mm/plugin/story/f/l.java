package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.story.d.a.c;
import com.tencent.mm.plugin.story.d.a.d;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.i;
import com.tencent.mm.plugin.story.model.m;
import com.tencent.mm.plugin.story.model.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/StoryFavSelectPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;)V", "MAX_COUNT", "", "TAG", "", "isRunning", "", "loadNpCount", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavSelectView;", "isAll", "errType", "errCode", "limitId", "loadDBData", "", "first", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setFavorite", "storyList", "", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "updateLocalMinId", "lastId", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h, a.c
{
  private final int MAX_COUNT;
  private long Som;
  private long Son;
  private long Soo;
  private int SpG;
  final a.d SpJ;
  private final String TAG;
  private boolean Uz;
  private String sWX;
  private boolean wHe;
  
  public l(a.d paramd)
  {
    AppMethodBeat.i(119352);
    this.SpJ = paramd;
    this.TAG = "MicroMsg.StoryFavSelectPresenter";
    this.sWX = "";
    this.MAX_COUNT = 20;
    AppMethodBeat.o(119352);
  }
  
  private static final void a(l paraml)
  {
    AppMethodBeat.i(367024);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml.vP(paraml.Son);
    paraml.EG(false);
    if (paraml.SpG > 0) {
      paraml.hvh();
    }
    AppMethodBeat.o(367024);
  }
  
  private static final void a(l paraml, List paramList)
  {
    AppMethodBeat.i(367033);
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramList, "$storyList");
    Object localObject1 = StoryCore.SjP;
    Object localObject3 = StoryCore.b.hvR().ds(paraml.sWX, true);
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject4 = ((Iterable)paramList).iterator();
    Object localObject5;
    label121:
    int i;
    label155:
    label179:
    label184:
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (j)((Iterator)localObject4).next();
      Object localObject6 = (Iterable)localObject3;
      if ((!(localObject6 instanceof Collection)) || (!((Collection)localObject6).isEmpty()))
      {
        localObject6 = ((Iterable)localObject6).iterator();
        if (((Iterator)localObject6).hasNext()) {
          if (((j)((Iterator)localObject6).next()).field_storyID == ((j)localObject5).field_storyID)
          {
            i = 1;
            if (i == 0) {
              break label179;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label184;
        }
        ((ArrayList)localObject2).add(localObject5);
        break;
        i = 0;
        break label155;
        break label121;
      }
    }
    localObject3 = ((Iterable)localObject3).iterator();
    label256:
    label290:
    label313:
    label318:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (j)((Iterator)localObject3).next();
      localObject5 = (Iterable)paramList;
      if ((!(localObject5 instanceof Collection)) || (!((Collection)localObject5).isEmpty()))
      {
        localObject5 = ((Iterable)localObject5).iterator();
        if (((Iterator)localObject5).hasNext()) {
          if (((j)((Iterator)localObject5).next()).field_storyID == ((j)localObject4).field_storyID)
          {
            i = 1;
            if (i == 0) {
              break label313;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label318;
        }
        ((ArrayList)localObject1).add(localObject4);
        break;
        i = 0;
        break label290;
        break label256;
      }
    }
    Log.i(paraml.TAG, "LogStory: setFavorite " + ((ArrayList)localObject2).size() + ' ' + ((ArrayList)localObject1).size());
    paraml = new ArrayList();
    paramList = new ArrayList();
    if (!((Collection)localObject2).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (j)((Iterator)localObject2).next();
          paraml.add(Long.valueOf(((j)localObject3).field_storyID));
          paramList.add(Integer.valueOf((int)((j)localObject3).systemRowid));
          localObject4 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.a(1L, ((j)localObject3).toString(), 0L, 0L, 1L);
          continue;
          i = 0;
          break;
        }
      }
      localObject2 = m.Sks;
      m.a.b((List)paraml, (List)paramList, true);
    }
    paraml.clear();
    paramList.clear();
    if (!((Collection)localObject1).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (j)((Iterator)localObject1).next();
          paraml.add(Long.valueOf(((j)localObject2).field_storyID));
          paramList.add(Integer.valueOf((int)((j)localObject2).systemRowid));
          localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.a(2L, ((j)localObject2).toString(), 0L, 0L, 1L);
          continue;
          i = 0;
          break;
        }
      }
      localObject1 = m.Sks;
      m.a.b((List)paraml, (List)paramList, false);
    }
    AppMethodBeat.o(367033);
  }
  
  private static final void a(final l paraml, boolean paramBoolean)
  {
    AppMethodBeat.i(367028);
    kotlin.g.b.s.u(paraml, "this$0");
    Object localObject1 = StoryCore.SjP;
    Object localObject2 = k.a(StoryCore.b.hvR(), paraml.Soo);
    if (!((List)localObject2).isEmpty()) {
      paraml.Son = ((j)kotlin.a.p.oM((List)localObject2)).field_storyID;
    }
    Log.d(paraml.TAG, "localCachedMinId=" + paraml.Son + " infos.size=" + ((List)localObject2).size() + " localMinId=" + paraml.Soo);
    localObject1 = new ArrayList();
    final ArrayList localArrayList = new ArrayList();
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = StoryCore.SjP;
      localObject3 = StoryCore.b.hvR();
      StoryCore.b localb = StoryCore.SjP;
      localArrayList.addAll((Collection)((k)localObject3).ds(StoryCore.b.hgg(), true));
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (j)((Iterator)localObject2).next();
      if ((((j)localObject3).field_storyID != 0L) && (!((j)localObject3).hzw())) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    d.uiThread((kotlin.g.a.a)new a(paramBoolean, paraml, (ArrayList)localObject1, localArrayList));
    AppMethodBeat.o(367028);
  }
  
  private static final void b(l paraml)
  {
    AppMethodBeat.i(367026);
    kotlin.g.b.s.u(paraml, "this$0");
    paraml.vP(paraml.Son);
    paraml.EG(false);
    if (paraml.SpG > 0) {
      paraml.hvh();
    }
    AppMethodBeat.o(367026);
  }
  
  private final void vP(long paramLong)
  {
    AppMethodBeat.i(119344);
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR();
    Object localObject2 = StoryCore.SjP;
    StoryCore.b.hwa();
    kotlin.g.b.s.u(this.sWX, "userName");
    localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    int i = com.tencent.mm.plugin.story.h.a.hyy();
    localObject2 = this.sWX;
    String str = this.sWX;
    StoryCore.b localb = StoryCore.SjP;
    this.Soo = ((k)localObject1).b(paramLong, i, (String)localObject2, Util.isEqual(str, StoryCore.b.hgg()));
    if (this.Som != 0L) {
      if (this.Soo >= this.Som) {
        break label160;
      }
    }
    label160:
    for (paramLong = this.Soo;; paramLong = this.Som)
    {
      this.Soo = paramLong;
      Log.d(this.TAG, "localMinId=" + this.Soo + ", respMaxId=" + this.Som);
      AppMethodBeat.o(119344);
      return;
    }
  }
  
  public final void EG(boolean paramBoolean)
  {
    AppMethodBeat.i(119347);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new l..ExternalSyntheticLambda3(this, paramBoolean));
    AppMethodBeat.o(119347);
  }
  
  public final void hoB()
  {
    AppMethodBeat.i(119346);
    com.tencent.mm.kernel.h.baD().mCm.b(273, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119346);
  }
  
  public final void hvh()
  {
    AppMethodBeat.i(119348);
    if (!this.Uz)
    {
      this.SpG -= 1;
      Log.i(this.TAG, "loadNpData username=" + this.sWX + " maxId=" + this.Som);
      if (!this.wHe)
      {
        this.Uz = true;
        com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
        String str = this.sWX;
        long l = this.Som;
        Object localObject = this.sWX;
        StoryCore.b localb = StoryCore.SjP;
        boolean bool = Util.isEqual((String)localObject, StoryCore.b.hgg());
        localObject = com.tencent.mm.plugin.story.h.a.Sry;
        locals.a((com.tencent.mm.am.p)new i(str, l, bool, "", com.tencent.mm.plugin.story.h.a.hyW()), 0);
        AppMethodBeat.o(119348);
      }
    }
    else
    {
      Log.i(this.TAG, "loadNpData is running");
    }
    AppMethodBeat.o(119348);
  }
  
  public final void hvi()
  {
    AppMethodBeat.i(119349);
    if (!this.Uz)
    {
      this.Uz = true;
      Log.i(this.TAG, "loadFpData username=" + this.sWX + " maxId=" + this.Som);
      com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
      String str = this.sWX;
      Object localObject = this.sWX;
      StoryCore.b localb = StoryCore.SjP;
      boolean bool = Util.isEqual((String)localObject, StoryCore.b.hgg());
      localObject = com.tencent.mm.plugin.story.h.a.Sry;
      locals.a((com.tencent.mm.am.p)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.h.a.hyW()), 0);
      AppMethodBeat.o(119349);
      return;
    }
    Log.i(this.TAG, "loadFpData is running");
    AppMethodBeat.o(119349);
  }
  
  public final void le(List<j> paramList)
  {
    AppMethodBeat.i(119351);
    kotlin.g.b.s.u(paramList, "storyList");
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new l..ExternalSyntheticLambda2(this, paramList));
    AppMethodBeat.o(119351);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119345);
    kotlin.g.b.s.u(paramString, "userName");
    this.sWX = paramString;
    vP(this.Son);
    com.tencent.mm.kernel.h.baD().mCm.a(273, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119345);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(119350);
    Log.i(this.TAG, "LogStory: " + paramInt1 + ' ' + paramInt2 + ' ' + paramString + ' ' + paramp);
    boolean bool;
    if (((paramp instanceof i)) && (Util.isEqual(((i)paramp).userName, this.sWX)))
    {
      int i = ((i)paramp).source;
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      if (i == com.tencent.mm.plugin.story.h.a.hyW())
      {
        Log.d(this.TAG, "onSceneEnd username=" + this.sWX + " respMaxId=" + this.Som + ' ' + paramInt1 + ' ' + paramInt2 + ' ' + ((i)paramp).QtH);
        this.Uz = false;
        long l = ((i)paramp).QtH;
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        if (paramInt2 != com.tencent.mm.plugin.story.h.a.hyD())
        {
          paramString = com.tencent.mm.plugin.story.h.a.Sry;
          if ((paramInt2 != com.tencent.mm.plugin.story.h.a.hyE()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.h.a.Sry;
            if ((paramInt2 != com.tencent.mm.plugin.story.h.a.hyC()) || (l != 0L)) {
              break label405;
            }
          }
        }
        bool = true;
        this.wHe = bool;
        this.SpJ.EF(this.wHe);
        this.Som = ((i)paramp).QtH;
        if (!((i)paramp).Qsg) {
          break label411;
        }
        paramString = StoryCore.SjP;
        StoryCore.b.gHI().post(new l..ExternalSyntheticLambda0(this));
      }
    }
    for (;;)
    {
      Log.d(this.TAG, "onSceneEnd username=" + this.sWX + " respMaxId=" + this.Som + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.wHe + " limitId:" + this.Som);
      AppMethodBeat.o(119350);
      return;
      label405:
      bool = false;
      break;
      label411:
      paramString = StoryCore.SjP;
      StoryCore.b.gHI().post(new l..ExternalSyntheticLambda1(this));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(boolean paramBoolean, l paraml, ArrayList<j> paramArrayList1, ArrayList<j> paramArrayList2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.l
 * JD-Core Version:    0.7.0.1
 */