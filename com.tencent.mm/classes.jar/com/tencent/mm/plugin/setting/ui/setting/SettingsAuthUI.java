package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.h;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.q;
import com.tencent.mm.plugin.setting.model.r;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.pulldown.f;
import com.tencent.mm.ui.y;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "clickPosition", "", "containerViewHeight", "hasAddSearchMenu", "", "isLoadingMore", "isShowingEmptyView", "mAdapter", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter;", "mLoadingFooterView", "Landroid/view/View;", "mPopupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "mTitleHeaderView", "nextPageData", "", "originActionBarColor", "Ljava/lang/Integer;", "rootViewHeight", "tipsDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "titleAnimationEndOffset", "titleAnimationStartOffset", "titleHeaderHeight", "checkShowEmptyView", "", "doDelUserAuth", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "getLayoutId", "initFullScreen", "loadMoreData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "refreshView", "showDelAuthBottomSheet", "showErrorTips", "show", "showLoadingView", "showTipsView", "tips", "", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateOptionMenu", "updateViewParams", "Companion", "SettingsAuthListAdapter", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingsAuthUI
  extends MMActivity
{
  public static final SettingsAuthUI.a PrY;
  private int ERV = -1;
  private byte[] PnI;
  private View PrZ;
  private int Psa;
  private int Psb;
  private int Psc;
  private int Psd;
  private int Pse = -1;
  private b Psf;
  private Integer Psg;
  private boolean Psh;
  private boolean Psi;
  private w Psj;
  private com.tencent.mm.ui.widget.b.a Psk;
  private boolean isLoadingMore;
  private View wDF;
  
  static
  {
    AppMethodBeat.i(299024);
    PrY = new SettingsAuthUI.a((byte)0);
    AppMethodBeat.o(299024);
  }
  
  private final void CJ(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(298913);
    Log.i("MicroMsg.SettingsAuthUI", kotlin.g.b.s.X("alvinluo showLoading show: ", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      Object localObject = this.Psf;
      ProgressBar localProgressBar;
      if ((localObject != null) && (((b)localObject).isEmpty() == true))
      {
        if (i == 0) {
          break label151;
        }
        localProgressBar = (ProgressBar)findViewById(b.f.settings_auth_loading);
        localObject = ((ProgressBar)findViewById(b.f.settings_auth_loading)).getLayoutParams();
        if (localObject != null) {
          break label109;
        }
        localObject = null;
      }
      for (;;)
      {
        localProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
        ((ProgressBar)findViewById(b.f.settings_auth_loading)).setVisibility(0);
        AppMethodBeat.o(298913);
        return;
        i = 0;
        break;
        label109:
        if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.Pse * 0.3F) - getResources().getDimensionPixelSize(b.d.Edge_1_2_5_A));
        }
        ah localah = ah.aiuX;
      }
    }
    label151:
    ((ProgressBar)findViewById(b.f.settings_auth_loading)).setVisibility(8);
    AppMethodBeat.o(298913);
  }
  
  private final void CK(boolean paramBoolean)
  {
    AppMethodBeat.i(298918);
    Object localObject = (LinearLayout)findViewById(b.f.settings_auth_error_layout);
    int i;
    LinearLayout localLinearLayout;
    if (paramBoolean)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      if (!paramBoolean) {
        break label186;
      }
      localLinearLayout = (LinearLayout)findViewById(b.f.settings_auth_error_layout);
      localObject = ((LinearLayout)findViewById(b.f.settings_auth_error_layout)).getLayoutParams();
      if (localObject != null) {
        break label118;
      }
      localObject = null;
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (h.aZW().bFQ() != 0) {
        break label160;
      }
      ((TextView)findViewById(b.f.settings_auth_error_tips)).setText((CharSequence)getResources().getString(b.i.settings_auth_list_network_error));
      AppMethodBeat.o(298918);
      return;
      i = 8;
      break;
      label118:
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)(this.Pse * 0.3F) - getResources().getDimensionPixelSize(b.d.Edge_3_5_A));
      }
      ah localah = ah.aiuX;
    }
    label160:
    ((TextView)findViewById(b.f.settings_auth_error_tips)).setText((CharSequence)getResources().getString(b.i.settings_auth_list_load_failed));
    label186:
    AppMethodBeat.o(298918);
  }
  
  private static final void a(ProgressBar paramProgressBar, SettingsAuthUI paramSettingsAuthUI, View paramView)
  {
    AppMethodBeat.i(298938);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramProgressBar);
    localb.cH(paramSettingsAuthUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    paramProgressBar.setVisibility(0);
    paramView.setVisibility(8);
    paramSettingsAuthUI.bXB();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298938);
  }
  
  private static final void a(ProgressBar paramProgressBar, SettingsAuthUI paramSettingsAuthUI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(298943);
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    if (paramProgressBar.getVisibility() == 0) {
      paramSettingsAuthUI.bXB();
    }
    AppMethodBeat.o(298943);
  }
  
  private static final void a(SettingsAuthUI paramSettingsAuthUI, View paramView)
  {
    AppMethodBeat.i(298951);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSettingsAuthUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    paramSettingsAuthUI.CK(false);
    paramSettingsAuthUI.CJ(true);
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paramSettingsAuthUI = paramSettingsAuthUI.getContext();
    kotlin.g.b.s.s(paramSettingsAuthUI, "context");
    com.tencent.mm.ui.component.k.d(paramSettingsAuthUI).q(d.class);
    d.ct(null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(298951);
  }
  
  private static final void a(SettingsAuthUI paramSettingsAuthUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(298968);
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    params.a(1, paramSettingsAuthUI.getResources().getColor(b.c.red_text_color), (CharSequence)paramSettingsAuthUI.getResources().getString(b.i.settings_auth_del_auth));
    AppMethodBeat.o(298968);
  }
  
  private static final void a(fun paramfun, SettingsAuthUI paramSettingsAuthUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(298972);
    kotlin.g.b.s.u(paramfun, "$userAuthApp");
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = c.Pos;
      c.a(203, paramfun);
      Log.i("MicroMsg.SettingsAuthUI", "doDealUserAuth appId: " + paramfun.appid + ", appName: " + paramfun.nSt);
      paramMenuItem = paramSettingsAuthUI.Psj;
      if (paramMenuItem != null) {
        paramMenuItem.dismiss();
      }
      paramSettingsAuthUI.Psj = com.tencent.mm.ui.base.k.a((Context)paramSettingsAuthUI.getContext(), paramSettingsAuthUI.getContext().getString(b.i.settings_auth_del_auth_loading), false, null);
      paramMenuItem = (CharSequence)paramfun.appid;
      if ((paramMenuItem != null) && (paramMenuItem.length() != 0)) {
        break label202;
      }
    }
    label202:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramMenuItem = com.tencent.mm.ui.component.k.aeZF;
        paramSettingsAuthUI = paramSettingsAuthUI.getContext();
        kotlin.g.b.s.s(paramSettingsAuthUI, "context");
        paramMenuItem = (e)com.tencent.mm.ui.component.k.d(paramSettingsAuthUI).q(e.class);
        paramSettingsAuthUI = paramfun.appid;
        paramfun = paramSettingsAuthUI;
        if (paramSettingsAuthUI == null) {
          paramfun = "";
        }
        paramMenuItem.aVD(paramfun);
      }
      AppMethodBeat.o(298972);
      return;
    }
  }
  
  private static final boolean a(SettingsAuthUI paramSettingsAuthUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(298932);
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    paramSettingsAuthUI.finish();
    AppMethodBeat.o(298932);
    return true;
  }
  
  private final void av(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(298920);
    TextView localTextView = (TextView)findViewById(b.f.settings_auth_tips);
    int i;
    if (paramBoolean)
    {
      i = 0;
      localTextView.setVisibility(i);
      ((TextView)findViewById(b.f.settings_auth_tips)).setText((CharSequence)paramString);
      if (paramBoolean)
      {
        localTextView = (TextView)findViewById(b.f.settings_auth_tips);
        paramString = ((TextView)findViewById(b.f.settings_auth_tips)).getLayoutParams();
        if (paramString != null) {
          break label102;
        }
        paramString = null;
      }
    }
    for (;;)
    {
      localTextView.setLayoutParams(paramString);
      AppMethodBeat.o(298920);
      return;
      i = 8;
      break;
      label102:
      if ((paramString instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)paramString).topMargin = ((int)(this.Pse * 0.3F));
      }
      ah localah = ah.aiuX;
    }
  }
  
  private static final boolean b(SettingsAuthUI paramSettingsAuthUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(298959);
    kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
    paramMenuItem = new Intent((Context)paramSettingsAuthUI, SettingsSearchAuthUI.class);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(paramSettingsAuthUI, paramMenuItem.aYi(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "updateOptionMenu$lambda-5", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI;Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramSettingsAuthUI.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramSettingsAuthUI, "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI", "updateOptionMenu$lambda-5", "(Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI;Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.ui.base.b.nd((Context)paramSettingsAuthUI);
    AppMethodBeat.o(298959);
    return true;
  }
  
  private final void bXB()
  {
    AppMethodBeat.i(298904);
    Log.v("MicroMsg.SettingsAuthUI", "loadMoreData isLoadingMore: " + this.isLoadingMore + ", nextPageData: " + this.PnI);
    if (!this.isLoadingMore)
    {
      this.isLoadingMore = true;
      Object localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = getContext();
      kotlin.g.b.s.s(localObject, "context");
      com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(d.class);
      d.ct(this.PnI);
    }
    AppMethodBeat.o(298904);
  }
  
  private final void gVF()
  {
    AppMethodBeat.i(298929);
    Object localObject = this.Psf;
    if ((localObject != null) && (((b)localObject).isEmpty() == true))
    {
      i = 1;
      if (i == 0) {
        break label202;
      }
      this.Psh = true;
      localObject = getResources().getString(b.i.settings_auth_list_empty);
      kotlin.g.b.s.s(localObject, "resources.getString(R.st…settings_auth_list_empty)");
      av(true, (String)localObject);
      localObject = this.Psf;
      if (localObject != null)
      {
        int j = ((b)localObject).getItemCount() - 1;
        SettingsAuthUI.b.d locald = (SettingsAuthUI.b.d)p.ae(((b)localObject).Psm, j);
        if ((locald == null) || (locald.itemType != 2)) {
          break label197;
        }
        i = 1;
        label103:
        if (i != 0)
        {
          ((b)localObject).Psm.remove(j);
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
    }
    for (;;)
    {
      if ((this.Psi) || (this.Psf == null)) {
        break label214;
      }
      localObject = this.Psf;
      kotlin.g.b.s.checkNotNull(localObject);
      if (((b)localObject).isEmpty()) {
        break label214;
      }
      this.Psi = true;
      removeAllOptionMenu();
      addIconOptionMenu(800, b.i.app_search, b.h.icons_outlined_search, new SettingsAuthUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(298929);
      return;
      i = 0;
      break;
      label197:
      i = 0;
      break label103;
      label202:
      this.Psh = false;
      a(this);
    }
    label214:
    localObject = this.Psf;
    if ((localObject != null) && (((b)localObject).isEmpty() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.Psi = false;
        removeAllOptionMenu();
      }
      AppMethodBeat.o(298929);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return b.g.settings_auth;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(299086);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 1000)
    {
      AppMethodBeat.o(299086);
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = this.Psf;
      if ((paramIntent == null) || (paramIntent.aiU(this.ERV) != true)) {
        break label74;
      }
    }
    label74:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        gVF();
      }
      AppMethodBeat.o(299086);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(299072);
    super.onCreate(paramBundle);
    setMMTitle(b.i.settings_auth_manage);
    hideActionbarLine();
    this.Psg = Integer.valueOf(getResources().getColor(b.c.BG_2));
    getMMTitleView().setAlpha(0.0F);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    this.Psa = 0;
    setBackBtn(new SettingsAuthUI..ExternalSyntheticLambda1(this));
    this.Psk = new com.tencent.mm.ui.widget.b.a((Context)this);
    paramBundle = (Context)this;
    Object localObject = (LoadMoreRecyclerView)findViewById(b.f.settings_auth_recycler_view);
    kotlin.g.b.s.s(localObject, "settings_auth_recycler_view");
    this.Psf = new b(paramBundle, (LoadMoreRecyclerView)localObject);
    paramBundle = this.Psf;
    if (paramBundle != null)
    {
      localObject = (SettingsAuthUI.b.c)new c(this);
      kotlin.g.b.s.u(localObject, "onAuthAppItemClickListener");
      paramBundle.Pso = ((SettingsAuthUI.b.c)localObject);
    }
    paramBundle = (LoadMoreRecyclerView)findViewById(b.f.settings_auth_recycler_view);
    paramBundle.setAdapter((RecyclerView.a)this.Psf);
    paramBundle.getContext();
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    paramBundle.setItemAnimator(null);
    this.wDF = LayoutInflater.from(paramBundle.getContext()).inflate(b.g.layout_settings_auth_list_loading_more, null);
    localObject = this.wDF;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = (ProgressBar)((View)localObject).findViewById(b.f.loading_progress_bar);
    View localView = this.wDF;
    kotlin.g.b.s.checkNotNull(localView);
    ((LinearLayout)localView.findViewById(b.f.loading_reload_layout)).setOnClickListener(new SettingsAuthUI..ExternalSyntheticLambda2((ProgressBar)localObject, this));
    localView = this.wDF;
    kotlin.g.b.s.checkNotNull(localView);
    paramBundle.setLoadingView(localView);
    paramBundle.showLoading(false);
    paramBundle.setOnLoadingStateChangedListener(new SettingsAuthUI..ExternalSyntheticLambda4((ProgressBar)localObject, this));
    this.PrZ = LayoutInflater.from(paramBundle.getContext()).inflate(b.g.layout_settings_auth_list_title, null);
    localObject = this.PrZ;
    kotlin.g.b.s.checkNotNull(localObject);
    aw.a((Paint)((TextView)((View)localObject).findViewById(b.f.settings_auth_list_title)).getPaint(), 0.8F);
    localObject = this.PrZ;
    kotlin.g.b.s.checkNotNull(localObject);
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new d(this));
    localObject = this.PrZ;
    kotlin.g.b.s.checkNotNull(localObject);
    paramBundle.ev((View)localObject);
    paramBundle.a((RecyclerView.l)new e(this));
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = getContext();
    kotlin.g.b.s.s(paramBundle, "context");
    ((d)com.tencent.mm.ui.component.k.d(paramBundle).q(d.class)).PrT = ((d.b)new f(this));
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = getContext();
    kotlin.g.b.s.s(paramBundle, "context");
    ((e)com.tencent.mm.ui.component.k.d(paramBundle).q(e.class)).PrX = ((e.b)new g(this));
    ((RelativeLayout)findViewById(b.f.root_container)).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
    ((LinearLayout)findViewById(b.f.settings_auth_error_layout)).setOnClickListener(new SettingsAuthUI..ExternalSyntheticLambda3(this));
    int i = getResources().getDimensionPixelSize(b.d.Edge_2A);
    Util.expandViewTouchArea((View)findViewById(b.f.settings_auth_reload_button), i, i, i, i);
    AppMethodBeat.o(299072);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(299082);
    super.onDestroy();
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    ((d)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(d.class)).PrT = null;
    localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    ((e)com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject).q(e.class)).PrX = null;
    AppMethodBeat.o(299082);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(299078);
    super.onResume();
    setActionbarColor(getResources().getColor(b.c.BG_2));
    Object localObject = getController();
    Integer localInteger = this.Psg;
    kotlin.g.b.s.checkNotNull(localInteger);
    ((y)localObject).setStatusBarColor(localInteger.intValue());
    localObject = getBounceView();
    if (localObject != null) {
      ((f)localObject).setStart2EndBgColor(getResources().getColor(b.c.BG_2));
    }
    AppMethodBeat.o(299078);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(299057);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(d.class);
    paramHashSet.add(e.class);
    AppMethodBeat.o(299057);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "recyclerView", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "appNameViewMaxWidth", "", "appTypeViewMaxWidth", "contentWidth", "dataSize", "loadFinished", "", "loadFirst", "mAuthList", "", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$UserAuthAppWrapper;", "onItemClickListener", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$OnAuthAppItemClickListener;", "x_down", "y_down", "getItemCount", "getItemViewType", "position", "isEmpty", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeAuthItem", "removeFooter", "type", "setOnAuthItemClickListener", "onAuthAppItemClickListener", "updateAuthData", "authData", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$SettingsAuthData;", "updateAuthItem", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$AuthItemVieHolder;", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "AuthItemType", "AuthItemVieHolder", "FooterViewHolder", "OnAuthAppItemClickListener", "UserAuthAppWrapper", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    final LoadMoreRecyclerView Psl;
    final List<SettingsAuthUI.b.d> Psm;
    boolean Psn;
    c Pso;
    private int Psp;
    private int Psq;
    private int contentWidth;
    private final Context context;
    int dataSize;
    boolean loadFinished;
    private int x_down;
    private int y_down;
    
    public b(Context paramContext, LoadMoreRecyclerView paramLoadMoreRecyclerView)
    {
      AppMethodBeat.i(298673);
      this.context = paramContext;
      this.Psl = paramLoadMoreRecyclerView;
      this.Psm = ((List)new ArrayList());
      this.Psn = true;
      this.contentWidth = (com.tencent.mm.cd.a.ms(this.context) - this.context.getResources().getDimensionPixelSize(b.d.Edge_4A) * 2 - this.context.getResources().getDimensionPixelSize(b.d.Edge_1_2_5_A) - this.context.getResources().getDimensionPixelSize(b.d.Edge_3A) - this.context.getResources().getDimensionPixelSize(b.d.Edge_0_5_A));
      this.Psp = (this.contentWidth / 2);
      this.Psq = (this.contentWidth / 2);
      Log.i("MicroMsg.SettingsAuthUI", "computeViewWidth appName: %s, appType: %s, content: %s", new Object[] { Integer.valueOf(this.Psp), Integer.valueOf(this.Psq), Integer.valueOf(this.contentWidth) });
      AppMethodBeat.o(298673);
    }
    
    private static final void a(b paramb, int paramInt, fun paramfun, View paramView)
    {
      AppMethodBeat.i(298683);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramfun);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      paramb = paramb.Pso;
      if (paramb != null) {
        paramb.b(paramInt, paramfun);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(298683);
    }
    
    private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(298677);
      kotlin.g.b.s.u(paramb, "this$0");
      if ((paramMotionEvent.getAction() & 0xFF) == 0)
      {
        paramb.x_down = ((int)paramMotionEvent.getRawX());
        paramb.y_down = ((int)paramMotionEvent.getRawY());
      }
      AppMethodBeat.o(298677);
      return false;
    }
    
    private static final boolean b(b paramb, int paramInt, fun paramfun, View paramView)
    {
      AppMethodBeat.i(298686);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramfun);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "this$0");
      localObject = paramb.Pso;
      if (localObject != null)
      {
        kotlin.g.b.s.s(paramView, "it");
        ((c)localObject).a(paramView, paramInt, paramfun, paramb.x_down, paramb.y_down);
      }
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(298686);
      return true;
    }
    
    public final boolean aiU(int paramInt)
    {
      AppMethodBeat.i(298698);
      Log.i("MicroMsg.SettingsAuthUI", "removeAuthItem position: " + paramInt + ", size: " + getItemCount());
      int i;
      if (paramInt >= 0) {
        if (paramInt < getItemCount()) {
          i = 1;
        }
      }
      while (i != 0)
      {
        this.Psm.remove(paramInt);
        this.dataSize -= 1;
        fX(paramInt);
        AppMethodBeat.o(298698);
        return true;
        i = 0;
        continue;
        i = 0;
      }
      AppMethodBeat.o(298698);
      return false;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(298701);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      if (paramInt == 2)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.layout_settings_auth_list_footer, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "view");
        paramViewGroup = (RecyclerView.v)new SettingsAuthUI.b.b(paramViewGroup);
        AppMethodBeat.o(298701);
        return paramViewGroup;
      }
      paramViewGroup = LayoutInflater.from(this.context).inflate(b.g.layout_settings_auth_list_app_item, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "view");
      paramViewGroup = (RecyclerView.v)new SettingsAuthUI.b.a(paramViewGroup);
      AppMethodBeat.o(298701);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(298704);
      kotlin.g.b.s.u(paramv, "holder");
      Object localObject1;
      Object localObject2;
      int i;
      if ((paramv instanceof SettingsAuthUI.b.a))
      {
        localObject1 = (SettingsAuthUI.b.a)paramv;
        paramv = (SettingsAuthUI.b.d)p.ae(this.Psm, paramInt);
        if (paramv != null) {
          break label313;
        }
        paramv = null;
        if (paramv != null)
        {
          ((SettingsAuthUI.b.a)localObject1).Psr.aZ((CharSequence)paramv.nSt);
          localObject2 = this.context.getResources().getString(b.i.seperator_marker);
          kotlin.g.b.s.s(localObject2, "context.resources.getStr….string.seperator_marker)");
          localObject2 = q.G((String)localObject2, (List)paramv.abSJ);
          if (((CharSequence)localObject2).length() <= 0) {
            break label321;
          }
          i = 1;
          label115:
          if (i == 0) {
            break label326;
          }
          ((SettingsAuthUI.b.a)localObject1).Pst.aZ((CharSequence)localObject2);
          ((SettingsAuthUI.b.a)localObject1).Pst.setVisibility(0);
          label141:
          localObject2 = (CharSequence)paramv.abSK;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label352;
          }
          i = 1;
          label167:
          if (i != 0) {
            break label357;
          }
          ((SettingsAuthUI.b.a)localObject1).Pss.setText((CharSequence)paramv.abSK);
          ((SettingsAuthUI.b.a)localObject1).Pss.setVisibility(0);
        }
      }
      for (;;)
      {
        localObject2 = ((SettingsAuthUI.b.a)localObject1).Psr;
        kotlin.g.b.s.s(localObject2, "authName");
        TextView localTextView = ((SettingsAuthUI.b.a)localObject1).Pss;
        kotlin.g.b.s.s(localTextView, "authType");
        r.a((MMNeat7extView)localObject2, localTextView, this.contentWidth, this.Psp, this.Psq, true);
        ((SettingsAuthUI.b.a)localObject1).LwF.setOnTouchListener(new SettingsAuthUI.b..ExternalSyntheticLambda2(this));
        ((SettingsAuthUI.b.a)localObject1).LwF.setOnClickListener(new SettingsAuthUI.b..ExternalSyntheticLambda0(this, paramInt, paramv));
        localObject1 = ((SettingsAuthUI.b.a)localObject1).LwF;
        if (localObject1 != null) {
          ((RelativeLayout)localObject1).setOnLongClickListener(new SettingsAuthUI.b..ExternalSyntheticLambda1(this, paramInt, paramv));
        }
        AppMethodBeat.o(298704);
        return;
        label313:
        paramv = paramv.Psu;
        break;
        label321:
        i = 0;
        break label115;
        label326:
        ((SettingsAuthUI.b.a)localObject1).Pst.aZ((CharSequence)"");
        ((SettingsAuthUI.b.a)localObject1).Pst.setVisibility(4);
        break label141;
        label352:
        i = 0;
        break label167;
        label357:
        ((SettingsAuthUI.b.a)localObject1).Pss.setText((CharSequence)"");
        ((SettingsAuthUI.b.a)localObject1).Pss.setVisibility(8);
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(298712);
      int i = this.Psm.size();
      AppMethodBeat.o(298712);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(298717);
      SettingsAuthUI.b.d locald = (SettingsAuthUI.b.d)p.ae(this.Psm, paramInt);
      if (locald == null)
      {
        AppMethodBeat.o(298717);
        return 1;
      }
      paramInt = locald.itemType;
      AppMethodBeat.o(298717);
      return paramInt;
    }
    
    public final boolean isEmpty()
    {
      return this.dataSize <= 0;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$OnAuthAppItemClickListener;", "", "onClick", "", "position", "", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "onLongClick", "view", "Landroid/view/View;", "xDonw", "yDown", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static abstract interface c
    {
      public abstract void a(View paramView, int paramInt1, fun paramfun, int paramInt2, int paramInt3);
      
      public abstract void b(int paramInt, fun paramfun);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$2", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$SettingsAuthListAdapter$OnAuthAppItemClickListener;", "onClick", "", "position", "", "userAuthApp", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "onLongClick", "view", "Landroid/view/View;", "xDonw", "yDown", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements SettingsAuthUI.b.c
  {
    c(SettingsAuthUI paramSettingsAuthUI) {}
    
    private static final void a(SettingsAuthUI paramSettingsAuthUI, int paramInt1, fun paramfun, MenuItem paramMenuItem, int paramInt2)
    {
      AppMethodBeat.i(298667);
      kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
      kotlin.g.b.s.u(paramfun, "$userAuthApp");
      if (paramMenuItem.getItemId() == 1)
      {
        SettingsAuthUI.a(paramSettingsAuthUI, paramInt1);
        paramMenuItem = c.Pos;
        c.a(202, paramfun);
        SettingsAuthUI.a(paramSettingsAuthUI, paramfun);
      }
      AppMethodBeat.o(298667);
    }
    
    private static final void a(SettingsAuthUI paramSettingsAuthUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(298663);
      kotlin.g.b.s.u(paramSettingsAuthUI, "this$0");
      paramContextMenu.add(0, 1, 0, (CharSequence)paramSettingsAuthUI.getString(b.i.settings_auth_del_auth));
      AppMethodBeat.o(298663);
    }
    
    public final void a(View paramView, int paramInt1, fun paramfun, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(298684);
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramfun, "userAuthApp");
      Log.i("MicroMsg.SettingsAuthUI", "onLongClick position: " + paramInt1 + ", appId: " + paramfun.appid);
      com.tencent.mm.ui.widget.b.a locala = SettingsAuthUI.b(this.Psv);
      if (locala != null) {
        locala.a(paramView, new SettingsAuthUI.c..ExternalSyntheticLambda0(this.Psv), new SettingsAuthUI.c..ExternalSyntheticLambda1(this.Psv, paramInt1, paramfun), paramInt2, paramInt3);
      }
      paramView = c.Pos;
      c.a(201, paramfun);
      AppMethodBeat.o(298684);
    }
    
    public final void b(int paramInt, fun paramfun)
    {
      AppMethodBeat.i(298678);
      kotlin.g.b.s.u(paramfun, "userAuthApp");
      try
      {
        SettingsAuthUI.a(this.Psv, paramInt);
        Object localObject = new Intent((Context)this.Psv.getContext(), SettingsDelAuthUI.class);
        ((Intent)localObject).putExtra("key_user_auth_app", paramfun.toByteArray());
        this.Psv.startActivityForResult((Intent)localObject, 1000);
        localObject = c.Pos;
        c.a(204, paramfun);
        AppMethodBeat.o(298678);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SettingsAuthUI", (Throwable)localException, "jump to SettingsDelAuthUI exception", new Object[0]);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    d(SettingsAuthUI paramSettingsAuthUI) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(298659);
      Object localObject = SettingsAuthUI.m(this.Psv);
      kotlin.g.b.s.checkNotNull(localObject);
      ((View)localObject).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      localObject = this.Psv;
      View localView = SettingsAuthUI.m(this.Psv);
      kotlin.g.b.s.checkNotNull(localView);
      SettingsAuthUI.c((SettingsAuthUI)localObject, localView.getMeasuredHeight());
      Log.v("MicroMsg.SettingsAuthUI", "onGlobalLayout headerView height: %s", new Object[] { Integer.valueOf(SettingsAuthUI.n(this.Psv)) });
      if (SettingsAuthUI.k(this.Psv))
      {
        SettingsAuthUI.a(this.Psv, true);
        SettingsAuthUI.l(this.Psv);
      }
      AppMethodBeat.o(298659);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "y", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    private int y;
    
    e(SettingsAuthUI paramSettingsAuthUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(298834);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(298834);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(298832);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      Log.v("MicroMsg.SettingsAuthUI", "onScrolled y: %s, dy: %s", new Object[] { Integer.valueOf(this.y), Integer.valueOf(paramInt2) });
      paramRecyclerView = SettingsAuthUI.d(this.Psv);
      if ((paramRecyclerView != null) && (paramRecyclerView.isEmpty() == true)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        this.Psv.getMMTitleView().setAlpha(0.0F);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(298832);
        return;
      }
      this.y += paramInt2;
      float f;
      if (this.y < SettingsAuthUI.o(this.Psv)) {
        f = 0.0F;
      }
      for (;;)
      {
        this.Psv.getMMTitleView().setAlpha(f);
        paramRecyclerView = this.Psv;
        localObject = SettingsAuthUI.q(this.Psv);
        kotlin.g.b.s.checkNotNull(localObject);
        paramRecyclerView.setActionbarColor(bb.gy(((Integer)localObject).intValue(), (int)(f * 100.0F)));
        paramRecyclerView = this.Psv.getController();
        localObject = SettingsAuthUI.q(this.Psv);
        kotlin.g.b.s.checkNotNull(localObject);
        paramRecyclerView.setStatusBarColor(((Integer)localObject).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$3$4", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(298832);
        return;
        if (this.y > SettingsAuthUI.p(this.Psv)) {
          f = 1.0F;
        } else {
          f = (this.y - SettingsAuthUI.o(this.Psv)) * 1.0F / (SettingsAuthUI.p(this.Psv) - SettingsAuthUI.o(this.Psv));
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$4", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$GetAuthDataCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "authData", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$SettingsAuthData;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements d.b
  {
    f(SettingsAuthUI paramSettingsAuthUI) {}
    
    public final void a(d.c paramc)
    {
      AppMethodBeat.i(298830);
      kotlin.g.b.s.u(paramc, "authData");
      SettingsAuthUI.c(this.Psv);
      SettingsAuthUI.a(this.Psv, paramc.PnI);
      SettingsAuthUI.b localb = SettingsAuthUI.d(this.Psv);
      if (localb != null)
      {
        kotlin.g.b.s.u(paramc, "authData");
        if (paramc.PrU) {
          break label494;
        }
        localb.loadFinished = false;
        localb.Psm.clear();
      }
      label315:
      label450:
      label471:
      label494:
      for (int j = 1;; j = 0)
      {
        if (localb.Psn) {}
        Object localObject1 = (Collection)paramc.PrV;
        int i;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            if (!localb.Psn)
            {
              i = localb.Psm.size();
              localb.dataSize += paramc.PrV.size();
              localObject1 = localb.Psm;
              Object localObject2 = (Iterable)paramc.PrV;
              Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
              localObject2 = ((Iterable)localObject2).iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localCollection.add(new SettingsAuthUI.b.d(1, (fun)((Iterator)localObject2).next()));
                  continue;
                  i = 0;
                  break;
                }
              }
              ((List)localObject1).addAll((Collection)localCollection);
            }
          }
        }
        for (;;)
        {
          if (paramc.PnI == null)
          {
            if (!localb.loadFinished)
            {
              localb.loadFinished = true;
              localb.Psm.add(new SettingsAuthUI.b.d());
            }
            localb.Psl.showLoading(false);
            if (j == 0) {
              break label450;
            }
            localb.bZE.notifyChanged();
            localObject1 = new StringBuilder("updateAuthData loadFirst: ").append(localb.Psn).append(", loadFinished: ").append(localb.loadFinished).append(", requestNextPage: ").append(paramc.PrU).append(", getDataSize: ");
            paramc = paramc.PrV;
            if (paramc != null) {
              break label471;
            }
          }
          for (paramc = null;; paramc = Integer.valueOf(paramc.size()))
          {
            Log.i("MicroMsg.SettingsAuthUI", paramc + ", currentDataSize: " + localb.dataSize + ", insertPosition: " + i);
            localb.Psn = false;
            SettingsAuthUI.a(this.Psv, false);
            SettingsAuthUI.e(this.Psv);
            AppMethodBeat.o(298830);
            return;
            localb.Psl.showLoading(true);
            break;
            localb.bA(i, localb.Psm.size() - i);
            break label315;
          }
          i = 0;
          break;
          i = 0;
        }
      }
    }
    
    public final void s(int paramInt1, int paramInt2, String paramString)
    {
      int i = 1;
      AppMethodBeat.i(298835);
      Log.e("MicroMsg.SettingsAuthUI", "getAuthData onFailed errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
      SettingsAuthUI.c(this.Psv);
      SettingsAuthUI.a(this.Psv, false);
      paramString = SettingsAuthUI.d(this.Psv);
      if ((paramString != null) && (paramString.isEmpty() == true)) {}
      for (paramInt1 = i; paramInt1 != 0; paramInt1 = 0)
      {
        SettingsAuthUI.f(this.Psv);
        SettingsAuthUI.a(this.Psv);
        AppMethodBeat.o(298835);
        return;
      }
      paramString = SettingsAuthUI.g(this.Psv);
      kotlin.g.b.s.checkNotNull(paramString);
      ((LinearLayout)paramString.findViewById(b.f.loading_reload_layout)).setVisibility(0);
      paramString = SettingsAuthUI.g(this.Psv);
      kotlin.g.b.s.checkNotNull(paramString);
      ((ProgressBar)paramString.findViewById(b.f.loading_progress_bar)).setVisibility(8);
      AppMethodBeat.o(298835);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$5", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC$DelAuthCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements e.b
  {
    g(SettingsAuthUI paramSettingsAuthUI) {}
    
    public final void gVE()
    {
      AppMethodBeat.i(298825);
      w localw = SettingsAuthUI.h(this.Psv);
      if (localw != null) {
        localw.dismiss();
      }
      aa.dc((Context)this.Psv.getContext(), this.Psv.getResources().getString(b.i.settings_auth_del_auth_failed));
      AppMethodBeat.o(298825);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(298822);
      Object localObject = SettingsAuthUI.h(this.Psv);
      if (localObject != null) {
        ((w)localObject).dismiss();
      }
      aa.db((Context)this.Psv.getContext(), this.Psv.getResources().getString(b.i.settings_auth_del_auth_success));
      localObject = SettingsAuthUI.d(this.Psv);
      if ((localObject != null) && (((SettingsAuthUI.b)localObject).aiU(SettingsAuthUI.i(this.Psv)) == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          SettingsAuthUI.e(this.Psv);
        }
        AppMethodBeat.o(298822);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/ui/setting/SettingsAuthUI$onCreate$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    h(SettingsAuthUI paramSettingsAuthUI) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(298820);
      ((RelativeLayout)this.Psv.findViewById(b.f.root_container)).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = com.tencent.mm.cd.a.ms((Context)this.Psv);
      int j = com.tencent.mm.cd.a.mt((Context)this.Psv);
      SettingsAuthUI.b(this.Psv, Math.min(Math.max(((RelativeLayout)this.Psv.findViewById(b.f.root_container)).getMeasuredHeight(), 0), j));
      Log.v("MicroMsg.SettingsAuthUI", "onGlobalLayout width: " + i + ", height: " + j + ", root_container: " + ((RelativeLayout)this.Psv.findViewById(b.f.root_container)).getMeasuredHeight() + ", rootViewHeight: " + SettingsAuthUI.j(this.Psv));
      if (SettingsAuthUI.k(this.Psv))
      {
        SettingsAuthUI.a(this.Psv, true);
        SettingsAuthUI.l(this.Psv);
      }
      AppMethodBeat.o(298820);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAuthUI
 * JD-Core Version:    0.7.0.1
 */