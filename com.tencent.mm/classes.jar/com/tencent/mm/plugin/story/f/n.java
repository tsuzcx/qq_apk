package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.n.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  public static final a zsw;
  
  static
  {
    AppMethodBeat.i(118755);
    zsw = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static void Qv(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.zsh;
      Object localObject5 = j.b.dVE().QO(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.zrf;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label120:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.l((Integer)localObject1);
        localObject1 = j.zsh;
        j.b.dVE().Pi(paramInt);
        localObject1 = n.zsw;
        localObject1 = j.zsh;
        localj = awG(j.b.dHx());
        localObject6 = localj.dZi();
        localObject1 = ((dep)localObject6).FOc;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((ddp)localObject1).Etz;
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = (ddy)d.a.j.C((List)localObject1, 0);
        if (localObject1 == null) {
          break label329;
        }
        localObject1 = ((ddy)localObject1).Fjh;
        localObject2 = ((dep)localObject6).FOc;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((ddp)localObject2).Etz;
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = (ddy)d.a.j.C((List)localObject2, 0);
        if (localObject2 == null) {
          break label334;
        }
        localObject2 = ((ddy)localObject2).Url;
        label160:
        localObject6 = ((dep)localObject6).FOc;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = ((ddp)localObject6).Etz;
        if (localObject6 == null) {
          break label339;
        }
        localObject6 = (ddy)d.a.j.C((List)localObject6, 0);
        if (localObject6 == null) {
          break label339;
        }
      }
      label329:
      label334:
      label339:
      for (float f = ((ddy)localObject6).FNF;; f = 0.0F)
      {
        localObject6 = k.zsq;
        localObject6 = j.zsh;
        k.a(j.b.dHx(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.zsh;
        localObject2 = j.b.dVJ().axg((String)localObject4);
        if (localObject2 == null) {
          break label379;
        }
        ((h)localObject2).field_count -= 1;
        if (((h)localObject2).field_count > 0) {
          break label344;
        }
        localObject1 = j.zsh;
        localObject1 = j.b.dVJ();
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
        localObject1 = j.zsh;
        j.b.dVJ().a((h)localObject2);
        label379:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.zsh;
        localObject3 = j.b.dVE();
        localObject5 = com.tencent.mm.plugin.story.e.a.zrf;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).eO((String)localObject1, com.tencent.mm.plugin.story.e.a.a.awt((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.zBQ;
          ((com.tencent.mm.plugin.story.i.j)localObject3).Pb(com.tencent.mm.plugin.story.i.a.dYk());
          localObject3 = j.zsh;
          j.b.dVE().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          ac.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static void T(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      ac.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.zBQ;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.dYw()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = g.agQ();
      d.g.b.k.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).agi().b((com.tencent.mm.ak.n)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static void U(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.zsh;
      localObject = j.b.dVE();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      ac.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, str);
      AppMethodBeat.o(118754);
    }
    
    public static long a(com.tencent.mm.plugin.story.i.j paramj, def paramdef, int paramInt)
    {
      AppMethodBeat.i(118743);
      d.g.b.k.h(paramj, "storyInfo");
      d.g.b.k.h(paramdef, "storyObj");
      long l;
      if ((paramdef.FNN == null) || (paramdef.FNN.getBuffer() == null))
      {
        ac.i(n.access$getTAG$cp(), "object desc is null");
        l = paramdef.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = paramdef.FNN.getBuffer().toByteArray();
      d.g.b.k.g(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.zsy;
      localObject2 = q.a.awJ((String)localObject1);
      if ((bs.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = paramdef.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((dep)localObject2))
      {
        l = paramdef.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      ac.d(n.access$getTAG$cp(), "from server xml ok " + paramdef.Id + " \n " + (String)localObject1);
      paramdef.FNN.setBuffer(new byte[0]);
      paramj.field_userName = paramdef.ncR;
      paramj.field_createTime = paramdef.CreateTime;
      paramj.field_storyID = paramdef.Id;
      paramj.field_attrBuf = paramdef.toByteArray();
      if (paramdef.FNR == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
        paramj.QM(com.tencent.mm.plugin.story.i.a.dYH());
        if (paramdef.FNK != 1) {
          break label374;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
        paramj.QM(com.tencent.mm.plugin.story.i.a.dYI());
      }
      for (;;)
      {
        paramj.field_favoriteTime = paramdef.FNS;
        paramj.Pb(paramInt);
        localObject1 = paramj.dZi();
        ((dep)localObject1).ncR = paramdef.ncR;
        paramj.b((dep)localObject1);
        ac.d(n.access$getTAG$cp(), "will replaceUserByPcId " + paramdef.Id);
        localObject1 = j.zsh;
        j.b.dVE().e(paramj);
        l = paramdef.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
        paramj.QN(com.tencent.mm.plugin.story.i.a.dYH());
        break;
        label374:
        localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
        paramj.QN(com.tencent.mm.plugin.story.i.a.dYI());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, def paramdef, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      d.g.b.k.h(paramString, "username");
      if (paramBoolean)
      {
        paramdef = j.zsh;
        j.b.dVE().B(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.zsh;
      Object localObject2 = j.b.dVE().yw(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.zsh;
      if (bs.lr(paramString, j.b.dHx()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        paramInt = com.tencent.mm.plugin.story.i.a.dYi();
        ((com.tencent.mm.plugin.story.i.j)localObject1).Pb(paramInt);
        if (paramdef == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, paramdef, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.zBQ;
        paramInt = com.tencent.mm.plugin.story.i.a.dYj();
        break;
        label157:
        paramString = j.zsh;
        ((com.tencent.mm.plugin.story.i.j)localObject1).dwR = j.b.dVE().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j awG(String paramString)
    {
      AppMethodBeat.i(118753);
      d.g.b.k.h(paramString, "username");
      Object localObject = j.zsh;
      localObject = j.b.dVE();
      j.b localb = j.zsh;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).bU(paramString, bs.lr(j.b.dHx(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> b(String paramString, List<? extends def> paramList, int paramInt)
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
      paramString = j.zsh;
      com.tencent.mm.plugin.story.i.k localk = j.b.dVE();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        def localdef = (def)paramList.get(i);
        ac.d(n.access$getTAG$cp(), "storyObj.id:" + localdef.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.yw(localdef.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localdef, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
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
      ac.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(Integer.valueOf(paramInt));
      if (paramBoolean1) {}
      for (paramInt = 1;; paramInt = 0)
      {
        Object localObject = com.tencent.mm.plugin.story.i.a.zBQ;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.dYy(), paramInt, paramBoolean2));
        localObject = g.agQ();
        d.g.b.k.g(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject).agi().b((com.tencent.mm.ak.n)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static void b(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
    {
      AppMethodBeat.i(118748);
      d.g.b.k.h(paramList, "idList");
      d.g.b.k.h(paramList1, "localIdList");
      ac.i(n.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
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
          ac.d(n.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.zBQ;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.dYz(), i));
        }
      }
      paramList = g.agQ();
      d.g.b.k.g(paramList, "MMKernel.network()");
      paramList.agi().b((com.tencent.mm.ak.n)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
    }
    
    public static void dVW()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.b localb = g.agQ();
      d.g.b.k.g(localb, "MMKernel.network()");
      localb.agi().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static boolean eN(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      d.g.b.k.h(paramString, "userName");
      boolean bool = false;
      Object localObject = j.zsh;
      localObject = j.b.dVE();
      j.b localb = j.zsh;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, bs.lr(paramString, j.b.dHx()), paramInt, true)).iterator();
      if (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).dZi();
        if ((((dep)localObject).FOc == null) || (((dep)localObject).FOc.Etz.size() == 0)) {
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
    
    public static void hN(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      ac.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.zsh;
      localObject = j.b.dVE();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).QO(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.zBQ;
          localj.QM(com.tencent.mm.plugin.story.i.a.dYH());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.zBQ;
          localj.QN(com.tencent.mm.plugin.story.i.a.dYH());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void hO(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      ac.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.zsh;
      localObject = j.b.dVE();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).QO(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.zBQ;
          localj.QM(com.tencent.mm.plugin.story.i.a.dYI());
        }
        for (localj.field_favoriteTime = ce.azK();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((c)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.zBQ;
          localj.QN(com.tencent.mm.plugin.story.i.a.dYI());
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