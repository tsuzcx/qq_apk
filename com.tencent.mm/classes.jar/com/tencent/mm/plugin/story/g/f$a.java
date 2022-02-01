package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.e.a.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.d.h.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.plugin.story.f.q.a;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "username", "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", "date", "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", "timestamp", "loadSyncData", "plugin-story_release"})
public final class f$a
{
  public static ArrayList<h> b(String paramString, boolean paramBoolean, ArrayList<Long> paramArrayList)
  {
    AppMethodBeat.i(119205);
    p.h(paramString, "username");
    com.tencent.mm.ac.c localc = new com.tencent.mm.ac.c("getGalleryItemsFromDbByStoryId");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = (Iterable)j.b.foc().cw(paramString, paramBoolean);
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
      localObject1 = paramArrayList.frG();
      if ((((eek)localObject1).NeB != null) && (((eek)localObject1).NeB.LoV.size() != 0))
      {
        localObject2 = h.FoY;
        localArrayList.add(h.a.a(paramArrayList, com.tencent.mm.plugin.story.f.d.i.Fpa));
        Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByStoryId story:" + paramArrayList + ", content:" + ((edt)((eek)localObject1).NeB.LoV.get(0)).Msz + ' ' + "and " + ((edt)((eek)localObject1).NeB.LoV.get(0)).Url + ", id:" + paramArrayList.field_storyID + ", storyUsername:" + paramArrayList.field_userName);
      }
    }
    localc.aBw();
    AppMethodBeat.o(119205);
    return localArrayList;
  }
  
  public static h ct(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119201);
    p.h(paramString, "username");
    Log.i(f.access$getTAG$cp(), "LogStory: loadSyncData ".concat(String.valueOf(paramString)));
    Object localObject1 = com.tencent.mm.plugin.story.f.k.FmH;
    paramString = com.tencent.mm.plugin.story.f.k.aRS(paramString);
    int i;
    if (paramString.field_syncId == 0L) {
      i = 1;
    }
    while (i == 0) {
      if (paramBoolean)
      {
        localObject1 = h.FoY;
        p.h(paramString, "extInfo");
        localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
        Object localObject2 = j.b.foc().KA(paramString.field_syncId);
        localObject1 = new com.tencent.mm.plugin.story.i.j();
        ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramString.field_syncId;
        ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramString.field_storyPostTime;
        ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString.getUserName();
        Object localObject3 = q.FmO;
        localObject3 = q.a.fox();
        ((eek)localObject3).UserName = paramString.getUserName();
        ((eek)localObject3).CreateTime = paramString.field_storyPostTime;
        Object localObject4 = q.FmO;
        localObject4 = new edt();
        ((edt)localObject4).Id = ("empty_" + cl.aWz());
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.story.i.j)localObject2).frG();
          if ((localObject2 != null) && (((eek)localObject2).NeD == 0))
          {
            ((edt)localObject4).Msz = paramString.aBE();
            ((edt)localObject4).Url = paramString.frx();
          }
        }
        ((eek)localObject3).NeB.LoV.add(localObject4);
        ((com.tencent.mm.plugin.story.i.j)localObject1).c((eek)localObject3);
        paramString = new h((com.tencent.mm.plugin.story.i.j)localObject1, (eek)localObject3);
        AppMethodBeat.o(119201);
        return paramString;
        i = 0;
      }
      else
      {
        localObject1 = h.FoY;
        paramString = h.a.a(paramString);
        AppMethodBeat.o(119201);
        return paramString;
      }
    }
    AppMethodBeat.o(119201);
    return null;
  }
  
  public static ArrayList<h> cu(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(119202);
    p.h(paramString, "username");
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    int i;
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      paramBoolean = Util.isEqual(j.b.fau(), paramString);
      i = cl.aWB();
      localObject2 = com.tencent.mm.plugin.story.f.i.Fmb;
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.fnT());; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, paramBoolean, i - com.tencent.mm.plugin.story.f.i.fnT(), true))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
        eek localeek = ((com.tencent.mm.plugin.story.i.j)localObject2).frG();
        if ((localeek.NeB != null) && (localeek.NeB.LoV.size() != 0))
        {
          h.a locala = h.FoY;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((edt)localeek.NeB.LoV.get(0)).Msz + ' ' + "and " + ((edt)localeek.NeB.LoV.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).frI().ibG + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
        }
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
      paramBoolean = Util.isEqual(j.b.fau(), paramString);
      i = cl.aWB();
      localObject2 = com.tencent.mm.plugin.story.f.i.Fmb;
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
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    }
    for (Object localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).j(paramString, Util.isEqual(j.b.fau(), paramString), paramInt);; localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject1).a(paramString, Util.isEqual(j.b.fau(), paramString), paramInt, true))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.plugin.story.i.j)((Iterator)localObject1).next();
        eek localeek = ((com.tencent.mm.plugin.story.i.j)localObject2).frG();
        if ((localeek.NeB != null) && (localeek.NeB.LoV.size() != 0))
        {
          h.a locala = h.FoY;
          localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject2));
          Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDb story username " + paramString + ' ' + localArrayList.size() + ' ' + "content " + ((edt)localeek.NeB.LoV.get(0)).Msz + ' ' + "and " + ((edt)localeek.NeB.LoV.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject2).field_userName + " tryCount:" + ((com.tencent.mm.plugin.story.i.j)localObject2).frI().ibG + " flag:" + ((com.tencent.mm.plugin.story.i.j)localObject2).field_localFlag);
        }
      }
      localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
      localObject1 = j.b.foc();
      localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    }
    AppMethodBeat.o(119203);
    return localArrayList;
  }
  
  public static ArrayList<h> la(String paramString1, String paramString2)
  {
    AppMethodBeat.i(119204);
    p.h(paramString1, "username");
    p.h(paramString2, "date");
    ArrayList localArrayList = new ArrayList();
    Object localObject = a.Flw;
    int i = a.a.aRN(paramString2);
    paramString2 = com.tencent.mm.plugin.story.f.j.Fmy;
    paramString2 = j.b.foc().fN(paramString1, i).iterator();
    while (paramString2.hasNext())
    {
      localObject = (com.tencent.mm.plugin.story.i.j)paramString2.next();
      eek localeek = ((com.tencent.mm.plugin.story.i.j)localObject).frG();
      if ((localeek.NeB != null) && (localeek.NeB.LoV.size() != 0))
      {
        h.a locala = h.FoY;
        localArrayList.add(h.a.b((com.tencent.mm.plugin.story.i.j)localObject));
        Log.i(f.access$getTAG$cp(), "getGalleryItemsFromDbByDate story username " + paramString1 + ' ' + localArrayList.size() + ' ' + "content " + ((edt)localeek.NeB.LoV.get(0)).Msz + ' ' + "and " + ((edt)localeek.NeB.LoV.get(0)).Url + " id:" + ((com.tencent.mm.plugin.story.i.j)localObject).field_storyID + " storyUsername: " + ((com.tencent.mm.plugin.story.i.j)localObject).field_userName);
      }
    }
    AppMethodBeat.o(119204);
    return localArrayList;
  }
  
  public static c.b u(List<h> paramList1, final List<h> paramList2)
  {
    AppMethodBeat.i(119206);
    p.h(paramList1, "oldItems");
    p.h(paramList2, "newItems");
    paramList1 = android.support.v7.h.c.a((c.a)new a(paramList1, paramList2), false);
    p.g(paramList1, "DiffUtil.calculateDiff(o…  }\n            }, false)");
    AppMethodBeat.o(119206);
    return paramList1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
  public static final class a
    extends c.a
  {
    a(List paramList1, List paramList2) {}
    
    public final int aB()
    {
      AppMethodBeat.i(119197);
      int i = this.FrK.size();
      AppMethodBeat.o(119197);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(119198);
      int i = paramList2.size();
      AppMethodBeat.o(119198);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(119199);
      if (((h)this.FrK.get(paramInt1)).edx == ((h)paramList2.get(paramInt2)).edx)
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
      boolean bool = p.j((h)this.FrK.get(paramInt1), (h)paramList2.get(paramInt2));
      AppMethodBeat.o(119200);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.f.a
 * JD-Core Version:    0.7.0.1
 */