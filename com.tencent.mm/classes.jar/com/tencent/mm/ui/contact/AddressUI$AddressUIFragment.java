package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
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
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.z.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI$AddressUIFragment
  extends AbstractTabChildActivity.AbStractTabFragment
  implements com.tencent.mm.ak.i
{
  private Animation Aod;
  private IListener ELE;
  private TextView PSJ;
  private TextView PSK;
  private a PSL;
  private com.tencent.mm.ui.voicesearch.b PSM;
  private String PSN;
  private String PSO;
  private int PSP;
  private AlphabetScrollBar PSQ;
  private LinearLayout PSR;
  private boolean PSS;
  private boolean PST;
  private l PSU;
  private BizContactEntranceView PSV;
  private b PSW;
  private b PSX;
  private b PSY;
  private b PSZ;
  private String PSf;
  private String PSg;
  private ContactCountView PTa;
  private y PTb;
  private j PTc;
  boolean PTd;
  private boolean PTe;
  private LinearLayout PTf;
  private VerticalScrollBar.a PTg;
  List<String> PTh;
  private Runnable PTi;
  private ProgressDialog gtM;
  com.tencent.mm.pluginsdk.ui.e gup;
  List<String> gzY;
  private final long jpE;
  private TextView kdj;
  private boolean khr;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g rJj;
  private Animation sSE;
  private ListView yCT;
  
  public AddressUI$AddressUIFragment()
  {
    AppMethodBeat.i(37621);
    this.gtM = null;
    this.PSO = "";
    this.PSR = null;
    this.PSS = false;
    this.khr = false;
    this.PST = false;
    this.PTe = true;
    this.jpE = 180000L;
    this.ELE = new AddressUI.AddressUIFragment.1(this);
    this.rJj = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(233982);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(233982);
          return;
        case 1: 
        case 2: 
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(233982);
          return;
        }
        AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
        AppMethodBeat.o(233982);
      }
    };
    this.PTg = new VerticalScrollBar.a()
    {
      public final void DP(String paramAnonymousString)
      {
        int i = 0;
        AppMethodBeat.i(233983);
        if (AddressUI.AddressUIFragment.this.getString(2131765029).equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(233983);
          return;
        }
        Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
        Log.v("MicroMsg.AddressAdapter", "getSections");
        localObject = ((a)localObject).PSl;
        if (localObject == null)
        {
          AppMethodBeat.o(233983);
          return;
        }
        if ("↑".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(233983);
          return;
        }
        if ("☆".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          AppMethodBeat.o(233983);
          return;
        }
        do
        {
          i += 1;
          if ((i >= localObject.length) || (localObject[i] == null)) {
            break;
          }
        } while (!localObject[i].equals(paramAnonymousString));
        i = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getPositionForSection(i);
        AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(i + AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
        AppMethodBeat.o(233983);
        return;
        AppMethodBeat.o(233983);
      }
    };
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new AddressUI.AddressUIFragment.11(this));
    this.gzY = new LinkedList();
    this.PTh = new LinkedList();
    this.PTi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37614);
        AddressUI.AddressUIFragment.s(AddressUI.AddressUIFragment.this);
        AppMethodBeat.o(37614);
      }
    };
    AppMethodBeat.o(37621);
  }
  
  private void gHs()
  {
    AppMethodBeat.i(233991);
    final View localView = getView().getRootView().findViewById(2131303053);
    int i = au.eu(getContext());
    int j = au.D(getContext(), -1);
    Runnable local12 = new Runnable()
    {
      int ibG = 0;
      
      public final void run()
      {
        AppMethodBeat.i(37608);
        if (AddressUI.AddressUIFragment.this.getView() == null)
        {
          AppMethodBeat.o(37608);
          return;
        }
        int i = au.eu(AddressUI.AddressUIFragment.this.getContext());
        int j = au.D(AddressUI.AddressUIFragment.this.getContext(), -1);
        if (j <= 0) {
          if (this.ibG < 2)
          {
            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
            AddressUI.AddressUIFragment.this.getView().post(this);
            this.ibG += 1;
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.ibG), Integer.valueOf(j), Integer.valueOf(i) });
          AppMethodBeat.o(37608);
          return;
          Log.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
          break;
          int k = AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this);
          if (k != AddressUI.AddressUIFragment.this.getView().getPaddingTop())
          {
            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(AddressUI.AddressUIFragment.this.getView().getPaddingTop()) });
            AddressUI.AddressUIFragment.this.getView().setPadding(0, k, 0, localView.getHeight());
          }
          else
          {
            Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
    };
    if (j <= 0)
    {
      getView().post(local12);
      AppMethodBeat.o(233991);
      return;
    }
    int k = getTopHeight();
    getView().setPadding(0, k, 0, localView.getHeight());
    Log.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    getView().postDelayed(local12, 100L);
    AppMethodBeat.o(233991);
  }
  
  private void gUq()
  {
    AppMethodBeat.i(37628);
    this.gzY = new LinkedList();
    this.PTh = new LinkedList();
    com.tencent.mm.br.c.gsX();
    this.gzY.add("tmessage");
    this.PTh.addAll(this.gzY);
    if (!this.gzY.contains("officialaccounts")) {
      this.gzY.add("officialaccounts");
    }
    this.gzY.add("helper_entry");
    if (this.PSL != null) {
      this.PSL.jB(this.gzY);
    }
    if (this.PSM != null) {
      this.PSM.jB(this.PTh);
    }
    AppMethodBeat.o(37628);
  }
  
  private void gUr()
  {
    try
    {
      AppMethodBeat.i(37632);
      long l = System.currentTimeMillis();
      gUq();
      Log.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.PSL != null)
      {
        Log.v("MicroMsg.AddressUI", "post to do refresh");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37609);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).gUp();
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) {
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).reset();
            }
            AppMethodBeat.o(37609);
          }
        });
      }
      if (this.PSM != null) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37610);
            Log.v("MicroMsg.AddressUI", "post search adapter to do refresh");
            AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).onNotifyChange(null, null);
            AppMethodBeat.o(37610);
          }
        });
      }
      Log.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(37632);
      return;
    }
    finally {}
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(37625);
    int j = au.eu(getContext());
    int i = au.D(getContext(), -1);
    View localView = getView().getRootView().findViewById(2131296366);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label178;
        }
      }
      label173:
      label178:
      for (boolean bool2 = localSharedPreferences.getBoolean("Main_need_read_top_margin", false);; bool2 = false)
      {
        if (bool2)
        {
          int k = localSharedPreferences.getInt("Main_top_marign", -1);
          if (k >= 0)
          {
            AppMethodBeat.o(37625);
            return j + k;
          }
        }
        if (bool1) {
          if (localView == null) {
            break label173;
          }
        }
        for (i = localView.getTop();; i = 0)
        {
          Log.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
          AppMethodBeat.o(37625);
          return i + j;
        }
      }
    }
  }
  
  public final void Cl(boolean paramBoolean)
  {
    AppMethodBeat.i(37624);
    if (this.PSQ != null)
    {
      if (this.sSE == null)
      {
        this.sSE = AnimationUtils.loadAnimation(getContext(), 2130772049);
        this.sSE.setDuration(200L);
      }
      if (this.Aod == null)
      {
        this.Aod = AnimationUtils.loadAnimation(getContext(), 2130772049);
        this.Aod.setDuration(200L);
      }
      if (paramBoolean)
      {
        if (this.PSQ.getVisibility() != 0)
        {
          this.PSQ.setVisibility(0);
          this.PSQ.startAnimation(this.sSE);
          AppMethodBeat.o(37624);
        }
      }
      else if (4 != this.PSQ.getVisibility())
      {
        this.PSQ.setVisibility(8);
        this.PSQ.startAnimation(this.Aod);
      }
    }
    AppMethodBeat.o(37624);
  }
  
  public final void gGA()
  {
    AppMethodBeat.i(37638);
    Log.v("MicroMsg.AddressUI", "request to top");
    if (this.yCT != null)
    {
      Object localObject1 = this.yCT;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(37638);
  }
  
  public final void gGB()
  {
    AppMethodBeat.i(37636);
    if (this.PSL != null)
    {
      a locala = this.PSL;
      locala.PSw.clear();
      locala.PSu.clear();
      locala.PSv = false;
    }
    Log.i("MicroMsg.INIT", "KEVIN Address turnTobg");
    if (this.PSV != null) {
      this.PSV.destroyDrawingCache();
    }
    if (this.PSW != null) {
      this.PSW.destroyDrawingCache();
    }
    if (this.PSY != null) {
      this.PSY.destroyDrawingCache();
    }
    if (this.PSZ != null) {
      this.PSZ.destroyDrawingCache();
    }
    if (this.PTa != null) {
      this.PTa.destroyDrawingCache();
    }
    if (this.PSU != null) {
      this.PSU.destroyDrawingCache();
    }
    AppMethodBeat.o(37636);
  }
  
  public final void gGC()
  {
    AppMethodBeat.i(37637);
    Log.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    AppMethodBeat.o(37637);
  }
  
  public final void gGu()
  {
    AppMethodBeat.i(37630);
    Log.v("MicroMsg.AddressUI", "address ui on create");
    Log.v("MicroMsg.AddressUI", "on address ui create");
    this.PSS = false;
    this.khr = false;
    this.PST = false;
    this.PSf = null;
    this.PSg = null;
    this.PSN = null;
    bg.azz().a(138, this);
    this.PSf = "@all.contact.without.chatroom.without.openim";
    this.PSg = getStringExtra("Contact_GroupFilter_Str");
    this.PSN = getString(2131761515);
    this.PSP = getIntExtra("List_Type", 2);
    gHs();
    Log.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
    if (this.yCT != null)
    {
      if (this.PSU != null) {
        this.yCT.removeHeaderView(this.PSU);
      }
      if (this.PSV != null) {
        this.yCT.removeHeaderView(this.PSV);
      }
      if (this.PSW != null) {
        this.yCT.removeHeaderView(this.PSW);
      }
      if (this.PSZ != null) {
        this.yCT.removeHeaderView(this.PSZ);
      }
      if (this.PSY != null) {
        this.yCT.removeHeaderView(this.PSY);
      }
    }
    this.yCT = ((ListView)findViewById(2131296545));
    this.yCT.setScrollingCacheEnabled(false);
    this.PSJ = ((TextView)findViewById(2131300081));
    this.PSJ.setText(2131755226);
    this.kdj = ((TextView)findViewById(2131300114));
    this.kdj.setText(2131755228);
    this.PSK = ((TextView)findViewById(2131300135));
    this.PSK.setOnClickListener(new AddressUI.AddressUIFragment.20(this));
    this.PSL = new a(getContext(), this.PSf, this.PSg, this.PSP);
    this.yCT.setAdapter(null);
    this.PSL.a(new f.a()
    {
      public final void bnE()
      {
        AppMethodBeat.i(37616);
        AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
        AddressUI.AddressUIFragment.c(localAddressUIFragment);
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).gUn();
        AppMethodBeat.o(37616);
      }
      
      public final void gHg() {}
    });
    this.PSL.PSs = true;
    this.PSL.setFragment(this);
    this.PSL.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dr(View paramAnonymousView)
      {
        AppMethodBeat.i(37617);
        Object localObject = paramAnonymousView;
        try
        {
          for (;;)
          {
            View localView = (View)((View)localObject).getParent();
            if (localView == null) {
              break;
            }
            boolean bool = localView.equals(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this));
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
          AppMethodBeat.o(37617);
          return -1;
        }
        AppMethodBeat.o(37617);
        return -1;
        label70:
        int i = AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37617);
        return i;
      }
    });
    this.PSL.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37618);
        AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37618);
      }
    });
    this.PSL.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37619);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.AddressUI", "onItemDel object null");
          AppMethodBeat.o(37619);
          return;
        }
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
        AppMethodBeat.o(37619);
      }
    });
    this.PSM = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.PSM.CR(true);
    this.PTf = new LinearLayout(getContext());
    this.PTf.setOrientation(1);
    this.yCT.addHeaderView(this.PTf);
    this.PSX = new b(getContext(), b.a.PTr);
    this.PTf.addView(this.PSX);
    bg.aVF();
    ((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NVr, Boolean.FALSE)).booleanValue();
    this.PSX.setVisible(false);
    this.PSU = new l(getContext());
    this.PTf.addView(this.PSU);
    this.PSZ = new b(getContext(), b.a.PTs);
    this.PTf.addView(this.PSZ);
    boolean bool = g.aAh().azQ().getBoolean(ar.a.OnH, false);
    if (!bool) {
      com.tencent.f.h.RTc.aY(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233989);
          g.aAi();
          if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjS("@social.black.android") > 0)
          {
            g.aAh().azQ().set(ar.a.OnH, Boolean.TRUE);
            AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233988);
                AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).setVisible(true);
                AppMethodBeat.o(233988);
              }
            });
          }
          AppMethodBeat.o(233989);
        }
      });
    }
    Object localObject = this.PSZ;
    if (bool)
    {
      bool = true;
      ((b)localObject).setVisible(bool);
      this.PSW = new b(getContext(), b.a.PTp);
      this.PTf.addView(this.PSW);
      this.PSW.setVisible(true);
      this.PSY = new b(getContext(), b.a.PTq);
      this.PTf.addView(this.PSY);
      this.PSY.setVisible(true);
      localObject = this.yCT;
      ContactCountView localContactCountView = new ContactCountView(getContext());
      this.PTa = localContactCountView;
      ((ListView)localObject).addFooterView(localContactCountView, null, false);
      if (com.tencent.mm.br.c.aZU("brandservice"))
      {
        this.PSV = new BizContactEntranceView(getContext());
        this.PTf.addView(this.PSV);
        this.PSV.setVisible(true);
      }
      localObject = new y.b()
      {
        public final void Cm(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(233990);
          if (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null)
          {
            AppMethodBeat.o(233990);
            return;
          }
          BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this);
          if (!paramAnonymousBoolean) {}
          for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
          {
            localBizContactEntranceView.Cn(paramAnonymousBoolean);
            AppMethodBeat.o(233990);
            return;
          }
        }
      };
      this.PTb = new y(getContext(), new y.a()
      {
        public final void anE(int paramAnonymousInt)
        {
          AppMethodBeat.i(233976);
          if ((AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null))
          {
            AppMethodBeat.o(233976);
            return;
          }
          if (paramAnonymousInt <= 0)
          {
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).Cn(true);
            AppMethodBeat.o(233976);
            return;
          }
          AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
          AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).Cn(false);
          AppMethodBeat.o(233976);
        }
      });
      this.PTb.setOnVisibilityChangeListener((y.b)localObject);
      if (this.PTb.getOpenIMCount() > 0) {
        break label1109;
      }
      ((y.b)localObject).Cm(false);
      this.PTb.setVisibility(8);
    }
    for (;;)
    {
      this.PTf.addView(this.PTb);
      this.PTc = new j(getContext(), new j.a()
      {
        public final void anF(int paramAnonymousInt)
        {
          AppMethodBeat.i(233977);
          if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null)
          {
            AppMethodBeat.o(233977);
            return;
          }
          if (paramAnonymousInt <= 0)
          {
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(8);
            AppMethodBeat.o(233977);
            return;
          }
          AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(0);
          AppMethodBeat.o(233977);
        }
      });
      if (this.PTc.getEnterpriseFriendCount() <= 0) {
        this.PTc.setVisibility(8);
      }
      this.PTf.addView(this.PTc);
      this.pqr = new com.tencent.mm.ui.widget.b.a(getContext());
      this.PSL.PSq = new a.a() {};
      this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(233978);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          if (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) == null) {}
          for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).QBl))
          {
            Log.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
            if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this)))) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(233978);
            return;
          }
          if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(233978);
            return;
          }
          paramAnonymousInt -= AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
          if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).QBl))
          {
            boolean bool1 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Ox(paramAnonymousInt);
            boolean bool2 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aot(paramAnonymousInt);
            Log.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (bool2) {
              AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).boh("");
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(233978);
              return;
              if (bool1)
              {
                paramAnonymousView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aos(paramAnonymousInt);
                paramAnonymousAdapterView = paramAnonymousView.Lqk.MTo;
                bg.aVF();
                localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousAdapterView);
                if (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                  {
                    if (((as)localObject).gBM()) {
                      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    e.a(paramAnonymousView, paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.br.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                }
                else
                {
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.Lqk.MTo);
                  ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ked);
                  ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Mjj.MTo);
                  ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.keb);
                  ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramAnonymousView.keh, paramAnonymousView.kdZ, paramAnonymousView.kea));
                  ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.kdY);
                  ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.MmL);
                  ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.MmK);
                  ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.MmO);
                  ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.MmM);
                  ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.MmN);
                  ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.MmQ.kej);
                  ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.MmQ.kel);
                  ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.MmQ.kek);
                  if (paramAnonymousView.MmR != null) {}
                  try
                  {
                    ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.MmR.toByteArray());
                    if ((paramAnonymousView.MmK & 0x8) > 0) {
                      com.tencent.mm.plugin.report.service.h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.br.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
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
                paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Ln(paramAnonymousInt);
                if (paramAnonymousAdapterView == null)
                {
                  Log.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(233978);
                  return;
                }
                paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                if (ab.Js(paramAnonymousAdapterView))
                {
                  paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                  paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                  paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                  AppMethodBeat.o(233978);
                  return;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                  com.tencent.mm.br.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
            }
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).akz(paramAnonymousInt);
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
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(233978);
            return;
            label1090:
            if (((!as.bjp(paramAnonymousAdapterView)) && (!as.bjq(paramAnonymousAdapterView))) || (WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramAnonymousView.getContext()))) {
              if (ab.Js(paramAnonymousAdapterView))
              {
                Log.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                if (ab.IQ(paramAnonymousAdapterView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousAdapterView);
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  ((com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(paramAnonymousAdapterView, 10L);
                }
              }
            }
          }
        }
      });
      this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(233979);
          Log.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.AddressUI", "on item long click, but match header view");
            AppMethodBeat.o(233979);
            return true;
          }
          if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).QBl))
          {
            AppMethodBeat.o(233979);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).akz(paramAnonymousInt - AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(233979);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((ab.Js(paramAnonymousAdapterView)) || (ab.Jt(paramAnonymousAdapterView)))
          {
            AppMethodBeat.o(233979);
            return true;
          }
          AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
          AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(233979);
          return true;
        }
      });
      this.yCT.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(233980);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(233980);
            return false;
            AddressUI.AddressUIFragment.this.hideVKB();
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.yCT.setOnScrollListener(this.gup);
      this.yCT.setDrawingCacheEnabled(false);
      this.PSQ = ((AlphabetScrollBar)findViewById(2131296563));
      this.PSQ.setOnScrollBarTouchListener(this.PTg);
      bg.aVF();
      com.tencent.mm.model.c.aSN().add(this.PSL);
      if (this.PTc != null) {
        ag.bah().a(this.PTc, null);
      }
      AppMethodBeat.o(37630);
      return;
      bool = false;
      break;
      label1109:
      ((y.b)localObject).Cm(true);
    }
  }
  
  public final void gGv()
  {
    AppMethodBeat.i(37631);
    Log.v("MicroMsg.AddressUI", "address ui on resume");
    long l = System.currentTimeMillis();
    bg.aVF();
    if (l - Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(340226, null), 0L) >= 180000L) {
      gUs();
    }
    Object localObject;
    if (this.PTe)
    {
      this.PTe = false;
      this.PTd = false;
      gUq();
      com.tencent.f.h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37611);
          Log.i("MicroMsg.AddressUI", "rcontact db init select count: %d", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount()) });
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233986);
              AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setAdapter(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this));
              Log.i("MicroMsg.AddressUI", "post to first init finish");
              View localView = AddressUI.AddressUIFragment.this.findViewById(2131303716);
              if (localView != null)
              {
                localView.setVisibility(8);
                localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.AddressUIFragment.this.getContext(), 2130772060));
              }
              AppMethodBeat.o(233986);
            }
          });
          AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).CQ(false);
          AppMethodBeat.o(37611);
        }
      });
      if (this.PSV != null)
      {
        localObject = this.PSV;
        ((BizContactEntranceView)localObject).gUu();
        ((BizContactEntranceView)localObject).setVisible(true);
      }
      if (this.PTc != null)
      {
        if (this.PTc.getEnterpriseFriendCount() > 0) {
          break label389;
        }
        this.PTc.setVisibility(8);
      }
    }
    for (;;)
    {
      bg.aVF();
      this.PSS = ((Boolean)com.tencent.mm.model.c.azQ().get(12296, Boolean.FALSE)).booleanValue();
      if (this.PSP == 2)
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSN().Kn(z.aTY());
        if ((localObject != null) && ((!com.tencent.mm.contact.c.oR(((ax)localObject).field_type)) || (!Util.isNullOrNil(((ax)localObject).field_conRemark)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((ax)localObject).field_conRemarkPYShort))))
        {
          ((as)localObject).aqQ();
          ((as)localObject).BD("");
          ((as)localObject).BI("");
          ((as)localObject).BJ("");
          bg.aVF();
          com.tencent.mm.model.c.aSN().c(z.aTY(), (as)localObject);
        }
      }
      if (this.PSM != null) {
        this.PSM.onResume();
      }
      this.PSL.OzQ = false;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37613);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
          AppMethodBeat.o(37613);
        }
      });
      if (this.PSU != null)
      {
        this.PSU.setFrontGround(true);
        l.gUK();
      }
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.PTi);
      }
      AppMethodBeat.o(37631);
      return;
      if (!this.PTd) {
        break;
      }
      this.PTd = false;
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37612);
          Process.setThreadPriority(10);
          AddressUI.AddressUIFragment.r(AddressUI.AddressUIFragment.this);
          AppMethodBeat.o(37612);
        }
      }, "AddressUI_updateUIData", 4);
      this.PTa.gUw();
      break;
      label389:
      this.PTc.setVisibility(0);
    }
  }
  
  public final void gGw() {}
  
  public final void gGx()
  {
    AppMethodBeat.i(37633);
    Log.i("MicroMsg.AddressUI", "AddressUI on Pause");
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(340226, Long.valueOf(System.currentTimeMillis()));
    bg.aVF();
    com.tencent.mm.model.c.azQ().set(12296, Boolean.valueOf(this.PSS));
    if (this.PSM != null) {
      this.PSM.onPause();
    }
    this.PSL.gUo();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(233987);
        AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
        AppMethodBeat.o(233987);
      }
    });
    if (this.PSU != null) {
      this.PSU.setFrontGround(false);
    }
    LauncherUI localLauncherUI = (LauncherUI)getContext();
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().aI(this.PTi);
    }
    AppMethodBeat.o(37633);
  }
  
  public final void gGy() {}
  
  public final void gGz()
  {
    AppMethodBeat.i(37634);
    Log.v("MicroMsg.AddressUI", "onDestory");
    if (this.PSQ != null) {
      this.PSQ.OWL = null;
    }
    bg.azz().b(138, this);
    if (this.PSL != null)
    {
      this.PSL.AV(true);
      this.PSL.detach();
      this.PSL.gGV();
    }
    if (this.PSM != null)
    {
      this.PSM.detach();
      this.PSM.ebf();
    }
    if ((bg.aAc()) && (this.PSL != null))
    {
      bg.aVF();
      com.tencent.mm.model.c.aSN().remove(this.PSL);
    }
    if ((bg.aAc()) && (this.PTc != null)) {
      ag.bah().a(this.PTc);
    }
    if (this.PSU != null)
    {
      l locall = this.PSU;
      if (bg.aAc()) {
        d.bgN().remove(locall.PVF);
      }
      this.PSU = null;
    }
    if (this.PSV != null) {
      this.PSV = null;
    }
    if (this.PSW != null) {
      this.PSW = null;
    }
    if (this.PSZ != null) {
      this.PSZ = null;
    }
    if (this.PSY != null) {
      this.PSY = null;
    }
    AppMethodBeat.o(37634);
  }
  
  public final void gHE()
  {
    AppMethodBeat.i(37639);
    if (this.PSU != null) {
      l.gUK();
    }
    AppMethodBeat.o(37639);
  }
  
  public final void gHF() {}
  
  public final void gUs()
  {
    AppMethodBeat.i(37640);
    if (this.yCT != null) {
      this.yCT.setSelection(0);
    }
    AppMethodBeat.o(37640);
  }
  
  public int getLayoutId()
  {
    return 2131492980;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(37622);
    com.tencent.mm.kiss.a.b.aBh();
    View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131492980);
    AppMethodBeat.o(37622);
    return localView;
  }
  
  public boolean noActionBar()
  {
    return true;
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
    AppMethodBeat.i(233992);
    super.onConfigurationChanged(paramConfiguration);
    gHs();
    AppMethodBeat.o(233992);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37623);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.ELE);
    AppMethodBeat.o(37623);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37626);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(this.PSO);
    if (localas == null)
    {
      Log.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
      AppMethodBeat.o(37626);
      return;
    }
    if (z.aTY().equals(localas.field_username))
    {
      AppMethodBeat.o(37626);
      return;
    }
    if (ab.IQ(this.PSO))
    {
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(paramView.getContext(), localas.arJ()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755223);
      AppMethodBeat.o(37626);
      return;
    }
    if ((ab.Jf(this.PSO)) || (ab.Jv(this.PSO)))
    {
      AppMethodBeat.o(37626);
      return;
    }
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.l.c(paramView.getContext(), localas.arJ()));
    if ((com.tencent.mm.contact.c.oR(localas.field_type)) && (localas.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757968);
    }
    AppMethodBeat.o(37626);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37635);
    super.onDestroy();
    EventCenter.instance.removeListener(this.ELE);
    AppMethodBeat.o(37635);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37627);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (!Util.isTopActivity(getContext()))
    {
      AppMethodBeat.o(37627);
      return;
    }
    if (z.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment
 * JD-Core Version:    0.7.0.1
 */