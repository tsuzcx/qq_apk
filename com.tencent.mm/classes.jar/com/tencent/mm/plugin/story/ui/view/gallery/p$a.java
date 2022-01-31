package com.tencent.mm.plugin.story.ui.view.gallery;

import a.a.j;
import a.f.a.a;
import a.l;
import a.o;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;", "", "groupItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "positionV", "", "positionH", "lastGroup", "skipPosition", "", "(Ljava/util/List;IILcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$GroupData;Z)V", "MAX_PRELOAD_COUNT", "horizontalList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "produceList", "Lkotlin/Function0;", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoPreloadMgr$TaskInfo;", "verticalList", "walkHorizontal", "walkIndex", "walkVertical", "info", "", "isDataChange", "isSame", "galleryItems", "produce", "produceHorizontalVideoItem", "produceVerticalVideoItem", "produceVideoItem", "reset", "", "resetWalk", "Companion", "plugin-story_release"})
public final class p$a
{
  static final String TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
  public static final p.a.a sUS;
  private final int sUI;
  int sUJ;
  int sUK;
  private int sUL;
  private ArrayList<g> sUM;
  private ArrayList<g> sUN;
  List<? extends a<o<i, p.c>>> sUO;
  int sUP;
  int sUQ;
  private final boolean sUR;
  
  static
  {
    AppMethodBeat.i(110872);
    sUS = new p.a.a((byte)0);
    TAG = "MicroMsg.GroupData.StoryVideoPreloadMgr";
    AppMethodBeat.o(110872);
  }
  
  public p$a(List<? extends List<g>> arg1, int paramInt1, int paramInt2, a arg4)
  {
    AppMethodBeat.i(110871);
    this.sUP = paramInt1;
    this.sUQ = paramInt2;
    this.sUR = true;
    this.sUI = 15;
    this.sUM = new ArrayList();
    this.sUN = new ArrayList();
    this.sUO = j.listOf(new a[] { (a)new p.a.b(this), (a)new p.a.c(this), (a)new p.a.d(this) });
    if (((??? != null) && (this.sUP != ???.sUP)) || ((??? != null) && (this.sUQ != ???.sUQ)) || (dP(???))) {
      reset();
    }
    this.sUM.clear();
    this.sUN.clear();
    for (;;)
    {
      synchronized ((Iterable)???)
      {
        localObject = ???.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        List localList = (List)((Iterator)localObject).next();
        if (!((Collection)localList).isEmpty())
        {
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          this.sUN.add(localList.get(0));
        }
      }
      paramInt1 = 0;
    }
    Object localObject = y.BMg;
    if (this.sUP < ???.size())
    {
      synchronized ((Iterable)???.get(this.sUP))
      {
        ??? = ???.iterator();
        if (???.hasNext())
        {
          localObject = (g)???.next();
          this.sUM.add(localObject);
        }
      }
      ??? = y.BMg;
      AppMethodBeat.o(110871);
      return;
    }
    AppMethodBeat.o(110871);
  }
  
  private final o<i, p.c> cGr()
  {
    AppMethodBeat.i(110869);
    for (;;)
    {
      if (this.sUR) {
        this.sUJ += 1;
      }
      if (this.sUJ >= this.sUN.size())
      {
        AppMethodBeat.o(110869);
        return null;
      }
      try
      {
        if (this.sUN.size() > 0)
        {
          Object localObject1 = ((g)this.sUN.get(this.sUJ)).syr;
          p localp = p.sUH;
          if (p.o((i)localObject1)) {}
          while (localObject1 != null)
          {
            localObject1 = new o(localObject1, new p.c(this.sUJ, 0, (i)localObject1));
            return localObject1;
            localObject1 = null;
          }
        }
        if (this.sUR) {
          continue;
        }
        this.sUJ += 1;
      }
      finally
      {
        if (!this.sUR) {
          this.sUJ += 1;
        }
        AppMethodBeat.o(110869);
      }
    }
  }
  
  private final o<i, p.c> cGs()
  {
    AppMethodBeat.i(110870);
    for (;;)
    {
      if (this.sUR) {
        this.sUK += 1;
      }
      if (this.sUK >= this.sUM.size())
      {
        AppMethodBeat.o(110870);
        return null;
      }
      try
      {
        if (this.sUM.size() > this.sUK)
        {
          Object localObject1 = ((g)this.sUM.get(this.sUK)).syr;
          p localp = p.sUH;
          if (p.o((i)localObject1)) {}
          while (localObject1 != null)
          {
            localObject1 = new o(localObject1, new p.c(this.sUJ, this.sUK, (i)localObject1));
            return localObject1;
            localObject1 = null;
          }
        }
        if (this.sUR) {
          continue;
        }
        this.sUK += 1;
      }
      finally
      {
        if (!this.sUR) {
          this.sUK += 1;
        }
        AppMethodBeat.o(110870);
      }
    }
  }
  
  private final void reset()
  {
    this.sUJ = this.sUP;
    this.sUK = this.sUQ;
    this.sUL = 0;
  }
  
  final o<i, p.c> cGp()
  {
    AppMethodBeat.i(110866);
    try
    {
      if (this.sUL > this.sUI)
      {
        ab.i(TAG, "stop preload now " + this.sUL);
        AppMethodBeat.o(110866);
        return null;
      }
      o localo = (o)((a)this.sUO.get(this.sUL % this.sUO.size())).invoke();
      this.sUL += 1;
      AppMethodBeat.o(110866);
      return localo;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(TAG, (Throwable)localException, "error on produce", new Object[0]);
      AppMethodBeat.o(110866);
    }
    return null;
  }
  
  public final void cGq()
  {
    AppMethodBeat.i(110868);
    ab.i(TAG, "resetWalk");
    reset();
    AppMethodBeat.o(110868);
  }
  
  final boolean dP(List<? extends List<g>> paramList)
  {
    AppMethodBeat.i(110867);
    if (paramList.size() == this.sUN.size())
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        if (((List)paramList.get(i)).isEmpty())
        {
          AppMethodBeat.o(110867);
          return true;
        }
        if (((g)this.sUN.get(i)).syr.cIp != ((g)((List)paramList.get(i)).get(0)).syr.cIp)
        {
          AppMethodBeat.o(110867);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(110867);
      return false;
    }
    AppMethodBeat.o(110867);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p.a
 * JD-Core Version:    0.7.0.1
 */