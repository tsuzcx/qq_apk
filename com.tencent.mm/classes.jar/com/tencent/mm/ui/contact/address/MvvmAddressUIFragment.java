package com.tencent.mm.ui.contact.address;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.p.d.a;
import com.tencent.mm.plugin.repairer.PluginRepairer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.contact.BizContactEntranceView;
import com.tencent.mm.ui.contact.ContactCountView;
import com.tencent.mm.ui.contact.aa;
import com.tencent.mm.ui.contact.aa.a;
import com.tencent.mm.ui.contact.aa.b;
import com.tencent.mm.ui.contact.j.a;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;", "Lcom/tencent/mm/ui/contact/address/BaseAddressUIFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getAdapter", "()Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "addressDataSource", "Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "getAddressDataSource", "()Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "addressDataSource$delegate", "addressFavorDataSource", "Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "getAddressFavorDataSource", "()Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "addressFavorDataSource$delegate", "bizEntranceView", "Lcom/tencent/mm/ui/contact/BizContactEntranceView;", "chatroomEntranceView", "Lcom/tencent/mm/ui/contact/AddressUIEntranceHeaderView;", "contactCountView", "Lcom/tencent/mm/ui/contact/ContactCountView;", "contactLabelEntranceView", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "getDataSource", "()Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "dataSource$delegate", "doubleClickJob", "Ljava/lang/Runnable;", "enterpriseBizView", "Lcom/tencent/mm/ui/contact/EnterpriseBizView;", "fadeIn", "Landroid/view/animation/Animation;", "fadeOut", "fcView", "Lcom/tencent/mm/ui/contact/FMessageContactView;", "ipcallEntranceView", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "liveList", "Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "getLiveList", "()Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "liveList$delegate", "onItemClickListener", "com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1;", "onItemClickListener$delegate", "onlyChatContactEntranceView", "openIMListHeaderView", "Lcom/tencent/mm/ui/contact/OpenIMListHeaderView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "x_down", "", "y_down", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "deleteContact", "", "contact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "getLayoutView", "Landroid/view/View;", "getLogTag", "", "initHeaderView", "markLoadingGone", "moveToTop", "onTabCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTabDestroy", "onTabPause", "onTabResume", "onTabSwitchIn", "requestToTop", "scrollToShowHead", "showHeadCode", "showScrollBar", "show", "", "turnToBg", "viewRemarkInfo", "Companion", "CreateContextMenuListener", "MenuItemSelectedListener", "app_release"})
public final class MvvmAddressUIFragment
  extends BaseAddressUIFragment
{
  public static final MvvmAddressUIFragment.a Xxj;
  private final kotlin.f BiY;
  private Animation FVj;
  private final kotlin.f GkX;
  private final kotlin.f GkY;
  private AlphabetScrollBar WFZ;
  private final kotlin.f WGf;
  private com.tencent.mm.ui.contact.l XpF;
  private BizContactEntranceView XpG;
  private com.tencent.mm.ui.contact.b XpH;
  private com.tencent.mm.ui.contact.b XpI;
  private com.tencent.mm.ui.contact.b XpJ;
  private com.tencent.mm.ui.contact.b XpK;
  private ContactCountView XpL;
  private aa XpM;
  private com.tencent.mm.ui.contact.j XpN;
  private final kotlin.f Xxf;
  private final kotlin.f Xxg;
  private WxLinearLayoutManager Xxh;
  private final Runnable Xxi;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private Animation wyA;
  private WxRecyclerView xUj;
  
  static
  {
    AppMethodBeat.i(267148);
    Xxj = new MvvmAddressUIFragment.a((byte)0);
    AppMethodBeat.o(267148);
  }
  
  public MvvmAddressUIFragment()
  {
    AppMethodBeat.i(267147);
    this.Xxf = kotlin.g.ar((kotlin.g.a.a)e.Xxm);
    this.Xxg = kotlin.g.ar((kotlin.g.a.a)f.Xxn);
    this.GkX = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.GkY = kotlin.g.ar((kotlin.g.a.a)new n(this));
    this.BiY = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.WGf = kotlin.g.ar((kotlin.g.a.a)new o(this));
    this.Xxi = ((Runnable)new i(this));
    AppMethodBeat.o(267147);
  }
  
  private final com.tencent.mm.plugin.livelist.h<d> hNY()
  {
    AppMethodBeat.i(267135);
    com.tencent.mm.plugin.livelist.h localh = (com.tencent.mm.plugin.livelist.h)this.BiY.getValue();
    AppMethodBeat.o(267135);
    return localh;
  }
  
  private final a hVt()
  {
    AppMethodBeat.i(267132);
    a locala = (a)this.Xxf.getValue();
    AppMethodBeat.o(267132);
    return locala;
  }
  
  private final b hVu()
  {
    AppMethodBeat.i(267133);
    b localb = (b)this.Xxg.getValue();
    AppMethodBeat.o(267133);
    return localb;
  }
  
  private final AddressLiveList hVv()
  {
    AppMethodBeat.i(267134);
    AddressLiveList localAddressLiveList = (AddressLiveList)this.GkY.getValue();
    AppMethodBeat.o(267134);
    return localAddressLiveList;
  }
  
  public final void GH(boolean paramBoolean)
  {
    AppMethodBeat.i(267140);
    if (this.WFZ != null)
    {
      Object localObject;
      if (this.wyA == null)
      {
        this.wyA = AnimationUtils.loadAnimation((Context)getContext(), R.a.djB);
        localObject = this.wyA;
        if (localObject != null) {
          ((Animation)localObject).setDuration(200L);
        }
      }
      if (this.FVj == null)
      {
        this.FVj = AnimationUtils.loadAnimation((Context)getContext(), R.a.djB);
        localObject = this.FVj;
        if (localObject != null) {
          ((Animation)localObject).setDuration(200L);
        }
      }
      if (paramBoolean)
      {
        localObject = this.WFZ;
        if ((localObject == null) || (((AlphabetScrollBar)localObject).getVisibility() != 0))
        {
          localObject = this.WFZ;
          if (localObject != null) {
            ((AlphabetScrollBar)localObject).setVisibility(0);
          }
          localObject = this.WFZ;
          if (localObject != null)
          {
            ((AlphabetScrollBar)localObject).startAnimation(this.wyA);
            AppMethodBeat.o(267140);
            return;
          }
          AppMethodBeat.o(267140);
        }
      }
      else
      {
        localObject = this.WFZ;
        if ((localObject == null) || (4 != ((AlphabetScrollBar)localObject).getVisibility()))
        {
          localObject = this.WFZ;
          if (localObject != null) {
            ((AlphabetScrollBar)localObject).setVisibility(8);
          }
          localObject = this.WFZ;
          if (localObject != null)
          {
            ((AlphabetScrollBar)localObject).startAnimation(this.FVj);
            AppMethodBeat.o(267140);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(267140);
  }
  
  public final void awR(int paramInt)
  {
    AppMethodBeat.i(267137);
    MvvmAddressUIFragment localMvvmAddressUIFragment = (MvvmAddressUIFragment)this;
    Object localObject1 = ((Iterable)localMvvmAddressUIFragment.hVv().mXB).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (d)localObject2;
      if ((((d)localObject2).WGm == paramInt) && (((d)localObject2).WGl))
      {
        localObject1 = localMvvmAddressUIFragment.xUj;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).ld();
        }
        localObject1 = localMvvmAddressUIFragment.Xxh;
        if (localObject1 != null)
        {
          ((WxLinearLayoutManager)localObject1).au(i + localMvvmAddressUIFragment.hNY().YSk.size(), 0);
          AppMethodBeat.o(267137);
          return;
        }
        AppMethodBeat.o(267137);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(267137);
  }
  
  public final int getLayoutId()
  {
    return R.i.ebr;
  }
  
  public final View getLayoutView()
  {
    AppMethodBeat.i(267138);
    com.tencent.mm.kiss.a.b.aIK();
    View localView = com.tencent.mm.kiss.a.b.d(getContext(), R.i.ebr);
    AppMethodBeat.o(267138);
    return localView;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.MvvmAddressUIFragment";
  }
  
  public final void gkF()
  {
    AppMethodBeat.i(267146);
    if (this.XpF != null) {
      com.tencent.mm.ui.contact.l.hUH();
    }
    AppMethodBeat.o(267146);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void hFb()
  {
    AppMethodBeat.i(267136);
    Log.i("MicroMsg.Mvvm.MvvmAddressUIFragment", "onTabCreate");
    hGa();
    Object localObject1 = getView();
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject1 = (WxRecyclerView)((View)localObject1).findViewById(R.h.dqp);
      this.xUj = ((WxRecyclerView)localObject1);
      localObject1 = this.xUj;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)hNY());
      }
      localObject1 = getContext();
      if (localObject1 != null)
      {
        this.Xxh = new WxLinearLayoutManager((Context)localObject1);
        localObject1 = this.xUj;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)this.Xxh);
        }
      }
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      this.XpI = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.Xqc);
      ((LinearLayout)localObject1).addView((View)this.XpI);
      localObject2 = this.XpI;
      if (localObject2 != null) {
        ((com.tencent.mm.ui.contact.b)localObject2).setVisible(false);
      }
      this.XpF = new com.tencent.mm.ui.contact.l((Context)getContext());
      ((LinearLayout)localObject1).addView((View)this.XpF);
      this.XpK = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.Xqd);
      ((LinearLayout)localObject1).addView((View)this.XpK);
      localObject2 = com.tencent.mm.kernel.h.aHG();
      p.j(localObject2, "MMKernel.storage()");
      boolean bool = ((com.tencent.mm.kernel.f)localObject2).aHp().getBoolean(ar.a.VCV, false);
      if (!bool) {
        com.tencent.e.h.ZvG.bf((Runnable)new j(this));
      }
      localObject2 = this.XpK;
      if (localObject2 != null) {
        ((com.tencent.mm.ui.contact.b)localObject2).setVisible(bool);
      }
      this.XpH = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.Xqa);
      ((LinearLayout)localObject1).addView((View)this.XpH);
      localObject2 = this.XpH;
      if (localObject2 != null) {
        ((com.tencent.mm.ui.contact.b)localObject2).setVisible(true);
      }
      this.XpJ = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.Xqb);
      ((LinearLayout)localObject1).addView((View)this.XpJ);
      localObject2 = this.XpJ;
      if (localObject2 != null) {
        ((com.tencent.mm.ui.contact.b)localObject2).setVisible(true);
      }
      if (com.tencent.mm.by.c.blP("brandservice"))
      {
        this.XpG = new BizContactEntranceView((Context)getContext());
        ((LinearLayout)localObject1).addView((View)this.XpG);
        localObject2 = this.XpG;
        if (localObject2 != null) {
          ((BizContactEntranceView)localObject2).setVisible(true);
        }
      }
      localObject2 = (aa.b)new m(this);
      this.XpM = new aa((Context)getContext(), (aa.a)new k(this));
      aa localaa = this.XpM;
      if (localaa != null) {
        localaa.setOnVisibilityChangeListener((aa.b)localObject2);
      }
      localaa = this.XpM;
      if (localaa == null) {
        break label930;
      }
      i = localaa.getOpenIMCount();
      label535:
      if (i > 0) {
        break label935;
      }
      ((aa.b)localObject2).GI(false);
      localObject2 = this.XpM;
      if (localObject2 != null) {
        ((aa)localObject2).setVisibility(8);
      }
      label565:
      ((LinearLayout)localObject1).addView((View)this.XpM);
      this.XpN = new com.tencent.mm.ui.contact.j((Context)getContext(), (j.a)new l(this));
      localObject2 = this.XpN;
      if (localObject2 == null) {
        break label946;
      }
      i = ((com.tencent.mm.ui.contact.j)localObject2).getEnterpriseFriendCount();
      label622:
      if (i <= 0)
      {
        localObject2 = this.XpN;
        if (localObject2 != null) {
          ((com.tencent.mm.ui.contact.j)localObject2).setVisibility(8);
        }
      }
      af.bjv().a((f.a)this.XpN, null);
      ((LinearLayout)localObject1).addView((View)this.XpN);
      com.tencent.mm.view.recyclerview.h.a(hNY(), (View)localObject1, ((LinearLayout)localObject1).hashCode());
      hNY().YSW = ((com.tencent.mm.view.recyclerview.g)this.WGf.getValue());
      localObject1 = getView();
      if (localObject1 == null) {
        break label951;
      }
    }
    label930:
    label935:
    label946:
    label951:
    for (localObject1 = (AlphabetScrollBar)((View)localObject1).findViewById(R.h.dqz);; localObject1 = null)
    {
      this.WFZ = ((AlphabetScrollBar)localObject1);
      localObject1 = this.WFZ;
      if (localObject1 != null) {
        ((AlphabetScrollBar)localObject1).setOnScrollBarTouchListener((VerticalScrollBar.a)new p(this));
      }
      this.szq = new com.tencent.mm.ui.widget.b.a((Context)getContext());
      hVt().Eit = ((MMLiveList)hVv());
      hVu().Eit = ((MMLiveList)hVv());
      localObject1 = com.tencent.mm.plugin.p.d.EiT;
      ((com.tencent.mm.plugin.p.a.a)d.a.bk(com.tencent.mm.plugin.p.a.a.class)).observe((androidx.lifecycle.l)this, (IStorageObserver)hVt());
      localObject1 = com.tencent.mm.plugin.p.d.EiT;
      ((com.tencent.mm.plugin.p.a.a)d.a.bk(com.tencent.mm.plugin.p.a.a.class)).observe((androidx.lifecycle.l)this, (IStorageObserver)hVu());
      hVv().EhK.a((androidx.lifecycle.l)this, (s)new q(this));
      localObject1 = getBounceView();
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.pulldown.e)localObject1).setEnd2StartBgColor(getResources().getColor(R.e.BG_2));
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1728L, 0L, 1L, false);
      AppMethodBeat.o(267136);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label535;
      ((aa.b)localObject2).GI(true);
      break label565;
      i = 0;
      break label622;
    }
  }
  
  public final void hFc()
  {
    AppMethodBeat.i(267142);
    super.hFc();
    Activity localActivity = getContext();
    Object localObject = localActivity;
    if (!(localActivity instanceof LauncherUI)) {
      localObject = null;
    }
    localObject = (LauncherUI)localObject;
    if (localObject != null)
    {
      localObject = ((LauncherUI)localObject).getHomeUI();
      if (localObject != null) {
        ((HomeUI)localObject).setTitleBarDoubleClickListener(this.Xxi);
      }
    }
    long l = System.currentTimeMillis();
    p.j(bh.beI(), "MMCore.getAccStg()");
    if (l - com.tencent.mm.model.c.aHp().ahV(340226) >= 180000L) {
      hUl();
    }
    localObject = this.XpF;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.l)localObject).setFrontGround(true);
    }
    if (this.XpF != null) {
      com.tencent.mm.ui.contact.l.hUH();
    }
    localObject = this.XpN;
    if (localObject != null)
    {
      if (((com.tencent.mm.ui.contact.j)localObject).getEnterpriseFriendCount() > 0) {
        break label169;
      }
      ((com.tencent.mm.ui.contact.j)localObject).setVisibility(8);
    }
    for (;;)
    {
      localObject = this.XpG;
      if (localObject != null) {
        ((BizContactEntranceView)localObject).gZg();
      }
      localObject = this.XpL;
      if (localObject == null) {
        break;
      }
      ((ContactCountView)localObject).hUp();
      AppMethodBeat.o(267142);
      return;
      label169:
      ((com.tencent.mm.ui.contact.j)localObject).setVisibility(0);
    }
    AppMethodBeat.o(267142);
  }
  
  public final void hFe()
  {
    AppMethodBeat.i(267141);
    super.hFe();
    Activity localActivity = getContext();
    Object localObject = localActivity;
    if (!(localActivity instanceof LauncherUI)) {
      localObject = null;
    }
    localObject = (LauncherUI)localObject;
    if (localObject != null)
    {
      localObject = ((LauncherUI)localObject).getHomeUI();
      if (localObject != null) {
        ((HomeUI)localObject).aO(this.Xxi);
      }
    }
    p.j(bh.beI(), "MMCore.getAccStg()");
    com.tencent.mm.model.c.aHp().i(340226, Long.valueOf(System.currentTimeMillis()));
    localObject = this.szq;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.b.a)localObject).cFD();
    }
    localObject = this.XpF;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.contact.l)localObject).setFrontGround(false);
      AppMethodBeat.o(267141);
      return;
    }
    AppMethodBeat.o(267141);
  }
  
  public final void hFg()
  {
    AppMethodBeat.i(267143);
    super.hFg();
    Object localObject = this.XpN;
    if (localObject != null)
    {
      af.bjv().a((f.a)localObject);
      this.XpN = null;
    }
    localObject = this.XpF;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.contact.l)localObject).detach();
      this.XpF = null;
    }
    if (this.XpG != null) {
      this.XpG = null;
    }
    if (this.XpH != null) {
      this.XpH = null;
    }
    if (this.XpK != null) {
      this.XpK = null;
    }
    if (this.XpJ != null) {
      this.XpJ = null;
    }
    if (this.XpN != null) {
      this.XpN = null;
    }
    localObject = this.WFZ;
    if (localObject != null)
    {
      ((AlphabetScrollBar)localObject).hKy();
      AppMethodBeat.o(267143);
      return;
    }
    AppMethodBeat.o(267143);
  }
  
  public final void hFh()
  {
    AppMethodBeat.i(267145);
    hUl();
    AppMethodBeat.o(267145);
  }
  
  public final void hFi()
  {
    AppMethodBeat.i(267144);
    super.hFi();
    Object localObject = this.XpG;
    if (localObject != null) {
      ((BizContactEntranceView)localObject).destroyDrawingCache();
    }
    localObject = this.XpH;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.XpJ;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.XpK;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.XpL;
    if (localObject != null) {
      ((ContactCountView)localObject).destroyDrawingCache();
    }
    localObject = this.XpF;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.contact.l)localObject).destroyDrawingCache();
      AppMethodBeat.o(267144);
      return;
    }
    AppMethodBeat.o(267144);
  }
  
  public final void hUl()
  {
    AppMethodBeat.i(267139);
    WxLinearLayoutManager localWxLinearLayoutManager = this.Xxh;
    if (localWxLinearLayoutManager != null)
    {
      localWxLinearLayoutManager.au(0, 0);
      AppMethodBeat.o(267139);
      return;
    }
    AppMethodBeat.o(267139);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$CreateContextMenuListener;", "Landroid/view/View$OnCreateContextMenuListener;", "dataItem", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "position", "", "(Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;I)V", "getDataItem", "()Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getPosition", "()I", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "app_release"})
  public final class b
    implements View.OnCreateContextMenuListener
  {
    private final d Xxk;
    private final int position;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(224024);
      this.Xxk = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(224024);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(224019);
      if (((paramContextMenuInfo instanceof AdapterView.AdapterContextMenuInfo)) && ((this.Xxk instanceof d)))
      {
        paramView = this.Xxk.contact;
        if (ab.Qj(paramView.getUsername()))
        {
          if (paramContextMenu != null) {
            paramContextMenu.setHeaderTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)MvvmAddressUIFragment.this.getContext(), (CharSequence)paramView.ays()));
          }
          if (paramContextMenu != null)
          {
            paramContextMenu.add(this.position, 2, 0, R.l.ent);
            AppMethodBeat.o(224019);
            return;
          }
          AppMethodBeat.o(224019);
          return;
        }
        if ((ab.Qy(paramView.getUsername())) || (ab.QO(paramView.getUsername())))
        {
          AppMethodBeat.o(224019);
          return;
        }
        if (paramContextMenu != null) {
          paramContextMenu.setHeaderTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)MvvmAddressUIFragment.this.getContext(), (CharSequence)paramView.ays()));
        }
        if ((paramView.axZ()) && (paramView.app() != 1) && (paramContextMenu != null)) {
          paramContextMenu.add(this.position, 7, 0, R.l.eyI);
        }
        paramView = com.tencent.mm.util.i.YyX;
        if ((com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.YxQ, 0) == 1) && (paramContextMenu != null))
        {
          paramContextMenu.add(this.position, 8, 0, (CharSequence)"Debug");
          AppMethodBeat.o(224019);
          return;
        }
      }
      AppMethodBeat.o(224019);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$MenuItemSelectedListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "dataItem", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "position", "", "(Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;I)V", "getDataItem", "()Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getPosition", "()I", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "app_release"})
  public final class c
    implements q.g
  {
    private final d Xxk;
    private final int position;
    
    public c(int paramInt)
    {
      AppMethodBeat.i(284308);
      this.Xxk = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(284308);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(284307);
      if (paramMenuItem != null)
      {
        switch (paramMenuItem.getItemId())
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(284307);
          return;
        case 1: 
        case 2: 
          MvvmAddressUIFragment.aE(this.Xxk.contact);
          AppMethodBeat.o(284307);
          return;
        case 7: 
          MvvmAddressUIFragment.a(MvvmAddressUIFragment.this, this.Xxk.contact);
          AppMethodBeat.o(284307);
          return;
        }
        paramMenuItem = Util.secPrint(this.Xxk.contact.getUsername()) + "-" + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd_HH:mm:ss", cm.bfF()) + ".txt";
        ((PluginRepairer)com.tencent.mm.kernel.h.ag(PluginRepairer.class)).sendContactInfo(paramMenuItem, this.Xxk.contact);
        AppMethodBeat.o(284307);
        return;
      }
      AppMethodBeat.o(284307);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.livelist.h<d>>
  {
    d(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<a>
  {
    public static final e Xxm;
    
    static
    {
      AppMethodBeat.i(288845);
      Xxm = new e();
      AppMethodBeat.o(288845);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<b>
  {
    public static final f Xxn;
    
    static
    {
      AppMethodBeat.i(289039);
      Xxn = new f();
      AppMethodBeat.o(289039);
    }
    
    f()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(272544);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new c();
      AppMethodBeat.o(272544);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.livelist.a.e<d, com.tencent.mm.plugin.livelist.a.c<d>, com.tencent.mm.plugin.livelist.a.d<d>>>
  {
    h(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(277821);
      this.Xxl.hUl();
      AppMethodBeat.o(277821);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void run()
    {
      AppMethodBeat.i(272274);
      Object localObject = com.tencent.mm.kernel.h.ae(n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      if (((n)localObject).bbL().bwr("@social.black.android") > 0)
      {
        localObject = com.tencent.mm.kernel.h.aHG();
        p.j(localObject, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VCV, Boolean.TRUE);
        localObject = MvvmAddressUIFragment.e(this.Xxl);
        if (localObject != null)
        {
          ((com.tencent.mm.ui.contact.b)localObject).post((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(291244);
              com.tencent.mm.ui.contact.b localb = MvvmAddressUIFragment.e(this.Xxo.Xxl);
              if (localb != null)
              {
                localb.setVisible(true);
                AppMethodBeat.o(291244);
                return;
              }
              AppMethodBeat.o(291244);
            }
          });
          AppMethodBeat.o(272274);
          return;
        }
      }
      AppMethodBeat.o(272274);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "openimCount", "", "onOpenIMListHeaderViewChange"})
  static final class k
    implements aa.a
  {
    k(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void awK(int paramInt)
    {
      AppMethodBeat.i(272446);
      if ((MvvmAddressUIFragment.g(this.Xxl) == null) || (MvvmAddressUIFragment.f(this.Xxl) == null))
      {
        AppMethodBeat.o(272446);
        return;
      }
      if (paramInt <= 0)
      {
        localObject = MvvmAddressUIFragment.g(this.Xxl);
        if (localObject != null) {
          ((aa)localObject).setVisibility(8);
        }
        localObject = MvvmAddressUIFragment.f(this.Xxl);
        if (localObject != null)
        {
          ((BizContactEntranceView)localObject).GJ(true);
          AppMethodBeat.o(272446);
          return;
        }
        AppMethodBeat.o(272446);
        return;
      }
      Object localObject = MvvmAddressUIFragment.g(this.Xxl);
      if (localObject != null) {
        ((aa)localObject).setVisibility(0);
      }
      localObject = MvvmAddressUIFragment.f(this.Xxl);
      if (localObject != null)
      {
        ((BizContactEntranceView)localObject).GJ(false);
        AppMethodBeat.o(272446);
        return;
      }
      AppMethodBeat.o(272446);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enterpriseBizCount", "", "onEnterpriseBizViewChange"})
  static final class l
    implements j.a
  {
    l(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void awJ(int paramInt)
    {
      AppMethodBeat.i(223668);
      if (MvvmAddressUIFragment.h(this.Xxl) == null)
      {
        AppMethodBeat.o(223668);
        return;
      }
      if (paramInt <= 0)
      {
        localj = MvvmAddressUIFragment.h(this.Xxl);
        if (localj != null)
        {
          localj.setVisibility(8);
          AppMethodBeat.o(223668);
          return;
        }
        AppMethodBeat.o(223668);
        return;
      }
      com.tencent.mm.ui.contact.j localj = MvvmAddressUIFragment.h(this.Xxl);
      if (localj != null)
      {
        localj.setVisibility(0);
        AppMethodBeat.o(223668);
        return;
      }
      AppMethodBeat.o(223668);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "visible", "", "onVisibilityChange"})
  static final class m
    implements aa.b
  {
    m(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void GI(boolean paramBoolean)
    {
      AppMethodBeat.i(272814);
      if (MvvmAddressUIFragment.f(this.Xxl) == null)
      {
        AppMethodBeat.o(272814);
        return;
      }
      BizContactEntranceView localBizContactEntranceView = MvvmAddressUIFragment.f(this.Xxl);
      if (localBizContactEntranceView != null)
      {
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localBizContactEntranceView.GJ(paramBoolean);
          AppMethodBeat.o(272814);
          return;
        }
      }
      AppMethodBeat.o(272814);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<AddressLiveList>
  {
    n(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1", "invoke", "()Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1;"})
  static final class o
    extends q
    implements kotlin.g.a.a<1>
  {
    o(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onScollBarTouch"})
  static final class p
    implements VerticalScrollBar.a
  {
    p(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    public final void KH(String paramString)
    {
      AppMethodBeat.i(217152);
      System.currentTimeMillis();
      if (paramString == null) {}
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              p.j(paramString, "it");
              if (paramString != null) {
                break;
              }
              paramString = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(217152);
              throw paramString;
              switch (paramString.hashCode())
              {
              }
            }
          } while (!paramString.equals("#"));
          this.Xxl.awR(123);
          AppMethodBeat.o(217152);
          return;
        } while (!paramString.equals("↑"));
        paramString = MvvmAddressUIFragment.a(this.Xxl);
        if (paramString == null) {
          break;
        }
        paramString.au(0, 0);
        AppMethodBeat.o(217152);
        return;
      } while (!paramString.equals("☆"));
      this.Xxl.awR(32);
      AppMethodBeat.o(217152);
      return;
      AppMethodBeat.o(217152);
      return;
      paramString = paramString.toCharArray();
      p.j(paramString, "(this as java.lang.String).toCharArray()");
      paramString = kotlin.a.e.c(paramString);
      if (paramString != null)
      {
        int i = paramString.charValue();
        this.Xxl.awR(i);
        AppMethodBeat.o(217152);
        return;
      }
      AppMethodBeat.o(217152);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onTabCreate$3", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "onChanged", "", "t", "app_release"})
  public static final class q
    implements s<List<? extends d>>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MvvmAddressUIFragment.q paramq) {}
      
      public final void run()
      {
        AppMethodBeat.i(282003);
        MvvmAddressUIFragment.b(this.Xxq.Xxl);
        MvvmAddressUIFragment localMvvmAddressUIFragment = this.Xxq.Xxl;
        ContactCountView localContactCountView = new ContactCountView((Context)this.Xxq.Xxl.getContext());
        localContactCountView.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -2));
        com.tencent.mm.view.recyclerview.h.b(MvvmAddressUIFragment.c(this.Xxq.Xxl), (View)localContactCountView, localContactCountView.hashCode());
        MvvmAddressUIFragment.a(localMvvmAddressUIFragment, localContactCountView);
        AppMethodBeat.o(282003);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.MvvmAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */