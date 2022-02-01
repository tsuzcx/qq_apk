package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.eob;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.d;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  public static final a LGO;
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118755);
    LGO = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static long a(com.tencent.mm.plugin.story.i.j paramj, eob parameob, int paramInt)
    {
      AppMethodBeat.i(118743);
      p.k(paramj, "storyInfo");
      p.k(parameob, "storyObj");
      long l;
      if ((parameob.UqL == null) || (parameob.UqL.Tkb == null))
      {
        Log.i(n.access$getTAG$cp(), "object desc is null");
        l = parameob.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = parameob.UqL.Tkb.toByteArray();
      p.j(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.LGQ;
      localObject2 = q.a.bdf((String)localObject1);
      if ((Util.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = parameob.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((eol)localObject2))
      {
        l = parameob.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Log.d(n.access$getTAG$cp(), "from server xml ok " + parameob.Id + " \n " + (String)localObject1);
      parameob.UqL.dc(new byte[0]);
      paramj.field_userName = parameob.UserName;
      paramj.field_createTime = parameob.CreateTime;
      paramj.field_storyID = parameob.Id;
      paramj.field_attrBuf = parameob.toByteArray();
      if (parameob.UqP == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
        paramj.ait(com.tencent.mm.plugin.story.i.a.gfB());
        if (parameob.UqI != 1) {
          break label362;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
        paramj.ait(com.tencent.mm.plugin.story.i.a.gfC());
      }
      for (;;)
      {
        paramj.field_favoriteTime = parameob.UqQ;
        paramj.addSourceFlag(paramInt);
        localObject1 = paramj.ggc();
        ((eol)localObject1).UserName = parameob.UserName;
        paramj.b((eol)localObject1);
        Log.d(n.access$getTAG$cp(), "will replaceUserByPcId " + parameob.Id);
        localObject1 = j.LGA;
        j.b.gcw().e(paramj);
        l = parameob.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
        paramj.aiu(com.tencent.mm.plugin.story.i.a.gfB());
        break;
        label362:
        localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
        paramj.aiu(com.tencent.mm.plugin.story.i.a.gfC());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, eob parameob, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      p.k(paramString, "username");
      if (paramBoolean)
      {
        parameob = j.LGA;
        j.b.gcw().U(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.LGA;
      Object localObject2 = j.b.gcw().RR(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.LGA;
      if (Util.isEqual(paramString, j.b.fOo()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        paramInt = com.tencent.mm.plugin.story.i.a.gfc();
        ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(paramInt);
        if (parameob == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, parameob, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.LPG;
        paramInt = com.tencent.mm.plugin.story.i.a.gfd();
        break;
        label157:
        paramString = j.LGA;
        ((com.tencent.mm.plugin.story.i.j)localObject1).fWh = j.b.gcw().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static void ai(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      Log.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.LPG;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.gfq()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = com.tencent.mm.kernel.h.aHF();
      p.j(localObject, "MMKernel.network()");
      ((c)localObject).aGY().b((com.tencent.mm.an.q)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static void aic(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.LGA;
      Object localObject5 = j.b.gcw().aiv(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.LFy;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label121:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.v((Integer)localObject1);
        localObject1 = j.LGA;
        j.b.gcw().agJ(paramInt);
        localObject1 = n.LGO;
        localObject1 = j.LGA;
        localj = bdd(j.b.fOo());
        localObject6 = localj.ggc();
        localObject1 = ((eol)localObject6).Ura;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((enl)localObject1).Sqr;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = (enu)kotlin.a.j.M((List)localObject1, 0);
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((enu)localObject1).TDF;
        localObject2 = ((eol)localObject6).Ura;
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = ((enl)localObject2).Sqr;
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = (enu)kotlin.a.j.M((List)localObject2, 0);
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = ((enu)localObject2).Url;
        label161:
        localObject6 = ((eol)localObject6).Ura;
        if (localObject6 == null) {
          break label344;
        }
        localObject6 = ((enl)localObject6).Sqr;
        if (localObject6 == null) {
          break label344;
        }
        localObject6 = (enu)kotlin.a.j.M((List)localObject6, 0);
        if (localObject6 == null) {
          break label344;
        }
      }
      label334:
      label339:
      label344:
      for (float f = ((enu)localObject6).UqC;; f = 0.0F)
      {
        localObject6 = k.LGJ;
        localObject6 = j.LGA;
        k.a(j.b.fOo(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.LGA;
        localObject2 = j.b.gcB().bdC((String)localObject4);
        if (localObject2 == null) {
          break label384;
        }
        ((com.tencent.mm.plugin.story.i.h)localObject2).field_count -= 1;
        if (((com.tencent.mm.plugin.story.i.h)localObject2).field_count > 0) {
          break label349;
        }
        localObject1 = j.LGA;
        localObject1 = j.b.gcB();
        p.k(localObject4, "date");
        ((i)localObject1).db.delete(i.Alf, "date=?", new String[] { String.valueOf(localObject4) });
        AppMethodBeat.o(118746);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label121;
        localObject2 = null;
        break label161;
      }
      label349:
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = ((com.tencent.mm.plugin.story.i.j)localObject5).field_userName;
      }
      if ((localObject1 == null) || (localObject4 == null)) {}
      for (;;)
      {
        localObject1 = j.LGA;
        j.b.gcB().a((com.tencent.mm.plugin.story.i.h)localObject2);
        label384:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.LGA;
        localObject3 = j.b.gcw();
        localObject5 = com.tencent.mm.plugin.story.e.a.LFy;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).gr((String)localObject1, com.tencent.mm.plugin.story.e.a.a.bcR((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.LPG;
          ((com.tencent.mm.plugin.story.i.j)localObject3).addSourceFlag(com.tencent.mm.plugin.story.i.a.gfe());
          localObject3 = j.LGA;
          j.b.gcw().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          Log.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void aj(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.LGA;
      localObject = j.b.gcw();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.Alf + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      Log.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.Alf, str);
      AppMethodBeat.o(118754);
    }
    
    public static void b(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
    {
      AppMethodBeat.i(118748);
      p.k(paramList, "idList");
      p.k(paramList1, "localIdList");
      Log.i(n.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((Collection)paramList1);
      paramList1 = new ArrayList();
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          long l = ((Number)paramList.next()).longValue();
          Log.d(n.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.LPG;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.gft(), i));
        }
      }
      paramList = com.tencent.mm.kernel.h.aHF();
      p.j(paramList, "MMKernel.network()");
      paramList.aGY().b((com.tencent.mm.an.q)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
    }
    
    public static com.tencent.mm.plugin.story.i.j bdd(String paramString)
    {
      AppMethodBeat.i(118753);
      p.k(paramString, "username");
      Object localObject = j.LGA;
      localObject = j.b.gcw();
      j.b localb = j.LGA;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).cL(paramString, Util.isEqual(j.b.fOo(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> c(String paramString, List<? extends eob> paramList, int paramInt)
    {
      AppMethodBeat.i(118742);
      p.k(paramString, "userName");
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramString = new LinkedList();
        AppMethodBeat.o(118742);
        return paramString;
      }
      LinkedList localLinkedList = new LinkedList();
      paramString = j.LGA;
      com.tencent.mm.plugin.story.i.k localk = j.b.gcw();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        eob localeob = (eob)paramList.get(i);
        Log.d(n.access$getTAG$cp(), "storyObj.id:" + localeob.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.RR(localeob.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localeob, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
          localLinkedList.add(paramString);
        }
        i += 1;
      }
      AppMethodBeat.o(118742);
      return localLinkedList;
    }
    
    public static void c(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(118747);
      Log.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        Object localObject = com.tencent.mm.plugin.story.i.a.LPG;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.gfs(), paramInt, paramBoolean2));
        localObject = com.tencent.mm.kernel.h.aHF();
        p.j(localObject, "MMKernel.network()");
        ((c)localObject).aGY().b((com.tencent.mm.an.q)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static void gcP()
    {
      AppMethodBeat.i(118751);
      c localc = com.tencent.mm.kernel.h.aHF();
      p.j(localc, "MMKernel.network()");
      localc.aGY().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static boolean gq(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      p.k(paramString, "userName");
      boolean bool = false;
      Object localObject = j.LGA;
      localObject = j.b.gcw();
      j.b localb = j.LGA;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, Util.isEqual(paramString, j.b.fOo()), paramInt, true)).iterator();
      while (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).ggc();
        if ((((eol)localObject).Ura != null) && (((eol)localObject).Ura.Sqr.size() != 0)) {
          bool = true;
        }
      }
      AppMethodBeat.o(118744);
      return bool;
    }
    
    public static void km(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      Log.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.LGA;
      localObject = j.b.gcw();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).aiv(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.LPG;
          localj.ait(com.tencent.mm.plugin.story.i.a.gfB());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((IAutoDBItem)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.LPG;
          localj.aiu(com.tencent.mm.plugin.story.i.a.gfB());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void kn(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      Log.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.LGA;
      localObject = j.b.gcw();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).aiv(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.LPG;
          localj.ait(com.tencent.mm.plugin.story.i.a.gfC());
        }
        for (localj.field_favoriteTime = cm.bfF();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((IAutoDBItem)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.LPG;
          localj.aiu(com.tencent.mm.plugin.story.i.a.gfC());
        }
      }
      AppMethodBeat.o(118750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.n
 * JD-Core Version:    0.7.0.1
 */