package com.tencent.mm.plugin.story.f;

import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.d.h;
import com.tencent.mm.plugin.story.model.d.h.a;
import com.tencent.mm.plugin.story.model.p;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", "index", "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  public static final a SoU = new a((byte)0);
  private static final String TAG = "MicroMsg.Gallery.GalleryController";
  
  public void M(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void N(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void O(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void aWi() {}
  
  public void anf(int paramInt) {}
  
  public void anj(int paramInt) {}
  
  public void ank(int paramInt) {}
  
  public void destroy() {}
  
  public void hxm() {}
  
  public void hxn() {}
  
  public void ma(int paramInt1, int paramInt2) {}
  
  public void mb(int paramInt1, int paramInt2) {}
  
  public void pause() {}
  
  public void resume() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static g.b M(List<h> paramList1, final List<h> paramList2)
    {
      AppMethodBeat.i(367005);
      s.u(paramList1, "oldItems");
      s.u(paramList2, "newItems");
      paramList1 = g.a((g.a)new a(paramList1, paramList2), false);
      s.s(paramList1, "oldItems: List<StoryGall…  }\n            }, false)");
      AppMethodBeat.o(367005);
      return paramList1;
    }
    
    public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
    {
      AppMethodBeat.i(119205);
      s.u(paramString, "username");
      c localc = new c("getGalleryItemsFromDbByStoryId");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = StoryCore.SjP;
      localObject1 = (Iterable)StoryCore.b.hvR().dq(paramString, paramBoolean);
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      label130:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        com.tencent.mm.plugin.story.h.j localj = (com.tencent.mm.plugin.story.h.j)localObject2;
        if (paramArrayList == null) {}
        for (paramBoolean = true;; paramBoolean = paramArrayList.contains(Long.valueOf(localj.field_storyID)))
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
        paramArrayList = (com.tencent.mm.plugin.story.h.j)paramString.next();
        localObject1 = paramArrayList.hzt();
        if ((((fjj)localObject1).abJZ != null) && (((fjj)localObject1).abJZ.Zpr.size() != 0))
        {
          localObject2 = h.Smn;
          localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.model.d.i.Smu));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((fis)((fjj)localObject1).abJZ.Zpr.get(0)).aaTl + " and " + ((fis)((fjj)localObject1).abJZ.Zpr.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
        }
      }
      localc.bbW();
      AppMethodBeat.o(119205);
      return localArrayList;
    }
    
    public static h dn(String paramString, boolean paramBoolean)
    {
      int j = 1;
      AppMethodBeat.i(119201);
      s.u(paramString, "username");
      Log.i(f.access$getTAG$cp(), s.X("LogStory: loadSyncData ", paramString));
      Object localObject1 = com.tencent.mm.plugin.story.model.j.Skm;
      paramString = com.tencent.mm.plugin.story.model.j.bbJ(paramString);
      Object localObject3;
      Object localObject4;
      if (paramString.field_syncId == 0L)
      {
        i = 1;
        if (i != 0) {
          break label299;
        }
        if (!paramBoolean) {
          break label281;
        }
        localObject1 = h.Smn;
        s.u(paramString, "extInfo");
        localObject1 = StoryCore.SjP;
        Object localObject2 = StoryCore.b.hvR().wd(paramString.field_syncId);
        localObject1 = new com.tencent.mm.plugin.story.h.j();
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID = paramString.field_syncId;
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = paramString.field_storyPostTime;
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = paramString.getUserName();
        localObject3 = p.Sku;
        localObject3 = p.a.hwl();
        ((fjj)localObject3).UserName = paramString.getUserName();
        ((fjj)localObject3).CreateTime = paramString.field_storyPostTime;
        localObject4 = p.Sku;
        localObject4 = new fis();
        ((fis)localObject4).Id = s.X("empty_", Long.valueOf(cn.bDv()));
        if (localObject2 == null) {
          break label276;
        }
        localObject2 = ((com.tencent.mm.plugin.story.h.j)localObject2).hzt();
        if ((localObject2 == null) || (((fjj)localObject2).abKb != 0)) {
          break label276;
        }
      }
      label276:
      for (int i = j;; i = 0)
      {
        if (i != 0)
        {
          ((fis)localObject4).aaTl = paramString.eCi();
          ((fis)localObject4).Url = paramString.hzk();
        }
        ((fjj)localObject3).abJZ.Zpr.add(localObject4);
        ((com.tencent.mm.plugin.story.h.j)localObject1).c((fjj)localObject3);
        paramString = new h((com.tencent.mm.plugin.story.h.j)localObject1, (fjj)localObject3);
        AppMethodBeat.o(119201);
        return paramString;
        i = 0;
        break;
      }
      label281:
      localObject1 = h.Smn;
      paramString = h.a.a(paramString);
      AppMethodBeat.o(119201);
      return paramString;
      label299:
      AppMethodBeat.o(119201);
      return null;
    }
    
    public static ArrayList<h> jdMethod_do(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(119202);
      s.u(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      int i;
      if (paramBoolean)
      {
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvR();
        localObject2 = StoryCore.SjP;
        paramBoolean = Util.isEqual(StoryCore.b.hgg(), paramString);
        i = cn.getSyncServerTimeSecond();
        localObject2 = com.tencent.mm.plugin.story.model.i.SjL;
      }
      for (Object localObject1 = ((k)localObject1).l(paramString, paramBoolean, i - com.tencent.mm.plugin.story.model.i.hvz());; localObject1 = ((k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.model.i.hvz(), true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
          fjj localfjj = ((com.tencent.mm.plugin.story.h.j)localObject2).hzt();
          if ((localfjj.abJZ != null) && (localfjj.abJZ.Zpr.size() != 0))
          {
            h.a locala = h.Smn;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.h.j)localObject2));
            Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + " content " + ((fis)localfjj.abJZ.Zpr.get(0)).aaTl + " and " + ((fis)localfjj.abJZ.Zpr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.h.j)localObject2).hzv().nrQ + " flag:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
          }
        }
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvR();
        localObject2 = StoryCore.SjP;
        paramBoolean = Util.isEqual(StoryCore.b.hgg(), paramString);
        i = cn.getSyncServerTimeSecond();
        localObject2 = com.tencent.mm.plugin.story.model.i.SjL;
      }
      AppMethodBeat.o(119202);
      return localArrayList;
    }
    
    public static ArrayList<h> k(String paramString, boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(119203);
      s.u(paramString, "username");
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (paramBoolean)
      {
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvR();
        localObject2 = StoryCore.SjP;
      }
      for (Object localObject1 = ((k)localObject1).l(paramString, Util.isEqual(StoryCore.b.hgg(), paramString), paramInt);; localObject1 = ((k)localObject1).a(paramString, Util.isEqual(StoryCore.b.hgg(), paramString), paramInt, true))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
          fjj localfjj = ((com.tencent.mm.plugin.story.h.j)localObject2).hzt();
          if ((localfjj.abJZ != null) && (localfjj.abJZ.Zpr.size() != 0))
          {
            h.a locala = h.Smn;
            localArrayList.add(h.a.b((com.tencent.mm.plugin.story.h.j)localObject2));
            Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + " content " + ((fis)localfjj.abJZ.Zpr.get(0)).aaTl + " and " + ((fis)localfjj.abJZ.Zpr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.h.j)localObject2).hzv().nrQ + " flag:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
          }
        }
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvR();
        localObject2 = StoryCore.SjP;
      }
      AppMethodBeat.o(119203);
      return localArrayList;
    }
    
    public static ArrayList<h> nf(String paramString1, String paramString2)
    {
      AppMethodBeat.i(119204);
      s.u(paramString1, "username");
      s.u(paramString2, "date");
      ArrayList localArrayList = new ArrayList();
      Object localObject = a.Sjk;
      int i = a.a.bbF(paramString2);
      paramString2 = StoryCore.SjP;
      paramString2 = StoryCore.b.hvR().hl(paramString1, i).iterator();
      while (paramString2.hasNext())
      {
        localObject = (com.tencent.mm.plugin.story.h.j)paramString2.next();
        fjj localfjj = ((com.tencent.mm.plugin.story.h.j)localObject).hzt();
        if ((localfjj.abJZ != null) && (localfjj.abJZ.Zpr.size() != 0))
        {
          h.a locala = h.Smn;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.h.j)localObject));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + " content " + ((fis)localfjj.abJZ.Zpr.get(0)).aaTl + " and " + ((fis)localfjj.abJZ.Zpr.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject).field_userName);
        }
      }
      AppMethodBeat.o(119204);
      return localArrayList;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends g.a
    {
      a(List<h> paramList1, List<h> paramList2) {}
      
      public final int If()
      {
        AppMethodBeat.i(119197);
        int i = this.SoV.size();
        AppMethodBeat.o(119197);
        return i;
      }
      
      public final int Ig()
      {
        AppMethodBeat.i(119198);
        int i = paramList2.size();
        AppMethodBeat.o(119198);
        return i;
      }
      
      public final boolean aU(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119199);
        if (((h)this.SoV.get(paramInt1)).idH == ((h)paramList2.get(paramInt2)).idH)
        {
          AppMethodBeat.o(119199);
          return true;
        }
        AppMethodBeat.o(119199);
        return false;
      }
      
      public final boolean aV(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(119200);
        boolean bool = s.p(this.SoV.get(paramInt1), paramList2.get(paramInt2));
        AppMethodBeat.o(119200);
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.f
 * JD-Core Version:    0.7.0.1
 */