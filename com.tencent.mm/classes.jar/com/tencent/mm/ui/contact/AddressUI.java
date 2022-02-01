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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.f.a;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment IsM;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.IsM = new AddressUIFragment();
      this.IsM.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.IsM).commit();
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
    implements com.tencent.mm.ak.g
  {
    private TextView IsN;
    private TextView IsO;
    private a IsP;
    private com.tencent.mm.ui.voicesearch.b IsQ;
    private String IsR;
    private String IsS;
    private int IsT;
    private AlphabetScrollBar IsU;
    private LinearLayout IsV;
    private boolean IsW;
    private boolean IsX;
    private l IsY;
    private BizContactEntranceView IsZ;
    private String Isk;
    private String Isl;
    private b Ita;
    private b Itb;
    private b Itc;
    private b Itd;
    private ContactCountView Ite;
    private y Itf;
    private j Itg;
    boolean Ith;
    private boolean Iti;
    private LinearLayout Itj;
    private VerticalScrollBar.a Itk;
    List<String> Itl;
    private Runnable Itm;
    com.tencent.mm.pluginsdk.ui.d ftW;
    private ProgressDialog fts;
    List<String> fzw;
    private final long hYc;
    private TextView iJe;
    private boolean iNn;
    private int nwY;
    private int nwZ;
    private com.tencent.mm.ui.widget.b.a nym;
    private n.d pHX;
    private Animation qzo;
    private ListView tUA;
    private Animation viC;
    private com.tencent.mm.sdk.b.c yTj;
    
    public AddressUIFragment()
    {
      AppMethodBeat.i(37621);
      this.fts = null;
      this.IsS = "";
      this.IsV = null;
      this.IsW = false;
      this.iNn = false;
      this.IsX = false;
      this.Iti = true;
      this.hYc = 180000L;
      this.yTj = new com.tencent.mm.sdk.b.c() {};
      this.pHX = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(196733);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(196733);
            return;
          case 1: 
          case 2: 
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(196733);
            return;
          }
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.o(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(196733);
        }
      };
      this.Itk = new VerticalScrollBar.a()
      {
        public final void sn(String paramAnonymousString)
        {
          int i = 0;
          AppMethodBeat.i(196734);
          if (AddressUI.AddressUIFragment.this.getString(2131762893).equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(196734);
            return;
          }
          Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
          ac.v("MicroMsg.AddressAdapter", "getSections");
          localObject = ((a)localObject).Isq;
          if (localObject == null)
          {
            AppMethodBeat.o(196734);
            return;
          }
          if ("↑".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
            AppMethodBeat.o(196734);
            return;
          }
          if ("☆".equals(paramAnonymousString))
          {
            AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            AppMethodBeat.o(196734);
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
          AppMethodBeat.o(196734);
          return;
          AppMethodBeat.o(196734);
        }
      };
      this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(196735);
          if (paramAnonymousInt1 < 2)
          {
            AppMethodBeat.o(196735);
            return;
          }
          if (!AddressUI.AddressUIFragment.p(AddressUI.AddressUIFragment.this)) {
            AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this);
          }
          AppMethodBeat.o(196735);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(196736);
          if (paramAnonymousInt == 2) {
            com.tencent.mm.cj.d.feq().fW(AddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(196736);
        }
      });
      this.fzw = new LinkedList();
      this.Itl = new LinkedList();
      this.Itm = new Runnable()
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
    
    private void ffv()
    {
      AppMethodBeat.i(196741);
      final View localView = getView().getRootView().findViewById(2131301338);
      int i = com.tencent.mm.ui.ap.dT(getContext());
      int j = com.tencent.mm.ui.ap.Q(getContext(), -1);
      Runnable local12 = new Runnable()
      {
        int gLY = 0;
        
        public final void run()
        {
          AppMethodBeat.i(37608);
          if (AddressUI.AddressUIFragment.this.getView() == null)
          {
            AppMethodBeat.o(37608);
            return;
          }
          int i = com.tencent.mm.ui.ap.dT(AddressUI.AddressUIFragment.this.getContext());
          int j = com.tencent.mm.ui.ap.Q(AddressUI.AddressUIFragment.this.getContext(), -1);
          if (j <= 0) {
            if (this.gLY < 2)
            {
              ac.i("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight again!");
              AddressUI.AddressUIFragment.this.getView().post(this);
              this.gLY += 1;
            }
          }
          for (;;)
          {
            ac.i("MicroMsg.AddressUI", "[trySetParentViewPadding] tryCount:%s actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(this.gLY), Integer.valueOf(j), Integer.valueOf(i) });
            AppMethodBeat.o(37608);
            return;
            ac.e("MicroMsg.AddressUI", "[trySetParentViewPadding] try getStatusHeight finally!");
            break;
            int k = AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this);
            if (k != AddressUI.AddressUIFragment.this.getView().getPaddingTop())
            {
              ac.i("MicroMsg.AddressUI", "[trySetParentViewPadding] now:%s old:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(AddressUI.AddressUIFragment.this.getView().getPaddingTop()) });
              AddressUI.AddressUIFragment.this.getView().setPadding(0, k, 0, localView.getHeight());
            }
            else
            {
              ac.i("MicroMsg.AddressUI", "[trySetParentViewPadding] has try more once! it's right! actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            }
          }
        }
      };
      if (j <= 0)
      {
        getView().post(local12);
        AppMethodBeat.o(196741);
        return;
      }
      int k = getTopHeight();
      getView().setPadding(0, k, 0, localView.getHeight());
      ac.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed(local12, 100L);
      AppMethodBeat.o(196741);
    }
    
    private void fqR()
    {
      AppMethodBeat.i(37628);
      this.fzw = new LinkedList();
      this.Itl = new LinkedList();
      com.tencent.mm.br.d.eQD();
      this.fzw.add("tmessage");
      this.Itl.addAll(this.fzw);
      if (!this.fzw.contains("officialaccounts")) {
        this.fzw.add("officialaccounts");
      }
      this.fzw.add("helper_entry");
      if (this.IsP != null) {
        this.IsP.ic(this.fzw);
      }
      if (this.IsQ != null) {
        this.IsQ.ic(this.Itl);
      }
      AppMethodBeat.o(37628);
    }
    
    private void fqS()
    {
      try
      {
        AppMethodBeat.i(37632);
        long l = System.currentTimeMillis();
        fqR();
        ac.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.IsP != null)
        {
          ac.v("MicroMsg.AddressUI", "post to do refresh");
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37609);
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fqQ();
              if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) {
                AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).reset();
              }
              AppMethodBeat.o(37609);
            }
          });
        }
        if (this.IsQ != null) {
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37610);
              ac.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37610);
            }
          });
        }
        ac.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(37632);
        return;
      }
      finally {}
    }
    
    private int getTopHeight()
    {
      AppMethodBeat.i(37625);
      int j = com.tencent.mm.ui.ap.dT(getContext());
      int i = com.tencent.mm.ui.ap.Q(getContext(), -1);
      View localView = getView().getRootView().findViewById(2131296345);
      if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
      for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
      {
        SharedPreferences localSharedPreferences;
        if (!bool1)
        {
          localSharedPreferences = com.tencent.mm.sdk.platformtools.ai.eUY();
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
            ac.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
            AppMethodBeat.o(37625);
            return i + j;
          }
        }
      }
    }
    
    public final void feA() {}
    
    public final void feB()
    {
      AppMethodBeat.i(37633);
      ac.i("MicroMsg.AddressUI", "AddressUI on Pause");
      az.ayM();
      com.tencent.mm.model.c.agA().set(340226, Long.valueOf(System.currentTimeMillis()));
      az.ayM();
      com.tencent.mm.model.c.agA().set(12296, Boolean.valueOf(this.IsW));
      if (this.IsQ != null) {
        this.IsQ.onPause();
      }
      this.IsP.fqP();
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196737);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
          AppMethodBeat.o(196737);
        }
      });
      if (this.IsY != null) {
        this.IsY.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.getHomeUI().aH(this.Itm);
      }
      AppMethodBeat.o(37633);
    }
    
    public final void feC() {}
    
    public final void feD()
    {
      AppMethodBeat.i(37634);
      ac.v("MicroMsg.AddressUI", "onDestory");
      if (this.IsU != null) {
        this.IsU.HDk = null;
      }
      az.agi().b(138, this);
      if (this.IsP != null)
      {
        this.IsP.wn(true);
        this.IsP.detach();
        this.IsP.feY();
      }
      if (this.IsQ != null)
      {
        this.IsQ.detach();
        this.IsQ.cVi();
      }
      if ((az.agM()) && (this.IsP != null))
      {
        az.ayM();
        com.tencent.mm.model.c.awB().b(this.IsP);
      }
      if ((az.agM()) && (this.Itg != null)) {
        af.aCW().a(this.Itg);
      }
      if (this.IsY != null)
      {
        l locall = this.IsY;
        if (az.agM()) {
          com.tencent.mm.bj.d.aJe().remove(locall.IvH);
        }
        this.IsY = null;
      }
      if (this.IsZ != null) {
        this.IsZ = null;
      }
      if (this.Ita != null) {
        this.Ita = null;
      }
      if (this.Itd != null) {
        this.Itd = null;
      }
      if (this.Itc != null) {
        this.Itc = null;
      }
      AppMethodBeat.o(37634);
    }
    
    public final void feE()
    {
      AppMethodBeat.i(37638);
      ac.v("MicroMsg.AddressUI", "request to top");
      if (this.tUA != null)
      {
        Object localObject1 = this.tUA;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      }
      AppMethodBeat.o(37638);
    }
    
    public final void feF()
    {
      AppMethodBeat.i(37636);
      if (this.IsP != null)
      {
        a locala = this.IsP;
        locala.IsB.clear();
        locala.Isz.clear();
        locala.IsA = false;
      }
      ac.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.IsZ != null) {
        this.IsZ.destroyDrawingCache();
      }
      if (this.Ita != null) {
        this.Ita.destroyDrawingCache();
      }
      if (this.Itc != null) {
        this.Itc.destroyDrawingCache();
      }
      if (this.Itd != null) {
        this.Itd.destroyDrawingCache();
      }
      if (this.Ite != null) {
        this.Ite.destroyDrawingCache();
      }
      if (this.IsY != null) {
        this.IsY.destroyDrawingCache();
      }
      AppMethodBeat.o(37636);
    }
    
    public final void feG()
    {
      AppMethodBeat.i(37637);
      ac.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      AppMethodBeat.o(37637);
    }
    
    public final void fey()
    {
      AppMethodBeat.i(37630);
      ac.v("MicroMsg.AddressUI", "address ui on create");
      ac.v("MicroMsg.AddressUI", "on address ui create");
      this.IsW = false;
      this.iNn = false;
      this.IsX = false;
      this.Isk = null;
      this.Isl = null;
      this.IsR = null;
      az.agi().a(138, this);
      this.Isk = "@all.contact.without.chatroom.without.openim";
      this.Isl = getStringExtra("Contact_GroupFilter_Str");
      this.IsR = getString(2131760134);
      this.IsT = getIntExtra("List_Type", 2);
      ffv();
      ac.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.tUA != null)
      {
        if (this.IsY != null) {
          this.tUA.removeHeaderView(this.IsY);
        }
        if (this.IsZ != null) {
          this.tUA.removeHeaderView(this.IsZ);
        }
        if (this.Ita != null) {
          this.tUA.removeHeaderView(this.Ita);
        }
        if (this.Itd != null) {
          this.tUA.removeHeaderView(this.Itd);
        }
        if (this.Itc != null) {
          this.tUA.removeHeaderView(this.Itc);
        }
      }
      this.tUA = ((ListView)findViewById(2131296471));
      this.tUA.setScrollingCacheEnabled(false);
      this.IsN = ((TextView)findViewById(2131299460));
      this.IsN.setText(2131755193);
      this.iJe = ((TextView)findViewById(2131299481));
      this.iJe.setText(2131755195);
      this.IsO = ((TextView)findViewById(2131299499));
      this.IsO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37615);
          AppMethodBeat.o(37615);
        }
      });
      this.IsP = new a(getContext(), this.Isk, this.Isl, this.IsT);
      this.tUA.setAdapter(null);
      this.IsP.a(new f.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(37616);
          AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
          AddressUI.AddressUIFragment.c(localAddressUIFragment);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).fqO();
          AppMethodBeat.o(37616);
        }
        
        public final void ffk() {}
      });
      this.IsP.Isx = true;
      this.IsP.setFragment(this);
      this.IsP.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
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
      this.IsP.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37618);
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37618);
        }
      });
      this.IsP.a(new MMSlideDelView.f()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37619);
          if (paramAnonymousObject == null)
          {
            ac.e("MicroMsg.AddressUI", "onItemDel object null");
            AppMethodBeat.o(37619);
            return;
          }
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37619);
        }
      });
      this.IsQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.IsQ.xU(true);
      this.Itj = new LinearLayout(getContext());
      this.Itj.setOrientation(1);
      this.tUA.addHeaderView(this.Itj);
      this.Itb = new b(getContext(), b.a.Itu);
      this.Itj.addView(this.Itb);
      az.ayM();
      ((Boolean)com.tencent.mm.model.c.agA().get(ah.a.GGA, Boolean.FALSE)).booleanValue();
      this.Itb.setVisible(false);
      this.IsY = new l(getContext());
      this.Itj.addView(this.IsY);
      this.Itd = new b(getContext(), b.a.Itv);
      this.Itj.addView(this.Itd);
      boolean bool = com.tencent.mm.kernel.g.agR().agA().getBoolean(ah.a.GWx, false);
      if (!bool) {
        com.tencent.e.h.JZN.aT(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196739);
            com.tencent.mm.kernel.g.agS();
            if (((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNC("@social.black.android") > 0)
            {
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWx, Boolean.TRUE);
              AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(196738);
                  AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).setVisible(true);
                  AppMethodBeat.o(196738);
                }
              });
            }
            AppMethodBeat.o(196739);
          }
        });
      }
      Object localObject = this.Itd;
      if (bool)
      {
        bool = true;
        ((b)localObject).setVisible(bool);
        this.Ita = new b(getContext(), b.a.Its);
        this.Itj.addView(this.Ita);
        this.Ita.setVisible(true);
        this.Itc = new b(getContext(), b.a.Itt);
        this.Itj.addView(this.Itc);
        this.Itc.setVisible(true);
        localObject = this.tUA;
        ContactCountView localContactCountView = new ContactCountView(getContext());
        this.Ite = localContactCountView;
        ((ListView)localObject).addFooterView(localContactCountView, null, false);
        if (com.tencent.mm.br.d.aCT("brandservice"))
        {
          this.IsZ = new BizContactEntranceView(getContext());
          this.Itj.addView(this.IsZ);
          this.IsZ.setVisible(true);
        }
        localObject = new y.b()
        {
          public final void xx(boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(196740);
            if (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(196740);
              return;
            }
            BizContactEntranceView localBizContactEntranceView = AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this);
            if (!paramAnonymousBoolean) {}
            for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
            {
              localBizContactEntranceView.xy(paramAnonymousBoolean);
              AppMethodBeat.o(196740);
              return;
            }
          }
        };
        this.Itf = new y(getContext(), new y.a()
        {
          public final void abN(int paramAnonymousInt)
          {
            AppMethodBeat.i(196727);
            if ((AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null))
            {
              AppMethodBeat.o(196727);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(8);
              AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).xy(true);
              AppMethodBeat.o(196727);
              return;
            }
            AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).setVisibility(0);
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).xy(false);
            AppMethodBeat.o(196727);
          }
        });
        this.Itf.setOnVisibilityChangeListener((y.b)localObject);
        if (this.Itf.getOpenIMCount() > 0) {
          break label1109;
        }
        ((y.b)localObject).xx(false);
        this.Itf.setVisibility(8);
      }
      for (;;)
      {
        this.Itj.addView(this.Itf);
        this.Itg = new j(getContext(), new j.a()
        {
          public final void abO(int paramAnonymousInt)
          {
            AppMethodBeat.i(196728);
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null)
            {
              AppMethodBeat.o(196728);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(8);
              AppMethodBeat.o(196728);
              return;
            }
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).setVisibility(0);
            AppMethodBeat.o(196728);
          }
        });
        if (this.Itg.getEnterpriseFriendCount() <= 0) {
          this.Itg.setVisibility(8);
        }
        this.Itj.addView(this.Itg);
        this.nym = new com.tencent.mm.ui.widget.b.a(getContext());
        this.IsP.Isv = new a.a() {};
        this.tUA.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(196729);
            paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
            if (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) == null) {}
            for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).IYA))
            {
              ac.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
              if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.AddressUIFragment.j(AddressUI.AddressUIFragment.this)))) {
                break;
              }
              AppMethodBeat.o(196729);
              return;
            }
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              AppMethodBeat.o(196729);
              return;
            }
            paramAnonymousInt -= AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount();
            Object localObject;
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).IYA))
            {
              boolean bool1 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).GF(paramAnonymousInt);
              boolean bool2 = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).acA(paramAnonymousInt);
              ac.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
              if (bool2)
              {
                AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).aRB("");
                AppMethodBeat.o(196729);
                return;
              }
              if (bool1)
              {
                paramAnonymousView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).acy(paramAnonymousInt);
                paramAnonymousAdapterView = paramAnonymousView.EuE.FEm;
                az.ayM();
                localObject = com.tencent.mm.model.c.awB().aNt(paramAnonymousAdapterView);
                if (com.tencent.mm.n.b.ln(((av)localObject).field_type))
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                  paramAnonymousView.putExtra("Contact_Scene", 3);
                  if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                  {
                    if (((com.tencent.mm.storage.ai)localObject).fad()) {
                      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
                    }
                    e.a(paramAnonymousView, paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                    com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                  AppMethodBeat.o(196729);
                  return;
                }
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.EuE.FEm);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.iJY);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Fbd.FEm);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.iJW);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramAnonymousView.iKc, paramAnonymousView.iJU, paramAnonymousView.iJV));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.iJT);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Fer);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Feq);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Feu);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Fes);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Fet);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.Few.iKe);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.Few.iKg);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.Few.iKf);
                if (paramAnonymousView.Fex != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.Fex.toByteArray());
                  if ((paramAnonymousView.Feq & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                  com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                  AppMethodBeat.o(196729);
                  return;
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ac.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                  }
                }
              }
              paramAnonymousAdapterView = AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).acz(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ac.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                AppMethodBeat.o(196729);
                return;
              }
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (w.xg(paramAnonymousAdapterView))
              {
                paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$13", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(196729);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                com.tencent.mm.br.d.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(196729);
              return;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).Za(paramAnonymousInt);
            if (paramAnonymousAdapterView != null)
            {
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              paramAnonymousView = AddressUI.AddressUIFragment.this;
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
              {
                AppMethodBeat.o(196729);
                return;
              }
              if (w.xg(paramAnonymousAdapterView))
              {
                ac.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
                AppMethodBeat.o(196729);
                return;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
              if (w.wE(paramAnonymousAdapterView)) {
                ((Intent)localObject).putExtra("Is_group_card", true);
              }
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                e.a((Intent)localObject, paramAnonymousAdapterView);
                ((Intent)localObject).putExtra("CONTACT_INFO_UI_SOURCE", 4);
                com.tencent.mm.br.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
            }
            AppMethodBeat.o(196729);
          }
        });
        this.tUA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(196730);
            ac.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
            if (paramAnonymousInt < AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount())
            {
              ac.w("MicroMsg.AddressUI", "on item long click, but match header view");
              AppMethodBeat.o(196730);
              return true;
            }
            if ((AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.i(AddressUI.AddressUIFragment.this).IYA))
            {
              AppMethodBeat.o(196730);
              return true;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).Za(paramAnonymousInt - AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            if (paramAnonymousAdapterView == null)
            {
              ac.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
              AppMethodBeat.o(196730);
              return true;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if ((w.xg(paramAnonymousAdapterView)) || (w.xh(paramAnonymousAdapterView)))
            {
              AppMethodBeat.o(196730);
              return true;
            }
            AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, paramAnonymousAdapterView);
            AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.k(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.l(AddressUI.AddressUIFragment.this), AddressUI.AddressUIFragment.m(AddressUI.AddressUIFragment.this));
            AppMethodBeat.o(196730);
            return true;
          }
        });
        this.tUA.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(196731);
            switch (paramAnonymousMotionEvent.getAction())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(196731);
              return false;
              AddressUI.AddressUIFragment.this.hideVKB();
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
              AddressUI.AddressUIFragment.b(AddressUI.AddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
            }
          }
        });
        this.tUA.setOnScrollListener(this.ftW);
        this.tUA.setDrawingCacheEnabled(false);
        this.IsU = ((AlphabetScrollBar)findViewById(2131296489));
        this.IsU.setOnScrollBarTouchListener(this.Itk);
        az.ayM();
        com.tencent.mm.model.c.awB().a(this.IsP);
        if (this.Itg != null) {
          af.aCW().a(this.Itg, null);
        }
        AppMethodBeat.o(37630);
        return;
        bool = false;
        break;
        label1109:
        ((y.b)localObject).xx(true);
      }
    }
    
    public final void fez()
    {
      AppMethodBeat.i(37631);
      ac.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      az.ayM();
      if (l - bs.a((Long)com.tencent.mm.model.c.agA().get(340226, null), 0L) >= 180000L) {
        fqT();
      }
      Object localObject;
      if (this.Iti)
      {
        this.Iti = false;
        this.Ith = false;
        fqR();
        this.tUA.setAdapter(this.IsP);
        this.tUA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37611);
            ac.i("MicroMsg.AddressUI", "post to first init finish");
            View localView = AddressUI.AddressUIFragment.this.findViewById(2131301512);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.AddressUIFragment.this.getContext(), 2130772048));
            }
            AppMethodBeat.o(37611);
          }
        });
        this.IsQ.xT(false);
        if (this.IsZ != null)
        {
          localObject = this.IsZ;
          ((BizContactEntranceView)localObject).fqV();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.Itg != null)
        {
          if (this.Itg.getEnterpriseFriendCount() > 0) {
            break label406;
          }
          this.Itg.setVisibility(8);
        }
      }
      for (;;)
      {
        az.ayM();
        this.IsW = ((Boolean)com.tencent.mm.model.c.agA().get(12296, Boolean.FALSE)).booleanValue();
        if (this.IsT == 2)
        {
          az.ayM();
          localObject = com.tencent.mm.model.c.awB().aNt(u.axw());
          if ((localObject != null) && ((!com.tencent.mm.n.b.ln(((av)localObject).field_type)) || (!bs.isNullOrNil(((av)localObject).field_conRemark)) || (!bs.isNullOrNil(((av)localObject).field_conRemarkPYFull)) || (!bs.isNullOrNil(((av)localObject).field_conRemarkPYShort))))
          {
            ((com.tencent.mm.storage.ai)localObject).aaf();
            ((com.tencent.mm.storage.ai)localObject).qh("");
            ((com.tencent.mm.storage.ai)localObject).qn("");
            ((com.tencent.mm.storage.ai)localObject).qo("");
            az.ayM();
            com.tencent.mm.model.c.awB().c(u.axw(), (com.tencent.mm.storage.ai)localObject);
          }
        }
        if (this.IsQ != null) {
          this.IsQ.onResume();
        }
        this.IsP.HhQ = false;
        com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37613);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
            AppMethodBeat.o(37613);
          }
        });
        if (this.IsY != null)
        {
          this.IsY.setFrontGround(true);
          l.frl();
        }
        localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.Itm);
        }
        AppMethodBeat.o(37631);
        return;
        if (!this.Ith) {
          break;
        }
        this.Ith = false;
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
        this.Ite.fqX();
        break;
        label406:
        this.Itg.setVisibility(0);
      }
    }
    
    public final void ffG()
    {
      AppMethodBeat.i(37639);
      if (this.IsY != null) {
        l.frl();
      }
      AppMethodBeat.o(37639);
    }
    
    public final void ffH() {}
    
    public final void fqT()
    {
      AppMethodBeat.i(37640);
      if (this.tUA != null) {
        this.tUA.setSelection(0);
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
      com.tencent.mm.kiss.a.b.ahR();
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
      ac.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
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
      AppMethodBeat.i(196742);
      super.onConfigurationChanged(paramConfiguration);
      ffv();
      AppMethodBeat.o(196742);
    }
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(37623);
      super.onCreate(paramBundle);
      com.tencent.mm.sdk.b.a.GpY.c(this.yTj);
      AppMethodBeat.o(37623);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37626);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      az.ayM();
      com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(this.IsS);
      if (localai == null)
      {
        ac.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.IsS);
        AppMethodBeat.o(37626);
        return;
      }
      if (u.axw().equals(localai.field_username))
      {
        AppMethodBeat.o(37626);
        return;
      }
      if (w.wE(this.IsS))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localai.aaS()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37626);
        return;
      }
      if ((w.wT(this.IsS)) || (w.xj(this.IsS)))
      {
        AppMethodBeat.o(37626);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localai.aaS()));
      if ((com.tencent.mm.n.b.ln(localai.field_type)) && (localai.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37626);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37635);
      super.onDestroy();
      com.tencent.mm.sdk.b.a.GpY.d(this.yTj);
      AppMethodBeat.o(37635);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37627);
      if (this.fts != null)
      {
        this.fts.dismiss();
        this.fts = null;
      }
      if (!bs.iX(getContext()))
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
    
    public final void xw(boolean paramBoolean)
    {
      AppMethodBeat.i(37624);
      if (this.IsU != null)
      {
        if (this.qzo == null)
        {
          this.qzo = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.qzo.setDuration(200L);
        }
        if (this.viC == null)
        {
          this.viC = AnimationUtils.loadAnimation(getContext(), 2130772039);
          this.viC.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.IsU.getVisibility() != 0)
          {
            this.IsU.setVisibility(0);
            this.IsU.startAnimation(this.qzo);
            AppMethodBeat.o(37624);
          }
        }
        else if (4 != this.IsU.getVisibility())
        {
          this.IsU.setVisibility(8);
          this.IsU.startAnimation(this.viC);
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