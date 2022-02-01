package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.n.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  public static final a BbT;
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118755);
    BbT = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static void SL(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.BbE;
      Object localObject5 = j.b.elB().Te(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.BaC;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label120:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.n((Integer)localObject1);
        localObject1 = j.BbE;
        j.b.elB().Rx(paramInt);
        localObject1 = n.BbT;
        localObject1 = j.BbE;
        localj = aDe(j.b.dXj());
        localObject6 = localj.epg();
        localObject1 = ((dkx)localObject6).HSy;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((djx)localObject1).Gtx;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = (dkg)d.a.j.F((List)localObject1, 0);
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((dkg)localObject1).Hmj;
        localObject2 = ((dkx)localObject6).HSy;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((djx)localObject2).Gtx;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = (dkg)d.a.j.F((List)localObject2, 0);
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((dkg)localObject2).Url;
        label160:
        localObject6 = ((dkx)localObject6).HSy;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = ((djx)localObject6).Gtx;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = (dkg)d.a.j.F((List)localObject6, 0);
        if (localObject6 == null) {
          break label339;
        }
      }
      label329:
      label334:
      label339:
      for (float f = ((dkg)localObject6).HSb;; f = 0.0F)
      {
        localObject6 = k.BbN;
        localObject6 = j.BbE;
        k.a(j.b.dXj(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.BbE;
        localObject2 = j.b.elG().aDD((String)localObject4);
        if (localObject2 == null) {
          break label379;
        }
        ((h)localObject2).field_count -= 1;
        if (((h)localObject2).field_count > 0) {
          break label344;
        }
        localObject1 = j.BbE;
        localObject1 = j.b.elG();
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
        localObject1 = j.BbE;
        j.b.elG().a((h)localObject2);
        label379:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.BbE;
        localObject3 = j.b.elB();
        localObject5 = com.tencent.mm.plugin.story.e.a.BaC;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).fp((String)localObject1, com.tencent.mm.plugin.story.e.a.a.aCR((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.BkN;
          ((com.tencent.mm.plugin.story.i.j)localObject3).Rq(com.tencent.mm.plugin.story.i.a.eoi());
          localObject3 = j.BbE;
          j.b.elB().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          ae.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void Y(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      ae.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.BkN;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.eou()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = g.ajQ();
      p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).ajj().b((com.tencent.mm.ak.n)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static void Z(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.BbE;
      localObject = j.b.elB();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      ae.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, str);
      AppMethodBeat.o(118754);
    }
    
    public static long a(com.tencent.mm.plugin.story.i.j paramj, dkn paramdkn, int paramInt)
    {
      AppMethodBeat.i(118743);
      p.h(paramj, "storyInfo");
      p.h(paramdkn, "storyObj");
      long l;
      if ((paramdkn.HSj == null) || (paramdkn.HSj.getBuffer() == null))
      {
        ae.i(n.access$getTAG$cp(), "object desc is null");
        l = paramdkn.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = paramdkn.HSj.getBuffer().toByteArray();
      p.g(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.BbV;
      localObject2 = q.a.aDg((String)localObject1);
      if ((bu.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = paramdkn.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((dkx)localObject2))
      {
        l = paramdkn.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      ae.d(n.access$getTAG$cp(), "from server xml ok " + paramdkn.Id + " \n " + (String)localObject1);
      paramdkn.HSj.setBuffer(new byte[0]);
      paramj.field_userName = paramdkn.nIJ;
      paramj.field_createTime = paramdkn.CreateTime;
      paramj.field_storyID = paramdkn.Id;
      paramj.field_attrBuf = paramdkn.toByteArray();
      if (paramdkn.HSn == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
        paramj.Tc(com.tencent.mm.plugin.story.i.a.eoF());
        if (paramdkn.HSg != 1) {
          break label374;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
        paramj.Tc(com.tencent.mm.plugin.story.i.a.eoG());
      }
      for (;;)
      {
        paramj.field_favoriteTime = paramdkn.HSo;
        paramj.Rq(paramInt);
        localObject1 = paramj.epg();
        ((dkx)localObject1).nIJ = paramdkn.nIJ;
        paramj.b((dkx)localObject1);
        ae.d(n.access$getTAG$cp(), "will replaceUserByPcId " + paramdkn.Id);
        localObject1 = j.BbE;
        j.b.elB().e(paramj);
        l = paramdkn.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
        paramj.Td(com.tencent.mm.plugin.story.i.a.eoF());
        break;
        label374:
        localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
        paramj.Td(com.tencent.mm.plugin.story.i.a.eoG());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, dkn paramdkn, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      p.h(paramString, "username");
      if (paramBoolean)
      {
        paramdkn = j.BbE;
        j.b.elB().G(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.BbE;
      Object localObject2 = j.b.elB().Bs(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.BbE;
      if (bu.lX(paramString, j.b.dXj()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        paramInt = com.tencent.mm.plugin.story.i.a.eog();
        ((com.tencent.mm.plugin.story.i.j)localObject1).Rq(paramInt);
        if (paramdkn == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, paramdkn, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.BkN;
        paramInt = com.tencent.mm.plugin.story.i.a.eoh();
        break;
        label157:
        paramString = j.BbE;
        ((com.tencent.mm.plugin.story.i.j)localObject1).dKr = j.b.elB().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j aDe(String paramString)
    {
      AppMethodBeat.i(118753);
      p.h(paramString, "username");
      Object localObject = j.BbE;
      localObject = j.b.elB();
      j.b localb = j.BbE;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).cf(paramString, bu.lX(j.b.dXj(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> b(String paramString, List<? extends dkn> paramList, int paramInt)
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
      paramString = j.BbE;
      com.tencent.mm.plugin.story.i.k localk = j.b.elB();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        dkn localdkn = (dkn)paramList.get(i);
        ae.d(n.access$getTAG$cp(), "storyObj.id:" + localdkn.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.Bs(localdkn.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localdkn, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
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
      ae.i(n.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
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
          ae.d(n.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.BkN;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.eox(), i));
        }
      }
      paramList = g.ajQ();
      p.g(paramList, "MMKernel.network()");
      paramList.ajj().b((com.tencent.mm.ak.n)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
    }
    
    public static void c(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(118747);
      ae.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        Object localObject = com.tencent.mm.plugin.story.i.a.BkN;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.eow(), paramInt, paramBoolean2));
        localObject = g.ajQ();
        p.g(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject).ajj().b((com.tencent.mm.ak.n)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static void elT()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.b localb = g.ajQ();
      p.g(localb, "MMKernel.network()");
      localb.ajj().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static boolean fo(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      p.h(paramString, "userName");
      boolean bool = false;
      Object localObject = j.BbE;
      localObject = j.b.elB();
      j.b localb = j.BbE;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, bu.lX(paramString, j.b.dXj()), paramInt, true)).iterator();
      while (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).epg();
        if ((((dkx)localObject).HSy != null) && (((dkx)localObject).HSy.Gtx.size() != 0)) {
          bool = true;
        }
      }
      AppMethodBeat.o(118744);
      return bool;
    }
    
    public static void ih(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      ae.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.BbE;
      localObject = j.b.elB();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).Te(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.BkN;
          localj.Tc(com.tencent.mm.plugin.story.i.a.eoF());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.BkN;
          localj.Td(com.tencent.mm.plugin.story.i.a.eoF());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void ii(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      ae.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.BbE;
      localObject = j.b.elB();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).Te(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.BkN;
          localj.Tc(com.tencent.mm.plugin.story.i.a.eoG());
        }
        for (localj.field_favoriteTime = ch.aDd();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.BkN;
          localj.Td(com.tencent.mm.plugin.story.i.a.eoG());
        }
      }
      AppMethodBeat.o(118750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.n
 * JD-Core Version:    0.7.0.1
 */