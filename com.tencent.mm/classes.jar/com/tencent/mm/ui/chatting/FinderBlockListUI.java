package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.dc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract.BlockListViewCallback;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.report.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/FinderBlockListUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "needChangeOrientation", "", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListPresenter;", "screenShotCallback", "com/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1", "Lcom/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1;", "type", "", "unInitTask", "Ljava/lang/Runnable;", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback;", "finish", "", "getCommentScene", "getLayoutId", "getReportType", "initView", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "app_release"})
public final class FinderBlockListUI
  extends MMActivity
{
  private static final int Aow = 1;
  private static final int Aox = 20;
  private static final int Aoy = 1;
  public static final a WDx;
  private boolean AwU;
  private final String TAG;
  private final d WDw;
  private int type;
  private Runnable xZq;
  private com.tencent.mm.plugin.finder.storage.aj zAg;
  private FinderBlockListContract.BlockListViewCallback zME;
  private FinderBlockListContract.BlockListPresenter zMG;
  
  static
  {
    AppMethodBeat.i(222177);
    WDx = new a((byte)0);
    Aow = 1;
    Aox = 20;
    Aoy = 1;
    AppMethodBeat.o(222177);
  }
  
  public FinderBlockListUI()
  {
    AppMethodBeat.i(222175);
    this.TAG = "Finder.FinderBlockListUI";
    this.WDw = new d(this);
    AppMethodBeat.o(222175);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(222165);
    super.finish();
    Log.i(this.TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
    AppMethodBeat.o(222165);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_block_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(222136);
    this.type = getIntent().getIntExtra("BLOCK_LIST_TYPE", 0);
    Object localObject1;
    switch (this.type)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      this.zAg = ((com.tencent.mm.plugin.finder.storage.aj)localObject1);
      if (this.zAg == null) {
        finish();
      }
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      setMMTitle(((com.tencent.mm.plugin.finder.storage.aj)localObject1).dRw());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      this.zMG = new FinderBlockListContract.BlockListPresenter((com.tencent.mm.plugin.finder.storage.aj)localObject1);
      localObject1 = (MMActivity)this;
      Object localObject2 = getContentView();
      kotlin.g.b.p.j(localObject2, "contentView");
      FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.zMG;
      if (localBlockListPresenter == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = new FinderBlockListContract.BlockListViewCallback((MMActivity)localObject1, (View)localObject2, localBlockListPresenter);
      localObject2 = this.zMG;
      if (localObject2 == null) {
        kotlin.g.b.p.iCn();
      }
      ((FinderBlockListContract.BlockListPresenter)localObject2).a((FinderBlockListContract.BlockListViewCallback)localObject1);
      ((FinderBlockListContract.BlockListViewCallback)localObject1).initView();
      this.zME = ((FinderBlockListContract.BlockListViewCallback)localObject1);
      localObject1 = this.zAg;
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      if (((com.tencent.mm.plugin.finder.storage.aj)localObject1).dRz()) {
        addIconOptionMenu(0, b.i.icons_outlined_add_friends, (MenuItem.OnMenuItemClickListener)new c(this));
      }
      AppMethodBeat.o(222136);
      return;
      localObject1 = (com.tencent.mm.plugin.finder.storage.aj)new c();
      continue;
      localObject1 = (com.tencent.mm.plugin.finder.storage.aj)new ab();
      continue;
      localObject1 = (com.tencent.mm.plugin.finder.storage.aj)new ac();
    }
  }
  
  public final void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    AppMethodBeat.i(222107);
    kotlin.g.b.p.k(paramHashSet, "uiComponents");
    super.initializeUIC(paramHashSet);
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    paramHashSet.add(com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
    localg = com.tencent.mm.ui.component.g.Xox;
    paramHashSet.add(com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.secdata.ui.a.class));
    AppMethodBeat.o(222107);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(222145);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == Aoy)
    {
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getStringExtra("Select_Contact");; paramIntent = null)
      {
        paramIntent = Util.stringToList(paramIntent, ",");
        kotlin.g.b.p.j(paramIntent, "nameList");
        localObject = (Iterable)paramIntent;
        paramIntent = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
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
      Object localObject = this.zMG;
      if (localObject != null)
      {
        ((FinderBlockListContract.BlockListPresenter)localObject).eF(paramIntent);
        AppMethodBeat.o(222145);
        return;
      }
    }
    AppMethodBeat.o(222145);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(222162);
    kotlin.g.b.p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(222162);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(222116);
    super.onCreate(paramBundle);
    Log.i(this.TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    initView();
    AppMethodBeat.o(222116);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(222156);
    super.onDestroy();
    FinderBlockListContract.BlockListPresenter localBlockListPresenter = this.zMG;
    if (localBlockListPresenter != null)
    {
      localBlockListPresenter.onDetach();
      AppMethodBeat.o(222156);
      return;
    }
    AppMethodBeat.o(222156);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(222154);
    super.onPause();
    Log.i(this.TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.xZq);
    Object localObject = d.AjH;
    if (((Number)d.dUR().aSr()).intValue() == 1)
    {
      Log.i(this.TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      ScreenShotUtil.setScreenShotCallback((Context)this, null);
    }
    localObject = this.xZq;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.xZq = null;
    AppMethodBeat.o(222154);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(222174);
    super.onResume();
    Log.i(this.TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = d.AjH;
    if (((Boolean)d.dUy().aSr()).booleanValue())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/FinderBlockListUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/chatting/FinderBlockListUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    localObject = d.AjH;
    if (((Number)d.dUR().aSr()).intValue() == 1)
    {
      Log.i(this.TAG, "REPORT_WHEN_SCREEN_SHOT register");
      ScreenShotUtil.setScreenShotCallback((Context)this, (ScreenShotUtil.ScreenShotCallback)this.WDw);
    }
    localObject = this.zMG;
    if (localObject != null)
    {
      ((FinderBlockListContract.BlockListPresenter)localObject).ata();
      AppMethodBeat.o(222174);
      return;
    }
    AppMethodBeat.o(222174);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public final void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(222160);
    if (!this.AwU)
    {
      super.setRequestedOrientation(1);
      AppMethodBeat.o(222160);
      return;
    }
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(222160);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/FinderBlockListUI$Companion;", "", "()V", "MAX_MULTI_SELECTED_USER", "", "getMAX_MULTI_SELECTED_USER", "()I", "MENU_ID_ADD_USER", "getMENU_ID_ADD_USER", "REQUEST_CODE_MULTI_ADDR", "getREQUEST_CODE_MULTI_ADDR", "app_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(287959);
      this.WDy.finish();
      AppMethodBeat.o(287959);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderBlockListUI paramFinderBlockListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(275512);
      Log.i(FinderBlockListUI.a(this.WDy), "doCallSelectContactUIForMultiRetransmit");
      paramMenuItem = new Intent();
      paramMenuItem.setClassName((Context)this.WDy, "com.tencent.mm.ui.contact.SelectContactUI");
      paramMenuItem.putExtra("list_type", 1);
      paramMenuItem.putExtra("titile", this.WDy.getString(b.j.finder_mod_block_select_user));
      paramMenuItem.putExtra("list_attr", w.XtL);
      Object localObject1 = FinderBlockListUI.b(this.WDy);
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      Object localObject2 = (Iterable)((FinderBlockListContract.BlockListPresenter)localObject1).mXB;
      localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((com.tencent.mm.plugin.finder.model.p)((Iterator)localObject2).next()).contact.username);
      }
      paramMenuItem.putExtra("always_select_contact", Util.listToString((List)localObject1, ","));
      paramMenuItem.putExtra("block_contact", z.bcZ());
      localObject1 = FinderBlockListUI.WDx;
      paramMenuItem.putExtra("max_limit_num", FinderBlockListUI.dZO());
      paramMenuItem.putExtra("Forbid_SelectChatRoom", true);
      paramMenuItem.putExtra("show_too_many_member", false);
      localObject1 = this.WDy.getContext();
      localObject2 = FinderBlockListUI.WDx;
      ((AppCompatActivity)localObject1).startActivityForResult(paramMenuItem, FinderBlockListUI.dZP());
      AppMethodBeat.o(275512);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/FinderBlockListUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "app_release"})
  public static final class d
    implements ScreenShotUtil.ScreenShotCallback
  {
    public final void onScreenShot(String paramString, long paramLong)
    {
      AppMethodBeat.i(279003);
      for (;;)
      {
        try
        {
          paramString = com.tencent.mm.ui.component.g.Xox;
          com.tencent.mm.plugin.finder.report.g localg = com.tencent.mm.plugin.finder.viewmodel.component.aj.c((com.tencent.mm.plugin.finder.viewmodel.component.aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this.WDy).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class));
          if (!(localg instanceof s)) {
            break label263;
          }
          LinkedList localLinkedList = new LinkedList();
          Iterator localIterator = ((Map)((s)localg).zWQ).entrySet().iterator();
          if (localIterator.hasNext())
          {
            paramString = (Map.Entry)localIterator.next();
            amd localamd = new amd();
            localamd.xbk = ((com.tencent.mm.plugin.finder.report.t)paramString.getValue()).feedId;
            paramString = ((com.tencent.mm.plugin.finder.report.t)paramString.getValue()).xpY;
            if (paramString == null) {
              break label281;
            }
            String str = paramString.getUserName();
            paramString = str;
            if (str == null) {
              break label281;
            }
            localamd.finderUsername = paramString;
            paramString = n.zWF;
            str = n.N(localamd.xbk, localg.xbu.xkX);
            paramString = str;
            if (str == null) {
              paramString = "";
            }
            localamd.sessionBuffer = paramString;
            localLinkedList.add(localamd);
            continue;
          }
          paramString = new dc((List)localLinkedList);
        }
        catch (Throwable paramString)
        {
          Log.printErrStackTrace(FinderBlockListUI.a(this.WDy), paramString, "onScreenShot", new Object[0]);
          AppMethodBeat.o(279003);
          return;
        }
        h.aGY().b((q)paramString);
        AppMethodBeat.o(279003);
        return;
        label263:
        Log.i(FinderBlockListUI.a(this.WDy), "onScreenShot: not FinderSingleFeedFlowReporter");
        AppMethodBeat.o(279003);
        return;
        label281:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.FinderBlockListUI
 * JD-Core Version:    0.7.0.1
 */