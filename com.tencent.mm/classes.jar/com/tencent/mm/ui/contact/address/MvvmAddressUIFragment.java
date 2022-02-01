package com.tencent.mm.ui.contact.address;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.contact.BizContactEntranceView;
import com.tencent.mm.ui.contact.ContactCountView;
import com.tencent.mm.ui.contact.ab.b;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;", "Lcom/tencent/mm/ui/contact/address/BaseAddressUIFragment;", "()V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getAdapter", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "addressDataSource", "Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "getAddressDataSource", "()Lcom/tencent/mm/ui/contact/address/AddressDataSource;", "addressDataSource$delegate", "addressFavorDataSource", "Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "getAddressFavorDataSource", "()Lcom/tencent/mm/ui/contact/address/AddressFavorDataSource;", "addressFavorDataSource$delegate", "bizEntranceView", "Lcom/tencent/mm/ui/contact/BizContactEntranceView;", "chatroomEntranceView", "Lcom/tencent/mm/ui/contact/AddressUIEntranceHeaderView;", "contactCountView", "Lcom/tencent/mm/ui/contact/ContactCountView;", "contactLabelEntranceView", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "getDataSource", "()Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "dataSource$delegate", "doubleClickJob", "Ljava/lang/Runnable;", "enterpriseBizView", "Lcom/tencent/mm/ui/contact/EnterpriseBizView;", "fadeIn", "Landroid/view/animation/Animation;", "fadeOut", "fcView", "Lcom/tencent/mm/ui/contact/FMessageContactView;", "ipcallEntranceView", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "liveList", "Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "getLiveList", "()Lcom/tencent/mm/ui/contact/address/AddressLiveList;", "liveList$delegate", "onItemClickListener", "com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1", "getOnItemClickListener", "()Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1;", "onItemClickListener$delegate", "onlyChatContactEntranceView", "openIMListHeaderView", "Lcom/tencent/mm/ui/contact/OpenIMListHeaderView;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "reporter", "Lcom/tencent/mm/ui/contact/address/MvvmAddressUIReporter;", "getReporter", "()Lcom/tencent/mm/ui/contact/address/MvvmAddressUIReporter;", "reporter$delegate", "scrollBar", "Lcom/tencent/mm/ui/base/AlphabetScrollBar;", "x_down", "", "y_down", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "deleteContact", "", "contact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "getLayoutView", "Landroid/view/View;", "getLogTag", "", "initHeaderView", "markLoadingGone", "moveToTop", "onTabCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTabDestroy", "onTabPause", "onTabResume", "onTabSwitchIn", "requestToTop", "scrollToShowHead", "showHeadCode", "showScrollBar", "show", "", "turnToBg", "viewRemarkInfo", "Companion", "CreateContextMenuListener", "MenuItemSelectedListener", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MvvmAddressUIFragment
  extends BaseAddressUIFragment
{
  public static final MvvmAddressUIFragment.a afjo;
  private WxRecyclerView AZd;
  private final kotlin.j DHL;
  private AlphabetScrollBar FWh;
  private final kotlin.j FWi;
  private final kotlin.j FWm;
  private Animation LQl;
  private l afbh;
  private BizContactEntranceView afbi;
  private com.tencent.mm.ui.contact.b afbj;
  private com.tencent.mm.ui.contact.b afbk;
  private com.tencent.mm.ui.contact.b afbl;
  private com.tencent.mm.ui.contact.b afbm;
  private ContactCountView afbn;
  private com.tencent.mm.ui.contact.ab afbo;
  private com.tencent.mm.ui.contact.j afbp;
  private final kotlin.j afjp;
  private final kotlin.j afjq;
  private final RecyclerView.m afjr;
  private WxLinearLayoutManager afjs;
  private final Runnable afjt;
  private final kotlin.j nWO;
  private com.tencent.mm.ui.widget.b.a vEV;
  private final kotlin.j xZP;
  private int x_down;
  private int y_down;
  private Animation zUH;
  
  static
  {
    AppMethodBeat.i(253535);
    afjo = new MvvmAddressUIFragment.a((byte)0);
    AppMethodBeat.o(253535);
  }
  
  public MvvmAddressUIFragment()
  {
    AppMethodBeat.i(253291);
    this.nWO = kotlin.k.cm((kotlin.g.a.a)l.afjy);
    this.afjp = kotlin.k.cm((kotlin.g.a.a)MvvmAddressUIFragment.e.afjw);
    this.afjq = kotlin.k.cm((kotlin.g.a.a)MvvmAddressUIFragment.f.afjx);
    this.DHL = kotlin.k.cm((kotlin.g.a.a)new MvvmAddressUIFragment.h(this));
    this.FWi = kotlin.k.cm((kotlin.g.a.a)new MvvmAddressUIFragment.i(this));
    RecyclerView.m localm = new RecyclerView.m();
    localm.bD(2, 30);
    localm.bD(1, 10);
    ah localah = ah.aiuX;
    this.afjr = localm;
    this.xZP = kotlin.k.cm((kotlin.g.a.a)new MvvmAddressUIFragment.d(this));
    this.FWm = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.afjt = new MvvmAddressUIFragment..ExternalSyntheticLambda5(this);
    AppMethodBeat.o(253291);
  }
  
  private static final void a(MvvmAddressUIFragment paramMvvmAddressUIFragment)
  {
    AppMethodBeat.i(253357);
    s.u(paramMvvmAddressUIFragment, "this$0");
    paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbm;
    if (paramMvvmAddressUIFragment != null) {
      paramMvvmAddressUIFragment.setVisible(true);
    }
    AppMethodBeat.o(253357);
  }
  
  private static final void a(MvvmAddressUIFragment paramMvvmAddressUIFragment, int paramInt)
  {
    AppMethodBeat.i(253387);
    s.u(paramMvvmAddressUIFragment, "this$0");
    if ((paramMvvmAddressUIFragment.afbo == null) || (paramMvvmAddressUIFragment.afbi == null))
    {
      AppMethodBeat.o(253387);
      return;
    }
    com.tencent.mm.ui.contact.ab localab;
    if (paramInt <= 0)
    {
      localab = paramMvvmAddressUIFragment.afbo;
      if (localab != null) {
        localab.setVisibility(8);
      }
      paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbi;
      if (paramMvvmAddressUIFragment != null)
      {
        paramMvvmAddressUIFragment.Mx(true);
        AppMethodBeat.o(253387);
      }
    }
    else
    {
      localab = paramMvvmAddressUIFragment.afbo;
      if (localab != null) {
        localab.setVisibility(0);
      }
      paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbi;
      if (paramMvvmAddressUIFragment != null) {
        paramMvvmAddressUIFragment.Mx(false);
      }
    }
    AppMethodBeat.o(253387);
  }
  
  private static final void a(MvvmAddressUIFragment paramMvvmAddressUIFragment, String paramString)
  {
    AppMethodBeat.i(253346);
    s.u(paramMvvmAddressUIFragment, "this$0");
    System.currentTimeMillis();
    if (paramString != null) {
      switch (paramString.hashCode())
      {
      }
    }
    do
    {
      do
      {
        s.s(paramString, "it");
        paramString = paramString.toCharArray();
        s.s(paramString, "(this as java.lang.String).toCharArray()");
        paramString = kotlin.a.k.c(paramString);
        if (paramString != null) {
          paramMvvmAddressUIFragment.aDy(paramString.charValue());
        }
        do
        {
          AppMethodBeat.o(253346);
          return;
          if (!paramString.equals("↑")) {
            break;
          }
          paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afjs;
        } while (paramMvvmAddressUIFragment == null);
        paramMvvmAddressUIFragment.bo(0, 0);
        AppMethodBeat.o(253346);
        return;
      } while (!paramString.equals("#"));
      paramMvvmAddressUIFragment.aDy(123);
      AppMethodBeat.o(253346);
      return;
    } while (!paramString.equals("☆"));
    paramMvvmAddressUIFragment.aDy(32);
    AppMethodBeat.o(253346);
  }
  
  private static final void a(MvvmAddressUIFragment paramMvvmAddressUIFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(253373);
    s.u(paramMvvmAddressUIFragment, "this$0");
    if (paramMvvmAddressUIFragment.afbi == null)
    {
      AppMethodBeat.o(253373);
      return;
    }
    paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbi;
    if (paramMvvmAddressUIFragment != null) {
      if (paramBoolean) {
        break label54;
      }
    }
    label54:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramMvvmAddressUIFragment.Mx(paramBoolean);
      AppMethodBeat.o(253373);
      return;
    }
  }
  
  private void aDy(int paramInt)
  {
    AppMethodBeat.i(253334);
    MvvmAddressUIFragment localMvvmAddressUIFragment = (MvvmAddressUIFragment)this;
    Object localObject1 = ((Iterable)localMvvmAddressUIFragment.jzs().pUj).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject2 = (d)localObject2;
      if ((((d)localObject2).FWv == paramInt) && (((d)localObject2).FWu))
      {
        localObject1 = localMvvmAddressUIFragment.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).JO();
        }
        localObject1 = localMvvmAddressUIFragment.afjs;
        if (localObject1 != null) {
          ((WxLinearLayoutManager)localObject1).bo(i + localMvvmAddressUIFragment.fcp().agOb.size(), 0);
        }
        AppMethodBeat.o(253334);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(253334);
  }
  
  private static final void b(MvvmAddressUIFragment paramMvvmAddressUIFragment)
  {
    AppMethodBeat.i(253368);
    s.u(paramMvvmAddressUIFragment, "this$0");
    if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxG("@social.black.android") > 0)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfP, Boolean.TRUE);
      com.tencent.mm.ui.contact.b localb = paramMvvmAddressUIFragment.afbm;
      if (localb != null) {
        localb.post(new MvvmAddressUIFragment..ExternalSyntheticLambda4(paramMvvmAddressUIFragment));
      }
    }
    AppMethodBeat.o(253368);
  }
  
  private static final void b(MvvmAddressUIFragment paramMvvmAddressUIFragment, int paramInt)
  {
    AppMethodBeat.i(253398);
    s.u(paramMvvmAddressUIFragment, "this$0");
    if (paramMvvmAddressUIFragment.afbp == null)
    {
      AppMethodBeat.o(253398);
      return;
    }
    if (paramInt <= 0)
    {
      paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbp;
      if (paramMvvmAddressUIFragment != null)
      {
        paramMvvmAddressUIFragment.setVisibility(8);
        AppMethodBeat.o(253398);
      }
    }
    else
    {
      paramMvvmAddressUIFragment = paramMvvmAddressUIFragment.afbp;
      if (paramMvvmAddressUIFragment != null) {
        paramMvvmAddressUIFragment.setVisibility(0);
      }
    }
    AppMethodBeat.o(253398);
  }
  
  private static final void c(MvvmAddressUIFragment paramMvvmAddressUIFragment)
  {
    AppMethodBeat.i(253406);
    s.u(paramMvvmAddressUIFragment, "this$0");
    paramMvvmAddressUIFragment.jyb();
    AppMethodBeat.o(253406);
  }
  
  private final g<d> fcp()
  {
    AppMethodBeat.i(253327);
    g localg = (g)this.xZP.getValue();
    AppMethodBeat.o(253327);
    return localg;
  }
  
  private final e jzp()
  {
    AppMethodBeat.i(253293);
    e locale = (e)this.nWO.getValue();
    AppMethodBeat.o(253293);
    return locale;
  }
  
  private final a jzq()
  {
    AppMethodBeat.i(253300);
    a locala = (a)this.afjp.getValue();
    AppMethodBeat.o(253300);
    return locala;
  }
  
  private final b jzr()
  {
    AppMethodBeat.i(253309);
    b localb = (b)this.afjq.getValue();
    AppMethodBeat.o(253309);
    return localb;
  }
  
  private final AddressLiveList jzs()
  {
    AppMethodBeat.i(253317);
    AddressLiveList localAddressLiveList = (AddressLiveList)this.FWi.getValue();
    AppMethodBeat.o(253317);
    return localAddressLiveList;
  }
  
  public final void Mw(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(253637);
    Object localObject;
    if (this.FWh != null)
    {
      if (this.zUH == null)
      {
        this.zUH = AnimationUtils.loadAnimation((Context)getContext(), R.a.fjx);
        localObject = this.zUH;
        if (localObject != null) {
          ((Animation)localObject).setDuration(200L);
        }
      }
      if (this.LQl == null)
      {
        this.LQl = AnimationUtils.loadAnimation((Context)getContext(), R.a.fjx);
        localObject = this.LQl;
        if (localObject != null) {
          ((Animation)localObject).setDuration(200L);
        }
      }
      if (paramBoolean)
      {
        localObject = this.FWh;
        if ((localObject != null) && (((AlphabetScrollBar)localObject).getVisibility() == 0)) {}
        while (i == 0)
        {
          localObject = this.FWh;
          if (localObject != null) {
            ((AlphabetScrollBar)localObject).setVisibility(0);
          }
          localObject = this.FWh;
          if (localObject == null) {
            break;
          }
          ((AlphabetScrollBar)localObject).startAnimation(this.zUH);
          AppMethodBeat.o(253637);
          return;
          i = 0;
        }
      }
      localObject = this.FWh;
      if ((localObject == null) || (4 != ((AlphabetScrollBar)localObject).getVisibility())) {
        break label224;
      }
    }
    label224:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.FWh;
        if (localObject != null) {
          ((AlphabetScrollBar)localObject).setVisibility(8);
        }
        localObject = this.FWh;
        if (localObject != null) {
          ((AlphabetScrollBar)localObject).startAnimation(this.LQl);
        }
      }
      AppMethodBeat.o(253637);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return R.i.gdZ;
  }
  
  public final View getLayoutView()
  {
    AppMethodBeat.i(253620);
    com.tencent.mm.kiss.layout.b.bbG();
    View localView = com.tencent.mm.kiss.layout.b.d(getContext(), R.i.gdZ);
    AppMethodBeat.o(253620);
    return localView;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.MvvmAddressUIFragment";
  }
  
  public final void hFq()
  {
    AppMethodBeat.i(253676);
    if (this.afbh != null) {
      l.gqT();
    }
    AppMethodBeat.o(253676);
  }
  
  public final void jhn()
  {
    Object localObject2 = null;
    AppMethodBeat.i(253604);
    Log.i("MicroMsg.Mvvm.MvvmAddressUIFragment", "onTabCreate");
    jzp().aNS();
    jil();
    Object localObject1 = getView();
    Object localObject3;
    com.tencent.mm.ui.contact.ab localab;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.AZd = ((WxRecyclerView)localObject1);
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setHasFixedSize(true);
      }
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setItemViewCacheSize(30);
      }
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setRecycledViewPool(this.afjr);
      }
      localObject1 = this.AZd;
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)fcp());
      }
      localObject1 = getContext();
      if (localObject1 != null)
      {
        this.afjs = new WxLinearLayoutManager((Context)localObject1);
        localObject1 = this.afjs;
        if (localObject1 != null) {
          ((LinearLayoutManager)localObject1).bXK = 20;
        }
        localObject1 = this.AZd;
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)this.afjs);
        }
      }
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      this.afbk = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.afbF);
      ((LinearLayout)localObject1).addView((View)this.afbk);
      localObject3 = this.afbk;
      if (localObject3 != null) {
        ((com.tencent.mm.ui.contact.b)localObject3).setVisible(false);
      }
      this.afbh = new l((Context)getContext());
      ((LinearLayout)localObject1).addView((View)this.afbh);
      this.afbm = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.afbG);
      ((LinearLayout)localObject1).addView((View)this.afbm);
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfP, false);
      if (!bool) {
        com.tencent.threadpool.h.ahAA.bn(new MvvmAddressUIFragment..ExternalSyntheticLambda6(this));
      }
      localObject3 = this.afbm;
      if (localObject3 != null) {
        ((com.tencent.mm.ui.contact.b)localObject3).setVisible(bool);
      }
      this.afbj = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.afbD);
      ((LinearLayout)localObject1).addView((View)this.afbj);
      localObject3 = this.afbj;
      if (localObject3 != null) {
        ((com.tencent.mm.ui.contact.b)localObject3).setVisible(true);
      }
      this.afbl = new com.tencent.mm.ui.contact.b((Context)getContext(), com.tencent.mm.ui.contact.b.a.afbE);
      ((LinearLayout)localObject1).addView((View)this.afbl);
      localObject3 = this.afbl;
      if (localObject3 != null) {
        ((com.tencent.mm.ui.contact.b)localObject3).setVisible(true);
      }
      if (com.tencent.mm.br.c.blq("brandservice"))
      {
        this.afbi = new BizContactEntranceView((Context)getContext());
        ((LinearLayout)localObject1).addView((View)this.afbi);
        localObject3 = this.afbi;
        if (localObject3 != null) {
          ((BizContactEntranceView)localObject3).setVisible(true);
        }
      }
      localObject3 = new MvvmAddressUIFragment..ExternalSyntheticLambda2(this);
      this.afbo = new com.tencent.mm.ui.contact.ab((Context)getContext(), new MvvmAddressUIFragment..ExternalSyntheticLambda1(this));
      localab = this.afbo;
      if (localab != null) {
        localab.setOnVisibilityChangeListener((ab.b)localObject3);
      }
      localab = this.afbo;
      if (localab != null) {
        break label961;
      }
      i = 0;
      label572:
      if (i > 0) {
        break label970;
      }
      ((ab.b)localObject3).onVisibilityChange(false);
      localObject3 = this.afbo;
      if (localObject3 != null) {
        ((com.tencent.mm.ui.contact.ab)localObject3).setVisibility(8);
      }
      label602:
      ((LinearLayout)localObject1).addView((View)this.afbo);
      this.afbp = new com.tencent.mm.ui.contact.j((Context)getContext(), new MvvmAddressUIFragment..ExternalSyntheticLambda3(this));
      localObject3 = this.afbp;
      if (localObject3 != null) {
        break label981;
      }
      i = 0;
      label652:
      if (i <= 0)
      {
        localObject3 = this.afbp;
        if (localObject3 != null) {
          ((com.tencent.mm.ui.contact.j)localObject3).setVisibility(8);
        }
      }
      af.bHf().a((f.a)this.afbp, null);
      ((LinearLayout)localObject1).addView((View)this.afbp);
      com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)fcp(), (View)localObject1, ((LinearLayout)localObject1).hashCode());
      fcp().agOO = ((com.tencent.mm.view.recyclerview.h)this.FWm.getValue());
      localObject1 = getView();
      if (localObject1 != null) {
        break label990;
      }
    }
    label961:
    label970:
    label981:
    label990:
    for (localObject1 = localObject2;; localObject1 = (AlphabetScrollBar)((View)localObject1).findViewById(R.h.fqN))
    {
      this.FWh = ((AlphabetScrollBar)localObject1);
      localObject1 = this.FWh;
      if (localObject1 != null) {
        ((AlphabetScrollBar)localObject1).setOnScrollBarTouchListener(new MvvmAddressUIFragment..ExternalSyntheticLambda0(this));
      }
      this.vEV = new com.tencent.mm.ui.widget.b.a((Context)getContext());
      jzq().Mnt = ((MvvmList)jzs());
      jzr().Mnt = ((MvvmList)jzs());
      localObject1 = com.tencent.mm.plugin.ac.b.MnM;
      ((com.tencent.mm.plugin.ac.a.a)com.tencent.mm.plugin.ac.b.a.q(com.tencent.mm.plugin.ac.a.a.class)).observe((q)this, (IStorageObserver)jzq());
      localObject1 = com.tencent.mm.plugin.ac.b.MnM;
      ((com.tencent.mm.plugin.ac.a.a)com.tencent.mm.plugin.ac.b.a.q(com.tencent.mm.plugin.ac.a.a.class)).observe((q)this, (IStorageObserver)jzr());
      jzs().MmR.a((q)this, (y)new k(this));
      localObject1 = getBounceView();
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.pulldown.f)localObject1).setEnd2StartBgColor(getResources().getColor(R.e.BG_2));
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1728L, 0L, 1L, false);
      AppMethodBeat.o(253604);
      return;
      localObject1 = (WxRecyclerView)((View)localObject1).findViewById(R.h.fqD);
      break;
      i = localab.getOpenIMCount();
      break label572;
      ((ab.b)localObject3).onVisibilityChange(true);
      break label602;
      i = ((com.tencent.mm.ui.contact.j)localObject3).getEnterpriseFriendCount();
      break label652;
    }
  }
  
  public final void jho()
  {
    AppMethodBeat.i(253651);
    super.jho();
    Object localObject = getContext();
    if ((localObject instanceof LauncherUI))
    {
      localObject = (LauncherUI)localObject;
      if (localObject != null)
      {
        localObject = ((LauncherUI)localObject).getHomeUI();
        if (localObject != null) {
          ((HomeUI)localObject).setTitleBarDoubleClickListener(this.afjt);
        }
      }
      long l = System.currentTimeMillis();
      bh.bCz();
      if (l - com.tencent.mm.model.c.ban().amW(340226) >= 180000L) {
        jyb();
      }
      localObject = this.afbh;
      if (localObject != null) {
        ((l)localObject).setFrontGround(true);
      }
      if (this.afbh != null) {
        l.gqT();
      }
      localObject = this.afbp;
      if (localObject != null)
      {
        if (((com.tencent.mm.ui.contact.j)localObject).getEnterpriseFriendCount() > 0) {
          break label162;
        }
        ((com.tencent.mm.ui.contact.j)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      localObject = this.afbi;
      if (localObject != null) {
        ((BizContactEntranceView)localObject).irV();
      }
      localObject = this.afbn;
      if (localObject != null) {
        ((ContactCountView)localObject).jyf();
      }
      AppMethodBeat.o(253651);
      return;
      localObject = null;
      break;
      label162:
      ((com.tencent.mm.ui.contact.j)localObject).setVisibility(0);
    }
  }
  
  public final void jhq()
  {
    AppMethodBeat.i(253645);
    super.jhq();
    Object localObject = getContext();
    if ((localObject instanceof LauncherUI)) {}
    for (localObject = (LauncherUI)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((LauncherUI)localObject).getHomeUI();
        if (localObject != null) {
          ((HomeUI)localObject).aW(this.afjt);
        }
      }
      bh.bCz();
      com.tencent.mm.model.c.ban().B(340226, Long.valueOf(System.currentTimeMillis()));
      localObject = this.vEV;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.b.a)localObject).diW();
      }
      localObject = this.afbh;
      if (localObject != null) {
        ((l)localObject).setFrontGround(false);
      }
      AppMethodBeat.o(253645);
      return;
    }
  }
  
  public final void jhs()
  {
    AppMethodBeat.i(253658);
    super.jhs();
    Object localObject = this.afbp;
    if (localObject != null)
    {
      af.bHf().a((f.a)localObject);
      this.afbp = null;
    }
    localObject = this.afbh;
    if (localObject != null)
    {
      ((l)localObject).detach();
      this.afbh = null;
    }
    if (this.afbi != null) {
      this.afbi = null;
    }
    if (this.afbj != null) {
      this.afbj = null;
    }
    if (this.afbm != null) {
      this.afbm = null;
    }
    if (this.afbl != null) {
      this.afbl = null;
    }
    if (this.afbp != null) {
      this.afbp = null;
    }
    localObject = this.FWh;
    if (localObject != null) {
      ((VerticalScrollBar)localObject).adXj = null;
    }
    AppMethodBeat.o(253658);
  }
  
  public final void jht()
  {
    AppMethodBeat.i(253671);
    jyb();
    AppMethodBeat.o(253671);
  }
  
  public final void jhu()
  {
    AppMethodBeat.i(253667);
    super.jhu();
    Object localObject = this.afbi;
    if (localObject != null) {
      ((BizContactEntranceView)localObject).destroyDrawingCache();
    }
    localObject = this.afbj;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.afbl;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.afbm;
    if (localObject != null) {
      ((com.tencent.mm.ui.contact.b)localObject).destroyDrawingCache();
    }
    localObject = this.afbn;
    if (localObject != null) {
      ((ContactCountView)localObject).destroyDrawingCache();
    }
    localObject = this.afbh;
    if (localObject != null) {
      ((l)localObject).destroyDrawingCache();
    }
    AppMethodBeat.o(253667);
  }
  
  public final void jyb()
  {
    AppMethodBeat.i(253624);
    WxLinearLayoutManager localWxLinearLayoutManager = this.afjs;
    if (localWxLinearLayoutManager != null) {
      localWxLinearLayoutManager.bo(0, 0);
    }
    AppMethodBeat.o(253624);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment$CreateContextMenuListener;", "Landroid/view/View$OnCreateContextMenuListener;", "dataItem", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "position", "", "(Lcom/tencent/mm/ui/contact/address/MvvmAddressUIFragment;Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;I)V", "getDataItem", "()Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "getPosition", "()I", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements View.OnCreateContextMenuListener
  {
    private final d afju;
    private final int position;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(253187);
      this.afju = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(253187);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(253200);
      if (((paramContextMenuInfo instanceof AdapterView.AdapterContextMenuInfo)) && ((this.afju instanceof d)))
      {
        paramView = this.afju.contact;
        if (com.tencent.mm.model.ab.IQ(paramView.field_username))
        {
          if (paramContextMenu != null) {
            paramContextMenu.setHeaderTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)MvvmAddressUIFragment.this.getContext(), (CharSequence)paramView.aSV()));
          }
          if (paramContextMenu != null) {
            paramContextMenu.add(this.position, 2, 0, R.l.gqu);
          }
          AppMethodBeat.o(253200);
          return;
        }
        if ((au.bwc(paramView.field_username)) || (au.bws(paramView.field_username)))
        {
          AppMethodBeat.o(253200);
          return;
        }
        if (paramContextMenu != null) {
          paramContextMenu.setHeaderTitle((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)MvvmAddressUIFragment.this.getContext(), (CharSequence)paramView.aSV()));
        }
        if ((com.tencent.mm.contact.d.rs(paramView.field_type)) && (paramView.field_deleteFlag != 1) && (paramContextMenu != null)) {
          paramContextMenu.add(this.position, 7, 0, R.l.gBA);
        }
        paramView = com.tencent.mm.util.i.agtt;
        if ((com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agqA, 0) == 1) && (paramContextMenu != null)) {
          paramContextMenu.add(this.position, 8, 0, (CharSequence)"Debug");
        }
      }
      AppMethodBeat.o(253200);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onItemClickListener$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<1>
  {
    j(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/contact/address/MvvmAddressUIFragment$onTabCreate$3", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "onChanged", "", "t", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements y<List<? extends d>>
  {
    k(MvvmAddressUIFragment paramMvvmAddressUIFragment) {}
    
    private static final void n(MvvmAddressUIFragment paramMvvmAddressUIFragment)
    {
      AppMethodBeat.i(253213);
      s.u(paramMvvmAddressUIFragment, "this$0");
      MvvmAddressUIFragment.g(paramMvvmAddressUIFragment);
      ContactCountView localContactCountView = new ContactCountView((Context)paramMvvmAddressUIFragment.getContext());
      localContactCountView.setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -2));
      com.tencent.mm.view.recyclerview.i.b((com.tencent.mm.view.recyclerview.i)MvvmAddressUIFragment.f(paramMvvmAddressUIFragment), (View)localContactCountView, localContactCountView.hashCode());
      ah localah = ah.aiuX;
      MvvmAddressUIFragment.a(paramMvvmAddressUIFragment, localContactCountView);
      AppMethodBeat.o(253213);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/address/MvvmAddressUIReporter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<e>
  {
    public static final l afjy;
    
    static
    {
      AppMethodBeat.i(253206);
      afjy = new l();
      AppMethodBeat.o(253206);
    }
    
    l()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.MvvmAddressUIFragment
 * JD-Core Version:    0.7.0.1
 */