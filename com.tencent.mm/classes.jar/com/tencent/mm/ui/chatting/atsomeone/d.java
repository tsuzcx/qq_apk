package com.tencent.mm.ui.chatting.atsomeone;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.zy;
import com.tencent.mm.f.b.a.y;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.livelist.MMSearchLiveList;
import com.tencent.mm.plugin.livelist.MMSearchLiveList.a;
import com.tencent.mm.plugin.livelist.h;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.util.c;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlinx.coroutines.by;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "context", "Landroid/content/Context;", "chatroom", "", "callback", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;)V", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getCallback", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;", "getChatroom", "()Ljava/lang/String;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "kotlin.jvm.PlatformType", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "chatroomMember$delegate", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "dataSource$delegate", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "isUseSearch", "", "()J", "setUseSearch", "(J)V", "lastTouchAlphabet", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "liveList", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "getLiveList", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "liveList$delegate", "onItemClickListener", "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1;", "onItemClickListener$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "searchDataSource", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "searchDataSource$delegate", "touchAlphabetCount", "", "getTouchAlphabetCount", "()I", "setTouchAlphabetCount", "(I)V", "at", "", "displayName", "username", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "inflateContentView", "Landroid/view/View;", "initContentView", "onClickClearTextBtn", "view", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "reportAtUser", "action", "Companion", "app_release"})
public final class d
  extends com.tencent.mm.ui.f.a
  implements FTSEditTextView.b
{
  public static final d.a WGh;
  private final kotlin.f BiY;
  private final kotlin.f GkX;
  private final kotlin.f GkY;
  private FTSEditTextView PAG;
  private AlphabetScrollBar WFZ;
  private final kotlin.f WGa;
  private final kotlin.f WGb;
  private String WGc;
  private long WGd;
  int WGe;
  private final kotlin.f WGf;
  private final b WGg;
  final String fxT;
  private WxRecyclerView xUj;
  private final kotlin.f zQC;
  
  static
  {
    AppMethodBeat.i(273737);
    WGh = new d.a((byte)0);
    AppMethodBeat.o(273737);
  }
  
  public d(final Context paramContext, String paramString, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(273736);
    this.fxT = paramString;
    this.WGg = paramb;
    this.GkX = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.WGa = kotlin.g.ar((kotlin.g.a.a)new d.m(this));
    this.WGb = kotlin.g.ar((kotlin.g.a.a)new d.d(this));
    this.GkY = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new d.j(paramContext));
    paramString = new zy();
    paramString.fZl.delay = 0L;
    EventCenter.instance.publish((IEvent)paramString);
    this.WGc = "";
    this.WGf = kotlin.g.ar((kotlin.g.a.a)new l(this, paramContext));
    AppMethodBeat.o(273736);
  }
  
  private final WxLinearLayoutManager fhl()
  {
    AppMethodBeat.i(273728);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.zQC.getValue();
    AppMethodBeat.o(273728);
    return localWxLinearLayoutManager;
  }
  
  private final AtSomeoneLiveList hNX()
  {
    AppMethodBeat.i(273726);
    AtSomeoneLiveList localAtSomeoneLiveList = (AtSomeoneLiveList)this.GkY.getValue();
    AppMethodBeat.o(273726);
    return localAtSomeoneLiveList;
  }
  
  private final h<f> hNY()
  {
    AppMethodBeat.i(273727);
    h localh = (h)this.BiY.getValue();
    AppMethodBeat.o(273727);
    return localh;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(273731);
    if (paramString1 != null)
    {
      int i;
      if (!n.ba((CharSequence)paramString1))
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label137;
        }
        paramString2 = hNX();
        paramList = paramString2.Eiv;
        if ((paramList != null) && (paramList.isActive() == true))
        {
          paramList = paramString2.Eiv;
          if (paramList != null) {
            paramList.a(null);
          }
        }
        paramString2.Eiv = LifecycleScope.launch$default(paramString2.EhL, null, (m)new MMSearchLiveList.a(paramString2, paramString1, null), 1, null);
        paramString1 = this.WFZ;
        if (paramString1 != null) {
          paramString1.setVisibility(8);
        }
        this.WGd = 1L;
        AppMethodBeat.o(273731);
        return;
        i = 0;
        break;
        label132:
        paramString1 = null;
      }
    }
    label137:
    paramString1 = (d)this;
    paramString2 = paramString1.hNX();
    paramString2.Eiw.erx();
    paramString2 = paramString2.Eiv;
    if (paramString2 != null) {
      paramString2.a(null);
    }
    paramString1.hNX().eLR();
    paramString1 = paramString1.WFZ;
    if (paramString1 != null)
    {
      paramString1.setVisibility(0);
      AppMethodBeat.o(273731);
      return;
    }
    AppMethodBeat.o(273731);
  }
  
  public final boolean aDV()
  {
    return true;
  }
  
  public final void avz(int paramInt)
  {
    AppMethodBeat.i(273734);
    y localy = new y();
    long l;
    if (hNW().Rh(z.bcZ())) {
      l = 1L;
    }
    for (;;)
    {
      localy.cg(l);
      localy.ci(paramInt);
      localy.iN(this.fxT);
      localy.ch(hNW().field_memberCount);
      localy.ck(this.WGd);
      localy.cj(this.WGe);
      localy.bpa();
      c localc = c.Yyz;
      c.a((com.tencent.mm.plugin.report.a)localy);
      AppMethodBeat.o(273734);
      return;
      if (hNW().bvA(z.bcZ())) {
        l = 2L;
      } else {
        l = 3L;
      }
    }
  }
  
  public final View bAI()
  {
    AppMethodBeat.i(273730);
    View localView = LayoutInflater.from(getContext()).inflate(R.i.ebK, null);
    p.j(localView, "LayoutInflater.from(cont….at_someone_dialog, null)");
    AppMethodBeat.o(273730);
    return localView;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean) {}
  
  public final ah hNW()
  {
    AppMethodBeat.i(273725);
    ah localah = (ah)this.WGb.getValue();
    AppMethodBeat.o(273725);
    return localah;
  }
  
  public final void initContentView()
  {
    AppMethodBeat.i(273729);
    super.initContentView();
    Object localObject = hWQ();
    if (localObject != null)
    {
      localObject = ((View)localObject).findViewById(R.h.close_btn);
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)new d.f(this));
      }
    }
    localObject = hWQ();
    if (localObject != null)
    {
      localObject = (FTSEditTextView)((View)localObject).findViewById(R.h.fts_edittext);
      this.PAG = ((FTSEditTextView)localObject);
      localObject = this.PAG;
      if (localObject != null) {
        ((FTSEditTextView)localObject).hXB();
      }
      localObject = this.PAG;
      if (localObject != null) {
        ((FTSEditTextView)localObject).setFtsEditTextListener((FTSEditTextView.b)this);
      }
      localObject = this.PAG;
      if (localObject != null)
      {
        Context localContext = getContext();
        p.j(localContext, "context");
        ((FTSEditTextView)localObject).setHint(localContext.getResources().getString(R.l.app_search));
      }
      localObject = this.PAG;
      if (localObject != null) {
        ((FTSEditTextView)localObject).hXN();
      }
      localObject = hWQ();
      if (localObject == null) {
        break label365;
      }
      localObject = (WxRecyclerView)((View)localObject).findViewById(R.h.dvr);
      label168:
      this.xUj = ((WxRecyclerView)localObject);
      localObject = this.xUj;
      if (localObject != null) {
        ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)hNY());
      }
      localObject = this.xUj;
      if (localObject != null) {
        ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)fhl());
      }
      hNY().YSW = ((com.tencent.mm.view.recyclerview.g)this.WGf.getValue());
      localObject = hWQ();
      if (localObject == null) {
        break label370;
      }
    }
    label365:
    label370:
    for (localObject = (AlphabetScrollBar)((View)localObject).findViewById(R.h.dqU);; localObject = null)
    {
      this.WFZ = ((AlphabetScrollBar)localObject);
      localObject = this.WFZ;
      if (localObject != null) {
        ((AlphabetScrollBar)localObject).setOnScrollBarTouchListener((VerticalScrollBar.a)new g(this));
      }
      localObject = this.WFZ;
      if (localObject != null) {
        ((AlphabetScrollBar)localObject).setAlphabet(new String[] { "🔍", "#" });
      }
      hNX().EhK.a((androidx.lifecycle.l)this, (s)new h(this));
      setOnCancelListener((DialogInterface.OnCancelListener)new d.i(this));
      AppMethodBeat.o(273729);
      return;
      localObject = null;
      break;
      localObject = null;
      break label168;
    }
  }
  
  public final void onClickClearTextBtn(View paramView) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<h<f>>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.livelist.a.a<f>>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onScollBarTouch"})
  static final class g
    implements VerticalScrollBar.a
  {
    g(d paramd) {}
    
    public final void KH(String paramString)
    {
      AppMethodBeat.i(221101);
      d locald = this.WGi;
      if ((p.h(d.a(locald), paramString) ^ true))
      {
        locald.WGe += 1;
        p.j(paramString, "it");
        d.a(locald, paramString);
      }
      if (p.h(paramString, "🔍"))
      {
        d.b(locald).au(0, 0);
        AppMethodBeat.o(221101);
        return;
      }
      Iterator localIterator = ((Iterable)d.c(locald).mXB).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (f)localObject;
        if ((p.h(((f)localObject).WGn, paramString)) && (((f)localObject).WGl))
        {
          d.b(locald).au(i, 0);
          AppMethodBeat.o(221101);
          return;
        }
        i += 1;
      }
      AppMethodBeat.o(221101);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class h<T>
    implements s<List<? extends f>>
  {
    h(d paramd) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<AtSomeoneLiveList>
  {
    k(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1", "invoke", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1;"})
  static final class l
    extends q
    implements kotlin.g.a.a<1>
  {
    l(d paramd, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.d
 * JD-Core Version:    0.7.0.1
 */