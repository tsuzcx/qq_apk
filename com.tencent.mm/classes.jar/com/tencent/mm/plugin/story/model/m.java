package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.model.a.f;
import com.tencent.mm.plugin.story.model.a.l;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final a Sks;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(118755);
    Sks = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long a(com.tencent.mm.plugin.story.h.j paramj, fiz paramfiz, int paramInt)
    {
      AppMethodBeat.i(118743);
      kotlin.g.b.s.u(paramj, "storyInfo");
      kotlin.g.b.s.u(paramfiz, "storyObj");
      long l;
      if ((paramfiz.abJK == null) || (paramfiz.abJK.aaxD == null))
      {
        Log.i(m.access$getTAG$cp(), "object desc is null");
        l = paramfiz.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = paramfiz.abJK.aaxD.toByteArray();
      kotlin.g.b.s.s(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = p.Sku;
      localObject2 = p.a.bbS((String)localObject1);
      if ((Util.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = paramfiz.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((fjj)localObject2))
      {
        l = paramfiz.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Log.d(m.access$getTAG$cp(), "from server xml ok " + paramfiz.Id + " \n " + (String)localObject1);
      paramfiz.abJK.df(new byte[0]);
      paramj.field_userName = paramfiz.UserName;
      paramj.field_createTime = paramfiz.CreateTime;
      paramj.field_storyID = paramfiz.Id;
      paramj.field_attrBuf = paramfiz.toByteArray();
      if (paramfiz.abJO == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
        paramj.ant(com.tencent.mm.plugin.story.h.a.hyT());
        if (paramfiz.abJH != 1) {
          break label356;
        }
        localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
        paramj.ant(com.tencent.mm.plugin.story.h.a.hyU());
      }
      for (;;)
      {
        paramj.field_favoriteTime = paramfiz.abJP;
        paramj.addSourceFlag(paramInt);
        localObject1 = paramj.hzt();
        ((fjj)localObject1).UserName = paramfiz.UserName;
        paramj.b((fjj)localObject1);
        Log.d(m.access$getTAG$cp(), kotlin.g.b.s.X("will replaceUserByPcId ", Long.valueOf(paramfiz.Id)));
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvR().e(paramj);
        l = paramfiz.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
        paramj.anu(com.tencent.mm.plugin.story.h.a.hyT());
        break;
        label356:
        localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
        paramj.anu(com.tencent.mm.plugin.story.h.a.hyU());
      }
    }
    
    public static com.tencent.mm.plugin.story.h.j a(String paramString, long paramLong, int paramInt, fiz paramfiz, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      kotlin.g.b.s.u(paramString, "username");
      if (paramBoolean)
      {
        paramfiz = StoryCore.SjP;
        StoryCore.b.hvR().aj(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = StoryCore.SjP;
      Object localObject2 = StoryCore.b.hvR().wa(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.h.j();
      }
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = paramString;
      localObject2 = StoryCore.SjP;
      if (Util.isEqual(paramString, StoryCore.b.hgg()))
      {
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        paramInt = com.tencent.mm.plugin.story.h.a.hyu();
        ((com.tencent.mm.plugin.story.h.j)localObject1).addSourceFlag(paramInt);
        if (paramfiz == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.h.j)localObject1, paramfiz, ((com.tencent.mm.plugin.story.h.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.h.a.Sry;
        paramInt = com.tencent.mm.plugin.story.h.a.hyv();
        break;
        label157:
        paramString = StoryCore.SjP;
        ((com.tencent.mm.plugin.story.h.j)localObject1).icg = StoryCore.b.hvR().f((com.tencent.mm.plugin.story.h.j)localObject1);
      }
    }
    
    public static void aA(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      Log.d(m.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      com.tencent.mm.plugin.story.h.a.a locala = com.tencent.mm.plugin.story.h.a.Sry;
      localArrayList1.add(new l(paramLong, com.tencent.mm.plugin.story.h.a.hyI()));
      localArrayList2.add(Integer.valueOf(paramInt));
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)new f((List)localArrayList1, (List)localArrayList2), 0);
      AppMethodBeat.o(118745);
    }
    
    public static void aB(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      String str = "UPDATE " + com.tencent.mm.plugin.story.h.k.ptT + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      Log.d(com.tencent.mm.plugin.story.h.k.TAG, kotlin.g.b.s.X("updateSourceTypeBefore sql ", str));
      ((com.tencent.mm.plugin.story.h.k)localObject).db.execSQL(com.tencent.mm.plugin.story.h.k.ptT, str);
      AppMethodBeat.o(118754);
    }
    
    public static void anc(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = StoryCore.SjP;
      Object localObject5 = StoryCore.b.hvR().anv(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.Sjk;
      Object localObject4;
      com.tencent.mm.plugin.story.h.j localj;
      Object localObject6;
      label86:
      Object localObject2;
      label98:
      float f;
      if (localObject5 == null)
      {
        localObject1 = null;
        localObject4 = com.tencent.mm.plugin.story.e.a.a.C((Integer)localObject1);
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvR().alC(paramInt);
        localObject1 = m.Sks;
        localObject1 = StoryCore.SjP;
        localj = bbQ(StoryCore.b.hgg());
        localObject6 = localj.hzt();
        localObject1 = ((fjj)localObject6).abJZ;
        if (localObject1 != null) {
          break label246;
        }
        localObject1 = null;
        localObject2 = ((fjj)localObject6).abJZ;
        if (localObject2 != null) {
          break label289;
        }
        localObject2 = null;
        localObject6 = ((fjj)localObject6).abJZ;
        if (localObject6 != null) {
          break label332;
        }
        f = 0.0F;
      }
      for (;;)
      {
        localObject6 = j.Skm;
        localObject6 = StoryCore.SjP;
        j.a(StoryCore.b.hgg(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = StoryCore.SjP;
        localObject2 = StoryCore.b.hvW().bco((String)localObject4);
        if (localObject2 == null) {
          break label411;
        }
        ((com.tencent.mm.plugin.story.h.h)localObject2).field_count -= 1;
        if (((com.tencent.mm.plugin.story.h.h)localObject2).field_count > 0) {
          break label382;
        }
        localObject1 = StoryCore.SjP;
        localObject1 = StoryCore.b.hvW();
        kotlin.g.b.s.u(localObject4, "date");
        ((i)localObject1).db.delete(i.ptT, "date=?", new String[] { kotlin.g.b.s.X("", localObject4) });
        AppMethodBeat.o(118746);
        return;
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.h.j)localObject5).field_createTime);
        break;
        label246:
        localObject1 = ((fij)localObject1).Zpr;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label86;
        }
        localObject1 = (fis)kotlin.a.p.ae((List)localObject1, 0);
        if (localObject1 == null)
        {
          localObject1 = null;
          break label86;
        }
        localObject1 = ((fis)localObject1).aaTl;
        break label86;
        label289:
        localObject2 = ((fij)localObject2).Zpr;
        if (localObject2 == null)
        {
          localObject2 = null;
          break label98;
        }
        localObject2 = (fis)kotlin.a.p.ae((List)localObject2, 0);
        if (localObject2 == null)
        {
          localObject2 = null;
          break label98;
        }
        localObject2 = ((fis)localObject2).Url;
        break label98;
        label332:
        localObject6 = ((fij)localObject6).Zpr;
        if (localObject6 == null)
        {
          f = 0.0F;
        }
        else
        {
          localObject6 = (fis)kotlin.a.p.ae((List)localObject6, 0);
          if (localObject6 == null) {
            f = 0.0F;
          } else {
            f = ((fis)localObject6).abJB;
          }
        }
      }
      label382:
      if (localObject5 == null)
      {
        localObject1 = localObject3;
        if ((localObject1 != null) && (localObject4 != null)) {
          break label427;
        }
      }
      for (;;)
      {
        localObject1 = StoryCore.SjP;
        StoryCore.b.hvW().a((com.tencent.mm.plugin.story.h.h)localObject2);
        label411:
        AppMethodBeat.o(118746);
        return;
        localObject1 = ((com.tencent.mm.plugin.story.h.j)localObject5).field_userName;
        break;
        label427:
        localObject3 = StoryCore.SjP;
        localObject3 = StoryCore.b.hvR();
        localObject5 = com.tencent.mm.plugin.story.e.a.Sjk;
        localObject1 = ((com.tencent.mm.plugin.story.h.k)localObject3).hl((String)localObject1, com.tencent.mm.plugin.story.e.a.a.bbF((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.h.a.Sry;
          ((com.tencent.mm.plugin.story.h.j)localObject3).addSourceFlag(com.tencent.mm.plugin.story.h.a.hyw());
          localObject3 = StoryCore.SjP;
          StoryCore.b.hvR().a((int)((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0));
          Log.d(m.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void b(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
    {
      AppMethodBeat.i(118748);
      kotlin.g.b.s.u(paramList, "idList");
      kotlin.g.b.s.u(paramList1, "localIdList");
      Log.i(m.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
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
          Log.d(m.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
          com.tencent.mm.plugin.story.h.a.a locala = com.tencent.mm.plugin.story.h.a.Sry;
          paramList1.add(new com.tencent.mm.plugin.story.model.a.k(l, com.tencent.mm.plugin.story.h.a.hyL(), i));
        }
      }
      com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)new f((List)paramList1, (List)localArrayList), 0);
      AppMethodBeat.o(118748);
    }
    
    public static com.tencent.mm.plugin.story.h.j bbQ(String paramString)
    {
      AppMethodBeat.i(118753);
      kotlin.g.b.s.u(paramString, "username");
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      StoryCore.b localb = StoryCore.SjP;
      paramString = ((com.tencent.mm.plugin.story.h.k)localObject).dr(paramString, Util.isEqual(StoryCore.b.hgg(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static void c(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(118747);
      Log.d(m.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        com.tencent.mm.plugin.story.h.a.a locala = com.tencent.mm.plugin.story.h.a.Sry;
        localArrayList1.add(new com.tencent.mm.plugin.story.model.a.m(paramLong, com.tencent.mm.plugin.story.h.a.hyK(), paramInt, paramBoolean2));
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)new f((List)localArrayList1, (List)localArrayList2), 0);
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.h.j> e(String paramString, List<? extends fiz> paramList, int paramInt)
    {
      AppMethodBeat.i(118742);
      kotlin.g.b.s.u(paramString, "userName");
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramString = new LinkedList();
        AppMethodBeat.o(118742);
        return paramString;
      }
      LinkedList localLinkedList = new LinkedList();
      paramString = StoryCore.SjP;
      com.tencent.mm.plugin.story.h.k localk = StoryCore.b.hvR();
      int i = 0;
      int k = paramList.size() - 1;
      if (k >= 0) {}
      for (;;)
      {
        int j = i + 1;
        fiz localfiz = (fiz)paramList.get(i);
        Log.d(m.access$getTAG$cp(), kotlin.g.b.s.X("storyObj.id:", Long.valueOf(localfiz.Id)));
        com.tencent.mm.plugin.story.h.j localj = localk.wa(localfiz.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.h.j();
        }
        if ((a(paramString, localfiz, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
          localLinkedList.add(paramString);
        }
        if (j > k)
        {
          AppMethodBeat.o(118742);
          return localLinkedList;
        }
        i = j;
      }
    }
    
    public static boolean hk(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      kotlin.g.b.s.u(paramString, "userName");
      boolean bool = false;
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      StoryCore.b localb = StoryCore.SjP;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.h.k)localObject).a(paramString, Util.isEqual(paramString, StoryCore.b.hgg()), paramInt, true)).iterator();
      while (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.h.j)paramString.next()).hzt();
        if ((((fjj)localObject).abJZ != null) && (((fjj)localObject).abJZ.Zpr.size() != 0)) {
          bool = true;
        }
      }
      AppMethodBeat.o(118744);
      return bool;
    }
    
    public static void hwj()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.h.baD().mCm.cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static void lY(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      Log.d(m.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      com.tencent.mm.plugin.story.h.j localj = ((com.tencent.mm.plugin.story.h.k)localObject).anv(paramInt1);
      com.tencent.mm.plugin.story.h.a.a locala;
      if (localj != null)
      {
        if (paramInt2 != 1) {
          break label90;
        }
        locala = com.tencent.mm.plugin.story.h.a.Sry;
        localj.ant(com.tencent.mm.plugin.story.h.a.hyT());
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.story.h.k)localObject).replace((IAutoDBItem)localj);
        AppMethodBeat.o(118749);
        return;
        label90:
        locala = com.tencent.mm.plugin.story.h.a.Sry;
        localj.anu(com.tencent.mm.plugin.story.h.a.hyT());
      }
    }
    
    public static void lZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      Log.d(m.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = StoryCore.SjP;
      localObject = StoryCore.b.hvR();
      com.tencent.mm.plugin.story.h.j localj = ((com.tencent.mm.plugin.story.h.k)localObject).anv(paramInt1);
      com.tencent.mm.plugin.story.h.a.a locala;
      if (localj != null)
      {
        if (paramInt2 != 1) {
          break label97;
        }
        locala = com.tencent.mm.plugin.story.h.a.Sry;
        localj.ant(com.tencent.mm.plugin.story.h.a.hyU());
      }
      for (localj.field_favoriteTime = cn.getSyncServerTimeSecond();; localj.field_favoriteTime = 0)
      {
        ((com.tencent.mm.plugin.story.h.k)localObject).replace((IAutoDBItem)localj);
        AppMethodBeat.o(118750);
        return;
        label97:
        locala = com.tencent.mm.plugin.story.h.a.Sry;
        localj.anu(com.tencent.mm.plugin.story.h.a.hyU());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.m
 * JD-Core Version:    0.7.0.1
 */