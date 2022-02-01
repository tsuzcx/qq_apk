package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f
{
  public static final a BgS = new a((byte)0);
  static final String TAG = "MicroMsg.Gallery.GalleryController";
  
  public void SO(int paramInt) {}
  
  public void SS(int paramInt) {}
  
  public void ST(int paramInt) {}
  
  public void cli() {}
  
  public void destroy() {}
  
  public void emX() {}
  
  public void emY() {}
  
  public void ij(int paramInt1, int paramInt2) {}
  
  public void ik(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  public void w(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void x(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void y(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
  public static final class a
  {
    public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      p.h(paramString, "username");
      b localb = new b("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
      localObject1 = (Iterable)j.b.elB().ce(paramString, paramBoolean);
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
        localObject1 = paramArrayList.epg();
        if ((((dkx)localObject1).HSy != null) && (((dkx)localObject1).HSy.Gtx.size() != 0))
        {
          localObject2 = h.Beh;
          localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.Bej));
          ae.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((dkg)((dkx)localObject1).HSy.Gtx.get(0)).Hmj + ' ' + "and " + ((dkg)((dkx)localObject1).HSy.Gtx.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localb.ald();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static h cb(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119201);
      p.h(paramString, "username");
      ae.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
      Object localObject1 = com.tencent.mm.plugin.story.f.k.BbN;
      paramString = com.tencent.mm.plugin.story.f.k.aCW(paramString);
      int i;
      if (paramString.field_syncId == 0L) {
        i = 1;
      }
      while (i == 0) {
        if (paramBoolean)
        {
          localObject1 = h.Beh;
          p.h(paramString, "extInfo");
          localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
          Object localObject2 = j.b.elB().Bv(paramString.field_syncId);
          localObject1 = new com.tencent.mm.plugin.story.i.j();
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
          ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
          Object localObject3 = q.BbV;
          localObject3 = q.a.elV();
          ((dkx)localObject3).nIJ = paramString.getUserName();
          ((dkx)localObject3).CreateTime = paramString.field_storyPostTime;
          Object localObject4 = q.BbV;
          localObject4 = new dkg();
          ((dkg)localObject4).Id = ("empty_" + ch.aDb());
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).epg();
            if ((localObject2 != null) && (((dkx)localObject2).HSA == 0))
            {
              ((dkg)localObject4).Hmj = paramString.all();
              ((dkg)localObject4).Url = paramString.eoX();
            }
          }
          ((dkx)localObject3).HSy.Gtx.add(localObject4);
          ((com.tencent.mm.plugin.story.i.j)localObject1).c((dkx)localObject3);
          paramString = new h((com.tencent.mm.plugin.story.i.j)localObject1, (dkx)localObject3);
          AppMethodBeat.o(119201);
          return paramString;
          i = 0;
        }
        else
        {
          localObject1 = h.Beh;
          paramString = h.a.a(paramString);
          AppMethodBeat.o(119201);
          return paramString;
        }
      }
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<h> cc(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      p.h(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elB();
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
        paramBoolean = bu.lX(j.b.dXj(), paramString);
        i = ch.aDd();
        localObject2 = com.tencent.mm.plugin.story.f.i.Bbh;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.els());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.els(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dkx localdkx = ((com.tencent.mm.plugin.story.i.j)localObject2).epg();
          if ((localdkx.HSy != null) && (localdkx.HSy.Gtx.size() != 0))
          {
            h.a locala = h.Beh;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ae.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((dkg)localdkx.HSy.Gtx.get(0)).Hmj + ' ' + "and " + ((dkg)localdkx.HSy.Gtx.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).epi().hiJ + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elB();
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
        paramBoolean = bu.lX(j.b.dXj(), paramString);
        i = ch.aDd();
        localObject2 = com.tencent.mm.plugin.story.f.i.Bbh;
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
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elB();
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      }
      for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, bu.lX(j.b.dXj(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, bu.lX(j.b.dXj(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
          dkx localdkx = ((com.tencent.mm.plugin.story.i.j)localObject2).epg();
          if ((localdkx.HSy != null) && (localdkx.HSy.Gtx.size() != 0))
          {
            h.a locala = h.Beh;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
            ae.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((dkg)localdkx.HSy.Gtx.get(0)).Hmj + ' ' + "and " + ((dkg)localdkx.HSy.Gtx.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).epi().hiJ + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
          }
        }
        localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
        localObject1 = j.b.elB();
        localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<h> km(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      p.h(paramString1, "username");
      p.h(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.BaC;
      int i = a.a.aCR(paramString2);
      paramString2 = com.tencent.mm.plugin.story.f.j.BbE;
      paramString2 = j.b.elB().fp(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
        dkx localdkx = ((com.tencent.mm.plugin.story.i.j)localObject).epg();
        if ((localdkx.HSy != null) && (localdkx.HSy.Gtx.size() != 0))
        {
          h.a locala = h.Beh;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
          ae.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((dkg)localdkx.HSy.Gtx.get(0)).Hmj + ' ' + "and " + ((dkg)localdkx.HSy.Gtx.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    public static c.b z(List<h> paramList1, final List<h> paramList2)
    {
      AppMethodBeat.i(119206);
      p.h(paramList1, "oldItems");
      p.h(paramList2, "newItems");
      paramList1 = c.a((c.a)new a(paramList1, paramList2), false);
      p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
      AppMethodBeat.o(119206);
      return paramList1;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
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
        int i = this.BgT.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final boolean i(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((h)this.BgT.get(paramInt1)).dLI == ((h)paramList2.get(paramInt2)).dLI)
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
        boolean bool = p.i((h)this.BgT.get(paramInt1), (h)paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f
 * JD-Core Version:    0.7.0.1
 */