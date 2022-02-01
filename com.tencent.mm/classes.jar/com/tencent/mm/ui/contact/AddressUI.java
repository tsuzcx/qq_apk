package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.x.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment GSA;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.GSA = new AddressUIFragment();
      this.GSA.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.GSA).commit();
    }
    AppMethodBeat.o(37647);
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class AddressUIFragment
    extends AbstractTabChildActivity.AbStractTabFragment
    implements com.tencent.mm.al.g
  {
    private String GRX;
    private String GRY;
    private TextView GSB;
    private TextView GSC;
    private a GSD;
    private com.tencent.mm.ui.voicesearch.b GSE;
    private String GSF;
    private String GSG;
    private int GSH;
    private AlphabetScrollBar GSI;
    private LinearLayout GSJ;
    private boolean GSK;
    private boolean GSL;
    private l GSM;
    private BizContactEntranceView GSN;
    private b GSO;
    private b GSP;
    private b GSQ;
    private b GSR;
    private ContactCountView GSS;
    private y GST;
    private j GSU;
    boolean GSV;
    private boolean GSW;
    private LinearLayout GSX;
    private Animation GSY;
    private VerticalScrollBar.a GSZ;
    List<String> GTa;
    private Runnable GTb;
    private ProgressDialog fpP;
    com.tencent.mm.pluginsdk.ui.d fqs;
    List<String> fvP;
    private final long hxB;
    private TextView iiX;
    private boolean inh;
    private int mUE;
    private int mUF;
    private com.tencent.mm.ui.widget.b.a mVN;
    private Animation pQG;
    private n.d peM;
    private ListView sMV;
    private com.tencent.mm.sdk.b.c xGw;
    
    public AddressUIFragment()
    {
      AppMethodBeat.i(37621);
      this.fpP = null;
      this.GSG = "";
      this.GSJ = null;
      this.GSK = false;
      this.inh = false;
      this.GSL = false;
      this.GSW = true;
      this.hxB = 180000L;
      this.xGw = new com.tencent.mm.sdk.b.c() {};
      this.peM = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(191654);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(191654);
            return;
          case 1: 
          case 2: 
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(191654);
            return;
          }
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(191654);
        }
      };
      this.GSZ = new VerticalScrollBar.a()
      {
        public final void pb(String paramAnonymousString)
        {
          int i = 0;
          AppMethodBeat.i(191655);
          if (AddressUI.AddressUIFragment.this.getString(2131762893).equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(191655);
            return;
          }
          Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
          ad.v("MicroMsg.AddressAdapter", "getSections");
          localObject = ((a)localObject).GSd;
          if (localObject == null)
          {
            AppMethodBeat.o(191655);
            return;
          }
          if ("↑".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(191655);
            return;
          }
          if ("☆".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            AppMethodBeat.o(191655);
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
          AppMethodBeat.o(191655);
          return;
          AppMethodBeat.o(191655);
        }
      };
      this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(191656);
          if (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(191656);
            return;
          }
          if (!AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this)) {
            AddressUI.AddressUIFragment.p(AddressUI.AddressUIFragment.this);
          }
          AppMethodBeat.o(191656);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(191657);
          if (paramAnonymousInt == 2) {
            com.tencent.mm.ck.d.eOM().fS(AddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(191657);
        }
      });
      this.fvP = new LinkedList();
      this.GTa = new LinkedList();
      this.GTb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37614);
          AddressUI.AddressUIFragment.r(AddressUI.AddressUIFragment.this);
          AppMethodBeat.o(37614);
        }
      };
      AppMethodBeat.o(37621);
    }
    
    private void ePQ()
    {
      AppMethodBeat.i(191662);
      final View localView = getView().getRootView().findViewById(2131301338);
      int i = ap.dL(getContext());
      int j = ap.M(getContext(), -1);
      Runnable local12 = new Runnable()
      {
        int gll = 0;
        
        public final void run()
        {
          AppMethodBeat.i(37608);
          if (AddressUI.AddressUIFragment.this.getView() == null)
          {
            AppMethodBeat.o(37608);
            return;
          }
          int i = ap.dL(AddressUI.AddressUIFragment.this.getContext());
          int j = ap.M(AddressUI.AddressUIFragment.this.getContext(), -1);
          if (j <= 0) {
            if (this.gll < 2)
            {
              ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
              AddressUI.AddressUIFragment.this.getView().post(this);
              this.gll += 1;
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.gll), Integer.valueOf(j), Integer.valueOf(i) });
            AppMethodBeat.o(37608);
            return;
            ad.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
            break;
            int k = AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this);
            if (k != AddressUI.AddressUIFragment.this.getView().getPaddingTop())
            {
              ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(AddressUI.AddressUIFragment.this.getView().getPaddingTop()) });
              AddressUI.AddressUIFragment.this.getView().setPadding(0, k, 0, localView.getHeight());
            }
            else
            {
              ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
        }
      };
      if (j <= 0)
      {
        getView().post(local12);
        AppMethodBeat.o(191662);
        return;
      }
      int k = getTopHeight();
      getView().setPadding(0, k, 0, localView.getHeight());
      ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed(local12, 100L);
      AppMethodBeat.o(191662);
    }
    
    private void fba()
    {
      AppMethodBeat.i(37628);
      this.fvP = new LinkedList();
      this.GTa = new LinkedList();
      com.tencent.mm.bs.d.eBj();
      this.fvP.add("tmessage");
      this.GTa.addAll(this.fvP);
      if (!this.fvP.contains("officialaccounts")) {
        this.fvP.add("officialaccounts");
      }
      this.fvP.add("helper_entry");
      if (this.GSD != null) {
        this.GSD.hP(this.fvP);
      }
      if (this.GSE != null) {
        this.GSE.hP(this.GTa);
      }
      AppMethodBeat.o(37628);
    }
    
    private void fbb()
    {
      try
      {
        AppMethodBeat.i(37632);
        long l = System.currentTimeMillis();
        fba();
        ad.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.GSD != null)
        {
          ad.v("MicroMsg.AddressUI", "post to do refresh");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37609);
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).faZ();
              if (AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) != null) {
                AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).reset();
              }
              AppMethodBeat.o(37609);
            }
          });
        }
        if (this.GSE != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37610);
              ad.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37610);
            }
          });
        }
        ad.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(37632);
        return;
      }
      finally {}
    }
    
    private int getTopHeight()
    {
      AppMethodBeat.i(37625);
      int j = ap.dL(getContext());
      int i = ap.M(getContext(), -1);
      View localView = getView().getRootView().findViewById(2131296345);
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
      for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
      {
        SharedPreferences localSharedPreferences;
        if (!bool1)
        {
          localSharedPreferences = aj.eFE();
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
            ad.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            AppMethodBeat.o(37625);
            return i + j;
          }
        }
      }
    }
    
    public final void eOU()
    {
      AppMethodBeat.i(37630);
      ad.v("MicroMsg.AddressUI", "address ui on create");
      ad.v("MicroMsg.AddressUI", "on address ui create");
      this.GSK = false;
      this.inh = false;
      this.GSL = false;
      this.GRX = null;
      this.GRY = null;
      this.GSF = null;
      com.tencent.mm.model.az.aeS().a(138, this);
      this.GRX = "@all.contact.without.chatroom.without.openim";
      this.GRY = getStringExtra("Contact_GroupFilter_Str");
      this.GSF = getString(2131760134);
      this.GSH = getIntExtra("List_Type", 2);
      ePQ();
      ad.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.sMV != null)
      {
        if (this.GSM != null) {
          this.sMV.removeHeaderView(this.GSM);
        }
        if (this.GSN != null) {
          this.sMV.removeHeaderView(this.GSN);
        }
        if (this.GSO != null) {
          this.sMV.removeHeaderView(this.GSO);
        }
        if (this.GSR != null) {
          this.sMV.removeHeaderView(this.GSR);
        }
        if (this.GSQ != null) {
          this.sMV.removeHeaderView(this.GSQ);
        }
      }
      this.sMV = ((ListView)findViewById(2131296471));
      this.sMV.setScrollingCacheEnabled(false);
      this.GSB = ((TextView)findViewById(2131299460));
      this.GSB.setText(2131755193);
      this.iiX = ((TextView)findViewById(2131299481));
      this.iiX.setText(2131755195);
      this.GSC = ((TextView)findViewById(2131299499));
      this.GSC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37615);
          AppMethodBeat.o(37615);
        }
      });
      this.GSD = new a(getContext(), this.GRX, this.GRY, this.GSH);
      this.sMV.setAdapter(null);
      this.GSD.a(new f.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(37616);
          AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
          AddressUI.AddressUIFragment.c(localAddressUIFragment);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).faX();
          AppMethodBeat.o(37616);
        }
        
        public final void ePF() {}
      });
      this.GSD.GSk = true;
      this.GSD.setFragment(this);
      this.GSD.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dw(View paramAnonymousView)
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
      this.GSD.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37618);
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37618);
        }
      });
      this.GSD.a(new MMSlideDelView.f()
      {
        public final void cO(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37619);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.AddressUI", "onItemDel object null");
            AppMethodBeat.o(37619);
            return;
          }
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37619);
        }
      });
      this.GSE = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.GSE.wN(true);
      this.GSX = new LinearLayout(getContext());
      this.GSX.setOrientation(1);
      this.sMV.addHeaderView(this.GSX);
      this.GSP = new b(getContext(), b.a.GTj);
      this.GSX.addView(this.GSP);
      com.tencent.mm.model.az.arV();
      ((Boolean)com.tencent.mm.model.c.afk().get(ae.a.FiL, Boolean.FALSE)).booleanValue();
      this.GSP.setVisible(false);
      this.GSM = new l(getContext());
      this.GSX.addView(this.GSM);
      this.GSR = new b(getContext(), b.a.GTk);
      this.GSX.addView(this.GSR);
      boolean bool = com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FxD, false);
      if (!bool) {
        com.tencent.e.h.Iye.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191660);
            com.tencent.mm.kernel.g.afC();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIh("@social.black.android") > 0)
            {
              com.tencent.mm.kernel.g.afB().afk().set(ae.a.FxD, Boolean.TRUE);
              AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(191659);
                  AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).setVisible(true);
                  AppMethodBeat.o(191659);
                }
              });
            }
            AppMethodBeat.o(191660);
          }
        });
      }
      Object localObject = this.GSR;
      if (bool)
      {
        bool = true;
        ((b)localObject).setVisible(bool);
        this.GSO = new b(getContext(), b.a.GTh);
        this.GSX.addView(this.GSO);
        this.GSO.setVisible(true);
        this.GSQ = new b(getContext(), b.a.GTi);
        this.GSX.addView(this.GSQ);
        this.GSQ.setVisible(true);
        localObject = this.sMV;
        ContactCountView localContactCountView = new ContactCountView(getContext());
        this.GSS = localContactCountView;
        ((ListView)localObject).addFooterView(localContactCountView, null, false);
        if (com.tencent.mm.bs.d.axB("brandservice"))
        {
          this.GSN = new BizContactEntranceView(getContext());
          this.GSX.addView(this.GSN);
          this.GSN.setVisible(true);
        }
        localObject = new y.b()
        {
          public final void ws(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(191661);
            if (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(191661);
              return;
            }
            BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this);
            if (!paramAnonymousBoolean) {}
            for (int i = 1; (localBizContactEntranceView.GTO == null) || (localBizContactEntranceView.GTQ == null); i = 0)
            {
              AppMethodBeat.o(191661);
              return;
            }
            if (i != 0)
            {
              i = localBizContactEntranceView.GTO.getPaddingLeft();
              localBizContactEntranceView.GTO.setBackground(ao.aC(localBizContactEntranceView.mContext, 2130969245));
              localBizContactEntranceView.GTO.setPadding(i, 0, 0, 0);
              localBizContactEntranceView.GTQ.setBackground(null);
              AppMethodBeat.o(191661);
              return;
            }
            localBizContactEntranceView.GTO.setBackground(null);
            localBizContactEntranceView.GTQ.setBackground(ao.aC(localBizContactEntranceView.mContext, 2130969245));
            AppMethodBeat.o(191661);
          }
        };
        this.GST = new y(getContext(), new y.a() {});
        this.GST.setOnVisibilityChangeListener((y.b)localObject);
        if (this.GST.getOpenIMCount() > 0) {
          break label1109;
        }
        ((y.b)localObject).ws(false);
        this.GST.setVisibility(8);
      }
      for (;;)
      {
        this.GSX.addView(this.GST);
        this.GSU = new j(getContext(), new j.a()
        {
          public final void ZA(int paramAnonymousInt)
          {
            AppMethodBeat.i(191649);
            if (AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(191649);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
              AppMethodBeat.o(191649);
              return;
            }
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
            AppMethodBeat.o(191649);
          }
        });
        if (this.GSU.getEnterpriseFriendCount() <= 0) {
          this.GSU.setVisibility(8);
        }
        this.GSX.addView(this.GSU);
        this.mVN = new com.tencent.mm.ui.widget.b.a(getContext());
        this.GSD.GSi = new a.a() {};
        this.sMV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(191650);
            paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null) {}
            for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Hyd))
            {
              ad.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
              if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this)))) {
                break;
              }
              AppMethodBeat.o(191650);
              return;
            }
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              AppMethodBeat.o(191650);
              return;
            }
            paramAnonymousInt -= AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
            Object localObject;
            if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Hyd))
            {
              boolean bool1 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).EJ(paramAnonymousInt);
              boolean bool2 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aan(paramAnonymousInt);
              ad.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
              if (bool2)
              {
                AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aLZ("");
                AppMethodBeat.o(191650);
                return;
              }
              if (bool1)
              {
                paramAnonymousView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aal(paramAnonymousInt);
                paramAnonymousAdapterView = paramAnonymousView.Dby.Ehn;
                com.tencent.mm.model.az.arV();
                localObject = com.tencent.mm.model.c.apM().aHY(paramAnonymousAdapterView);
                if (com.tencent.mm.n.b.ls(((au)localObject).field_type))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                  {
                    if (((com.tencent.mm.storage.af)localObject).eKB()) {
                      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    e.a(paramAnonymousView, paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                  AppMethodBeat.o(191650);
                  return;
                }
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.Dby.Ehn);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ijR);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.DFJ.Ehn);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.ijP);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramAnonymousView.ijV, paramAnonymousView.ijN, paramAnonymousView.ijO));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.ijM);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.DIW);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.DIV);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.DIZ);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.DIX);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.DIY);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.DJb.ijX);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.DJb.ijZ);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.DJb.ijY);
                if (paramAnonymousView.DJc != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.DJc.toByteArray());
                  if ((paramAnonymousView.DIV & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  AppMethodBeat.o(191650);
                  return;
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                  }
                }
              }
              paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aam(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                AppMethodBeat.o(191650);
                return;
              }
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (w.td(paramAnonymousAdapterView))
              {
                paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(191650);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(191650);
              return;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).WQ(paramAnonymousInt);
            if (paramAnonymousAdapterView != null)
            {
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              paramAnonymousView = AddressUI.AddressUIFragment.this;
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
              {
                AppMethodBeat.o(191650);
                return;
              }
              if (w.td(paramAnonymousAdapterView))
              {
                ad.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
                AppMethodBeat.o(191650);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              if (w.sB(paramAnonymousAdapterView)) {
                ((Intent)localObject).putExtra("Is_group_card", true);
              }
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                e.a((Intent)localObject, paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
            }
            AppMethodBeat.o(191650);
          }
        });
        this.sMV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(191651);
            ad.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              ad.w("MicroMsg.AddressUI", "on item long click, but match header view");
              AppMethodBeat.o(191651);
              return true;
            }
            if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Hyd))
            {
              AppMethodBeat.o(191651);
              return true;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).WQ(paramAnonymousInt - AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            if (paramAnonymousAdapterView == null)
            {
              ad.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
              AppMethodBeat.o(191651);
              return true;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if ((w.td(paramAnonymousAdapterView)) || (w.te(paramAnonymousAdapterView)))
            {
              AppMethodBeat.o(191651);
              return true;
            }
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
            AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(191651);
            return true;
          }
        });
        this.sMV.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(191652);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(191652);
              return false;
              AddressUI.AddressUIFragment.this.hideVKB();
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
              AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
            }
          }
        });
        this.sMV.setOnScrollListener(this.fqs);
        this.sMV.setDrawingCacheEnabled(false);
        this.GSI = ((AlphabetScrollBar)findViewById(2131296489));
        this.GSI.setOnScrollBarTouchListener(this.GSZ);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apM().a(this.GSD);
        if (this.GSU != null) {
          com.tencent.mm.am.af.awe().a(this.GSU, null);
        }
        AppMethodBeat.o(37630);
        return;
        bool = false;
        break;
        label1109:
        ((y.b)localObject).ws(true);
      }
    }
    
    public final void eOV()
    {
      AppMethodBeat.i(37631);
      ad.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      com.tencent.mm.model.az.arV();
      if (l - bt.a((Long)com.tencent.mm.model.c.afk().get(340226, null), 0L) >= 180000L) {
        fbc();
      }
      Object localObject;
      if (this.GSW)
      {
        this.GSW = false;
        this.GSV = false;
        fba();
        this.sMV.setAdapter(this.GSD);
        this.sMV.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37611);
            ad.i("MicroMsg.AddressUI", "post to first init finish");
            View localView = AddressUI.AddressUIFragment.this.findViewById(2131301512);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.AddressUIFragment.this.getContext(), 2130772048));
            }
            AppMethodBeat.o(37611);
          }
        });
        this.GSE.wM(false);
        if (this.GSN != null)
        {
          localObject = this.GSN;
          ((BizContactEntranceView)localObject).fbe();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.GSU != null)
        {
          if (this.GSU.getEnterpriseFriendCount() > 0) {
            break label406;
          }
          this.GSU.setVisibility(8);
        }
      }
      for (;;)
      {
        com.tencent.mm.model.az.arV();
        this.GSK = ((Boolean)com.tencent.mm.model.c.afk().get(12296, Boolean.FALSE)).booleanValue();
        if (this.GSH == 2)
        {
          com.tencent.mm.model.az.arV();
          localObject = com.tencent.mm.model.c.apM().aHY(u.aqG());
          if ((localObject != null) && ((!com.tencent.mm.n.b.ls(((au)localObject).field_type)) || (!bt.isNullOrNil(((au)localObject).field_conRemark)) || (!bt.isNullOrNil(((au)localObject).field_conRemarkPYFull)) || (!bt.isNullOrNil(((au)localObject).field_conRemarkPYShort))))
          {
            ((com.tencent.mm.storage.af)localObject).Zk();
            ((com.tencent.mm.storage.af)localObject).nb("");
            ((com.tencent.mm.storage.af)localObject).nh("");
            ((com.tencent.mm.storage.af)localObject).ni("");
            com.tencent.mm.model.az.arV();
            com.tencent.mm.model.c.apM().c(u.aqG(), (com.tencent.mm.storage.af)localObject);
          }
        }
        if (this.GSE != null) {
          this.GSE.onResume();
        }
        this.GSD.FII = false;
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37613);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
            AppMethodBeat.o(37613);
          }
        });
        if (this.GSM != null)
        {
          this.GSM.setFrontGround(true);
          l.fbu();
        }
        localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.GTb);
        }
        AppMethodBeat.o(37631);
        return;
        if (!this.GSV) {
          break;
        }
        this.GSV = false;
        com.tencent.mm.sdk.g.b.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37612);
            Process.setThreadPriority(10);
            AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this);
            AppMethodBeat.o(37612);
          }
        }, "AddressUI_updateUIData");
        this.GSS.fbg();
        break;
        label406:
        this.GSU.setVisibility(0);
      }
    }
    
    public final void eOW() {}
    
    public final void eOX()
    {
      AppMethodBeat.i(37633);
      ad.i("MicroMsg.AddressUI", "AddressUI on Pause");
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.afk().set(340226, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.afk().set(12296, Boolean.valueOf(this.GSK));
      if (this.GSE != null) {
        this.GSE.onPause();
      }
      this.GSD.faY();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191658);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
          AppMethodBeat.o(191658);
        }
      });
      if (this.GSM != null) {
        this.GSM.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.getHomeUI().aF(this.GTb);
      }
      AppMethodBeat.o(37633);
    }
    
    public final void eOY() {}
    
    public final void eOZ()
    {
      AppMethodBeat.i(37634);
      ad.v("MicroMsg.AddressUI", "onDestory");
      if (this.GSI != null) {
        this.GSI.Gdv = null;
      }
      com.tencent.mm.model.az.aeS().b(138, this);
      if (this.GSD != null)
      {
        this.GSD.vl(true);
        this.GSD.detach();
        this.GSD.ePu();
      }
      if (this.GSE != null)
      {
        this.GSE.detach();
        this.GSE.cHX();
      }
      if ((com.tencent.mm.model.az.afw()) && (this.GSD != null))
      {
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apM().b(this.GSD);
      }
      if ((com.tencent.mm.model.az.afw()) && (this.GSU != null)) {
        com.tencent.mm.am.af.awe().a(this.GSU);
      }
      if (this.GSM != null)
      {
        l locall = this.GSM;
        if (com.tencent.mm.model.az.afw()) {
          com.tencent.mm.bk.d.aCo().remove(locall.GVt);
        }
        this.GSM = null;
      }
      if (this.GSN != null) {
        this.GSN = null;
      }
      if (this.GSO != null) {
        this.GSO = null;
      }
      if (this.GSR != null) {
        this.GSR = null;
      }
      if (this.GSQ != null) {
        this.GSQ = null;
      }
      AppMethodBeat.o(37634);
    }
    
    public final void ePa()
    {
      AppMethodBeat.i(37638);
      ad.v("MicroMsg.AddressUI", "request to top");
      if (this.sMV != null)
      {
        Object localObject1 = this.sMV;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      }
      AppMethodBeat.o(37638);
    }
    
    public final void ePb()
    {
      AppMethodBeat.i(37636);
      if (this.GSD != null)
      {
        a locala = this.GSD;
        locala.GSo.clear();
        locala.GSm.clear();
        locala.GSn = false;
      }
      ad.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.GSN != null) {
        this.GSN.destroyDrawingCache();
      }
      if (this.GSO != null) {
        this.GSO.destroyDrawingCache();
      }
      if (this.GSQ != null) {
        this.GSQ.destroyDrawingCache();
      }
      if (this.GSR != null) {
        this.GSR.destroyDrawingCache();
      }
      if (this.GSS != null) {
        this.GSS.destroyDrawingCache();
      }
      if (this.GSM != null) {
        this.GSM.destroyDrawingCache();
      }
      AppMethodBeat.o(37636);
    }
    
    public final void ePc()
    {
      AppMethodBeat.i(37637);
      ad.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      AppMethodBeat.o(37637);
    }
    
    public final void eQa()
    {
      AppMethodBeat.i(37639);
      if (this.GSM != null) {
        l.fbu();
      }
      AppMethodBeat.o(37639);
    }
    
    public final void eQb() {}
    
    public final void fbc()
    {
      AppMethodBeat.i(37640);
      if (this.sMV != null) {
        this.sMV.setSelection(0);
      }
      AppMethodBeat.o(37640);
    }
    
    public int getLayoutId()
    {
      return 2131492947;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37622);
      com.tencent.mm.kiss.a.b.agA();
      View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131492947);
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
      ad.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      AppMethodBeat.i(191663);
      super.onConfigurationChanged(paramConfiguration);
      ePQ();
      AppMethodBeat.o(191663);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(37623);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.ESL.c(this.xGw);
      AppMethodBeat.o(37623);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37626);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      com.tencent.mm.model.az.arV();
      com.tencent.mm.storage.af localaf = com.tencent.mm.model.c.apM().aHY(this.GSG);
      if (localaf == null)
      {
        ad.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.GSG);
        AppMethodBeat.o(37626);
        return;
      }
      if (u.aqG().equals(localaf.field_username))
      {
        AppMethodBeat.o(37626);
        return;
      }
      if (w.sB(this.GSG))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localaf.ZX()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37626);
        return;
      }
      if ((w.sQ(this.GSG)) || (w.tg(this.GSG)))
      {
        AppMethodBeat.o(37626);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localaf.ZX()));
      if ((com.tencent.mm.n.b.ls(localaf.field_type)) && (localaf.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37626);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37635);
      super.onDestroy();
      com.tencent.mm.sdk.b.a.ESL.d(this.xGw);
      AppMethodBeat.o(37635);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37627);
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (!bt.iM(getContext()))
      {
        AppMethodBeat.o(37627);
        return;
      }
      if (x.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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
    
    public final void wr(boolean paramBoolean)
    {
      AppMethodBeat.i(37624);
      if (this.GSI != null)
      {
        if (this.pQG == null)
        {
          this.pQG = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.pQG.setDuration(200L);
        }
        if (this.GSY == null)
        {
          this.GSY = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.GSY.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.GSI.getVisibility() != 0)
          {
            this.GSI.setVisibility(0);
            this.GSI.startAnimation(this.pQG);
            AppMethodBeat.o(37624);
          }
        }
        else if (4 != this.GSI.getVisibility())
        {
          this.GSI.setVisibility(8);
          this.GSI.startAnimation(this.GSY);
        }
      }
      AppMethodBeat.o(37624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */