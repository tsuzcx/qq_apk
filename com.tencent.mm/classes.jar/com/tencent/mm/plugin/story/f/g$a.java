package com.tencent.mm.plugin.story.f;

import a.l;
import android.support.v7.h.c;
import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.a;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.e.b;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.d.h;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "loadSyncData", "plugin-story_release"})
public final class g$a
{
  public static ArrayList<com.tencent.mm.plugin.story.model.d.g> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(138806);
    a.f.b.j.q(paramString, "username");
    a locala = new a("getGalleryItemsFromDbByStoryId");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = (Iterable)j.b.cAB().bC(paramString, paramBoolean);
    paramString = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label130:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      com.tencent.mm.plugin.story.h.j localj = (com.tencent.mm.plugin.story.h.j)localObject2;
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
      paramArrayList = (com.tencent.mm.plugin.story.h.j)paramString.next();
      localObject1 = paramArrayList.cEY();
      if ((((cic)localObject1).xSK != null) && (((cic)localObject1).xSK.wOa.size() != 0))
      {
        localObject2 = com.tencent.mm.plugin.story.model.d.g.syw;
        localArrayList.add(com.tencent.mm.plugin.story.model.d.g.a.a(paramArrayList, h.syy));
        ab.i(g.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((chl)((cic)localObject1).xSK.wOa.get(0)).xrS + ' ' + "and " + ((chl)((cic)localObject1).xSK.wOa.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
      }
    }
    locala.SS();
    AppMethodBeat.o(138806);
    return localArrayList;
  }
  
  public static ArrayList<com.tencent.mm.plugin.story.model.d.g> bA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109585);
    a.f.b.j.q(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    int i;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB();
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      paramBoolean = bo.isEqual(j.b.coK(), paramString);
      i = cb.abr();
      localObject2 = i.suJ;
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.story.h.k)localObject1).i(paramString, paramBoolean, i - i.cAp());; localObject1 = ((com.tencent.mm.plugin.story.h.k)localObject1).a(paramString, paramBoolean, i - i.cAp(), true))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.story.h.j)((Iterator)localObject1).next();
        cic localcic = ((com.tencent.mm.plugin.story.h.j)localObject2).cEY();
        if ((localcic.xSK != null) && (localcic.xSK.wOa.size() != 0))
        {
          com.tencent.mm.plugin.story.model.d.g.a locala = com.tencent.mm.plugin.story.model.d.g.syw;
          localArrayList.add(com.tencent.mm.plugin.story.model.d.g.a.b((com.tencent.mm.plugin.story.h.j)localObject2));
          ab.i(g.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((chl)localcic.xSK.wOa.get(0)).xrS + ' ' + "and " + ((chl)localcic.xSK.wOa.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.h.j)localObject2).cFb().ePG + " flag:" + ((com.tencent.mm.plugin.story.h.j)localObject2).field_localFlag);
        }
      }
      localObject1 = com.tencent.mm.plugin.story.model.j.svi;
      localObject1 = j.b.cAB();
      localObject2 = com.tencent.mm.plugin.story.model.j.svi;
      paramBoolean = bo.isEqual(j.b.coK(), paramString);
      i = cb.abr();
      localObject2 = i.suJ;
    }
    AppMethodBeat.o(109585);
    return localArrayList;
  }
  
  public static com.tencent.mm.plugin.story.model.d.g bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(109584);
    a.f.b.j.q(paramString, "username");
    ab.i(g.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
    Object localObject1 = com.tencent.mm.plugin.story.model.k.svr;
    paramString = com.tencent.mm.plugin.story.model.k.acU(paramString);
    int i;
    if (paramString.field_syncId == 0L) {
      i = 1;
    }
    while (i == 0) {
      if (paramBoolean)
      {
        localObject1 = com.tencent.mm.plugin.story.model.d.g.syw;
        a.f.b.j.q(paramString, "extInfo");
        localObject1 = com.tencent.mm.plugin.story.model.j.svi;
        Object localObject2 = j.b.cAB().mV(paramString.field_syncId);
        localObject1 = new com.tencent.mm.plugin.story.h.j();
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID = paramString.field_syncId;
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = paramString.field_storyPostTime;
        ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = paramString.getUserName();
        Object localObject3 = q.svz;
        localObject3 = q.a.cAY();
        ((cic)localObject3).jJA = paramString.getUserName();
        ((cic)localObject3).CreateTime = paramString.field_storyPostTime;
        Object localObject4 = q.svz;
        localObject4 = new chl();
        ((chl)localObject4).Id = ("empty_" + cb.abq());
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.story.h.j)localObject2).cEY();
          if ((localObject2 != null) && (((cic)localObject2).xSM == 0))
          {
            ((chl)localObject4).xrS = paramString.cER();
            ((chl)localObject4).Url = paramString.cEQ();
          }
        }
        ((cic)localObject3).xSK.wOa.add(localObject4);
        ((com.tencent.mm.plugin.story.h.j)localObject1).c((cic)localObject3);
        paramString = new com.tencent.mm.plugin.story.model.d.g((com.tencent.mm.plugin.story.h.j)localObject1, (cic)localObject3);
        AppMethodBeat.o(109584);
        return paramString;
        i = 0;
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.story.model.d.g.syw;
        paramString = com.tencent.mm.plugin.story.model.d.g.a.a(paramString);
        AppMethodBeat.o(109584);
        return paramString;
      }
    }
    AppMethodBeat.o(109584);
    return null;
  }
  
  public static ArrayList<com.tencent.mm.plugin.story.model.d.g> gO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(109586);
    a.f.b.j.q(paramString1, "username");
    a.f.b.j.q(paramString2, "date");
    ArrayList localArrayList = new ArrayList();
    Object localObject = b.ssx;
    int i = b.a.acL(paramString2);
    paramString2 = com.tencent.mm.plugin.story.model.j.svi;
    paramString2 = j.b.cAB().dy(paramString1, i).iterator();
    while (paramString2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.story.h.j)paramString2.next();
      cic localcic = ((com.tencent.mm.plugin.story.h.j)localObject).cEY();
      if ((localcic.xSK != null) && (localcic.xSK.wOa.size() != 0))
      {
        com.tencent.mm.plugin.story.model.d.g.a locala = com.tencent.mm.plugin.story.model.d.g.syw;
        localArrayList.add(com.tencent.mm.plugin.story.model.d.g.a.b((com.tencent.mm.plugin.story.h.j)localObject));
        ab.i(g.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((chl)localcic.xSK.wOa.get(0)).xrS + ' ' + "and " + ((chl)localcic.xSK.wOa.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.h.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.h.j)localObject).field_userName);
      }
    }
    AppMethodBeat.o(109586);
    return localArrayList;
  }
  
  public static c.b o(List<com.tencent.mm.plugin.story.model.d.g> paramList1, List<com.tencent.mm.plugin.story.model.d.g> paramList2)
  {
    AppMethodBeat.i(109587);
    a.f.b.j.q(paramList1, "oldItems");
    a.f.b.j.q(paramList2, "newItems");
    paramList1 = c.a((c.a)new g.a.a(paramList1, paramList2), false);
    a.f.b.j.p(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
    AppMethodBeat.o(109587);
    return paramList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */