package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback;
import com.tencent.mm.plugin.finder.storage.ae;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.finder.storage.ar;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/FinderBlockListUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "needChangeOrientation", "", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "screenShotCallback", "com/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1", "Lcom/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1;", "type", "", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "finish", "", "getCommentScene", "getLayoutId", "getReportType", "initView", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderBlockListUI
  extends MMActivity
{
  private static final int FOM;
  private static final int FON;
  private static final int FOO;
  public static final FinderBlockListUI.a aekX;
  private Runnable CxA;
  private ar ECo;
  private FinderBlockListContract.BlockListViewCallback EXw;
  private FinderBlockListContract.BlockListPresenter EXy;
  private boolean FVH;
  private final String TAG;
  private final FinderBlockListUI.b aekY;
  private int type;
  
  static
  {
    AppMethodBeat.i(254234);
    aekX = new FinderBlockListUI.a((byte)0);
    FOM = 1;
    FON = 20;
    FOO = 1;
    AppMethodBeat.o(254234);
  }
  
  public FinderBlockListUI()
  {
    AppMethodBeat.i(254224);
    this.TAG = "Finder.FinderBlockListUI";
    this.aekY = new FinderBlockListUI.b(this);
    AppMethodBeat.o(254224);
  }
  
  private static final boolean a(FinderBlockListUI paramFinderBlockListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(254227);
    s.u(paramFinderBlockListUI, "this$0");
    paramFinderBlockListUI.finish();
    AppMethodBeat.o(254227);
    return true;
  }
  
  private static final boolean b(FinderBlockListUI paramFinderBlockListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(254230);
    s.u(paramFinderBlockListUI, "this$0");
    Log.i(paramFinderBlockListUI.TAG, "doCallSelectContactUIForMultiRetransmit");
    paramMenuItem = new Intent();
    paramMenuItem.setClassName((Context)paramFinderBlockListUI, "com.tencent.mm.ui.contact.SelectContactUI");
    paramMenuItem.putExtra("list_type", 1);
    paramMenuItem.putExtra("titile", paramFinderBlockListUI.getString(e.h.finder_mod_block_select_user));
    paramMenuItem.putExtra("list_attr", w.affp);
    Object localObject1 = paramFinderBlockListUI.EXy;
    s.checkNotNull(localObject1);
    Object localObject2 = (Iterable)((FinderBlockListContract.BlockListPresenter)localObject1).pUj;
    localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact.username);
    }
    paramMenuItem.putExtra("always_select_contact", Util.listToString((List)localObject1, ","));
    paramMenuItem.putExtra("block_contact", z.bAM());
    paramMenuItem.putExtra("max_limit_num", FON);
    paramMenuItem.putExtra("Forbid_SelectChatRoom", true);
    paramMenuItem.putExtra("show_too_many_member", false);
    paramFinderBlockListUI.getContext().startActivityForResult(paramMenuItem, FOO);
    AppMethodBeat.o(254230);
    return true;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(254266);
    super.finish();
    Log.i(this.TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
    AppMethodBeat.o(254266);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_block_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(254252);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    Object localObject1;
    switch (this.type)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      this.ECo = ((ar)localObject1);
      if (this.ECo == null) {
        finish();
      }
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      setMMTitle(((ar)localObject1).ePJ());
      setBackBtn(new FinderBlockListUI..ExternalSyntheticLambda1(this));
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      this.EXy = new FinderBlockListContract.BlockListPresenter((ar)localObject1);
      localObject1 = (MMActivity)this;
      Object localObject2 = getContentView();
      s.s(localObject2, "contentView");
      FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.EXy;
      s.checkNotNull(localBlockListPresenter);
      localObject1 = new FinderBlockListContract.BlockListViewCallback((MMActivity)localObject1, (View)localObject2, localBlockListPresenter);
      localObject2 = this.EXy;
      s.checkNotNull(localObject2);
      ((FinderBlockListContract.BlockListPresenter)localObject2).a((FinderBlockListContract.BlockListViewCallback)localObject1);
      ((FinderBlockListContract.BlockListViewCallback)localObject1).initView();
      localObject2 = ah.aiuX;
      this.EXw = ((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject1 = this.ECo;
      s.checkNotNull(localObject1);
      if (((ar)localObject1).ePK()) {
        addIconOptionMenu(0, e.g.icons_outlined_add_friends, new FinderBlockListUI..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(254252);
      return;
      localObject1 = (ar)new c();
      continue;
      localObject1 = (ar)new ae();
      continue;
      localObject1 = (ar)new af();
    }
  }
  
  public final void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    AppMethodBeat.i(254243);
    s.u(paramHashSet, "uiComponents");
    super.initializeUIC(paramHashSet);
    k localk = k.aeZF;
    paramHashSet.add(k.d((AppCompatActivity)this).q(as.class));
    localk = k.aeZF;
    paramHashSet.add(k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.secdata.ui.a.class));
    AppMethodBeat.o(254243);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(254256);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == FOO)
    {
      if (paramIntent == null) {}
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("Select_Contact"))
      {
        paramIntent = Util.stringToList(paramIntent, ",");
        s.s(paramIntent, "nameList");
        localObject = (Iterable)paramIntent;
        paramIntent = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          FinderContact localFinderContact = new FinderContact();
          localFinderContact.username = str;
          paramIntent.add(localFinderContact);
        }
      }
      paramIntent = (List)paramIntent;
      Object localObject = this.EXy;
      if (localObject != null) {
        ((FinderBlockListContract.BlockListPresenter)localObject).hn(paramIntent);
      }
    }
    AppMethodBeat.o(254256);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(254265);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(254265);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(254249);
    super.onCreate(paramBundle);
    Log.i(this.TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    initView();
    AppMethodBeat.o(254249);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(254261);
    super.onDestroy();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.EXy;
    if (localBlockListPresenter != null) {
      localBlockListPresenter.onDetach();
    }
    AppMethodBeat.o(254261);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(254258);
    super.onPause();
    Log.i(this.TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.CxA);
    Object localObject = d.FAy;
    if (((Number)d.eTq().bmg()).intValue() == 1)
    {
      Log.i(this.TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      ScreenShotUtil.setScreenShotCallback((Context)this, null);
    }
    localObject = this.CxA;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.CxA = null;
    AppMethodBeat.o(254258);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(254270);
    super.onResume();
    Log.i(this.TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = d.FAy;
    if (((Boolean)d.eSX().bmg()).booleanValue())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/FinderBlockListUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/FinderBlockListUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    localObject = d.FAy;
    if (((Number)d.eTq().bmg()).intValue() == 1)
    {
      Log.i(this.TAG, "REPORT_WHEN_SCREEN_SHOT register");
      ScreenShotUtil.setScreenShotCallback((Context)this, (ScreenShotUtil.ScreenShotCallback)this.aekY);
    }
    localObject = this.EXy;
    if (localObject != null) {
      ((FinderBlockListContract.BlockListPresenter)localObject).aNi();
    }
    AppMethodBeat.o(254270);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(254264);
    if (!this.FVH)
    {
      super.setRequestedOrientation(1);
      AppMethodBeat.o(254264);
      return;
    }
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(254264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */