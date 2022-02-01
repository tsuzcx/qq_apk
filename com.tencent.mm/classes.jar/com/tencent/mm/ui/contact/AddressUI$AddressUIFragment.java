package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.contact.address.BaseAddressUIFragment;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI$AddressUIFragment
  extends BaseAddressUIFragment
  implements com.tencent.mm.an.i
{
  private ListView Een;
  private Animation FVj;
  private IListener KZF;
  private AlphabetScrollBar WFZ;
  private String XoS;
  private String XoT;
  private String XpA;
  private String XpB;
  private int XpC;
  private boolean XpD;
  private boolean XpE;
  private l XpF;
  private BizContactEntranceView XpG;
  private b XpH;
  private b XpI;
  private b XpJ;
  private b XpK;
  private ContactCountView XpL;
  private aa XpM;
  private j XpN;
  boolean XpO;
  private boolean XpP;
  private LinearLayout XpQ;
  private VerticalScrollBar.a XpR;
  List<String> XpS;
  private Runnable XpT;
  private TextView Xpw;
  private TextView Xpx;
  private a Xpy;
  private com.tencent.mm.ui.voicesearch.b Xpz;
  private ProgressDialog iXX;
  com.tencent.mm.pluginsdk.ui.e iYA;
  List<String> jkb;
  private TextView mUJ;
  private boolean mYQ;
  private final long meZ;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private q.g voR;
  private Animation wyA;
  
  public AddressUI$AddressUIFragment()
  {
    AppMethodBeat.i(37621);
    this.iXX = null;
    this.XpB = "";
    this.XpD = false;
    this.mYQ = false;
    this.XpE = false;
    this.XpP = true;
    this.meZ = 180000L;
    this.KZF = new AddressUI.AddressUIFragment.1(this);
    this.voR = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(37603);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(37603);
          return;
        case 1: 
        case 2: 
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(37603);
          return;
        }
        AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
        AppMethodBeat.o(37603);
      }
    };
    this.XpR = new VerticalScrollBar.a()
    {
      public final void KH(String paramAnonymousString)
      {
        int i = 0;
        AppMethodBeat.i(37604);
        if (AddressUI.AddressUIFragment.this.getString(R.l.scroll_bar_search).equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(37604);
          return;
        }
        Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
        Log.v("MicroMsg.AddressAdapter", "getSections");
        localObject = ((a)localObject).XoY;
        if (localObject == null)
        {
          AppMethodBeat.o(37604);
          return;
        }
        if ("↑".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(37604);
          return;
        }
        if ("☆".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          AppMethodBeat.o(37604);
          return;
        }
        do
        {
          i += 1;
          if ((i >= localObject.length) || (localObject[i] == null)) {
            break;
          }
        } while (!localObject[i].equals(paramAnonymousString));
        i = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).awI(i);
        AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setSelection(i + AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
        AppMethodBeat.o(37604);
        return;
        AppMethodBeat.o(37604);
      }
    };
    this.iYA = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(37605);
        if (paramAnonymousInt1 < 2)
        {
          AppMethodBeat.o(37605);
          return;
        }
        if (!AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this)) {
          AddressUI.AddressUIFragment.p(AddressUI.AddressUIFragment.this);
        }
        AppMethodBeat.o(37605);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(37606);
        AppMethodBeat.o(37606);
      }
    });
    this.jkb = new LinkedList();
    this.XpS = new LinkedList();
    this.XpT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37613);
        AddressUI.AddressUIFragment.r(AddressUI.AddressUIFragment.this);
        AppMethodBeat.o(37613);
      }
    };
    AppMethodBeat.o(37621);
  }
  
  private void hUj()
  {
    AppMethodBeat.i(37628);
    this.jkb = new LinkedList();
    this.XpS = new LinkedList();
    com.tencent.mm.by.c.hok();
    this.jkb.add("tmessage");
    this.XpS.addAll(this.jkb);
    if (!this.jkb.contains("officialaccounts")) {
      this.jkb.add("officialaccounts");
    }
    this.jkb.add("helper_entry");
    if (this.Xpy != null) {
      this.Xpy.kw(this.jkb);
    }
    if (this.Xpz != null) {
      this.Xpz.kw(this.XpS);
    }
    AppMethodBeat.o(37628);
  }
  
  private void hUk()
  {
    try
    {
      AppMethodBeat.i(37632);
      long l = System.currentTimeMillis();
      hUj();
      Log.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.Xpy != null)
      {
        Log.v("MicroMsg.AddressUI", "post to do refresh");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37607);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).hUi();
            if (AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) != null) {
              AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).reset();
            }
            AppMethodBeat.o(37607);
          }
        });
      }
      if (this.Xpz != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37609);
            Log.v("MicroMsg.AddressUI", "post search adapter to do refresh");
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).onNotifyChange(null, null);
            AppMethodBeat.o(37609);
          }
        });
      }
      Log.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(37632);
      return;
    }
    finally {}
  }
  
  public final void GH(boolean paramBoolean)
  {
    AppMethodBeat.i(37624);
    if (this.WFZ != null)
    {
      if (this.wyA == null)
      {
        this.wyA = AnimationUtils.loadAnimation(getContext(), R.a.djB);
        this.wyA.setDuration(200L);
      }
      if (this.FVj == null)
      {
        this.FVj = AnimationUtils.loadAnimation(getContext(), R.a.djB);
        this.FVj.setDuration(200L);
      }
      if (paramBoolean)
      {
        if (this.WFZ.getVisibility() != 0)
        {
          this.WFZ.setVisibility(0);
          this.WFZ.startAnimation(this.wyA);
          AppMethodBeat.o(37624);
        }
      }
      else if (4 != this.WFZ.getVisibility())
      {
        this.WFZ.setVisibility(8);
        this.WFZ.startAnimation(this.FVj);
      }
    }
    AppMethodBeat.o(37624);
  }
  
  public int getLayoutId()
  {
    return R.i.address;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(37622);
    com.tencent.mm.kiss.a.b.aIK();
    View localView = com.tencent.mm.kiss.a.b.d(getContext(), R.i.address);
    AppMethodBeat.o(37622);
    return localView;
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.AddressUI";
  }
  
  public final void gkE() {}
  
  public final void gkF()
  {
    AppMethodBeat.i(37639);
    if (this.XpF != null) {
      l.hUH();
    }
    AppMethodBeat.o(37639);
  }
  
  public final void hFb()
  {
    AppMethodBeat.i(37630);
    Log.v("MicroMsg.AddressUI", "address ui on create");
    Log.v("MicroMsg.AddressUI", "on address ui create");
    this.XpD = false;
    this.mYQ = false;
    this.XpE = false;
    this.XoS = null;
    this.XoT = null;
    this.XpA = null;
    bh.aGY().a(138, this);
    this.XoS = "@all.contact.without.chatroom.without.openim";
    this.XoT = getStringExtra("Contact_GroupFilter_Str");
    this.XpA = getString(R.l.eGu);
    this.XpC = getIntExtra("List_Type", 2);
    hGa();
    Log.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    if (this.Een != null)
    {
      if (this.XpF != null) {
        this.Een.removeHeaderView(this.XpF);
      }
      if (this.XpG != null) {
        this.Een.removeHeaderView(this.XpG);
      }
      if (this.XpH != null) {
        this.Een.removeHeaderView(this.XpH);
      }
      if (this.XpK != null) {
        this.Een.removeHeaderView(this.XpK);
      }
      if (this.XpJ != null) {
        this.Een.removeHeaderView(this.XpJ);
      }
    }
    this.Een = ((ListView)findViewById(R.h.address_contactlist));
    this.Een.setScrollingCacheEnabled(false);
    this.Xpw = ((TextView)findViewById(R.h.dFv));
    this.Xpw.setText(R.l.enu);
    this.mUJ = ((TextView)findViewById(R.h.dFA));
    this.mUJ.setText(R.l.enx);
    this.Xpx = ((TextView)findViewById(R.h.dFC));
    this.Xpx.setOnClickListener(new AddressUI.AddressUIFragment.12(this));
    this.Xpy = new a(getContext(), this.XoS, this.XoT, this.XpC);
    this.Een.setAdapter(null);
    this.Xpy.a(new g.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(290373);
        AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
        AddressUI.AddressUIFragment.b(localAddressUIFragment);
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).hUg();
        AppMethodBeat.o(290373);
      }
      
      public final void hFP() {}
    });
    this.Xpy.Xpf = true;
    this.Xpy.setFragment(this);
    this.Xpy.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(265624);
        Object localObject = paramAnonymousView;
        try
        {
          for (;;)
          {
            View localView = (View)((View)localObject).getParent();
            if (localView == null) {
              break;
            }
            boolean bool = localView.equals(AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this));
            if (bool) {
              break;
            }
            localObject = localView;
          }
          if (((View)localObject).getParent() != null) {
            break label70;
          }
        }
        catch (ClassCastException paramAnonymousView)
        {
          AppMethodBeat.o(265624);
          return -1;
        }
        AppMethodBeat.o(265624);
        return -1;
        label70:
        int i = AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(265624);
        return i;
      }
    });
    this.Xpy.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(276687);
        AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(276687);
      }
    });
    this.Xpy.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(267933);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.AddressUI", "onItemDel object null");
          AppMethodBeat.o(267933);
          return;
        }
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
        AppMethodBeat.o(267933);
      }
    });
    this.Xpz = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Xpz.Hl(true);
    this.XpQ = new LinearLayout(getContext());
    this.XpQ.setOrientation(1);
    this.Een.addHeaderView(this.XpQ);
    this.XpI = new b(getContext(), b.a.Xqc);
    this.XpQ.addView(this.XpI);
    bh.beI();
    ((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.Vjr, Boolean.FALSE)).booleanValue();
    this.XpI.setVisible(false);
    this.XpF = new l(getContext());
    this.XpQ.addView(this.XpF);
    this.XpK = new b(getContext(), b.a.Xqd);
    this.XpQ.addView(this.XpK);
    boolean bool = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VCV, false);
    if (!bool) {
      com.tencent.e.h.ZvG.bf(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(286735);
          com.tencent.mm.kernel.h.aHH();
          if (((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwr("@social.black.android") > 0)
          {
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCV, Boolean.TRUE);
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(289053);
                AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setVisible(true);
                AppMethodBeat.o(289053);
              }
            });
          }
          AppMethodBeat.o(286735);
        }
      });
    }
    Object localObject = this.XpK;
    if (bool)
    {
      bool = true;
      ((b)localObject).setVisible(bool);
      this.XpH = new b(getContext(), b.a.Xqa);
      this.XpQ.addView(this.XpH);
      this.XpH.setVisible(true);
      this.XpJ = new b(getContext(), b.a.Xqb);
      this.XpQ.addView(this.XpJ);
      this.XpJ.setVisible(true);
      localObject = this.Een;
      ContactCountView localContactCountView = new ContactCountView(getContext());
      this.XpL = localContactCountView;
      ((ListView)localObject).addFooterView(localContactCountView, null, false);
      if (com.tencent.mm.by.c.blP("brandservice"))
      {
        this.XpG = new BizContactEntranceView(getContext());
        this.XpQ.addView(this.XpG);
        this.XpG.setVisible(true);
      }
      localObject = new aa.b()
      {
        public final void GI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37620);
          if (AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this) == null)
          {
            AppMethodBeat.o(37620);
            return;
          }
          BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            localBizContactEntranceView.GJ(paramAnonymousBoolean);
            AppMethodBeat.o(37620);
            return;
          }
        }
      };
      this.XpM = new aa(getContext(), new aa.a()
      {
        public final void awK(int paramAnonymousInt)
        {
          AppMethodBeat.i(278212);
          if ((AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this) == null))
          {
            AppMethodBeat.o(278212);
            return;
          }
          if (paramAnonymousInt <= 0)
          {
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).setVisibility(8);
            AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).GJ(true);
            AppMethodBeat.o(278212);
            return;
          }
          AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).setVisibility(0);
          AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).GJ(false);
          AppMethodBeat.o(278212);
        }
      });
      this.XpM.setOnVisibilityChangeListener((aa.b)localObject);
      if (this.XpM.getOpenIMCount() > 0) {
        break label1109;
      }
      ((aa.b)localObject).GI(false);
      this.XpM.setVisibility(8);
    }
    for (;;)
    {
      this.XpQ.addView(this.XpM);
      this.XpN = new j(getContext(), new j.a()
      {
        public final void awJ(int paramAnonymousInt)
        {
          AppMethodBeat.i(37598);
          if (AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null)
          {
            AppMethodBeat.o(37598);
            return;
          }
          if (paramAnonymousInt <= 0)
          {
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
            AppMethodBeat.o(37598);
            return;
          }
          AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
          AppMethodBeat.o(37598);
        }
      });
      if (this.XpN.getEnterpriseFriendCount() <= 0) {
        this.XpN.setVisibility(8);
      }
      this.XpQ.addView(this.XpN);
      this.szq = new com.tencent.mm.ui.widget.b.a(getContext());
      this.Xpy.Xpd = new a.a() {};
      this.Een.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37599);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null) {}
          for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).XZK))
          {
            Log.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
            if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this)))) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37599);
            return;
          }
          if (paramAnonymousInt < AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37599);
            return;
          }
          paramAnonymousInt -= AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
          if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).XZK))
          {
            boolean bool1 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).TR(paramAnonymousInt);
            boolean bool2 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).axB(paramAnonymousInt);
            Log.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (bool2) {
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).bAW("");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(37599);
              return;
              if (bool1)
              {
                paramAnonymousView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).axA(paramAnonymousInt);
                paramAnonymousAdapterView = paramAnonymousView.SrH.Ufy;
                bh.beI();
                localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousAdapterView);
                if (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                  {
                    if (((as)localObject).hxX()) {
                      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    e.a(paramAnonymousView, paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.by.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                }
                else
                {
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.SrH.Ufy);
                  ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.mVD);
                  ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.TtX.Ufy);
                  ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.mVB);
                  ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramAnonymousView.mVH, paramAnonymousView.mVz, paramAnonymousView.mVA));
                  ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.mVy);
                  ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.TxG);
                  ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.TxF);
                  ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.TxJ);
                  ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.TxH);
                  ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.TxI);
                  ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.TxL.mVJ);
                  ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.TxL.mVL);
                  ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.TxL.mVK);
                  if (paramAnonymousView.TxM != null) {}
                  try
                  {
                    ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.TxM.toByteArray());
                    if ((paramAnonymousView.TxF & 0x8) > 0) {
                      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.by.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  }
                  catch (IOException localIOException)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                    }
                  }
                }
              }
              else
              {
                paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Qx(paramAnonymousInt);
                if (paramAnonymousAdapterView == null)
                {
                  Log.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(37599);
                  return;
                }
                paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                if (ab.QL(paramAnonymousAdapterView))
                {
                  paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                  paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                  paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
                  com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(37599);
                  return;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                  com.tencent.mm.by.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
            }
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).asW(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = AddressUI.AddressUIFragment.this;
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
              break label1090;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37599);
            return;
            label1090:
            if (((!as.bvK(paramAnonymousAdapterView)) && (!as.bvL(paramAnonymousAdapterView))) || (WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramAnonymousView.getContext()))) {
              if (ab.QL(paramAnonymousAdapterView))
              {
                Log.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                if (ab.Qj(paramAnonymousAdapterView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousAdapterView);
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.by.c.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210(paramAnonymousAdapterView, 10L);
                }
              }
            }
          }
        }
      });
      this.Een.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37600);
          Log.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.AddressUI", "on item long click, but match header view");
            AppMethodBeat.o(37600);
            return true;
          }
          if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).XZK))
          {
            AppMethodBeat.o(37600);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).asW(paramAnonymousInt - AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37600);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((ab.QL(paramAnonymousAdapterView)) || (ab.QM(paramAnonymousAdapterView)))
          {
            AppMethodBeat.o(37600);
            return true;
          }
          AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
          AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(37600);
          return true;
        }
      });
      this.Een.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37601);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37601);
            return false;
            AddressUI.AddressUIFragment.this.hideVKB();
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.Een.setOnScrollListener(this.iYA);
      this.Een.setDrawingCacheEnabled(false);
      this.WFZ = ((AlphabetScrollBar)findViewById(R.h.dqz));
      this.WFZ.setOnScrollBarTouchListener(this.XpR);
      bh.beI();
      com.tencent.mm.model.c.bbL().add(this.Xpy);
      if (this.XpN != null) {
        af.bjv().a(this.XpN, null);
      }
      AppMethodBeat.o(37630);
      return;
      bool = false;
      break;
      label1109:
      ((aa.b)localObject).GI(true);
    }
  }
  
  public final void hFc()
  {
    AppMethodBeat.i(37631);
    Log.v("MicroMsg.AddressUI", "address ui on resume");
    long l = System.currentTimeMillis();
    bh.beI();
    if (l - Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(340226, null), 0L) >= 180000L) {
      hUl();
    }
    if (this.XpP)
    {
      this.XpP = false;
      this.XpO = false;
      hUj();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37610);
          Log.i("MicroMsg.AddressUI", "rcontact db init select count: %d", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount()) });
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(214568);
              AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setAdapter(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this));
              Log.i("MicroMsg.AddressUI", "post to first init finish");
              View localView = AddressUI.AddressUIFragment.this.findViewById(R.h.loading_tips_area);
              if (localView != null)
              {
                localView.setVisibility(8);
                localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.AddressUIFragment.this.getContext(), R.a.fast_faded_out));
              }
              AppMethodBeat.o(214568);
            }
          });
          AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Hk(false);
          AppMethodBeat.o(37610);
        }
      });
      if (this.XpG != null) {
        this.XpG.gZg();
      }
      if (this.XpN != null)
      {
        if (this.XpN.getEnterpriseFriendCount() > 0) {
          break label382;
        }
        this.XpN.setVisibility(8);
      }
    }
    for (;;)
    {
      bh.beI();
      this.XpD = ((Boolean)com.tencent.mm.model.c.aHp().b(12296, Boolean.FALSE)).booleanValue();
      if (this.XpC == 2)
      {
        bh.beI();
        localObject = com.tencent.mm.model.c.bbL().RG(z.bcZ());
        if ((localObject != null) && ((!com.tencent.mm.contact.d.rk(((ax)localObject).field_type)) || (!Util.isNullOrNil(((ax)localObject).field_conRemark)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYShort))))
        {
          ((as)localObject).axk();
          ((as)localObject).Ir("");
          ((as)localObject).Iw("");
          ((as)localObject).Ix("");
          bh.beI();
          com.tencent.mm.model.c.bbL().c(z.bcZ(), (as)localObject);
        }
      }
      if (this.Xpz != null) {
        this.Xpz.onResume();
      }
      this.Xpy.VTe = false;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37612);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
          AppMethodBeat.o(37612);
        }
      });
      if (this.XpF != null)
      {
        this.XpF.setFrontGround(true);
        l.hUH();
      }
      Object localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.XpT);
      }
      AppMethodBeat.o(37631);
      return;
      if (!this.XpO) {
        break;
      }
      this.XpO = false;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37611);
          Process.setThreadPriority(10);
          AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this);
          AppMethodBeat.o(37611);
        }
      }, "AddressUI_updateUIData", 4);
      this.XpL.hUp();
      break;
      label382:
      this.XpN.setVisibility(0);
    }
  }
  
  public final void hFd() {}
  
  public final void hFe()
  {
    AppMethodBeat.i(37633);
    Log.i("MicroMsg.AddressUI", "AddressUI on Pause");
    bh.beI();
    com.tencent.mm.model.c.aHp().i(340226, Long.valueOf(System.currentTimeMillis()));
    bh.beI();
    com.tencent.mm.model.c.aHp().i(12296, Boolean.valueOf(this.XpD));
    if (this.Xpz != null) {
      this.Xpz.onPause();
    }
    this.Xpy.hUh();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37614);
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
        AppMethodBeat.o(37614);
      }
    });
    if (this.XpF != null) {
      this.XpF.setFrontGround(false);
    }
    LauncherUI localLauncherUI = (LauncherUI)getContext();
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aO(this.XpT);
    }
    AppMethodBeat.o(37633);
  }
  
  public final void hFf() {}
  
  public final void hFg()
  {
    AppMethodBeat.i(37634);
    Log.v("MicroMsg.AddressUI", "onDestory");
    if (this.WFZ != null) {
      this.WFZ.WpX = null;
    }
    bh.aGY().b(138, this);
    if (this.Xpy != null)
    {
      this.Xpy.Fk(true);
      this.Xpy.detach();
      this.Xpy.hFC();
    }
    if (this.Xpz != null)
    {
      this.Xpz.detach();
      this.Xpz.eKd();
    }
    if ((bh.aHB()) && (this.Xpy != null))
    {
      bh.beI();
      com.tencent.mm.model.c.bbL().remove(this.Xpy);
    }
    if ((bh.aHB()) && (this.XpN != null)) {
      af.bjv().a(this.XpN);
    }
    if (this.XpF != null)
    {
      this.XpF.detach();
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
    AppMethodBeat.o(37634);
  }
  
  public final void hFh()
  {
    AppMethodBeat.i(37638);
    Log.v("MicroMsg.AddressUI", "request to top");
    if (this.Een != null)
    {
      Object localObject1 = this.Een;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(37638);
  }
  
  public final void hFi()
  {
    AppMethodBeat.i(37636);
    if (this.Xpy != null)
    {
      a locala = this.Xpy;
      locala.Xpj.clear();
      locala.Xph.clear();
      locala.Xpi = false;
    }
    Log.i("MicroMsg.INIT", "KEVIN Address turnTobg");
    if (this.XpG != null) {
      this.XpG.destroyDrawingCache();
    }
    if (this.XpH != null) {
      this.XpH.destroyDrawingCache();
    }
    if (this.XpJ != null) {
      this.XpJ.destroyDrawingCache();
    }
    if (this.XpK != null) {
      this.XpK.destroyDrawingCache();
    }
    if (this.XpL != null) {
      this.XpL.destroyDrawingCache();
    }
    if (this.XpF != null) {
      this.XpF.destroyDrawingCache();
    }
    AppMethodBeat.o(37636);
  }
  
  public final void hFj()
  {
    AppMethodBeat.i(37637);
    Log.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    AppMethodBeat.o(37637);
  }
  
  public final void hUl()
  {
    AppMethodBeat.i(37640);
    if (this.Een != null) {
      this.Een.setSelection(0);
    }
    AppMethodBeat.o(37640);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(37629);
    Log.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 6) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(37629);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(37629);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37629);
      return;
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(291617);
    super.onConfigurationChanged(paramConfiguration);
    hGa();
    AppMethodBeat.o(291617);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37623);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.KZF);
    AppMethodBeat.o(37623);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37626);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().RG(this.XpB);
    if (localas == null)
    {
      Log.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.XpB);
      AppMethodBeat.o(37626);
      return;
    }
    if (z.bcZ().equals(localas.field_username))
    {
      AppMethodBeat.o(37626);
      return;
    }
    if (ab.Qj(this.XpB))
    {
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(paramView.getContext(), localas.ays()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.ent);
      AppMethodBeat.o(37626);
      return;
    }
    if ((ab.Qy(this.XpB)) || (ab.QO(this.XpB)))
    {
      AppMethodBeat.o(37626);
      return;
    }
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(paramView.getContext(), localas.ays()));
    if ((com.tencent.mm.contact.d.rk(localas.field_type)) && (localas.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.eyI);
    }
    AppMethodBeat.o(37626);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37635);
    super.onDestroy();
    EventCenter.instance.removeListener(this.KZF);
    AppMethodBeat.o(37635);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37627);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (!Util.isTopActivity(getContext()))
    {
      AppMethodBeat.o(37627);
      return;
    }
    if (ac.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(37627);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(37627);
      return;
    }
    AppMethodBeat.o(37627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment
 * JD-Core Version:    0.7.0.1
 */