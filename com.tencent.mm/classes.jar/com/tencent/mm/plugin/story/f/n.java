package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.n.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  public static final a AKq;
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118755);
    AKq = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static void Se(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.AKb;
      Object localObject5 = j.b.ehT().Sx(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.AIZ;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label120:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.m((Integer)localObject1);
        localObject1 = j.AKb;
        j.b.ehT().QQ(paramInt);
        localObject1 = n.AKq;
        localObject1 = j.AKb;
        localj = aBL(j.b.dTJ());
        localObject6 = localj.elx();
        localObject1 = ((dkc)localObject6).HyN;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((djc)localObject1).GaQ;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = (djl)d.a.j.E((List)localObject1, 0);
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((djl)localObject1).GSI;
        localObject2 = ((dkc)localObject6).HyN;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((djc)localObject2).GaQ;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = (djl)d.a.j.E((List)localObject2, 0);
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((djl)localObject2).Url;
        label160:
        localObject6 = ((dkc)localObject6).HyN;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = ((djc)localObject6).GaQ;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = (djl)d.a.j.E((List)localObject6, 0);
        if (localObject6 == null) {
          break label339;
        }
      }
      label329:
      label334:
      label339:
      for (float f = ((djl)localObject6).Hyq;; f = 0.0F)
      {
        localObject6 = k.AKk;
        localObject6 = j.AKb;
        k.a(j.b.dTJ(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.AKb;
        localObject2 = j.b.ehY().aCk((String)localObject4);
        if (localObject2 == null) {
          break label379;
        }
        ((h)localObject2).field_count -= 1;
        if (((h)localObject2).field_count > 0) {
          break label344;
        }
        localObject1 = j.AKb;
        localObject1 = j.b.ehY();
        p.h(localObject4, "date");
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
        localObject1 = j.AKb;
        j.b.ehY().a((h)localObject2);
        label379:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.AKb;
        localObject3 = j.b.ehT();
        localObject5 = com.tencent.mm.plugin.story.e.a.AIZ;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).fg((String)localObject1, com.tencent.mm.plugin.story.e.a.a.aBy((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.ATp;
          ((com.tencent.mm.plugin.story.i.j)localObject3).QJ(com.tencent.mm.plugin.story.i.a.ekz());
          localObject3 = j.AKb;
          j.b.ehT().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          ad.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void Y(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      ad.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.ATp;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.ekL()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = g.ajB();
      p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).aiU().b((com.tencent.mm.al.n)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static void Z(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.AKb;
      localObject = j.b.ehT();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      ad.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, str);
      AppMethodBeat.o(118754);
    }
    
    public static long a(com.tencent.mm.plugin.story.i.j paramj, djs paramdjs, int paramInt)
    {
      AppMethodBeat.i(118743);
      p.h(paramj, "storyInfo");
      p.h(paramdjs, "storyObj");
      long l;
      if ((paramdjs.Hyy == null) || (paramdjs.Hyy.getBuffer() == null))
      {
        ad.i(n.access$getTAG$cp(), "object desc is null");
        l = paramdjs.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = paramdjs.Hyy.getBuffer().toByteArray();
      p.g(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.AKs;
      localObject2 = q.a.aBN((String)localObject1);
      if ((bt.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = paramdjs.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((dkc)localObject2))
      {
        l = paramdjs.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      ad.d(n.access$getTAG$cp(), "from server xml ok " + paramdjs.Id + " \n " + (String)localObject1);
      paramdjs.Hyy.setBuffer(new byte[0]);
      paramj.field_userName = paramdjs.nDo;
      paramj.field_createTime = paramdjs.CreateTime;
      paramj.field_storyID = paramdjs.Id;
      paramj.field_attrBuf = paramdjs.toByteArray();
      if (paramdjs.HyC == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
        paramj.Sv(com.tencent.mm.plugin.story.i.a.ekW());
        if (paramdjs.Hyv != 1) {
          break label374;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
        paramj.Sv(com.tencent.mm.plugin.story.i.a.ekX());
      }
      for (;;)
      {
        paramj.field_favoriteTime = paramdjs.HyD;
        paramj.QJ(paramInt);
        localObject1 = paramj.elx();
        ((dkc)localObject1).nDo = paramdjs.nDo;
        paramj.b((dkc)localObject1);
        ad.d(n.access$getTAG$cp(), "will replaceUserByPcId " + paramdjs.Id);
        localObject1 = j.AKb;
        j.b.ehT().e(paramj);
        l = paramdjs.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
        paramj.Sw(com.tencent.mm.plugin.story.i.a.ekW());
        break;
        label374:
        localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
        paramj.Sw(com.tencent.mm.plugin.story.i.a.ekX());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, djs paramdjs, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      p.h(paramString, "username");
      if (paramBoolean)
      {
        paramdjs = j.AKb;
        j.b.ehT().F(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.AKb;
      Object localObject2 = j.b.ehT().AU(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.AKb;
      if (bt.lQ(paramString, j.b.dTJ()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        paramInt = com.tencent.mm.plugin.story.i.a.ekx();
        ((com.tencent.mm.plugin.story.i.j)localObject1).QJ(paramInt);
        if (paramdjs == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, paramdjs, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.ATp;
        paramInt = com.tencent.mm.plugin.story.i.a.eky();
        break;
        label157:
        paramString = j.AKb;
        ((com.tencent.mm.plugin.story.i.j)localObject1).dJd = j.b.ehT().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j aBL(String paramString)
    {
      AppMethodBeat.i(118753);
      p.h(paramString, "username");
      Object localObject = j.AKb;
      localObject = j.b.ehT();
      j.b localb = j.AKb;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).cb(paramString, bt.lQ(j.b.dTJ(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> b(String paramString, List<? extends djs> paramList, int paramInt)
    {
      AppMethodBeat.i(118742);
      p.h(paramString, "userName");
      if ((paramList == null) || (paramList.isEmpty()))
      {
        paramString = new LinkedList();
        AppMethodBeat.o(118742);
        return paramString;
      }
      LinkedList localLinkedList = new LinkedList();
      paramString = j.AKb;
      com.tencent.mm.plugin.story.i.k localk = j.b.ehT();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        djs localdjs = (djs)paramList.get(i);
        ad.d(n.access$getTAG$cp(), "storyObj.id:" + localdjs.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.AU(localdjs.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localdjs, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
          localLinkedList.add(paramString);
        }
        i += 1;
      }
      AppMethodBeat.o(118742);
      return localLinkedList;
    }
    
    public static void b(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
    {
      AppMethodBeat.i(118748);
      p.h(paramList, "idList");
      p.h(paramList1, "localIdList");
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
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.ATp;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.ekO(), i));
        }
      }
      paramList = g.ajB();
      p.g(paramList, "MMKernel.network()");
      paramList.aiU().b((com.tencent.mm.al.n)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
    }
    
    public static void c(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(118747);
      ad.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        Object localObject = com.tencent.mm.plugin.story.i.a.ATp;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.ekN(), paramInt, paramBoolean2));
        localObject = g.ajB();
        p.g(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject).aiU().b((com.tencent.mm.al.n)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static void eil()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.b localb = g.ajB();
      p.g(localb, "MMKernel.network()");
      localb.aiU().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static boolean ff(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      p.h(paramString, "userName");
      boolean bool = false;
      Object localObject = j.AKb;
      localObject = j.b.ehT();
      j.b localb = j.AKb;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, bt.lQ(paramString, j.b.dTJ()), paramInt, true)).iterator();
      while (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).elx();
        if ((((dkc)localObject).HyN != null) && (((dkc)localObject).HyN.GaQ.size() != 0)) {
          bool = true;
        }
      }
      AppMethodBeat.o(118744);
      return bool;
    }
    
    public static void ie(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      ad.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.AKb;
      localObject = j.b.ehT();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).Sx(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.ATp;
          localj.Sv(com.tencent.mm.plugin.story.i.a.ekW());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.ATp;
          localj.Sw(com.tencent.mm.plugin.story.i.a.ekW());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void jdMethod_if(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      ad.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.AKb;
      localObject = j.b.ehT();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).Sx(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.ATp;
          localj.Sv(com.tencent.mm.plugin.story.i.a.ekX());
        }
        for (localj.field_favoriteTime = cf.aCN();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.ATp;
          localj.Sw(com.tencent.mm.plugin.story.i.a.ekX());
        }
      }
      AppMethodBeat.o(118750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.n
 * JD-Core Version:    0.7.0.1
 */