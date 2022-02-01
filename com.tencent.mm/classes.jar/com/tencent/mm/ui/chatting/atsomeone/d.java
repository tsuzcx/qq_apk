package com.tencent.mm.ui.chatting.atsomeone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.abv;
import com.tencent.mm.autogen.mmdata.rpt.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.util.c;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog;", "Lcom/tencent/mm/ui/dialog/HalfScreenDialog;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "context", "Landroid/content/Context;", "chatroom", "", "callback", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;)V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getCallback", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneCallback;", "getChatroom", "()Ljava/lang/String;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "kotlin.jvm.PlatformType", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "chatroomMember$delegate", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "dataSource$delegate", "ftsEditTextView", "Lcom/tencent/mm/ui/search/FTSEditTextView;", "isUseSearch", "", "()J", "setUseSearch", "(J)V", "lastTouchAlphabet", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "liveList", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "getLiveList", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;", "liveList$delegate", "onItemClickListener", "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1;", "onItemClickListener$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "searchDataSource", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "getSearchDataSource", "()Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;", "searchDataSource$delegate", "touchAlphabetCount", "", "getTouchAlphabetCount", "()I", "setTouchAlphabetCount", "(I)V", "at", "", "displayName", "username", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "inflateContentView", "Landroid/view/View;", "initContentView", "onClickClearTextBtn", "view", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "reportAtUser", "action", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.ui.f.a
  implements FTSEditTextView.c
{
  public static final d.a aenB;
  private WxRecyclerView AZd;
  private final j DHL;
  private final j DHM;
  private final j EKZ;
  private FTSEditTextView FWg;
  private AlphabetScrollBar FWh;
  private final j FWi;
  private String FWj;
  private long FWk;
  private int FWl;
  private final j FWm;
  private final b aenC;
  private final j aenD;
  final String hCy;
  private final j xZP;
  
  static
  {
    AppMethodBeat.i(254235);
    aenB = new d.a((byte)0);
    AppMethodBeat.o(254235);
  }
  
  public d(Context paramContext, String paramString, b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(254190);
    this.hCy = paramString;
    this.aenC = paramb;
    this.DHL = k.cm((kotlin.g.a.a)new e(this));
    this.DHM = k.cm((kotlin.g.a.a)new i(this));
    this.aenD = k.cm((kotlin.g.a.a)new d(this));
    this.FWi = k.cm((kotlin.g.a.a)new g(this));
    this.xZP = k.cm((kotlin.g.a.a)new b(this));
    this.EKZ = k.cm((kotlin.g.a.a)new f(paramContext));
    paramString = new abv();
    paramString.ifq.delay = 0L;
    paramString.publish();
    this.FWj = "";
    this.FWm = k.cm((kotlin.g.a.a)new h(paramContext, this));
    AppMethodBeat.o(254190);
  }
  
  private static final void a(d paramd, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(254220);
    s.u(paramd, "this$0");
    paramd.aCb(3);
    AppMethodBeat.o(254220);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(254213);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254213);
  }
  
  private static final void a(d paramd, String paramString)
  {
    AppMethodBeat.i(254215);
    s.u(paramd, "this$0");
    if (!s.p(paramd.FWj, paramString))
    {
      paramd.FWl += 1;
      s.s(paramString, "it");
      paramd.FWj = paramString;
    }
    if (s.p(paramString, "🔍"))
    {
      paramd.fcq().bo(0, 0);
      AppMethodBeat.o(254215);
      return;
    }
    Iterator localIterator = ((Iterable)paramd.jqE().pUj).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (f)localObject;
      if ((s.p(((f)localObject).FWw, paramString)) && (((f)localObject).FWu))
      {
        paramd.fcq().bo(i, 0);
        AppMethodBeat.o(254215);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(254215);
  }
  
  private static final void a(d paramd, List paramList)
  {
    AppMethodBeat.i(254217);
    s.u(paramd, "this$0");
    paramList = paramd.FWh;
    if (paramList != null)
    {
      paramd = ((Collection)paramd.jqE().FWy).toArray(new String[0]);
      if (paramd == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(254217);
        throw paramd;
      }
      paramList.setAlphabet((String[])paramd);
    }
    AppMethodBeat.o(254217);
  }
  
  private void aCb(int paramInt)
  {
    AppMethodBeat.i(254208);
    ab localab = new ab();
    long l;
    if (jqD().Jf(z.bAM())) {
      l = 1L;
    }
    for (;;)
    {
      localab.imY = l;
      localab.ikE = paramInt;
      localab.imN = localab.F("ChatName", this.hCy, true);
      localab.imZ = jqD().field_memberCount;
      localab.inb = this.FWk;
      localab.ina = this.FWl;
      localab.bMH();
      c localc = c.agsX;
      c.a((com.tencent.mm.plugin.report.a)localab);
      AppMethodBeat.o(254208);
      return;
      if (jqD().bvK(z.bAM())) {
        l = 2L;
      } else {
        l = 3L;
      }
    }
  }
  
  private final com.tencent.mm.plugin.mvvmlist.g<f> fcp()
  {
    AppMethodBeat.i(254197);
    com.tencent.mm.plugin.mvvmlist.g localg = (com.tencent.mm.plugin.mvvmlist.g)this.xZP.getValue();
    AppMethodBeat.o(254197);
    return localg;
  }
  
  private final WxLinearLayoutManager fcq()
  {
    AppMethodBeat.i(254202);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(254202);
    return localWxLinearLayoutManager;
  }
  
  private final AtSomeoneLiveList jqE()
  {
    AppMethodBeat.i(254194);
    AtSomeoneLiveList localAtSomeoneLiveList = (AtSomeoneLiveList)this.FWi.getValue();
    AppMethodBeat.o(254194);
    return localAtSomeoneLiveList;
  }
  
  public final boolean aWU()
  {
    return true;
  }
  
  public final View bZy()
  {
    AppMethodBeat.i(254257);
    View localView = LayoutInflater.from(getContext()).inflate(R.i.ges, null);
    s.s(localView, "from(context).inflate(R.….at_someone_dialog, null)");
    AppMethodBeat.o(254257);
    return localView;
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean) {}
  
  public final void initContentView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(254255);
    super.initContentView();
    Object localObject1 = jBj();
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(R.h.close_btn);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new d..ExternalSyntheticLambda1(this));
      }
    }
    localObject1 = jBj();
    if (localObject1 == null)
    {
      localObject1 = null;
      this.FWg = ((FTSEditTextView)localObject1);
      localObject1 = this.FWg;
      if (localObject1 != null) {
        ((FTSEditTextView)localObject1).jBL();
      }
      localObject1 = this.FWg;
      if (localObject1 != null) {
        ((FTSEditTextView)localObject1).setFtsEditTextListener((FTSEditTextView.c)this);
      }
      localObject1 = this.FWg;
      if (localObject1 != null) {
        ((FTSEditTextView)localObject1).setHint(getContext().getResources().getString(R.l.app_search));
      }
      localObject1 = this.FWg;
      if (localObject1 != null) {
        ((FTSEditTextView)localObject1).jCu();
      }
      localObject1 = jBj();
      if (localObject1 != null) {
        break label329;
      }
      localObject1 = null;
      label141:
      this.AZd = ((WxRecyclerView)localObject1);
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)fcp());
      }
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)fcq());
      }
      fcp().agOO = ((h)this.FWm.getValue());
      localObject1 = jBj();
      if (localObject1 != null) {
        break label343;
      }
    }
    label329:
    label343:
    for (localObject1 = localObject2;; localObject1 = (AlphabetScrollBar)((View)localObject1).findViewById(R.h.alphabet_scrollbar))
    {
      this.FWh = ((AlphabetScrollBar)localObject1);
      localObject1 = this.FWh;
      if (localObject1 != null) {
        ((AlphabetScrollBar)localObject1).setOnScrollBarTouchListener(new d..ExternalSyntheticLambda3(this));
      }
      localObject1 = this.FWh;
      if (localObject1 != null) {
        ((AlphabetScrollBar)localObject1).setAlphabet(new String[] { "🔍", "#" });
      }
      jqE().MmR.a((q)this, new d..ExternalSyntheticLambda2(this));
      setOnCancelListener(new d..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(254255);
      return;
      localObject1 = (FTSEditTextView)((View)localObject1).findViewById(R.h.fts_edittext);
      break;
      localObject1 = (WxRecyclerView)((View)localObject1).findViewById(R.h.chatroom_member_rv);
      break label141;
    }
  }
  
  public final aj jqD()
  {
    AppMethodBeat.i(254250);
    aj localaj = (aj)this.aenD.getValue();
    AppMethodBeat.o(254250);
    return localaj;
  }
  
  public final void onClickClearTextBtn(View paramView) {}
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    AppMethodBeat.i(254260);
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      if (paramString1 == null)
      {
        paramString1 = (d)this;
        paramString1.jqE().eui();
        paramString1.jqE().gsy();
        paramString1 = paramString1.FWh;
        if (paramString1 != null) {
          paramString1.setVisibility(0);
        }
      }
      AppMethodBeat.o(254260);
      return;
      int i;
      if (!n.bp((CharSequence)paramString1))
      {
        i = 1;
        label69:
        if (i == 0) {
          break label89;
        }
      }
      for (;;)
      {
        if (paramString1 != null) {
          break label94;
        }
        paramString1 = null;
        break;
        i = 0;
        break label69;
        label89:
        paramString1 = null;
      }
      label94:
      jqE().gd(paramString1);
      paramString1 = this.FWh;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      this.FWk = 1L;
      paramString1 = ah.aiuX;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.g<f>>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    c(d paramd) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(254150);
      if (paramInt == 1)
      {
        localObject = this.aenE.jqD();
        s.s(localObject, "chatroomMember");
        localObject = (com.tencent.mm.view.recyclerview.f)new g((aj)localObject);
        AppMethodBeat.o(254150);
        return localObject;
      }
      Object localObject = this.aenE.jqD();
      s.s(localObject, "chatroomMember");
      localObject = (com.tencent.mm.view.recyclerview.f)new e((aj)localObject);
      AppMethodBeat.o(254150);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/storage/ChatRoomMember;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<aj>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.mvvmlist.a.a<f>>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    f(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<AtSomeoneLiveList>
  {
    g(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$onItemClickListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<1>
  {
    h(Context paramContext, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchDataSource;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<AtSomeoneSearchDataSource>
  {
    i(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.d
 * JD-Core Version:    0.7.0.1
 */