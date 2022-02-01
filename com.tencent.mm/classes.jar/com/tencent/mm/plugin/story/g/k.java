package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.d.a.a;
import com.tencent.mm.plugin.story.d.a.b;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter;", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "view", "Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "(Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;)V", "isRunning", "", "loadNpCount", "", "localCachedMinId", "", "localMinId", "mIsAll", "mUsername", "", "respMaxId", "getView", "()Lcom/tencent/mm/plugin/story/contract/AlbumContract$IFavAlbumView;", "isAll", "errType", "errCode", "limitId", "loadFavStoryFromDB", "", "loadFpData", "loadNpData", "onCreate", "userName", "onDestory", "onHandleFp", "onHandleNp", "onSceneEnd", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reloadFp", "updateLocalMinId", "lastId", "Companion", "plugin-story_release"})
public final class k
  implements com.tencent.mm.ak.i, a.a
{
  public static final a FsL;
  private static final String TAG = "MicroMsg.StoryFavAlbumPresenter";
  private long FqQ;
  private long FqR;
  private long FqS;
  private int FsJ;
  final a.b FsK;
  private boolean isRunning;
  private String mRa;
  private boolean qhf;
  
  static
  {
    AppMethodBeat.i(119338);
    FsL = new a((byte)0);
    TAG = "MicroMsg.StoryFavAlbumPresenter";
    AppMethodBeat.o(119338);
  }
  
  public k(a.b paramb)
  {
    AppMethodBeat.i(119337);
    this.FsK = paramb;
    this.mRa = "";
    this.FsJ = 1;
    AppMethodBeat.o(119337);
  }
  
  public final void Km(long paramLong)
  {
    AppMethodBeat.i(119331);
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.foc();
    String str = this.mRa;
    Object localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    boolean bool = Util.isEqual(j.b.fau(), this.mRa);
    localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.fol();
    localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
    this.FqS = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramLong, str, bool, com.tencent.mm.plugin.story.i.a.fqJ());
    Log.d(TAG, "localMinId=" + this.FqS + ", respMaxId=" + this.FqQ);
    AppMethodBeat.o(119331);
  }
  
  public final void fib()
  {
    AppMethodBeat.i(119332);
    b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(273, (com.tencent.mm.ak.i)this);
    localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(764, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119332);
  }
  
  public final void fnw()
  {
    AppMethodBeat.i(119333);
    if (!this.isRunning)
    {
      this.FsJ -= 1;
      Log.i(TAG, "loadNpData username=" + this.mRa + " maxId=" + this.FqQ);
      if (!this.qhf)
      {
        this.isRunning = true;
        Object localObject1 = g.aAg();
        p.g(localObject1, "MMKernel.network()");
        localObject1 = ((b)localObject1).azz();
        String str = this.mRa;
        long l = this.FqQ;
        Object localObject2 = this.mRa;
        j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
        boolean bool = Util.isEqual((String)localObject2, j.b.fau());
        localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
        ((t)localObject1).b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.story.f.a.i(str, l, bool, "", com.tencent.mm.plugin.story.i.a.frj()));
      }
    }
    AppMethodBeat.o(119333);
  }
  
  public final void fnx()
  {
    AppMethodBeat.i(119334);
    if (!this.isRunning)
    {
      this.isRunning = true;
      Log.i(TAG, "loadFpData username=" + this.mRa + " maxId=" + this.FqQ);
      Object localObject1 = g.aAg();
      p.g(localObject1, "MMKernel.network()");
      localObject1 = ((b)localObject1).azz();
      String str = this.mRa;
      Object localObject2 = this.mRa;
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      boolean bool = Util.isEqual((String)localObject2, j.b.fau());
      localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
      ((t)localObject1).b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.story.f.a.i(str, 0L, bool, "", com.tencent.mm.plugin.story.i.a.frj()));
    }
    AppMethodBeat.o(119334);
  }
  
  public final void fny()
  {
    AppMethodBeat.i(119335);
    j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.eJP().post((Runnable)new b(this));
    AppMethodBeat.o(119335);
  }
  
  public final void onCreate(String paramString)
  {
    AppMethodBeat.i(119330);
    p.h(paramString, "userName");
    this.mRa = paramString;
    Km(this.FqR);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(273, (com.tencent.mm.ak.i)this);
    paramString = g.aAg();
    p.g(paramString, "MMKernel.network()");
    paramString.azz().a(764, (com.tencent.mm.ak.i)this);
    AppMethodBeat.o(119330);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(119336);
    int i;
    if ((paramq instanceof com.tencent.mm.plugin.story.f.a.i))
    {
      i = ((com.tencent.mm.plugin.story.f.a.i)paramq).source;
      paramString = com.tencent.mm.plugin.story.i.a.FvD;
      if (i == com.tencent.mm.plugin.story.i.a.frj())
      {
        this.isRunning = false;
        long l = ((com.tencent.mm.plugin.story.f.a.i)paramq).DJB;
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        if (paramInt2 != com.tencent.mm.plugin.story.i.a.fqP())
        {
          paramString = com.tencent.mm.plugin.story.i.a.FvD;
          if ((paramInt2 != com.tencent.mm.plugin.story.i.a.fqQ()) && ((paramInt1 != 0) || (paramInt2 != 0) || (l != 0L)))
          {
            paramString = com.tencent.mm.plugin.story.i.a.FvD;
            if ((paramInt2 != com.tencent.mm.plugin.story.i.a.fqO()) || (l != 0L)) {
              break label263;
            }
          }
        }
        boolean bool = true;
        this.qhf = bool;
        this.FsK.vK(this.qhf);
        this.FqQ = ((com.tencent.mm.plugin.story.f.a.i)paramq).DJB;
        if (((com.tencent.mm.plugin.story.f.a.i)paramq).DIe)
        {
          paramString = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new c(this));
        }
        for (;;)
        {
          Log.d(TAG, "onSceneEnd username=" + this.mRa + " respMaxId=" + this.FqQ + ' ' + paramInt1 + ' ' + paramInt2 + " isAll:" + this.qhf + " limitId:" + this.FqQ);
          AppMethodBeat.o(119336);
          return;
          label263:
          bool = false;
          break;
          paramString = com.tencent.mm.plugin.story.f.j.Fmy;
          j.b.eJP().post((Runnable)new d(this));
        }
      }
    }
    int j;
    if ((paramq instanceof f))
    {
      paramString = ((f)paramq).foQ();
      if (paramString != null) {
        if (((paramString instanceof com.tencent.mm.plugin.story.f.a.k)) && (paramInt2 == 0))
        {
          paramq = (Iterable)((f)paramq).FnH;
          j = 0;
          paramq = paramq.iterator();
          i = 0;
          if (paramq.hasNext())
          {
            Object localObject = paramq.next();
            if (j < 0) {
              kotlin.a.j.hxH();
            }
            int k = ((Number)localObject).intValue();
            Log.i(TAG, "onSceneEnd update story favorite: errType " + paramInt1 + ", errcode " + paramInt2 + ", localId " + k + ", favorite:" + ((com.tencent.mm.plugin.story.f.a.k)paramString).FnT);
            localObject = n.FmM;
            n.a.jd(k, ((com.tencent.mm.plugin.story.f.a.k)paramString).FnT);
            if (((com.tencent.mm.plugin.story.f.a.k)paramString).FnT != 1) {
              break label552;
            }
            i = 1;
          }
        }
      }
    }
    label552:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0)
      {
        this.FsJ = 1;
        this.FqR = 0L;
        this.FqS = 0L;
        Km(this.FqR);
        fnx();
        fny();
        AppMethodBeat.o(119336);
        return;
      }
      fny();
      AppMethodBeat.o(119336);
      return;
      AppMethodBeat.o(119336);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/StoryFavAlbumPresenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119327);
      final ArrayList localArrayList = new ArrayList();
      final z.f localf = new z.f();
      Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject = j.b.foc();
      String str1 = k.a(this.FsM);
      String str2 = k.a(this.FsM);
      j.b localb = com.tencent.mm.plugin.story.f.j.Fmy;
      localf.SYG = com.tencent.mm.plugin.story.i.k.a((com.tencent.mm.plugin.story.i.k)localObject, str1, Util.isEqual(str2, j.b.fau()), k.b(this.FsM));
      int i;
      if (!((Collection)localf.SYG).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label222;
        }
        k.a(this.FsM, ((com.tencent.mm.plugin.story.i.j)kotlin.a.j.ku((List)localf.SYG)).field_storyID);
      }
      for (;;)
      {
        localObject = k.FsL;
        Log.d(k.access$getTAG$cp(), "localCachedMinId=" + k.c(this.FsM) + " infos.size=" + ((List)localf.SYG).size() + " localMinId=" + k.b(this.FsM));
        d.h((kotlin.g.a.a)new kotlin.g.b.q(localf) {});
        AppMethodBeat.o(119327);
        return;
        i = 0;
        break;
        label222:
        localObject = com.tencent.mm.plugin.story.f.j.Fmy;
        localObject = j.b.foc();
        str1 = k.a(this.FsM);
        str2 = k.a(this.FsM);
        localb = com.tencent.mm.plugin.story.f.j.Fmy;
        localArrayList.addAll((Collection)((com.tencent.mm.plugin.story.i.k)localObject).cw(str1, Util.isEqual(str2, j.b.fau())));
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119328);
      this.FsM.Km(k.c(this.FsM));
      this.FsM.fny();
      if (k.d(this.FsM) > 0) {
        this.FsM.fnw();
      }
      AppMethodBeat.o(119328);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(119329);
      this.FsM.Km(k.c(this.FsM));
      this.FsM.fny();
      if (k.d(this.FsM) > 0) {
        this.FsM.fnw();
      }
      AppMethodBeat.o(119329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.k
 * JD-Core Version:    0.7.0.1
 */