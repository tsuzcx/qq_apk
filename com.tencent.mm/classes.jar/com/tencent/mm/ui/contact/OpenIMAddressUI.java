package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.y.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment Kjs;
  
  public int getLayoutId()
  {
    return 2131495054;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37918);
    super.onCreate(paramBundle);
    paramBundle = getSupportFragmentManager();
    if (paramBundle.findFragmentById(16908290) == null)
    {
      this.Kjs = new OpenIMAddressUIFragment();
      this.Kjs.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131301022, this.Kjs).commit();
    }
    AppMethodBeat.o(37918);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static class OpenIMAddressUIFragment
    extends MMFragment
    implements com.tencent.mm.al.f
  {
    boolean KjN;
    private boolean KjO;
    List<String> KjR;
    private com.tencent.mm.ui.voicesearch.b Kjw;
    private String Kjy;
    private String KoE;
    private x KoF;
    private Runnable KoG;
    com.tencent.mm.pluginsdk.ui.e fMX;
    private ProgressDialog fMu;
    List<String> fSL;
    private com.tencent.mm.ui.widget.f nYF;
    private int nYw;
    private int nYx;
    private n.e qlC;
    private ListView uXc;
    
    public OpenIMAddressUIFragment()
    {
      super();
      AppMethodBeat.i(37902);
      this.KoE = "";
      this.fMu = null;
      this.Kjy = "";
      this.KjO = true;
      this.KoG = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37901);
          OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          AppMethodBeat.o(37901);
        }
      };
      this.qlC = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(37885);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(37885);
            return;
          case 1: 
          case 2: 
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.j(OpenIMAddressUI.OpenIMAddressUIFragment.this));
            AppMethodBeat.o(37885);
            return;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.j(OpenIMAddressUI.OpenIMAddressUIFragment.this));
          AppMethodBeat.o(37885);
        }
      };
      this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(37886);
          ad.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(37886);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(37887);
          ad.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 2) {
            com.tencent.mm.cj.d.fux().gt(OpenIMAddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(37887);
        }
      });
      this.fSL = new LinkedList();
      this.KjR = new LinkedList();
      AppMethodBeat.o(37902);
    }
    
    private void fHE()
    {
      AppMethodBeat.i(37906);
      this.fSL = new LinkedList();
      this.KjR = new LinkedList();
      com.tencent.mm.bs.d.ffH();
      this.fSL.add("tmessage");
      this.KjR.addAll(this.fSL);
      if (!this.fSL.contains("officialaccounts")) {
        this.fSL.add("officialaccounts");
      }
      this.fSL.add("helper_entry");
      if (this.KoF != null) {
        this.KoF.io(this.fSL);
      }
      if (this.Kjw != null) {
        this.Kjw.io(this.KjR);
      }
      AppMethodBeat.o(37906);
    }
    
    private void fHF()
    {
      try
      {
        AppMethodBeat.i(37910);
        long l = System.currentTimeMillis();
        fHE();
        ad.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.KoF != null)
        {
          ad.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37888);
              OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fHD();
              AppMethodBeat.o(37888);
            }
          });
        }
        if (this.Kjw != null) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37889);
              ad.v("MicroMsg.OpenIMAddressUI", "post search adapter to do refresh");
              OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(null, null);
              AppMethodBeat.o(37889);
            }
          });
        }
        ad.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        AppMethodBeat.o(37910);
        return;
      }
      finally {}
    }
    
    public int getLayoutId()
    {
      return 2131495056;
    }
    
    public View getLayoutView()
    {
      AppMethodBeat.i(37903);
      com.tencent.mm.kiss.a.b.akC();
      View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131495056);
      AppMethodBeat.o(37903);
      return localView;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(37908);
      super.onActivityCreated(paramBundle);
      ad.v("MicroMsg.OpenIMAddressUI", "on address ui create");
      ba.aiU().a(138, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(453, this);
      this.KoE = getStringExtra("key_openim_acctype_id");
      setMMTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).b(this.KoE, "openim_acct_type_title", b.a.iHt));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37883);
          OpenIMAddressUI.OpenIMAddressUIFragment.this.finish();
          AppMethodBeat.o(37883);
          return true;
        }
      });
      setTitleBarDoubleClickListener(this.KoG);
      ad.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      this.uXc = ((ListView)findViewById(2131296471));
      this.uXc.setScrollingCacheEnabled(false);
      this.KoF = new x(getContext(), "@openim.contact", this.KoE);
      this.KoF.a(new f.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(37894);
          OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
          OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).fHB();
          AppMethodBeat.o(37894);
        }
        
        public final void fvs() {}
      });
      this.KoF.Kjc = true;
      this.KoF.KoK = this;
      this.KoF.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dA(View paramAnonymousView)
        {
          AppMethodBeat.i(37895);
          int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(37895);
          return i;
        }
      });
      this.KoF.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37896);
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37896);
        }
      });
      this.KoF.a(new MMSlideDelView.f()
      {
        public final void cP(Object paramAnonymousObject)
        {
          AppMethodBeat.i(37897);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
            AppMethodBeat.o(37897);
            return;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousObject.toString());
          AppMethodBeat.o(37897);
        }
      });
      this.Kjw = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.Kjw.yI(true);
      this.nYF = new com.tencent.mm.ui.widget.f(getContext());
      this.uXc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37898);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          boolean bool1;
          if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null)
          {
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);
            ad.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
            paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
            if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).KPF)) {
              break label937;
            }
            bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).HY(paramAnonymousInt);
            boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aeX(paramAnonymousInt);
            ad.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (!bool2) {
              break label230;
            }
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aXz("");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37898);
            return;
            paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).KPF);
            break;
            label230:
            if (bool1)
            {
              paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aeW(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.GbY.HoB;
              ba.aBQ();
              localObject = c.azp().Bf(paramAnonymousAdapterView);
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
                  com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
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
                  com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).FC(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37898);
                return;
              }
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (w.Ad(paramAnonymousAdapterView))
              {
                paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
                paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37898);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
                com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
            }
          }
          label937:
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).abj(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
              break label995;
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37898);
            return;
            label995:
            if (w.Ad(paramAnonymousAdapterView))
            {
              ad.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
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
          AppMethodBeat.i(37899);
          ad.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
          if (paramAnonymousInt < OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount())
          {
            ad.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
            AppMethodBeat.o(37899);
            return true;
          }
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).KPF))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).abj(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((w.Ad(paramAnonymousAdapterView)) || (w.Ae(paramAnonymousAdapterView)))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, paramAnonymousAdapterView);
          OpenIMAddressUI.OpenIMAddressUIFragment.h(OpenIMAddressUI.OpenIMAddressUIFragment.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, OpenIMAddressUI.OpenIMAddressUIFragment.this, OpenIMAddressUI.OpenIMAddressUIFragment.e(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.f(OpenIMAddressUI.OpenIMAddressUIFragment.this), OpenIMAddressUI.OpenIMAddressUIFragment.g(OpenIMAddressUI.OpenIMAddressUIFragment.this));
          AppMethodBeat.o(37899);
          return true;
        }
      });
      this.uXc.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37900);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(37900);
            return false;
            OpenIMAddressUI.OpenIMAddressUIFragment.this.hideVKB();
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
            OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.uXc.setOnScrollListener(this.fMX);
      this.uXc.setDrawingCacheEnabled(false);
      ba.aBQ();
      c.azp().a(this.KoF);
      AppMethodBeat.o(37908);
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(37907);
      ad.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 == 6) && (paramInt2 == -1))
      {
        setResult(-1);
        finish();
        AppMethodBeat.o(37907);
        return;
      }
      if (paramInt2 != -1)
      {
        AppMethodBeat.o(37907);
        return;
      }
      switch (paramInt1)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37907);
        return;
        setResult(-1, paramIntent);
        finish();
      }
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(37904);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      ba.aBQ();
      am localam = c.azp().Bf(this.Kjy);
      if (localam == null)
      {
        ad.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.Kjy);
        AppMethodBeat.o(37904);
        return;
      }
      if (u.aAm().equals(localam.field_username))
      {
        AppMethodBeat.o(37904);
        return;
      }
      if (w.zB(this.Kjy))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localam.adv()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37904);
        return;
      }
      if ((w.zQ(this.Kjy)) || (w.Ag(this.Kjy)))
      {
        AppMethodBeat.o(37904);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localam.adv()));
      if ((com.tencent.mm.o.b.lM(localam.field_type)) && (localam.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37904);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37912);
      super.onDestroy();
      ad.v("MicroMsg.OpenIMAddressUI", "onDestory");
      ba.aiU().b(138, this);
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.b(453, this);
      if (this.KoF != null)
      {
        this.KoF.wZ(true);
        this.KoF.detach();
        this.KoF.fvg();
      }
      if (this.Kjw != null)
      {
        this.Kjw.detach();
        this.Kjw.det();
      }
      if ((ba.ajx()) && (this.KoF != null))
      {
        ba.aBQ();
        c.azp().b(this.KoF);
      }
      AppMethodBeat.o(37912);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(37911);
      super.onPause();
      ad.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
      if (this.Kjw != null) {
        this.Kjw.onPause();
      }
      this.KoF.fHC();
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37893);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).pause();
          AppMethodBeat.o(37893);
        }
      });
      AppMethodBeat.o(37911);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(37909);
      super.onResume();
      ad.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
      if (this.KjO)
      {
        this.KjO = false;
        this.KjN = false;
        fHE();
        this.uXc.setAdapter(this.KoF);
        this.uXc.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37890);
            ad.i("MicroMsg.OpenIMAddressUI", "post to first init finish");
            View localView = OpenIMAddressUI.OpenIMAddressUIFragment.this.findViewById(2131301512);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), 2130772048));
            }
            AppMethodBeat.o(37890);
          }
        });
        this.Kjw.yH(false);
      }
      for (;;)
      {
        if (this.Kjw != null) {
          this.Kjw.onResume();
        }
        this.KoF.IVh = false;
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(37892);
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).resume();
            AppMethodBeat.o(37892);
          }
        });
        AppMethodBeat.o(37909);
        return;
        if (this.KjN)
        {
          this.KjN = false;
          com.tencent.mm.sdk.g.b.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37891);
              Process.setThreadPriority(10);
              OpenIMAddressUI.OpenIMAddressUIFragment.k(OpenIMAddressUI.OpenIMAddressUIFragment.this);
              AppMethodBeat.o(37891);
            }
          }, "AddressUI_updateUIData");
        }
      }
    }
    
    public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(37905);
      if (paramn.getType() == 453)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          AppMethodBeat.o(37905);
          return;
        }
        if (!((bff)((i)paramn).rr.hNL.hNQ).GBe.isEmpty()) {
          fHF();
        }
        AppMethodBeat.o(37905);
        return;
      }
      if (this.fMu != null)
      {
        this.fMu.dismiss();
        this.fMu = null;
      }
      if (!bt.jh(getContext()))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if (y.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        AppMethodBeat.o(37905);
        return;
      }
      AppMethodBeat.o(37905);
    }
    
    public boolean supportNavigationSwipeBack()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */