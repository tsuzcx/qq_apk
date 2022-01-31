package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.o;
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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public x vIR;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.Z(16908290) == null)
    {
      this.vIR = new a();
      this.vIR.setArguments(getIntent().getExtras());
      paramBundle.bP().a(16908290, this.vIR).commit();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  public static class a
    extends AbstractTabChildActivity.a
    implements com.tencent.mm.ah.f
  {
    private final long TIME_INTERVAL = 180000L;
    com.tencent.mm.pluginsdk.ui.d dnR = new com.tencent.mm.pluginsdk.ui.d(new AddressUI.a.8(this));
    private ProgressDialog dnm = null;
    List<String> dru = new LinkedList();
    private TextView fer;
    private boolean fiq = false;
    private int idy;
    private int idz;
    private com.tencent.mm.ui.widget.b.a iep;
    private n.d jEB = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          return;
        case 1: 
        case 2: 
          AddressUI.a.a(AddressUI.a.this, AddressUI.a.m(AddressUI.a.this));
          return;
        }
        AddressUI.a.c(AddressUI.a.this, AddressUI.a.m(AddressUI.a.this));
      }
    };
    private Animation jPF;
    private ListView lBK;
    private TextView vIS;
    private TextView vIT;
    private a vIU;
    private com.tencent.mm.ui.voicesearch.b vIV;
    private String vIW;
    private String vIX = "";
    private int vIY;
    private AlphabetScrollBar vIZ;
    private String vIs;
    private String vIt;
    private LinearLayout vJa = null;
    private boolean vJb = false;
    private boolean vJc = false;
    private k vJd;
    private BizContactEntranceView vJe;
    private b vJf;
    private b vJg;
    private b vJh;
    private ContactCountView vJi;
    private u vJj;
    private i vJk;
    boolean vJl;
    private boolean vJm = true;
    private LinearLayout vJn;
    private Animation vJo;
    private VerticalScrollBar.a vJp = new AddressUI.a.7(this);
    List<String> vJq = new LinkedList();
    private Runnable vJr = new AddressUI.a.15(this);
    
    private void cHo()
    {
      this.dru = new LinkedList();
      this.vJq = new LinkedList();
      com.tencent.mm.br.d.coz();
      this.dru.add("tmessage");
      this.vJq.addAll(this.dru);
      if (!this.dru.contains("officialaccounts")) {
        this.dru.add("officialaccounts");
      }
      this.dru.add("helper_entry");
      if (this.vIU != null) {
        this.vIU.ej(this.dru);
      }
      if (this.vIV != null) {
        this.vIV.ej(this.vJq);
      }
    }
    
    private void cHp()
    {
      try
      {
        long l = System.currentTimeMillis();
        cHo();
        y.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.vIU != null)
        {
          y.v("MicroMsg.AddressUI", "post to do refresh");
          ai.d(new AddressUI.a.9(this));
        }
        if (this.vIV != null) {
          ai.d(new Runnable()
          {
            public final void run()
            {
              y.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.a.g(AddressUI.a.this).a(null, null);
            }
          });
        }
        y.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        return;
      }
      finally {}
    }
    
    public final void cHq()
    {
      if (this.lBK != null) {
        this.lBK.setSelection(0);
      }
    }
    
    protected final void cxD()
    {
      y.v("MicroMsg.AddressUI", "address ui on create");
      y.v("MicroMsg.AddressUI", "on address ui create");
      this.vJb = false;
      this.fiq = false;
      this.vJc = false;
      this.vIs = null;
      this.vIt = null;
      this.vIW = null;
      au.Dk().a(138, this);
      this.vIs = "@all.contact.without.chatroom.without.openim";
      this.vIt = getStringExtra("Contact_GroupFilter_Str");
      this.vIW = getString(R.l.group_weixin);
      this.vIY = getIntExtra("List_Type", 2);
      Object localObject = getView().getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
      int i = com.tencent.mm.compatible.util.a.bh(getContext());
      getView().setPadding(0, i, 0, ((View)localObject).getHeight());
      y.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.lBK != null)
      {
        if (this.vJd != null) {
          this.lBK.removeHeaderView(this.vJd);
        }
        if (this.vJe != null) {
          this.lBK.removeHeaderView(this.vJe);
        }
        if (this.vJf != null) {
          this.lBK.removeHeaderView(this.vJf);
        }
        if (this.vJh != null) {
          this.lBK.removeHeaderView(this.vJh);
        }
      }
      this.lBK = ((ListView)findViewById(R.h.address_contactlist));
      this.lBK.setScrollingCacheEnabled(false);
      this.vIS = ((TextView)findViewById(R.h.empty_blacklist_tip_tv));
      this.vIS.setText(R.l.address_empty_blacklist_tip);
      this.fer = ((TextView)findViewById(R.h.empty_voicesearch_tip_tv));
      this.fer.setText(R.l.address_empty_voicesearch_tip);
      this.vIT = ((TextView)findViewById(R.h.enter_search_tips_tv));
      this.vIT.setOnClickListener(new AddressUI.a.1(this));
      this.vIU = new a(getContext(), this.vIs, this.vIt, this.vIY);
      this.lBK.setAdapter(null);
      this.vIU.a(new AddressUI.a.12(this));
      this.vIU.vIF = true;
      this.vIU.s(this);
      this.vIU.setGetViewPositionCallback(new AddressUI.a.17(this));
      this.vIU.setPerformItemClickListener(new AddressUI.a.18(this));
      this.vIU.a(new AddressUI.a.19(this));
      this.vIV = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.vIV.nP(true);
      this.vJn = new LinearLayout(getContext());
      this.vJn.setOrientation(1);
      this.lBK.addHeaderView(this.vJn);
      this.vJg = new b(getContext(), b.a.vJy);
      this.vJn.addView(this.vJg);
      au.Hx();
      ((Boolean)c.Dz().get(ac.a.uqp, Boolean.valueOf(false))).booleanValue();
      this.vJg.setVisible(false);
      this.vJd = new k(getContext());
      this.vJn.addView(this.vJd);
      this.vJf = new b(getContext(), b.a.vJw);
      this.vJn.addView(this.vJf);
      this.vJf.setVisible(true);
      this.vJh = new b(getContext(), b.a.vJx);
      this.vJn.addView(this.vJh);
      this.vJh.setVisible(true);
      localObject = this.lBK;
      ContactCountView localContactCountView = new ContactCountView(getContext());
      this.vJi = localContactCountView;
      ((ListView)localObject).addFooterView(localContactCountView, null, false);
      if (com.tencent.mm.br.d.SP("brandservice"))
      {
        this.vJe = new BizContactEntranceView(getContext());
        this.vJn.addView(this.vJe);
        this.vJe.setVisible(true);
      }
      localObject = new AddressUI.a.20(this);
      this.vJj = new u(getContext(), new AddressUI.a.21(this));
      this.vJj.setOnVisibilityChangeListener((u.b)localObject);
      if (this.vJj.getOpenIMCount() <= 0)
      {
        ((u.b)localObject).nw(false);
        this.vJj.setVisibility(8);
      }
      for (;;)
      {
        this.vJn.addView(this.vJj);
        if (com.tencent.mm.br.d.SP("brandservice"))
        {
          this.vJk = new i(getContext(), new AddressUI.a.22(this));
          if (this.vJk.getEnterpriseFriendCount() <= 0) {
            this.vJk.setVisibility(8);
          }
          this.vJn.addView(this.vJk);
        }
        this.iep = new com.tencent.mm.ui.widget.b.a(getContext());
        this.vIU.vID = new AddressUI.a.23(this);
        this.lBK.setOnItemClickListener(new AddressUI.a.2(this));
        this.lBK.setOnItemLongClickListener(new AddressUI.a.3(this));
        this.lBK.setOnTouchListener(new AddressUI.a.4(this));
        this.lBK.setOnScrollListener(this.dnR);
        this.lBK.setDrawingCacheEnabled(false);
        this.vIZ = ((AlphabetScrollBar)findViewById(R.h.address_scrollbar));
        this.vIZ.setOnScrollBarTouchListener(this.vJp);
        au.Hx();
        c.Fw().a(this.vIU);
        if (this.vJk != null) {
          com.tencent.mm.ai.z.My().a(this.vJk, null);
        }
        return;
        ((u.b)localObject).nw(true);
      }
    }
    
    protected final void cxE()
    {
      y.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      au.Hx();
      if (l - ah.d((Long)c.Dz().get(340226, null)) >= 180000L) {
        cHq();
      }
      Object localObject;
      if (this.vJm)
      {
        this.vJm = false;
        this.vJl = false;
        cHo();
        this.lBK.setAdapter(this.vIU);
        this.lBK.post(new AddressUI.a.11(this));
        this.vIV.nO(false);
        if (this.vJe != null)
        {
          localObject = this.vJe;
          ((BizContactEntranceView)localObject).cHr();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.vJk != null)
        {
          if (this.vJk.getEnterpriseFriendCount() > 0) {
            break label395;
          }
          this.vJk.setVisibility(8);
        }
      }
      for (;;)
      {
        au.Hx();
        this.vJb = ((Boolean)c.Dz().get(12296, Boolean.valueOf(false))).booleanValue();
        if (this.vIY == 2)
        {
          au.Hx();
          localObject = c.Fw().abl(q.Gj());
          if ((localObject != null) && ((!com.tencent.mm.n.a.gR(((ao)localObject).field_type)) || (!ah.bl(((ao)localObject).field_conRemark)) || (!ah.bl(((ao)localObject).field_conRemarkPYFull)) || (!ah.bl(((ao)localObject).field_conRemarkPYShort))))
          {
            ((ad)localObject).AH();
            ((ad)localObject).df("");
            ((ad)localObject).jdMethod_do("");
            ((ad)localObject).dp("");
            au.Hx();
            c.Fw().a(q.Gj(), (ad)localObject);
          }
        }
        if (this.vIV != null) {
          this.vIV.onResume();
        }
        this.vIU.uIl = false;
        ai.d(new AddressUI.a.14(this));
        if (this.vJd != null)
        {
          this.vJd.setFrontGround(true);
          k.cHA();
        }
        localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).uKP.setTitleBarDoubleClickListener(this.vJr);
        }
        return;
        if (!this.vJl) {
          break;
        }
        this.vJl = false;
        com.tencent.mm.sdk.f.e.a(new AddressUI.a.13(this), "AddressUI_updateUIData", 4);
        this.vJi.cHs();
        break;
        label395:
        this.vJk.setVisibility(0);
      }
    }
    
    protected final void cxF() {}
    
    protected final void cxG()
    {
      y.i("MicroMsg.AddressUI", "AddressUI on Pause");
      au.Hx();
      c.Dz().o(340226, Long.valueOf(System.currentTimeMillis()));
      au.Hx();
      c.Dz().o(12296, Boolean.valueOf(this.vJb));
      if (this.vIV != null) {
        this.vIV.onPause();
      }
      this.vIU.cHm();
      ai.d(new AddressUI.a.16(this));
      if (this.vJd != null) {
        this.vJd.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.uKP.ah(this.vJr);
      }
    }
    
    protected final void cxH() {}
    
    protected final void cxI()
    {
      y.v("MicroMsg.AddressUI", "onDestory");
      if (this.vIZ != null) {
        this.vIZ.vbE = null;
      }
      au.Dk().b(138, this);
      if (this.vIU != null)
      {
        this.vIU.mK(true);
        this.vIU.detach();
        this.vIU.cxZ();
      }
      if (this.vIV != null)
      {
        this.vIV.detach();
        this.vIV.bcS();
      }
      if ((au.DK()) && (this.vIU != null))
      {
        au.Hx();
        c.Fw().b(this.vIU);
      }
      if ((au.DK()) && (this.vJk != null)) {
        com.tencent.mm.ai.z.My().a(this.vJk);
      }
      if (this.vJd != null)
      {
        k localk = this.vJd;
        if (au.DK()) {
          com.tencent.mm.bh.d.RY().d(localk.vLm);
        }
        this.vJd = null;
      }
      if (this.vJe != null) {
        this.vJe = null;
      }
      if (this.vJf != null) {
        this.vJf = null;
      }
      if (this.vJh != null) {
        this.vJh = null;
      }
    }
    
    public final void cxJ()
    {
      y.v("MicroMsg.AddressUI", "request to top");
      if (this.lBK != null) {
        BackwardSupportUtil.c.a(this.lBK);
      }
    }
    
    public final void cxK()
    {
      if (this.vIU != null)
      {
        a locala = this.vIU;
        locala.vIJ.clear();
        locala.vIH.clear();
        locala.vII = false;
      }
      y.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.vJe != null) {
        this.vJe.destroyDrawingCache();
      }
      if (this.vJf != null) {
        this.vJf.destroyDrawingCache();
      }
      if (this.vJh != null) {
        this.vJh.destroyDrawingCache();
      }
      if (this.vJi != null) {
        this.vJi.destroyDrawingCache();
      }
      if (this.vJd != null) {
        this.vJd.destroyDrawingCache();
      }
    }
    
    public final void cxL()
    {
      y.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    }
    
    public final void cyy()
    {
      if (this.vJd != null) {
        k.cHA();
      }
    }
    
    public final void cyz() {}
    
    protected int getLayoutId()
    {
      return R.i.address;
    }
    
    protected View getLayoutView()
    {
      return com.tencent.mm.kiss.a.b.ED().a(getContext(), "R.layout.address", R.i.address);
    }
    
    public boolean noActionBar()
    {
      return true;
    }
    
    public final void nv(boolean paramBoolean)
    {
      if (this.vIZ != null)
      {
        if (this.jPF == null)
        {
          this.jPF = AnimationUtils.loadAnimation(getContext(), R.a.faded_in);
          this.jPF.setDuration(200L);
        }
        if (this.vJo == null)
        {
          this.vJo = AnimationUtils.loadAnimation(getContext(), R.a.faded_in);
          this.vJo.setDuration(200L);
        }
        if (!paramBoolean) {
          break label103;
        }
        if (this.vIZ.getVisibility() != 0)
        {
          this.vIZ.setVisibility(0);
          this.vIZ.startAnimation(this.jPF);
        }
      }
      label103:
      while (4 == this.vIZ.getVisibility()) {
        return;
      }
      this.vIZ.setVisibility(8);
      this.vIZ.startAnimation(this.vJo);
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      y.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 == 6) && (paramInt2 == -1))
      {
        setResult(-1);
        finish();
      }
      while (paramInt2 != -1) {
        return;
      }
      switch (paramInt1)
      {
      default: 
        return;
      }
      setResult(-1, paramIntent);
      finish();
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      au.Hx();
      ad localad = c.Fw().abl(this.vIX);
      if (localad == null) {
        y.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.vIX);
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (q.Gj().equals(localad.field_username));
          if (s.hi(this.vIX))
          {
            paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(paramView.getContext(), localad.Bq()));
            paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.address_delgroupcard);
            return;
          }
        } while ((s.hx(this.vIX)) || (s.hN(this.vIX)));
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(paramView.getContext(), localad.Bq()));
      } while ((!com.tencent.mm.n.a.gR(localad.field_type)) || (localad.field_deleteFlag == 1));
      paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.contact_info_mod_remark_labelinfo);
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
    {
      if (this.dnm != null)
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
      if (!ah.bU(getContext())) {}
      while ((w.a.a(getContext(), paramInt1, paramInt2, paramString, 4)) || (paramInt1 != 0) || (paramInt2 == 0)) {
        return;
      }
    }
    
    public boolean supportNavigationSwipeBack()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */