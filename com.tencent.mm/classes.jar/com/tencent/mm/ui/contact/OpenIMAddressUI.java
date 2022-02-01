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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.x.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI
  extends MMActivity
{
  public MMFragment GSA;
  
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
      this.GSA = new OpenIMAddressUIFragment();
      this.GSA.setArguments(getIntent().getExtras());
      paramBundle.beginTransaction().a(2131301022, this.GSA).commit();
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
    implements com.tencent.mm.al.g
  {
    private com.tencent.mm.ui.voicesearch.b GSE;
    private String GSG;
    boolean GSV;
    private boolean GSW;
    List<String> GTa;
    private String GXI;
    private x GXJ;
    private Runnable GXK;
    private ProgressDialog fpP;
    com.tencent.mm.pluginsdk.ui.d fqs;
    List<String> fvP;
    private int mUE;
    private int mUF;
    private com.tencent.mm.ui.widget.f mUI;
    private n.d peM;
    private ListView sMV;
    
    public OpenIMAddressUIFragment()
    {
      super();
      AppMethodBeat.i(37902);
      this.GXI = "";
      this.fpP = null;
      this.GSG = "";
      this.GSW = true;
      this.GXK = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(37901);
          OpenIMAddressUI.OpenIMAddressUIFragment.i(OpenIMAddressUI.OpenIMAddressUIFragment.this);
          AppMethodBeat.o(37901);
        }
      };
      this.peM = new n.d()
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
      this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
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
            com.tencent.mm.ck.d.eOM().fS(OpenIMAddressUI.class.getName() + ".Listview", 4);
          }
          AppMethodBeat.o(37887);
        }
      });
      this.fvP = new LinkedList();
      this.GTa = new LinkedList();
      AppMethodBeat.o(37902);
    }
    
    private void fba()
    {
      AppMethodBeat.i(37906);
      this.fvP = new LinkedList();
      this.GTa = new LinkedList();
      com.tencent.mm.bs.d.eBj();
      this.fvP.add("tmessage");
      this.GTa.addAll(this.fvP);
      if (!this.fvP.contains("officialaccounts")) {
        this.fvP.add("officialaccounts");
      }
      this.fvP.add("helper_entry");
      if (this.GXJ != null) {
        this.GXJ.hP(this.fvP);
      }
      if (this.GSE != null) {
        this.GSE.hP(this.GTa);
      }
      AppMethodBeat.o(37906);
    }
    
    private void fbb()
    {
      try
      {
        AppMethodBeat.i(37910);
        long l = System.currentTimeMillis();
        fba();
        ad.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.GXJ != null)
        {
          ad.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(37888);
              OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).faZ();
              AppMethodBeat.o(37888);
            }
          });
        }
        if (this.GSE != null) {
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
      com.tencent.mm.kiss.a.b.agA();
      View localView = com.tencent.mm.kiss.a.b.c(getContext(), 2131495056);
      AppMethodBeat.o(37903);
      return localView;
    }
    
    public void onActivityCreated(Bundle paramBundle)
    {
      AppMethodBeat.i(37908);
      super.onActivityCreated(paramBundle);
      ad.v("MicroMsg.OpenIMAddressUI", "on address ui create");
      az.aeS().a(138, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(453, this);
      this.GXI = getStringExtra("key_openim_acctype_id");
      setMMTitle(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).b(this.GXI, "openim_acct_type_title", b.a.hNA));
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
      setTitleBarDoubleClickListener(this.GXK);
      ad.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      this.sMV = ((ListView)findViewById(2131296471));
      this.sMV.setScrollingCacheEnabled(false);
      this.GXJ = new x(getContext(), "@openim.contact", this.GXI);
      this.GXJ.a(new f.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(37894);
          OpenIMAddressUI.OpenIMAddressUIFragment localOpenIMAddressUIFragment = OpenIMAddressUI.OpenIMAddressUIFragment.this;
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount();
          OpenIMAddressUI.OpenIMAddressUIFragment.b(localOpenIMAddressUIFragment);
          OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).faX();
          AppMethodBeat.o(37894);
        }
        
        public final void ePF() {}
      });
      this.GXJ.GSk = true;
      this.GXJ.GXO = this;
      this.GXJ.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dw(View paramAnonymousView)
        {
          AppMethodBeat.i(37895);
          int i = OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(37895);
          return i;
        }
      });
      this.GXJ.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(37896);
          OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(37896);
        }
      });
      this.GXJ.a(new MMSlideDelView.f()
      {
        public final void cO(Object paramAnonymousObject)
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
      this.GSE = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
      this.GSE.wN(true);
      this.mUI = new com.tencent.mm.ui.widget.f(getContext());
      this.sMV.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(37898);
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          if (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) {}
          boolean bool1;
          for (paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this);; paramAnonymousAdapterView = Boolean.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Hyd))
          {
            ad.i("MicroMsg.OpenIMAddressUI", paramAnonymousAdapterView);
            paramAnonymousInt -= OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount();
            if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) == null) || (!OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Hyd)) {
              break label861;
            }
            bool1 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).EJ(paramAnonymousInt);
            boolean bool2 = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aan(paramAnonymousInt);
            ad.i("MicroMsg.OpenIMAddressUI", "onItemClick ".concat(String.valueOf(bool2)));
            if (!bool2) {
              break;
            }
            OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aLZ("");
            AppMethodBeat.o(37898);
            return;
          }
          Object localObject;
          if (bool1)
          {
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aal(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.Dby.Ehn;
            az.arV();
            localObject = c.apM().aHY(paramAnonymousAdapterView);
            if (com.tencent.mm.n.b.ls(((au)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((af)localObject).eKB()) {
                  h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(37898);
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
                h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
              }
              com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
              AppMethodBeat.o(37898);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.OpenIMAddressUI", localIOException, "", new Object[0]);
              }
            }
          }
          paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).aam(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).getCount()), Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(37898);
            return;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (w.td(paramAnonymousAdapterView))
          {
            paramAnonymousView = new Intent(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), OpenIMAddressUI.class);
            paramAnonymousView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            paramAnonymousAdapterView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/OpenIMAddressUI$OpenIMAddressUIFragment$6", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(37898);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Contact_Scene", 3);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
            com.tencent.mm.bs.d.b(OpenIMAddressUI.OpenIMAddressUIFragment.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView);
          }
          AppMethodBeat.o(37898);
          return;
          label861:
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).WQ(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = OpenIMAddressUI.OpenIMAddressUIFragment.this;
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
            {
              AppMethodBeat.o(37898);
              return;
            }
            if (w.td(paramAnonymousAdapterView))
            {
              ad.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              AppMethodBeat.o(37898);
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
              com.tencent.mm.bs.d.b(paramAnonymousView.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
            }
          }
          AppMethodBeat.o(37898);
        }
      });
      this.sMV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
          if ((OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this) != null) && (OpenIMAddressUI.OpenIMAddressUIFragment.d(OpenIMAddressUI.OpenIMAddressUIFragment.this).Hyd))
          {
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = (com.tencent.mm.storage.f)OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this).WQ(paramAnonymousInt - OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(OpenIMAddressUI.OpenIMAddressUIFragment.c(OpenIMAddressUI.OpenIMAddressUIFragment.this).getHeaderViewsCount()) });
            AppMethodBeat.o(37899);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((w.td(paramAnonymousAdapterView)) || (w.te(paramAnonymousAdapterView)))
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
      this.sMV.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37900);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37900);
            return false;
            OpenIMAddressUI.OpenIMAddressUIFragment.this.hideVKB();
            OpenIMAddressUI.OpenIMAddressUIFragment.a(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawX());
            OpenIMAddressUI.OpenIMAddressUIFragment.b(OpenIMAddressUI.OpenIMAddressUIFragment.this, (int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.sMV.setOnScrollListener(this.fqs);
      this.sMV.setDrawingCacheEnabled(false);
      az.arV();
      c.apM().a(this.GXJ);
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
      az.arV();
      af localaf = c.apM().aHY(this.GSG);
      if (localaf == null)
      {
        ad.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.GSG);
        AppMethodBeat.o(37904);
        return;
      }
      if (u.aqG().equals(localaf.field_username))
      {
        AppMethodBeat.o(37904);
        return;
      }
      if (w.sB(this.GSG))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localaf.ZX()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131755190);
        AppMethodBeat.o(37904);
        return;
      }
      if ((w.sQ(this.GSG)) || (w.tg(this.GSG)))
      {
        AppMethodBeat.o(37904);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.k.c(paramView.getContext(), localaf.ZX()));
      if ((com.tencent.mm.n.b.ls(localaf.field_type)) && (localaf.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, 2131757731);
      }
      AppMethodBeat.o(37904);
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(37912);
      super.onDestroy();
      ad.v("MicroMsg.OpenIMAddressUI", "onDestory");
      az.aeS().b(138, this);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(453, this);
      if (this.GXJ != null)
      {
        this.GXJ.vl(true);
        this.GXJ.detach();
        this.GXJ.ePu();
      }
      if (this.GSE != null)
      {
        this.GSE.detach();
        this.GSE.cHX();
      }
      if ((az.afw()) && (this.GXJ != null))
      {
        az.arV();
        c.apM().b(this.GXJ);
      }
      AppMethodBeat.o(37912);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(37911);
      super.onPause();
      ad.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
      if (this.GSE != null) {
        this.GSE.onPause();
      }
      this.GXJ.faY();
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
      if (this.GSW)
      {
        this.GSW = false;
        this.GSV = false;
        fba();
        this.sMV.setAdapter(this.GXJ);
        this.sMV.post(new Runnable()
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
        this.GSE.wM(false);
      }
      for (;;)
      {
        if (this.GSE != null) {
          this.GSE.onResume();
        }
        this.GXJ.FII = false;
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
        if (this.GSV)
        {
          this.GSV = false;
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
        if (!((axj)((i)paramn).rr.gUT.gUX).Dwr.isEmpty()) {
          fbb();
        }
        AppMethodBeat.o(37905);
        return;
      }
      if (this.fpP != null)
      {
        this.fpP.dismiss();
        this.fpP = null;
      }
      if (!bt.iM(getContext()))
      {
        AppMethodBeat.o(37905);
        return;
      }
      if (x.a.a(getContext(), paramInt1, paramInt2, paramString, 4))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.OpenIMAddressUI
 * JD-Core Version:    0.7.0.1
 */