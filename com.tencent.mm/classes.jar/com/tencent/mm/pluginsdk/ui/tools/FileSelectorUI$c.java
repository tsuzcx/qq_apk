package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.fav.a.a.c;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "appendFileList", "", "listFavItem", "", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "asyncLoad", "canBeForwardWithMsg", "", "info", "coreLoad", "", "createFileListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "favItemInfo", "getAllFavItemInfoInCurType", "subList", "dataType", "itemType", "initASync", "loadMoreAsync", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileSelectorUI$c
  extends FileSelectorUI.d
{
  public FileSelectorUI$c(FileSelectorUI.e parame)
  {
    super(parame, localObject);
    AppMethodBeat.i(245690);
    AppMethodBeat.o(245690);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(245725);
    s.u(paramc, "this$0");
    long l = System.currentTimeMillis();
    boolean bool = paramc.hasInit;
    if (!paramc.hasInit)
    {
      paramc.hasInit = true;
      while (paramc.YrW.size() < 10) {
        if (paramc.iOf() <= 0) {
          Log.i("MicroMsg.FileSelectorUI", s.X("has no data to load，chatting init sync end:", Long.valueOf(System.currentTimeMillis() - l)));
        }
      }
    }
    for (;;)
    {
      d.uiThread((a)new a(paramc));
      Log.i("MicroMsg.FileSelectorUI", "[isInit:" + bool + "] fav load data end:" + (System.currentTimeMillis() - l) + ", startIndex:" + paramc.getStartIndex());
      AppMethodBeat.o(245725);
      return;
      paramc.iOf();
    }
  }
  
  private final void iOc()
  {
    AppMethodBeat.i(245699);
    com.tencent.threadpool.h.ahAA.bm(new FileSelectorUI.c..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(245699);
  }
  
  private final int iOf()
  {
    AppMethodBeat.i(245695);
    List localList = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavItemInfoStorage().hj(getStartIndex(), iOg());
    ArrayList localArrayList = new ArrayList();
    s.s(localList, "favFileList");
    localList = mz(localList);
    if (localList != null) {
      localArrayList.addAll((Collection)localList);
    }
    setStartIndex(getStartIndex() + iOg());
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(245695);
      return 0;
    }
    my((List)localArrayList);
    int i = localArrayList.size();
    AppMethodBeat.o(245695);
    return i;
  }
  
  private final void my(List<? extends g> paramList)
  {
    AppMethodBeat.i(245719);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg == null) {
        localObject1 = null;
      }
      arf localarf;
      FileSelectorUI.i locali;
      for (;;)
      {
        if (localObject1 == null) {
          break label303;
        }
        ((FileSelectorUI.j)localObject1).a(FileSelectorUI.g.Ysn);
        ((FileSelectorUI.j)localObject1).d(FileSelectorUI.h.Ysr);
        ((FileSelectorUI.l)localObject1).title = com.tencent.mm.pluginsdk.platformtools.f.B((Context)this.YrS.getContext(), ((FileSelectorUI.j)localObject1).createTime);
        this.YrW.add(localObject1);
        break;
        if (localg.field_favProto == null)
        {
          localObject1 = null;
        }
        else if (localg.field_favProto.vEn == null)
        {
          localObject1 = null;
        }
        else if (localg.field_favProto.vEn.size() <= 0)
        {
          localObject1 = null;
        }
        else
        {
          localarf = (arf)localg.field_favProto.vEn.get(0);
          if (localarf == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = b.d(localarf);
            if (Util.isNullOrNil((String)localObject1))
            {
              Log.e("MicroMsg.FileSelectorUI", "createFileListItem, fav filePath is null ,filter");
              localObject1 = null;
            }
            else
            {
              locali = new FileSelectorUI.i(this.YrS);
              locali.createTime = localg.field_updateTime;
              locali.Ysx = ((CharSequence)getDisplayName(localg.field_fromUser));
              locali.Ysz = localarf.Zza;
              locali.YsA = localarf.ZzM;
              locali.Ysw = localarf.Ysw;
              if (!Util.isNullOrNil(localarf.title)) {
                break label305;
              }
              Log.i("MicroMsg.FileSelectorUI", "invalid title");
              localObject1 = null;
            }
          }
        }
      }
      label303:
      continue;
      label305:
      Object localObject2 = localarf.title;
      s.s(localObject2, "dataItem.title");
      locali.aO((CharSequence)localObject2);
      locali.filePath = ((String)localObject1);
      if ((localg != null) && ((localg.field_itemStatus <= 0) || (b.g(localg))))
      {
        localObject1 = com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class);
        if (localObject1 == null)
        {
          paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fav.api.IPluginFav");
          AppMethodBeat.o(245719);
          throw paramList;
        }
        localObject2 = ((com.tencent.mm.plugin.fav.a.ah)localObject1).getFavItemInfoStorage().mK(localg.field_localId);
        localObject1 = new com.tencent.mm.vfs.u(b.d(b.c(localg)));
      }
      label516:
      int i;
      label518:
      boolean bool;
      switch (localg.field_type)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 15: 
      case 17: 
      default: 
        i = 0;
        if (i == 0)
        {
          bool = true;
          label524:
          locali.YsB = bool;
          if (Util.isNullOrNil(localarf.title)) {
            break label858;
          }
        }
        break;
      }
      label858:
      for (Object localObject1 = localarf.title;; localObject1 = localg.field_favProto.title)
      {
        locali.Ysv = ((String)localObject1);
        locali.desc = localarf.desc;
        localObject1 = localarf.hIQ;
        s.s(localObject1, "dataItem.dataId");
        locali.brO((String)localObject1);
        locali.localId = localg.field_localId;
        localObject1 = (FileSelectorUI.j)locali;
        break;
        if (((com.tencent.mm.vfs.u)localObject1).jKS()) {
          break label516;
        }
        i = 1;
        break label518;
        localObject2 = b.c(localg);
        s.s(localObject2, "getFirstDataItem(info)");
        if ((!Util.isNullOrNil(((arf)localObject2).ZyM)) || (((com.tencent.mm.vfs.u)localObject1).jKS())) {
          break label516;
        }
        i = 1;
        break label518;
        if ((localg.field_id <= 0) && (localObject2 != null)) {
          break label516;
        }
        if ((localg.field_favProto == null) || (localg.field_favProto.vEn.size() <= 1))
        {
          i = 0;
          break label518;
        }
        localObject1 = localg.field_favProto.vEn.iterator();
        s.s(localObject1, "info.field_favProto.getDataList().iterator()");
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (localObject2 == null)
            {
              paramList = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FavDataItem");
              AppMethodBeat.o(245719);
              throw paramList;
            }
            localObject2 = (arf)localObject2;
            if ((!Util.isNullOrNil(((arf)localObject2).Ysw)) && (!Util.isNullOrNil(((arf)localObject2).ZyH)) && (!com.tencent.mm.vfs.y.ZC(b.d((arf)localObject2))))
            {
              i = 1;
              break;
            }
          }
        }
        i = 0;
        break label518;
        if (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SIGHTCannotTransmitForFav")) != 0)
        {
          Log.w("MicroMsg.FavSendFilter", "can not retransmit short video");
          break label516;
        }
        if (((com.tencent.mm.vfs.u)localObject1).jKS()) {
          break label516;
        }
        i = 1;
        break label518;
        bool = false;
        break label524;
      }
    }
    Log.d("MicroMsg.FileSelectorUI", "append file item list size %d, current total size is %d(fav)", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(this.YrW.size()) });
    AppMethodBeat.o(245719);
  }
  
  private static List<g> mz(List<? extends g> paramList)
  {
    AppMethodBeat.i(245708);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    g localg1;
    if (paramList.hasNext())
    {
      localg1 = (g)paramList.next();
      if ((localg1.field_type != 18) && (localg1.field_type != 14)) {}
    }
    for (;;)
    {
      try
      {
        Object localObject = localg1.field_favProto.vEn;
        s.s(localObject, "favItemInfo.field_favProto.getDataList()");
        localObject = (List)localObject;
        if (localg1.field_type != 18) {
          break label336;
        }
        i = 1;
        if (i >= ((List)localObject).size()) {
          break;
        }
        arf localarf = (arf)((List)localObject).get(i);
        if (localarf.dataType == 8)
        {
          g localg2 = localg1.dQt();
          localg2.field_type = 8;
          localg2.Acq = true;
          localg2.Acr = localg1;
          localg2.hIG = (localg1.field_localId + '_' + localarf.hIQ);
          localg2.Acs = localarf.hIQ;
          localg2.field_favProto = c.c(localg1.field_favProto);
          localg2.field_favProto.vEn = new LinkedList();
          localg2.field_favProto.vEn.add(localarf);
          localg2.field_favProto.btm(localarf.title);
          localArrayList.add(localg2);
          i += 1;
          continue;
        }
        i += 1;
        continue;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FileSelectorUI", "getSearchList() [%s] Exception:%s %s", new Object[] { Integer.valueOf(8), localException.getClass().getSimpleName(), localException.getMessage() });
      }
      localArrayList.add(localException);
      break;
      paramList = (List)localArrayList;
      AppMethodBeat.o(245708);
      return paramList;
      label336:
      int i = 0;
    }
  }
  
  public final void iOd()
  {
    AppMethodBeat.i(245738);
    this.hasInit = false;
    setStartIndex(0);
    axe(100);
    iOc();
    AppMethodBeat.o(245738);
  }
  
  public final void iOe()
  {
    AppMethodBeat.i(245743);
    iOc();
    AppMethodBeat.o(245743);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<kotlin.ah>
  {
    a(FileSelectorUI.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.c
 * JD-Core Version:    0.7.0.1
 */