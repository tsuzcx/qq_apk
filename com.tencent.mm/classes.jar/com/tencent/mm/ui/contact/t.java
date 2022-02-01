package com.tencent.mm.ui.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/MMSearchChatroomMemberAdapter;", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactAdapter;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "ui", "Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;", "chatroom", "", "scene", "", "isMultiSelect", "", "blockSet", "Ljava/util/HashSet;", "(Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;Ljava/lang/String;IZLjava/util/HashSet;)V", "getBlockSet", "()Ljava/util/HashSet;", "getChatroom", "()Ljava/lang/String;", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "getCurrentSearchTask", "()Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "setCurrentSearchTask", "(Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;)V", "ftsQuery", "Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "getFtsQuery", "()Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;", "setFtsQuery", "(Lcom/tencent/mm/plugin/fts/api/model/FTSQuery;)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "memberMatchList", "", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMemberMatchList", "()Ljava/util/List;", "setMemberMatchList", "(Ljava/util/List;)V", "searchEnd", "Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;", "getSearchEnd", "()Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;", "setSearchEnd", "(Lcom/tencent/mm/ui/contact/MMBaseSearchContactAdapter$IOnSearchEnd;)V", "cancelSearch", "", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "doSearch", "query", "finish", "getCount", "onFTSSearchEnd", "result", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "stopSearch", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends q
  implements com.tencent.mm.plugin.fts.a.l
{
  private c DHR;
  private com.tencent.mm.plugin.fts.a.a.j FWt;
  private final HashSet<String> HtA;
  private List<? extends i> HtP;
  public p.a afew;
  private final String hCy;
  private final kotlin.j rdm;
  
  public t(o paramo, String paramString, boolean paramBoolean, HashSet<String> paramHashSet)
  {
    super(paramo, paramBoolean, 0);
    AppMethodBeat.i(252871);
    this.hCy = paramString;
    this.HtA = paramHashSet;
    this.rdm = k.cm((kotlin.g.a.a)t.a.afeY);
    AppMethodBeat.o(252871);
  }
  
  private void fxG()
  {
    AppMethodBeat.i(252876);
    c localc = this.DHR;
    if (localc != null)
    {
      ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(localc);
      this.DHR = null;
    }
    AppMethodBeat.o(252876);
  }
  
  private MMHandler getHandler()
  {
    AppMethodBeat.i(252874);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(252874);
    return localMMHandler;
  }
  
  public final void aEJ(String paramString)
  {
    AppMethodBeat.i(252882);
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null) {
        ((t)this).eui();
      }
      AppMethodBeat.o(252882);
      return;
      int i;
      if (((CharSequence)kotlin.n.n.bq((CharSequence)paramString).toString()).length() > 0)
      {
        i = 1;
        label51:
        if (i == 0) {
          break label69;
        }
      }
      for (;;)
      {
        if (paramString != null) {
          break label74;
        }
        paramString = null;
        break;
        i = 0;
        break label51;
        label69:
        paramString = null;
      }
      label74:
      com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
      locall.Htv = this.hCy;
      locall.query = paramString;
      locall.qRb = 12;
      locall.handler = getHandler();
      locall.HtC = ((com.tencent.mm.plugin.fts.a.l)this);
      locall.HtA.addAll((Collection)this.HtA);
      this.DHR = ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).search(2, locall);
      paramString = ah.aiuX;
    }
  }
  
  public final void b(m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(252912);
    Object localObject1;
    if (paramm != null)
    {
      if (!s.p(paramm.HtE, this.DHR)) {
        break label74;
      }
      localObject1 = paramm;
      if (localObject1 != null) {
        switch (paramm.resultCode)
        {
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(252912);
      return;
      label74:
      localObject1 = null;
      break;
      localObject1 = paramm.HtF;
      s.s(localObject1, "result.resultList");
      localObject1 = (com.tencent.mm.plugin.fts.a.a.o)p.ae((List)localObject1, 0);
      List localList;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label180;
        }
        localList = null;
        label111:
        this.HtP = localList;
        if (localObject1 != null) {
          break label188;
        }
      }
      label180:
      label188:
      for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.plugin.fts.a.a.o)localObject1).FWt)
      {
        this.FWt = ((com.tencent.mm.plugin.fts.a.a.j)localObject1);
        clearCache();
        localObject1 = this.afew;
        if (localObject1 != null) {
          ((p.a)localObject1).h(paramm.FWt.Hte, getCount(), true);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(252912);
        return;
        ((com.tencent.mm.plugin.fts.a.a.o)localObject1).FWt = paramm.FWt;
        break;
        localList = ((com.tencent.mm.plugin.fts.a.a.o)localObject1).HtP;
        break label111;
      }
      this.HtP = null;
      this.FWt = null;
      clearCache();
      localObject1 = this.afew;
      if (localObject1 != null) {
        ((p.a)localObject1).h(paramm.FWt.Hte, getCount(), true);
      }
      notifyDataSetChanged();
    }
  }
  
  public final void eui()
  {
    AppMethodBeat.i(252887);
    fxG();
    p.a locala = this.afew;
    if (locala != null) {
      locala.h("", 0, true);
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(252887);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(252903);
    fxG();
    this.HtP = null;
    this.FWt = null;
    super.finish();
    AppMethodBeat.o(252903);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(252891);
    List localList = this.HtP;
    if (localList == null)
    {
      AppMethodBeat.o(252891);
      return 0;
    }
    int i = localList.size();
    AppMethodBeat.o(252891);
    return i;
  }
  
  protected final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(252896);
    Object localObject1 = new com.tencent.mm.ui.contact.a.d(paramInt, gZe());
    Object localObject2 = this.HtP;
    if (localObject2 != null)
    {
      localObject2 = (i)p.ae((List)localObject2, paramInt);
      if (localObject2 != null)
      {
        ((com.tencent.mm.ui.contact.a.d)localObject1).afjN = ((i)localObject2);
        ((com.tencent.mm.ui.contact.a.a)localObject1).hCy = this.hCy;
        ((com.tencent.mm.ui.contact.a.a)localObject1).FWt = this.FWt;
      }
    }
    localObject1 = (com.tencent.mm.ui.contact.a.a)localObject1;
    AppMethodBeat.o(252896);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.t
 * JD-Core Version:    0.7.0.1
 */