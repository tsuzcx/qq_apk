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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.f.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment KFM;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.KFM = new AddressUIFragment();
      this.KFM.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.KFM).commit();
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
    implements com.tencent.mm.ak.f
  {
    private com.tencent.mm.sdk.b.c ACd;
    private TextView KFN;
    private TextView KFO;
    private a KFP;
    private com.tencent.mm.ui.voicesearch.b KFQ;
    private String KFR;
    private String KFS;
    private int KFT;
    private AlphabetScrollBar KFU;
    private LinearLayout KFV;
    private boolean KFW;
    private boolean KFX;
    private l KFY;
    private BizContactEntranceView KFZ;
    private String KFj;
    private String KFk;
    private b KGa;
    private b KGb;
    private b KGc;
    private b KGd;
    private ContactCountView KGe;
    private y KGf;
    private j KGg;
    boolean KGh;
    private boolean KGi;
    private LinearLayout KGj;
    private VerticalScrollBar.a KGk;
    List<String> KGl;
    private Runnable KGm;
    private ProgressDialog fOC;
    com.tencent.mm.pluginsdk.ui.e fPf;
    List<String> fUR;
    private final long ius;
    private TextView jfg;
    private boolean jjp;
    private int oef;
    private int oeg;
    private com.tencent.mm.ui.widget.b.a ofu;
    private n.e qsh;
    private Animation rrh;
    private ListView viQ;
    private Animation wDE;
    
    public AddressUIFragment()
    {
      AppMethodBeat.i(37621);
      this.fOC = null;
      this.KFS = "";
      this.KFV = null;
      this.KFW = false;
      this.jjp = false;
      this.KFX = false;
      this.KGi = true;
      this.ius = 180000L;
      this.ACd = new com.tencent.mm.sdk.b.c() {};
      this.qsh = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(187925);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(187925);
            return;
          case 1: 
          case 2: 
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(187925);
            return;
          }
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(187925);
        }
      };
      this.KGk = new VerticalScrollBar.a()
      {
        public final void vy(String paramAnonymousString)
        {
          int i = 0;
          AppMethodBeat.i(187926);
          if (AddressUI.AddressUIFragment.this.getString(2131762893).equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(187926);
            return;
          }
          Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
          ae.v("MicroMsg.AddressAdapter", "getSections");
          localObject = ((a)localObject).KFp;
          if (localObject == null)
          {
            AppMethodBeat.o(187926);
            return;
          }
          if ("↑".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(187926);
            return;
          }
          if ("☆".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            AppMethodBeat.o(187926);
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
          AppMethodBeat.o(187926);
          return;
          AppMethodBeat.o(187926);
        }
      };
      this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(187927);
          if (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(187927);
            return;
          }
          if (!AddressUI.AddressUIFragment.p(AddressUI.AddressUIFragment.this)) {
            AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this);
          }
          AppMethodBeat.o(187927);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(187928);
          if (paramAnonymousInt == 2) {
            com.tencent.mm.ci.d.fyy().gC(AddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(187928);
        }
      });
      this.fUR = new LinkedList();
      this.KGl = new LinkedList();
      this.KGm = new Runnable()
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
    
    private void fLW()
    {
      AppMethodBeat.i(37628);
      this.fUR = new LinkedList();
      this.KGl = new LinkedList();
      com.tencent.mm.br.d.fjx();
      this.fUR.add("tmessage");
      this.KGl.addAll(this.fUR);
      if (!this.fUR.contains("officialaccounts")) {
        this.fUR.add("officialaccounts");
      }
      this.fUR.add("helper_entry");
      if (this.KFP != null) {
        this.KFP.iy(this.fUR);
      }
      if (this.KFQ != null) {
        this.KFQ.iy(this.KGl);
      }
      AppMethodBeat.o(37628);
    }
    
    private void fLX()
    {
      try
      {
        AppMethodBeat.i(37632);
        long l = System.currentTimeMillis();
        fLW();
        ae.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.KFP != null)
        {
          ae.v("MicroMsg.AddressUI", "post to do refresh");
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37609);
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fLV();
              if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) {
                AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).reset();
              }
              AppMethodBeat.o(37609);
            }
          });
        }
        if (this.KFQ != null) {
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37610);
              ae.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37610);
            }
          });
        }
        ae.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(37632);
        return;
      }
      finally {}
    }
    
    private void fzE()
    {
      AppMethodBeat.i(187933);
      final View localView = getView().getRootView().findViewById(2131301338);
      int i = com.tencent.mm.ui.ar.dX(getContext());
      int j = com.tencent.mm.ui.ar.B(getContext(), -1);
      Runnable local12 = new Runnable()
      {
        int hiJ = 0;
        
        public final void run()
        {
          AppMethodBeat.i(37608);
          if (AddressUI.AddressUIFragment.this.getView() == null)
          {
            AppMethodBeat.o(37608);
            return;
          }
          int i = com.tencent.mm.ui.ar.dX(AddressUI.AddressUIFragment.this.getContext());
          int j = com.tencent.mm.ui.ar.B(AddressUI.AddressUIFragment.this.getContext(), -1);
          if (j <= 0) {
            if (this.hiJ < 2)
            {
              ae.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
              AddressUI.AddressUIFragment.this.getView().post(this);
              this.hiJ += 1;
            }
          }
          for (;;)
          {
            ae.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.hiJ), Integer.valueOf(j), Integer.valueOf(i) });
            AppMethodBeat.o(37608);
            return;
            ae.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
            break;
            int k = AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this);
            if (k != AddressUI.AddressUIFragment.this.getView().getPaddingTop())
            {
              ae.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(AddressUI.AddressUIFragment.this.getView().getPaddingTop()) });
              AddressUI.AddressUIFragment.this.getView().setPadding(0, k, 0, localView.getHeight());
            }
            else
            {
              ae.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
        }
      };
      if (j <= 0)
      {
        getView().post(local12);
        AppMethodBeat.o(187933);
        return;
      }
      int k = getTopHeight();
      getView().setPadding(0, k, 0, localView.getHeight());
      ae.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed(local12, 100L);
      AppMethodBeat.o(187933);
    }
    
    private int getTopHeight()
    {
      AppMethodBeat.i(37625);
      int j = com.tencent.mm.ui.ar.dX(getContext());
      int i = com.tencent.mm.ui.ar.B(getContext(), -1);
      View localView = getView().getRootView().findViewById(2131296345);
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
      for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
      {
        SharedPreferences localSharedPreferences;
        if (!bool1)
        {
          localSharedPreferences = ak.fox();
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
            ae.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            AppMethodBeat.o(37625);
            return i + j;
          }
        }
      }
    }
    
    public final void fLY()
    {
      AppMethodBeat.i(37640);
      if (this.viQ != null) {
        this.viQ.setSelection(0);
      }
      AppMethodBeat.o(37640);
    }
    
    public final void fyG()
    {
      AppMethodBeat.i(37630);
      ae.v("MicroMsg.AddressUI", "address ui on create");
      ae.v("MicroMsg.AddressUI", "on address ui create");
      this.KFW = false;
      this.jjp = false;
      this.KFX = false;
      this.KFj = null;
      this.KFk = null;
      this.KFR = null;
      bc.ajj().a(138, this);
      this.KFj = "@all.contact.without.chatroom.without.openim";
      this.KFk = getStringExtra("Contact_GroupFilter_Str");
      this.KFR = getString(2131760134);
      this.KFT = getIntExtra("List_Type", 2);
      fzE();
      ae.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.viQ != null)
      {
        if (this.KFY != null) {
          this.viQ.removeHeaderView(this.KFY);
        }
        if (this.KFZ != null) {
          this.viQ.removeHeaderView(this.KFZ);
        }
        if (this.KGa != null) {
          this.viQ.removeHeaderView(this.KGa);
        }
        if (this.KGd != null) {
          this.viQ.removeHeaderView(this.KGd);
        }
        if (this.KGc != null) {
          this.viQ.removeHeaderView(this.KGc);
        }
      }
      this.viQ = ((ListView)findViewById(2131296471));
      this.viQ.setScrollingCacheEnabled(false);
      this.KFN = ((TextView)findViewById(2131299460));
      this.KFN.setText(2131755193);
      this.jfg = ((TextView)findViewById(2131299481));
      this.jfg.setText(2131755195);
      this.KFO = ((TextView)findViewById(2131299499));
      this.KFO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37615);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37615);
        }
      });
      this.KFP = new a(getContext(), this.KFj, this.KFk, this.KFT);
      this.viQ.setAdapter(null);
      this.KFP.a(new f.a()
      {
        public final void aSR()
        {
          AppMethodBeat.i(37616);
          AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
          AddressUI.AddressUIFragment.c(localAddressUIFragment);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fLT();
          AppMethodBeat.o(37616);
        }
        
        public final void fzs() {}
      });
      this.KFP.KFw = true;
      this.KFP.setFragment(this);
      this.KFP.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
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
      this.KFP.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37618);
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37618);
        }
      });
      this.KFP.a(new MMSlideDelView.f()
      {
        public final void cQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37619);
          if (paramAnonymousObject == null)
          {
            ae.e("MicroMsg.AddressUI", "onItemDel object null");
            AppMethodBeat.o(37619);
            return;
          }
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37619);
        }
      });
      this.KFQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.KFQ.yW(true);
      this.KGj = new LinearLayout(getContext());
      this.KGj.setOrientation(1);
      this.viQ.addHeaderView(this.KGj);
      this.KGb = new b(getContext(), b.a.KGu);
      this.KGj.addView(this.KGb);
      bc.aCg();
      ((Boolean)com.tencent.mm.model.c.ajA().get(am.a.INo, Boolean.FALSE)).booleanValue();
      this.KGb.setVisible(false);
      this.KFY = new l(getContext());
      this.KGj.addView(this.KFY);
      this.KGd = new b(getContext(), b.a.KGv);
      this.KGj.addView(this.KGd);
      boolean bool = com.tencent.mm.kernel.g.ajR().ajA().getBoolean(am.a.Jeb, false);
      if (!bool) {
        h.MqF.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187931);
            com.tencent.mm.kernel.g.ajS();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUU("@social.black.android") > 0)
            {
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.Jeb, Boolean.TRUE);
              AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(187930);
                  AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).setVisible(true);
                  AppMethodBeat.o(187930);
                }
              });
            }
            AppMethodBeat.o(187931);
          }
        });
      }
      Object localObject = this.KGd;
      if (bool)
      {
        bool = true;
        ((b)localObject).setVisible(bool);
        this.KGa = new b(getContext(), b.a.KGs);
        this.KGj.addView(this.KGa);
        this.KGa.setVisible(true);
        this.KGc = new b(getContext(), b.a.KGt);
        this.KGj.addView(this.KGc);
        this.KGc.setVisible(true);
        localObject = this.viQ;
        ContactCountView localContactCountView = new ContactCountView(getContext());
        this.KGe = localContactCountView;
        ((ListView)localObject).addFooterView(localContactCountView, null, false);
        if (com.tencent.mm.br.d.aJN("brandservice"))
        {
          this.KFZ = new BizContactEntranceView(getContext());
          this.KGj.addView(this.KFZ);
          this.KFZ.setVisible(true);
        }
        localObject = new y.b()
        {
          public final void yx(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(187932);
            if (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(187932);
              return;
            }
            BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this);
            if (!paramAnonymousBoolean) {}
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              localBizContactEntranceView.yy(paramAnonymousBoolean);
              AppMethodBeat.o(187932);
              return;
            }
          }
        };
        this.KGf = new y(getContext(), new y.a()
        {
          public final void aeT(int paramAnonymousInt)
          {
            AppMethodBeat.i(187919);
            if ((AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null))
            {
              AppMethodBeat.o(187919);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
              AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).yy(true);
              AppMethodBeat.o(187919);
              return;
            }
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).yy(false);
            AppMethodBeat.o(187919);
          }
        });
        this.KGf.setOnVisibilityChangeListener((y.b)localObject);
        if (this.KGf.getOpenIMCount() > 0) {
          break label1109;
        }
        ((y.b)localObject).yx(false);
        this.KGf.setVisibility(8);
      }
      for (;;)
      {
        this.KGj.addView(this.KGf);
        this.KGg = new j(getContext(), new j.a()
        {
          public final void aeU(int paramAnonymousInt)
          {
            AppMethodBeat.i(187920);
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(187920);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(8);
              AppMethodBeat.o(187920);
              return;
            }
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(0);
            AppMethodBeat.o(187920);
          }
        });
        if (this.KGg.getEnterpriseFriendCount() <= 0) {
          this.KGg.setVisibility(8);
        }
        this.KGj.addView(this.KGg);
        this.ofu = new com.tencent.mm.ui.widget.b.a(getContext());
        this.KFP.KFu = new a.a() {};
        this.viQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(187921);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
            if (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) == null) {}
            for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Lmd))
            {
              ae.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
              if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this)))) {
                break;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(187921);
              return;
            }
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(187921);
              return;
            }
            paramAnonymousInt -= AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Lmd))
            {
              boolean bool1 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Iw(paramAnonymousInt);
              boolean bool2 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).afG(paramAnonymousInt);
              ae.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
              if (bool2) {
                AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aZb("");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(187921);
                return;
                if (bool1)
                {
                  paramAnonymousView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).afF(paramAnonymousInt);
                  paramAnonymousAdapterView = paramAnonymousView.GuF.HId;
                  bc.aCg();
                  localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousAdapterView);
                  if (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("Contact_Scene", 3);
                    if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                    {
                      if (((an)localObject).fug()) {
                        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                      }
                      e.a(paramAnonymousView, paramAnonymousAdapterView);
                      paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                      com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                    }
                  }
                  else
                  {
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.GuF.HId);
                    ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.jga);
                    ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Hed.HId);
                    ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.jfY);
                    ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramAnonymousView.jge, paramAnonymousView.jfW, paramAnonymousView.jfX));
                    ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.jfV);
                    ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Hhv);
                    ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Hhu);
                    ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Hhy);
                    ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Hhw);
                    ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Hhx);
                    ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.HhA.jgg);
                    ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.HhA.jgi);
                    ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.HhA.jgh);
                    if (paramAnonymousView.HhB != null) {}
                    try
                    {
                      ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.HhB.toByteArray());
                      if ((paramAnonymousView.Hhu & 0x8) > 0) {
                        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                      }
                      ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                      com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                    }
                    catch (IOException localIOException)
                    {
                      for (;;)
                      {
                        ae.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                      }
                    }
                  }
                }
                else
                {
                  paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Ga(paramAnonymousInt);
                  if (paramAnonymousAdapterView == null)
                  {
                    ae.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(187921);
                    return;
                  }
                  paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                  if (x.AN(paramAnonymousAdapterView))
                  {
                    paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                    paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                    paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(187921);
                    return;
                  }
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                    com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                }
              }
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).abR(paramAnonymousInt);
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
              AppMethodBeat.o(187921);
              return;
              label1090:
              if (x.AN(paramAnonymousAdapterView))
              {
                ae.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                if (x.Al(paramAnonymousAdapterView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousAdapterView);
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
              }
            }
          }
        });
        this.viQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(187922);
            ae.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              ae.w("MicroMsg.AddressUI", "on item long click, but match header view");
              AppMethodBeat.o(187922);
              return true;
            }
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).Lmd))
            {
              AppMethodBeat.o(187922);
              return true;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).abR(paramAnonymousInt - AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            if (paramAnonymousAdapterView == null)
            {
              ae.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
              AppMethodBeat.o(187922);
              return true;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if ((x.AN(paramAnonymousAdapterView)) || (x.AO(paramAnonymousAdapterView)))
            {
              AppMethodBeat.o(187922);
              return true;
            }
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
            AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(187922);
            return true;
          }
        });
        this.viQ.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(187923);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(187923);
              return false;
              AddressUI.AddressUIFragment.this.hideVKB();
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
              AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
            }
          }
        });
        this.viQ.setOnScrollListener(this.fPf);
        this.viQ.setDrawingCacheEnabled(false);
        this.KFU = ((AlphabetScrollBar)findViewById(2131296489));
        this.KFU.setOnScrollBarTouchListener(this.KGk);
        bc.aCg();
        com.tencent.mm.model.c.azF().a(this.KFP);
        if (this.KGg != null) {
          ag.aGp().a(this.KGg, null);
        }
        AppMethodBeat.o(37630);
        return;
        bool = false;
        break;
        label1109:
        ((y.b)localObject).yx(true);
      }
    }
    
    public final void fyH()
    {
      AppMethodBeat.i(37631);
      ae.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      bc.aCg();
      if (l - bu.a((Long)com.tencent.mm.model.c.ajA().get(340226, null), 0L) >= 180000L) {
        fLY();
      }
      Object localObject;
      if (this.KGi)
      {
        this.KGi = false;
        this.KGh = false;
        fLW();
        h.MqF.aO(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37611);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).post(new AddressUI.AddressUIFragment.15.1(this));
            AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).yV(false);
            AppMethodBeat.o(37611);
          }
        });
        if (this.KFZ != null)
        {
          localObject = this.KFZ;
          ((BizContactEntranceView)localObject).fMa();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.KGg != null)
        {
          if (this.KGg.getEnterpriseFriendCount() > 0) {
            break label388;
          }
          this.KGg.setVisibility(8);
        }
      }
      for (;;)
      {
        bc.aCg();
        this.KFW = ((Boolean)com.tencent.mm.model.c.ajA().get(12296, Boolean.FALSE)).booleanValue();
        if (this.KFT == 2)
        {
          bc.aCg();
          localObject = com.tencent.mm.model.c.azF().BH(v.aAC());
          if ((localObject != null) && ((!com.tencent.mm.contact.c.lO(((aw)localObject).field_type)) || (!bu.isNullOrNil(((aw)localObject).field_conRemark)) || (!bu.isNullOrNil(((aw)localObject).field_conRemarkPYFull)) || (!bu.isNullOrNil(((aw)localObject).field_conRemarkPYShort))))
          {
            ((an)localObject).acS();
            ((an)localObject).tm("");
            ((an)localObject).ts("");
            ((an)localObject).tt("");
            bc.aCg();
            com.tencent.mm.model.c.azF().c(v.aAC(), (an)localObject);
          }
        }
        if (this.KFQ != null) {
          this.KFQ.onResume();
        }
        this.KFP.JpP = false;
        com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37613);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
            AppMethodBeat.o(37613);
          }
        });
        if (this.KFY != null)
        {
          this.KFY.setFrontGround(true);
          l.fMq();
        }
        localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.KGm);
        }
        AppMethodBeat.o(37631);
        return;
        if (!this.KGh) {
          break;
        }
        this.KGh = false;
        com.tencent.mm.sdk.g.b.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37612);
            Process.setThreadPriority(10);
            AddressUI.AddressUIFragment.r(AddressUI.AddressUIFragment.this);
            AppMethodBeat.o(37612);
          }
        }, "AddressUI_updateUIData");
        this.KGe.fMc();
        break;
        label388:
        this.KGg.setVisibility(0);
      }
    }
    
    public final void fyI() {}
    
    public final void fyJ()
    {
      AppMethodBeat.i(37633);
      ae.i("MicroMsg.AddressUI", "AddressUI on Pause");
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(340226, Long.valueOf(System.currentTimeMillis()));
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(12296, Boolean.valueOf(this.KFW));
      if (this.KFQ != null) {
        this.KFQ.onPause();
      }
      this.KFP.fLU();
      com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187929);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
          AppMethodBeat.o(187929);
        }
      });
      if (this.KFY != null) {
        this.KFY.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.getHomeUI().aD(this.KGm);
      }
      AppMethodBeat.o(37633);
    }
    
    public final void fyK() {}
    
    public final void fyL()
    {
      AppMethodBeat.i(37634);
      ae.v("MicroMsg.AddressUI", "onDestory");
      if (this.KFU != null) {
        this.KFU.JLP = null;
      }
      bc.ajj().b(138, this);
      if (this.KFP != null)
      {
        this.KFP.xh(true);
        this.KFP.detach();
        this.KFP.fzh();
      }
      if (this.KFQ != null)
      {
        this.KFQ.detach();
        this.KFQ.dhl();
      }
      if ((bc.ajM()) && (this.KFP != null))
      {
        bc.aCg();
        com.tencent.mm.model.c.azF().b(this.KFP);
      }
      if ((bc.ajM()) && (this.KGg != null)) {
        ag.aGp().a(this.KGg);
      }
      if (this.KFY != null)
      {
        l locall = this.KFY;
        if (bc.ajM()) {
          com.tencent.mm.bj.d.aMM().remove(locall.KIH);
        }
        this.KFY = null;
      }
      if (this.KFZ != null) {
        this.KFZ = null;
      }
      if (this.KGa != null) {
        this.KGa = null;
      }
      if (this.KGd != null) {
        this.KGd = null;
      }
      if (this.KGc != null) {
        this.KGc = null;
      }
      AppMethodBeat.o(37634);
    }
    
    public final void fyM()
    {
      AppMethodBeat.i(37638);
      ae.v("MicroMsg.AddressUI", "request to top");
      if (this.viQ != null)
      {
        Object localObject1 = this.viQ;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      }
      AppMethodBeat.o(37638);
    }
    
    public final void fyN()
    {
      AppMethodBeat.i(37636);
      if (this.KFP != null)
      {
        a locala = this.KFP;
        locala.KFA.clear();
        locala.KFy.clear();
        locala.KFz = false;
      }
      ae.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.KFZ != null) {
        this.KFZ.destroyDrawingCache();
      }
      if (this.KGa != null) {
        this.KGa.destroyDrawingCache();
      }
      if (this.KGc != null) {
        this.KGc.destroyDrawingCache();
      }
      if (this.KGd != null) {
        this.KGd.destroyDrawingCache();
      }
      if (this.KGe != null) {
        this.KGe.destroyDrawingCache();
      }
      if (this.KFY != null) {
        this.KFY.destroyDrawingCache();
      }
      AppMethodBeat.o(37636);
    }
    
    public final void fyO()
    {
      AppMethodBeat.i(37637);
      ae.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      AppMethodBeat.o(37637);
    }
    
    public final void fzQ()
    {
      AppMethodBeat.i(37639);
      if (this.KFY != null) {
        l.fMq();
      }
      AppMethodBeat.o(37639);
    }
    
    public final void fzR() {}
    
    public int getLayoutId()
    {
      return 2131492947;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37622);
      com.tencent.mm.kiss.a.b.akR();
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
      ae.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      AppMethodBeat.i(187934);
      super.onConfigurationChanged(paramConfiguration);
      fzE();
      AppMethodBeat.o(187934);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(37623);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.IvT.c(this.ACd);
      AppMethodBeat.o(37623);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37626);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(this.KFS);
      if (localan == null)
      {
        ae.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.KFS);
        AppMethodBeat.o(37626);
        return;
      }
      if (v.aAC().equals(localan.field_username))
      {
        AppMethodBeat.o(37626);
        return;
      }
      if (x.Al(this.KFS))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localan.adG()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37626);
        return;
      }
      if ((x.AA(this.KFS)) || (x.AQ(this.KFS)))
      {
        AppMethodBeat.o(37626);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localan.adG()));
      if ((com.tencent.mm.contact.c.lO(localan.field_type)) && (localan.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37626);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37635);
      super.onDestroy();
      com.tencent.mm.sdk.b.a.IvT.d(this.ACd);
      AppMethodBeat.o(37635);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37627);
      if (this.fOC != null)
      {
        this.fOC.dismiss();
        this.fOC = null;
      }
      if (!bu.jn(getContext()))
      {
        AppMethodBeat.o(37627);
        return;
      }
      if (com.tencent.mm.ui.y.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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
    
    public final void yw(boolean paramBoolean)
    {
      AppMethodBeat.i(37624);
      if (this.KFU != null)
      {
        if (this.rrh == null)
        {
          this.rrh = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.rrh.setDuration(200L);
        }
        if (this.wDE == null)
        {
          this.wDE = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.wDE.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.KFU.getVisibility() != 0)
          {
            this.KFU.setVisibility(0);
            this.KFU.startAnimation(this.rrh);
            AppMethodBeat.o(37624);
          }
        }
        else if (4 != this.KFU.getVisibility())
        {
          this.KFU.setVisibility(8);
          this.KFU.startAnimation(this.wDE);
        }
      }
      AppMethodBeat.o(37624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */