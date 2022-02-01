package com.tencent.mm.plugin.story.g;

import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f
{
  public static final a LLM = new a((byte)0);
  private static final String TAG = "MicroMsg.Gallery.GalleryController";
  
  public void G(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void H(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void I(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void aDi() {}
  
  public void aif(int paramInt) {}
  
  public void aij(int paramInt) {}
  
  public void aik(int paramInt) {}
  
  public void destroy() {}
  
  public void gdS() {}
  
  public void gdT() {}
  
  public void ko(int paramInt1, int paramInt2) {}
  
  public void kp(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
  public static final class a
  {
    public static ArrayList<com.tencent.mm.plugin.story.f.d.h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      p.k(paramString, "username");
      c localc = new c("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
      localObject1 = (Iterable)j.b.gcw().cK(paramString, paramBoolean);
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label130:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        com.tencent.mm.plugin.story.i.j localj = (com.tencent.mm.plugin.story.i.j)localObject2;
        if (paramArrayList != null) {}
        for (paramBoolean = paramArrayList.contains(Long.valueOf(localj.field_storyID));; paramBoolean = true)
        {
          if (!paramBoolean) {
            break label130;
          }
          paramString.add(localObject2);
          break;
        }
      }
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (com.tencent.mm.plugin.story.i.j)paramString.next();
        localObject1 = paramArrayList.ggc();
        if ((((eol)localObject1).Ura != null) && (((eol)localObject1).Ura.Sqr.size() != 0))
        {
          localObject2 = com.tencent.mm.plugin.story.f.d.h.LJa;
          localArrayList.add(com.tencent.mm.plugin.story.f.d.h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.LJc));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((enu)((eol)localObject1).Ura.Sqr.get(0)).TDF + ' ' + "and " + ((enu)((eol)localObject1).Ura.Sqr.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localc.aIZ();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static com.tencent.mm.plugin.story.f.d.h cH(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119201);
      p.k(paramString, "username");
      Log.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
      Object localObject1 = com.tencent.mm.plugin.story.f.k.LGJ;
      paramString = com.tencent.mm.plugin.story.f.k.bcW(paramString);
      int i;
      if (paramString.field_syncId == 0L) {
        i = 1;
      }
      while (i == 0) {
        if (paramBoolean)
        {
          localObject1 = com.tencent.mm.plugin.story.f.d.h.LJa;
          p.k(paramString, "extInfo");
          localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
          Object localObject2 = j.b.gcw().RU(paramString.field_syncId);
          localObject1 = new com.tencent.mm.plugin.story.i.j();
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
          Object localObject3 = q.LGQ;
          localObject3 = q.a.gcR();
          ((eol)localObject3).UserName = paramString.getUserName();
          ((eol)localObject3).CreateTime = paramString.field_storyPostTime;
          Object localObject4 = q.LGQ;
          localObject4 = new enu();
          ((enu)localObject4).Id = ("empty_" + cm.bfD());
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).ggc();
            if ((localObject2 != null) && (((eol)localObject2).Urc == 0))
            {
              ((enu)localObject4).TDF = paramString.aJi();
              ((enu)localObject4).Url = paramString.gfT();
            }
          }
          ((eol)localObject3).Ura.Sqr.add(localObject4);
          ((com.tencent.mm.plugin.story.i.j)localObject1).c((eol)localObject3);
          paramString = new com.tencent.mm.plugin.story.f.d.h((com.tencent.mm.plugin.story.i.j)localObject1, (eol)localObject3);
          AppMethodBeat.o(119201);
          return paramString;
          i = 0;
        }
        else
        {
          localObject1 = com.tencent.mm.plugin.story.f.d.h.LJa;
          paramString = com.tencent.mm.plugin.story.f.d.h.a.a(paramString);
          AppMethodBeat.o(119201);
          return paramString;
        }
      }
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<com.tencent.mm.plugin.story.f.d.h> cI(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      p.k(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcw();
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
        paramBoolean = Util.isEqual(j.b.fOo(), paramString);
        i = cm.bfF();
        localObject2 = com.tencent.mm.plugin.story.f.i.LGd;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).m(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.gcn());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.gcn(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          eol localeol = ((com.tencent.mm.plugin.story.i.j)localObject2).ggc();
          if ((localeol.Ura != null) && (localeol.Ura.Sqr.size() != 0))
          {
            com.tencent.mm.plugin.story.f.d.h.a locala = com.tencent.mm.plugin.story.f.d.h.LJa;
            localArrayList.add(com.tencent.mm.plugin.story.f.d.h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((enu)localeol.Ura.Sqr.get(0)).TDF + ' ' + "and " + ((enu)localeol.Ura.Sqr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).gge().kQn + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcw();
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
        paramBoolean = Util.isEqual(j.b.fOo(), paramString);
        i = cm.bfF();
        localObject2 = com.tencent.mm.plugin.story.f.i.LGd;
      }
      AppMethodBeat.o(119202);
      return localArrayList;
    }
    
    public static ArrayList<com.tencent.mm.plugin.story.f.d.h> l(String paramString, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(119203);
      p.k(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcw();
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).m(paramString, Util.isEqual(j.b.fOo(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, Util.isEqual(j.b.fOo(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          eol localeol = ((com.tencent.mm.plugin.story.i.j)localObject2).ggc();
          if ((localeol.Ura != null) && (localeol.Ura.Sqr.size() != 0))
          {
            com.tencent.mm.plugin.story.f.d.h.a locala = com.tencent.mm.plugin.story.f.d.h.LJa;
            localArrayList.add(com.tencent.mm.plugin.story.f.d.h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((enu)localeol.Ura.Sqr.get(0)).TDF + ' ' + "and " + ((enu)localeol.Ura.Sqr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).gge().kQn + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.LGA;
        localObject1 = j.b.gcw();
        localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<com.tencent.mm.plugin.story.f.d.h> lx(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      p.k(paramString1, "username");
      p.k(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.LFy;
      int i = a.a.bcR(paramString2);
      paramString2 = com.tencent.mm.plugin.story.f.j.LGA;
      paramString2 = j.b.gcw().gr(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
        eol localeol = ((com.tencent.mm.plugin.story.i.j)localObject).ggc();
        if ((localeol.Ura != null) && (localeol.Ura.Sqr.size() != 0))
        {
          com.tencent.mm.plugin.story.f.d.h.a locala = com.tencent.mm.plugin.story.f.d.h.LJa;
          localArrayList.add(com.tencent.mm.plugin.story.f.d.h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((enu)localeol.Ura.Sqr.get(0)).TDF + ' ' + "and " + ((enu)localeol.Ura.Sqr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    public static h.b y(List<com.tencent.mm.plugin.story.f.d.h> paramList1, final List<com.tencent.mm.plugin.story.f.d.h> paramList2)
    {
      AppMethodBeat.i(218640);
      p.k(paramList1, "oldItems");
      p.k(paramList2, "newItems");
      paramList1 = androidx.recyclerview.widget.h.a((androidx.recyclerview.widget.h.a)new a(paramList1, paramList2), false);
      p.j(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(218640);
      return paramList1;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class a
      extends androidx.recyclerview.widget.h.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean Z(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((com.tencent.mm.plugin.story.f.d.h)this.LLN.get(paramInt1)).fXG == ((com.tencent.mm.plugin.story.f.d.h)paramList2.get(paramInt2)).fXG)
        {
          AppMethodBeat.o(119199);
          return true;
        }
        AppMethodBeat.o(119199);
        return false;
      }
      
      public final boolean ab(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119200);
        boolean bool = p.h((com.tencent.mm.plugin.story.f.d.h)this.LLN.get(paramInt1), (com.tencent.mm.plugin.story.f.d.h)paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
      
      public final int jL()
      {
        AppMethodBeat.i(119197);
        int i = this.LLN.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final int jM()
      {
        AppMethodBeat.i(119198);
        int i = paramList2.size();
        AppMethodBeat.o(119198);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f
 * JD-Core Version:    0.7.0.1
 */