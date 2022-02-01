package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.zc;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.contact.address.BaseAddressUIFragment;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.g.a;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public MMFragment afaX;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37647);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.afaX = new AddressUIFragment();
      this.afaX.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(16908290, this.afaX).FW();
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1728L, 2L, 1L, false);
    AppMethodBeat.o(37647);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(253019);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(253019);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class AddressUIFragment
    extends BaseAddressUIFragment
  {
    private AlphabetScrollBar FWh;
    private ListView JVY;
    private Animation LQl;
    private IListener RzF;
    com.tencent.mm.pluginsdk.ui.e adKd;
    private TextView afaY;
    private TextView afaZ;
    private String afau;
    private String afav;
    private a afba;
    private com.tencent.mm.ui.voicesearch.b afbb;
    private String afbc;
    private String afbd;
    private int afbe;
    private boolean afbf;
    private boolean afbg;
    private l afbh;
    private BizContactEntranceView afbi;
    private b afbj;
    private b afbk;
    private b afbl;
    private b afbm;
    private ContactCountView afbn;
    private ab afbo;
    private j afbp;
    boolean afbq;
    private boolean afbr;
    private LinearLayout afbs;
    private final com.tencent.mm.ui.contact.address.e afbt;
    private VerticalScrollBar.a afbu;
    List<String> afbv;
    private Runnable afbw;
    List<String> lMF;
    private ProgressDialog lzP;
    private final long oXR;
    private TextView pRq;
    private boolean pVy;
    private com.tencent.mm.ui.widget.b.a vEV;
    private int x_down;
    private u.i yBn;
    private int y_down;
    private Animation zUH;
    
    public AddressUIFragment()
    {
      AppMethodBeat.i(37621);
      this.lzP = null;
      this.afbd = "";
      this.afbf = false;
      this.pVy = false;
      this.afbg = false;
      this.afbr = true;
      this.oXR = 180000L;
      this.afbt = new com.tencent.mm.ui.contact.address.e();
      this.RzF = new IListener(com.tencent.mm.app.f.hfK) {};
      this.yBn = new u.i()
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
      this.afbu = new VerticalScrollBar.a()
      {
        public final void onScollBarTouch(String paramAnonymousString)
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
          localObject = ((a)localObject).afaA;
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
          i = AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).aDr(i);
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setSelection(i + AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
          AppMethodBeat.o(37604);
          return;
          AppMethodBeat.o(37604);
        }
      };
      this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
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
      this.lMF = new LinkedList();
      this.afbv = new LinkedList();
      this.afbw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37613);
          AddressUI.AddressUIFragment.s(AddressUI.AddressUIFragment.this);
          AppMethodBeat.o(37613);
        }
      };
      AppMethodBeat.o(37621);
    }
    
    private void jxZ()
    {
      AppMethodBeat.i(37628);
      this.lMF = new LinkedList();
      this.afbv = new LinkedList();
      if (com.tencent.mm.br.c.iPe()) {
        this.lMF.add("filehelper");
      }
      this.lMF.add("tmessage");
      this.afbv.addAll(this.lMF);
      if (!this.lMF.contains("officialaccounts")) {
        this.lMF.add("officialaccounts");
      }
      this.lMF.add("helper_entry");
      if (this.afba != null) {
        this.afba.nM(this.lMF);
      }
      if (this.afbb != null) {
        this.afbb.nM(this.afbv);
      }
      AppMethodBeat.o(37628);
    }
    
    private void jya()
    {
      try
      {
        AppMethodBeat.i(37632);
        long l = System.currentTimeMillis();
        jxZ();
        Log.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.afba != null)
        {
          Log.v("MicroMsg.AddressUI", "post to do refresh");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37607);
              AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).jxY();
              if (AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this) != null) {
                AddressUI.AddressUIFragment.g(AddressUI.AddressUIFragment.this).reset();
              }
              AppMethodBeat.o(37607);
            }
          });
        }
        if (this.afbb != null) {
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
    
    public static void s(String paramString, Context paramContext)
    {
      AppMethodBeat.i(252939);
      if ((paramString == null) || (paramString.length() <= 0))
      {
        AppMethodBeat.o(252939);
        return;
      }
      if (((au.bwO(paramString)) || (au.bwP(paramString))) && (!WeChatBrands.Business.Entries.ContactWeCom.checkAvailable(paramContext)))
      {
        AppMethodBeat.o(252939);
        return;
      }
      if (au.bwp(paramString))
      {
        Log.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramString });
        AppMethodBeat.o(252939);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramString);
      if (com.tencent.mm.model.ab.IQ(paramString)) {
        localIntent.putExtra("Is_group_card", true);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        e.a(localIntent, paramString);
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 4);
        com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramString, 10L);
      }
      AppMethodBeat.o(252939);
    }
    
    public final void Mw(boolean paramBoolean)
    {
      AppMethodBeat.i(37624);
      if (this.FWh != null)
      {
        if (this.zUH == null)
        {
          this.zUH = AnimationUtils.loadAnimation(getContext(), R.a.fjx);
          this.zUH.setDuration(200L);
        }
        if (this.LQl == null)
        {
          this.LQl = AnimationUtils.loadAnimation(getContext(), R.a.fjx);
          this.LQl.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.FWh.getVisibility() != 0)
          {
            this.FWh.setVisibility(0);
            this.FWh.startAnimation(this.zUH);
            AppMethodBeat.o(37624);
          }
        }
        else if (4 != this.FWh.getVisibility())
        {
          this.FWh.setVisibility(8);
          this.FWh.startAnimation(this.LQl);
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
      com.tencent.mm.kiss.layout.b.bbG();
      View localView = com.tencent.mm.kiss.layout.b.d(getContext(), R.i.address);
      AppMethodBeat.o(37622);
      return localView;
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.AddressUI";
    }
    
    public final void hFp() {}
    
    public final void hFq()
    {
      AppMethodBeat.i(37639);
      if (this.afbh != null) {
        l.gqT();
      }
      AppMethodBeat.o(37639);
    }
    
    public final void jhn()
    {
      AppMethodBeat.i(37630);
      Log.v("MicroMsg.AddressUI", "address ui on create");
      this.afbt.aNS();
      Log.v("MicroMsg.AddressUI", "on address ui create");
      this.afbf = false;
      this.pVy = false;
      this.afbg = false;
      this.afau = null;
      this.afav = null;
      this.afbc = null;
      this.afau = "@all.contact.without.chatroom.without.openim";
      this.afav = getStringExtra("Contact_GroupFilter_Str");
      this.afbc = getString(R.l.gJp);
      this.afbe = getIntExtra("List_Type", 2);
      jil();
      Log.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.JVY != null)
      {
        if (this.afbh != null) {
          this.JVY.removeHeaderView(this.afbh);
        }
        if (this.afbi != null) {
          this.JVY.removeHeaderView(this.afbi);
        }
        if (this.afbj != null) {
          this.JVY.removeHeaderView(this.afbj);
        }
        if (this.afbm != null) {
          this.JVY.removeHeaderView(this.afbm);
        }
        if (this.afbl != null) {
          this.JVY.removeHeaderView(this.afbl);
        }
      }
      this.JVY = ((ListView)findViewById(R.h.address_contactlist));
      this.JVY.setScrollingCacheEnabled(false);
      this.afaY = ((TextView)findViewById(R.h.fGB));
      this.afaY.setText(R.l.gqv);
      this.pRq = ((TextView)findViewById(R.h.fGG));
      this.pRq.setText(R.l.gqx);
      this.afaZ = ((TextView)findViewById(R.h.fGI));
      this.afaZ.setOnClickListener(new AddressUI.AddressUIFragment.12(this));
      this.afba = new a(getContext(), this.afau, this.afav, this.afbe);
      this.JVY.setAdapter(null);
      this.afba.a(new g.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(253078);
          AddressUI.AddressUIFragment localAddressUIFragment = AddressUI.AddressUIFragment.this;
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount();
          AddressUI.AddressUIFragment.b(localAddressUIFragment);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).jxW();
          AppMethodBeat.o(253078);
        }
        
        public final void jia() {}
      });
      this.afba.afaH = true;
      this.afba.setFragment(this);
      this.afba.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int eB(View paramAnonymousView)
        {
          AppMethodBeat.i(253041);
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
            AppMethodBeat.o(253041);
            return -1;
          }
          AppMethodBeat.o(253041);
          return -1;
          label70:
          int i = AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(253041);
          return i;
        }
      });
      this.afba.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(253046);
          AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(253046);
        }
      });
      this.afba.a(new MMSlideDelView.f()
      {
        public final void es(Object paramAnonymousObject)
        {
          AppMethodBeat.i(253066);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.AddressUI", "onItemDel object null");
            AppMethodBeat.o(253066);
            return;
          }
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(253066);
        }
      });
      this.afbb = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.afbb.Nh(true);
      this.afbs = new LinearLayout(getContext());
      this.afbs.setOrientation(1);
      this.JVY.addHeaderView(this.afbs);
      this.afbk = new b(getContext(), b.a.afbF);
      this.afbs.addView(this.afbk);
      bh.bCz();
      ((Boolean)com.tencent.mm.model.c.ban().get(at.a.acKL, Boolean.FALSE)).booleanValue();
      this.afbk.setVisible(false);
      this.afbh = new l(getContext());
      this.afbs.addView(this.afbh);
      this.afbm = new b(getContext(), b.a.afbG);
      this.afbs.addView(this.afbm);
      boolean bool = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adfP, false);
      if (!bool) {
        com.tencent.threadpool.h.ahAA.bn(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(253072);
            com.tencent.mm.kernel.h.baF();
            if (((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxG("@social.black.android") > 0)
            {
              com.tencent.mm.kernel.h.baE().ban().set(at.a.adfP, Boolean.TRUE);
              AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(252814);
                  AddressUI.AddressUIFragment.d(AddressUI.AddressUIFragment.this).setVisible(true);
                  AppMethodBeat.o(252814);
                }
              });
            }
            AppMethodBeat.o(253072);
          }
        });
      }
      Object localObject = this.afbm;
      if (bool)
      {
        bool = true;
        ((b)localObject).setVisible(bool);
        this.afbj = new b(getContext(), b.a.afbD);
        this.afbs.addView(this.afbj);
        this.afbj.setVisible(true);
        this.afbl = new b(getContext(), b.a.afbE);
        this.afbs.addView(this.afbl);
        this.afbl.setVisible(true);
        localObject = this.JVY;
        ContactCountView localContactCountView = new ContactCountView(getContext());
        this.afbn = localContactCountView;
        ((ListView)localObject).addFooterView(localContactCountView, null, false);
        if (com.tencent.mm.br.c.blq("brandservice"))
        {
          this.afbi = new BizContactEntranceView(getContext());
          this.afbs.addView(this.afbi);
          this.afbi.setVisible(true);
        }
        localObject = new ab.b()
        {
          public final void onVisibilityChange(boolean paramAnonymousBoolean)
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
              localBizContactEntranceView.Mx(paramAnonymousBoolean);
              AppMethodBeat.o(37620);
              return;
            }
          }
        };
        this.afbo = new ab(getContext(), new ab.a()
        {
          public final void onOpenIMListHeaderViewChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(253065);
            if ((AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this) == null) || (AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this) == null))
            {
              AppMethodBeat.o(253065);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).setVisibility(8);
              AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).Mx(true);
              AppMethodBeat.o(253065);
              return;
            }
            AddressUI.AddressUIFragment.f(AddressUI.AddressUIFragment.this).setVisibility(0);
            AddressUI.AddressUIFragment.e(AddressUI.AddressUIFragment.this).Mx(false);
            AppMethodBeat.o(253065);
          }
        });
        this.afbo.setOnVisibilityChangeListener((ab.b)localObject);
        if (this.afbo.getOpenIMCount() > 0) {
          break label1106;
        }
        ((ab.b)localObject).onVisibilityChange(false);
        this.afbo.setVisibility(8);
      }
      for (;;)
      {
        this.afbs.addView(this.afbo);
        this.afbp = new j(getContext(), new j.a()
        {
          public final void onEnterpriseBizViewChange(int paramAnonymousInt)
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
        if (this.afbp.getEnterpriseFriendCount() <= 0) {
          this.afbp.setVisibility(8);
        }
        this.afbs.addView(this.afbp);
        this.vEV = new com.tencent.mm.ui.widget.b.a(getContext());
        this.afba.afaF = new a.a() {};
        this.JVY.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(37599);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
            ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
            if (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) == null) {}
            for (paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).afRG))
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
            if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).afRG))
            {
              boolean bool1 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).XL(paramAnonymousInt);
              boolean bool2 = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aEl(paramAnonymousInt);
              Log.i("MicroMsg.AddressUI", "onItemClick ".concat(String.valueOf(bool2)));
              if (bool2) {
                AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).bDp("");
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37599);
                return;
                if (bool1)
                {
                  paramAnonymousView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).aEk(paramAnonymousInt);
                  paramAnonymousAdapterView = paramAnonymousView.ZqL.abwM;
                  bh.bCz();
                  localObject = com.tencent.mm.model.c.bzA().JE(paramAnonymousAdapterView);
                  if (d.rs(((az)localObject).field_type))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                    paramAnonymousView.putExtra("Contact_Scene", 3);
                    if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                    {
                      if (((au)localObject).iZC()) {
                        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
                      }
                      e.a(paramAnonymousView, paramAnonymousAdapterView);
                      paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
                      com.tencent.mm.br.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                    }
                  }
                  else
                  {
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.ZqL.abwM);
                    ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.pSk);
                    ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.aaIz.abwM);
                    ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.pSi);
                    ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramAnonymousView.pSo, paramAnonymousView.pSg, paramAnonymousView.pSh));
                    ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.pSf);
                    ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.aaMn);
                    ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.aaMm);
                    ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.aaMq);
                    ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.aaMo);
                    ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.aaMp);
                    ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.aaMs.pSq);
                    ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.aaMs.pSs);
                    ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.aaMs.pSr);
                    if (paramAnonymousView.aaMt != null) {}
                    try
                    {
                      ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.aaMt.toByteArray());
                      if ((paramAnonymousView.aaMm & 0x8) > 0) {
                        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
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
                  paramAnonymousAdapterView = AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).TF(paramAnonymousInt);
                  if (paramAnonymousAdapterView == null)
                  {
                    Log.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(37599);
                    return;
                  }
                  paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
                  if (au.bwp(paramAnonymousAdapterView))
                  {
                    paramAnonymousView = new Intent(AddressUI.AddressUIFragment.this.getContext(), AddressUI.class);
                    paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    paramAnonymousAdapterView = AddressUI.AddressUIFragment.this;
                    paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
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
                    com.tencent.mm.br.c.b(AddressUI.AddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
                  }
                }
              }
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).azn(paramAnonymousInt);
            if (paramAnonymousAdapterView != null) {
              AddressUI.AddressUIFragment.s(paramAnonymousAdapterView.field_username, AddressUI.AddressUIFragment.this.getContext());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment$12", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37599);
          }
        });
        this.JVY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
            if ((AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this) != null) && (AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).afRG))
            {
              AppMethodBeat.o(37600);
              return true;
            }
            paramAnonymousAdapterView = (com.tencent.mm.storage.f)AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).azn(paramAnonymousInt - AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount());
            if (paramAnonymousAdapterView == null)
            {
              Log.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).getHeaderViewsCount()) });
              AppMethodBeat.o(37600);
              return true;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if ((au.bwp(paramAnonymousAdapterView)) || (au.bwq(paramAnonymousAdapterView)))
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
        this.JVY.setOnTouchListener(new View.OnTouchListener()
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
        this.JVY.setOnScrollListener(this.adKd);
        this.JVY.setDrawingCacheEnabled(false);
        this.FWh = ((AlphabetScrollBar)findViewById(R.h.fqN));
        this.FWh.setOnScrollBarTouchListener(this.afbu);
        bh.bCz();
        com.tencent.mm.model.c.bzA().add(this.afba);
        if (this.afbp != null) {
          af.bHf().a(this.afbp, null);
        }
        AppMethodBeat.o(37630);
        return;
        bool = false;
        break;
        label1106:
        ((ab.b)localObject).onVisibilityChange(true);
      }
    }
    
    public final void jho()
    {
      AppMethodBeat.i(37631);
      Log.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      bh.bCz();
      if (l - Util.nullAs((Long)com.tencent.mm.model.c.ban().d(340226, null), 0L) >= 180000L) {
        jyb();
      }
      if (this.afbr)
      {
        this.afbr = false;
        this.afbq = false;
        jxZ();
        com.tencent.threadpool.h.ahAA.bm(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37610);
            Log.i("MicroMsg.AddressUI", "rcontact db init select count: %d", new Object[] { Integer.valueOf(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).getCount()) });
            AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(253086);
                AddressUI.AddressUIFragment.c(AddressUI.AddressUIFragment.this).setAdapter(AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this));
                Log.i("MicroMsg.AddressUI", "post to first init finish");
                View localView = AddressUI.AddressUIFragment.this.findViewById(R.h.loading_tips_area);
                if (localView != null)
                {
                  localView.setVisibility(8);
                  localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.AddressUIFragment.this.getContext(), R.a.fast_faded_out));
                  AddressUI.AddressUIFragment.q(AddressUI.AddressUIFragment.this).report();
                }
                AppMethodBeat.o(253086);
              }
            });
            AddressUI.AddressUIFragment.h(AddressUI.AddressUIFragment.this).Ng(false);
            AppMethodBeat.o(37610);
          }
        });
        if (this.afbi != null) {
          this.afbi.irV();
        }
        if (this.afbp != null)
        {
          if (this.afbp.getEnterpriseFriendCount() > 0) {
            break label382;
          }
          this.afbp.setVisibility(8);
        }
      }
      for (;;)
      {
        bh.bCz();
        this.afbf = ((Boolean)com.tencent.mm.model.c.ban().d(12296, Boolean.FALSE)).booleanValue();
        if (this.afbe == 2)
        {
          bh.bCz();
          localObject = com.tencent.mm.model.c.bzA().JE(z.bAM());
          if ((localObject != null) && ((!d.rs(((az)localObject).field_type)) || (!Util.isNullOrNil(((az)localObject).field_conRemark)) || (!Util.isNullOrNil(((az)localObject).field_conRemarkPYFull)) || (!Util.isNullOrNil(((az)localObject).field_conRemarkPYShort))))
          {
            ((au)localObject).aRK();
            ((au)localObject).AW("");
            ((au)localObject).Bb("");
            ((au)localObject).Bc("");
            bh.bCz();
            com.tencent.mm.model.c.bzA().d(z.bAM(), (au)localObject);
          }
        }
        if (this.afbb != null) {
          this.afbb.onResume();
        }
        this.afba.adxn = false;
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37612);
            AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).resume();
            AppMethodBeat.o(37612);
          }
        });
        if (this.afbh != null)
        {
          this.afbh.setFrontGround(true);
          l.gqT();
        }
        Object localObject = (LauncherUI)getContext();
        if (localObject != null) {
          ((LauncherUI)localObject).getHomeUI().setTitleBarDoubleClickListener(this.afbw);
        }
        AppMethodBeat.o(37631);
        return;
        if (!this.afbq) {
          break;
        }
        this.afbq = false;
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37611);
            Process.setThreadPriority(10);
            AddressUI.AddressUIFragment.r(AddressUI.AddressUIFragment.this);
            AppMethodBeat.o(37611);
          }
        }, "AddressUI_updateUIData", 4);
        this.afbn.jyf();
        break;
        label382:
        this.afbp.setVisibility(0);
      }
    }
    
    public final void jhp() {}
    
    public final void jhq()
    {
      AppMethodBeat.i(37633);
      Log.i("MicroMsg.AddressUI", "AddressUI on Pause");
      bh.bCz();
      com.tencent.mm.model.c.ban().B(340226, Long.valueOf(System.currentTimeMillis()));
      bh.bCz();
      com.tencent.mm.model.c.ban().B(12296, Boolean.valueOf(this.afbf));
      if (this.afbb != null) {
        this.afbb.onPause();
      }
      this.afba.jxX();
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37614);
          AddressUI.AddressUIFragment.a(AddressUI.AddressUIFragment.this).pause();
          AppMethodBeat.o(37614);
        }
      });
      if (this.afbh != null) {
        this.afbh.setFrontGround(false);
      }
      LauncherUI localLauncherUI = (LauncherUI)getContext();
      if (localLauncherUI != null) {
        localLauncherUI.getHomeUI().aW(this.afbw);
      }
      AppMethodBeat.o(37633);
    }
    
    public final void jhr() {}
    
    public final void jhs()
    {
      AppMethodBeat.i(37634);
      Log.v("MicroMsg.AddressUI", "onDestory");
      if (this.FWh != null) {
        this.FWh.adXj = null;
      }
      if (this.afba != null)
      {
        this.afba.KV(true);
        this.afba.detach();
        this.afba.jhO();
      }
      if (this.afbb != null)
      {
        this.afbb.detach();
        this.afbb.fSd();
      }
      if ((bh.baz()) && (this.afba != null))
      {
        bh.bCz();
        com.tencent.mm.model.c.bzA().remove(this.afba);
      }
      if ((bh.baz()) && (this.afbp != null)) {
        af.bHf().a(this.afbp);
      }
      if (this.afbh != null)
      {
        this.afbh.detach();
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
      AppMethodBeat.o(37634);
    }
    
    public final void jht()
    {
      AppMethodBeat.i(37638);
      Log.v("MicroMsg.AddressUI", "request to top");
      if (this.JVY != null)
      {
        Object localObject1 = this.JVY;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/contact/AddressUI$AddressUIFragment", "requestToTop", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      }
      AppMethodBeat.o(37638);
    }
    
    public final void jhu()
    {
      AppMethodBeat.i(37636);
      if (this.afba != null)
      {
        a locala = this.afba;
        locala.afaL.clear();
        locala.afaJ.clear();
        locala.afaK = false;
      }
      Log.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.afbi != null) {
        this.afbi.destroyDrawingCache();
      }
      if (this.afbj != null) {
        this.afbj.destroyDrawingCache();
      }
      if (this.afbl != null) {
        this.afbl.destroyDrawingCache();
      }
      if (this.afbm != null) {
        this.afbm.destroyDrawingCache();
      }
      if (this.afbn != null) {
        this.afbn.destroyDrawingCache();
      }
      if (this.afbh != null) {
        this.afbh.destroyDrawingCache();
      }
      AppMethodBeat.o(37636);
    }
    
    public final void jhv()
    {
      AppMethodBeat.i(37637);
      Log.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      AppMethodBeat.o(37637);
    }
    
    public final void jyb()
    {
      AppMethodBeat.i(37640);
      if (this.JVY != null) {
        this.JVY.setSelection(0);
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
    
    public void onCreate(Bundle paramBundle)
    {
      AppMethodBeat.i(37623);
      super.onCreate(paramBundle);
      this.RzF.alive();
      AppMethodBeat.o(37623);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37626);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(this.afbd);
      if (localau == null)
      {
        Log.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.afbd);
        AppMethodBeat.o(37626);
        return;
      }
      if (z.bAM().equals(localau.field_username))
      {
        AppMethodBeat.o(37626);
        return;
      }
      if (com.tencent.mm.model.ab.IQ(this.afbd))
      {
        paramContextMenu.setHeaderTitle(p.b(paramView.getContext(), localau.aSV()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.gqu);
        AppMethodBeat.o(37626);
        return;
      }
      if ((au.bwc(this.afbd)) || (au.bws(this.afbd)))
      {
        AppMethodBeat.o(37626);
        return;
      }
      paramContextMenu.setHeaderTitle(p.b(paramView.getContext(), localau.aSV()));
      if ((d.rs(localau.field_type)) && (localau.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.gBA);
      }
      AppMethodBeat.o(37626);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37635);
      super.onDestroy();
      this.RzF.dead();
      AppMethodBeat.o(37635);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.AddressUI
 * JD-Core Version:    0.7.0.1
 */