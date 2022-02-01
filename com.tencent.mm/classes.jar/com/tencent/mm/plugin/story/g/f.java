package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.b;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f
{
  static final String TAG = "MicroMsg.Gallery.GalleryController";
  public static final a ykw = new a((byte)0);
  
  public void Os(int paramInt) {}
  
  public void Ow(int paramInt) {}
  
  public void Ox(int paramInt) {}
  
  public void bYc() {}
  
  public void dIA() {}
  
  public void dIz() {}
  
  public void destroy() {}
  
  public void hG(int paramInt1, int paramInt2) {}
  
  public void hH(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void w(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void x(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void y(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
  public static final class a
  {
    public static c.b A(List<h> paramList1, final List<h> paramList2)
    {
      AppMethodBeat.i(119206);
      d.g.b.k.h(paramList1, "oldItems");
      d.g.b.k.h(paramList2, "newItems");
      paramList1 = c.a((c.a)new a(paramList1, paramList2), false);
      d.g.b.k.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(119206);
      return paramList1;
    }
    
    public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      d.g.b.k.h(paramString, "username");
      b localb = new b("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
      localObject1 = (Iterable)j.b.dHd().bM(paramString, paramBoolean);
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
        localObject1 = paramArrayList.dKH();
        if ((((czd)localObject1).Era != null) && (((czd)localObject1).Era.DaC.size() != 0))
        {
          localObject2 = h.yhK;
          localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.yhM));
          ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((cym)((czd)localObject1).Era.DaC.get(0)).DMQ + ' ' + "and " + ((cym)((czd)localObject1).Era.DaC.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localb.agL();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static h bJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119201);
      d.g.b.k.h(paramString, "username");
      ad.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
      Object localObject1 = com.tencent.mm.plugin.story.f.k.yfq;
      paramString = com.tencent.mm.plugin.story.f.k.arp(paramString);
      int i;
      if (paramString.field_syncId == 0L) {
        i = 1;
      }
      while (i == 0) {
        if (paramBoolean)
        {
          localObject1 = h.yhK;
          d.g.b.k.h(paramString, "extInfo");
          localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
          Object localObject2 = j.b.dHd().tW(paramString.field_syncId);
          localObject1 = new com.tencent.mm.plugin.story.i.j();
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
          Object localObject3 = q.yfy;
          localObject3 = q.a.dHx();
          ((czd)localObject3).mAQ = paramString.getUserName();
          ((czd)localObject3).CreateTime = paramString.field_storyPostTime;
          Object localObject4 = q.yfy;
          localObject4 = new cym();
          ((cym)localObject4).Id = ("empty_" + ce.asR());
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).dKH();
            if ((localObject2 != null) && (((czd)localObject2).Erc == 0))
            {
              ((cym)localObject4).DMQ = paramString.cmT();
              ((cym)localObject4).Url = paramString.dKy();
            }
          }
          ((czd)localObject3).Era.DaC.add(localObject4);
          ((com.tencent.mm.plugin.story.i.j)localObject1).c((czd)localObject3);
          paramString = new h((com.tencent.mm.plugin.story.i.j)localObject1, (czd)localObject3);
          AppMethodBeat.o(119201);
          return paramString;
          i = 0;
        }
        else
        {
          localObject1 = h.yhK;
          paramString = h.a.a(paramString);
          AppMethodBeat.o(119201);
          return paramString;
        }
      }
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<h> bK(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      d.g.b.k.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHd();
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
        paramBoolean = bt.kU(j.b.dta(), paramString);
        i = ce.asT();
        localObject2 = com.tencent.mm.plugin.story.f.i.yeK;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.dGU());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.dGU(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          czd localczd = ((com.tencent.mm.plugin.story.i.j)localObject2).dKH();
          if ((localczd.Era != null) && (localczd.Era.DaC.size() != 0))
          {
            h.a locala = h.yhK;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((cym)localczd.Era.DaC.get(0)).DMQ + ' ' + "and " + ((cym)localczd.Era.DaC.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).dKJ().gll + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHd();
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
        paramBoolean = bt.kU(j.b.dta(), paramString);
        i = ce.asT();
        localObject2 = com.tencent.mm.plugin.story.f.i.yeK;
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
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHd();
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, bt.kU(j.b.dta(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, bt.kU(j.b.dta(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          czd localczd = ((com.tencent.mm.plugin.story.i.j)localObject2).dKH();
          if ((localczd.Era != null) && (localczd.Era.DaC.size() != 0))
          {
            h.a locala = h.yhK;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((cym)localczd.Era.DaC.get(0)).DMQ + ' ' + "and " + ((cym)localczd.Era.DaC.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).dKJ().gll + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
        localObject1 = j.b.dHd();
        localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<h> js(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      d.g.b.k.h(paramString1, "username");
      d.g.b.k.h(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.yef;
      int i = a.a.ark(paramString2);
      paramString2 = com.tencent.mm.plugin.story.f.j.yfh;
      paramString2 = j.b.dHd().eG(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
        czd localczd = ((com.tencent.mm.plugin.story.i.j)localObject).dKH();
        if ((localczd.Era != null) && (localczd.Era.DaC.size() != 0))
        {
          h.a locala = h.yhK;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
          ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((cym)localczd.Era.DaC.get(0)).DMQ + ' ' + "and " + ((cym)localczd.Era.DaC.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class a
      extends c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final boolean H(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((h)this.ykx.get(paramInt1)).dAu == ((h)paramList2.get(paramInt2)).dAu)
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
        boolean bool = d.g.b.k.g((h)this.ykx.get(paramInt1), (h)paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
      
      public final int gR()
      {
        AppMethodBeat.i(119197);
        int i = this.ykx.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final int gS()
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