package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/MMSearchChatroomMemberAdapter;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactAdapter;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "ui", "Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;", "chatroom", "", "scene", "", "isMultiSelect", "", "blockSet", "Ljava/util/HashSet;", "(Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;Ljava/lang/String;IZLjava/util/HashSet;)V", "getBlockSet", "()Ljava/util/HashSet;", "getChatroom", "()Ljava/lang/String;", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "getCurrentSearchTask", "()Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "setCurrentSearchTask", "(Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;)V", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "memberMatchList", "", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMemberMatchList", "()Ljava/util/List;", "setMemberMatchList", "(Ljava/util/List;)V", "searchEnd", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;", "getSearchEnd", "()Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;", "setSearchEnd", "(Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;)V", "cancelSearch", "", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "doSearch", "query", "finish", "getCount", "onFTSSearchEnd", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "stopSearch", "ui-selectcontact_release"})
public final class t
  extends q
  implements com.tencent.mm.plugin.fts.a.l
{
  private com.tencent.mm.plugin.fts.a.a.h BHY;
  private final HashSet<String> BIS;
  private List<? extends com.tencent.mm.plugin.fts.a.a.g> BJg;
  private com.tencent.mm.plugin.fts.a.a.a WGr;
  public p.a XsV;
  private final String fxT;
  private final f ocu;
  
  public t(o paramo, String paramString, boolean paramBoolean, HashSet<String> paramHashSet)
  {
    super(paramo, paramBoolean, 0);
    AppMethodBeat.i(186327);
    this.fxT = paramString;
    this.BIS = paramHashSet;
    this.ocu = kotlin.g.ar((kotlin.g.a.a)t.a.Xtu);
    AppMethodBeat.o(186327);
  }
  
  private MMHandler btS()
  {
    AppMethodBeat.i(186294);
    MMHandler localMMHandler = (MMHandler)this.ocu.getValue();
    AppMethodBeat.o(186294);
    return localMMHandler;
  }
  
  private void eqZ()
  {
    AppMethodBeat.i(186308);
    com.tencent.mm.plugin.fts.a.a.a locala = this.WGr;
    if (locala != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(locala);
      this.WGr = null;
      AppMethodBeat.o(186308);
      return;
    }
    AppMethodBeat.o(186308);
  }
  
  public final void aIi(String paramString)
  {
    AppMethodBeat.i(186301);
    if (paramString != null)
    {
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(186301);
        throw paramString;
      }
      int i;
      if (((CharSequence)kotlin.n.n.bb((CharSequence)paramString).toString()).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label149;
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label154;
        }
        com.tencent.mm.plugin.fts.a.a.j localj = new com.tencent.mm.plugin.fts.a.a.j();
        localj.BIN = this.fxT;
        localj.query = paramString;
        localj.nRn = 12;
        localj.handler = btS();
        localj.BIU = ((com.tencent.mm.plugin.fts.a.l)this);
        localj.BIS.addAll((Collection)this.BIS);
        this.WGr = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).search(2, localj);
        AppMethodBeat.o(186301);
        return;
        i = 0;
        break;
        label149:
        paramString = null;
      }
    }
    label154:
    ((t)this).erx();
    AppMethodBeat.o(186301);
  }
  
  public final void b(k paramk)
  {
    Object localObject3 = null;
    AppMethodBeat.i(186326);
    if (paramk != null)
    {
      Object localObject1;
      if (p.h(paramk.BIV, this.WGr))
      {
        localObject1 = paramk;
        if (localObject1 == null) {
          break label241;
        }
        switch (paramk.resultCode)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(186326);
        return;
        localObject1 = null;
        break;
        localObject1 = paramk.BIW;
        p.j(localObject1, "result.resultList");
        localObject1 = (m)kotlin.a.j.M((List)localObject1, 0);
        if (localObject1 != null)
        {
          ((m)localObject1).BHY = paramk.BHY;
          if (localObject1 == null) {
            break label188;
          }
        }
        label188:
        for (Object localObject2 = ((m)localObject1).BJg;; localObject2 = null)
        {
          this.BJg = ((List)localObject2);
          localObject2 = localObject3;
          if (localObject1 != null) {
            localObject2 = ((m)localObject1).BHY;
          }
          this.BHY = ((com.tencent.mm.plugin.fts.a.a.h)localObject2);
          clearCache();
          localObject1 = this.XsV;
          if (localObject1 != null) {
            ((p.a)localObject1).g(paramk.BHY.BIw, getCount(), true);
          }
          notifyDataSetChanged();
          AppMethodBeat.o(186326);
          return;
          localObject1 = null;
          break;
        }
        this.BJg = null;
        this.BHY = null;
        clearCache();
        localObject1 = this.XsV;
        if (localObject1 != null) {
          ((p.a)localObject1).g(paramk.BHY.BIw, getCount(), true);
        }
        notifyDataSetChanged();
      }
    }
    label241:
    AppMethodBeat.o(186326);
  }
  
  public final void erx()
  {
    AppMethodBeat.i(186314);
    eqZ();
    p.a locala = this.XsV;
    if (locala != null) {
      locala.g("", 0, true);
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(186314);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(186324);
    eqZ();
    this.BJg = null;
    this.BHY = null;
    super.finish();
    AppMethodBeat.o(186324);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(186318);
    List localList = this.BJg;
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(186318);
      return i;
    }
    AppMethodBeat.o(186318);
    return 0;
  }
  
  protected final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(186321);
    Object localObject1 = new com.tencent.mm.ui.contact.a.d(paramInt, fJk());
    Object localObject2 = this.BJg;
    if (localObject2 != null)
    {
      localObject2 = (com.tencent.mm.plugin.fts.a.a.g)kotlin.a.j.M((List)localObject2, paramInt);
      if (localObject2 != null)
      {
        ((com.tencent.mm.ui.contact.a.d)localObject1).XxD = ((com.tencent.mm.plugin.fts.a.a.g)localObject2);
        ((com.tencent.mm.ui.contact.a.d)localObject1).bAk(this.fxT);
        ((com.tencent.mm.ui.contact.a.d)localObject1).c(this.BHY);
      }
    }
    localObject1 = (com.tencent.mm.ui.contact.a.a)localObject1;
    AppMethodBeat.o(186321);
    return localObject1;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.t
 * JD-Core Version:    0.7.0.1
 */