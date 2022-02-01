package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.b;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f
{
  public static final a APr = new a((byte)0);
  static final String TAG = "MicroMsg.Gallery.GalleryController";
  
  public void Sh(int paramInt) {}
  
  public void Sl(int paramInt) {}
  
  public void Sm(int paramInt) {}
  
  public void cjS() {}
  
  public void destroy() {}
  
  public void ejp() {}
  
  public void ejq() {}
  
  public void ig(int paramInt1, int paramInt2) {}
  
  public void ih(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void w(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void x(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void y(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
  public static final class a
  {
    public static c.b A(List<h> paramList1, final List<h> paramList2)
    {
      AppMethodBeat.i(119206);
      p.h(paramList1, "oldItems");
      p.h(paramList2, "newItems");
      paramList1 = c.a((c.a)new a(paramList1, paramList2), false);
      p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(119206);
      return paramList1;
    }
    
    public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      p.h(paramString, "username");
      b localb = new b("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
      localObject1 = (Iterable)j.b.ehT().ca(paramString, paramBoolean);
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
        localObject1 = paramArrayList.elx();
        if ((((dkc)localObject1).HyN != null) && (((dkc)localObject1).HyN.GaQ.size() != 0))
        {
          localObject2 = h.AMF;
          localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.AMH));
          ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((djl)((dkc)localObject1).HyN.GaQ.get(0)).GSI + ' ' + "and " + ((djl)((dkc)localObject1).HyN.GaQ.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localb.akO();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static h bX(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119201);
      p.h(paramString, "username");
      ad.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
      Object localObject1 = com.tencent.mm.plugin.story.f.k.AKk;
      paramString = com.tencent.mm.plugin.story.f.k.aBD(paramString);
      int i;
      if (paramString.field_syncId == 0L) {
        i = 1;
      }
      while (i == 0) {
        if (paramBoolean)
        {
          localObject1 = h.AMF;
          p.h(paramString, "extInfo");
          localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
          Object localObject2 = j.b.ehT().AX(paramString.field_syncId);
          localObject1 = new com.tencent.mm.plugin.story.i.j();
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
          Object localObject3 = q.AKs;
          localObject3 = q.a.ein();
          ((dkc)localObject3).nDo = paramString.getUserName();
          ((dkc)localObject3).CreateTime = paramString.field_storyPostTime;
          Object localObject4 = q.AKs;
          localObject4 = new djl();
          ((djl)localObject4).Id = ("empty_" + cf.aCL());
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).elx();
            if ((localObject2 != null) && (((dkc)localObject2).HyP == 0))
            {
              ((djl)localObject4).GSI = paramString.akW();
              ((djl)localObject4).Url = paramString.elo();
            }
          }
          ((dkc)localObject3).HyN.GaQ.add(localObject4);
          ((com.tencent.mm.plugin.story.i.j)localObject1).c((dkc)localObject3);
          paramString = new h((com.tencent.mm.plugin.story.i.j)localObject1, (dkc)localObject3);
          AppMethodBeat.o(119201);
          return paramString;
          i = 0;
        }
        else
        {
          localObject1 = h.AMF;
          paramString = h.a.a(paramString);
          AppMethodBeat.o(119201);
          return paramString;
        }
      }
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<h> bY(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      p.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehT();
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
        paramBoolean = bt.lQ(j.b.dTJ(), paramString);
        i = cf.aCN();
        localObject2 = com.tencent.mm.plugin.story.f.i.AJE;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.ehK());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.ehK(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dkc localdkc = ((com.tencent.mm.plugin.story.i.j)localObject2).elx();
          if ((localdkc.HyN != null) && (localdkc.HyN.GaQ.size() != 0))
          {
            h.a locala = h.AMF;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((djl)localdkc.HyN.GaQ.get(0)).GSI + ' ' + "and " + ((djl)localdkc.HyN.GaQ.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).elz().hfV + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehT();
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
        paramBoolean = bt.lQ(j.b.dTJ(), paramString);
        i = cf.aCN();
        localObject2 = com.tencent.mm.plugin.story.f.i.AJE;
      }
      AppMethodBeat.o(119202);
      return localArrayList;
    }
    
    public static ArrayList<h> i(String paramString, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(119203);
      p.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehT();
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, bt.lQ(j.b.dTJ(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, bt.lQ(j.b.dTJ(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dkc localdkc = ((com.tencent.mm.plugin.story.i.j)localObject2).elx();
          if ((localdkc.HyN != null) && (localdkc.HyN.GaQ.size() != 0))
          {
            h.a locala = h.AMF;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((djl)localdkc.HyN.GaQ.get(0)).GSI + ' ' + "and " + ((djl)localdkc.HyN.GaQ.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).elz().hfV + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.AKb;
        localObject1 = j.b.ehT();
        localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<h> kf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      p.h(paramString1, "username");
      p.h(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.AIZ;
      int i = a.a.aBy(paramString2);
      paramString2 = com.tencent.mm.plugin.story.f.j.AKb;
      paramString2 = j.b.ehT().fg(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
        dkc localdkc = ((com.tencent.mm.plugin.story.i.j)localObject).elx();
        if ((localdkc.HyN != null) && (localdkc.HyN.GaQ.size() != 0))
        {
          h.a locala = h.AMF;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
          ad.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((djl)localdkc.HyN.GaQ.get(0)).GSI + ' ' + "and " + ((djl)localdkc.HyN.GaQ.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
    public static final class a
      extends c.a
    {
      a(List paramList1, List paramList2) {}
      
      public final int aA()
      {
        AppMethodBeat.i(119198);
        int i = paramList2.size();
        AppMethodBeat.o(119198);
        return i;
      }
      
      public final int az()
      {
        AppMethodBeat.i(119197);
        int i = this.APs.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final boolean i(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((h)this.APs.get(paramInt1)).dKt == ((h)paramList2.get(paramInt2)).dKt)
        {
          AppMethodBeat.o(119199);
          return true;
        }
        AppMethodBeat.o(119199);
        return false;
      }
      
      public final boolean j(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119200);
        boolean bool = p.i((h)this.APs.get(paramInt1), (h)paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f
 * JD-Core Version:    0.7.0.1
 */