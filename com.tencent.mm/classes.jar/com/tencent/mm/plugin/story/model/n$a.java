package com.tencent.mm.plugin.story.model;

import a.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.e.b.a;
import com.tencent.mm.plugin.story.h.a;
import com.tencent.mm.plugin.story.h.a.a;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "plugin-story_release"})
public final class n$a
{
  public static void FH(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(109123);
    Object localObject1 = j.svi;
    Object localObject4 = j.b.cAB().Gb(paramInt);
    localObject1 = com.tencent.mm.plugin.story.e.b.ssx;
    if (localObject4 != null) {}
    Object localObject3;
    h localh;
    for (localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.h.j)localObject4).field_createTime);; localObject1 = null)
    {
      localObject3 = b.a.i((Integer)localObject1);
      localObject1 = j.svi;
      j.b.cAB().EA(paramInt);
      localObject1 = j.svi;
      localh = j.b.cAH().adE((String)localObject3);
      if (localh == null) {
        break label177;
      }
      localh.field_count -= 1;
      if (localh.field_count > 0) {
        break;
      }
      localObject1 = j.svi;
      localObject1 = j.b.cAH();
      a.f.b.j.q(localObject3, "date");
      ((i)localObject1).db.delete(i.sGE, "date=?", new String[] { String.valueOf(localObject3) });
      AppMethodBeat.o(109123);
      return;
    }
    localObject1 = localObject2;
    if (localObject4 != null) {
      localObject1 = ((com.tencent.mm.plugin.story.h.j)localObject4).field_userName;
    }
    if ((localObject1 == null) || (localObject3 == null)) {}
    for (;;)
    {
      localObject1 = j.svi;
      j.b.cAH().a(localh);
      label177:
      AppMethodBeat.o(109123);
      return;
      localObject2 = j.svi;
      localObject2 = j.b.cAB();
      localObject4 = com.tencent.mm.plugin.story.e.b.ssx;
      localObject1 = ((k)localObject2).dy((String)localObject1, b.a.acL((String)localObject3));
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = (com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0);
        localObject3 = a.sFV;
        ((com.tencent.mm.plugin.story.h.j)localObject2).Eu(a.cDQ());
        localObject2 = j.svi;
        j.b.cAB().a((int)((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0));
        ab.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.h.j)((List)localObject1).get(0)).field_sourceType + ' ');
      }
    }
  }
  
  public static void G(long paramLong, int paramInt)
  {
    AppMethodBeat.i(109122);
    ab.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = a.sFV;
    localArrayList1.add(new com.tencent.mm.plugin.story.model.a.m(paramLong, a.cEc()));
    localArrayList2.add(Integer.valueOf(paramInt));
    localObject = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).Rc().b((com.tencent.mm.ai.m)new com.tencent.mm.plugin.story.model.a.g((List)localArrayList1, (List)localArrayList2));
    AppMethodBeat.o(109122);
  }
  
  public static long a(com.tencent.mm.plugin.story.h.j paramj, chs paramchs, int paramInt)
  {
    AppMethodBeat.i(138748);
    a.f.b.j.q(paramj, "storyInfo");
    a.f.b.j.q(paramchs, "storyObj");
    long l;
    if ((paramchs.xSx == null) || (paramchs.xSx.getBuffer() == null))
    {
      ab.i(n.access$getTAG$cp(), "object desc is null");
      l = paramchs.Id;
      AppMethodBeat.o(138748);
      return l;
    }
    Object localObject1 = paramchs.xSx.getBuffer().toByteArray();
    a.f.b.j.p(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
    localObject1 = new String((byte[])localObject1, d.UTF_8);
    ab.d(n.access$getTAG$cp(), "from server %d \n%s", new Object[] { Long.valueOf(paramchs.Id), localObject1 });
    Object localObject2 = q.svz;
    localObject2 = q.a.adi((String)localObject1);
    if ((bo.isNullOrNil((String)localObject1)) || (localObject2 == null))
    {
      l = paramchs.Id;
      AppMethodBeat.o(138748);
      return l;
    }
    if (!paramj.c((cic)localObject2))
    {
      l = paramchs.Id;
      AppMethodBeat.o(138748);
      return l;
    }
    ab.d(n.access$getTAG$cp(), "from server xml ok %d \n ".concat(String.valueOf(localObject1)), new Object[] { Long.valueOf(paramchs.Id) });
    paramchs.xSx.setBuffer(new byte[0]);
    paramj.field_userName = paramchs.jJA;
    paramj.field_createTime = paramchs.CreateTime;
    paramj.field_storyID = paramchs.Id;
    paramj.field_attrBuf = paramchs.toByteArray();
    if (paramchs.xSB == 1)
    {
      localObject1 = a.sFV;
      paramj.FZ(a.cEp());
      if (paramchs.xSu != 1) {
        break label400;
      }
      localObject1 = a.sFV;
      paramj.FZ(a.cEq());
    }
    for (;;)
    {
      paramj.field_favoriteTime = paramchs.xSC;
      paramj.Eu(paramInt);
      localObject1 = paramj.cEY();
      ((cic)localObject1).jJA = paramchs.jJA;
      paramj.b((cic)localObject1);
      ab.d(n.access$getTAG$cp(), "will replaceUserByPcId " + paramchs.Id);
      localObject1 = j.svi;
      j.b.cAB().c(paramchs.Id, paramj);
      l = paramchs.Id;
      AppMethodBeat.o(138748);
      return l;
      localObject1 = a.sFV;
      paramj.Ga(a.cEp());
      break;
      label400:
      localObject1 = a.sFV;
      paramj.Ga(a.cEq());
    }
  }
  
  public static com.tencent.mm.plugin.story.h.j a(String paramString, long paramLong, int paramInt, chs paramchs, boolean paramBoolean)
  {
    AppMethodBeat.i(109129);
    a.f.b.j.q(paramString, "username");
    if (paramBoolean)
    {
      paramchs = j.svi;
      j.b.cAB().x(paramLong, paramString);
      AppMethodBeat.o(109129);
      return null;
    }
    Object localObject1 = j.svi;
    Object localObject2 = j.b.cAB().mR(paramLong);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new com.tencent.mm.plugin.story.h.j();
    }
    ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID = paramLong;
    ((com.tencent.mm.plugin.story.h.j)localObject1).field_createTime = paramInt;
    ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName = paramString;
    localObject2 = j.svi;
    if (bo.isEqual(paramString, j.b.coK()))
    {
      paramString = a.sFV;
      paramInt = a.cDO();
      ((com.tencent.mm.plugin.story.h.j)localObject1).Eu(paramInt);
      if (paramchs == null) {
        break label157;
      }
      a((com.tencent.mm.plugin.story.h.j)localObject1, paramchs, ((com.tencent.mm.plugin.story.h.j)localObject1).field_sourceType);
    }
    for (;;)
    {
      AppMethodBeat.o(109129);
      return localObject1;
      paramString = a.sFV;
      paramInt = a.cDP();
      break;
      label157:
      paramString = j.svi;
      ((com.tencent.mm.plugin.story.h.j)localObject1).cIp = j.b.cAB().e((com.tencent.mm.plugin.story.h.j)localObject1);
    }
  }
  
  public static void a(List<Long> paramList, List<Integer> paramList1, boolean paramBoolean)
  {
    AppMethodBeat.i(151059);
    a.f.b.j.q(paramList, "idList");
    a.f.b.j.q(paramList1, "localIdList");
    ab.i(n.access$getTAG$cp(), "setStoryFavRemote story count: " + paramList.size() + " to " + paramBoolean);
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
        ab.d(n.access$getTAG$cp(), "setStoryFavRemote story: " + l + " to " + paramBoolean);
        a.a locala = a.sFV;
        paramList1.add(new com.tencent.mm.plugin.story.model.a.l(l, a.cEf(), i));
      }
    }
    paramList = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(paramList, "MMKernel.network()");
    paramList.Rc().b((com.tencent.mm.ai.m)new com.tencent.mm.plugin.story.model.a.g((List)paramList1, (List)localArrayList));
    AppMethodBeat.o(151059);
  }
  
  public static LinkedList<com.tencent.mm.plugin.story.h.j> b(String paramString, List<? extends chs> paramList, int paramInt)
  {
    AppMethodBeat.i(109119);
    a.f.b.j.q(paramString, "userName");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramString = new LinkedList();
      AppMethodBeat.o(109119);
      return paramString;
    }
    LinkedList localLinkedList = new LinkedList();
    paramString = j.svi;
    k localk = j.b.cAB();
    int j = ((Collection)paramList).size();
    int i = 0;
    while (i < j)
    {
      chs localchs = (chs)paramList.get(i);
      ab.d(n.access$getTAG$cp(), "storyObj.id:" + localchs.Id);
      com.tencent.mm.plugin.story.h.j localj = localk.mR(localchs.Id);
      paramString = localj;
      if (localj == null) {
        paramString = new com.tencent.mm.plugin.story.h.j();
      }
      if ((a(paramString, localchs, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
        localLinkedList.add(paramString);
      }
      i += 1;
    }
    AppMethodBeat.o(109119);
    return localLinkedList;
  }
  
  public static void b(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(109124);
    ab.d(n.access$getTAG$cp(), "setPrivacyRemote story item: " + paramLong + " to " + paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(Integer.valueOf(paramInt));
    if (paramBoolean1) {}
    for (paramInt = 1;; paramInt = 0)
    {
      Object localObject = a.sFV;
      localArrayList1.add(new com.tencent.mm.plugin.story.model.a.n(paramLong, a.cEe(), paramInt, paramBoolean2));
      localObject = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).Rc().b((com.tencent.mm.ai.m)new com.tencent.mm.plugin.story.model.a.g((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(109124);
      return;
    }
  }
  
  public static void cAW()
  {
    AppMethodBeat.i(109128);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().cancel(764);
    AppMethodBeat.o(109128);
  }
  
  public static boolean dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(109121);
    a.f.b.j.q(paramString, "userName");
    boolean bool = false;
    Object localObject = j.svi;
    localObject = j.b.cAB();
    j.b localb = j.svi;
    paramString = ((Iterable)((k)localObject).a(paramString, bo.isEqual(paramString, j.b.coK()), paramInt, true)).iterator();
    if (paramString.hasNext())
    {
      localObject = ((com.tencent.mm.plugin.story.h.j)paramString.next()).cEY();
      if ((((cic)localObject).xSK == null) || (((cic)localObject).xSK.wOa.size() == 0)) {
        break label106;
      }
      bool = true;
    }
    label106:
    for (;;)
    {
      break;
      AppMethodBeat.o(109121);
      return bool;
    }
  }
  
  public static void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109126);
    ab.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
    Object localObject = j.svi;
    localObject = j.b.cAB();
    com.tencent.mm.plugin.story.h.j localj = ((k)localObject).Gb(paramInt1);
    if (localj != null)
    {
      a.a locala;
      if (paramInt2 == 1)
      {
        locala = a.sFV;
        localj.FZ(a.cEp());
      }
      for (;;)
      {
        ((k)localObject).replace((c)localj);
        AppMethodBeat.o(109126);
        return;
        locala = a.sFV;
        localj.Ga(a.cEp());
      }
    }
    AppMethodBeat.o(109126);
  }
  
  public static void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(109127);
    ab.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
    Object localObject = j.svi;
    localObject = j.b.cAB();
    com.tencent.mm.plugin.story.h.j localj = ((k)localObject).Gb(paramInt1);
    if (localj != null)
    {
      a.a locala;
      if (paramInt2 == 1)
      {
        locala = a.sFV;
        localj.FZ(a.cEq());
      }
      for (localj.field_favoriteTime = cb.abr();; localj.field_favoriteTime = 0)
      {
        ((k)localObject).replace((c)localj);
        AppMethodBeat.o(109127);
        return;
        locala = a.sFV;
        localj.Ga(a.cEq());
      }
    }
    AppMethodBeat.o(109127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.n.a
 * JD-Core Version:    0.7.0.1
 */