package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI$AddressUIFragment
  extends AbstractTabChildActivity.AbStractTabFragment
  implements com.tencent.mm.ai.f
{
  private BizContactEntranceView AaA;
  private b AaB;
  private b AaC;
  private b AaD;
  private ContactCountView AaE;
  private v AaF;
  private i AaG;
  boolean AaH;
  private boolean AaI;
  private LinearLayout AaJ;
  private Animation AaK;
  private VerticalScrollBar.a AaL;
  List<String> AaM;
  private Runnable AaN;
  private TextView Aao;
  private TextView Aap;
  private a Aaq;
  private com.tencent.mm.ui.voicesearch.b Aar;
  private String Aas;
  private String Aat;
  private int Aau;
  private AlphabetScrollBar Aav;
  private LinearLayout Aaw;
  private boolean Aax;
  private boolean Aay;
  private k Aaz;
  private final long TIME_INTERVAL;
  private ProgressDialog eeN;
  com.tencent.mm.pluginsdk.ui.d efo;
  List<String> ejc;
  private TextView gwa;
  private boolean gzX;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private n.d lNZ;
  private Animation mjV;
  private ListView nYW;
  private com.tencent.mm.sdk.b.c rXM;
  private String zZK;
  private String zZL;
  
  public AddressUI$AddressUIFragment()
  {
    AppMethodBeat.i(33507);
    this.eeN = null;
    this.Aat = "";
    this.Aaw = null;
    this.Aax = false;
    this.gzX = false;
    this.Aay = false;
    this.AaI = true;
    this.TIME_INTERVAL = 180000L;
    this.rXM = new AddressUI.AddressUIFragment.1(this);
    this.lNZ = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(33490);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(33490);
          return;
        case 1: 
        case 2: 
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
          AppMethodBeat.o(33490);
          return;
        }
        AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this, AddressUI.AddressUIFragment.n(AddressUI.AddressUIFragment.this));
        AppMethodBeat.o(33490);
      }
    };
    this.AaL = new VerticalScrollBar.a()
    {
      public final void lf(String paramAnonymousString)
      {
        int i = 0;
        AppMethodBeat.i(33491);
        if (AddressUI.AddressUIFragment.this.getString(2131302955).equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(33491);
          return;
        }
        Object localObject = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this);
        ab.v("MicroMsg.AddressAdapter", "getSections");
        localObject = ((a)localObject).zZQ;
        if (localObject == null)
        {
          AppMethodBeat.o(33491);
          return;
        }
        if ("↑".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(0);
          AppMethodBeat.o(33491);
          return;
        }
        if ("☆".equals(paramAnonymousString))
        {
          AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setSelection(AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          AppMethodBeat.o(33491);
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
        AppMethodBeat.o(33491);
        return;
        AppMethodBeat.o(33491);
      }
    };
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new AddressUI.AddressUIFragment.10(this));
    this.ejc = new LinkedList();
    this.AaM = new LinkedList();
    this.AaN = new AddressUI.AddressUIFragment.17(this);
    AppMethodBeat.o(33507);
  }
  
  private void dLE()
  {
    AppMethodBeat.i(33513);
    this.ejc = new LinkedList();
    this.AaM = new LinkedList();
    com.tencent.mm.bq.d.dpU();
    this.ejc.add("tmessage");
    this.AaM.addAll(this.ejc);
    if (!this.ejc.contains("officialaccounts")) {
      this.ejc.add("officialaccounts");
    }
    this.ejc.add("helper_entry");
    if (this.Aaq != null) {
      this.Aaq.ft(this.ejc);
    }
    if (this.Aar != null) {
      this.Aar.ft(this.AaM);
    }
    AppMethodBeat.o(33513);
  }
  
  private void dLF()
  {
    try
    {
      AppMethodBeat.i(33517);
      long l = System.currentTimeMillis();
      dLE();
      ab.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
      if (this.Aaq != null)
      {
        ab.v("MicroMsg.AddressUI", "post to do refresh");
        al.d(new AddressUI.AddressUIFragment.11(this));
      }
      if (this.Aar != null) {
        al.d(new AddressUI.AddressUIFragment.13(this));
      }
      ab.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
      AppMethodBeat.o(33517);
      return;
    }
    finally {}
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(156143);
    int j = am.di(getContext());
    int i = am.K(getContext(), -1);
    View localView = getView().getRootView().findViewById(2131820956);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool = LauncherUI.getInstance().isInMultiWindowMode();; bool = false)
    {
      if (bool) {
        if (localView == null) {
          break label111;
        }
      }
      label111:
      for (i = localView.getTop();; i = 0)
      {
        ab.i("MicroMsg.AddressUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
        AppMethodBeat.o(156143);
        return i + j;
      }
    }
  }
  
  public final void dAA() {}
  
  public final void dAB()
  {
    AppMethodBeat.i(33518);
    ab.i("MicroMsg.AddressUI", "AddressUI on Pause");
    com.tencent.mm.model.aw.aaz();
    com.tencent.mm.model.c.Ru().set(340226, Long.valueOf(System.currentTimeMillis()));
    com.tencent.mm.model.aw.aaz();
    com.tencent.mm.model.c.Ru().set(12296, Boolean.valueOf(this.Aax));
    if (this.Aar != null) {
      this.Aar.onPause();
    }
    this.Aaq.dLC();
    al.d(new AddressUI.AddressUIFragment.18(this));
    if (this.Aaz != null) {
      this.Aaz.setFrontGround(false);
    }
    LauncherUI localLauncherUI = (LauncherUI)getContext();
    if (localLauncherUI != null) {
      localLauncherUI.getHomeUI().av(this.AaN);
    }
    AppMethodBeat.o(33518);
  }
  
  public final void dAC() {}
  
  public final void dAD()
  {
    AppMethodBeat.i(33519);
    ab.v("MicroMsg.AddressUI", "onDestory");
    if (this.Aav != null) {
      this.Aav.zpW = null;
    }
    com.tencent.mm.model.aw.Rc().b(138, this);
    if (this.Aaq != null)
    {
      this.Aaq.qd(true);
      this.Aaq.detach();
      this.Aaq.dAW();
    }
    if (this.Aar != null)
    {
      this.Aar.detach();
      this.Aar.bKb();
    }
    if ((com.tencent.mm.model.aw.RG()) && (this.Aaq != null))
    {
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YA().b(this.Aaq);
    }
    if ((com.tencent.mm.model.aw.RG()) && (this.AaG != null)) {
      com.tencent.mm.aj.z.afi().a(this.AaG);
    }
    if (this.Aaz != null)
    {
      k localk = this.Aaz;
      if (com.tencent.mm.model.aw.RG()) {
        com.tencent.mm.bi.d.ali().remove(localk.AcO);
      }
      this.Aaz = null;
    }
    if (this.AaA != null) {
      this.AaA = null;
    }
    if (this.AaB != null) {
      this.AaB = null;
    }
    if (this.AaD != null) {
      this.AaD = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.rXM);
    AppMethodBeat.o(33519);
  }
  
  public final void dAE()
  {
    AppMethodBeat.i(33522);
    ab.v("MicroMsg.AddressUI", "request to top");
    if (this.nYW != null) {
      BackwardSupportUtil.c.a(this.nYW);
    }
    AppMethodBeat.o(33522);
  }
  
  public final void dAF()
  {
    AppMethodBeat.i(33520);
    if (this.Aaq != null)
    {
      a locala = this.Aaq;
      locala.Aab.clear();
      locala.zZZ.clear();
      locala.Aaa = false;
    }
    ab.i("MicroMsg.INIT", "KEVIN Address turnTobg");
    if (this.AaA != null) {
      this.AaA.destroyDrawingCache();
    }
    if (this.AaB != null) {
      this.AaB.destroyDrawingCache();
    }
    if (this.AaD != null) {
      this.AaD.destroyDrawingCache();
    }
    if (this.AaE != null) {
      this.AaE.destroyDrawingCache();
    }
    if (this.Aaz != null) {
      this.Aaz.destroyDrawingCache();
    }
    AppMethodBeat.o(33520);
  }
  
  public final void dAG()
  {
    AppMethodBeat.i(33521);
    ab.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    AppMethodBeat.o(33521);
  }
  
  public final void dAy()
  {
    AppMethodBeat.i(33515);
    ab.v("MicroMsg.AddressUI", "address ui on create");
    ab.v("MicroMsg.AddressUI", "on address ui create");
    this.Aax = false;
    this.gzX = false;
    this.Aay = false;
    this.zZK = null;
    this.zZL = null;
    this.Aas = null;
    com.tencent.mm.model.aw.Rc().a(138, this);
    this.zZK = "@all.contact.without.chatroom.without.openim";
    this.zZL = getStringExtra("Contact_GroupFilter_Str");
    this.Aas = getString(2131300543);
    this.Aau = getIntExtra("List_Type", 2);
    Object localObject1 = getView().getRootView().findViewById(2131820634);
    int i = am.di(getContext());
    int j = am.K(getContext(), -1);
    Object localObject2 = new AddressUI.AddressUIFragment.12(this, (View)localObject1);
    if (j <= 0)
    {
      getView().post((Runnable)localObject2);
      ab.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.nYW != null)
      {
        if (this.Aaz != null) {
          this.nYW.removeHeaderView(this.Aaz);
        }
        if (this.AaA != null) {
          this.nYW.removeHeaderView(this.AaA);
        }
        if (this.AaB != null) {
          this.nYW.removeHeaderView(this.AaB);
        }
        if (this.AaD != null) {
          this.nYW.removeHeaderView(this.AaD);
        }
      }
      this.nYW = ((ListView)findViewById(2131821074));
      this.nYW.setScrollingCacheEnabled(false);
      this.Aao = ((TextView)findViewById(2131821076));
      this.Aao.setText(2131296461);
      this.gwa = ((TextView)findViewById(2131821075));
      this.gwa.setText(2131296463);
      this.Aap = ((TextView)findViewById(2131821078));
      this.Aap.setOnClickListener(new AddressUI.AddressUIFragment.19(this));
      this.Aaq = new a(getContext(), this.zZK, this.zZL, this.Aau);
      this.nYW.setAdapter(null);
      this.Aaq.a(new AddressUI.AddressUIFragment.20(this));
      this.Aaq.zZX = true;
      this.Aaq.setFragment(this);
      this.Aaq.setGetViewPositionCallback(new AddressUI.AddressUIFragment.21(this));
      this.Aaq.setPerformItemClickListener(new AddressUI.AddressUIFragment.22(this));
      this.Aaq.a(new AddressUI.AddressUIFragment.23(this));
      this.Aar = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.Aar.rz(true);
      this.AaJ = new LinearLayout(getContext());
      this.AaJ.setOrientation(1);
      this.nYW.addHeaderView(this.AaJ);
      this.AaC = new b(getContext(), b.a.AaU);
      this.AaJ.addView(this.AaC);
      com.tencent.mm.model.aw.aaz();
      ((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAp, Boolean.FALSE)).booleanValue();
      this.AaC.setVisible(false);
      this.Aaz = new k(getContext());
      this.AaJ.addView(this.Aaz);
      this.AaB = new b(getContext(), b.a.AaS);
      this.AaJ.addView(this.AaB);
      this.AaB.setVisible(true);
      this.AaD = new b(getContext(), b.a.AaT);
      this.AaJ.addView(this.AaD);
      this.AaD.setVisible(true);
      localObject1 = this.nYW;
      localObject2 = new ContactCountView(getContext());
      this.AaE = ((ContactCountView)localObject2);
      ((ListView)localObject1).addFooterView((View)localObject2, null, false);
      if (com.tencent.mm.bq.d.ahR("brandservice"))
      {
        this.AaA = new BizContactEntranceView(getContext());
        this.AaJ.addView(this.AaA);
        this.AaA.setVisible(true);
      }
      localObject1 = new AddressUI.AddressUIFragment.24(this);
      this.AaF = new v(getContext(), new AddressUI.AddressUIFragment.25(this));
      this.AaF.setOnVisibilityChangeListener((v.b)localObject1);
      if (this.AaF.getOpenIMCount() > 0) {
        break label1139;
      }
      ((v.b)localObject1).rf(false);
      this.AaF.setVisibility(8);
    }
    for (;;)
    {
      this.AaJ.addView(this.AaF);
      if (com.tencent.mm.bq.d.ahR("brandservice"))
      {
        this.AaG = new i(getContext(), new AddressUI.AddressUIFragment.2(this));
        if (this.AaG.getEnterpriseFriendCount() <= 0) {
          this.AaG.setVisibility(8);
        }
        this.AaJ.addView(this.AaG);
      }
      this.jVd = new com.tencent.mm.ui.widget.c.a(getContext());
      this.Aaq.zZV = new AddressUI.AddressUIFragment.3(this);
      this.nYW.setOnItemClickListener(new AddressUI.AddressUIFragment.4(this));
      this.nYW.setOnItemLongClickListener(new AddressUI.AddressUIFragment.5(this));
      this.nYW.setOnTouchListener(new AddressUI.AddressUIFragment.6(this));
      this.nYW.setOnScrollListener(this.efo);
      this.nYW.setDrawingCacheEnabled(false);
      this.Aav = ((AlphabetScrollBar)findViewById(2131821077));
      this.Aav.setOnScrollBarTouchListener(this.AaL);
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YA().a(this.Aaq);
      if (this.AaG != null) {
        com.tencent.mm.aj.z.afi().a(this.AaG, null);
      }
      AppMethodBeat.o(33515);
      return;
      int k = getTopHeight();
      getView().setPadding(0, k, 0, ((View)localObject1).getHeight());
      ab.i("MicroMsg.AddressUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed((Runnable)localObject2, 100L);
      break;
      label1139:
      ((v.b)localObject1).rf(true);
    }
  }
  
  public final void dAz()
  {
    AppMethodBeat.i(33516);
    ab.v("MicroMsg.AddressUI", "address ui on resume");
    long l = System.currentTimeMillis();
    com.tencent.mm.model.aw.aaz();
    if (l - ah.d((Long)com.tencent.mm.model.c.Ru().get(340226, null)) >= 180000L) {
      dLG();
    }
    Object localObject;
    if (this.AaI)
    {
      this.AaI = false;
      this.AaH = false;
      dLE();
      this.nYW.setAdapter(this.Aaq);
      this.nYW.post(new AddressUI.AddressUIFragment.14(this));
      this.Aar.ry(false);
      if (this.AaA != null)
      {
        localObject = this.AaA;
        ((BizContactEntranceView)localObject).dLH();
        ((BizContactEntranceView)localObject).setVisible(true);
      }
      if (this.AaG != null)
      {
        if (this.AaG.getEnterpriseFriendCount() > 0) {
          break label405;
        }
        this.AaG.setVisibility(8);
      }
    }
    for (;;)
    {
      com.tencent.mm.model.aw.aaz();
      this.Aax = ((Boolean)com.tencent.mm.model.c.Ru().get(12296, Boolean.FALSE)).booleanValue();
      if (this.Aau == 2)
      {
        com.tencent.mm.model.aw.aaz();
        localObject = com.tencent.mm.model.c.YA().arw(r.Zn());
        if ((localObject != null) && ((!com.tencent.mm.n.a.je(((aq)localObject).field_type)) || (!ah.isNullOrNil(((aq)localObject).field_conRemark)) || (!ah.isNullOrNil(((aq)localObject).field_conRemarkPYFull)) || (!ah.isNullOrNil(((aq)localObject).field_conRemarkPYShort))))
        {
          ((ad)localObject).Nx();
          ((ad)localObject).jn("");
          ((ad)localObject).jt("");
          ((ad)localObject).ju("");
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.YA().b(r.Zn(), (ad)localObject);
        }
      }
      if (this.Aar != null) {
        this.Aar.onResume();
      }
      this.Aaq.yVE = false;
      al.d(new AddressUI.AddressUIFragment.16(this));
      if (this.Aaz != null)
      {
        this.Aaz.setFrontGround(true);
        k.dLS();
      }
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.AaN);
      }
      AppMethodBeat.o(33516);
      return;
      if (!this.AaH) {
        break;
      }
      this.AaH = false;
      com.tencent.mm.sdk.g.d.f(new AddressUI.AddressUIFragment.15(this), "AddressUI_updateUIData");
      this.AaE.dLJ();
      break;
      label405:
      this.AaG.setVisibility(0);
    }
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(33523);
    if (this.Aaz != null) {
      k.dLS();
    }
    AppMethodBeat.o(33523);
  }
  
  public final void dBD() {}
  
  public final void dLG()
  {
    AppMethodBeat.i(33524);
    if (this.nYW != null) {
      this.nYW.setSelection(0);
    }
    AppMethodBeat.o(33524);
  }
  
  public int getLayoutId()
  {
    return 2130968639;
  }
  
  public View getLayoutView()
  {
    AppMethodBeat.i(33508);
    com.tencent.mm.kiss.a.b.SH();
    View localView = com.tencent.mm.kiss.a.b.b(getContext(), 2130968639);
    AppMethodBeat.o(33508);
    return localView;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(33514);
    ab.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
    if ((paramInt1 == 6) && (paramInt2 == -1))
    {
      setResult(-1);
      finish();
      AppMethodBeat.o(33514);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33514);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33514);
      return;
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33509);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.c(this.rXM);
    AppMethodBeat.o(33509);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33511);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    com.tencent.mm.model.aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(this.Aat);
    if (localad == null)
    {
      ab.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.Aat);
      AppMethodBeat.o(33511);
      return;
    }
    if (r.Zn().equals(localad.field_username))
    {
      AppMethodBeat.o(33511);
      return;
    }
    if (t.nR(this.Aat))
    {
      paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Of()));
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131296458);
      AppMethodBeat.o(33511);
      return;
    }
    if ((t.og(this.Aat)) || (t.ow(this.Aat)))
    {
      AppMethodBeat.o(33511);
      return;
    }
    paramContextMenu.setHeaderTitle(j.b(paramView.getContext(), localad.Of()));
    if ((com.tencent.mm.n.a.je(localad.field_type)) && (localad.field_deleteFlag != 1)) {
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131298670);
    }
    AppMethodBeat.o(33511);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33512);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (!ah.cB(getContext()))
    {
      AppMethodBeat.o(33512);
      return;
    }
    if (v.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(33512);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(33512);
      return;
    }
    AppMethodBeat.o(33512);
  }
  
  public final void re(boolean paramBoolean)
  {
    AppMethodBeat.i(33510);
    if (this.Aav != null)
    {
      if (this.mjV == null)
      {
        this.mjV = AnimationUtils.loadAnimation(getContext(), 2131034173);
        this.mjV.setDuration(200L);
      }
      if (this.AaK == null)
      {
        this.AaK = AnimationUtils.loadAnimation(getContext(), 2131034173);
        this.AaK.setDuration(200L);
      }
      if (paramBoolean)
      {
        if (this.Aav.getVisibility() != 0)
        {
          this.Aav.setVisibility(0);
          this.Aav.startAnimation(this.mjV);
          AppMethodBeat.o(33510);
        }
      }
      else if (4 != this.Aav.getVisibility())
      {
        this.Aav.setVisibility(8);
        this.Aav.startAnimation(this.AaK);
      }
    }
    AppMethodBeat.o(33510);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI.AddressUIFragment
 * JD-Core Version:    0.7.0.1
 */