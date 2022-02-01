package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.a.f;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eek;
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

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic;", "", "()V", "Companion", "plugin-story_release"})
public final class n
{
  public static final a FmM;
  private static final String TAG = "MicroMsg.StoryInfoStorageLogic";
  
  static
  {
    AppMethodBeat.i(118755);
    FmM = new a((byte)0);
    TAG = "MicroMsg.StoryInfoStorageLogic";
    AppMethodBeat.o(118755);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryInfoStorageLogic$Companion;", "", "()V", "TAG", "", "cancelDeleteStory", "", "cleanHistoryFlag", "userName", "storyId", "", "deleteByUsername", "", "username", "deleteDiedStoryByTime", "deleteLocalStory", "localId", "deleteRemoteStory", "getLastStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "getMergeStoryObjectWithCache", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "info", "insertStoryForHistory", "storyObj", "sourceType", "insertStoryList", "Ljava/util/LinkedList;", "list", "", "isStoryExist", "", "timeStamp", "isValidStoryId", "loadFavStoryFromRemote", "replace", "storyInfo", "replaceForHistory", "setStoryFavLocal", "favorite", "setStoryFavRemote", "idList", "localIdList", "setStoryPrivacyLocal", "visibility", "setStoryPrivacyRemote", "privacy", "deprecated", "updateNextAlbumSourceType", "date", "updateStoryBySync", "createTime", "isDelete", "updateStoryLocalFlag", "localFlag", "plugin-story_release"})
  public static final class a
  {
    public static void Z(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118745);
      Log.d(n.access$getTAG$cp(), "delete story item: " + paramInt + ' ' + paramLong);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = com.tencent.mm.plugin.story.i.a.FvD;
      localArrayList1.add(new com.tencent.mm.plugin.story.f.a.l(paramLong, com.tencent.mm.plugin.story.i.a.fqU()));
      localArrayList2.add(Integer.valueOf(paramInt));
      localObject = g.aAg();
      p.g(localObject, "MMKernel.network()");
      ((com.tencent.mm.kernel.b)localObject).azz().b((com.tencent.mm.ak.q)new f((List)localArrayList1, (List)localArrayList2));
      AppMethodBeat.o(118745);
    }
    
    public static long a(com.tencent.mm.plugin.story.i.j paramj, eea parameea, int paramInt)
    {
      AppMethodBeat.i(118743);
      p.h(paramj, "storyInfo");
      p.h(parameea, "storyObj");
      long l;
      if ((parameea.Nem == null) || (parameea.Nem.getBuffer() == null))
      {
        Log.i(n.access$getTAG$cp(), "object desc is null");
        l = parameea.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Object localObject1 = parameea.Nem.getBuffer().toByteArray();
      p.g(localObject1, "storyObj.ObjDesc.getBuffer().toByteArray()");
      localObject1 = new String((byte[])localObject1, d.UTF_8);
      Object localObject2 = q.FmO;
      localObject2 = q.a.aSb((String)localObject1);
      if ((Util.isNullOrNil((String)localObject1)) || (localObject2 == null))
      {
        l = parameea.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      if (!paramj.c((eek)localObject2))
      {
        l = parameea.Id;
        AppMethodBeat.o(118743);
        return l;
      }
      Log.d(n.access$getTAG$cp(), "from server xml ok " + parameea.Id + " \n " + (String)localObject1);
      parameea.Nem.setBuffer(new byte[0]);
      paramj.field_userName = parameea.UserName;
      paramj.field_createTime = parameea.CreateTime;
      paramj.field_storyID = parameea.Id;
      paramj.field_attrBuf = parameea.toByteArray();
      if (parameea.Neq == 1)
      {
        localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
        paramj.aaY(com.tencent.mm.plugin.story.i.a.frf());
        if (parameea.Nej != 1) {
          break label363;
        }
        localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
        paramj.aaY(com.tencent.mm.plugin.story.i.a.frg());
      }
      for (;;)
      {
        paramj.field_favoriteTime = parameea.Ner;
        paramj.addSourceFlag(paramInt);
        localObject1 = paramj.frG();
        ((eek)localObject1).UserName = parameea.UserName;
        paramj.b((eek)localObject1);
        Log.d(n.access$getTAG$cp(), "will replaceUserByPcId " + parameea.Id);
        localObject1 = j.Fmy;
        j.b.foc().e(paramj);
        l = parameea.Id;
        AppMethodBeat.o(118743);
        return l;
        localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
        paramj.aaZ(com.tencent.mm.plugin.story.i.a.frf());
        break;
        label363:
        localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
        paramj.aaZ(com.tencent.mm.plugin.story.i.a.frg());
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j a(String paramString, long paramLong, int paramInt, eea parameea, boolean paramBoolean)
    {
      AppMethodBeat.i(118752);
      p.h(paramString, "username");
      if (paramBoolean)
      {
        parameea = j.Fmy;
        j.b.foc().M(paramLong, paramString);
        AppMethodBeat.o(118752);
        return null;
      }
      Object localObject1 = j.Fmy;
      Object localObject2 = j.b.foc().Kx(paramLong);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.plugin.story.i.j();
      }
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID = paramLong;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_createTime = paramInt;
      ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName = paramString;
      localObject2 = j.Fmy;
      if (Util.isEqual(paramString, j.b.fau()))
      {
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        paramInt = com.tencent.mm.plugin.story.i.a.fqG();
        ((com.tencent.mm.plugin.story.i.j)localObject1).addSourceFlag(paramInt);
        if (parameea == null) {
          break label157;
        }
        a((com.tencent.mm.plugin.story.i.j)localObject1, parameea, ((com.tencent.mm.plugin.story.i.j)localObject1).field_sourceType);
      }
      for (;;)
      {
        AppMethodBeat.o(118752);
        return localObject1;
        paramString = com.tencent.mm.plugin.story.i.a.FvD;
        paramInt = com.tencent.mm.plugin.story.i.a.fqH();
        break;
        label157:
        paramString = j.Fmy;
        ((com.tencent.mm.plugin.story.i.j)localObject1).ecf = j.b.foc().f((com.tencent.mm.plugin.story.i.j)localObject1);
      }
    }
    
    public static com.tencent.mm.plugin.story.i.j aRZ(String paramString)
    {
      AppMethodBeat.i(118753);
      p.h(paramString, "username");
      Object localObject = j.Fmy;
      localObject = j.b.foc();
      j.b localb = j.Fmy;
      paramString = ((com.tencent.mm.plugin.story.i.k)localObject).cx(paramString, Util.isEqual(j.b.fau(), paramString));
      AppMethodBeat.o(118753);
      return paramString;
    }
    
    public static void aa(long paramLong, int paramInt)
    {
      AppMethodBeat.i(118754);
      Object localObject = j.Fmy;
      localObject = j.b.foc();
      String str = "UPDATE " + com.tencent.mm.plugin.story.i.k.TABLE + " SET localFlag = " + paramInt + " Where storyID = '" + paramLong + '\'';
      Log.d(com.tencent.mm.plugin.story.i.k.TAG, "updateSourceTypeBefore sql ".concat(String.valueOf(str)));
      ((com.tencent.mm.plugin.story.i.k)localObject).db.execSQL(com.tencent.mm.plugin.story.i.k.TABLE, str);
      AppMethodBeat.o(118754);
    }
    
    public static void aaH(int paramInt)
    {
      Object localObject3 = null;
      AppMethodBeat.i(118746);
      Object localObject1 = j.Fmy;
      Object localObject5 = j.b.foc().aba(paramInt);
      localObject1 = com.tencent.mm.plugin.story.e.a.Flw;
      Object localObject4;
      com.tencent.mm.plugin.story.i.j localj;
      Object localObject6;
      label121:
      Object localObject2;
      if (localObject5 != null)
      {
        localObject1 = Integer.valueOf(((com.tencent.mm.plugin.story.i.j)localObject5).field_createTime);
        localObject4 = com.tencent.mm.plugin.story.e.a.a.n((Integer)localObject1);
        localObject1 = j.Fmy;
        j.b.foc().Zs(paramInt);
        localObject1 = n.FmM;
        localObject1 = j.Fmy;
        localj = aRZ(j.b.fau());
        localObject6 = localj.frG();
        localObject1 = ((eek)localObject6).NeB;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((edk)localObject1).LoV;
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = (edt)kotlin.a.j.L((List)localObject1, 0);
        if (localObject1 == null) {
          break label334;
        }
        localObject1 = ((edt)localObject1).Msz;
        localObject2 = ((eek)localObject6).NeB;
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = ((edk)localObject2).LoV;
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = (edt)kotlin.a.j.L((List)localObject2, 0);
        if (localObject2 == null) {
          break label339;
        }
        localObject2 = ((edt)localObject2).Url;
        label161:
        localObject6 = ((eek)localObject6).NeB;
        if (localObject6 == null) {
          break label344;
        }
        localObject6 = ((edk)localObject6).LoV;
        if (localObject6 == null) {
          break label344;
        }
        localObject6 = (edt)kotlin.a.j.L((List)localObject6, 0);
        if (localObject6 == null) {
          break label344;
        }
      }
      label334:
      label339:
      label344:
      for (float f = ((edt)localObject6).Ned;; f = 0.0F)
      {
        localObject6 = k.FmH;
        localObject6 = j.Fmy;
        k.a(j.b.fau(), localj.field_storyID, localj.field_createTime, (String)localObject1, (String)localObject2, (f * 1000.0F));
        localObject1 = j.Fmy;
        localObject2 = j.b.foh().aSy((String)localObject4);
        if (localObject2 == null) {
          break label384;
        }
        ((h)localObject2).field_count -= 1;
        if (((h)localObject2).field_count > 0) {
          break label349;
        }
        localObject1 = j.Fmy;
        localObject1 = j.b.foh();
        p.h(localObject4, "date");
        ((i)localObject1).db.delete(i.TABLE, "date=?", new String[] { String.valueOf(localObject4) });
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
        localObject1 = j.Fmy;
        j.b.foh().a((h)localObject2);
        label384:
        AppMethodBeat.o(118746);
        return;
        localObject3 = j.Fmy;
        localObject3 = j.b.foc();
        localObject5 = com.tencent.mm.plugin.story.e.a.Flw;
        localObject1 = ((com.tencent.mm.plugin.story.i.k)localObject3).fN((String)localObject1, com.tencent.mm.plugin.story.e.a.a.aRN((String)localObject4));
        if (!((List)localObject1).isEmpty())
        {
          localObject3 = (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0);
          localObject4 = com.tencent.mm.plugin.story.i.a.FvD;
          ((com.tencent.mm.plugin.story.i.j)localObject3).addSourceFlag(com.tencent.mm.plugin.story.i.a.fqI());
          localObject3 = j.Fmy;
          j.b.foc().a((int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid, (com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0));
          Log.d(n.access$getTAG$cp(), "update " + (int)((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).systemRowid + "'s sourceType to " + ((com.tencent.mm.plugin.story.i.j)((List)localObject1).get(0)).field_sourceType + ' ');
        }
      }
    }
    
    public static LinkedList<com.tencent.mm.plugin.story.i.j> b(String paramString, List<? extends eea> paramList, int paramInt)
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
      paramString = j.Fmy;
      com.tencent.mm.plugin.story.i.k localk = j.b.foc();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        eea localeea = (eea)paramList.get(i);
        Log.d(n.access$getTAG$cp(), "storyObj.id:" + localeea.Id);
        com.tencent.mm.plugin.story.i.j localj = localk.Kx(localeea.Id);
        paramString = localj;
        if (localj == null) {
          paramString = new com.tencent.mm.plugin.story.i.j();
        }
        if ((a(paramString, localeea, paramInt) != 0L) && (paramString.field_storyID != 0L)) {
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
          com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.FvD;
          paramList1.add(new com.tencent.mm.plugin.story.f.a.k(l, com.tencent.mm.plugin.story.i.a.fqX(), i));
        }
      }
      paramList = g.aAg();
      p.g(paramList, "MMKernel.network()");
      paramList.azz().b((com.tencent.mm.ak.q)new f((List)paramList1, (List)localArrayList));
      AppMethodBeat.o(118748);
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
        Object localObject = com.tencent.mm.plugin.story.i.a.FvD;
        localArrayList1.add(new m(paramLong, com.tencent.mm.plugin.story.i.a.fqW(), paramInt, paramBoolean2));
        localObject = g.aAg();
        p.g(localObject, "MMKernel.network()");
        ((com.tencent.mm.kernel.b)localObject).azz().b((com.tencent.mm.ak.q)new f((List)localArrayList1, (List)localArrayList2));
        AppMethodBeat.o(118747);
        return;
      }
    }
    
    public static boolean fM(String paramString, int paramInt)
    {
      AppMethodBeat.i(118744);
      p.h(paramString, "userName");
      boolean bool = false;
      Object localObject = j.Fmy;
      localObject = j.b.foc();
      j.b localb = j.Fmy;
      paramString = ((Iterable)((com.tencent.mm.plugin.story.i.k)localObject).a(paramString, Util.isEqual(paramString, j.b.fau()), paramInt, true)).iterator();
      while (paramString.hasNext())
      {
        localObject = ((com.tencent.mm.plugin.story.i.j)paramString.next()).frG();
        if ((((eek)localObject).NeB != null) && (((eek)localObject).NeB.LoV.size() != 0)) {
          bool = true;
        }
      }
      AppMethodBeat.o(118744);
      return bool;
    }
    
    public static void fov()
    {
      AppMethodBeat.i(118751);
      com.tencent.mm.kernel.b localb = g.aAg();
      p.g(localb, "MMKernel.network()");
      localb.azz().cancel(764);
      AppMethodBeat.o(118751);
    }
    
    public static void jc(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118749);
      Log.d(n.access$getTAG$cp(), "setPrivacyLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.Fmy;
      localObject = j.b.foc();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).aba(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.FvD;
          localj.aaY(com.tencent.mm.plugin.story.i.a.frf());
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((IAutoDBItem)localj);
          AppMethodBeat.o(118749);
          return;
          locala = com.tencent.mm.plugin.story.i.a.FvD;
          localj.aaZ(com.tencent.mm.plugin.story.i.a.frf());
        }
      }
      AppMethodBeat.o(118749);
    }
    
    public static void jd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(118750);
      Log.d(n.access$getTAG$cp(), "setStoryFavLocal story item: " + paramInt1 + " to " + paramInt2);
      Object localObject = j.Fmy;
      localObject = j.b.foc();
      com.tencent.mm.plugin.story.i.j localj = ((com.tencent.mm.plugin.story.i.k)localObject).aba(paramInt1);
      if (localj != null)
      {
        com.tencent.mm.plugin.story.i.a.a locala;
        if (paramInt2 == 1)
        {
          locala = com.tencent.mm.plugin.story.i.a.FvD;
          localj.aaY(com.tencent.mm.plugin.story.i.a.frg());
        }
        for (localj.field_favoriteTime = cl.aWB();; localj.field_favoriteTime = 0)
        {
          ((com.tencent.mm.plugin.story.i.k)localObject).replace((IAutoDBItem)localj);
          AppMethodBeat.o(118750);
          return;
          locala = com.tencent.mm.plugin.story.i.a.FvD;
          localj.aaZ(com.tencent.mm.plugin.story.i.a.frg());
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