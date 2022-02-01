package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.a.f;
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
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements com.tencent.mm.am.h, a.a
{
  public static final k.a SpE;
  private static final String TAG;
  private long Som;
  private long Son;
  private long Soo;
  final a.b SpF;
  private int SpG;
  private boolean Uz;
  private String sWX;
  private boolean wHe;
  
  static
  {
    AppMethodBeat.i(119338);
    SpE = new k.a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.SpF = paramb;
    this.sWX = "";
    this.SpG = 1;
    AppMethodBeat.o(119337);
  }
  
  private static final void a(k paramk)
  {
    AppMethodBeat.i(367023);
    kotlin.g.b.s.u(paramk, "this$0");
    final ArrayList localArrayList = new ArrayList();
    final ah.f localf = new ah.f();
    Object localObject = StoryCore.SjP;
    localObject = StoryCore.b.hvR();
    String str1 = paramk.sWX;
    String str2 = paramk.sWX;
    StoryCore.b localb = StoryCore.SjP;
    localf.aqH = com.tencent.mm.plugin.story.h.k.a((com.tencent.mm.plugin.story.h.k)localObject, str1, Util.isEqual(str2, StoryCore.b.hgg()), paramk.Soo);
    int i;
    if (!((Collection)localf.aqH).isEmpty())
    {
      i = 1;
      if (i == 0) {
        break label202;
      }
      paramk.Son = ((j)kotlin.a.p.oM((List)localf.aqH)).field_storyID;
    }
    for (;;)
    {
      Log.d(TAG, "localCachedMinId=" + paramk.Son + " infos.size=" + ((List)localf.aqH).size() + " localMinId=" + paramk.Soo);
      d.uiThread((kotlin.g.a.a)new b(paramk, localf, localArrayList));
      AppMethodBeat.o(367023);
      return;
      i = 0;
      break;
      label202:
      localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      str1 = paramk.sWX;
      str2 = paramk.sWX;
      localb = StoryCore.SjP;
      localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.h.k)localObject).dq(str1, Util.isEqual(str2, StoryCore.b.hgg())));
    }
  }
  
  private static final void b(k paramk)
  {
    AppMethodBeat.i(367025);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.vP(paramk.Son);
    paramk.hvj();
    if (paramk.SpG > 0) {
      paramk.hvh();
    }
    AppMethodBeat.o(367025);
  }
  
  private static final void c(k paramk)
  {
    AppMethodBeat.i(367027);
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.vP(paramk.Son);
    paramk.hvj();
    if (paramk.SpG > 0) {
      paramk.hvh();
    }
    AppMethodBeat.o(367027);
  }
  
  private void vP(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR();
    String str = this.sWX;
    Object localObject2 = StoryCore.SjP;
    boolean bool = Util.isEqual(StoryCore.b.hgg(), this.sWX);
    localObject2 = StoryCore.SjP;
    StoryCore.b.hwa();
    localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
    this.Soo = ((com.tencent.mm.plugin.story.h.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.h.a.hyx());
    Log.d(TAG, "localMinId=" + this.Soo + ", respMaxId=" + this.Som);
    AppMethodBeat.o(119331);
  }
  
  public final void hoB()
  {
    AppMethodBeat.i(119332);
    com.tencent.mm.kernel.h.baD().mCm.b(273, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119332);
  }
  
  public final void hvh()
  {
    AppMethodBeat.i(119333);
    if (!this.Uz)
    {
      this.SpG -= 1;
      Log.i(TAG, "loadNpData username=" + this.sWX + " maxId=" + this.Som);
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
        locals.a((com.tencent.mm.am.p)new i(str, l, bool, "", com.tencent.mm.plugin.story.h.a.hyX()), 0);
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void hvi()
  {
    AppMethodBeat.i(119334);
    if (!this.Uz)
    {
      this.Uz = true;
      Log.i(TAG, "loadFpData username=" + this.sWX + " maxId=" + this.Som);
      com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.baD().mCm;
      String str = this.sWX;
      Object localObject = this.sWX;
      StoryCore.b localb = StoryCore.SjP;
      boolean bool = Util.isEqual((String)localObject, StoryCore.b.hgg());
      localObject = com.tencent.mm.plugin.story.h.a.Sry;
      locals.a((com.tencent.mm.am.p)new i(str, 0L, bool, "", com.tencent.mm.plugin.story.h.a.hyX()), 0);
    }
    AppMethodBeat.o(119334);
  }
  
  public final void hvj()
  {
    AppMethodBeat.i(119335);
    StoryCore.b localb = StoryCore.SjP;
    StoryCore.b.gHI().post(new k..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    kotlin.g.b.s.u(paramString, "userName");
    this.sWX = paramString;
    vP(this.Son);
    com.tencent.mm.kernel.h.baD().mCm.a(273, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramp instanceof i))
    {
      i = ((i)paramp).source;
      paramString = com.tencent.mm.plugin.story.h.a.Sry;
      if (i == com.tencent.mm.plugin.story.h.a.hyX())
      {
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
              break label260;
            }
          }
        }
        boolean bool = true;
        this.wHe = bool;
        this.SpF.EF(this.wHe);
        this.Som = ((i)paramp).QtH;
        if (((i)paramp).Qsg)
        {
          paramString = StoryCore.SjP;
          StoryCore.b.gHI().post(new k..ExternalSyntheticLambda0(this));
        }
        for (;;)
        {
          Log.d(TAG, "onSceneEnd username=" + this.sWX + " respMaxId=" + this.Som + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.wHe + " limitId:" + this.Som);
          AppMethodBeat.o(119336);
          return;
          label260:
          bool = false;
          break;
          paramString = StoryCore.SjP;
          StoryCore.b.gHI().post(new k..ExternalSyntheticLambda2(this));
        }
      }
    }
    int j;
    if ((paramp instanceof f))
    {
      paramString = ((f)paramp).hwE();
      if ((paramString != null) && ((paramString instanceof com.tencent.mm.plugin.story.model.a.k)) && (paramInt2 == 0))
      {
        paramp = (Iterable)((f)paramp).Slm;
        j = 0;
        paramp = paramp.iterator();
        i = 0;
        if (paramp.hasNext())
        {
          Object localObject = paramp.next();
          if (j < 0) {
            kotlin.a.p.kkW();
          }
          int k = ((Number)localObject).intValue();
          Log.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
          localObject = m.Sks;
          m.a.lZ(k, ((com.tencent.mm.plugin.story.model.a.k)paramString).favorite);
          if (((com.tencent.mm.plugin.story.model.a.k)paramString).favorite != 1) {
            break label539;
          }
          i = 1;
        }
      }
    }
    label539:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        this.SpG = 1;
        this.Son = 0L;
        this.Soo = 0L;
        vP(this.Son);
        hvi();
        hvj();
        AppMethodBeat.o(119336);
        return;
      }
      hvj();
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(k paramk, ah.f<List<j>> paramf, ArrayList<j> paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k
 * JD-Core Version:    0.7.0.1
 */