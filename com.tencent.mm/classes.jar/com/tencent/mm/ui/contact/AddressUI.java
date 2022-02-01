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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.a.vb;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ar;
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
  public MMFragment Kjs;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.Kjs = new AddressUIFragment();
      this.Kjs.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.Kjs).commit();
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
    implements com.tencent.mm.al.f
  {
    private com.tencent.mm.sdk.b.c AkQ;
    private String KiP;
    private String KiQ;
    private AlphabetScrollBar KjA;
    private LinearLayout KjB;
    private boolean KjC;
    private boolean KjD;
    private l KjE;
    private BizContactEntranceView KjF;
    private b KjG;
    private b KjH;
    private b KjI;
    private b KjJ;
    private ContactCountView KjK;
    private y KjL;
    private j KjM;
    boolean KjN;
    private boolean KjO;
    private LinearLayout KjP;
    private VerticalScrollBar.a KjQ;
    List<String> KjR;
    private Runnable KjS;
    private TextView Kjt;
    private TextView Kju;
    private a Kjv;
    private com.tencent.mm.ui.voicesearch.b Kjw;
    private String Kjx;
    private String Kjy;
    private int Kjz;
    com.tencent.mm.pluginsdk.ui.e fMX;
    private ProgressDialog fMu;
    List<String> fSL;
    private final long iry;
    private TextView jcn;
    private boolean jgw;
    private int nYw;
    private int nYx;
    private com.tencent.mm.ui.widget.b.a nZK;
    private n.e qlC;
    private Animation rjd;
    private ListView uXc;
    private Animation wnV;
    
    public AddressUIFragment()
    {
      AppMethodBeat.i(37621);
      this.fMu = null;
      this.Kjy = "";
      this.KjB = null;
      this.KjC = false;
      this.jgw = false;
      this.KjD = false;
      this.KjO = true;
      this.iry = 180000L;
      this.AkQ = new com.tencent.mm.sdk.b.c() {};
      this.qlC = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(194524);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(194524);
            return;
          case 1: 
          case 2: 
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(194524);
            return;
          }
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(194524);
        }
      };
      this.KjQ = new VerticalScrollBar.a()
      {
        public final void vc(String paramAnonymousString)
        {
          int i = 0;
          AppMethodBeat.i(194525);
          if (AddressUI.AddressUIFragment.this.getString(2131762893).equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(194525);
            return;
          }
          Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
          ad.v("MicroMsg.AddressAdapter", "getSections");
          localObject = ((a)localObject).KiV;
          if (localObject == null)
          {
            AppMethodBeat.o(194525);
            return;
          }
          if ("↑".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(194525);
            return;
          }
          if ("☆".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            AppMethodBeat.o(194525);
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
          AppMethodBeat.o(194525);
          return;
          AppMethodBeat.o(194525);
        }
      };
      this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(194526);
          if (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(194526);
            return;
          }
          if (!AddressUI.AddressUIFragment.p(AddressUI.AddressUIFragment.this)) {
            AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this);
          }
          AppMethodBeat.o(194526);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(194527);
          if (paramAnonymousInt == 2) {
            com.tencent.mm.cj.d.fux().gt(AddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(194527);
        }
      });
      this.fSL = new LinkedList();
      this.KjR = new LinkedList();
      this.KjS = new Runnable()
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
    
    private void fHE()
    {
      AppMethodBeat.i(37628);
      this.fSL = new LinkedList();
      this.KjR = new LinkedList();
      com.tencent.mm.bs.d.ffH();
      this.fSL.add("tmessage");
      this.KjR.addAll(this.fSL);
      if (!this.fSL.contains("officialaccounts")) {
        this.fSL.add("officialaccounts");
      }
      this.fSL.add("helper_entry");
      if (this.Kjv != null) {
        this.Kjv.io(this.fSL);
      }
      if (this.Kjw != null) {
        this.Kjw.io(this.KjR);
      }
      AppMethodBeat.o(37628);
    }
    
    private void fHF()
    {
      try
      {
        AppMethodBeat.i(37632);
        long l = System.currentTimeMillis();
        fHE();
        ad.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.Kjv != null)
        {
          ad.v("MicroMsg.AddressUI", "post to do refresh");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37609);
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fHD();
              if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) {
                AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).reset();
              }
              AppMethodBeat.o(37609);
            }
          });
        }
        if (this.Kjw != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37610);
              ad.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).a(null, null);
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
    
    private void fvE()
    {
      AppMethodBeat.i(194532);
      final View localView = getView().getRootView().findViewById(2131301338);
      int i = ar.dT(getContext());
      int j = ar.B(getContext(), -1);
      Runnable local12 = new Runnable()
      {
        int hfV = 0;
        
        public final void run()
        {
          AppMethodBeat.i(37608);
          if (AddressUI.AddressUIFragment.this.getView() == null)
          {
            AppMethodBeat.o(37608);
            return;
          }
          int i = ar.dT(AddressUI.AddressUIFragment.this.getContext());
          int j = ar.B(AddressUI.AddressUIFragment.this.getContext(), -1);
          if (j <= 0) {
            if (this.hfV < 2)
            {
              ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
              AddressUI.AddressUIFragment.this.getView().post(this);
              this.hfV += 1;
            }
          }
          for (;;)
          {
            ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.hfV), Integer.valueOf(j), Integer.valueOf(i) });
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
        AppMethodBeat.o(194532);
        return;
      }
      int k = getTopHeight();
      getView().setPadding(0, k, 0, localView.getHeight());
      ad.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed(local12, 100L);
      AppMethodBeat.o(194532);
    }
    
    private int getTopHeight()
    {
      AppMethodBeat.i(37625);
      int j = ar.dT(getContext());
      int i = ar.B(getContext(), -1);
      View localView = getView().getRootView().findViewById(2131296345);
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
      for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
      {
        SharedPreferences localSharedPreferences;
        if (!bool1)
        {
          localSharedPreferences = aj.fkD();
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
    
    public final void fHG()
    {
      AppMethodBeat.i(37640);
      if (this.uXc != null) {
        this.uXc.setSelection(0);
      }
      AppMethodBeat.o(37640);
    }
    
    public final void fuF()
    {
      AppMethodBeat.i(37630);
      ad.v("MicroMsg.AddressUI", "address ui on create");
      ad.v("MicroMsg.AddressUI", "on address ui create");
      this.KjC = false;
      this.jgw = false;
      this.KjD = false;
      this.KiP = null;
      this.KiQ = null;
      this.Kjx = null;
      ba.aiU().a(138, this);
      this.KiP = "@all.contact.without.chatroom.without.openim";
      this.KiQ = getStringExtra("Contact_GroupFilter_Str");
      this.Kjx = getString(2131760134);
      this.Kjz = getIntExtra("List_Type", 2);
      fvE();
      ad.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.uXc != null)
      {
        if (this.KjE != null) {
          this.uXc.removeHeaderView(this.KjE);
        }
        if (this.KjF != null) {
          this.uXc.removeHeaderView(this.KjF);
        }
        if (this.KjG != null) {
          this.uXc.removeHeaderView(this.KjG);
        }
        if (this.KjJ != null) {
          this.uXc.removeHeaderView(this.KjJ);
        }
        if (this.KjI != null) {
          this.uXc.removeHeaderView(this.KjI);
        }
      }
      this.uXc = ((ListView)findViewById(2131296471));
      this.uXc.setScrollingCacheEnabled(false);
      this.Kjt = ((TextView)findViewById(2131299460));
      this.Kjt.setText(2131755193);
      this.jcn = ((TextView)findViewById(2131299481));
      this.jcn.setText(2131755195);
      this.Kju = ((TextView)findViewById(2131299499));
      this.Kju.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37615);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37615);
        }
      });
      this.Kjv = new a(getContext(), this.KiP, this.KiQ, this.Kjz);
      this.uXc.setAdapter(null);
      this.Kjv.a(new f.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(37616);
          AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
          AddressUI.AddressUIFragment.c(localAddressUIFragment);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fHB();
          AppMethodBeat.o(37616);
        }
        
        public final void fvs() {}
      });
      this.Kjv.Kjc = true;
      this.Kjv.setFragment(this);
      this.Kjv.setGetViewPositionCallback(new MMSlideDelView.c()
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
      this.Kjv.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37618);
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37618);
        }
      });
      this.Kjv.a(new MMSlideDelView.f()
      {
        public final void cP(Object paramAnonymousObject)
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
      this.Kjw = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.Kjw.yI(true);
      this.KjP = new LinearLayout(getContext());
      this.KjP.setOrientation(1);
      this.uXc.addHeaderView(this.KjP);
      this.KjH = new b(getContext(), b.a.Kka);
      this.KjP.addView(this.KjH);
      ba.aBQ();
      ((Boolean)com.tencent.mm.model.c.ajl().get(al.a.IsS, Boolean.FALSE)).booleanValue();
      this.KjH.setVisible(false);
      this.KjE = new l(getContext());
      this.KjP.addView(this.KjE);
      this.KjJ = new b(getContext(), b.a.Kkb);
      this.KjP.addView(this.KjJ);
      boolean bool = com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IJv, false);
      if (!bool) {
        h.LTJ.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194530);
            com.tencent.mm.kernel.g.ajD();
            if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTt("@social.black.android") > 0)
            {
              com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJv, Boolean.TRUE);
              AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(194529);
                  AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).setVisible(true);
                  AppMethodBeat.o(194529);
                }
              });
            }
            AppMethodBeat.o(194530);
          }
        });
      }
      Object localObject = this.KjJ;
      if (bool)
      {
        bool = true;
        ((b)localObject).setVisible(bool);
        this.KjG = new b(getContext(), b.a.KjY);
        this.KjP.addView(this.KjG);
        this.KjG.setVisible(true);
        this.KjI = new b(getContext(), b.a.KjZ);
        this.KjP.addView(this.KjI);
        this.KjI.setVisible(true);
        localObject = this.uXc;
        ContactCountView localContactCountView = new ContactCountView(getContext());
        this.KjK = localContactCountView;
        ((ListView)localObject).addFooterView(localContactCountView, null, false);
        if (com.tencent.mm.bs.d.aIu("brandservice"))
        {
          this.KjF = new BizContactEntranceView(getContext());
          this.KjP.addView(this.KjF);
          this.KjF.setVisible(true);
        }
        localObject = new y.b()
        {
          public final void yk(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(194531);
            if (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(194531);
              return;
            }
            BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this);
            if (!paramAnonymousBoolean) {}
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              localBizContactEntranceView.yl(paramAnonymousBoolean);
              AppMethodBeat.o(194531);
              return;
            }
          }
        };
        this.KjL = new y(getContext(), new y.a()
        {
          public final void aek(int paramAnonymousInt)
          {
            AppMethodBeat.i(194518);
            if ((AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null))
            {
              AppMethodBeat.o(194518);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
              AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).yl(true);
              AppMethodBeat.o(194518);
              return;
            }
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).yl(false);
            AppMethodBeat.o(194518);
          }
        });
        this.KjL.setOnVisibilityChangeListener((y.b)localObject);
        if (this.KjL.getOpenIMCount() > 0) {
          break label1109;
        }
        ((y.b)localObject).yk(false);
        this.KjL.setVisibility(8);
      }
      for (;;)
      {
        this.KjP.addView(this.KjL);
        this.KjM = new j(getContext(), new j.a()
        {
          public final void ael(int paramAnonymousInt)
          {
            AppMethodBeat.i(194519);
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(194519);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(8);
              AppMethodBeat.o(194519);
              return;
            }
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(0);
            AppMethodBeat.o(194519);
          }
        });
        if (this.KjM.getEnterpriseFriendCount() <= 0) {
          this.KjM.setVisibility(8);
        }
        this.KjP.addView(this.KjM);
        this.nZK = new com.tencent.mm.ui.widget.b.a(getContext());
        this.Kjv.Kja = new a.a() {};
        this.uXc.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(194520);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
            if (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) == null) {}
            for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).KPF))
            {
              ad.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
              if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this)))) {
                break;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(194520);
              return;
            }
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(194520);
              return;
            }
            paramAnonymousInt -= AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).KPF))
            {
              boolean bool1 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).HY(paramAnonymousInt);
              boolean bool2 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aeX(paramAnonymousInt);
              ad.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
              if (bool2) {
                AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aXz("");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(194520);
                return;
                if (bool1)
                {
                  paramAnonymousView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aeW(paramAnonymousInt);
                  paramAnonymousAdapterView = paramAnonymousView.GbY.HoB;
                  ba.aBQ();
                  localObject = com.tencent.mm.model.c.azp().Bf(paramAnonymousAdapterView);
                  if (com.tencent.mm.o.b.lM(((aw)localObject).field_type))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("Contact_Scene", 3);
                    if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                    {
                      if (((am)localObject).fqg()) {
                        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousAdapterView + ",3");
                      }
                      e.a(paramAnonymousView, paramAnonymousAdapterView);
                      paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                      com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                    }
                  }
                  else
                  {
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.GbY.HoB);
                    ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.jdh);
                    ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.GKC.HoB);
                    ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.jdf);
                    ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramAnonymousView.jdl, paramAnonymousView.jdd, paramAnonymousView.jde));
                    ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.jdc);
                    ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.GNV);
                    ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.GNU);
                    ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.GNY);
                    ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.GNW);
                    ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.GNX);
                    ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.GOa.jdn);
                    ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.GOa.jdp);
                    ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.GOa.jdo);
                    if (paramAnonymousView.GOb != null) {}
                    try
                    {
                      ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.GOb.toByteArray());
                      if ((paramAnonymousView.GNU & 0x8) > 0) {
                        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, paramAnonymousAdapterView + ",3");
                      }
                      ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                      com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                    }
                    catch (IOException localIOException)
                    {
                      for (;;)
                      {
                        ad.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                      }
                    }
                  }
                }
                else
                {
                  paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).FC(paramAnonymousInt);
                  if (paramAnonymousAdapterView == null)
                  {
                    ad.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194520);
                    return;
                  }
                  paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                  if (w.Ad(paramAnonymousAdapterView))
                  {
                    paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                    paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                    paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(194520);
                    return;
                  }
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                    com.tencent.mm.bs.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                }
              }
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).abj(paramAnonymousInt);
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
              AppMethodBeat.o(194520);
              return;
              label1090:
              if (w.Ad(paramAnonymousAdapterView))
              {
                ad.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
                if (w.zB(paramAnonymousAdapterView)) {
                  ((Intent)localObject).putExtra("Is_group_card", true);
                }
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  e.a((Intent)localObject, paramAnonymousAdapterView);
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
              }
            }
          }
        });
        this.uXc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(194521);
            ad.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              ad.w("MicroMsg.AddressUI", "on item long click, but match header view");
              AppMethodBeat.o(194521);
              return true;
            }
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).KPF))
            {
              AppMethodBeat.o(194521);
              return true;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).abj(paramAnonymousInt - AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            if (paramAnonymousAdapterView == null)
            {
              ad.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
              AppMethodBeat.o(194521);
              return true;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if ((w.Ad(paramAnonymousAdapterView)) || (w.Ae(paramAnonymousAdapterView)))
            {
              AppMethodBeat.o(194521);
              return true;
            }
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
            AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(194521);
            return true;
          }
        });
        this.uXc.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(194522);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
              AppMethodBeat.o(194522);
              return false;
              AddressUI.AddressUIFragment.this.hideVKB();
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
              AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
            }
          }
        });
        this.uXc.setOnScrollListener(this.fMX);
        this.uXc.setDrawingCacheEnabled(false);
        this.KjA = ((AlphabetScrollBar)findViewById(2131296489));
        this.KjA.setOnScrollBarTouchListener(this.KjQ);
        ba.aBQ();
        com.tencent.mm.model.c.azp().a(this.Kjv);
        if (this.KjM != null) {
          ag.aFZ().a(this.KjM, null);
        }
        AppMethodBeat.o(37630);
        return;
        bool = false;
        break;
        label1109:
        ((y.b)localObject).yk(true);
      }
    }
    
    public final void fuG()
    {
      AppMethodBeat.i(37631);
      ad.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      ba.aBQ();
      if (l - bt.a((Long)com.tencent.mm.model.c.ajl().get(340226, null), 0L) >= 180000L) {
        fHG();
      }
      Object localObject;
      if (this.KjO)
      {
        this.KjO = false;
        this.KjN = false;
        fHE();
        this.uXc.setAdapter(this.Kjv);
        this.uXc.post(new Runnable()
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
        this.Kjw.yH(false);
        if (this.KjF != null)
        {
          localObject = this.KjF;
          ((BizContactEntranceView)localObject).fHI();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.KjM != null)
        {
          if (this.KjM.getEnterpriseFriendCount() > 0) {
            break label406;
          }
          this.KjM.setVisibility(8);
        }
      }
      for (;;)
      {
        ba.aBQ();
        this.KjC = ((Boolean)com.tencent.mm.model.c.ajl().get(12296, Boolean.FALSE)).booleanValue();
        if (this.Kjz == 2)
        {
          ba.aBQ();
          localObject = com.tencent.mm.model.c.azp().Bf(u.aAm());
          if ((localObject != null) && ((!com.tencent.mm.o.b.lM(((aw)localObject).field_type)) || (!bt.isNullOrNil(((aw)localObject).field_conRemark)) || (!bt.isNullOrNil(((aw)localObject).field_conRemarkPYFull)) || (!bt.isNullOrNil(((aw)localObject).field_conRemarkPYShort))))
          {
            ((am)localObject).acH();
            ((am)localObject).sR("");
            ((am)localObject).sX("");
            ((am)localObject).sY("");
            ba.aBQ();
            com.tencent.mm.model.c.azp().c(u.aAm(), (am)localObject);
          }
        }
        if (this.Kjw != null) {
          this.Kjw.onResume();
        }
        this.Kjv.IVh = false;
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37613);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
            AppMethodBeat.o(37613);
          }
        });
        if (this.KjE != null)
        {
          this.KjE.setFrontGround(true);
          l.fHY();
        }
        localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.KjS);
        }
        AppMethodBeat.o(37631);
        return;
        if (!this.KjN) {
          break;
        }
        this.KjN = false;
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
        this.KjK.fHK();
        break;
        label406:
        this.KjM.setVisibility(0);
      }
    }
    
    public final void fuH() {}
    
    public final void fuI()
    {
      AppMethodBeat.i(37633);
      ad.i("MicroMsg.AddressUI", "AddressUI on Pause");
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(340226, Long.valueOf(System.currentTimeMillis()));
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(12296, Boolean.valueOf(this.KjC));
      if (this.Kjw != null) {
        this.Kjw.onPause();
      }
      this.Kjv.fHC();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194528);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
          AppMethodBeat.o(194528);
        }
      });
      if (this.KjE != null) {
        this.KjE.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.getHomeUI().aF(this.KjS);
      }
      AppMethodBeat.o(37633);
    }
    
    public final void fuJ() {}
    
    public final void fuK()
    {
      AppMethodBeat.i(37634);
      ad.v("MicroMsg.AddressUI", "onDestory");
      if (this.KjA != null) {
        this.KjA.Jra = null;
      }
      ba.aiU().b(138, this);
      if (this.Kjv != null)
      {
        this.Kjv.wZ(true);
        this.Kjv.detach();
        this.Kjv.fvg();
      }
      if (this.Kjw != null)
      {
        this.Kjw.detach();
        this.Kjw.det();
      }
      if ((ba.ajx()) && (this.Kjv != null))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azp().b(this.Kjv);
      }
      if ((ba.ajx()) && (this.KjM != null)) {
        ag.aFZ().a(this.KjM);
      }
      if (this.KjE != null)
      {
        l locall = this.KjE;
        if (ba.ajx()) {
          com.tencent.mm.bk.d.aMo().remove(locall.Kmn);
        }
        this.KjE = null;
      }
      if (this.KjF != null) {
        this.KjF = null;
      }
      if (this.KjG != null) {
        this.KjG = null;
      }
      if (this.KjJ != null) {
        this.KjJ = null;
      }
      if (this.KjI != null) {
        this.KjI = null;
      }
      AppMethodBeat.o(37634);
    }
    
    public final void fuL()
    {
      AppMethodBeat.i(37638);
      ad.v("MicroMsg.AddressUI", "request to top");
      if (this.uXc != null)
      {
        Object localObject1 = this.uXc;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      }
      AppMethodBeat.o(37638);
    }
    
    public final void fuM()
    {
      AppMethodBeat.i(37636);
      if (this.Kjv != null)
      {
        a locala = this.Kjv;
        locala.Kjg.clear();
        locala.Kje.clear();
        locala.Kjf = false;
      }
      ad.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.KjF != null) {
        this.KjF.destroyDrawingCache();
      }
      if (this.KjG != null) {
        this.KjG.destroyDrawingCache();
      }
      if (this.KjI != null) {
        this.KjI.destroyDrawingCache();
      }
      if (this.KjJ != null) {
        this.KjJ.destroyDrawingCache();
      }
      if (this.KjK != null) {
        this.KjK.destroyDrawingCache();
      }
      if (this.KjE != null) {
        this.KjE.destroyDrawingCache();
      }
      AppMethodBeat.o(37636);
    }
    
    public final void fuN()
    {
      AppMethodBeat.i(37637);
      ad.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      AppMethodBeat.o(37637);
    }
    
    public final void fvQ()
    {
      AppMethodBeat.i(37639);
      if (this.KjE != null) {
        l.fHY();
      }
      AppMethodBeat.o(37639);
    }
    
    public final void fvR() {}
    
    public int getLayoutId()
    {
      return 2131492947;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37622);
      com.tencent.mm.kiss.a.b.akC();
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
      AppMethodBeat.i(194533);
      super.onConfigurationChanged(paramConfiguration);
      fvE();
      AppMethodBeat.o(194533);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(37623);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.IbL.c(this.AkQ);
      AppMethodBeat.o(37623);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37626);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(this.Kjy);
      if (localam == null)
      {
        ad.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.Kjy);
        AppMethodBeat.o(37626);
        return;
      }
      if (u.aAm().equals(localam.field_username))
      {
        AppMethodBeat.o(37626);
        return;
      }
      if (w.zB(this.Kjy))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localam.adv()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37626);
        return;
      }
      if ((w.zQ(this.Kjy)) || (w.Ag(this.Kjy)))
      {
        AppMethodBeat.o(37626);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localam.adv()));
      if ((com.tencent.mm.o.b.lM(localam.field_type)) && (localam.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37626);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37635);
      super.onDestroy();
      com.tencent.mm.sdk.b.a.IbL.d(this.AkQ);
      AppMethodBeat.o(37635);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37627);
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if (!bt.jh(getContext()))
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
    
    public final void yj(boolean paramBoolean)
    {
      AppMethodBeat.i(37624);
      if (this.KjA != null)
      {
        if (this.rjd == null)
        {
          this.rjd = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.rjd.setDuration(200L);
        }
        if (this.wnV == null)
        {
          this.wnV = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.wnV.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.KjA.getVisibility() != 0)
          {
            this.KjA.setVisibility(0);
            this.KjA.startAnimation(this.rjd);
            AppMethodBeat.o(37624);
          }
        }
        else if (4 != this.KjA.getVisibility())
        {
          this.KjA.setVisibility(8);
          this.KjA.startAnimation(this.wnV);
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