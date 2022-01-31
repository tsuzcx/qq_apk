package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@i
public class NearbyFriendsUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private b.a dZA;
  private com.tencent.mm.sdk.b.c dZC;
  private com.tencent.mm.modelgeo.d dZt;
  boolean eUJ;
  private ListView gAb;
  private List<azr> meE;
  private boolean ofu;
  private boolean ogA;
  private com.tencent.mm.plugin.nearby.a.c pcJ;
  private NearbyFriendsUI.c pcV;
  private com.tencent.mm.plugin.nearby.a.c pcW;
  private com.tencent.mm.plugin.nearby.a.d pcX;
  private Map<String, NearbyFriendsUI.a> pcY;
  private boolean pcZ;
  private String[] pda;
  private int pdb;
  private BindMobileOrQQHeaderView pdc;
  private ViewGroup pdd;
  private View pde;
  private View pdf;
  private boolean pdg;
  private int pdh;
  private boolean pdi;
  private int pdj;
  private View pdk;
  private NearbyFriendsUI.b pdl;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public NearbyFriendsUI()
  {
    AppMethodBeat.i(55467);
    this.tipDialog = null;
    this.meE = new LinkedList();
    this.pcY = new HashMap();
    this.pcZ = false;
    this.pdb = 1;
    this.pdg = false;
    this.pdi = false;
    this.ofu = false;
    this.pdj = 0;
    this.pdk = null;
    this.dZC = new NearbyFriendsUI.1(this);
    this.eUJ = false;
    this.dZA = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(55449);
        if (NearbyFriendsUI.d(NearbyFriendsUI.this))
        {
          AppMethodBeat.o(55449);
          return false;
        }
        NearbyFriendsUI.e(NearbyFriendsUI.this);
        if (NearbyFriendsUI.this.eUJ)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          com.tencent.mm.plugin.report.service.g.Cz(11);
          AppMethodBeat.o(55449);
          return false;
        }
        boolean bool;
        if (paramAnonymousBoolean)
        {
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null) {
            NearbyFriendsUI.f(NearbyFriendsUI.this).setMessage(NearbyFriendsUI.this.getString(2131301754));
          }
          NearbyFriendsUI.a(NearbyFriendsUI.this, new NearbyFriendsUI.b(NearbyFriendsUI.this, paramAnonymousFloat2, paramAnonymousFloat1, (int)paramAnonymousDouble2));
          com.tencent.mm.modelstat.e locale = com.tencent.mm.modelstat.e.akz();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousBoolean = false;
            if (NearbyFriendsUI.g(NearbyFriendsUI.this) != null) {
              break label264;
            }
            bool = false;
            label163:
            locale.a(2001, paramAnonymousBoolean, bool, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
            NearbyFriendsUI.a(NearbyFriendsUI.this, new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.h(NearbyFriendsUI.this), NearbyFriendsUI.i(NearbyFriendsUI.this).fBC, NearbyFriendsUI.i(NearbyFriendsUI.this).fBB, NearbyFriendsUI.i(NearbyFriendsUI.this).accuracy, paramAnonymousInt, "", ""));
            com.tencent.mm.kernel.g.Rc().a(NearbyFriendsUI.b(NearbyFriendsUI.this), 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(55449);
          return false;
          paramAnonymousBoolean = true;
          break;
          label264:
          bool = NearbyFriendsUI.g(NearbyFriendsUI.this).fBM;
          break label163;
          com.tencent.mm.plugin.report.service.g.Cz(11);
          if (NearbyFriendsUI.f(NearbyFriendsUI.this) != null)
          {
            NearbyFriendsUI.f(NearbyFriendsUI.this).dismiss();
            NearbyFriendsUI.a(NearbyFriendsUI.this, null);
          }
          NearbyFriendsUI.this.findViewById(2131826490).setVisibility(0);
          NearbyFriendsUI.j(NearbyFriendsUI.this).setVisibility(8);
          NearbyFriendsUI.k(NearbyFriendsUI.this);
          if ((!NearbyFriendsUI.l(NearbyFriendsUI.this)) && (!com.tencent.mm.modelgeo.d.agR()))
          {
            NearbyFriendsUI.m(NearbyFriendsUI.this);
            com.tencent.mm.ui.base.h.a(NearbyFriendsUI.this, NearbyFriendsUI.this.getString(2131300538), NearbyFriendsUI.this.getString(2131297087), NearbyFriendsUI.this.getString(2131300996), NearbyFriendsUI.this.getString(2131296888), false, new NearbyFriendsUI.8.1(this), null);
          }
        }
      }
    };
    AppMethodBeat.o(55467);
  }
  
  private void bWD()
  {
    AppMethodBeat.i(55470);
    View localView;
    Object localObject;
    int i;
    if (com.tencent.mm.bo.a.dkM())
    {
      if (this.pdk != null)
      {
        this.gAb.removeHeaderView(this.pdk);
        this.pdk = null;
      }
      localView = View.inflate(this, 2130970347, null);
      localObject = (TextView)localView.findViewById(2131824819);
      com.tencent.mm.kernel.g.RJ().QQ();
      i = ((j)com.tencent.mm.kernel.g.E(j.class)).bPN().bbZ();
      if (i != 0) {
        break label119;
      }
      localView.setVisibility(8);
      localView = null;
    }
    for (;;)
    {
      this.pdk = localView;
      if (this.pdk != null) {
        this.gAb.addHeaderView(this.pdk);
      }
      AppMethodBeat.o(55470);
      return;
      label119:
      localView.setVisibility(0);
      ((TextView)localObject).setText(getResources().getQuantityString(2131361819, i, new Object[] { Integer.valueOf(i) }));
      localObject = (ImageView)localView.findViewById(2131824818);
      bf localbf = ((j)com.tencent.mm.kernel.g.E(j.class)).bPN().bPW();
      if (localbf != null) {
        a.b.c((ImageView)localObject, localbf.field_sayhiuser);
      }
      localView.setOnClickListener(new NearbyFriendsUI.9(this));
    }
  }
  
  private void bWE()
  {
    AppMethodBeat.i(55473);
    com.tencent.mm.plugin.nearby.a.gmO.bl(this);
    AppMethodBeat.o(55473);
  }
  
  private void bWF()
  {
    int j = 0;
    AppMethodBeat.i(145835);
    Object localObject1 = new LinkedList();
    int i = 0;
    while (i < this.meE.size())
    {
      if (!NearbyFriendsUI.d.AC(((azr)this.meE.get(i)).gwP)) {
        ((List)localObject1).add(this.meE.get(i));
      }
      i += 1;
    }
    this.meE.clear();
    this.meE = ((List)localObject1);
    ab.i("MicroMsg.NearbyFriend", "insertPoiItemList()");
    label133:
    Object localObject2;
    List localList;
    if (!this.meE.isEmpty())
    {
      i = 1;
      localObject1 = this.pcY.keySet().iterator();
      do
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject1).next();
        } while (i == 0);
        localObject2 = (NearbyFriendsUI.a)this.pcY.get(localObject2);
      } while ((((NearbyFriendsUI.a)localObject2).iqO) || ((((NearbyFriendsUI.a)localObject2).pdr > 0) && (((NearbyFriendsUI.a)localObject2).pdv >= ((NearbyFriendsUI.a)localObject2).pdr)) || (((NearbyFriendsUI.a)localObject2).kxm >= ((NearbyFriendsUI.a)localObject2).pds));
      localList = this.meE;
      if ((((NearbyFriendsUI.a)localObject2).pos >= 0) && (((NearbyFriendsUI.a)localObject2).pos <= this.meE.size())) {
        break label306;
      }
    }
    label306:
    for (int k = this.meE.size();; k = ((NearbyFriendsUI.a)localObject2).pos + j)
    {
      localList.add(k, NearbyFriendsUI.d.d(((NearbyFriendsUI.a)localObject2).id, ((NearbyFriendsUI.a)localObject2).cDz, ((NearbyFriendsUI.a)localObject2).name, ((NearbyFriendsUI.a)localObject2).desc, ((NearbyFriendsUI.a)localObject2).pdu));
      j += 1;
      break label133;
      i = 0;
      break;
    }
    AppMethodBeat.o(145835);
  }
  
  private void getData()
  {
    AppMethodBeat.i(55469);
    this.ofu = false;
    AppCompatActivity localAppCompatActivity = getContext();
    getString(2131297087);
    this.tipDialog = com.tencent.mm.ui.base.h.b(localAppCompatActivity, getString(2131301762), true, new NearbyFriendsUI.7(this));
    this.eUJ = false;
    if (this.dZt != null) {
      this.dZt.a(this.dZA, true);
    }
    AppMethodBeat.o(55469);
  }
  
  public int getLayoutId()
  {
    return 2130970343;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55471);
    this.gAb = ((ListView)findViewById(2131826488));
    this.pcV = new NearbyFriendsUI.c(this, this);
    Object localObject = this.gAb;
    if (this.pdd == null)
    {
      this.pdd = new LinearLayout(this);
      this.pdd.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((LinearLayout)this.pdd).setGravity(17);
    }
    this.pdg = true;
    ((ListView)localObject).addHeaderView(this.pdd);
    localObject = com.tencent.mm.m.g.Nq().getValue("LBSShowBindPhone");
    if ((localObject != null) && (((String)localObject).length() > 0)) {}
    try
    {
      this.pdh = Integer.valueOf((String)localObject).intValue();
      localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, null);
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        this.pdh = 0;
      }
      this.pdj = 0;
      if (com.tencent.mm.model.a.g.abw().pL("3") != null)
      {
        localObject = com.tencent.mm.model.a.g.abw().pL("3").value;
        locala = com.tencent.mm.plugin.account.friend.a.l.aqq();
        if (((String)localObject).equals("0")) {
          this.pdj = 0;
        }
      }
      else
      {
        if (((this.pdh > 0) || (this.pdj > 0)) && (this.pdj != 1))
        {
          this.pdc = new BindMobileOrQQHeaderView(this);
          this.gAb.addHeaderView(this.pdc);
        }
        this.gAb.setAdapter(this.pcV);
        this.gAb.setOnItemClickListener(new NearbyFriendsUI.10(this));
        this.gAb.setOnTouchListener(new NearbyFriendsUI.11(this));
        setBackBtn(new NearbyFriendsUI.12(this));
        setToTop(new NearbyFriendsUI.13(this));
        addIconOptionMenu(0, 2130839668, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(55458);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.b.d(NearbyFriendsUI.this, 1, false);
            paramAnonymousMenuItem.sap = new NearbyFriendsUI.14.1(this);
            paramAnonymousMenuItem.sao = new n.c()
            {
              public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                AppMethodBeat.i(55457);
                paramAnonymous2l.hx(-1, 2131301765);
                paramAnonymous2l.hx(-1, 2131301764);
                paramAnonymous2l.hx(-1, 2131301763);
                paramAnonymous2l.hx(-1, 2131302877);
                paramAnonymous2l.hx(-1, 2131301748);
                AppMethodBeat.o(55457);
              }
            };
            paramAnonymousMenuItem.crd();
            AppMethodBeat.o(55458);
            return true;
          }
        });
        AppMethodBeat.o(55471);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l.a locala;
        this.pdh = 0;
        continue;
        if (localException.equals("2"))
        {
          if (locala == l.a.gxC)
          {
            this.pdj = 2;
            com.tencent.mm.model.a.f.pP("3");
          }
        }
        else if ((localException.equals("1")) && (locala == l.a.gxz))
        {
          this.pdj = 2;
          com.tencent.mm.model.a.f.pP("3");
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(55474);
    ab.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55474);
      return;
      if (paramInt2 == -1)
      {
        this.pcZ = false;
        getData();
        AppMethodBeat.o(55474);
        return;
        if (paramInt2 == -1) {
          finish();
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55468);
    com.tencent.mm.plugin.report.service.g.Cx(11);
    super.onCreate(paramBundle);
    setMMTitle(2131301773);
    com.tencent.mm.kernel.g.Rc().a(148, this);
    com.tencent.mm.kernel.g.Rc().a(376, this);
    com.tencent.mm.kernel.g.Rc().a(1087, this);
    this.dZt = com.tencent.mm.modelgeo.d.agQ();
    initView();
    this.pda = new String[] { getResources().getString(2131301765), getResources().getString(2131301764), getResources().getString(2131301763), getResources().getString(2131302877) };
    this.pdb = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(16386, null), 1);
    Object localObject1;
    int j;
    int i;
    label231:
    Object localObject2;
    if (this.pdb == 3)
    {
      setTitleLogo(0, 2131231426);
      getData();
      if (!aa.dsD()) {
        break label796;
      }
      localObject1 = br.F(((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWi, ""), "lbsads");
      if (localObject1 == null) {
        break label796;
      }
      j = bo.getInt((String)((Map)localObject1).get(".lbsads.$count"), 0);
      if (j <= 0) {
        break label796;
      }
      i = 0;
      if (i >= j) {
        break label674;
      }
      localObject2 = new StringBuilder(".lbsads.lbsad");
      if (i != 0) {
        break label666;
      }
    }
    label666:
    for (paramBundle = "";; paramBundle = Integer.valueOf(i))
    {
      paramBundle = paramBundle;
      localObject2 = new NearbyFriendsUI.a((byte)0);
      ((NearbyFriendsUI.a)localObject2).id = ((String)((Map)localObject1).get(paramBundle + ".$id"));
      ((NearbyFriendsUI.a)localObject2).pos = bo.getInt((String)((Map)localObject1).get(paramBundle + ".$pos"), 0);
      ((NearbyFriendsUI.a)localObject2).pdr = bo.getInt((String)((Map)localObject1).get(paramBundle + ".$close_times"), 0);
      ((NearbyFriendsUI.a)localObject2).pds = bo.getInt((String)((Map)localObject1).get(paramBundle + ".$show_times"), 2147483647);
      ((NearbyFriendsUI.a)localObject2).name = ((String)((Map)localObject1).get(paramBundle + ".name"));
      ((NearbyFriendsUI.a)localObject2).desc = ((String)((Map)localObject1).get(paramBundle + ".desc"));
      ((NearbyFriendsUI.a)localObject2).cDz = ((String)((Map)localObject1).get(paramBundle + ".icon"));
      ((NearbyFriendsUI.a)localObject2).pdt = bo.getInt((String)((Map)localObject1).get(paramBundle + ".jump.$type"), 0);
      ((NearbyFriendsUI.a)localObject2).pdu = ((String)((Map)localObject1).get(paramBundle + ".jump"));
      this.pcY.put(((NearbyFriendsUI.a)localObject2).id, localObject2);
      i += 1;
      break label231;
      if (this.pdb == 4)
      {
        setTitleLogo(0, 2131231425);
        break;
      }
      setTitleLogo(0, 0);
      this.pdb = 1;
      break;
    }
    label674:
    paramBundle = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yLY, null);
    if (paramBundle == null) {}
    for (paramBundle = "";; paramBundle = (String)paramBundle)
    {
      paramBundle = paramBundle.split("\\|");
      j = paramBundle.length;
      i = 0;
      while (i < j)
      {
        localObject1 = paramBundle[i].split(":");
        if (localObject1.length == 3)
        {
          localObject2 = (NearbyFriendsUI.a)this.pcY.get(localObject1[0]);
          if (localObject2 != null)
          {
            ((NearbyFriendsUI.a)localObject2).pdv = bo.getInt(localObject1[1], 0);
            ((NearbyFriendsUI.a)localObject2).kxm = bo.getInt(localObject1[2], 0);
          }
        }
        i += 1;
      }
    }
    label796:
    AppMethodBeat.o(55468);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55477);
    if (this.pdj > 0) {
      com.tencent.mm.model.a.f.pQ("3");
    }
    com.tencent.mm.plugin.report.service.g.Cz(11);
    com.tencent.mm.kernel.g.Rc().b(148, this);
    com.tencent.mm.kernel.g.Rc().b(376, this);
    com.tencent.mm.kernel.g.Rc().b(1087, this);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (this.dZt != null) {
      this.dZt.c(this.dZA);
    }
    o.adi().cancel();
    Object localObject;
    if (this.pcV != null)
    {
      localObject = this.pcV;
      if (((NearbyFriendsUI.c)localObject).gxo != null)
      {
        ((NearbyFriendsUI.c)localObject).gxo.detach();
        ((NearbyFriendsUI.c)localObject).gxo = null;
      }
    }
    if (this.meE.size() > 0)
    {
      Iterator localIterator = this.pcY.values().iterator();
      localObject = "";
      while (localIterator.hasNext())
      {
        NearbyFriendsUI.a locala = (NearbyFriendsUI.a)localIterator.next();
        localObject = new StringBuilder().append((String)localObject).append("|").append(locala.id).append(":").append(locala.pdv).append(":");
        int i = locala.kxm + 1;
        locala.kxm = i;
        localObject = i;
        com.tencent.mm.plugin.report.service.h.qsU.e(17431, new Object[] { locala.id, Integer.valueOf(locala.pdw + 1) });
      }
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLY, localObject);
    }
    super.onDestroy();
    AppMethodBeat.o(55477);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(55475);
    super.onPause();
    if (this.dZt != null) {
      this.dZt.c(this.dZA);
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.dZC);
    AppMethodBeat.o(55475);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55476);
    super.onResume();
    if (this.dZt != null) {
      this.dZt.a(this.dZA, true);
    }
    bWD();
    this.pcV.notifyDataSetChanged();
    com.tencent.mm.kernel.g.RJ().QQ();
    if (((j)com.tencent.mm.kernel.g.E(j.class)).bPN().bbZ() == 0) {
      this.gAb.removeHeaderView(this.pdf);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.dZC);
    AppMethodBeat.o(55476);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(55478);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    label321:
    label454:
    Object localObject;
    if (paramm.getType() == 148)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      int i = ((com.tencent.mm.plugin.nearby.a.c)paramm).Ac();
      if ((this.pcW == null) && ((i == 1) || (i == 3) || (i == 4)))
      {
        AppMethodBeat.o(55478);
        return;
      }
      if (((i == 1) || (i == 3) || (i == 4)) && (this.pcZ))
      {
        ab.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(55478);
        return;
      }
      if ((this.pcJ == null) && (i == 2))
      {
        AppMethodBeat.o(55478);
        return;
      }
      ab.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if (paramm.getType() != 148)
      {
        AppMethodBeat.o(55478);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((i == 1) || (i == 3) || (i == 4))
        {
          this.meE = ((com.tencent.mm.plugin.nearby.a.c)paramm).bWA();
          if ((this.meE == null) || (this.meE.size() == 0))
          {
            findViewById(2131826489).setVisibility(0);
            this.gAb.setVisibility(8);
            bWE();
            com.tencent.mm.plugin.report.service.g.Cz(11);
            if (this.pdb != 3) {
              break label767;
            }
            setTitleLogo(0, 2131231426);
            this.pcZ = true;
            this.pcW = null;
          }
        }
        else
        {
          if (((com.tencent.mm.plugin.nearby.a.c)paramm).Ac() == 2)
          {
            com.tencent.mm.ui.base.h.a(getContext(), getString(2131301751), "", new NearbyFriendsUI.5(this));
            this.pcJ = null;
          }
          if (!((com.tencent.mm.plugin.nearby.a.c)paramm).bWy()) {
            break label811;
          }
          paramString = getString(2131301776);
          paramInt1 = ((com.tencent.mm.plugin.nearby.a.c)paramm).bWz();
          if (this.pdd != null)
          {
            if (this.pde != null) {
              break label800;
            }
            this.pde = View.inflate(this, 2130970348, null);
            this.pdd.addView(this.pde);
            this.pde.setOnClickListener(new NearbyFriendsUI.2(this));
            ((TextView)this.pde.findViewById(2131826504)).setText(paramString);
            if (paramInt1 != 0) {
              ((TextView)this.pde.findViewById(2131826505)).setText(String.format(getResources().getQuantityString(2131361812, paramInt1, new Object[] { Integer.valueOf(paramInt1) }), new Object[0]));
            }
          }
        }
        for (;;)
        {
          this.pdi = true;
          AppMethodBeat.o(55478);
          return;
          paramString = new LinkedList();
          localObject = this.meE.iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            azr localazr = (azr)((Iterator)localObject).next();
            if (((j)com.tencent.mm.kernel.g.E(j.class)).YA().arr(localazr.jJA))
            {
              paramString.add(paramInt1, localazr);
              paramInt1 += 1;
            }
            else if ((!bo.isNullOrNil(localazr.jJA)) && (!bo.isNullOrNil(localazr.xpd)))
            {
              paramString.add(localazr);
            }
          }
          this.meE.clear();
          this.meE = paramString;
          if ((this.meE == null) || (this.meE.size() == 0))
          {
            findViewById(2131826489).setVisibility(0);
            this.gAb.setVisibility(8);
            break;
          }
          findViewById(2131826489).setVisibility(8);
          bWF();
          this.pcV.notifyDataSetChanged();
          if (this.pcV.getCount() > 0) {
            this.gAb.setSelection(0);
          }
          this.gAb.post(new NearbyFriendsUI.4(this));
          break;
          label767:
          if (this.pdb == 4)
          {
            setTitleLogo(0, 2131231425);
            break label321;
          }
          setTitleLogo(0, 0);
          this.pdb = 1;
          break label321;
          label800:
          this.pde.setVisibility(0);
          break label454;
          label811:
          if ((this.pde != null) && (this.pdd != null)) {
            this.pde.setVisibility(8);
          }
        }
      }
      if ((i == 1) || (i == 3) || (i == 4))
      {
        localObject = (TextView)findViewById(2131826489);
        ((TextView)localObject).setVisibility(0);
        bWE();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label1165;
        }
      }
    }
    label1165:
    for (paramString = com.tencent.mm.h.a.kO(paramString);; paramString = null)
    {
      if ((paramString != null) && (paramString.desc != null) && (paramString.desc.length() > 0)) {
        ((TextView)localObject).setText(paramString.desc);
      }
      for (;;)
      {
        this.gAb.setVisibility(8);
        this.pcW = null;
        if (((com.tencent.mm.plugin.nearby.a.c)paramm).Ac() == 2)
        {
          Toast.makeText(this, 2131301750, 1).show();
          this.pcJ = null;
        }
        AppMethodBeat.o(55478);
        return;
        if (paramInt2 == -2001) {
          ((TextView)localObject).setText(getString(2131301753));
        } else {
          ((TextView)localObject).setText(getString(2131301756));
        }
      }
      if (paramm.getType() == 376)
      {
        if (((com.tencent.mm.plugin.nearby.a.d)paramm).Ac() != 1)
        {
          AppMethodBeat.o(55478);
          return;
        }
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
        if ((paramInt1 == 0) && (paramInt2 == 0) && (((com.tencent.mm.plugin.nearby.a.d)paramm).gfM != null))
        {
          paramString = ((com.tencent.mm.plugin.nearby.a.d)paramm).gfM;
          com.tencent.mm.plugin.nearby.a.b.fA(paramString, ((com.tencent.mm.plugin.nearby.a.d)paramm).pcq);
          paramm = new Intent();
          paramm.putExtra("Chat_User", paramString);
          com.tencent.mm.plugin.nearby.a.gmO.e(paramm, this);
          AppMethodBeat.o(55478);
          return;
        }
        com.tencent.mm.ui.base.h.a(getContext(), 2131301774, 2131297087, new NearbyFriendsUI.6(this));
      }
      AppMethodBeat.o(55478);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class e
  {
    TextView gvI;
    ImageView gxs;
    TextView gxt;
    TextView pdA;
    TextView pdB;
    ImageView pdC;
    ImageView pdD;
    ImageView pdE;
    ImageView pdF;
    ImageView pdG;
    ImageView pdH;
    ImageView pdI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI
 * JD-Core Version:    0.7.0.1
 */