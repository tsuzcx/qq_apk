package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.n.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  public static final a yfw;
  
  static
  {
    AppMethodBeat.i(118755);
    yfw = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static void Op(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.yfh;
      Object localObject5 = j.b.dHd().OI(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.yef;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label120:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.k((Integer)localObject1);
        localObject1 = j.yfh;
        j.b.dHd().Nf(paramInt);
        localObject1 = n.yfw;
        localObject1 = j.yfh;
        localj = arx(j.b.dta());
        localObject6 = localj.dKH();
        localObject1 = ((czd)localObject6).Era;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((cyd)localObject1).DaC;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = (cym)d.a.j.C((List)localObject1, 0);
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((cym)localObject1).DMQ;
        localObject2 = ((czd)localObject6).Era;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((cyd)localObject2).DaC;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = (cym)d.a.j.C((List)localObject2, 0);
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((cym)localObject2).Url;
        label160:
        localObject6 = ((czd)localObject6).Era;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = ((cyd)localObject6).DaC;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = (cym)d.a.j.C((List)localObject6, 0);
        if (localObject6 == null) {
          break label339;
        }
      }
      label329:
      label334:
      label339:
      for (float f = ((cym)localObject6).EqD;; f = 0.0F)
      {
        localObject6 = k.yfq;
        localObject6 = j.yfh;
        k.a(j.b.dta(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.yfh;
        localObject2 = j.b.dHi().arX((String)localObject4);
        if (localObject2 == null) {
          break label379;
        }
        ((h)localObject2).field_count -= 1;
        if (((h)localObject2).field_count > 0) {
          break label344;
        }
        localObject1 = j.yfh;
        localObject1 = j.b.dHi();
        d.g.b.k.h(localObject4, "date");
        ((i)localObject1).db.delete(i.TABLE, "date=?", new String[] { String.valueOf(localObject4) });
        AppMethodBeat.o(118746);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label120;
        localObject2 = null;
        break label160;
      }
      label344:
      localObject1 = localObject3;
      if (localObject5 != null) {
        localObject1 = ((com.tencent.mm.plugin.story.i.j)localObject5).field_userName;
      }
      if ((localObject1 == null) || (localObject4 == null)) {}
      for (;;)
      {
        localObject1 = j.yfh;
        j.b.dHi().a((h)localObject2);
        label379:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.yfh;
        localObject3 = j.b.dHd();
        localObject5 = com.tencent.mm.plugin.story.e.a.yef;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).eG((String)localObject1, com.tencent.mm.plugin.story.e.a.a.ark((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.yor;
          ((com.tencent.mm.plugin.story.i.j)localObject3).MY(com.tencent.mm.plugin.story.i.a.dJJ());
          localObject3 = j.yfh;
          j.b.dHd().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          ad.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void Q(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      ad.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.yor;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.dJV()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = g.afA();
      d.g.b.k.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).aeS().b((com.tencent.mm.al.n)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static void R(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.yfh;
      localObject = j.b.dHd();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      ad.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, str);
      AppMethodBeat.o(118754);
    }
    
    public static long a(com.tencent.mm.plugin.story.i.j paramj, cyt paramcyt, int paramInt)
    {
      AppMethodBeat.i(118743);
      d.g.b.k.h(paramj, "storyInfo");
      d.g.b.k.h(paramcyt, "storyObj");
      long l;
      if ((paramcyt.EqL == null) || (paramcyt.EqL.getBuffer() == null))
      {
        ad.i(n.access$getTAG$cp(), "object desc is null");
        l = paramcyt.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = paramcyt.EqL.getBuffer().toByteArray();
      d.g.b.k.g(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.yfy;
      localObject2 = q.a.arA((String)localObject1);
      if ((bt.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = paramcyt.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((czd)localObject2))
      {
        l = paramcyt.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      ad.d(n.access$getTAG$cp(), "from server xml ok " + paramcyt.Id + " \n " + (String)localObject1);
      paramcyt.EqL.setBuffer(new byte[0]);
      paramj.field_userName = paramcyt.mAQ;
      paramj.field_createTime = paramcyt.CreateTime;
      paramj.field_storyID = paramcyt.Id;
      paramj.field_attrBuf = paramcyt.toByteArray();
      if (paramcyt.EqP == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.yor;
        paramj.OG(com.tencent.mm.plugin.story.i.a.dKg());
        if (paramcyt.EqI != 1) {
          break label374;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.yor;
        paramj.OG(com.tencent.mm.plugin.story.i.a.dKh());
      }
      for (;;)
      {
        paramj.field_favoriteTime = paramcyt.EqQ;
        paramj.MY(paramInt);
        localObject1 = paramj.dKH();
        ((czd)localObject1).mAQ = paramcyt.mAQ;
        paramj.b((czd)localObject1);
        ad.d(n.access$getTAG$cp(), "will replaceUserByPcId " + paramcyt.Id);
        localObject1 = j.yfh;
        j.b.dHd().e(paramj);
        l = paramcyt.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.yor;
        paramj.OH(com.tencent.mm.plugin.story.i.a.dKg());
        break;
        label374:
        localObject1 = com.tencent.mm.plugin.story.i.a.yor;
        paramj.OH(com.tencent.mm.plugin.story.i.a.dKh());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, cyt paramcyt, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      d.g.b.k.h(paramString, "username");
      if (paramBoolean)
      {
        paramcyt = j.yfh;
        j.b.dHd().D(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.yfh;
      Object localObject2 = j.b.dHd().tT(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.yfh;
      if (bt.kU(paramString, j.b.dta()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        paramInt = com.tencent.mm.plugin.story.i.a.dJH();
        ((com.tencent.mm.plugin.story.i.j)localObject1).MY(paramInt);
        if (paramcyt == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, paramcyt, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.yor;
        paramInt = com.tencent.mm.plugin.story.i.a.dJI();
        break;
        label157:
        paramString = j.yfh;
        ((com.tencent.mm.plugin.story.i.j)localObject1).dzf = j.b.dHd().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j arx(String paramString)
    {
      AppMethodBeat.i(118753);
      d.g.b.k.h(paramString, "username");
      Object localObject = j.yfh;
      localObject = j.b.dHd();
      j.b localb = j.yfh;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).bN(paramString, bt.kU(j.b.dta(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> b(String paramString, List<? extends cyt> paramList, int paramInt)
    {
      AppMethodBeat.i(118742);
      d.g.b.k.h(paramString, "userName");
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramString = new LinkedList();
        AppMethodBeat.o(118742);
        return paramString;
      }
      LinkedList localLinkedList = new LinkedList();
      paramString = j.yfh;
      com.tencent.mm.plugin.story.i.k localk = j.b.dHd();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        cyt localcyt = (cyt)paramList.get(i);
        ad.d(n.access$getTAG$cp(), "storyObj.id:" + localcyt.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.tT(localcyt.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localcyt, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
          localLinkedList.add(paramString);
        }
        i += 1;
      }
      AppMethodBeat.o(118742);
      return localLinkedList;
    }
    
    public static void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(118747);
      ad.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        Object localObject = com.tencent.mm.plugin.story.i.a.yor;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.dJX(), paramInt, paramBoolean2));
        localObject = g.afA();
        d.g.b.k.g(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject).aeS().b((com.tencent.mm.al.n)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static void b(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
    {
      AppMethodBeat.i(118748);
      d.g.b.k.h(paramList, "idList");
      d.g.b.k.h(paramList1, "localIdList");
      ad.i(n.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
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
          ad.d(n.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.yor;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.dJY(), i));
        }
      }
      paramList = g.afA();
      d.g.b.k.g(paramList, "MMKernel.network()");
      paramList.aeS().b((com.tencent.mm.al.n)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
    }
    
    public static void dHv()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.b localb = g.afA();
      d.g.b.k.g(localb, "MMKernel.network()");
      localb.aeS().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static boolean eF(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      d.g.b.k.h(paramString, "userName");
      boolean bool = false;
      Object localObject = j.yfh;
      localObject = j.b.dHd();
      j.b localb = j.yfh;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, bt.kU(paramString, j.b.dta()), paramInt, true)).iterator();
      if (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).dKH();
        if ((((czd)localObject).Era == null) || (((czd)localObject).Era.DaC.size() == 0)) {
          break label106;
        }
        bool = true;
      }
      label106:
      for (;;)
      {
        break;
        AppMethodBeat.o(118744);
        return bool;
      }
    }
    
    public static void hE(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      ad.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.yfh;
      localObject = j.b.dHd();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).OI(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.yor;
          localj.OG(com.tencent.mm.plugin.story.i.a.dKg());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.yor;
          localj.OH(com.tencent.mm.plugin.story.i.a.dKg());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void hF(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      ad.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.yfh;
      localObject = j.b.dHd();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).OI(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.yor;
          localj.OG(com.tencent.mm.plugin.story.i.a.dKh());
        }
        for (localj.field_favoriteTime = ce.asT();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.yor;
          localj.OH(com.tencent.mm.plugin.story.i.a.dKh());
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