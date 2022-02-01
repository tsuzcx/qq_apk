package com.tencent.mm.ui.mvvm;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.selectcontact.a.b;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.d;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.contact.LabelContainerView.a;
import com.tencent.mm.ui.mvvm.b.c;
import com.tencent.mm.ui.mvvm.b.e;
import com.tencent.mm.ui.mvvm.b.g;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "_56dp", "", "get_56dp", "()I", "_56dp$delegate", "Lkotlin/Lazy;", "alphabetScrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "getAlphabetScrollBar", "()Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "setAlphabetScrollBar", "(Lcom/tencent/mm/ui/base/AlphabetScrollBar;)V", "isLabelNotLoading", "", "labelContainer", "Lcom/tencent/mm/ui/contact/LabelContainerView;", "labelHeaderText", "Landroid/widget/TextView;", "labelPanel", "Lcom/tencent/mm/ui/base/MMTagPanel;", "labelStrList", "", "", "noResultTV", "getNoResultTV", "()Landroid/widget/TextView;", "setNoResultTV", "(Landroid/widget/TextView;)V", "searchListener", "Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$SelectContactListener;", "getSearchListener", "()Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$SelectContactListener;", "searchListener$delegate", "searchNoResultView", "Landroid/view/View;", "getSearchNoResultView", "()Landroid/view/View;", "setSearchNoResultView", "(Landroid/view/View;)V", "selectContactView", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;", "getSelectContactView", "()Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;", "selectContactView$delegate", "shadowView", "getShadowView", "setShadowView", "clearSearchFocus", "", "clearSearchText", "dispatchAction", "action", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "getLayoutId", "initLabelPanel", "liveListUIC", "Lcom/tencent/mm/ui/mvvm/uic/SelectContactLiveListApiUIC;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "selectLabel", "tag", "setInitStatus", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateLabelList", "updateLabelPanel", "hasFocus", "query", "Companion", "SelectContactListener", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseMvvmSelectContactUI
  extends MMSecDataActivity
{
  public static final BaseMvvmSelectContactUI.a afAo = new BaseMvvmSelectContactUI.a((byte)0);
  View NfI;
  private final j afAp = kotlin.k.cm((kotlin.g.a.a)new c(this));
  private final j afAq = kotlin.k.cm((kotlin.g.a.a)new h(this));
  private boolean afAr = true;
  private final j afAs = kotlin.k.cm((kotlin.g.a.a)new g(this));
  AlphabetScrollBar afeA;
  private View afeH;
  private TextView afeI;
  private LabelContainerView afeL;
  private TextView afeM;
  private MMTagPanel afeN;
  private List<String> afeP = (List)new ArrayList();
  
  private static final boolean a(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI, MenuItem paramMenuItem)
  {
    s.u(paramBaseMvvmSelectContactUI, "this$0");
    paramBaseMvvmSelectContactUI.onBackPressed();
    return false;
  }
  
  private static final boolean a(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI, View paramView, MotionEvent paramMotionEvent)
  {
    s.u(paramBaseMvvmSelectContactUI, "this$0");
    return false;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void aLa(String paramString)
  {
    s.u(paramString, "tag");
  }
  
  public int getLayoutId()
  {
    return a.f.mvvm_select_contact_ui;
  }
  
  public final MultiSelectContactView jBT()
  {
    return (MultiSelectContactView)this.afAq.getValue();
  }
  
  public final b jBU()
  {
    return (b)this.afAs.getValue();
  }
  
  protected final com.tencent.mm.ui.mvvm.b.d jBV()
  {
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    return (com.tencent.mm.ui.mvvm.b.d)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cq(com.tencent.mm.ui.mvvm.b.d.class);
  }
  
  public void onBackPressed()
  {
    hideVKB();
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new BaseMvvmSelectContactUI..ExternalSyntheticLambda0(this));
    this.NfI = findViewById(a.e.shadow);
    jBT().setVisibility(0);
    this.afeH = findViewById(a.e.no_result_view);
    this.afeI = ((TextView)findViewById(a.e.no_result_tv));
    paramBundle = this.afeH;
    if (paramBundle != null) {
      paramBundle.setOnTouchListener(new BaseMvvmSelectContactUI..ExternalSyntheticLambda1(this));
    }
    this.afeA = ((AlphabetScrollBar)findViewById(a.e.select_contact_scrollbar));
    paramBundle = this.afeA;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = this.afeA;
    if (paramBundle != null) {
      paramBundle.setOnScrollBarTouchListener((VerticalScrollBar.a)jBU());
    }
    this.afeL = ((LabelContainerView)findViewById(a.e.select_contact_label_container));
    paramBundle = this.afeL;
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = paramBundle.findViewById(16908310)) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
    this.afeM = ((TextView)paramBundle);
    paramBundle = this.afeM;
    if (paramBundle != null) {
      paramBundle.setText(a.h.select_contact_by_label_panel);
    }
    paramBundle = this.afeL;
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = paramBundle.findViewById(a.e.contact_label_panel)) {
      throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.MMTagPanel");
    }
    this.afeN = ((MMTagPanel)paramBundle);
    paramBundle = this.afeN;
    if (paramBundle != null) {
      paramBundle.setTagSelectedBG(a.d.tag_white_tab_selector);
    }
    paramBundle = this.afeN;
    if (paramBundle != null) {
      paramBundle.setTagSelectedTextColorRes(a.b.normal_text_color);
    }
    paramBundle = this.afeL;
    if (paramBundle != null) {
      paramBundle.setOnLabelContainerListener((LabelContainerView.a)new d(this));
    }
    paramBundle = this.afeN;
    if (paramBundle != null) {
      paramBundle.setCallBack((MMTagPanel.a)new e(this));
    }
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)this, (kotlin.g.a.b)new f(this));
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1728L, 1L, 1L, false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.afAr)
    {
      this.afAr = false;
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new i(this));
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setSearchNoResultView(View paramView)
  {
    this.afeH = paramView;
  }
  
  public final void setShadowView(View paramView)
  {
    this.NfI = paramView;
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(c.class);
    paramHashSet.add(g.class);
    paramHashSet.add(com.tencent.mm.ui.component.l.i(com.tencent.mm.ui.mvvm.b.a.class, com.tencent.mm.ui.mvvm.b.d.class));
    paramHashSet.add(e.class);
    paramHashSet.add(com.tencent.mm.ui.mvvm.b.b.class);
    paramHashSet.add(com.tencent.mm.ui.mvvm.b.f.class);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$SelectContactListener;", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView$OnSearchTextChangeListener;", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView$OnSearchTextFouceChangeListener;", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView$OnContactSelectChangeListener;", "Lcom/tencent/mm/ui/base/VerticalScrollBar$OnScollBarTouchListener;", "(Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI;)V", "onFoucusChange", "", "fouced", "", "onScollBarTouch", "showHead", "", "onSearchTextChange", "text", "onSelectChange", "action", "", "userName", "scrollToShowHead", "showHeadCode", "top", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements MultiSelectContactView.c, MultiSelectContactView.d, MultiSelectContactView.e, VerticalScrollBar.a
  {
    public b()
    {
      AppMethodBeat.i(250511);
      AppMethodBeat.o(250511);
    }
    
    private final void cR(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(250518);
      BaseMvvmSelectContactUI localBaseMvvmSelectContactUI = this.afAt;
      Object localObject1 = localBaseMvvmSelectContactUI.getStateCenter();
      int i;
      label68:
      Object localObject2;
      label106:
      label122:
      Object localObject3;
      label160:
      label176:
      Object localObject4;
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.ui.mvvm.a.i)((UIStateCenter)localObject1).getState();
        if ((localObject1 != null) && (((com.tencent.mm.ui.mvvm.a.i)localObject1).jBX() == true))
        {
          i = 1;
          if (i == 0) {
            break label340;
          }
          localObject1 = (MvvmList)localBaseMvvmSelectContactUI.jBV().jCf();
          localObject2 = localBaseMvvmSelectContactUI.getStateCenter();
          if (localObject2 == null) {
            break label355;
          }
          localObject2 = (com.tencent.mm.ui.mvvm.a.i)((UIStateCenter)localObject2).getState();
          if ((localObject2 == null) || (((com.tencent.mm.ui.mvvm.a.i)localObject2).jBX() != true)) {
            break label355;
          }
          i = 1;
          if (i == 0) {
            break label360;
          }
          localObject2 = localBaseMvvmSelectContactUI.jBV().jCd();
          localObject3 = localBaseMvvmSelectContactUI.getStateCenter();
          if (localObject3 == null) {
            break label375;
          }
          localObject3 = (com.tencent.mm.ui.mvvm.a.i)((UIStateCenter)localObject3).getState();
          if ((localObject3 == null) || (((com.tencent.mm.ui.mvvm.a.i)localObject3).jBX() != true)) {
            break label375;
          }
          i = 1;
          if (i == 0) {
            break label380;
          }
          localObject3 = localBaseMvvmSelectContactUI.jBV().jCa();
          localObject4 = localBaseMvvmSelectContactUI.getStateCenter();
          if (localObject4 == null) {
            break label395;
          }
          localObject4 = (com.tencent.mm.ui.mvvm.a.i)((UIStateCenter)localObject4).getState();
          if ((localObject4 == null) || (((com.tencent.mm.ui.mvvm.a.i)localObject4).jBX() != true)) {
            break label395;
          }
          i = 1;
          label214:
          if (i == 0) {
            break label400;
          }
          localObject4 = localBaseMvvmSelectContactUI.jBV().jCe();
          label230:
          if (paramBoolean) {
            break label428;
          }
          localObject1 = ((Iterable)((MvvmList)localObject1).pUj).iterator();
          i = 0;
        }
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label422;
        }
        Object localObject5 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject5 = (com.tencent.mm.ui.mvvm.item.b)localObject5;
        if ((((com.tencent.mm.ui.mvvm.item.b)localObject5).FWv == paramInt) && (((com.tencent.mm.ui.mvvm.item.b)localObject5).FWu))
        {
          ((WxRecyclerView)localObject2).JO();
          ((WxLinearLayoutManager)localObject3).bo(((com.tencent.mm.view.recyclerview.i)localObject4).agOb.size() + i, BaseMvvmSelectContactUI.a(localBaseMvvmSelectContactUI));
          AppMethodBeat.o(250518);
          return;
          i = 0;
          break;
          label340:
          localObject1 = localBaseMvvmSelectContactUI.jBV().gNg();
          break label68;
          label355:
          i = 0;
          break label106;
          label360:
          localObject2 = localBaseMvvmSelectContactUI.jBV().getRecyclerView();
          break label122;
          label375:
          i = 0;
          break label160;
          label380:
          localObject3 = localBaseMvvmSelectContactUI.jBV().fcq();
          break label176;
          label395:
          i = 0;
          break label214;
          label400:
          localObject4 = localBaseMvvmSelectContactUI.jBV().fcp();
          break label230;
        }
        i += 1;
      }
      label422:
      AppMethodBeat.o(250518);
      return;
      label428:
      ((WxLinearLayoutManager)localObject3).bo(0, BaseMvvmSelectContactUI.a(localBaseMvvmSelectContactUI));
      AppMethodBeat.o(250518);
    }
    
    public final void JC(boolean paramBoolean)
    {
      AppMethodBeat.i(250527);
      Log.i("MicroMsg.SelectContact.BaseMvvmSelectContactUI", s.X("onFoucusChange ", Boolean.valueOf(paramBoolean)));
      UIStateCenter localUIStateCenter = this.afAt.getStateCenter();
      Object localObject;
      if (localUIStateCenter != null)
      {
        localObject = this.afAt.jBT().getSearchContent();
        if (localObject != null) {
          break label74;
        }
        localObject = "";
      }
      for (;;)
      {
        localUIStateCenter.dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.d(paramBoolean, (String)localObject));
        AppMethodBeat.o(250527);
        return;
        label74:
        String str = n.bq((CharSequence)localObject).toString();
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
    }
    
    public final void ad(int paramInt, String paramString)
    {
      AppMethodBeat.i(250534);
      Log.i("MicroMsg.SelectContact.BaseMvvmSelectContactUI", "onSelectChange " + paramInt + ' ' + paramString);
      if ((paramInt == 1) && (paramString != null)) {
        BaseMvvmSelectContactUI.a(this.afAt, (IStateAction)new com.tencent.mm.ui.mvvm.a.l(paramString));
      }
      AppMethodBeat.o(250534);
    }
    
    public final void bqJ(String paramString)
    {
      AppMethodBeat.i(250522);
      Log.i("MicroMsg.SelectContact.BaseMvvmSelectContactUI", s.X("onSearchTextChange ", paramString));
      if (paramString == null) {
        paramString = "";
      }
      for (;;)
      {
        String str = cn.bDw() + '_' + paramString;
        UIStateCenter localUIStateCenter = this.afAt.getStateCenter();
        if (localUIStateCenter != null) {
          localUIStateCenter.dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.f(str, paramString));
        }
        AppMethodBeat.o(250522);
        return;
        paramString = n.bq((CharSequence)paramString).toString();
        if (paramString == null) {
          paramString = "";
        }
      }
    }
    
    public final void onScollBarTouch(String paramString)
    {
      AppMethodBeat.i(250543);
      if (paramString != null) {
        switch (paramString.hashCode())
        {
        }
      }
      do
      {
        do
        {
          do
          {
            paramString = paramString.toCharArray();
            s.s(paramString, "(this as java.lang.String).toCharArray()");
            paramString = kotlin.a.k.c(paramString);
            if (paramString != null) {
              cR(paramString.charValue(), false);
            }
            AppMethodBeat.o(250543);
            return;
          } while (!paramString.equals("↑"));
          cR(0, true);
          AppMethodBeat.o(250543);
          return;
        } while (!paramString.equals("#"));
        cR(123, false);
        AppMethodBeat.o(250543);
        return;
      } while (!paramString.equals("☆"));
      cR(32, false);
      AppMethodBeat.o(250543);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    c(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$initLabelPanel$1", "Lcom/tencent/mm/ui/contact/LabelContainerView$IOnLabelContainerListener;", "hideKB", "", "singleTap", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements LabelContainerView.a
  {
    d(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI) {}
    
    public final void dCv()
    {
      AppMethodBeat.i(250509);
      if (this.afAt.jBT() != null) {
        this.afAt.jBT().clearFocus();
      }
      LabelContainerView localLabelContainerView = BaseMvvmSelectContactUI.b(this.afAt);
      if (localLabelContainerView != null) {
        localLabelContainerView.requestFocus();
      }
      localLabelContainerView = BaseMvvmSelectContactUI.b(this.afAt);
      if (localLabelContainerView != null) {
        localLabelContainerView.setVisibility(8);
      }
      this.afAt.hideVKB();
      AppMethodBeat.o(250509);
    }
    
    public final void dCw()
    {
      AppMethodBeat.i(250513);
      this.afAt.hideVKB();
      AppMethodBeat.o(250513);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$initLabelPanel$2", "Lcom/tencent/mm/ui/base/MMTagPanel$ICallBack;", "onTagCreate", "", "tag", "", "onTagEditTextChange", "curText", "onTagEditTextClick", "onTagLengthMax", "match", "", "exceedCount", "", "onTagRemove", "onTagSelected", "onTagUnSelected", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MMTagPanel.a
  {
    e(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI) {}
    
    public final void G(boolean paramBoolean, int paramInt) {}
    
    public final void aoT(String paramString)
    {
      AppMethodBeat.i(250505);
      s.u(paramString, "tag");
      AppMethodBeat.o(250505);
    }
    
    public final void aoU(String paramString)
    {
      AppMethodBeat.i(250512);
      s.u(paramString, "tag");
      this.afAt.aLa(paramString);
      AppMethodBeat.o(250512);
    }
    
    public final void aoV(String paramString)
    {
      AppMethodBeat.i(250516);
      s.u(paramString, "tag");
      AppMethodBeat.o(250516);
    }
    
    public final void aoW(String paramString)
    {
      AppMethodBeat.i(250525);
      s.u(paramString, "curText");
      AppMethodBeat.o(250525);
    }
    
    public final void aoX(String paramString)
    {
      AppMethodBeat.i(250529);
      s.u(paramString, "tag");
      AppMethodBeat.o(250529);
    }
    
    public final void dCx() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.mvvm.a.i, ah>
  {
    f(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$onCreate$3$1$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.l
    {
      a(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI) {}
      
      public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
      {
        AppMethodBeat.i(250495);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramRecyclerView);
        localb.sc(paramInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$onCreate$3$1$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramRecyclerView, paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$onCreate$3$1$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(250495);
      }
      
      public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(250488);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$onCreate$3$1$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        s.u(paramRecyclerView, "recyclerView");
        if (this.afAt.jBV().fcq().Ju() == 0)
        {
          paramRecyclerView = paramRecyclerView.getChildAt(0);
          if (paramRecyclerView != null) {
            break label125;
          }
          paramRecyclerView = null;
          if (paramRecyclerView == null)
          {
            paramRecyclerView = this.afAt.NfI;
            if (paramRecyclerView != null) {
              paramRecyclerView.setVisibility(8);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$onCreate$3$1$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(250488);
        return;
        label125:
        localObject = this.afAt;
        if (paramRecyclerView.getTop() == 0)
        {
          paramRecyclerView = ((BaseMvvmSelectContactUI)localObject).NfI;
          if (paramRecyclerView != null) {
            paramRecyclerView.setVisibility(8);
          }
        }
        for (;;)
        {
          paramRecyclerView = ah.aiuX;
          break;
          paramRecyclerView = ((BaseMvvmSelectContactUI)localObject).NfI;
          if (paramRecyclerView != null) {
            paramRecyclerView.setVisibility(0);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI$SelectContactListener;", "Lcom/tencent/mm/ui/mvvm/BaseMvvmSelectContactUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<BaseMvvmSelectContactUI.b>
  {
    g(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/MultiSelectContactView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<MultiSelectContactView>
  {
    h(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(BaseMvvmSelectContactUI paramBaseMvvmSelectContactUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.BaseMvvmSelectContactUI
 * JD-Core Version:    0.7.0.1
 */