package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f
{
  static final String TAG = "MicroMsg.Gallery.GalleryController";
  public static final a zxv = new a((byte)0);
  
  public void QC(int paramInt) {}
  
  public void QD(int paramInt) {}
  
  public void Qy(int paramInt) {}
  
  public void cfp() {}
  
  public void dXa() {}
  
  public void dXb() {}
  
  public void destroy() {}
  
  public void hP(int paramInt1, int paramInt2) {}
  
  public void hQ(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void w(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void x(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void y(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
  public static final class a
  {
    public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      d.g.b.k.h(paramString, "username");
      b localb = new b("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
      localObject1 = (Iterable)j.b.dVE().bT(paramString, paramBoolean);
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
        localObject1 = paramArrayList.dZi();
        if ((((dep)localObject1).FOc != null) && (((dep)localObject1).FOc.Etz.size() != 0))
        {
          localObject2 = h.zuK;
          localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.zuM));
          ac.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((ddy)((dep)localObject1).FOc.Etz.get(0)).Fjh + ' ' + "and " + ((ddy)((dep)localObject1).FOc.Etz.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localb.aic();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static h bQ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119201);
      d.g.b.k.h(paramString, "username");
      ac.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
      Object localObject1 = com.tencent.mm.plugin.story.f.k.zsq;
      paramString = com.tencent.mm.plugin.story.f.k.awy(paramString);
      int i;
      if (paramString.field_syncId == 0L) {
        i = 1;
      }
      while (i == 0) {
        if (paramBoolean)
        {
          localObject1 = h.zuK;
          d.g.b.k.h(paramString, "extInfo");
          localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
          Object localObject2 = j.b.dVE().yz(paramString.field_syncId);
          localObject1 = new com.tencent.mm.plugin.story.i.j();
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
          Object localObject3 = q.zsy;
          localObject3 = q.a.dVY();
          ((dep)localObject3).ncR = paramString.getUserName();
          ((dep)localObject3).CreateTime = paramString.field_storyPostTime;
          Object localObject4 = q.zsy;
          localObject4 = new ddy();
          ((ddy)localObject4).Id = ("empty_" + ce.azI());
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).dZi();
            if ((localObject2 != null) && (((dep)localObject2).FOe == 0))
            {
              ((ddy)localObject4).Fjh = paramString.aik();
              ((ddy)localObject4).Url = paramString.dYZ();
            }
          }
          ((dep)localObject3).FOc.Etz.add(localObject4);
          ((com.tencent.mm.plugin.story.i.j)localObject1).c((dep)localObject3);
          paramString = new h((com.tencent.mm.plugin.story.i.j)localObject1, (dep)localObject3);
          AppMethodBeat.o(119201);
          return paramString;
          i = 0;
        }
        else
        {
          localObject1 = h.zuK;
          paramString = h.a.a(paramString);
          AppMethodBeat.o(119201);
          return paramString;
        }
      }
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<h> bR(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      d.g.b.k.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVE();
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
        paramBoolean = bs.lr(j.b.dHx(), paramString);
        i = ce.azK();
        localObject2 = com.tencent.mm.plugin.story.f.i.zrK;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.dVv());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.dVv(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dep localdep = ((com.tencent.mm.plugin.story.i.j)localObject2).dZi();
          if ((localdep.FOc != null) && (localdep.FOc.Etz.size() != 0))
          {
            h.a locala = h.zuK;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ac.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((ddy)localdep.FOc.Etz.get(0)).Fjh + ' ' + "and " + ((ddy)localdep.FOc.Etz.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).dZk().gLY + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVE();
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
        paramBoolean = bs.lr(j.b.dHx(), paramString);
        i = ce.azK();
        localObject2 = com.tencent.mm.plugin.story.f.i.zrK;
      }
      AppMethodBeat.o(119202);
      return localArrayList;
    }
    
    public static ArrayList<h> i(String paramString, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(119203);
      d.g.b.k.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVE();
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, bs.lr(j.b.dHx(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, bs.lr(j.b.dHx(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dep localdep = ((com.tencent.mm.plugin.story.i.j)localObject2).dZi();
          if ((localdep.FOc != null) && (localdep.FOc.Etz.size() != 0))
          {
            h.a locala = h.zuK;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ac.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((ddy)localdep.FOc.Etz.get(0)).Fjh + ' ' + "and " + ((ddy)localdep.FOc.Etz.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).dZk().gLY + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
        localObject1 = j.b.dVE();
        localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<h> jQ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      d.g.b.k.h(paramString1, "username");
      d.g.b.k.h(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.zrf;
      int i = a.a.awt(paramString2);
      paramString2 = com.tencent.mm.plugin.story.f.j.zsh;
      paramString2 = j.b.dVE().eO(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
        dep localdep = ((com.tencent.mm.plugin.story.i.j)localObject).dZi();
        if ((localdep.FOc != null) && (localdep.FOc.Etz.size() != 0))
        {
          h.a locala = h.zuK;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
          ac.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((ddy)localdep.FOc.Etz.get(0)).Fjh + ' ' + "and " + ((ddy)localdep.FOc.Etz.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    public static c.b z(List<h> paramList1, final List<h> paramList2)
    {
      AppMethodBeat.i(119206);
      d.g.b.k.h(paramList1, "oldItems");
      d.g.b.k.h(paramList2, "newItems");
      paramList1 = c.a((c.a)new a(paramList1, paramList2), false);
      d.g.b.k.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(119206);
      return paramList1;
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class a
      extends c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean H(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((h)this.zxw.get(paramInt1)).dyg == ((h)paramList2.get(paramInt2)).dyg)
        {
          AppMethodBeat.o(119199);
          return true;
        }
        AppMethodBeat.o(119199);
        return false;
      }
      
      public final boolean I(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119200);
        boolean bool = d.g.b.k.g((h)this.zxw.get(paramInt1), (h)paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
      
      public final int gZ()
      {
        AppMethodBeat.i(119197);
        int i = this.zxw.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final int ha()
      {
        AppMethodBeat.i(119198);
        int i = paramList2.size();
        AppMethodBeat.o(119198);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f
 * JD-Core Version:    0.7.0.1
 */